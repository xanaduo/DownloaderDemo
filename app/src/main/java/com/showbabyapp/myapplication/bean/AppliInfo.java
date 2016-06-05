package com.showbabyapp.myapplication.bean;

import java.util.List;

/**
 * Created by 秀宝-段誉 on 2016-06-05.
 * 邮箱：xanaduo@qq.com
 */
public class AppliInfo {
    public int ret;
    public String msg;
    public List<Appli> data;

    public static class Appli {
        public String name;
        public String desc;
        public String size;
        public String icon;
        public String url;

        public DownloadInfo generateDownloadInfo() {
            DownloadInfo info = new DownloadInfo();
            info.pid = url;
            info.fileName = name;
            info.downloadUrl = url;
            return info;
        }
    }
}
