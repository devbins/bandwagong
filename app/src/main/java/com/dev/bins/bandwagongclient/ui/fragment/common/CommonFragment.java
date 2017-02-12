package com.dev.bins.bandwagongclient.ui.fragment.common;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dev.bins.bandwagongclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommonFragment extends Fragment implements CommonContract.View {

    @BindView(R.id.info)
    TextView tv;
    @BindView(R.id.pb)
    ProgressBar mPb;
    private CommonContract.Presenter mPresenter;

    public CommonFragment() {
        mPresenter = new CommonPresenter(this);
    }

    public static CommonFragment newInstance() {

        Bundle args = new Bundle();

        CommonFragment fragment = new CommonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_common, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void setPresenter(CommonContract.Presenter presenter) {
//        mPresenter = presenter;
    }

    @Override

    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void setText(String text) {
        tv.setText(text);
    }

    @Override
    public void showLoad(boolean loading) {
        if (loading) {
            mPb.setVisibility(View.VISIBLE);
        } else {
            mPb.setVisibility(View.INVISIBLE);
        }
    }
}
