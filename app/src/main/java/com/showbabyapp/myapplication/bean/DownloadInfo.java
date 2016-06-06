package com.showbabyapp.myapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Author: wyouflf Date: 13-11-10 Time: 下午8:11
 */
@Table(name = "download", onCreated = "CREATE UNIQUE INDEX index_download ON download(downloadUrl,fileSavePath)")
public class DownloadInfo implements Parcelable {
    public static final int MAX_TASK = 2;
    public static final String KEY_DOWNLOAD_ACTION = "KEY_DOWNLOAD_ACTION";
    public static final int VALUE_DOWNLOAD_ACTION_START = 0;
    public static final int VALUE_DOWNLOAD_ACTION_PAUSE = 1;
    public static final int VALUE_DOWNLOAD_ACTION_RESUME = 2;
    public static final int VALUE_DOWNLOAD_ACTION_CANCEL = 3;
    public static final int VALUE_DOWNLOAD_ACTION_PAUSE_ALL = 4;
    public static final int VALUE_DOWNLOAD_ACTION_RECOVER_ALL = 5;

    @Column(name = "id", isId = true)
    public long id;

    @Column(name = "state")
    public int state = DownloadState.WAITING.value();

    public DownloadState downloadState;

    @Column(name = "fileSavePath")
    public String fileSavePath;

    @Column(name = "progress")
    public long progress;

    @Column(name = "fileLength")
    public long fileLength;

    @Column(name = "autoResume")
    public boolean autoResume;

    @Column(name = "autoRename")
    public boolean autoRename;

    /**
     * 资源的id
     */
    @Column(name = "pid")
    public String pid;

    @Column(name = "downloadUrl")
    public String downloadUrl;

    @Column(name = "fileName")
    public String fileName;

    @Column(name = "imageSavePath")
    public String imageSavePath;

    /**
     * 资源的URI
     */
    @Column(name = "resourceUri")
    public String resourceUri;

    /**
     * 资源类型
     */
    @Column(name = "resType")
    public String resType;

    @Column(name = "downloadSpeed")
    public String downloadSpeed = "0B/s";

    @Column(name = "downloadImageUrl")
    public String downloadImageUrl;

    @Column(name = "isDone")
    public boolean isDone;
    /**
     * 版本号
     */
    @Column(name = "version")
    public String version;
    @Column(name = "androidSize")
    public String androidSize;
    /**
     * 是否激活
     */
    @Column(name = "activate")
    public int activate;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof DownloadInfo))
            return false;

        DownloadInfo that = (DownloadInfo) o;

        if (id != that.id)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }


    @Override
    public String toString() {
        return "DownloadInfo{" +
                "progress=" + progress +
                ", fileLength=" + fileLength +
                ", fileName='" + fileName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeInt(this.state);
        dest.writeString(this.fileSavePath);
        dest.writeLong(this.progress);
        dest.writeLong(this.fileLength);
        dest.writeByte(this.autoResume ? (byte) 1 : (byte) 0);
        dest.writeByte(this.autoRename ? (byte) 1 : (byte) 0);
        dest.writeString(this.pid);
        dest.writeString(this.downloadUrl);
        dest.writeString(this.fileName);
        dest.writeString(this.imageSavePath);
        dest.writeString(this.resourceUri);
        dest.writeString(this.resType);
        dest.writeString(this.downloadSpeed);
        dest.writeString(this.downloadImageUrl);
        dest.writeByte(this.isDone ? (byte) 1 : (byte) 0);
        dest.writeString(this.version);
        dest.writeString(this.androidSize);
        dest.writeInt(this.activate);
    }

    public DownloadInfo() {
    }

    protected DownloadInfo(Parcel in) {
        this.id = in.readLong();
        this.state = in.readInt();
        this.fileSavePath = in.readString();
        this.progress = in.readLong();
        this.fileLength = in.readLong();
        this.autoResume = in.readByte() != 0;
        this.autoRename = in.readByte() != 0;
        this.pid = in.readString();
        this.downloadUrl = in.readString();
        this.fileName = in.readString();
        this.imageSavePath = in.readString();
        this.resourceUri = in.readString();
        this.resType = in.readString();
        this.downloadSpeed = in.readString();
        this.downloadImageUrl = in.readString();
        this.isDone = in.readByte() != 0;
        this.version = in.readString();
        this.androidSize = in.readString();
        this.activate = in.readInt();
    }

    public static final Parcelable.Creator<DownloadInfo> CREATOR = new Parcelable.Creator<DownloadInfo>() {
        @Override
        public DownloadInfo createFromParcel(Parcel source) {
            return new DownloadInfo(source);
        }

        @Override
        public DownloadInfo[] newArray(int size) {
            return new DownloadInfo[size];
        }
    };
}
