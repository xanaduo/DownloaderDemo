package org.xutils;

import com.showbabyapp.myapplication.model.net.INetCallback;

import org.xutils.common.Callback;

public abstract class XutilsCallback<Result> implements Callback.CommonCallback<Result>, INetCallback<Result> {

    public void finish() {
    }

    @Override
    public void onSuccess(Result result) {
        success(result);
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        error(ex);
    }

    @Override
    public void onCancelled(CancelledException cex) {
    }

    @Override
    public void onFinished() {
        finish();
    }
}