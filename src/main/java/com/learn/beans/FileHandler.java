 package com.learn.beans;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileHandler {
	// 운영체제 구분
	private String baseDirWindows;
	private String baseDirLinux;
	private String baseDirMacos;
	// 파일명 난독화 설정
	private boolean obfuscationEnable;
	// 파일 확정자 가릴 지 설정
	private boolean obfuscationHideExtEnable;

	private String osname;
	
	public void setBaseDirWindows(String baseDirWindows) {
		this.baseDirWindows = baseDirWindows;
	}

	public void setBaseDirLinux(String baseDirLinux) {
		this.baseDirLinux = baseDirLinux;
	}

	public void setBaseDirMacos(String baseDirMacos) {
		this.baseDirMacos = baseDirMacos;
	}

	public void setObfuscationEnable(boolean obfuscationEnable) {
		this.obfuscationEnable = obfuscationEnable;
	}

	public void setObfuscationHideExtEnable(boolean obfuscationHideExtEnable) {
		this.obfuscationHideExtEnable = obfuscationHideExtEnable;
	}

	public void setOsname(String osname) {
		this.osname = osname;
	}

	public StoredFile store(MultipartFile multipartFile) { // 사용자가 서버에 보내준 파일이 들어감
		// 방어코딩: 파일이 없거나, 빈 파일을 보내는 경우
		if(multipartFile == null || multipartFile.isEmpty()) {
			return null;
		}
		
		// 난독화 여부에 따라 난독화를 설정함
		String fileName = this.getObfuscationFileName(multipartFile.getOriginalFilename());
		
		// 목적지 설정
		File storePath = null;

		if(osname.startsWith("windows")) {
			storePath = new File(this.baseDirWindows, fileName);
		}
		else if(osname.startsWith("mac")) {
			String homePath = System.getProperty("user.home");
			storePath = new File(homePath + this.baseDirMacos, fileName);
		}
		else {
			storePath = new File(this.baseDirLinux, fileName);
		}
		
		if(!storePath.getParentFile().exists()) {
			storePath.getParentFile().mkdirs();
		}
		// 업로드한 파일을 저장한다.
		try {
			// 업로드한 파일을 storePath로 옮긴다! (중요)
			multipartFile.transferTo(storePath);
		} catch (IllegalStateException | IOException e) {
			// 업로드 실패
			// 파일을 저장하는 경로가 접근 불가능한 경로일 때(Windows 기준: C:\\ 직접 업로드할 때)
			// 디스크의 남은 용량이 부족할 때 (남아있는 용량 < 업로드한 파일의 크기)
			return null;
		}
		// 파일명에서 확장자 가져오기
		String originalFilename = multipartFile.getOriginalFilename();
		String extension = "";

		if (originalFilename != null && originalFilename.contains(".")) {
		    extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1); // ex: "pdf"
		}
		
		// 업로드 성공: 사용자에게 파일 정보를 보여줌
		// String fileName, String realFileName, String realFilePath, long fileSize
		return new StoredFile(multipartFile.getOriginalFilename(),
							  fileName,
							  storePath.getAbsolutePath(),
							  storePath.length(),
							  extension);
	}

	// 파일 난독화 설정
	public String getObfuscationFileName(String fileName) {
		if (obfuscationEnable) { // 난독화 설정 여부

			String ext = fileName.substring(fileName.lastIndexOf("."));
			fileName = UUID.randomUUID().toString();

			// 확장자 숨김 여부
			if (!obfuscationHideExtEnable) {
				fileName += ext;
			}
		}

		return fileName;
	}

	// 파일 핸들러 내부에 작성함: 브라우저에게 원본 파일명을 알려주기 위해 DB에 저장함.
	public class StoredFile {
		private String fileName;
		private String realFileName;
		private String realFilePath;
		private long fileSize;
		private String fileType;

		public StoredFile(String fileName, String realFileName, String realFilePath
						, long fileSize, String fileType) {
			this.fileName = fileName;
			this.realFileName = realFileName;
			this.realFilePath = realFilePath;
			this.fileSize = fileSize;
			this.fileType = fileType;
		}

		public String getFileName() {
			return this.fileName;
		}

		public String getRealFileName() {
			return this.realFileName;
		}

		public String getRealFilePath() {
			return this.realFilePath;
		}

		public long getFileSize() {
			return this.fileSize;
		}

		public String getFileType() {
			return this.fileType;
		}

	}

}