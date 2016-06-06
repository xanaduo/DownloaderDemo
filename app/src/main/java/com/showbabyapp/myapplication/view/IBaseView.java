package com.showbabyapp.myapplication.view;

/**
 * Created by 秀宝-段誉 on 2016-06-06.
 * 邮箱：xanaduo@qq.com
 */
public interface IBaseView<P> {

    /**
     * View接口都需要实现
     * @param presenter
     */
    void setPresenter(P presenter);
}
