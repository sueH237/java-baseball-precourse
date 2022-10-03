package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballComputer {
	
	private List<Integer> randNewNumbers;
	private boolean end;
	private int strikeCount;
	private int ballCount;

	public BaseballComputer() {
		this.randNewNumbers = makeRandomNumbers();
		this.end = false;
	}
	
	private List<Integer> makeRandomNumbers() {
		List<Integer> randomNumbers = new ArrayList<>();
		while (randomNumbers.size() < 3) {
			randomNumbers.add(makeRandomNumber(randomNumbers));
		}
		return randomNumbers;
	}
	
	private int makeRandomNumber(List<Integer> randomNumbers) {
		int num = Randoms.pickNumberInRange(1,9);
		while (randomNumbers.contains(num)) {
			num = Randoms.pickNumberInRange(1,9);
		}
		return num;
	}
	
	public boolean isEnd() {
		return end;
	}
	
	public int getStrikeCount() {
		return strikeCount;
	}
	
	public int getBallCount() {
		return ballCount;
	}
	
	public void checkInput(List<Integer> inputNumbers) {
		strikeCount = ballCount = 0;
		
		for(int i = 0; i < 3; i++) {
			updateState(inputNumbers.get(i), i);
		}
		if(strikeCount == 3){
			end = true;
		}
	}
	
	public void updateState(int num, int idx) {
		if(randNewNumbers.get(idx) == num) {
			strikeCount++;
			return;
		}
		if(randNewNumbers.contains(num)) {
			ballCount++;
			return;
		}
	}
	
	
}