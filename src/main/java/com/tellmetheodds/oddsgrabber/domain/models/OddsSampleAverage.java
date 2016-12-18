package com.tellmetheodds.oddsgrabber.domain.models;

import java.math.BigDecimal;

/**
 *
 * Created by rr.t3ch on 18/12/16.
 */
public class OddsSampleAverage {

    private final String date;
    private final int market;
    private final Double oddsAverage;

    public OddsSampleAverage(String date, int market, Double oddsAverage) {
        this.date = date;
        this.market = market;
        this.oddsAverage = oddsAverage;
    }

    public String getDate() {
        return date;
    }

    public int getMarket() {
        return market;
    }

    public Double getOddsAverage() {
        return oddsAverage;
    }
}
