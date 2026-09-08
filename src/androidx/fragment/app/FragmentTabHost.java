package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f10061a;

    /* renamed from: b, reason: collision with root package name */
    public Context f10062b;

    /* renamed from: c, reason: collision with root package name */
    public FragmentManager f10063c;

    /* renamed from: d, reason: collision with root package name */
    public int f10064d;

    /* renamed from: e, reason: collision with root package name */
    public TabHost.OnTabChangeListener f10065e;

    /* renamed from: f, reason: collision with root package name */
    public a f10066f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10067g;

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f10068a;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f10068a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f10068a);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f10068a = parcel.readString();
        }
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f10069a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<?> f10070b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f10071c;

        /* renamed from: d, reason: collision with root package name */
        public Fragment f10072d;
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10061a = new ArrayList<>();
        c(context, attributeSet);
    }

    public final B a(String str, B b10) {
        Fragment fragment;
        a b11 = b(str);
        if (this.f10066f != b11) {
            if (b10 == null) {
                b10 = this.f10063c.p();
            }
            a aVar = this.f10066f;
            if (aVar != null && (fragment = aVar.f10072d) != null) {
                b10.m(fragment);
            }
            if (b11 != null) {
                Fragment fragment2 = b11.f10072d;
                if (fragment2 == null) {
                    Fragment a10 = this.f10063c.x0().a(this.f10062b.getClassLoader(), b11.f10070b.getName());
                    b11.f10072d = a10;
                    a10.setArguments(b11.f10071c);
                    b10.c(this.f10064d, b11.f10072d, b11.f10069a);
                } else {
                    b10.h(fragment2);
                }
            }
            this.f10066f = b11;
        }
        return b10;
    }

    public final a b(String str) {
        int size = this.f10061a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = this.f10061a.get(i10);
            if (aVar.f10069a.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f10064d = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f10061a.size();
        B b10 = null;
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = this.f10061a.get(i10);
            Fragment m02 = this.f10063c.m0(aVar.f10069a);
            aVar.f10072d = m02;
            if (m02 != null && !m02.isDetached()) {
                if (aVar.f10069a.equals(currentTabTag)) {
                    this.f10066f = aVar;
                } else {
                    if (b10 == null) {
                        b10 = this.f10063c.p();
                    }
                    b10.m(aVar.f10072d);
                }
            }
        }
        this.f10067g = true;
        B a10 = a(currentTabTag, b10);
        if (a10 != null) {
            a10.i();
            this.f10063c.i0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f10067g = false;
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f10068a);
    }

    @Override // android.view.View
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10068a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        B a10;
        if (this.f10067g && (a10 = a(str, null)) != null) {
            a10.i();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f10065e;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f10065e = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
