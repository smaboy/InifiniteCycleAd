package com.example.smaboy.app.bean;

import com.example.smaboy.app.interf.BeanInterface;

/**
 * 类名: AdData_1
 * 类作用描述: 数据类，实现数据接口
 * 作者: Smaboy
 * 创建时间: 2018/10/25 14:31
 */
public class AdData_1 implements BeanInterface {
    private String mTitle ;
    private String mImgUrl ;
    private int mImgInt ;

    public AdData_1(String mTitle, String mImgUrl, int mImgInt) {
        this.mTitle = mTitle;
        this.mImgUrl = mImgUrl;
        this.mImgInt = mImgInt;
    }

    @Override
    public void setTitle(String title) {
        mTitle=title;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    @Override
    public void setImgUrl(String imgUrl) {

        mImgUrl=imgUrl;
    }

    @Override
    public String getImgUrl() {
        return mImgUrl;
    }

    @Override
    public void setImgInt(int imgInt) {

        mImgInt=imgInt;
    }

    @Override
    public int getImgInt() {
        return mImgInt;
    }
}
