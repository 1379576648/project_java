package com.trkj.project_java.utils;

import java.text.DecimalFormat;

public class SerialNumberUtils{

    private final static String FORMAT_CODE = "00000";

    /**
     * 当天第一条流水号
     * @return 202203310001
     */
    public static String getSerialNumber(){
        // 流水号
        int count = 1;
        DecimalFormat dft = new DecimalFormat(FORMAT_CODE);
        // 格式化为四位流水号 code: 00001
        String code = dft.format(count);
        // 调用工具类方法
        String date = DateUtils.getCurrentTimeOne();
        // 格式化日期 date: 20200724
        return date + code;
    }

    /**
     * 根据传来的数据加1
     * @return
     */
    public static String getSerialNumberOne(Integer count){
        DecimalFormat dft = new DecimalFormat(FORMAT_CODE);
        // 格式化为四位流水号 code: 0001
        String code = dft.format(count+1);
        // 调用工具类方法
        String date = DateUtils.getCurrentTimeOne();
        // 格式化日期 date: 20200724
        return date + code;
    }

}
