package com.oplus.omoji.ui;

import androidx.lifecycle.w;

/* compiled from: OmojiPanelFragment.kt */
/* loaded from: classes3.dex */
public final class OmojiPanelFragment$sam$androidx_lifecycle_Observer$0 implements w, kotlin.jvm.internal.g {
    private final /* synthetic */ v9.l function;

    public OmojiPanelFragment$sam$androidx_lifecycle_Observer$0(v9.l function) {
        kotlin.jvm.internal.i.f(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof w) || !(obj instanceof kotlin.jvm.internal.g)) {
            return false;
        }
        return kotlin.jvm.internal.i.b(getFunctionDelegate(), ((kotlin.jvm.internal.g) obj).getFunctionDelegate());
    }

    @Override // kotlin.jvm.internal.g
    public final m9.c<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.w
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
