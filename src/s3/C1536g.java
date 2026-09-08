package s3;

import android.os.SystemClock;

/* compiled from: LogTime.java */
/* renamed from: s3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1536g {

    /* renamed from: a, reason: collision with root package name */
    public static final double f36764a = 1.0d / Math.pow(10.0d, 6.0d);

    public static double a(long j10) {
        return (b() - j10) * f36764a;
    }

    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
