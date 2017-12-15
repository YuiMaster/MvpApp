package com.yui.mvpdemo.base.http;

/**
 * @author liaoyuhuan
 * @date on  2017/12/15
 * @email
 * @org
 * @describe 添加描述
 */

public class HttpResponseEntity<T> {
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;
}
