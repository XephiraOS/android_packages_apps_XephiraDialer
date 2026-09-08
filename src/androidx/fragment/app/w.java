package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;

/* compiled from: FragmentPagerAdapter.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class w extends androidx.viewpager.widget.a {

    /* renamed from: a, reason: collision with root package name */
    public final FragmentManager f10205a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10206b;

    /* renamed from: c, reason: collision with root package name */
    public B f10207c;

    /* renamed from: d, reason: collision with root package name */
    public Fragment f10208d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10209e;

    @Deprecated
    public w(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public static String b(int i10, long j10) {
        return "android:switcher:" + i10 + ":" + j10;
    }

    public long a(int i10) {
        return i10;
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f10207c == null) {
            this.f10207c = this.f10205a.p();
        }
        this.f10207c.m(fragment);
        if (fragment.equals(this.f10208d)) {
            this.f10208d = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void finishUpdate(ViewGroup viewGroup) {
        B b10 = this.f10207c;
        if (b10 != null) {
            if (!this.f10209e) {
                try {
                    this.f10209e = true;
                    b10.l();
                } finally {
                    this.f10209e = false;
                }
            }
            this.f10207c = null;
        }
    }

    public abstract Fragment getItem(int i10);

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        if (this.f10207c == null) {
            this.f10207c = this.f10205a.p();
        }
        long a10 = a(i10);
        Fragment m02 = this.f10205a.m0(b(viewGroup.getId(), a10));
        if (m02 != null) {
            this.f10207c.h(m02);
        } else {
            m02 = getItem(i10);
            this.f10207c.c(viewGroup.getId(), m02, b(viewGroup.getId(), a10));
        }
        if (m02 != this.f10208d) {
            m02.setMenuVisibility(false);
            if (this.f10206b == 1) {
                this.f10207c.w(m02, Lifecycle.State.STARTED);
            } else {
                m02.setUserVisibleHint(false);
            }
        }
        return m02;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        if (((Fragment) obj).getView() == view) {
            return true;
        }
        return false;
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.a
    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f10208d;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f10206b == 1) {
                    if (this.f10207c == null) {
                        this.f10207c = this.f10205a.p();
                    }
                    this.f10207c.w(this.f10208d, Lifecycle.State.STARTED);
                } else {
                    this.f10208d.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f10206b == 1) {
                if (this.f10207c == null) {
                    this.f10207c = this.f10205a.p();
                }
                this.f10207c.w(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f10208d = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public w(FragmentManager fragmentManager, int i10) {
        this.f10207c = null;
        this.f10208d = null;
        this.f10205a = fragmentManager;
        this.f10206b = i10;
    }

    @Override // androidx.viewpager.widget.a
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }
}
