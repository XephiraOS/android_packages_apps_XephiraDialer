package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* compiled from: ReflectionAccessFilterHelper.java */
/* loaded from: classes3.dex */
public class i {

    /* compiled from: ReflectionAccessFilterHelper.java */
    /* loaded from: classes3.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f24803a;

        /* compiled from: ReflectionAccessFilterHelper.java */
        /* loaded from: classes3.dex */
        public class a extends b {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Method f24804b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method) {
                super();
                this.f24804b = method;
            }

            @Override // com.google.gson.internal.i.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f24804b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e10) {
                    throw new RuntimeException("Failed invoking canAccess", e10);
                }
            }
        }

        /* compiled from: ReflectionAccessFilterHelper.java */
        /* renamed from: com.google.gson.internal.i$b$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0226b extends b {
            public C0226b() {
                super();
            }

            @Override // com.google.gson.internal.i.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x001d  */
        static {
            /*
                boolean r0 = com.google.gson.internal.d.d()
                if (r0 == 0) goto L1a
                java.lang.Class<java.lang.reflect.AccessibleObject> r0 = java.lang.reflect.AccessibleObject.class
                java.lang.String r1 = "canAccess"
                java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
                java.lang.Class[] r2 = new java.lang.Class[]{r2}     // Catch: java.lang.NoSuchMethodException -> L1a
                java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch: java.lang.NoSuchMethodException -> L1a
                com.google.gson.internal.i$b$a r1 = new com.google.gson.internal.i$b$a     // Catch: java.lang.NoSuchMethodException -> L1a
                r1.<init>(r0)     // Catch: java.lang.NoSuchMethodException -> L1a
                goto L1b
            L1a:
                r1 = 0
            L1b:
                if (r1 != 0) goto L22
                com.google.gson.internal.i$b$b r1 = new com.google.gson.internal.i$b$b
                r1.<init>()
            L22:
                com.google.gson.internal.i.b.f24803a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.i.b.<clinit>():void");
        }

        public b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.f24803a.a(accessibleObject, obj);
    }

    public static ReflectionAccessFilter.FilterResult b(List<ReflectionAccessFilter> list, Class<?> cls) {
        Iterator<ReflectionAccessFilter> it = list.iterator();
        while (it.hasNext()) {
            ReflectionAccessFilter.FilterResult a10 = it.next().a(cls);
            if (a10 != ReflectionAccessFilter.FilterResult.INDECISIVE) {
                return a10;
            }
        }
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }
}
