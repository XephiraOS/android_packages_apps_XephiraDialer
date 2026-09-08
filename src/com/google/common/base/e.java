package com.google.common.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: Joiner.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f24310a;

    public e(String str) {
        this.f24310a = (String) k.o(str);
    }

    public static e f(char c10) {
        return new e(String.valueOf(c10));
    }

    public static e g(String str) {
        return new e(str);
    }

    public <A extends Appendable> A a(A a10, Iterator<? extends Object> it) {
        k.o(a10);
        if (it.hasNext()) {
            a10.append(h(it.next()));
            while (it.hasNext()) {
                a10.append(this.f24310a);
                a10.append(h(it.next()));
            }
        }
        return a10;
    }

    public final StringBuilder b(StringBuilder sb, Iterable<? extends Object> iterable) {
        return c(sb, iterable.iterator());
    }

    public final StringBuilder c(StringBuilder sb, Iterator<? extends Object> it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public final String d(Iterable<? extends Object> iterable) {
        return e(iterable.iterator());
    }

    public final String e(Iterator<? extends Object> it) {
        return c(new StringBuilder(), it).toString();
    }

    public CharSequence h(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }
}
