package com.dev.bins.bandwagongclient.net;

import com.dev.bins.bandwagongclient.Api;
import com.dev.bins.bandwagongclient.bean.AvailableOS;
import com.dev.bins.bandwagongclient.bean.ResultCode;
import com.dev.bins.bandwagongclient.bean.ServerInfo;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
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
        return mApi.getServerInfo(veid, api_key)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public Subscription getAvailableOS(Subscriber<AvailableOS> subscriber, String veid, String api_key) {
        return mApi.getAvailableOS(veid, api_key)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public Subscription kill(Subscriber<ResultCode> subscriber, String veid, String api_key) {
        return mApi.kill(veid, api_key)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public Subscription start(Subscriber<ResultCode> subscriber, String veid, String api_key) {
        return mApi.start(veid, api_key)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public Subscription stop(Subscriber<ResultCode> subscriber, String veid, String api_key) {
        return mApi.stop(veid, api_key)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public Subscription restart(Subscriber<ResultCode> subscriber, String veid, String api_key) {
        return mApi.restart(veid, api_key)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
