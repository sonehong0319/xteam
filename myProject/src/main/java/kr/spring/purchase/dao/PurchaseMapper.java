package kr.spring.purchase.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.board.vo.BoardVO;
import kr.spring.purchase.vo.PurchaseVO;
  
public interface PurchaseMapper {
	public List<PurchaseVO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	@Insert("INSERT INTO purchase (pur_num, mem_num, gam_num, pur_date) VALUES (purchase_seq.nextval,#{mem_num},#{gam_num},SYSDATE)")
	public void insertPurchase(PurchaseVO purcahse);
	@Select("SELECT * FROM purchase WHERE pur_num=#{pur_num}")
	public BoardVO selectBoard(Integer purchase_num);
	@Update("UPDATE board SET board_hit=board_hit+1 WHERE board_num=#{board_num}")
	public void updateHit(Integer board_num);
	public void updateBoard(BoardVO board);
	@Delete("DELETE FROM board WHERE board_num=#{board_num}")
	public void deleteBoard(Integer board_num);
	  
}







