package com.customize.contacts;

import H7.a;
import H7.b;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.preference.PreferenceManager;
import com.android.contacts.ContactShortcuts;
import com.android.contacts.compat.data.f;
import com.android.contacts.framework.baseui.calllog.d;
import com.android.contacts.framework.baseui.util.A;
import com.customize.contacts.util.C0801l;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class StatisticsService extends IntentService {
    public StatisticsService() {
        super("StatisticsService");
    }

    public static boolean d(Context context) {
        boolean z10;
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        if (!defaultSharedPreferences.getString("QUERY_DAY", "").equals(format)) {
            edit.putString("QUERY_DAY", format);
            edit.apply();
            z10 = true;
        } else {
            z10 = false;
        }
        if (a.b()) {
            b.b("StatisticsService", "should notify = " + z10);
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x020b A[Catch: all -> 0x026f, TRY_ENTER, TryCatch #6 {all -> 0x026f, blocks: (B:60:0x020b, B:63:0x0274, B:65:0x02ac, B:67:0x02b2, B:68:0x02bc, B:72:0x02d8, B:73:0x02e4, B:75:0x030a, B:77:0x0310, B:78:0x031a, B:82:0x0336, B:83:0x0342, B:85:0x0368, B:87:0x036e, B:88:0x0374, B:90:0x038c, B:93:0x0394, B:94:0x03ad, B:99:0x03ba, B:100:0x03c9), top: B:58:0x0209 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0274 A[Catch: all -> 0x026f, TryCatch #6 {all -> 0x026f, blocks: (B:60:0x020b, B:63:0x0274, B:65:0x02ac, B:67:0x02b2, B:68:0x02bc, B:72:0x02d8, B:73:0x02e4, B:75:0x030a, B:77:0x0310, B:78:0x031a, B:82:0x0336, B:83:0x0342, B:85:0x0368, B:87:0x036e, B:88:0x0374, B:90:0x038c, B:93:0x0394, B:94:0x03ad, B:99:0x03ba, B:100:0x03c9), top: B:58:0x0209 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03b6 A[LOOP:4: B:88:0x0374->B:96:0x03b6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03b3 A[EDGE_INSN: B:97:0x03b3->B:98:0x03b3 BREAK  A[LOOP:4: B:88:0x0374->B:96:0x03b6], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 1381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.StatisticsService.a():void");
    }

    public final Cursor b() {
        return getContentResolver().query(Uri.parse("content://call_log/" + f.c("calls_with_normalized")).buildUpon().appendQueryParameter("limit", R0.b.f3167a).build(), d.a(), C0801l.f(), null, null);
    }

    public final void c() {
        ContactShortcuts.a C10 = ContactShortcuts.f13087j.C();
        if (C10 == null) {
            b.i("StatisticsService", "contactShortCount is null");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("count_shotcuts_detail", Integer.valueOf(C10.b()));
        hashMap.put("count_shotcuts_call", Integer.valueOf(C10.a()));
        A.a(getApplicationContext(), 2000309, 200032617, hashMap, false);
        b.e("StatisticsService", "contactShortCount : " + C10);
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        b.b("StatisticsService", "StatisticsService onStart");
        if (B3.a.u()) {
            E0.b.a();
        }
        a();
    }
}
