package com.yui.libbase;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.android.ActivityEvent;

import me.yokeyword.fragmentation.SupportActivity;
import rx.subjects.BehaviorSubject;

/**
 * 更新当前状态
 *
 * @author liaoyuhuan
 * @date on  2017/12/15
 * @email
 * @org
 * @describe 添加描述
 */

public abstract class LifecycleActivity extends SupportActivity implements LifecycleProvider<ActivityEvent> {

    private final BehaviorSubject<ActivityEvent> behaviorSubject = BehaviorSubject.create();

    @Override
    @CallSuper
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        behaviorSubject.onNext(ActivityEvent.CREATE);
    }

    @Override
    @CallSuper
    protected void onStart() {
        super.onStart();
        behaviorSubject.onNext(ActivityEvent.START);
    }

    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
        behaviorSubject.onNext(ActivityEvent.RESUME);
    }

    @Override
    @CallSuper
    protected void onPause() {
        behaviorSubject.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override
    @CallSuper
    protected void onStop() {
        behaviorSubject.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    @Override
    @CallSuper
    protected void onDestroy() {
        behaviorSubject.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }
}
