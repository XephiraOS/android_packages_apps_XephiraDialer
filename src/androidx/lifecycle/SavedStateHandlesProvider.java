package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.a;
import java.util.Map;
import v9.InterfaceC1637a;

/* compiled from: SavedStateHandleSupport.kt */
/* loaded from: classes.dex */
public final class SavedStateHandlesProvider implements a.c {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.savedstate.a f10329a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10330b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f10331c;

    /* renamed from: d, reason: collision with root package name */
    public final m9.d f10332d;

    public SavedStateHandlesProvider(androidx.savedstate.a savedStateRegistry, final N viewModelStoreOwner) {
        m9.d b10;
        kotlin.jvm.internal.i.f(savedStateRegistry, "savedStateRegistry");
        kotlin.jvm.internal.i.f(viewModelStoreOwner, "viewModelStoreOwner");
        this.f10329a = savedStateRegistry;
        b10 = kotlin.a.b(new InterfaceC1637a<SavedStateHandlesVM>() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SavedStateHandlesVM invoke() {
                return SavedStateHandleSupport.e(N.this);
            }
        });
        this.f10332d = b10;
    }

    public final Bundle a(String key) {
        Bundle bundle;
        kotlin.jvm.internal.i.f(key, "key");
        c();
        Bundle bundle2 = this.f10331c;
        if (bundle2 != null) {
            bundle = bundle2.getBundle(key);
        } else {
            bundle = null;
        }
        Bundle bundle3 = this.f10331c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f10331c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f10331c = null;
        }
        return bundle;
    }

    public final SavedStateHandlesVM b() {
        return (SavedStateHandlesVM) this.f10332d.getValue();
    }

    public final void c() {
        if (!this.f10330b) {
            Bundle b10 = this.f10329a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.f10331c;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            if (b10 != null) {
                bundle.putAll(b10);
            }
            this.f10331c = bundle;
            this.f10330b = true;
            b();
        }
    }

    @Override // androidx.savedstate.a.c
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f10331c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, D> entry : b().g().entrySet()) {
            String key = entry.getKey();
            Bundle saveState = entry.getValue().c().saveState();
            if (!kotlin.jvm.internal.i.b(saveState, Bundle.EMPTY)) {
                bundle.putBundle(key, saveState);
            }
        }
        this.f10330b = false;
        return bundle;
    }
}
