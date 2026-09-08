package a;

/* compiled from: CoroutineDebugging.kt */
/* renamed from: a.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0406b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6250a = "_COROUTINE";

    public static final StackTraceElement b(Throwable th, String str) {
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        return new StackTraceElement(f6250a + '.' + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }
}
