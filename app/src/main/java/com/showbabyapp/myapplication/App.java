package com.showbabyapp.myapplication;

import android.app.Application;

import com.showbabyapp.myapplication.downloader.DownloadManager;

import org.xutils.x;

/**
 * Created by 秀宝-段誉 on 2016-06-05.
 * 邮箱：xanaduo@qq.com
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        DownloadManager.getInstance(this);
    }
}
