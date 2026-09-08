package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: FragmentStore.java */
/* loaded from: classes.dex */
public class A {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<Fragment> f9842a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, y> f9843b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, FragmentState> f9844c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public FragmentManagerViewModel f9845d;

    public void A(FragmentManagerViewModel fragmentManagerViewModel) {
        this.f9845d = fragmentManagerViewModel;
    }

    public FragmentState B(String str, FragmentState fragmentState) {
        if (fragmentState != null) {
            return this.f9844c.put(str, fragmentState);
        }
        return this.f9844c.remove(str);
    }

    public void a(Fragment fragment) {
        if (!this.f9842a.contains(fragment)) {
            synchronized (this.f9842a) {
                this.f9842a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void b() {
        this.f9843b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        if (this.f9843b.get(str) != null) {
            return true;
        }
        return false;
    }

    public void d(int i10) {
        for (y yVar : this.f9843b.values()) {
            if (yVar != null) {
                yVar.u(i10);
            }
        }
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f9843b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (y yVar : this.f9843b.values()) {
                printWriter.print(str);
                if (yVar != null) {
                    Fragment k10 = yVar.k();
                    printWriter.println(k10);
                    k10.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f9842a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = this.f9842a.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    public Fragment f(String str) {
        y yVar = this.f9843b.get(str);
        if (yVar != null) {
            return yVar.k();
        }
        return null;
    }

    public Fragment g(int i10) {
        for (int size = this.f9842a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f9842a.get(size);
            if (fragment != null && fragment.mFragmentId == i10) {
                return fragment;
            }
        }
        for (y yVar : this.f9843b.values()) {
            if (yVar != null) {
                Fragment k10 = yVar.k();
                if (k10.mFragmentId == i10) {
                    return k10;
                }
            }
        }
        return null;
    }

    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f9842a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f9842a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (y yVar : this.f9843b.values()) {
                if (yVar != null) {
                    Fragment k10 = yVar.k();
                    if (str.equals(k10.mTag)) {
                        return k10;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public Fragment i(String str) {
        Fragment findFragmentByWho;
        for (y yVar : this.f9843b.values()) {
            if (yVar != null && (findFragmentByWho = yVar.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f9842a.indexOf(fragment);
        for (int i10 = indexOf - 1; i10 >= 0; i10--) {
            Fragment fragment2 = this.f9842a.get(i10);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f9842a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f9842a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public List<y> k() {
        ArrayList arrayList = new ArrayList();
        for (y yVar : this.f9843b.values()) {
            if (yVar != null) {
                arrayList.add(yVar);
            }
        }
        return arrayList;
    }

    public List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        for (y yVar : this.f9843b.values()) {
            if (yVar != null) {
                arrayList.add(yVar.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public ArrayList<FragmentState> m() {
        return new ArrayList<>(this.f9844c.values());
    }

    public y n(String str) {
        return this.f9843b.get(str);
    }

    public List<Fragment> o() {
        ArrayList arrayList;
        if (this.f9842a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f9842a) {
            arrayList = new ArrayList(this.f9842a);
        }
        return arrayList;
    }

    public FragmentManagerViewModel p() {
        return this.f9845d;
    }

    public FragmentState q(String str) {
        return this.f9844c.get(str);
    }

    public void r(y yVar) {
        Fragment k10 = yVar.k();
        if (c(k10.mWho)) {
            return;
        }
        this.f9843b.put(k10.mWho, yVar);
        if (k10.mRetainInstanceChangedWhileDetached) {
            if (k10.mRetainInstance) {
                this.f9845d.g(k10);
            } else {
                this.f9845d.q(k10);
            }
            k10.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + k10);
        }
    }

    public void s(y yVar) {
        Fragment k10 = yVar.k();
        if (k10.mRetainInstance) {
            this.f9845d.q(k10);
        }
        if (this.f9843b.put(k10.mWho, null) != null && FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k10);
        }
    }

    public void t() {
        Iterator<Fragment> it = this.f9842a.iterator();
        while (it.hasNext()) {
            y yVar = this.f9843b.get(it.next().mWho);
            if (yVar != null) {
                yVar.m();
            }
        }
        for (y yVar2 : this.f9843b.values()) {
            if (yVar2 != null) {
                yVar2.m();
                Fragment k10 = yVar2.k();
                if (k10.mRemoving && !k10.isInBackStack()) {
                    if (k10.mBeingSaved && !this.f9844c.containsKey(k10.mWho)) {
                        yVar2.s();
                    }
                    s(yVar2);
                }
            }
        }
    }

    public void u(Fragment fragment) {
        synchronized (this.f9842a) {
            this.f9842a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    public void v() {
        this.f9843b.clear();
    }

    public void w(List<String> list) {
        this.f9842a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment f10 = f(str);
                if (f10 != null) {
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + f10);
                    }
                    a(f10);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
            }
        }
    }

    public void x(ArrayList<FragmentState> arrayList) {
        this.f9844c.clear();
        Iterator<FragmentState> it = arrayList.iterator();
        while (it.hasNext()) {
            FragmentState next = it.next();
            this.f9844c.put(next.f10049b, next);
        }
    }

    public ArrayList<String> y() {
        ArrayList<String> arrayList = new ArrayList<>(this.f9843b.size());
        for (y yVar : this.f9843b.values()) {
            if (yVar != null) {
                Fragment k10 = yVar.k();
                yVar.s();
                arrayList.add(k10.mWho);
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k10 + ": " + k10.mSavedFragmentState);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> z() {
        synchronized (this.f9842a) {
            try {
                if (this.f9842a.isEmpty()) {
                    return null;
                }
                ArrayList<String> arrayList = new ArrayList<>(this.f9842a.size());
                Iterator<Fragment> it = this.f9842a.iterator();
                while (it.hasNext()) {
                    Fragment next = it.next();
                    arrayList.add(next.mWho);
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
