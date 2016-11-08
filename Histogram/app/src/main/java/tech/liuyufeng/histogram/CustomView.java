package tech.liuyufeng.histogram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by CPUdream on 2016/11/8.
 */

public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawLine(10,10, 490, 10, paint);
        canvas.drawLine(10,10, 10, 490, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((MeasureSpec.getMode(widthMeasureSpec)) == MeasureSpec.EXACTLY ?  MeasureSpec.getSize(widthMeasureSpec): getMeasuredWidth(), (MeasureSpec.getMode(heightMeasureSpec)) == MeasureSpec.EXACTLY ? MeasureSpec.getSize(widthMeasureSpec):getMeasuredWidth());
    }
}
