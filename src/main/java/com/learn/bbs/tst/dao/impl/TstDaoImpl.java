package com.learn.bbs.tst.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.tst.dao.TstDao;
import com.learn.bbs.tst.vo.CreateTstRequestVO;
import com.learn.bbs.tst.vo.DeleteTstRequestVO;
import com.learn.bbs.tst.vo.SearchTstRequestVO;
import com.learn.bbs.tst.vo.TstCommonVO;
import com.learn.bbs.tst.vo.TstVO;
import com.learn.bbs.tst.vo.UpdateTstRequestVO;


/**
 * @author 최예진
 * 시험
 */
@Repository
public class TstDaoImpl extends SqlSessionDaoSupport implements TstDao {

    private final String NAME_SPACE = "com.learn.bbs.tst.dao.impl.TstDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public List<TstVO> selectAllTest(SearchTstRequestVO searchTstRequestVO) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllTest", searchTstRequestVO);
	}

	@Override
	public int selectAllTestCount(SearchTstRequestVO searchTstRequestVO) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectAllTestCount", searchTstRequestVO);
	}
	
	@Override
	public TstVO selectOneTest(TstCommonVO tstCommonVO) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectOneTest", tstCommonVO);
	}

	@Override
	public int insertNewTest(CreateTstRequestVO createTstRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewTest", createTstRequestVO);
	}

	@Override
	public int updateOneTest(UpdateTstRequestVO updateTstRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "updateOneTest", updateTstRequestVO);
	}

	@Override
	public int deleteOneTest(DeleteTstRequestVO deleteTstRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "deleteOneTest", deleteTstRequestVO);
	}


}