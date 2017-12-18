package com.yui.libbase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yui.libbase.utils.LOG;
import com.yui.libbase.utils.ToastUtil;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author Jane
 * @date 2017/11/21
 * <p>
 * Activity 基础类
 */

public abstract class BaseActivity extends LifecycleActivity implements IBaseViewHolder {
    protected Context mActivity;
    protected HttpManager mHttpManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mHttpManager = new HttpManager();
        setContentView(getActivitylayout());

        if(savedInstanceState == null){
            loadRootFragment(R.id.fl_container,getRootFragment());
        }


        initData();
        initView();
        finalInit();
    }

    public abstract int getActivitylayout();

    public abstract void initData();

    public abstract void initView();

    public abstract SupportFragment getRootFragment();

    public void finalInit() {

    }

    @Override
    public void showErro(Throwable e) {
        LOG.w("showErro " + e);
        ToastUtil.show(this, "showErro " + e);
    }

    @Override
    public void showSuccess() {
        LOG.w("showSuccess ");
    }
}
