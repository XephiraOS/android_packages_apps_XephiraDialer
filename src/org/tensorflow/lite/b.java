package org.tensorflow.lite;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Interpreter.java */
/* loaded from: classes4.dex */
public final class b implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public NativeInterpreterWrapper f35921a;

    /* compiled from: Interpreter.java */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public Boolean f35923b;

        /* renamed from: c, reason: collision with root package name */
        public Boolean f35924c;

        /* renamed from: d, reason: collision with root package name */
        public Boolean f35925d;

        /* renamed from: a, reason: collision with root package name */
        public int f35922a = -1;

        /* renamed from: e, reason: collision with root package name */
        public final List<org.tensorflow.lite.a> f35926e = new ArrayList();

        public a a(org.tensorflow.lite.a aVar) {
            this.f35926e.add(aVar);
            return this;
        }

        public a b(int i10) {
            this.f35922a = i10;
            return this;
        }
    }

    public b(ByteBuffer byteBuffer, a aVar) {
        this.f35921a = new NativeInterpreterWrapper(byteBuffer, aVar);
    }

    public final void a() {
        if (this.f35921a != null) {
        } else {
            throw new IllegalStateException("Internal error: The Interpreter has already been closed.");
        }
    }

    public Tensor c(int i10) {
        a();
        return this.f35921a.c(i10);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        NativeInterpreterWrapper nativeInterpreterWrapper = this.f35921a;
        if (nativeInterpreterWrapper != null) {
            nativeInterpreterWrapper.close();
            this.f35921a = null;
        }
    }

    public int e() {
        a();
        return this.f35921a.e();
    }

    public Tensor f(int i10) {
        a();
        return this.f35921a.f(i10);
    }

    public void finalize() {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public int g() {
        a();
        return this.f35921a.g();
    }

    public void l() {
        a();
        this.f35921a.r();
    }

    public void o(Object obj, Object obj2) {
        HashMap hashMap = new HashMap();
        hashMap.put(0, obj2);
        r(new Object[]{obj}, hashMap);
    }

    public void r(Object[] objArr, Map<Integer, Object> map) {
        a();
        this.f35921a.u(objArr, map);
    }
}
