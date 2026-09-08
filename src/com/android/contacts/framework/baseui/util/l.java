package com.android.contacts.framework.baseui.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.android.incallui.OplusPhoneCapabilities;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import n6.C1372a;

/* compiled from: MbaUtils.java */
/* loaded from: classes.dex */
public class l {

    /* compiled from: MbaUtils.java */
    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f15940a;

        public a(Activity activity) {
            this.f15940a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C1372a.b().c(this.f15940a);
            dialogInterface.dismiss();
        }
    }

    /* compiled from: MbaUtils.java */
    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f15941a;

        public b(Activity activity) {
            this.f15941a = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            this.f15941a.finish();
        }
    }

    /* compiled from: MbaUtils.java */
    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15942a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f15943b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f15944c;

        public c(String str, Context context, DialogInterface.OnClickListener onClickListener) {
            this.f15942a = str;
            this.f15943b = context;
            this.f15944c = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            intent.setData(Uri.fromParts("package", this.f15942a, null));
            R7.b.c(this.f15943b, intent);
            dialogInterface.dismiss();
            DialogInterface.OnClickListener onClickListener = this.f15944c;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i10);
            }
        }
    }

    /* compiled from: MbaUtils.java */
    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f15945a;

        public d(DialogInterface.OnClickListener onClickListener) {
            this.f15945a = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            DialogInterface.OnClickListener onClickListener = this.f15945a;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i10);
            }
        }
    }

    public static Dialog a(Activity activity) {
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(activity);
        cOUIAlertDialogBuilder.setCancelable(false);
        String string = activity.getString(N0.k.f1961c);
        cOUIAlertDialogBuilder.setTitle((CharSequence) activity.getString(N0.k.f1964f, string));
        cOUIAlertDialogBuilder.setMessage((CharSequence) activity.getString(N0.k.f1965g, string));
        a aVar = new a(activity);
        b bVar = new b(activity);
        cOUIAlertDialogBuilder.setPositiveButton((CharSequence) activity.getString(N0.k.f1976r), (DialogInterface.OnClickListener) aVar);
        cOUIAlertDialogBuilder.setNegativeButton((CharSequence) activity.getString(N0.k.f1962d), (DialogInterface.OnClickListener) bVar);
        return cOUIAlertDialogBuilder.show();
    }

    public static CharSequence b(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 512));
        } catch (PackageManager.NameNotFoundException e10) {
            H7.b.c("MbaUtils", "getPackageLabel: exception: " + e10.getMessage());
            return "";
        }
    }

    public static boolean c(Context context, Intent intent) {
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return true;
        }
        return false;
    }

    public static boolean d(Context context, String str) {
        boolean z10 = false;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 512);
            if (applicationInfo != null && !applicationInfo.enabled && (applicationInfo.flags & 1) != 0) {
                z10 = true;
            }
            if (z10) {
                H7.b.i("MbaUtils", "Package [" + str + "] is disabled!");
            }
        } catch (PackageManager.NameNotFoundException e10) {
            H7.b.c("MbaUtils", "isAppDisabled: getApplicationInfo exception: " + e10.getMessage());
        }
        return z10;
    }

    public static boolean e(Context context) {
        if (C1372a.b().d(context) == 1) {
            return true;
        }
        return false;
    }

    public static void f(Context context, String str, DialogInterface.OnClickListener onClickListener, int i10) {
        try {
            g(context, str, b(context, str), onClickListener, i10);
        } catch (Exception e10) {
            H7.b.c("MbaUtils", "requestEnableTargetApp: exception: " + e10.getMessage());
        }
    }

    public static void g(Context context, String str, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, int i10) {
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(context);
        cOUIAlertDialogBuilder.setCancelable(false);
        cOUIAlertDialogBuilder.setTitle((CharSequence) context.getString(N0.k.f1966h, charSequence));
        cOUIAlertDialogBuilder.setMessage((CharSequence) context.getString(N0.k.f1965g, charSequence));
        c cVar = new c(str, context, onClickListener);
        d dVar = new d(onClickListener);
        cOUIAlertDialogBuilder.setPositiveButton((CharSequence) context.getString(N0.k.f1976r), (DialogInterface.OnClickListener) cVar);
        cOUIAlertDialogBuilder.setNegativeButton((CharSequence) context.getString(N0.k.f1962d), (DialogInterface.OnClickListener) dVar);
        androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
        if (i10 != 1) {
            if (i10 != 2) {
                U0.n.d(show);
                return;
            } else {
                U0.n.a(show);
                return;
            }
        }
        U0.n.b(show);
    }
}
