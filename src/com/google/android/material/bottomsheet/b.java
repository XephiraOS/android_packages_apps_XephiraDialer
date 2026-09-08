package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.j;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* compiled from: BottomSheetDialogFragment.java */
/* loaded from: classes3.dex */
public class b extends j {
    private boolean waitingForDismissAllowingStateLoss;

    public b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void dismissWithAnimation(BottomSheetBehavior<?> bottomSheetBehavior, boolean z10) {
        this.waitingForDismissAllowingStateLoss = z10;
        if (bottomSheetBehavior.getState() == 5) {
            dismissAfterAnimation();
            return;
        }
        if (getDialog() instanceof com.google.android.material.bottomsheet.a) {
            ((com.google.android.material.bottomsheet.a) getDialog()).removeDefaultCallback();
        }
        bottomSheetBehavior.addBottomSheetCallback(new C0209b());
        bottomSheetBehavior.setState(5);
    }

    private boolean tryDismissWithAnimation(boolean z10) {
        Dialog dialog = getDialog();
        if (dialog instanceof com.google.android.material.bottomsheet.a) {
            com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
            BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
            if (behavior.isHideable() && aVar.getDismissWithAnimation()) {
                dismissWithAnimation(behavior, z10);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public void dismiss() {
        if (!tryDismissWithAnimation(false)) {
            super.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public void dismissAllowingStateLoss() {
        if (!tryDismissWithAnimation(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    @Override // androidx.appcompat.app.j, androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(getContext(), getTheme());
    }

    public b(int i10) {
        super(i10);
    }

    /* compiled from: BottomSheetDialogFragment.java */
    /* renamed from: com.google.android.material.bottomsheet.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0209b extends BottomSheetBehavior.g {
        public C0209b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onStateChanged(View view, int i10) {
            if (i10 == 5) {
                b.this.dismissAfterAnimation();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onSlide(View view, float f10) {
        }
    }
}
