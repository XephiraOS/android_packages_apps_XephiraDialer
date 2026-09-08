package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import java.util.Map;

/* loaded from: classes.dex */
public class RtlViewPager extends ViewPager {

    /* renamed from: a, reason: collision with root package name */
    public final Map<ViewPager.i, c> f16108a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16109b;

    /* loaded from: classes.dex */
    public static class a extends DataSetObserver {

        /* renamed from: a, reason: collision with root package name */
        public final d f16113a;

        @Override // android.database.DataSetObserver
        public void onChanged() {
            d dVar = this.f16113a;
            if (dVar != null) {
                dVar.d();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            onChanged();
        }

        public a(d dVar) {
            this.f16113a = dVar;
        }
    }

    /* loaded from: classes.dex */
    public class b extends d {

        /* renamed from: c, reason: collision with root package name */
        public int f16114c;

        @Override // com.android.contacts.framework.baseui.widget.RtlViewPager.d, androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
            super.destroyItem(viewGroup, f(i10), obj);
        }

        public final int f(int i10) {
            return (getCount() - i10) - 1;
        }

        @Override // com.android.contacts.framework.baseui.widget.RtlViewPager.d, androidx.viewpager.widget.a
        public int getItemPosition(Object obj) {
            int itemPosition = super.getItemPosition(obj);
            if (itemPosition >= 0) {
                return f(itemPosition);
            }
            return itemPosition;
        }

        @Override // com.android.contacts.framework.baseui.widget.RtlViewPager.d, androidx.viewpager.widget.a
        public CharSequence getPageTitle(int i10) {
            return super.getPageTitle(f(i10));
        }

        @Override // com.android.contacts.framework.baseui.widget.RtlViewPager.d, androidx.viewpager.widget.a
        public float getPageWidth(int i10) {
            return super.getPageWidth(f(i10));
        }

        @Override // com.android.contacts.framework.baseui.widget.RtlViewPager.d, androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup viewGroup, int i10) {
            return super.instantiateItem(viewGroup, f(i10));
        }

        @Override // com.android.contacts.framework.baseui.widget.RtlViewPager.d, androidx.viewpager.widget.a
        public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
            super.setPrimaryItem(viewGroup, (this.f16114c - i10) - 1, obj);
        }

        public b(androidx.viewpager.widget.a aVar) {
            super(aVar);
            this.f16114c = aVar.getCount();
        }
    }

    /* loaded from: classes.dex */
    public class c implements ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        public final ViewPager.i f16116a;

        /* renamed from: b, reason: collision with root package name */
        public int f16117b;

        public final int a(int i10) {
            if (RtlViewPager.this.getAdapter() != null) {
                return (r0.getCount() - i10) - 1;
            }
            return i10;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrollStateChanged(int i10) {
            if (!RtlViewPager.this.f16109b) {
                this.f16116a.onPageScrollStateChanged(i10);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrolled(int i10, float f10, int i11) {
            if (!RtlViewPager.this.f16109b) {
                if (f10 == 0.0f && i11 == 0) {
                    this.f16117b = a(i10);
                } else {
                    this.f16117b = a(i10 + 1);
                }
                ViewPager.i iVar = this.f16116a;
                int i12 = this.f16117b;
                if (f10 > 0.0f) {
                    f10 = 1.0f - f10;
                }
                iVar.onPageScrolled(i12, f10, i11);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageSelected(int i10) {
            if (!RtlViewPager.this.f16109b) {
                this.f16116a.onPageSelected(a(i10));
            }
        }

        public c(ViewPager.i iVar) {
            this.f16117b = -1;
            this.f16116a = iVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends androidx.viewpager.widget.a {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.viewpager.widget.a f16119a;

        /* renamed from: b, reason: collision with root package name */
        public DataSetObserver f16120b;

        public androidx.viewpager.widget.a b() {
            return this.f16119a;
        }

        public void c() {
            if (this.f16119a != null && this.f16120b == null) {
                a aVar = new a(this);
                this.f16120b = aVar;
                this.f16119a.registerDataSetObserver(aVar);
            }
        }

        public final void d() {
            super.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
            this.f16119a.destroyItem(viewGroup, i10, obj);
        }

        public void e() {
            DataSetObserver dataSetObserver;
            androidx.viewpager.widget.a aVar = this.f16119a;
            if (aVar != null && (dataSetObserver = this.f16120b) != null) {
                aVar.unregisterDataSetObserver(dataSetObserver);
                this.f16120b = null;
            }
        }

        @Override // androidx.viewpager.widget.a
        public void finishUpdate(ViewGroup viewGroup) {
            this.f16119a.finishUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return this.f16119a.getCount();
        }

        @Override // androidx.viewpager.widget.a
        public int getItemPosition(Object obj) {
            return this.f16119a.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence getPageTitle(int i10) {
            return this.f16119a.getPageTitle(i10);
        }

        @Override // androidx.viewpager.widget.a
        public float getPageWidth(int i10) {
            return this.f16119a.getPageWidth(i10);
        }

        @Override // androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup viewGroup, int i10) {
            return this.f16119a.instantiateItem(viewGroup, i10);
        }

        @Override // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object obj) {
            return this.f16119a.isViewFromObject(view, obj);
        }

        @Override // androidx.viewpager.widget.a
        public void notifyDataSetChanged() {
            this.f16119a.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.a
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f16119a.registerDataSetObserver(dataSetObserver);
        }

        @Override // androidx.viewpager.widget.a
        public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
            this.f16119a.restoreState(parcelable, classLoader);
        }

        @Override // androidx.viewpager.widget.a
        public Parcelable saveState() {
            return this.f16119a.saveState();
        }

        @Override // androidx.viewpager.widget.a
        public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
            this.f16119a.setPrimaryItem(viewGroup, i10, obj);
        }

        @Override // androidx.viewpager.widget.a
        public void startUpdate(ViewGroup viewGroup) {
            this.f16119a.startUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.a
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f16119a.unregisterDataSetObserver(dataSetObserver);
        }

        public d(androidx.viewpager.widget.a aVar) {
            this.f16119a = aVar;
            a aVar2 = new a(this);
            this.f16120b = aVar2;
            aVar.registerDataSetObserver(aVar2);
        }
    }

    public RtlViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16108a = new ArrayMap(1);
    }

    private void setCurrentItemWithoutNotification(int i10) {
        this.f16109b = true;
        setCurrentItem(i10, true);
        this.f16109b = false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void addOnPageChangeListener(ViewPager.i iVar) {
        if (com.android.contacts.framework.api.appstore.application.a.b()) {
            c cVar = new c(iVar);
            this.f16108a.put(iVar, cVar);
            iVar = cVar;
        }
        super.addOnPageChangeListener(iVar);
    }

    public int b(int i10) {
        if (i10 >= 0 && com.android.contacts.framework.api.appstore.application.a.b()) {
            if (getAdapter() == null) {
                return 0;
            }
            return (getAdapter().getCount() - i10) - 1;
        }
        return i10;
    }

    public final void c() {
        androidx.viewpager.widget.a adapter = super.getAdapter();
        if (adapter instanceof b) {
            ((b) adapter).c();
        }
    }

    public final void d() {
        androidx.viewpager.widget.a adapter = super.getAdapter();
        if (adapter instanceof b) {
            ((b) adapter).e();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void fakeDragBy(float f10) {
        if (!com.android.contacts.framework.api.appstore.application.a.b()) {
            f10 = -f10;
        }
        super.fakeDragBy(f10);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public androidx.viewpager.widget.a getAdapter() {
        androidx.viewpager.widget.a adapter = super.getAdapter();
        if (adapter instanceof b) {
            return ((b) adapter).b();
        }
        return adapter;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        return b(super.getCurrentItem());
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        d();
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f16110a);
        if (savedState.f16112c != com.android.contacts.framework.api.appstore.application.a.b()) {
            setCurrentItem(savedState.f16111b, false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentItem(), com.android.contacts.framework.api.appstore.application.a.b());
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void removeOnPageChangeListener(ViewPager.i iVar) {
        if (com.android.contacts.framework.api.appstore.application.a.b()) {
            iVar = this.f16108a.remove(iVar);
        }
        super.removeOnPageChangeListener(iVar);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(androidx.viewpager.widget.a aVar) {
        boolean z10;
        if (aVar != null && com.android.contacts.framework.api.appstore.application.a.b()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            d();
            aVar = new b(aVar);
        }
        super.setAdapter(aVar);
        if (z10) {
            setCurrentItemWithoutNotification(0);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i10, boolean z10) {
        super.setCurrentItem(b(i10), z10);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i10) {
        super.setCurrentItem(b(i10));
    }

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.ClassLoaderCreator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public Parcelable f16110a;

        /* renamed from: b, reason: collision with root package name */
        public int f16111b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f16112c;

        /* loaded from: classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable, int i10, boolean z10) {
            this.f16110a = parcelable;
            this.f16111b = i10;
            this.f16112c = z10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f16110a, i10);
            parcel.writeInt(this.f16111b);
            parcel.writeByte(this.f16112c ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f16110a = parcel.readParcelable(classLoader == null ? getClass().getClassLoader() : classLoader);
            this.f16111b = parcel.readInt();
            this.f16112c = parcel.readByte() != 0;
        }
    }
}
