package com.example.smaboy.app.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smaboy.app.R;
import com.example.smaboy.app.interf.BeanInterface;
import com.example.smaboy.app.view.DotView;

import java.util.ArrayList;


/**
 * 类名: InfiniteCycleAdapter
 * 类作用描述: 无限循环滚动适配器
 * 作者: Smaboy
 * 创建时间: 2018/10/12 17:15
 */
public class InfiniteCycleAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<BeanInterface> mData;
    private ViewPager mViewPager;


    public InfiniteCycleAdapter(Context context, ArrayList<BeanInterface> data, ViewPager viewPager) {
        mContext = context;
        mData = data;
        mViewPager = viewPager;


    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container,  int position) {

        //设置布局，并初始化
        View view = LayoutInflater.from(mContext).inflate(R.layout.infinite_cycle_viewpager_item, null);
        ImageView iv = view.findViewById(R.id.iv);
        TextView tv_title = view.findViewById(R.id.tv_title);
        final LinearLayout ll_dot_title = view.findViewById(R.id.ll_dot_title);
        LinearLayout ll_dot = view.findViewById(R.id.ll_dot);

        //确定位置
        int cur=position%mData.size();

        //设置数据
        iv.setImageResource(mData.get(cur).getImgInt());
        tv_title.setText(mData.get(cur).getTitle());

        //初始化指示器
        setRedDot(ll_dot_title,0);

        //设置页面改变监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int positon) {
                int temp = positon % mData.size();
                setRedDot(ll_dot_title,temp);//重新设置红点指示器的位置
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


        //设置布局的显示
        ll_dot_title.setVisibility(View.VISIBLE);
        ll_dot.setVisibility(View.GONE);

        //将view加入集合
        container.addView(view);

        return view;
    }

    /**
     * 设置小红点指示器
     *
     * @param ll_dot_title  容器
     *
     *  @param redPosition  红点位置
     *
     */
    private void setRedDot(LinearLayout ll_dot_title,int redPosition) {
        ll_dot_title.removeAllViews();//清空所有子视图
        if(redPosition<0||redPosition>=mData.size()) {
            return;
        }

        for(int i = 0; i < mData.size(); i++) {
            DotView dotView =new DotView(mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp2px(8), dp2px(8));
            layoutParams.setMargins(dp2px(8),0,0,0);
            dotView.setLayoutParams(layoutParams);
            //这边我们需要对小红点进行背景颜色的处理
            if(i==redPosition) {
                dotView.setPaintColor(Color.RED);
            }else {
                dotView.setPaintColor(Color.WHITE);
            }

            ll_dot_title.addView(dotView);
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }


    public int dp2px(int dp){
        return (int) (mContext.getResources().getDisplayMetrics().density*dp);

    }






}
