package com.customize.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.android.contacts.framework.baseui.widget.RtlViewPager;

/* loaded from: classes3.dex */
public class ContactsViewPager extends RtlViewPager {

    /* renamed from: c, reason: collision with root package name */
    public boolean f22293c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f22294d;

    public ContactsViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22293c = true;
        this.f22294d = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f22293c) {
            return false;
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Throwable th) {
            H7.b.c("ContactsViewPager", "th = " + th);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        if (r5 != 3) goto L18;
     */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.f22293c
            r1 = 0
            if (r0 != 0) goto La
            boolean r0 = r4.f22294d
            if (r0 != 0) goto La
            return r1
        La:
            boolean r0 = super.onTouchEvent(r5)
            int r5 = r5.getAction()
            r5 = r5 & 255(0xff, float:3.57E-43)
            r2 = 1
            if (r5 == 0) goto L23
            if (r5 == r2) goto L20
            r3 = 2
            if (r5 == r3) goto L23
            r2 = 3
            if (r5 == r2) goto L20
            goto L27
        L20:
            r4.f22294d = r1
            goto L27
        L23:
            if (r0 == 0) goto L27
            r4.f22294d = r2
        L27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.widget.ContactsViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCanScrolling(boolean z10) {
        this.f22293c = z10;
    }
}
