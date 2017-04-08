package com.rxjavasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content,new UserFragment(),this.toString())
                .commit();
    }
}
