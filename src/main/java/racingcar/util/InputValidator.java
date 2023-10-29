package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputValidator {

    // 자동차 이름의 유효성 검사
    public static List<String> isValidCarName(String input) {
        List<String> carList = Stream.of(input.split(",")).collect(Collectors.toList());

        isValidType(carList);
        isValidLength(carList);

        return carList;
    }

    // 시도 횟수의 유효성 검사
    public static int isValidAttemptNumber(String input) {
        int attemptNumber = isIntegerNumber(input);
        return attemptNumber;
    }

    // 시도 횟수가 정수형 숫자인지 검사
    private static int isIntegerNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    // 자동차 이름들이 문자인지 검사
    private static void isValidType(List<String> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            try {
                Double.parseDouble(inputList.get(i));
                throw new IllegalArgumentException();
            } catch (NumberFormatException e) {
            }
        }
    }

    // 자동차 이름이 5자 이하인지 검사
    private static void isValidLength(List<String> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
