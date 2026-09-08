package F3;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import com.customize.contacts.camera.FocusIndicatorLayout;
import com.google.common.collect.n;
import com.oplus.dialer.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ManualFocusManager.java */
/* loaded from: classes3.dex */
public class e implements Camera.AutoFocusCallback {

    /* renamed from: a, reason: collision with root package name */
    public final FocusIndicatorLayout f835a;

    /* renamed from: b, reason: collision with root package name */
    public final Camera f836b;

    /* renamed from: c, reason: collision with root package name */
    public final F3.a f837c;

    /* renamed from: f, reason: collision with root package name */
    public List<Camera.Area> f840f;

    /* renamed from: g, reason: collision with root package name */
    public List<Camera.Area> f841g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f842h;

    /* renamed from: e, reason: collision with root package name */
    public Matrix f839e = new Matrix();

    /* renamed from: d, reason: collision with root package name */
    public Handler f838d = new a(this);

    /* compiled from: ManualFocusManager.java */
    /* loaded from: classes3.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<e> f843a;

        public a(e eVar) {
            this.f843a = new WeakReference<>(eVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            removeCallbacksAndMessages(null);
            e eVar = this.f843a.get();
            if (eVar != null && eVar.f842h) {
                if (H7.a.b()) {
                    H7.b.b("ManualFocusManager", "DelayedFocusHandler onAutoFocus");
                }
                eVar.onAutoFocus(false, null);
            }
        }
    }

    public e(Activity activity, Camera camera, F3.a aVar) {
        this.f835a = (FocusIndicatorLayout) activity.findViewById(R.id.focus_indicator_layout);
        this.f836b = camera;
        this.f837c = aVar;
    }

    public final void b(int i10, int i11, float f10, int i12, int i13, int i14, int i15, Rect rect) {
        int i16 = (int) (i10 * f10);
        int i17 = (int) (i11 * f10);
        RectF rectF = new RectF(b.a(i12 - (i16 / 2), 0, i14 - i16), b.a(i13 - (i17 / 2), 0, i15 - i17), r4 + i16, r3 + i17);
        this.f839e.mapRect(rectF);
        b.h(rectF, rect);
    }

    public synchronized void c(int i10, int i11, int i12, int i13) {
        try {
            int width = this.f835a.getWidth();
            int height = this.f835a.getHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f835a.getLayoutParams();
            layoutParams.setMargins(b.a(i10 - (width / 2), 0, i12 - width), b.a(i11 - (height / 2), 0, i13 - height), 0, 0);
            layoutParams.gravity = 3;
            this.f835a.requestLayout();
            this.f836b.cancelAutoFocus();
            this.f837c.q().invert(this.f839e);
            if (this.f840f == null) {
                ArrayList f10 = n.f();
                this.f840f = f10;
                f10.add(new Camera.Area(new Rect(), 1));
            }
            if (this.f841g == null) {
                ArrayList f11 = n.f();
                this.f841g = f11;
                f11.add(new Camera.Area(new Rect(), 1));
            }
            if (!B3.a.z()) {
                b(width, height, 0.85f, i10, i11, i12, i13, this.f840f.get(0).rect);
                b(width, height, 0.85f, i10, i11, i12, i13, this.f841g.get(0).rect);
            } else {
                b(width, height, 1.0f, i10, i11, i12, i13, this.f840f.get(0).rect);
                b(width, height, 1.5f, i10, i11, i12, i13, this.f841g.get(0).rect);
            }
            this.f837c.x(this.f840f, this.f841g);
            if (!this.f842h) {
                this.f842h = true;
                try {
                    this.f836b.autoFocus(this);
                    this.f835a.e();
                    e();
                } catch (RuntimeException e10) {
                    H7.b.i("ManualFocusManager", "Unexpected exception while mIsFocusing = " + e10);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void d() {
        try {
            this.f835a.c();
            this.f838d.removeCallbacksAndMessages(null);
        } catch (Exception e10) {
            H7.b.c("ManualFocusManager", "" + e10);
        }
    }

    public final void e() {
        Handler handler = this.f838d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f838d.sendMessageDelayed(this.f838d.obtainMessage(), 500L);
        }
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z10, Camera camera) {
        if (H7.a.b()) {
            H7.b.b("ManualFocusManager", "onAutoFocus focused:" + z10);
        }
        synchronized (this) {
            this.f838d.removeCallbacksAndMessages(null);
            this.f835a.d(true);
            this.f842h = false;
        }
        this.f837c.o(z10);
    }
}
