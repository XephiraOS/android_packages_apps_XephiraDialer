package com.oplus.blacklistapp.callintercept.settings;

import android.R;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oplus.utils.C0846g;
import v6.C1629c;
import v6.C1632f;

/* compiled from: NumRecognitionConfirmDialogHelper.kt */
/* loaded from: classes3.dex */
public final class A {

    /* renamed from: b, reason: collision with root package name */
    public static final a f26758b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Dialog f26759a;

    /* compiled from: NumRecognitionConfirmDialogHelper.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final void f(Context context, DialogInterface dialogInterface, int i10) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(C1629c.f37417c, "com.ted.number.ui.TedUpdateSettingActivity"));
        intent.putExtra("highlight_update_stranger_switch", true);
        C1632f.g0(context, intent);
        C0846g.i("RecognitionEnableConfirmDialogHelper", "positiveButton clicked whichButton=" + i10);
    }

    public static final void g(DialogInterface dialogInterface, int i10) {
        C0846g.i("RecognitionEnableConfirmDialogHelper", "negativeButton clicked whichButton=" + i10);
    }

    public static final void h(DialogInterface dialogInterface) {
        C0846g.i("RecognitionEnableConfirmDialogHelper", "cancelButton clicked");
    }

    public final void d() {
        Dialog dialog = this.f26759a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public final void e(final Context context) {
        if (context == null) {
            C0846g.i("RecognitionEnableConfirmDialogHelper", "cancelButton clicked");
            return;
        }
        Dialog dialog = this.f26759a;
        if (dialog != null) {
            dialog.dismiss();
        }
        C0846g.i("RecognitionEnableConfirmDialogHelper", "showConfirmDialog");
        COUIAlertDialogBuilder negativeButton = new COUIAlertDialogBuilder(context).setTitle(com.oplus.blacklistapp.u.f27612d1).setPositiveButton(com.oplus.blacklistapp.u.f27648k2, new DialogInterface.OnClickListener() { // from class: com.oplus.blacklistapp.callintercept.settings.x
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                A.f(context, dialogInterface, i10);
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.oplus.blacklistapp.callintercept.settings.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                A.g(dialogInterface, i10);
            }
        });
        negativeButton.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.oplus.blacklistapp.callintercept.settings.z
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                A.h(dialogInterface);
            }
        });
        androidx.appcompat.app.b create = negativeButton.create();
        this.f26759a = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        Dialog dialog2 = this.f26759a;
        if (dialog2 != null) {
            dialog2.show();
        }
        negativeButton.updateViewAfterShown();
    }
}
