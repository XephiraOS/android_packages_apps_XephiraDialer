package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.K;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public class i extends w {

    /* renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f11062s;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<RecyclerView.B> f11063h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<RecyclerView.B> f11064i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<j> f11065j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    public ArrayList<C0137i> f11066k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<ArrayList<RecyclerView.B>> f11067l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<ArrayList<j>> f11068m = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    public ArrayList<ArrayList<C0137i>> f11069n = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<RecyclerView.B> f11070o = new ArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<RecyclerView.B> f11071p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<RecyclerView.B> f11072q = new ArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    public ArrayList<RecyclerView.B> f11073r = new ArrayList<>();

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11074a;

        public a(ArrayList arrayList) {
            this.f11074a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f11074a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                i.this.S(jVar.f11108a, jVar.f11109b, jVar.f11110c, jVar.f11111d, jVar.f11112e);
            }
            this.f11074a.clear();
            i.this.f11068m.remove(this.f11074a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11076a;

        public b(ArrayList arrayList) {
            this.f11076a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f11076a.iterator();
            while (it.hasNext()) {
                i.this.R((C0137i) it.next());
            }
            this.f11076a.clear();
            i.this.f11069n.remove(this.f11076a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11078a;

        public c(ArrayList arrayList) {
            this.f11078a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f11078a.iterator();
            while (it.hasNext()) {
                i.this.Q((RecyclerView.B) it.next());
            }
            this.f11078a.clear();
            i.this.f11067l.remove(this.f11078a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.B f11080a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f11081b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f11082c;

        public d(RecyclerView.B b10, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f11080a = b10;
            this.f11081b = viewPropertyAnimator;
            this.f11082c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f11081b.setListener(null);
            this.f11082c.setAlpha(1.0f);
            i.this.G(this.f11080a);
            i.this.f11072q.remove(this.f11080a);
            i.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i.this.H(this.f11080a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.B f11084a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f11085b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f11086c;

        public e(RecyclerView.B b10, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f11084a = b10;
            this.f11085b = view;
            this.f11086c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f11085b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f11086c.setListener(null);
            i.this.A(this.f11084a);
            i.this.f11070o.remove(this.f11084a);
            i.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i.this.B(this.f11084a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.B f11088a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11089b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f11090c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f11091d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f11092e;

        public f(RecyclerView.B b10, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f11088a = b10;
            this.f11089b = i10;
            this.f11090c = view;
            this.f11091d = i11;
            this.f11092e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f11089b != 0) {
                this.f11090c.setTranslationX(0.0f);
            }
            if (this.f11091d != 0) {
                this.f11090c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f11092e.setListener(null);
            i.this.E(this.f11088a);
            i.this.f11071p.remove(this.f11088a);
            i.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i.this.F(this.f11088a);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0137i f11094a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f11095b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f11096c;

        public g(C0137i c0137i, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f11094a = c0137i;
            this.f11095b = viewPropertyAnimator;
            this.f11096c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f11095b.setListener(null);
            this.f11096c.setAlpha(1.0f);
            this.f11096c.setTranslationX(0.0f);
            this.f11096c.setTranslationY(0.0f);
            i.this.C(this.f11094a.f11102a, true);
            i.this.f11073r.remove(this.f11094a.f11102a);
            i.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i.this.D(this.f11094a.f11102a, true);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0137i f11098a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f11099b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f11100c;

        public h(C0137i c0137i, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f11098a = c0137i;
            this.f11099b = viewPropertyAnimator;
            this.f11100c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f11099b.setListener(null);
            this.f11100c.setAlpha(1.0f);
            this.f11100c.setTranslationX(0.0f);
            this.f11100c.setTranslationY(0.0f);
            i.this.C(this.f11098a.f11103b, false);
            i.this.f11073r.remove(this.f11098a.f11103b);
            i.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i.this.D(this.f11098a.f11103b, false);
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.B f11108a;

        /* renamed from: b, reason: collision with root package name */
        public int f11109b;

        /* renamed from: c, reason: collision with root package name */
        public int f11110c;

        /* renamed from: d, reason: collision with root package name */
        public int f11111d;

        /* renamed from: e, reason: collision with root package name */
        public int f11112e;

        public j(RecyclerView.B b10, int i10, int i11, int i12, int i13) {
            this.f11108a = b10;
            this.f11109b = i10;
            this.f11110c = i11;
            this.f11111d = i12;
            this.f11112e = i13;
        }
    }

    public void Q(RecyclerView.B b10) {
        View view = b10.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f11070o.add(b10);
        animate.alpha(1.0f).setDuration(l()).setListener(new e(b10, view, animate)).start();
    }

    public void R(C0137i c0137i) {
        View view;
        RecyclerView.B b10 = c0137i.f11102a;
        View view2 = null;
        if (b10 == null) {
            view = null;
        } else {
            view = b10.itemView;
        }
        RecyclerView.B b11 = c0137i.f11103b;
        if (b11 != null) {
            view2 = b11.itemView;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f11073r.add(c0137i.f11102a);
            duration.translationX(c0137i.f11106e - c0137i.f11104c);
            duration.translationY(c0137i.f11107f - c0137i.f11105d);
            duration.alpha(0.0f).setListener(new g(c0137i, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f11073r.add(c0137i.f11103b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(c0137i, animate, view2)).start();
        }
    }

    public void S(RecyclerView.B b10, int i10, int i11, int i12, int i13) {
        View view = b10.itemView;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f11071p.add(b10);
        animate.setDuration(n()).setListener(new f(b10, i14, view, i15, animate)).start();
    }

    public final void T(RecyclerView.B b10) {
        View view = b10.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f11072q.add(b10);
        animate.setDuration(o()).alpha(0.0f).setListener(new d(b10, animate, view)).start();
    }

    public void U(List<RecyclerView.B> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    public void V() {
        if (!p()) {
            i();
        }
    }

    public final void W(List<C0137i> list, RecyclerView.B b10) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0137i c0137i = list.get(size);
            if (Y(c0137i, b10) && c0137i.f11102a == null && c0137i.f11103b == null) {
                list.remove(c0137i);
            }
        }
    }

    public final void X(C0137i c0137i) {
        RecyclerView.B b10 = c0137i.f11102a;
        if (b10 != null) {
            Y(c0137i, b10);
        }
        RecyclerView.B b11 = c0137i.f11103b;
        if (b11 != null) {
            Y(c0137i, b11);
        }
    }

    public final boolean Y(C0137i c0137i, RecyclerView.B b10) {
        boolean z10 = false;
        if (c0137i.f11103b == b10) {
            c0137i.f11103b = null;
        } else {
            if (c0137i.f11102a != b10) {
                return false;
            }
            c0137i.f11102a = null;
            z10 = true;
        }
        b10.itemView.setAlpha(1.0f);
        b10.itemView.setTranslationX(0.0f);
        b10.itemView.setTranslationY(0.0f);
        C(b10, z10);
        return true;
    }

    public final void Z(RecyclerView.B b10) {
        if (f11062s == null) {
            f11062s = new ValueAnimator().getInterpolator();
        }
        b10.itemView.animate().setInterpolator(f11062s);
        j(b10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.B b10, List<Object> list) {
        if (list.isEmpty() && !super.g(b10, list)) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.B b10) {
        View view = b10.itemView;
        view.animate().cancel();
        int size = this.f11065j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f11065j.get(size).f11108a == b10) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(b10);
                this.f11065j.remove(size);
            }
        }
        W(this.f11066k, b10);
        if (this.f11063h.remove(b10)) {
            view.setAlpha(1.0f);
            G(b10);
        }
        if (this.f11064i.remove(b10)) {
            view.setAlpha(1.0f);
            A(b10);
        }
        for (int size2 = this.f11069n.size() - 1; size2 >= 0; size2--) {
            ArrayList<C0137i> arrayList = this.f11069n.get(size2);
            W(arrayList, b10);
            if (arrayList.isEmpty()) {
                this.f11069n.remove(size2);
            }
        }
        for (int size3 = this.f11068m.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.f11068m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f11108a == b10) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(b10);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f11068m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f11067l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.B> arrayList3 = this.f11067l.get(size5);
            if (arrayList3.remove(b10)) {
                view.setAlpha(1.0f);
                A(b10);
                if (arrayList3.isEmpty()) {
                    this.f11067l.remove(size5);
                }
            }
        }
        this.f11072q.remove(b10);
        this.f11070o.remove(b10);
        this.f11073r.remove(b10);
        this.f11071p.remove(b10);
        V();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f11065j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.f11065j.get(size);
            View view = jVar.f11108a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(jVar.f11108a);
            this.f11065j.remove(size);
        }
        for (int size2 = this.f11063h.size() - 1; size2 >= 0; size2--) {
            G(this.f11063h.get(size2));
            this.f11063h.remove(size2);
        }
        int size3 = this.f11064i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.B b10 = this.f11064i.get(size3);
            b10.itemView.setAlpha(1.0f);
            A(b10);
            this.f11064i.remove(size3);
        }
        for (int size4 = this.f11066k.size() - 1; size4 >= 0; size4--) {
            X(this.f11066k.get(size4));
        }
        this.f11066k.clear();
        if (!p()) {
            return;
        }
        for (int size5 = this.f11068m.size() - 1; size5 >= 0; size5--) {
            ArrayList<j> arrayList = this.f11068m.get(size5);
            for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                j jVar2 = arrayList.get(size6);
                View view2 = jVar2.f11108a.itemView;
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                E(jVar2.f11108a);
                arrayList.remove(size6);
                if (arrayList.isEmpty()) {
                    this.f11068m.remove(arrayList);
                }
            }
        }
        for (int size7 = this.f11067l.size() - 1; size7 >= 0; size7--) {
            ArrayList<RecyclerView.B> arrayList2 = this.f11067l.get(size7);
            for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                RecyclerView.B b11 = arrayList2.get(size8);
                b11.itemView.setAlpha(1.0f);
                A(b11);
                arrayList2.remove(size8);
                if (arrayList2.isEmpty()) {
                    this.f11067l.remove(arrayList2);
                }
            }
        }
        for (int size9 = this.f11069n.size() - 1; size9 >= 0; size9--) {
            ArrayList<C0137i> arrayList3 = this.f11069n.get(size9);
            for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                X(arrayList3.get(size10));
                if (arrayList3.isEmpty()) {
                    this.f11069n.remove(arrayList3);
                }
            }
        }
        U(this.f11072q);
        U(this.f11071p);
        U(this.f11070o);
        U(this.f11073r);
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        if (this.f11064i.isEmpty() && this.f11066k.isEmpty() && this.f11065j.isEmpty() && this.f11063h.isEmpty() && this.f11071p.isEmpty() && this.f11072q.isEmpty() && this.f11070o.isEmpty() && this.f11073r.isEmpty() && this.f11068m.isEmpty() && this.f11067l.isEmpty() && this.f11069n.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void u() {
        long j10;
        long j11;
        boolean z10 = !this.f11063h.isEmpty();
        boolean z11 = !this.f11065j.isEmpty();
        boolean z12 = !this.f11066k.isEmpty();
        boolean z13 = !this.f11064i.isEmpty();
        if (!z10 && !z11 && !z13 && !z12) {
            return;
        }
        Iterator<RecyclerView.B> it = this.f11063h.iterator();
        while (it.hasNext()) {
            T(it.next());
        }
        this.f11063h.clear();
        if (z11) {
            ArrayList<j> arrayList = new ArrayList<>();
            arrayList.addAll(this.f11065j);
            this.f11068m.add(arrayList);
            this.f11065j.clear();
            a aVar = new a(arrayList);
            if (z10) {
                K.b0(arrayList.get(0).f11108a.itemView, aVar, o());
            } else {
                aVar.run();
            }
        }
        if (z12) {
            ArrayList<C0137i> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.f11066k);
            this.f11069n.add(arrayList2);
            this.f11066k.clear();
            b bVar = new b(arrayList2);
            if (z10) {
                K.b0(arrayList2.get(0).f11102a.itemView, bVar, o());
            } else {
                bVar.run();
            }
        }
        if (z13) {
            ArrayList<RecyclerView.B> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.f11064i);
            this.f11067l.add(arrayList3);
            this.f11064i.clear();
            c cVar = new c(arrayList3);
            if (!z10 && !z11 && !z12) {
                cVar.run();
                return;
            }
            long j12 = 0;
            if (z10) {
                j10 = o();
            } else {
                j10 = 0;
            }
            if (z11) {
                j11 = n();
            } else {
                j11 = 0;
            }
            if (z12) {
                j12 = m();
            }
            K.b0(arrayList3.get(0).itemView, cVar, j10 + Math.max(j11, j12));
        }
    }

    @Override // androidx.recyclerview.widget.w
    public boolean w(RecyclerView.B b10) {
        Z(b10);
        b10.itemView.setAlpha(0.0f);
        this.f11064i.add(b10);
        return true;
    }

    @Override // androidx.recyclerview.widget.w
    public boolean x(RecyclerView.B b10, RecyclerView.B b11, int i10, int i11, int i12, int i13) {
        if (b10 == b11) {
            return y(b10, i10, i11, i12, i13);
        }
        float translationX = b10.itemView.getTranslationX();
        float translationY = b10.itemView.getTranslationY();
        float alpha = b10.itemView.getAlpha();
        Z(b10);
        int i14 = (int) ((i12 - i10) - translationX);
        int i15 = (int) ((i13 - i11) - translationY);
        b10.itemView.setTranslationX(translationX);
        b10.itemView.setTranslationY(translationY);
        b10.itemView.setAlpha(alpha);
        if (b11 != null) {
            Z(b11);
            b11.itemView.setTranslationX(-i14);
            b11.itemView.setTranslationY(-i15);
            b11.itemView.setAlpha(0.0f);
        }
        this.f11066k.add(new C0137i(b10, b11, i10, i11, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.w
    public boolean y(RecyclerView.B b10, int i10, int i11, int i12, int i13) {
        View view = b10.itemView;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) b10.itemView.getTranslationY());
        Z(b10);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            E(b10);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX(-i14);
        }
        if (i15 != 0) {
            view.setTranslationY(-i15);
        }
        this.f11065j.add(new j(b10, translationX, translationY, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.w
    public boolean z(RecyclerView.B b10) {
        Z(b10);
        this.f11063h.add(b10);
        return true;
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: androidx.recyclerview.widget.i$i, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0137i {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.B f11102a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.B f11103b;

        /* renamed from: c, reason: collision with root package name */
        public int f11104c;

        /* renamed from: d, reason: collision with root package name */
        public int f11105d;

        /* renamed from: e, reason: collision with root package name */
        public int f11106e;

        /* renamed from: f, reason: collision with root package name */
        public int f11107f;

        public C0137i(RecyclerView.B b10, RecyclerView.B b11) {
            this.f11102a = b10;
            this.f11103b = b11;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f11102a + ", newHolder=" + this.f11103b + ", fromX=" + this.f11104c + ", fromY=" + this.f11105d + ", toX=" + this.f11106e + ", toY=" + this.f11107f + '}';
        }

        public C0137i(RecyclerView.B b10, RecyclerView.B b11, int i10, int i11, int i12, int i13) {
            this(b10, b11);
            this.f11104c = i10;
            this.f11105d = i11;
            this.f11106e = i12;
            this.f11107f = i13;
        }
    }
}
