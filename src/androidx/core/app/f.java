package androidx.core.app;

import android.content.res.Configuration;

/* compiled from: MultiWindowModeChangedInfo.kt */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9366a;

    /* renamed from: b, reason: collision with root package name */
    public Configuration f9367b;

    public f(boolean z10) {
        this.f9366a = z10;
    }

    public final boolean a() {
        return this.f9366a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(boolean z10, Configuration newConfig) {
        this(z10);
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        this.f9367b = newConfig;
    }
}
