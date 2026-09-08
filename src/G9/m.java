package G9;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SegmentPool.kt */
/* loaded from: classes4.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f1160a = new m();

    /* renamed from: b, reason: collision with root package name */
    public static final int f1161b = 65536;

    /* renamed from: c, reason: collision with root package name */
    public static final l f1162c = new l(new byte[0], 0, 0, false, false);

    /* renamed from: d, reason: collision with root package name */
    public static final int f1163d;

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReference<l>[] f1164e;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f1163d = highestOneBit;
        AtomicReference<l>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i10 = 0; i10 < highestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference<>();
        }
        f1164e = atomicReferenceArr;
    }

    public static final void b(l segment) {
        AtomicReference<l> a10;
        l lVar;
        l andSet;
        int i10;
        kotlin.jvm.internal.i.f(segment, "segment");
        if (segment.f1158f == null && segment.f1159g == null) {
            if (segment.f1156d || (andSet = (a10 = f1160a.a()).getAndSet((lVar = f1162c))) == lVar) {
                return;
            }
            if (andSet != null) {
                i10 = andSet.f1155c;
            } else {
                i10 = 0;
            }
            if (i10 >= f1161b) {
                a10.set(andSet);
                return;
            }
            segment.f1158f = andSet;
            segment.f1154b = 0;
            segment.f1155c = i10 + 8192;
            a10.set(segment);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final l c() {
        AtomicReference<l> a10 = f1160a.a();
        l lVar = f1162c;
        l andSet = a10.getAndSet(lVar);
        if (andSet == lVar) {
            return new l();
        }
        if (andSet == null) {
            a10.set(null);
            return new l();
        }
        a10.set(andSet.f1158f);
        andSet.f1158f = null;
        andSet.f1155c = 0;
        return andSet;
    }

    public final AtomicReference<l> a() {
        return f1164e[(int) (Thread.currentThread().getId() & (f1163d - 1))];
    }
}
