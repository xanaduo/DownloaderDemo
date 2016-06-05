package com.showbabyapp.myapplication.model;

/**
 * Created by 秀宝-段誉 on 2016-06-05.
 * 邮箱：xanaduo@qq.com
 *
 * 数据模型的接口回调，Result表示回调的结果
 */
public interface ModelListener<Result> {
    void onSuccess(Result result);

    void onEmpty();

    void onFailure(Throwable throwable);

    void onFinish();
}
