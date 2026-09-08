package com.oplus.contacts.list.dialog.delete;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oplus.dialer.R;
import kotlin.jvm.internal.i;

/* compiled from: DeleteProcessDialog.kt */
/* loaded from: classes3.dex */
public final class f extends DialogInterfaceOnCancelListenerC0472c {
    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public Dialog onCreateDialog(Bundle bundle) {
        androidx.appcompat.app.b dialog = new COUIAlertDialogBuilder(requireContext(), 2132083086).setTitle(R.string.in_processing).show();
        dialog.setCanceledOnTouchOutside(false);
        setCancelable(false);
        i.e(dialog, "dialog");
        return dialog;
    }
}
