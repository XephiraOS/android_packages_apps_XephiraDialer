package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.d;
import androidx.constraintlayout.widget.e;
import androidx.constraintlayout.widget.f;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import s.c;
import t.C1573a;
import t.h;
import t.n;

/* compiled from: MotionScene.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final MotionLayout f8127a;

    /* renamed from: n, reason: collision with root package name */
    public MotionEvent f8140n;

    /* renamed from: q, reason: collision with root package name */
    public MotionLayout.f f8143q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8144r;

    /* renamed from: s, reason: collision with root package name */
    public float f8145s;

    /* renamed from: t, reason: collision with root package name */
    public float f8146t;

    /* renamed from: b, reason: collision with root package name */
    public f f8128b = null;

    /* renamed from: c, reason: collision with root package name */
    public b f8129c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8130d = false;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<b> f8131e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public b f8132f = null;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<b> f8133g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public SparseArray<androidx.constraintlayout.widget.b> f8134h = new SparseArray<>();

    /* renamed from: i, reason: collision with root package name */
    public HashMap<String, Integer> f8135i = new HashMap<>();

    /* renamed from: j, reason: collision with root package name */
    public SparseIntArray f8136j = new SparseIntArray();

    /* renamed from: k, reason: collision with root package name */
    public boolean f8137k = false;

    /* renamed from: l, reason: collision with root package name */
    public int f8138l = VibrateUtils.STRENGTH_OFFSET;

    /* renamed from: m, reason: collision with root package name */
    public int f8139m = 0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8141o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f8142p = false;

    /* compiled from: MotionScene.java */
    /* renamed from: androidx.constraintlayout.motion.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class InterpolatorC0102a implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f8147a;

        public InterpolatorC0102a(c cVar) {
            this.f8147a = cVar;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) this.f8147a.a(f10);
        }
    }

    public a(Context context, MotionLayout motionLayout, int i10) {
        this.f8127a = motionLayout;
        C(context, i10);
        SparseArray<androidx.constraintlayout.widget.b> sparseArray = this.f8134h;
        int i11 = d.f8791a;
        sparseArray.put(i11, new androidx.constraintlayout.widget.b());
        this.f8135i.put("motion_base", Integer.valueOf(i11));
    }

    public static String P(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1);
    }

    public final boolean A(int i10) {
        int i11 = this.f8136j.get(i10);
        int size = this.f8136j.size();
        while (i11 > 0) {
            if (i11 == i10) {
                return true;
            }
            int i12 = size - 1;
            if (size < 0) {
                return true;
            }
            i11 = this.f8136j.get(i11);
            size = i12;
        }
        return false;
    }

    public final boolean B() {
        if (this.f8143q != null) {
            return true;
        }
        return false;
    }

    public final void C(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            int eventType = xml.getEventType();
            b bVar = null;
            while (true) {
                char c10 = 1;
                if (eventType != 1) {
                    if (eventType != 0) {
                        if (eventType == 2) {
                            String name = xml.getName();
                            if (this.f8137k) {
                                System.out.println("parsing = " + name);
                            }
                            switch (name.hashCode()) {
                                case -1349929691:
                                    if (name.equals("ConstraintSet")) {
                                        c10 = 5;
                                        break;
                                    }
                                    break;
                                case -1239391468:
                                    if (name.equals("KeyFrameSet")) {
                                        c10 = 6;
                                        break;
                                    }
                                    break;
                                case 269306229:
                                    if (name.equals("Transition")) {
                                        break;
                                    }
                                    break;
                                case 312750793:
                                    if (name.equals("OnClick")) {
                                        c10 = 3;
                                        break;
                                    }
                                    break;
                                case 327855227:
                                    if (name.equals("OnSwipe")) {
                                        c10 = 2;
                                        break;
                                    }
                                    break;
                                case 793277014:
                                    if (name.equals("MotionScene")) {
                                        c10 = 0;
                                        break;
                                    }
                                    break;
                                case 1382829617:
                                    if (name.equals("StateSet")) {
                                        c10 = 4;
                                        break;
                                    }
                                    break;
                            }
                            c10 = 65535;
                            switch (c10) {
                                case 0:
                                    E(context, xml);
                                    break;
                                case 1:
                                    ArrayList<b> arrayList = this.f8131e;
                                    bVar = new b(this, context, xml);
                                    arrayList.add(bVar);
                                    if (this.f8129c == null && !bVar.f8150b) {
                                        this.f8129c = bVar;
                                        if (bVar.f8160l != null) {
                                            this.f8129c.f8160l.p(this.f8144r);
                                        }
                                    }
                                    if (!bVar.f8150b) {
                                        break;
                                    } else {
                                        if (bVar.f8151c == -1) {
                                            this.f8132f = bVar;
                                        } else {
                                            this.f8133g.add(bVar);
                                        }
                                        this.f8131e.remove(bVar);
                                        break;
                                    }
                                case 2:
                                    if (bVar == null) {
                                        Log.v("MotionScene", " OnSwipe (" + context.getResources().getResourceEntryName(i10) + ".xml:" + xml.getLineNumber() + ")");
                                    }
                                    bVar.f8160l = new androidx.constraintlayout.motion.widget.b(context, this.f8127a, xml);
                                    break;
                                case 3:
                                    bVar.t(context, xml);
                                    break;
                                case 4:
                                    this.f8128b = new f(context, xml);
                                    break;
                                case 5:
                                    D(context, xml);
                                    break;
                                case 6:
                                    bVar.f8159k.add(new h(context, xml));
                                    break;
                                default:
                                    Log.v("MotionScene", "WARNING UNKNOWN ATTRIBUTE " + name);
                                    break;
                            }
                        }
                    } else {
                        xml.getName();
                    }
                    eventType = xml.next();
                } else {
                    return;
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    public final void D(Context context, XmlPullParser xmlPullParser) {
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        bVar.C(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i10 = -1;
        int i11 = -1;
        for (int i12 = 0; i12 < attributeCount; i12++) {
            String attributeName = xmlPullParser.getAttributeName(i12);
            String attributeValue = xmlPullParser.getAttributeValue(i12);
            if (this.f8137k) {
                System.out.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            if (!attributeName.equals("deriveConstraintsFrom")) {
                if (attributeName.equals("id")) {
                    i10 = o(context, attributeValue);
                    this.f8135i.put(P(attributeValue), Integer.valueOf(i10));
                }
            } else {
                i11 = o(context, attributeValue);
            }
        }
        if (i10 != -1) {
            if (this.f8127a.f8012B != 0) {
                bVar.E(true);
            }
            bVar.x(context, xmlPullParser);
            if (i11 != -1) {
                this.f8136j.put(i10, i11);
            }
            this.f8134h.put(i10, bVar);
        }
    }

    public final void E(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), e.f8934P6);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == e.f8943Q6) {
                this.f8138l = obtainStyledAttributes.getInt(index, this.f8138l);
            } else if (index == e.f8952R6) {
                this.f8139m = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void F(float f10, float f11) {
        b bVar = this.f8129c;
        if (bVar != null && bVar.f8160l != null) {
            this.f8129c.f8160l.m(f10, f11);
        }
    }

    public void G(float f10, float f11) {
        b bVar = this.f8129c;
        if (bVar != null && bVar.f8160l != null) {
            this.f8129c.f8160l.n(f10, f11);
        }
    }

    public void H(MotionEvent motionEvent, int i10, MotionLayout motionLayout) {
        MotionLayout.f fVar;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.f8143q == null) {
            this.f8143q = this.f8127a.S();
        }
        this.f8143q.a(motionEvent);
        if (i10 != -1) {
            int action = motionEvent.getAction();
            boolean z10 = false;
            if (action != 0) {
                if (action == 2 && !this.f8141o) {
                    float rawY = motionEvent.getRawY() - this.f8146t;
                    float rawX = motionEvent.getRawX() - this.f8145s;
                    if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.f8140n) == null) {
                        return;
                    }
                    b g10 = g(i10, rawX, rawY, motionEvent2);
                    if (g10 != null) {
                        motionLayout.setTransition(g10);
                        RectF j10 = this.f8129c.f8160l.j(this.f8127a, rectF);
                        if (j10 != null && !j10.contains(this.f8140n.getX(), this.f8140n.getY())) {
                            z10 = true;
                        }
                        this.f8142p = z10;
                        this.f8129c.f8160l.q(this.f8145s, this.f8146t);
                    }
                }
            } else {
                this.f8145s = motionEvent.getRawX();
                this.f8146t = motionEvent.getRawY();
                this.f8140n = motionEvent;
                this.f8141o = false;
                if (this.f8129c.f8160l != null) {
                    RectF e10 = this.f8129c.f8160l.e(this.f8127a, rectF);
                    if (e10 != null && !e10.contains(this.f8140n.getX(), this.f8140n.getY())) {
                        this.f8140n = null;
                        this.f8141o = true;
                        return;
                    }
                    RectF j11 = this.f8129c.f8160l.j(this.f8127a, rectF);
                    if (j11 != null && !j11.contains(this.f8140n.getX(), this.f8140n.getY())) {
                        this.f8142p = true;
                    } else {
                        this.f8142p = false;
                    }
                    this.f8129c.f8160l.o(this.f8145s, this.f8146t);
                    return;
                }
                return;
            }
        }
        if (this.f8141o) {
            return;
        }
        b bVar = this.f8129c;
        if (bVar != null && bVar.f8160l != null && !this.f8142p) {
            this.f8129c.f8160l.l(motionEvent, this.f8143q, i10, this);
        }
        this.f8145s = motionEvent.getRawX();
        this.f8146t = motionEvent.getRawY();
        if (motionEvent.getAction() == 1 && (fVar = this.f8143q) != null) {
            fVar.b();
            this.f8143q = null;
            int i11 = motionLayout.f8042e;
            if (i11 != -1) {
                f(motionLayout, i11);
            }
        }
    }

    public final void I(int i10) {
        int i11 = this.f8136j.get(i10);
        if (i11 > 0) {
            I(this.f8136j.get(i10));
            androidx.constraintlayout.widget.b bVar = this.f8134h.get(i10);
            androidx.constraintlayout.widget.b bVar2 = this.f8134h.get(i11);
            if (bVar2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + C1573a.b(this.f8127a.getContext(), i11));
                return;
            }
            bVar.B(bVar2);
            this.f8136j.put(i10, -1);
        }
    }

    public void J(MotionLayout motionLayout) {
        for (int i10 = 0; i10 < this.f8134h.size(); i10++) {
            int keyAt = this.f8134h.keyAt(i10);
            if (A(keyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            I(keyAt);
        }
        for (int i11 = 0; i11 < this.f8134h.size(); i11++) {
            this.f8134h.valueAt(i11).A(motionLayout);
        }
    }

    public void K(int i10) {
        b bVar = this.f8129c;
        if (bVar != null) {
            bVar.F(i10);
        } else {
            this.f8138l = i10;
        }
    }

    public void L(boolean z10) {
        this.f8144r = z10;
        b bVar = this.f8129c;
        if (bVar != null && bVar.f8160l != null) {
            this.f8129c.f8160l.p(this.f8144r);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r2 != (-1)) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void M(int r7, int r8) {
        /*
            r6 = this;
            androidx.constraintlayout.widget.f r0 = r6.f8128b
            r1 = -1
            if (r0 == 0) goto L18
            int r0 = r0.c(r7, r1, r1)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r7
        Ld:
            androidx.constraintlayout.widget.f r2 = r6.f8128b
            int r2 = r2.c(r8, r1, r1)
            if (r2 == r1) goto L16
            goto L1a
        L16:
            r2 = r8
            goto L1a
        L18:
            r0 = r7
            goto L16
        L1a:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.a$b> r3 = r6.f8131e
            java.util.Iterator r3 = r3.iterator()
        L20:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L5a
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.a$b r4 = (androidx.constraintlayout.motion.widget.a.b) r4
            int r5 = androidx.constraintlayout.motion.widget.a.b.a(r4)
            if (r5 != r2) goto L38
            int r5 = androidx.constraintlayout.motion.widget.a.b.c(r4)
            if (r5 == r0) goto L44
        L38:
            int r5 = androidx.constraintlayout.motion.widget.a.b.a(r4)
            if (r5 != r8) goto L20
            int r5 = androidx.constraintlayout.motion.widget.a.b.c(r4)
            if (r5 != r7) goto L20
        L44:
            r6.f8129c = r4
            if (r4 == 0) goto L59
            androidx.constraintlayout.motion.widget.b r7 = androidx.constraintlayout.motion.widget.a.b.m(r4)
            if (r7 == 0) goto L59
            androidx.constraintlayout.motion.widget.a$b r7 = r6.f8129c
            androidx.constraintlayout.motion.widget.b r7 = androidx.constraintlayout.motion.widget.a.b.m(r7)
            boolean r6 = r6.f8144r
            r7.p(r6)
        L59:
            return
        L5a:
            androidx.constraintlayout.motion.widget.a$b r7 = r6.f8132f
            java.util.ArrayList<androidx.constraintlayout.motion.widget.a$b> r3 = r6.f8133g
            java.util.Iterator r3 = r3.iterator()
        L62:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L76
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.a$b r4 = (androidx.constraintlayout.motion.widget.a.b) r4
            int r5 = androidx.constraintlayout.motion.widget.a.b.a(r4)
            if (r5 != r8) goto L62
            r7 = r4
            goto L62
        L76:
            androidx.constraintlayout.motion.widget.a$b r8 = new androidx.constraintlayout.motion.widget.a$b
            r8.<init>(r6, r7)
            androidx.constraintlayout.motion.widget.a.b.d(r8, r0)
            androidx.constraintlayout.motion.widget.a.b.b(r8, r2)
            if (r0 == r1) goto L88
            java.util.ArrayList<androidx.constraintlayout.motion.widget.a$b> r7 = r6.f8131e
            r7.add(r8)
        L88:
            r6.f8129c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.a.M(int, int):void");
    }

    public void N(b bVar) {
        this.f8129c = bVar;
        if (bVar != null && bVar.f8160l != null) {
            this.f8129c.f8160l.p(this.f8144r);
        }
    }

    public void O() {
        b bVar = this.f8129c;
        if (bVar != null && bVar.f8160l != null) {
            this.f8129c.f8160l.r();
        }
    }

    public boolean Q() {
        Iterator<b> it = this.f8131e.iterator();
        while (it.hasNext()) {
            if (it.next().f8160l != null) {
                return true;
            }
        }
        b bVar = this.f8129c;
        if (bVar != null && bVar.f8160l != null) {
            return true;
        }
        return false;
    }

    public void e(MotionLayout motionLayout, int i10) {
        Iterator<b> it = this.f8131e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f8161m.size() > 0) {
                Iterator it2 = next.f8161m.iterator();
                while (it2.hasNext()) {
                    ((b.ViewOnClickListenerC0103a) it2.next()).c(motionLayout);
                }
            }
        }
        Iterator<b> it3 = this.f8133g.iterator();
        while (it3.hasNext()) {
            b next2 = it3.next();
            if (next2.f8161m.size() > 0) {
                Iterator it4 = next2.f8161m.iterator();
                while (it4.hasNext()) {
                    ((b.ViewOnClickListenerC0103a) it4.next()).c(motionLayout);
                }
            }
        }
        Iterator<b> it5 = this.f8131e.iterator();
        while (it5.hasNext()) {
            b next3 = it5.next();
            if (next3.f8161m.size() > 0) {
                Iterator it6 = next3.f8161m.iterator();
                while (it6.hasNext()) {
                    ((b.ViewOnClickListenerC0103a) it6.next()).a(motionLayout, i10, next3);
                }
            }
        }
        Iterator<b> it7 = this.f8133g.iterator();
        while (it7.hasNext()) {
            b next4 = it7.next();
            if (next4.f8161m.size() > 0) {
                Iterator it8 = next4.f8161m.iterator();
                while (it8.hasNext()) {
                    ((b.ViewOnClickListenerC0103a) it8.next()).a(motionLayout, i10, next4);
                }
            }
        }
    }

    public boolean f(MotionLayout motionLayout, int i10) {
        if (B() || this.f8130d) {
            return false;
        }
        Iterator<b> it = this.f8131e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f8162n != 0 && this.f8129c != next) {
                if (i10 == next.f8152d && (next.f8162n == 4 || next.f8162n == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(next);
                    if (next.f8162n == 4) {
                        motionLayout.a0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.H(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.T();
                    }
                    return true;
                }
                if (i10 == next.f8151c && (next.f8162n == 3 || next.f8162n == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(next);
                    if (next.f8162n == 3) {
                        motionLayout.b0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.H(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.T();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public b g(int i10, float f10, float f11, MotionEvent motionEvent) {
        float f12;
        if (i10 != -1) {
            List<b> z10 = z(i10);
            RectF rectF = new RectF();
            float f13 = 0.0f;
            b bVar = null;
            for (b bVar2 : z10) {
                if (!bVar2.f8163o && bVar2.f8160l != null) {
                    bVar2.f8160l.p(this.f8144r);
                    RectF j10 = bVar2.f8160l.j(this.f8127a, rectF);
                    if (j10 == null || motionEvent == null || j10.contains(motionEvent.getX(), motionEvent.getY())) {
                        RectF j11 = bVar2.f8160l.j(this.f8127a, rectF);
                        if (j11 == null || motionEvent == null || j11.contains(motionEvent.getX(), motionEvent.getY())) {
                            float a10 = bVar2.f8160l.a(f10, f11);
                            if (bVar2.f8151c == i10) {
                                f12 = -1.0f;
                            } else {
                                f12 = 1.1f;
                            }
                            float f14 = a10 * f12;
                            if (f14 > f13) {
                                bVar = bVar2;
                                f13 = f14;
                            }
                        }
                    }
                }
            }
            return bVar;
        }
        return this.f8129c;
    }

    public int h() {
        b bVar = this.f8129c;
        if (bVar != null) {
            return bVar.f8164p;
        }
        return -1;
    }

    public androidx.constraintlayout.widget.b i(int i10) {
        return j(i10, -1, -1);
    }

    public androidx.constraintlayout.widget.b j(int i10, int i11, int i12) {
        int c10;
        if (this.f8137k) {
            PrintStream printStream = System.out;
            printStream.println("id " + i10);
            printStream.println("size " + this.f8134h.size());
        }
        f fVar = this.f8128b;
        if (fVar != null && (c10 = fVar.c(i10, i11, i12)) != -1) {
            i10 = c10;
        }
        if (this.f8134h.get(i10) == null) {
            Log.e("MotionScene", "Warning could not find ConstraintSet id/" + C1573a.b(this.f8127a.getContext(), i10) + " In MotionScene");
            SparseArray<androidx.constraintlayout.widget.b> sparseArray = this.f8134h;
            return sparseArray.get(sparseArray.keyAt(0));
        }
        return this.f8134h.get(i10);
    }

    public int[] k() {
        int size = this.f8134h.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = this.f8134h.keyAt(i10);
        }
        return iArr;
    }

    public ArrayList<b> l() {
        return this.f8131e;
    }

    public int m() {
        b bVar = this.f8129c;
        if (bVar != null) {
            return bVar.f8156h;
        }
        return this.f8138l;
    }

    public int n() {
        b bVar = this.f8129c;
        if (bVar != null) {
            return bVar.f8151c;
        }
        return -1;
    }

    public final int o(Context context, String str) {
        int i10;
        if (str.contains("/")) {
            i10 = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.f8137k) {
                System.out.println("id getMap res = " + i10);
            }
        } else {
            i10 = -1;
        }
        if (i10 == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e("MotionScene", "error in parsing id");
            return i10;
        }
        return i10;
    }

    public Interpolator p() {
        int i10 = this.f8129c.f8153e;
        if (i10 != -2) {
            if (i10 != -1) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 4) {
                                if (i10 != 5) {
                                    return null;
                                }
                                return new BounceInterpolator();
                            }
                            return new AnticipateInterpolator();
                        }
                        return new DecelerateInterpolator();
                    }
                    return new AccelerateInterpolator();
                }
                return new AccelerateDecelerateInterpolator();
            }
            return new InterpolatorC0102a(c.c(this.f8129c.f8154f));
        }
        return AnimationUtils.loadInterpolator(this.f8127a.getContext(), this.f8129c.f8155g);
    }

    public void q(n nVar) {
        b bVar = this.f8129c;
        if (bVar == null) {
            b bVar2 = this.f8132f;
            if (bVar2 != null) {
                Iterator it = bVar2.f8159k.iterator();
                while (it.hasNext()) {
                    ((h) it.next()).a(nVar);
                }
                return;
            }
            return;
        }
        Iterator it2 = bVar.f8159k.iterator();
        while (it2.hasNext()) {
            ((h) it2.next()).a(nVar);
        }
    }

    public float r() {
        b bVar = this.f8129c;
        if (bVar != null && bVar.f8160l != null) {
            return this.f8129c.f8160l.f();
        }
        return 0.0f;
    }

    public float s() {
        b bVar = this.f8129c;
        if (bVar != null && bVar.f8160l != null) {
            return this.f8129c.f8160l.g();
        }
        return 0.0f;
    }

    public boolean t() {
        b bVar = this.f8129c;
        if (bVar != null && bVar.f8160l != null) {
            return this.f8129c.f8160l.h();
        }
        return false;
    }

    public float u(float f10, float f11) {
        b bVar = this.f8129c;
        if (bVar != null && bVar.f8160l != null) {
            return this.f8129c.f8160l.i(f10, f11);
        }
        return 0.0f;
    }

    public final int v(int i10) {
        int c10;
        f fVar = this.f8128b;
        if (fVar != null && (c10 = fVar.c(i10, -1, -1)) != -1) {
            return c10;
        }
        return i10;
    }

    public float w() {
        b bVar = this.f8129c;
        if (bVar != null) {
            return bVar.f8157i;
        }
        return 0.0f;
    }

    public int x() {
        b bVar = this.f8129c;
        if (bVar != null) {
            return bVar.f8152d;
        }
        return -1;
    }

    public b y(int i10) {
        Iterator<b> it = this.f8131e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f8149a == i10) {
                return next;
            }
        }
        return null;
    }

    public List<b> z(int i10) {
        int v10 = v(i10);
        ArrayList arrayList = new ArrayList();
        Iterator<b> it = this.f8131e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.f8152d == v10 || next.f8151c == v10) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* compiled from: MotionScene.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f8149a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f8150b;

        /* renamed from: c, reason: collision with root package name */
        public int f8151c;

        /* renamed from: d, reason: collision with root package name */
        public int f8152d;

        /* renamed from: e, reason: collision with root package name */
        public int f8153e;

        /* renamed from: f, reason: collision with root package name */
        public String f8154f;

        /* renamed from: g, reason: collision with root package name */
        public int f8155g;

        /* renamed from: h, reason: collision with root package name */
        public int f8156h;

        /* renamed from: i, reason: collision with root package name */
        public float f8157i;

        /* renamed from: j, reason: collision with root package name */
        public final a f8158j;

        /* renamed from: k, reason: collision with root package name */
        public ArrayList<h> f8159k;

        /* renamed from: l, reason: collision with root package name */
        public androidx.constraintlayout.motion.widget.b f8160l;

        /* renamed from: m, reason: collision with root package name */
        public ArrayList<ViewOnClickListenerC0103a> f8161m;

        /* renamed from: n, reason: collision with root package name */
        public int f8162n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f8163o;

        /* renamed from: p, reason: collision with root package name */
        public int f8164p;

        /* renamed from: q, reason: collision with root package name */
        public int f8165q;

        /* renamed from: r, reason: collision with root package name */
        public int f8166r;

        /* compiled from: MotionScene.java */
        /* renamed from: androidx.constraintlayout.motion.widget.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class ViewOnClickListenerC0103a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final b f8167a;

            /* renamed from: b, reason: collision with root package name */
            public int f8168b;

            /* renamed from: c, reason: collision with root package name */
            public int f8169c;

            public ViewOnClickListenerC0103a(Context context, b bVar, XmlPullParser xmlPullParser) {
                this.f8168b = -1;
                this.f8169c = 17;
                this.f8167a = bVar;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), e.f8997W6);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i10 = 0; i10 < indexCount; i10++) {
                    int index = obtainStyledAttributes.getIndex(i10);
                    if (index == e.f9015Y6) {
                        this.f8168b = obtainStyledAttributes.getResourceId(index, this.f8168b);
                    } else if (index == e.f9006X6) {
                        this.f8169c = obtainStyledAttributes.getInt(index, this.f8169c);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v4, types: [android.view.View] */
            public void a(MotionLayout motionLayout, int i10, b bVar) {
                boolean z10;
                boolean z11;
                boolean z12;
                boolean z13;
                int i11 = this.f8168b;
                MotionLayout motionLayout2 = motionLayout;
                if (i11 != -1) {
                    motionLayout2 = motionLayout.findViewById(i11);
                }
                if (motionLayout2 != null) {
                    int i12 = bVar.f8152d;
                    int i13 = bVar.f8151c;
                    if (i12 == -1) {
                        motionLayout2.setOnClickListener(this);
                        return;
                    }
                    int i14 = this.f8169c;
                    boolean z14 = false;
                    if ((i14 & 1) != 0 && i10 == i12) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if ((i14 & 256) != 0 && i10 == i12) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean z15 = z10 | z11;
                    if ((i14 & 1) != 0 && i10 == i12) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z16 = z12 | z15;
                    if ((i14 & 16) != 0 && i10 == i13) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean z17 = z16 | z13;
                    if ((i14 & 4096) != 0 && i10 == i13) {
                        z14 = true;
                    }
                    if (z17 | z14) {
                        motionLayout2.setOnClickListener(this);
                        return;
                    }
                    return;
                }
                Log.e("MotionScene", "OnClick could not find id " + this.f8168b);
            }

            public boolean b(b bVar, MotionLayout motionLayout) {
                b bVar2 = this.f8167a;
                if (bVar2 != bVar) {
                    int i10 = bVar2.f8151c;
                    int i11 = this.f8167a.f8152d;
                    if (i11 == -1) {
                        if (motionLayout.f8042e != i10) {
                            return true;
                        }
                        return false;
                    }
                    int i12 = motionLayout.f8042e;
                    if (i12 == i11 || i12 == i10) {
                        return true;
                    }
                    return false;
                }
                return true;
            }

            public void c(MotionLayout motionLayout) {
                int i10 = this.f8168b;
                if (i10 == -1) {
                    return;
                }
                View findViewById = motionLayout.findViewById(i10);
                if (findViewById == null) {
                    Log.e("MotionScene", " (*)  could not find id " + this.f8168b);
                    return;
                }
                findViewById.setOnClickListener(null);
            }

            /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
            /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onClick(android.view.View r8) {
                /*
                    Method dump skipped, instructions count: 228
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.a.b.ViewOnClickListenerC0103a.onClick(android.view.View):void");
            }
        }

        public b(a aVar, b bVar) {
            this.f8149a = -1;
            this.f8150b = false;
            this.f8151c = -1;
            this.f8152d = -1;
            this.f8153e = 0;
            this.f8154f = null;
            this.f8155g = -1;
            this.f8156h = VibrateUtils.STRENGTH_OFFSET;
            this.f8157i = 0.0f;
            this.f8159k = new ArrayList<>();
            this.f8160l = null;
            this.f8161m = new ArrayList<>();
            this.f8162n = 0;
            this.f8163o = false;
            this.f8164p = -1;
            this.f8165q = 0;
            this.f8166r = 0;
            this.f8158j = aVar;
            if (bVar != null) {
                this.f8164p = bVar.f8164p;
                this.f8153e = bVar.f8153e;
                this.f8154f = bVar.f8154f;
                this.f8155g = bVar.f8155g;
                this.f8156h = bVar.f8156h;
                this.f8159k = bVar.f8159k;
                this.f8157i = bVar.f8157i;
                this.f8165q = bVar.f8165q;
            }
        }

        public int A() {
            return this.f8165q;
        }

        public int B() {
            return this.f8152d;
        }

        public androidx.constraintlayout.motion.widget.b C() {
            return this.f8160l;
        }

        public boolean D() {
            return !this.f8163o;
        }

        public boolean E(int i10) {
            if ((this.f8166r & i10) != 0) {
                return true;
            }
            return false;
        }

        public void F(int i10) {
            this.f8156h = i10;
        }

        public void t(Context context, XmlPullParser xmlPullParser) {
            this.f8161m.add(new ViewOnClickListenerC0103a(context, this, xmlPullParser));
        }

        public String u(Context context) {
            String resourceEntryName;
            if (this.f8152d == -1) {
                resourceEntryName = "null";
            } else {
                resourceEntryName = context.getResources().getResourceEntryName(this.f8152d);
            }
            if (this.f8151c == -1) {
                return resourceEntryName + " -> null";
            }
            return resourceEntryName + " -> " + context.getResources().getResourceEntryName(this.f8151c);
        }

        public final void v(a aVar, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                if (index == e.f8989V7) {
                    this.f8151c = typedArray.getResourceId(index, this.f8151c);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.f8151c))) {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        bVar.w(context, this.f8151c);
                        aVar.f8134h.append(this.f8151c, bVar);
                    }
                } else if (index == e.f8998W7) {
                    this.f8152d = typedArray.getResourceId(index, this.f8152d);
                    if ("layout".equals(context.getResources().getResourceTypeName(this.f8152d))) {
                        androidx.constraintlayout.widget.b bVar2 = new androidx.constraintlayout.widget.b();
                        bVar2.w(context, this.f8152d);
                        aVar.f8134h.append(this.f8152d, bVar2);
                    }
                } else if (index == e.f9025Z7) {
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.f8155g = resourceId;
                        if (resourceId != -1) {
                            this.f8153e = -2;
                        }
                    } else if (i11 == 3) {
                        String string = typedArray.getString(index);
                        this.f8154f = string;
                        if (string.indexOf("/") > 0) {
                            this.f8155g = typedArray.getResourceId(index, -1);
                            this.f8153e = -2;
                        } else {
                            this.f8153e = -1;
                        }
                    } else {
                        this.f8153e = typedArray.getInteger(index, this.f8153e);
                    }
                } else if (index == e.f9007X7) {
                    this.f8156h = typedArray.getInt(index, this.f8156h);
                } else if (index == e.f9045b8) {
                    this.f8157i = typedArray.getFloat(index, this.f8157i);
                } else if (index == e.f8980U7) {
                    this.f8162n = typedArray.getInteger(index, this.f8162n);
                } else if (index == e.f8971T7) {
                    this.f8149a = typedArray.getResourceId(index, this.f8149a);
                } else if (index == e.f9055c8) {
                    this.f8163o = typedArray.getBoolean(index, this.f8163o);
                } else if (index == e.f9035a8) {
                    this.f8164p = typedArray.getInteger(index, -1);
                } else if (index == e.f9016Y7) {
                    this.f8165q = typedArray.getInteger(index, 0);
                } else if (index == e.f9065d8) {
                    this.f8166r = typedArray.getInteger(index, 0);
                }
            }
            if (this.f8152d == -1) {
                this.f8150b = true;
            }
        }

        public final void w(a aVar, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f8962S7);
            v(aVar, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public int x() {
            return this.f8162n;
        }

        public int y() {
            return this.f8156h;
        }

        public int z() {
            return this.f8151c;
        }

        public b(a aVar, Context context, XmlPullParser xmlPullParser) {
            this.f8149a = -1;
            this.f8150b = false;
            this.f8151c = -1;
            this.f8152d = -1;
            this.f8153e = 0;
            this.f8154f = null;
            this.f8155g = -1;
            this.f8156h = VibrateUtils.STRENGTH_OFFSET;
            this.f8157i = 0.0f;
            this.f8159k = new ArrayList<>();
            this.f8160l = null;
            this.f8161m = new ArrayList<>();
            this.f8162n = 0;
            this.f8163o = false;
            this.f8164p = -1;
            this.f8165q = 0;
            this.f8166r = 0;
            this.f8156h = aVar.f8138l;
            this.f8165q = aVar.f8139m;
            this.f8158j = aVar;
            w(aVar, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}
