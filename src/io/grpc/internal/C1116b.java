package io.grpc.internal;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: AtomicLongCounter.java */
/* renamed from: io.grpc.internal.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1116b implements L {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f33020a = new AtomicLong();

    @Override // io.grpc.internal.L
    public void a(long j10) {
        this.f33020a.getAndAdd(j10);
    }
}
