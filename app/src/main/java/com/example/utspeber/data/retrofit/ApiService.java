package com.example.utspeber.data.retrofit;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @Header({"Authorization: token<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>"})
    @GET("search/users")
    Call<Response>searchUser(@Query("q")String query);

    @Header({"Authorization: token<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>"})
    @GET("users/{username}")
    Call<Response>getUser(@Path("username") String username);
}
