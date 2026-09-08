package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.w0;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes4.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f34536a;

    /* renamed from: b, reason: collision with root package name */
    public static final w0 f34537b;

    static {
        s sVar = new s();
        f34536a = sVar;
        D.f("kotlinx.coroutines.fast.service.loader", true);
        f34537b = sVar.a();
    }

    public final w0 a() {
        kotlin.sequences.e b10;
        List o10;
        Object next;
        w0 e10;
        try {
            b10 = SequencesKt__SequencesKt.b(ServiceLoader.load(r.class, r.class.getClassLoader()).iterator());
            o10 = SequencesKt___SequencesKt.o(b10);
            Iterator it = o10.iterator();
            if (!it.hasNext()) {
                next = null;
            } else {
                next = it.next();
                if (it.hasNext()) {
                    int c10 = ((r) next).c();
                    do {
                        Object next2 = it.next();
                        int c11 = ((r) next2).c();
                        if (c10 < c11) {
                            next = next2;
                            c10 = c11;
                        }
                    } while (it.hasNext());
                }
            }
            r rVar = (r) next;
            if (rVar != null && (e10 = t.e(rVar, o10)) != null) {
                return e10;
            }
            return t.b(null, null, 3, null);
        } catch (Throwable th) {
            return t.b(th, null, 2, null);
        }
    }
}
