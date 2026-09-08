package com.customize.contacts.feature;

import P7.c;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.VibratorManager;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.feature.OSPublicFeature;
import com.customize.contacts.feature.a;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import kotlin.LazyThreadSafetyMode;
import kotlin.text.StringsKt__IndentKt;
import m9.d;
import r0.C1500c;
import v9.InterfaceC1637a;

/* compiled from: OSPublicFeature.kt */
/* loaded from: classes3.dex */
public final class OSPublicFeature {

    /* renamed from: A, reason: collision with root package name */
    public static final d f21031A;

    /* renamed from: B, reason: collision with root package name */
    public static final d f21032B;

    /* renamed from: C, reason: collision with root package name */
    public static final d f21033C;

    /* renamed from: a, reason: collision with root package name */
    public static final OSPublicFeature f21034a = new OSPublicFeature();

    /* renamed from: b, reason: collision with root package name */
    public static Context f21035b;

    /* renamed from: c, reason: collision with root package name */
    public static PackageManager f21036c;

    /* renamed from: d, reason: collision with root package name */
    public static ContentResolver f21037d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f21038e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f21039f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f21040g;

    /* renamed from: h, reason: collision with root package name */
    public static final d f21041h;

    /* renamed from: i, reason: collision with root package name */
    public static final d f21042i;

    /* renamed from: j, reason: collision with root package name */
    public static final d f21043j;

    /* renamed from: k, reason: collision with root package name */
    public static final d f21044k;

    /* renamed from: l, reason: collision with root package name */
    public static final d f21045l;

    /* renamed from: m, reason: collision with root package name */
    public static final d f21046m;

    /* renamed from: n, reason: collision with root package name */
    public static final d f21047n;

    /* renamed from: o, reason: collision with root package name */
    public static final d f21048o;

    /* renamed from: p, reason: collision with root package name */
    public static final d f21049p;

    /* renamed from: q, reason: collision with root package name */
    public static final d f21050q;

    /* renamed from: r, reason: collision with root package name */
    public static final d f21051r;

    /* renamed from: s, reason: collision with root package name */
    public static final d f21052s;

    /* renamed from: t, reason: collision with root package name */
    public static final d f21053t;

    /* renamed from: u, reason: collision with root package name */
    public static final d f21054u;

    /* renamed from: v, reason: collision with root package name */
    public static final d f21055v;

    /* renamed from: w, reason: collision with root package name */
    public static final d f21056w;

    /* renamed from: x, reason: collision with root package name */
    public static final d f21057x;

    /* renamed from: y, reason: collision with root package name */
    public static final d f21058y;

    /* renamed from: z, reason: collision with root package name */
    public static final d f21059z;

    /* compiled from: OSPublicFeature.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f21060a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final String f21061b = "oppo.contacts.dualsim.changepin";

        /* renamed from: c, reason: collision with root package name */
        public static final String f21062c = "oppo.contacts.sim.contacts.entry";

        /* renamed from: d, reason: collision with root package name */
        public static final String f21063d = "oppo.contacts.filter.sim.callog";

        /* renamed from: e, reason: collision with root package name */
        public static final String f21064e = "oppo.contacts.support.card.recognize";

        /* renamed from: f, reason: collision with root package name */
        public static final String f21065f = "oppo.common_center.wifi.calling.customize";

        /* renamed from: g, reason: collision with root package name */
        public static final String f21066g = "oppo.contacts.support.voicemail";

        /* renamed from: h, reason: collision with root package name */
        public static final String f21067h = "oppo.mms.rcs.support";

        /* renamed from: i, reason: collision with root package name */
        public static final String f21068i = "oppo.common.contacts.support.cnip_name";

        /* renamed from: j, reason: collision with root package name */
        public static final String f21069j = "oppo.contacts.dialpad.show.wifi.icon";

        /* renamed from: k, reason: collision with root package name */
        public static final String f21070k = "oppo.contacts.support.bouygues.voicemail";

        public final String a() {
            return f21069j;
        }

        public final String b() {
            return f21062c;
        }

        public final String c() {
            return f21061b;
        }

        public final String d() {
            return f21067h;
        }

        public final String e() {
            return f21070k;
        }

        public final String f() {
            return f21064e;
        }

        public final String g() {
            return f21068i;
        }

        public final String h() {
            return f21066g;
        }

        public final String i() {
            return f21065f;
        }
    }

    /* compiled from: OSPublicFeature.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f21072a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final String f21073b = "oppo.qualcomm.gemini.support";

        /* renamed from: c, reason: collision with root package name */
        public static final String f21074c = "oppo.hw.manufacturer.mtk";

        /* renamed from: d, reason: collision with root package name */
        public static final String f21075d = "oppo.hw.manufacturer.qualcomm";

        /* renamed from: e, reason: collision with root package name */
        public static final String f21076e = "oppo.phone.hide.call.harass.intercept";

        /* renamed from: f, reason: collision with root package name */
        public static final String f21077f = "oppo.common_center.number.recognition";

        /* renamed from: g, reason: collision with root package name */
        public static final String f21078g = "oppo.all.client_7_5";

        /* renamed from: h, reason: collision with root package name */
        public static final String f21079h = "oppo.comm.smartdrive.support_ride_mode";

        /* renamed from: i, reason: collision with root package name */
        public static final String f21080i = "oppo.common_center.disable.ted.function";

        /* renamed from: j, reason: collision with root package name */
        public static final String f21081j = C1500c.f36271b;

        /* renamed from: k, reason: collision with root package name */
        public static final String f21082k = "oppo.multimedia.call.assistant.support";

        /* renamed from: l, reason: collision with root package name */
        public static final String f21083l = "oppo.phone.show.number.mark";

        public final String a() {
            return f21082k;
        }

        public final String b() {
            return f21078g;
        }

        public final String c() {
            return f21081j;
        }

        public final String d() {
            return f21074c;
        }

        public final String e() {
            return f21075d;
        }

        public final String f() {
            return f21076e;
        }

        public final String g() {
            return f21073b;
        }

        public final String h() {
            return f21083l;
        }

        public final String i() {
            return f21079h;
        }

        public final String j() {
            return f21077f;
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
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f34162b;
        a10 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$disableTedFunction$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                context = OSPublicFeature.f21035b;
                return Boolean.valueOf(!c.f(context, "com.ted.number", false));
            }
        });
        f21039f = a10;
        a11 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$allClient_7_5$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.b.f21072a.b(), "", true));
            }
        });
        f21040g = a11;
        a12 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$supportMtkGemini$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
            
                r1 = com.customize.contacts.feature.OSPublicFeature.f21036c;
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
                    goto L16
                La:
                    android.content.pm.PackageManager r1 = com.customize.contacts.feature.OSPublicFeature.d()
                    if (r1 == 0) goto L16
                    java.lang.String r0 = "mtk.gemini.support"
                    boolean r0 = r1.hasSystemFeature(r0)
                L16:
                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.feature.OSPublicFeature$supportMtkGemini$2.invoke():java.lang.Boolean");
            }
        });
        f21041h = a12;
        a13 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$supportOnePlusName$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
            
                r1 = com.customize.contacts.feature.OSPublicFeature.f21036c;
             */
            @Override // v9.InterfaceC1637a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Boolean invoke() {
                /*
                    r1 = this;
                    boolean r1 = com.oplus.foundation.util.OsUtils.k()
                    r0 = 1
                    if (r1 == 0) goto L1a
                    boolean r1 = com.customize.contacts.FeatureOption.o()
                    if (r1 == 0) goto Le
                    goto L1a
                Le:
                    android.content.pm.PackageManager r1 = com.customize.contacts.feature.OSPublicFeature.d()
                    if (r1 == 0) goto L1a
                    java.lang.String r0 = "oplus.companyname.not.support"
                    boolean r0 = r1.hasSystemFeature(r0)
                L1a:
                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.feature.OSPublicFeature$supportOnePlusName$2.invoke():java.lang.Boolean");
            }
        });
        f21042i = a13;
        a14 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$supportQualcommGemini$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
            
                r1 = com.customize.contacts.feature.OSPublicFeature.f21036c;
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
                    android.content.pm.PackageManager r1 = com.customize.contacts.feature.OSPublicFeature.d()
                    if (r1 == 0) goto L1a
                    com.customize.contacts.feature.OSPublicFeature$b r0 = com.customize.contacts.feature.OSPublicFeature.b.f21072a
                    java.lang.String r0 = r0.g()
                    boolean r0 = r1.hasSystemFeature(r0)
                L1a:
                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.feature.OSPublicFeature$supportQualcommGemini$2.invoke():java.lang.Boolean");
            }
        });
        f21043j = a14;
        a15 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$mtkPlatform$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                boolean hasSystemFeature;
                if (!OsUtils.f28275a.i()) {
                    packageManager = OSPublicFeature.f21036c;
                    hasSystemFeature = packageManager != null ? packageManager.hasSystemFeature(OSPublicFeature.b.f21072a.d()) : false;
                } else {
                    hasSystemFeature = B3.a.j();
                }
                return Boolean.valueOf(hasSystemFeature);
            }
        });
        f21044k = a15;
        a16 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$qualcommPlatform$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                boolean hasSystemFeature;
                if (!OsUtils.f28275a.i()) {
                    packageManager = OSPublicFeature.f21036c;
                    hasSystemFeature = packageManager != null ? packageManager.hasSystemFeature(OSPublicFeature.b.f21072a.e()) : false;
                } else {
                    hasSystemFeature = B3.a.k();
                }
                return Boolean.valueOf(hasSystemFeature);
            }
        });
        f21045l = a16;
        a17 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$dualSimChangePin$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.a.f21060a.c(), "com.android.contacts.dual_sim_change_pin", false));
            }
        });
        f21046m = a17;
        a18 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$displaySimContatcsEntry$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.a.f21060a.b(), "com.android.contacts.sim_contacts_entry", false));
            }
        });
        f21047n = a18;
        a19 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$supportRideMode$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                boolean b10;
                if (OsUtils.e()) {
                    b10 = false;
                } else {
                    a.C0202a c0202a = a.f21107a;
                    packageManager = OSPublicFeature.f21036c;
                    contentResolver = OSPublicFeature.f21037d;
                    b10 = c0202a.b(packageManager, contentResolver, OSPublicFeature.b.f21072a.i(), "com.android.contacts.support_ride_mode", false);
                }
                return Boolean.valueOf(b10);
            }
        });
        f21048o = a19;
        a20 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$hideBlockCalls$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.b.f21072a.f(), "com.android.contacts.hide_call_harass_intercept", false));
            }
        });
        f21049p = a20;
        a21 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$hardwareLinermotorSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                packageManager = OSPublicFeature.f21036c;
                return Boolean.valueOf(packageManager != null ? packageManager.hasSystemFeature(OSPublicFeature.b.f21072a.c()) : false);
            }
        });
        f21050q = a21;
        a22 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$supportCardRecognize$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.a.f21060a.f(), "com.android.contacts.support_card_recognize", false));
            }
        });
        f21051r = a22;
        a23 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$wifiCalling$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.a.f21060a.i(), "", FeatureOption.o()));
            }
        });
        f21052s = a23;
        a24 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$rcsVersion$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.a.f21060a.d(), "com.android.contacts.mms_rcs_support", false));
            }
        });
        f21053t = a24;
        a25 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$supportCnipName$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.a.f21060a.g(), "com.android.contacts.support_cnip_name", false));
            }
        });
        f21054u = a25;
        a26 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$supportVoicemail$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.a.f21060a.h(), "", FeatureOption.o()));
            }
        });
        f21055v = a26;
        a27 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$supportBouyguesVoiceMail$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.a.f21060a.e(), "", FeatureOption.o()));
            }
        });
        f21056w = a27;
        a28 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$dialPadShowWifiIcon$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.a.f21060a.a(), "", true));
            }
        });
        f21057x = a28;
        a29 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$supportCallAssistant$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.b.f21072a.a(), "", true));
            }
        });
        f21058y = a29;
        a30 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$phoneShowNumberMark$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager;
                ContentResolver contentResolver;
                a.C0202a c0202a = a.f21107a;
                packageManager = OSPublicFeature.f21036c;
                contentResolver = OSPublicFeature.f21037d;
                return Boolean.valueOf(c0202a.b(packageManager, contentResolver, OSPublicFeature.b.f21072a.h(), "com.android.contacts.phone_show_number_mark", false));
            }
        });
        f21059z = a30;
        a31 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$windowPreview$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                Resources resources;
                context = OSPublicFeature.f21035b;
                boolean z10 = false;
                if (context != null && (resources = context.getResources()) != null && resources.getInteger(R.integer.main_activity_window_preview_type) == 1) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
        });
        f21031A = a31;
        a32 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$supportVibrator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                context = OSPublicFeature.f21035b;
                Object systemService = context != null ? context.getSystemService("vibrator_manager") : null;
                return Boolean.valueOf(systemService instanceof VibratorManager ? ((VibratorManager) systemService).getDefaultVibrator().hasVibrator() : false);
            }
        });
        f21032B = a32;
        a33 = kotlin.a.a(lazyThreadSafetyMode, new InterfaceC1637a<Boolean>() { // from class: com.customize.contacts.feature.OSPublicFeature$supportImVibrator$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                Context context;
                boolean z10;
                Context context2;
                context = OSPublicFeature.f21035b;
                if (!D7.a.m(context, "oplus.software.vibrator_op7vibrator")) {
                    context2 = OSPublicFeature.f21035b;
                    if (D7.a.m(context2, "oplus.software.vibrator_lmvibrator")) {
                        z10 = true;
                        return Boolean.valueOf(z10);
                    }
                }
                z10 = false;
                return Boolean.valueOf(z10);
            }
        });
        f21033C = a33;
    }

    public static final void E(Context context) {
        boolean z10;
        OSPublicFeature oSPublicFeature = f21034a;
        if (!oSPublicFeature.A() && !oSPublicFeature.p()) {
            z10 = false;
        } else {
            z10 = true;
        }
        B3.a.e0(context, z10);
    }

    public static final boolean F() {
        return f21034a.z();
    }

    public static final void G() {
        String e10;
        OSPublicFeature oSPublicFeature = f21034a;
        e10 = StringsKt__IndentKt.e("\n                sDisableTedFunction = " + oSPublicFeature.g() + "\n                sSupportTedNumberRecognition = " + f21038e + "\n                sAllClient_7_5 = " + oSPublicFeature.e() + "\n                sSupportMtkGemini = " + oSPublicFeature.u() + "\n                sSupportQualcommGemini = " + oSPublicFeature.w() + "\n                sMtkPlatform = " + oSPublicFeature.l() + "\n                sQualcommPlatform = " + oSPublicFeature.n() + "\n                sDualSimChangePin = " + oSPublicFeature.i() + "\n                sSupportRideMode = " + oSPublicFeature.x() + "\n                sHideBlockCalls = " + oSPublicFeature.k() + "\n                sSupportVoicemail = " + oSPublicFeature.A() + "\n                sHardwareLinermotorSupport = " + oSPublicFeature.j() + "\n                sSupportCardRecognize = " + oSPublicFeature.r() + "\n                sWifiCalling = " + oSPublicFeature.B() + "\n                sRcsVersion = " + oSPublicFeature.o() + "\n                sSupportCnipName = " + oSPublicFeature.s() + "\n                sSupportBouyguesVoiceMail = " + oSPublicFeature.p() + "\n                sDialPadShowWifiIcon = " + oSPublicFeature.f() + "\n                sSupportCallAssistant = " + oSPublicFeature.q() + "\n                windowPreview = " + oSPublicFeature.C() + "\n                ");
        H7.b.e("OSPublicFeature", e10);
    }

    public static final void H() {
        boolean z10;
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            f21038e = Boolean.FALSE;
            return;
        }
        boolean z11 = true;
        if (!com.customize.contacts.feature.a.f21107a.b(f21036c, f21037d, b.f21072a.j(), "com.android.contacts.number_recognition", false) && !NumberRecognitionRegionSupportUtil.c()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!CommonFeatureOption.j() || (!FeatureOption.i() && (!z10 || f21034a.g()))) {
            z11 = false;
        }
        if (!z11) {
            E0.b.b();
        }
        f21038e = Boolean.valueOf(z11);
    }

    public final boolean A() {
        return ((Boolean) f21055v.getValue()).booleanValue();
    }

    public final boolean B() {
        return ((Boolean) f21052s.getValue()).booleanValue();
    }

    public final boolean C() {
        return ((Boolean) f21031A.getValue()).booleanValue();
    }

    public final void D(final Context context, PackageManager packageManager, ContentResolver contentResolver) {
        f21035b = context;
        f21036c = packageManager;
        f21037d = contentResolver;
        CommonOSPublicFeature.f28307a.d(context, u(), w(), FeatureOption.i());
        N7.a.b().execute(new Runnable() { // from class: L3.b
            @Override // java.lang.Runnable
            public final void run() {
                OSPublicFeature.E(context);
            }
        });
    }

    public final boolean e() {
        return ((Boolean) f21040g.getValue()).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) f21057x.getValue()).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) f21039f.getValue()).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) f21047n.getValue()).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) f21046m.getValue()).booleanValue();
    }

    public final boolean j() {
        return ((Boolean) f21050q.getValue()).booleanValue();
    }

    public final boolean k() {
        return ((Boolean) f21049p.getValue()).booleanValue();
    }

    public final boolean l() {
        return ((Boolean) f21044k.getValue()).booleanValue();
    }

    public final boolean m() {
        return ((Boolean) f21059z.getValue()).booleanValue();
    }

    public final boolean n() {
        return ((Boolean) f21045l.getValue()).booleanValue();
    }

    public final boolean o() {
        return ((Boolean) f21053t.getValue()).booleanValue();
    }

    public final boolean p() {
        return ((Boolean) f21056w.getValue()).booleanValue();
    }

    public final boolean q() {
        return ((Boolean) f21058y.getValue()).booleanValue();
    }

    public final boolean r() {
        return ((Boolean) f21051r.getValue()).booleanValue();
    }

    public final boolean s() {
        return ((Boolean) f21054u.getValue()).booleanValue();
    }

    public final boolean t() {
        return ((Boolean) f21033C.getValue()).booleanValue();
    }

    public final boolean u() {
        return ((Boolean) f21041h.getValue()).booleanValue();
    }

    public final boolean v() {
        return ((Boolean) f21042i.getValue()).booleanValue();
    }

    public final boolean w() {
        return ((Boolean) f21043j.getValue()).booleanValue();
    }

    public final boolean x() {
        return ((Boolean) f21048o.getValue()).booleanValue();
    }

    public final Boolean y() {
        return f21038e;
    }

    public final boolean z() {
        return ((Boolean) f21032B.getValue()).booleanValue();
    }
}
