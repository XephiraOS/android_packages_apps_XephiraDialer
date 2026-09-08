package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.Map;

/* loaded from: classes.dex */
public class ChangeBounds extends Transition {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f11530b = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: c, reason: collision with root package name */
    public static final Property<i, PointF> f11531c = new a(PointF.class, "topLeft");

    /* renamed from: d, reason: collision with root package name */
    public static final Property<i, PointF> f11532d = new b(PointF.class, "bottomRight");

    /* renamed from: e, reason: collision with root package name */
    public static final Property<View, PointF> f11533e = new c(PointF.class, "bottomRight");

    /* renamed from: f, reason: collision with root package name */
    public static final Property<View, PointF> f11534f = new d(PointF.class, "topLeft");

    /* renamed from: g, reason: collision with root package name */
    public static final Property<View, PointF> f11535g = new e(PointF.class, "position");

    /* renamed from: h, reason: collision with root package name */
    public static final o f11536h = new o();

    /* renamed from: a, reason: collision with root package name */
    public boolean f11537a;

    /* loaded from: classes.dex */
    public class a extends Property<i, PointF> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.c(pointF);
        }
    }

    /* loaded from: classes.dex */
    public class b extends Property<i, PointF> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.a(pointF);
        }
    }

    /* loaded from: classes.dex */
    public class c extends Property<View, PointF> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            H.e(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* loaded from: classes.dex */
    public class d extends Property<View, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            H.e(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* loaded from: classes.dex */
    public class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            H.e(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f11538a;
        private final i mViewBounds;

        public f(i iVar) {
            this.f11538a = iVar;
            this.mViewBounds = iVar;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends AnimatorListenerAdapter implements Transition.i {

        /* renamed from: a, reason: collision with root package name */
        public final View f11540a;

        /* renamed from: b, reason: collision with root package name */
        public final Rect f11541b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f11542c;

        /* renamed from: d, reason: collision with root package name */
        public final Rect f11543d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f11544e;

        /* renamed from: f, reason: collision with root package name */
        public final int f11545f;

        /* renamed from: g, reason: collision with root package name */
        public final int f11546g;

        /* renamed from: h, reason: collision with root package name */
        public final int f11547h;

        /* renamed from: i, reason: collision with root package name */
        public final int f11548i;

        /* renamed from: j, reason: collision with root package name */
        public final int f11549j;

        /* renamed from: k, reason: collision with root package name */
        public final int f11550k;

        /* renamed from: l, reason: collision with root package name */
        public final int f11551l;

        /* renamed from: m, reason: collision with root package name */
        public final int f11552m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f11553n;

        public g(View view, Rect rect, boolean z10, Rect rect2, boolean z11, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.f11540a = view;
            this.f11541b = rect;
            this.f11542c = z10;
            this.f11543d = rect2;
            this.f11544e = z11;
            this.f11545f = i10;
            this.f11546g = i11;
            this.f11547h = i12;
            this.f11548i = i13;
            this.f11549j = i14;
            this.f11550k = i15;
            this.f11551l = i16;
            this.f11552m = i17;
        }

        @Override // androidx.transition.Transition.i
        public void b(Transition transition) {
            Rect rect;
            this.f11540a.setTag(C0511n.f11729e, this.f11540a.getClipBounds());
            if (this.f11544e) {
                rect = null;
            } else {
                rect = this.f11543d;
            }
            this.f11540a.setClipBounds(rect);
        }

        @Override // androidx.transition.Transition.i
        public void e(Transition transition) {
            this.f11553n = true;
        }

        @Override // androidx.transition.Transition.i
        public void g(Transition transition) {
            View view = this.f11540a;
            int i10 = C0511n.f11729e;
            Rect rect = (Rect) view.getTag(i10);
            this.f11540a.setTag(i10, null);
            this.f11540a.setClipBounds(rect);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (this.f11553n) {
                return;
            }
            Rect rect = null;
            if (z10) {
                if (!this.f11542c) {
                    rect = this.f11541b;
                }
            } else if (!this.f11544e) {
                rect = this.f11543d;
            }
            this.f11540a.setClipBounds(rect);
            if (z10) {
                H.e(this.f11540a, this.f11545f, this.f11546g, this.f11547h, this.f11548i);
            } else {
                H.e(this.f11540a, this.f11549j, this.f11550k, this.f11551l, this.f11552m);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            int max = Math.max(this.f11547h - this.f11545f, this.f11551l - this.f11549j);
            int max2 = Math.max(this.f11548i - this.f11546g, this.f11552m - this.f11550k);
            int i10 = z10 ? this.f11549j : this.f11545f;
            int i11 = z10 ? this.f11550k : this.f11546g;
            H.e(this.f11540a, i10, i11, max + i10, max2 + i11);
            this.f11540a.setClipBounds(z10 ? this.f11543d : this.f11541b);
        }

        @Override // androidx.transition.Transition.i
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void d(Transition transition) {
        }
    }

    /* loaded from: classes.dex */
    public static class h extends x {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11554a = false;

        /* renamed from: b, reason: collision with root package name */
        public final ViewGroup f11555b;

        public h(ViewGroup viewGroup) {
            this.f11555b = viewGroup;
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void b(Transition transition) {
            G.b(this.f11555b, false);
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void d(Transition transition) {
            if (!this.f11554a) {
                G.b(this.f11555b, false);
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void e(Transition transition) {
            G.b(this.f11555b, false);
            this.f11554a = true;
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void g(Transition transition) {
            G.b(this.f11555b, true);
        }
    }

    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public int f11556a;

        /* renamed from: b, reason: collision with root package name */
        public int f11557b;

        /* renamed from: c, reason: collision with root package name */
        public int f11558c;

        /* renamed from: d, reason: collision with root package name */
        public int f11559d;

        /* renamed from: e, reason: collision with root package name */
        public final View f11560e;

        /* renamed from: f, reason: collision with root package name */
        public int f11561f;

        /* renamed from: g, reason: collision with root package name */
        public int f11562g;

        public i(View view) {
            this.f11560e = view;
        }

        public void a(PointF pointF) {
            this.f11558c = Math.round(pointF.x);
            this.f11559d = Math.round(pointF.y);
            int i10 = this.f11562g + 1;
            this.f11562g = i10;
            if (this.f11561f == i10) {
                b();
            }
        }

        public final void b() {
            H.e(this.f11560e, this.f11556a, this.f11557b, this.f11558c, this.f11559d);
            this.f11561f = 0;
            this.f11562g = 0;
        }

        public void c(PointF pointF) {
            this.f11556a = Math.round(pointF.x);
            this.f11557b = Math.round(pointF.y);
            int i10 = this.f11561f + 1;
            this.f11561f = i10;
            if (i10 == this.f11562g) {
                b();
            }
        }
    }

    public ChangeBounds() {
        this.f11537a = false;
    }

    public void a(boolean z10) {
        this.f11537a = z10;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C c10) {
        captureValues(c10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C c10) {
        Rect rect;
        captureValues(c10);
        if (this.f11537a && (rect = (Rect) c10.f11528b.getTag(C0511n.f11729e)) != null) {
            c10.f11527a.put("android:changeBounds:clip", rect);
        }
    }

    public final void captureValues(C c10) {
        View view = c10.f11528b;
        if (view.isLaidOut() || view.getWidth() != 0 || view.getHeight() != 0) {
            c10.f11527a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            c10.f11527a.put("android:changeBounds:parent", c10.f11528b.getParent());
            if (this.f11537a) {
                c10.f11527a.put("android:changeBounds:clip", view.getClipBounds());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C c10, C c11) {
        int i10;
        int i11;
        int i12;
        int i13;
        ObjectAnimator a10;
        boolean z10;
        int i14;
        boolean z11;
        Rect rect;
        View view;
        ObjectAnimator objectAnimator;
        Animator c12;
        if (c10 == null || c11 == null) {
            return null;
        }
        Map<String, Object> map = c10.f11527a;
        Map<String, Object> map2 = c11.f11527a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = c11.f11528b;
        Rect rect2 = (Rect) c10.f11527a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) c11.f11527a.get("android:changeBounds:bounds");
        int i15 = rect2.left;
        int i16 = rect3.left;
        int i17 = rect2.top;
        int i18 = rect3.top;
        int i19 = rect2.right;
        int i20 = rect3.right;
        int i21 = rect2.bottom;
        int i22 = rect3.bottom;
        int i23 = i19 - i15;
        int i24 = i21 - i17;
        int i25 = i20 - i16;
        int i26 = i22 - i18;
        Rect rect4 = (Rect) c10.f11527a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) c11.f11527a.get("android:changeBounds:clip");
        if ((i23 != 0 && i24 != 0) || (i25 != 0 && i26 != 0)) {
            if (i15 == i16 && i17 == i18) {
                i10 = 0;
            } else {
                i10 = 1;
            }
            if (i19 != i20 || i21 != i22) {
                i10++;
            }
        } else {
            i10 = 0;
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i10++;
        }
        int i27 = i10;
        if (i27 > 0) {
            if (!this.f11537a) {
                H.e(view2, i15, i17, i19, i21);
                if (i27 == 2) {
                    if (i23 == i25 && i24 == i26) {
                        c12 = C0509l.a(view2, f11535g, getPathMotion().a(i15, i17, i16, i18));
                    } else {
                        i iVar = new i(view2);
                        ObjectAnimator a11 = C0509l.a(iVar, f11531c, getPathMotion().a(i15, i17, i16, i18));
                        ObjectAnimator a12 = C0509l.a(iVar, f11532d, getPathMotion().a(i19, i21, i20, i22));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a11, a12);
                        animatorSet.addListener(new f(iVar));
                        view = view2;
                        c12 = animatorSet;
                    }
                } else if (i15 == i16 && i17 == i18) {
                    c12 = C0509l.a(view2, f11533e, getPathMotion().a(i19, i21, i20, i22));
                } else {
                    c12 = C0509l.a(view2, f11534f, getPathMotion().a(i15, i17, i16, i18));
                }
                view = view2;
            } else {
                H.e(view2, i15, i17, Math.max(i23, i25) + i15, i17 + Math.max(i24, i26));
                if (i15 == i16 && i17 == i18) {
                    i11 = i20;
                    i12 = i19;
                    i13 = i16;
                    a10 = null;
                } else {
                    i11 = i20;
                    i12 = i19;
                    i13 = i16;
                    a10 = C0509l.a(view2, f11535g, getPathMotion().a(i15, i17, i16, i18));
                }
                if (rect4 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    i14 = 0;
                    rect4 = new Rect(0, 0, i23, i24);
                } else {
                    i14 = 0;
                }
                if (rect5 == null) {
                    z11 = 1;
                } else {
                    z11 = i14;
                }
                if (z11 != 0) {
                    rect = new Rect(i14, i14, i25, i26);
                } else {
                    rect = rect5;
                }
                if (!rect4.equals(rect)) {
                    view2.setClipBounds(rect4);
                    objectAnimator = ObjectAnimator.ofObject(view2, "clipBounds", f11536h, rect4, rect);
                    int i28 = i13;
                    view = view2;
                    g gVar = new g(view2, rect4, z10, rect, z11, i15, i17, i12, i21, i28, i18, i11, i22);
                    objectAnimator.addListener(gVar);
                    addListener(gVar);
                } else {
                    view = view2;
                    objectAnimator = null;
                }
                c12 = B.c(a10, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                G.b(viewGroup4, true);
                getRootTransition().addListener(new h(viewGroup4));
            }
            return c12;
        }
        return null;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f11530b;
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11537a = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f11743d);
        boolean e10 = A.k.e(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        a(e10);
    }
}
