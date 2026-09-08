package kotlinx.coroutines.channels;

import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: BufferedChannel.kt */
/* loaded from: classes4.dex */
public /* synthetic */ class BufferedChannelKt$createSegmentFunction$1<E> extends FunctionReferenceImpl implements v9.p<Long, f<E>, f<E>> {

    /* renamed from: a, reason: collision with root package name */
    public static final BufferedChannelKt$createSegmentFunction$1 f34404a = new BufferedChannelKt$createSegmentFunction$1();

    public BufferedChannelKt$createSegmentFunction$1() {
        super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    public final f<E> f(long j10, f<E> fVar) {
        f<E> x10;
        x10 = BufferedChannelKt.x(j10, fVar);
        return x10;
    }

    @Override // v9.p
    public /* bridge */ /* synthetic */ Object invoke(Long l10, Object obj) {
        return f(l10.longValue(), (f) obj);
    }
}
