package com.android.incallui.foldscreen.presentation.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.K;
import com.android.incallui.Log;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenDialogViewModel;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.panel.COUIBottomSheetDialogFragment;
import f.C0991a;
import kotlin.jvm.internal.i;
import v9.InterfaceC1637a;

/* compiled from: FoldScreenInCallDialogFragment.kt */
/* loaded from: classes.dex */
public final class FoldScreenInCallDialogFragment extends COUIBottomSheetDialogFragment implements DialogInterface.OnShowListener {

    /* renamed from: a, reason: collision with root package name */
    public final m9.d f18436a;

    public FoldScreenInCallDialogFragment() {
        m9.d b10;
        setIsInTinyScreen(true, true);
        setDraggable(false);
        setMainPanelFragment(new InCallPanelFragment());
        b10 = kotlin.a.b(new InterfaceC1637a<FoldScreenDialogViewModel>() { // from class: com.android.incallui.foldscreen.presentation.fragment.FoldScreenInCallDialogFragment$viewModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final FoldScreenDialogViewModel invoke() {
                return (FoldScreenDialogViewModel) new K(FoldScreenInCallDialogFragment.this, new Z1.d(Y1.a.f5520a)).a(FoldScreenDialogViewModel.class);
            }
        });
        this.f18436a = b10;
    }

    public final FoldScreenDialogViewModel c1() {
        return (FoldScreenDialogViewModel) this.f18436a.getValue();
    }

    @Override // com.coui.appcompat.panel.COUIBottomSheetDialogFragment, com.google.android.material.bottomsheet.b, androidx.appcompat.app.j, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        i.e(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnShowListener(this);
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        i.f(dialog, "dialog");
        super.onDismiss(dialog);
        Log.d("FoldScreenInCallDialogFragment", "DialogFragment onDismiss: ");
        c1().m();
        c1().o();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        COUIBottomSheetDialog cOUIBottomSheetDialog;
        Log.d("FoldScreenInCallDialogFragment", "DialogFragment onShow: ");
        if (dialogInterface instanceof COUIBottomSheetDialog) {
            cOUIBottomSheetDialog = (COUIBottomSheetDialog) dialogInterface;
        } else {
            cOUIBottomSheetDialog = null;
        }
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setPanelBackground(C0991a.b(cOUIBottomSheetDialog.getContext(), P1.c.f2833a));
        }
        c1().n();
        c1().p("FoldActivityFocus");
    }
}
