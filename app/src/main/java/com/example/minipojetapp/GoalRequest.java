package com.example.minipojetapp;


public class GoalRequest {

    private Long userId;
    private String skill;
    private String suggestedGoal;
    private int time;

    public GoalRequest(Long userId,
                       String skill,
                       String suggestedGoal,
                       int time) {
        this.userId = userId;
        this.skill = skill;
        this.suggestedGoal = suggestedGoal;
        this.time = time;
    }

    // getters (اختياري)
    public Long getUserId() {
        return userId;
    }

    public String getSkill() {
        return skill;
    }

    public String getSuggestedGoal() {
        return suggestedGoal;
    }

    public int getTime() {
        return time;
    }
}
