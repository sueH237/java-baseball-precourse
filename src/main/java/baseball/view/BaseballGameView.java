package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameView {
	
    public static List<Integer> readInputNumbers() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (!validateInput(input)) {
            throw new IllegalArgumentException("잘못된 입력값입니다");
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
}