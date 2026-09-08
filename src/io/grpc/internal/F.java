package io.grpc.internal;

import java.util.ArrayList;

/* compiled from: InsightBuilder.java */
/* loaded from: classes4.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f32515a = new ArrayList<>();

    public F a(Object obj) {
        this.f32515a.add(String.valueOf(obj));
        return this;
    }

    public F b(String str, Object obj) {
        this.f32515a.add(str + "=" + obj);
        return this;
    }

    public String toString() {
        return this.f32515a.toString();
    }
}
