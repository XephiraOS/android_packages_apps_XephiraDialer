package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Result;
import kotlinx.coroutines.InterfaceC1266m;
import v9.InterfaceC1637a;

/* compiled from: WithLifecycleState.kt */
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements InterfaceC0489l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f10344a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lifecycle f10345b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1266m<Object> f10346c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1637a<Object> f10347d;

    @Override // androidx.lifecycle.InterfaceC0489l
    public void onStateChanged(InterfaceC0492o source, Lifecycle.Event event) {
        Object b10;
        kotlin.jvm.internal.i.f(source, "source");
        kotlin.jvm.internal.i.f(event, "event");
        if (event == Lifecycle.Event.Companion.c(this.f10344a)) {
            this.f10345b.d(this);
            InterfaceC1266m<Object> interfaceC1266m = this.f10346c;
            InterfaceC1637a<Object> interfaceC1637a = this.f10347d;
            try {
                Result.a aVar = Result.f34166a;
                b10 = Result.b(interfaceC1637a.invoke());
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            interfaceC1266m.resumeWith(b10);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f10345b.d(this);
            InterfaceC1266m<Object> interfaceC1266m2 = this.f10346c;
            Result.a aVar3 = Result.f34166a;
            interfaceC1266m2.resumeWith(Result.b(kotlin.b.a(new LifecycleDestroyedException())));
        }
    }
}
