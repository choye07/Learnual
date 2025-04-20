package com.learn.bbs.crs.cncl.dao;

import com.learn.bbs.crs.cncl.vo.CnclCancellationRequestVO;

/**
 * @author 최예진
 * 취소 내역
 */
public interface CnclHstrDao {
    // 취소 했을 시 취소 내역에 insert -> 추후에 userid 필요한데 일단 더미데이터 박아놨어요 (CnclHstrController)
    public int insertCancelledAppHstr(CnclCancellationRequestVO cnclCancellationRequestVO);
    
    // 해당 신청 내역이 취소되었는지 여부
    public boolean existsCancelledAppHstr(String appHstrId);
}