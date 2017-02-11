package com.dev.bins.bandwagongclient.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dev.bins.bandwagongclient.ui.fragment.common.CommonFragment;
import com.dev.bins.bandwagongclient.ui.fragment.ShellFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bin on 11/02/2017.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragments = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(CommonFragment.newInstance());
        fragments.add(ShellFragment.newInstance());

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
