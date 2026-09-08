package com.android.incallui.foldscreen.presentation.fragment;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.android.incallui.Log;
import com.coui.appcompat.panel.COUIPanelBarView;
import com.coui.appcompat.panel.COUIPanelFragment;
import kotlin.jvm.internal.i;

/* compiled from: FoldScreenInCallDialogFragment.kt */
/* loaded from: classes.dex */
public final class InCallPanelFragment extends COUIPanelFragment {
    public final d c1(FragmentManager fragmentManager) {
        Fragment l02 = fragmentManager.l0(getContentResId());
        if (l02 instanceof d) {
            return (d) l02;
        }
        return null;
    }

    @Override // com.coui.appcompat.panel.COUIPanelFragment
    public void initView(View view) {
        Log.d("FoldScreenInCallDialogFragment", "PanelFragment initView: ");
        COUIPanelBarView panelBarView = getPanelBarView();
        if (panelBarView != null) {
            panelBarView.setVisibility(4);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        i.e(childFragmentManager, "childFragmentManager");
        d c12 = c1(childFragmentManager);
        if (c12 == null) {
            c12 = new d();
        }
        getChildFragmentManager().p().s(getContentResId(), c12).i();
    }
}
