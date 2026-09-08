package com.android.contacts.calllog;

import android.text.TextUtils;

/* compiled from: NumberWithSubId.java */
/* loaded from: classes.dex */
public class H {

    /* renamed from: a, reason: collision with root package name */
    public final String f13849a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13850b;

    public H(String str, int i10) {
        this.f13849a = str;
        this.f13850b = i10;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof H)) {
            return false;
        }
        H h10 = (H) obj;
        if (!TextUtils.equals(this.f13849a, h10.f13849a) || this.f13850b != h10.f13850b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        String str = this.f13849a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return this.f13850b ^ hashCode;
    }
}
