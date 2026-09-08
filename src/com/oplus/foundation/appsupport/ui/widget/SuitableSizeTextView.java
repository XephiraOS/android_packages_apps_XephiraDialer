package com.oplus.foundation.appsupport.ui.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m7.g;

/* compiled from: SuitableSizeTextView.kt */
/* loaded from: classes3.dex */
public class SuitableSizeTextView extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    public int f28221a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuitableSizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.f(context, "context");
    }

    public final void a() {
        super.setTextSize(0, b(getTextSize()));
    }

    public final float b(float f10) {
        return COUIChangeTextUtil.getSuitableFontSize(f10, getResources().getConfiguration().fontScale, this.f28221a);
    }

    public final int getFontScaleLevel() {
        return this.f28221a;
    }

    public final void setFontScaleLevel(int i10) {
        this.f28221a = i10;
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        a();
    }

    public /* synthetic */ SuitableSizeTextView(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R.attr.textViewStyle : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitableSizeTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f28221a = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f35361f4);
        setFontScaleLevel(obtainStyledAttributes.getInteger(g.f35367g4, 1));
        obtainStyledAttributes.recycle();
    }
}
