package i8;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import f8.C1022a;
import g8.C1051a;
import g8.C1052b;
import i8.e;
import java.util.HashMap;
import java.util.Iterator;
import p.C1416b;

/* compiled from: PhysicalAnimator.java */
/* loaded from: classes3.dex */
public class k implements e.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f32240a;

    /* renamed from: g, reason: collision with root package name */
    public HashMap<c, InterfaceC1105a> f32246g;

    /* renamed from: h, reason: collision with root package name */
    public HashMap<c, b> f32247h;

    /* renamed from: j, reason: collision with root package name */
    public C1052b f32249j;

    /* renamed from: k, reason: collision with root package name */
    public C1051a f32250k;

    /* renamed from: b, reason: collision with root package name */
    public final C1416b<c> f32241b = new C1416b<>(1);

    /* renamed from: c, reason: collision with root package name */
    public final C1416b<c> f32242c = new C1416b<>(1);

    /* renamed from: d, reason: collision with root package name */
    public boolean f32243d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f32244e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f32245f = false;

    /* renamed from: i, reason: collision with root package name */
    public e f32248i = null;

    public k(Context context) {
        this.f32240a = context;
        o();
    }

    public static k e(Context context) {
        return new k(context);
    }

    public static String i(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        return "custom";
                    }
                    return "alpha";
                }
                return "rotation";
            }
            return "scale";
        }
        return "position";
    }

    public final void A() {
        if (f8.b.a()) {
            f8.b.d("PhysicsWorld-Frame", "syncMoverChanging start ===========> mCurrentRunningBehaviors =:" + this.f32241b.size());
        }
        Iterator<c> it = this.f32241b.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null) {
                next.m();
                B(next);
                t(next);
                if (f8.b.a()) {
                    f8.b.d("PhysicsWorld-Frame", "updateBehavior : " + next);
                }
                if (next.s()) {
                    if (f8.b.b()) {
                        f8.b.c("syncMoverChanging : behavior is steady");
                    }
                    next.B();
                }
            }
        }
        this.f32243d = this.f32241b.isEmpty();
        if (f8.b.a()) {
            f8.b.d("PhysicsWorld-Frame", "syncMoverChanging end ===========> mCurrentRunningBehaviors =:" + this.f32241b.size());
        }
        if (this.f32243d) {
            u();
        } else {
            this.f32248i.d();
        }
    }

    public void B(c cVar) {
        cVar.D();
    }

    public void a(c cVar, InterfaceC1105a interfaceC1105a) {
        if (this.f32246g == null) {
            this.f32246g = new HashMap<>(1);
        }
        this.f32246g.put(cVar, interfaceC1105a);
    }

    public void b(c cVar, b bVar) {
        if (this.f32247h == null) {
            this.f32247h = new HashMap<>(1);
        }
        this.f32247h.put(cVar, bVar);
    }

    public <T extends c> T c(T t10) {
        Object obj;
        Object obj2;
        t10.c(this);
        int i10 = 0;
        while (i10 < this.f32242c.size()) {
            c m10 = this.f32242c.m(i10);
            if (m10 != null && (obj = m10.f32212n) != null && (obj2 = t10.f32212n) != null && obj == obj2 && m10.q() == t10.q() && v(m10)) {
                i10--;
            }
            i10++;
        }
        this.f32242c.add(t10);
        if (f8.b.b()) {
            f8.b.c("addBehavior behavior =:" + t10 + ",mAllBehaviors.size =:" + this.f32242c.size());
        }
        return t10;
    }

    public final C1051a d(m mVar, int i10) {
        C1051a f10 = f(this.f32249j.f().d(C1022a.d(mVar.f32259e.f31799a), C1022a.d(mVar.f32259e.f31800b)), 1, i10, C1022a.d(mVar.f32255a), C1022a.d(mVar.f32256b), i(i10));
        f10.f31938e.f();
        f10.l(true);
        return f10;
    }

    @Override // i8.e.a
    public void doFrame(long j10) {
        if (this.f32245f) {
            return;
        }
        y();
    }

    public C1051a f(f8.e eVar, int i10, int i11, float f10, float f11, String str) {
        return this.f32249j.a(eVar, i10, i11, f10, f11, str);
    }

    public h8.b g(h8.c cVar) {
        return this.f32249j.b(cVar);
    }

    public final void h() {
        this.f32249j = new C1052b();
        this.f32250k = f(new f8.e(), 0, 5, 0.0f, 0.0f, "Ground");
        if (f8.b.b()) {
            f8.b.c("createWorld : " + this);
        }
    }

    public boolean j(C1051a c1051a) {
        if (c1051a == null) {
            return false;
        }
        this.f32249j.c(c1051a);
        return true;
    }

    public boolean k(h8.b bVar) {
        this.f32249j.d(bVar);
        return true;
    }

    public C1051a l() {
        return this.f32250k;
    }

    public C1051a m(m mVar, int i10) {
        C1051a c1051a;
        if (f8.b.b()) {
            f8.b.c("getOrCreatePropertyBody : uiItem =:" + mVar + ",propertyType =:" + i10);
        }
        Iterator<c> it = this.f32242c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            m mVar2 = next.f32208j;
            if (mVar2 != null && mVar2 == mVar && (c1051a = next.f32209k) != null && c1051a.g() == i10) {
                return next.f32209k;
            }
        }
        return d(mVar, i10);
    }

    public m n(Object obj) {
        Object obj2;
        if (f8.b.b()) {
            f8.b.c("getOrCreateUIItem : target =:" + obj);
        }
        Iterator<c> it = this.f32242c.iterator();
        while (it.hasNext()) {
            m mVar = it.next().f32208j;
            if (mVar != null && (obj2 = mVar.f32257c) != null && obj != null && obj2 == obj) {
                return mVar;
            }
        }
        if (obj instanceof View) {
            View view = (View) obj;
            m b10 = new m(obj).b(view.getMeasuredWidth(), view.getMeasuredHeight());
            b10.c(view.getX(), view.getY());
            b10.d(view.getScaleX(), view.getScaleY());
            return b10;
        }
        if (obj instanceof m) {
            return (m) obj;
        }
        return new m().b(0.0f, 0.0f);
    }

    public final void o() {
        e eVar = new e();
        this.f32248i = eVar;
        eVar.e(this);
        p();
        h();
    }

    public final void p() {
        C1022a.e(this.f32240a.getResources().getDisplayMetrics().density);
        Display defaultDisplay = ((WindowManager) this.f32240a.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            C1022a.f(1.0f / defaultDisplay.getRefreshRate());
        }
        if (f8.b.b()) {
            f8.b.c("initConfig : sPhysicalSizeToPixelsRatio =:" + C1022a.f31794c + ",sSteadyAccuracy =:" + C1022a.f31793b + ",sRefreshRate =:" + C1022a.f31792a);
        }
    }

    public boolean q() {
        return this.f32244e;
    }

    public final void r(c cVar) {
        InterfaceC1105a interfaceC1105a;
        HashMap<c, InterfaceC1105a> hashMap = this.f32246g;
        if (hashMap != null && (interfaceC1105a = hashMap.get(cVar)) != null) {
            interfaceC1105a.onAnimationEnd(cVar);
        }
    }

    public final void s(c cVar) {
        InterfaceC1105a interfaceC1105a;
        HashMap<c, InterfaceC1105a> hashMap = this.f32246g;
        if (hashMap != null && (interfaceC1105a = hashMap.get(cVar)) != null) {
            interfaceC1105a.onAnimationStart(cVar);
        }
    }

    public final void t(c cVar) {
        b bVar;
        HashMap<c, b> hashMap = this.f32247h;
        if (hashMap != null && (bVar = hashMap.get(cVar)) != null) {
            bVar.onAnimationUpdate(cVar);
        }
    }

    public final void u() {
        if (!this.f32244e) {
            return;
        }
        this.f32248i.f();
        this.f32244e = false;
    }

    public boolean v(c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean remove = this.f32242c.remove(cVar);
        if (f8.b.b()) {
            f8.b.c("removeBehavior behavior =:" + cVar + ",removed =:" + remove);
        }
        if (remove) {
            cVar.y();
        }
        return remove;
    }

    public final void w() {
        if (this.f32244e) {
            return;
        }
        this.f32248i.d();
        this.f32244e = true;
    }

    public void x(c cVar) {
        Object obj;
        Object obj2;
        C1051a c1051a;
        C1051a c1051a2;
        if (!this.f32245f) {
            if (!this.f32241b.contains(cVar) || !this.f32244e) {
                if (f8.b.b()) {
                    f8.b.c("startBehavior behavior =:" + cVar);
                }
                int i10 = 0;
                while (i10 < this.f32241b.size()) {
                    c m10 = this.f32241b.m(i10);
                    if (m10 != null && (obj = m10.f32212n) != null && (obj2 = cVar.f32212n) != null && obj == obj2 && (c1051a = m10.f32209k) != null && (c1051a2 = cVar.f32209k) != null && c1051a == c1051a2 && m10.B()) {
                        i10--;
                    }
                    i10++;
                }
                this.f32241b.add(cVar);
                this.f32243d = false;
                w();
                s(cVar);
            }
        }
    }

    public final void y() {
        this.f32249j.i(C1022a.f31792a);
        A();
    }

    public void z(c cVar) {
        this.f32241b.remove(cVar);
        if (f8.b.b()) {
            f8.b.c("stopBehavior behavior =:" + cVar + ",mCurrentRunningBehaviors.size() =:" + this.f32241b.size());
        }
        r(cVar);
    }
}
