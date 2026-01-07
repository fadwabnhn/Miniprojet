package com.example.minipojetapp;

public class ProfileRequest {

    private Long userId;
    private String name;
    private String level;
    private String preference;
    private int timeSelected;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public int getTimeSelected() {
        return timeSelected;
    }

    public void setTimeSelected(int timeSelected) {
        this.timeSelected = timeSelected;
    }
}
