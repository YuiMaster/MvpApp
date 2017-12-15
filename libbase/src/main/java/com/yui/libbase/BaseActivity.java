package com.yui.libbase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle.components.RxActivity;
import com.yui.libbase.utils.LOG;
import com.yui.libbase.utils.ToastUtil;

/**
 * @author Jane
 * @date 2017/11/21
 * <p>
 * Activity 基础类
 */

public abstract class BaseActivity extends RxActivity implements IBaseViewHolder {


    protected Context mActivity;
    protected HttpManager mHttpManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        mHttpManager = new HttpManager();
        setContentView(getActivitylayout());
        initData();
        initView();
        finalInit();
    }

    public abstract int getActivitylayout();

    public abstract void initData();

    public abstract void initView();

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
