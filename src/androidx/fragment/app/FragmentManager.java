package androidx.fragment.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.view.InterfaceC0459n;
import androidx.core.view.InterfaceC0463s;
import androidx.fragment.app.B;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.InterfaceC0489l;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.savedstate.a;
import c.AbstractC0540a;
import c.C0541b;
import c.C0543d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class FragmentManager {

    /* renamed from: S, reason: collision with root package name */
    public static boolean f9964S = false;

    /* renamed from: D, reason: collision with root package name */
    public androidx.activity.result.b<Intent> f9968D;

    /* renamed from: E, reason: collision with root package name */
    public androidx.activity.result.b<IntentSenderRequest> f9969E;

    /* renamed from: F, reason: collision with root package name */
    public androidx.activity.result.b<String[]> f9970F;

    /* renamed from: H, reason: collision with root package name */
    public boolean f9972H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f9973I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f9974J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f9975K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f9976L;

    /* renamed from: M, reason: collision with root package name */
    public ArrayList<C0470a> f9977M;

    /* renamed from: N, reason: collision with root package name */
    public ArrayList<Boolean> f9978N;

    /* renamed from: O, reason: collision with root package name */
    public ArrayList<Fragment> f9979O;

    /* renamed from: P, reason: collision with root package name */
    public FragmentManagerViewModel f9980P;

    /* renamed from: Q, reason: collision with root package name */
    public FragmentStrictMode.b f9981Q;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9984b;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<C0470a> f9986d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<Fragment> f9987e;

    /* renamed from: g, reason: collision with root package name */
    public OnBackPressedDispatcher f9989g;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<m> f9995m;

    /* renamed from: v, reason: collision with root package name */
    public androidx.fragment.app.l<?> f10004v;

    /* renamed from: w, reason: collision with root package name */
    public androidx.fragment.app.i f10005w;

    /* renamed from: x, reason: collision with root package name */
    public Fragment f10006x;

    /* renamed from: y, reason: collision with root package name */
    public Fragment f10007y;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<n> f9983a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final A f9985c = new A();

    /* renamed from: f, reason: collision with root package name */
    public final androidx.fragment.app.n f9988f = new androidx.fragment.app.n(this);

    /* renamed from: h, reason: collision with root package name */
    public final androidx.activity.n f9990h = new b(false);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f9991i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    public final Map<String, BackStackState> f9992j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    public final Map<String, Bundle> f9993k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l, reason: collision with root package name */
    public final Map<String, l> f9994l = Collections.synchronizedMap(new HashMap());

    /* renamed from: n, reason: collision with root package name */
    public final androidx.fragment.app.o f9996n = new androidx.fragment.app.o(this);

    /* renamed from: o, reason: collision with root package name */
    public final CopyOnWriteArrayList<v> f9997o = new CopyOnWriteArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    public final I.a<Configuration> f9998p = new I.a() { // from class: androidx.fragment.app.p
        @Override // I.a
        public final void accept(Object obj) {
            FragmentManager.this.V0((Configuration) obj);
        }
    };

    /* renamed from: q, reason: collision with root package name */
    public final I.a<Integer> f9999q = new I.a() { // from class: androidx.fragment.app.q
        @Override // I.a
        public final void accept(Object obj) {
            FragmentManager.this.W0((Integer) obj);
        }
    };

    /* renamed from: r, reason: collision with root package name */
    public final I.a<androidx.core.app.f> f10000r = new I.a() { // from class: androidx.fragment.app.r
        @Override // I.a
        public final void accept(Object obj) {
            FragmentManager.this.X0((androidx.core.app.f) obj);
        }
    };

    /* renamed from: s, reason: collision with root package name */
    public final I.a<androidx.core.app.l> f10001s = new I.a() { // from class: androidx.fragment.app.s
        @Override // I.a
        public final void accept(Object obj) {
            FragmentManager.this.Y0((androidx.core.app.l) obj);
        }
    };

    /* renamed from: t, reason: collision with root package name */
    public final InterfaceC0463s f10002t = new c();

    /* renamed from: u, reason: collision with root package name */
    public int f10003u = -1;

    /* renamed from: z, reason: collision with root package name */
    public androidx.fragment.app.k f10008z = null;

    /* renamed from: A, reason: collision with root package name */
    public androidx.fragment.app.k f9965A = new d();

    /* renamed from: B, reason: collision with root package name */
    public H f9966B = null;

    /* renamed from: C, reason: collision with root package name */
    public H f9967C = new e();

    /* renamed from: G, reason: collision with root package name */
    public ArrayDeque<LaunchedFragmentInfo> f9971G = new ArrayDeque<>();

    /* renamed from: R, reason: collision with root package name */
    public Runnable f9982R = new f();

    /* loaded from: classes.dex */
    public class a implements androidx.activity.result.a<Map<String, Boolean>> {
        public a() {
        }

        @Override // androidx.activity.result.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<String, Boolean> map) {
            int i10;
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                if (((Boolean) arrayList.get(i11)).booleanValue()) {
                    i10 = 0;
                } else {
                    i10 = -1;
                }
                iArr[i11] = i10;
            }
            LaunchedFragmentInfo pollFirst = FragmentManager.this.f9971G.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = pollFirst.f10013a;
            int i12 = pollFirst.f10014b;
            Fragment i13 = FragmentManager.this.f9985c.i(str);
            if (i13 == null) {
                Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                return;
            }
            i13.onRequestPermissionsResult(i12, strArr, iArr);
        }
    }

    /* loaded from: classes.dex */
    public class b extends androidx.activity.n {
        public b(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.n
        public void d() {
            FragmentManager.this.I0();
        }
    }

    /* loaded from: classes.dex */
    public class c implements InterfaceC0463s {
        public c() {
        }

        @Override // androidx.core.view.InterfaceC0463s
        public boolean a(MenuItem menuItem) {
            return FragmentManager.this.M(menuItem);
        }

        @Override // androidx.core.view.InterfaceC0463s
        public void b(Menu menu) {
            FragmentManager.this.N(menu);
        }

        @Override // androidx.core.view.InterfaceC0463s
        public void c(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.F(menu, menuInflater);
        }

        @Override // androidx.core.view.InterfaceC0463s
        public void d(Menu menu) {
            FragmentManager.this.R(menu);
        }
    }

    /* loaded from: classes.dex */
    public class d extends androidx.fragment.app.k {
        public d() {
        }

        @Override // androidx.fragment.app.k
        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.z0().b(FragmentManager.this.z0().f(), str, null);
        }
    }

    /* loaded from: classes.dex */
    public class e implements H {
        public e() {
        }

        @Override // androidx.fragment.app.H
        public SpecialEffectsController a(ViewGroup viewGroup) {
            return new C0471b(viewGroup);
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.e0(true);
        }
    }

    /* loaded from: classes.dex */
    public class g implements v {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f10021a;

        public g(Fragment fragment) {
            this.f10021a = fragment;
        }

        @Override // androidx.fragment.app.v
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            this.f10021a.onAttachFragment(fragment);
        }
    }

    /* loaded from: classes.dex */
    public class h implements androidx.activity.result.a<ActivityResult> {
        public h() {
        }

        @Override // androidx.activity.result.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.f9971G.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = pollFirst.f10013a;
            int i10 = pollFirst.f10014b;
            Fragment i11 = FragmentManager.this.f9985c.i(str);
            if (i11 == null) {
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                return;
            }
            i11.onActivityResult(i10, activityResult.d(), activityResult.b());
        }
    }

    /* loaded from: classes.dex */
    public class i implements androidx.activity.result.a<ActivityResult> {
        public i() {
        }

        @Override // androidx.activity.result.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo pollFirst = FragmentManager.this.f9971G.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = pollFirst.f10013a;
            int i10 = pollFirst.f10014b;
            Fragment i11 = FragmentManager.this.f9985c.i(str);
            if (i11 == null) {
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                return;
            }
            i11.onActivityResult(i10, activityResult.d(), activityResult.b());
        }
    }

    /* loaded from: classes.dex */
    public static class j extends AbstractC0540a<IntentSenderRequest, ActivityResult> {
        @Override // c.AbstractC0540a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent b10 = intentSenderRequest.b();
            if (b10 != null && (bundleExtra = b10.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                b10.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (b10.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.a(intentSenderRequest.h()).b(null).c(intentSenderRequest.f(), intentSenderRequest.d()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // c.AbstractC0540a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    /* loaded from: classes.dex */
    public static class l implements x {

        /* renamed from: a, reason: collision with root package name */
        public final Lifecycle f10025a;

        /* renamed from: b, reason: collision with root package name */
        public final x f10026b;

        /* renamed from: c, reason: collision with root package name */
        public final InterfaceC0489l f10027c;

        public l(Lifecycle lifecycle, x xVar, InterfaceC0489l interfaceC0489l) {
            this.f10025a = lifecycle;
            this.f10026b = xVar;
            this.f10027c = interfaceC0489l;
        }

        @Override // androidx.fragment.app.x
        public void a(String str, Bundle bundle) {
            this.f10026b.a(str, bundle);
        }

        public boolean b(Lifecycle.State state) {
            return this.f10025a.b().b(state);
        }

        public void c() {
            this.f10025a.d(this.f10027c);
        }
    }

    /* loaded from: classes.dex */
    public interface m {
        void a();
    }

    /* loaded from: classes.dex */
    public interface n {
        boolean a(ArrayList<C0470a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    public class o implements n {

        /* renamed from: a, reason: collision with root package name */
        public final String f10028a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10029b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10030c;

        public o(String str, int i10, int i11) {
            this.f10028a = str;
            this.f10029b = i10;
            this.f10030c = i11;
        }

        @Override // androidx.fragment.app.FragmentManager.n
        public boolean a(ArrayList<C0470a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f10007y;
            if (fragment != null && this.f10029b < 0 && this.f10028a == null && fragment.getChildFragmentManager().h1()) {
                return false;
            }
            return FragmentManager.this.k1(arrayList, arrayList2, this.f10028a, this.f10029b, this.f10030c);
        }
    }

    public static Fragment G0(View view) {
        Object tag = view.getTag(R.b.f3155a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean M0(int i10) {
        if (!f9964S && !Log.isLoggable("FragmentManager", i10)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static void a0(boolean z10) {
        f9964S = z10;
    }

    public static void g0(ArrayList<C0470a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        while (i10 < i11) {
            C0470a c0470a = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue()) {
                c0470a.z(-1);
                c0470a.E();
            } else {
                c0470a.z(1);
                c0470a.D();
            }
            i10++;
        }
    }

    public static FragmentManager o0(View view) {
        FragmentActivity fragmentActivity;
        Fragment p02 = p0(view);
        if (p02 != null) {
            if (p02.isAdded()) {
                return p02.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + p02 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (context instanceof ContextWrapper) {
                if (context instanceof FragmentActivity) {
                    fragmentActivity = (FragmentActivity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                fragmentActivity = null;
                break;
            }
        }
        if (fragmentActivity != null) {
            return fragmentActivity.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    public static Fragment p0(View view) {
        while (view != null) {
            Fragment G02 = G0(view);
            if (G02 != null) {
                return G02;
            }
            Object parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        return null;
    }

    public static int u1(int i10) {
        int i11 = 4097;
        if (i10 == 4097) {
            return 8194;
        }
        if (i10 != 8194) {
            i11 = 8197;
            if (i10 == 8197) {
                return 4100;
            }
            if (i10 == 4099) {
                return 4099;
            }
            if (i10 != 4100) {
                return 0;
            }
        }
        return i11;
    }

    public void A() {
        this.f9973I = false;
        this.f9974J = false;
        this.f9980P.r(false);
        V(4);
    }

    public LayoutInflater.Factory2 A0() {
        return this.f9988f;
    }

    public final void A1(String str, Bundle bundle) {
        l lVar = this.f9994l.get(str);
        if (lVar != null && lVar.b(Lifecycle.State.STARTED)) {
            lVar.a(str, bundle);
        } else {
            this.f9993k.put(str, bundle);
        }
        if (M0(2)) {
            Log.v("FragmentManager", "Setting fragment result with key " + str + " and result " + bundle);
        }
    }

    public void B() {
        this.f9973I = false;
        this.f9974J = false;
        this.f9980P.r(false);
        V(0);
    }

    public androidx.fragment.app.o B0() {
        return this.f9996n;
    }

    public final void B1(final String str, InterfaceC0492o interfaceC0492o, final x xVar) {
        final Lifecycle lifecycle = interfaceC0492o.getLifecycle();
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        InterfaceC0489l interfaceC0489l = new InterfaceC0489l() { // from class: androidx.fragment.app.FragmentManager.6
            @Override // androidx.lifecycle.InterfaceC0489l
            public void onStateChanged(InterfaceC0492o interfaceC0492o2, Lifecycle.Event event) {
                Bundle bundle;
                if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.f9993k.get(str)) != null) {
                    xVar.a(str, bundle);
                    FragmentManager.this.u(str);
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.d(this);
                    FragmentManager.this.f9994l.remove(str);
                }
            }
        };
        lifecycle.a(interfaceC0489l);
        l put = this.f9994l.put(str, new l(lifecycle, xVar, interfaceC0489l));
        if (put != null) {
            put.c();
        }
        if (M0(2)) {
            Log.v("FragmentManager", "Setting FragmentResultListener with key " + str + " lifecycleOwner " + lifecycle + " and listener " + xVar);
        }
    }

    public void C(Configuration configuration, boolean z10) {
        if (z10 && (this.f10004v instanceof androidx.core.content.c)) {
            H1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.f9985c.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z10) {
                    fragment.mChildFragmentManager.C(configuration, true);
                }
            }
        }
    }

    public Fragment C0() {
        return this.f10006x;
    }

    public void C1(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(j0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public boolean D(MenuItem menuItem) {
        if (this.f10003u < 1) {
            return false;
        }
        for (Fragment fragment : this.f9985c.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public Fragment D0() {
        return this.f10007y;
    }

    public void D1(Fragment fragment) {
        if (fragment != null && (!fragment.equals(j0(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        Fragment fragment2 = this.f10007y;
        this.f10007y = fragment;
        O(fragment2);
        O(this.f10007y);
    }

    public void E() {
        this.f9973I = false;
        this.f9974J = false;
        this.f9980P.r(false);
        V(1);
    }

    public H E0() {
        H h10 = this.f9966B;
        if (h10 != null) {
            return h10;
        }
        Fragment fragment = this.f10006x;
        if (fragment != null) {
            return fragment.mFragmentManager.E0();
        }
        return this.f9967C;
    }

    public final void E1(Fragment fragment) {
        ViewGroup w02 = w0(fragment);
        if (w02 != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            int i10 = R.b.f3157c;
            if (w02.getTag(i10) == null) {
                w02.setTag(i10, fragment);
            }
            ((Fragment) w02.getTag(i10)).setPopDirection(fragment.getPopDirection());
        }
    }

    public boolean F(Menu menu, MenuInflater menuInflater) {
        if (this.f10003u < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.f9985c.o()) {
            if (fragment != null && Q0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.f9987e != null) {
            for (int i10 = 0; i10 < this.f9987e.size(); i10++) {
                Fragment fragment2 = this.f9987e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f9987e = arrayList;
        return z10;
    }

    public FragmentStrictMode.b F0() {
        return this.f9981Q;
    }

    public void F1(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public void G() {
        this.f9975K = true;
        e0(true);
        b0();
        t();
        V(-1);
        Object obj = this.f10004v;
        if (obj instanceof androidx.core.content.d) {
            ((androidx.core.content.d) obj).removeOnTrimMemoryListener(this.f9999q);
        }
        Object obj2 = this.f10004v;
        if (obj2 instanceof androidx.core.content.c) {
            ((androidx.core.content.c) obj2).removeOnConfigurationChangedListener(this.f9998p);
        }
        Object obj3 = this.f10004v;
        if (obj3 instanceof androidx.core.app.j) {
            ((androidx.core.app.j) obj3).removeOnMultiWindowModeChangedListener(this.f10000r);
        }
        Object obj4 = this.f10004v;
        if (obj4 instanceof androidx.core.app.k) {
            ((androidx.core.app.k) obj4).removeOnPictureInPictureModeChangedListener(this.f10001s);
        }
        Object obj5 = this.f10004v;
        if (obj5 instanceof InterfaceC0459n) {
            ((InterfaceC0459n) obj5).removeMenuProvider(this.f10002t);
        }
        this.f10004v = null;
        this.f10005w = null;
        this.f10006x = null;
        if (this.f9989g != null) {
            this.f9990h.h();
            this.f9989g = null;
        }
        androidx.activity.result.b<Intent> bVar = this.f9968D;
        if (bVar != null) {
            bVar.c();
            this.f9969E.c();
            this.f9970F.c();
        }
    }

    public final void G1() {
        Iterator<y> it = this.f9985c.k().iterator();
        while (it.hasNext()) {
            f1(it.next());
        }
    }

    public void H() {
        V(1);
    }

    public M H0(Fragment fragment) {
        return this.f9980P.o(fragment);
    }

    public final void H1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new G("FragmentManager"));
        androidx.fragment.app.l<?> lVar = this.f10004v;
        if (lVar != null) {
            try {
                lVar.h("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
                throw runtimeException;
            }
        }
        try {
            Z("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e11) {
            Log.e("FragmentManager", "Failed dumping state", e11);
            throw runtimeException;
        }
    }

    public void I(boolean z10) {
        if (z10 && (this.f10004v instanceof androidx.core.content.d)) {
            H1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.f9985c.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z10) {
                    fragment.mChildFragmentManager.I(true);
                }
            }
        }
    }

    public void I0() {
        e0(true);
        if (this.f9990h.g()) {
            h1();
        } else {
            this.f9989g.l();
        }
    }

    public void I1(k kVar) {
        this.f9996n.p(kVar);
    }

    public void J(boolean z10, boolean z11) {
        if (z11 && (this.f10004v instanceof androidx.core.app.j)) {
            H1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.f9985c.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z10);
                if (z11) {
                    fragment.mChildFragmentManager.J(z10, true);
                }
            }
        }
    }

    public void J0(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            E1(fragment);
        }
    }

    public final void J1() {
        synchronized (this.f9983a) {
            try {
                boolean z10 = true;
                if (!this.f9983a.isEmpty()) {
                    this.f9990h.j(true);
                    return;
                }
                androidx.activity.n nVar = this.f9990h;
                if (s0() <= 0 || !R0(this.f10006x)) {
                    z10 = false;
                }
                nVar.j(z10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void K(Fragment fragment) {
        Iterator<v> it = this.f9997o.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    public void K0(Fragment fragment) {
        if (fragment.mAdded && N0(fragment)) {
            this.f9972H = true;
        }
    }

    public void L() {
        for (Fragment fragment : this.f9985c.l()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.L();
            }
        }
    }

    public boolean L0() {
        return this.f9975K;
    }

    public boolean M(MenuItem menuItem) {
        if (this.f10003u < 1) {
            return false;
        }
        for (Fragment fragment : this.f9985c.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void N(Menu menu) {
        if (this.f10003u < 1) {
            return;
        }
        for (Fragment fragment : this.f9985c.o()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final boolean N0(Fragment fragment) {
        if ((fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.q()) {
            return true;
        }
        return false;
    }

    public final void O(Fragment fragment) {
        if (fragment != null && fragment.equals(j0(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    public final boolean O0() {
        Fragment fragment = this.f10006x;
        if (fragment == null) {
            return true;
        }
        if (fragment.isAdded() && this.f10006x.getParentFragmentManager().O0()) {
            return true;
        }
        return false;
    }

    public void P() {
        V(5);
    }

    public boolean P0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    public void Q(boolean z10, boolean z11) {
        if (z11 && (this.f10004v instanceof androidx.core.app.k)) {
            H1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.f9985c.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z10);
                if (z11) {
                    fragment.mChildFragmentManager.Q(z10, true);
                }
            }
        }
    }

    public boolean Q0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public boolean R(Menu menu) {
        boolean z10 = false;
        if (this.f10003u < 1) {
            return false;
        }
        for (Fragment fragment : this.f9985c.o()) {
            if (fragment != null && Q0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    public boolean R0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragment.equals(fragmentManager.D0()) && R0(fragmentManager.f10006x)) {
            return true;
        }
        return false;
    }

    public void S() {
        J1();
        O(this.f10007y);
    }

    public boolean S0(int i10) {
        if (this.f10003u >= i10) {
            return true;
        }
        return false;
    }

    public void T() {
        this.f9973I = false;
        this.f9974J = false;
        this.f9980P.r(false);
        V(7);
    }

    public boolean T0() {
        if (!this.f9973I && !this.f9974J) {
            return false;
        }
        return true;
    }

    public void U() {
        this.f9973I = false;
        this.f9974J = false;
        this.f9980P.r(false);
        V(5);
    }

    public final void V(int i10) {
        try {
            this.f9984b = true;
            this.f9985c.d(i10);
            c1(i10, false);
            Iterator<SpecialEffectsController> it = w().iterator();
            while (it.hasNext()) {
                it.next().j();
            }
            this.f9984b = false;
            e0(true);
        } catch (Throwable th) {
            this.f9984b = false;
            throw th;
        }
    }

    public final /* synthetic */ void V0(Configuration configuration) {
        if (O0()) {
            C(configuration, false);
        }
    }

    public void W() {
        this.f9974J = true;
        this.f9980P.r(true);
        V(4);
    }

    public final /* synthetic */ void W0(Integer num) {
        if (O0() && num.intValue() == 80) {
            I(false);
        }
    }

    public void X() {
        V(2);
    }

    public final /* synthetic */ void X0(androidx.core.app.f fVar) {
        if (O0()) {
            J(fVar.a(), false);
        }
    }

    public final void Y() {
        if (this.f9976L) {
            this.f9976L = false;
            G1();
        }
    }

    public final /* synthetic */ void Y0(androidx.core.app.l lVar) {
        if (O0()) {
            Q(lVar.a(), false);
        }
    }

    public void Z(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f9985c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f9987e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                Fragment fragment = this.f9987e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<C0470a> arrayList2 = this.f9986d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                C0470a c0470a = this.f9986d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(c0470a.toString());
                c0470a.B(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f9991i.get());
        synchronized (this.f9983a) {
            try {
                int size3 = this.f9983a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i12 = 0; i12 < size3; i12++) {
                        n nVar = this.f9983a.get(i12);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i12);
                        printWriter.print(": ");
                        printWriter.println(nVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f10004v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f10005w);
        if (this.f10006x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f10006x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f10003u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f9973I);
        printWriter.print(" mStopped=");
        printWriter.print(this.f9974J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f9975K);
        if (this.f9972H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f9972H);
        }
    }

    public void Z0(Fragment fragment, String[] strArr, int i10) {
        if (this.f9970F != null) {
            this.f9971G.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
            this.f9970F.a(strArr);
            return;
        }
        this.f10004v.k(fragment, strArr, i10);
    }

    public void a1(Fragment fragment, Intent intent, int i10, Bundle bundle) {
        if (this.f9968D != null) {
            this.f9971G.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
            if (intent != null && bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.f9968D.a(intent);
            return;
        }
        this.f10004v.m(fragment, intent, i10, bundle);
    }

    public final void b0() {
        Iterator<SpecialEffectsController> it = w().iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    public void b1(Fragment fragment, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        Intent intent2;
        if (this.f9969E != null) {
            if (bundle != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (M0(2)) {
                    Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            } else {
                intent2 = intent;
            }
            IntentSenderRequest a10 = new IntentSenderRequest.a(intentSender).b(intent2).c(i12, i11).a();
            this.f9971G.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
            if (M0(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.f9969E.a(a10);
            return;
        }
        this.f10004v.n(fragment, intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public void c0(n nVar, boolean z10) {
        if (!z10) {
            if (this.f10004v == null) {
                if (this.f9975K) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            r();
        }
        synchronized (this.f9983a) {
            try {
                if (this.f10004v == null) {
                    if (z10) {
                    } else {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f9983a.add(nVar);
                    y1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c1(int i10, boolean z10) {
        androidx.fragment.app.l<?> lVar;
        if (this.f10004v == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (!z10 && i10 == this.f10003u) {
            return;
        }
        this.f10003u = i10;
        this.f9985c.t();
        G1();
        if (this.f9972H && (lVar = this.f10004v) != null && this.f10003u == 7) {
            lVar.o();
            this.f9972H = false;
        }
    }

    public final void d0(boolean z10) {
        if (!this.f9984b) {
            if (this.f10004v == null) {
                if (this.f9975K) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            if (Looper.myLooper() == this.f10004v.g().getLooper()) {
                if (!z10) {
                    r();
                }
                if (this.f9977M == null) {
                    this.f9977M = new ArrayList<>();
                    this.f9978N = new ArrayList<>();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    public void d1() {
        if (this.f10004v == null) {
            return;
        }
        this.f9973I = false;
        this.f9974J = false;
        this.f9980P.r(false);
        for (Fragment fragment : this.f9985c.o()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public boolean e0(boolean z10) {
        d0(z10);
        boolean z11 = false;
        while (r0(this.f9977M, this.f9978N)) {
            z11 = true;
            this.f9984b = true;
            try {
                p1(this.f9977M, this.f9978N);
            } finally {
                s();
            }
        }
        J1();
        Y();
        this.f9985c.b();
        return z11;
    }

    public void e1(FragmentContainerView fragmentContainerView) {
        View view;
        for (y yVar : this.f9985c.k()) {
            Fragment k10 = yVar.k();
            if (k10.mContainerId == fragmentContainerView.getId() && (view = k10.mView) != null && view.getParent() == null) {
                k10.mContainer = fragmentContainerView;
                yVar.b();
            }
        }
    }

    public void f0(n nVar, boolean z10) {
        if (z10 && (this.f10004v == null || this.f9975K)) {
            return;
        }
        d0(z10);
        if (nVar.a(this.f9977M, this.f9978N)) {
            this.f9984b = true;
            try {
                p1(this.f9977M, this.f9978N);
            } finally {
                s();
            }
        }
        J1();
        Y();
        this.f9985c.b();
    }

    public void f1(y yVar) {
        Fragment k10 = yVar.k();
        if (k10.mDeferStart) {
            if (this.f9984b) {
                this.f9976L = true;
            } else {
                k10.mDeferStart = false;
                yVar.m();
            }
        }
    }

    public void g1(int i10, int i11, boolean z10) {
        if (i10 >= 0) {
            c0(new o(null, i10, i11), z10);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public final void h0(ArrayList<C0470a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        boolean z10 = arrayList.get(i10).f9863r;
        ArrayList<Fragment> arrayList3 = this.f9979O;
        if (arrayList3 == null) {
            this.f9979O = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.f9979O.addAll(this.f9985c.o());
        Fragment D02 = D0();
        boolean z11 = false;
        for (int i12 = i10; i12 < i11; i12++) {
            C0470a c0470a = arrayList.get(i12);
            if (!arrayList2.get(i12).booleanValue()) {
                D02 = c0470a.F(this.f9979O, D02);
            } else {
                D02 = c0470a.I(this.f9979O, D02);
            }
            if (!z11 && !c0470a.f9854i) {
                z11 = false;
            } else {
                z11 = true;
            }
        }
        this.f9979O.clear();
        if (!z10 && this.f10003u >= 1) {
            for (int i13 = i10; i13 < i11; i13++) {
                Iterator<B.a> it = arrayList.get(i13).f9848c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().f9866b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.f9985c.r(y(fragment));
                    }
                }
            }
        }
        g0(arrayList, arrayList2, i10, i11);
        boolean booleanValue = arrayList2.get(i11 - 1).booleanValue();
        for (int i14 = i10; i14 < i11; i14++) {
            C0470a c0470a2 = arrayList.get(i14);
            if (booleanValue) {
                for (int size = c0470a2.f9848c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = c0470a2.f9848c.get(size).f9866b;
                    if (fragment2 != null) {
                        y(fragment2).m();
                    }
                }
            } else {
                Iterator<B.a> it2 = c0470a2.f9848c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = it2.next().f9866b;
                    if (fragment3 != null) {
                        y(fragment3).m();
                    }
                }
            }
        }
        c1(this.f10003u, true);
        for (SpecialEffectsController specialEffectsController : x(arrayList, i10, i11)) {
            specialEffectsController.r(booleanValue);
            specialEffectsController.p();
            specialEffectsController.g();
        }
        while (i10 < i11) {
            C0470a c0470a3 = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue() && c0470a3.f10106v >= 0) {
                c0470a3.f10106v = -1;
            }
            c0470a3.H();
            i10++;
        }
        if (z11) {
            r1();
        }
    }

    public boolean h1() {
        return j1(null, -1, 0);
    }

    public void i(C0470a c0470a) {
        if (this.f9986d == null) {
            this.f9986d = new ArrayList<>();
        }
        this.f9986d.add(c0470a);
    }

    public boolean i0() {
        boolean e02 = e0(true);
        q0();
        return e02;
    }

    public boolean i1(int i10, int i11) {
        if (i10 >= 0) {
            return j1(null, i10, i11);
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public y j(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.f(fragment, str);
        }
        if (M0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        y y10 = y(fragment);
        fragment.mFragmentManager = this;
        this.f9985c.r(y10);
        if (!fragment.mDetached) {
            this.f9985c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (N0(fragment)) {
                this.f9972H = true;
            }
        }
        return y10;
    }

    public Fragment j0(String str) {
        return this.f9985c.f(str);
    }

    public final boolean j1(String str, int i10, int i11) {
        e0(false);
        d0(true);
        Fragment fragment = this.f10007y;
        if (fragment != null && i10 < 0 && str == null && fragment.getChildFragmentManager().h1()) {
            return true;
        }
        boolean k12 = k1(this.f9977M, this.f9978N, str, i10, i11);
        if (k12) {
            this.f9984b = true;
            try {
                p1(this.f9977M, this.f9978N);
            } finally {
                s();
            }
        }
        J1();
        Y();
        this.f9985c.b();
        return k12;
    }

    public void k(v vVar) {
        this.f9997o.add(vVar);
    }

    public final int k0(String str, int i10, boolean z10) {
        ArrayList<C0470a> arrayList = this.f9986d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i10 < 0) {
            if (z10) {
                return 0;
            }
            return this.f9986d.size() - 1;
        }
        int size = this.f9986d.size() - 1;
        while (size >= 0) {
            C0470a c0470a = this.f9986d.get(size);
            if ((str != null && str.equals(c0470a.G())) || (i10 >= 0 && i10 == c0470a.f10106v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (z10) {
            while (size > 0) {
                C0470a c0470a2 = this.f9986d.get(size - 1);
                if ((str != null && str.equals(c0470a2.G())) || (i10 >= 0 && i10 == c0470a2.f10106v)) {
                    size--;
                } else {
                    return size;
                }
            }
            return size;
        }
        if (size == this.f9986d.size() - 1) {
            return -1;
        }
        return size + 1;
    }

    public boolean k1(ArrayList<C0470a> arrayList, ArrayList<Boolean> arrayList2, String str, int i10, int i11) {
        boolean z10;
        if ((i11 & 1) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int k02 = k0(str, i10, z10);
        if (k02 < 0) {
            return false;
        }
        for (int size = this.f9986d.size() - 1; size >= k02; size--) {
            arrayList.add(this.f9986d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public void l(Fragment fragment) {
        this.f9980P.g(fragment);
    }

    public Fragment l0(int i10) {
        return this.f9985c.g(i10);
    }

    public void l1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            H1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public int m() {
        return this.f9991i.getAndIncrement();
    }

    public Fragment m0(String str) {
        return this.f9985c.h(str);
    }

    public void m1(k kVar, boolean z10) {
        this.f9996n.o(kVar, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(androidx.fragment.app.l<?> lVar, androidx.fragment.app.i iVar, Fragment fragment) {
        String str;
        if (this.f10004v == null) {
            this.f10004v = lVar;
            this.f10005w = iVar;
            this.f10006x = fragment;
            if (fragment != null) {
                k(new g(fragment));
            } else if (lVar instanceof v) {
                k((v) lVar);
            }
            if (this.f10006x != null) {
                J1();
            }
            if (lVar instanceof androidx.activity.p) {
                androidx.activity.p pVar = (androidx.activity.p) lVar;
                OnBackPressedDispatcher onBackPressedDispatcher = pVar.getOnBackPressedDispatcher();
                this.f9989g = onBackPressedDispatcher;
                InterfaceC0492o interfaceC0492o = pVar;
                if (fragment != null) {
                    interfaceC0492o = fragment;
                }
                onBackPressedDispatcher.i(interfaceC0492o, this.f9990h);
            }
            if (fragment != null) {
                this.f9980P = fragment.mFragmentManager.t0(fragment);
            } else if (lVar instanceof N) {
                this.f9980P = FragmentManagerViewModel.m(((N) lVar).getViewModelStore());
            } else {
                this.f9980P = new FragmentManagerViewModel(false);
            }
            this.f9980P.r(T0());
            this.f9985c.A(this.f9980P);
            Object obj = this.f10004v;
            if ((obj instanceof d0.d) && fragment == null) {
                androidx.savedstate.a savedStateRegistry = ((d0.d) obj).getSavedStateRegistry();
                savedStateRegistry.h("android:support:fragments", new a.c() { // from class: androidx.fragment.app.t
                    @Override // androidx.savedstate.a.c
                    public final Bundle saveState() {
                        Bundle U02;
                        U02 = FragmentManager.this.U0();
                        return U02;
                    }
                });
                Bundle b10 = savedStateRegistry.b("android:support:fragments");
                if (b10 != null) {
                    t1(b10);
                }
            }
            Object obj2 = this.f10004v;
            if (obj2 instanceof androidx.activity.result.c) {
                ActivityResultRegistry activityResultRegistry = ((androidx.activity.result.c) obj2).getActivityResultRegistry();
                if (fragment != null) {
                    str = fragment.mWho + ":";
                } else {
                    str = "";
                }
                String str2 = "FragmentManager:" + str;
                this.f9968D = activityResultRegistry.j(str2 + "StartActivityForResult", new C0543d(), new h());
                this.f9969E = activityResultRegistry.j(str2 + "StartIntentSenderForResult", new j(), new i());
                this.f9970F = activityResultRegistry.j(str2 + "RequestPermissions", new C0541b(), new a());
            }
            Object obj3 = this.f10004v;
            if (obj3 instanceof androidx.core.content.c) {
                ((androidx.core.content.c) obj3).addOnConfigurationChangedListener(this.f9998p);
            }
            Object obj4 = this.f10004v;
            if (obj4 instanceof androidx.core.content.d) {
                ((androidx.core.content.d) obj4).addOnTrimMemoryListener(this.f9999q);
            }
            Object obj5 = this.f10004v;
            if (obj5 instanceof androidx.core.app.j) {
                ((androidx.core.app.j) obj5).addOnMultiWindowModeChangedListener(this.f10000r);
            }
            Object obj6 = this.f10004v;
            if (obj6 instanceof androidx.core.app.k) {
                ((androidx.core.app.k) obj6).addOnPictureInPictureModeChangedListener(this.f10001s);
            }
            Object obj7 = this.f10004v;
            if ((obj7 instanceof InterfaceC0459n) && fragment == null) {
                ((InterfaceC0459n) obj7).addMenuProvider(this.f10002t);
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public Fragment n0(String str) {
        return this.f9985c.i(str);
    }

    public void n1(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z10 = !fragment.isInBackStack();
        if (!fragment.mDetached || z10) {
            this.f9985c.u(fragment);
            if (N0(fragment)) {
                this.f9972H = true;
            }
            fragment.mRemoving = true;
            E1(fragment);
        }
    }

    public void o(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f9985c.a(fragment);
                if (M0(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (N0(fragment)) {
                    this.f9972H = true;
                }
            }
        }
    }

    public void o1(v vVar) {
        this.f9997o.remove(vVar);
    }

    public B p() {
        return new C0470a(this);
    }

    public final void p1(ArrayList<C0470a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == arrayList2.size()) {
            int size = arrayList.size();
            int i10 = 0;
            int i11 = 0;
            while (i10 < size) {
                if (!arrayList.get(i10).f9863r) {
                    if (i11 != i10) {
                        h0(arrayList, arrayList2, i11, i10);
                    }
                    i11 = i10 + 1;
                    if (arrayList2.get(i10).booleanValue()) {
                        while (i11 < size && arrayList2.get(i11).booleanValue() && !arrayList.get(i11).f9863r) {
                            i11++;
                        }
                    }
                    h0(arrayList, arrayList2, i10, i11);
                    i10 = i11 - 1;
                }
                i10++;
            }
            if (i11 != size) {
                h0(arrayList, arrayList2, i11, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    public boolean q() {
        boolean z10 = false;
        for (Fragment fragment : this.f9985c.l()) {
            if (fragment != null) {
                z10 = N0(fragment);
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public final void q0() {
        Iterator<SpecialEffectsController> it = w().iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    public void q1(Fragment fragment) {
        this.f9980P.q(fragment);
    }

    public final void r() {
        if (!T0()) {
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final boolean r0(ArrayList<C0470a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f9983a) {
            if (this.f9983a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f9983a.size();
                boolean z10 = false;
                for (int i10 = 0; i10 < size; i10++) {
                    z10 |= this.f9983a.get(i10).a(arrayList, arrayList2);
                }
                return z10;
            } finally {
                this.f9983a.clear();
                this.f10004v.g().removeCallbacks(this.f9982R);
            }
        }
    }

    public final void r1() {
        if (this.f9995m != null) {
            for (int i10 = 0; i10 < this.f9995m.size(); i10++) {
                this.f9995m.get(i10).a();
            }
        }
    }

    public final void s() {
        this.f9984b = false;
        this.f9978N.clear();
        this.f9977M.clear();
    }

    public int s0() {
        ArrayList<C0470a> arrayList = this.f9986d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void s1(Parcelable parcelable) {
        if (this.f10004v instanceof d0.d) {
            H1(new IllegalStateException("You cannot use restoreSaveState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        t1(parcelable);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t() {
        /*
            r4 = this;
            androidx.fragment.app.l<?> r0 = r4.f10004v
            boolean r1 = r0 instanceof androidx.lifecycle.N
            if (r1 == 0) goto L11
            androidx.fragment.app.A r0 = r4.f9985c
            androidx.fragment.app.FragmentManagerViewModel r0 = r0.p()
            boolean r0 = r0.p()
            goto L27
        L11:
            android.content.Context r0 = r0.f()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L29
            androidx.fragment.app.l<?> r0 = r4.f10004v
            android.content.Context r0 = r0.f()
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            r0 = r0 ^ 1
        L27:
            if (r0 == 0) goto L5b
        L29:
            java.util.Map<java.lang.String, androidx.fragment.app.BackStackState> r0 = r4.f9992j
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L33:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L5b
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.BackStackState r1 = (androidx.fragment.app.BackStackState) r1
            java.util.List<java.lang.String> r1 = r1.f9888a
            java.util.Iterator r1 = r1.iterator()
        L45:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L33
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            androidx.fragment.app.A r3 = r4.f9985c
            androidx.fragment.app.FragmentManagerViewModel r3 = r3.p()
            r3.i(r2)
            goto L45
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.t():void");
    }

    public final FragmentManagerViewModel t0(Fragment fragment) {
        return this.f9980P.l(fragment);
    }

    public void t1(Parcelable parcelable) {
        y yVar;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f10004v.f().getClassLoader());
                this.f9993k.put(str.substring(7), bundle2);
            }
        }
        ArrayList<FragmentState> arrayList = new ArrayList<>();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f10004v.f().getClassLoader());
                arrayList.add((FragmentState) bundle.getParcelable("state"));
            }
        }
        this.f9985c.x(arrayList);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        this.f9985c.v();
        Iterator<String> it = fragmentManagerState.f10032a.iterator();
        while (it.hasNext()) {
            FragmentState B10 = this.f9985c.B(it.next(), null);
            if (B10 != null) {
                Fragment k10 = this.f9980P.k(B10.f10049b);
                if (k10 != null) {
                    if (M0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + k10);
                    }
                    yVar = new y(this.f9996n, this.f9985c, k10, B10);
                } else {
                    yVar = new y(this.f9996n, this.f9985c, this.f10004v.f().getClassLoader(), x0(), B10);
                }
                Fragment k11 = yVar.k();
                k11.mFragmentManager = this;
                if (M0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + k11.mWho + "): " + k11);
                }
                yVar.o(this.f10004v.f().getClassLoader());
                this.f9985c.r(yVar);
                yVar.u(this.f10003u);
            }
        }
        for (Fragment fragment : this.f9980P.n()) {
            if (!this.f9985c.c(fragment.mWho)) {
                if (M0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.f10032a);
                }
                this.f9980P.q(fragment);
                fragment.mFragmentManager = this;
                y yVar2 = new y(this.f9996n, this.f9985c, fragment);
                yVar2.u(1);
                yVar2.m();
                fragment.mRemoving = true;
                yVar2.m();
            }
        }
        this.f9985c.w(fragmentManagerState.f10033b);
        if (fragmentManagerState.f10034c != null) {
            this.f9986d = new ArrayList<>(fragmentManagerState.f10034c.length);
            int i10 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f10034c;
                if (i10 >= backStackRecordStateArr.length) {
                    break;
                }
                C0470a d10 = backStackRecordStateArr[i10].d(this);
                if (M0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i10 + " (index " + d10.f10106v + "): " + d10);
                    PrintWriter printWriter = new PrintWriter(new G("FragmentManager"));
                    d10.C("  ", printWriter, false);
                    printWriter.close();
                }
                this.f9986d.add(d10);
                i10++;
            }
        } else {
            this.f9986d = null;
        }
        this.f9991i.set(fragmentManagerState.f10035d);
        String str3 = fragmentManagerState.f10036e;
        if (str3 != null) {
            Fragment j02 = j0(str3);
            this.f10007y = j02;
            O(j02);
        }
        ArrayList<String> arrayList2 = fragmentManagerState.f10037f;
        if (arrayList2 != null) {
            for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                this.f9992j.put(arrayList2.get(i11), fragmentManagerState.f10038g.get(i11));
            }
        }
        this.f9971G = new ArrayDeque<>(fragmentManagerState.f10039h);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f10006x;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f10006x)));
            sb.append("}");
        } else {
            androidx.fragment.app.l<?> lVar = this.f10004v;
            if (lVar != null) {
                sb.append(lVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f10004v)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(String str) {
        this.f9993k.remove(str);
        if (M0(2)) {
            Log.v("FragmentManager", "Clearing fragment result with key " + str);
        }
    }

    public androidx.fragment.app.i u0() {
        return this.f10005w;
    }

    public final void v(String str) {
        l remove = this.f9994l.remove(str);
        if (remove != null) {
            remove.c();
        }
        if (M0(2)) {
            Log.v("FragmentManager", "Clearing FragmentResultListener for key " + str);
        }
    }

    public Fragment v0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment j02 = j0(string);
        if (j02 == null) {
            H1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return j02;
    }

    public Parcelable v1() {
        if (this.f10004v instanceof d0.d) {
            H1(new IllegalStateException("You cannot use saveAllState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        Bundle U02 = U0();
        if (U02.isEmpty()) {
            return null;
        }
        return U02;
    }

    public final Set<SpecialEffectsController> w() {
        HashSet hashSet = new HashSet();
        Iterator<y> it = this.f9985c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().k().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.o(viewGroup, E0()));
            }
        }
        return hashSet;
    }

    public final ViewGroup w0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f10005w.d()) {
            View c10 = this.f10005w.c(fragment.mContainerId);
            if (c10 instanceof ViewGroup) {
                return (ViewGroup) c10;
            }
        }
        return null;
    }

    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public Bundle U0() {
        BackStackRecordState[] backStackRecordStateArr;
        int size;
        Bundle bundle = new Bundle();
        q0();
        b0();
        e0(true);
        this.f9973I = true;
        this.f9980P.r(true);
        ArrayList<String> y10 = this.f9985c.y();
        ArrayList<FragmentState> m10 = this.f9985c.m();
        if (m10.isEmpty()) {
            if (M0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
        } else {
            ArrayList<String> z10 = this.f9985c.z();
            ArrayList<C0470a> arrayList = this.f9986d;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i10 = 0; i10 < size; i10++) {
                    backStackRecordStateArr[i10] = new BackStackRecordState(this.f9986d.get(i10));
                    if (M0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i10 + ": " + this.f9986d.get(i10));
                    }
                }
            } else {
                backStackRecordStateArr = null;
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f10032a = y10;
            fragmentManagerState.f10033b = z10;
            fragmentManagerState.f10034c = backStackRecordStateArr;
            fragmentManagerState.f10035d = this.f9991i.get();
            Fragment fragment = this.f10007y;
            if (fragment != null) {
                fragmentManagerState.f10036e = fragment.mWho;
            }
            fragmentManagerState.f10037f.addAll(this.f9992j.keySet());
            fragmentManagerState.f10038g.addAll(this.f9992j.values());
            fragmentManagerState.f10039h = new ArrayList<>(this.f9971G);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.f9993k.keySet()) {
                bundle.putBundle("result_" + str, this.f9993k.get(str));
            }
            Iterator<FragmentState> it = m10.iterator();
            while (it.hasNext()) {
                FragmentState next = it.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", next);
                bundle.putBundle("fragment_" + next.f10049b, bundle2);
            }
        }
        return bundle;
    }

    public final Set<SpecialEffectsController> x(ArrayList<C0470a> arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator<B.a> it = arrayList.get(i10).f9848c.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f9866b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(SpecialEffectsController.n(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    public androidx.fragment.app.k x0() {
        androidx.fragment.app.k kVar = this.f10008z;
        if (kVar != null) {
            return kVar;
        }
        Fragment fragment = this.f10006x;
        if (fragment != null) {
            return fragment.mFragmentManager.x0();
        }
        return this.f9965A;
    }

    public Fragment.SavedState x1(Fragment fragment) {
        y n10 = this.f9985c.n(fragment.mWho);
        if (n10 == null || !n10.k().equals(fragment)) {
            H1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return n10.r();
    }

    public y y(Fragment fragment) {
        y n10 = this.f9985c.n(fragment.mWho);
        if (n10 != null) {
            return n10;
        }
        y yVar = new y(this.f9996n, this.f9985c, fragment);
        yVar.o(this.f10004v.f().getClassLoader());
        yVar.u(this.f10003u);
        return yVar;
    }

    public List<Fragment> y0() {
        return this.f9985c.o();
    }

    public void y1() {
        synchronized (this.f9983a) {
            try {
                if (this.f9983a.size() == 1) {
                    this.f10004v.g().removeCallbacks(this.f9982R);
                    this.f10004v.g().post(this.f9982R);
                    J1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void z(Fragment fragment) {
        if (M0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (M0(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.f9985c.u(fragment);
                if (N0(fragment)) {
                    this.f9972H = true;
                }
                E1(fragment);
            }
        }
    }

    public androidx.fragment.app.l<?> z0() {
        return this.f10004v;
    }

    public void z1(Fragment fragment, boolean z10) {
        ViewGroup w02 = w0(fragment);
        if (w02 != null && (w02 instanceof FragmentContainerView)) {
            ((FragmentContainerView) w02).setDrawDisappearingViewsLast(!z10);
        }
    }

    /* loaded from: classes.dex */
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public String f10013a;

        /* renamed from: b, reason: collision with root package name */
        public int f10014b;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i10) {
                return new LaunchedFragmentInfo[i10];
            }
        }

        public LaunchedFragmentInfo(String str, int i10) {
            this.f10013a = str;
            this.f10014b = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f10013a);
            parcel.writeInt(this.f10014b);
        }

        public LaunchedFragmentInfo(Parcel parcel) {
            this.f10013a = parcel.readString();
            this.f10014b = parcel.readInt();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class k {
        public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }

        @Deprecated
        public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }
    }
}
