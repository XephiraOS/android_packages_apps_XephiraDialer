package com.customize.contacts.manager;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

/* compiled from: DialogGetter.java */
/* loaded from: classes3.dex */
public final class j {
    public static Dialog a(Context context, DialogInterface.OnClickListener onClickListener, int i10, int i11) {
        return c(context, onClickListener, i10, i11, null);
    }

    public static Dialog b(Context context, DialogInterface.OnClickListener onClickListener, int i10, int i11, int i12) {
        return c(context, onClickListener, i10, i11, context.getString(i12));
    }

    public static Dialog c(Context context, DialogInterface.OnClickListener onClickListener, int i10, int i11, String str) {
        U0.b bVar = new U0.b(context, 2132083073);
        bVar.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setTitle((CharSequence) String.format(context.getResources().getQuantityString(com.oplus.dialer.R.plurals.dialog_title_delete_n_contacts_from_groups, i10), Integer.valueOf(i10))).setNeutralButton(com.oplus.dialer.R.string.remove, onClickListener).setCancelable(true);
        if (!TextUtils.isEmpty(str)) {
            bVar.setMessage((CharSequence) str);
        }
        return bVar.show();
    }
}
