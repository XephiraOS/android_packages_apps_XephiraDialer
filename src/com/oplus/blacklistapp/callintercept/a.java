package com.oplus.blacklistapp.callintercept;

import F6.e;
import android.content.Context;
import android.util.Log;
import com.oplus.blacklistapp.callintercept.settings.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: CrossProcessDataStructureSet.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f26566a = e.c();

    /* renamed from: b, reason: collision with root package name */
    public static final String f26567b = e.d();

    /* renamed from: c, reason: collision with root package name */
    public static final String f26568c = e.O();

    /* renamed from: d, reason: collision with root package name */
    public static final String f26569d = e.U();

    /* renamed from: e, reason: collision with root package name */
    public static final String f26570e = e.W();

    /* renamed from: f, reason: collision with root package name */
    public static final String f26571f = e.Q();

    /* renamed from: g, reason: collision with root package name */
    public static final String f26572g = e.S();

    /* renamed from: h, reason: collision with root package name */
    public static final String f26573h = e.P();

    /* renamed from: i, reason: collision with root package name */
    public static final String f26574i = e.V();

    /* renamed from: j, reason: collision with root package name */
    public static final String f26575j = e.X();

    /* renamed from: k, reason: collision with root package name */
    public static final String f26576k = e.R();

    /* renamed from: l, reason: collision with root package name */
    public static final String f26577l = e.T();

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f26578m = {1, 2, 4, 8, 16, 32, 64};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f26579n = {1, 2, 4, 8, 16, 32, 64};

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f26580o = {1, 2, 3, 4, 5, 6, 7};

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f26581p = {1, 2, 3, 4, 5, 6, 7};

    public static int a(int i10, int i11, boolean z10) {
        if (z10) {
            return i10 | i11;
        }
        return i10 & (~i11);
    }

    public static int b(int i10) {
        int i11 = i10 - 1;
        int i12 = 0;
        while (true) {
            int[] iArr = f26580o;
            if (i12 < iArr.length) {
                if (i10 == iArr[i12]) {
                    return i12;
                }
                i12++;
            } else {
                return i11;
            }
        }
    }

    public static int c(ArrayList<Integer> arrayList) {
        int i10 = 0;
        if (arrayList != null) {
            try {
                if (arrayList.size() != 0) {
                    Iterator<Integer> it = arrayList.iterator();
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        if (intValue >= 1) {
                            int[] iArr = f26578m;
                            if (intValue <= iArr.length) {
                                i10 |= iArr[b(intValue)];
                            }
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
                Log.w("CrossProcessDataStructureSet", "getFlagFromScheduleDays ArrayIndexOutOfBoundsException ");
            }
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d(int r0) {
        /*
            if (r0 == 0) goto L5e
            switch(r0) {
                case 20: goto L5b;
                case 21: goto L58;
                case 22: goto L55;
                case 23: goto L52;
                case 24: goto L4f;
                case 25: goto L4c;
                case 26: goto L49;
                case 27: goto L46;
                case 28: goto L3a;
                case 29: goto L31;
                case 30: goto L28;
                case 31: goto L25;
                case 32: goto L22;
                default: goto L5;
            }
        L5:
            switch(r0) {
                case 49: goto L1f;
                case 50: goto L1c;
                case 51: goto L19;
                case 52: goto L16;
                case 53: goto L13;
                case 54: goto L10;
                case 55: goto Ld;
                case 56: goto L9;
                default: goto L8;
            }
        L8:
            goto L43
        L9:
            java.lang.String r0 = "nation_anti_fraud_number"
            goto L60
        Ld:
            java.lang.String r0 = "ride_mode"
            goto L60
        L10:
            java.lang.String r0 = "smart_drive"
            goto L60
        L13:
            java.lang.String r0 = "intermediary"
            goto L60
        L16:
            java.lang.String r0 = "advertisement"
            goto L60
        L19:
            java.lang.String r0 = "harassment"
            goto L60
        L1c:
            java.lang.String r0 = "fraud"
            goto L60
        L1f:
            java.lang.String r0 = "criminal"
            goto L60
        L22:
            java.lang.String r0 = "unblock_vip_normal"
            goto L60
        L25:
            java.lang.String r0 = "unblock_vip_penetrate_all"
            goto L60
        L28:
            boolean r0 = l7.b.o()
            if (r0 == 0) goto L43
            java.lang.String r0 = "payphone_number"
            goto L60
        L31:
            boolean r0 = l7.b.o()
            if (r0 == 0) goto L43
            java.lang.String r0 = "unrecognized_number"
            goto L60
        L3a:
            boolean r0 = l7.b.o()
            if (r0 == 0) goto L43
            java.lang.String r0 = "anonymous_number"
            goto L60
        L43:
            java.lang.String r0 = "unKnow_type"
            goto L60
        L46:
            java.lang.String r0 = "black_list"
            goto L60
        L49:
            java.lang.String r0 = "all_calls"
            goto L60
        L4c:
            java.lang.String r0 = "all_strangers"
            goto L60
        L4f:
            java.lang.String r0 = "attribution"
            goto L60
        L52:
            java.lang.String r0 = "old_advertisement"
            goto L60
        L55:
            java.lang.String r0 = "UNKNOW_NUMBER"
            goto L60
        L58:
            java.lang.String r0 = "stranger_number"
            goto L60
        L5b:
            java.lang.String r0 = "delay_ring"
            goto L60
        L5e:
            java.lang.String r0 = "unblock_normal"
        L60:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.a.d(int):java.lang.String");
    }

    public static ArrayList<Integer> e(int i10) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i11 = 0;
        while (true) {
            try {
                int[] iArr = f26578m;
                if (i11 >= iArr.length) {
                    break;
                }
                int i12 = iArr[i11];
                if ((i10 & i12) == i12) {
                    arrayList.add(Integer.valueOf(f26580o[i11]));
                }
                i11++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                Log.w("CrossProcessDataStructureSet", "getScheduleDaysFromFlag ArrayIndexOutOfBoundsException ");
                return null;
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public static HashMap<String, String> f(Context context, boolean z10, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (context == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("slot_id", String.valueOf(i10));
        hashMap.put("blocked_all_incoming", String.valueOf(z10));
        if (z10) {
            str = f26566a;
            str2 = f26568c + i10;
            str3 = f26569d + i10;
            str4 = f26570e + i10;
            str5 = f26571f + i10;
            str6 = f26572g + i10;
        } else {
            str = f26567b;
            str2 = f26573h + i10;
            str3 = f26574i + i10;
            str4 = f26575j + i10;
            str5 = f26576k + i10;
            str6 = f26577l + i10;
        }
        int c10 = z6.b.c(context, 1, str, 0);
        int c11 = z6.b.c(context, 1, str2, 65);
        int c12 = z6.b.c(context, 1, str3, 23);
        int c13 = z6.b.c(context, 1, str4, 0);
        String str7 = c12 + " : " + c13;
        String str8 = z6.b.c(context, 1, str5, 8) + " : " + z6.b.c(context, 1, str6, 0);
        ArrayList<Integer> e10 = e(c11);
        boolean a10 = u.a(i10, c10);
        if (e10 != null) {
            String str9 = "";
            for (int i11 = 0; i11 < e10.size(); i11++) {
                str9 = str9 + e10.get(i11) + ",";
            }
            hashMap.put("day_of_week", str9);
        }
        hashMap.put("switch_record", String.valueOf(a10));
        hashMap.put("start_time", str7);
        hashMap.put("end_time", str8);
        return hashMap;
    }

    /* compiled from: CrossProcessDataStructureSet.java */
    /* renamed from: com.oplus.blacklistapp.callintercept.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0237a {

        /* renamed from: a, reason: collision with root package name */
        public int f26582a;

        /* renamed from: b, reason: collision with root package name */
        public long f26583b;

        /* renamed from: c, reason: collision with root package name */
        public int f26584c;

        public C0237a(int i10) {
            this.f26582a = i10;
            this.f26583b = -1L;
            this.f26584c = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("InterceptTactics{ ");
            sb.append("  Tactics: " + a.d(this.f26582a));
            sb.append("  PersonId: " + this.f26583b);
            sb.append("  TacticProperties: " + this.f26584c);
            sb.append(" }");
            return sb.toString();
        }

        public C0237a(int i10, long j10, int i11) {
            this.f26582a = i10;
            this.f26583b = j10;
            this.f26584c = i11;
        }
    }
}
