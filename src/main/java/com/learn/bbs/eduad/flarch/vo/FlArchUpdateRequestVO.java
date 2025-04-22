package com.learn.bbs.eduad.flarch.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.learn.bbs.file.vo.FlVO;

import jakarta.validation.constraints.NotEmpty;

public class FlArchUpdateRequestVO {

	@NotEmpty(message = "제목은 필수 입력값입니다.")
	private String flArchTtl;

	@NotEmpty(message = "내용은 필수 입력값입니다.")
	private String flArchCtt;

	private String instrId;

	private String flArchId;

	// 새로 첨부된 파일 등록을 위해 MultipartFile 타입을 사용한다.
	private List<MultipartFile> flList;
    
	// 삭제할 기존 파일 ID - 유지할 파일을 서버에게 알려주기 위해 필요함
	private List<String> deleteFileIds;


	public String getFlArchTtl() {
		return flArchTtl;
	}

	public void setFlArchTtl(String flArchTtl) {
		this.flArchTtl = flArchTtl;
	}

	public String getFlArchCtt() {
		return flArchCtt;
	}

	public void setFlArchCtt(String flArchCtt) {
		this.flArchCtt = flArchCtt;
	}

	public String getInstrId() {
		return instrId;
	}

	public void setInstrId(String instrId) {
		this.instrId = instrId;
	}

	public String getFlArchId() {
		return flArchId;
	}

	public void setFlArchId(String flArchId) {
		this.flArchId = flArchId;
	}

	public List<MultipartFile> getFlList() {
		return flList;
	}

	public void setFlList(List<MultipartFile> flList) {
		this.flList = flList;
	}

	public List<String> getDeleteFileIds() {
		return deleteFileIds;
	}

	public void setDeleteFileIds(List<String> deleteFileIds) {
		this.deleteFileIds = deleteFileIds;
	}

}
