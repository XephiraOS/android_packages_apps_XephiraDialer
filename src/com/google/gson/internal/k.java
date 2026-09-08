package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* loaded from: classes3.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f24809a = c();

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes3.dex */
    public class a extends k {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f24810b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f24811c;

        public a(Method method, Object obj) {
            this.f24810b = method;
            this.f24811c = obj;
        }

        @Override // com.google.gson.internal.k
        public <T> T d(Class<T> cls) {
            k.b(cls);
            return (T) this.f24810b.invoke(this.f24811c, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes3.dex */
    public class b extends k {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f24812b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f24813c;

        public b(Method method, int i10) {
            this.f24812b = method;
            this.f24813c = i10;
        }

        @Override // com.google.gson.internal.k
        public <T> T d(Class<T> cls) {
            k.b(cls);
            return (T) this.f24812b.invoke(null, cls, Integer.valueOf(this.f24813c));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes3.dex */
    public class c extends k {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Method f24814b;

        public c(Method method) {
            this.f24814b = method;
        }

        @Override // com.google.gson.internal.k
        public <T> T d(Class<T> cls) {
            k.b(cls);
            return (T) this.f24814b.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes3.dex */
    public class d extends k {
        @Override // com.google.gson.internal.k
        public <T> T d(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    public static void b(Class<?> cls) {
        String a10 = com.google.gson.internal.b.a(cls);
        if (a10 == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + a10);
    }

    public static k c() {
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    return new d();
                }
            } catch (Exception unused2) {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                return new c(declaredMethod);
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            int intValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            return new b(declaredMethod3, intValue);
        }
    }

    public abstract <T> T d(Class<T> cls);
}
