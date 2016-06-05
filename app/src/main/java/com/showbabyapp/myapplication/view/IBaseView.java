package com.showbabyapp.myapplication.view;

/**
 * Created by 秀宝-段誉 on 2016-06-04 13:32.
 * <p/>
 * View接口，Data是界面展示的数据
 */
public interface IBaseView<Data> {
    /**
     * 加载的界面
     */
    void loadView();

    /**
     * 成功的界面
     *
     * @param data
     */
    void successView(Data data);

    /**
     * 数据为空的界面
     */
    void emptyView();

    /**
     * 失败的界面
     *
     * @param throwable
     */
    void failureView(Throwable throwable);

    /**
     * 界面结束
     */
    void finishView();

}
