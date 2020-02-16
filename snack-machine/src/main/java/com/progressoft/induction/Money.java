package com.progressoft.induction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Money {
    public BigDecimal currentMoney;
    public static final BigDecimal ZERO = BigDecimal.valueOf(0.0);
    public static final BigDecimal QUARTER_DINAR = BigDecimal.valueOf(0.25);
    public static final BigDecimal HALF_DINAR = BigDecimal.valueOf(0.5);
    public static final BigDecimal DINAR = BigDecimal.valueOf(1.0);
    public static final BigDecimal TWO_DINAR = BigDecimal.valueOf(2.0);
    public static final BigDecimal FIVE_DINAR = BigDecimal.valueOf(5.0);
    public static final BigDecimal TEN_DINAR = BigDecimal.valueOf(10.0);
    public static final List<BigDecimal> accepted = Arrays.asList(QUARTER_DINAR, HALF_DINAR, DINAR, FIVE_DINAR, TEN_DINAR);

    public Money() {
        currentMoney = BigDecimal.valueOf(0);

    }

    public Money(BigDecimal amount) {
        if (amount.doubleValue() >= 0)
            currentMoney = amount;
        else
            throw new IllegalArgumentException();
    }

    public boolean isLessThan(Money compared) {

        if (compared == null)
            return false;
        else return this.currentMoney.doubleValue() < compared.currentMoney.doubleValue();

    }

    public Money subtract(Money amount) {
        if (this.currentMoney.doubleValue() < amount.currentMoney.doubleValue()) {

            throw new IllegalArgumentException();
        } else {
            this.currentMoney = this.currentMoney.subtract(amount.currentMoney);
        }
        return this;
    }

    public Money add(Money amount) {
        this.currentMoney = this.currentMoney.add(amount.currentMoney);

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof Money) {
            Money money = (Money) o;
            return currentMoney.equals(money.currentMoney);
        }
        return this.currentMoney.equals(o);
    }

}
