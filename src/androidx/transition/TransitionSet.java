package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TransitionSet extends Transition {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<Transition> f11666a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11667b;

    /* renamed from: c, reason: collision with root package name */
    public int f11668c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11669d;

    /* renamed from: e, reason: collision with root package name */
    public int f11670e;

    /* loaded from: classes.dex */
    public class a extends x {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Transition f11671a;

        public a(Transition transition) {
            this.f11671a = transition;
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void d(Transition transition) {
            this.f11671a.runAnimators();
            transition.removeListener(this);
        }
    }

    /* loaded from: classes.dex */
    public class b extends x {
        public b() {
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void e(Transition transition) {
            TransitionSet.this.f11666a.remove(transition);
            if (!TransitionSet.this.hasAnimators()) {
                TransitionSet.this.notifyListeners(Transition.j.f11663c, false);
                TransitionSet transitionSet = TransitionSet.this;
                transitionSet.mEnded = true;
                transitionSet.notifyListeners(Transition.j.f11662b, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends x {

        /* renamed from: a, reason: collision with root package name */
        public TransitionSet f11674a;

        public c(TransitionSet transitionSet) {
            this.f11674a = transitionSet;
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void a(Transition transition) {
            TransitionSet transitionSet = this.f11674a;
            if (!transitionSet.f11669d) {
                transitionSet.start();
                this.f11674a.f11669d = true;
            }
        }

        @Override // androidx.transition.x, androidx.transition.Transition.i
        public void d(Transition transition) {
            TransitionSet transitionSet = this.f11674a;
            int i10 = transitionSet.f11668c - 1;
            transitionSet.f11668c = i10;
            if (i10 == 0) {
                transitionSet.f11669d = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }
    }

    public TransitionSet() {
        this.f11666a = new ArrayList<>();
        this.f11667b = true;
        this.f11669d = false;
        this.f11670e = 0;
    }

    @Override // androidx.transition.Transition
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public TransitionSet addListener(Transition.i iVar) {
        return (TransitionSet) super.addListener(iVar);
    }

    @Override // androidx.transition.Transition
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public TransitionSet addTarget(int i10) {
        for (int i11 = 0; i11 < this.f11666a.size(); i11++) {
            this.f11666a.get(i11).addTarget(i10);
        }
        return (TransitionSet) super.addTarget(i10);
    }

    @Override // androidx.transition.Transition
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public TransitionSet addTarget(View view) {
        for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
            this.f11666a.get(i10).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    @Override // androidx.transition.Transition
    public void cancel() {
        super.cancel();
        int size = this.f11666a.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11666a.get(i10).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C c10) {
        if (isValidTarget(c10.f11528b)) {
            Iterator<Transition> it = this.f11666a.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(c10.f11528b)) {
                    next.captureEndValues(c10);
                    c10.f11529c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void capturePropagationValues(C c10) {
        super.capturePropagationValues(c10);
        int size = this.f11666a.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11666a.get(i10).capturePropagationValues(c10);
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C c10) {
        if (isValidTarget(c10.f11528b)) {
            Iterator<Transition> it = this.f11666a.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(c10.f11528b)) {
                    next.captureStartValues(c10);
                    c10.f11529c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void createAnimators(ViewGroup viewGroup, D d10, D d11, ArrayList<C> arrayList, ArrayList<C> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f11666a.size();
        for (int i10 = 0; i10 < size; i10++) {
            Transition transition = this.f11666a.get(i10);
            if (startDelay > 0 && (this.f11667b || i10 == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, d10, d11, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public TransitionSet addTarget(Class<?> cls) {
        for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
            this.f11666a.get(i10).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @Override // androidx.transition.Transition
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public TransitionSet addTarget(String str) {
        for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
            this.f11666a.get(i10).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(View view, boolean z10) {
        for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
            this.f11666a.get(i10).excludeTarget(view, z10);
        }
        return super.excludeTarget(view, z10);
    }

    public TransitionSet f(Transition transition) {
        g(transition);
        long j10 = this.mDuration;
        if (j10 >= 0) {
            transition.setDuration(j10);
        }
        if ((this.f11670e & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.f11670e & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.f11670e & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.f11670e & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f11666a.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11666a.get(i10).forceToEnd(viewGroup);
        }
    }

    public final void g(Transition transition) {
        this.f11666a.add(transition);
        transition.mParent = this;
    }

    public Transition h(int i10) {
        if (i10 >= 0 && i10 < this.f11666a.size()) {
            return this.f11666a.get(i10);
        }
        return null;
    }

    @Override // androidx.transition.Transition
    public boolean hasAnimators() {
        for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
            if (this.f11666a.get(i10).hasAnimators()) {
                return true;
            }
        }
        return false;
    }

    public int i() {
        return this.f11666a.size();
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        int size = this.f11666a.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f11666a.get(i10).isSeekingSupported()) {
                return false;
            }
        }
        return true;
    }

    public final int j(long j10) {
        for (int i10 = 1; i10 < this.f11666a.size(); i10++) {
            if (this.f11666a.get(i10).mSeekOffsetInParent > j10) {
                return i10 - 1;
            }
        }
        return this.f11666a.size() - 1;
    }

    @Override // androidx.transition.Transition
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public TransitionSet removeListener(Transition.i iVar) {
        return (TransitionSet) super.removeListener(iVar);
    }

    @Override // androidx.transition.Transition
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public TransitionSet removeTarget(int i10) {
        for (int i11 = 0; i11 < this.f11666a.size(); i11++) {
            this.f11666a.get(i11).removeTarget(i10);
        }
        return (TransitionSet) super.removeTarget(i10);
    }

    @Override // androidx.transition.Transition
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public TransitionSet removeTarget(View view) {
        for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
            this.f11666a.get(i10).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    @Override // androidx.transition.Transition
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public TransitionSet removeTarget(Class<?> cls) {
        for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
            this.f11666a.get(i10).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    @Override // androidx.transition.Transition
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public TransitionSet removeTarget(String str) {
        for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
            this.f11666a.get(i10).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }

    @Override // androidx.transition.Transition
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public TransitionSet setDuration(long j10) {
        ArrayList<Transition> arrayList;
        super.setDuration(j10);
        if (this.mDuration >= 0 && (arrayList = this.f11666a) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f11666a.get(i10).setDuration(j10);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void pause(View view) {
        super.pause(view);
        int size = this.f11666a.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11666a.get(i10).pause(view);
        }
    }

    @Override // androidx.transition.Transition
    public void prepareAnimatorsForSeeking() {
        this.mTotalDuration = 0L;
        b bVar = new b();
        for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
            Transition transition = this.f11666a.get(i10);
            transition.addListener(bVar);
            transition.prepareAnimatorsForSeeking();
            long totalDurationMillis = transition.getTotalDurationMillis();
            if (this.f11667b) {
                this.mTotalDuration = Math.max(this.mTotalDuration, totalDurationMillis);
            } else {
                long j10 = this.mTotalDuration;
                transition.mSeekOffsetInParent = j10;
                this.mTotalDuration = j10 + totalDurationMillis;
            }
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        this.f11670e |= 1;
        ArrayList<Transition> arrayList = this.f11666a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f11666a.get(i10).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    public TransitionSet r(int i10) {
        if (i10 != 0) {
            if (i10 == 1) {
                this.f11667b = false;
            } else {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
            }
        } else {
            this.f11667b = true;
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void resume(View view) {
        super.resume(view);
        int size = this.f11666a.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11666a.get(i10).resume(view);
        }
    }

    @Override // androidx.transition.Transition
    public void runAnimators() {
        if (this.f11666a.isEmpty()) {
            start();
            end();
            return;
        }
        t();
        if (!this.f11667b) {
            for (int i10 = 1; i10 < this.f11666a.size(); i10++) {
                this.f11666a.get(i10 - 1).addListener(new a(this.f11666a.get(i10)));
            }
            Transition transition = this.f11666a.get(0);
            if (transition != null) {
                transition.runAnimators();
                return;
            }
            return;
        }
        Iterator<Transition> it = this.f11666a.iterator();
        while (it.hasNext()) {
            it.next().runAnimators();
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public TransitionSet setStartDelay(long j10) {
        return (TransitionSet) super.setStartDelay(j10);
    }

    @Override // androidx.transition.Transition
    public void setCanRemoveViews(boolean z10) {
        super.setCanRemoveViews(z10);
        int size = this.f11666a.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11666a.get(i10).setCanRemoveViews(z10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @Override // androidx.transition.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setCurrentPlayTimeMillis(long r19, long r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r3 = r21
            long r5 = r18.getTotalDurationMillis()
            androidx.transition.TransitionSet r7 = r0.mParent
            r8 = 0
            if (r7 == 0) goto L21
            int r7 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r7 >= 0) goto L18
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 < 0) goto L20
        L18:
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L21
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L21
        L20:
            return
        L21:
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r10 = 0
            if (r7 >= 0) goto L28
            r12 = 1
            goto L29
        L28:
            r12 = r10
        L29:
            int r13 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r13 < 0) goto L31
            int r14 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r14 < 0) goto L39
        L31:
            int r14 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r14 > 0) goto L40
            int r14 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r14 <= 0) goto L40
        L39:
            r0.mEnded = r10
            androidx.transition.Transition$j r14 = androidx.transition.Transition.j.f11661a
            r0.notifyListeners(r14, r12)
        L40:
            boolean r14 = r0.f11667b
            if (r14 == 0) goto L5d
        L44:
            java.util.ArrayList<androidx.transition.Transition> r7 = r0.f11666a
            int r7 = r7.size()
            if (r10 >= r7) goto L5a
            java.util.ArrayList<androidx.transition.Transition> r7 = r0.f11666a
            java.lang.Object r7 = r7.get(r10)
            androidx.transition.Transition r7 = (androidx.transition.Transition) r7
            r7.setCurrentPlayTimeMillis(r1, r3)
            int r10 = r10 + 1
            goto L44
        L5a:
            r16 = r12
            goto La5
        L5d:
            int r10 = r0.j(r3)
            if (r7 < 0) goto L88
        L63:
            java.util.ArrayList<androidx.transition.Transition> r7 = r0.f11666a
            int r7 = r7.size()
            if (r10 >= r7) goto L5a
            java.util.ArrayList<androidx.transition.Transition> r7 = r0.f11666a
            java.lang.Object r7 = r7.get(r10)
            androidx.transition.Transition r7 = (androidx.transition.Transition) r7
            long r14 = r7.mSeekOffsetInParent
            r16 = r12
            long r11 = r1 - r14
            int r17 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r17 >= 0) goto L7e
            goto La5
        L7e:
            long r14 = r3 - r14
            r7.setCurrentPlayTimeMillis(r11, r14)
            int r10 = r10 + 1
            r12 = r16
            goto L63
        L88:
            r16 = r12
        L8a:
            if (r10 < 0) goto La5
            java.util.ArrayList<androidx.transition.Transition> r7 = r0.f11666a
            java.lang.Object r7 = r7.get(r10)
            androidx.transition.Transition r7 = (androidx.transition.Transition) r7
            long r11 = r7.mSeekOffsetInParent
            long r14 = r1 - r11
            long r11 = r3 - r11
            r7.setCurrentPlayTimeMillis(r14, r11)
            int r7 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r7 < 0) goto La2
            goto La5
        La2:
            int r10 = r10 + (-1)
            goto L8a
        La5:
            androidx.transition.TransitionSet r7 = r0.mParent
            if (r7 == 0) goto Lc3
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto Lb1
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 <= 0) goto Lb7
        Lb1:
            if (r13 >= 0) goto Lc3
            int r2 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r2 < 0) goto Lc3
        Lb7:
            if (r1 <= 0) goto Lbc
            r1 = 1
            r0.mEnded = r1
        Lbc:
            androidx.transition.Transition$j r1 = androidx.transition.Transition.j.f11662b
            r11 = r16
            r0.notifyListeners(r1, r11)
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionSet.setCurrentPlayTimeMillis(long, long):void");
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.f fVar) {
        super.setEpicenterCallback(fVar);
        this.f11670e |= 8;
        int size = this.f11666a.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11666a.get(i10).setEpicenterCallback(fVar);
        }
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f11670e |= 4;
        if (this.f11666a != null) {
            for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
                this.f11666a.get(i10).setPathMotion(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(z zVar) {
        super.setPropagation(zVar);
        this.f11670e |= 2;
        int size = this.f11666a.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11666a.get(i10).setPropagation(zVar);
        }
    }

    public final void t() {
        c cVar = new c(this);
        Iterator<Transition> it = this.f11666a.iterator();
        while (it.hasNext()) {
            it.next().addListener(cVar);
        }
        this.f11668c = this.f11666a.size();
    }

    @Override // androidx.transition.Transition
    public String toString(String str) {
        String transition = super.toString(str);
        for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
            StringBuilder sb = new StringBuilder();
            sb.append(transition);
            sb.append("\n");
            sb.append(this.f11666a.get(i10).toString(str + "  "));
            transition = sb.toString();
        }
        return transition;
    }

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public Transition mo0clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo0clone();
        transitionSet.f11666a = new ArrayList<>();
        int size = this.f11666a.size();
        for (int i10 = 0; i10 < size; i10++) {
            transitionSet.g(this.f11666a.get(i10).mo0clone());
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(String str, boolean z10) {
        for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
            this.f11666a.get(i10).excludeTarget(str, z10);
        }
        return super.excludeTarget(str, z10);
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11666a = new ArrayList<>();
        this.f11667b = true;
        this.f11669d = false;
        this.f11670e = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f11748i);
        r(A.k.k(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(int i10, boolean z10) {
        for (int i11 = 0; i11 < this.f11666a.size(); i11++) {
            this.f11666a.get(i11).excludeTarget(i10, z10);
        }
        return super.excludeTarget(i10, z10);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(Class<?> cls, boolean z10) {
        for (int i10 = 0; i10 < this.f11666a.size(); i10++) {
            this.f11666a.get(i10).excludeTarget(cls, z10);
        }
        return super.excludeTarget(cls, z10);
    }
}
