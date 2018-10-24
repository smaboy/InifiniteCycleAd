package com.example.smaboy.app.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smaboy.app.MainActivity;
import com.example.smaboy.app.R;

import java.util.ArrayList;

import static com.example.smaboy.app.R.drawable.red_dot;

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
        mContext = context;
        mData = data;
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
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        ImageView iv = new ImageView(mContext);
//        iv.setImageResource(mData.get(position%mData.size()));
//        iv.setScaleType(ImageView.ScaleType.FIT_XY);

        View view = LayoutInflater.from(mContext).inflate(R.layout.infinite_cycle_viewpager_item, null);
        ImageView iv = view.findViewById(R.id.iv);
        TextView tv_title = view.findViewById(R.id.tv_title);
        LinearLayout ll_dot_title = view.findViewById(R.id.ll_dot_title);
        LinearLayout ll_dot = view.findViewById(R.id.ll_dot);



        //设置数据
        iv.setImageResource(mData.get(position%mData.size()));
        tv_title.setText("标题"+position%mData.size());
        for(int i = 0; i < mData.size(); i++) {
            TextView textView = new TextView(mContext);
//            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
//            layoutParams.height=10;
//            layoutParams.width=10;
            textView.setLayoutParams(new LinearLayout.LayoutParams(dp2px(10),dp2px(10)));
            if(i!=0) {
                textView.setPadding(20,0,0,0);
                textView.setBackground(mContext.getDrawable(R.drawable.white_dot));
            }else {
                textView.setBackground(mContext.getDrawable(R.drawable.red_dot));
            }
            ll_dot_title.addView(textView);
        }
        ll_dot_title.setVisibility(View.VISIBLE);
        ll_dot.setVisibility(View.GONE);

        container.addView(view);
        return view;
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
