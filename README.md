

# 我的其他progressbar效果

# 添加依赖
```groovy

compile 'cn.qssq666:myprogressbar:v0.1'

```

# xml使用
```xml


    <cn.qssq666.progressbar.HorizontalProgressBar
        android:id="@+id/horizontalprogr"
        android:layout_width="match_parent"
        android:layout_height="1dp"
        android:layout_marginTop="20dp"
        android:background="#ffff00"
        app:maxProgress="100"
        app:progress="20"
        app:progressColor="@android:color/white" />

    <cn.qssq666.progressbar.HorizontalProgressBar
        android:id="@+id/horizontalprogr1"
        android:layout_width="match_parent"
        android:layout_height="1dp"
        android:layout_marginTop="20dp"
        android:background="#ffffff"
        app:maxProgress="100"
        app:progress="0"
        app:progressColor="#ff0000"
        app:progressStyle="splash" />
```
这是一个正方形的半透明进度，可以从任意方向产生进度.无绘制代码，完全是用view的margin实现的。

https://github.com/qssq/Progress-block-Progress-Bar-qq