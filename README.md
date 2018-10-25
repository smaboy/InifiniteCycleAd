# InifiniteCycleAd
### 无限循环轮播图

使用步骤
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

    这里我们做的事情，主要有三件：

    a. 处理数据，这边我们的数据实体类需要继承我们的BeanInterface接口，实现相关方法
    b. 设置数据，这边我们只需要传递我们的上下文、数据集、InfiniteCycleViewPager的实例三个参数
    c. 最后就是我们的循环滚动，一行代码搞定，可以设置我们滚动的延时时间



