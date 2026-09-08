package q4;

import I.h;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import f4.C1001b;
import f4.C1002c;
import f4.C1008i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseMotionStrategy.java */
/* renamed from: q4.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1486b implements com.google.android.material.floatingactionbutton.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f36133a;

    /* renamed from: b, reason: collision with root package name */
    public final ExtendedFloatingActionButton f36134b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<Animator.AnimatorListener> f36135c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public final C1485a f36136d;

    /* renamed from: e, reason: collision with root package name */
    public C1008i f36137e;

    /* renamed from: f, reason: collision with root package name */
    public C1008i f36138f;

    /* compiled from: BaseMotionStrategy.java */
    /* renamed from: q4.b$a */
    /* loaded from: classes3.dex */
    public class a extends Property<ExtendedFloatingActionButton, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(C1001b.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.f23312J.getColorForState(extendedFloatingActionButton.getDrawableState(), AbstractC1486b.this.f36134b.f23312J.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f10) {
            int colorForState = extendedFloatingActionButton.f23312J.getColorForState(extendedFloatingActionButton.getDrawableState(), AbstractC1486b.this.f36134b.f23312J.getDefaultColor());
            ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (C1001b.a(0.0f, Color.alpha(colorForState) / 255.0f, f10.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f10.floatValue() == 1.0f) {
                extendedFloatingActionButton.C(extendedFloatingActionButton.f23312J);
            } else {
                extendedFloatingActionButton.C(valueOf);
            }
        }
    }

    public AbstractC1486b(ExtendedFloatingActionButton extendedFloatingActionButton, C1485a c1485a) {
        this.f36134b = extendedFloatingActionButton;
        this.f36133a = extendedFloatingActionButton.getContext();
        this.f36136d = c1485a;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public void a() {
        this.f36136d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public C1008i d() {
        return this.f36138f;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public final void f(C1008i c1008i) {
        this.f36138f = c1008i;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public AnimatorSet g() {
        return k(l());
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public final List<Animator.AnimatorListener> h() {
        return this.f36135c;
    }

    public AnimatorSet k(C1008i c1008i) {
        ArrayList arrayList = new ArrayList();
        if (c1008i.j("opacity")) {
            arrayList.add(c1008i.f("opacity", this.f36134b, View.ALPHA));
        }
        if (c1008i.j("scale")) {
            arrayList.add(c1008i.f("scale", this.f36134b, View.SCALE_Y));
            arrayList.add(c1008i.f("scale", this.f36134b, View.SCALE_X));
        }
        if (c1008i.j("width")) {
            arrayList.add(c1008i.f("width", this.f36134b, ExtendedFloatingActionButton.f23299O));
        }
        if (c1008i.j("height")) {
            arrayList.add(c1008i.f("height", this.f36134b, ExtendedFloatingActionButton.f23300P));
        }
        if (c1008i.j("paddingStart")) {
            arrayList.add(c1008i.f("paddingStart", this.f36134b, ExtendedFloatingActionButton.f23301Q));
        }
        if (c1008i.j("paddingEnd")) {
            arrayList.add(c1008i.f("paddingEnd", this.f36134b, ExtendedFloatingActionButton.f23302R));
        }
        if (c1008i.j("labelOpacity")) {
            arrayList.add(c1008i.f("labelOpacity", this.f36134b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        C1002c.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final C1008i l() {
        C1008i c1008i = this.f36138f;
        if (c1008i != null) {
            return c1008i;
        }
        if (this.f36137e == null) {
            this.f36137e = C1008i.d(this.f36133a, b());
        }
        return (C1008i) h.e(this.f36137e);
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public void onAnimationEnd() {
        this.f36136d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public void onAnimationStart(Animator animator) {
        this.f36136d.c(animator);
    }
}
