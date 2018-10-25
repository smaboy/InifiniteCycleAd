package com.example.smaboy.app.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 类名: DotView
 * 类作用描述: 红点view
 * <p>
 * 作者: Smaboy
 * 创建时间: 2018/10/25 15:19
 */
public class DotView extends View {

    private int temp;
    private Paint paint;

    public DotView(Context context) {
        this(context,null);

    }

    public DotView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        temp = Math.min(w, h);
        widthMeasureSpec=MeasureSpec.makeMeasureSpec(temp,MeasureSpec.getMode(widthMeasureSpec));
        heightMeasureSpec=MeasureSpec.makeMeasureSpec(temp,MeasureSpec.getMode(heightMeasureSpec));

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }

    /**
     * 设置画笔颜色
     *
     * @param color
     */
    public void setPaintColor(int color) {
        paint.setColor(color);
        invalidate();

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawCircle(temp/2,temp/2,temp/2,paint);

    }

    private void initPaint() {

        paint=new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

    }

}
