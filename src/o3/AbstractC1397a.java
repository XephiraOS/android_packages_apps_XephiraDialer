package o3;

import X2.g;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.android.incallui.OplusPhoneUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.heytap.accessory.constant.FastPairConstants;
import g3.i;
import g3.j;
import g3.l;
import g3.n;
import java.util.Map;
import o3.AbstractC1397a;
import r3.C1507a;
import s3.C1531b;
import s3.C1540k;
import s3.C1541l;

/* compiled from: BaseRequestOptions.java */
/* renamed from: o3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1397a<T extends AbstractC1397a<T>> implements Cloneable {

    /* renamed from: A, reason: collision with root package name */
    public boolean f35728A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f35729B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f35730C;

    /* renamed from: E, reason: collision with root package name */
    public boolean f35732E;

    /* renamed from: a, reason: collision with root package name */
    public int f35733a;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f35737e;

    /* renamed from: f, reason: collision with root package name */
    public int f35738f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f35739g;

    /* renamed from: h, reason: collision with root package name */
    public int f35740h;

    /* renamed from: m, reason: collision with root package name */
    public boolean f35745m;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f35747o;

    /* renamed from: p, reason: collision with root package name */
    public int f35748p;

    /* renamed from: y, reason: collision with root package name */
    public boolean f35752y;

    /* renamed from: z, reason: collision with root package name */
    public Resources.Theme f35753z;

    /* renamed from: b, reason: collision with root package name */
    public float f35734b = 1.0f;

    /* renamed from: c, reason: collision with root package name */
    public Z2.c f35735c = Z2.c.f5874e;

    /* renamed from: d, reason: collision with root package name */
    public Priority f35736d = Priority.NORMAL;

    /* renamed from: i, reason: collision with root package name */
    public boolean f35741i = true;

    /* renamed from: j, reason: collision with root package name */
    public int f35742j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f35743k = -1;

    /* renamed from: l, reason: collision with root package name */
    public X2.b f35744l = C1507a.c();

    /* renamed from: n, reason: collision with root package name */
    public boolean f35746n = true;

    /* renamed from: q, reason: collision with root package name */
    public X2.d f35749q = new X2.d();

    /* renamed from: r, reason: collision with root package name */
    public Map<Class<?>, g<?>> f35750r = new C1531b();

    /* renamed from: x, reason: collision with root package name */
    public Class<?> f35751x = Object.class;

    /* renamed from: D, reason: collision with root package name */
    public boolean f35731D = true;

    public static boolean H(int i10, int i11) {
        if ((i10 & i11) != 0) {
            return true;
        }
        return false;
    }

    public final boolean A() {
        return this.f35729B;
    }

    public final boolean B() {
        return this.f35728A;
    }

    public final boolean C(AbstractC1397a<?> abstractC1397a) {
        if (Float.compare(abstractC1397a.f35734b, this.f35734b) == 0 && this.f35738f == abstractC1397a.f35738f && C1541l.d(this.f35737e, abstractC1397a.f35737e) && this.f35740h == abstractC1397a.f35740h && C1541l.d(this.f35739g, abstractC1397a.f35739g) && this.f35748p == abstractC1397a.f35748p && C1541l.d(this.f35747o, abstractC1397a.f35747o) && this.f35741i == abstractC1397a.f35741i && this.f35742j == abstractC1397a.f35742j && this.f35743k == abstractC1397a.f35743k && this.f35745m == abstractC1397a.f35745m && this.f35746n == abstractC1397a.f35746n && this.f35729B == abstractC1397a.f35729B && this.f35730C == abstractC1397a.f35730C && this.f35735c.equals(abstractC1397a.f35735c) && this.f35736d == abstractC1397a.f35736d && this.f35749q.equals(abstractC1397a.f35749q) && this.f35750r.equals(abstractC1397a.f35750r) && this.f35751x.equals(abstractC1397a.f35751x) && C1541l.d(this.f35744l, abstractC1397a.f35744l) && C1541l.d(this.f35753z, abstractC1397a.f35753z)) {
            return true;
        }
        return false;
    }

    public final boolean D() {
        return this.f35741i;
    }

    public final boolean E() {
        return G(8);
    }

    public boolean F() {
        return this.f35731D;
    }

    public final boolean G(int i10) {
        return H(this.f35733a, i10);
    }

    public final boolean I() {
        return this.f35746n;
    }

    public final boolean J() {
        return this.f35745m;
    }

    public final boolean K() {
        return G(2048);
    }

    public final boolean L() {
        return C1541l.t(this.f35743k, this.f35742j);
    }

    public T M() {
        this.f35752y = true;
        return X();
    }

    public T N() {
        return R(DownsampleStrategy.f19637e, new i());
    }

    public T O() {
        return Q(DownsampleStrategy.f19636d, new j());
    }

    public T P() {
        return Q(DownsampleStrategy.f19635c, new n());
    }

    public final T Q(DownsampleStrategy downsampleStrategy, g<Bitmap> gVar) {
        return W(downsampleStrategy, gVar, false);
    }

    public final T R(DownsampleStrategy downsampleStrategy, g<Bitmap> gVar) {
        if (this.f35728A) {
            return (T) clone().R(downsampleStrategy, gVar);
        }
        g(downsampleStrategy);
        return e0(gVar, false);
    }

    public T S(int i10) {
        return T(i10, i10);
    }

    public T T(int i10, int i11) {
        if (this.f35728A) {
            return (T) clone().T(i10, i11);
        }
        this.f35743k = i10;
        this.f35742j = i11;
        this.f35733a |= 512;
        return Y();
    }

    public T U(Drawable drawable) {
        if (this.f35728A) {
            return (T) clone().U(drawable);
        }
        this.f35739g = drawable;
        int i10 = this.f35733a | 64;
        this.f35740h = 0;
        this.f35733a = i10 & (-129);
        return Y();
    }

    public T V(Priority priority) {
        if (this.f35728A) {
            return (T) clone().V(priority);
        }
        this.f35736d = (Priority) C1540k.d(priority);
        this.f35733a |= 8;
        return Y();
    }

    public final T W(DownsampleStrategy downsampleStrategy, g<Bitmap> gVar, boolean z10) {
        T R10;
        if (z10) {
            R10 = f0(downsampleStrategy, gVar);
        } else {
            R10 = R(downsampleStrategy, gVar);
        }
        R10.f35731D = true;
        return R10;
    }

    public final T Y() {
        if (!this.f35752y) {
            return X();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public <Y> T Z(X2.c<Y> cVar, Y y10) {
        if (this.f35728A) {
            return (T) clone().Z(cVar, y10);
        }
        C1540k.d(cVar);
        C1540k.d(y10);
        this.f35749q.e(cVar, y10);
        return Y();
    }

    public T a(AbstractC1397a<?> abstractC1397a) {
        if (this.f35728A) {
            return (T) clone().a(abstractC1397a);
        }
        if (H(abstractC1397a.f35733a, 2)) {
            this.f35734b = abstractC1397a.f35734b;
        }
        if (H(abstractC1397a.f35733a, 262144)) {
            this.f35729B = abstractC1397a.f35729B;
        }
        if (H(abstractC1397a.f35733a, OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS)) {
            this.f35732E = abstractC1397a.f35732E;
        }
        if (H(abstractC1397a.f35733a, 4)) {
            this.f35735c = abstractC1397a.f35735c;
        }
        if (H(abstractC1397a.f35733a, 8)) {
            this.f35736d = abstractC1397a.f35736d;
        }
        if (H(abstractC1397a.f35733a, 16)) {
            this.f35737e = abstractC1397a.f35737e;
            this.f35738f = 0;
            this.f35733a &= -33;
        }
        if (H(abstractC1397a.f35733a, 32)) {
            this.f35738f = abstractC1397a.f35738f;
            this.f35737e = null;
            this.f35733a &= -17;
        }
        if (H(abstractC1397a.f35733a, 64)) {
            this.f35739g = abstractC1397a.f35739g;
            this.f35740h = 0;
            this.f35733a &= -129;
        }
        if (H(abstractC1397a.f35733a, 128)) {
            this.f35740h = abstractC1397a.f35740h;
            this.f35739g = null;
            this.f35733a &= -65;
        }
        if (H(abstractC1397a.f35733a, 256)) {
            this.f35741i = abstractC1397a.f35741i;
        }
        if (H(abstractC1397a.f35733a, 512)) {
            this.f35743k = abstractC1397a.f35743k;
            this.f35742j = abstractC1397a.f35742j;
        }
        if (H(abstractC1397a.f35733a, 1024)) {
            this.f35744l = abstractC1397a.f35744l;
        }
        if (H(abstractC1397a.f35733a, 4096)) {
            this.f35751x = abstractC1397a.f35751x;
        }
        if (H(abstractC1397a.f35733a, 8192)) {
            this.f35747o = abstractC1397a.f35747o;
            this.f35748p = 0;
            this.f35733a &= -16385;
        }
        if (H(abstractC1397a.f35733a, 16384)) {
            this.f35748p = abstractC1397a.f35748p;
            this.f35747o = null;
            this.f35733a &= -8193;
        }
        if (H(abstractC1397a.f35733a, FastPairConstants.PAIR_TYPE_BLE_IN_PAIR)) {
            this.f35753z = abstractC1397a.f35753z;
        }
        if (H(abstractC1397a.f35733a, 65536)) {
            this.f35746n = abstractC1397a.f35746n;
        }
        if (H(abstractC1397a.f35733a, 131072)) {
            this.f35745m = abstractC1397a.f35745m;
        }
        if (H(abstractC1397a.f35733a, 2048)) {
            this.f35750r.putAll(abstractC1397a.f35750r);
            this.f35731D = abstractC1397a.f35731D;
        }
        if (H(abstractC1397a.f35733a, 524288)) {
            this.f35730C = abstractC1397a.f35730C;
        }
        if (!this.f35746n) {
            this.f35750r.clear();
            int i10 = this.f35733a;
            this.f35745m = false;
            this.f35733a = i10 & (-133121);
            this.f35731D = true;
        }
        this.f35733a |= abstractC1397a.f35733a;
        this.f35749q.d(abstractC1397a.f35749q);
        return Y();
    }

    public T a0(X2.b bVar) {
        if (this.f35728A) {
            return (T) clone().a0(bVar);
        }
        this.f35744l = (X2.b) C1540k.d(bVar);
        this.f35733a |= 1024;
        return Y();
    }

    public T b() {
        if (this.f35752y && !this.f35728A) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f35728A = true;
        return M();
    }

    public T b0(float f10) {
        if (this.f35728A) {
            return (T) clone().b0(f10);
        }
        if (f10 >= 0.0f && f10 <= 1.0f) {
            this.f35734b = f10;
            this.f35733a |= 2;
            return Y();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public T c() {
        return f0(DownsampleStrategy.f19637e, new i());
    }

    public T c0(boolean z10) {
        if (this.f35728A) {
            return (T) clone().c0(true);
        }
        this.f35741i = !z10;
        this.f35733a |= 256;
        return Y();
    }

    @Override // 
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public T clone() {
        try {
            T t10 = (T) super.clone();
            X2.d dVar = new X2.d();
            t10.f35749q = dVar;
            dVar.d(this.f35749q);
            C1531b c1531b = new C1531b();
            t10.f35750r = c1531b;
            c1531b.putAll(this.f35750r);
            t10.f35752y = false;
            t10.f35728A = false;
            return t10;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public T d0(g<Bitmap> gVar) {
        return e0(gVar, true);
    }

    public T e(Class<?> cls) {
        if (this.f35728A) {
            return (T) clone().e(cls);
        }
        this.f35751x = (Class) C1540k.d(cls);
        this.f35733a |= 4096;
        return Y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T e0(g<Bitmap> gVar, boolean z10) {
        if (this.f35728A) {
            return (T) clone().e0(gVar, z10);
        }
        l lVar = new l(gVar, z10);
        g0(Bitmap.class, gVar, z10);
        g0(Drawable.class, lVar, z10);
        g0(BitmapDrawable.class, lVar.c(), z10);
        g0(k3.c.class, new k3.f(gVar), z10);
        return Y();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC1397a) {
            return C((AbstractC1397a) obj);
        }
        return false;
    }

    public T f(Z2.c cVar) {
        if (this.f35728A) {
            return (T) clone().f(cVar);
        }
        this.f35735c = (Z2.c) C1540k.d(cVar);
        this.f35733a |= 4;
        return Y();
    }

    public final T f0(DownsampleStrategy downsampleStrategy, g<Bitmap> gVar) {
        if (this.f35728A) {
            return (T) clone().f0(downsampleStrategy, gVar);
        }
        g(downsampleStrategy);
        return d0(gVar);
    }

    public T g(DownsampleStrategy downsampleStrategy) {
        return Z(DownsampleStrategy.f19640h, C1540k.d(downsampleStrategy));
    }

    public <Y> T g0(Class<Y> cls, g<Y> gVar, boolean z10) {
        if (this.f35728A) {
            return (T) clone().g0(cls, gVar, z10);
        }
        C1540k.d(cls);
        C1540k.d(gVar);
        this.f35750r.put(cls, gVar);
        int i10 = this.f35733a;
        this.f35746n = true;
        this.f35733a = 67584 | i10;
        this.f35731D = false;
        if (z10) {
            this.f35733a = i10 | 198656;
            this.f35745m = true;
        }
        return Y();
    }

    public T h(int i10) {
        if (this.f35728A) {
            return (T) clone().h(i10);
        }
        this.f35738f = i10;
        int i11 = this.f35733a | 32;
        this.f35737e = null;
        this.f35733a = i11 & (-17);
        return Y();
    }

    public T h0(boolean z10) {
        if (this.f35728A) {
            return (T) clone().h0(z10);
        }
        this.f35732E = z10;
        this.f35733a |= OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS;
        return Y();
    }

    public int hashCode() {
        return C1541l.o(this.f35753z, C1541l.o(this.f35744l, C1541l.o(this.f35751x, C1541l.o(this.f35750r, C1541l.o(this.f35749q, C1541l.o(this.f35736d, C1541l.o(this.f35735c, C1541l.p(this.f35730C, C1541l.p(this.f35729B, C1541l.p(this.f35746n, C1541l.p(this.f35745m, C1541l.n(this.f35743k, C1541l.n(this.f35742j, C1541l.p(this.f35741i, C1541l.o(this.f35747o, C1541l.n(this.f35748p, C1541l.o(this.f35739g, C1541l.n(this.f35740h, C1541l.o(this.f35737e, C1541l.n(this.f35738f, C1541l.l(this.f35734b)))))))))))))))))))));
    }

    public final Z2.c i() {
        return this.f35735c;
    }

    public final int j() {
        return this.f35738f;
    }

    public final Drawable k() {
        return this.f35737e;
    }

    public final Drawable l() {
        return this.f35747o;
    }

    public final int m() {
        return this.f35748p;
    }

    public final boolean n() {
        return this.f35730C;
    }

    public final X2.d o() {
        return this.f35749q;
    }

    public final int p() {
        return this.f35742j;
    }

    public final int q() {
        return this.f35743k;
    }

    public final Drawable r() {
        return this.f35739g;
    }

    public final int s() {
        return this.f35740h;
    }

    public final Priority t() {
        return this.f35736d;
    }

    public final Class<?> u() {
        return this.f35751x;
    }

    public final X2.b v() {
        return this.f35744l;
    }

    public final float w() {
        return this.f35734b;
    }

    public final Resources.Theme x() {
        return this.f35753z;
    }

    public final Map<Class<?>, g<?>> y() {
        return this.f35750r;
    }

    public final boolean z() {
        return this.f35732E;
    }

    public final T X() {
        return this;
    }
}
