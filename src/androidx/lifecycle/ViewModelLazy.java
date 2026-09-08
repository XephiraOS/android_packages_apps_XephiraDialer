package androidx.lifecycle;

import V.a;
import androidx.lifecycle.I;
import androidx.lifecycle.K;
import u9.C1614a;
import v9.InterfaceC1637a;

/* compiled from: ViewModelLazy.kt */
/* loaded from: classes.dex */
public final class ViewModelLazy<VM extends I> implements m9.d<VM> {

    /* renamed from: a, reason: collision with root package name */
    public final C9.c<VM> f10336a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1637a<M> f10337b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC1637a<K.b> f10338c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1637a<V.a> f10339d;

    /* renamed from: e, reason: collision with root package name */
    public VM f10340e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(C9.c<VM> viewModelClass, InterfaceC1637a<? extends M> storeProducer, InterfaceC1637a<? extends K.b> factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        kotlin.jvm.internal.i.f(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.i.f(storeProducer, "storeProducer");
        kotlin.jvm.internal.i.f(factoryProducer, "factoryProducer");
    }

    @Override // m9.d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public VM getValue() {
        VM vm = this.f10340e;
        if (vm == null) {
            VM vm2 = (VM) new K(this.f10337b.invoke(), this.f10338c.invoke(), this.f10339d.invoke()).a(C1614a.a(this.f10336a));
            this.f10340e = vm2;
            return vm2;
        }
        return vm;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(C9.c<VM> viewModelClass, InterfaceC1637a<? extends M> storeProducer, InterfaceC1637a<? extends K.b> factoryProducer, InterfaceC1637a<? extends V.a> extrasProducer) {
        kotlin.jvm.internal.i.f(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.i.f(storeProducer, "storeProducer");
        kotlin.jvm.internal.i.f(factoryProducer, "factoryProducer");
        kotlin.jvm.internal.i.f(extrasProducer, "extrasProducer");
        this.f10336a = viewModelClass;
        this.f10337b = storeProducer;
        this.f10338c = factoryProducer;
        this.f10339d = extrasProducer;
    }

    public /* synthetic */ ViewModelLazy(C9.c cVar, InterfaceC1637a interfaceC1637a, InterfaceC1637a interfaceC1637a2, InterfaceC1637a interfaceC1637a3, int i10, kotlin.jvm.internal.f fVar) {
        this(cVar, interfaceC1637a, interfaceC1637a2, (i10 & 8) != 0 ? new InterfaceC1637a<a.C0073a>() { // from class: androidx.lifecycle.ViewModelLazy.1
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final a.C0073a invoke() {
                return a.C0073a.f3957b;
            }
        } : interfaceC1637a3);
    }
}
