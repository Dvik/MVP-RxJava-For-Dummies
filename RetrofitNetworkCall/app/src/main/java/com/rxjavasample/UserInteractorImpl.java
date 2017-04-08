package com.rxjavasample;

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

    public UserInteractorImpl() {
        service = GithubService.createService("70b893249a22986d14bb162bf13b7a60e3dee5f4");
    }

    @Override
    public Observable<List<UserResponse>> users() {
        return service.getUsers().subscribeOn(Schedulers.io());
    }
}
