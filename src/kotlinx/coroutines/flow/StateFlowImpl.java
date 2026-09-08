package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.C;
import m9.q;

/* compiled from: StateFlow.kt */
/* loaded from: classes4.dex */
public final class StateFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<o> implements i<T>, a, kotlinx.coroutines.flow.internal.g<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34436e = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: d, reason: collision with root package name */
    public int f34437d;

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    @Override // kotlinx.coroutines.flow.internal.g
    public a<T> a(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        return n.d(this, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.i
    public boolean c(T t10, T t11) {
        if (t10 == null) {
            t10 = (T) kotlinx.coroutines.flow.internal.j.f34464a;
        }
        if (t11 == null) {
            t11 = (T) kotlinx.coroutines.flow.internal.j.f34464a;
        }
        return j(t10, t11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00bd, code lost:
    
        if (kotlin.jvm.internal.i.b(r12, r7) == false) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b4 A[Catch: all -> 0x0078, TryCatch #1 {all -> 0x0078, blocks: (B:13:0x00ac, B:15:0x00b4, B:17:0x00b9, B:19:0x00de, B:21:0x00e4, B:25:0x00bf, B:28:0x00c6, B:11:0x0074, B:12:0x009d, B:49:0x0087, B:51:0x008b), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b9 A[Catch: all -> 0x0078, TryCatch #1 {all -> 0x0078, blocks: (B:13:0x00ac, B:15:0x00b4, B:17:0x00b9, B:19:0x00de, B:21:0x00e4, B:25:0x00bf, B:28:0x00c6, B:11:0x0074, B:12:0x009d, B:49:0x0087, B:51:0x008b), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e4 A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #1 {all -> 0x0078, blocks: (B:13:0x00ac, B:15:0x00b4, B:17:0x00b9, B:19:0x00de, B:21:0x00e4, B:25:0x00bf, B:28:0x00c6, B:11:0x0074, B:12:0x009d, B:49:0x0087, B:51:0x008b), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00e2 -> B:13:0x00ac). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00f4 -> B:13:0x00ac). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.k, kotlinx.coroutines.flow.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object collect(kotlinx.coroutines.flow.b<? super T> r11, kotlin.coroutines.c<?> r12) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.b, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.h, kotlinx.coroutines.flow.b
    public Object emit(T t10, kotlin.coroutines.c<? super q> cVar) {
        setValue(t10);
        return q.f35511a;
    }

    @Override // kotlinx.coroutines.flow.i, kotlinx.coroutines.flow.m
    public T getValue() {
        C c10 = kotlinx.coroutines.flow.internal.j.f34464a;
        T t10 = (T) f34436e.get(this);
        if (t10 == c10) {
            return null;
        }
        return t10;
    }

    @Override // kotlinx.coroutines.flow.internal.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public o d() {
        return new o();
    }

    @Override // kotlinx.coroutines.flow.internal.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public o[] e(int i10) {
        return new o[i10];
    }

    public final boolean j(Object obj, Object obj2) {
        int i10;
        o[] g10;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34436e;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !kotlin.jvm.internal.i.b(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.i.b(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i11 = this.f34437d;
            if ((i11 & 1) == 0) {
                int i12 = i11 + 1;
                this.f34437d = i12;
                o[] g11 = g();
                q qVar = q.f35511a;
                while (true) {
                    o[] oVarArr = g11;
                    if (oVarArr != null) {
                        for (o oVar : oVarArr) {
                            if (oVar != null) {
                                oVar.g();
                            }
                        }
                    }
                    synchronized (this) {
                        i10 = this.f34437d;
                        if (i10 == i12) {
                            this.f34437d = i12 + 1;
                            return true;
                        }
                        g10 = g();
                        q qVar2 = q.f35511a;
                    }
                    g11 = g10;
                    i12 = i10;
                }
            } else {
                this.f34437d = i11 + 2;
                return true;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.i
    public void setValue(T t10) {
        if (t10 == null) {
            t10 = (T) kotlinx.coroutines.flow.internal.j.f34464a;
        }
        j(null, t10);
    }
}
