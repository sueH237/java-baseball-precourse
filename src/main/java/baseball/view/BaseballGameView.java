package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import baseball.domain.BaseballComputer;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameView {
	
    public static List<Integer> readInputNumbers() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (!validateInput(input)) {
            throw new IllegalArgumentException();
        }
        return convertStringToIntegerList(input);
    }

    private static List<Integer> convertStringToIntegerList(String inputStr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < inputStr.length(); i++) {
            result.add(inputStr.charAt(i) - '0');
        }
        return result;
    }

    private static boolean validateInput(String str) {
        if (str.length() != 3) {
            return false;
        }
        if(!isValidNumber(str)){
            return false;
        }
        return true;
    }

    private static boolean isValidNumber(String str) {
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        char c3 = str.charAt(2);

        if(c1 < '1' || c1 > '9' || c2 < '1' || c2 > '9' || c3 < '1' || c3 > '9'){
            return false;
        }
        if(c1 == c2 || c2 == c3 || c1 == c3){
            return false;
        }

        return true;
    }
    
    public static void getResult(BaseballComputer baseballComputer) {
    	if(baseballComputer.getBallCount() > 0){
    		System.out.print(baseballComputer.getBallCount()+"볼 ");
    	}
    	if(baseballComputer.getStrikeCount() > 0){
    		System.out.print(baseballComputer.getStrikeCount()+"스트라이크");
    	}
    	if(baseballComputer.getBallCount() == 0 && baseballComputer.getStrikeCount() == 0){
    		System.out.print("낫싱");
    	}
    	System.out.print("\n");
    }
    
    public static boolean checkGameStatus() {
    	System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
    	String answer = Console.readLine();
    	if(answer.equals("1"))
    		return true;
    	if(answer.equals("2"))
    		return false;
    	throw new IllegalArgumentException();
    }
    
    public static void showGameEnd() {
    	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}