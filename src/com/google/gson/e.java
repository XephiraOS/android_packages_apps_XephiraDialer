package com.google.gson;

import F4.d;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: GsonBuilder.java */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public com.google.gson.internal.c f24726a = com.google.gson.internal.c.f24788g;

    /* renamed from: b, reason: collision with root package name */
    public LongSerializationPolicy f24727b = LongSerializationPolicy.DEFAULT;

    /* renamed from: c, reason: collision with root package name */
    public c f24728c = FieldNamingPolicy.IDENTITY;

    /* renamed from: d, reason: collision with root package name */
    public final Map<Type, f<?>> f24729d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final List<s> f24730e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final List<s> f24731f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public boolean f24732g = false;

    /* renamed from: h, reason: collision with root package name */
    public String f24733h = d.f24695z;

    /* renamed from: i, reason: collision with root package name */
    public int f24734i = 2;

    /* renamed from: j, reason: collision with root package name */
    public int f24735j = 2;

    /* renamed from: k, reason: collision with root package name */
    public boolean f24736k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f24737l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f24738m = true;

    /* renamed from: n, reason: collision with root package name */
    public boolean f24739n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f24740o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f24741p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f24742q = true;

    /* renamed from: r, reason: collision with root package name */
    public q f24743r = d.f24693B;

    /* renamed from: s, reason: collision with root package name */
    public q f24744s = d.f24694C;

    /* renamed from: t, reason: collision with root package name */
    public final LinkedList<ReflectionAccessFilter> f24745t = new LinkedList<>();

    public final void a(String str, int i10, int i11, List<s> list) {
        s sVar;
        s sVar2;
        boolean z10 = I4.d.f1340a;
        s sVar3 = null;
        if (str != null && !str.trim().isEmpty()) {
            sVar = d.b.f857b.b(str);
            if (z10) {
                sVar3 = I4.d.f1342c.b(str);
                sVar2 = I4.d.f1341b.b(str);
            }
            sVar2 = null;
        } else if (i10 != 2 && i11 != 2) {
            s a10 = d.b.f857b.a(i10, i11);
            if (z10) {
                sVar3 = I4.d.f1342c.a(i10, i11);
                s a11 = I4.d.f1341b.a(i10, i11);
                sVar = a10;
                sVar2 = a11;
            } else {
                sVar = a10;
                sVar2 = null;
            }
        } else {
            return;
        }
        list.add(sVar);
        if (z10) {
            list.add(sVar3);
            list.add(sVar2);
        }
    }

    public d b() {
        List<s> arrayList = new ArrayList<>(this.f24730e.size() + this.f24731f.size() + 3);
        arrayList.addAll(this.f24730e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f24731f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f24733h, this.f24734i, this.f24735j, arrayList);
        return new d(this.f24726a, this.f24728c, new HashMap(this.f24729d), this.f24732g, this.f24736k, this.f24740o, this.f24738m, this.f24739n, this.f24741p, this.f24737l, this.f24742q, this.f24727b, this.f24733h, this.f24734i, this.f24735j, new ArrayList(this.f24730e), new ArrayList(this.f24731f), arrayList, this.f24743r, this.f24744s, new ArrayList(this.f24745t));
    }

    public e c() {
        this.f24737l = true;
        return this;
    }

    public e d() {
        this.f24739n = true;
        return this;
    }
}
