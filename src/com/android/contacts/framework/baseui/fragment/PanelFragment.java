package com.android.contacts.framework.baseui.fragment;

import N0.c;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.panel.COUIBottomSheetDialogFragment;
import com.coui.appcompat.panel.COUIPanelFragment;

/* compiled from: PanelFragment.kt */
/* loaded from: classes.dex */
public class PanelFragment extends COUIPanelFragment {
    private COUIBottomSheetDialog bottomSheetDialog;

    @Override // com.coui.appcompat.panel.COUIPanelFragment
    public void onShow(Boolean bool) {
        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment;
        KeyEvent.Callback callback;
        super.onShow(bool);
        Fragment parentFragment = getParentFragment();
        COUIBottomSheetDialog cOUIBottomSheetDialog = null;
        if (parentFragment instanceof COUIBottomSheetDialogFragment) {
            cOUIBottomSheetDialogFragment = (COUIBottomSheetDialogFragment) parentFragment;
        } else {
            cOUIBottomSheetDialogFragment = null;
        }
        if (cOUIBottomSheetDialogFragment != null) {
            callback = cOUIBottomSheetDialogFragment.getDialog();
        } else {
            callback = null;
        }
        if (callback instanceof COUIBottomSheetDialog) {
            cOUIBottomSheetDialog = (COUIBottomSheetDialog) callback;
        }
        this.bottomSheetDialog = cOUIBottomSheetDialog;
        if (cOUIBottomSheetDialog != null) {
            int attrColor = COUIContextUtil.getAttrColor(cOUIBottomSheetDialog.getContext(), c.f1840a);
            cOUIBottomSheetDialog.setPanelBackgroundTintColor(attrColor);
            cOUIBottomSheetDialog.setNavColor(attrColor);
            cOUIBottomSheetDialog.setIsShowInMaxHeight(false);
        }
    }
}
