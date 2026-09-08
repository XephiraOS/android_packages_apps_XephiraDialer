package com.heytap.addon.direct;

import com.color.direct.ColorDirectFindResult;
import com.oplus.direct.OplusDirectFindResult;

/* compiled from: OplusDirectFindResult.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static String f25357c;

    /* renamed from: a, reason: collision with root package name */
    public OplusDirectFindResult f25358a;

    /* renamed from: b, reason: collision with root package name */
    public ColorDirectFindResult f25359b;

    static {
        if (A5.a.b()) {
            f25357c = "direct_find_error";
        } else {
            f25357c = "direct_find_error";
        }
    }

    public a() {
        if (A5.a.b()) {
            this.f25358a = new OplusDirectFindResult();
        } else {
            this.f25359b = new ColorDirectFindResult();
        }
    }

    public void a(OplusDirectFindResult oplusDirectFindResult) {
        this.f25358a = oplusDirectFindResult;
    }

    public String toString() {
        if (A5.a.b()) {
            return this.f25358a.toString();
        }
        return this.f25359b.toString();
    }
}
