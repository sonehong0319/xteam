package kr.spring.game.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.board.vo.BoardVO;
import kr.spring.game.dao.GameMapper;
import kr.spring.game.vo.GameVO;

@Service("gameService")
public class GameServiceImpl implements GameService{

	@Resource
	GameMapper gameMapper;
	
	@Override
	public List<GameVO> selectList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertGame(GameVO game) {
		gameMapper.insertGame(game);
	}

	@Override
	public BoardVO selectGame(Integer gam_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHit(Integer gam_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGame(BoardVO game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGame(Integer gam_num) {
		// TODO Auto-generated method stub
		
	}

	
}










