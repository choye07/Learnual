package com.learn.bbs.menu.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.learn.bbs.menu.dao.MenuDao;
import com.learn.bbs.menu.vo.MenuRegistRequestVO;
import com.learn.bbs.menu.vo.MenuSearchRequestVO;
import com.learn.bbs.menu.vo.MenuVO;

/**
 * @TableName MENU
 * @TableComment null 메뉴
 */
@Repository
public class MenuDaoImpl extends SqlSessionDaoSupport implements MenuDao {

	private final String NAME_SPACE = "com.learn.bbs.menu.dao.impl.MenuDaoImpl.";

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertNewMenu(MenuRegistRequestVO menuRegistRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewMenu", menuRegistRequestVO);
	}

	@Override
	public List<MenuVO> selectAllMenu(MenuSearchRequestVO menuSearchRequestVO) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllMenu", menuSearchRequestVO);
	}

}