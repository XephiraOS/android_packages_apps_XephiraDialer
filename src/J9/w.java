package j9;

import com.android.incallui.OplusAutoRedialNotificationUI;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: InternalLogId.java */
/* loaded from: classes4.dex */
public final class w {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLong f34044d = new AtomicLong();

    /* renamed from: a, reason: collision with root package name */
    public final String f34045a;

    /* renamed from: b, reason: collision with root package name */
    public final String f34046b;

    /* renamed from: c, reason: collision with root package name */
    public final long f34047c;

    public w(String str, String str2, long j10) {
        com.google.common.base.k.p(str, "typeName");
        com.google.common.base.k.e(!str.isEmpty(), "empty type");
        this.f34045a = str;
        this.f34046b = str2;
        this.f34047c = j10;
    }

    public static w a(Class<?> cls, String str) {
        return b(c(cls), str);
    }

    public static w b(String str, String str2) {
        return new w(str, str2, e());
    }

    public static String c(Class<?> cls) {
        String simpleName = ((Class) com.google.common.base.k.p(cls, OplusAutoRedialNotificationUI.TYPE)).getSimpleName();
        if (!simpleName.isEmpty()) {
            return simpleName;
        }
        return cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    public static long e() {
        return f34044d.incrementAndGet();
    }

    public long d() {
        return this.f34047c;
    }

    public String f() {
        return this.f34045a + "<" + this.f34047c + ">";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        if (this.f34046b != null) {
            sb.append(": (");
            sb.append(this.f34046b);
            sb.append(')');
        }
        return sb.toString();
    }
}
