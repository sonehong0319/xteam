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
		return gameMapper.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gameMapper.selectRowCount(map);
	}

	@Override
	public void insertGame(GameVO game) {
		gameMapper.insertGame(game);
	}

	@Override
	public GameVO selectGame(Integer gam_num) {
		return gameMapper.selectGame(gam_num);
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

	@Override
	public List<GameVO> selectListCate(Map<String, Object> map) {
		return gameMapper.selectListCate(map);
	}

	@Override
	public int selectRowCountCate(Map<String, Object> map) {
		return gameMapper.selectRowCountCate(map);
	}

	
}










