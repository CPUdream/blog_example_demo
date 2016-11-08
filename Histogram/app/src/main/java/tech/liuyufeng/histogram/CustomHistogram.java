package tech.liuyufeng.histogram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by CPUdream on 2016/11/2.
 */

public class CustomHistogram extends View{

    public CustomHistogram(Context context) {
        super(context);
    }
    public CustomHistogram(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getMiniWidth(widthMeasureSpec), getMiniHeight(heightMeasureSpec));
    }

    private int getMiniWidth(int widthMeasureSpec) {
        int result = 500;
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        if(mode == MeasureSpec.EXACTLY){
            result = size;
        }else if(mode == MeasureSpec.AT_MOST){
            result = Math.max(result, size);
        }
        return result;
    }
    private int getMiniHeight(int widthMeasureSpec) {
        int result = 500;
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        if(mode == MeasureSpec.EXACTLY){
            result = Math.max(result, size);
        }else if(mode == MeasureSpec.AT_MOST){
            result = Math.max(result, size);
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawLine(0,490, 490, 490, paint);
        canvas.drawLine(0,0, 0, 490, paint);
        canvas.drawRect(0, 320, 30, 490, paint);
        canvas.drawRect(32, 160, 62, 490, paint);
        canvas.drawRect(64, 450, 94, 490, paint);
        canvas.drawRect(96,  200, 126, 490, paint);
        canvas.drawRect(128,  12, 158, 490, paint);
        canvas.save();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }


}
