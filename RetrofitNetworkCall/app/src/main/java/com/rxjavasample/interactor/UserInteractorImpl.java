package com.rxjavasample.interactor;

import com.rxjavasample.model.UserResponse;
import com.rxjavasample.retrofit.GithubAPI;
import com.rxjavasample.retrofit.GithubService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Divya on 4/8/2017.
 */

public class UserInteractorImpl implements UserInteractor {

    private GithubAPI service;

    public UserInteractorImpl(String accessToken) {
        service = GithubService.createService(accessToken);
    }

    @Override
    public Observable<List<UserResponse>> users() {
        return service.getUsers().subscribeOn(Schedulers.io());
    }
}
