package com.progressoft.induction;


import java.math.BigDecimal;

import static java.util.Objects.isNull;


public class SnackMachine {

    private Snack chips;
    private Snack chocolates;
    private Snack chewingGums;
    private Money inserted;
    public static final int DEFAULT_QUANTITY = 10;
    private BigDecimal moneyInside;

    public SnackMachine() {
        chips = new Snack(DEFAULT_QUANTITY, SnackType.CHIPS);
        chocolates = new Snack(DEFAULT_QUANTITY, SnackType.CHOCOLATE);
        chewingGums = new Snack(DEFAULT_QUANTITY, SnackType.CHEWING_GUM);
        this.moneyInside = Money.ZERO;
        inserted = new Money(Money.ZERO);
    }

    public BigDecimal moneyInside() {
        return moneyInside;
    }


    public void insertMoney(Object amount) {
        if (!(amount instanceof BigDecimal))
            throw new IllegalArgumentException();
        BigDecimal val = (BigDecimal) amount;

        if (!Money.accepted.contains(val))
            throw new IllegalArgumentException();
        inserted = inserted.add(new Money(val));
    }

    public void insertMoney(Money amount) {
        if (isNull(amount))
            throw new IllegalArgumentException();
        if (!Money.accepted.contains(amount.currentMoney))
            throw new IllegalArgumentException();
        inserted = inserted.add(amount);

    }

    public Money moneyInTransaction() {
        return inserted;
    }

    public Snack chewingGums() {
        return chewingGums;
    }

    public Snack chips() {
        return chips;
    }

    public Snack chocolates() {
        return chocolates;
    }
    public boolean enoughPrice(SnackType type){
        return moneyInTransaction().currentMoney.compareTo(type.getPrice()) != -1;
    }

    public void addMoney(SnackType type){ moneyInside = moneyInside.add(type.getPrice());}

    public Money buySnack(SnackType type) {
        boolean flag=true;
        if (type.equals(SnackType.CHEWING_GUM) && chewingGums.isAvailable()) {
            if (enoughPrice(type)) {
                chewingGums.setQuantity(chewingGums.quantity() - 1);
                addMoney(type);
                flag=false;
            }
        } else if (type.equals(SnackType.CHIPS) && chips.isAvailable()) {
            if (enoughPrice(type)) {
                chips.setQuantity(chips.quantity() - 1);
                addMoney(type);
                flag=false;
            }
        } else if (type.equals(SnackType.CHOCOLATE)&&chocolates.isAvailable())
            if (enoughPrice(type)) {
                chocolates.setQuantity(chocolates.quantity() - 1);
                addMoney(type);
                flag=false;
            }
        if(!flag)
            if (enoughPrice(type)) {
                Money val =new Money( inserted.subtract(new Money(type.getPrice())).currentMoney);
                inserted.currentMoney=BigDecimal.valueOf(0.0);
                return val;
            }
        throw new IllegalStateException();

    }
}
