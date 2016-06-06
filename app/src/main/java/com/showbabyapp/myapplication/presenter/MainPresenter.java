package com.showbabyapp.myapplication.presenter;

import com.showbabyapp.myapplication.bean.AppliInfo;
import com.showbabyapp.myapplication.model.IBaseModel;
import com.showbabyapp.myapplication.model.ModelListener;
import com.showbabyapp.myapplication.model.rank.RankModel;
import com.showbabyapp.myapplication.view.IDefaultView;

/**
 * Created by 秀宝-段誉 on 2016-06-04 11:27.
 */
public class MainPresenter extends BasePresenter<IDefaultView> {
    private IBaseModel<String, AppliInfo> model;
    private String url = "http://api.stay4it.com/v1/public/core/?service=downloader.applist";

    public MainPresenter(IDefaultView viewRef) {
        super(viewRef);
        viewRef.setPresenter(this);
        model = new RankModel();
    }

    public void load() {
        getView().loadView();
        model.load(url, new ModelListener<AppliInfo>() {
            @Override
            public void onSuccess(AppliInfo result) {
                getView().successView(result);
            }

            @Override
            public void onEmpty() {
                getView().emptyView();
            }

            @Override
            public void onFailure(Throwable throwable) {
                getView().failureView(throwable);
            }

            @Override
            public void onFinish() {
                getView().finishView();
            }
        });
    }

}
