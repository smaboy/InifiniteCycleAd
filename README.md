# InifiniteCycleAd
### 无限循环轮播图
##### 实现功能：
  1. 无限轮询播放
  2. 触摸停止，放开自动开启
  3. 有标题内容会自动显示，无标题内容只显示指示器，不显示标题栏
  4. 回调接口，可以设置点击事件


##### 使用步骤
  1. 将我们自定viewpager放入布局

         <com.example.smaboy.app.view.InfiniteCycleViewPager
            android:id="@+id/viewpager"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>

  2. 主页的逻辑也非常简洁

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

          //添加轮播图的item点击监听
          viewpager.setItemClickListener(new InfiniteCycleViewPagerItemClickListener() {
              @Override
              public void itemClick(View v, ArrayList<BeanInterface> mData, int position) {
                    //数据处理
                    Toast.makeText(MainActivity.this, mData.get(position).getTitle(), Toast.LENGTH_SHORT).show();
              }
          });

    这里我们做的事情，主要有四件：

    a. 处理数据，这边我们的数据实体类需要继承我们的BeanInterface接口，实现相关方法
    b. 设置数据，这边我们只需要传递我们的上下文、数据集、InfiniteCycleViewPager的实例三个参数
    c. 最后就是我们的循环滚动，一行代码搞定，可以设置我们滚动的延时时间
    d. 设置轮播图的item点击事件监听，我们可以看到点击事件回调函数中，给我们返回了，三个参数，我们可以通过他们
       做许多事情，一般我们可以通过它拿到我们当前页面数据，然后通过url跳转到相应页面





#### 效果图如下所示:

<img src="demo1.gif">
<img src="demo2.gif">



