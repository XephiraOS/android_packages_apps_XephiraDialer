package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;
import java.util.Objects;

/* compiled from: JsonPrimitive.java */
/* loaded from: classes3.dex */
public final class n extends j {

    /* renamed from: a, reason: collision with root package name */
    public final Object f24817a;

    public n(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f24817a = bool;
    }

    public static boolean r(n nVar) {
        Object obj = nVar.f24817a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if (!(number instanceof BigInteger) && !(number instanceof Long) && !(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f24817a == null) {
            if (nVar.f24817a == null) {
                return true;
            }
            return false;
        }
        if (r(this) && r(nVar)) {
            if (o().longValue() == nVar.o().longValue()) {
                return true;
            }
            return false;
        }
        Object obj2 = this.f24817a;
        if ((obj2 instanceof Number) && (nVar.f24817a instanceof Number)) {
            double doubleValue = o().doubleValue();
            double doubleValue2 = nVar.o().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2)) {
                return true;
            }
            return false;
        }
        return obj2.equals(nVar.f24817a);
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f24817a == null) {
            return 31;
        }
        if (r(this)) {
            doubleToLongBits = o().longValue();
        } else {
            Object obj = this.f24817a;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(o().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean k() {
        if (q()) {
            return ((Boolean) this.f24817a).booleanValue();
        }
        return Boolean.parseBoolean(p());
    }

    public double l() {
        if (s()) {
            return o().doubleValue();
        }
        return Double.parseDouble(p());
    }

    public int m() {
        if (s()) {
            return o().intValue();
        }
        return Integer.parseInt(p());
    }

    public long n() {
        if (s()) {
            return o().longValue();
        }
        return Long.parseLong(p());
    }

    public Number o() {
        Object obj = this.f24817a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new LazilyParsedNumber((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public String p() {
        Object obj = this.f24817a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (s()) {
            return o().toString();
        }
        if (q()) {
            return ((Boolean) this.f24817a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f24817a.getClass());
    }

    public boolean q() {
        return this.f24817a instanceof Boolean;
    }

    public boolean s() {
        return this.f24817a instanceof Number;
    }

    public boolean t() {
        return this.f24817a instanceof String;
    }

    public n(Number number) {
        Objects.requireNonNull(number);
        this.f24817a = number;
    }

    public n(String str) {
        Objects.requireNonNull(str);
        this.f24817a = str;
    }
}
