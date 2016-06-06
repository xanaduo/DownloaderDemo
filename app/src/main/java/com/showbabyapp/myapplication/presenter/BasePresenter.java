package com.showbabyapp.myapplication.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016-06-05.
 * <p/>
 * Presenter接口，V表示是View接口
 */
public abstract class BasePresenter<V> {
    /**
     * View接口类型的弱引用
     */
    protected Reference<V> viewRef;

    public BasePresenter(V viewRef) {
        attachView(viewRef);
    }

    /**
     * 添加View
     *
     * @param viewRef
     */
    public void attachView(V viewRef) {
        this.viewRef = new WeakReference<>(viewRef);
    }

    /**
     * 获得View
     *
     * @return
     */
    protected V getView() {
        return this.viewRef.get();
    }

    /**
     * 判断是否添加了
     *
     * @return
     */
    public boolean isViewAttached() {
        return this.viewRef != null && viewRef.get() != null;
    }

    /**
     * 移除View
     */
    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
