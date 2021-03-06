package com.example.smaboy.app;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.example.smaboy.app.adapter.InfiniteCycleAdapter;
import com.example.smaboy.app.bean.AdData_1;
import com.example.smaboy.app.interf.BeanInterface;
import com.example.smaboy.app.view.InfiniteCycleViewPager;

import java.util.ArrayList;

@Deprecated
public class MainActivity extends AppCompatActivity {

    private InfiniteCycleViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //隐藏标题栏
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_main);


        //初始化
        init();
        initData();


    }

    private void initData() {
        //模拟数据
        ArrayList<BeanInterface> data=new ArrayList<>();
        data.add(new AdData_1("标题1","",R.drawable.t01));
        data.add(new AdData_1("标题2","",R.drawable.t02));
        data.add(new AdData_1("标题3","",R.drawable.t03));
        data.add(new AdData_1("标题4","",R.drawable.t04));
        data.add(new AdData_1("标题5","",R.drawable.t05));

        //设置数据
        viewpager.setAdapter(new InfiniteCycleAdapter(this,data,viewpager));

        //设置viewpager滚动循环
        viewpager.startScroll(3000);
    }

    private void init() {
        //初始化视图
        viewpager=findViewById(R.id.viewpager);

        //设置recyclerview的布局属性
        ViewGroup.LayoutParams layoutParams = viewpager.getLayoutParams();
        layoutParams.height=getResources().getDisplayMetrics().heightPixels/2;
        viewpager.setLayoutParams(layoutParams);
    }

}
