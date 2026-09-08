package com.android.contacts.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Trace;
import android.text.TextUtils;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import c.C0543d;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PermissionsUtil.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f17608a;

    /* renamed from: b, reason: collision with root package name */
    public static String f17609b;

    /* renamed from: c, reason: collision with root package name */
    public static String f17610c;

    /* renamed from: d, reason: collision with root package name */
    public static String f17611d;

    /* compiled from: PermissionsUtil.java */
    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f17612a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f17613b;

        public a(Activity activity, boolean z10) {
            this.f17612a = activity;
            this.f17613b = z10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            K7.b.c(this.f17612a, w.f17609b, 999, FeatureOption.i());
            if (this.f17613b) {
                this.f17612a.finish();
            }
        }
    }

    /* compiled from: PermissionsUtil.java */
    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f17614a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f17615b;

        public b(boolean z10, Activity activity) {
            this.f17614a = z10;
            this.f17615b = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (this.f17614a) {
                dialogInterface.dismiss();
            } else {
                this.f17615b.finish();
            }
        }
    }

    /* compiled from: PermissionsUtil.java */
    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f17616a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f17617b;

        public c(boolean z10, Activity activity) {
            this.f17616a = z10;
            this.f17617b = activity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (this.f17616a) {
                dialogInterface.dismiss();
            } else {
                this.f17617b.finish();
            }
        }
    }

    /* compiled from: PermissionsUtil.java */
    /* loaded from: classes.dex */
    public class d implements androidx.activity.result.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.android.contacts.framework.baseui.util.t f17618a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.activity.result.b[] f17619b;

        public d(com.android.contacts.framework.baseui.util.t tVar, androidx.activity.result.b[] bVarArr) {
            this.f17618a = tVar;
            this.f17619b = bVarArr;
        }

        @Override // androidx.activity.result.a
        public void a(Object obj) {
            if (obj instanceof ActivityResult) {
                H7.b.b("PermissionsUtil", "resultCode: " + ((ActivityResult) obj).d());
                this.f17618a.a(0, obj, null);
            }
            androidx.activity.result.b bVar = this.f17619b[0];
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    public static Dialog A(final ComponentActivity componentActivity, final boolean z10, String str, final String str2, final int i10, final com.android.contacts.framework.baseui.util.t tVar) {
        int i11;
        if (TextUtils.isEmpty(str)) {
            if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                i11 = R.string.launcher_odialer;
            } else {
                i11 = R.string.people;
            }
            str = componentActivity.getString(i11);
        }
        String[] h10 = h(componentActivity, str2, str);
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(componentActivity);
        cOUIAlertDialogBuilder.setTitle((CharSequence) h10[0]);
        cOUIAlertDialogBuilder.setMessage((CharSequence) h10[1]);
        cOUIAlertDialogBuilder.setPositiveButton(R.string.oplus_button_set, new DialogInterface.OnClickListener() { // from class: com.android.contacts.util.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                w.t(com.android.contacts.framework.baseui.util.t.this, componentActivity, str2, i10, z10, dialogInterface, i12);
            }
        });
        cOUIAlertDialogBuilder.setNegativeButton(R.string.cancel_description, new DialogInterface.OnClickListener() { // from class: com.android.contacts.util.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                w.u(com.android.contacts.framework.baseui.util.t.this, z10, componentActivity, dialogInterface, i12);
            }
        });
        androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.android.contacts.util.v
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                w.v(com.android.contacts.framework.baseui.util.t.this, z10, componentActivity, dialogInterface);
            }
        });
        show.setCanceledOnTouchOutside(false);
        return show;
    }

    public static androidx.appcompat.app.b B(Activity activity, boolean z10) {
        return C(activity, z10, null, null, null);
    }

    public static androidx.appcompat.app.b C(Activity activity, boolean z10, String str, String str2, String[] strArr) {
        return D(activity, z10, str, str2, strArr, false);
    }

    public static androidx.appcompat.app.b D(Activity activity, boolean z10, String str, String str2, String[] strArr, boolean z11) {
        boolean l10;
        int i10;
        int i11;
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(activity);
        if (strArr == null) {
            l10 = l(activity, g());
        } else {
            l10 = l(activity, strArr);
        }
        if (TextUtils.isEmpty(str)) {
            if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                i11 = R.string.launcher_odialer;
            } else {
                i11 = R.string.people;
            }
            str = activity.getString(i11);
        }
        H7.b.e("PermissionsUtil", "showPermissionDialog, hasPermission: " + l10);
        if (!l10) {
            x(activity, f17609b, str);
        } else {
            activity.finish();
        }
        cOUIAlertDialogBuilder.setTitle((CharSequence) f17611d);
        cOUIAlertDialogBuilder.setMessage((CharSequence) f17610c);
        cOUIAlertDialogBuilder.setPositiveButton(R.string.oplus_button_set, (DialogInterface.OnClickListener) new a(activity, z10));
        if (z11) {
            i10 = R.string.cancel;
        } else {
            i10 = R.string.oplus_runtime_dialog_cancel;
        }
        cOUIAlertDialogBuilder.setNegativeButton(i10, (DialogInterface.OnClickListener) new b(z11, activity));
        androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
        show.setOnCancelListener(new c(z11, activity));
        show.setCanceledOnTouchOutside(false);
        return show;
    }

    public static String e() {
        if (OsUtils.k()) {
            return "android.permission.READ_MEDIA_AUDIO";
        }
        return "android.permission.READ_EXTERNAL_STORAGE";
    }

    public static Set<String> f() {
        HashSet hashSet = new HashSet();
        hashSet.add("android.permission.GET_ACCOUNTS");
        hashSet.add("android.permission.READ_CONTACTS");
        hashSet.add("android.permission.WRITE_CONTACTS");
        if (CommonFeatureOption.j()) {
            hashSet.add("android.permission.READ_CALL_LOG");
            hashSet.add("android.permission.WRITE_CALL_LOG");
            hashSet.add("android.permission.CALL_PHONE");
        }
        hashSet.add("android.permission.READ_PHONE_STATE");
        if (FeatureOption.i()) {
            hashSet.add("android.permission.READ_PHONE_NUMBERS");
        }
        return hashSet;
    }

    public static String[] g() {
        if (f17608a == null) {
            f17608a = (String[]) f().toArray(new String[0]);
        }
        return f17608a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0175, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a5, code lost:
    
        if (r7.equals("android.permission.RECEIVE_SMS") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] h(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.util.w.h(android.content.Context, java.lang.String, java.lang.String):java.lang.String[]");
    }

    public static boolean i(Context context) {
        return k(context, "com.android.voicemail.permission.ADD_VOICEMAIL");
    }

    public static boolean j(Context context) {
        return k(context, "android.permission.READ_CONTACTS");
    }

    public static boolean k(Context context, String str) {
        if (context.checkSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public static boolean l(Context context, String[] strArr) {
        Trace.beginSection("hasPermission");
        try {
            for (String str : strArr) {
                if (!k(context, str)) {
                    f17609b = str;
                    H7.b.e("PermissionsUtil", "sMissingPermission = " + f17609b);
                    return false;
                }
            }
            Trace.endSection();
            return true;
        } finally {
            Trace.endSection();
        }
    }

    public static boolean m(Context context) {
        return k(context, "android.permission.CALL_PHONE");
    }

    public static boolean n(Context context) {
        if (!r(context) && !k(context, "android.permission.READ_PHONE_STATE")) {
            return false;
        }
        return true;
    }

    public static boolean o(Context context) {
        return k(context, "com.android.voicemail.permission.READ_VOICEMAIL");
    }

    public static boolean p(Context context) {
        if (!r(context) && (!k(context, "com.android.voicemail.permission.READ_VOICEMAIL") || !k(context, "com.android.voicemail.permission.WRITE_VOICEMAIL"))) {
            return false;
        }
        return true;
    }

    public static boolean q(String[] strArr, int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            for (int i10 = 0; i10 < strArr.length; i10++) {
                if (iArr[i10] != 0 && s(strArr[i10])) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean r(Context context) {
        return TextUtils.equals(context.getPackageName(), P7.d.a(context));
    }

    public static boolean s(String str) {
        return Arrays.asList(g()).contains(str);
    }

    public static /* synthetic */ void t(com.android.contacts.framework.baseui.util.t tVar, ComponentActivity componentActivity, String str, int i10, boolean z10, DialogInterface dialogInterface, int i11) {
        if (tVar == null) {
            K7.b.c(componentActivity, str, i10, FeatureOption.i());
        } else {
            Intent a10 = K7.b.a(componentActivity, str, FeatureOption.i());
            androidx.activity.result.b j10 = componentActivity.getActivityResultRegistry().j("GUIDE_TO_ENABLE_PERMISSION", new C0543d(), new d(tVar, r5));
            androidx.activity.result.b[] bVarArr = {j10};
            j10.a(a10);
        }
        dialogInterface.dismiss();
        if (z10) {
            componentActivity.finish();
        }
    }

    public static /* synthetic */ void u(com.android.contacts.framework.baseui.util.t tVar, boolean z10, ComponentActivity componentActivity, DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        if (tVar != null) {
            tVar.a(1, null, null);
        }
        if (z10) {
            componentActivity.finish();
        }
    }

    public static /* synthetic */ void v(com.android.contacts.framework.baseui.util.t tVar, boolean z10, ComponentActivity componentActivity, DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        if (tVar != null) {
            tVar.a(-1, null, null);
        }
        if (z10) {
            componentActivity.finish();
        }
    }

    public static boolean w(Activity activity) {
        Trace.beginSection("requestPermissions");
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : g()) {
                if (!k(activity, str)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() == 0) {
                H7.b.c("PermissionsUtil", "Request permission activity was called even though all permissions are satisfied.");
                Trace.endSection();
                return true;
            }
            activity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 1);
            Trace.endSection();
            return false;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public static void x(Activity activity, String str, String str2) {
        H7.b.b("PermissionsUtil", "setTitleAndMessage: missingPermission = " + str);
        String[] h10 = h(activity, str, str2);
        f17611d = h10[0];
        f17610c = h10[1];
    }

    public static Dialog y(ComponentActivity componentActivity, boolean z10, String str, String str2) {
        return z(componentActivity, z10, str, str2, 999);
    }

    public static Dialog z(ComponentActivity componentActivity, boolean z10, String str, String str2, int i10) {
        return A(componentActivity, z10, str, str2, i10, null);
    }
}
