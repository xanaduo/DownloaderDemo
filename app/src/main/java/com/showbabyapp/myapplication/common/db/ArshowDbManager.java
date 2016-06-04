package com.showbabyapp.myapplication.common.db;

import android.content.Context;

import com.showbabyapp.myapplication.common.ContextUtils;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * 数据库管理
 *
 * @author 黄校
 * 2016年3月18日 下午8:24:40
 */
public class ArshowDbManager {
	private static ArshowDbManager instance;
	public static DbManager dbManager;

	private ArshowDbManager(Context context) {
		String dbName = this.getClass().getSimpleName() + "_" + context.getPackageName() + ".db";
		DbManager.DaoConfig daoConfig = new DbManager.DaoConfig().setDbDir(new File(ContextUtils.appPath(context)))
				.setDbName(dbName).setDbVersion(12);
		dbManager = x.getDb(daoConfig);
	}

	/**
	 * 获得账户管理
	 * @return
	 */
	public static ArshowDbManager getInstance(Context context) {
		if (instance == null) {
			synchronized (ArshowDbManager.class) {
				if (instance == null) {
					instance = new ArshowDbManager(context);
				}
			}
		}
		return instance;
	}
}
