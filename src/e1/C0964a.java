package e1;

import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: OmojiListResult.kt */
/* renamed from: e1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0964a {

    /* renamed from: a, reason: collision with root package name */
    @E4.c("isFull")
    public boolean f30556a;

    /* renamed from: b, reason: collision with root package name */
    @E4.c("omojiList")
    public List<C0293a> f30557b;

    /* compiled from: OmojiListResult.kt */
    /* renamed from: e1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0293a {

        /* renamed from: a, reason: collision with root package name */
        @E4.c("materials")
        public String f30558a;

        /* renamed from: b, reason: collision with root package name */
        @E4.c("thumbnail")
        public String f30559b;

        public final String a() {
            return this.f30558a;
        }

        public final String b() {
            return this.f30559b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0293a)) {
                return false;
            }
            C0293a c0293a = (C0293a) obj;
            if (i.b(this.f30558a, c0293a.f30558a) && i.b(this.f30559b, c0293a.f30559b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            String str = this.f30558a;
            int i10 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i11 = hashCode * 31;
            String str2 = this.f30559b;
            if (str2 != null) {
                i10 = str2.hashCode();
            }
            return i11 + i10;
        }

        public String toString() {
            return "OmojiProviderData(materials=" + this.f30558a + ", thumbnail=" + this.f30559b + ")";
        }
    }

    public final List<C0293a> a() {
        return this.f30557b;
    }

    public final boolean b() {
        return this.f30556a;
    }
}
