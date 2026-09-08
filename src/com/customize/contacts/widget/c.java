package com.customize.contacts.widget;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;

/* compiled from: ContactFragmentPagerAdapter.java */
/* loaded from: classes3.dex */
public abstract class c extends w {

    /* renamed from: f, reason: collision with root package name */
    public Fragment f22568f;

    public c(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment c() {
        return this.f22568f;
    }

    public void d(Object obj) {
        this.f22568f = (Fragment) obj;
    }

    @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
    public void finishUpdate(ViewGroup viewGroup) {
        super.finishUpdate(viewGroup);
    }

    @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        return super.instantiateItem(viewGroup, i10);
    }

    @Override // androidx.fragment.app.w, androidx.viewpager.widget.a
    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        super.setPrimaryItem(viewGroup, i10, obj);
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f22568f;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.f22568f.setUserVisibleHint(false);
            }
            fragment.setMenuVisibility(true);
            fragment.setUserVisibleHint(true);
            this.f22568f = fragment;
        }
    }
}
