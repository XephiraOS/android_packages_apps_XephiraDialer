package com.customize.contacts.util;

import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: ContactsPhonesUtils.java */
/* renamed from: com.customize.contacts.util.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0808t {

    /* renamed from: a, reason: collision with root package name */
    public String f22179a = null;

    /* renamed from: b, reason: collision with root package name */
    public long f22180b = -1;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<ContactsPhonesUtils$PhoneItem> f22181c = new ArrayList<>();

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        int size = this.f22181c.size();
        for (int i10 = 0; i10 != size; i10++) {
            if (str.equals(this.f22181c.get(i10).f21872e)) {
                return true;
            }
        }
        return false;
    }
}
