package com.android.incallui.foldscreen.presentation.utils;

import P1.d;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.coui.appcompat.panel.COUIBottomSheetBehavior;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: InCallBottomSheetBehavior.kt */
/* loaded from: classes.dex */
public final class InCallBottomSheetBehavior<V extends View> extends COUIBottomSheetBehavior<V> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f18449b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Boolean f18450a;

    /* compiled from: InCallBottomSheetBehavior.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InCallBottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        i.f(context, "context");
        i.f(attrs, "attrs");
    }

    public final boolean a(CoordinatorLayout parent, View view, int i10, int i11) {
        i.f(parent, "parent");
        if (view == null) {
            return false;
        }
        return parent.z(view, i10, i11);
    }

    public final boolean b(CoordinatorLayout parent, V child, MotionEvent event) {
        i.f(parent, "parent");
        i.f(child, "child");
        i.f(event, "event");
        return false;
    }

    public final boolean c(CoordinatorLayout parent, V child, MotionEvent event) {
        i.f(parent, "parent");
        i.f(child, "child");
        i.f(event, "event");
        int x10 = (int) event.getX();
        int y10 = (int) event.getY();
        if (!a(parent, parent.findViewById(d.f2844c), x10, y10) && !a(parent, parent.findViewById(d.f2851j), x10, y10)) {
            return false;
        }
        return true;
    }

    @Override // com.coui.appcompat.panel.COUIBottomSheetBehavior, com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        i.f(parent, "parent");
        i.f(child, "child");
        i.f(event, "event");
        Boolean bool = this.f18450a;
        if (c(parent, child, event)) {
            Boolean bool2 = this.f18450a;
            if (bool2 == null) {
                bool2 = Boolean.valueOf(isDraggable());
            }
            this.f18450a = bool2;
            setDraggable(false);
        } else if (b(parent, child, event)) {
            Boolean bool3 = this.f18450a;
            if (bool3 == null) {
                bool3 = Boolean.valueOf(isDraggable());
            }
            this.f18450a = bool3;
            setDraggable(true);
        } else if (bool != null) {
            this.f18450a = null;
            setDraggable(bool.booleanValue());
        }
        return super.onInterceptTouchEvent(parent, child, event);
    }
}
