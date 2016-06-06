package com.showbabyapp.myapplication.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.showbabyapp.myapplication.presenter.BasePresenter;

/**
 * Created by 秀宝-段誉 on 2016-06-05.
 * 邮箱：xanaduo@qq.com
 */
public abstract class MVPBaseActivity<V, P extends BasePresenter<V>> extends AppCompatActivity {
    /**
     * Presenter对象
     */
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.presenter = createPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.detachView();
    }

    /**
     * 创建Presenter
     * @return
     */
    protected abstract P createPresenter();
}
