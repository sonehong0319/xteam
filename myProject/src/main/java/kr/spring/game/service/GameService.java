package kr.spring.game.service;

import java.util.List;
import java.util.Map;

import kr.spring.board.vo.BoardVO;
import kr.spring.game.vo.GameVO;


public interface GameService {
	public List<GameVO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String,Object> map);
	public List<GameVO> selectListCate(Map<String,Object> map);
	public int selectRowCountCate(Map<String,Object> map);
	public void insertGame(GameVO game);
	public GameVO selectGame(Integer gam_num);
	public void updateHit(Integer gam_num);
	public void updateGame(BoardVO game);
	public void deleteGame(Integer gam_num);
}







