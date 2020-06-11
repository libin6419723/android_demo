package com.kongzhong.android_demo.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
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
    public Paint mPaint1;
    public Paint mPaint2;
    public int g;
    public int h;
    public int i;
    public RectF j;
    public float k;
    public Bitmap mIcon = null;

    public CircularRingView(Context context) {
        super(context);
        init();
    }

    public CircularRingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setIcon(Bitmap icon) {
            this.mIcon = icon;
    }

    public void animator(float f2, boolean z) {
        if (z) {
            this.mPaint2.setColor(b);
        } else {
            this.mPaint2.setColor(c);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, (f2 / 100.0f) * 360.0f});
        ofFloat.setDuration(2000);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = CircularRingView.this.k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularRingView.this.invalidate();
            }
        });
        ofFloat.start();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle((float) (this.g / 2), (float) (this.h / 2), ((float) this.i) - d, this.mPaint1);
        if (this.j == null) {
            float f2 = d;
            this.j = new RectF(f2, f2, ((float) this.h) - f2, ((float) this.g) - f2);
        }
        canvas.drawArc(this.j, -90.0f, this.k, false, this.mPaint2);
        if (this.mIcon != null)
            canvas.drawBitmap(this.mIcon, 0.0f, 0.0f, this.mPaint1);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.g = getMeasuredWidth();
        this.h = getMeasuredHeight();
        this.i = this.g / 2;
    }


    public static int dp2pixels(Context context, float dp) {
        return (int) ((dp * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void init() {
        d = (float) this.dp2pixels(getContext(), 4.0f);
        this.mPaint1 = new Paint();
        this.mPaint1.setColor(a);
        this.mPaint1.setAntiAlias(true);
        this.mPaint1.setStyle(Paint.Style.STROKE);
        this.mPaint1.setStrokeWidth(d);
        this.mPaint1.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint1.setDither(true);
        this.mPaint2 = new Paint();
        this.mPaint2.setStyle(Paint.Style.STROKE);
        this.mPaint2.setStrokeWidth(d);
        this.mPaint2.setColor(b);
        this.mPaint2.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint2.setAntiAlias(true);
        this.mPaint2.setDither(true);
    }

}
