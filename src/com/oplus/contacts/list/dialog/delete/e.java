package com.oplus.contacts.list.dialog.delete;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.m;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.util.X;
import java.util.Arrays;
import kotlin.jvm.internal.i;
import m9.g;

/* compiled from: DeleteConfirmDialogFragment.kt */
/* loaded from: classes3.dex */
public final class e extends U0.c {

    /* renamed from: b, reason: collision with root package name */
    public static final a f27921b = new a(null);

    /* compiled from: DeleteConfirmDialogFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final e a(ContactsDeleteInfo deleteInfo) {
            i.f(deleteInfo, "deleteInfo");
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putParcelable("delete_info", deleteInfo);
            eVar.setArguments(bundle);
            return eVar;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final void f1(e this$0, ContactsDeleteInfo contactsDeleteInfo, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        m.a(this$0, "request_key_dialog_btn_click", F.c.a(g.a("key_which_btn", -3), g.a("dialog_fragment_tag", "tag_delete_confirm"), g.a("delete_info", contactsDeleteInfo)));
    }

    public static final void g1(e this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        m.a(this$0, "request_key_dialog_btn_click", F.c.a(g.a("key_which_btn", -2), g.a("dialog_fragment_tag", "tag_delete_confirm")));
    }

    @Override // U0.c
    public Dialog c1(Bundle bundle) {
        final ContactsDeleteInfo contactsDeleteInfo;
        int i10;
        int i11;
        Bundle arguments = getArguments();
        if (arguments != null) {
            contactsDeleteInfo = (ContactsDeleteInfo) arguments.getParcelable("delete_info");
        } else {
            contactsDeleteInfo = null;
        }
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(requireContext(), 2132083073);
        Context requireContext = requireContext();
        int i12 = -1;
        if (contactsDeleteInfo != null) {
            i10 = contactsDeleteInfo.b();
        } else {
            i10 = -1;
        }
        int i13 = 0;
        if (contactsDeleteInfo != null) {
            i11 = contactsDeleteInfo.f();
        } else {
            i11 = 0;
        }
        String b10 = X.b(requireContext, i10, i11);
        if (contactsDeleteInfo != null) {
            i12 = contactsDeleteInfo.b();
        }
        if (contactsDeleteInfo != null) {
            i13 = contactsDeleteInfo.f();
        }
        cOUIAlertDialogBuilder.setTitle((CharSequence) b10).setNeutralButton(X.a(i12, i13), new DialogInterface.OnClickListener() { // from class: com.oplus.contacts.list.dialog.delete.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i14) {
                e.f1(e.this, contactsDeleteInfo, dialogInterface, i14);
            }
        });
        cOUIAlertDialogBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.oplus.contacts.list.dialog.delete.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i14) {
                e.g1(e.this, dialogInterface, i14);
            }
        });
        if (contactsDeleteInfo != null && contactsDeleteInfo.d()) {
            Context requireContext2 = requireContext();
            i.e(requireContext2, "requireContext()");
            cOUIAlertDialogBuilder.setMessage((CharSequence) h1(requireContext2, contactsDeleteInfo.b(), contactsDeleteInfo.f()));
        }
        androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
        i.e(show, "dialogBuilder.show()");
        return show;
    }

    public final String h1(Context context, int i10, int i11) {
        String string;
        try {
            if (i10 == i11) {
                string = context.getString(com.oplus.dialer.R.string.delete_all_contacts_contain_cloud);
                i.e(string, "{\n                contex…tain_cloud)\n            }");
            } else if (i10 > 1) {
                String b10 = U7.a.b(i10);
                i.e(b10, "formatNumberWithLocale(markedCount)");
                int parseInt = Integer.parseInt(b10);
                kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.f34245a;
                String quantityString = context.getResources().getQuantityString(com.oplus.dialer.R.plurals.delete_n_contacts_contain_cloud, parseInt);
                i.e(quantityString, "context.resources.getQua…unt\n                    )");
                string = String.format(quantityString, Arrays.copyOf(new Object[]{Integer.valueOf(parseInt)}, 1));
                i.e(string, "format(...)");
            } else {
                string = context.getString(com.oplus.dialer.R.string.delete_contact_contain_cloud);
                i.e(string, "{\n                contex…tain_cloud)\n            }");
            }
            return string;
        } catch (Exception e10) {
            H7.b.c("AutoConfigAlertDialogFragment", "getDeleteContactMessage error " + e10);
            return "";
        }
    }
}
