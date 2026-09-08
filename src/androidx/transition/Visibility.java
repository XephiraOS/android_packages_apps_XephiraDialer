package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* loaded from: classes.dex */
public abstract class Visibility extends Transition {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f11675b = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: a, reason: collision with root package name */
    public int f11676a;

    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter implements Transition.i {

        /* renamed from: a, reason: collision with root package name */
        public final View f11677a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11678b;

        /* renamed from: c, reason: collision with root package name */
        public final ViewGroup f11679c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f11680d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f11681e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f11682f = false;

        public a(View view, int i10, boolean z10) {
            this.f11677a = view;
            this.f11678b = i10;
            this.f11679c = (ViewGroup) view.getParent();
            this.f11680d = z10;
            i(true);
        }

        private void i(boolean z10) {
            ViewGroup viewGroup;
            if (this.f11680d && this.f11681e != z10 && (viewGroup = this.f11679c) != null) {
                this.f11681e = z10;
                G.b(viewGroup, z10);
            }
        }

        @Override // androidx.transition.Transition.i
        public void b(Transition transition) {
            i(false);
            if (!this.f11682f) {
                H.g(this.f11677a, this.f11678b);
            }
        }

        @Override // androidx.transition.Transition.i
        public void d(Transition transition) {
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.i
        public void g(Transition transition) {
            i(true);
            if (!this.f11682f) {
                H.g(this.f11677a, 0);
            }
        }

        public final void h() {
            if (!this.f11682f) {
                H.g(this.f11677a, this.f11678b);
                ViewGroup viewGroup = this.f11679c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            i(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f11682f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (z10) {
                return;
            }
            h();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            if (z10) {
                H.g(this.f11677a, 0);
                ViewGroup viewGroup = this.f11679c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }

        @Override // androidx.transition.Transition.i
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void e(Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter implements Transition.i {

        /* renamed from: a, reason: collision with root package name */
        public final ViewGroup f11683a;

        /* renamed from: b, reason: collision with root package name */
        public final View f11684b;

        /* renamed from: c, reason: collision with root package name */
        public final View f11685c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11686d = true;

        public b(ViewGroup viewGroup, View view, View view2) {
            this.f11683a = viewGroup;
            this.f11684b = view;
            this.f11685c = view2;
        }

        @Override // androidx.transition.Transition.i
        public void d(Transition transition) {
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.i
        public void e(Transition transition) {
            if (this.f11686d) {
                h();
            }
        }

        public final void h() {
            this.f11685c.setTag(C0511n.f11728d, null);
            this.f11683a.getOverlay().remove(this.f11684b);
            this.f11686d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f11683a.getOverlay().remove(this.f11684b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f11684b.getParent() == null) {
                this.f11683a.getOverlay().add(this.f11684b);
            } else {
                Visibility.this.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            if (z10) {
                this.f11685c.setTag(C0511n.f11728d, this.f11684b);
                this.f11683a.getOverlay().add(this.f11684b);
                this.f11686d = true;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (z10) {
                return;
            }
            h();
        }

        @Override // androidx.transition.Transition.i
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void b(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void g(Transition transition) {
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11688a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11689b;

        /* renamed from: c, reason: collision with root package name */
        public int f11690c;

        /* renamed from: d, reason: collision with root package name */
        public int f11691d;

        /* renamed from: e, reason: collision with root package name */
        public ViewGroup f11692e;

        /* renamed from: f, reason: collision with root package name */
        public ViewGroup f11693f;
    }

    public Visibility() {
        this.f11676a = 3;
    }

    private void captureValues(C c10) {
        c10.f11527a.put("android:visibility:visibility", Integer.valueOf(c10.f11528b.getVisibility()));
        c10.f11527a.put("android:visibility:parent", c10.f11528b.getParent());
        int[] iArr = new int[2];
        c10.f11528b.getLocationOnScreen(iArr);
        c10.f11527a.put("android:visibility:screenLocation", iArr);
    }

    public int a() {
        return this.f11676a;
    }

    public final c b(C c10, C c11) {
        c cVar = new c();
        cVar.f11688a = false;
        cVar.f11689b = false;
        if (c10 != null && c10.f11527a.containsKey("android:visibility:visibility")) {
            cVar.f11690c = ((Integer) c10.f11527a.get("android:visibility:visibility")).intValue();
            cVar.f11692e = (ViewGroup) c10.f11527a.get("android:visibility:parent");
        } else {
            cVar.f11690c = -1;
            cVar.f11692e = null;
        }
        if (c11 != null && c11.f11527a.containsKey("android:visibility:visibility")) {
            cVar.f11691d = ((Integer) c11.f11527a.get("android:visibility:visibility")).intValue();
            cVar.f11693f = (ViewGroup) c11.f11527a.get("android:visibility:parent");
        } else {
            cVar.f11691d = -1;
            cVar.f11693f = null;
        }
        if (c10 != null && c11 != null) {
            int i10 = cVar.f11690c;
            int i11 = cVar.f11691d;
            if (i10 == i11 && cVar.f11692e == cVar.f11693f) {
                return cVar;
            }
            if (i10 != i11) {
                if (i10 == 0) {
                    cVar.f11689b = false;
                    cVar.f11688a = true;
                } else if (i11 == 0) {
                    cVar.f11689b = true;
                    cVar.f11688a = true;
                }
            } else if (cVar.f11693f == null) {
                cVar.f11689b = false;
                cVar.f11688a = true;
            } else if (cVar.f11692e == null) {
                cVar.f11689b = true;
                cVar.f11688a = true;
            }
        } else if (c10 == null && cVar.f11691d == 0) {
            cVar.f11689b = true;
            cVar.f11688a = true;
        } else if (c11 == null && cVar.f11690c == 0) {
            cVar.f11689b = false;
            cVar.f11688a = true;
        }
        return cVar;
    }

    public Animator c(ViewGroup viewGroup, View view, C c10, C c11) {
        return null;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C c10) {
        captureValues(c10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C c10) {
        captureValues(c10);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C c10, C c11) {
        c b10 = b(c10, c11);
        if (b10.f11688a) {
            if (b10.f11692e != null || b10.f11693f != null) {
                if (b10.f11689b) {
                    return d(viewGroup, c10, b10.f11690c, c11, b10.f11691d);
                }
                return f(viewGroup, c10, b10.f11690c, c11, b10.f11691d);
            }
            return null;
        }
        return null;
    }

    public Animator d(ViewGroup viewGroup, C c10, int i10, C c11, int i11) {
        if ((this.f11676a & 1) != 1 || c11 == null) {
            return null;
        }
        if (c10 == null) {
            View view = (View) c11.f11528b.getParent();
            if (b(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f11688a) {
                return null;
            }
        }
        return c(viewGroup, c11.f11528b, c10, c11);
    }

    public Animator e(ViewGroup viewGroup, View view, C c10, C c11) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x008f, code lost:
    
        if (r17.mCanRemoveViews != false) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator f(android.view.ViewGroup r18, androidx.transition.C r19, int r20, androidx.transition.C r21, int r22) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.f(android.view.ViewGroup, androidx.transition.C, int, androidx.transition.C, int):android.animation.Animator");
    }

    public void g(int i10) {
        if ((i10 & (-4)) == 0) {
            this.f11676a = i10;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f11675b;
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(C c10, C c11) {
        if (c10 == null && c11 == null) {
            return false;
        }
        if (c10 != null && c11 != null && c11.f11527a.containsKey("android:visibility:visibility") != c10.f11527a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c b10 = b(c10, c11);
        if (!b10.f11688a) {
            return false;
        }
        if (b10.f11690c != 0 && b10.f11691d != 0) {
            return false;
        }
        return true;
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11676a = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f11744e);
        int k10 = A.k.k(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (k10 != 0) {
            g(k10);
        }
    }
}
