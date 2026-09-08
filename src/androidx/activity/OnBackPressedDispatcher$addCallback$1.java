package androidx.activity;

import kotlin.jvm.internal.FunctionReferenceImpl;
import v9.InterfaceC1637a;

/* compiled from: OnBackPressedDispatcher.kt */
/* loaded from: classes.dex */
public /* synthetic */ class OnBackPressedDispatcher$addCallback$1 extends FunctionReferenceImpl implements InterfaceC1637a<m9.q> {
    public OnBackPressedDispatcher$addCallback$1(Object obj) {
        super(0, obj, OnBackPressedDispatcher.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
    }

    public final void f() {
        ((OnBackPressedDispatcher) this.receiver).q();
    }

    @Override // v9.InterfaceC1637a
    public /* bridge */ /* synthetic */ m9.q invoke() {
        f();
        return m9.q.f35511a;
    }
}
