package com.example.smaboy.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.smaboy.app.adapter.InfiniteCycleAdapter;
import com.example.smaboy.app.view.InfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.Arrays;

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




        viewpager=findViewById(R.id.viewpager);


        //模拟数据
        ArrayList<Integer> data=new ArrayList<>();
        data.add(R.drawable.t01);
        data.add(R.drawable.t02);
        data.add(R.drawable.t03);
        data.add(R.drawable.t04);
        data.add(R.drawable.t05);

        //设置数据
        viewpager.setAdapter(new InfiniteCycleAdapter(this,data));
    }
}
