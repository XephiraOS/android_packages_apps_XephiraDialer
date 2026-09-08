package com.android.contacts.calllog;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: ContactInfo.java */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: B, reason: collision with root package name */
    public static final y f14054B = new y();

    /* renamed from: A, reason: collision with root package name */
    public F0.a f14055A;

    /* renamed from: b, reason: collision with root package name */
    public Uri f14057b;

    /* renamed from: c, reason: collision with root package name */
    public String f14058c;

    /* renamed from: d, reason: collision with root package name */
    public int f14059d;

    /* renamed from: e, reason: collision with root package name */
    public String f14060e;

    /* renamed from: f, reason: collision with root package name */
    public String f14061f;

    /* renamed from: g, reason: collision with root package name */
    public String f14062g;

    /* renamed from: h, reason: collision with root package name */
    public String f14063h;

    /* renamed from: j, reason: collision with root package name */
    public String f14065j;

    /* renamed from: k, reason: collision with root package name */
    public long f14066k;

    /* renamed from: l, reason: collision with root package name */
    public Uri f14067l;

    /* renamed from: m, reason: collision with root package name */
    public long f14068m;

    /* renamed from: n, reason: collision with root package name */
    public int f14069n;

    /* renamed from: o, reason: collision with root package name */
    public long f14070o;

    /* renamed from: p, reason: collision with root package name */
    public int f14071p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14072q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f14073r;

    /* renamed from: s, reason: collision with root package name */
    public String f14074s;

    /* renamed from: t, reason: collision with root package name */
    public String f14075t;

    /* renamed from: u, reason: collision with root package name */
    public int f14076u;

    /* renamed from: v, reason: collision with root package name */
    public String f14077v;

    /* renamed from: y, reason: collision with root package name */
    public int f14080y;

    /* renamed from: z, reason: collision with root package name */
    public String f14081z;

    /* renamed from: a, reason: collision with root package name */
    public long f14056a = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f14064i = 0;

    /* renamed from: w, reason: collision with root package name */
    public boolean f14078w = false;

    /* renamed from: x, reason: collision with root package name */
    public boolean f14079x = false;

    public String a() {
        F0.a aVar;
        if (!TextUtils.isEmpty(this.f14058c)) {
            return this.f14058c;
        }
        if (B3.a.u() && (aVar = this.f14055A) != null) {
            return aVar.c();
        }
        return "";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        if (U7.g.a(this.f14057b, yVar.f14057b) && TextUtils.equals(this.f14058c, yVar.f14058c) && this.f14059d == yVar.f14059d && TextUtils.equals(this.f14060e, yVar.f14060e) && TextUtils.equals(this.f14061f, yVar.f14061f) && TextUtils.equals(this.f14063h, yVar.f14063h) && this.f14066k == yVar.f14066k && U7.g.a(this.f14067l, yVar.f14067l) && TextUtils.equals(this.f14065j, yVar.f14065j) && this.f14078w == yVar.f14078w && this.f14079x == yVar.f14079x) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Uri uri = this.f14057b;
        int i10 = 0;
        if (uri == null) {
            hashCode = 0;
        } else {
            hashCode = uri.hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        String str = this.f14058c;
        if (str != null) {
            i10 = str.hashCode();
        }
        return i11 + i10;
    }
}
