package com.android.contacts.scenecard;

/* compiled from: SceneSimCardStateManager.kt */
/* loaded from: classes.dex */
public final class Y {

    /* renamed from: a, reason: collision with root package name */
    public final int f17253a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17254b;

    /* renamed from: c, reason: collision with root package name */
    public final long f17255c;

    /* renamed from: d, reason: collision with root package name */
    public final String f17256d;

    /* renamed from: e, reason: collision with root package name */
    public final long f17257e;

    /* renamed from: f, reason: collision with root package name */
    public final int f17258f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f17259g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f17260h;

    public Y(int i10, String sim1Name, long j10, String sim2Name, long j11, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.i.f(sim1Name, "sim1Name");
        kotlin.jvm.internal.i.f(sim2Name, "sim2Name");
        this.f17253a = i10;
        this.f17254b = sim1Name;
        this.f17255c = j10;
        this.f17256d = sim2Name;
        this.f17257e = j11;
        this.f17258f = i11;
        this.f17259g = z10;
        this.f17260h = z11;
    }

    public static /* synthetic */ Y b(Y y10, int i10, String str, long j10, String str2, long j11, int i11, boolean z10, boolean z11, int i12, Object obj) {
        int i13;
        String str3;
        long j12;
        String str4;
        long j13;
        int i14;
        boolean z12;
        boolean z13;
        if ((i12 & 1) != 0) {
            i13 = y10.f17253a;
        } else {
            i13 = i10;
        }
        if ((i12 & 2) != 0) {
            str3 = y10.f17254b;
        } else {
            str3 = str;
        }
        if ((i12 & 4) != 0) {
            j12 = y10.f17255c;
        } else {
            j12 = j10;
        }
        if ((i12 & 8) != 0) {
            str4 = y10.f17256d;
        } else {
            str4 = str2;
        }
        if ((i12 & 16) != 0) {
            j13 = y10.f17257e;
        } else {
            j13 = j11;
        }
        if ((i12 & 32) != 0) {
            i14 = y10.f17258f;
        } else {
            i14 = i11;
        }
        if ((i12 & 64) != 0) {
            z12 = y10.f17259g;
        } else {
            z12 = z10;
        }
        if ((i12 & 128) != 0) {
            z13 = y10.f17260h;
        } else {
            z13 = z11;
        }
        return y10.a(i13, str3, j12, str4, j13, i14, z12, z13);
    }

    public final Y a(int i10, String sim1Name, long j10, String sim2Name, long j11, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.i.f(sim1Name, "sim1Name");
        kotlin.jvm.internal.i.f(sim2Name, "sim2Name");
        return new Y(i10, sim1Name, j10, sim2Name, j11, i11, z10, z11);
    }

    public final int c() {
        return this.f17253a;
    }

    public final int d() {
        return this.f17258f;
    }

    public final long e() {
        return this.f17255c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Y)) {
            return false;
        }
        Y y10 = (Y) obj;
        if (this.f17253a == y10.f17253a && kotlin.jvm.internal.i.b(this.f17254b, y10.f17254b) && this.f17255c == y10.f17255c && kotlin.jvm.internal.i.b(this.f17256d, y10.f17256d) && this.f17257e == y10.f17257e && this.f17258f == y10.f17258f && this.f17259g == y10.f17259g && this.f17260h == y10.f17260h) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f17254b;
    }

    public final boolean g() {
        return this.f17259g;
    }

    public final long h() {
        return this.f17257e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((Integer.hashCode(this.f17253a) * 31) + this.f17254b.hashCode()) * 31) + Long.hashCode(this.f17255c)) * 31) + this.f17256d.hashCode()) * 31) + Long.hashCode(this.f17257e)) * 31) + Integer.hashCode(this.f17258f)) * 31;
        boolean z10 = this.f17259g;
        int i10 = 1;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        int i12 = (hashCode + i11) * 31;
        boolean z11 = this.f17260h;
        if (!z11) {
            i10 = z11 ? 1 : 0;
        }
        return i12 + i10;
    }

    public final String i() {
        return this.f17256d;
    }

    public final boolean j() {
        return this.f17260h;
    }

    public String toString() {
        return "SimCardStates(availableSimCount=" + this.f17253a + ", sim1Name=" + this.f17254b + ", sim1Id=" + this.f17255c + ", sim2Name=" + this.f17256d + ", sim2Id=" + this.f17257e + ", defaultSlotId=" + this.f17258f + ", sim1WifiCalling=" + this.f17259g + ", sim2WifiCalling=" + this.f17260h + ")";
    }

    public /* synthetic */ Y(int i10, String str, long j10, String str2, long j11, int i11, boolean z10, boolean z11, int i12, kotlin.jvm.internal.f fVar) {
        this(i10, str, j10, str2, j11, i11, (i12 & 64) != 0 ? false : z10, (i12 & 128) != 0 ? false : z11);
    }
}
