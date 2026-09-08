package androidx.fragment.app;

import androidx.lifecycle.I;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import androidx.lifecycle.ViewModelLazy;
import v9.InterfaceC1637a;

/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt {
    public static final <VM extends I> m9.d<VM> a(final Fragment fragment, C9.c<VM> viewModelClass, InterfaceC1637a<? extends M> storeProducer, InterfaceC1637a<? extends K.b> interfaceC1637a) {
        kotlin.jvm.internal.i.f(fragment, "<this>");
        kotlin.jvm.internal.i.f(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.i.f(storeProducer, "storeProducer");
        if (interfaceC1637a == null) {
            interfaceC1637a = new InterfaceC1637a<K.b>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // v9.InterfaceC1637a
                public final K.b invoke() {
                    K.b defaultViewModelProviderFactory = Fragment.this.getDefaultViewModelProviderFactory();
                    kotlin.jvm.internal.i.e(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                    return defaultViewModelProviderFactory;
                }
            };
        }
        return new ViewModelLazy(viewModelClass, storeProducer, interfaceC1637a);
    }
}
