package com.rxjavasample;

import com.rxjavasample.model.UserResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Divya on 4/8/2017.
 */

public interface UserInteractor {
    Observable<List<UserResponse>> users();
}
