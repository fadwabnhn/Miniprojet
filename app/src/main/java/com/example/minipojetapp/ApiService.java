package com.example.minipojetapp;


import java.util.Map;

import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.POST;
import retrofit2.http.PUT;
import okhttp3.ResponseBody;

public interface ApiService {
    @POST("api/users/signup")
    Call<User> signup(@Body User user);

    @POST("api/users/login")
    Call<User> login(@Body User user);

    @POST("profile/save")

    Call<Void> saveProfile(@Body ProfileRequest request);

    @POST("api/goals")
    Call<GoalResponse> saveGoal(@Body GoalRequest request);


    @POST("api/goals/strategies")
    Call<Void> saveStrategies(@Body StrategyRequest request);


}

