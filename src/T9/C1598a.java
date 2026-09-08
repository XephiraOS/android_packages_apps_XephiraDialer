package t9;

import kotlin.random.Random;
import s9.C1572a;

/* compiled from: JDK8PlatformImplementations.kt */
/* renamed from: t9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1598a extends C1572a {

    /* compiled from: JDK8PlatformImplementations.kt */
    /* renamed from: t9.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0365a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0365a f37291a = new C0365a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f37292b;

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
                f37292b = num2;
            }
            num = null;
            if (num != null) {
                num2 = num;
            }
            f37292b = num2;
        }
    }

    @Override // r9.C1518a
    public Random b() {
        if (c(34)) {
            return new A9.a();
        }
        return super.b();
    }

    public final boolean c(int i10) {
        Integer num = C0365a.f37292b;
        if (num != null && num.intValue() < i10) {
            return false;
        }
        return true;
    }
}
