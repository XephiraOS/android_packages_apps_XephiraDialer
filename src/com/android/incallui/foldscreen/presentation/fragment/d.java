package com.android.incallui.foldscreen.presentation.fragment;

import P1.e;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.incallui.Log;
import kotlin.jvm.internal.i;

/* compiled from: FoldScreenInCallDialogFragment.kt */
/* loaded from: classes.dex */
public final class d extends Fragment {
    public d() {
        super(e.f2873j);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        Log.d("FoldScreenInCallDialogFragment", "PanelContentFragment onViewCreated: ");
        FragmentManager childFragmentManager = getChildFragmentManager();
        i.e(childFragmentManager, "childFragmentManager");
        Z1.b.b(childFragmentManager, P1.d.f2849h, FoldScreenCallCardFragment.class);
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        i.e(childFragmentManager2, "childFragmentManager");
        Z1.b.b(childFragmentManager2, P1.d.f2848g, FoldScreenCallButtonFragment.class);
    }
}
