package com.android.incallui.widget.multiwaveview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PointCloud {
    private static final int INNER_POINTS = 8;
    private static final float MAX_POINT_SIZE = 4.0f;
    private static final float MIN_POINT_SIZE = 2.0f;
    private static final float PI = 3.1415927f;
    private static final String TAG = "PointCloud";
    private float mCenterX;
    private float mCenterY;
    private Drawable mDrawable;
    private float mOuterRadius;
    private Paint mPaint;
    private ArrayList<Point> mPointCloud = new ArrayList<>();
    private float mScale = 1.0f;
    WaveManager waveManager = new WaveManager();
    GlowManager glowManager = new GlowManager();

    /* loaded from: classes.dex */
    public class GlowManager {

        /* renamed from: x, reason: collision with root package name */
        private float f19178x;

        /* renamed from: y, reason: collision with root package name */
        private float f19179y;
        private float radius = 0.0f;
        private float alpha = 0.0f;

        public GlowManager() {
        }

        public void setRadius(float f10) {
            this.radius = f10;
        }

        public void setX(float f10) {
            this.f19178x = f10;
        }

        public void setY(float f10) {
            this.f19179y = f10;
        }
    }

    /* loaded from: classes.dex */
    public class Point {
        float radius;

        /* renamed from: x, reason: collision with root package name */
        float f19180x;

        /* renamed from: y, reason: collision with root package name */
        float f19181y;

        public Point(float f10, float f11, float f12) {
            this.f19180x = f10;
            this.f19181y = f11;
            this.radius = f12;
        }
    }

    /* loaded from: classes.dex */
    public class WaveManager {
        private float radius = 50.0f;
        private float width = 200.0f;
        private float alpha = 0.0f;

        public WaveManager() {
        }

        public void setAlpha(float f10) {
            this.alpha = f10;
        }

        public void setRadius(float f10) {
            this.radius = f10;
        }
    }

    public PointCloud(Drawable drawable) {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setFilterBitmap(true);
        this.mPaint.setColor(Color.rgb(255, 255, 255));
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    private static float hypot(float f10, float f11) {
        return (float) Math.hypot(f10, f11);
    }

    private float interp(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    private static float max(float f10, float f11) {
        if (f10 <= f11) {
            return f11;
        }
        return f10;
    }

    public void draw(Canvas canvas) {
        ArrayList<Point> arrayList = this.mPointCloud;
        canvas.save();
        float f10 = this.mScale;
        canvas.scale(f10, f10, this.mCenterX, this.mCenterY);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            Point point = arrayList.get(i10);
            float interp = interp(MAX_POINT_SIZE, 2.0f, point.radius / this.mOuterRadius);
            float f11 = point.f19180x + this.mCenterX;
            float f12 = point.f19181y + this.mCenterY;
            int alphaForPoint = getAlphaForPoint(point);
            if (alphaForPoint != 0) {
                if (this.mDrawable != null) {
                    canvas.save();
                    float f13 = interp / MAX_POINT_SIZE;
                    canvas.scale(f13, f13, f11, f12);
                    canvas.translate(f11 - (this.mDrawable.getIntrinsicWidth() * 0.5f), f12 - (this.mDrawable.getIntrinsicHeight() * 0.5f));
                    this.mDrawable.setAlpha(alphaForPoint);
                    this.mDrawable.draw(canvas);
                    canvas.restore();
                } else {
                    this.mPaint.setAlpha(alphaForPoint);
                    canvas.drawCircle(f11, f12, interp, this.mPaint);
                }
            }
        }
        canvas.restore();
    }

    public int getAlphaForPoint(Point point) {
        float f10;
        float hypot = hypot(this.glowManager.f19178x - point.f19180x, this.glowManager.f19179y - point.f19181y);
        float f11 = 0.0f;
        if (hypot < this.glowManager.radius) {
            f10 = this.glowManager.alpha * max(0.0f, (float) Math.pow(Math.cos((hypot * 0.7853981633974483d) / this.glowManager.radius), 10.0d));
        } else {
            f10 = 0.0f;
        }
        float hypot2 = hypot(point.f19180x, point.f19181y) - this.waveManager.radius;
        if (hypot2 < this.waveManager.width * 0.5f && hypot2 < 0.0f) {
            f11 = this.waveManager.alpha * max(0.0f, (float) Math.pow(Math.cos((hypot2 * 0.7853981633974483d) / this.waveManager.width), 20.0d));
        }
        return (int) (max(f10, f11) * 255.0f);
    }

    public void makePointCloud(float f10, float f11) {
        if (f10 == 0.0f) {
            Log.w(TAG, "Must specify an inner radius");
            return;
        }
        this.mOuterRadius = f11;
        this.mPointCloud.clear();
        float f12 = f11 - f10;
        float f13 = (f10 * 6.2831855f) / 8.0f;
        int round = Math.round(f12 / f13);
        float f14 = f12 / round;
        int i10 = 0;
        while (i10 <= round) {
            int i11 = (int) ((f10 * 6.2831855f) / f13);
            float f15 = 6.2831855f / i11;
            float f16 = 1.5707964f;
            for (int i12 = 0; i12 < i11; i12++) {
                double d10 = f16;
                f16 += f15;
                this.mPointCloud.add(new Point(((float) Math.cos(d10)) * f10, ((float) Math.sin(d10)) * f10, f10));
            }
            i10++;
            f10 += f14;
        }
    }

    public void setCenter(float f10, float f11) {
        this.mCenterX = f10;
        this.mCenterY = f11;
    }

    public void setScale(float f10) {
        this.mScale = f10;
    }
}
