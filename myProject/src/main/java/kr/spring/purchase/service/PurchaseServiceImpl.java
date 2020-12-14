package kr.spring.purchase.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.purchase.dao.PurchaseMapper;
import kr.spring.purchase.vo.PurchaseVO;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Resource
	PurchaseMapper purchaseMapper;

	@Override
	public List<PurchaseVO> selectList(Map<String, Object> map) {
		return purchaseMapper.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return purchaseMapper.selectRowCount(map);
	}

	@Override
	public void insertPurchase(PurchaseVO purchase) {
		purchaseMapper.insertPurchase(purchase);
		
	}

	@Override
	public PurchaseVO selectPurchase(Integer pur_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePurchase(Integer pur_num) {
		// TODO Auto-generated method stub
		
	}
	

}





