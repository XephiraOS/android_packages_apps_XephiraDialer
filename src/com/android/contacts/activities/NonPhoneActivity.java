package com.android.contacts.activities;

import C7.e;
import R0.c;
import R7.b;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.ContactsActivity;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oplus.dialer.R;

/* loaded from: classes.dex */
public class NonPhoneActivity extends ContactsActivity {

    /* loaded from: classes.dex */
    public static final class a extends DialogInterfaceOnCancelListenerC0472c implements DialogInterface.OnClickListener {
        public final String c1() {
            return getArguments().getString("PHONE_NUMBER");
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -1) {
                Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
                intent.setType("vnd.android.cursor.item/contact");
                intent.putExtra("phone", c1());
                intent.putExtra(c.f3183a, true);
                b.c(getActivity(), intent);
            }
            dismiss();
        }

        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
        public Dialog onCreateDialog(Bundle bundle) {
            return new COUIAlertDialogBuilder(getActivity()).setTitle(R.string.non_phone_caption).setMessage((CharSequence) c1()).setPositiveButton((CharSequence) getActivity().getString(R.string.non_phone_add_to_contacts), (DialogInterface.OnClickListener) this).setNegativeButton((CharSequence) getActivity().getString(R.string.non_phone_close), (DialogInterface.OnClickListener) this).show();
        }

        @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c, android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                e.b(activity);
            }
        }
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RequestPermissionsActivity.p2(this);
        String p12 = p1();
        if (TextUtils.isEmpty(p12)) {
            e.b(this);
            return;
        }
        a aVar = new a();
        Bundle bundle2 = new Bundle();
        bundle2.putString("PHONE_NUMBER", p12);
        aVar.setArguments(bundle2);
        getSupportFragmentManager().p().e(aVar, "Fragment").j();
    }

    public final String p1() {
        Uri data;
        if (getIntent() == null || (data = getIntent().getData()) == null || !"tel".equals(data.getScheme())) {
            return null;
        }
        return getIntent().getData().getSchemeSpecificPart();
    }
}
