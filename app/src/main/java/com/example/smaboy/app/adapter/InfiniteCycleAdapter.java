package com.example.smaboy.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smaboy.app.MainActivity;

import java.util.ArrayList;

/**
 * 类名: InfiniteCycleAdapter
 * 类作用描述: 无限循环滚动适配器
 * 作者: Smaboy
 * 创建时间: 2018/10/12 17:15
 */
public class InfiniteCycleAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<Integer> mData;

    public InfiniteCycleAdapter(Context context, ArrayList<Integer> data) {
        mContext=context;
        mData=data;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        TextView iv = new TextView(mContext);
//        iv.setText(position%mData.size()+"哈哈");
//        container.addView(iv);
        ImageView iv = new ImageView(mContext);
        iv.setImageResource(mData.get(position%mData.size()));
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }


}
