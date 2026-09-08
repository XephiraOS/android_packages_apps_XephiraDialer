package androidx.recyclerview.widget;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import androidx.preference.Preference;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.animation.dynamicanimation.COUISpringAnimation;
import com.coui.appcompat.animation.dynamicanimation.COUISpringForce;
import com.coui.appcompat.contextutil.COUIContextUtil;

/* compiled from: COUIRecyclerDividerManager.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: l, reason: collision with root package name */
    public static float f11042l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    public static float f11043m = 0.15f;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11044a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f11045b;

    /* renamed from: c, reason: collision with root package name */
    public int f11046c;

    /* renamed from: d, reason: collision with root package name */
    public int f11047d;

    /* renamed from: e, reason: collision with root package name */
    public int f11048e;

    /* renamed from: f, reason: collision with root package name */
    public int f11049f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11050g;

    /* renamed from: h, reason: collision with root package name */
    public float f11051h;

    /* renamed from: i, reason: collision with root package name */
    public float f11052i;

    /* renamed from: j, reason: collision with root package name */
    public COUISpringAnimation f11053j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.dynamicanimation.animation.d<f> f11054k;

    /* compiled from: COUIRecyclerDividerManager.java */
    /* loaded from: classes.dex */
    public class a extends androidx.dynamicanimation.animation.d<f> {
        public a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(f fVar) {
            return fVar.g();
        }

        @Override // androidx.dynamicanimation.animation.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(f fVar, float f10) {
            fVar.k(f10);
        }
    }

    public f(RecyclerView recyclerView, int i10) {
        this.f11045b = recyclerView;
        this.f11047d = i10;
        h();
    }

    public void c(MotionEvent motionEvent) {
        if (this.f11044a) {
            if (motionEvent.getAction() == 0) {
                this.f11050g = true;
                this.f11046c = (int) (motionEvent.getY() + 0.5f);
                e(motionEvent);
            } else {
                if (motionEvent.getAction() == 1) {
                    f(motionEvent);
                    return;
                }
                if (motionEvent.getAction() == 3) {
                    f(motionEvent);
                } else if (motionEvent.getAction() == 2 && Math.abs(((int) (motionEvent.getY() + 0.5f)) - this.f11046c) > this.f11047d) {
                    f(motionEvent);
                }
            }
        }
    }

    public final void d() {
        if (this.f11053j != null) {
            return;
        }
        this.f11053j = new COUISpringAnimation(this, this.f11054k);
        COUISpringForce cOUISpringForce = new COUISpringForce();
        cOUISpringForce.setBounce(f11042l);
        cOUISpringForce.setResponse(f11043m);
        this.f11053j.setSpring(cOUISpringForce);
    }

    public final void e(MotionEvent motionEvent) {
        this.f11051h = motionEvent.getX();
        float y10 = motionEvent.getY();
        this.f11052i = y10;
        if (i(this.f11051h, y10)) {
            d();
            this.f11053j.setStartValue(this.f11048e);
            this.f11053j.animateToFinalPosition(0.0f);
        }
    }

    public final void f(MotionEvent motionEvent) {
        if (this.f11050g) {
            this.f11050g = false;
            this.f11051h = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.f11052i = y10;
            if (i(this.f11051h, y10)) {
                d();
                this.f11053j.setStartValue(this.f11048e);
                this.f11053j.animateToFinalPosition(this.f11049f);
            }
        }
    }

    public final int g() {
        return this.f11048e;
    }

    public final void h() {
        l(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean i(float f10, float f11) {
        View findChildViewUnder = this.f11045b.findChildViewUnder(f10, f11);
        if (findChildViewUnder != 0 && (this.f11045b.getAdapter() instanceof androidx.preference.h)) {
            Preference j10 = ((androidx.preference.h) this.f11045b.getAdapter()).j(this.f11045b.getChildAdapterPosition(findChildViewUnder));
            if (j10 != null) {
                return j10.isEnabled();
            }
            return false;
        }
        if (findChildViewUnder instanceof m) {
            return ((m) findChildViewUnder).getItemEnabled();
        }
        return true;
    }

    public void j(MotionEvent motionEvent) {
        f(motionEvent);
    }

    public final void k(float f10) {
        this.f11048e = (int) f10;
        m(this.f11051h, this.f11052i);
    }

    public void l(boolean z10) {
        this.f11044a = z10;
        if (z10) {
            int alpha = Color.alpha(COUIContextUtil.getAttrColor(this.f11045b.getContext(), X8.c.f4400q));
            this.f11049f = alpha;
            this.f11048e = alpha;
            if (this.f11054k == null) {
                this.f11054k = new a("dividerAlpha");
            }
            d();
        }
    }

    public final void m(float f10, float f11) {
        View findChildViewUnder = this.f11045b.findChildViewUnder(f10, f11);
        if (findChildViewUnder != null) {
            for (int i10 = 0; i10 < this.f11045b.getItemDecorationCount(); i10++) {
                RecyclerView.n itemDecorationAt = this.f11045b.getItemDecorationAt(i10);
                if (itemDecorationAt instanceof COUIRecyclerView.a) {
                    COUIRecyclerView.a aVar = (COUIRecyclerView.a) itemDecorationAt;
                    aVar.setPressDividerPos(this.f11045b.indexOfChild(findChildViewUnder));
                    aVar.setPressDividerAlpha(this.f11048e);
                    this.f11045b.invalidate();
                }
            }
        }
    }
}
