package com.dev.bins.bandwagongclient.ui.fragment.common;

import android.preference.PreferenceManager;

import com.dev.bins.bandwagongclient.bean.ServerInfo;
import com.dev.bins.bandwagongclient.net.NetWorkManager;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by bin on 11/02/2017.
 */

public class CommonPresenter implements CommonContract.Presenter {

    private CommonContract.View mView;

    private CompositeSubscription mSubscriptions;

    public CommonPresenter(CommonContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void subscribe() {

        PreferenceManager.getDefaultSharedPreferences()

        mView.showLoad(true);
        Subscriber<ServerInfo> subscriber = new Subscriber<ServerInfo>() {
            @Override
            public void onCompleted() {
                System.out.println("complete");
                mView.showLoad(false);
            }

            @Override
            public void onError(Throwable e) {
                mView.showLoad(false);
                e.printStackTrace();
            }

            @Override
            public void onNext(ServerInfo serverInfo) {
                mView.setText(serverInfo.toString());
            }
        };
        Subscription subscription = NetWorkManager.getInstance().getServerInfo(subscriber, "471025", "private_bKsAUc4F9mmur33apTIagx8u");
        mSubscriptions.add(subscription);
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
        if (mSubscriptions != null)
            mSubscriptions.unsubscribe();
    }
}
