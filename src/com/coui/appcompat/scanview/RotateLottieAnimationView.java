package com.coui.appcompat.scanview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.oplus.anim.EffectiveAnimationView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: RotateLottieAnimationView.kt */
/* loaded from: classes.dex */
public final class RotateLottieAnimationView extends EffectiveAnimationView {
    private static final int ANIMATION_SPEED = 270;
    public static final Companion Companion = new Companion(null);
    private static final int ONE_SECOND = 1000;
    private static final float SCALE_TWO = 2.0f;
    private static final String TAG = "RotateLottieAnimationView";
    private long animationEndTime;
    private long animationStartTime;
    private boolean clockwise;
    private int currentDegree;
    private int degree;
    private boolean enableAnimation;
    private boolean forceDisable;
    private final m9.d orientationListener$delegate;
    private int startDegree;

    /* compiled from: RotateLottieAnimationView.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotateLottieAnimationView(Context context) {
        super(context);
        m9.d b10;
        i.f(context, "context");
        this.enableAnimation = true;
        b10 = kotlin.a.b(new InterfaceC1637a<WeakReference<CameraOrientationListener>>() { // from class: com.coui.appcompat.scanview.RotateLottieAnimationView$orientationListener$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public final WeakReference<CameraOrientationListener> invoke() {
                return new WeakReference<>(new CameraOrientationListener(RotateLottieAnimationView.this.getContext().getApplicationContext()) { // from class: com.coui.appcompat.scanview.RotateLottieAnimationView$orientationListener$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(applicationContext);
                        i.e(applicationContext, "applicationContext");
                    }

                    @Override // com.coui.appcompat.scanview.CameraOrientationListener
                    public void onDirectionChanged(int i10) {
                        RotateLottieAnimationView.this.setOrientation(i10);
                    }
                });
            }
        });
        this.orientationListener$delegate = b10;
    }

    private final WeakReference<CameraOrientationListener> getOrientationListener() {
        return (WeakReference) this.orientationListener$delegate.getValue();
    }

    public final void disableOrientationListener() {
        this.forceDisable = true;
        CameraOrientationListener cameraOrientationListener = getOrientationListener().get();
        if (cameraOrientationListener != null) {
            cameraOrientationListener.disable();
        }
    }

    public final void enableOrientationListener() {
        this.forceDisable = false;
        CameraOrientationListener cameraOrientationListener = getOrientationListener().get();
        if (cameraOrientationListener != null) {
            cameraOrientationListener.enable();
        }
    }

    @Override // com.oplus.anim.EffectiveAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        CameraOrientationListener cameraOrientationListener;
        super.onAttachedToWindow();
        if (!this.forceDisable && (cameraOrientationListener = getOrientationListener().get()) != null) {
            cameraOrientationListener.enable();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        CameraOrientationListener cameraOrientationListener;
        super.onDetachedFromWindow();
        if (!this.forceDisable && (cameraOrientationListener = getOrientationListener().get()) != null) {
            cameraOrientationListener.disable();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float d10;
        int i10;
        i.f(canvas, "canvas");
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        int i11 = bounds.right - bounds.left;
        int i12 = bounds.bottom - bounds.top;
        if (i11 != 0 && i12 != 0) {
            if (this.currentDegree != this.degree) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                if (currentAnimationTimeMillis < this.animationEndTime) {
                    int i13 = (int) (currentAnimationTimeMillis - this.animationStartTime);
                    int i14 = this.startDegree;
                    if (!this.clockwise) {
                        i13 = -i13;
                    }
                    int i15 = i14 + ((i13 * 270) / 1000);
                    if (i15 >= 0) {
                        i10 = i15 % 360;
                    } else {
                        i10 = (i15 % 360) + 360;
                    }
                    this.currentDegree = i10;
                    invalidate();
                } else {
                    this.currentDegree = this.degree;
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            int saveCount = canvas.getSaveCount();
            if (getScaleType() == ImageView.ScaleType.FIT_CENTER && (width < i11 || height < i12)) {
                float f10 = width;
                float f11 = height;
                d10 = B9.i.d(f10 / i11, f11 / i12);
                canvas.scale(d10, d10, f10 / 2.0f, f11 / 2.0f);
            }
            canvas.translate(paddingLeft + (width / 2.0f), paddingTop + (height / 2.0f));
            canvas.rotate(-this.currentDegree);
            canvas.translate((-i11) / 2.0f, (-i12) / 2.0f);
            drawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent event) {
        i.f(event, "event");
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent event) {
        i.f(event, "event");
        return false;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (this.forceDisable) {
            return;
        }
        if (i10 == 0) {
            CameraOrientationListener cameraOrientationListener = getOrientationListener().get();
            if (cameraOrientationListener != null) {
                cameraOrientationListener.enable();
                return;
            }
            return;
        }
        CameraOrientationListener cameraOrientationListener2 = getOrientationListener().get();
        if (cameraOrientationListener2 != null) {
            cameraOrientationListener2.disable();
        }
    }

    public final void resetOrientation() {
        setOrientation(0);
    }

    public final void setOrientation(int i10) {
        boolean z10;
        int i11;
        boolean z11 = false;
        if (getVisibility() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.enableAnimation = z10;
        if (i10 >= 0) {
            i11 = i10 % 360;
        } else {
            i11 = (i10 % 360) + 360;
        }
        if (i11 == this.degree) {
            return;
        }
        this.degree = i11;
        if (z10) {
            this.startDegree = this.currentDegree;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.animationStartTime = currentAnimationTimeMillis;
            int i12 = this.degree - this.currentDegree;
            if (i12 < 0) {
                i12 += 360;
            }
            if (i12 > 180) {
                i12 -= 360;
            }
            if (i12 >= 0) {
                z11 = true;
            }
            this.clockwise = z11;
            this.animationEndTime = currentAnimationTimeMillis + ((Math.abs(i12) * 1000) / 270);
        } else {
            this.currentDegree = i11;
        }
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotateLottieAnimationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m9.d b10;
        i.f(context, "context");
        i.f(attrs, "attrs");
        this.enableAnimation = true;
        b10 = kotlin.a.b(new InterfaceC1637a<WeakReference<CameraOrientationListener>>() { // from class: com.coui.appcompat.scanview.RotateLottieAnimationView$orientationListener$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public final WeakReference<CameraOrientationListener> invoke() {
                return new WeakReference<>(new CameraOrientationListener(RotateLottieAnimationView.this.getContext().getApplicationContext()) { // from class: com.coui.appcompat.scanview.RotateLottieAnimationView$orientationListener$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(applicationContext);
                        i.e(applicationContext, "applicationContext");
                    }

                    @Override // com.coui.appcompat.scanview.CameraOrientationListener
                    public void onDirectionChanged(int i10) {
                        RotateLottieAnimationView.this.setOrientation(i10);
                    }
                });
            }
        });
        this.orientationListener$delegate = b10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotateLottieAnimationView(Context context, AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        m9.d b10;
        i.f(context, "context");
        i.f(attrs, "attrs");
        this.enableAnimation = true;
        b10 = kotlin.a.b(new InterfaceC1637a<WeakReference<CameraOrientationListener>>() { // from class: com.coui.appcompat.scanview.RotateLottieAnimationView$orientationListener$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public final WeakReference<CameraOrientationListener> invoke() {
                return new WeakReference<>(new CameraOrientationListener(RotateLottieAnimationView.this.getContext().getApplicationContext()) { // from class: com.coui.appcompat.scanview.RotateLottieAnimationView$orientationListener$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(applicationContext);
                        i.e(applicationContext, "applicationContext");
                    }

                    @Override // com.coui.appcompat.scanview.CameraOrientationListener
                    public void onDirectionChanged(int i102) {
                        RotateLottieAnimationView.this.setOrientation(i102);
                    }
                });
            }
        });
        this.orientationListener$delegate = b10;
    }
}
