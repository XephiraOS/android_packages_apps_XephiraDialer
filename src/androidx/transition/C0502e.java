package androidx.transition;

import F.d;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FragmentTransitionSupport.java */
/* renamed from: androidx.transition.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0502e extends androidx.fragment.app.E {

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: androidx.transition.e$a */
    /* loaded from: classes.dex */
    public class a extends Transition.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f11699a;

        public a(Rect rect) {
            this.f11699a = rect;
        }

        @Override // androidx.transition.Transition.f
        public Rect a(Transition transition) {
            return this.f11699a;
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: androidx.transition.e$c */
    /* loaded from: classes.dex */
    public class c extends x {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f11704a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11705b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f11706c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11707d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f11708e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11709f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f11704a = obj;
            this.f11705b = arrayList;
            this.f11706c = obj2;
            this.f11707d = arrayList2;
            this.f11708e = obj3;
            this.f11709f = arrayList3;
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void a(Transition transition) {
            Object obj = this.f11704a;
            if (obj != null) {
                C0502e.this.y(obj, this.f11705b, null);
            }
            Object obj2 = this.f11706c;
            if (obj2 != null) {
                C0502e.this.y(obj2, this.f11707d, null);
            }
            Object obj3 = this.f11708e;
            if (obj3 != null) {
                C0502e.this.y(obj3, this.f11709f, null);
            }
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void d(Transition transition) {
            transition.removeListener(this);
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: androidx.transition.e$e, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0141e extends Transition.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f11713a;

        public C0141e(Rect rect) {
            this.f11713a = rect;
        }

        @Override // androidx.transition.Transition.f
        public Rect a(Transition transition) {
            Rect rect = this.f11713a;
            if (rect != null && !rect.isEmpty()) {
                return this.f11713a;
            }
            return null;
        }
    }

    public static boolean w(Transition transition) {
        if (androidx.fragment.app.E.i(transition.getTargetIds()) && androidx.fragment.app.E.i(transition.getTargetNames()) && androidx.fragment.app.E.i(transition.getTargetTypes())) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void x(Runnable runnable, Transition transition, Runnable runnable2) {
        if (runnable == null) {
            transition.cancel();
            runnable2.run();
        } else {
            runnable.run();
        }
    }

    @Override // androidx.fragment.app.E
    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.E
    public void b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i10 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int i11 = transitionSet.i();
            while (i10 < i11) {
                b(transitionSet.h(i10), arrayList);
                i10++;
            }
            return;
        }
        if (!w(transition) && androidx.fragment.app.E.i(transition.getTargets())) {
            int size = arrayList.size();
            while (i10 < size) {
                transition.addTarget(arrayList.get(i10));
                i10++;
            }
        }
    }

    @Override // androidx.fragment.app.E
    public void c(ViewGroup viewGroup, Object obj) {
        y.a(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.E
    public boolean e(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.E
    public Object f(Object obj) {
        if (obj != null) {
            return ((Transition) obj).mo0clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.E
    public Object j(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().f(transition).f(transition2).r(1);
        } else if (transition == null) {
            if (transition2 != null) {
                transition = transition2;
            } else {
                transition = null;
            }
        }
        if (transition3 != null) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.f(transition);
            }
            transitionSet.f(transition3);
            return transitionSet;
        }
        return transition;
    }

    @Override // androidx.fragment.app.E
    public Object k(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.f((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.f((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.f((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.E
    public void m(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.E
    public void n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.E
    public void o(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new C0141e(rect));
        }
    }

    @Override // androidx.fragment.app.E
    public void p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(rect));
        }
    }

    @Override // androidx.fragment.app.E
    public void q(Fragment fragment, Object obj, F.d dVar, Runnable runnable) {
        z(fragment, obj, dVar, null, runnable);
    }

    @Override // androidx.fragment.app.E
    public void s(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            androidx.fragment.app.E.d(targets, arrayList.get(i10));
        }
        targets.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.E
    public void t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            y(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.E
    public Object u(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.f((Transition) obj);
        return transitionSet;
    }

    public void y(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int size;
        Transition transition = (Transition) obj;
        int i10 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int i11 = transitionSet.i();
            while (i10 < i11) {
                y(transitionSet.h(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (!w(transition)) {
            List<View> targets = transition.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    size = 0;
                } else {
                    size = arrayList2.size();
                }
                while (i10 < size) {
                    transition.addTarget(arrayList2.get(i10));
                    i10++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    transition.removeTarget(arrayList.get(size2));
                }
            }
        }
    }

    public void z(Fragment fragment, Object obj, F.d dVar, final Runnable runnable, final Runnable runnable2) {
        final Transition transition = (Transition) obj;
        dVar.c(new d.a() { // from class: androidx.transition.d
            @Override // F.d.a
            public final void onCancel() {
                C0502e.x(runnable, transition, runnable2);
            }
        });
        transition.addListener(new d(runnable2));
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: androidx.transition.e$b */
    /* loaded from: classes.dex */
    public class b implements Transition.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f11701a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11702b;

        public b(View view, ArrayList arrayList) {
            this.f11701a = view;
            this.f11702b = arrayList;
        }

        @Override // androidx.transition.Transition.i
        public void a(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }

        @Override // androidx.transition.Transition.i
        public void d(Transition transition) {
            transition.removeListener(this);
            this.f11701a.setVisibility(8);
            int size = this.f11702b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f11702b.get(i10)).setVisibility(0);
            }
        }

        @Override // androidx.transition.Transition.i
        public void b(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void e(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void g(Transition transition) {
        }
    }

    /* compiled from: FragmentTransitionSupport.java */
    /* renamed from: androidx.transition.e$d */
    /* loaded from: classes.dex */
    public class d implements Transition.i {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f11711a;

        public d(Runnable runnable) {
            this.f11711a = runnable;
        }

        @Override // androidx.transition.Transition.i
        public void d(Transition transition) {
            this.f11711a.run();
        }

        @Override // androidx.transition.Transition.i
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void b(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void e(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void g(Transition transition) {
        }
    }
}
