package com.showbabyapp.myapplication.bean;

public class DownloadHolderInfo
{
    public String prid;// 主键ID
    public String pid;// 分类ID
    public String androidPath;// 资源包的路径
    public String androidSize;// 资源包的大小
    public String title;// 产品标题
    public String thumbImage;// 缩略图
    public String version;// 资源包的版本
    /**
     * 是否激活，默认激活
     */
    public int activated;
}