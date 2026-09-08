package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.a;
import java.util.Iterator;

/* compiled from: LegacySavedStateHandleController.kt */
/* loaded from: classes.dex */
public final class LegacySavedStateHandleController {

    /* renamed from: a, reason: collision with root package name */
    public static final LegacySavedStateHandleController f10277a = new LegacySavedStateHandleController();

    /* compiled from: LegacySavedStateHandleController.kt */
    /* loaded from: classes.dex */
    public static final class a implements a.InterfaceC0139a {
        @Override // androidx.savedstate.a.InterfaceC0139a
        public void a(d0.d owner) {
            kotlin.jvm.internal.i.f(owner, "owner");
            if (owner instanceof N) {
                M viewModelStore = ((N) owner).getViewModelStore();
                androidx.savedstate.a savedStateRegistry = owner.getSavedStateRegistry();
                Iterator<String> it = viewModelStore.c().iterator();
                while (it.hasNext()) {
                    I b10 = viewModelStore.b(it.next());
                    kotlin.jvm.internal.i.c(b10);
                    LegacySavedStateHandleController.a(b10, savedStateRegistry, owner.getLifecycle());
                }
                if (!viewModelStore.c().isEmpty()) {
                    savedStateRegistry.i(a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }

    public static final void a(I viewModel, androidx.savedstate.a registry, Lifecycle lifecycle) {
        kotlin.jvm.internal.i.f(viewModel, "viewModel");
        kotlin.jvm.internal.i.f(registry, "registry");
        kotlin.jvm.internal.i.f(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.d("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.c()) {
            savedStateHandleController.a(registry, lifecycle);
            f10277a.c(registry, lifecycle);
        }
    }

    public static final SavedStateHandleController b(androidx.savedstate.a registry, Lifecycle lifecycle, String str, Bundle bundle) {
        kotlin.jvm.internal.i.f(registry, "registry");
        kotlin.jvm.internal.i.f(lifecycle, "lifecycle");
        kotlin.jvm.internal.i.c(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, D.f10237f.a(registry.b(str), bundle));
        savedStateHandleController.a(registry, lifecycle);
        f10277a.c(registry, lifecycle);
        return savedStateHandleController;
    }

    public final void c(final androidx.savedstate.a aVar, final Lifecycle lifecycle) {
        Lifecycle.State b10 = lifecycle.b();
        if (b10 != Lifecycle.State.INITIALIZED && !b10.b(Lifecycle.State.STARTED)) {
            lifecycle.a(new InterfaceC0489l() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // androidx.lifecycle.InterfaceC0489l
                public void onStateChanged(InterfaceC0492o source, Lifecycle.Event event) {
                    kotlin.jvm.internal.i.f(source, "source");
                    kotlin.jvm.internal.i.f(event, "event");
                    if (event == Lifecycle.Event.ON_START) {
                        Lifecycle.this.d(this);
                        aVar.i(LegacySavedStateHandleController.a.class);
                    }
                }
            });
        } else {
            aVar.i(a.class);
        }
    }
}
