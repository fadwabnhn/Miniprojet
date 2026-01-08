package com.example.minipojetapp;

public class User {
    private int id; // <-- معرف المستخدم
    private String email;
    private String password;

    // Constructor لتسجيل الدخول/التسجيل
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Constructor كامل إذا أردت استقبال البيانات من السيرفر
    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    // Getter و Setter للـ id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // Getter و Setter للبريد الإلكتروني
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Getter و Setter لكلمة المرور
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
