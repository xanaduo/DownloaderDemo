package com.showbabyapp.myapplication.bean;

public class PageParamInfo
{
    public int start;
    public int limit = 12;
    public String aid = "";
    public PageParamInfo()
    {
    }

    public PageParamInfo(int start, int limit)
    {
        this.start = start;
        this.limit = limit;
    } 
}