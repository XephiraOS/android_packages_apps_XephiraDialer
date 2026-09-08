package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

/* compiled from: GestureDetectorCompat.java */
@Deprecated
/* renamed from: androidx.core.view.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0454i {

    /* renamed from: a, reason: collision with root package name */
    public final GestureDetector f9507a;

    public C0454i(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f9507a.onTouchEvent(motionEvent);
    }

    public C0454i(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f9507a = new GestureDetector(context, onGestureListener, handler);
    }
}
