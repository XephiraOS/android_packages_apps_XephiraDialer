package com.android.contacts.calllog;

import android.text.TextUtils;

/* compiled from: ContactInfoRequest.java */
/* loaded from: classes.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name */
    public final String f13732a;

    /* renamed from: b, reason: collision with root package name */
    public final y f13733b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13734c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13735d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13736e;

    public B(String str, y yVar, int i10, boolean z10, int i11) {
        this.f13732a = str;
        this.f13733b = yVar;
        this.f13734c = i10;
        this.f13735d = z10;
        this.f13736e = i11;
    }

    public boolean a(Object obj, Object obj2) {
        y yVar = (y) obj;
        y yVar2 = (y) obj2;
        if (yVar == null && yVar2 == null) {
            return true;
        }
        if (yVar != null && yVar2 != null && U7.g.a(yVar.f14057b, yVar2.f14057b) && TextUtils.equals(yVar.f14058c, yVar2.f14058c) && TextUtils.equals(yVar.f14061f, yVar2.f14061f) && TextUtils.equals(yVar.f14062g, yVar2.f14062g) && yVar.f14066k == yVar2.f14066k && U7.g.a(yVar.f14067l, yVar2.f14067l) && yVar.f14056a == yVar2.f14056a && yVar.f14071p == yVar2.f14071p) {
            return true;
        }
        return false;
    }

    public boolean b() {
        int i10 = this.f13736e;
        if (i10 == 0 || i10 == 1) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof B)) {
            return false;
        }
        B b10 = (B) obj;
        if (TextUtils.equals(this.f13732a, b10.f13732a) && a(this.f13733b, b10.f13733b) && this.f13736e == b10.f13736e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        y yVar = this.f13733b;
        int i10 = 0;
        if (yVar == null) {
            hashCode = 0;
        } else {
            hashCode = yVar.hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        String str = this.f13732a;
        if (str != null) {
            i10 = str.hashCode();
        }
        return i11 + i10;
    }
}
