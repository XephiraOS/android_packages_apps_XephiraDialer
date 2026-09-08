package q4;

import I.h;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e4.C0978d;
import java.util.ArrayList;
import w4.InterfaceC1650b;
import x4.i;
import x4.n;

/* compiled from: FloatingActionButtonImplLollipop.java */
/* loaded from: classes3.dex */
public class d extends com.google.android.material.floatingactionbutton.a {

    /* renamed from: O, reason: collision with root package name */
    public StateListAnimator f36157O;

    /* compiled from: FloatingActionButtonImplLollipop.java */
    /* loaded from: classes3.dex */
    public static class a extends i {
        public a(n nVar) {
            super(nVar);
        }

        @Override // x4.i, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public d(FloatingActionButton floatingActionButton, InterfaceC1650b interfaceC1650b) {
        super(floatingActionButton, interfaceC1650b);
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void C() {
        f0();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void F(float f10, float f11, float f12) {
        if (this.f23400w.getStateListAnimator() == this.f36157O) {
            StateListAnimator j02 = j0(f10, f11, f12);
            this.f36157O = j02;
            this.f23400w.setStateListAnimator(j02);
        }
        if (Z()) {
            f0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public boolean K() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void V(ColorStateList colorStateList) {
        Drawable drawable = this.f23380c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(v4.b.d(colorStateList));
        } else {
            super.V(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public boolean Z() {
        if (!this.f23401x.b() && b0()) {
            return false;
        }
        return true;
    }

    public c i0(int i10, ColorStateList colorStateList) {
        Context context = this.f23400w.getContext();
        c cVar = new c((n) h.e(this.f23378a));
        cVar.e(androidx.core.content.b.c(context, C0978d.f30712f), androidx.core.content.b.c(context, C0978d.f30711e), androidx.core.content.b.c(context, C0978d.f30709c), androidx.core.content.b.c(context, C0978d.f30710d));
        cVar.d(i10);
        cVar.c(colorStateList);
        return cVar;
    }

    public final StateListAnimator j0(float f10, float f11, float f12) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.f23369I, k0(f10, f12));
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.f23370J, k0(f10, f11));
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.f23371K, k0(f10, f11));
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.f23372L, k0(f10, f11));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f23400w, "elevation", f10).setDuration(0L));
        arrayList.add(ObjectAnimator.ofFloat(this.f23400w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.a.f23364D);
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.f23373M, animatorSet);
        stateListAnimator.addState(com.google.android.material.floatingactionbutton.a.f23374N, k0(0.0f, 0.0f));
        return stateListAnimator;
    }

    public final Animator k0(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f23400w, "elevation", f10).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f23400w, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f11).setDuration(100L));
        animatorSet.setInterpolator(com.google.android.material.floatingactionbutton.a.f23364D);
        return animatorSet;
    }

    public i l0() {
        return new a((n) h.e(this.f23378a));
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public float m() {
        return this.f23400w.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void r(Rect rect) {
        if (this.f23401x.b()) {
            super.r(rect);
        } else if (!b0()) {
            int sizeDimension = (this.f23388k - this.f23400w.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10) {
        Drawable drawable;
        i l02 = l0();
        this.f23379b = l02;
        l02.setTintList(colorStateList);
        if (mode != null) {
            this.f23379b.setTintMode(mode);
        }
        this.f23379b.initializeElevationOverlay(this.f23400w.getContext());
        if (i10 > 0) {
            this.f23381d = i0(i10, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) h.e(this.f23381d), (Drawable) h.e(this.f23379b)});
        } else {
            this.f23381d = null;
            drawable = this.f23379b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(v4.b.d(colorStateList2), drawable, null);
        this.f23380c = rippleDrawable;
        this.f23382e = rippleDrawable;
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void A() {
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void d0() {
    }

    @Override // com.google.android.material.floatingactionbutton.a
    public void E(int[] iArr) {
    }
}
