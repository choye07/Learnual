package com.learn.bbs.eduad.todo.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.eduad.todo.vo.TodoVO;
import com.learn.bbs.eduad.todo.dao.TodoDao;
import com.learn.bbs.eduad.todo.vo.TodoDeleteRequestVO;
import com.learn.bbs.eduad.todo.vo.TodoUpdateRequestVO;
import com.learn.bbs.eduad.todo.vo.TodoWriteRequestVO;

@Repository
public class TodoDaoImpl extends SqlSessionDaoSupport implements TodoDao {

	private final String NAME_SPACE = "com.learn.bbs.eduad.todo.dao.impl.TodoDaoImpl.";

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int selectAllCountTodo(String lgnId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectAllCountTodo", lgnId);
	}
	
	@Override
	public List<TodoVO> selectAllTodo(String lgnId) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllTodo", lgnId);
	}
	
	@Override
	public List<TodoVO> selectMyAllTodo(String lgnId) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectMyAllTodo", lgnId);
	}

	@Override
	public int insertNewTodo(TodoWriteRequestVO todoWriteRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewTodo", todoWriteRequestVO);
	}

	@Override
	public int deleteOneTodo(TodoDeleteRequestVO todoDeleteRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "deleteOneTodo", todoDeleteRequestVO);
	}
	
	@Override
	public int updateOneTodo(TodoUpdateRequestVO todoUpdateRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "updateOneTodo", todoUpdateRequestVO);
	}

}