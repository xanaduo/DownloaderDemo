package com.showbabyapp.myapplication.model;

/**
 * Created by 秀宝-段誉 on 2016-06-05.
 * 邮箱：xanaduo@qq.com
 * <p/>
 * 数据模型，Param是请求参数，Result是返回结果
 */
public interface IBaseModel<Param, Result> {
    void load(Param param, ModelListener<Result> listener);
}
