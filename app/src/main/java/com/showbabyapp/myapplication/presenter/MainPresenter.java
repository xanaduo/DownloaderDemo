package com.showbabyapp.myapplication.presenter;

import com.showbabyapp.myapplication.view.IBaseView;

import org.xutils.SXutilsRequest;
import org.xutils.XutilsCallback;

/**
 * Created by 秀宝-段誉 on 2016-06-04 11:27.
 */
public class MainPresenter {
    private IBaseView baseView;

    public MainPresenter(IBaseView baseView) {
        this.baseView = baseView;
    }

    public void load(String url) {
        SXutilsRequest.post(url, new XutilsCallback<String>() {
            @Override
            public void success(String s) {
                baseView.refreshView(s);
            }

            @Override
            public void error(Throwable throwable) {
                baseView.errorView(throwable);
            }

        });
    }
}
