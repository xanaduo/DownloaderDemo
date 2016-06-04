package com.showbabyapp.myapplication.common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.showbabyapp.myapplication.bean.PageParamInfo;
import com.showbabyapp.myapplication.constant.ServerParameterConstant;

import org.xutils.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

public class ParameterUtils
{
    /**
     * 装载参数
     * @return
     */
    public static RequestParams loadParameters(String url, List<? extends PageParamInfo> list)
    {
        return loadParameter(url, list);
    }

    /**
     * 装载参数
     * @return
     */
    public static RequestParams loadParameter(String url, PageParamInfo paramInfo)
    {
        List<PageParamInfo> list = new ArrayList<>();
        if (paramInfo != null)
            list.add(paramInfo);
        return loadParameter(url, list);
    }


    /**
     * 加载参数
     * @param url
     * @return
     */
    public static RequestParams loadParameter(String url)
    {
        List<PageParamInfo> list = new ArrayList<>();
        return loadParameter(url, list);
    }

    /**
     * 装载参数
     * @param url
     * @param list
     * @return
     */
    private static RequestParams loadParameter(String url, List<? extends PageParamInfo> list)
    {
        RequestParams rp = new RequestParams(url);
        rp.addBodyParameter("PDATA", addProperty(list));
        return rp;
    }


    /**
     * 传入集合
     * @param list
     * @return
     */
    public static String addProperty(List<? extends Object> list)
    {
        JsonObject jo = new JsonObject();
        //公钥
        jo.addProperty(ServerParameterConstant.APPKEY, "");
        jo.addProperty(ServerParameterConstant.SIGNATURE, "");
        //时间戳
        jo.addProperty(ServerParameterConstant.TIMESTAMP, (System.currentTimeMillis() / 1000) + "");
        jo.addProperty(ServerParameterConstant.STS, "");
        jo.addProperty(ServerParameterConstant.MODEL, "");
        jo.addProperty(ServerParameterConstant.RMK, "");
        jo.addProperty(ServerParameterConstant.APKVERSION, "");
        jo.addProperty(ServerParameterConstant.REGISTERID, "");
        JsonParser jp = new JsonParser();
        jo.add(ServerParameterConstant.BIZ,jp.parse(new Gson().toJson(list)));
        return jo.toString();
    }

}