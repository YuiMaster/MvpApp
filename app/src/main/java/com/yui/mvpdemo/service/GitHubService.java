package com.yui.mvpdemo.service;

import com.yui.mvpdemo.base.http.HttpResponseEntity;
import com.yui.mvpdemo.mvvm.model.RepoBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Service接口定义文档
 *
 * @author liaoyuhuan
 * @date on  2017/12/15
 * @email
 * @org
 * @describe 添加描述
 */


public interface GitHubService {

    /**
     * 请求
     *
     * @param user
     *
     * @return
     */
    @GET("users/{user}/repos")
    Observable<HttpResponseEntity<List<RepoBean>>> requestRepos(@Path("user") String user);

    /**
     * 请求
     *
     * @param user
     *
     * @return
     */
    @GET("users/{user}/repos")
    Call<List<RepoBean>> listRepos(@Path("user") String user);
}
