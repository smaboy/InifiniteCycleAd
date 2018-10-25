package com.example.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.smaboy.app.adapter.InfiniteCycleAdapter;
import com.example.smaboy.app.bean.AdData_1;
import com.example.smaboy.app.interf.BeanInterface;
import com.example.smaboy.app.interf.InfiniteCycleViewPagerItemClickListener;
import com.example.smaboy.app.view.InfiniteCycleViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private InfiniteCycleViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //隐藏标题栏
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        setContentView(com.example.smaboy.app.R.layout.activity_main);


        //初始化
        init();
        initData();


    }

    private void initData() {
        //模拟数据
        ArrayList<BeanInterface> data=new ArrayList<>();
        data.add(new AdData_1("标题1","", com.example.smaboy.app.R.drawable.t01));
        data.add(new AdData_1("标题2","", com.example.smaboy.app.R.drawable.t02));
        data.add(new AdData_1("标题3","", com.example.smaboy.app.R.drawable.t03));
        data.add(new AdData_1("标题4","", com.example.smaboy.app.R.drawable.t04));
        data.add(new AdData_1("标题5","", com.example.smaboy.app.R.drawable.t05));

        //设置数据
        viewpager.setAdapter(new InfiniteCycleAdapter(this,data,viewpager));

        //设置viewpager滚动循环
        viewpager.startScroll(3000);

        viewpager.setItemClickListener(new InfiniteCycleViewPagerItemClickListener() {
            @Override
            public void itemClick(View v, ArrayList<BeanInterface> mData, int position) {
                //数据处理
                Toast.makeText(MainActivity.this, "哈哈"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        //初始化视图
        viewpager=findViewById(com.example.smaboy.app.R.id.viewpager);

        //设置recyclerview的布局属性
        ViewGroup.LayoutParams layoutParams = viewpager.getLayoutParams();
        layoutParams.height=getResources().getDisplayMetrics().heightPixels/2;
        viewpager.setLayoutParams(layoutParams);
    }
}
