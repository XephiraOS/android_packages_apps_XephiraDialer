package m2;

import D2.g;
import android.text.TextUtils;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: SecondaryInfo.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: g, reason: collision with root package name */
    public static final a f35091g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public String f35092a;

    /* renamed from: b, reason: collision with root package name */
    public String f35093b;

    /* renamed from: c, reason: collision with root package name */
    public String f35094c;

    /* renamed from: d, reason: collision with root package name */
    public int f35095d = -1;

    /* renamed from: e, reason: collision with root package name */
    public String f35096e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f35097f;

    /* compiled from: SecondaryInfo.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final boolean a(c cVar, c cVar2) {
            String str;
            String str2 = null;
            if (cVar != null) {
                str = cVar.c();
            } else {
                str = null;
            }
            if (cVar2 != null) {
                str2 = cVar2.c();
            }
            return i.b(str, str2);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final int a() {
        return this.f35095d;
    }

    public final String b() {
        return this.f35096e;
    }

    public final String c() {
        return this.f35092a;
    }

    public final String d() {
        return this.f35093b;
    }

    public final boolean e() {
        return this.f35097f;
    }

    public final String f() {
        return this.f35094c;
    }

    public final boolean g() {
        if (TextUtils.isEmpty(this.f35093b) && TextUtils.isEmpty(this.f35094c)) {
            return true;
        }
        return false;
    }

    public final void h(int i10) {
        this.f35095d = i10;
    }

    public final void i(String str) {
        this.f35096e = str;
    }

    public final void j(String str) {
        this.f35092a = str;
    }

    public final void k(String str) {
        this.f35093b = str;
    }

    public final void l(boolean z10) {
        this.f35097f = z10;
    }

    public final void m(String str) {
        this.f35094c = str;
    }

    public String toString() {
        return "name=" + g.o(this.f35093b) + ", number=" + g.l(this.f35094c) + ", connectionLabel=" + this.f35096e + ", cardIconResId=" + this.f35095d + ", nameIsNumber=" + this.f35097f;
    }
}
