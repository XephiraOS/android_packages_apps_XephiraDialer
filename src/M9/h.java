package m9;

import com.heytap.accessory.constant.FastPairConstants;

/* compiled from: UByte.kt */
/* loaded from: classes4.dex */
public final class h implements Comparable<h> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f35490b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final byte f35491a;

    /* compiled from: UByte.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public /* synthetic */ h(byte b10) {
        this.f35491a = b10;
    }

    public static final /* synthetic */ h a(byte b10) {
        return new h(b10);
    }

    public static boolean c(byte b10, Object obj) {
        if (!(obj instanceof h) || b10 != ((h) obj).f()) {
            return false;
        }
        return true;
    }

    public static int d(byte b10) {
        return Byte.hashCode(b10);
    }

    public static String e(byte b10) {
        return String.valueOf(b10 & FastPairConstants.GO_INTENT_NOT_SET);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(h hVar) {
        return kotlin.jvm.internal.i.g(f() & FastPairConstants.GO_INTENT_NOT_SET, hVar.f() & FastPairConstants.GO_INTENT_NOT_SET);
    }

    public boolean equals(Object obj) {
        return c(this.f35491a, obj);
    }

    public final /* synthetic */ byte f() {
        return this.f35491a;
    }

    public int hashCode() {
        return d(this.f35491a);
    }

    public String toString() {
        return e(this.f35491a);
    }

    public static byte b(byte b10) {
        return b10;
    }
}
