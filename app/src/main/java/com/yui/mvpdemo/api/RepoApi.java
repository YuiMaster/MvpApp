package com.yui.mvpdemo.api;

import com.trello.rxlifecycle.LifecycleProvider;
import com.yui.mvpdemo.service.GitHubService;

import retrofit2.Retrofit;
import rx.Observable;


/**
 * Created by Jane on 2017/12/15.
 * 请求repo 接口
 */

public class RepoApi extends BaseApi {
    private String name;

    public void setArgument(String name) {
        this.name = name;
    }

    public RepoApi(LifecycleProvider lifecycleProvider, Retrofit retrofit) {
        super(lifecycleProvider, retrofit);
    }

    @Override
    public Observable getObservable() {
        GitHubService service = getRetrofit().create(GitHubService.class);
        return service.requestRepos(name);
    }

}
