package com.showbabyapp.myapplication.common;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by 秀宝-段誉 on 2016-06-04 15:59.
 */
public class ContextUtils {
    /**
     * SD卡的路径
     */
    public static final String SDCARD_PATH = Environment.getExternalStorageDirectory() + File.separator;

    /**
     * APP所在的SD路径
     * @param context
     * @return
     */
    public static String appPath(Context context) {
        return SDCARD_PATH + "Android/data/" + context.getPackageName() + File.separator;
    }
}
