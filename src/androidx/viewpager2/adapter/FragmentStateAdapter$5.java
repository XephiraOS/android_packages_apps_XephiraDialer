package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.InterfaceC0489l;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class FragmentStateAdapter$5 implements InterfaceC0489l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f11815a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f11816b;

    @Override // androidx.lifecycle.InterfaceC0489l
    public void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f11815a.removeCallbacks(this.f11816b);
            interfaceC0492o.getLifecycle().d(this);
        }
    }
}
