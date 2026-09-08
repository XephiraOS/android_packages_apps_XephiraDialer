package com.google.gson;

import java.lang.reflect.Field;
import java.util.Objects;

/* compiled from: FieldAttributes.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Field f24691a;

    public b(Field field) {
        Objects.requireNonNull(field);
        this.f24691a = field;
    }

    public String toString() {
        return this.f24691a.toString();
    }
}
