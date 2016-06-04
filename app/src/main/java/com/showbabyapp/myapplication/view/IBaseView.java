package com.showbabyapp.myapplication.view;

/**
 * Created by 秀宝-段誉 on 2016-06-04 13:32.
 */
public interface IBaseView<Result> {

    void refreshView(Result data);

    void errorView(Throwable throwable);
}
