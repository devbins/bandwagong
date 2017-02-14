package com.dev.bins.bandwagongclient.ui.fragment.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.dev.bins.bandwagongclient.bean.ServerInfo;
import com.dev.bins.bandwagongclient.net.NetWorkManager;
import com.dev.bins.bandwagongclient.util.SharePreferenceConstant;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by bin on 11/02/2017.
 */

public class CommonPresenter implements CommonContract.Presenter {

    private CommonContract.View mView;

    private CompositeSubscription mSubscriptions;

    private Context mContext;

    public CommonPresenter(CommonContract.View mView, Context context) {
        this.mView = mView;
        mContext = context;
        mView.setPresenter(this);
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void subscribe() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(mContext);
        String veid = sp.getString(SharePreferenceConstant.VEID, null);
        String key = sp.getString(SharePreferenceConstant.key, null);
        if (TextUtils.isEmpty(veid) || TextUtils.isEmpty(key)) {
            mView.showHostDialog();
            return;
        }
        load();
    }

    @Override
    public void load() {
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
