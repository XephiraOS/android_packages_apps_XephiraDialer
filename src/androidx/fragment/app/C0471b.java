package androidx.fragment.app;

import F.d;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.K;
import androidx.core.view.M;
import androidx.fragment.app.C0477h;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p.C1415a;

/* compiled from: DefaultSpecialEffectsController.java */
/* renamed from: androidx.fragment.app.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0471b extends SpecialEffectsController {

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10108a;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            f10108a = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10108a[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10108a[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10108a[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0122b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f10109a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f10110b;

        public RunnableC0122b(List list, SpecialEffectsController.Operation operation) {
            this.f10109a = list;
            this.f10110b = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10109a.contains(this.f10110b)) {
                this.f10109a.remove(this.f10110b);
                C0471b.this.s(this.f10110b);
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$c */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f10112a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f10113b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f10114c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f10115d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ k f10116e;

        public c(ViewGroup viewGroup, View view, boolean z10, SpecialEffectsController.Operation operation, k kVar) {
            this.f10112a = viewGroup;
            this.f10113b = view;
            this.f10114c = z10;
            this.f10115d = operation;
            this.f10116e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f10112a.endViewTransition(this.f10113b);
            if (this.f10114c) {
                this.f10115d.e().a(this.f10113b);
            }
            this.f10116e.a();
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f10115d + " has ended.");
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$d */
    /* loaded from: classes.dex */
    public class d implements d.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator f10118a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f10119b;

        public d(Animator animator, SpecialEffectsController.Operation operation) {
            this.f10118a = animator;
            this.f10119b = operation;
        }

        @Override // F.d.a
        public void onCancel() {
            this.f10118a.end();
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.f10119b + " has been canceled.");
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$f */
    /* loaded from: classes.dex */
    public class f implements d.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f10127a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f10128b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f10129c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f10130d;

        public f(View view, ViewGroup viewGroup, k kVar, SpecialEffectsController.Operation operation) {
            this.f10127a = view;
            this.f10128b = viewGroup;
            this.f10129c = kVar;
            this.f10130d = operation;
        }

        @Override // F.d.a
        public void onCancel() {
            this.f10127a.clearAnimation();
            this.f10128b.endViewTransition(this.f10127a);
            this.f10129c.a();
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f10130d + " has been cancelled.");
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$g */
    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f10132a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f10133b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f10134c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ C1415a f10135d;

        public g(SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean z10, C1415a c1415a) {
            this.f10132a = operation;
            this.f10133b = operation2;
            this.f10134c = z10;
            this.f10135d = c1415a;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.a(this.f10132a.f(), this.f10133b.f(), this.f10134c, this.f10135d, false);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$h */
    /* loaded from: classes.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ E f10137a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f10138b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f10139c;

        public h(E e10, View view, Rect rect) {
            this.f10137a = e10;
            this.f10138b = view;
            this.f10139c = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10137a.h(this.f10138b, this.f10139c);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$i */
    /* loaded from: classes.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f10141a;

        public i(ArrayList arrayList) {
            this.f10141a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            C.d(this.f10141a, 4);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$j */
    /* loaded from: classes.dex */
    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f10143a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f10144b;

        public j(m mVar, SpecialEffectsController.Operation operation) {
            this.f10143a = mVar;
            this.f10144b = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10143a.a();
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Transition for operation " + this.f10144b + "has completed");
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$k */
    /* loaded from: classes.dex */
    public static class k extends l {

        /* renamed from: c, reason: collision with root package name */
        public boolean f10146c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10147d;

        /* renamed from: e, reason: collision with root package name */
        public C0477h.a f10148e;

        public k(SpecialEffectsController.Operation operation, F.d dVar, boolean z10) {
            super(operation, dVar);
            this.f10147d = false;
            this.f10146c = z10;
        }

        public C0477h.a e(Context context) {
            boolean z10;
            if (this.f10147d) {
                return this.f10148e;
            }
            Fragment f10 = b().f();
            if (b().e() == SpecialEffectsController.Operation.State.VISIBLE) {
                z10 = true;
            } else {
                z10 = false;
            }
            C0477h.a b10 = C0477h.b(context, f10, z10, this.f10146c);
            this.f10148e = b10;
            this.f10147d = true;
            return b10;
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$l */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public final SpecialEffectsController.Operation f10149a;

        /* renamed from: b, reason: collision with root package name */
        public final F.d f10150b;

        public l(SpecialEffectsController.Operation operation, F.d dVar) {
            this.f10149a = operation;
            this.f10150b = dVar;
        }

        public void a() {
            this.f10149a.d(this.f10150b);
        }

        public SpecialEffectsController.Operation b() {
            return this.f10149a;
        }

        public F.d c() {
            return this.f10150b;
        }

        public boolean d() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State c10 = SpecialEffectsController.Operation.State.c(this.f10149a.f().mView);
            SpecialEffectsController.Operation.State e10 = this.f10149a.e();
            if (c10 != e10 && (c10 == (state = SpecialEffectsController.Operation.State.VISIBLE) || e10 == state)) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$m */
    /* loaded from: classes.dex */
    public static class m extends l {

        /* renamed from: c, reason: collision with root package name */
        public final Object f10151c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f10152d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f10153e;

        public m(SpecialEffectsController.Operation operation, F.d dVar, boolean z10, boolean z11) {
            super(operation, dVar);
            Object exitTransition;
            Object enterTransition;
            boolean allowEnterTransitionOverlap;
            if (operation.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z10) {
                    enterTransition = operation.f().getReenterTransition();
                } else {
                    enterTransition = operation.f().getEnterTransition();
                }
                this.f10151c = enterTransition;
                if (z10) {
                    allowEnterTransitionOverlap = operation.f().getAllowReturnTransitionOverlap();
                } else {
                    allowEnterTransitionOverlap = operation.f().getAllowEnterTransitionOverlap();
                }
                this.f10152d = allowEnterTransitionOverlap;
            } else {
                if (z10) {
                    exitTransition = operation.f().getReturnTransition();
                } else {
                    exitTransition = operation.f().getExitTransition();
                }
                this.f10151c = exitTransition;
                this.f10152d = true;
            }
            if (z11) {
                if (z10) {
                    this.f10153e = operation.f().getSharedElementReturnTransition();
                    return;
                } else {
                    this.f10153e = operation.f().getSharedElementEnterTransition();
                    return;
                }
            }
            this.f10153e = null;
        }

        public E e() {
            E f10 = f(this.f10151c);
            E f11 = f(this.f10153e);
            if (f10 != null && f11 != null && f10 != f11) {
                throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f10151c + " which uses a different Transition  type than its shared element transition " + this.f10153e);
            }
            if (f10 == null) {
                return f11;
            }
            return f10;
        }

        public final E f(Object obj) {
            if (obj == null) {
                return null;
            }
            E e10 = C.f9890a;
            if (e10 != null && e10.e(obj)) {
                return e10;
            }
            E e11 = C.f9891b;
            if (e11 != null && e11.e(obj)) {
                return e11;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        public Object g() {
            return this.f10153e;
        }

        public Object h() {
            return this.f10151c;
        }

        public boolean i() {
            if (this.f10153e != null) {
                return true;
            }
            return false;
        }

        public boolean j() {
            return this.f10152d;
        }
    }

    public C0471b(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void f(List<SpecialEffectsController.Operation> list, boolean z10) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State c10 = SpecialEffectsController.Operation.State.c(operation3.f().mView);
            int i10 = a.f10108a[operation3.e().ordinal()];
            if (i10 != 1 && i10 != 2 && i10 != 3) {
                if (i10 == 4 && c10 != SpecialEffectsController.Operation.State.VISIBLE) {
                    operation2 = operation3;
                }
            } else if (c10 == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                operation = operation3;
            }
        }
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Executing operations from " + operation + " to " + operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        y(list);
        for (SpecialEffectsController.Operation operation4 : list) {
            F.d dVar = new F.d();
            operation4.j(dVar);
            arrayList.add(new k(operation4, dVar, z10));
            F.d dVar2 = new F.d();
            operation4.j(dVar2);
            boolean z11 = false;
            if (z10) {
                if (operation4 != operation) {
                    arrayList2.add(new m(operation4, dVar2, z10, z11));
                    operation4.a(new RunnableC0122b(arrayList3, operation4));
                }
                z11 = true;
                arrayList2.add(new m(operation4, dVar2, z10, z11));
                operation4.a(new RunnableC0122b(arrayList3, operation4));
            } else {
                if (operation4 != operation2) {
                    arrayList2.add(new m(operation4, dVar2, z10, z11));
                    operation4.a(new RunnableC0122b(arrayList3, operation4));
                }
                z11 = true;
                arrayList2.add(new m(operation4, dVar2, z10, z11));
                operation4.a(new RunnableC0122b(arrayList3, operation4));
            }
        }
        Map<SpecialEffectsController.Operation, Boolean> x10 = x(arrayList2, arrayList3, z10, operation, operation2);
        w(arrayList, arrayList3, x10.containsValue(Boolean.TRUE), x10);
        Iterator<SpecialEffectsController.Operation> it = arrayList3.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        arrayList3.clear();
        if (FragmentManager.M0(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + operation + " to " + operation2);
        }
    }

    public void s(SpecialEffectsController.Operation operation) {
        operation.e().a(operation.f().mView);
    }

    public void t(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (M.a(viewGroup)) {
                if (!arrayList.contains(view)) {
                    arrayList.add(viewGroup);
                    return;
                }
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    t(arrayList, childAt);
                }
            }
            return;
        }
        if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public void u(Map<String, View> map, View view) {
        String E10 = K.E(view);
        if (E10 != null) {
            map.put(E10, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    public void v(C1415a<String, View> c1415a, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = c1415a.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(K.E(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    public final void w(List<k> list, List<SpecialEffectsController.Operation> list2, boolean z10, Map<SpecialEffectsController.Operation, Boolean> map) {
        int i10;
        boolean z11;
        Context context;
        View view;
        int i11;
        boolean z12;
        SpecialEffectsController.Operation operation;
        ViewGroup m10 = m();
        Context context2 = m10.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<k> it = list.iterator();
        boolean z13 = false;
        while (true) {
            i10 = 2;
            if (!it.hasNext()) {
                break;
            }
            k next = it.next();
            if (next.d()) {
                next.a();
            } else {
                C0477h.a e10 = next.e(context2);
                if (e10 == null) {
                    next.a();
                } else {
                    Animator animator = e10.f10165b;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        SpecialEffectsController.Operation b10 = next.b();
                        Fragment f10 = b10.f();
                        if (Boolean.TRUE.equals(map.get(b10))) {
                            if (FragmentManager.M0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + f10 + " as this Fragment was involved in a Transition.");
                            }
                            next.a();
                        } else {
                            if (b10.e() == SpecialEffectsController.Operation.State.GONE) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                                list2.remove(b10);
                            }
                            View view2 = f10.mView;
                            m10.startViewTransition(view2);
                            animator.addListener(new c(m10, view2, z12, b10, next));
                            animator.setTarget(view2);
                            animator.start();
                            if (FragmentManager.M0(2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Animator from operation ");
                                operation = b10;
                                sb.append(operation);
                                sb.append(" has started.");
                                Log.v("FragmentManager", sb.toString());
                            } else {
                                operation = b10;
                            }
                            next.c().c(new d(animator, operation));
                            z13 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k kVar = (k) it2.next();
            SpecialEffectsController.Operation b11 = kVar.b();
            Fragment f11 = b11.f();
            if (z10) {
                if (FragmentManager.M0(i10)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f11 + " as Animations cannot run alongside Transitions.");
                }
                kVar.a();
            } else if (z13) {
                if (FragmentManager.M0(i10)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + f11 + " as Animations cannot run alongside Animators.");
                }
                kVar.a();
            } else {
                View view3 = f11.mView;
                Animation animation = (Animation) I.h.e(((C0477h.a) I.h.e(kVar.e(context2))).f10164a);
                if (b11.e() != SpecialEffectsController.Operation.State.REMOVED) {
                    view3.startAnimation(animation);
                    kVar.a();
                    z11 = z13;
                    context = context2;
                    i11 = i10;
                    view = view3;
                } else {
                    m10.startViewTransition(view3);
                    C0477h.b bVar = new C0477h.b(animation, m10, view3);
                    z11 = z13;
                    context = context2;
                    view = view3;
                    bVar.setAnimationListener(new e(b11, m10, view3, kVar));
                    view.startAnimation(bVar);
                    i11 = 2;
                    if (FragmentManager.M0(2)) {
                        Log.v("FragmentManager", "Animation from operation " + b11 + " has started.");
                    }
                }
                kVar.c().c(new f(view, m10, kVar, b11));
                i10 = i11;
                z13 = z11;
                context2 = context;
            }
        }
    }

    public final Map<SpecialEffectsController.Operation, Boolean> x(List<m> list, List<SpecialEffectsController.Operation> list2, boolean z10, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2) {
        String str;
        boolean z11;
        String str2;
        boolean z12;
        String str3;
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        HashMap hashMap;
        View view2;
        Object k10;
        C1415a c1415a;
        ArrayList<View> arrayList3;
        SpecialEffectsController.Operation operation3;
        ArrayList<View> arrayList4;
        Rect rect;
        E e10;
        HashMap hashMap2;
        SpecialEffectsController.Operation operation4;
        View view3;
        View view4;
        View view5;
        boolean z13 = z10;
        SpecialEffectsController.Operation operation5 = operation;
        SpecialEffectsController.Operation operation6 = operation2;
        HashMap hashMap3 = new HashMap();
        E e11 = null;
        for (m mVar : list) {
            if (!mVar.d()) {
                E e12 = mVar.e();
                if (e11 == null) {
                    e11 = e12;
                } else if (e12 != null && e11 != e12) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (e11 == null) {
            for (m mVar2 : list) {
                hashMap3.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return hashMap3;
        }
        View view6 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList5 = new ArrayList<>();
        ArrayList<View> arrayList6 = new ArrayList<>();
        C1415a c1415a2 = new C1415a();
        Iterator<m> it = list.iterator();
        Object obj3 = null;
        View view7 = null;
        boolean z14 = false;
        while (true) {
            str = "FragmentManager";
            if (!it.hasNext()) {
                break;
            }
            m next = it.next();
            if (next.i() && operation5 != null && operation6 != null) {
                Object u10 = e11.u(e11.f(next.g()));
                ArrayList<String> sharedElementSourceNames = operation2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.f().getSharedElementTargetNames();
                View view8 = view7;
                int i10 = 0;
                while (i10 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i10));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i10));
                    }
                    i10++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.f().getSharedElementTargetNames();
                if (!z13) {
                    operation.f().getExitTransitionCallback();
                    operation2.f().getEnterTransitionCallback();
                } else {
                    operation.f().getEnterTransitionCallback();
                    operation2.f().getExitTransitionCallback();
                }
                int i11 = 0;
                for (int size = sharedElementSourceNames.size(); i11 < size; size = size) {
                    c1415a2.put(sharedElementSourceNames.get(i11), sharedElementTargetNames2.get(i11));
                    i11++;
                }
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for (Iterator<String> it2 = sharedElementTargetNames2.iterator(); it2.hasNext(); it2 = it2) {
                        Log.v("FragmentManager", "Name: " + it2.next());
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for (Iterator<String> it3 = sharedElementSourceNames.iterator(); it3.hasNext(); it3 = it3) {
                        Log.v("FragmentManager", "Name: " + it3.next());
                    }
                }
                C1415a<String, View> c1415a3 = new C1415a<>();
                u(c1415a3, operation.f().mView);
                c1415a3.p(sharedElementSourceNames);
                c1415a2.p(c1415a3.keySet());
                C1415a<String, View> c1415a4 = new C1415a<>();
                u(c1415a4, operation2.f().mView);
                c1415a4.p(sharedElementTargetNames2);
                c1415a4.p(c1415a2.values());
                C.c(c1415a2, c1415a4);
                v(c1415a3, c1415a2.keySet());
                v(c1415a4, c1415a2.values());
                if (c1415a2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    c1415a = c1415a2;
                    arrayList3 = arrayList6;
                    operation3 = operation5;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view6;
                    e10 = e11;
                    view7 = view8;
                    obj3 = null;
                    operation4 = operation2;
                    hashMap2 = hashMap3;
                } else {
                    C.a(operation2.f(), operation.f(), z13, c1415a3, true);
                    HashMap hashMap4 = hashMap3;
                    View view9 = view6;
                    c1415a = c1415a2;
                    ArrayList<View> arrayList8 = arrayList6;
                    androidx.core.view.B.a(m(), new g(operation2, operation, z10, c1415a4));
                    arrayList5.addAll(c1415a3.values());
                    if (!sharedElementSourceNames.isEmpty()) {
                        view7 = c1415a3.get(sharedElementSourceNames.get(0));
                        e11.p(u10, view7);
                    } else {
                        view7 = view8;
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(c1415a4.values());
                    if (!sharedElementTargetNames2.isEmpty() && (view5 = c1415a4.get(sharedElementTargetNames2.get(0))) != null) {
                        androidx.core.view.B.a(m(), new h(e11, view5, rect2));
                        view4 = view9;
                        z14 = true;
                    } else {
                        view4 = view9;
                    }
                    e11.s(u10, view4, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    e10 = e11;
                    e11.n(u10, null, null, null, null, u10, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    operation3 = operation;
                    hashMap2 = hashMap4;
                    hashMap2.put(operation3, bool);
                    operation4 = operation2;
                    hashMap2.put(operation4, bool);
                    obj3 = u10;
                }
            } else {
                c1415a = c1415a2;
                arrayList3 = arrayList6;
                operation3 = operation5;
                arrayList4 = arrayList5;
                rect = rect2;
                e10 = e11;
                hashMap2 = hashMap3;
                View view10 = view6;
                operation4 = operation6;
                view3 = view10;
                view7 = view7;
            }
            operation5 = operation3;
            arrayList5 = arrayList4;
            rect2 = rect;
            hashMap3 = hashMap2;
            c1415a2 = c1415a;
            z13 = z10;
            arrayList6 = arrayList3;
            e11 = e10;
            SpecialEffectsController.Operation operation7 = operation4;
            view6 = view3;
            operation6 = operation7;
        }
        View view11 = view7;
        C1415a c1415a5 = c1415a2;
        ArrayList<View> arrayList9 = arrayList6;
        SpecialEffectsController.Operation operation8 = operation5;
        ArrayList<View> arrayList10 = arrayList5;
        Rect rect3 = rect2;
        E e13 = e11;
        HashMap hashMap5 = hashMap3;
        View view12 = view6;
        SpecialEffectsController.Operation operation9 = operation6;
        View view13 = view12;
        ArrayList arrayList11 = new ArrayList();
        Object obj4 = null;
        Object obj5 = null;
        for (m mVar3 : list) {
            if (mVar3.d()) {
                hashMap5.put(mVar3.b(), Boolean.FALSE);
                mVar3.a();
            } else {
                Object f10 = e13.f(mVar3.h());
                SpecialEffectsController.Operation b10 = mVar3.b();
                if (obj3 != null && (b10 == operation8 || b10 == operation9)) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (f10 == null) {
                    if (!z12) {
                        hashMap5.put(b10, Boolean.FALSE);
                        mVar3.a();
                    }
                    arrayList2 = arrayList9;
                    str3 = str;
                    arrayList = arrayList10;
                    view = view13;
                    k10 = obj4;
                    hashMap = hashMap5;
                    view2 = view11;
                } else {
                    str3 = str;
                    ArrayList<View> arrayList12 = new ArrayList<>();
                    Object obj6 = obj4;
                    t(arrayList12, b10.f().mView);
                    if (z12) {
                        if (b10 == operation8) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        e13.a(f10, view13);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view13;
                        obj2 = obj5;
                        hashMap = hashMap5;
                        obj = obj6;
                    } else {
                        e13.b(f10, arrayList12);
                        view = view13;
                        obj = obj6;
                        arrayList = arrayList10;
                        obj2 = obj5;
                        arrayList2 = arrayList9;
                        hashMap = hashMap5;
                        e13.n(f10, f10, arrayList12, null, null, null, null);
                        if (b10.e() == SpecialEffectsController.Operation.State.GONE) {
                            list2.remove(b10);
                            ArrayList<View> arrayList13 = new ArrayList<>(arrayList12);
                            arrayList13.remove(b10.f().mView);
                            e13.m(f10, b10.f().mView, arrayList13);
                            androidx.core.view.B.a(m(), new i(arrayList12));
                        }
                    }
                    if (b10.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z14) {
                            e13.o(f10, rect3);
                        }
                        view2 = view11;
                    } else {
                        view2 = view11;
                        e13.p(f10, view2);
                    }
                    hashMap.put(b10, Boolean.TRUE);
                    if (mVar3.j()) {
                        obj5 = e13.k(obj2, f10, null);
                        k10 = obj;
                    } else {
                        k10 = e13.k(obj, f10, null);
                        obj5 = obj2;
                    }
                }
                operation9 = operation2;
                hashMap5 = hashMap;
                obj4 = k10;
                view11 = view2;
                str = str3;
                view13 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
            }
        }
        ArrayList<View> arrayList14 = arrayList9;
        String str4 = str;
        ArrayList<View> arrayList15 = arrayList10;
        HashMap hashMap6 = hashMap5;
        Object j10 = e13.j(obj5, obj4, obj3);
        if (j10 == null) {
            return hashMap6;
        }
        for (m mVar4 : list) {
            if (!mVar4.d()) {
                Object h10 = mVar4.h();
                SpecialEffectsController.Operation b11 = mVar4.b();
                HashMap hashMap7 = hashMap6;
                if (obj3 != null && (b11 == operation8 || b11 == operation2)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (h10 == null && !z11) {
                    str2 = str4;
                } else if (!K.O(m())) {
                    if (FragmentManager.M0(2)) {
                        str2 = str4;
                        Log.v(str2, "SpecialEffectsController: Container " + m() + " has not been laid out. Completing operation " + b11);
                    } else {
                        str2 = str4;
                    }
                    mVar4.a();
                } else {
                    str2 = str4;
                    e13.q(mVar4.b().f(), j10, mVar4.c(), new j(mVar4, b11));
                }
                hashMap6 = hashMap7;
                str4 = str2;
            }
        }
        HashMap hashMap8 = hashMap6;
        String str5 = str4;
        if (!K.O(m())) {
            return hashMap8;
        }
        C.d(arrayList11, 4);
        ArrayList<String> l10 = e13.l(arrayList14);
        if (FragmentManager.M0(2)) {
            Log.v(str5, ">>>>> Beginning transition <<<<<");
            Log.v(str5, ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator<View> it4 = arrayList15.iterator();
            while (it4.hasNext()) {
                View next2 = it4.next();
                Log.v(str5, "View: " + next2 + " Name: " + K.E(next2));
            }
            Log.v(str5, ">>>>> SharedElementLastInViews <<<<<");
            Iterator<View> it5 = arrayList14.iterator();
            while (it5.hasNext()) {
                View next3 = it5.next();
                Log.v(str5, "View: " + next3 + " Name: " + K.E(next3));
            }
        }
        e13.c(m(), j10);
        e13.r(m(), arrayList15, arrayList14, l10, c1415a5);
        C.d(arrayList11, 0);
        e13.t(obj3, arrayList15, arrayList14);
        return hashMap8;
    }

    public final void y(List<SpecialEffectsController.Operation> list) {
        Fragment f10 = list.get(list.size() - 1).f();
        for (SpecialEffectsController.Operation operation : list) {
            operation.f().mAnimationInfo.f9940c = f10.mAnimationInfo.f9940c;
            operation.f().mAnimationInfo.f9941d = f10.mAnimationInfo.f9941d;
            operation.f().mAnimationInfo.f9942e = f10.mAnimationInfo.f9942e;
            operation.f().mAnimationInfo.f9943f = f10.mAnimationInfo.f9943f;
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: androidx.fragment.app.b$e */
    /* loaded from: classes.dex */
    public class e implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpecialEffectsController.Operation f10121a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f10122b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f10123c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ k f10124d;

        /* compiled from: DefaultSpecialEffectsController.java */
        /* renamed from: androidx.fragment.app.b$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f10122b.endViewTransition(eVar.f10123c);
                e.this.f10124d.a();
            }
        }

        public e(SpecialEffectsController.Operation operation, ViewGroup viewGroup, View view, k kVar) {
            this.f10121a = operation;
            this.f10122b = viewGroup;
            this.f10123c = view;
            this.f10124d = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f10122b.post(new a());
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f10121a + " has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (FragmentManager.M0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.f10121a + " has reached onAnimationStart.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
