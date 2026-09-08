package com.android.incallui.oplus.incomingfloatingwindow.presentation.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.incallui.Log;
import com.android.incallui.R;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.FloatingWindowBindingAdapterUtilsKt;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.view.FloatingWindowConstraintLayout;
import java.util.function.Consumer;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import w2.InterfaceGestureDetectorOnGestureListenerC1647b;

/* compiled from: FloatingWindowConstraintLayout.kt */
/* loaded from: classes.dex */
public final class FloatingWindowConstraintLayout extends ConstraintLayout implements InterfaceGestureDetectorOnGestureListenerC1647b {

    /* renamed from: d, reason: collision with root package name */
    public static final a f18942d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final WindowManager f18943a;

    /* renamed from: b, reason: collision with root package name */
    public final Consumer<Boolean> f18944b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18945c;

    /* compiled from: FloatingWindowConstraintLayout.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatingWindowConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        i.f(context, "context");
    }

    public static final void h(boolean z10) {
        if (Log.sDebug) {
            Log.d("FloatingWindowConstraintLayout", "crossWindowBlurEnabledListener: " + z10);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!isHardwareAccelerated()) {
            if (Log.sDebug) {
                Log.d("FloatingWindowConstraintLayout", "draw: viewRootImpl HardwareAccelerate is disabled");
            }
            FloatingWindowBindingAdapterUtilsKt.g(this, this.f18945c);
        } else if (canvas == null || !canvas.isHardwareAccelerated()) {
            if (Log.sDebug) {
                Log.d("FloatingWindowConstraintLayout", "draw: canvas HardwareAccelerate is disabled");
            }
            FloatingWindowBindingAdapterUtilsKt.g(this, this.f18945c);
        }
        super.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f18943a.addCrossWindowBlurEnabledListener(this.f18944b);
    }

    @Override // android.view.GestureDetector.OnContextClickListener
    public boolean onContextClick(MotionEvent motionEvent) {
        return InterfaceGestureDetectorOnGestureListenerC1647b.a.a(this, motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f18943a.removeCrossWindowBlurEnabledListener(this.f18944b);
        FloatingWindowBindingAdapterUtilsKt.d(this);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return InterfaceGestureDetectorOnGestureListenerC1647b.a.b(this, motionEvent);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return InterfaceGestureDetectorOnGestureListenerC1647b.a.c(this, motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return InterfaceGestureDetectorOnGestureListenerC1647b.a.d(this, motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        return InterfaceGestureDetectorOnGestureListenerC1647b.a.e(this, motionEvent, motionEvent2, f10, f11);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        InterfaceGestureDetectorOnGestureListenerC1647b.a.f(this, motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        return InterfaceGestureDetectorOnGestureListenerC1647b.a.g(this, motionEvent, motionEvent2, f10, f11);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        InterfaceGestureDetectorOnGestureListenerC1647b.a.h(this, motionEvent);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return InterfaceGestureDetectorOnGestureListenerC1647b.a.i(this, motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return InterfaceGestureDetectorOnGestureListenerC1647b.a.j(this, motionEvent);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != null) {
            drawable.setFilterBitmap(true);
        }
        super.setBackground(drawable);
    }

    public /* synthetic */ FloatingWindowConstraintLayout(Context context, AttributeSet attributeSet, int i10, int i11, int i12, f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingWindowConstraintLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        i.f(context, "context");
        this.f18943a = (WindowManager) context.getSystemService(WindowManager.class);
        this.f18944b = new Consumer() { // from class: v2.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                FloatingWindowConstraintLayout.h(((Boolean) obj).booleanValue());
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingWindowConstraintLayout, i10, 0);
        this.f18945c = obtainStyledAttributes.getResourceId(R.styleable.FloatingWindowConstraintLayout_defaultBackground, 0);
        obtainStyledAttributes.recycle();
    }
}
