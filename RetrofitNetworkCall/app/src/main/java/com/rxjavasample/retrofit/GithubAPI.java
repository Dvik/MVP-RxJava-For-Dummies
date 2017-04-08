package com.rxjavasample.retrofit;

import com.rxjavasample.model.UserInfo;
import com.rxjavasample.model.UserResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Divya on 3/30/2017.
 */

public interface GithubAPI {

    @GET("/users")
    Observable<List<UserResponse>> getUsers();

    @GET("/users/{user}")
    Observable<UserInfo> getUserInfo(@Path("user") String user);

}
