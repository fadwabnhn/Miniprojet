package com.example.minipojetapp;


import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.POST;

public interface ApiService {
    @POST("api/users/signup")
    Call<User> signup(@Body User user);

    @POST("api/users/login")
    Call<User> login(@Body User user);
}
