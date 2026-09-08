package com.android.incallui.oplus.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.incallui.Log;
import com.android.incallui.oplus.widgets.b;

/* loaded from: classes.dex */
public class OplusIncallUIImageView extends AppCompatImageView implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public final E2.b f19153a;

    public OplusIncallUIImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19153a = new b(this);
    }

    @Override // com.android.incallui.oplus.widgets.b.a
    public void c() {
        if (Log.sDebug) {
            Log.i("OplusIncallUIImageView", "cancelPressState");
        }
        setFocusable(false);
        setPressed(false);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Log.i("OplusIncallUIImageView", "onTouchEvent...");
        this.f19153a.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public OplusIncallUIImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19153a = new b(this);
    }
}
