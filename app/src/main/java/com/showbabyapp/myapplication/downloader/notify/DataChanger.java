package com.showbabyapp.myapplication.downloader.notify;

import android.content.Context;

import com.showbabyapp.myapplication.bean.DownloadInfo;
import com.showbabyapp.myapplication.bean.DownloadState;
import com.showbabyapp.myapplication.common.db.ArshowDbManager;

import org.xutils.ex.DbException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

/**
 * Created by 秀宝-段誉 on 2016/5/13 12:49.
 * <p>
 * 被观察者
 */
public class DataChanger extends Observable {
    private static DataChanger dataChanger;
    //使用LinkedHashMap是因为链表增删快
    private HashMap<String, DownloadInfo> opraterMap;

    private Context context;

    public DataChanger(Context context) {
        this.context = context;
        opraterMap = new LinkedHashMap<>();
    }

    /**
     * 单例双重判断
     *
     * @return
     */
    public static DataChanger getInstance(Context context) {
        if (dataChanger == null) {
            synchronized (DataChanger.class) {
                if (dataChanger == null)
                    dataChanger = new DataChanger(context);
            }
        }
        return dataChanger;
    }

    /**
     * 发送状态
     *
     * @param downloadInfo
     */
    public void postStatus(DownloadInfo downloadInfo) {
        //所有的操作数据都被保存起来，以便下次使用
        opraterMap.put(downloadInfo.pid, downloadInfo);
        try {
            //TODO 不能使用saveOrUpdate，因为没有id，会插入新的数据
            ArshowDbManager.dbManager.saveOrUpdate(downloadInfo);
        } catch (DbException e) {
            e.printStackTrace();
        }

        setChanged();
        notifyObservers(downloadInfo);
    }

    /**
     * 查询所有被暂停的任务
     *
     * @return
     */
    public List<DownloadInfo> queryAllRecoverableInfos() {
        List<DownloadInfo> downloadInfos = new ArrayList<>();
        for (Map.Entry<String, DownloadInfo> entry : opraterMap.entrySet()) {
            if (entry.getValue().downloadState == DownloadState.STOPPED)
                downloadInfos.add(entry.getValue());
        }
        return downloadInfos;
    }

    /**
     * 根据id获取
     *
     * @param url
     * @return
     */
    public DownloadInfo queryDownloadInfo(String url) {
        return opraterMap.get(url);
    }

    public void addToDownloadMap(String key, DownloadInfo value) {
        opraterMap.put(key, value);
    }

    public boolean containsDownloadEntry(String id) {
        return opraterMap.containsKey(id);
    }
}
