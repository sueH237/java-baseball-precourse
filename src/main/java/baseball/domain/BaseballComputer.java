package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

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
	
	public List<Integer> getRandomNumbers() {
		return randNewNumbers;
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
	
	private List<Integer> makeRandomNumbers() {
		List<Integer> randNewNumbers = new ArrayList<>();
		while (randNewNumbers.size() < 3) {
			randNewNumbers.add(makeRandomNumber(randNewNumbers));
		}
		return randNewNumbers;
	}
	
	private int makeRandomNumber(List<Integer> randNewNumbers) {
		int num = Randoms.pickNumberInRange(1,9);
		while (randNewNumbers.contains(num)) {
			num = Randoms.pickNumberInRange(1,9);
		}
		return num;
	}
	
	public void checkInput(List<Integer> inputNumbers) {
		strikeCount = 0;
		ballCount = 0;
		
		for(int i = 0; i < 3; i++) {
			updateState(inputNumbers.get(i), i);
		}
		if(strikeCount == 3){
			end = true;
		}
	}
	
	public void updateState(Integer num, int idx) {
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