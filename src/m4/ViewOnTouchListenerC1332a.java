package m4;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: InsetDialogOnTouchListener.java */
/* renamed from: m4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class ViewOnTouchListenerC1332a implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final Dialog f35099a;

    /* renamed from: b, reason: collision with root package name */
    public final int f35100b;

    /* renamed from: c, reason: collision with root package name */
    public final int f35101c;

    /* renamed from: d, reason: collision with root package name */
    public final int f35102d;

    public ViewOnTouchListenerC1332a(Dialog dialog, Rect rect) {
        this.f35099a = dialog;
        this.f35100b = rect.left;
        this.f35101c = rect.top;
        this.f35102d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(R.id.content);
        int left = this.f35100b + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        if (new RectF(left, this.f35101c + findViewById.getTop(), width, findViewById.getHeight() + r3).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        view.performClick();
        return this.f35099a.onTouchEvent(obtain);
    }
}
