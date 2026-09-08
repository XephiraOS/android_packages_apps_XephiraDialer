package com.customize.contacts.camera;

import H7.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* loaded from: classes3.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    public SurfaceHolder f20845a;

    /* renamed from: b, reason: collision with root package name */
    public a f20846b;

    /* renamed from: c, reason: collision with root package name */
    public float f20847c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20848d;

    /* loaded from: classes3.dex */
    public interface a {
        void F(boolean z10);

        void c();

        void surfaceCreated(SurfaceHolder surfaceHolder);
    }

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20847c = 1.0f;
        this.f20848d = false;
        a();
    }

    public final void a() {
        SurfaceHolder holder = getHolder();
        this.f20845a = holder;
        holder.addCallback(this);
        this.f20845a.setType(3);
    }

    public boolean b() {
        return this.f20848d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0010, code lost:
    
        if (r0 != 5) goto L18;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            com.customize.contacts.camera.CameraSurfaceView$a r0 = r3.f20846b
            r1 = 1
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r4.getActionMasked()
            if (r0 == 0) goto L28
            r2 = 2
            if (r0 == r2) goto L13
            r2 = 5
            if (r0 == r2) goto L28
            goto L2e
        L13:
            float r4 = F3.b.e(r4)
            com.customize.contacts.camera.CameraSurfaceView$a r0 = r3.f20846b
            float r2 = r3.f20847c
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 <= 0) goto L21
            r2 = r1
            goto L22
        L21:
            r2 = 0
        L22:
            r0.F(r2)
            r3.f20847c = r4
            goto L2e
        L28:
            float r4 = F3.b.e(r4)
            r3.f20847c = r4
        L2e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.camera.CameraSurfaceView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCallback(a aVar) {
        this.f20846b = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        b.b("CameraSurfaceView", "surfaceCreated");
        this.f20848d = true;
        a aVar = this.f20846b;
        if (aVar != null) {
            aVar.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        b.b("CameraSurfaceView", "surfaceDestroyed");
        this.f20848d = false;
        a aVar = this.f20846b;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
    }
}
