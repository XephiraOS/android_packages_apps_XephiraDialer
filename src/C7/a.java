package C7;

/* compiled from: ClickUtils.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f394a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static long f395b = 500;

    /* renamed from: c, reason: collision with root package name */
    public static long f396c;

    /* renamed from: d, reason: collision with root package name */
    public static int f397d;

    public static final boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - f396c) > f395b) {
            f396c = currentTimeMillis;
            return false;
        }
        return true;
    }

    public static final boolean b(int i10) {
        long currentTimeMillis = System.currentTimeMillis();
        if (f397d != i10) {
            f397d = i10;
            f396c = currentTimeMillis;
            return false;
        }
        if (Math.abs(currentTimeMillis - f396c) > f395b) {
            f397d = i10;
            f396c = currentTimeMillis;
            return false;
        }
        return true;
    }
}
