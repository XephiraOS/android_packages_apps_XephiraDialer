package com.android.incallui.foldscreen.presentation.fragment;

import P1.e;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.K;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenCallCardViewModel;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: FoldScreenCallCardFragment.kt */
/* loaded from: classes.dex */
public final class FoldScreenCallCardFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final m9.d f18435a;

    public FoldScreenCallCardFragment() {
        m9.d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<FoldScreenCallCardViewModel>() { // from class: com.android.incallui.foldscreen.presentation.fragment.FoldScreenCallCardFragment$viewModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final FoldScreenCallCardViewModel invoke() {
                return (FoldScreenCallCardViewModel) new K(FoldScreenCallCardFragment.this, new Z1.d(Y1.a.f5520a)).a(FoldScreenCallCardViewModel.class);
            }
        });
        this.f18435a = b10;
    }

    public final FoldScreenCallCardViewModel c1() {
        return (FoldScreenCallCardViewModel) this.f18435a.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        View inflate = inflater.inflate(e.f2871h, viewGroup, false);
        R1.i i12 = R1.i.i1(inflate);
        i12.k1(c1());
        i12.b1(getViewLifecycleOwner());
        return inflate;
    }
}
