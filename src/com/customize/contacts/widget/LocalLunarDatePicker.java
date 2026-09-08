package com.customize.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes3.dex */
public class LocalLunarDatePicker extends COUILunarDatePicker {

    /* renamed from: y, reason: collision with root package name */
    public boolean f22390y;

    /* renamed from: z, reason: collision with root package name */
    public a f22391z;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public LocalLunarDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22390y = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == 0) goto L1f
            if (r0 == r1) goto L15
            r2 = 2
            if (r0 == r2) goto L1f
            r2 = 3
            if (r0 == r2) goto L15
            r2 = 4
            if (r0 == r2) goto L15
            r3.f22390y = r1
            goto L22
        L15:
            r3.f22390y = r1
            com.customize.contacts.widget.LocalLunarDatePicker$a r0 = r3.f22391z
            if (r0 == 0) goto L22
            r0.a()
            goto L22
        L1f:
            r0 = 0
            r3.f22390y = r0
        L22:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L2b
            r0.requestDisallowInterceptTouchEvent(r1)
        L2b:
            boolean r3 = super.dispatchTouchEvent(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.widget.LocalLunarDatePicker.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setLunarDateChangeEndListener(a aVar) {
        this.f22391z = aVar;
    }

    public boolean x() {
        return this.f22390y;
    }
}
