package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import h.C1069a;
import j0.C1157g;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p.C1420f;
import p.C1422h;

/* compiled from: ResourceManagerInternal.java */
/* loaded from: classes.dex */
public final class A {

    /* renamed from: i, reason: collision with root package name */
    public static A f7456i;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap<Context, p.j<ColorStateList>> f7458a;

    /* renamed from: b, reason: collision with root package name */
    public p.i<String, b> f7459b;

    /* renamed from: c, reason: collision with root package name */
    public p.j<String> f7460c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakHashMap<Context, C1420f<WeakReference<Drawable.ConstantState>>> f7461d = new WeakHashMap<>(0);

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f7462e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7463f;

    /* renamed from: g, reason: collision with root package name */
    public c f7464g;

    /* renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f7455h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    public static final a f7457j = new a(6);

    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public static class a extends C1422h<Integer, PorterDuffColorFilter> {
        public a(int i10) {
            super(i10);
        }

        public static int generateCacheKey(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter get(int i10, PorterDuff.Mode mode) {
            return get(Integer.valueOf(generateCacheKey(i10, mode)));
        }

        public PorterDuffColorFilter put(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(generateCacheKey(i10, mode)), porterDuffColorFilter);
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public interface c {
        boolean a(Context context, int i10, Drawable drawable);

        PorterDuff.Mode b(int i10);

        Drawable c(A a10, Context context, int i10);

        ColorStateList d(Context context, int i10);

        boolean e(Context context, int i10, Drawable drawable);
    }

    public static long d(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    public static PorterDuffColorFilter f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList != null && mode != null) {
            return k(colorStateList.getColorForState(iArr, 0), mode);
        }
        return null;
    }

    public static synchronized A g() {
        A a10;
        synchronized (A.class) {
            try {
                if (f7456i == null) {
                    A a11 = new A();
                    f7456i = a11;
                    o(a11);
                }
                a10 = f7456i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return a10;
    }

    public static synchronized PorterDuffColorFilter k(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (A.class) {
            a aVar = f7457j;
            porterDuffColorFilter = aVar.get(i10, mode);
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i10, mode);
                aVar.put(i10, mode, porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    public static boolean p(Drawable drawable) {
        if (!(drawable instanceof C1157g) && !"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            return false;
        }
        return true;
    }

    public static void v(Drawable drawable, I i10, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z10 = i10.f7722d;
            if (!z10 && !i10.f7721c) {
                drawable.clearColorFilter();
                return;
            }
            if (z10) {
                colorStateList = i10.f7719a;
            } else {
                colorStateList = null;
            }
            if (i10.f7721c) {
                mode = i10.f7720b;
            } else {
                mode = f7455h;
            }
            drawable.setColorFilter(f(colorStateList, mode, iArr));
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    public final synchronized boolean a(Context context, long j10, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                C1420f<WeakReference<Drawable.ConstantState>> c1420f = this.f7461d.get(context);
                if (c1420f == null) {
                    c1420f = new C1420f<>();
                    this.f7461d.put(context, c1420f);
                }
                c1420f.h(j10, new WeakReference<>(constantState));
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(Context context, int i10, ColorStateList colorStateList) {
        if (this.f7458a == null) {
            this.f7458a = new WeakHashMap<>();
        }
        p.j<ColorStateList> jVar = this.f7458a.get(context);
        if (jVar == null) {
            jVar = new p.j<>();
            this.f7458a.put(context, jVar);
        }
        jVar.a(i10, colorStateList);
    }

    public final void c(Context context) {
        if (this.f7463f) {
            return;
        }
        this.f7463f = true;
        Drawable i10 = i(context, C1069a.f31996a);
        if (i10 != null && p(i10)) {
            return;
        }
        this.f7463f = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }

    public final Drawable e(Context context, int i10) {
        Drawable c10;
        if (this.f7462e == null) {
            this.f7462e = new TypedValue();
        }
        TypedValue typedValue = this.f7462e;
        context.getResources().getValue(i10, typedValue, true);
        long d10 = d(typedValue);
        Drawable h10 = h(context, d10);
        if (h10 != null) {
            return h10;
        }
        c cVar = this.f7464g;
        if (cVar == null) {
            c10 = null;
        } else {
            c10 = cVar.c(this, context, i10);
        }
        if (c10 != null) {
            c10.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, d10, c10);
        }
        return c10;
    }

    public final synchronized Drawable h(Context context, long j10) {
        C1420f<WeakReference<Drawable.ConstantState>> c1420f = this.f7461d.get(context);
        if (c1420f == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> d10 = c1420f.d(j10);
        if (d10 != null) {
            Drawable.ConstantState constantState = d10.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            c1420f.i(j10);
        }
        return null;
    }

    public synchronized Drawable i(Context context, int i10) {
        return j(context, i10, false);
    }

    public synchronized Drawable j(Context context, int i10, boolean z10) {
        Drawable q10;
        try {
            c(context);
            q10 = q(context, i10);
            if (q10 == null) {
                q10 = e(context, i10);
            }
            if (q10 == null) {
                q10 = androidx.core.content.b.e(context, i10);
            }
            if (q10 != null) {
                q10 = u(context, i10, z10, q10);
            }
            if (q10 != null) {
                u.b(q10);
            }
        } catch (Throwable th) {
            throw th;
        }
        return q10;
    }

    public synchronized ColorStateList l(Context context, int i10) {
        ColorStateList m10;
        m10 = m(context, i10);
        if (m10 == null) {
            c cVar = this.f7464g;
            if (cVar == null) {
                m10 = null;
            } else {
                m10 = cVar.d(context, i10);
            }
            if (m10 != null) {
                b(context, i10, m10);
            }
        }
        return m10;
    }

    public final ColorStateList m(Context context, int i10) {
        p.j<ColorStateList> jVar;
        WeakHashMap<Context, p.j<ColorStateList>> weakHashMap = this.f7458a;
        if (weakHashMap == null || (jVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return jVar.d(i10);
    }

    public PorterDuff.Mode n(int i10) {
        c cVar = this.f7464g;
        if (cVar == null) {
            return null;
        }
        return cVar.b(i10);
    }

    public final Drawable q(Context context, int i10) {
        int next;
        p.i<String, b> iVar = this.f7459b;
        if (iVar == null || iVar.isEmpty()) {
            return null;
        }
        p.j<String> jVar = this.f7460c;
        if (jVar != null) {
            String d10 = jVar.d(i10);
            if ("appcompat_skip_skip".equals(d10) || (d10 != null && this.f7459b.get(d10) == null)) {
                return null;
            }
        } else {
            this.f7460c = new p.j<>();
        }
        if (this.f7462e == null) {
            this.f7462e = new TypedValue();
        }
        TypedValue typedValue = this.f7462e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long d11 = d(typedValue);
        Drawable h10 = h(context, d11);
        if (h10 != null) {
            return h10;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2) {
                    String name = xml.getName();
                    this.f7460c.a(i10, name);
                    b bVar = this.f7459b.get(name);
                    if (bVar != null) {
                        h10 = bVar.a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (h10 != null) {
                        h10.setChangingConfigurations(typedValue.changingConfigurations);
                        a(context, d11, h10);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e10) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e10);
            }
        }
        if (h10 == null) {
            this.f7460c.a(i10, "appcompat_skip_skip");
        }
        return h10;
    }

    public synchronized void r(Context context) {
        C1420f<WeakReference<Drawable.ConstantState>> c1420f = this.f7461d.get(context);
        if (c1420f != null) {
            c1420f.a();
        }
    }

    public synchronized Drawable s(Context context, Q q10, int i10) {
        try {
            Drawable q11 = q(context, i10);
            if (q11 == null) {
                q11 = q10.a(i10);
            }
            if (q11 != null) {
                return u(context, i10, false, q11);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void t(c cVar) {
        this.f7464g = cVar;
    }

    public final Drawable u(Context context, int i10, boolean z10, Drawable drawable) {
        ColorStateList l10 = l(context, i10);
        if (l10 != null) {
            Drawable r10 = C.a.r(drawable.mutate());
            C.a.o(r10, l10);
            PorterDuff.Mode n10 = n(i10);
            if (n10 != null) {
                C.a.p(r10, n10);
                return r10;
            }
            return r10;
        }
        c cVar = this.f7464g;
        if ((cVar == null || !cVar.e(context, i10, drawable)) && !w(context, i10, drawable) && z10) {
            return null;
        }
        return drawable;
    }

    public boolean w(Context context, int i10, Drawable drawable) {
        c cVar = this.f7464g;
        if (cVar != null && cVar.a(context, i10, drawable)) {
            return true;
        }
        return false;
    }

    public static void o(A a10) {
    }
}
