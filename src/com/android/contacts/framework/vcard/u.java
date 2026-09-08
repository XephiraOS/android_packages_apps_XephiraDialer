package com.android.contacts.framework.vcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: VCardProperty.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public String f16556a;

    /* renamed from: b, reason: collision with root package name */
    public List<String> f16557b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, Collection<String>> f16558c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public String f16559d;

    /* renamed from: e, reason: collision with root package name */
    public List<String> f16560e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f16561f;

    public void a(String str) {
        if (this.f16557b == null) {
            this.f16557b = new ArrayList();
        }
        this.f16557b.add(str);
    }

    public void b(String str, String str2) {
        Collection<String> collection;
        if (!this.f16558c.containsKey(str)) {
            if (str.equals("TYPE")) {
                collection = new HashSet<>();
            } else {
                collection = new ArrayList<>();
            }
            this.f16558c.put(str, collection);
        } else {
            collection = this.f16558c.get(str);
        }
        collection.add(str2);
    }

    public byte[] c() {
        return this.f16561f;
    }

    public String d() {
        return this.f16556a;
    }

    public Map<String, Collection<String>> e() {
        return this.f16558c;
    }

    public Collection<String> f(String str) {
        return this.f16558c.get(str);
    }

    public String g() {
        return this.f16559d;
    }

    public List<String> h() {
        return this.f16560e;
    }

    public void i(byte[] bArr) {
        this.f16561f = bArr;
    }

    public void j(String str) {
        String str2 = this.f16556a;
        if (str2 != null) {
            H7.b.i(h.LOG_TAG, String.format("Property name is re-defined (existing: %s, requested: %s", str2, str));
        }
        this.f16556a = str;
    }

    public void k(String str) {
        this.f16559d = str;
    }

    public void l(List<String> list) {
        this.f16560e = list;
    }

    public void m(String... strArr) {
        this.f16560e = Arrays.asList(strArr);
    }
}
