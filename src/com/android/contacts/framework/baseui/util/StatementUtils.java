package com.android.contacts.framework.baseui.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import kotlin.Result;
import v9.InterfaceC1637a;

/* compiled from: StatementUtils.kt */
/* loaded from: classes.dex */
public final class StatementUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final StatementUtils f15877a = new StatementUtils();

    /* renamed from: b, reason: collision with root package name */
    public static androidx.appcompat.app.b f15878b;

    /* compiled from: StatementUtils.kt */
    /* loaded from: classes.dex */
    public enum DialogType {
        NONE,
        NORMAL,
        UPDATE
    }

    public static final void A(Context context, int i10, boolean z10, int i11) {
        kotlin.jvm.internal.i.f(context, "context");
        Intent intent = new Intent("oplus.intent.action.STATEMENT_SHOW");
        intent.putExtra("source", i10);
        intent.putExtra("from_car", z10);
        intent.putExtra("extra_from", i11);
        R7.b.f(context, intent, 0, null, 4, null);
    }

    public static /* synthetic */ void B(Context context, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        A(context, i10, z10, i11);
    }

    public static final void d(Context context, boolean z10) {
        kotlin.jvm.internal.i.f(context, "context");
        if (z10) {
            s.a(context, true);
        }
        NumberIdentifyUtils.n(context, z10 ? 1 : 0, null, null, true, 12, null);
    }

    public static final void e(Context context, boolean z10) {
        kotlin.jvm.internal.i.f(context, "context");
        androidx.preference.j.b(context.getApplicationContext()).edit().putInt("contacts_permission_recognition_dialog", !z10 ? 1 : 0).apply();
        K7.a.a(context, z10);
    }

    public static final String g(Context context, DialogType dialogType) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(dialogType, "dialogType");
        if (FeatureUtil.O()) {
            if (dialogType == DialogType.NORMAL) {
                String g10 = M7.a.g(context, "com.ted.number", "number_recognition_user_notice_dialog_content", null, 8, null);
                if (g10 == null) {
                    String string = context.getString(N0.k.f1952B);
                    kotlin.jvm.internal.i.e(string, "context.getString(R.stri…th_number_recognition_v2)");
                    return string;
                }
                return g10;
            }
            String g11 = M7.a.g(context, "com.ted.number", "number_recognition_user_notice_update_dialog_content", null, 8, null);
            if (g11 == null) {
                String string2 = context.getString(N0.k.f1952B);
                kotlin.jvm.internal.i.e(string2, "context.getString(R.stri…th_number_recognition_v2)");
                return string2;
            }
            return g11;
        }
        String string3 = context.getString(N0.k.f1952B);
        kotlin.jvm.internal.i.e(string3, "{\n            context.ge…recognition_v2)\n        }");
        return string3;
    }

    public static /* synthetic */ String h(Context context, DialogType dialogType, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            dialogType = DialogType.NORMAL;
        }
        return g(context, dialogType);
    }

    public static final String i(Context context, DialogType dialogType) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(dialogType, "dialogType");
        if (dialogType == DialogType.UPDATE) {
            String string = context.getString(N0.k.f1957G);
            kotlin.jvm.internal.i.e(string, "{\n            context.ge…_notice_update)\n        }");
            return string;
        }
        String string2 = context.getString(N0.k.f1977s);
        kotlin.jvm.internal.i.e(string2, "{\n            context.ge…tatement_title)\n        }");
        return string2;
    }

    public static final DialogType j(Context context, boolean z10) {
        kotlin.jvm.internal.i.f(context, "context");
        if (!CommonFeatureOption.l()) {
            return DialogType.NONE;
        }
        if (!androidx.preference.j.b(context).contains("identify_unfamiliar_number_recognition_dialog")) {
            boolean e10 = NumberIdentifyUtils.e(context);
            if (e10) {
                NumberIdentifyUtils.r(context, true);
            }
            if (!e10) {
                return DialogType.NORMAL;
            }
        }
        if (z10 && q(context) && NumberIdentifyUtils.e(context)) {
            return DialogType.UPDATE;
        }
        return DialogType.NONE;
    }

    public static final CharSequence l(Context context, DialogType dialogType) {
        String str;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(dialogType, "dialogType");
        if (FeatureUtil.O()) {
            if (dialogType == DialogType.NORMAL) {
                str = "number_recognition_user_notice_dialog_content";
            } else {
                str = "number_recognition_user_notice_update_dialog_content";
            }
            String g10 = M7.a.g(context, "com.ted.number", str, null, 8, null);
            if (g10 == null || g10.length() == 0) {
                return f15877a.n(context);
            }
            return g10;
        }
        return f15877a.n(context);
    }

    public static /* synthetic */ CharSequence m(Context context, DialogType dialogType, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            dialogType = DialogType.NORMAL;
        }
        return l(context, dialogType);
    }

    public static final CharSequence o(Context context, boolean z10) {
        String string;
        kotlin.jvm.internal.i.f(context, "context");
        if (!CommonFeatureOption.j()) {
            if (z10) {
                string = context.getString(N0.k.f1956F);
            } else if (OsUtils.k()) {
                string = context.getString(N0.k.f1955E);
            } else {
                string = context.getString(N0.k.f1954D);
            }
        } else if (z10) {
            string = context.getString(N0.k.f1951A);
        } else if (VirtualSupportUtils.m()) {
            string = context.getString(N0.k.f1953C);
        } else if (OsUtils.k()) {
            string = context.getString(N0.k.f1984z);
        } else {
            string = context.getString(N0.k.f1983y);
        }
        kotlin.jvm.internal.i.e(string, "if (!CommonFeatureOption…          }\n            }");
        return string;
    }

    public static final boolean p(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (androidx.preference.j.b(context).getInt("contacts_permission_recognition_dialog", 1) == 0) {
            return true;
        }
        return false;
    }

    public static final boolean q(Context context) {
        Object b10;
        boolean z10;
        kotlin.jvm.internal.i.f(context, "context");
        StatementUtils statementUtils = f15877a;
        try {
            Result.a aVar = Result.f34166a;
            String k10 = statementUtils.k(context);
            H7.b.e("StatementUtils", "isRecognitionNoticeUpdate version = " + k10);
            if (FeatureUtil.O() && !kotlin.jvm.internal.i.b(FeatureUtil.w(), k10)) {
                z10 = true;
            } else {
                z10 = false;
            }
            b10 = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("StatementUtils", "isRecognitionNoticeUpdate " + d10 + " " + d10.getMessage());
        }
        Boolean bool = Boolean.FALSE;
        if (Result.f(b10)) {
            b10 = bool;
        }
        return ((Boolean) b10).booleanValue();
    }

    public static final boolean r(Context context, boolean z10) {
        kotlin.jvm.internal.i.f(context, "context");
        if (j(context, z10) != DialogType.NONE) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean s(Context context, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return r(context, z10);
    }

    public static final boolean t(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (v(context, false, false, false, 14, null) != DialogType.NONE) {
            return true;
        }
        return false;
    }

    public static final DialogType u(Context context, boolean z10, boolean z11, boolean z12) {
        if (!z10) {
            return DialogType.NONE;
        }
        if (!z11 && NumberIdentifyUtils.f(context) == 1) {
            return DialogType.NORMAL;
        }
        if (z12 && q(context) && z11) {
            return DialogType.UPDATE;
        }
        return DialogType.NONE;
    }

    public static /* synthetic */ DialogType v(Context context, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = CommonFeatureOption.l();
        }
        if ((i10 & 4) != 0) {
            z11 = NumberIdentifyUtils.e(context);
        }
        if ((i10 & 8) != 0) {
            z12 = false;
        }
        return u(context, z10, z11, z12);
    }

    public static final void x() {
        f15877a.f();
    }

    public static final void y(Context context, InterfaceC1637a onAgreeFunc, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(context, "$context");
        kotlin.jvm.internal.i.f(onAgreeFunc, "$onAgreeFunc");
        d(context, true);
        f15877a.f();
        onAgreeFunc.invoke();
        A.c("agree");
    }

    public static final void z(Context context, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(context, "$context");
        d(context, false);
        f15877a.f();
        A.c("disagree");
    }

    public final void f() {
        androidx.appcompat.app.b bVar;
        androidx.appcompat.app.b bVar2 = f15878b;
        if (bVar2 != null && bVar2.isShowing() && (bVar = f15878b) != null) {
            bVar.dismiss();
        }
        f15878b = null;
    }

    public final String k(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        return G0.c.k(context, 0, "number_recognition_user_notice_agree_version", 1);
    }

    public final String n(Context context) {
        if (NumberIdentifyUtils.b()) {
            String string = context.getString(N0.k.f1970l);
            kotlin.jvm.internal.i.e(string, "{\n            context.ge…out_network_v2)\n        }");
            return string;
        }
        String string2 = context.getString(N0.k.f1969k);
        kotlin.jvm.internal.i.e(string2, "{\n            context.ge…ith_network_v3)\n        }");
        return string2;
    }

    public final Dialog w(final Context context, final InterfaceC1637a<m9.q> onAgreeFunc) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(onAgreeFunc, "onAgreeFunc");
        f();
        androidx.appcompat.app.b h10 = U0.k.h(context, false, new Runnable() { // from class: com.android.contacts.framework.baseui.util.x
            @Override // java.lang.Runnable
            public final void run() {
                StatementUtils.x();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.android.contacts.framework.baseui.util.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                StatementUtils.y(context, onAgreeFunc, dialogInterface, i10);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.android.contacts.framework.baseui.util.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                StatementUtils.z(context, dialogInterface, i10);
            }
        }, null, 32, null);
        h10.show();
        f15878b = h10;
        return h10;
    }
}
