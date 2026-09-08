package F;

import android.os.Trace;

/* compiled from: TraceCompat.java */
@Deprecated
/* loaded from: classes.dex */
public final class h {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
