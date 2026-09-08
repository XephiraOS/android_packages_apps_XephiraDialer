package androidx.lifecycle;

import V.a;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public final class L {
    public static final V.a a(N owner) {
        kotlin.jvm.internal.i.f(owner, "owner");
        if (owner instanceof InterfaceC0485h) {
            return ((InterfaceC0485h) owner).getDefaultViewModelCreationExtras();
        }
        return a.C0073a.f3957b;
    }
}
