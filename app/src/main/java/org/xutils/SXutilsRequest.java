package org.xutils;

import com.showbabyapp.myapplication.bean.PageParamInfo;
import com.showbabyapp.myapplication.common.ParameterUtils;

/**
 * Created by 秀宝-段誉 on 2016-06-04 10:22.
 * <p/>
 * xutils框架的请求类
 */
public class SXutilsRequest {

    /**
     * post请求传参
     *
     * @param url
     * @param callback
     */
    public static void post(String url, XutilsCallback<String> callback) {
        post(url, null, callback);
    }

    /**
     * post请求，传参
     *
     * @param url
     * @param bean
     * @param callback
     */
    public static void post(String url, PageParamInfo bean, XutilsCallback<String> callback) {
        x.http().post(ParameterUtils.loadParameter(url, bean), callback);
    }

}
