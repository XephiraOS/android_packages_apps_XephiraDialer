package x4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* compiled from: ShapeAppearanceModel.java */
/* loaded from: classes3.dex */
public class n {

    /* renamed from: m, reason: collision with root package name */
    public static final d f37922m = new l(0.5f);

    /* renamed from: a, reason: collision with root package name */
    public e f37923a;

    /* renamed from: b, reason: collision with root package name */
    public e f37924b;

    /* renamed from: c, reason: collision with root package name */
    public e f37925c;

    /* renamed from: d, reason: collision with root package name */
    public e f37926d;

    /* renamed from: e, reason: collision with root package name */
    public d f37927e;

    /* renamed from: f, reason: collision with root package name */
    public d f37928f;

    /* renamed from: g, reason: collision with root package name */
    public d f37929g;

    /* renamed from: h, reason: collision with root package name */
    public d f37930h;

    /* renamed from: i, reason: collision with root package name */
    public g f37931i;

    /* renamed from: j, reason: collision with root package name */
    public g f37932j;

    /* renamed from: k, reason: collision with root package name */
    public g f37933k;

    /* renamed from: l, reason: collision with root package name */
    public g f37934l;

    /* compiled from: ShapeAppearanceModel.java */
    /* loaded from: classes3.dex */
    public interface c {
        d a(d dVar);
    }

    public static b a() {
        return new b();
    }

    public static b b(Context context, int i10, int i11) {
        return c(context, i10, i11, 0);
    }

    public static b c(Context context, int i10, int i11, int i12) {
        return d(context, i10, i11, new C1679a(i12));
    }

    public static b d(Context context, int i10, int i11, d dVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        if (i11 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i11);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(e4.m.f31240R8);
        try {
            int i12 = obtainStyledAttributes.getInt(e4.m.f31251S8, 0);
            int i13 = obtainStyledAttributes.getInt(e4.m.f31284V8, i12);
            int i14 = obtainStyledAttributes.getInt(e4.m.f31295W8, i12);
            int i15 = obtainStyledAttributes.getInt(e4.m.f31273U8, i12);
            int i16 = obtainStyledAttributes.getInt(e4.m.f31262T8, i12);
            d m10 = m(obtainStyledAttributes, e4.m.f31306X8, dVar);
            d m11 = m(obtainStyledAttributes, e4.m.f31338a9, m10);
            d m12 = m(obtainStyledAttributes, e4.m.f31349b9, m10);
            d m13 = m(obtainStyledAttributes, e4.m.f31327Z8, m10);
            return new b().F(i13, m11).K(i14, m12).z(i15, m13).u(i16, m(obtainStyledAttributes, e4.m.f31317Y8, m10));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b e(Context context, AttributeSet attributeSet, int i10, int i11) {
        return f(context, attributeSet, i10, i11, 0);
    }

    public static b f(Context context, AttributeSet attributeSet, int i10, int i11, int i12) {
        return g(context, attributeSet, i10, i11, new C1679a(i12));
    }

    public static b g(Context context, AttributeSet attributeSet, int i10, int i11, d dVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e4.m.f31379e6, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(e4.m.f31390f6, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(e4.m.f31401g6, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, dVar);
    }

    public static d m(TypedArray typedArray, int i10, d dVar) {
        TypedValue peekValue = typedArray.peekValue(i10);
        if (peekValue == null) {
            return dVar;
        }
        int i11 = peekValue.type;
        if (i11 == 5) {
            return new C1679a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        if (i11 == 6) {
            return new l(peekValue.getFraction(1.0f, 1.0f));
        }
        return dVar;
    }

    public g h() {
        return this.f37933k;
    }

    public e i() {
        return this.f37926d;
    }

    public d j() {
        return this.f37930h;
    }

    public e k() {
        return this.f37925c;
    }

    public d l() {
        return this.f37929g;
    }

    public g n() {
        return this.f37934l;
    }

    public g o() {
        return this.f37932j;
    }

    public g p() {
        return this.f37931i;
    }

    public e q() {
        return this.f37923a;
    }

    public d r() {
        return this.f37927e;
    }

    public e s() {
        return this.f37924b;
    }

    public d t() {
        return this.f37928f;
    }

    public boolean u(RectF rectF) {
        boolean z10;
        boolean z11;
        boolean z12;
        if (this.f37934l.getClass().equals(g.class) && this.f37932j.getClass().equals(g.class) && this.f37931i.getClass().equals(g.class) && this.f37933k.getClass().equals(g.class)) {
            z10 = true;
        } else {
            z10 = false;
        }
        float a10 = this.f37927e.a(rectF);
        if (this.f37928f.a(rectF) == a10 && this.f37930h.a(rectF) == a10 && this.f37929g.a(rectF) == a10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((this.f37924b instanceof m) && (this.f37923a instanceof m) && (this.f37925c instanceof m) && (this.f37926d instanceof m)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z10 || !z11 || !z12) {
            return false;
        }
        return true;
    }

    public b v() {
        return new b(this);
    }

    public n w(float f10) {
        return v().o(f10).m();
    }

    public n x(d dVar) {
        return v().p(dVar).m();
    }

    public n y(c cVar) {
        return v().I(cVar.a(r())).N(cVar.a(t())).x(cVar.a(j())).C(cVar.a(l())).m();
    }

    public n(b bVar) {
        this.f37923a = bVar.f37935a;
        this.f37924b = bVar.f37936b;
        this.f37925c = bVar.f37937c;
        this.f37926d = bVar.f37938d;
        this.f37927e = bVar.f37939e;
        this.f37928f = bVar.f37940f;
        this.f37929g = bVar.f37941g;
        this.f37930h = bVar.f37942h;
        this.f37931i = bVar.f37943i;
        this.f37932j = bVar.f37944j;
        this.f37933k = bVar.f37945k;
        this.f37934l = bVar.f37946l;
    }

    /* compiled from: ShapeAppearanceModel.java */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public e f37935a;

        /* renamed from: b, reason: collision with root package name */
        public e f37936b;

        /* renamed from: c, reason: collision with root package name */
        public e f37937c;

        /* renamed from: d, reason: collision with root package name */
        public e f37938d;

        /* renamed from: e, reason: collision with root package name */
        public d f37939e;

        /* renamed from: f, reason: collision with root package name */
        public d f37940f;

        /* renamed from: g, reason: collision with root package name */
        public d f37941g;

        /* renamed from: h, reason: collision with root package name */
        public d f37942h;

        /* renamed from: i, reason: collision with root package name */
        public g f37943i;

        /* renamed from: j, reason: collision with root package name */
        public g f37944j;

        /* renamed from: k, reason: collision with root package name */
        public g f37945k;

        /* renamed from: l, reason: collision with root package name */
        public g f37946l;

        public b() {
            this.f37935a = j.b();
            this.f37936b = j.b();
            this.f37937c = j.b();
            this.f37938d = j.b();
            this.f37939e = new C1679a(0.0f);
            this.f37940f = new C1679a(0.0f);
            this.f37941g = new C1679a(0.0f);
            this.f37942h = new C1679a(0.0f);
            this.f37943i = j.c();
            this.f37944j = j.c();
            this.f37945k = j.c();
            this.f37946l = j.c();
        }

        public static float n(e eVar) {
            if (eVar instanceof m) {
                return ((m) eVar).f37921a;
            }
            if (eVar instanceof f) {
                return ((f) eVar).f37891a;
            }
            return -1.0f;
        }

        public b A(e eVar) {
            this.f37937c = eVar;
            float n10 = n(eVar);
            if (n10 != -1.0f) {
                B(n10);
            }
            return this;
        }

        public b B(float f10) {
            this.f37941g = new C1679a(f10);
            return this;
        }

        public b C(d dVar) {
            this.f37941g = dVar;
            return this;
        }

        public b D(g gVar) {
            this.f37943i = gVar;
            return this;
        }

        public b E(int i10, float f10) {
            return G(j.a(i10)).H(f10);
        }

        public b F(int i10, d dVar) {
            return G(j.a(i10)).I(dVar);
        }

        public b G(e eVar) {
            this.f37935a = eVar;
            float n10 = n(eVar);
            if (n10 != -1.0f) {
                H(n10);
            }
            return this;
        }

        public b H(float f10) {
            this.f37939e = new C1679a(f10);
            return this;
        }

        public b I(d dVar) {
            this.f37939e = dVar;
            return this;
        }

        public b J(int i10, float f10) {
            return L(j.a(i10)).M(f10);
        }

        public b K(int i10, d dVar) {
            return L(j.a(i10)).N(dVar);
        }

        public b L(e eVar) {
            this.f37936b = eVar;
            float n10 = n(eVar);
            if (n10 != -1.0f) {
                M(n10);
            }
            return this;
        }

        public b M(float f10) {
            this.f37940f = new C1679a(f10);
            return this;
        }

        public b N(d dVar) {
            this.f37940f = dVar;
            return this;
        }

        public n m() {
            return new n(this);
        }

        public b o(float f10) {
            return H(f10).M(f10).B(f10).w(f10);
        }

        public b p(d dVar) {
            return I(dVar).N(dVar).C(dVar).x(dVar);
        }

        public b q(int i10, float f10) {
            return r(j.a(i10)).o(f10);
        }

        public b r(e eVar) {
            return G(eVar).L(eVar).A(eVar).v(eVar);
        }

        public b s(g gVar) {
            this.f37945k = gVar;
            return this;
        }

        public b t(int i10, float f10) {
            return v(j.a(i10)).w(f10);
        }

        public b u(int i10, d dVar) {
            return v(j.a(i10)).x(dVar);
        }

        public b v(e eVar) {
            this.f37938d = eVar;
            float n10 = n(eVar);
            if (n10 != -1.0f) {
                w(n10);
            }
            return this;
        }

        public b w(float f10) {
            this.f37942h = new C1679a(f10);
            return this;
        }

        public b x(d dVar) {
            this.f37942h = dVar;
            return this;
        }

        public b y(int i10, float f10) {
            return A(j.a(i10)).B(f10);
        }

        public b z(int i10, d dVar) {
            return A(j.a(i10)).C(dVar);
        }

        public b(n nVar) {
            this.f37935a = j.b();
            this.f37936b = j.b();
            this.f37937c = j.b();
            this.f37938d = j.b();
            this.f37939e = new C1679a(0.0f);
            this.f37940f = new C1679a(0.0f);
            this.f37941g = new C1679a(0.0f);
            this.f37942h = new C1679a(0.0f);
            this.f37943i = j.c();
            this.f37944j = j.c();
            this.f37945k = j.c();
            this.f37946l = j.c();
            this.f37935a = nVar.f37923a;
            this.f37936b = nVar.f37924b;
            this.f37937c = nVar.f37925c;
            this.f37938d = nVar.f37926d;
            this.f37939e = nVar.f37927e;
            this.f37940f = nVar.f37928f;
            this.f37941g = nVar.f37929g;
            this.f37942h = nVar.f37930h;
            this.f37943i = nVar.f37931i;
            this.f37944j = nVar.f37932j;
            this.f37945k = nVar.f37933k;
            this.f37946l = nVar.f37934l;
        }
    }

    public n() {
        this.f37923a = j.b();
        this.f37924b = j.b();
        this.f37925c = j.b();
        this.f37926d = j.b();
        this.f37927e = new C1679a(0.0f);
        this.f37928f = new C1679a(0.0f);
        this.f37929g = new C1679a(0.0f);
        this.f37930h = new C1679a(0.0f);
        this.f37931i = j.c();
        this.f37932j = j.c();
        this.f37933k = j.c();
        this.f37934l = j.c();
    }
}
