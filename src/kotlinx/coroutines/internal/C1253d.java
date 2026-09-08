package kotlinx.coroutines.internal;

/* compiled from: ConcurrentLinkedList.kt */
/* renamed from: kotlinx.coroutines.internal.d */
/* loaded from: classes4.dex */
public final class C1253d {

    /* renamed from: a */
    public static final C f34505a = new C("CLOSED");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.e] */
    public static final <N extends AbstractC1254e<N>> N b(N n10) {
        while (true) {
            Object f10 = n10.f();
            if (f10 == f34505a) {
                return n10;
            }
            ?? r02 = (AbstractC1254e) f10;
            if (r02 == 0) {
                if (n10.j()) {
                    return n10;
                }
            } else {
                n10 = r02;
            }
        }
    }

    public static final <S extends z<S>> Object c(S s10, long j10, v9.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s10.f34541c < j10 || s10.h()) {
                Object f10 = s10.f();
                if (f10 == f34505a) {
                    return A.a(f34505a);
                }
                S s11 = (S) ((AbstractC1254e) f10);
                if (s11 == null) {
                    s11 = pVar.invoke(Long.valueOf(s10.f34541c + 1), s10);
                    if (s10.l(s11)) {
                        if (s10.h()) {
                            s10.k();
                        }
                    }
                }
                s10 = s11;
            } else {
                return A.a(s10);
            }
        }
    }
}
