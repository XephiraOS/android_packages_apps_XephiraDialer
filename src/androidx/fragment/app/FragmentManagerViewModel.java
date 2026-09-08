package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.I;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FragmentManagerViewModel extends I {

    /* renamed from: k, reason: collision with root package name */
    public static final K.b f10040k = new a();

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10044g;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<String, Fragment> f10041d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap<String, FragmentManagerViewModel> f10042e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap<String, M> f10043f = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public boolean f10045h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10046i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f10047j = false;

    /* loaded from: classes.dex */
    public class a implements K.b {
        @Override // androidx.lifecycle.K.b
        public <T extends I> T a(Class<T> cls) {
            return new FragmentManagerViewModel(true);
        }
    }

    public FragmentManagerViewModel(boolean z10) {
        this.f10044g = z10;
    }

    public static FragmentManagerViewModel m(M m10) {
        return (FragmentManagerViewModel) new K(m10, f10040k).a(FragmentManagerViewModel.class);
    }

    @Override // androidx.lifecycle.I
    public void e() {
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f10045h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FragmentManagerViewModel.class != obj.getClass()) {
            return false;
        }
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
        if (this.f10041d.equals(fragmentManagerViewModel.f10041d) && this.f10042e.equals(fragmentManagerViewModel.f10042e) && this.f10043f.equals(fragmentManagerViewModel.f10043f)) {
            return true;
        }
        return false;
    }

    public void g(Fragment fragment) {
        if (this.f10047j) {
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f10041d.containsKey(fragment.mWho)) {
                return;
            }
            this.f10041d.put(fragment.mWho, fragment);
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    public void h(Fragment fragment) {
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        j(fragment.mWho);
    }

    public int hashCode() {
        return (((this.f10041d.hashCode() * 31) + this.f10042e.hashCode()) * 31) + this.f10043f.hashCode();
    }

    public void i(String str) {
        if (FragmentManager.M0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        j(str);
    }

    public final void j(String str) {
        FragmentManagerViewModel fragmentManagerViewModel = this.f10042e.get(str);
        if (fragmentManagerViewModel != null) {
            fragmentManagerViewModel.e();
            this.f10042e.remove(str);
        }
        M m10 = this.f10043f.get(str);
        if (m10 != null) {
            m10.a();
            this.f10043f.remove(str);
        }
    }

    public Fragment k(String str) {
        return this.f10041d.get(str);
    }

    public FragmentManagerViewModel l(Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel = this.f10042e.get(fragment.mWho);
        if (fragmentManagerViewModel == null) {
            FragmentManagerViewModel fragmentManagerViewModel2 = new FragmentManagerViewModel(this.f10044g);
            this.f10042e.put(fragment.mWho, fragmentManagerViewModel2);
            return fragmentManagerViewModel2;
        }
        return fragmentManagerViewModel;
    }

    public Collection<Fragment> n() {
        return new ArrayList(this.f10041d.values());
    }

    public M o(Fragment fragment) {
        M m10 = this.f10043f.get(fragment.mWho);
        if (m10 == null) {
            M m11 = new M();
            this.f10043f.put(fragment.mWho, m11);
            return m11;
        }
        return m10;
    }

    public boolean p() {
        return this.f10045h;
    }

    public void q(Fragment fragment) {
        if (this.f10047j) {
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.f10041d.remove(fragment.mWho) != null && FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public void r(boolean z10) {
        this.f10047j = z10;
    }

    public boolean s(Fragment fragment) {
        if (!this.f10041d.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.f10044g) {
            return this.f10045h;
        }
        return !this.f10046i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f10041d.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f10042e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f10043f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
