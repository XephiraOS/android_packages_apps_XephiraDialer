package com.oplus.contacts.list.settings;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ContactsMainListSettingData.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f28057a;

    /* renamed from: b, reason: collision with root package name */
    public final String f28058b;

    /* renamed from: c, reason: collision with root package name */
    public final String f28059c;

    /* renamed from: d, reason: collision with root package name */
    public final String f28060d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f28061e;

    /* renamed from: f, reason: collision with root package name */
    public final String f28062f;

    /* renamed from: g, reason: collision with root package name */
    public final int f28063g;

    /* renamed from: h, reason: collision with root package name */
    public final int f28064h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f28065i;

    public a() {
        this(0, null, null, null, false, null, 0, 0, false, 511, null);
    }

    public final a a(int i10, String str, String str2, String str3, boolean z10, String str4, int i11, int i12, boolean z11) {
        return new a(i10, str, str2, str3, z10, str4, i11, i12, z11);
    }

    public final String c() {
        return this.f28058b;
    }

    public final String d() {
        return this.f28059c;
    }

    public final String e() {
        return this.f28060d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f28057a == aVar.f28057a && i.b(this.f28058b, aVar.f28058b) && i.b(this.f28059c, aVar.f28059c) && i.b(this.f28060d, aVar.f28060d) && this.f28061e == aVar.f28061e && i.b(this.f28062f, aVar.f28062f) && this.f28063g == aVar.f28063g && this.f28064h == aVar.f28064h && this.f28065i == aVar.f28065i) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f28062f;
    }

    public final int g() {
        return this.f28064h;
    }

    public final int h() {
        return this.f28057a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = Integer.hashCode(this.f28057a) * 31;
        String str = this.f28058b;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i11 = (hashCode4 + hashCode) * 31;
        String str2 = this.f28059c;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        String str3 = this.f28060d;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        boolean z10 = this.f28061e;
        int i14 = 1;
        int i15 = z10;
        if (z10 != 0) {
            i15 = 1;
        }
        int i16 = (i13 + i15) * 31;
        String str4 = this.f28062f;
        if (str4 != null) {
            i10 = str4.hashCode();
        }
        int hashCode5 = (((((i16 + i10) * 31) + Integer.hashCode(this.f28063g)) * 31) + Integer.hashCode(this.f28064h)) * 31;
        boolean z11 = this.f28065i;
        if (!z11) {
            i14 = z11 ? 1 : 0;
        }
        return hashCode5 + i14;
    }

    public final boolean i() {
        return this.f28065i;
    }

    public final boolean j() {
        return this.f28061e;
    }

    public final int k() {
        return this.f28063g;
    }

    public String toString() {
        return super.toString() + ":fType:" + this.f28057a + ", aType:" + this.f28059c + ", aName:" + this.f28058b + ", onlyPhone:" + this.f28061e + ", label:" + this.f28062f + ", sort:" + this.f28063g + ", display:" + this.f28064h + ", kana:" + this.f28065i;
    }

    public a(int i10, String str, String str2, String str3, boolean z10, String str4, int i11, int i12, boolean z11) {
        this.f28057a = i10;
        this.f28058b = str;
        this.f28059c = str2;
        this.f28060d = str3;
        this.f28061e = z10;
        this.f28062f = str4;
        this.f28063g = i11;
        this.f28064h = i12;
        this.f28065i = z11;
    }

    public /* synthetic */ a(int i10, String str, String str2, String str3, boolean z10, String str4, int i11, int i12, boolean z11, int i13, f fVar) {
        this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? null : str, (i13 & 4) != 0 ? null : str2, (i13 & 8) != 0 ? null : str3, (i13 & 16) != 0 ? false : z10, (i13 & 32) != 0 ? null : str4, (i13 & 64) != 0 ? 0 : i11, (i13 & 128) != 0 ? 0 : i12, (i13 & 256) != 0 ? true : z11);
    }
}
