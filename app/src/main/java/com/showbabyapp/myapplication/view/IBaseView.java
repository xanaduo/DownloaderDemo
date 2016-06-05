package com.showbabyapp.myapplication.view;

/**
 * Created by 秀宝-段誉 on 2016-06-04 13:32.
 *
 *  View接口，Data是界面展示的数据
 */
public interface IBaseView<Data> {
    void loadView();

    void successView(Data data);

    void emptyView();

    void failureView(Throwable throwable);

    void finishView();
}
