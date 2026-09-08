package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: FragmentTransaction.java */
/* loaded from: classes.dex */
public abstract class B {

    /* renamed from: a, reason: collision with root package name */
    public final k f9846a;

    /* renamed from: b, reason: collision with root package name */
    public final ClassLoader f9847b;

    /* renamed from: d, reason: collision with root package name */
    public int f9849d;

    /* renamed from: e, reason: collision with root package name */
    public int f9850e;

    /* renamed from: f, reason: collision with root package name */
    public int f9851f;

    /* renamed from: g, reason: collision with root package name */
    public int f9852g;

    /* renamed from: h, reason: collision with root package name */
    public int f9853h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9854i;

    /* renamed from: k, reason: collision with root package name */
    public String f9856k;

    /* renamed from: l, reason: collision with root package name */
    public int f9857l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f9858m;

    /* renamed from: n, reason: collision with root package name */
    public int f9859n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f9860o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<String> f9861p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<String> f9862q;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList<Runnable> f9864s;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<a> f9848c = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public boolean f9855j = true;

    /* renamed from: r, reason: collision with root package name */
    public boolean f9863r = false;

    /* compiled from: FragmentTransaction.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f9865a;

        /* renamed from: b, reason: collision with root package name */
        public Fragment f9866b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f9867c;

        /* renamed from: d, reason: collision with root package name */
        public int f9868d;

        /* renamed from: e, reason: collision with root package name */
        public int f9869e;

        /* renamed from: f, reason: collision with root package name */
        public int f9870f;

        /* renamed from: g, reason: collision with root package name */
        public int f9871g;

        /* renamed from: h, reason: collision with root package name */
        public Lifecycle.State f9872h;

        /* renamed from: i, reason: collision with root package name */
        public Lifecycle.State f9873i;

        public a() {
        }

        public a(int i10, Fragment fragment) {
            this.f9865a = i10;
            this.f9866b = fragment;
            this.f9867c = false;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f9872h = state;
            this.f9873i = state;
        }

        public a(int i10, Fragment fragment, boolean z10) {
            this.f9865a = i10;
            this.f9866b = fragment;
            this.f9867c = z10;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f9872h = state;
            this.f9873i = state;
        }

        public a(int i10, Fragment fragment, Lifecycle.State state) {
            this.f9865a = i10;
            this.f9866b = fragment;
            this.f9867c = false;
            this.f9872h = fragment.mMaxState;
            this.f9873i = state;
        }
    }

    public B(k kVar, ClassLoader classLoader) {
        this.f9846a = kVar;
        this.f9847b = classLoader;
    }

    public B b(int i10, Fragment fragment) {
        o(i10, fragment, null, 1);
        return this;
    }

    public B c(int i10, Fragment fragment, String str) {
        o(i10, fragment, str, 1);
        return this;
    }

    public B d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public B e(Fragment fragment, String str) {
        o(0, fragment, str, 1);
        return this;
    }

    public void f(a aVar) {
        this.f9848c.add(aVar);
        aVar.f9868d = this.f9849d;
        aVar.f9869e = this.f9850e;
        aVar.f9870f = this.f9851f;
        aVar.f9871g = this.f9852g;
    }

    public B g(String str) {
        if (this.f9855j) {
            this.f9854i = true;
            this.f9856k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public B h(Fragment fragment) {
        f(new a(7, fragment));
        return this;
    }

    public abstract int i();

    public abstract int j();

    public abstract void k();

    public abstract void l();

    public B m(Fragment fragment) {
        f(new a(6, fragment));
        return this;
    }

    public B n() {
        if (!this.f9854i) {
            this.f9855j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public void o(int i10, Fragment fragment, String str, int i11) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            FragmentStrictMode.f(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str3 = fragment.mTag;
                if (str3 != null && !str.equals(str3)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
                }
                fragment.mTag = str;
            }
            if (i10 != 0) {
                if (i10 != -1) {
                    int i12 = fragment.mFragmentId;
                    if (i12 != 0 && i12 != i10) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i10);
                    }
                    fragment.mFragmentId = i10;
                    fragment.mContainerId = i10;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                }
            }
            f(new a(i11, fragment));
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    public B p(Fragment fragment) {
        f(new a(4, fragment));
        return this;
    }

    public abstract boolean q();

    public B r(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public B s(int i10, Fragment fragment) {
        return t(i10, fragment, null);
    }

    public B t(int i10, Fragment fragment, String str) {
        if (i10 != 0) {
            o(i10, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public B u(int i10, int i11) {
        return v(i10, i11, 0, 0);
    }

    public B v(int i10, int i11, int i12, int i13) {
        this.f9849d = i10;
        this.f9850e = i11;
        this.f9851f = i12;
        this.f9852g = i13;
        return this;
    }

    public B w(Fragment fragment, Lifecycle.State state) {
        f(new a(10, fragment, state));
        return this;
    }

    public B x(boolean z10) {
        this.f9863r = z10;
        return this;
    }

    public B y(Fragment fragment) {
        f(new a(5, fragment));
        return this;
    }
}
