package com.dev.bins.bandwagongclient.ui.fragment.common;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dev.bins.bandwagongclient.R;
import com.dev.bins.bandwagongclient.VerifyDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommonFragment extends Fragment implements CommonContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.info)
    TextView tv;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private CommonContract.Presenter mPresenter;

    public CommonFragment() {
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
        mSwipeRefreshLayout.setOnRefreshListener(this);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new CommonPresenter(this, getContext());
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
        mSwipeRefreshLayout.setRefreshing(loading);
    }

    @Override
    public void showHostDialog() {
        new VerifyDialog(getActivity()).show();
    }

    @Override
    public void onRefresh() {
        mPresenter.load();
    }
}
