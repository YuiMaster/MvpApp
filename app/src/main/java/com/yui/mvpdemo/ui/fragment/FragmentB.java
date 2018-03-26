package com.yui.mvpdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yui.mvpdemo.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Administrator on 2018/3/26.
 */

public class FragmentB extends SupportFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_b, null);
        return view;
    }
}
