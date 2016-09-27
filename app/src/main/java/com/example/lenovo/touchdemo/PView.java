package com.example.lenovo.touchdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Lenovo on 2016/9/27.
 */

public class PView extends View {
    public float currentX;
    public float currentY;
    Bitmap icon;
    public PView(Context context) {
        super(context);
        //定义图片
        icon = BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建画笔
        Paint p = new Paint();

        //绘制图片
        canvas.drawBitmap(icon,currentX,currentY,p);
    }
}
