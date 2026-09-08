package k0;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p.C1415a;

/* compiled from: VersionedParcel.java */
/* renamed from: k0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1206a {

    /* renamed from: a, reason: collision with root package name */
    public final C1415a<String, Method> f34058a;

    /* renamed from: b, reason: collision with root package name */
    public final C1415a<String, Method> f34059b;

    /* renamed from: c, reason: collision with root package name */
    public final C1415a<String, Class> f34060c;

    public AbstractC1206a(C1415a<String, Method> c1415a, C1415a<String, Method> c1415a2, C1415a<String, Class> c1415a3) {
        this.f34058a = c1415a;
        this.f34059b = c1415a2;
        this.f34060c = c1415a3;
    }

    public abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i10) {
        w(i10);
        A(bArr);
    }

    public abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i10) {
        w(i10);
        C(charSequence);
    }

    public abstract void E(int i10);

    public void F(int i10, int i11) {
        w(i11);
        E(i10);
    }

    public abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i10) {
        w(i10);
        G(parcelable);
    }

    public abstract void I(String str);

    public void J(String str, int i10) {
        w(i10);
        I(str);
    }

    public <T extends c> void K(T t10, AbstractC1206a abstractC1206a) {
        try {
            e(t10.getClass()).invoke(null, t10, abstractC1206a);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (InvocationTargetException e13) {
            if (e13.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e13.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e13);
        }
    }

    public void L(c cVar) {
        if (cVar == null) {
            I(null);
            return;
        }
        N(cVar);
        AbstractC1206a b10 = b();
        K(cVar, b10);
        b10.a();
    }

    public void M(c cVar, int i10) {
        w(i10);
        L(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N(c cVar) {
        try {
            I(c(cVar.getClass()).getName());
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e10);
        }
    }

    public abstract void a();

    public abstract AbstractC1206a b();

    public final Class c(Class<? extends c> cls) {
        Class cls2 = this.f34060c.get(cls.getName());
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.f34060c.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    public final Method d(String str) {
        Method method = this.f34058a.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, AbstractC1206a.class.getClassLoader()).getDeclaredMethod("read", AbstractC1206a.class);
            this.f34058a.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public final Method e(Class cls) {
        Method method = this.f34059b.get(cls.getName());
        if (method == null) {
            Class c10 = c(cls);
            System.currentTimeMillis();
            Method declaredMethod = c10.getDeclaredMethod("write", cls, AbstractC1206a.class);
            this.f34059b.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public boolean h(boolean z10, int i10) {
        if (!m(i10)) {
            return z10;
        }
        return g();
    }

    public abstract byte[] i();

    public byte[] j(byte[] bArr, int i10) {
        if (!m(i10)) {
            return bArr;
        }
        return i();
    }

    public abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i10) {
        if (!m(i10)) {
            return charSequence;
        }
        return k();
    }

    public abstract boolean m(int i10);

    public <T extends c> T n(String str, AbstractC1206a abstractC1206a) {
        try {
            return (T) d(str).invoke(null, abstractC1206a);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (InvocationTargetException e13) {
            if (e13.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e13.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e13);
        }
    }

    public abstract int o();

    public int p(int i10, int i11) {
        if (!m(i11)) {
            return i10;
        }
        return o();
    }

    public abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t10, int i10) {
        if (!m(i10)) {
            return t10;
        }
        return (T) q();
    }

    public abstract String s();

    public String t(String str, int i10) {
        if (!m(i10)) {
            return str;
        }
        return s();
    }

    public <T extends c> T u() {
        String s10 = s();
        if (s10 == null) {
            return null;
        }
        return (T) n(s10, b());
    }

    public <T extends c> T v(T t10, int i10) {
        if (!m(i10)) {
            return t10;
        }
        return (T) u();
    }

    public abstract void w(int i10);

    public abstract void y(boolean z10);

    public void z(boolean z10, int i10) {
        w(i10);
        y(z10);
    }

    public void x(boolean z10, boolean z11) {
    }
}
