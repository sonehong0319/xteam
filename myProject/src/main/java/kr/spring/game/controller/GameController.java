package kr.spring.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameController {
	@RequestMapping("/game/game.do")
	public String getGame() {
		return "game";
	}
}





