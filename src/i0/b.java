package i0;

import android.os.Trace;

/* compiled from: TraceApi18Impl.java */
/* loaded from: classes.dex */
public final class b {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
