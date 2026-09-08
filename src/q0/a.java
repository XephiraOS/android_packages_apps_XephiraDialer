package Q0;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CallLogData1.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0058a f3093b = new C0058a(null);

    /* renamed from: a, reason: collision with root package name */
    @E4.c("localVersion")
    public final String f3094a;

    /* compiled from: CallLogData1.kt */
    /* renamed from: Q0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0058a {
        public C0058a() {
        }

        public final a a(String str) {
            return (a) U7.b.f3872a.a(str, a.class);
        }

        public /* synthetic */ C0058a(f fVar) {
            this();
        }
    }

    public a(String str) {
        this.f3094a = str;
    }

    public static final a a(String str) {
        return f3093b.a(str);
    }

    public final String b() {
        return this.f3094a;
    }

    public final String c() {
        return U7.b.f3872a.b(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof a) && i.b(this.f3094a, ((a) obj).f3094a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f3094a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "CallLogData1(localVersion=" + this.f3094a + ")";
    }
}
