package com.android.contacts.calllog;

import android.content.Context;
import android.database.MatrixCursor;
import android.util.Log;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusNumberMarkUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import v9.InterfaceC1637a;

/* compiled from: CallLogItemCacheManager.kt */
/* loaded from: classes.dex */
public final class CallLogItemCacheManager {

    /* renamed from: c, reason: collision with root package name */
    public static final c f13737c = new c(null);

    /* renamed from: d, reason: collision with root package name */
    public static final m9.d<CallLogItemCacheManager> f13738d;

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f13739a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f13740b;

    /* compiled from: CallLogItemCacheManager.kt */
    /* loaded from: classes.dex */
    public interface a {
        void a(MatrixCursor matrixCursor);
    }

    /* compiled from: CallLogItemCacheManager.kt */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @E4.c("id")
        public Long f13742a;

        /* renamed from: b, reason: collision with root package name */
        @E4.c("number")
        public String f13743b;

        /* renamed from: c, reason: collision with root package name */
        @E4.c(BreenoCallContract.BaseColumns.DATE)
        public Long f13744c;

        /* renamed from: d, reason: collision with root package name */
        @E4.c("duration")
        public Long f13745d;

        /* renamed from: e, reason: collision with root package name */
        @E4.c(OplusNumberMarkUtils.OplusContact.OPLUS_MARK_CONTACTS_CALL_TYPE)
        public Integer f13746e;

        /* renamed from: f, reason: collision with root package name */
        @E4.c("voicemailUri")
        public String f13747f;

        /* renamed from: g, reason: collision with root package name */
        @E4.c("geocodedLocation")
        public String f13748g;

        /* renamed from: h, reason: collision with root package name */
        @E4.c("name")
        public String f13749h;

        /* renamed from: i, reason: collision with root package name */
        @E4.c("lookupUri")
        public String f13750i;

        /* renamed from: j, reason: collision with root package name */
        @E4.c("normalizedNumber")
        public String f13751j;

        /* renamed from: k, reason: collision with root package name */
        @E4.c("photoId")
        public Long f13752k;

        /* renamed from: l, reason: collision with root package name */
        @E4.c("formattedNumber")
        public String f13753l;

        /* renamed from: m, reason: collision with root package name */
        @E4.c("simId")
        public Integer f13754m;

        /* renamed from: n, reason: collision with root package name */
        @E4.c("ringTime")
        public Integer f13755n;

        /* renamed from: o, reason: collision with root package name */
        @E4.c("photoUri")
        public String f13756o;

        /* renamed from: p, reason: collision with root package name */
        @E4.c("features")
        public Integer f13757p;

        /* renamed from: q, reason: collision with root package name */
        @E4.c("countryIso")
        public String f13758q;

        /* renamed from: r, reason: collision with root package name */
        @E4.c("hasRecog")
        public String f13759r;

        /* renamed from: s, reason: collision with root package name */
        @E4.c("cnipName")
        public String f13760s;

        /* renamed from: t, reason: collision with root package name */
        @E4.c("roamType")
        public Integer f13761t;

        /* renamed from: u, reason: collision with root package name */
        @E4.c("uniqueId")
        public String f13762u;

        /* renamed from: v, reason: collision with root package name */
        @E4.c("identifyName")
        public String f13763v;

        /* renamed from: w, reason: collision with root package name */
        @E4.c("data1")
        public String f13764w;

        public b(Long l10, String str, Long l11, Long l12, Integer num, String str2, String str3, String str4, String str5, String str6, Long l13, String str7, Integer num2, Integer num3, String str8, Integer num4, String str9, String str10, String str11, Integer num5, String str12, String str13, String str14) {
            this.f13742a = l10;
            this.f13743b = str;
            this.f13744c = l11;
            this.f13745d = l12;
            this.f13746e = num;
            this.f13747f = str2;
            this.f13748g = str3;
            this.f13749h = str4;
            this.f13750i = str5;
            this.f13751j = str6;
            this.f13752k = l13;
            this.f13753l = str7;
            this.f13754m = num2;
            this.f13755n = num3;
            this.f13756o = str8;
            this.f13757p = num4;
            this.f13758q = str9;
            this.f13759r = str10;
            this.f13760s = str11;
            this.f13761t = num5;
            this.f13762u = str12;
            this.f13763v = str13;
            this.f13764w = str14;
        }

        public final Integer a() {
            return this.f13746e;
        }

        public final String b() {
            return this.f13760s;
        }

        public final String c() {
            return this.f13758q;
        }

        public final String d() {
            return this.f13764w;
        }

        public final Long e() {
            return this.f13744c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (kotlin.jvm.internal.i.b(this.f13742a, bVar.f13742a) && kotlin.jvm.internal.i.b(this.f13743b, bVar.f13743b) && kotlin.jvm.internal.i.b(this.f13744c, bVar.f13744c) && kotlin.jvm.internal.i.b(this.f13745d, bVar.f13745d) && kotlin.jvm.internal.i.b(this.f13746e, bVar.f13746e) && kotlin.jvm.internal.i.b(this.f13747f, bVar.f13747f) && kotlin.jvm.internal.i.b(this.f13748g, bVar.f13748g) && kotlin.jvm.internal.i.b(this.f13749h, bVar.f13749h) && kotlin.jvm.internal.i.b(this.f13750i, bVar.f13750i) && kotlin.jvm.internal.i.b(this.f13751j, bVar.f13751j) && kotlin.jvm.internal.i.b(this.f13752k, bVar.f13752k) && kotlin.jvm.internal.i.b(this.f13753l, bVar.f13753l) && kotlin.jvm.internal.i.b(this.f13754m, bVar.f13754m) && kotlin.jvm.internal.i.b(this.f13755n, bVar.f13755n) && kotlin.jvm.internal.i.b(this.f13756o, bVar.f13756o) && kotlin.jvm.internal.i.b(this.f13757p, bVar.f13757p) && kotlin.jvm.internal.i.b(this.f13758q, bVar.f13758q) && kotlin.jvm.internal.i.b(this.f13759r, bVar.f13759r) && kotlin.jvm.internal.i.b(this.f13760s, bVar.f13760s) && kotlin.jvm.internal.i.b(this.f13761t, bVar.f13761t) && kotlin.jvm.internal.i.b(this.f13762u, bVar.f13762u) && kotlin.jvm.internal.i.b(this.f13763v, bVar.f13763v) && kotlin.jvm.internal.i.b(this.f13764w, bVar.f13764w)) {
                return true;
            }
            return false;
        }

        public final Long f() {
            return this.f13745d;
        }

        public final Integer g() {
            return this.f13757p;
        }

        public final String h() {
            return this.f13753l;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int hashCode7;
            int hashCode8;
            int hashCode9;
            int hashCode10;
            int hashCode11;
            int hashCode12;
            int hashCode13;
            int hashCode14;
            int hashCode15;
            int hashCode16;
            int hashCode17;
            int hashCode18;
            int hashCode19;
            int hashCode20;
            int hashCode21;
            int hashCode22;
            Long l10 = this.f13742a;
            int i10 = 0;
            if (l10 == null) {
                hashCode = 0;
            } else {
                hashCode = l10.hashCode();
            }
            int i11 = hashCode * 31;
            String str = this.f13743b;
            if (str == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str.hashCode();
            }
            int i12 = (i11 + hashCode2) * 31;
            Long l11 = this.f13744c;
            if (l11 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = l11.hashCode();
            }
            int i13 = (i12 + hashCode3) * 31;
            Long l12 = this.f13745d;
            if (l12 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = l12.hashCode();
            }
            int i14 = (i13 + hashCode4) * 31;
            Integer num = this.f13746e;
            if (num == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = num.hashCode();
            }
            int i15 = (i14 + hashCode5) * 31;
            String str2 = this.f13747f;
            if (str2 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str2.hashCode();
            }
            int i16 = (i15 + hashCode6) * 31;
            String str3 = this.f13748g;
            if (str3 == null) {
                hashCode7 = 0;
            } else {
                hashCode7 = str3.hashCode();
            }
            int i17 = (i16 + hashCode7) * 31;
            String str4 = this.f13749h;
            if (str4 == null) {
                hashCode8 = 0;
            } else {
                hashCode8 = str4.hashCode();
            }
            int i18 = (i17 + hashCode8) * 31;
            String str5 = this.f13750i;
            if (str5 == null) {
                hashCode9 = 0;
            } else {
                hashCode9 = str5.hashCode();
            }
            int i19 = (i18 + hashCode9) * 31;
            String str6 = this.f13751j;
            if (str6 == null) {
                hashCode10 = 0;
            } else {
                hashCode10 = str6.hashCode();
            }
            int i20 = (i19 + hashCode10) * 31;
            Long l13 = this.f13752k;
            if (l13 == null) {
                hashCode11 = 0;
            } else {
                hashCode11 = l13.hashCode();
            }
            int i21 = (i20 + hashCode11) * 31;
            String str7 = this.f13753l;
            if (str7 == null) {
                hashCode12 = 0;
            } else {
                hashCode12 = str7.hashCode();
            }
            int i22 = (i21 + hashCode12) * 31;
            Integer num2 = this.f13754m;
            if (num2 == null) {
                hashCode13 = 0;
            } else {
                hashCode13 = num2.hashCode();
            }
            int i23 = (i22 + hashCode13) * 31;
            Integer num3 = this.f13755n;
            if (num3 == null) {
                hashCode14 = 0;
            } else {
                hashCode14 = num3.hashCode();
            }
            int i24 = (i23 + hashCode14) * 31;
            String str8 = this.f13756o;
            if (str8 == null) {
                hashCode15 = 0;
            } else {
                hashCode15 = str8.hashCode();
            }
            int i25 = (i24 + hashCode15) * 31;
            Integer num4 = this.f13757p;
            if (num4 == null) {
                hashCode16 = 0;
            } else {
                hashCode16 = num4.hashCode();
            }
            int i26 = (i25 + hashCode16) * 31;
            String str9 = this.f13758q;
            if (str9 == null) {
                hashCode17 = 0;
            } else {
                hashCode17 = str9.hashCode();
            }
            int i27 = (i26 + hashCode17) * 31;
            String str10 = this.f13759r;
            if (str10 == null) {
                hashCode18 = 0;
            } else {
                hashCode18 = str10.hashCode();
            }
            int i28 = (i27 + hashCode18) * 31;
            String str11 = this.f13760s;
            if (str11 == null) {
                hashCode19 = 0;
            } else {
                hashCode19 = str11.hashCode();
            }
            int i29 = (i28 + hashCode19) * 31;
            Integer num5 = this.f13761t;
            if (num5 == null) {
                hashCode20 = 0;
            } else {
                hashCode20 = num5.hashCode();
            }
            int i30 = (i29 + hashCode20) * 31;
            String str12 = this.f13762u;
            if (str12 == null) {
                hashCode21 = 0;
            } else {
                hashCode21 = str12.hashCode();
            }
            int i31 = (i30 + hashCode21) * 31;
            String str13 = this.f13763v;
            if (str13 == null) {
                hashCode22 = 0;
            } else {
                hashCode22 = str13.hashCode();
            }
            int i32 = (i31 + hashCode22) * 31;
            String str14 = this.f13764w;
            if (str14 != null) {
                i10 = str14.hashCode();
            }
            return i32 + i10;
        }

        public final String i() {
            return this.f13748g;
        }

        public final String j() {
            return this.f13759r;
        }

        public final Long k() {
            return this.f13742a;
        }

        public final String l() {
            return this.f13763v;
        }

        public final String m() {
            return this.f13750i;
        }

        public final String n() {
            return this.f13749h;
        }

        public final String o() {
            return this.f13751j;
        }

        public final String p() {
            return this.f13743b;
        }

        public final Long q() {
            return this.f13752k;
        }

        public final String r() {
            return this.f13756o;
        }

        public final Integer s() {
            return this.f13755n;
        }

        public final Integer t() {
            return this.f13761t;
        }

        public String toString() {
            return "CallLogItemCacheBean(id=" + this.f13742a + ", number=" + this.f13743b + ", date=" + this.f13744c + ", duration=" + this.f13745d + ", callType=" + this.f13746e + ", voicemailUri=" + this.f13747f + ", geocodedLocation=" + this.f13748g + ", name=" + this.f13749h + ", lookupUri=" + this.f13750i + ", normalizedNumber=" + this.f13751j + ", photoId=" + this.f13752k + ", formattedNumber=" + this.f13753l + ", simId=" + this.f13754m + ", ringTime=" + this.f13755n + ", photoUri=" + this.f13756o + ", features=" + this.f13757p + ", countryIso=" + this.f13758q + ", hasRecog=" + this.f13759r + ", cnipName=" + this.f13760s + ", roamType=" + this.f13761t + ", uniqueId=" + this.f13762u + ", identifyName=" + this.f13763v + ", data1=" + this.f13764w + ")";
        }

        public final Integer u() {
            return this.f13754m;
        }

        public final String v() {
            return this.f13762u;
        }

        public final String w() {
            return this.f13747f;
        }
    }

    /* compiled from: CallLogItemCacheManager.kt */
    /* loaded from: classes.dex */
    public static final class c {
        public c() {
        }

        public final CallLogItemCacheManager a() {
            return (CallLogItemCacheManager) CallLogItemCacheManager.f13738d.getValue();
        }

        public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: CallLogItemCacheManager.kt */
    /* loaded from: classes.dex */
    public static final class d extends J4.a<List<? extends b>> {
    }

    /* compiled from: CallLogItemCacheManager.kt */
    /* loaded from: classes.dex */
    public static final class e extends J4.a<List<? extends b>> {
    }

    static {
        m9.d<CallLogItemCacheManager> a10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<CallLogItemCacheManager>() { // from class: com.android.contacts.calllog.CallLogItemCacheManager$Companion$instance$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CallLogItemCacheManager invoke() {
                return new CallLogItemCacheManager(null);
            }
        });
        f13738d = a10;
    }

    public /* synthetic */ CallLogItemCacheManager(kotlin.jvm.internal.f fVar) {
        this();
    }

    public final void c(int i10, b item) {
        kotlin.jvm.internal.i.f(item, "item");
        if (this.f13739a.size() > i10) {
            this.f13739a.set(i10, item);
        } else {
            this.f13739a.add(item);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0275  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.database.MatrixCursor d(java.util.List<com.android.contacts.calllog.CallLogItemCacheManager.b> r28) {
        /*
            Method dump skipped, instructions count: 652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.calllog.CallLogItemCacheManager.d(java.util.List):android.database.MatrixCursor");
    }

    public final void e() {
        this.f13739a.clear();
    }

    public final void f(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        C1248i.d(C1241e0.f34422a, S.a(), null, new CallLogItemCacheManager$generatorCache$1(context, this, new com.google.gson.d().t(this.f13739a, new d().getType()), null), 2, null);
    }

    public final MatrixCursor g(Context context) {
        Object b10;
        Boolean bool;
        long currentTimeMillis = System.currentTimeMillis();
        String string = context.getSharedPreferences("calllog_cache", 0).getString("CALL_LOG_ITEM_CACHE", null);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        try {
            Result.a aVar = Result.f34166a;
            if (string != null) {
                long currentTimeMillis3 = System.currentTimeMillis();
                List<b> list = (List) new com.google.gson.d().k(string, new e().getType());
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                if (list != null) {
                    bool = Boolean.valueOf(!list.isEmpty());
                } else {
                    bool = null;
                }
                kotlin.jvm.internal.i.c(bool);
                if (bool.booleanValue()) {
                    this.f13739a.clear();
                    this.f13739a.addAll(list);
                    this.f13740b = true;
                    long currentTimeMillis5 = System.currentTimeMillis();
                    MatrixCursor d10 = d(list);
                    H7.b.e("CallLogItemCacheManager", "getCallLogCursor: spLoadTake: " + currentTimeMillis2 + ", jsonParseTake: " + currentTimeMillis4 + ", buildCursorTake: " + (System.currentTimeMillis() - currentTimeMillis5));
                    return d10;
                }
            } else {
                string = null;
            }
            b10 = Result.b(string);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d11 = Result.d(b10);
        if (d11 != null) {
            H7.b.c("CallLogItemCacheManager", "e = " + d11);
        }
        return null;
    }

    public final void h(Context context, boolean z10, a callBack) {
        Object b10;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(callBack, "callBack");
        try {
            Result.a aVar = Result.f34166a;
            H7.b.e("CallLogItemCacheManager", "readFromCache: mainThread: " + z10 + ", initLoaded: " + this.f13740b + ", cache size: " + this.f13739a.size());
            if (z10) {
                if (this.f13740b) {
                    callBack.a(d(this.f13739a));
                } else {
                    callBack.a(g(context));
                }
            } else {
                callBack.a(g(context));
            }
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("ExceptionUtils", "Exception when invoke block : " + d10);
        }
    }

    public CallLogItemCacheManager() {
        this.f13739a = new CopyOnWriteArrayList<>();
    }
}
