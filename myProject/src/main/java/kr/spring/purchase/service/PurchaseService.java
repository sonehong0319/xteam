package kr.spring.purchase.service;

import java.util.List;
import java.util.Map;

import kr.spring.board.vo.BoardVO;
import kr.spring.purchase.vo.PurchaseVO;

public interface PurchaseService {
	public List<PurchaseVO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public void insertPurchase(PurchaseVO purchase);
	public PurchaseVO selectPurchase(Integer pur_num);
	public void deletePurchase(Integer pur_num);
}
  




