package com.customize.contacts.feature;

import P7.c;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.feature.OSCustomizeFeature;
import com.customize.contacts.feature.a;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import java.util.HashMap;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsKt;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: OSCustomizeFeature.kt */
/* loaded from: classes3.dex */
public final class OSCustomizeFeature {

    /* renamed from: A, reason: collision with root package name */
    public static final d f20955A;

    /* renamed from: B, reason: collision with root package name */
    public static final d f20956B;

    /* renamed from: C, reason: collision with root package name */
    public static final d f20957C;

    /* renamed from: D, reason: collision with root package name */
    public static final d f20958D;

    /* renamed from: E, reason: collision with root package name */
    public static final d f20959E;

    /* renamed from: a, reason: collision with root package name */
    public static final OSCustomizeFeature f20960a = new OSCustomizeFeature();

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f20961b;

    /* renamed from: c, reason: collision with root package name */
    public static Context f20962c;

    /* renamed from: d, reason: collision with root package name */
    public static PackageManager f20963d;

    /* renamed from: e, reason: collision with root package name */
    public static ContentResolver f20964e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f20965f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f20966g;

    /* renamed from: h, reason: collision with root package name */
    public static final d f20967h;

    /* renamed from: i, reason: collision with root package name */
    public static final d f20968i;

    /* renamed from: j, reason: collision with root package name */
    public static final d f20969j;

    /* renamed from: k, reason: collision with root package name */
    public static final d f20970k;

    /* renamed from: l, reason: collision with root package name */
    public static final d f20971l;

    /* renamed from: m, reason: collision with root package name */
    public static final d f20972m;

    /* renamed from: n, reason: collision with root package name */
    public static final d f20973n;

    /* renamed from: o, reason: collision with root package name */
    public static final d f20974o;

    /* renamed from: p, reason: collision with root package name */
    public static final d f20975p;

    /* renamed from: q, reason: collision with root package name */
    public static final d f20976q;

    /* renamed from: r, reason: collision with root package name */
    public static final d f20977r;

    /* renamed from: s, reason: collision with root package name */
    public static final d f20978s;

    /* renamed from: t, reason: collision with root package name */
    public static final d f20979t;

    /* renamed from: u, reason: collision with root package name */
    public static final d f20980u;

    /* renamed from: v, reason: collision with root package name */
    public static final d f20981v;

    /* renamed from: w, reason: collision with root package name */
    public static final d f20982w;

    /* renamed from: x, reason: collision with root package name */
    public static final d f20983x;

    /* renamed from: y, reason: collision with root package name */
    public static final d f20984y;

    /* renamed from: z, reason: collision with root package name */
    public static final d f20985z;

    /* compiled from: OSCustomizeFeature.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f20986a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final String f20987b = "oppo.common.support.edge.gesture";

        /* renamed from: c, reason: collision with root package name */
        public static final String f20988c = "oppo.contacts.show.sdn.service.number";

        /* renamed from: d, reason: collision with root package name */
        public static final String f20989d = "oppo.contacts.display.apn";

        /* renamed from: e, reason: collision with root package name */
        public static final String f20990e = "oppo.contacts.wifi.calling.customize";

        /* renamed from: f, reason: collision with root package name */
        public static final String f20991f = "oppo.contacts.calllog.show.volte";

        /* renamed from: g, reason: collision with root package name */
        public static final String f20992g = "oppo.contacts.calllog.show.hd.icon";

        /* renamed from: h, reason: collision with root package name */
        public static final String f20993h = "coloros.customize.contacts.harass_intercept_anonymous_etc";

        /* renamed from: i, reason: collision with root package name */
        public static final String f20994i = "coloros.customize.contacts.special_number_expand_detail";

        /* renamed from: j, reason: collision with root package name */
        public static final String f20995j = "coloros.customize.contacts.speed_dial_consumer_hotline";

        /* renamed from: k, reason: collision with root package name */
        public static final String f20996k = "coloros.customize.contacts.show_sdn_more";

        /* renamed from: l, reason: collision with root package name */
        public static final String f20997l = "coloros.customize.contacts.unknown_location_not_display";

        /* renamed from: m, reason: collision with root package name */
        public static final String f20998m = "coloros.customize.contacts.hide_sms_menu";

        /* renamed from: n, reason: collision with root package name */
        public static final String f20999n = "coloros.customize.contacts.new_contact_expand_structure_name";

        /* renamed from: o, reason: collision with root package name */
        public static final String f21000o = "coloros.customize.contacts.show_imei_sv";

        /* renamed from: p, reason: collision with root package name */
        public static final String f21001p = "oppo.contacts.disable.roaming.assist";

        public final String a() {
            return f20992g;
        }

        public final String b() {
            return f21001p;
        }

        public final String c() {
            return f20993h;
        }

        public final String d() {
            return f20998m;
        }

        public final String e() {
            return f20999n;
        }

        public final String f() {
            return f20996k;
        }

        public final String g() {
            return f20988c;
        }

        public final String h() {
            return f20994i;
        }

        public final String i() {
            return f20995j;
        }

        public final String j() {
            return f20987b;
        }

        public final String k() {
            return f20997l;
        }

        public final String l() {
            return f20990e;
        }
    }

    /* compiled from: OSCustomizeFeature.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f21002a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final String f21003b = "oppo.phone.direct.fdn.dialing";

        /* renamed from: c, reason: collision with root package name */
        public static final String f21004c = "oppo.contacts.use.non.support.blacklist.mms";

        public final String a() {
            return f21004c;
        }

        public final String b() {
            return f21003b;
        }
    }

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
        d a19;
        d a20;
        d a21;
        d a22;
        d a23;
        d a24;
        d a25;
        d a26;
        d a27;
        d a28;
        d a29;
        d a30;
        d a31;
        d a32;
        d a33;
        d a34;
        d a35;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f34162b;
        a10 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$supportEdgeGesture$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
            
                r1 = com.customize.contacts.feature.OSCustomizeFeature.f20963d;
             */
            @Override // v9.InterfaceC1637a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Boolean invoke() {
                /*
                    r1 = this;
                    com.oplus.foundation.util.OsUtils r1 = com.oplus.foundation.util.OsUtils.f28275a
                    boolean r1 = r1.i()
                    r0 = 0
                    if (r1 == 0) goto La
                    goto L1a
                La:
                    android.content.pm.PackageManager r1 = com.customize.contacts.feature.OSCustomizeFeature.d()
                    if (r1 == 0) goto L1a
                    com.customize.contacts.feature.OSCustomizeFeature$a r0 = com.customize.contacts.feature.OSCustomizeFeature.a.f20986a
                    java.lang.String r0 = r0.j()
                    boolean r0 = r1.hasSystemFeature(r0)
                L1a:
                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.feature.OSCustomizeFeature$supportEdgeGesture$2.invoke():java.lang.Boolean");
            }
        });
        f20965f = a10;
        a11 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$showSdnServiceNumber$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.a.f20986a.g(), "com.android.contacts.show_sdn_service_number", false));
            }
        });
        f20966g = a11;
        a12 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$calllogFdnSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.b.f21002a.b(), "com.android.contacts.call_log_fdn_support", false));
            }
        });
        f20967h = a12;
        a13 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$removeOplusMmsTimeOut$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                context = OSCustomizeFeature.f20962c;
                return Boolean.valueOf(c.f(context, "com.android.mms", true));
            }
        });
        f20968i = a13;
        a14 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$wifiCallingCustomize$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.a.f20986a.l(), "", FeatureOption.o()));
            }
        });
        f20969j = a14;
        a15 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$calllogShowVilteViwifi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, "", "com.android.contacts.call_log_show_vilte_viwifi", false));
            }
        });
        f20970k = a15;
        a16 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$calllogShowHdIcon$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.a.f20986a.a(), "", true));
            }
        });
        f20971l = a16;
        a17 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$useNonSupportBlacklistMms$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.b.f21002a.a(), "com.android.contacts.use_non_support_blacklist_mms", false));
            }
        });
        f20972m = a17;
        a18 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$harassInterceptAnonymousEtc$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.a.f20986a.c(), "com.android.contacts.harass_intercept_anonymous_etc", false));
            }
        });
        f20973n = a18;
        a19 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$specialNumberExpandDetail$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.a.f20986a.h(), "com.android.contacts.special_number_expand_detail", false));
            }
        });
        f20974o = a19;
        a20 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$speedDialConsumerHotline$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.a.f20986a.i(), "com.android.contacts.speed_dial_consumer_hotline", false));
            }
        });
        f20975p = a20;
        a21 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$showSdnMore$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.a.f20986a.f(), "com.android.contacts.show_sdn_more", false));
            }
        });
        f20976q = a21;
        a22 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$supportCameraFlash$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                packageManager = OSCustomizeFeature.f20963d;
                return Boolean.valueOf(packageManager != null ? packageManager.hasSystemFeature("android.hardware.camera.flash") : false);
            }
        });
        f20977r = a22;
        a23 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$unknownLocationNotDisplay$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.a.f20986a.k(), "com.android.contacts.unknown_location_not_display", false));
            }
        });
        f20978s = a23;
        a24 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$hideSmsMenu$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.a.f20986a.d(), "com.android.contacts.hide_sms_menu", false));
            }
        });
        f20979t = a24;
        a25 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$newContactExpandStructureName$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.a.f20986a.e(), "com.android.contacts.new_contact_expand_structure_name", false));
            }
        });
        f20980u = a25;
        a26 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$disableRoamingAssistant$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSCustomizeFeature.a.f20986a.b(), "com.android.contacts.disable_roaming_assistant", false));
            }
        });
        f20981v = a26;
        a27 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$needPresetContacts$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, "com.android.contacts.preset_contacts", "com.android.contacts.preset_contacts", false));
            }
        });
        f20982w = a27;
        a28 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<String>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$operator$2
            @Override // v9.InterfaceC1637a
            public final String invoke() {
                ContentResolver contentResolver;
                contentResolver = OSCustomizeFeature.f20964e;
                return AppFeatureProviderUtils.i(contentResolver, "com.android.contacts.operator_mark", null);
            }
        });
        f20983x = a28;
        a29 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<String>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$regionMark$2
            @Override // v9.InterfaceC1637a
            public final String invoke() {
                ContentResolver contentResolver;
                contentResolver = OSCustomizeFeature.f20964e;
                return AppFeatureProviderUtils.i(contentResolver, "com.android.contacts.region_mark", "CN");
            }
        });
        f20984y = a29;
        a30 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$removeUstVvm$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSCustomizeFeature.f20963d;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, "", "com.android.contacts.remove_ust_vvm", false));
            }
        });
        f20985z = a30;
        a31 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$displaySdn$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                context = OSCustomizeFeature.f20962c;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(c0202a.c(context, contentResolver, "com.android.contacts.display_sdn_function"));
            }
        });
        f20955A = a31;
        a32 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<HashMap<String, String>>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$voiceMailNameMap$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final HashMap<String, String> invoke() {
                ContentResolver contentResolver;
                HashMap<String, String> E10;
                OSCustomizeFeature oSCustomizeFeature = OSCustomizeFeature.f20960a;
                contentResolver = OSCustomizeFeature.f20964e;
                E10 = oSCustomizeFeature.E(contentResolver);
                return E10;
            }
        });
        f20956B = a32;
        a33 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<HashMap<String, String>>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$speedDialMap$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final HashMap<String, String> invoke() {
                ContentResolver contentResolver;
                HashMap<String, String> y10;
                OSCustomizeFeature oSCustomizeFeature = OSCustomizeFeature.f20960a;
                contentResolver = OSCustomizeFeature.f20964e;
                y10 = oSCustomizeFeature.y(contentResolver);
                return y10;
            }
        });
        f20957C = a33;
        a34 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$hideVideoCall$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                ContentResolver contentResolver;
                contentResolver = OSCustomizeFeature.f20964e;
                return Boolean.valueOf(AppFeatureProviderUtils.p(contentResolver, "com.android.contacts.hide_video_call"));
            }
        });
        f20958D = a34;
        a35 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSCustomizeFeature$chakenPhone$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                boolean z10;
                ContentResolver contentResolver;
                if (FeatureOption.i()) {
                    contentResolver = OSCustomizeFeature.f20964e;
                    if (AppFeatureProviderUtils.p(contentResolver, "com.android.contacts.trusted_call_by_chaken")) {
                        z10 = true;
                        return Boolean.valueOf(z10);
                    }
                }
                z10 = false;
                return Boolean.valueOf(z10);
            }
        });
        f20959E = a35;
    }

    public static final boolean H() {
        return f20960a.p();
    }

    public static final void J() {
        String e10;
        OSCustomizeFeature oSCustomizeFeature = f20960a;
        boolean A10 = oSCustomizeFeature.A();
        boolean u10 = oSCustomizeFeature.u();
        boolean g10 = oSCustomizeFeature.g();
        boolean t10 = oSCustomizeFeature.t();
        boolean F10 = oSCustomizeFeature.F();
        boolean i10 = oSCustomizeFeature.i();
        boolean h10 = oSCustomizeFeature.h();
        boolean C10 = oSCustomizeFeature.C();
        boolean l10 = oSCustomizeFeature.l();
        boolean v10 = oSCustomizeFeature.v();
        boolean w10 = oSCustomizeFeature.w();
        boolean B10 = oSCustomizeFeature.B();
        boolean p10 = oSCustomizeFeature.p();
        boolean k10 = oSCustomizeFeature.k();
        String q10 = oSCustomizeFeature.q();
        String r10 = oSCustomizeFeature.r();
        boolean o10 = oSCustomizeFeature.o();
        HashMap<String, String> D10 = oSCustomizeFeature.D();
        HashMap<String, String> x10 = oSCustomizeFeature.x();
        boolean n10 = n();
        CommonFeatureOption commonFeatureOption = CommonFeatureOption.f28289a;
        e10 = StringsKt__IndentKt.e("\n                sSupportEdgeGesture = " + A10 + "\n                sShowSdnServiceNumber = " + u10 + "\n                sCalllogFdnSupport = " + g10 + "\n                removeOplusMmsTimeOut = " + t10 + "\n                sWifiCallingCustomize = " + F10 + "\n                calllogShowVilteViwifi = " + i10 + "\n                sCalllogShowHdIcon = " + h10 + "\n                sUseNonSupportBlacklistMms = " + C10 + "\n                sHarassInterceptAnonymousEtc = " + l10 + "\n                sSpecialNumberExpandDetail = " + v10 + "\n                sSpeedDialConsumerHotline = " + w10 + "\n                sUnknownLocationNotDisplay = " + B10 + "\n                sNewContactExpandStructureName = " + p10 + "\n                sDisableRoamingAssistant = " + k10 + "\n                sOperator = " + q10 + "\n                sRegionMark = " + r10 + "\n                sNeedPresetContacts = " + o10 + "\n                sVoiceMailNameMap = " + D10 + "\n                sSpeedDialMap = " + x10 + "\n                sHideVideoCall = " + n10 + "\n                businessDisable = " + commonFeatureOption.b() + "\n                insertContactsBusinessCardDisable = " + commonFeatureOption.f() + "\n                insertContactsQrCodeDisable = " + commonFeatureOption.g() + "\n                ");
        H7.b.e("OSCustomizeFeature", e10);
    }

    public static final void L(Context context) {
        i.f(context, "$context");
        f20961b = Boolean.valueOf(!c.c(context, "com.android.mms", true));
    }

    public static final boolean n() {
        return ((Boolean) f20958D.getValue()).booleanValue();
    }

    public final boolean A() {
        return ((Boolean) f20965f.getValue()).booleanValue();
    }

    public final boolean B() {
        return ((Boolean) f20978s.getValue()).booleanValue();
    }

    public final boolean C() {
        return ((Boolean) f20972m.getValue()).booleanValue();
    }

    public final HashMap<String, String> D() {
        return (HashMap) f20956B.getValue();
    }

    public final HashMap<String, String> E(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return new HashMap<>();
        }
        List<String> l10 = AppFeatureProviderUtils.l(contentResolver, "com.android.contacts.voice_mail_name");
        i.e(l10, "getStringList(cr, Custom…eFeature.VOICE_MAIL_NAME)");
        return I(l10);
    }

    public final boolean F() {
        return ((Boolean) f20969j.getValue()).booleanValue();
    }

    public final void G(Context context, PackageManager packageManager, ContentResolver contentResolver) {
        i.f(context, "context");
        f20962c = context;
        f20963d = packageManager;
        f20964e = contentResolver;
        K(context);
    }

    public final HashMap<String, String> I(List<String> list) {
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

    public final void K(final Context context) {
        N7.a.b().execute(new Runnable() { // from class: L3.a
            @Override // java.lang.Runnable
            public final void run() {
                OSCustomizeFeature.L(context);
            }
        });
    }

    public final boolean g() {
        return ((Boolean) f20967h.getValue()).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) f20971l.getValue()).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) f20970k.getValue()).booleanValue();
    }

    public final boolean j() {
        return ((Boolean) f20959E.getValue()).booleanValue();
    }

    public final boolean k() {
        return ((Boolean) f20981v.getValue()).booleanValue();
    }

    public final boolean l() {
        return ((Boolean) f20973n.getValue()).booleanValue();
    }

    public final boolean m() {
        return ((Boolean) f20979t.getValue()).booleanValue();
    }

    public final boolean o() {
        return ((Boolean) f20982w.getValue()).booleanValue();
    }

    public final boolean p() {
        return ((Boolean) f20980u.getValue()).booleanValue();
    }

    public final String q() {
        return (String) f20983x.getValue();
    }

    public final String r() {
        return (String) f20984y.getValue();
    }

    public final Boolean s() {
        return f20961b;
    }

    public final boolean t() {
        return ((Boolean) f20968i.getValue()).booleanValue();
    }

    public final boolean u() {
        return ((Boolean) f20966g.getValue()).booleanValue();
    }

    public final boolean v() {
        return ((Boolean) f20974o.getValue()).booleanValue();
    }

    public final boolean w() {
        return ((Boolean) f20975p.getValue()).booleanValue();
    }

    public final HashMap<String, String> x() {
        return (HashMap) f20957C.getValue();
    }

    public final HashMap<String, String> y(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return new HashMap<>();
        }
        List<String> l10 = AppFeatureProviderUtils.l(contentResolver, "com.android.contacts.speed_dial");
        i.e(l10, "getStringList(cr, CustomizeFeature.SPEED_DIAL)");
        return I(l10);
    }

    public final boolean z() {
        return ((Boolean) f20977r.getValue()).booleanValue();
    }
}
