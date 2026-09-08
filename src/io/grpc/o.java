package io.grpc;

/* compiled from: InternalServiceProviders.java */
/* loaded from: classes4.dex */
public final class o {
    public static boolean a(ClassLoader classLoader) {
        return G.b(classLoader);
    }

    public static <T> Iterable<T> getCandidatesViaHardCoded(Class<T> cls, Iterable<Class<?>> iterable) {
        return G.getCandidatesViaHardCoded(cls, iterable);
    }

    public static <T> Iterable<T> getCandidatesViaServiceLoader(Class<T> cls, ClassLoader classLoader) {
        return G.getCandidatesViaServiceLoader(cls, classLoader);
    }
}
