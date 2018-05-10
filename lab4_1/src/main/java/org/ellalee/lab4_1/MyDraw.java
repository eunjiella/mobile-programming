package org.ellalee.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyDraw extends View {
    private Path path = new Path();

    public MyDraw(Context c){
        super(c);
    }
    public MyDraw(Context c, AttributeSet a){
        super(c,a);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint pnt = new Paint();
        pnt.setColor(Color.BLUE);
        pnt.setStyle(Paint.Style.STROKE); // 선이 그려지도록
        pnt.setStrokeWidth(10f);
        canvas.drawPath(path,pnt);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate(); //draw again
        return true;
    }
}
