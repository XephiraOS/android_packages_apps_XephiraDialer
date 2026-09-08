package com.android.incallui.foldscreen.presentation.viewmodel;

import com.android.incallui.Call;
import d.InterfaceC0944a;
import kotlin.jvm.internal.i;

/* compiled from: FoldScreenDialogViewModel.kt */
/* loaded from: classes.dex */
public final class FoldScreenDialogViewModel extends FoldScreenBaseViewModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @InterfaceC0944a
    public FoldScreenDialogViewModel(Y1.a useCaseProvider) {
        super(useCaseProvider);
        i.f(useCaseProvider, "useCaseProvider");
    }

    public final void m() {
        if (!i.b(k().b().getValue(), Boolean.TRUE)) {
            return;
        }
        i().f().b();
    }

    public final void n() {
        if (!i.b(k().b().getValue(), Boolean.TRUE)) {
            return;
        }
        i().e().b();
        i().g().b();
    }

    public final void o() {
        Call b10;
        if (i.b(k().b().getValue(), Boolean.TRUE) && (b10 = j().j().b()) != null && !b10.getIsSilence()) {
            j().u().b();
        }
    }

    public final void p(String fromTag) {
        i.f(fromTag, "fromTag");
        j().v().b(fromTag);
    }
}
