package com.coui.appcompat.privacypolicy;

import android.widget.TextView;
import kotlin.jvm.internal.i;

/* compiled from: MultiFunctionSpan.kt */
/* loaded from: classes.dex */
public final class MultiFunctionSpanKt {
    public static final void setMultiFunctionSpan(TextView textView, CharSequence spanText) {
        i.f(textView, "<this>");
        i.f(spanText, "spanText");
        textView.setText(spanText);
        textView.setMovementMethod(new MultiMovementMethod());
        textView.setHighlightColor(0);
    }
}
