package com.android.incallui.oplus.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatButton;
import com.android.incallui.InCallUIAide;
import com.android.incallui.InCallUIFontTypeFace;
import com.android.incallui.Log;
import com.android.incallui.oplus.widgets.b;

/* loaded from: classes.dex */
public class OplusIncallUIButton extends AppCompatButton implements b.a, InCallUIAide.FontChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public E2.b f19151a;

    /* renamed from: b, reason: collision with root package name */
    public InCallUIFontTypeFace f19152b;

    public OplusIncallUIButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19152b = new InCallUIFontTypeFace(this);
        this.f19151a = new b(this);
    }

    @Override // com.android.incallui.oplus.widgets.b.a
    public void c() {
        if (Log.sDebug) {
            Log.d("OplusIncallUIButton", "cancelPressState");
        }
        setFocusable(false);
        setPressed(false);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("OplusIncallUIButton", "onDetachedFromWindow");
        InCallUIFontTypeFace inCallUIFontTypeFace = this.f19152b;
        if (inCallUIFontTypeFace != null) {
            inCallUIFontTypeFace.setListenTypeface(0);
        }
    }

    @Override // com.android.incallui.InCallUIAide.FontChangeListener
    public void onFontChanged(Typeface typeface) {
        if (typeface != null) {
            setTypeface(typeface);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f19151a.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }
}
