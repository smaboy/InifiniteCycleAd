package com.example.smaboy.app.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smaboy.app.R;
import com.example.smaboy.app.adapter.InfiniteCycleAdapter;
import com.example.smaboy.app.interf.BeanInterface;

import java.util.ArrayList;

/**
 * 类名: AdView
 * 类作用描述: 自定义广告页（展示广告轮播图）
 * 作者: Smaboy
 * 创建时间: 2018/10/25 13:29
 */
public class AdView extends FrameLayout {
    private Context mContext;
    private ArrayList<BeanInterface> mData;//数据集合，你可以自己定义
    private InfiniteCycleViewPager vp;
    private LinearLayout ll_title;//标题容器
    private TextView tv_title;//标题

    public AdView( Context context) {
        this(context,null);
    }

    public AdView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
    }

    /**
     *
     * 向外提供设置数据的方法
     *
     * @param beanInterfaces
     */
    public void setData(ArrayList<BeanInterface> beanInterfaces){
        mData=beanInterfaces;

        //初始化数据
        initView();

    }


    private void initView(){
        View.inflate(mContext, R.layout.ad_view,this);//加入布局

        //初始化视图
        vp = findViewById(R.id.vp);
        ll_title = findViewById(R.id.ll_title);
        tv_title = findViewById(R.id.tv_title);

        //设置recyclerview的布局属性
        ViewGroup.LayoutParams layoutParams = vp.getLayoutParams();
        layoutParams.height=getResources().getDisplayMetrics().heightPixels/2;
        vp.setLayoutParams(layoutParams);

        //开始设置数据
        InfiniteCycleAdapter adapter=new InfiniteCycleAdapter(mContext,mData,vp);
        vp.setAdapter(adapter);
        tv_title.setText(mData.get(vp.getCurrentItem()).getTitle());
        setRedDot(ll_title,vp.getCurrentItem());

        //设置监听，用于设置标题，和指示器




    }

    /**
     * 设置小红点指示器
     *
     * @param ll_dot  容器
     *
     *  @param redPosition  红点位置
     *
     */
    private void setRedDot(LinearLayout ll_dot,int redPosition) {
        ll_dot.removeAllViews();//清空所有子视图
        if(redPosition<0||redPosition>=mData.size()) {
            return;
        }

        for(int i = 0; i < mData.size(); i++) {
            TextView textView = new TextView(mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp2px(10),dp2px(10));
            layoutParams.setMargins(dp2px(10),0,0,0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(Gravity.CENTER);

            //这边我们需要对小红点进行背景颜色的处理


            if(i==redPosition) {
                textView.setBackground(mContext.getResources().getDrawable(R.drawable.red_dot));
            }else {
                textView.setBackground(mContext.getResources().getDrawable(R.drawable.white_dot));
            }

            ll_dot.addView(textView);
        }
    }

    public int dp2px(int dp){
        return (int) (mContext.getResources().getDisplayMetrics().density*dp);

    }

}
