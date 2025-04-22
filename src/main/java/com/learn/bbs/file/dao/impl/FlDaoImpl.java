package com.learn.bbs.file.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.file.dao.FlDao;
import com.learn.bbs.file.vo.FlDeleteRequestVO;
import com.learn.bbs.file.vo.FlDownloadRequestVO;
import com.learn.bbs.file.vo.FlUpdateRequestVO;
import com.learn.bbs.file.vo.FlVO;

@Repository
public class FlDaoImpl extends SqlSessionDaoSupport implements FlDao {

	private final String NAME_SPACE = "com.learn.bbs.file.dao.impl.FlDaoImpl.";
    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int insertNewFile(FlVO flVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewFile", flVO);
	}

	@Override
	public FlVO selectOneFile(FlDownloadRequestVO flDownloadRequestVO) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectOneFile", flDownloadRequestVO);
	}
	
	@Override
	public List<FlVO> selectFilesById(String id) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectFilesById", id);
	}

	@Override
	public int deleteOneFile(FlDeleteRequestVO flDeleteRequestVO) {
		return this.getSqlSession().delete(NAME_SPACE + "deleteOneFile", flDeleteRequestVO);
	}

	@Override
	public int deleteAllFiles(FlDeleteRequestVO flDeleteRequestVO) {
		return this.getSqlSession().delete(NAME_SPACE + "deleteAllFiles", flDeleteRequestVO);
	}
	
	@Override
	public int updateOneFile(FlUpdateRequestVO flUpdateRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "updateOneFile", flUpdateRequestVO);
	}

}