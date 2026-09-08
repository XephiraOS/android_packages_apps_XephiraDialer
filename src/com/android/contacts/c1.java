package com.android.contacts;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.android.contacts.framework.baseui.util.NumberIdentifyUtils;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oplus.dialer.R;
import com.ted.number.ui.TedUpdateSettingActivity;

/* compiled from: SpecialNameHelper.kt */
/* loaded from: classes.dex */
public final class c1 {

    /* renamed from: e, reason: collision with root package name */
    public static final a f13725e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Dialog f13726a;

    /* renamed from: b, reason: collision with root package name */
    public final U0.h f13727b = new U0.h();

    /* renamed from: c, reason: collision with root package name */
    public String f13728c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f13729d;

    /* compiled from: SpecialNameHelper.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final void g(String str, Integer num, c1 this$0, Context context, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        H7.b.b("SpecialNameHelper", "SPECIAL_NAME:" + str + " SLOT_ID:" + num);
        this$0.f13728c = str;
        this$0.f13729d = num;
        R7.b.f(context, this$0.d(context), 0, null, 6, null);
        Dialog dialog = this$0.f13726a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static final void h(c1 this$0, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        H7.b.b("SpecialNameHelper", "negativeButton clicked whichButton");
        Dialog dialog = this$0.f13726a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static final void i(DialogInterface dialogInterface) {
        H7.b.b("SpecialNameHelper", "cancelButton clicked");
    }

    public final Intent d(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) TedUpdateSettingActivity.class));
        intent.putExtra("highlight_update_stranger_switch", true);
        return intent;
    }

    public final void e() {
        Dialog dialog = this.f13726a;
        if (dialog != null) {
            if (!dialog.isShowing()) {
                dialog = null;
            }
            if (dialog != null) {
                dialog.dismiss();
            }
        }
        this.f13726a = null;
        this.f13727b.g();
    }

    public final void f(final Context context, final String str, final Integer num) {
        if (context == null) {
            H7.b.b("SpecialNameHelper", "context null");
            return;
        }
        H7.b.b("SpecialNameHelper", "showConfirmDialog");
        COUIAlertDialogBuilder negativeButton = new COUIAlertDialogBuilder(context).setTitle(R.string.enable_number_recognition_title).setPositiveButton(R.string.oplus_start_switch, new DialogInterface.OnClickListener() { // from class: com.android.contacts.Z0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                c1.g(str, num, this, context, dialogInterface, i10);
            }
        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.android.contacts.a1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                c1.h(c1.this, dialogInterface, i10);
            }
        });
        negativeButton.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.android.contacts.b1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                c1.i(dialogInterface);
            }
        });
        androidx.appcompat.app.b create = negativeButton.create();
        this.f13726a = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        Dialog dialog = this.f13726a;
        if (dialog != null) {
            dialog.show();
        }
        negativeButton.updateViewAfterShown();
    }

    public final void j(Context context, String str, int i10, int i11) {
        if (context == null) {
            return;
        }
        if (!NumberIdentifyUtils.e(context)) {
            f(context, str, Integer.valueOf(i10));
            return;
        }
        Intent intent = new Intent();
        intent.setPackage("com.oplus.blacklistapp");
        intent.setAction("oplus.intent.action.blacklist.view_special_name_list");
        intent.putExtra("SpecialName", str);
        intent.putExtra("slotId", i10);
        R7.b.f(context, intent, 0, null, 6, null);
    }
}
