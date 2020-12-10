package kr.spring.game.dao;

import java.util.List;
import java.util.Map;

import kr.spring.game.vo.GameVO;

public interface GameMapper {
	public List<GameVO> selectList(Map<String,Object> map);
}
