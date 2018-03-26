package com.yui.mvpdemo.ui.activity;

import android.view.View;
import android.widget.Button;

import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.yui.libbase.BaseActivity;
import com.yui.mvpdemo.R;
import com.yui.mvpdemo.ui.fragment.FragmentA;
import com.yui.mvpdemo.ui.fragment.FragmentB;

import javax.annotation.Nonnull;

import me.yokeyword.fragmentation.SupportFragment;
import rx.Observable;

/**
 * Created by Administrator on 2018/3/26.
 */

public class TestActivity extends BaseActivity {

    private Button mBtn1;

    @Override
    public int getActivitylayout() {
        return R.layout.activity_test;
    }

    @Override
    public void initData() {
    }


    private boolean addEd = true;

    @Override
    public void initView() {
        mBtn1 = (Button) findViewById(R.id.btn_request);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (addEd) {
                    replaceLoadRootFragment(R.id.fl_container, new FragmentB(), false);
                } else {
                    replaceLoadRootFragment(R.id.fl_container, new FragmentA(), false);
                }
                addEd = !addEd;
            }
        });

    }


    @Override
    public SupportFragment getRootFragment() {
        return new FragmentA();
    }


    @Nonnull
    @Override
    public Observable<ActivityEvent> lifecycle() {
        return null;
    }

    @Nonnull
    @Override
    public <T> LifecycleTransformer<T> bindUntilEvent(@Nonnull ActivityEvent event) {
        return null;
    }

    @Nonnull
    @Override
    public <T> LifecycleTransformer<T> bindToLifecycle() {
        return null;
    }
}
