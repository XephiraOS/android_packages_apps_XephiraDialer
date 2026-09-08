package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.C;
import kotlinx.coroutines.internal.z;

/* compiled from: Semaphore.kt */
/* loaded from: classes4.dex */
public final class d extends z<d> {

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReferenceArray f34633e;

    public d(long j10, d dVar, int i10) {
        super(j10, dVar, i10);
        int i11;
        i11 = c.f34632f;
        this.f34633e = new AtomicReferenceArray(i11);
    }

    @Override // kotlinx.coroutines.internal.z
    public int n() {
        int i10;
        i10 = c.f34632f;
        return i10;
    }

    @Override // kotlinx.coroutines.internal.z
    public void o(int i10, Throwable th, CoroutineContext coroutineContext) {
        C c10;
        c10 = c.f34631e;
        r().set(i10, c10);
        p();
    }

    public final AtomicReferenceArray r() {
        return this.f34633e;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f34541c + ", hashCode=" + hashCode() + ']';
    }
}
