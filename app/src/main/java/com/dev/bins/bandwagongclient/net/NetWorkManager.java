package com.dev.bins.bandwagongclient.net;

import com.dev.bins.bandwagongclient.Api;
import com.dev.bins.bandwagongclient.bean.ServerInfo;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by bin on 11/02/2017.
 */

public class NetWorkManager {

    private static NetWorkManager INSTANCE = new NetWorkManager();
    private Retrofit mRetrofit;
    private final Api mApi;

    private NetWorkManager() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mApi = mRetrofit.create(Api.class);

    }

    public static NetWorkManager getInstance() {
        return INSTANCE;
    }


    public Subscription getServerInfo(Subscriber<ServerInfo> subscriber, String veid, String api_key){
        return mApi.getServerInfo(veid,api_key)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
