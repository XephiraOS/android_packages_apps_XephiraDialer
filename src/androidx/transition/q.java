package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

/* compiled from: SidePropagation.java */
/* loaded from: classes.dex */
public class q extends N {

    /* renamed from: b, reason: collision with root package name */
    public float f11738b = 3.0f;

    /* renamed from: c, reason: collision with root package name */
    public int f11739c = 80;

    @Override // androidx.transition.z
    public long c(ViewGroup viewGroup, Transition transition, C c10, C c11) {
        int i10;
        int i11;
        int i12;
        C c12 = c10;
        if (c12 == null && c11 == null) {
            return 0L;
        }
        Rect epicenter = transition.getEpicenter();
        if (c11 != null && e(c12) != 0) {
            c12 = c11;
            i10 = 1;
        } else {
            i10 = -1;
        }
        int f10 = f(c12);
        int g10 = g(c12);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (epicenter != null) {
            i11 = epicenter.centerX();
            i12 = epicenter.centerY();
        } else {
            i11 = (round + width) / 2;
            i12 = (round2 + height) / 2;
        }
        float h10 = h(viewGroup, f10, g10, i11, i12, round, round2, width, height) / i(viewGroup);
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round((((float) (duration * i10)) / this.f11738b) * h10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0012, code lost:
    
        r4 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x001d, code lost:
    
        if (r5.getLayoutDirection() == 1) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r5.getLayoutDirection() == 1) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        r4 = 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(android.view.View r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        /*
            r4 = this;
            int r4 = r4.f11739c
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r1 = 1
            r2 = 3
            r3 = 5
            if (r4 != r0) goto L14
            int r4 = r5.getLayoutDirection()
            if (r4 != r1) goto L12
        L10:
            r4 = r3
            goto L20
        L12:
            r4 = r2
            goto L20
        L14:
            r0 = 8388613(0x800005, float:1.175495E-38)
            if (r4 != r0) goto L20
            int r4 = r5.getLayoutDirection()
            if (r4 != r1) goto L10
            goto L12
        L20:
            if (r4 == r2) goto L46
            if (r4 == r3) goto L3e
            r5 = 48
            if (r4 == r5) goto L36
            r5 = 80
            if (r4 == r5) goto L2e
            r4 = 0
            goto L4d
        L2e:
            int r7 = r7 - r11
            int r8 = r8 - r6
            int r4 = java.lang.Math.abs(r8)
            int r4 = r4 + r7
            goto L4d
        L36:
            int r13 = r13 - r7
            int r8 = r8 - r6
            int r4 = java.lang.Math.abs(r8)
            int r4 = r4 + r13
            goto L4d
        L3e:
            int r6 = r6 - r10
            int r9 = r9 - r7
            int r4 = java.lang.Math.abs(r9)
            int r4 = r4 + r6
            goto L4d
        L46:
            int r12 = r12 - r6
            int r9 = r9 - r7
            int r4 = java.lang.Math.abs(r9)
            int r4 = r4 + r12
        L4d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.q.h(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    public final int i(ViewGroup viewGroup) {
        int i10 = this.f11739c;
        if (i10 != 3 && i10 != 5 && i10 != 8388611 && i10 != 8388613) {
            return viewGroup.getHeight();
        }
        return viewGroup.getWidth();
    }

    public void j(int i10) {
        this.f11739c = i10;
    }
}
