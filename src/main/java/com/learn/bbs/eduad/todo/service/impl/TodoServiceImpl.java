package com.learn.bbs.eduad.todo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.learn.bbs.eduad.todo.dao.TodoDao;
import com.learn.bbs.eduad.todo.service.TodoService;
import com.learn.bbs.eduad.todo.vo.ReadExceTodoFile;
import com.learn.bbs.eduad.todo.vo.TodoDeleteRequestVO;
import com.learn.bbs.eduad.todo.vo.TodoFileVO;
import com.learn.bbs.eduad.todo.vo.TodoListVO;
import com.learn.bbs.eduad.todo.vo.TodoUpdateRequestVO;
import com.learn.bbs.eduad.todo.vo.TodoVO;
import com.learn.bbs.eduad.todo.vo.TodoWriteRequestVO;
import com.learn.bbs.file.dao.FlDao;
import com.learn.bbs.file.vo.FlVO;
import com.learn.beans.FileHandler;
import com.learn.beans.FileHandler.StoredFile;
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

		if (todoList == null) {
			todoList = new ArrayList<>();
		}

		TodoListVO todoListVO = new TodoListVO();
		todoListVO.setTodoCnt(count);
		todoListVO.setTodoList(todoList);

		return todoListVO;
	}

	@Transactional
	@Override
	public boolean createNewTodoByFile(TodoFileVO todoFileVO) {

		// 강좌 마다 하나의 학습 계획서가 있다.
		// 업로드한 강의 계획서를 FlVO로 생성하여 데이터베이스에 저장한다(insert)
		
		MultipartFile file = todoFileVO.getFile();
		
		if (file == null || file.isEmpty()) {
			throw new IllegalArgumentException("파일이 비어 있습니다.");
		}

		// 사용자가 업로드한 파일을 서버에 저장하는 객체
		StoredFile storedFile = this.fileHandler.store(file);

		if (storedFile != null) {

			// 업로드한 파일에서 오늘의 날짜의 과목명과 학습내용을 읽어온다.
			Read<ReadExceTodoFile> read = new Read<>(storedFile.getStoredPath(), ReadExceTodoFile.class);

			// 오늘의 날짜를 알아온다.
			LocalDate today = LocalDate.now();

			// 엑셀 파일에서 컬럼의 데이터를 읽어와 리스트로 저장한다.
			List<ReadExceTodoFile> result = read.read();

			// 읽어온 엑셀 파일의 셀 내용을 투두 내용으로 만든다.
			int insertCount = 0;

			for (ReadExceTodoFile tc : result) {
				LocalDate tmpDate = LocalDate.parse(tc.getDate());

				if (today.equals(tmpDate)) {
					
					String fileTodoCtt = tc.getContent();

					// 1. 공백, null 체크
					if (fileTodoCtt == null || fileTodoCtt.trim().isEmpty()) {
						// 오늘의 투두 내용이 비어 있어 저장하지 않습니다.
						throw new IllegalStateException("오늘 날짜의 투두 내용이 비어 있습니다.");
					}

					// 2. 오늘의 투두로 만들기
					TodoWriteRequestVO todoWriteRequestVO = new TodoWriteRequestVO();
					todoWriteRequestVO.setTodoCtt(fileTodoCtt);
					todoWriteRequestVO.setLgnId(todoFileVO.getLgnId());
					todoWriteRequestVO.setCrsInfId(todoFileVO.getCrsInfId());
					todoWriteRequestVO.setArtcId(todoFileVO.getArtcId());

					// 읽어온 엑셀 파일의 셀 내용을 투두 내용으로 넣어서 만든다.
					insertCount += this.todoDao.insertNewTodo(todoWriteRequestVO);

					// 사용자가 업로드한 파일을 file 객체로 만든다.
					FlVO flVO = new FlVO();
					flVO.setId(todoWriteRequestVO.getTodoId());
					flVO.setFlNm(storedFile.getFileName());
					flVO.setFlObfsNm(storedFile.getRealFileName());
					flVO.setFlObfsPth(storedFile.getRealFilePath());
					flVO.setFlSz(storedFile.getFileSize());
					flVO.setArtcId(todoWriteRequestVO.getArtcId());

					this.flDao.insertNewFile(flVO);
				}
			}

			// 투두 DB에 저장한 row의 수
			return insertCount > 0;
		}
		// 업로드한 파일이 없으면 아예 false
		return false;
	}

	@Transactional
	@Override
	public boolean createNewTodo(TodoWriteRequestVO todoWriteRequestVO) {
		// 강의 계획서가 아닌 사용자가 직접 텍스트로 추가한 경우
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