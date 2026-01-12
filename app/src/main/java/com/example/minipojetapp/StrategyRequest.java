package com.example.minipojetapp;

import java.util.List;

public class StrategyRequest {

    private Long goalId;
    private List<String> strategies;

    public StrategyRequest(Long goalId, List<String> strategies) {
        this.goalId = goalId;
        this.strategies = strategies;
    }

    public Long getGoalId() {
        return goalId;
    }

    public List<String> getStrategies() {
        return strategies;
    }
}
