package com.android.contacts.business.calllog.breenocall;

import C7.f;
import H7.b;
import P7.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.android.incallui.BuildConfig;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import java.util.List;
import java.util.Locale;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.a;
import kotlin.collections.C1229j;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.S;
import m9.d;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: FeatureOpt.kt */
/* loaded from: classes.dex */
public final class FeatureOpt {
    private static final String DETECT_NAME_AIGC_PHONE_SUMMARY = "aigc_call_summary_phone";
    private static final String EXTRA_KEY = "supportAiCall";
    private static final d FEATURE_HIDE_CALL_RECORD_MCC$delegate;
    private static final String FEATURE_INCALLUI_HIDE_CALL_RECORD_MCC = "com.android.incallui.hide_call_record_mcc";
    private static final String FEATURE_INCALLUI_NOT_SUPPORT_RECORD = "com.android.incallui.not_support_record";
    private static final d FEATURE_NOT_SUPPORT_RECORD$delegate;
    private static final String KEY_AI_CALL_SUPPORT = "ai_call_support";
    private static final String KEY_CALL_SUMMARY_CHECK_TIME = "call_summary_check_time";
    private static final String KEY_CALL_SUMMARY_CURRENT_VERSION = "call_summary_current_version";
    private static final String KEY_CALL_SUMMARY_SUPPORT = "call_summary_support";
    private static final String KEY_CALL_SUMMARY_SUPPORTED = "call_summary_supported";
    private static final String META_KEY_ACCESSIBILITY_SUMMARY_SUPPORT = "support_summary";
    private static final String META_KEY_BREENO_CALLLOG_SUPPORT = "breeno_calllog_support";
    private static final String META_KEY_BREENO_CALL_SUMMARY_SUPPORT = "breeno_summary_support";
    private static final String META_KEY_CALL_SUMMARY_REGION = "call_summary_region";
    private static final String META_KEY_CALL_SUMMARY_SUPPORT = "ai_summary_support";
    private static final String META_KEY_INCALLUI_SUPPORT = "incallui_support_aicall";
    private static final String META_KEY_NOTE_CALL_SUMMARY_SUPPORT = "summary_note_version";
    private static final String META_KEY_NOTE_RECORD_SUMMARY_SUPPORT = "record_summary_support";
    private static final String META_KEY_PHONE_SUPPORT = "teleservice_support_aicall";
    private static final String META_KEY_TELECOM_SUPPORT = "telecom_support_aicall";
    private static final String METHOD_IS_SUPPORT_AI_CALL = "setting.isSupportAiCall";
    private static final String PERSIST_SYS_OPLUS_REGION = "persist.sys.oplus.region";
    private static final String SETTING_KEY_BREENO_CALLLOG_SUPPORT = "is_support_ai_call";
    private static final String SP_FILE_NAME = "ai_call";
    private static final String TAG = "FeatureOpt";
    private static final d accessibilityCallSummarySupport$delegate;
    private static long aiCallSummaryCheckTime;
    private static String aiCallSummaryCheckVersion;
    private static Boolean aiCallSummarySupport;
    private static boolean aiCallSummarySupported;
    private static Boolean aiCallSupport;
    private static final d breenoCallLogSupport$delegate;
    private static final d breenoCallSummarySupport$delegate;
    private static final d callSummaryIconDisplayable$delegate;
    private static final d notePackageName$delegate;
    private static final d phoneCallSummarySupport$delegate;
    private static final d phoneSupport$delegate;
    public static final FeatureOpt INSTANCE = new FeatureOpt();
    private static final Uri AI_CALL_URI = Uri.parse("content://com.heytap.speechassist.provider.aiCall");

    static {
        d a10;
        d a11;
        d a12;
        d a13;
        d a14;
        d a15;
        d a16;
        d a17;
        d a18;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f34162b;
        a10 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.business.calllog.breenocall.FeatureOpt$breenoCallLogSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean isBreenoCallLogSupport;
                isBreenoCallLogSupport = FeatureOpt.INSTANCE.isBreenoCallLogSupport(P7.a.f2961a.a());
                return Boolean.valueOf(isBreenoCallLogSupport);
            }
        });
        breenoCallLogSupport$delegate = a10;
        a11 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.business.calllog.breenocall.FeatureOpt$phoneSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean isPhoneSupport;
                isPhoneSupport = FeatureOpt.INSTANCE.isPhoneSupport(P7.a.f2961a.a());
                return Boolean.valueOf(isPhoneSupport);
            }
        });
        phoneSupport$delegate = a11;
        a12 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.business.calllog.breenocall.FeatureOpt$phoneCallSummarySupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean isPhoneCallSummarySupport;
                isPhoneCallSummarySupport = FeatureOpt.INSTANCE.isPhoneCallSummarySupport(P7.a.f2961a.a());
                return Boolean.valueOf(isPhoneCallSummarySupport);
            }
        });
        phoneCallSummarySupport$delegate = a12;
        a13 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.business.calllog.breenocall.FeatureOpt$accessibilityCallSummarySupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean isAccessibilityCallSummarySupport;
                isAccessibilityCallSummarySupport = FeatureOpt.INSTANCE.isAccessibilityCallSummarySupport(P7.a.f2961a.a());
                return Boolean.valueOf(isAccessibilityCallSummarySupport);
            }
        });
        accessibilityCallSummarySupport$delegate = a13;
        a14 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.business.calllog.breenocall.FeatureOpt$breenoCallSummarySupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean hasCallSummaryMetadataConfig;
                hasCallSummaryMetadataConfig = FeatureOpt.INSTANCE.hasCallSummaryMetadataConfig(P7.a.f2961a.a());
                return Boolean.valueOf(hasCallSummaryMetadataConfig);
            }
        });
        breenoCallSummarySupport$delegate = a14;
        a15 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.business.calllog.breenocall.FeatureOpt$FEATURE_NOT_SUPPORT_RECORD$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(AppFeatureProviderUtils.p(P7.a.f2961a.a().getContentResolver(), "com.android.incallui.not_support_record"));
            }
        });
        FEATURE_NOT_SUPPORT_RECORD$delegate = a15;
        a16 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<List<String>>() { // from class: com.android.contacts.business.calllog.breenocall.FeatureOpt$FEATURE_HIDE_CALL_RECORD_MCC$2
            @Override // v9.InterfaceC1637a
            public final List<String> invoke() {
                return AppFeatureProviderUtils.l(P7.a.f2961a.a().getContentResolver(), "com.android.incallui.hide_call_record_mcc");
            }
        });
        FEATURE_HIDE_CALL_RECORD_MCC$delegate = a16;
        a17 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<String>() { // from class: com.android.contacts.business.calllog.breenocall.FeatureOpt$notePackageName$2
            @Override // v9.InterfaceC1637a
            public final String invoke() {
                P7.a aVar = P7.a.f2961a;
                return (!c.d(aVar.a(), "com.coloros.note", false) && c.d(aVar.a(), "com.oneplus.note", false)) ? "com.oneplus.note" : "com.coloros.note";
            }
        });
        notePackageName$delegate = a17;
        a18 = a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.business.calllog.breenocall.FeatureOpt$callSummaryIconDisplayable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean hasNoteCallSummaryMetadataConfig;
                boolean z10 = false;
                if (!com.android.contacts.framework.api.appstore.appinfo.a.k() && !CommonFeatureOption.m()) {
                    P7.a aVar = P7.a.f2961a;
                    Context a19 = aVar.a();
                    FeatureOpt featureOpt = FeatureOpt.INSTANCE;
                    if (c.d(a19, featureOpt.getNotePackageName(), false)) {
                        hasNoteCallSummaryMetadataConfig = featureOpt.hasNoteCallSummaryMetadataConfig(aVar.a(), featureOpt.getNotePackageName());
                        if (hasNoteCallSummaryMetadataConfig && FeatureOpt.isSupportCallSummary()) {
                            z10 = true;
                        }
                    }
                }
                return Boolean.valueOf(z10);
            }
        });
        callSummaryIconDisplayable$delegate = a18;
    }

    private FeatureOpt() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkUpdateBreenoCallSupport(boolean z10, int i10, Runnable runnable, SharedPreferences sharedPreferences) {
        if (!i.b(Boolean.valueOf(z10), aiCallSupport)) {
            aiCallSupport = Boolean.valueOf(z10);
            if (runnable != null) {
                C1244g.d(C1241e0.f34422a, S.c(), null, new FeatureOpt$checkUpdateBreenoCallSupport$1(runnable, null), 2, null);
            }
        }
        b.e(TAG, "checkUpdateBreenoCallSupport value = " + z10 + "; oldValue = " + i10);
        if (z10 != i10) {
            R7.d.a(R7.d.i(R7.d.b(sharedPreferences), KEY_AI_CALL_SUPPORT, z10 ? 1 : 0));
        }
    }

    private final boolean getAccessibilityCallSummarySupport() {
        return ((Boolean) accessibilityCallSummarySupport$delegate.getValue()).booleanValue();
    }

    private final boolean getAiCallSupport() {
        Object b10;
        P7.a aVar = P7.a.f2961a;
        boolean z10 = true;
        int d10 = G0.c.d(aVar.a(), 1, SETTING_KEY_BREENO_CALLLOG_SUPPORT, -1);
        b.e(TAG, "isBreenoCallSupport support: " + d10);
        if (d10 != 0) {
            if (d10 != 1) {
                try {
                    Result.a aVar2 = Result.f34166a;
                    int e10 = R7.d.e(R7.b.b(aVar.a(), SP_FILE_NAME, 0), KEY_AI_CALL_SUPPORT, -1);
                    b.e(TAG, "getAiCallSupport sp: " + e10);
                    if (e10 == -1) {
                        INSTANCE.updateBreenoCallSupport(null);
                    }
                    q qVar = q.f35511a;
                    if (1 != e10) {
                        z10 = false;
                    }
                    b10 = Result.b(Boolean.valueOf(z10));
                } catch (Throwable th) {
                    Result.a aVar3 = Result.f34166a;
                    b10 = Result.b(kotlin.b.a(th));
                }
                Throwable d11 = Result.d(b10);
                if (d11 != null) {
                    b.c(TAG, "getAiCallSupport getSharedPreferences e: " + d11);
                }
                Boolean bool = Boolean.FALSE;
                if (Result.f(b10)) {
                    b10 = bool;
                }
                z10 = ((Boolean) b10).booleanValue();
            }
        } else {
            z10 = false;
        }
        aiCallSupport = Boolean.valueOf(z10);
        return z10;
    }

    private final boolean getBreenoCallLogSupport() {
        return ((Boolean) breenoCallLogSupport$delegate.getValue()).booleanValue();
    }

    private final boolean getBreenoCallSummarySupport() {
        return ((Boolean) breenoCallSummarySupport$delegate.getValue()).booleanValue();
    }

    private final boolean getCallSummaryIconDisplayable() {
        return ((Boolean) callSummaryIconDisplayable$delegate.getValue()).booleanValue();
    }

    private final List<String> getFEATURE_HIDE_CALL_RECORD_MCC() {
        Object value = FEATURE_HIDE_CALL_RECORD_MCC$delegate.getValue();
        i.e(value, "<get-FEATURE_HIDE_CALL_RECORD_MCC>(...)");
        return (List) value;
    }

    private final boolean getFEATURE_NOT_SUPPORT_RECORD() {
        return ((Boolean) FEATURE_NOT_SUPPORT_RECORD$delegate.getValue()).booleanValue();
    }

    private final boolean getPhoneCallSummarySupport() {
        return ((Boolean) phoneCallSummarySupport$delegate.getValue()).booleanValue();
    }

    private final boolean getPhoneSupport() {
        return ((Boolean) phoneSupport$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.Y(r3, new java.lang.String[]{","}, false, 0, 6, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String[] getRegionsSupport() {
        /*
            r9 = this;
            r9 = 0
            kotlin.Result$a r0 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L2f
            P7.a r0 = P7.a.f2961a     // Catch: java.lang.Throwable -> L2f
            android.content.Context r0 = r0.a()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r1 = "com.coloros.accessibilityassistant"
            java.lang.String r2 = "call_summary_region"
            java.lang.String r3 = M7.a.a(r0, r1, r2, r9)     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L31
            java.lang.String r0 = ","
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L2f
            r7 = 6
            r8 = 0
            r5 = 0
            r6 = 0
            java.util.List r0 = kotlin.text.f.Y(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L31
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L2f
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L2f
            java.lang.Object[] r0 = r0.toArray(r1)     // Catch: java.lang.Throwable -> L2f
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch: java.lang.Throwable -> L2f
            goto L32
        L2f:
            r0 = move-exception
            goto L37
        L31:
            r0 = r9
        L32:
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L2f
            goto L41
        L37:
            kotlin.Result$a r1 = kotlin.Result.f34166a
            java.lang.Object r0 = kotlin.b.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L41:
            java.lang.Throwable r1 = kotlin.Result.d(r0)
            if (r1 != 0) goto L49
            r9 = r0
            goto L64
        L49:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Error retrieving call_summary_region metadata: "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "FeatureOpt"
            H7.b.c(r1, r0)
        L64:
            java.lang.String[] r9 = (java.lang.String[]) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.business.calllog.breenocall.FeatureOpt.getRegionsSupport():java.lang.String[]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasCallSummaryMetadataConfig(Context context) {
        return M7.a.h(context, "com.android.providers.contacts", META_KEY_BREENO_CALL_SUMMARY_SUPPORT, "true");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasNoteCallSummaryMetadataConfig(Context context, String str) {
        boolean h10 = M7.a.h(context, str, META_KEY_NOTE_CALL_SUMMARY_SUPPORT, OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        boolean hasRecordSummaryMetadataConfig = hasRecordSummaryMetadataConfig(context, str);
        b.e(TAG, "callSummarySupport: " + h10 + ", recordSummarySupport: " + hasRecordSummaryMetadataConfig);
        if (!h10 && !hasRecordSummaryMetadataConfig) {
            return false;
        }
        return true;
    }

    private final boolean hasRecordSummaryMetadataConfig(Context context, String str) {
        String a10 = M7.a.a(context, str, META_KEY_NOTE_RECORD_SUMMARY_SUPPORT, OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
        int c10 = f.c(a10, 0);
        b.e(TAG, "record summary metadata config: " + a10 + ", " + c10);
        if (c10 < 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAccessibilityCallSummarySupport(Context context) {
        if (M7.a.h(context, "com.coloros.accessibilityassistant", META_KEY_ACCESSIBILITY_SUMMARY_SUPPORT, "true") && M7.a.h(context, "com.coloros.translate.engine", META_KEY_ACCESSIBILITY_SUMMARY_SUPPORT, "true")) {
            return true;
        }
        return false;
    }

    private final boolean isAiCallSupport() {
        Boolean bool = aiCallSupport;
        if (bool != null) {
            return bool.booleanValue();
        }
        return getAiCallSupport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBreenoCallLogSupport(Context context) {
        return M7.a.h(context, "com.android.providers.contacts", META_KEY_BREENO_CALLLOG_SUPPORT, "true");
    }

    public static final boolean isCallSummaryIconDisplayable() {
        if (H7.a.b()) {
            FeatureOpt featureOpt = INSTANCE;
            b.b(TAG, "Call summary icon displayable: " + featureOpt.getCallSummaryIconDisplayable() + ", note: " + featureOpt.getNotePackageName());
        }
        return INSTANCE.getCallSummaryIconDisplayable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPhoneCallSummarySupport(Context context) {
        if (M7.a.h(context, BuildConfig.LIBRARY_PACKAGE_NAME, META_KEY_CALL_SUMMARY_SUPPORT, "true") && M7.a.h(context, "com.android.server.telecom", META_KEY_CALL_SUMMARY_SUPPORT, "true") && M7.a.h(context, "com.android.phone", META_KEY_CALL_SUMMARY_SUPPORT, "true")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPhoneSupport(Context context) {
        if (M7.a.h(context, BuildConfig.LIBRARY_PACKAGE_NAME, META_KEY_INCALLUI_SUPPORT, "true") && M7.a.h(context, "com.android.server.telecom", META_KEY_TELECOM_SUPPORT, "true") && M7.a.h(context, "com.android.phone", META_KEY_PHONE_SUPPORT, "true")) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean isSupportCallSummary() {
        /*
            boolean r0 = com.oplus.foundation.util.feature.CommonFeatureOption.m()
            r1 = 0
            if (r0 != 0) goto L1d
            com.android.contacts.business.calllog.breenocall.FeatureOpt r2 = com.android.contacts.business.calllog.breenocall.FeatureOpt.INSTANCE
            boolean r3 = r2.getPhoneCallSummarySupport()
            if (r3 == 0) goto L1d
            boolean r3 = r2.getAccessibilityCallSummarySupport()
            if (r3 == 0) goto L1d
            boolean r2 = r2.getBreenoCallSummarySupport()
            if (r2 == 0) goto L1d
            r2 = 1
            goto L1e
        L1d:
            r2 = r1
        L1e:
            com.android.contacts.business.calllog.breenocall.FeatureOpt r3 = com.android.contacts.business.calllog.breenocall.FeatureOpt.INSTANCE
            boolean r4 = r3.getPhoneCallSummarySupport()
            boolean r5 = r3.getAccessibilityCallSummarySupport()
            boolean r3 = r3.getBreenoCallSummarySupport()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "isSupportCallSummary: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r7 = ", isTablet: "
            r6.append(r7)
            r6.append(r0)
            java.lang.String r0 = ", phone: "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r0 = ", accessibility: "
            r6.append(r0)
            r6.append(r5)
            java.lang.String r0 = ", breeno: "
            r6.append(r0)
            r6.append(r3)
            java.lang.String r0 = r6.toString()
            java.lang.String r3 = "FeatureOpt"
            H7.b.e(r3, r0)
            boolean r0 = isSupportRegion()
            if (r0 != 0) goto L6e
            java.lang.String r0 = "isSupportCallSummary isSupportRegion false"
            H7.b.e(r3, r0)
            return r1
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.business.calllog.breenocall.FeatureOpt.isSupportCallSummary():boolean");
    }

    public static final boolean isSupportRegion() {
        boolean t10;
        boolean t11;
        if (CommonOSPublicFeature.f()) {
            return true;
        }
        FeatureOpt featureOpt = INSTANCE;
        if (featureOpt.getFEATURE_NOT_SUPPORT_RECORD()) {
            b.e(TAG, "FEATURE_NOT_SUPPORT_RECORD");
            return false;
        }
        String[] regionsSupport = featureOpt.getRegionsSupport();
        if (regionsSupport == null) {
            b.e(TAG, "regionsSupport is null");
            return false;
        }
        String b10 = M7.d.b(PERSIST_SYS_OPLUS_REGION, "");
        Locale locale = Locale.ROOT;
        String lowerCase = b10.toLowerCase(locale);
        i.e(lowerCase, "toLowerCase(...)");
        b.b(TAG, "userSettingRegion :" + lowerCase);
        t10 = C1229j.t(regionsSupport, lowerCase);
        if (!t10) {
            b.e(TAG, "userSettingRegion is not regionsSupport");
            return false;
        }
        String lowerCase2 = J7.a.b().toLowerCase(locale);
        i.e(lowerCase2, "toLowerCase(...)");
        b.b(TAG, "mccRegion :" + lowerCase2);
        if (i.b(lowerCase2, "")) {
            b.e(TAG, "mccRegion is \"\"");
            return true;
        }
        if (featureOpt.getFEATURE_HIDE_CALL_RECORD_MCC().contains(lowerCase2)) {
            b.e(TAG, "hideCallRecordMcc  contains  mccRegion");
            return false;
        }
        b.e(TAG, "check mccRegion in regionsSupport");
        t11 = C1229j.t(regionsSupport, lowerCase2);
        return t11;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:1|2|3|4|(4:6|7|(1:12)|13)|14|(2:16|(5:20|21|22|(1:24)|25))|28|(1:30)(1:47)|31|32|33|(1:35)|36|(1:38)|39|(1:41)|43|21|22|(0)|25|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x010f, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0130, code lost:
    
        r3 = kotlin.Result.f34166a;
        r0 = kotlin.Result.b(kotlin.b.a(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean loadCallSummarySupport() {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.business.calllog.breenocall.FeatureOpt.loadCallSummarySupport():boolean");
    }

    public final String getNotePackageName() {
        return (String) notePackageName$delegate.getValue();
    }

    public final boolean isAiCallSummarySupport(boolean z10) {
        if (z10) {
            return loadCallSummarySupport();
        }
        Boolean bool = aiCallSummarySupport;
        if (bool == null) {
            SharedPreferences b10 = R7.b.b(P7.a.f2961a.a(), SP_FILE_NAME, 0);
            bool = Boolean.valueOf(R7.d.d(b10, KEY_CALL_SUMMARY_SUPPORT, false, 2, null));
            b.e(TAG, "isAiCallSummarySupport sp value: " + bool + ";time: " + R7.d.g(b10, KEY_CALL_SUMMARY_CHECK_TIME, 0L, 2, null));
        } else {
            b.e(TAG, "isAiCallSummarySupport aiCallSummarySupport: " + bool);
        }
        return bool.booleanValue();
    }

    public final void updateBreenoCallSupport(Runnable runnable) {
        C1244g.d(C1241e0.f34422a, S.b(), null, new FeatureOpt$updateBreenoCallSupport$1(runnable, null), 2, null);
    }

    public static final boolean isBreenoCallLogSupport() {
        if (CommonOSPublicFeature.f() && !CommonFeatureOption.m()) {
            FeatureOpt featureOpt = INSTANCE;
            if (featureOpt.getBreenoCallLogSupport() && featureOpt.isAiCallSupport() && featureOpt.getPhoneSupport()) {
                return true;
            }
        }
        return false;
    }
}
