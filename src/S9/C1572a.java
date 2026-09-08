package s9;

import kotlin.jvm.internal.i;
import r9.C1518a;

/* compiled from: JDK7PlatformImplementations.kt */
/* renamed from: s9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1572a extends C1518a {

    /* compiled from: JDK7PlatformImplementations.kt */
    /* renamed from: s9.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0360a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0360a f36896a = new C0360a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f36897b;

        static {
            Integer num;
            Object obj;
            Integer num2 = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
                if (num != null && num.intValue() > 0) {
                    num2 = num;
                }
                f36897b = num2;
            }
            num = null;
            if (num != null) {
                num2 = num;
            }
            f36897b = num2;
        }
    }

    private final boolean c(int i10) {
        Integer num = C0360a.f36897b;
        if (num != null && num.intValue() < i10) {
            return false;
        }
        return true;
    }

    @Override // r9.C1518a
    public void a(Throwable cause, Throwable exception) {
        i.f(cause, "cause");
        i.f(exception, "exception");
        if (c(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
