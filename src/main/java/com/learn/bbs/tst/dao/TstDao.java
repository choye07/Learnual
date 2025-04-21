package com.learn.bbs.tst.dao;

import java.util.List;

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
public interface TstDao {

	public List<TstVO> selectAllTest(SearchTstRequestVO searchTstRequestVO);
	
	public int selectAllTestCount(SearchTstRequestVO searchTstRequestVO);
	
	public TstVO selectOneTest(TstCommonVO tstCommonVO);
	
	public int insertNewTest(CreateTstRequestVO createTstRequestVO);
	
	public int updateOneTest(UpdateTstRequestVO updateTstRequestVO);
	
	public int deleteOneTest(DeleteTstRequestVO deleteTstRequestVO);
	
}