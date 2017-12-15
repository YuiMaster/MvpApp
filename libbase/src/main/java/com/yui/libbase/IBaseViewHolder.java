package com.yui.libbase;

/**
 * @param <T>
 *
 * @author Jane
 * @date 2017/11/23
 */

public interface IBaseViewHolder<T> {
    /**
     * 显示错误
     *
     * @param e
     */
    void showErro(Throwable e);

    /**
     * 显示操作成功
     */
    void showSuccess();
}
