package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballComputer {
	
	private List<Integer> randNewNumbers;
	private boolean end;

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
	
	
	
}