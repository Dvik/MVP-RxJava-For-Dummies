package com.rxjavasample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rxjavasample.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Divya on 3/30/2017.
 */

public class UserFragment extends Fragment implements UserView {

    @BindView(R.id.rv_user)
    RecyclerView recycler_user;

    private ArrayList<UserResponse> usersList;
    private UserAdapter userAdapter;

    private UserInteractor interactor;
    private UserPresenter presenter;

    public UserFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usersList = new ArrayList<UserResponse>();
        interactor = new UserInteractorImpl();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this, rootView);

        userAdapter = new UserAdapter(usersList, getActivity());
        recycler_user.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recycler_user.setAdapter(userAdapter);

        UserInteractor interactor = new UserInteractorImpl();
        presenter = new UserPresenter(interactor);
        presenter.bind(this);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getUsers();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        presenter.unbind();
        super.onDestroyView();
    }

    @Override
    public void updateUi(List<UserResponse> users) {
        usersList = (ArrayList<UserResponse>) users;
        userAdapter = new UserAdapter(usersList, getActivity());
        recycler_user.setAdapter(userAdapter);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();

    }
}
