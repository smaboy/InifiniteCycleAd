package com.example.smaboy.app.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smaboy.app.R;
import com.example.smaboy.app.adapter.InfiniteCycleAdapter;

import java.util.ArrayList;

/**
 * 类名: AdView
 * 类作用描述: 自定义广告页（展示广告轮播图）
 * 作者: Smaboy
 * 创建时间: 2018/10/25 13:29
 */
public class AdView extends FrameLayout {
    private Context mContext;
    private ArrayList<Integer> mData;//数据集合，你可以自己定义
    private InfiniteCycleViewPager vp;
    private LinearLayout ll_title;//标题容器
    private TextView tv_title;//标题

    public AdView(Context context) {
        this(context,null);

    }

    public AdView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化操作
        mContext=context;


        initView();
    }





    private void initView(){
        View.inflate(mContext, R.layout.ad_view,this);//加入布局

        //初始化视图
        vp = findViewById(R.id.vp);
        ll_title = findViewById(R.id.ll_title);
        tv_title = findViewById(R.id.tv_title);

        //开始设置数据
//        //模拟数据
//        ArrayList<Integer> data=new ArrayList<>();
//        data.add(R.drawable.t01);
//        data.add(R.drawable.t02);
//        data.add(R.drawable.t03);
//        data.add(R.drawable.t04);
//        data.add(R.drawable.t05);
//
//        vp.setAdapter(new InfiniteCycleAdapter(mContext,data,vp));

    }


}
