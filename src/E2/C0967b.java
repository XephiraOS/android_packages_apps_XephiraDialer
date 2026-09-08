package e2;

import kotlin.jvm.internal.i;

/* compiled from: DialpadButtonInfo.kt */
/* renamed from: e2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0967b {

    /* renamed from: a, reason: collision with root package name */
    public final char f30578a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f30579b;

    /* renamed from: c, reason: collision with root package name */
    public final String f30580c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f30581d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f30582e;

    /* renamed from: f, reason: collision with root package name */
    public final String f30583f;

    public C0967b(char c10, boolean z10, String letterStr, boolean z11, Integer num, String contentDescription) {
        i.f(letterStr, "letterStr");
        i.f(contentDescription, "contentDescription");
        this.f30578a = c10;
        this.f30579b = z10;
        this.f30580c = letterStr;
        this.f30581d = z11;
        this.f30582e = num;
        this.f30583f = contentDescription;
    }

    public final String a() {
        return this.f30583f;
    }

    public final Integer b() {
        return this.f30582e;
    }

    public final String c() {
        return this.f30580c;
    }

    public final char d() {
        return this.f30578a;
    }

    public final boolean e() {
        return this.f30581d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0967b)) {
            return false;
        }
        C0967b c0967b = (C0967b) obj;
        if (this.f30578a == c0967b.f30578a && this.f30579b == c0967b.f30579b && i.b(this.f30580c, c0967b.f30580c) && this.f30581d == c0967b.f30581d && i.b(this.f30582e, c0967b.f30582e) && i.b(this.f30583f, c0967b.f30583f)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return this.f30579b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = Character.hashCode(this.f30578a) * 31;
        boolean z10 = this.f30579b;
        int i10 = 1;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        int hashCode3 = (((hashCode2 + i11) * 31) + this.f30580c.hashCode()) * 31;
        boolean z11 = this.f30581d;
        if (!z11) {
            i10 = z11 ? 1 : 0;
        }
        int i12 = (hashCode3 + i10) * 31;
        Integer num = this.f30582e;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return ((i12 + hashCode) * 31) + this.f30583f.hashCode();
    }

    public String toString() {
        return "DialpadButtonInfo(numberChar=" + this.f30578a + ", showNumberSpace=" + this.f30579b + ", letterStr=" + this.f30580c + ", showLetterSpace=" + this.f30581d + ", iconRes=" + this.f30582e + ", contentDescription=" + this.f30583f + ')';
    }
}
