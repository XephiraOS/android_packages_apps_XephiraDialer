package com.android.contacts.cust.business.export;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.android.contacts.cust.business.export.a;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import com.oplus.foundation.util.OsUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: CustCustomizeFeature.kt */
/* loaded from: classes.dex */
public final class CustCustomizeFeature {

    /* renamed from: a, reason: collision with root package name */
    public static final CustCustomizeFeature f14117a = new CustCustomizeFeature();

    /* renamed from: b, reason: collision with root package name */
    public static ContentResolver f14118b;

    /* renamed from: c, reason: collision with root package name */
    public static PackageManager f14119c;

    /* renamed from: d, reason: collision with root package name */
    public static Context f14120d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f14121e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f14122f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f14123g;

    /* renamed from: h, reason: collision with root package name */
    public static final d f14124h;

    /* renamed from: i, reason: collision with root package name */
    public static final d f14125i;

    /* renamed from: j, reason: collision with root package name */
    public static final d f14126j;

    /* renamed from: k, reason: collision with root package name */
    public static final d f14127k;

    /* renamed from: l, reason: collision with root package name */
    public static final d f14128l;

    /* renamed from: m, reason: collision with root package name */
    public static final d f14129m;

    /* renamed from: n, reason: collision with root package name */
    public static final d f14130n;

    /* renamed from: o, reason: collision with root package name */
    public static final d f14131o;

    static {
        d b10;
        d b11;
        d b12;
        d b13;
        d b14;
        d b15;
        d b16;
        d b17;
        d b18;
        d b19;
        d b20;
        b10 = kotlin.a.b(new InterfaceC1637a<String>() { // from class: com.android.contacts.cust.business.export.CustCustomizeFeature$operator$2
            @Override // v9.InterfaceC1637a
            public final String invoke() {
                ContentResolver contentResolver;
                contentResolver = CustCustomizeFeature.f14118b;
                return AppFeatureProviderUtils.i(contentResolver, "com.android.contacts.operator_mark", null);
            }
        });
        f14121e = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.cust.business.export.CustCustomizeFeature$showImeiSv$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0159a c0159a = a.f14149a;
                packageManager = CustCustomizeFeature.f14119c;
                contentResolver = CustCustomizeFeature.f14118b;
                return Boolean.valueOf(c0159a.b(packageManager, contentResolver, "coloros.customize.contacts.show_imei_sv", "com.android.contacts.show_imei_sv", false));
            }
        });
        f14122f = b11;
        b12 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.cust.business.export.CustCustomizeFeature$disableVolteVowifiIcon$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean z10;
                PackageManager packageManager;
                ContentResolver contentResolver;
                if (OsUtils.f28275a.i()) {
                    a.C0159a c0159a = a.f14149a;
                    packageManager = CustCustomizeFeature.f14119c;
                    contentResolver = CustCustomizeFeature.f14118b;
                    z10 = c0159a.b(packageManager, contentResolver, "", "com.android.contacts.disable_volte_vowifi_icon", false);
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        });
        f14123g = b12;
        b13 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.cust.business.export.CustCustomizeFeature$displayApn$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0159a c0159a = a.f14149a;
                packageManager = CustCustomizeFeature.f14119c;
                contentResolver = CustCustomizeFeature.f14118b;
                return Boolean.valueOf(c0159a.b(packageManager, contentResolver, "oppo.contacts.display.apn", "com.android.contacts.display_apn", false));
            }
        });
        f14124h = b13;
        b14 = kotlin.a.b(new InterfaceC1637a<HashMap<String, String>>() { // from class: com.android.contacts.cust.business.export.CustCustomizeFeature$voiceMailNameMap$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final HashMap<String, String> invoke() {
                ContentResolver contentResolver;
                HashMap<String, String> r10;
                CustCustomizeFeature custCustomizeFeature = CustCustomizeFeature.f14117a;
                contentResolver = CustCustomizeFeature.f14118b;
                r10 = custCustomizeFeature.r(contentResolver);
                return r10;
            }
        });
        f14125i = b14;
        b15 = kotlin.a.b(new InterfaceC1637a<HashMap<String, String>>() { // from class: com.android.contacts.cust.business.export.CustCustomizeFeature$speedDialMap$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final HashMap<String, String> invoke() {
                ContentResolver contentResolver;
                HashMap<String, String> p10;
                CustCustomizeFeature custCustomizeFeature = CustCustomizeFeature.f14117a;
                contentResolver = CustCustomizeFeature.f14118b;
                p10 = custCustomizeFeature.p(contentResolver);
                return p10;
            }
        });
        f14126j = b15;
        b16 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.cust.business.export.CustCustomizeFeature$speedDialConsumerHotline$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0159a c0159a = a.f14149a;
                packageManager = CustCustomizeFeature.f14119c;
                contentResolver = CustCustomizeFeature.f14118b;
                return Boolean.valueOf(c0159a.b(packageManager, contentResolver, "coloros.customize.contacts.speed_dial_consumer_hotline", "com.android.contacts.speed_dial_consumer_hotline", false));
            }
        });
        f14127k = b16;
        b17 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.cust.business.export.CustCustomizeFeature$showSdnMore$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0159a c0159a = a.f14149a;
                packageManager = CustCustomizeFeature.f14119c;
                contentResolver = CustCustomizeFeature.f14118b;
                return Boolean.valueOf(c0159a.b(packageManager, contentResolver, "coloros.customize.contacts.show_sdn_more", "com.android.contacts.show_sdn_more", false));
            }
        });
        f14128l = b17;
        b18 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.cust.business.export.CustCustomizeFeature$showSdnServiceNumber$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0159a c0159a = a.f14149a;
                packageManager = CustCustomizeFeature.f14119c;
                contentResolver = CustCustomizeFeature.f14118b;
                return Boolean.valueOf(c0159a.b(packageManager, contentResolver, "oppo.contacts.show.sdn.service.number", "com.android.contacts.show_sdn_service_number", false));
            }
        });
        f14129m = b18;
        b19 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.cust.business.export.CustCustomizeFeature$displaySdn$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                ContentResolver contentResolver;
                a.C0159a c0159a = a.f14149a;
                context = CustCustomizeFeature.f14120d;
                contentResolver = CustCustomizeFeature.f14118b;
                return Boolean.valueOf(c0159a.c(context, contentResolver, "com.android.contacts.display_sdn_function"));
            }
        });
        f14130n = b19;
        b20 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.cust.business.export.CustCustomizeFeature$calllogFdnSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0159a c0159a = a.f14149a;
                packageManager = CustCustomizeFeature.f14119c;
                contentResolver = CustCustomizeFeature.f14118b;
                return Boolean.valueOf(c0159a.b(packageManager, contentResolver, "oppo.phone.direct.fdn.dialing", "com.android.contacts.call_log_fdn_support", false));
            }
        });
        f14131o = b20;
    }

    public final boolean f() {
        return ((Boolean) f14131o.getValue()).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) f14123g.getValue()).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) f14124h.getValue()).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) f14130n.getValue()).booleanValue();
    }

    public final String j() {
        return (String) f14121e.getValue();
    }

    public final boolean k() {
        return ((Boolean) f14122f.getValue()).booleanValue();
    }

    public final boolean l() {
        return ((Boolean) f14128l.getValue()).booleanValue();
    }

    public final boolean m() {
        return ((Boolean) f14129m.getValue()).booleanValue();
    }

    public final boolean n() {
        return ((Boolean) f14127k.getValue()).booleanValue();
    }

    public final HashMap<String, String> o() {
        return (HashMap) f14126j.getValue();
    }

    public final HashMap<String, String> p(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return new HashMap<>();
        }
        List<String> l10 = AppFeatureProviderUtils.l(contentResolver, "com.android.contacts.speed_dial");
        i.e(l10, "getStringList(cr, SPEED_DIAL)");
        return t(l10);
    }

    public final HashMap<String, String> q() {
        return (HashMap) f14125i.getValue();
    }

    public final HashMap<String, String> r(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return new HashMap<>();
        }
        List<String> l10 = AppFeatureProviderUtils.l(contentResolver, "com.android.contacts.voice_mail_name");
        i.e(l10, "getStringList(cr, VOICE_MAIL_NAME)");
        return t(l10);
    }

    public final void s(Context context) {
        ContentResolver contentResolver;
        PackageManager packageManager = null;
        if (context != null) {
            contentResolver = context.getContentResolver();
        } else {
            contentResolver = null;
        }
        f14118b = contentResolver;
        if (context != null) {
            packageManager = context.getPackageManager();
        }
        f14119c = packageManager;
        f14120d = context;
    }

    public final HashMap<String, String> t(List<String> list) {
        List Y9;
        HashMap<String, String> hashMap = new HashMap<>();
        if (list != null && (!list.isEmpty())) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    Y9 = StringsKt__StringsKt.Y(str, new String[]{"|"}, false, 0, 6, null);
                    String[] strArr = (String[]) Y9.toArray(new String[0]);
                    if (strArr.length == 2) {
                        hashMap.put(strArr[0], strArr[1]);
                    }
                }
            }
        }
        return hashMap;
    }
}
