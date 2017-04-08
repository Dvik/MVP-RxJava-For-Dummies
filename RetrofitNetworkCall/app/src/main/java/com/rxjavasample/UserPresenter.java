package com.rxjavasample;

import com.rxjavasample.model.UserResponse;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Divya on 4/8/2017.
 */

public class UserPresenter {

    private UserInteractor interactor;
    private UserView view;
    private CompositeDisposable disposable;

    public UserPresenter(UserInteractor userInteractor) {
        this.interactor = userInteractor;
        disposable = new CompositeDisposable();
    }

    public void bind(UserView view) {
        this.view = view;
    }

    public void unbind() {
        view = null;
        disposable.dispose();
    }

    public void getUsers() {
        disposable.add(interactor
                .users()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<UserResponse>>() {
                    @Override
                    public void onNext(List<UserResponse> userResponses) {
                        if (view != null)
                            view.updateUi(userResponses);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null)
                            view.showToast(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

}
