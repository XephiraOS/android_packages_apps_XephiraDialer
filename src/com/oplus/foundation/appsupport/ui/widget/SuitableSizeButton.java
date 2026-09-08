package com.oplus.foundation.appsupport.ui.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m7.g;

/* compiled from: SuitableSizeButton.kt */
/* loaded from: classes3.dex */
public class SuitableSizeButton extends AppCompatButton {

    /* renamed from: a, reason: collision with root package name */
    public int f28220a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuitableSizeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.f(context, "context");
    }

    public final void a(int i10) {
        super.setTextSize(0, COUIChangeTextUtil.getSuitableFontSize(getTextSize(), getResources().getConfiguration().fontScale, i10));
    }

    public final int getMFontScaleLevel() {
        return this.f28220a;
    }

    public final void setMFontScaleLevel(int i10) {
        this.f28220a = i10;
        a(i10);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        a(this.f28220a);
    }

    public /* synthetic */ SuitableSizeButton(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R.attr.textViewStyle : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitableSizeButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f28220a = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f35361f4);
        setMFontScaleLevel(obtainStyledAttributes.getInteger(g.f35367g4, 1));
        obtainStyledAttributes.recycle();
    }
}
