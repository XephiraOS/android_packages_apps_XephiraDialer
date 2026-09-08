package kotlinx.coroutines.sync;

import kotlin.jvm.internal.FunctionReferenceImpl;
import v9.p;

/* compiled from: Semaphore.kt */
/* loaded from: classes4.dex */
public /* synthetic */ class SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 extends FunctionReferenceImpl implements p<Long, d, d> {

    /* renamed from: a, reason: collision with root package name */
    public static final SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 f34624a = new SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1();

    public SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1() {
        super(2, c.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    public final d f(long j10, d dVar) {
        d h10;
        h10 = c.h(j10, dVar);
        return h10;
    }

    @Override // v9.p
    public /* bridge */ /* synthetic */ d invoke(Long l10, d dVar) {
        return f(l10.longValue(), dVar);
    }
}
