package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class Slide extends Visibility {

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f11634e = new DecelerateInterpolator();

    /* renamed from: f, reason: collision with root package name */
    public static final TimeInterpolator f11635f = new AccelerateInterpolator();

    /* renamed from: g, reason: collision with root package name */
    public static final g f11636g = new a();

    /* renamed from: h, reason: collision with root package name */
    public static final g f11637h = new b();

    /* renamed from: i, reason: collision with root package name */
    public static final g f11638i = new c();

    /* renamed from: j, reason: collision with root package name */
    public static final g f11639j = new d();

    /* renamed from: k, reason: collision with root package name */
    public static final g f11640k = new e();

    /* renamed from: l, reason: collision with root package name */
    public static final g f11641l = new f();

    /* renamed from: c, reason: collision with root package name */
    public g f11642c;

    /* renamed from: d, reason: collision with root package name */
    public int f11643d;

    /* loaded from: classes.dex */
    public class a extends h {
        public a() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* loaded from: classes.dex */
    public class b extends h {
        public b() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            if (viewGroup.getLayoutDirection() == 1) {
                return view.getTranslationX() + viewGroup.getWidth();
            }
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    /* loaded from: classes.dex */
    public class c extends i {
        public c() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    }

    /* loaded from: classes.dex */
    public class d extends h {
        public d() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* loaded from: classes.dex */
    public class e extends h {
        public e() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            if (viewGroup.getLayoutDirection() == 1) {
                return view.getTranslationX() - viewGroup.getWidth();
            }
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    /* loaded from: classes.dex */
    public class f extends i {
        public f() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    /* loaded from: classes.dex */
    public static abstract class h implements g {
        public h() {
        }

        @Override // androidx.transition.Slide.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i implements g {
        public i() {
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    public Slide() {
        this.f11642c = f11641l;
        this.f11643d = 80;
        h(80);
    }

    private void captureValues(C c10) {
        int[] iArr = new int[2];
        c10.f11528b.getLocationOnScreen(iArr);
        c10.f11527a.put("android:slide:screenPosition", iArr);
    }

    @Override // androidx.transition.Visibility
    public Animator c(ViewGroup viewGroup, View view, C c10, C c11) {
        if (c11 == null) {
            return null;
        }
        int[] iArr = (int[]) c11.f11527a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return E.a(view, c11, iArr[0], iArr[1], this.f11642c.b(viewGroup, view), this.f11642c.a(viewGroup, view), translationX, translationY, f11634e, this);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(C c10) {
        super.captureEndValues(c10);
        captureValues(c10);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(C c10) {
        super.captureStartValues(c10);
        captureValues(c10);
    }

    @Override // androidx.transition.Visibility
    public Animator e(ViewGroup viewGroup, View view, C c10, C c11) {
        if (c10 == null) {
            return null;
        }
        int[] iArr = (int[]) c10.f11527a.get("android:slide:screenPosition");
        return E.a(view, c10, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f11642c.b(viewGroup, view), this.f11642c.a(viewGroup, view), f11635f, this);
    }

    public void h(int i10) {
        if (i10 != 3) {
            if (i10 != 5) {
                if (i10 != 48) {
                    if (i10 != 80) {
                        if (i10 != 8388611) {
                            if (i10 == 8388613) {
                                this.f11642c = f11640k;
                            } else {
                                throw new IllegalArgumentException("Invalid slide direction");
                            }
                        } else {
                            this.f11642c = f11637h;
                        }
                    } else {
                        this.f11642c = f11641l;
                    }
                } else {
                    this.f11642c = f11638i;
                }
            } else {
                this.f11642c = f11639j;
            }
        } else {
            this.f11642c = f11636g;
        }
        this.f11643d = i10;
        q qVar = new q();
        qVar.j(i10);
        setPropagation(qVar);
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11642c = f11641l;
        this.f11643d = 80;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f11747h);
        int k10 = A.k.k(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        h(k10);
    }
}
