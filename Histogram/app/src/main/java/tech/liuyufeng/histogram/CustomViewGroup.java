package tech.liuyufeng.histogram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by CPUdream on 2016/11/3.
 */

public class CustomViewGroup extends ViewGroup{
    private int hh;
    private int hhh = 0;
    private int www = 0;
    private int ww;
    private int xx;
    private MarginLayoutParams cpar;
    public CustomViewGroup(Context context) {
        super(context);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for(int i = 0; i < count; i++){
            View child = getChildAt(i);
            int width = child.getMeasuredWidth();
            int height = child.getMeasuredHeight();
            if(i == 0 || i == 1){
                child.layout(0, 0, xx + width, height);
            }else{
                xx += width;
                child.layout(xx, 0, xx +width, height);
            }


        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int fuWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int fuHeightMode = MeasureSpec.getMode(heightMeasureSpec);
        int fuSize = MeasureSpec.getSize(widthMeasureSpec);
        int fuSizeHight = MeasureSpec.getSize(heightMeasureSpec);

        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for(int i = 0; i < childCount; i++){
            View view =  getChildAt(i);
            hh = view.getMeasuredHeight();
            ww = view.getMeasuredWidth();
            cpar = (MarginLayoutParams) getLayoutParams();
            hhh = Math.max(hh, hhh);
            www = Math.max(ww, www);
        }
        setMeasuredDimension(fuWidthMode == MeasureSpec.EXACTLY ? fuSize : hhh , fuHeightMode == MeasureSpec.EXACTLY ? fuSizeHight : www);
    }


    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
