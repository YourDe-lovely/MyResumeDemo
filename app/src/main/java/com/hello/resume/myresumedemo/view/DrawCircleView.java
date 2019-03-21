package com.hello.resume.myresumedemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class DrawCircleView extends LinearLayout {

    //触摸生成一个跟随手指的小球  圆球
    public DrawCircleView(Context context) {
        super(context);
        initView(context);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private Context mContext ;
    private Paint mPaint ;
    private float mCurrentX = 10;
    private float mCurrentY = 10 ;
    public void initView(Context context){
        setOrientation(LinearLayout.VERTICAL);
        //不设置该方法  linearlayout不会调用ondraw方法
        setDividerDrawable(getResources().getDrawable(android.R.drawable.divider_horizontal_bright));
        mContext = context;
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        System.out.println("onDraw");
        mPaint.setColor(Color.RED);
        canvas.drawCircle(mCurrentX,mCurrentY,30,mPaint);
        super.onDraw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("onTouchEvent");
        mCurrentX = event.getX();
        mCurrentY = event.getY();
        invalidate();
        return true;
    }
}
