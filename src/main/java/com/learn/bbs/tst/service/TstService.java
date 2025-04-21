package com.learn.bbs.tst.service;

import com.learn.bbs.tst.vo.CreateTstRequestVO;
import com.learn.bbs.tst.vo.DeleteTstRequestVO;
import com.learn.bbs.tst.vo.SearchTstRequestVO;
import com.learn.bbs.tst.vo.TstCommonVO;
import com.learn.bbs.tst.vo.TstListVO;
import com.learn.bbs.tst.vo.TstVO;
import com.learn.bbs.tst.vo.UpdateTstRequestVO;

/**
 * @author 최예진
 * 시험
 */
public interface TstService {

	public TstListVO readAllTest(SearchTstRequestVO searchTstRequestVO);
	
	public TstVO readOneTest(TstCommonVO tstCommonVO);
	
	public boolean createNewTest(CreateTstRequestVO createTstRequestVO);
	
	public boolean updateOneTest(UpdateTstRequestVO updateTstRequestVO);
	
	/**
	 * 시험 상태 - 
	 * 확정 -> 
	 * 	시험 확정 시 편집 불가 - 
	 * 마감 -> 
	 * 	시험 마감 시 편집 불가, 응시 불가
	 * 
	 * @param updateTstRequestVO
	 * @return
	 */
	public boolean changeTestStat(UpdateTstRequestVO updateTstRequestVO);
	
	public boolean deleteOneTest(DeleteTstRequestVO deleteTstRequestVO);
	
}