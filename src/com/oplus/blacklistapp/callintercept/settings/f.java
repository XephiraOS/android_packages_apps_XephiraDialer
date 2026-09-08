package com.oplus.blacklistapp.callintercept.settings;

/* compiled from: CallHarassInterceptInfo.kt */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: h, reason: collision with root package name */
    public static final a f26878h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public int f26879a;

    /* renamed from: b, reason: collision with root package name */
    public String f26880b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f26881c;

    /* renamed from: d, reason: collision with root package name */
    public String f26882d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f26883e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f26884f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f26885g;

    /* compiled from: CallHarassInterceptInfo.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public f() {
        this(0, null, false, null, false, false, false, 127, null);
    }

    public final f a() {
        return new f(this.f26879a, this.f26880b, this.f26881c, this.f26882d, this.f26883e, false, false, 96, null);
    }

    public final boolean b() {
        return this.f26881c;
    }

    public final String c() {
        return this.f26880b;
    }

    public final boolean d() {
        return this.f26883e;
    }

    public final int e() {
        return this.f26879a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f26879a == fVar.f26879a && kotlin.jvm.internal.i.b(this.f26880b, fVar.f26880b) && this.f26881c == fVar.f26881c && kotlin.jvm.internal.i.b(this.f26882d, fVar.f26882d) && this.f26883e == fVar.f26883e && this.f26884f == fVar.f26884f && this.f26885g == fVar.f26885g) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f26882d;
    }

    public final boolean g() {
        return this.f26884f;
    }

    public final boolean h() {
        return this.f26885g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.f26879a) * 31) + this.f26880b.hashCode()) * 31;
        boolean z10 = this.f26881c;
        int i10 = 1;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        int hashCode2 = (((hashCode + i11) * 31) + this.f26882d.hashCode()) * 31;
        boolean z11 = this.f26883e;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (hashCode2 + i12) * 31;
        boolean z12 = this.f26884f;
        int i14 = z12;
        if (z12 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z13 = this.f26885g;
        if (!z13) {
            i10 = z13 ? 1 : 0;
        }
        return i15 + i10;
    }

    public final void i(boolean z10) {
        this.f26881c = z10;
    }

    public final void j(String str) {
        kotlin.jvm.internal.i.f(str, "<set-?>");
        this.f26880b = str;
    }

    public final void k(boolean z10) {
        this.f26883e = z10;
    }

    public final void l(boolean z10) {
        this.f26884f = z10;
    }

    public final void m(int i10) {
        this.f26879a = i10;
    }

    public final void n(boolean z10) {
        this.f26885g = z10;
    }

    public final void o(String str) {
        kotlin.jvm.internal.i.f(str, "<set-?>");
        this.f26882d = str;
    }

    public String toString() {
        return "CallHarassInterceptInfo(itemType=" + this.f26879a + ", content=" + this.f26880b + ", checked=" + this.f26881c + ", tips=" + this.f26882d + ", enable=" + this.f26883e + ", isFirst=" + this.f26884f + ", isLast=" + this.f26885g + ")";
    }

    public f(int i10, String content, boolean z10, String tips, boolean z11, boolean z12, boolean z13) {
        kotlin.jvm.internal.i.f(content, "content");
        kotlin.jvm.internal.i.f(tips, "tips");
        this.f26879a = i10;
        this.f26880b = content;
        this.f26881c = z10;
        this.f26882d = tips;
        this.f26883e = z11;
        this.f26884f = z12;
        this.f26885g = z13;
    }

    public /* synthetic */ f(int i10, String str, boolean z10, String str2, boolean z11, boolean z12, boolean z13, int i11, kotlin.jvm.internal.f fVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? "" : str2, (i11 & 16) != 0 ? true : z11, (i11 & 32) != 0 ? false : z12, (i11 & 64) != 0 ? false : z13);
    }
}
