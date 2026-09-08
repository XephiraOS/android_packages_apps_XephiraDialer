package com.android.contacts.detail;

/* compiled from: CallLogDeleteHelper.kt */
/* loaded from: classes.dex */
public final class D {

    /* renamed from: a, reason: collision with root package name */
    public final int f14390a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14391b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14392c;

    public D(int i10, int i11, String str) {
        this.f14390a = i10;
        this.f14391b = i11;
        this.f14392c = str;
    }

    public final int a() {
        return this.f14391b;
    }

    public final int b() {
        return this.f14390a;
    }

    public final String c() {
        return this.f14392c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d10 = (D) obj;
        if (this.f14390a == d10.f14390a && this.f14391b == d10.f14391b && kotlin.jvm.internal.i.b(this.f14392c, d10.f14392c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((Integer.hashCode(this.f14390a) * 31) + Integer.hashCode(this.f14391b)) * 31;
        String str = this.f14392c;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "CallLogDeleteScene(scene=" + this.f14390a + ", action=" + this.f14391b + ", timeInterval=" + this.f14392c + ")";
    }
}
