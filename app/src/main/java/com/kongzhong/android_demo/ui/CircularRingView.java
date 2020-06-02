package com.kongzhong.android_demo.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircularRingView extends View {
    public static final int a = Color.parseColor("#EDEDED");
    public static final int b = Color.parseColor("#43E4F9");
    public static final int c = Color.parseColor("#FE9438");
    public static float d;
    public Paint e;
    public Paint f;
    public int g;
    public int h;
    public int i;
    public RectF j;
    public float k;

    public CircularRingView(Context context) {
        super(context);
        init();
    }
    public CircularRingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle((float) (this.g / 2), (float) (this.h / 2), ((float) this.i) - d, this.e);
        if (this.j == null) {
            float f2 = d;
            this.j = new RectF(f2, f2, ((float) this.h) - f2, ((float) this.g) - f2);
        }
        canvas.drawArc(this.j, -90.0f, this.k, false, this.f);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.g = getMeasuredWidth();
        this.h = getMeasuredHeight();
        this.i = this.g / 2;
    }


    public static int u2d(Context context, float dp) {
        return (int) ((dp * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void init() {
        d = (float) this.u2d(getContext(), 4.0f);
        this.e = new Paint();
        this.e.setColor(a);
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeWidth(d);
        this.e.setStrokeCap(Paint.Cap.ROUND);
        this.e.setDither(true);
        this.f = new Paint();
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setStrokeWidth(d);
        this.f.setColor(b);
        this.f.setStrokeCap(Paint.Cap.ROUND);
        this.f.setAntiAlias(true);
        this.f.setDither(true);
    }

}
