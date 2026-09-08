package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p.C1415a;

/* compiled from: TransitionManager.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public static Transition f11751a = new AutoTransition();

    /* renamed from: b, reason: collision with root package name */
    public static ThreadLocal<WeakReference<C1415a<ViewGroup, ArrayList<Transition>>>> f11752b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList<ViewGroup> f11753c = new ArrayList<>();

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (!f11753c.contains(viewGroup) && viewGroup.isLaidOut()) {
            f11753c.add(viewGroup);
            if (transition == null) {
                transition = f11751a;
            }
            Transition mo0clone = transition.mo0clone();
            d(viewGroup, mo0clone);
            p.c(viewGroup, null);
            c(viewGroup, mo0clone);
        }
    }

    public static C1415a<ViewGroup, ArrayList<Transition>> b() {
        C1415a<ViewGroup, ArrayList<Transition>> c1415a;
        WeakReference<C1415a<ViewGroup, ArrayList<Transition>>> weakReference = f11752b.get();
        if (weakReference != null && (c1415a = weakReference.get()) != null) {
            return c1415a;
        }
        C1415a<ViewGroup, ArrayList<Transition>> c1415a2 = new C1415a<>();
        f11752b.set(new WeakReference<>(c1415a2));
        return c1415a2;
    }

    public static void c(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            a aVar = new a(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    public static void d(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.captureValues(viewGroup, true);
        }
        p b10 = p.b(viewGroup);
        if (b10 != null) {
            b10.a();
        }
    }

    /* compiled from: TransitionManager.java */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public Transition f11754a;

        /* renamed from: b, reason: collision with root package name */
        public ViewGroup f11755b;

        /* compiled from: TransitionManager.java */
        /* renamed from: androidx.transition.y$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0142a extends x {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C1415a f11756a;

            public C0142a(C1415a c1415a) {
                this.f11756a = c1415a;
            }

            @Override // androidx.transition.x, androidx.transition.Transition.i
            public void d(Transition transition) {
                ((ArrayList) this.f11756a.get(a.this.f11755b)).remove(transition);
                transition.removeListener(this);
            }
        }

        public a(Transition transition, ViewGroup viewGroup) {
            this.f11754a = transition;
            this.f11755b = viewGroup;
        }

        public final void a() {
            this.f11755b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f11755b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!y.f11753c.remove(this.f11755b)) {
                return true;
            }
            C1415a<ViewGroup, ArrayList<Transition>> b10 = y.b();
            ArrayList<Transition> arrayList = b10.get(this.f11755b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                b10.put(this.f11755b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f11754a);
            this.f11754a.addListener(new C0142a(b10));
            this.f11754a.captureValues(this.f11755b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.f11755b);
                }
            }
            this.f11754a.playTransition(this.f11755b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            y.f11753c.remove(this.f11755b);
            ArrayList<Transition> arrayList = y.b().get(this.f11755b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.f11755b);
                }
            }
            this.f11754a.clearValues(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }
}
