package com.example.doodleapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DoodleView extends View {
    private Paint paint;
    private ArrayList<Line> lines;
    private Line currentLine;

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(0xFF000000);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        lines = new ArrayList<>();
    }

    public void setBrushSize(float size) {
        paint.setStrokeWidth(size);
    }

    public void setBrushColor(int color) {
        paint.setColor(color);
    }

    public void clearCanvas() {
        lines.clear();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (Line line : lines) {
            paint.setColor(line.color);
            paint.setStrokeWidth(line.size);
            canvas.drawPath(line.path, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentLine = new Line(paint.getColor(), paint.getStrokeWidth());
                currentLine.path.moveTo(event.getX(), event.getY());
                lines.add(currentLine);
                return true;

            case MotionEvent.ACTION_MOVE:
                currentLine.path.lineTo(event.getX(), event.getY());
                invalidate();
                return true;

            default:
                return false;
        }
    }
}
