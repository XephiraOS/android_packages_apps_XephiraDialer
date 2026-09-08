package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: CompositeOnPageChangeCallback.java */
/* loaded from: classes.dex */
public final class b extends ViewPager2.i {

    /* renamed from: a, reason: collision with root package name */
    public final List<ViewPager2.i> f11862a;

    public b(int i10) {
        this.f11862a = new ArrayList(i10);
    }

    public void addOnPageChangeCallback(ViewPager2.i iVar) {
        this.f11862a.add(iVar);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrollStateChanged(int i10) {
        try {
            Iterator<ViewPager2.i> it = this.f11862a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrollStateChanged(i10);
            }
        } catch (ConcurrentModificationException e10) {
            throwCallbackListModifiedWhileInUse(e10);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrolled(int i10, float f10, int i11) {
        try {
            Iterator<ViewPager2.i> it = this.f11862a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrolled(i10, f10, i11);
            }
        } catch (ConcurrentModificationException e10) {
            throwCallbackListModifiedWhileInUse(e10);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageSelected(int i10) {
        try {
            Iterator<ViewPager2.i> it = this.f11862a.iterator();
            while (it.hasNext()) {
                it.next().onPageSelected(i10);
            }
        } catch (ConcurrentModificationException e10) {
            throwCallbackListModifiedWhileInUse(e10);
        }
    }

    public final void throwCallbackListModifiedWhileInUse(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
