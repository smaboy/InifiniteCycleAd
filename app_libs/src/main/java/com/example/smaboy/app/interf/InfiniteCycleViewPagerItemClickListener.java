package com.example.smaboy.app.interf;

import android.view.View;

import java.util.ArrayList;

/**
 * 类名: InfiniteCycleViewPagerItemClickListener
 * 类作用描述: java类作用描述
 * 作者: Smaboy
 * 创建时间: 2018/10/25 18:31
 */
public interface InfiniteCycleViewPagerItemClickListener {
    void itemClick(View v,ArrayList<BeanInterface> mData,int position);
}
