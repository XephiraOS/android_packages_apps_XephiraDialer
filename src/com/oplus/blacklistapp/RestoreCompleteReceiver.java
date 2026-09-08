package com.oplus.blacklistapp;

import F6.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.oplus.utils.C0846g;
import v6.C1632f;

/* compiled from: RestoreCompleteReceiver.kt */
/* loaded from: classes3.dex */
public final class RestoreCompleteReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final a f26248a = new a(null);

    /* compiled from: RestoreCompleteReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        a.C0017a c0017a = F6.a.f997a;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (c0017a.p(str)) {
            boolean z10 = androidx.preference.j.b(context).getBoolean("has_restore_settings_data", false);
            C0846g.i("RestoreCompleteReceiver", "backup and restore complete, start update intercept rule sHasRestoreSettingsData = " + z10);
            if (!z10) {
                C1632f.n0(context);
            }
        }
    }
}
