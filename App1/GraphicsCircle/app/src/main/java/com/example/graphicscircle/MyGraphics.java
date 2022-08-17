package com.example.graphicscircle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyGraphics extends View implements View.OnTouchListener
{
    int screenHeight, screenWidth;

    int xPos, yPos;
    int xOld, yOld;
    int radius = 300;
    boolean moving = false;

    public MyGraphics(MainActivity mainActivity)
    {
        super(mainActivity);
        this.setOnTouchListener(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenHeight = h;
        screenWidth = w;

        xPos = w/2;
        yPos = h/2;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(xPos, yPos, radius, paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        if(event.getPointerCount() == 2)
        {
            int x1 = (int)event.getX(0);
            int y1 = (int)event.getY(0);
            int x2 = (int)event.getX(1);
            int y2 = (int)event.getY(1);

            radius = (int)Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2))/2;
            invalidate();
            return true;
        }

        int newX = (int)event.getX();
        int newY = (int)event.getY();

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(Math.sqrt(Math.pow(xPos-newX, 2) + Math.pow(yPos-newY, 2)) < radius)
                {
                    moving = true;
                    xOld = newX;
                    yOld = newY;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(moving)
                {
                    xPos += newX - xOld;
                    yPos += newY - yOld;
                    xOld = newX;
                    yOld = newY;
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                moving = false;
                break;
        }
        return true;
    }
}
