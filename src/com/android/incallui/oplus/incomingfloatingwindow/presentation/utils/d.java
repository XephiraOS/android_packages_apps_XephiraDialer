package com.android.incallui.oplus.incomingfloatingwindow.presentation.utils;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.android.incallui.Log;
import kotlin.jvm.internal.i;
import m9.q;
import q2.C1481a;
import v9.l;
import w2.InterfaceGestureDetectorOnGestureListenerC1647b;

/* compiled from: FloatingWindowGestureDetector.kt */
/* loaded from: classes.dex */
public abstract class d implements View.OnTouchListener {

    /* renamed from: g, reason: collision with root package name */
    public static final a f18930g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final View f18931a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f18932b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f18933c;

    /* renamed from: d, reason: collision with root package name */
    public MotionEvent f18934d;

    /* renamed from: e, reason: collision with root package name */
    public final b f18935e;

    /* renamed from: f, reason: collision with root package name */
    public final GestureDetector f18936f;

    /* compiled from: FloatingWindowGestureDetector.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: FloatingWindowGestureDetector.kt */
    /* loaded from: classes.dex */
    public static final class b implements InterfaceGestureDetectorOnGestureListenerC1647b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q2.c f18938b;

        public b(q2.c cVar) {
            this.f18938b = cVar;
        }

        @Override // android.view.GestureDetector.OnContextClickListener
        public boolean onContextClick(MotionEvent motionEvent) {
            return InterfaceGestureDetectorOnGestureListenerC1647b.a.a(this, motionEvent);
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
            if (Log.sDebug) {
                Log.d("FloatingWindowLayoutGestureDetector", "onDown: ");
            }
            d.this.f18934d = MotionEvent.obtain(motionEvent);
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            if (Log.sDebug) {
                Log.d("FloatingWindowLayoutGestureDetector", "onFling: current motion fling at " + f11);
            }
            if (d.this.h(f11)) {
                return d.this.f18931a.post(d.this.f());
            }
            return d.this.f18931a.post(d.this.f18933c);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            InterfaceGestureDetectorOnGestureListenerC1647b.a.f(this, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            q2.c cVar;
            if (motionEvent != null && motionEvent2 != null) {
                float rawY = motionEvent2.getRawY() - motionEvent.getRawY();
                if (Log.sDebug) {
                    Log.d("FloatingWindowLayoutGestureDetector", "onScroll: current motion scroll at " + rawY);
                }
                if (d.this.i(rawY) && (cVar = this.f18938b) != null) {
                    cVar.i(rawY);
                    return true;
                }
                return true;
            }
            return false;
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
            Integer num;
            if (Log.sDebug) {
                Log.d("FloatingWindowLayoutGestureDetector", "onSingleTapUp: ");
            }
            l<Integer, q> g10 = d.this.g();
            if (motionEvent != null) {
                num = Integer.valueOf(motionEvent.getDeviceId());
            } else {
                num = null;
            }
            g10.invoke(num);
            return true;
        }
    }

    public d(View layout, boolean z10, final q2.c cVar) {
        i.f(layout, "layout");
        this.f18931a = layout;
        this.f18932b = z10;
        this.f18933c = new Runnable() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.utils.c
            @Override // java.lang.Runnable
            public final void run() {
                d.e(q2.c.this);
            }
        };
        b bVar = new b(cVar);
        this.f18935e = bVar;
        GestureDetector gestureDetector = new GestureDetector(layout.getContext(), bVar);
        gestureDetector.setIsLongpressEnabled(false);
        this.f18936f = gestureDetector;
    }

    public static final void e(q2.c cVar) {
        if (cVar != null) {
            cVar.f(new C1481a(3));
        }
    }

    public abstract Runnable f();

    public abstract l<Integer, q> g();

    public abstract boolean h(float f10);

    public abstract boolean i(float f10);

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Integer num;
        i.f(view, "view");
        if (this.f18932b) {
            if (motionEvent != null) {
                num = Integer.valueOf(motionEvent.getAction());
            } else {
                num = null;
            }
            if ((num != null && num.intValue() == 0) || (num != null && num.intValue() == 2)) {
                view.setPressed(true);
            } else if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 3)) {
                view.setPressed(false);
            }
        }
        return this.f18936f.onTouchEvent(motionEvent);
    }
}
