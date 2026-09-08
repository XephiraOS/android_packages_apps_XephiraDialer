package com.oplus.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.oplus.blacklistapp.BlackListAppUtil;
import java.util.Map;

/* loaded from: classes4.dex */
public class RtlViewPager extends ViewPager {

    /* renamed from: a, reason: collision with root package name */
    public final Map<ViewPager.i, c> f29287a;

    /* renamed from: b, reason: collision with root package name */
    public DataSetObserver f29288b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f29289c;

    /* loaded from: classes4.dex */
    public static class a extends DataSetObserver {

        /* renamed from: a, reason: collision with root package name */
        public final b f29290a;

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            this.f29290a.c();
        }

        public a(b bVar) {
            this.f29290a = bVar;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {

        /* renamed from: b, reason: collision with root package name */
        public int f29291b;

        public b(androidx.viewpager.widget.a aVar) {
            super(aVar);
            this.f29291b = aVar.getCount();
        }

        private int d(int i10) {
            return (getCount() - i10) - 1;
        }

        public final void c() {
            int count = getCount();
            int i10 = this.f29291b;
            if (count != i10) {
                RtlViewPager.this.setCurrentItemWithoutNotification(Math.max(0, i10 - 1));
                this.f29291b = count;
            }
        }

        @Override // com.oplus.widget.RtlViewPager.d, androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
            super.destroyItem(viewGroup, d(i10), obj);
        }

        @Override // com.oplus.widget.RtlViewPager.d, androidx.viewpager.widget.a
        public int getItemPosition(Object obj) {
            int itemPosition = super.getItemPosition(obj);
            if (itemPosition >= 0) {
                return d(itemPosition);
            }
            return itemPosition;
        }

        @Override // com.oplus.widget.RtlViewPager.d, androidx.viewpager.widget.a
        public CharSequence getPageTitle(int i10) {
            return super.getPageTitle(d(i10));
        }

        @Override // com.oplus.widget.RtlViewPager.d, androidx.viewpager.widget.a
        public float getPageWidth(int i10) {
            return super.getPageWidth(d(i10));
        }

        @Override // com.oplus.widget.RtlViewPager.d, androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup viewGroup, int i10) {
            return super.instantiateItem(viewGroup, d(i10));
        }

        @Override // com.oplus.widget.RtlViewPager.d, androidx.viewpager.widget.a
        public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
            super.setPrimaryItem(viewGroup, (this.f29291b - i10) - 1, obj);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        public final ViewPager.i f29293a;

        /* renamed from: b, reason: collision with root package name */
        public int f29294b;

        private int a(int i10) {
            if (RtlViewPager.this.getAdapter() != null) {
                return (r0.getCount() - i10) - 1;
            }
            return i10;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrollStateChanged(int i10) {
            if (!RtlViewPager.this.f29289c) {
                this.f29293a.onPageScrollStateChanged(i10);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrolled(int i10, float f10, int i11) {
            if (!RtlViewPager.this.f29289c) {
                if (f10 == 0.0f && i11 == 0) {
                    this.f29294b = a(i10);
                } else {
                    this.f29294b = a(i10 + 1);
                }
                ViewPager.i iVar = this.f29293a;
                int i12 = this.f29294b;
                if (f10 > 0.0f) {
                    f10 = 1.0f - f10;
                }
                iVar.onPageScrolled(i12, f10, i11);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageSelected(int i10) {
            if (!RtlViewPager.this.f29289c) {
                this.f29293a.onPageSelected(a(i10));
            }
        }

        public c(ViewPager.i iVar) {
            this.f29294b = -1;
            this.f29293a = iVar;
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends androidx.viewpager.widget.a {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.viewpager.widget.a f29296a;

        public d(androidx.viewpager.widget.a aVar) {
            this.f29296a = aVar;
        }

        public androidx.viewpager.widget.a a() {
            return this.f29296a;
        }

        @Override // androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
            this.f29296a.destroyItem(viewGroup, i10, obj);
        }

        @Override // androidx.viewpager.widget.a
        public void finishUpdate(ViewGroup viewGroup) {
            this.f29296a.finishUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return this.f29296a.getCount();
        }

        @Override // androidx.viewpager.widget.a
        public int getItemPosition(Object obj) {
            return this.f29296a.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence getPageTitle(int i10) {
            return this.f29296a.getPageTitle(i10);
        }

        @Override // androidx.viewpager.widget.a
        public float getPageWidth(int i10) {
            return this.f29296a.getPageWidth(i10);
        }

        @Override // androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup viewGroup, int i10) {
            return this.f29296a.instantiateItem(viewGroup, i10);
        }

        @Override // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object obj) {
            return this.f29296a.isViewFromObject(view, obj);
        }

        @Override // androidx.viewpager.widget.a
        public void notifyDataSetChanged() {
            this.f29296a.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.a
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f29296a.registerDataSetObserver(dataSetObserver);
        }

        @Override // androidx.viewpager.widget.a
        public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
            this.f29296a.restoreState(parcelable, classLoader);
        }

        @Override // androidx.viewpager.widget.a
        public Parcelable saveState() {
            return this.f29296a.saveState();
        }

        @Override // androidx.viewpager.widget.a
        public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
            this.f29296a.setPrimaryItem(viewGroup, i10, obj);
        }

        @Override // androidx.viewpager.widget.a
        public void startUpdate(ViewGroup viewGroup) {
            this.f29296a.startUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.a
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f29296a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public RtlViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29287a = new ArrayMap(1);
    }

    private int c(int i10) {
        if (i10 >= 0 && BlackListAppUtil.f26245b) {
            if (getAdapter() == null) {
                return 0;
            }
            return (getAdapter().getCount() - i10) - 1;
        }
        return i10;
    }

    private void e() {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a adapter = super.getAdapter();
        if ((adapter instanceof b) && (dataSetObserver = this.f29288b) != null) {
            adapter.unregisterDataSetObserver(dataSetObserver);
            this.f29288b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItemWithoutNotification(int i10) {
        this.f29289c = true;
        setCurrentItem(i10, false);
        this.f29289c = false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void addOnPageChangeListener(ViewPager.i iVar) {
        if (BlackListAppUtil.f26245b) {
            c cVar = new c(iVar);
            this.f29287a.put(iVar, cVar);
            iVar = cVar;
        }
        super.addOnPageChangeListener(iVar);
    }

    public final void d(androidx.viewpager.widget.a aVar) {
        if ((aVar instanceof b) && this.f29288b == null) {
            b bVar = (b) aVar;
            a aVar2 = new a(bVar);
            this.f29288b = aVar2;
            aVar.registerDataSetObserver(aVar2);
            bVar.c();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void fakeDragBy(float f10) {
        if (!BlackListAppUtil.f26245b) {
            f10 = -f10;
        }
        super.fakeDragBy(f10);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public androidx.viewpager.widget.a getAdapter() {
        androidx.viewpager.widget.a adapter = super.getAdapter();
        if (adapter instanceof b) {
            return ((b) adapter).a();
        }
        return adapter;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        return c(super.getCurrentItem());
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d(super.getAdapter());
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        e();
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void removeOnPageChangeListener(ViewPager.i iVar) {
        if (BlackListAppUtil.f26245b) {
            iVar = this.f29287a.remove(iVar);
        }
        super.removeOnPageChangeListener(iVar);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(androidx.viewpager.widget.a aVar) {
        boolean z10;
        e();
        if (aVar != null && BlackListAppUtil.f26245b) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            b bVar = new b(aVar);
            d(bVar);
            aVar = bVar;
        }
        super.setAdapter(aVar);
        if (z10) {
            setCurrentItemWithoutNotification(0);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i10, boolean z10) {
        super.setCurrentItem(c(i10), z10);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i10) {
        super.setCurrentItem(c(i10));
    }
}
