package com.dev.bins.bandwagongclient.ui.fragment.common;

import com.dev.bins.bandwagongclient.BasePresenter;
import com.dev.bins.bandwagongclient.BaseView;

/**
 * Created by bin on 11/02/2017.
 */

public interface CommonContract {


    interface View extends BaseView<Presenter> {
        void setText(String text);

        void showLoad(boolean loading);

        void showHostDialog();
    }


    interface Presenter extends BasePresenter{
        void load();
    }
}
