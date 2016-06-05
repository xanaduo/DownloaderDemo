package com.showbabyapp.myapplication.model.rank;

import com.google.gson.Gson;
import com.showbabyapp.myapplication.bean.AppliInfo;
import com.showbabyapp.myapplication.model.IBaseModel;
import com.showbabyapp.myapplication.model.ModelListener;

import org.xutils.SXutilsRequest;
import org.xutils.XutilsCallback;

/**
 * Created by 秀宝-段誉 on 2016-06-05.
 * 邮箱：xanaduo@qq.com
 */
public class RankModel implements IBaseModel<String, AppliInfo> {

    @Override
    public void load(String url, final ModelListener<AppliInfo> listener) {
        SXutilsRequest.post(url, new XutilsCallback<String>() {
            @Override
            public void success(String s) {
                AppliInfo appliInfo = new Gson().fromJson(s, AppliInfo.class);
                if (appliInfo.ret == 200) {
                    listener.onSuccess(appliInfo);
                } else if (appliInfo.ret == 500) {
                    listener.onEmpty();
                }
            }

            @Override
            public void error(Throwable throwable) {
                listener.onFailure(throwable);
            }

            @Override
            public void finish() {
                listener.onFinish();
            }
        });
    }
}
