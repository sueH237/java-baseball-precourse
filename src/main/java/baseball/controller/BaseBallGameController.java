package baseball.controller;

import java.util.List;

import baseball.domain.BaseballComputer;
import baseball.view.BaseballGameView;

public class BaseBallGameController {
	
	public static void start() {
		BaseballComputer baseballComputer = new BaseballComputer();
		play(baseballComputer);
	}
	
	private static void play(BaseballComputer baseballComputer) {
		while(!baseballComputer.isEnd()) {
			List<Integer> inputNumbers = BaseballGameView.readInputNumbers();
			baseballComputer.checkInput(inputNumbers);
			BaseballGameView.getResult(baseballComputer);
		}
	}
}