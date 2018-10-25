package com.example.smaboy.app.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * 类名: InfiniteCycleViewPager
 * 类作用描述: 自定义viewpager类
 * 作者: Smaboy
 * 创建时间: 2018/10/12 17:14
 */
public class InfiniteCycleViewPager extends ViewPager {

    //处理轮询滚动
    private Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0x001 ://开启滚动
                    //重新设置当前页面
                    setCurrentItem(curPosition+1,true);//滚动到当前位置后面的一个位置

                    //处理完上个消息之后，再发一个延迟消息实现循环
                    startScroll(delayMills);
                    return true;

                default:
                    break;

            }
            return false;
        }
    });

    private int curPosition;//当前位置
    private long delayMills;//当前位置

    public InfiniteCycleViewPager(@NonNull Context context) {
        super(context);
    }

    public InfiniteCycleViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 开始轮播图的循环滚动
     *
     * @param delayMills  滚动延迟时间
     */
    public void startScroll(long delayMills ){
        curPosition=getCurrentItem();//获取当前位置
        this.delayMills=delayMills;//获取延迟时间
        handler.sendEmptyMessageDelayed(0x001,delayMills);

    }
    /**
     * 停止轮播图的循环滚动
     *
     *
     */
    public void stopScroll(){

        boolean b = handler.hasMessages(0x001);
        if(b) {
            handler.removeMessages(0x001);

        }

    }



    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN ://当手指放在轮播图上的时候停止滚动


            case MotionEvent.ACTION_MOVE ://当手指在轮播图上滚动的时候也停止滚动
                stopScroll();
                break;
            case MotionEvent.ACTION_UP :

                startScroll(delayMills);
                break;
        }

        return super.onTouchEvent(ev);
    }


}
