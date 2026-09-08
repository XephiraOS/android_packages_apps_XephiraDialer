package androidx.fragment.app;

import F.d;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.K;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SpecialEffectsController {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f10075a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<Operation> f10076b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<Operation> f10077c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public boolean f10078d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10079e = false;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f10097a;

        public a(d dVar) {
            this.f10097a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SpecialEffectsController.this.f10076b.contains(this.f10097a)) {
                this.f10097a.e().a(this.f10097a.f().mView);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f10099a;

        public b(d dVar) {
            this.f10099a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            SpecialEffectsController.this.f10076b.remove(this.f10099a);
            SpecialEffectsController.this.f10077c.remove(this.f10099a);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10101a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f10102b;

        static {
            int[] iArr = new int[Operation.LifecycleImpact.values().length];
            f10102b = iArr;
            try {
                iArr[Operation.LifecycleImpact.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10102b[Operation.LifecycleImpact.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10102b[Operation.LifecycleImpact.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Operation.State.values().length];
            f10101a = iArr2;
            try {
                iArr2[Operation.State.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10101a[Operation.State.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10101a[Operation.State.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10101a[Operation.State.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends Operation {

        /* renamed from: h, reason: collision with root package name */
        public final y f10103h;

        public d(Operation.State state, Operation.LifecycleImpact lifecycleImpact, y yVar, F.d dVar) {
            super(state, lifecycleImpact, yVar.k(), dVar);
            this.f10103h = yVar;
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void c() {
            super.c();
            this.f10103h.m();
        }

        @Override // androidx.fragment.app.SpecialEffectsController.Operation
        public void l() {
            if (g() == Operation.LifecycleImpact.ADDING) {
                Fragment k10 = this.f10103h.k();
                View findFocus = k10.mView.findFocus();
                if (findFocus != null) {
                    k10.setFocusedView(findFocus);
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k10);
                    }
                }
                View requireView = f().requireView();
                if (requireView.getParent() == null) {
                    this.f10103h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k10.getPostOnViewCreatedAlpha());
                return;
            }
            if (g() == Operation.LifecycleImpact.REMOVING) {
                Fragment k11 = this.f10103h.k();
                View requireView2 = k11.requireView();
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "Clearing focus " + requireView2.findFocus() + " on view " + requireView2 + " for Fragment " + k11);
                }
                requireView2.clearFocus();
            }
        }
    }

    public SpecialEffectsController(ViewGroup viewGroup) {
        this.f10075a = viewGroup;
    }

    public static SpecialEffectsController n(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return o(viewGroup, fragmentManager.E0());
    }

    public static SpecialEffectsController o(ViewGroup viewGroup, H h10) {
        int i10 = R.b.f3156b;
        Object tag = viewGroup.getTag(i10);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController a10 = h10.a(viewGroup);
        viewGroup.setTag(i10, a10);
        return a10;
    }

    public final void a(Operation.State state, Operation.LifecycleImpact lifecycleImpact, y yVar) {
        synchronized (this.f10076b) {
            try {
                F.d dVar = new F.d();
                Operation h10 = h(yVar.k());
                if (h10 != null) {
                    h10.k(state, lifecycleImpact);
                    return;
                }
                d dVar2 = new d(state, lifecycleImpact, yVar, dVar);
                this.f10076b.add(dVar2);
                dVar2.a(new a(dVar2));
                dVar2.a(new b(dVar2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(Operation.State state, y yVar) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + yVar.k());
        }
        a(state, Operation.LifecycleImpact.ADDING, yVar);
    }

    public void c(y yVar) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + yVar.k());
        }
        a(Operation.State.GONE, Operation.LifecycleImpact.NONE, yVar);
    }

    public void d(y yVar) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + yVar.k());
        }
        a(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, yVar);
    }

    public void e(y yVar) {
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + yVar.k());
        }
        a(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, yVar);
    }

    public abstract void f(List<Operation> list, boolean z10);

    public void g() {
        if (this.f10079e) {
            return;
        }
        if (!K.N(this.f10075a)) {
            j();
            this.f10078d = false;
            return;
        }
        synchronized (this.f10076b) {
            try {
                if (!this.f10076b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f10077c);
                    this.f10077c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Operation operation = (Operation) it.next();
                        if (FragmentManager.M0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + operation);
                        }
                        operation.b();
                        if (!operation.i()) {
                            this.f10077c.add(operation);
                        }
                    }
                    q();
                    ArrayList arrayList2 = new ArrayList(this.f10076b);
                    this.f10076b.clear();
                    this.f10077c.addAll(arrayList2);
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((Operation) it2.next()).l();
                    }
                    f(arrayList2, this.f10078d);
                    this.f10078d = false;
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Operation h(Fragment fragment) {
        Iterator<Operation> it = this.f10076b.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    public final Operation i(Fragment fragment) {
        Iterator<Operation> it = this.f10077c.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    public void j() {
        String str;
        String str2;
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean N10 = K.N(this.f10075a);
        synchronized (this.f10076b) {
            try {
                q();
                Iterator<Operation> it = this.f10076b.iterator();
                while (it.hasNext()) {
                    it.next().l();
                }
                Iterator it2 = new ArrayList(this.f10077c).iterator();
                while (it2.hasNext()) {
                    Operation operation = (Operation) it2.next();
                    if (FragmentManager.M0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (N10) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f10075a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(operation);
                        Log.v("FragmentManager", sb.toString());
                    }
                    operation.b();
                }
                Iterator it3 = new ArrayList(this.f10076b).iterator();
                while (it3.hasNext()) {
                    Operation operation2 = (Operation) it3.next();
                    if (FragmentManager.M0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (N10) {
                            str = "";
                        } else {
                            str = "Container " + this.f10075a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(operation2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    operation2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k() {
        if (this.f10079e) {
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f10079e = false;
            g();
        }
    }

    public Operation.LifecycleImpact l(y yVar) {
        Operation.LifecycleImpact lifecycleImpact;
        Operation h10 = h(yVar.k());
        if (h10 != null) {
            lifecycleImpact = h10.g();
        } else {
            lifecycleImpact = null;
        }
        Operation i10 = i(yVar.k());
        if (i10 != null && (lifecycleImpact == null || lifecycleImpact == Operation.LifecycleImpact.NONE)) {
            return i10.g();
        }
        return lifecycleImpact;
    }

    public ViewGroup m() {
        return this.f10075a;
    }

    public void p() {
        synchronized (this.f10076b) {
            try {
                q();
                this.f10079e = false;
                int size = this.f10076b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    Operation operation = this.f10076b.get(size);
                    Operation.State c10 = Operation.State.c(operation.f().mView);
                    Operation.State e10 = operation.e();
                    Operation.State state = Operation.State.VISIBLE;
                    if (e10 == state && c10 != state) {
                        this.f10079e = operation.f().isPostponed();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void q() {
        Iterator<Operation> it = this.f10076b.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.g() == Operation.LifecycleImpact.ADDING) {
                next.k(Operation.State.b(next.f().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public void r(boolean z10) {
        this.f10078d = z10;
    }

    /* loaded from: classes.dex */
    public static class Operation {

        /* renamed from: a, reason: collision with root package name */
        public State f10080a;

        /* renamed from: b, reason: collision with root package name */
        public LifecycleImpact f10081b;

        /* renamed from: c, reason: collision with root package name */
        public final Fragment f10082c;

        /* renamed from: d, reason: collision with root package name */
        public final List<Runnable> f10083d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        public final HashSet<F.d> f10084e = new HashSet<>();

        /* renamed from: f, reason: collision with root package name */
        public boolean f10085f = false;

        /* renamed from: g, reason: collision with root package name */
        public boolean f10086g = false;

        /* loaded from: classes.dex */
        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        /* loaded from: classes.dex */
        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static State b(int i10) {
                if (i10 != 0) {
                    if (i10 != 4) {
                        if (i10 == 8) {
                            return GONE;
                        }
                        throw new IllegalArgumentException("Unknown visibility " + i10);
                    }
                    return INVISIBLE;
                }
                return VISIBLE;
            }

            public static State c(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return b(view.getVisibility());
            }

            public void a(View view) {
                int i10 = c.f10101a[ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 == 4) {
                                if (FragmentManager.M0(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                                }
                                view.setVisibility(4);
                                return;
                            }
                            return;
                        }
                        if (FragmentManager.M0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                        }
                        view.setVisibility(8);
                        return;
                    }
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                    }
                    viewGroup.removeView(view);
                }
            }
        }

        /* loaded from: classes.dex */
        public class a implements d.a {
            public a() {
            }

            @Override // F.d.a
            public void onCancel() {
                Operation.this.b();
            }
        }

        public Operation(State state, LifecycleImpact lifecycleImpact, Fragment fragment, F.d dVar) {
            this.f10080a = state;
            this.f10081b = lifecycleImpact;
            this.f10082c = fragment;
            dVar.c(new a());
        }

        public final void a(Runnable runnable) {
            this.f10083d.add(runnable);
        }

        public final void b() {
            if (h()) {
                return;
            }
            this.f10085f = true;
            if (this.f10084e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f10084e).iterator();
            while (it.hasNext()) {
                ((F.d) it.next()).a();
            }
        }

        public void c() {
            if (this.f10086g) {
                return;
            }
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f10086g = true;
            Iterator<Runnable> it = this.f10083d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        public final void d(F.d dVar) {
            if (this.f10084e.remove(dVar) && this.f10084e.isEmpty()) {
                c();
            }
        }

        public State e() {
            return this.f10080a;
        }

        public final Fragment f() {
            return this.f10082c;
        }

        public LifecycleImpact g() {
            return this.f10081b;
        }

        public final boolean h() {
            return this.f10085f;
        }

        public final boolean i() {
            return this.f10086g;
        }

        public final void j(F.d dVar) {
            l();
            this.f10084e.add(dVar);
        }

        public final void k(State state, LifecycleImpact lifecycleImpact) {
            int i10 = c.f10102b[lifecycleImpact.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3 && this.f10080a != State.REMOVED) {
                        if (FragmentManager.M0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f10082c + " mFinalState = " + this.f10080a + " -> " + state + ". ");
                        }
                        this.f10080a = state;
                        return;
                    }
                    return;
                }
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f10082c + " mFinalState = " + this.f10080a + " -> REMOVED. mLifecycleImpact  = " + this.f10081b + " to REMOVING.");
                }
                this.f10080a = State.REMOVED;
                this.f10081b = LifecycleImpact.REMOVING;
                return;
            }
            if (this.f10080a == State.REMOVED) {
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f10082c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f10081b + " to ADDING.");
                }
                this.f10080a = State.VISIBLE;
                this.f10081b = LifecycleImpact.ADDING;
            }
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f10080a + "} {mLifecycleImpact = " + this.f10081b + "} {mFragment = " + this.f10082c + "}";
        }

        public void l() {
        }
    }
}
