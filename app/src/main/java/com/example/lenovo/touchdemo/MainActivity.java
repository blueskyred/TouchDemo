package com.example.lenovo.touchdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    //定义飞机的移动速度
    private int speed = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题的窗口
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //创建PView的组件
        final PView pView= new PView(this);

        setContentView(pView);
        pView.setBackgroundResource(R.color.colorPrimary);
        //获取窗口管理器
        WindowManager windowManger = getWindowManager();
        Display  display = windowManger.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //获取屏幕宽和高
        display.getMetrics(displayMetrics);
        //设置飞机的初始位置
        pView.currentX = displayMetrics.widthPixels/2;
        pView.currentY = displayMetrics.heightPixels-40;
        //为pView组件的键盘事件绑定监听器
        pView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //获取有那个键触发的事件
                switch (event.getKeyCode()){
                    //控制图片下移
                    case  KeyEvent.KEYCODE_S:
                        pView.currentY +=speed;
                        break;
                    //控制图片上移
                    case KeyEvent.KEYCODE_W:
                        pView.currentY -= speed;
                        break;
                    //控制图片左移
                    case KeyEvent.KEYCODE_A:
                        pView.currentX -= speed;
                        break;
                    //控制图片右移
                    case KeyEvent.KEYCODE_D:
                        pView.currentX += speed;
                        break;

                }
                //通知pView组件重绘
                pView.invalidate();
                return true;
            }
        });

    }
}
