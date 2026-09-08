package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.B;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: BackStackRecord.java */
/* renamed from: androidx.fragment.app.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0470a extends B implements FragmentManager.n {

    /* renamed from: t, reason: collision with root package name */
    public final FragmentManager f10104t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10105u;

    /* renamed from: v, reason: collision with root package name */
    public int f10106v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f10107w;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0470a(androidx.fragment.app.FragmentManager r3) {
        /*
            r2 = this;
            androidx.fragment.app.k r0 = r3.x0()
            androidx.fragment.app.l r1 = r3.z0()
            if (r1 == 0) goto L17
            androidx.fragment.app.l r1 = r3.z0()
            android.content.Context r1 = r1.f()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L18
        L17:
            r1 = 0
        L18:
            r2.<init>(r0, r1)
            r0 = -1
            r2.f10106v = r0
            r0 = 0
            r2.f10107w = r0
            r2.f10104t = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0470a.<init>(androidx.fragment.app.FragmentManager):void");
    }

    public int A(boolean z10) {
        if (!this.f10105u) {
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new G("FragmentManager"));
                B("  ", printWriter);
                printWriter.close();
            }
            this.f10105u = true;
            if (this.f9854i) {
                this.f10106v = this.f10104t.m();
            } else {
                this.f10106v = -1;
            }
            this.f10104t.c0(this, z10);
            return this.f10106v;
        }
        throw new IllegalStateException("commit already called");
    }

    public void B(String str, PrintWriter printWriter) {
        C(str, printWriter, true);
    }

    public void C(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f9856k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f10106v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f10105u);
            if (this.f9853h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f9853h));
            }
            if (this.f9849d != 0 || this.f9850e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f9849d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f9850e));
            }
            if (this.f9851f != 0 || this.f9852g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f9851f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f9852g));
            }
            if (this.f9857l != 0 || this.f9858m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f9857l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f9858m);
            }
            if (this.f9859n != 0 || this.f9860o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f9859n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f9860o);
            }
        }
        if (!this.f9848c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f9848c.size();
            for (int i10 = 0; i10 < size; i10++) {
                B.a aVar = this.f9848c.get(i10);
                switch (aVar.f9865a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + aVar.f9865a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f9866b);
                if (z10) {
                    if (aVar.f9868d != 0 || aVar.f9869e != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f9868d));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f9869e));
                    }
                    if (aVar.f9870f != 0 || aVar.f9871g != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f9870f));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f9871g));
                    }
                }
            }
        }
    }

    public void D() {
        int size = this.f9848c.size();
        for (int i10 = 0; i10 < size; i10++) {
            B.a aVar = this.f9848c.get(i10);
            Fragment fragment = aVar.f9866b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f10107w;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f9853h);
                fragment.setSharedElementNames(this.f9861p, this.f9862q);
            }
            switch (aVar.f9865a) {
                case 1:
                    fragment.setAnimations(aVar.f9868d, aVar.f9869e, aVar.f9870f, aVar.f9871g);
                    this.f10104t.z1(fragment, false);
                    this.f10104t.j(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f9865a);
                case 3:
                    fragment.setAnimations(aVar.f9868d, aVar.f9869e, aVar.f9870f, aVar.f9871g);
                    this.f10104t.n1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f9868d, aVar.f9869e, aVar.f9870f, aVar.f9871g);
                    this.f10104t.J0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f9868d, aVar.f9869e, aVar.f9870f, aVar.f9871g);
                    this.f10104t.z1(fragment, false);
                    this.f10104t.F1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f9868d, aVar.f9869e, aVar.f9870f, aVar.f9871g);
                    this.f10104t.z(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f9868d, aVar.f9869e, aVar.f9870f, aVar.f9871g);
                    this.f10104t.z1(fragment, false);
                    this.f10104t.o(fragment);
                    break;
                case 8:
                    this.f10104t.D1(fragment);
                    break;
                case 9:
                    this.f10104t.D1(null);
                    break;
                case 10:
                    this.f10104t.C1(fragment, aVar.f9873i);
                    break;
            }
        }
    }

    public void E() {
        for (int size = this.f9848c.size() - 1; size >= 0; size--) {
            B.a aVar = this.f9848c.get(size);
            Fragment fragment = aVar.f9866b;
            if (fragment != null) {
                fragment.mBeingSaved = this.f10107w;
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.u1(this.f9853h));
                fragment.setSharedElementNames(this.f9862q, this.f9861p);
            }
            switch (aVar.f9865a) {
                case 1:
                    fragment.setAnimations(aVar.f9868d, aVar.f9869e, aVar.f9870f, aVar.f9871g);
                    this.f10104t.z1(fragment, true);
                    this.f10104t.n1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f9865a);
                case 3:
                    fragment.setAnimations(aVar.f9868d, aVar.f9869e, aVar.f9870f, aVar.f9871g);
                    this.f10104t.j(fragment);
                    break;
                case 4:
                    fragment.setAnimations(aVar.f9868d, aVar.f9869e, aVar.f9870f, aVar.f9871g);
                    this.f10104t.F1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(aVar.f9868d, aVar.f9869e, aVar.f9870f, aVar.f9871g);
                    this.f10104t.z1(fragment, true);
                    this.f10104t.J0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(aVar.f9868d, aVar.f9869e, aVar.f9870f, aVar.f9871g);
                    this.f10104t.o(fragment);
                    break;
                case 7:
                    fragment.setAnimations(aVar.f9868d, aVar.f9869e, aVar.f9870f, aVar.f9871g);
                    this.f10104t.z1(fragment, true);
                    this.f10104t.z(fragment);
                    break;
                case 8:
                    this.f10104t.D1(null);
                    break;
                case 9:
                    this.f10104t.D1(fragment);
                    break;
                case 10:
                    this.f10104t.C1(fragment, aVar.f9872h);
                    break;
            }
        }
    }

    public Fragment F(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i10 = 0;
        while (i10 < this.f9848c.size()) {
            B.a aVar = this.f9848c.get(i10);
            int i11 = aVar.f9865a;
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3 && i11 != 6) {
                        if (i11 != 7) {
                            if (i11 == 8) {
                                this.f9848c.add(i10, new B.a(9, fragment2, true));
                                aVar.f9867c = true;
                                i10++;
                                fragment2 = aVar.f9866b;
                            }
                        }
                    } else {
                        arrayList.remove(aVar.f9866b);
                        Fragment fragment3 = aVar.f9866b;
                        if (fragment3 == fragment2) {
                            this.f9848c.add(i10, new B.a(9, fragment3));
                            i10++;
                            fragment2 = null;
                        }
                    }
                } else {
                    Fragment fragment4 = aVar.f9866b;
                    int i12 = fragment4.mContainerId;
                    boolean z10 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList.get(size);
                        if (fragment5.mContainerId == i12) {
                            if (fragment5 == fragment4) {
                                z10 = true;
                            } else {
                                if (fragment5 == fragment2) {
                                    this.f9848c.add(i10, new B.a(9, fragment5, true));
                                    i10++;
                                    fragment2 = null;
                                }
                                B.a aVar2 = new B.a(3, fragment5, true);
                                aVar2.f9868d = aVar.f9868d;
                                aVar2.f9870f = aVar.f9870f;
                                aVar2.f9869e = aVar.f9869e;
                                aVar2.f9871g = aVar.f9871g;
                                this.f9848c.add(i10, aVar2);
                                arrayList.remove(fragment5);
                                i10++;
                            }
                        }
                    }
                    if (z10) {
                        this.f9848c.remove(i10);
                        i10--;
                    } else {
                        aVar.f9865a = 1;
                        aVar.f9867c = true;
                        arrayList.add(fragment4);
                    }
                }
                i10++;
            }
            arrayList.add(aVar.f9866b);
            i10++;
        }
        return fragment2;
    }

    public String G() {
        return this.f9856k;
    }

    public void H() {
        if (this.f9864s != null) {
            for (int i10 = 0; i10 < this.f9864s.size(); i10++) {
                this.f9864s.get(i10).run();
            }
            this.f9864s = null;
        }
    }

    public Fragment I(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f9848c.size() - 1; size >= 0; size--) {
            B.a aVar = this.f9848c.get(size);
            int i10 = aVar.f9865a;
            if (i10 != 1) {
                if (i10 != 3) {
                    switch (i10) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f9866b;
                            break;
                        case 10:
                            aVar.f9873i = aVar.f9872h;
                            break;
                    }
                }
                arrayList.add(aVar.f9866b);
            }
            arrayList.remove(aVar.f9866b);
        }
        return fragment;
    }

    @Override // androidx.fragment.app.FragmentManager.n
    public boolean a(ArrayList<C0470a> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f9854i) {
            this.f10104t.i(this);
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.B
    public int i() {
        return A(false);
    }

    @Override // androidx.fragment.app.B
    public int j() {
        return A(true);
    }

    @Override // androidx.fragment.app.B
    public void k() {
        n();
        this.f10104t.f0(this, false);
    }

    @Override // androidx.fragment.app.B
    public void l() {
        n();
        this.f10104t.f0(this, true);
    }

    @Override // androidx.fragment.app.B
    public B m(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager != null && fragmentManager != this.f10104t) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.m(fragment);
    }

    @Override // androidx.fragment.app.B
    public void o(int i10, Fragment fragment, String str, int i11) {
        super.o(i10, fragment, str, i11);
        fragment.mFragmentManager = this.f10104t;
    }

    @Override // androidx.fragment.app.B
    public B p(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager != null && fragmentManager != this.f10104t) {
            throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.p(fragment);
    }

    @Override // androidx.fragment.app.B
    public boolean q() {
        return this.f9848c.isEmpty();
    }

    @Override // androidx.fragment.app.B
    public B r(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager != null && fragmentManager != this.f10104t) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.r(fragment);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f10106v >= 0) {
            sb.append(" #");
            sb.append(this.f10106v);
        }
        if (this.f9856k != null) {
            sb.append(" ");
            sb.append(this.f9856k);
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // androidx.fragment.app.B
    public B w(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager == this.f10104t) {
            if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
                throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
            }
            if (state != Lifecycle.State.DESTROYED) {
                return super.w(fragment, state);
            }
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f10104t);
    }

    @Override // androidx.fragment.app.B
    public B y(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager != null && fragmentManager != this.f10104t) {
            throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        return super.y(fragment);
    }

    public void z(int i10) {
        if (!this.f9854i) {
            return;
        }
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
        }
        int size = this.f9848c.size();
        for (int i11 = 0; i11 < size; i11++) {
            B.a aVar = this.f9848c.get(i11);
            Fragment fragment = aVar.f9866b;
            if (fragment != null) {
                fragment.mBackStackNesting += i10;
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "Bump nesting of " + aVar.f9866b + " to " + aVar.f9866b.mBackStackNesting);
                }
            }
        }
    }
}
