package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.strictmode.FragmentStrictMode;

/* compiled from: FragmentLayoutInflaterFactory.java */
/* loaded from: classes.dex */
public class n implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    public final FragmentManager f10178a;

    public n(FragmentManager fragmentManager) {
        this.f10178a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        y y10;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f10178a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.c.f3158a);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R.c.f3159b);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.c.f3160c, -1);
        String string = obtainStyledAttributes.getString(R.c.f3161d);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !k.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment l02 = resourceId != -1 ? this.f10178a.l0(resourceId) : null;
        if (l02 == null && string != null) {
            l02 = this.f10178a.m0(string);
        }
        if (l02 == null && id != -1) {
            l02 = this.f10178a.l0(id);
        }
        if (l02 == null) {
            l02 = this.f10178a.x0().a(context.getClassLoader(), attributeValue);
            l02.mFromLayout = true;
            l02.mFragmentId = resourceId != 0 ? resourceId : id;
            l02.mContainerId = id;
            l02.mTag = string;
            l02.mInLayout = true;
            FragmentManager fragmentManager = this.f10178a;
            l02.mFragmentManager = fragmentManager;
            l02.mHost = fragmentManager.z0();
            l02.onInflate(this.f10178a.z0().f(), attributeSet, l02.mSavedFragmentState);
            y10 = this.f10178a.j(l02);
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Fragment " + l02 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else if (!l02.mInLayout) {
            l02.mInLayout = true;
            FragmentManager fragmentManager2 = this.f10178a;
            l02.mFragmentManager = fragmentManager2;
            l02.mHost = fragmentManager2.z0();
            l02.onInflate(this.f10178a.z0().f(), attributeSet, l02.mSavedFragmentState);
            y10 = this.f10178a.y(l02);
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + l02 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        FragmentStrictMode.g(l02, viewGroup);
        l02.mContainer = viewGroup;
        y10.m();
        y10.j();
        View view2 = l02.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (l02.mView.getTag() == null) {
            l02.mView.setTag(string);
        }
        l02.mView.addOnAttachStateChangeListener(new a(y10));
        return l02.mView;
    }

    /* compiled from: FragmentLayoutInflaterFactory.java */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f10179a;

        public a(y yVar) {
            this.f10179a = yVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment k10 = this.f10179a.k();
            this.f10179a.m();
            SpecialEffectsController.n((ViewGroup) k10.mView.getParent(), n.this.f10178a).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
