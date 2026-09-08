package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.K;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.N;

/* compiled from: FragmentStateManager.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public final o f10210a;

    /* renamed from: b, reason: collision with root package name */
    public final A f10211b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f10212c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10213d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f10214e = -1;

    /* compiled from: FragmentStateManager.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10217a;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            f10217a = iArr;
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10217a[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10217a[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10217a[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public y(o oVar, A a10, Fragment fragment) {
        this.f10210a = oVar;
        this.f10211b = a10;
        this.f10212c = fragment;
    }

    public void a() {
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f10212c);
        }
        Fragment fragment = this.f10212c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        o oVar = this.f10210a;
        Fragment fragment2 = this.f10212c;
        oVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    public void b() {
        int j10 = this.f10211b.j(this.f10212c);
        Fragment fragment = this.f10212c;
        fragment.mContainer.addView(fragment.mView, j10);
    }

    public void c() {
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f10212c);
        }
        Fragment fragment = this.f10212c;
        Fragment fragment2 = fragment.mTarget;
        y yVar = null;
        if (fragment2 != null) {
            y n10 = this.f10211b.n(fragment2.mWho);
            if (n10 != null) {
                Fragment fragment3 = this.f10212c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                yVar = n10;
            } else {
                throw new IllegalStateException("Fragment " + this.f10212c + " declared target fragment " + this.f10212c.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (yVar = this.f10211b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f10212c + " declared target fragment " + this.f10212c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (yVar != null) {
            yVar.m();
        }
        Fragment fragment4 = this.f10212c;
        fragment4.mHost = fragment4.mFragmentManager.z0();
        Fragment fragment5 = this.f10212c;
        fragment5.mParentFragment = fragment5.mFragmentManager.C0();
        this.f10210a.g(this.f10212c, false);
        this.f10212c.performAttach();
        this.f10210a.b(this.f10212c, false);
    }

    public int d() {
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact;
        Fragment fragment = this.f10212c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i10 = this.f10214e;
        int i11 = b.f10217a[fragment.mMaxState.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        i10 = Math.min(i10, -1);
                    } else {
                        i10 = Math.min(i10, 0);
                    }
                } else {
                    i10 = Math.min(i10, 1);
                }
            } else {
                i10 = Math.min(i10, 5);
            }
        }
        Fragment fragment2 = this.f10212c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                i10 = Math.max(this.f10214e, 2);
                View view = this.f10212c.mView;
                if (view != null && view.getParent() == null) {
                    i10 = Math.min(i10, 2);
                }
            } else {
                i10 = this.f10214e < 4 ? Math.min(i10, fragment2.mState) : Math.min(i10, 1);
            }
        }
        if (!this.f10212c.mAdded) {
            i10 = Math.min(i10, 1);
        }
        Fragment fragment3 = this.f10212c;
        ViewGroup viewGroup = fragment3.mContainer;
        if (viewGroup != null) {
            lifecycleImpact = SpecialEffectsController.n(viewGroup, fragment3.getParentFragmentManager()).l(this);
        } else {
            lifecycleImpact = null;
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i10 = Math.min(i10, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i10 = Math.max(i10, 3);
        } else {
            Fragment fragment4 = this.f10212c;
            if (fragment4.mRemoving) {
                if (fragment4.isInBackStack()) {
                    i10 = Math.min(i10, 1);
                } else {
                    i10 = Math.min(i10, -1);
                }
            }
        }
        Fragment fragment5 = this.f10212c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i10 = Math.min(i10, 4);
        }
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i10 + " for " + this.f10212c);
        }
        return i10;
    }

    public void e() {
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f10212c);
        }
        Fragment fragment = this.f10212c;
        if (!fragment.mIsCreated) {
            this.f10210a.h(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.f10212c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            o oVar = this.f10210a;
            Fragment fragment3 = this.f10212c;
            oVar.c(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.f10212c.mState = 1;
    }

    public void f() {
        String str;
        if (this.f10212c.mFromLayout) {
            return;
        }
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f10212c);
        }
        Fragment fragment = this.f10212c;
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        Fragment fragment2 = this.f10212c;
        ViewGroup viewGroup = fragment2.mContainer;
        if (viewGroup == null) {
            int i10 = fragment2.mContainerId;
            if (i10 != 0) {
                if (i10 != -1) {
                    viewGroup = (ViewGroup) fragment2.mFragmentManager.u0().c(this.f10212c.mContainerId);
                    if (viewGroup == null) {
                        Fragment fragment3 = this.f10212c;
                        if (!fragment3.mRestored) {
                            try {
                                str = fragment3.getResources().getResourceName(this.f10212c.mContainerId);
                            } catch (Resources.NotFoundException unused) {
                                str = "unknown";
                            }
                            throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f10212c.mContainerId) + " (" + str + ") for fragment " + this.f10212c);
                        }
                    } else if (!(viewGroup instanceof FragmentContainerView)) {
                        FragmentStrictMode.n(this.f10212c, viewGroup);
                    }
                } else {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f10212c + " for a container view with no id");
                }
            } else {
                viewGroup = null;
            }
        }
        Fragment fragment4 = this.f10212c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.f10212c.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f10212c;
            fragment5.mView.setTag(R.b.f3155a, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f10212c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (K.N(this.f10212c.mView)) {
                K.f0(this.f10212c.mView);
            } else {
                View view2 = this.f10212c.mView;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f10212c.performViewCreated();
            o oVar = this.f10210a;
            Fragment fragment7 = this.f10212c;
            oVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.f10212c.mView.getVisibility();
            this.f10212c.setPostOnViewCreatedAlpha(this.f10212c.mView.getAlpha());
            Fragment fragment8 = this.f10212c;
            if (fragment8.mContainer != null && visibility == 0) {
                View findFocus = fragment8.mView.findFocus();
                if (findFocus != null) {
                    this.f10212c.setFocusedView(findFocus);
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f10212c);
                    }
                }
                this.f10212c.mView.setAlpha(0.0f);
            }
        }
        this.f10212c.mState = 2;
    }

    public void g() {
        boolean z10;
        Fragment f10;
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f10212c);
        }
        Fragment fragment = this.f10212c;
        boolean z11 = true;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            Fragment fragment2 = this.f10212c;
            if (!fragment2.mBeingSaved) {
                this.f10211b.B(fragment2.mWho, null);
            }
        }
        if (!z10 && !this.f10211b.p().s(this.f10212c)) {
            String str = this.f10212c.mTargetWho;
            if (str != null && (f10 = this.f10211b.f(str)) != null && f10.mRetainInstance) {
                this.f10212c.mTarget = f10;
            }
            this.f10212c.mState = 0;
            return;
        }
        l<?> lVar = this.f10212c.mHost;
        if (lVar instanceof N) {
            z11 = this.f10211b.p().p();
        } else if (lVar.f() instanceof Activity) {
            z11 = true ^ ((Activity) lVar.f()).isChangingConfigurations();
        }
        if ((z10 && !this.f10212c.mBeingSaved) || z11) {
            this.f10211b.p().h(this.f10212c);
        }
        this.f10212c.performDestroy();
        this.f10210a.d(this.f10212c, false);
        for (y yVar : this.f10211b.k()) {
            if (yVar != null) {
                Fragment k10 = yVar.k();
                if (this.f10212c.mWho.equals(k10.mTargetWho)) {
                    k10.mTarget = this.f10212c;
                    k10.mTargetWho = null;
                }
            }
        }
        Fragment fragment3 = this.f10212c;
        String str2 = fragment3.mTargetWho;
        if (str2 != null) {
            fragment3.mTarget = this.f10211b.f(str2);
        }
        this.f10211b.s(this);
    }

    public void h() {
        View view;
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f10212c);
        }
        Fragment fragment = this.f10212c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f10212c.performDestroyView();
        this.f10210a.n(this.f10212c, false);
        Fragment fragment2 = this.f10212c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.o(null);
        this.f10212c.mInLayout = false;
    }

    public void i() {
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f10212c);
        }
        this.f10212c.performDetach();
        this.f10210a.e(this.f10212c, false);
        Fragment fragment = this.f10212c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if ((fragment.mRemoving && !fragment.isInBackStack()) || this.f10211b.p().s(this.f10212c)) {
            if (FragmentManager.M0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f10212c);
            }
            this.f10212c.initState();
        }
    }

    public void j() {
        Fragment fragment = this.f10212c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.M0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f10212c);
            }
            Fragment fragment2 = this.f10212c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f10212c.mSavedFragmentState);
            View view = this.f10212c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f10212c;
                fragment3.mView.setTag(R.b.f3155a, fragment3);
                Fragment fragment4 = this.f10212c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f10212c.performViewCreated();
                o oVar = this.f10210a;
                Fragment fragment5 = this.f10212c;
                oVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f10212c.mState = 2;
            }
        }
    }

    public Fragment k() {
        return this.f10212c;
    }

    public final boolean l(View view) {
        if (view == this.f10212c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f10212c.mView) {
                return true;
            }
        }
        return false;
    }

    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f10213d) {
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f10213d = true;
            boolean z10 = false;
            while (true) {
                int d10 = d();
                Fragment fragment = this.f10212c;
                int i10 = fragment.mState;
                if (d10 != i10) {
                    if (d10 > i10) {
                        switch (i10 + 1) {
                            case 0:
                                c();
                                break;
                            case 1:
                                e();
                                break;
                            case 2:
                                j();
                                f();
                                break;
                            case 3:
                                a();
                                break;
                            case 4:
                                if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                    SpecialEffectsController.n(viewGroup3, fragment.getParentFragmentManager()).b(SpecialEffectsController.Operation.State.b(this.f10212c.mView.getVisibility()), this);
                                }
                                this.f10212c.mState = 4;
                                break;
                            case 5:
                                v();
                                break;
                            case 6:
                                fragment.mState = 6;
                                break;
                            case 7:
                                p();
                                break;
                        }
                    } else {
                        switch (i10 - 1) {
                            case -1:
                                i();
                                break;
                            case 0:
                                if (fragment.mBeingSaved && this.f10211b.q(fragment.mWho) == null) {
                                    s();
                                }
                                g();
                                break;
                            case 1:
                                h();
                                this.f10212c.mState = 1;
                                break;
                            case 2:
                                fragment.mInLayout = false;
                                fragment.mState = 2;
                                break;
                            case 3:
                                if (FragmentManager.M0(3)) {
                                    Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f10212c);
                                }
                                Fragment fragment2 = this.f10212c;
                                if (fragment2.mBeingSaved) {
                                    s();
                                } else if (fragment2.mView != null && fragment2.mSavedViewState == null) {
                                    t();
                                }
                                Fragment fragment3 = this.f10212c;
                                if (fragment3.mView != null && (viewGroup2 = fragment3.mContainer) != null) {
                                    SpecialEffectsController.n(viewGroup2, fragment3.getParentFragmentManager()).d(this);
                                }
                                this.f10212c.mState = 3;
                                break;
                            case 4:
                                w();
                                break;
                            case 5:
                                fragment.mState = 5;
                                break;
                            case 6:
                                n();
                                break;
                        }
                    }
                    z10 = true;
                } else {
                    if (!z10 && i10 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !this.f10212c.mBeingSaved) {
                        if (FragmentManager.M0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f10212c);
                        }
                        this.f10211b.p().h(this.f10212c);
                        this.f10211b.s(this);
                        if (FragmentManager.M0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f10212c);
                        }
                        this.f10212c.initState();
                    }
                    Fragment fragment4 = this.f10212c;
                    if (fragment4.mHiddenChanged) {
                        if (fragment4.mView != null && (viewGroup = fragment4.mContainer) != null) {
                            SpecialEffectsController n10 = SpecialEffectsController.n(viewGroup, fragment4.getParentFragmentManager());
                            if (this.f10212c.mHidden) {
                                n10.c(this);
                            } else {
                                n10.e(this);
                            }
                        }
                        Fragment fragment5 = this.f10212c;
                        FragmentManager fragmentManager = fragment5.mFragmentManager;
                        if (fragmentManager != null) {
                            fragmentManager.K0(fragment5);
                        }
                        Fragment fragment6 = this.f10212c;
                        fragment6.mHiddenChanged = false;
                        fragment6.onHiddenChanged(fragment6.mHidden);
                        this.f10212c.mChildFragmentManager.L();
                    }
                    this.f10213d = false;
                    return;
                }
            }
        } catch (Throwable th) {
            this.f10213d = false;
            throw th;
        }
    }

    public void n() {
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f10212c);
        }
        this.f10212c.performPause();
        this.f10210a.f(this.f10212c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f10212c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f10212c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        Fragment fragment2 = this.f10212c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
        Fragment fragment3 = this.f10212c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
        Fragment fragment4 = this.f10212c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Fragment fragment5 = this.f10212c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.f10212c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        Fragment fragment6 = this.f10212c;
        if (!fragment6.mUserVisibleHint) {
            fragment6.mDeferStart = true;
        }
    }

    public void p() {
        String str;
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f10212c);
        }
        View focusedView = this.f10212c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.M0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                if (requestFocus) {
                    str = "succeeded";
                } else {
                    str = "failed";
                }
                sb.append(str);
                sb.append(" on Fragment ");
                sb.append(this.f10212c);
                sb.append(" resulting in focused view ");
                sb.append(this.f10212c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f10212c.setFocusedView(null);
        this.f10212c.performResume();
        this.f10210a.i(this.f10212c, false);
        Fragment fragment = this.f10212c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final Bundle q() {
        Bundle bundle = new Bundle();
        this.f10212c.performSaveInstanceState(bundle);
        this.f10210a.j(this.f10212c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f10212c.mView != null) {
            t();
        }
        if (this.f10212c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f10212c.mSavedViewState);
        }
        if (this.f10212c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f10212c.mSavedViewRegistryState);
        }
        if (!this.f10212c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f10212c.mUserVisibleHint);
        }
        return bundle;
    }

    public Fragment.SavedState r() {
        Bundle q10;
        if (this.f10212c.mState <= -1 || (q10 = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(q10);
    }

    public void s() {
        FragmentState fragmentState = new FragmentState(this.f10212c);
        Fragment fragment = this.f10212c;
        if (fragment.mState > -1 && fragmentState.f10060m == null) {
            Bundle q10 = q();
            fragmentState.f10060m = q10;
            if (this.f10212c.mTargetWho != null) {
                if (q10 == null) {
                    fragmentState.f10060m = new Bundle();
                }
                fragmentState.f10060m.putString("android:target_state", this.f10212c.mTargetWho);
                int i10 = this.f10212c.mTargetRequestCode;
                if (i10 != 0) {
                    fragmentState.f10060m.putInt("android:target_req_state", i10);
                }
            }
        } else {
            fragmentState.f10060m = fragment.mSavedFragmentState;
        }
        this.f10211b.B(this.f10212c.mWho, fragmentState);
    }

    public void t() {
        if (this.f10212c.mView == null) {
            return;
        }
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f10212c + " with view " + this.f10212c.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f10212c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f10212c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f10212c.mViewLifecycleOwner.e(bundle);
        if (!bundle.isEmpty()) {
            this.f10212c.mSavedViewRegistryState = bundle;
        }
    }

    public void u(int i10) {
        this.f10214e = i10;
    }

    public void v() {
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f10212c);
        }
        this.f10212c.performStart();
        this.f10210a.k(this.f10212c, false);
    }

    public void w() {
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f10212c);
        }
        this.f10212c.performStop();
        this.f10210a.l(this.f10212c, false);
    }

    public y(o oVar, A a10, ClassLoader classLoader, k kVar, FragmentState fragmentState) {
        this.f10210a = oVar;
        this.f10211b = a10;
        Fragment b10 = fragmentState.b(kVar, classLoader);
        this.f10212c = b10;
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + b10);
        }
    }

    public y(o oVar, A a10, Fragment fragment, FragmentState fragmentState) {
        this.f10210a = oVar;
        this.f10211b = a10;
        this.f10212c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.f10060m;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }

    /* compiled from: FragmentStateManager.java */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f10215a;

        public a(View view) {
            this.f10215a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f10215a.removeOnAttachStateChangeListener(this);
            K.f0(this.f10215a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
