package com.showbabyapp.myapplication.downloader;

import android.os.Handler;

import com.showbabyapp.myapplication.bean.DownloadInfo;

/**
 * Created by 秀宝-段誉 on 2016/5/13 12:49.
 * <p/>
 * 1、如果服务器不支持断点下载就用单线程下载单任务下载
 * 2、如果支持则使用多线程多任务下载
 */
public class DownloadTask implements Runnable {
    private DownloadInfo downloadInfo;
    private boolean paused;
    private boolean canceled;
    private Handler handler;

    public DownloadTask(DownloadInfo downloadInfo, Handler handler) {
        this.downloadInfo = downloadInfo;
        this.handler = handler;
    }

    public void resume() {
    }

    public void pause() {
        this.paused = true;
    }

    public void cancel() {
        this.canceled = true;
    }

    /**
     * 开始下载
     */
    private void start() {

        notifyUpdate(DownloadService.HANDLER_WHAT, downloadInfo);
    }

    @Override
    public void run() {
        start();
    }

    /**
     * 更新进度
     *
     * @param what
     * @param downloadInfo
     */
    public void notifyUpdate(int what, DownloadInfo downloadInfo) {
        handler.obtainMessage(what, downloadInfo).sendToTarget();
    }
}
