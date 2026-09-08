package com.android.incallui.oplus.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.incallui.InCallUIAide;
import com.android.incallui.InCallUIFontTypeFace;

/* loaded from: classes.dex */
public class InCallUITextView extends AppCompatTextView implements InCallUIAide.FontChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public InCallUIFontTypeFace f19130a;

    public InCallUITextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19130a = new InCallUIFontTypeFace(this);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InCallUIFontTypeFace inCallUIFontTypeFace = this.f19130a;
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
}
