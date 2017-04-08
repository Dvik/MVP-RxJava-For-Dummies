package com.rxjavasample;

import com.rxjavasample.model.UserResponse;

import java.util.List;

/**
 * Created by Divya on 4/8/2017.
 */

public interface UserView {
    void updateUi(List<UserResponse> users);

    void showToast(String message);
}
