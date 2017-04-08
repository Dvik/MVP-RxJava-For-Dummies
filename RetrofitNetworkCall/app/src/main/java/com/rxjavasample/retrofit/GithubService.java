package com.rxjavasample.retrofit;

import android.app.DownloadManager;
import android.text.TextUtils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Divya on 3/30/2017.
 */

public class GithubService {

    private static String BASE_URL = "https://api.github.com/";

    public static GithubAPI createService(String token) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL);

        if (!TextUtils.isEmpty(token)) {
            OkHttpClient.Builder client = new OkHttpClient.Builder()
                    .addInterceptor(
                            chain -> {
                                Request request = chain.request()
                                        .newBuilder()
                                        .addHeader("Authorization", String.format("token %s", token))
                                        .build();
                                return chain.proceed(request);
                            }
                    );
            builder.client(client.build());
        }

        return builder.build().create(GithubAPI.class);

    }
}
