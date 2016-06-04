package com.showbabyapp.myapplication.constant;

public final class ServerParameterConstant
{
    /**
     * 短信验证类型：
     * 0:找回密码 1:注册 2:换绑手机 3:其他
     */
    public static final int SMS_CODE_FIND = 0;
    public static final int SMS_CODE_REGIST = 1;
    public static final int SMS_CODE_BIND = 2;
    public static final int SMS_CODE_OTHER = 3;

    /**
     * 规则协议类型：
     * 0:用户协议 1:积分规则 2:投稿协议 3:帮助文档 4：退款说明 5：关于F码 6:活动规则
     */
    public static final int INSTRUCTION_PROTOCOL = 0;
    public static final int INSTRUCTION_RULE = 1;
    public static final int INSTRUCTION_SUBMIT = 2;
    public static final int INSTRUCTION_HELP = 3;
    public static final int INSTRUCTION_REFUND = 4;
    public static final int INSTRUCTION_FRIEND_CODE = 5;
    public static final int SATURDAY_ACTIVE = 6;
    public static final int INSTRUCTION_PROMPT = 7;

    /**
     * 服务端请求的key
     */
    public static final String PDATA = "pdata";
    public static final String APPKEY = "appkey";
    public static final String TIMESTAMP = "timestamp";
    public static final String SIGNATURE = "signature";
    public static final String MODEL = "model";
    public static final String APKVERSION = "apkVersion";
    public static final String STS = "sts";
    public static final String RMK = "rmk";
    public static final String REGISTERID = "registerID";
    public static final String BIZ = "biz";
}
