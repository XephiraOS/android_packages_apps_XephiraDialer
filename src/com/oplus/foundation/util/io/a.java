package com.oplus.foundation.util.io;

import kotlin.jvm.internal.i;

/* compiled from: ColumnInfo.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f28357a;

    /* renamed from: b, reason: collision with root package name */
    public int f28358b;

    public a(String columnName, int i10) {
        i.f(columnName, "columnName");
        this.f28357a = columnName;
        this.f28358b = i10;
    }

    public final int a() {
        return this.f28358b;
    }

    public final String b() {
        return this.f28357a;
    }

    public final void c(int i10) {
        this.f28358b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (i.b(this.f28357a, aVar.f28357a) && this.f28358b == aVar.f28358b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f28357a.hashCode() * 31) + Integer.hashCode(this.f28358b);
    }

    public String toString() {
        return "ColumnInfo(columnName=" + this.f28357a + ", columnIndex=" + this.f28358b + ")";
    }
}
