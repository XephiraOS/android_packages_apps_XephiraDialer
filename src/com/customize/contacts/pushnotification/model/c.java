package com.customize.contacts.pushnotification.model;

/* compiled from: PushNotificationBean.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: o, reason: collision with root package name */
    public static final a f21762o = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public long f21763a;

    /* renamed from: b, reason: collision with root package name */
    public long f21764b;

    /* renamed from: c, reason: collision with root package name */
    public long f21765c;

    /* renamed from: d, reason: collision with root package name */
    public int f21766d;

    /* renamed from: e, reason: collision with root package name */
    public int f21767e;

    /* renamed from: f, reason: collision with root package name */
    public int f21768f;

    /* renamed from: g, reason: collision with root package name */
    public String f21769g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21770h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21771i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f21772j;

    /* renamed from: k, reason: collision with root package name */
    public String f21773k;

    /* renamed from: l, reason: collision with root package name */
    public String f21774l;

    /* renamed from: m, reason: collision with root package name */
    public int f21775m;

    /* renamed from: n, reason: collision with root package name */
    public long f21776n;

    /* compiled from: PushNotificationBean.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public c(long j10, long j11, long j12, int i10, int i11, int i12, String notificationStringId, boolean z10, boolean z11, boolean z12, String languageRestrict, String regionRestrict, int i13, long j13) {
        kotlin.jvm.internal.i.f(notificationStringId, "notificationStringId");
        kotlin.jvm.internal.i.f(languageRestrict, "languageRestrict");
        kotlin.jvm.internal.i.f(regionRestrict, "regionRestrict");
        this.f21763a = j10;
        this.f21764b = j11;
        this.f21765c = j12;
        this.f21766d = i10;
        this.f21767e = i11;
        this.f21768f = i12;
        this.f21769g = notificationStringId;
        this.f21770h = z10;
        this.f21771i = z11;
        this.f21772j = z12;
        this.f21773k = languageRestrict;
        this.f21774l = regionRestrict;
        this.f21775m = i13;
        this.f21776n = j13;
    }

    public final long a() {
        return this.f21765c;
    }

    public final int b() {
        return this.f21766d;
    }

    public final long c() {
        return this.f21763a;
    }

    public final String d() {
        return this.f21773k;
    }

    public final long e() {
        return this.f21764b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                return kotlin.jvm.internal.i.b(this.f21769g, ((c) obj).f21769g);
            }
            return false;
        }
        return true;
    }

    public final long f() {
        return this.f21776n;
    }

    public final int g() {
        return this.f21767e;
    }

    public final String h() {
        return this.f21769g;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final int i() {
        return this.f21768f;
    }

    public final String j() {
        return this.f21774l;
    }

    public final boolean k() {
        return this.f21771i;
    }

    public final boolean l() {
        return this.f21770h;
    }

    public final boolean m() {
        return this.f21772j;
    }

    public final int n() {
        return this.f21775m;
    }

    public final void o(int i10) {
        this.f21766d = i10;
    }

    public final void p(long j10) {
        this.f21764b = j10;
    }

    public final void q(long j10) {
        this.f21776n = j10;
    }

    public final void r(int i10) {
        this.f21775m = i10;
    }

    public String toString() {
        return "PushNotificationBean(id=" + this.f21763a + ", lastDisplayTime=" + this.f21764b + ", displayPeriod=" + this.f21765c + ", hasIgnoredTime=" + this.f21766d + ", maxIgnoreTime=" + this.f21767e + ", priority=" + this.f21768f + ", notificationStringId=" + this.f21769g + ", showIgnoreButton=" + this.f21770h + ", showFirstActionButton=" + this.f21771i + ", showSecondActionButton=" + this.f21772j + ", languageRestrict=" + this.f21773k + ", regionRestrict=" + this.f21774l + ", state=" + this.f21775m + ", lastQueryTime=" + this.f21776n + ")";
    }

    public /* synthetic */ c(long j10, long j11, long j12, int i10, int i11, int i12, String str, boolean z10, boolean z11, boolean z12, String str2, String str3, int i13, long j13, int i14, kotlin.jvm.internal.f fVar) {
        this((i14 & 1) != 0 ? -1L : j10, (i14 & 2) == 0 ? j11 : -1L, (i14 & 4) != 0 ? 0L : j12, (i14 & 8) != 0 ? 0 : i10, (i14 & 16) != 0 ? 1 : i11, (i14 & 32) != 0 ? Integer.MAX_VALUE : i12, (i14 & 64) != 0 ? "" : str, (i14 & 128) != 0 ? false : z10, (i14 & 256) != 0 ? false : z11, (i14 & 512) != 0 ? false : z12, (i14 & 1024) != 0 ? "" : str2, (i14 & 2048) != 0 ? "" : str3, (i14 & 4096) != 0 ? 0 : i13, (i14 & 8192) != 0 ? 0L : j13);
    }

    public c() {
        this(-1L, 0L, 0L, 0, 0, 0, null, false, false, false, null, null, 0, 0L, 16382, null);
    }
}
