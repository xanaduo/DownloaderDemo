package com.showbabyapp.myapplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by 秀宝-段誉 on 2016-06-05.
 * 邮箱：xanaduo@qq.com
 */
public abstract class MVPBaseFragment<P> extends Fragment {
    /**
     * Presenter对象
     */
    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
