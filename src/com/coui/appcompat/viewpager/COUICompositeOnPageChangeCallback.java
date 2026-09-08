package com.coui.appcompat.viewpager;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class COUICompositeOnPageChangeCallback extends ViewPager2.i {
    private final List<ViewPager2.i> mCallbacks;

    public COUICompositeOnPageChangeCallback(int i10) {
        this.mCallbacks = new ArrayList(i10);
    }

    private void throwCallbackListModifiedWhileInUse(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    public void addOnPageChangeCallback(ViewPager2.i iVar) {
        this.mCallbacks.add(iVar);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void onPageScrollStateChanged(int i10) {
        try {
            Iterator<ViewPager2.i> it = this.mCallbacks.iterator();
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
            Iterator<ViewPager2.i> it = this.mCallbacks.iterator();
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
            Iterator<ViewPager2.i> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onPageSelected(i10);
            }
        } catch (ConcurrentModificationException e10) {
            throwCallbackListModifiedWhileInUse(e10);
        }
    }

    public void removeOnPageChangeCallback(ViewPager2.i iVar) {
        this.mCallbacks.remove(iVar);
    }
}
