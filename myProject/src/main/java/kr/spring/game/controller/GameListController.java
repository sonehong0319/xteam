package kr.spring.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameListController {
	@RequestMapping("/game/gameList.do")
	public String getGameList() {
		return "gameList";
	}
}





