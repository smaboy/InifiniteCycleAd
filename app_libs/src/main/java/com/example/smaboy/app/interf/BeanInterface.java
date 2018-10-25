package com.example.smaboy.app.interf;

/**
 * 类名: BeanInterface
 * 类作用描述: 数据类接口，方便统一数据操作
 * 作者: Smaboy
 * 创建时间: 2018/10/25 14:28
 */
public interface BeanInterface {

    //标题数据
    void setTitle(String title);
    String  getTitle();

    //图片地址url
    void setImgUrl(String imgUrl);
    String getImgUrl();

    //图片地址int
    void setImgInt(int imgInt);
    int getImgInt();

}
