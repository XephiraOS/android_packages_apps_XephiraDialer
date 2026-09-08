package androidx.core.app;

import android.content.res.Configuration;

/* compiled from: PictureInPictureModeChangedInfo.kt */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9391a;

    /* renamed from: b, reason: collision with root package name */
    public Configuration f9392b;

    public l(boolean z10) {
        this.f9391a = z10;
    }

    public final boolean a() {
        return this.f9391a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public l(boolean z10, Configuration newConfig) {
        this(z10);
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        this.f9392b = newConfig;
    }
}
