package com.showbabyapp.myapplication.model.net;

/**
 * Created by 秀宝-段誉 on 2016-06-04 13:15.
 */
public interface INetCallback<Result> {

    void success(Result result);

    void error(Throwable throwable);

    void finish();
}
