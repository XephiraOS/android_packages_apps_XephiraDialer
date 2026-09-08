package com.coui.appcompat.privacypolicy;

import android.widget.TextView;
import kotlin.jvm.internal.i;

/* compiled from: PrivacyPolicySpanBuilder.kt */
/* loaded from: classes.dex */
public final class PrivacyPolicySpanBuilderKt {
    private static final String TAG = "PrivacyPolicySpanBuilder";

    public static final PrivacyPolicySpanBuilder spanBuilder(String str, TextView textView) {
        i.f(str, "<this>");
        i.f(textView, "textView");
        return new PrivacyPolicySpanBuilder(textView, str);
    }
}
