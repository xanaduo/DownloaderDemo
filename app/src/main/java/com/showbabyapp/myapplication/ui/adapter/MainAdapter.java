/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.showbabyapp.myapplication.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.showbabyapp.myapplication.R;
import com.showbabyapp.myapplication.bean.AppliInfo;
import com.showbabyapp.myapplication.bean.DownloadInfo;
import com.showbabyapp.myapplication.bean.DownloadState;
import com.showbabyapp.myapplication.downloader.DownloadManager;

/**
 * Provide views to RecyclerView with data from list.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";
    private static DownloadManager manager;
    private AppliInfo appliInfo;

    public MainAdapter(DownloadManager manager) {
        this.manager = manager;
    }

    public void setData(AppliInfo data) {
        this.appliInfo = data;
        //notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.initData(appliInfo.data.get(position));
    }


    @Override
    public int getItemCount() {
        if (appliInfo == null)
            return 0;
        return appliInfo.data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private AppliInfo.Appli appli;
        private DownloadInfo info;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, appli.name + "/" + appli.url);
                    if (info.downloadState == DownloadState.WAITING || info.downloadState == DownloadState.FINISHED) {
                        manager.start(info);
                    } else if (info.downloadState == DownloadState.STARTED || info.downloadState == DownloadState.WAITING) {
                        manager.pause(info);
                    } else if (info.downloadState == DownloadState.STOPPED) {
                        manager.resume(info);
                    }
                }
            });
            textView = (TextView) v.findViewById(R.id.textView);
        }

        public void initData(AppliInfo.Appli appli) {
            this.appli = appli;
            textView.setText(appli.name);
            info = manager.containsDownloadEntry(appli.url) ? manager.queryDownloadInfo(appli.url) : appli.generateDownloadInfo();
        }
    }
}
