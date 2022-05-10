package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.money.Money;

public class Statistics {

  private final List<Statistic> statistics;
  private final Money purchaseAmount;

  public Statistics(WinNumbers winNumbers, LottoTickets lottoTickets, Money lottoPrice) {
    this.statistics = createStatistics(winNumbers, lottoTickets);
    this.purchaseAmount = lottoPrice.multiply(lottoTickets.size());
  }

  private List<Statistic> createStatistics(WinNumbers winNumbers, LottoTickets lottoTickets) {
    return Arrays.stream(Prizes.values())
        .filter(prizes -> prizes != Prizes.NOT_PRIZE)
        .map(prize -> new Statistic(lottoTickets.getMatchedCountPerPrize(prize, winNumbers), prize))
        .collect(Collectors.toList());
  }

  public List<Statistic> getStatistics() {
    return Collections.unmodifiableList(statistics);
  }

  public double rateOfReturn() {
    Money winAmount = statistics.stream()
        .map(Statistic::getTotalPrize)
        .reduce(Money::sum)
        .orElse(Money.createWon(0));
    Rate divide = Rate.of((double) winAmount.value() / purchaseAmount.value());
    return divide.getRate();
  }
}