package com.customize.contacts.util;

import F0.c;
import R0.c;
import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.CallLog;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import com.oplus.foundation.util.io.CloseableUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: InterceptUtils.java */
/* loaded from: classes3.dex */
public class J {

    /* renamed from: c, reason: collision with root package name */
    public static final String f21899c = com.android.contacts.compat.data.f.a("oplus_customize_harass_intercept_mark_number_enbale");

    /* renamed from: d, reason: collision with root package name */
    public static int f21900d;

    /* renamed from: a, reason: collision with root package name */
    public Handler f21901a = null;

    /* renamed from: b, reason: collision with root package name */
    public HandlerThread f21902b = null;

    /* compiled from: InterceptUtils.java */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21903a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f21904b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f21905c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f21906d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f21907e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f21908f;

        public a(Context context, String str, int i10, long j10, int i11, String str2) {
            this.f21903a = context;
            this.f21904b = str;
            this.f21905c = i10;
            this.f21906d = j10;
            this.f21907e = i11;
            this.f21908f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            J.f21900d--;
            if (this.f21903a == null) {
                H7.b.b("CallogInterceptUtils", "context is null");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f21904b);
            if (BlackListUtils.d(this.f21903a, arrayList).get("isWhiteList").booleanValue()) {
                if (H7.a.b()) {
                    H7.b.b("CallogInterceptUtils", "the number " + H7.a.d(this.f21904b) + " in white list.");
                    return;
                }
                return;
            }
            if (B3.a.u()) {
                E0.b.F(new c.a().h(this.f21904b).c(Integer.valueOf(this.f21905c)).e(Long.valueOf(this.f21906d)).j(0).i(Long.valueOf(System.currentTimeMillis())).k(Integer.valueOf(this.f21907e)).f(Boolean.TRUE).b(Boolean.valueOf(C0801l.o(this.f21905c))).a());
            }
            int o10 = E0.b.o(this.f21904b);
            int m10 = E0.b.m(this.f21904b);
            int slotIndex = SubscriptionManager.getSlotIndex(this.f21907e);
            int h10 = J.h(this.f21903a, slotIndex, o10, m10);
            if (H7.a.b()) {
                H7.b.b("CallogInterceptUtils", "number = " + H7.a.d(this.f21904b) + " ,markType = " + o10 + " ,markCount = " + m10 + " ,slotId = " + slotIndex + " ,blockType = " + h10);
            }
            if (h10 != -1 && OplusPhoneUtils.DeviceState.LOCK_DEVICE.equals(this.f21908f)) {
                if (this.f21905c == 3) {
                    Context context = this.f21903a;
                    String str = c.a.f3195a;
                    int d10 = G0.c.d(context, 0, str, 0);
                    if (d10 > 0) {
                        d10--;
                    }
                    com.oplus.foundation.util.ui.a.a(this.f21903a, d10);
                    G0.c.n(this.f21903a, 0, str, d10);
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("cancel_calls_notifications", new String[]{this.f21904b});
                    com.android.contacts.framework.api.appstore.missedcall.a.b(this.f21903a, bundle);
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(OplusAutoRedialNotificationUI.TYPE, Integer.valueOf(h10));
                    this.f21903a.getContentResolver().update(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, contentValues, "number = ? AND " + OplusAutoRedialNotificationUI.TYPE + " != ?" + C0801l.b(this.f21905c) + " AND simid = ?", new String[]{this.f21904b, Integer.toString(2), Integer.toString(this.f21907e)});
                } catch (Exception e10) {
                    H7.b.c("CallogInterceptUtils", "Exception e: " + e10);
                }
                J.f(slotIndex, this.f21904b, o10, m10, this.f21908f);
                if (J.this.f21902b != null) {
                    J.this.f21902b.quit();
                    J.this.f21902b = null;
                    return;
                }
                return;
            }
            if (J.f21900d > 0) {
                if (H7.a.b()) {
                    H7.b.b("CallogInterceptUtils", "---after 1 second will queryTedMarkInfo again---");
                }
                J.this.f21901a.postDelayed(this, 1200L);
            } else {
                if (h10 != -1) {
                    J.f(slotIndex, this.f21904b, o10, m10, this.f21908f);
                }
                if (J.this.f21902b != null) {
                    J.this.f21902b.quit();
                    J.this.f21902b = null;
                }
            }
        }
    }

    public static void f(int i10, String str, int i11, int i12, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("volte", String.valueOf(b0.A0(i10)));
        hashMap.put("number", String.valueOf(H7.a.d(str)));
        hashMap.put("markType", String.valueOf(i11));
        hashMap.put("markCount", String.valueOf(i12));
        hashMap.put("slotId", String.valueOf(i10));
        hashMap.put("hasRecog", String.valueOf(str2));
        com.android.contacts.framework.baseui.util.A.a(P7.a.f2962b, 2000320, 200034801, hashMap, false);
    }

    public static int g(Context context, int i10) {
        String str;
        if (context == null) {
            return 0;
        }
        if (i10 == 0) {
            str = c.a.f3208n;
        } else {
            str = c.a.f3209o;
        }
        int d10 = G0.c.d(context, 1, str, 0);
        if (H7.a.b()) {
            H7.b.b("CallogInterceptUtils", "getMarkNumberThreshold " + str + " threshold = " + d10);
        }
        return d10;
    }

    public static int h(Context context, int i10, int i11, int i12) {
        int i13;
        int i14;
        if (H7.a.b()) {
            H7.b.b("CallogInterceptUtils", "isBlockedByMarkNumberInfo slotId = " + i10 + "  markInfoType = " + i11);
        }
        if (i12 > 0 && k(i11)) {
            if (i10 == 1 && j(context, c.a.f3203i, 3, i10)) {
                if (H7.a.b()) {
                    H7.b.b("CallogInterceptUtils", "readBlockSettings useSim1RulesOn need change slot id to 0");
                }
                i10 = 0;
            }
            String str = null;
            if (OsUtils.k()) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("harass_intercept_marked_number", 0);
                    ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(com.android.contacts.framework.api.appstore.appinfo.a.e());
                    if (acquireContentProviderClient != null) {
                        try {
                            if (!i(acquireContentProviderClient.call(com.android.contacts.framework.api.appstore.appinfo.a.e(), "get_property", null, bundle).getInt("harass_intercept_marked_number", 3), i10)) {
                                if (H7.a.b()) {
                                    H7.b.b("CallogInterceptUtils", "intercept mark number switch not open");
                                }
                                CloseableUtils.a(acquireContentProviderClient);
                                return -1;
                            }
                        } catch (Throwable th) {
                            if (acquireContentProviderClient != null) {
                                CloseableUtils.a(acquireContentProviderClient);
                            }
                            throw th;
                        }
                    }
                    if (acquireContentProviderClient != null) {
                        CloseableUtils.a(acquireContentProviderClient);
                    }
                } catch (Throwable th2) {
                    H7.b.c("CallogInterceptUtils", "read INTERCEPT_SP_KEY_MARKED_NUMBER error : " + th2);
                }
            }
            if (!j(context, f21899c, 3, i10)) {
                return -1;
            }
            if (i11 != 1) {
                if (i11 != 14) {
                    if (i11 != 3) {
                        if (i11 != 4) {
                            if (i11 != 5) {
                                i13 = -1;
                            } else {
                                str = c.a.f3207m;
                                i13 = 53;
                            }
                        } else {
                            str = c.a.f3205k;
                            i13 = 51;
                        }
                    } else {
                        str = c.a.f3204j;
                        i13 = 50;
                    }
                } else {
                    i13 = 49;
                }
            } else {
                str = c.a.f3206l;
                i13 = 52;
            }
            if (!TextUtils.isEmpty(str)) {
                if (j(context, str, 0, i10)) {
                    i14 = g(context, i10);
                } else {
                    i14 = -1;
                }
                if (H7.a.b()) {
                    H7.b.b("CallogInterceptUtils", "isBlockedByMarkNumberInfo threshold = " + i14 + "  markInfoCount = " + i12);
                }
                if (i14 != -1 && i12 >= i14) {
                    return i13;
                }
            } else if (i11 == 14) {
                return i13;
            }
        }
        return -1;
    }

    public static boolean i(int i10, int i11) {
        boolean z10 = false;
        if (i11 != 0 ? (i10 & 2) == 2 : (i10 & 1) == 1) {
            z10 = true;
        }
        if (H7.a.b()) {
            H7.b.b("CallogInterceptUtils", "isHarassIntercepOpen " + z10);
        }
        return z10;
    }

    public static boolean j(Context context, String str, int i10, int i11) {
        if (context == null) {
            return false;
        }
        int d10 = G0.c.d(context, 1, str, i10);
        boolean i12 = i(d10, i11);
        if (H7.a.b()) {
            H7.b.b("CallogInterceptUtils", "isHarassInterceptOpen key = " + str + " keyValue =  " + d10 + " isOpen = " + i12);
        }
        return i12;
    }

    public static boolean k(int i10) {
        if (1 == i10 || 3 == i10 || 4 == i10 || 5 == i10 || 14 == i10) {
            return true;
        }
        return false;
    }

    public static boolean l(int i10) {
        if (3 != i10 && 12 != i10 && 14 != i10) {
            return false;
        }
        return true;
    }

    public static boolean m(String str, int i10, int i11) {
        if (H7.a.b()) {
            H7.b.b("CallogInterceptUtils", "needShowHeaderTips hasRecog = " + str + " tagIndex = " + i10 + " callType = " + i11);
        }
        if (OplusPhoneUtils.DeviceState.UNLOCK_DEVICE.equals(str) && i10 == 3 && i11 != 3) {
            return true;
        }
        return false;
    }

    public static boolean n(String str) {
        return !OplusPhoneUtils.DeviceState.UNLOCK_DEVICE.equals(str);
    }

    public static boolean o(String str, boolean z10, int i10, int i11) {
        if (H7.a.b()) {
            H7.b.b("CallogInterceptUtils", "needShowTedTag hasRecog = " + str + " isCustomMark = " + z10 + " tagIndex = " + i10 + " callType = " + i11);
        }
        if (!z10 && OplusPhoneUtils.DeviceState.UNLOCK_DEVICE.equals(str) && i10 != 3 && i11 != 3) {
            return false;
        }
        return true;
    }

    public static boolean r(Context context, int i10, int i11) {
        if (VirtualSupportUtils.m() || !b0.l0(context)) {
            return false;
        }
        if (s(context, i11)) {
            i11 = 0;
        }
        if ((i10 != 3 || j(context, c.a.f3204j, 3, i11)) && ((i10 != 4 || j(context, c.a.f3205k, 0, i11)) && ((i10 != 1 || j(context, c.a.f3206l, 0, i11)) && (i10 != 5 || j(context, c.a.f3207m, 0, i11))))) {
            return false;
        }
        return true;
    }

    public static boolean s(Context context, int i10) {
        if (i10 != 1) {
            return true;
        }
        return j(context, c.a.f3203i, 3, i10);
    }

    public void p(Context context, String str, int i10, int i11, long j10, long j11, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !C0801l.o(i11) && i11 != 2) {
            a aVar = new a(context, str, i11, j10, i10, str2);
            if (this.f21902b == null || this.f21901a == null) {
                HandlerThread handlerThread = new HandlerThread("RequeryTedMarkInfo");
                this.f21902b = handlerThread;
                handlerThread.start();
                this.f21901a = new Handler(this.f21902b.getLooper());
            }
            this.f21901a.postDelayed(aVar, 100L);
        }
    }

    public void q() {
        f21900d = 2;
    }
}
