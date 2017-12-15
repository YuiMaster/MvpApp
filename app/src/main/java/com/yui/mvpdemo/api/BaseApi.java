package com.yui.mvpdemo.api;

import com.trello.rxlifecycle.LifecycleProvider;
import com.yui.mvpdemo.base.http.HttpResponseEntity;

import java.lang.ref.SoftReference;

import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Func1;

/**
 * @author liaoyuhuan
 * @date on  2017/12/15
 * @email
 * @org
 * @describe 添加描述
 */


public abstract class BaseApi<T> implements Func1<HttpResponseEntity<T>, T> {
    private SoftReference<LifecycleProvider> lifecycleProvider;
    private Retrofit retrofit;

    public BaseApi(LifecycleProvider lifecycleProvider, Retrofit retrofit) {
        setLifecycleProvider(lifecycleProvider);
        setRetrofit(retrofit);
    }

    public BaseApi(LifecycleProvider lifecycleProvider) {
        setLifecycleProvider(lifecycleProvider);
    }

    public LifecycleProvider getLifecycleProvider() {
        return lifecycleProvider.get();
    }

    public void setLifecycleProvider(LifecycleProvider lifecycleProvider) {
        this.lifecycleProvider = new SoftReference<LifecycleProvider>(lifecycleProvider);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public T call(HttpResponseEntity<T> httpResponseEntity) {
        return httpResponseEntity.getData();
    }


    public abstract Observable getObservable();
}
