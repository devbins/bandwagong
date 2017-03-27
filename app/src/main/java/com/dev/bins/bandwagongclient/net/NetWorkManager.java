package com.dev.bins.bandwagongclient.net;

import com.dev.bins.bandwagongclient.bean.AvailableOS;
import com.dev.bins.bandwagongclient.bean.ResultCode;
import com.dev.bins.bandwagongclient.bean.ServerInfo;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by bin on 11/02/2017.
 */

public class NetWorkManager {

    private static NetWorkManager INSTANCE = new NetWorkManager();
    private final Api mApi;
    private Retrofit mRetrofit;

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


    public Subscription getServerInfo(Subscriber<ServerInfo> subscriber, String veid, String api_key) {
        return request(mApi.getServerInfo(veid, api_key),subscriber);
    }

    public Subscription getAvailableOS(Subscriber<AvailableOS> subscriber, String veid, String api_key) {
        return request(mApi.getAvailableOS(veid, api_key),subscriber);

    }

    public Subscription kill(Subscriber<ResultCode> subscriber, String veid, String api_key) {
        return request(mApi.kill(veid, api_key),subscriber);
    }

    public Subscription start(Subscriber<ResultCode> subscriber, String veid, String api_key) {
        return request(mApi.start(veid, api_key),subscriber);
    }

    public Subscription stop(Subscriber<ResultCode> subscriber, String veid, String api_key) {
        return request(mApi.stop(veid, api_key),subscriber);
    }

    public Subscription restart(Subscriber<ResultCode> subscriber, String veid, String api_key) {
        return request(mApi.restart(veid, api_key),subscriber);
    }


    public <T> Subscription request(Observable<T> observable, Subscriber<T> subscriber) {
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
