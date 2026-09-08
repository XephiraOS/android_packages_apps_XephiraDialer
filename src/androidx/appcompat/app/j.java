package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c;

/* compiled from: AppCompatDialogFragment.java */
/* loaded from: classes.dex */
public class j extends DialogInterfaceOnCancelListenerC0472c {
    public j() {
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public Dialog onCreateDialog(Bundle bundle) {
        return new i(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public void setupDialog(Dialog dialog, int i10) {
        if (dialog instanceof i) {
            i iVar = (i) dialog;
            if (i10 != 1 && i10 != 2) {
                if (i10 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            iVar.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i10);
    }

    public j(int i10) {
        super(i10);
    }
}
