package com.oplus.contacts.googlecontacts.actvities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c;
import androidx.fragment.app.FragmentActivity;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import kotlin.jvm.internal.i;

/* compiled from: MoveResultFragment.kt */
/* loaded from: classes3.dex */
public final class e extends DialogInterfaceOnCancelListenerC0472c {
    public static final void d1(e this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public Dialog onCreateDialog(Bundle bundle) {
        int i10;
        Bundle arguments = getArguments();
        if (arguments != null) {
            i10 = arguments.getInt("actual_count", 0);
        } else {
            i10 = 0;
        }
        if (arguments != null) {
            arguments.getInt(OplusAutoRedialNotificationUI.TOTAL_COUNT, 0);
        }
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(requireContext());
        cOUIAlertDialogBuilder.setTitle((CharSequence) getResources().getQuantityString(Y6.d.f5556a, i10, Integer.valueOf(i10))).setPositiveButton(Y6.e.f5557a, new DialogInterface.OnClickListener() { // from class: com.oplus.contacts.googlecontacts.actvities.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                e.d1(e.this, dialogInterface, i11);
            }
        });
        androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
        i.e(show, "builder.show()");
        return show;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        i.f(dialog, "dialog");
        super.onDismiss(dialog);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
