package com.progressoft.induction;

import java.math.BigDecimal;

public enum SnackType {
    CHEWING_GUM(Money.HALF_DINAR),
    CHIPS(Money.DINAR),
    CHOCOLATE(Money.TWO_DINAR),
    ;
    public BigDecimal price;

    private SnackType(BigDecimal price) {
        this.price=price;
    }
    public BigDecimal getPrice(){
        return this.price;
    }




}
