package tech.liuyufeng.histogram;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import java.util.Random;

/**
 * Created by CPUdream on 2016/11/3.
 */

public class rectangle extends View{
    private int mWight;
    private int mHight;
    private int mClor;
    private float yy = 0;
    private float y = 0;
    public rectangle(Context context) {
        super(context);
    }

    public rectangle(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.rectangle);
        mClor = ta.getColor(R.styleable.rectangle_backgroud, Color.RED);

    }

    public rectangle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(mClor);
        LinearGradient gradient = new LinearGradient(10, 10, mWight, mHight,Color.BLACK, Color.WHITE, Shader.TileMode.CLAMP);
        paint.setShader(gradient);
        Random r = new Random();
        int yyyy = r.nextInt(10);
        canvas.drawRect( 10, 10 , mWight,  mHight* yyyy, paint);
        canvas.restore();
        postInvalidateDelayed(300);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getMinWidth(widthMeasureSpec), getMinHeight(heightMeasureSpec));
    }

    private int getMinHeight(int heightMeasureSpec) {
        int result = 50;
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);
        mHight = size;
        if(mode == MeasureSpec.EXACTLY){
            result = Math.max(size, result);
        }else if(mode == MeasureSpec.AT_MOST){

        }
        return result;
    }

    private int getMinWidth(int widthMeasureSpec) {
        int result = 50;
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        mWight = size;
        if(mode == MeasureSpec.EXACTLY){
            result = Math.max(size, result);
        }else if(mode == MeasureSpec.AT_MOST){
        }
        return result;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                Log.i("you", "1111up");
                Toast.makeText(getContext(), "抬起了", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_DOWN:
                Log.i("you", "1111down");
                y = event.getRawY();
                Toast.makeText(getContext(), "按下了", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("you", "1111move");
                yy = event.getRawY();
                float y1 = yy -y;
                if(y1> 0){
                    Toast.makeText(getContext(), "减小" + y1, Toast.LENGTH_SHORT).show();
                    invalidate();
                }else{
                    Toast.makeText(getContext(), "真高" + y1, Toast.LENGTH_SHORT).show();
                    invalidate();
                }
                break;
        }
        return true;
    }
}
