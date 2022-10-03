package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
	
    @ParameterizedTest(name = "랜덤수 생성 : {0}")
    @ValueSource(ints = {1,3,5})
    void 랜덤_수_생성(int randomNumber){
        assertRandomNumberInRangeTest(
                () -> {
                    BaseballComputer baseballComputer = new BaseballComputer();
                    assertThat(baseballComputer.getRandomNumbers()).contains(randomNumber);
                },
                1,1, 3, 3, 5, 5, 6, 6
        );
    }

    @Test
    @DisplayName("볼 테스트")
    void 볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                	BaseballComputer baseballComputer = new BaseballComputer();
                    List<Integer> inputNumbers = Arrays.asList(5, 1, 3);
                    baseballComputer.checkInput(inputNumbers);

                    assertThat(baseballComputer.getBallCount()).isEqualTo(3);
                },
                1, 3, 5
        );
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void 스크라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                	BaseballComputer baseballComputer = new BaseballComputer();
                    List<Integer> inputNumbers = Arrays.asList(1, 3, 6);
                    baseballComputer.checkInput(inputNumbers);

                    assertThat(baseballComputer.getStrikeCount()).isEqualTo(2);
                },
                1, 3, 5
        );
    }

    @Test
    @DisplayName("낫싱 테스트")
    void 낫싱_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                	BaseballComputer baseballComputer = new BaseballComputer();
                    List<Integer> inputNumbers = Arrays.asList(7, 8, 9);
                    baseballComputer.checkInput(inputNumbers);

                    assertThat(baseballComputer.getStrikeCount()).isEqualTo(0);
                    assertThat(baseballComputer.getBallCount()).isEqualTo(0);
                },
                1, 3, 5
        );
    }


}