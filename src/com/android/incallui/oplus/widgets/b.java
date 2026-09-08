package com.android.incallui.oplus.widgets;

import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.oplus.widgets.c;

/* compiled from: OplusAntiTouchByMistake.java */
/* loaded from: classes.dex */
public class b implements c.InterfaceC0185c, E2.b {

    /* renamed from: c, reason: collision with root package name */
    public boolean f19161c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19162d;

    /* renamed from: e, reason: collision with root package name */
    public a f19163e;

    /* renamed from: b, reason: collision with root package name */
    public int f19160b = 0;

    /* renamed from: a, reason: collision with root package name */
    public c f19159a = InCallPresenter.getInstance().realInstance().getOplusScheduledGenerator();

    /* compiled from: OplusAntiTouchByMistake.java */
    /* loaded from: classes.dex */
    public interface a {
        void c();
    }

    public b(a aVar) {
        this.f19163e = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x001e, code lost:
    
        if (r4 != 6) goto L33;
     */
    @Override // E2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.view.MotionEvent r4) {
        /*
            r3 = this;
            r0 = 0
            java.lang.String r1 = "OplusAntiTouchByMistake"
            if (r4 != 0) goto Lb
            java.lang.String r3 = "onTouchEvent: MotionEvent is null"
            com.android.incallui.Log.v(r1, r3)
            return r0
        Lb:
            int r4 = r4.getAction()
            if (r4 == 0) goto L42
            r2 = 1
            if (r4 == r2) goto L35
            r2 = 2
            if (r4 == r2) goto L2b
            r2 = 3
            if (r4 == r2) goto L21
            r2 = 5
            if (r4 == r2) goto L42
            r2 = 6
            if (r4 == r2) goto L35
            goto L4e
        L21:
            boolean r3 = com.android.incallui.Log.sDebug
            if (r3 == 0) goto L4e
            java.lang.String r3 = "*** CANCEL ***"
            com.android.incallui.Log.v(r1, r3)
            goto L4e
        L2b:
            boolean r3 = com.android.incallui.Log.sDebug
            if (r3 == 0) goto L4e
            java.lang.String r3 = "*** MOVE ***"
            com.android.incallui.Log.v(r1, r3)
            goto L4e
        L35:
            boolean r4 = com.android.incallui.Log.sDebug
            if (r4 == 0) goto L3e
            java.lang.String r4 = "*** UP ***"
            com.android.incallui.Log.v(r1, r4)
        L3e:
            r3.f()
            goto L4e
        L42:
            boolean r4 = com.android.incallui.Log.sDebug
            if (r4 == 0) goto L4b
            java.lang.String r4 = "*** DOWN ***"
            com.android.incallui.Log.v(r1, r4)
        L4b:
            r3.e()
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.oplus.widgets.b.a(android.view.MotionEvent):boolean");
    }

    @Override // com.android.incallui.oplus.widgets.c.InterfaceC0185c
    public void b() {
        this.f19160b++;
        if (Log.sDebug) {
            Log.v("OplusAntiTouchByMistake", "onScheduled  mDownTimeDuration = " + this.f19160b + " FIRST_LONG_PRESS_TIME = 500");
        }
        int i10 = this.f19160b * 100;
        if (!this.f19161c && i10 >= 500) {
            this.f19161c = true;
            return;
        }
        if (!this.f19162d && i10 >= 5000) {
            this.f19162d = true;
            c();
            c cVar = this.f19159a;
            if (cVar != null) {
                cVar.e(this);
            }
        }
    }

    public void c() {
        if (Log.sDebug) {
            Log.d("OplusAntiTouchByMistake", "cancelPressState");
        }
        a aVar = this.f19163e;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void d() {
        this.f19161c = false;
        this.f19162d = false;
    }

    public void e() {
        this.f19160b = 0;
        d();
        c cVar = this.f19159a;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public void f() {
        if (this.f19161c && !this.f19162d) {
            c();
        }
        c cVar = this.f19159a;
        if (cVar != null) {
            cVar.e(this);
        }
    }
}
