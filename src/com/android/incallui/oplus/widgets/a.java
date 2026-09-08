package com.android.incallui.oplus.widgets;

import android.util.Property;
import com.android.incallui.oplus.widgets.LoadingAnimTextView;
import kotlin.jvm.internal.i;

/* compiled from: LoadingAnimTextView.kt */
/* loaded from: classes.dex */
public final class a extends Property<LoadingAnimTextView.AlphaForegroundColorSpan, Float> {
    public a(Class<Float> cls) {
        super(cls, "ALPHA_FOREGROUND_COLOR_SPAN_PROPERTY");
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(LoadingAnimTextView.AlphaForegroundColorSpan span) {
        i.f(span, "span");
        return Float.valueOf(span.d());
    }

    public void b(LoadingAnimTextView.AlphaForegroundColorSpan span, float f10) {
        i.f(span, "span");
        span.f(f10);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(LoadingAnimTextView.AlphaForegroundColorSpan alphaForegroundColorSpan, Float f10) {
        b(alphaForegroundColorSpan, f10.floatValue());
    }
}
