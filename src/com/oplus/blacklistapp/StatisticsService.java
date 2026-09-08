package com.oplus.blacklistapp;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.IBinder;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import android.util.Log;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.blacklistapp.callintercept.policy.d;
import com.oplus.blacklistapp.callintercept.settings.MarkNumberThresholdUtil;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0855p;
import com.oplus.utils.D;
import com.oplus.utils.StatisticsUtils;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import v6.C1627a;
import v6.C1632f;

/* loaded from: classes3.dex */
public class StatisticsService extends Service {

    /* renamed from: b, reason: collision with root package name */
    public static final String f26249b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f26250c;

    /* renamed from: d, reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f26251d;

    /* renamed from: e, reason: collision with root package name */
    public static ThreadPoolExecutor f26252e;

    /* renamed from: f, reason: collision with root package name */
    public static String[] f26253f;

    /* renamed from: a, reason: collision with root package name */
    public List<SubscriptionInfo> f26254a;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StatisticsService statisticsService = StatisticsService.this;
            statisticsService.f26254a = C1632f.i(statisticsService.getApplicationContext());
            Cursor cursor = null;
            try {
                try {
                    cursor = StatisticsService.this.getContentResolver().query(C0855p.a.f29171a, C0855p.a.f29174d, "list_type=?  OR list_type=?", new String[]{String.valueOf(1), "3"}, null);
                    if (cursor != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("blacklist_count", Integer.valueOf(cursor.getCount()));
                        StatisticsUtils.a(StatisticsService.this.getBaseContext(), 2010802, 201080001, hashMap, false);
                    }
                } catch (Exception e10) {
                    Log.e("BlacklistApp_StatisticsService", "" + e10);
                }
                StatisticsService.this.m();
                StatisticsService.this.i();
                StatisticsService.this.j();
                StatisticsService.this.k();
                StatisticsService.this.l();
                StatisticsService.this.stopSelf();
            } finally {
                I9.a.a(cursor);
            }
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        String str = com.oplus.blacklist.database.a.f26232a;
        sb.append(str);
        sb.append("/area_list");
        f26249b = sb.toString();
        f26250c = "content://" + str + "/bl_area_for_country";
        f26251d = new LinkedBlockingQueue<>();
        f26252e = new ThreadPoolExecutor(1, 5, 180L, TimeUnit.SECONDS, f26251d);
        f26253f = new String[]{C1632f.f37455i, C1632f.f37456j, C1632f.f37457k, C1632f.f37458l};
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x01e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.StatisticsService.i():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004d, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006e, code lost:
    
        r2 = getContentResolver().query(android.net.Uri.parse("content://message-external/blocked_conversations"), new java.lang.String[]{com.android.incallui.OplusNumberMarkUtils.OplusBlacklist.BLOCK_TYPE}, null, null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0085, code lost:
    
        if (r2 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0087, code lost:
    
        r1 = r2.getCount();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008b, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b4, code lost:
    
        r0 = new java.util.HashMap();
        r0.put("block_message_conversation_list", java.lang.Integer.valueOf(r1));
        r0.put("block_calllog_list", java.lang.Integer.valueOf(r4));
        com.oplus.utils.StatisticsUtils.a(getBaseContext(), 2010802, 201081005, r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d8, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0091, code lost:
    
        r5 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009d, code lost:
    
        android.util.Log.e("BlacklistApp_StatisticsService", "blockMessageItemCursor " + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b1, code lost:
    
        if (r2 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0096, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0093, code lost:
    
        r5 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0094, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d9, code lost:
    
        if (r2 != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00db, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00de, code lost:
    
        throw r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006b, code lost:
    
        if (r1 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004b, code lost:
    
        if (r1 != null) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e1  */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.StatisticsService.j():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
    
        if (r4 == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
    
        if (r4 == 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k() {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.StatisticsService.k():void");
    }

    public final void l() {
        String str;
        List<SubscriptionInfo> list = this.f26254a;
        if (list == null) {
            C0846g.i("BlacklistApp_StatisticsService", "active sim list is null, return");
            return;
        }
        int size = list.size();
        if (size != 0 && size <= 2) {
            if (size == 1) {
                SubscriptionInfo subscriptionInfo = this.f26254a.get(0);
                if (subscriptionInfo == null) {
                    C0846g.i("BlacklistApp_StatisticsService", "subInfo is null, return");
                    return;
                }
                int simSlotIndex = subscriptionInfo.getSimSlotIndex();
                HashMap<String, String> p10 = p(simSlotIndex, size);
                if (simSlotIndex == 0) {
                    str = "1_1";
                } else {
                    str = "1_2";
                }
                p10.put("SIM_select", str);
                Log.d("BlacklistApp_StatisticsService", "addCommonUserActionForHarassInterceptRule: map = " + p10.toString());
                StatisticsUtils.a(getBaseContext(), 2010804, 201082007, p10, false);
                return;
            }
            HashMap<String, String> p11 = p(0, size);
            p11.put("SIM_select", "2_1");
            Log.d("BlacklistApp_StatisticsService", "addCommonUserActionForHarassInterceptRule: sim1Map = " + p11.toString());
            StatisticsUtils.a(getBaseContext(), 2010804, 201082007, p11, false);
            HashMap<String, String> p12 = p(1, size);
            p12.put("SIM_select", "2_2");
            Log.d("BlacklistApp_StatisticsService", "addCommonUserActionForHarassInterceptRule: sim2Map = " + p12.toString());
            StatisticsUtils.a(getBaseContext(), 2010804, 201082007, p12, false);
            return;
        }
        C0846g.i("BlacklistApp_StatisticsService", "simSize is zero or more than two, return");
    }

    public final void m() {
        String str;
        if (!C0844e.f(getApplicationContext())) {
            C0846g.i("BlacklistApp_StatisticsService", "can not show nation anti fraud , return");
            return;
        }
        HashMap hashMap = new HashMap();
        if (D.a(getApplicationContext())) {
            str = "on";
        } else {
            str = "off";
        }
        hashMap.put("fraud_interception_service", str);
        StatisticsUtils.a(getBaseContext(), 2010802, 201080017, hashMap, false);
    }

    public final void n() {
        f26252e.execute(new a());
    }

    public final void o(int i10, d.e eVar, StringBuilder sb, StringBuilder sb2) {
        String str;
        if (eVar.f26691e) {
            sb.append(",all_block_call");
        }
        if (eVar.f26690d) {
            sb.append(",unknown_block_call");
        }
        if (eVar.f26687a) {
            sb.append(",one_ring_block_call");
        }
        if (eVar.f26688b) {
            sb.append(",private_numbers_block_call");
        }
        if (eVar.f26693g) {
            sb.append(",mark_number_block_call");
        }
        Cursor cursor = null;
        try {
            try {
                if (!l7.b.f34737e) {
                    str = f26249b;
                } else {
                    str = f26250c;
                }
                Uri parse = Uri.parse(str);
                ContentResolver contentResolver = getApplicationContext().getContentResolver();
                StringBuilder sb3 = new StringBuilder();
                if (i10 != -1) {
                    sb3.append("slot_id ='");
                    sb3.append(i10);
                    sb3.append("'");
                }
                cursor = contentResolver.query(parse, null, sb3.toString(), null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    sb.append(",region_block_call");
                    cursor.moveToPosition(-1);
                    if (l7.b.f34735c) {
                        sb2.append("city_list");
                        while (true) {
                            if (!cursor.moveToNext()) {
                                break;
                            } else if (cursor.getLong(cursor.getColumnIndex("area_id")) == Long.parseLong("-4")) {
                                sb2.append(",other");
                                break;
                            }
                        }
                    } else {
                        sb2.append("country_list");
                        while (true) {
                            if (!cursor.moveToNext()) {
                                break;
                            } else if (TextUtils.equals(cursor.getString(cursor.getColumnIndex("country_code")), "OTHERS")) {
                                sb2.append(",other");
                                break;
                            }
                        }
                    }
                }
                if (cursor == null) {
                    return;
                }
            } catch (SQLiteException e10) {
                C1627a.h("BlacklistApp_StatisticsService", "Catch a SQLiteException when query: " + e10);
                if (0 == 0) {
                    return;
                }
            } catch (Exception e11) {
                C1627a.h("BlacklistApp_StatisticsService", "run: " + e11);
                if (0 == 0) {
                    return;
                }
            }
            cursor.close();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i10) {
        super.onStart(intent, i10);
        n();
    }

    public final HashMap<String, String> p(int i10, int i11) {
        HashMap<String, String> hashMap = new HashMap<>();
        d.e b02 = C1632f.b0(getApplicationContext(), i10, false);
        if (i11 == 2 && i10 == 1 && C1632f.B(getApplicationContext(), C1632f.f37454h, 3, i10)) {
            hashMap.put("block_way", "consistent_with_SIM1");
            return hashMap;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        o(i10, b02, sb, sb3);
        s(i10, sb2);
        w(sb);
        w(sb2);
        hashMap.put("block_way", sb.toString());
        hashMap.put("release_rule", sb2.toString());
        hashMap.put("region_block_rule", sb3.toString());
        if (b02.f26693g) {
            StringBuilder sb4 = new StringBuilder();
            r(i10, sb4);
            w(sb4);
            hashMap.put("mark_number_rule", sb4.toString());
        }
        return hashMap;
    }

    public final String q(int i10) {
        if (i10 == 50) {
            return OplusPhoneUtils.DeviceState.LOCK_DEVICE;
        }
        if (i10 == 25) {
            return "2";
        }
        return "3";
    }

    public final void r(int i10, StringBuilder sb) {
        if (C1632f.B(getApplicationContext(), C1632f.f37455i, 3, i10)) {
            sb.append(",scam");
        }
        if (C1632f.B(getApplicationContext(), C1632f.f37456j, 0, i10)) {
            sb.append(",nuisance");
        }
        if (C1632f.B(getApplicationContext(), C1632f.f37457k, 0, i10)) {
            sb.append(",telemarketing");
        }
        if (C1632f.B(getApplicationContext(), C1632f.f37458l, 0, i10)) {
            sb.append(",real_estate_agent");
        }
        int c10 = MarkNumberThresholdUtil.c(MarkNumberThresholdUtil.d(i10, getApplicationContext()));
        if (c10 == 1) {
            sb.append(",high");
        } else if (c10 == 20) {
            sb.append(",medium");
        } else if (c10 == 50) {
            sb.append(",low");
        }
    }

    public final void s(int i10, StringBuilder sb) {
        SharedPreferences b10 = androidx.preference.j.b(getApplicationContext());
        if (C1632f.C(b10, "auto_open_and_close", 0, i10)) {
            sb.append(",schedule_blocking");
        }
        if (C1632f.C(b10, "not_intercept_repeat_call", 0, i10)) {
            sb.append(",do_not_block_repeated_calls");
        }
        if (C1632f.C(b10, "not_intercept_credible_strangers", 3, i10)) {
            sb.append(",do_not_block_special_numbers");
        }
    }

    public final String t(String str) {
        if (C1632f.f37455i.equals(str)) {
            return "scam";
        }
        if (C1632f.f37456j.equals(str)) {
            return "nuisance";
        }
        if (C1632f.f37457k.equals(str)) {
            return "telemarketing";
        }
        return "real_estate_agent";
    }

    public final /* synthetic */ Integer u() {
        return Integer.valueOf(z6.b.b(this, 1, C1632f.f37468v));
    }

    public final /* synthetic */ Integer v() {
        return Integer.valueOf(z6.b.b(this, 1, C1632f.f37469w));
    }

    public final void w(StringBuilder sb) {
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
    }
}
