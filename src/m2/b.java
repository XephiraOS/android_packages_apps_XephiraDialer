package m2;

import D2.g;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: PrimaryInfo.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: n, reason: collision with root package name */
    public static final a f35077n = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public String f35078a;

    /* renamed from: b, reason: collision with root package name */
    public String f35079b;

    /* renamed from: c, reason: collision with root package name */
    public String f35080c;

    /* renamed from: d, reason: collision with root package name */
    public String f35081d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f35082e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f35083f;

    /* renamed from: g, reason: collision with root package name */
    public int f35084g = -1;

    /* renamed from: h, reason: collision with root package name */
    public String f35085h;

    /* renamed from: i, reason: collision with root package name */
    public String f35086i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f35087j;

    /* renamed from: k, reason: collision with root package name */
    public String f35088k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f35089l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f35090m;

    /* compiled from: PrimaryInfo.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final boolean a(b bVar, b bVar2) {
            String str;
            String str2 = null;
            if (bVar != null) {
                str = bVar.d();
            } else {
                str = null;
            }
            if (bVar2 != null) {
                str2 = bVar2.d();
            }
            return i.b(str, str2);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final Drawable a() {
        return this.f35082e;
    }

    public final int b() {
        return this.f35084g;
    }

    public final String c() {
        return this.f35085h;
    }

    public final String d() {
        return this.f35078a;
    }

    public final String e() {
        return this.f35088k;
    }

    public final String f() {
        return this.f35081d;
    }

    public final String g() {
        return this.f35086i;
    }

    public final String h() {
        return this.f35079b;
    }

    public final boolean i() {
        return this.f35087j;
    }

    public final String j() {
        return this.f35080c;
    }

    public final boolean k() {
        return this.f35089l;
    }

    public final boolean l() {
        return this.f35090m;
    }

    public final void m(Drawable drawable) {
        this.f35082e = drawable;
    }

    public final void n(int i10) {
        this.f35084g = i10;
    }

    public final void o(String str) {
        this.f35085h = str;
    }

    public final void p(boolean z10) {
        this.f35083f = z10;
    }

    public final void q(String str) {
        this.f35078a = str;
    }

    public final void r(String str) {
        this.f35088k = str;
    }

    public final void s(String str) {
        this.f35081d = str;
    }

    public final void t(String str) {
        this.f35086i = str;
    }

    public String toString() {
        return "id=" + this.f35078a + ", name=" + g.o(this.f35079b) + ", number=" + g.l(this.f35080c) + ", isEmergency=" + this.f35083f + ", nameIsNumber=" + this.f35087j + ", location=" + g.o(this.f35081d) + ", avatar=" + this.f35082e + ", contactType=" + this.f35085h + ", job=" + this.f35088k + ", isPenetratedIncomingCall=" + this.f35089l + ", isVoiceMailNumber=" + this.f35090m;
    }

    public final void u(String str) {
        this.f35079b = str;
    }

    public final void v(boolean z10) {
        this.f35087j = z10;
    }

    public final void w(String str) {
        this.f35080c = str;
    }

    public final void x(boolean z10) {
        this.f35089l = z10;
    }

    public final void y(boolean z10) {
        this.f35090m = z10;
    }
}
