package kr.spring.game.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;

import kr.spring.board.vo.BoardVO;
import kr.spring.game.vo.GameVO;

public interface GameMapper {
	public List<GameVO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	@Insert("INSERT INTO games (gam_num, gam_name, gam_price, gam_date, gam_hit, gam_detail, cate_num, gam_uploadfile) VALUES (games_seq.nextval,#{gam_name},#{gam_price}, #{gam_date}, #{gam_hit}, #{gam_detail}, #{cate_num}, #{gam_uploadfile})")
	public void insertGame(GameVO game);
	public BoardVO selectGame(Integer gam_num);
	public void updateHit(Integer gam_num);
	public void updateGame(BoardVO game);
	public void deleteGame(Integer gam_num);
}
