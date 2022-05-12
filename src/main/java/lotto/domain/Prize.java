package lotto.domain;

import java.util.Arrays;
import lotto.domain.money.Money;

public enum Prize {
  FIRST(6, Money.createWon(2_000_000_000)),
  SECOND(5, Money.createWon(1_500_000)),
  THIRD(4, Money.createWon(50_000)),
  FOURTH(3, Money.createWon(5_000)),
  NOT_PRIZE(0, Money.createWon(0));

  private final int matchCount;
  private final Money prize;

  Prize(int matchCount, Money prize) {
    this.matchCount = matchCount;
    this.prize = prize;
  }

  public static Money getPrizeMoney(int count) {
    return Arrays.stream(values())
        .filter(prize -> prize.matchCount == count)
        .findAny()
        .map(prize -> prize.prize)
        .orElse(Money.createWon(0));
  }

  public static Prize of(int count) {
    return Arrays.stream(values())
        .filter(prize -> prize.matchCount == count)
        .findAny()
        .orElse(NOT_PRIZE);
  }

  public Money getPrize() {
    return prize;
  }

  public int getMatchCount() {
    return matchCount;
  }
}