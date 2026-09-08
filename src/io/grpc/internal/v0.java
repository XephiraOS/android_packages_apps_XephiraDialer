package io.grpc.internal;

import java.util.concurrent.TimeUnit;

/* compiled from: TimeProvider.java */
/* loaded from: classes4.dex */
public interface v0 {

    /* renamed from: a, reason: collision with root package name */
    public static final v0 f33408a = new a();

    /* compiled from: TimeProvider.java */
    /* loaded from: classes4.dex */
    public class a implements v0 {
        @Override // io.grpc.internal.v0
        public long a() {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        }
    }

    long a();
}
