package com.showbabyapp.myapplication.bean;

public class RankListInfo extends ArshowBeans<RankListInfo.RankListChildInfo>
{

	public class RankListChildInfo extends DownloadHolderInfo {
		//		public String mid;// 类型ID
		//		public String bid;// 品牌ID
		//		public String mname;// 类型名称
		public String bname;// 品牌名称
		public String context;// 产品描述
		public String clickcount;// 点击次数
		//		public String uptime;// 上传时间
		public String introduce;// 内容介绍
		public int activateCount;// 内容介绍
	}

}