package io.grpc.stub;

import com.google.common.base.k;
import io.grpc.C1108b;
import io.grpc.C1111e;
import io.grpc.stub.a;
import j9.AbstractC1193c;
import j9.AbstractC1194d;
import j9.C1203m;
import j9.InterfaceC1196f;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: AbstractStub.java */
/* loaded from: classes4.dex */
public abstract class a<S extends a<S>> {
    private final C1108b callOptions;
    private final AbstractC1194d channel;

    /* compiled from: AbstractStub.java */
    /* renamed from: io.grpc.stub.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0314a<T extends a<T>> {
        T a(AbstractC1194d abstractC1194d, C1108b c1108b);
    }

    public a(AbstractC1194d abstractC1194d) {
        this(abstractC1194d, C1108b.f32416k);
    }

    public static <T extends a<T>> T newStub(InterfaceC0314a<T> interfaceC0314a, AbstractC1194d abstractC1194d) {
        return (T) newStub(interfaceC0314a, abstractC1194d, C1108b.f32416k);
    }

    public abstract S build(AbstractC1194d abstractC1194d, C1108b c1108b);

    public final C1108b getCallOptions() {
        return this.callOptions;
    }

    public final AbstractC1194d getChannel() {
        return this.channel;
    }

    public final S withCallCredentials(AbstractC1193c abstractC1193c) {
        return build(this.channel, this.callOptions.l(abstractC1193c));
    }

    @Deprecated
    public final S withChannel(AbstractC1194d abstractC1194d) {
        return build(abstractC1194d, this.callOptions);
    }

    public final S withCompression(String str) {
        return build(this.channel, this.callOptions.m(str));
    }

    public final S withDeadline(C1203m c1203m) {
        return build(this.channel, this.callOptions.n(c1203m));
    }

    public final S withDeadlineAfter(long j10, TimeUnit timeUnit) {
        return build(this.channel, this.callOptions.o(j10, timeUnit));
    }

    public final S withExecutor(Executor executor) {
        return build(this.channel, this.callOptions.p(executor));
    }

    public final S withInterceptors(InterfaceC1196f... interfaceC1196fArr) {
        return build(C1111e.b(this.channel, interfaceC1196fArr), this.callOptions);
    }

    public final S withMaxInboundMessageSize(int i10) {
        return build(this.channel, this.callOptions.q(i10));
    }

    public final S withMaxOutboundMessageSize(int i10) {
        return build(this.channel, this.callOptions.r(i10));
    }

    public final <T> S withOption(C1108b.c<T> cVar, T t10) {
        return build(this.channel, this.callOptions.s(cVar, t10));
    }

    public final S withWaitForReady() {
        return build(this.channel, this.callOptions.u());
    }

    public a(AbstractC1194d abstractC1194d, C1108b c1108b) {
        this.channel = (AbstractC1194d) k.p(abstractC1194d, "channel");
        this.callOptions = (C1108b) k.p(c1108b, "callOptions");
    }

    public static <T extends a<T>> T newStub(InterfaceC0314a<T> interfaceC0314a, AbstractC1194d abstractC1194d, C1108b c1108b) {
        return interfaceC0314a.a(abstractC1194d, c1108b);
    }
}
