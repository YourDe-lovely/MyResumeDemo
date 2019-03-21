package com.hello.resume.myresumedemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import com.hello.resume.myresumedemo.MainActivity;
import com.hello.resume.myresumedemo.util.ToastUtils;

public class TouchLatourView extends View {

    private int lastX ;
    private int lastY ;

    Scroller mScroller ;

    Context mContext ;

    private void init(Context context){
        mContext = context ;
        mScroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX() , mScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int x , int y){
        int scrollx = getScrollX() ;
        int delta = x - scrollx ;
        mScroller.startScroll(scrollx , 0 , delta ,0,2000);
        invalidate();
    }

    public TouchLatourView(Context context) {
        super(context);
        init(context);
    }

    public TouchLatourView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TouchLatourView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x , y ;

        x = (int) event.getX();
        y = (int) event.getY();

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                ToastUtils.getInstance().showMessage(getContext(),"touchView");
                lastX = x ;
                lastY = y ;
                break;
            case MotionEvent.ACTION_MOVE:

                int offX = x - lastX ;
                int offY = y - lastY ;
                layout(getLeft() + offX , getTop()+offY , getRight()+offX , getBottom()+offY);
                break;
        }
        return true;
    }
}
