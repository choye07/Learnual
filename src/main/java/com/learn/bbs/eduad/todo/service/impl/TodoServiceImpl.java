package com.learn.bbs.eduad.todo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.learn.bbs.eduad.todo.dao.TodoDao;
import com.learn.bbs.eduad.todo.service.TodoService;
import com.learn.bbs.eduad.todo.vo.ReadExceTodoFile;
import com.learn.bbs.eduad.todo.vo.TodoDeleteRequestVO;
import com.learn.bbs.eduad.todo.vo.TodoListVO;
import com.learn.bbs.eduad.todo.vo.TodoUpdateRequestVO;
import com.learn.bbs.eduad.todo.vo.TodoVO;
import com.learn.bbs.eduad.todo.vo.TodoWriteRequestVO;
import com.learn.bbs.file.dao.FlDao;
import com.learn.bbs.file.vo.FlVO;
import com.learn.beans.FileHandler;
import com.learn.beans.FileHandler.StoredFile;
import com.learn.exceptions.NotExistsException;
import com.learn.exceptions.PageNotFoundException;
import com.learn.io.github.seccoding.excel.read.Read;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoDao todoDao;
	@Autowired
	private FileHandler fileHandler;
	@Autowired
	private FlDao flDao;

	@Transactional(readOnly = true)
	@Override
	public TodoListVO getAllMyTodo(String lgnId) {

		// 오늘의 모든 투두 조회
		// 강사 대시보드 = 강의 계획서 + 강사 직접 추가한 투두

		// 투두 카운트
		int count = this.todoDao.selectAllCountTodo(lgnId);

		List<TodoVO> todoList = this.todoDao.selectMyAllTodo(lgnId);

		TodoListVO todoListVO = new TodoListVO();
		todoListVO.setTodoCnt(count);
		todoListVO.setTodoList(todoList);

		return todoListVO;
	}

	@Transactional
	@Override
	public boolean createNewTodoByFile(TodoWriteRequestVO todoWriteRequestVO) {
		// 강의 계획서에서 엑셀 파일 읽어오기(DB insert)
		// 읽어서 todo 인스턴스 만들기 -> insert -> 오늘 날짜의 인스턴스만 읽어온다.

		// dao의 insert 실행
		int insertCount = this.todoDao.insertNewTodo(todoWriteRequestVO);
		// TODO 로그 확인
		System.out.println("insertCount: " + insertCount);  // insertCount 값 확인

		if (insertCount > 0) {
			// TODO 투두 추가 성공
			  System.out.println("투두가 성공적으로 등록되었습니다.");
			// 업로드된 강의 계획서 파일이 이미 있는지 확인
			List<FlVO> planner = this.flDao.selectFilesById(todoWriteRequestVO.getTodoId());
			StoredFile storedFile = null;
			
			if (planner.size() < 1 && todoWriteRequestVO.getFile() != null && !todoWriteRequestVO.getFile().isEmpty()) {

				// 파일이 없으면 강의 계획서 파일을 새롭게 올려 투두를 추가하는 경우이다.
				MultipartFile file = todoWriteRequestVO.getFile();

				// 사용자가 업로드한 파일을 서버에 저장하는 객체
				storedFile = this.fileHandler.store(file);
				 System.out.println("파일이 성공적으로 저장되었습니다: " + storedFile.getFileName());
				// 저장될 파일이 없으면, 파일 저장 실패
				if (storedFile == null) {
					 System.out.println("파일 저장 실패.");
					throw new NotExistsException();
				}

				// 강좌 마다 하나의 학습 계획서가 있다.
				// 사용자가 업로드한 파일을 file 객체로 만든다.
				FlVO flVO = new FlVO();
				flVO.setId(todoWriteRequestVO.getTodoId());
				flVO.setFlNm(storedFile.getFileName());
				flVO.setFlObfsNm(storedFile.getRealFileName());
				flVO.setFlObfsPth(storedFile.getRealFilePath());
				flVO.setFlSz(storedFile.getFileSize());
				flVO.setFlTypeNm(storedFile.getFileType());
				
				 System.out.println("파일 정보 DB에 저장: " + flVO);  // 파일 정보 확인

				// 데이터 베이스에 파일 테이블에 파일 정보를 저장한다(insert).
				this.flDao.insertNewFile(flVO);
			}

			if (storedFile != null) {

				// 파일이 있으면 강의 계획서를 읽어오고, 강사가 직접 투두를 추가하는 경우이다.
				// 각 강좌들의 학습목표로 오늘의 날짜의 과목명과 학습내용을 읽어온다.

				// 업로드한 파일의 정보를 읽어온다.
				Read<ReadExceTodoFile> read = new Read<>(storedFile.getStoredPath(), ReadExceTodoFile.class);

				// 오늘의 날짜를 알아온다.
				LocalDate today = LocalDate.now();
				// TODO 오늘 날짜가 잘 나온다면 지워질 코드
				System.out.println("오늘 날짜는: " + today);

				// 엑셀 파일에서 컬럼의 데이터를 읽어와 리스트로 저장한다.
				List<ReadExceTodoFile> result = read.read();

				// TODO 출력 확인이 되면 지워질 코드
				result.forEach(tc -> {
				    System.out.println("엑셀에서 읽은 날짜: " + tc.getDate());
				    System.out.println("엑셀에서 읽은 과목: " + tc.getSubject());
				    System.out.println("엑셀에서 읽은 내용: " + tc.getContent());

					// 오늘 날짜인 content만 읽어오기 위해 LocalDate로 타입을 맞춘다.
					LocalDate tmpDate = LocalDate.parse(tc.getDate());
					System.out.println(tmpDate);
					if (today.equals(tmpDate)) {
						String fileTodoCtt = tc.getContent();
						 System.out.println("오늘 날짜와 일치하는 투두를 찾았습니다: " + tc.getContent());

						// 읽어온 엑셀 파일의 셀 내용을 투두 내용으로 넣어서 만든다.
						TodoVO todoVO = new TodoVO();
						todoVO.setTodoCtt(fileTodoCtt);
						todoVO.setLgnId(todoWriteRequestVO.getLgnId());
						todoVO.setCrsInfId(todoWriteRequestVO.getCrsInfId());
						todoVO.setArtcId("ARTC_ID");
						// TODO 여기서 파일이 필요한지 한번 생각해보기 쿼리에서는 필요가 없는 듯..
 						//List<FlVO> file = this.flDao.selectFilesById(todoVO.getTodoId());
						//todoVO.setFlVO(file.get(0));
					}
				});

			}
		}
		// 투두 DB에 저장한 row의 수
		return insertCount > 0;
	}

	@Transactional
	@Override
	public boolean createNewTodo(TodoWriteRequestVO todoWriteRequestVO) {
		// dao의 insert 실행
		int insertCount = this.todoDao.insertNewTodo(todoWriteRequestVO);
		if (insertCount == 0) {
			throw new PageNotFoundException(todoWriteRequestVO.getTodoId());
		}
		return insertCount > 0;
	}

	@Transactional
	@Override
	public boolean deleteOneTodo(TodoDeleteRequestVO todoDeleteRequestVO) {
		// dao의 insert 실행
		int deleteCount = this.todoDao.deleteOneTodo(todoDeleteRequestVO);
		
		if (deleteCount == 0) {
			throw new PageNotFoundException(todoDeleteRequestVO.getTodoId());
		}
		return deleteCount > 0;
	}

	@Transactional
	@Override
	public boolean updateOneTodo(TodoUpdateRequestVO todoUpdateRequestVO) {
		// dao의 insert 실행
		int updateCount = this.todoDao.updateOneTodo(todoUpdateRequestVO);
		if (updateCount == 0) {
			throw new PageNotFoundException(todoUpdateRequestVO.getTodoId());
		}
		return updateCount > 0;
	}

}