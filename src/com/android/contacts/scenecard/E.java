package com.android.contacts.scenecard;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.coui.appcompat.clickablespan.COUIClickableSpan;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.statement.COUIUserStatementDialog;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import kotlin.Pair;

/* compiled from: SceneDialogCreator.kt */
/* loaded from: classes.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    public static final E f17080a = new E();

    public static final void B(Runnable runnable, Context context) {
        kotlin.jvm.internal.i.f(context, "$context");
        if (runnable != null) {
            runnable.run();
        }
        Pair<Intent, Bundle> a10 = C0672f.f17272a.a(context, 1, 1, R.string.view_personal_information_protection_policy);
        R7.b.e(context, a10.a(), 0, a10.b());
    }

    public static final boolean C(COUIBottomSheetDialog dialog, Runnable runnable, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.i.f(dialog, "$dialog");
        if (i10 == 4 && keyEvent != null && keyEvent.getAction() == 1) {
            dialog.dismiss();
            if (runnable != null) {
                runnable.run();
                return false;
            }
            return false;
        }
        return false;
    }

    public static final COUIBottomSheetDialog m(Context context, int i10, CharSequence charSequence, CharSequence charSequence2, int i11, int i12, COUIUserStatementDialog.OnButtonClickListener onButtonClickListener) {
        COUIUserStatementDialog cOUIUserStatementDialog = new COUIUserStatementDialog(context, 0, 0.0f, 0.0f, 14, null);
        cOUIUserStatementDialog.setIsShowInMaxHeight(false);
        cOUIUserStatementDialog.setTitleText(context.getString(i10));
        cOUIUserStatementDialog.setStatement(TextUtils.concat(charSequence, "\n"));
        cOUIUserStatementDialog.setProtocolText(charSequence2);
        cOUIUserStatementDialog.setBottomButtonText(context.getString(i11));
        cOUIUserStatementDialog.setExitButtonText(context.getString(i12));
        cOUIUserStatementDialog.setOnButtonClickListener(onButtonClickListener);
        cOUIUserStatementDialog.setCanceledOnTouchOutside(false);
        return cOUIUserStatementDialog;
    }

    public static final boolean o(Runnable runnable, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 == 4 && keyEvent != null && keyEvent.getAction() == 1) {
            if (runnable == null) {
                return true;
            }
            runnable.run();
            return true;
        }
        return false;
    }

    public static final void p(Runnable runnable, Context context) {
        kotlin.jvm.internal.i.f(context, "$context");
        if (runnable != null) {
            runnable.run();
        }
        Pair<Intent, Bundle> a10 = C0672f.f17272a.a(context, 1, 2, R.string.view_user_agreement);
        R7.b.e(context, a10.a(), 0, a10.b());
    }

    public static final void q(Runnable runnable, Context context) {
        kotlin.jvm.internal.i.f(context, "$context");
        if (runnable != null) {
            runnable.run();
        }
        Pair<Intent, Bundle> a10 = C0672f.f17272a.a(context, 1, 3, R.string.view_personal_information_protection_policy);
        R7.b.e(context, a10.a(), 0, a10.b());
    }

    public static final void r(Runnable runnable, Context context) {
        kotlin.jvm.internal.i.f(context, "$context");
        if (runnable != null) {
            runnable.run();
        }
        Pair<Intent, Bundle> a10 = C0672f.f17272a.a(context, 1, 4, R.string.view_more_infomation);
        R7.b.e(context, a10.a(), 0, a10.b());
    }

    public static final void t(Runnable runnable, Context context) {
        kotlin.jvm.internal.i.f(context, "$context");
        if (runnable != null) {
            runnable.run();
        }
        Pair<Intent, Bundle> a10 = C0672f.f17272a.a(context, 1, 2, R.string.view_user_agreement);
        R7.b.e(context, a10.a(), 0, a10.b());
    }

    public static final void u(Runnable runnable, Context context) {
        kotlin.jvm.internal.i.f(context, "$context");
        if (runnable != null) {
            runnable.run();
        }
        Pair<Intent, Bundle> a10 = C0672f.f17272a.a(context, 1, 3, R.string.view_personal_information_protection_policy);
        R7.b.e(context, a10.a(), 0, a10.b());
    }

    public static final boolean v(Runnable runnable, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 == 4 && runnable != null) {
            runnable.run();
            return false;
        }
        return false;
    }

    public static final void x(Runnable onConfirm, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(onConfirm, "$onConfirm");
        onConfirm.run();
    }

    public static final void y(Runnable onCancel, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(onCancel, "$onCancel");
        onCancel.run();
    }

    public static final void z(Runnable onCancel, DialogInterface dialogInterface) {
        kotlin.jvm.internal.i.f(onCancel, "$onCancel");
        onCancel.run();
    }

    public final COUIBottomSheetDialog A(final Context context, final Runnable runnable, COUIUserStatementDialog.OnButtonClickListener listener, final Runnable runnable2) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(listener, "listener");
        final COUIBottomSheetDialog m10 = m(context, R.string.permission_statement_title, StatementUtils.o(context, CommonFeatureOption.f28289a.f()), com.android.contacts.framework.baseui.util.u.f(context, true, new COUIClickableSpan.SpannableStrClickListener() { // from class: com.android.contacts.scenecard.s
            @Override // com.coui.appcompat.clickablespan.COUIClickableSpan.SpannableStrClickListener
            public final void onClick() {
                E.B(runnable2, context);
            }
        }), R.string.agree_and_use, R.string.disagree_and_exit, listener);
        m10.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.android.contacts.scenecard.v
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                boolean C10;
                C10 = E.C(COUIBottomSheetDialog.this, runnable, dialogInterface, i10, keyEvent);
                return C10;
            }
        });
        return m10;
    }

    public final COUIBottomSheetDialog n(final Context context, final Runnable runnable, COUIUserStatementDialog.OnButtonClickListener listener, final Runnable runnable2) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(listener, "listener");
        COUIBottomSheetDialog m10 = m(context, R.string.agree_information_processing, StatementUtils.m(context, null, 2, null), com.android.contacts.framework.baseui.util.u.a(context, true, false, new COUIClickableSpan.SpannableStrClickListener() { // from class: com.android.contacts.scenecard.z
            @Override // com.coui.appcompat.clickablespan.COUIClickableSpan.SpannableStrClickListener
            public final void onClick() {
                E.p(runnable2, context);
            }
        }, new COUIClickableSpan.SpannableStrClickListener() { // from class: com.android.contacts.scenecard.A
            @Override // com.coui.appcompat.clickablespan.COUIClickableSpan.SpannableStrClickListener
            public final void onClick() {
                E.q(runnable2, context);
            }
        }, new COUIClickableSpan.SpannableStrClickListener() { // from class: com.android.contacts.scenecard.B
            @Override // com.coui.appcompat.clickablespan.COUIClickableSpan.SpannableStrClickListener
            public final void onClick() {
                E.r(runnable2, context);
            }
        }), R.string.agree_and_use, R.string.disagree, listener);
        m10.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.android.contacts.scenecard.C
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                boolean o10;
                o10 = E.o(runnable, dialogInterface, i10, keyEvent);
                return o10;
            }
        });
        return m10;
    }

    public final COUIBottomSheetDialog s(final Context context, COUIUserStatementDialog.OnButtonClickListener listener, final Runnable runnable, final Runnable runnable2) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(listener, "listener");
        COUIBottomSheetDialog m10 = m(context, R.string.permission_statement_title, StatementUtils.h(context, null, 2, null), com.android.contacts.framework.baseui.util.u.d(context, true, false, new COUIClickableSpan.SpannableStrClickListener() { // from class: com.android.contacts.scenecard.w
            @Override // com.coui.appcompat.clickablespan.COUIClickableSpan.SpannableStrClickListener
            public final void onClick() {
                E.t(runnable2, context);
            }
        }, new COUIClickableSpan.SpannableStrClickListener() { // from class: com.android.contacts.scenecard.x
            @Override // com.coui.appcompat.clickablespan.COUIClickableSpan.SpannableStrClickListener
            public final void onClick() {
                E.u(runnable2, context);
            }
        }), R.string.agree_and_use, R.string.disagree, listener);
        m10.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.android.contacts.scenecard.y
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                boolean v10;
                v10 = E.v(runnable, dialogInterface, i10, keyEvent);
                return v10;
            }
        });
        return m10;
    }

    public final Dialog w(Context context, String unGrantedPermission, final Runnable onConfirm, final Runnable onCancel) {
        int i10;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(unGrantedPermission, "unGrantedPermission");
        kotlin.jvm.internal.i.f(onConfirm, "onConfirm");
        kotlin.jvm.internal.i.f(onCancel, "onCancel");
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            i10 = R.string.launcher_odialer;
        } else {
            i10 = R.string.people;
        }
        String string = context.getString(i10);
        kotlin.jvm.internal.i.e(string, "context.getString(\n     …R.string.people\n        )");
        String[] h10 = com.android.contacts.util.w.h(context, unGrantedPermission, string);
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(context, 2132083080);
        cOUIAlertDialogBuilder.setTitle((CharSequence) h10[0]);
        cOUIAlertDialogBuilder.setMessage((CharSequence) h10[1]);
        cOUIAlertDialogBuilder.setPositiveButton(R.string.oplus_button_set, new DialogInterface.OnClickListener() { // from class: com.android.contacts.scenecard.D
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                E.x(onConfirm, dialogInterface, i11);
            }
        });
        cOUIAlertDialogBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.android.contacts.scenecard.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                E.y(onCancel, dialogInterface, i11);
            }
        });
        cOUIAlertDialogBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.android.contacts.scenecard.u
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                E.z(onCancel, dialogInterface);
            }
        });
        androidx.appcompat.app.b create = cOUIAlertDialogBuilder.create();
        kotlin.jvm.internal.i.e(create, "builder.create()");
        create.setCanceledOnTouchOutside(false);
        return create;
    }
}
