package lotto.view;

import lotto.Amount;
import lotto.game.LottoNumber;
import lotto.game.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static Amount inputAmount() {
        int input = intInput("구입금액을 입력해 주세요.");
        return new Amount(input);
    }

    public static LottoNumbers inputWinNumbers() {
        String input = stringInput("지난 주 당첨 번호를 입력해 주세요.");
        List<LottoNumber> lottoNumbers = Arrays.stream(input.split(", "))
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    private static String stringInput(String message) {
        print(message);
        return scanner.nextLine();
    }

    private static int intInput(String message) {
        print(message);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
