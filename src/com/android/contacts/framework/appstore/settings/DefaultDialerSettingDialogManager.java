package com.android.contacts.framework.appstore.settings;

import H0.d;
import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.b;
import androidx.lifecycle.InterfaceC0480c;
import androidx.lifecycle.InterfaceC0492o;
import com.android.contacts.framework.api.appstore.appinfo.a;
import com.android.contacts.framework.appstore.settings.DefaultDialerSettingDialogManager;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import kotlin.jvm.internal.i;

/* compiled from: DefaultDialerSettingDialogManager.kt */
/* loaded from: classes.dex */
public final class DefaultDialerSettingDialogManager {

    /* renamed from: a, reason: collision with root package name */
    public static final DefaultDialerSettingDialogManager f15648a = new DefaultDialerSettingDialogManager();

    /* renamed from: b, reason: collision with root package name */
    public static b f15649b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.android.contacts.framework.appstore.settings.DefaultDialerSettingDialogManager$showChangeDefaultDialerDialog$observer$1, androidx.lifecycle.n] */
    public static final void d(final AppCompatActivity activity) {
        i.f(activity, "activity");
        b bVar = f15649b;
        if (bVar != null) {
            if (bVar.isShowing()) {
                bVar.dismiss();
            }
            f15649b = null;
        }
        final ?? r02 = new InterfaceC0480c() { // from class: com.android.contacts.framework.appstore.settings.DefaultDialerSettingDialogManager$showChangeDefaultDialerDialog$observer$1
            @Override // androidx.lifecycle.InterfaceC0480c
            public void onDestroy(InterfaceC0492o owner) {
                i.f(owner, "owner");
                super.onDestroy(owner);
                b c10 = DefaultDialerSettingDialogManager.f15648a.c();
                if (c10 != null) {
                    c10.dismiss();
                }
                AppCompatActivity.this.getLifecycle().d(this);
            }
        };
        activity.getLifecycle().a(r02);
        b show = new COUIAlertDialogBuilder(activity).setTitle((CharSequence) activity.getString(d.f1221i)).setMessage((CharSequence) activity.getString(d.f1219g)).setNegativeButton(d.f1214b, (DialogInterface.OnClickListener) null).setPositiveButton(d.f1222j, new DialogInterface.OnClickListener() { // from class: L0.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                DefaultDialerSettingDialogManager.e(AppCompatActivity.this, dialogInterface, i10);
            }
        }).show();
        show.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: L0.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DefaultDialerSettingDialogManager.f(AppCompatActivity.this, r02, dialogInterface);
            }
        });
        f15649b = show;
    }

    public static final void e(AppCompatActivity activity, DialogInterface dialogInterface, int i10) {
        i.f(activity, "$activity");
        a.m(activity);
    }

    public static final void f(AppCompatActivity activity, DefaultDialerSettingDialogManager$showChangeDefaultDialerDialog$observer$1 observer, DialogInterface dialogInterface) {
        i.f(activity, "$activity");
        i.f(observer, "$observer");
        activity.getLifecycle().d(observer);
        f15649b = null;
    }

    public final b c() {
        return f15649b;
    }
}
