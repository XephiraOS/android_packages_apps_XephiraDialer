package kotlinx.coroutines.channels;

import m9.q;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public interface o<E> {

    /* compiled from: Channel.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ boolean a(o oVar, Throwable th, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    th = null;
                }
                return oVar.d(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    boolean d(Throwable th);

    Object j(E e10);

    Object k(E e10, kotlin.coroutines.c<? super q> cVar);
}
