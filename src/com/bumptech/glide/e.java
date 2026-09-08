package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GlideExperiments.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, Object> f19337a;

    /* compiled from: GlideExperiments.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map<Class<?>, Object> f19338a = new HashMap();

        public e b() {
            return new e(this);
        }
    }

    public e(a aVar) {
        this.f19337a = Collections.unmodifiableMap(new HashMap(aVar.f19338a));
    }

    public boolean a(Class<Object> cls) {
        return this.f19337a.containsKey(cls);
    }
}
