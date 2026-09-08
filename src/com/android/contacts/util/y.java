package com.android.contacts.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: QQFillManager.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: f, reason: collision with root package name */
    public static y f17623f = new y();

    /* renamed from: a, reason: collision with root package name */
    public final String f17624a = "([0-9]{5,15})@qq\\.com";

    /* renamed from: b, reason: collision with root package name */
    public boolean f17625b = true;

    /* renamed from: c, reason: collision with root package name */
    public String f17626c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f17627d = Integer.MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public HashMap<Integer, String> f17628e = new HashMap<>();

    public static y c() {
        return f17623f;
    }

    public boolean a() {
        return this.f17625b;
    }

    public final String b() {
        Iterator<Integer> it = this.f17628e.keySet().iterator();
        int i10 = Integer.MAX_VALUE;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (i10 > intValue) {
                i10 = intValue;
            }
        }
        return this.f17628e.get(Integer.valueOf(i10));
    }

    public String d() {
        return this.f17626c;
    }

    public String e(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("([0-9]{5,15})@qq\\.com", 2).matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        return matcher.group(1);
    }

    public void f() {
        this.f17625b = true;
        this.f17626c = null;
        this.f17627d = Integer.MAX_VALUE;
        this.f17628e.clear();
    }

    public void g(boolean z10) {
        this.f17625b = z10;
    }

    public void h(String str, int i10) {
        int i11 = this.f17627d;
        if (i10 <= i11) {
            if (str != null) {
                this.f17628e.put(Integer.valueOf(i11), this.f17626c);
                this.f17626c = str;
            } else {
                this.f17628e.remove(Integer.valueOf(i10));
                this.f17626c = b();
            }
            this.f17627d = i10;
            return;
        }
        if (this.f17628e.containsKey(Integer.valueOf(i10)) && str == null) {
            this.f17628e.remove(Integer.valueOf(i10));
        } else {
            this.f17628e.put(Integer.valueOf(i10), str);
        }
    }
}
