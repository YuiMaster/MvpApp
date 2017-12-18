package com.yui.mvpdemo;

import android.view.View;
import android.widget.Button;

import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.yui.libbase.BaseActivity;
import com.yui.libbase.utils.LOG;
import com.yui.mvpdemo.mvvm.model.RepoBean;
import com.yui.mvpdemo.service.GitHubService;

import java.util.List;

import javax.annotation.Nonnull;

import me.yokeyword.fragmentation.SupportFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * @author liaoyuhuan
 * @date on  2017/12/15
 * @email
 * @org
 * @describe 添加描述
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button mButton;

    @Override
    public int getActivitylayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        mButton = (Button) findViewById(R.id.btn_request);
        mButton.setOnClickListener(this);
    }

    @Override
    public SupportFragment getRootFragment() {
        return new SupportFragment();
    }


    /**
     * https://api.github.com/users/octocat/repos
     */
    private void requestRepos() {
        LOG.w("ydb/", "requestRepos");
        /** 取得service**/
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);

        Call<List<RepoBean>> repos = service.listRepos("octocat");
        repos.enqueue(new Callback<List<RepoBean>>() {
            @Override
            public void onResponse(Call<List<RepoBean>> call, Response<List<RepoBean>> response) {
                LOG.w("ydb/", "onResponse");
            }

            @Override
            public void onFailure(Call<List<RepoBean>> call, Throwable t) {
                LOG.w("ydb/", "onFailure");
            }
        });
    }

    /**
     * Called when a view has been clicked.
     *
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        requestRepos();
    }

    /**
     * @return a sequence of lifecycle events
     */
    @Nonnull
    @Override
    public Observable<ActivityEvent> lifecycle() {
        return null;
    }

    /**
     * Binds a source until a specific event occurs.
     * <p>
     * Intended for use with {@link Observable#compose(Observable.Transformer)}
     *
     * @param event the event that triggers unsubscription
     *
     * @return a reusable {@link Observable.Transformer} which unsubscribes when the event triggers.
     */
    @Nonnull
    @Override
    public <T> LifecycleTransformer<T> bindUntilEvent(@Nonnull ActivityEvent event) {
        return null;
    }

    /**
     * Binds a source until the next reasonable event occurs.
     * <p>
     * Intended for use with {@link Observable#compose(Observable.Transformer)}
     *
     * @return a reusable {@link Observable.Transformer} which unsubscribes at the correct time.
     */
    @Nonnull
    @Override
    public <T> LifecycleTransformer<T> bindToLifecycle() {
        return null;
    }
}
