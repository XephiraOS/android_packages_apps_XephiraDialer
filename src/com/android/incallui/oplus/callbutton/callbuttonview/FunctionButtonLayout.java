package com.android.incallui.oplus.callbutton.callbuttonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.incallui.Log;
import com.android.incallui.oplus.widgets.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: FunctionButtonLayout.kt */
/* loaded from: classes.dex */
public final class FunctionButtonLayout extends FrameLayout implements b.a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f18882f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public ImageView f18883a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f18884b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f18885c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f18886d;

    /* renamed from: e, reason: collision with root package name */
    public E2.b f18887e;

    /* compiled from: FunctionButtonLayout.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        this.f18886d = true;
        this.f18887e = new b(this);
    }

    public final void a(ImageView imageView, ImageView imageView2, ImageView imageView3) {
        Log.d("FunctionButtonLayout", "initView circle, image, selectedImage");
        this.f18883a = imageView;
        this.f18884b = imageView2;
        this.f18885c = imageView3;
    }

    @Override // com.android.incallui.oplus.widgets.b.a
    public void c() {
        Log.d("FunctionButtonLayout", "cancelPressState");
        setFocusable(false);
        setPressed(false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Log.d("FunctionButtonLayout", "onTouchEvent...");
        this.f18887e.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public final void setCanPressed(boolean z10) {
        this.f18886d = z10;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        boolean z11;
        if (z10 != isPressed()) {
            z11 = true;
        } else {
            z11 = false;
        }
        Log.d("FunctionButtonLayout", " setPressed pressed = " + z10 + " changed = " + z11);
        if (!z11) {
            Log.d("FunctionButtonLayout", "setPressed not changed");
        } else {
            super.setPressed(z10);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z10) {
        Log.d("FunctionButtonLayout", "setSelected isSelected = " + isSelected() + "  selected = " + z10 + "  isPressed = " + isPressed());
        if (isSelected() != z10) {
            super.setSelected(z10);
        } else {
            Log.d("FunctionButtonLayout", "setSelected not change");
        }
    }
}
