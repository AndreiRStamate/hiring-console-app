package com.company;

public class Constraint {
    private Integer limitaInferioara;
    private Integer limitaSuperioara;

    public Constraint(Integer limitaInferioara, Integer limitaSuperioara) {
        this.limitaInferioara = limitaInferioara;
        this.limitaSuperioara = limitaSuperioara;
    }

    public Integer getLimitaInferioara() {
        return limitaInferioara;
    }

    public Integer getLimitaSuperioara() {
        return limitaSuperioara;
    }
}
