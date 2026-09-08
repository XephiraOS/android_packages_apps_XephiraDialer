package com.android.incallui.oplus.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: AdaptiveTextSizeTextView.kt */
/* loaded from: classes.dex */
public final class AdaptiveTextSizeTextView extends AppCompatTextView {

    /* renamed from: c, reason: collision with root package name */
    public static final a f19127c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public int f19128a;

    /* renamed from: b, reason: collision with root package name */
    public E2.a f19129b;

    /* compiled from: AdaptiveTextSizeTextView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdaptiveTextSizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        this.f19128a = -1;
        this.f19129b = new E2.a(this, attributeSet);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f19128a != getMeasuredWidth()) {
            this.f19128a = getMeasuredWidth();
            E2.a aVar = this.f19129b;
            if (aVar != null) {
                aVar.a(getText());
            }
            super.onMeasure(i10, i11);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        E2.a aVar = this.f19129b;
        if (aVar != null) {
            aVar.a(charSequence);
        }
    }

    public final void setMaxTextSize(float f10) {
        E2.a aVar = this.f19129b;
        if (aVar != null) {
            aVar.c(f10);
        }
    }

    public final void setMinTextSize(float f10) {
        E2.a aVar = this.f19129b;
        if (aVar != null) {
            aVar.d(f10);
        }
    }
}
