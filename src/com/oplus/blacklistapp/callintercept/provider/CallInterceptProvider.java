package com.oplus.blacklistapp.callintercept.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import android.telephony.SubscriptionInfo;
import androidx.preference.j;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusSpecialNumberUtils;
import com.google.gson.d;
import com.google.gson.e;
import com.oplus.blacklist.database.a;
import com.oplus.blacklistapp.callintercept.settings.MarkNumberThresholdUtil;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0848i;
import com.oplus.utils.S;
import com.ted.phonenumber.entrys.CallerIdItem$MarkerData;
import com.ted.phonenumber.entrys.RecognitionNumber;
import com.ted.phonenumber.entrys.RequestData;
import com.ted.phonenumber.service.INumListCallback;
import h9.C1087a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.o;
import kotlin.collections.p;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import u6.C1610a;
import v6.C1632f;

/* compiled from: CallInterceptProvider.kt */
/* loaded from: classes3.dex */
public final class CallInterceptProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final a f26748a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f26749b = {"number", OplusAutoRedialNotificationUI.TYPE};

    /* renamed from: c, reason: collision with root package name */
    public static final d f26750c;

    /* compiled from: CallInterceptProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: CallInterceptProvider.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f26751a;

        /* renamed from: b, reason: collision with root package name */
        public final long f26752b;

        /* renamed from: c, reason: collision with root package name */
        public final int f26753c;

        public b(int i10, long j10, int i11) {
            this.f26751a = i10;
            this.f26752b = j10;
            this.f26753c = i11;
        }

        public final int a() {
            return this.f26753c;
        }

        public final long b() {
            return this.f26752b;
        }

        public final int c() {
            return this.f26751a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f26751a == bVar.f26751a && this.f26752b == bVar.f26752b && this.f26753c == bVar.f26753c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f26751a) * 31) + Long.hashCode(this.f26752b)) * 31) + Integer.hashCode(this.f26753c);
        }

        public String toString() {
            return "QueryCallLogArgs(simId=" + this.f26751a + ", minDate=" + this.f26752b + ", limit=" + this.f26753c + ")";
        }
    }

    static {
        d b10;
        if (C0846g.c()) {
            b10 = new e().d().b();
        } else {
            b10 = new e().b();
        }
        f26750c = b10;
    }

    public final void b(List<RecognitionNumber> list, Map<String, String> map) {
        if (list != null) {
            for (RecognitionNumber recognitionNumber : list) {
                CallerIdItem$MarkerData markerData = recognitionNumber.b();
                if (markerData != null) {
                    i.e(markerData, "markerData");
                    if (!markerData.G() && markerData.u() > 0) {
                        int u10 = markerData.u();
                        if (u10 != 1) {
                            if (u10 != 3) {
                                if (u10 != 4) {
                                    if (u10 == 5) {
                                        String d10 = recognitionNumber.d();
                                        i.e(d10, "recognitionNumber.number");
                                        map.put(d10, "intermediary");
                                    }
                                } else {
                                    String d11 = recognitionNumber.d();
                                    i.e(d11, "recognitionNumber.number");
                                    map.put(d11, "harassment");
                                }
                            } else {
                                String d12 = recognitionNumber.d();
                                i.e(d12, "recognitionNumber.number");
                                map.put(d12, "fraud");
                            }
                        } else {
                            String d13 = recognitionNumber.d();
                            i.e(d13, "recognitionNumber.number");
                            map.put(d13, "advertisement");
                        }
                    }
                }
            }
        }
    }

    public final HashSet<Long> c(Context context, int i10) {
        Object b10;
        q qVar;
        String str = "slot_id ='" + i10 + "'";
        HashSet<Long> hashSet = new HashSet<>();
        try {
            Result.a aVar = Result.f34166a;
            Cursor query = context.getContentResolver().query(a.C0236a.f26235a, new String[]{"area_id"}, str, null, null);
            if (query != null) {
                try {
                    query.moveToPosition(-1);
                    int columnIndex = query.getColumnIndex("area_id");
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndex)) {
                            hashSet.add(Long.valueOf(query.getLong(columnIndex)));
                        }
                    }
                    q qVar2 = q.f35511a;
                    kotlin.io.a.a(query, null);
                    qVar = q.f35511a;
                } finally {
                }
            } else {
                qVar = null;
            }
            b10 = Result.b(qVar);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            C0846g.j("CallInterceptProvider", "getBlackListAreas exceptionOrNull: " + d10);
            return null;
        }
        return hashSet;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String method, String str, Bundle bundle) {
        i.f(method, "method");
        int hashCode = method.hashCode();
        String str2 = null;
        if (hashCode != -1426075972) {
            if (hashCode != 941437834) {
                if (hashCode == 1378771102 && method.equals("get_property")) {
                    return S.b(getContext(), bundle);
                }
            } else if (method.equals("getMarkedNumberCalls")) {
                int i10 = 0;
                if (bundle != null) {
                    i10 = bundle.getInt("days", 0);
                }
                int i11 = 200;
                if (bundle != null) {
                    i11 = bundle.getInt("maxCountPerSimCard", 200);
                }
                return h(i10, i11);
            }
        } else if (method.equals("getSwitchStatus")) {
            if (bundle != null) {
                str2 = bundle.getString("switchKey");
            }
            return m(str2);
        }
        C0846g.i("CallInterceptProvider", "unknown method: " + method);
        return null;
    }

    public final CallBlockRegionNumbersSettings d() {
        Context applicationContext;
        Context context = getContext();
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return null;
        }
        CallBlockRegionNumbersSettings callBlockRegionNumbersSettings = new CallBlockRegionNumbersSettings(n(applicationContext), null, 2, null);
        List<SubscriptionInfo> simCardList = C1632f.i(applicationContext);
        if (simCardList != null) {
            i.e(simCardList, "simCardList");
            for (SubscriptionInfo subInfo : simCardList) {
                List<CallBlockRegionNumbersSimSwitch> simCardSettings = callBlockRegionNumbersSettings.getSimCardSettings();
                i.e(subInfo, "subInfo");
                simCardSettings.add(e(applicationContext, subInfo));
            }
        }
        return callBlockRegionNumbersSettings;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        i.f(uri, "uri");
        return 0;
    }

    public final CallBlockRegionNumbersSimSwitch e(Context context, SubscriptionInfo subscriptionInfo) {
        SharedPreferences b10 = j.b(context);
        int l10 = l(context, subscriptionInfo);
        boolean z10 = false;
        boolean B10 = C1632f.B(context, C1632f.f37464r, 0, l10);
        boolean B11 = C1632f.B(context, C1632f.f37467u, 0, l10);
        boolean C10 = C1632f.C(b10, "harass_intercept_attribution", 3, l10);
        if (!B10 && !B11) {
            z10 = C10;
        }
        return new CallBlockRegionNumbersSimSwitch(z10, subscriptionInfo.getSimSlotIndex(), "harass_intercept_attribution", c(context, l10));
    }

    public final CallInterceptMarkedNumberSettings f() {
        Context applicationContext;
        Context context = getContext();
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return null;
        }
        boolean n10 = n(applicationContext);
        CallInterceptMarkedNumberSettings callInterceptMarkedNumberSettings = new CallInterceptMarkedNumberSettings(n10, null, 2, null);
        if (n10) {
            List<SubscriptionInfo> simCardList = C1632f.i(applicationContext);
            if (simCardList != null) {
                i.e(simCardList, "simCardList");
                for (SubscriptionInfo subscriptionInfo : simCardList) {
                    List<CallInterceptMarkedNumberSimCardSettings> simCardSettings = callInterceptMarkedNumberSettings.getSimCardSettings();
                    i.e(subscriptionInfo, "subscriptionInfo");
                    simCardSettings.add(k(applicationContext, subscriptionInfo));
                }
            }
        } else {
            C0846g.i("CallInterceptProvider", "getInterceptMarkedNumberSettings: not support");
        }
        return callInterceptMarkedNumberSettings;
    }

    public final int g(Context context, int i10, String str) {
        Integer valueOf = Integer.valueOf(MarkNumberThresholdUtil.e(i10, context, str));
        if (valueOf.intValue() == 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 1;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        i.f(uri, "uri");
        return null;
    }

    public final Bundle h(int i10, int i11) {
        Context applicationContext;
        C0846g.i("CallInterceptProvider", "getMarkedNumberCalls: days = " + i10 + ", maxCountPerSimCard = " + i11 + " ");
        Context context = getContext();
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return null;
        }
        int min = Math.min(i11, 6000);
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(i10);
        CallInterceptMarkedNumberCalls callInterceptMarkedNumberCalls = new CallInterceptMarkedNumberCalls(min, null, 2, null);
        List<SubscriptionInfo> simCardList = C1632f.i(applicationContext);
        if (simCardList != null) {
            i.e(simCardList, "simCardList");
            for (SubscriptionInfo subscriptionInfo : simCardList) {
                List<SimCardCalls> simCardCalls = callInterceptMarkedNumberCalls.getSimCardCalls();
                i.e(subscriptionInfo, "subscriptionInfo");
                simCardCalls.add(q(applicationContext, subscriptionInfo, currentTimeMillis, min));
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("response", f26750c.s(callInterceptMarkedNumberCalls));
        return bundle;
    }

    public final CallReleaseRulesSettings i() {
        Context applicationContext;
        Context context = getContext();
        if (context != null && (applicationContext = context.getApplicationContext()) != null) {
            CallReleaseRulesSettings callReleaseRulesSettings = new CallReleaseRulesSettings(n(applicationContext), s(applicationContext), null, 4, null);
            List<SubscriptionInfo> simCardList = C1632f.i(applicationContext);
            if (simCardList != null) {
                i.e(simCardList, "simCardList");
                for (SubscriptionInfo subInfo : simCardList) {
                    List<CallReleaseRulesSimSettings> simCardSettings = callReleaseRulesSettings.getSimCardSettings();
                    i.e(subInfo, "subInfo");
                    simCardSettings.add(j(applicationContext, subInfo));
                }
                return callReleaseRulesSettings;
            }
            return callReleaseRulesSettings;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        i.f(uri, "uri");
        return null;
    }

    public final CallReleaseRulesSimSettings j(Context context, SubscriptionInfo subscriptionInfo) {
        boolean z10;
        boolean z11;
        SharedPreferences b10 = j.b(context);
        int l10 = l(context, subscriptionInfo);
        boolean z12 = false;
        boolean B10 = C1632f.B(context, C1632f.f37464r, 0, l10);
        boolean B11 = C1632f.B(context, C1632f.f37467u, 0, l10);
        boolean z13 = b10.getBoolean("has_attribution_data_" + l10, false);
        boolean C10 = C1632f.C(b10, "auto_open_and_close", 0, l10);
        boolean C11 = C1632f.C(b10, "not_intercept_repeat_call", 0, l10);
        boolean C12 = C1632f.C(b10, "not_intercept_credible_strangers", 0, l10);
        C0846g.i("CallInterceptProvider", "slotId = " + subscriptionInfo.getSimSlotIndex() + " interceptAllIncoming = " + B10 + ", interceptAllStrangers = " + B11 + ", hasAttributionData = " + z13 + ", scheduleBlock = " + C10 + ", releaseRepeatCall = " + C11 + ", releaseSpecialNumbers = " + C12 + " ");
        if (!B10 && !B11) {
            z10 = false;
        } else {
            z10 = C10;
        }
        ScheduleBlockSwitch scheduleBlockSwitch = new ScheduleBlockSwitch(z10, subscriptionInfo.getSimSlotIndex(), "auto_open_and_close", b10.getInt("open_days_" + l10, 65), b10.getInt("open_start_hour_" + l10, 23), b10.getInt("open_end_hour_" + l10, 8), b10.getInt("open_start_minute_" + l10, 0), b10.getInt("open_end_minute_" + l10, 0));
        if (!B10 && C11) {
            z11 = true;
        } else {
            z11 = false;
        }
        CallCommonSwitch callCommonSwitch = new CallCommonSwitch(z11, subscriptionInfo.getSimSlotIndex(), "not_intercept_repeat_call");
        if ((B10 || B11 || z13) && !B10 && C12) {
            z12 = true;
        }
        return new CallReleaseRulesSimSettings(scheduleBlockSwitch, callCommonSwitch, new CallCommonSwitch(z12, subscriptionInfo.getSimSlotIndex(), "not_intercept_credible_strangers"));
    }

    public final CallInterceptMarkedNumberSimCardSettings k(Context context, SubscriptionInfo subscriptionInfo) {
        int simSlotIndex;
        boolean z10;
        String str;
        String str2;
        List k10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        List k11;
        boolean p10 = p(context, subscriptionInfo);
        if (p10) {
            simSlotIndex = 0;
        } else {
            simSlotIndex = subscriptionInfo.getSimSlotIndex();
        }
        boolean B10 = C1632f.B(context, C1632f.f37464r, 0, simSlotIndex);
        boolean B11 = C1632f.B(context, C1632f.f37467u, 0, simSlotIndex);
        boolean C10 = C1632f.C(j.b(context), "harass_intercept_marked_number_v2", 3, simSlotIndex);
        String HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY = C1632f.f37455i;
        boolean B12 = C1632f.B(context, HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY, 3, simSlotIndex);
        String HARASS_INTERCEPT_MARK_HARASSMENT_KEY = C1632f.f37456j;
        boolean B13 = C1632f.B(context, HARASS_INTERCEPT_MARK_HARASSMENT_KEY, 0, simSlotIndex);
        String HARASS_INTERCEPT_MARK_ADVERTISING_KEY = C1632f.f37457k;
        boolean B14 = C1632f.B(context, HARASS_INTERCEPT_MARK_ADVERTISING_KEY, 0, simSlotIndex);
        String HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY = C1632f.f37458l;
        boolean B15 = C1632f.B(context, HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY, 0, simSlotIndex);
        if (!B10 && !B11) {
            z10 = true;
        } else {
            z10 = false;
        }
        i.e(HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY, "HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY");
        int g10 = g(context, simSlotIndex, HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY);
        i.e(HARASS_INTERCEPT_MARK_HARASSMENT_KEY, "HARASS_INTERCEPT_MARK_HARASSMENT_KEY");
        int g11 = g(context, simSlotIndex, HARASS_INTERCEPT_MARK_HARASSMENT_KEY);
        i.e(HARASS_INTERCEPT_MARK_ADVERTISING_KEY, "HARASS_INTERCEPT_MARK_ADVERTISING_KEY");
        int g12 = g(context, simSlotIndex, HARASS_INTERCEPT_MARK_ADVERTISING_KEY);
        i.e(HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY, "HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY");
        int g13 = g(context, simSlotIndex, HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY);
        if (z10 && C10) {
            str = "oplus.intent.action.BLACKLIST_INTERCEPT_MARKED_NUMBER";
        } else {
            str = "oplus.intent.action.anti.harassment.call";
        }
        String str3 = str;
        C0846g.i("CallInterceptProvider", "slotId = " + subscriptionInfo.getSimSlotIndex() + " useSim1Rules = " + p10 + ", interceptAllIncoming = " + B10 + ", interceptAllStrangers = " + B11 + ", totalSwitch = " + C10 + ", fraud = " + B12 + ", harassment = " + B13 + ", advertisement = " + B14 + ", intermediary = " + B15 + ", fraudNumberStrength = " + g10 + ", harassmentNumberStrength = " + g11 + ", advertisementNumberStrength = " + g12 + ", intermediaryNumberStrength = " + g13 + ", settingAction = " + str3 + " ");
        int simSlotIndex2 = subscriptionInfo.getSimSlotIndex();
        CharSequence displayName = subscriptionInfo.getDisplayName();
        if (displayName != null) {
            str2 = displayName.toString();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        String str4 = str2;
        k10 = o.k(new CallInterceptMarkedNumberStrength(g10, "fraud"), new CallInterceptMarkedNumberStrength(g11, "harassment"), new CallInterceptMarkedNumberStrength(g12, "advertisement"), new CallInterceptMarkedNumberStrength(g13, "intermediary"));
        if (C10 && B12) {
            z11 = true;
        } else {
            z11 = false;
        }
        CallInterceptMarkedNumberSubSwitch callInterceptMarkedNumberSubSwitch = new CallInterceptMarkedNumberSubSwitch(z11, "fraud");
        if (C10 && B13) {
            z12 = true;
        } else {
            z12 = false;
        }
        CallInterceptMarkedNumberSubSwitch callInterceptMarkedNumberSubSwitch2 = new CallInterceptMarkedNumberSubSwitch(z12, "harassment");
        if (C10 && B14) {
            z13 = true;
        } else {
            z13 = false;
        }
        CallInterceptMarkedNumberSubSwitch callInterceptMarkedNumberSubSwitch3 = new CallInterceptMarkedNumberSubSwitch(z13, "advertisement");
        if (C10 && B15) {
            z14 = true;
        } else {
            z14 = false;
        }
        k11 = o.k(callInterceptMarkedNumberSubSwitch, callInterceptMarkedNumberSubSwitch2, callInterceptMarkedNumberSubSwitch3, new CallInterceptMarkedNumberSubSwitch(z14, "intermediary"));
        return new CallInterceptMarkedNumberSimCardSettings(z10, simSlotIndex2, str4, p10, str3, k10, k11);
    }

    public final int l(Context context, SubscriptionInfo subscriptionInfo) {
        boolean p10 = p(context, subscriptionInfo);
        C0846g.i("CallInterceptProvider", "useSim1Rules = " + p10);
        if (p10) {
            return 0;
        }
        return subscriptionInfo.getSimSlotIndex();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle m(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "getSwitchStatus: switchKey = "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "CallInterceptProvider"
            com.oplus.utils.C0846g.i(r2, r0)
            r0 = 0
            if (r6 == 0) goto L57
            int r3 = r6.hashCode()
            r4 = -1977344720(0xffffffff8a241d30, float:-7.901802E-33)
            if (r3 == r4) goto L49
            r4 = -1644696457(0xffffffff9df7ec77, float:-6.5624855E-21)
            if (r3 == r4) goto L3b
            r4 = 981915851(0x3a86d8cb, float:0.0010287998)
            if (r3 == r4) goto L2d
            goto L57
        L2d:
            java.lang.String r3 = "attributionNumbers"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L36
            goto L57
        L36:
            com.oplus.blacklistapp.callintercept.provider.CallBlockRegionNumbersSettings r5 = r5.d()
            goto L58
        L3b:
            java.lang.String r3 = "interceptMarkedNumber"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L44
            goto L57
        L44:
            com.oplus.blacklistapp.callintercept.provider.CallInterceptMarkedNumberSettings r5 = r5.f()
            goto L58
        L49:
            java.lang.String r3 = "releaseRules"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L52
            goto L57
        L52:
            com.oplus.blacklistapp.callintercept.provider.CallReleaseRulesSettings r5 = r5.i()
            goto L58
        L57:
            r5 = r0
        L58:
            if (r5 == 0) goto L6a
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            com.google.gson.d r3 = com.oplus.blacklistapp.callintercept.provider.CallInterceptProvider.f26750c
            java.lang.String r5 = r3.s(r5)
            java.lang.String r3 = "response"
            r0.putString(r3, r5)
        L6a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            r5.append(r6)
            java.lang.String r6 = ", result = "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.oplus.utils.C0846g.i(r2, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.provider.CallInterceptProvider.m(java.lang.String):android.os.Bundle");
    }

    public final boolean n(Context context) {
        if (C1632f.D(context)) {
            C0846g.i("CallInterceptProvider", "contact is hide block calls");
            return false;
        }
        if (!C1632f.x()) {
            C0846g.i("CallInterceptProvider", "dialer not support");
            return false;
        }
        if (!l7.b.d()) {
            C0846g.i("CallInterceptProvider", "number recognition not enable");
            return false;
        }
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        if (userManager != null && userManager.isSystemUser()) {
            return true;
        }
        C0846g.i("CallInterceptProvider", "not primaryUser");
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        if (r2.equals("-2") == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (r2.equals(com.android.incallui.OplusPhoneUtils.DeviceState.INVALID_STATUS) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (r2.equals("-3") != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o(java.lang.String r2) {
        /*
            r1 = this;
            r1 = 1
            if (r2 == 0) goto L50
            boolean r0 = kotlin.text.f.q(r2)
            if (r0 == 0) goto La
            goto L50
        La:
            if (r2 == 0) goto L30
            int r0 = r2.hashCode()
            switch(r0) {
                case 1444: goto L26;
                case 1445: goto L1d;
                case 1446: goto L14;
                default: goto L13;
            }
        L13:
            goto L30
        L14:
            java.lang.String r0 = "-3"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L30
            goto L2f
        L1d:
            java.lang.String r0 = "-2"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L2f
            goto L30
        L26:
            java.lang.String r0 = "-1"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L2f
            goto L30
        L2f:
            return r1
        L30:
            boolean r0 = l7.b.o()
            if (r0 == 0) goto L4f
            java.lang.String r0 = "-100"
            boolean r0 = kotlin.jvm.internal.i.b(r2, r0)
            if (r0 != 0) goto L50
            java.lang.String r0 = "-101"
            boolean r0 = kotlin.jvm.internal.i.b(r2, r0)
            if (r0 != 0) goto L50
            java.lang.String r0 = "-102"
            boolean r2 = kotlin.jvm.internal.i.b(r2, r0)
            if (r2 == 0) goto L4f
            goto L50
        L4f:
            r1 = 0
        L50:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.provider.CallInterceptProvider.o(java.lang.String):boolean");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    public final boolean p(Context context, SubscriptionInfo subscriptionInfo) {
        if (subscriptionInfo.getSimSlotIndex() == 1) {
            return C1632f.B(context, C1632f.f37454h, 3, subscriptionInfo.getSimSlotIndex());
        }
        return false;
    }

    public final SimCardCalls q(Context context, SubscriptionInfo subscriptionInfo, long j10, int i10) {
        List j11;
        CallsCount callsCount = new CallsCount("fraud", 0, 0, 0, 0, 0, 62, null);
        CallsCount callsCount2 = new CallsCount("harassment", 0, 0, 0, 0, 0, 62, null);
        CallsCount callsCount3 = new CallsCount("advertisement", 0, 0, 0, 0, 0, 62, null);
        CallsCount callsCount4 = new CallsCount("intermediary", 0, 0, 0, 0, 0, 62, null);
        CallsCount callsCount5 = new CallsCount("no_mark", 0, 0, 0, 0, 0, 62, null);
        int simSlotIndex = subscriptionInfo.getSimSlotIndex();
        j11 = o.j(callsCount, callsCount2, callsCount3, callsCount4);
        SimCardCalls simCardCalls = new SimCardCalls(simSlotIndex, callsCount5, j11, 0, 8, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        t(context, simCardCalls, linkedHashMap, arrayList, linkedHashSet, new b(subscriptionInfo.getSubscriptionId(), j10, i10));
        u(context, simCardCalls, linkedHashSet, linkedHashMap, arrayList);
        return simCardCalls;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        i.f(uri, "uri");
        return null;
    }

    public final Cursor r(Context context, int i10, long j10, int i11) {
        Object b10;
        C0846g.i("CallInterceptProvider", "querySimCardIncomingCalls: simId = " + i10 + ", minDate = " + j10 + ", limit = " + i11);
        Uri build = C0848i.g(context).buildUpon().appendQueryParameter("limit", String.valueOf(i11)).build();
        String[] strArr = {String.valueOf(i10), String.valueOf(j10), "2", "100"};
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(context.getContentResolver().query(build, f26749b, "simid = ? AND date > ? AND type not in (?, ?)", strArr, "date DESC"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            C0846g.j("CallInterceptProvider", "querySimCardIncomingCalls: " + d10);
        }
        if (Result.f(b10)) {
            b10 = null;
        }
        return (Cursor) b10;
    }

    public final HashSet<String> s(Context context) {
        Object b10;
        q qVar;
        HashSet<String> hashSet = new HashSet<>();
        String[] strArr = {BreenoCallContract.BaseColumns._ID, "number", OplusSpecialNumberUtils.OplusSpecialNumColumns.CN_NAME};
        try {
            Result.a aVar = Result.f34166a;
            Cursor query = context.getContentResolver().query(C0848i.o(context), strArr, "", null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        hashSet.add(query.getString(1));
                    } finally {
                    }
                }
                q qVar2 = q.f35511a;
                kotlin.io.a.a(query, null);
                qVar = q.f35511a;
            } else {
                qVar = null;
            }
            b10 = Result.b(qVar);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            C0846g.j("CallInterceptProvider", "querySpecialNumbers exceptionOrNull: " + d10);
            return null;
        }
        return hashSet;
    }

    public final void t(Context context, SimCardCalls simCardCalls, Map<String, String> map, List<CallAnswerInfo> list, Set<String> set, b bVar) {
        String str;
        Cursor r10 = r(context, bVar.c(), bVar.b(), bVar.a());
        if (r10 != null) {
            try {
                simCardCalls.setTotalCount(r10.getCount());
                while (r10.moveToNext()) {
                    String number = r10.getString(0);
                    int i10 = r10.getInt(1);
                    AnswerType a10 = C1610a.a(i10);
                    if (o(number)) {
                        C0846g.i("CallInterceptProvider", "getSimCardCalls: number(" + C0846g.f(number) + ") is unknown");
                        simCardCalls.getOtherCalls().increment(a10);
                    } else {
                        switch (i10) {
                            case 50:
                                i.e(number, "number");
                                map.put(number, "fraud");
                                str = "fraud";
                                break;
                            case 51:
                                i.e(number, "number");
                                map.put(number, "harassment");
                                str = "harassment";
                                break;
                            case 52:
                                i.e(number, "number");
                                map.put(number, "advertisement");
                                str = "advertisement";
                                break;
                            case 53:
                                i.e(number, "number");
                                map.put(number, "intermediary");
                                str = "intermediary";
                                break;
                            default:
                                i.e(number, "number");
                                str = map.getOrDefault(number, "no_mark");
                                break;
                        }
                        if (C0846g.c()) {
                            C0846g.i("CallInterceptProvider", "getSimCardCalls: number(" + C0846g.f(number) + ") markedType from call log type is: " + str);
                        }
                        switch (str.hashCode()) {
                            case -2079627610:
                                if (!str.equals("harassment")) {
                                    break;
                                } else {
                                    simCardCalls.getMarkedNumberCalls().get(1).increment(a10);
                                    break;
                                }
                            case -859717425:
                                if (!str.equals("intermediary")) {
                                    break;
                                } else {
                                    simCardCalls.getMarkedNumberCalls().get(3).increment(a10);
                                    break;
                                }
                            case -128069115:
                                if (!str.equals("advertisement")) {
                                    break;
                                } else {
                                    simCardCalls.getMarkedNumberCalls().get(2).increment(a10);
                                    break;
                                }
                            case 97692260:
                                if (!str.equals("fraud")) {
                                    break;
                                } else {
                                    simCardCalls.getMarkedNumberCalls().get(0).increment(a10);
                                    break;
                                }
                        }
                        list.add(new CallAnswerInfo(number, a10));
                        set.add(number);
                    }
                }
                q qVar = q.f35511a;
                kotlin.io.a.a(r10, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.a.a(r10, th);
                    throw th2;
                }
            }
        }
    }

    public final void u(Context context, SimCardCalls simCardCalls, Set<String> set, final Map<String, String> map, List<CallAnswerInfo> list) {
        List<List> t10;
        int p10;
        if (C1087a.m(context)) {
            t10 = CollectionsKt___CollectionsKt.t(set, 500);
            for (List list2 : t10) {
                p10 = p.p(list2, 10);
                ArrayList arrayList = new ArrayList(p10);
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(new RequestData.b().r((String) it.next()).n());
                }
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                C1087a.e(context).p(arrayList, new INumListCallback.Stub() { // from class: com.oplus.blacklistapp.callintercept.provider.CallInterceptProvider$updateMarkedNumberInfoFromTed$1$1
                    @Override // com.ted.phonenumber.service.INumListCallback
                    public void I(List<RecognitionNumber> list3) {
                        C0846g.i("CallInterceptProvider", "queryBatch onPartSuccess: " + list3);
                        CallInterceptProvider.this.b(list3, map);
                        countDownLatch.countDown();
                    }

                    @Override // com.ted.phonenumber.service.INumListCallback
                    public void L() {
                        C0846g.i("CallInterceptProvider", "queryBatch: onFailed");
                        countDownLatch.countDown();
                    }

                    @Override // com.ted.phonenumber.service.INumListCallback
                    public void v(List<RecognitionNumber> list3) {
                        C0846g.i("CallInterceptProvider", "queryBatch onSuccess: " + list3);
                        CallInterceptProvider.this.b(list3, map);
                        countDownLatch.countDown();
                    }
                });
                countDownLatch.await(15L, TimeUnit.SECONDS);
            }
        }
        for (CallAnswerInfo callAnswerInfo : list) {
            String str = map.get(callAnswerInfo.getNumber());
            if (str != null) {
                switch (str.hashCode()) {
                    case -2079627610:
                        if (str.equals("harassment")) {
                            simCardCalls.getMarkedNumberCalls().get(1).increment(callAnswerInfo.getAnswerType());
                            break;
                        } else {
                            break;
                        }
                    case -859717425:
                        if (str.equals("intermediary")) {
                            simCardCalls.getMarkedNumberCalls().get(3).increment(callAnswerInfo.getAnswerType());
                            break;
                        } else {
                            break;
                        }
                    case -128069115:
                        if (str.equals("advertisement")) {
                            simCardCalls.getMarkedNumberCalls().get(2).increment(callAnswerInfo.getAnswerType());
                            break;
                        } else {
                            break;
                        }
                    case 97692260:
                        if (str.equals("fraud")) {
                            simCardCalls.getMarkedNumberCalls().get(0).increment(callAnswerInfo.getAnswerType());
                            break;
                        } else {
                            break;
                        }
                }
            }
            simCardCalls.getOtherCalls().increment(callAnswerInfo.getAnswerType());
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        i.f(uri, "uri");
        return 0;
    }
}
