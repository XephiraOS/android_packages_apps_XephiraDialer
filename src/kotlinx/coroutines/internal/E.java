package kotlinx.coroutines.internal;

/* compiled from: SystemProps.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class E {

    /* renamed from: a, reason: collision with root package name */
    public static final int f34483a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f34483a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
