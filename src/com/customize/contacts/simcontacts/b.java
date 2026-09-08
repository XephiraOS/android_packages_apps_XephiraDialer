package com.customize.contacts.simcontacts;

import android.content.ContentUris;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.compat.data.f;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.c0;
import com.customize.contacts.util.h0;
import com.oplus.dialer.R;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import r0.C1498a;

/* compiled from: AutoSyncSimContactsUtils.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f21805a = f.c("sim_index");

    /* renamed from: b, reason: collision with root package name */
    public static boolean f21806b = false;

    /* renamed from: c, reason: collision with root package name */
    public static ScheduledExecutorService f21807c = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: d, reason: collision with root package name */
    public static boolean f21808d = true;

    public static boolean b(Context context, String str, int i10, long j10, String str2) {
        boolean g10 = b0.g(context, context.getContentResolver(), i10, b0.I0(context, j(str)));
        if (g10) {
            int c10 = G7.c.c(context.getContentResolver(), I3.c.e(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j10), null, null, true, str2), null, null);
            h0.m(context, str2, c10);
            if (c10 == 1) {
                g10 = true;
            } else {
                g10 = false;
            }
        }
        H7.b.b("AutoSyncSimContactsUtils", "delete sim contact, accountName = " + str + ", simIndex = " + i10 + ", contactId = " + j10 + ", deleted = " + g10);
        return g10;
    }

    public static String c(Context context) {
        return context.getString(R.string.oplus_storage_sim);
    }

    public static String d(Context context, String str) {
        return c0.r(context, j(str));
    }

    public static boolean e() {
        return f21808d;
    }

    public static String f(Context context, int i10) {
        boolean T10;
        boolean z10 = false;
        if (B3.a.i()) {
            T10 = b0.u0(context, 0);
            z10 = b0.u0(context, 1);
        } else {
            T10 = b0.T(context);
        }
        if (T10 && z10) {
            return String.format("%s %d", "SIM", Integer.valueOf(i10 + 1));
        }
        return c(context);
    }

    public static String g(int i10) {
        if (B3.a.i()) {
            if (i10 == 1) {
                return "SIM2";
            }
            return "SIM1";
        }
        return "SIM";
    }

    public static String h(Context context, String str) {
        if (b0.h() == 1) {
            return context.getString(R.string.adn_dialog_title);
        }
        if (b0.h() == 2) {
            return context.getString(R.string.sim_card_contact_label, Integer.valueOf(j(str) + 1));
        }
        if (b0.j() == 1) {
            return context.getString(R.string.adn_dialog_title);
        }
        if (b0.j() == 2) {
            return context.getString(R.string.sim_card_contact_label, Integer.valueOf(j(str) + 1));
        }
        return "";
    }

    public static String i(Context context, int i10) {
        String[] J10;
        String str;
        String string = context.getString(R.string.sim_contact);
        if ((i10 == 0 || i10 == 1) && (str = (J10 = b0.J(context))[i10]) != null && str.length() > 0) {
            return J10[i10];
        }
        return string;
    }

    public static int j(String str) {
        if (!B3.a.i() || !TextUtils.equals(str, "SIM2")) {
            return 0;
        }
        return 1;
    }

    public static void k(final Context context) {
        if (FeatureOption.k() && PrimaryUserUtils.a()) {
            synchronized (b.class) {
                if (context != null) {
                    if (!f21806b) {
                        ScheduledExecutorService scheduledExecutorService = f21807c;
                        if (scheduledExecutorService != null) {
                            try {
                                scheduledExecutorService.schedule(new Runnable() { // from class: com.customize.contacts.simcontacts.a
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        b.l(context);
                                    }
                                }, 1000L, TimeUnit.MILLISECONDS);
                            } catch (Exception e10) {
                                H7.b.c("AutoSyncSimContactsUtils", "Exception when start initAutoSyncSimContacts task " + e10);
                                o();
                            }
                        }
                        return;
                    }
                }
                H7.b.b("AutoSyncSimContactsUtils", "the context is null or has init the sim contacts, return");
                return;
            }
        }
        H7.b.b("AutoSyncSimContactsUtils", "the FeatureOption.isSimContactsAutoSync() is false, we don't need to import sim contacts");
    }

    public static /* synthetic */ void l(Context context) {
        Process.setThreadPriority(10);
        m(context);
        H7.b.b("AutoSyncSimContactsUtils", "start the sim contacts load task");
        p(context);
        f21806b = true;
        o();
    }

    public static void m(Context context) {
        try {
            SimStateReceiver simStateReceiver = new SimStateReceiver();
            IntentFilter intentFilter = new IntentFilter();
            C0811w.j(context, simStateReceiver, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
            intentFilter.addAction("qualcomm.intent.action.ACTION_ADN_INIT_DONE");
            intentFilter.addAction("mediatek.intent.action.PHB_STATE_CHANGED");
            intentFilter.addAction("com.oplus.querySimCard");
            intentFilter.addAction(C1498a.f36264w);
            intentFilter.addAction(C1498a.f36265x);
            context.registerReceiver(simStateReceiver, intentFilter, R0.b.f3175i, null, 2);
        } catch (Exception e10) {
            H7.b.c("AutoSyncSimContactsUtils", "Exception in registerSimStateChangeReceiver when registerSimStateChangeReceiver " + e10);
        }
    }

    public static void n(boolean z10) {
        f21808d = z10;
    }

    public static void o() {
        ScheduledExecutorService scheduledExecutorService = f21807c;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
        f21807c = null;
    }

    public static void p(Context context) {
        if (context == null) {
            H7.b.b("AutoSyncSimContactsUtils", "the context is null, return from tryToImportSimContactsToDatabase");
            return;
        }
        c cVar = new c(context);
        cVar.n(0);
        cVar.n(1);
    }
}
