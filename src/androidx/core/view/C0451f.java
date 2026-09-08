package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* compiled from: DifferentialMotionFlingController.java */
/* renamed from: androidx.core.view.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0451f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9496a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0452g f9497b;

    /* renamed from: c, reason: collision with root package name */
    public final b f9498c;

    /* renamed from: d, reason: collision with root package name */
    public final a f9499d;

    /* renamed from: e, reason: collision with root package name */
    public VelocityTracker f9500e;

    /* renamed from: f, reason: collision with root package name */
    public float f9501f;

    /* renamed from: g, reason: collision with root package name */
    public int f9502g;

    /* renamed from: h, reason: collision with root package name */
    public int f9503h;

    /* renamed from: i, reason: collision with root package name */
    public int f9504i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f9505j;

    /* compiled from: DifferentialMotionFlingController.java */
    /* renamed from: androidx.core.view.f$a */
    /* loaded from: classes.dex */
    public interface a {
        float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10);
    }

    /* compiled from: DifferentialMotionFlingController.java */
    /* renamed from: androidx.core.view.f$b */
    /* loaded from: classes.dex */
    public interface b {
        void a(Context context, int[] iArr, MotionEvent motionEvent, int i10);
    }

    public C0451f(Context context, InterfaceC0452g interfaceC0452g) {
        this(context, interfaceC0452g, new b() { // from class: androidx.core.view.d
            @Override // androidx.core.view.C0451f.b
            public final void a(Context context2, int[] iArr, MotionEvent motionEvent, int i10) {
                C0451f.c(context2, iArr, motionEvent, i10);
            }
        }, new a() { // from class: androidx.core.view.e
            @Override // androidx.core.view.C0451f.a
            public final float a(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10) {
                float f10;
                f10 = C0451f.f(velocityTracker, motionEvent, i10);
                return f10;
            }
        });
    }

    public static void c(Context context, int[] iArr, MotionEvent motionEvent, int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = L.c(context, viewConfiguration, motionEvent.getDeviceId(), i10, motionEvent.getSource());
        iArr[1] = L.b(context, viewConfiguration, motionEvent.getDeviceId(), i10, motionEvent.getSource());
    }

    public static float f(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10) {
        H.a(velocityTracker, motionEvent);
        H.b(velocityTracker, 1000);
        return H.d(velocityTracker, i10);
    }

    public final boolean d(MotionEvent motionEvent, int i10) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f9503h == source && this.f9504i == deviceId && this.f9502g == i10) {
            return false;
        }
        this.f9498c.a(this.f9496a, this.f9505j, motionEvent, i10);
        this.f9503h = source;
        this.f9504i = deviceId;
        this.f9502g = i10;
        return true;
    }

    public final float e(MotionEvent motionEvent, int i10) {
        if (this.f9500e == null) {
            this.f9500e = VelocityTracker.obtain();
        }
        return this.f9499d.a(this.f9500e, motionEvent, i10);
    }

    public void g(MotionEvent motionEvent, int i10) {
        boolean d10 = d(motionEvent, i10);
        if (this.f9505j[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f9500e;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f9500e = null;
                return;
            }
            return;
        }
        float e10 = e(motionEvent, i10) * this.f9497b.b();
        float signum = Math.signum(e10);
        float f10 = 0.0f;
        if (d10 || (signum != Math.signum(this.f9501f) && signum != 0.0f)) {
            this.f9497b.c();
        }
        float abs = Math.abs(e10);
        int[] iArr = this.f9505j;
        if (abs < iArr[0]) {
            return;
        }
        float max = Math.max(-r6, Math.min(e10, iArr[1]));
        if (this.f9497b.a(max)) {
            f10 = max;
        }
        this.f9501f = f10;
    }

    public C0451f(Context context, InterfaceC0452g interfaceC0452g, b bVar, a aVar) {
        this.f9502g = -1;
        this.f9503h = -1;
        this.f9504i = -1;
        this.f9505j = new int[]{Integer.MAX_VALUE, 0};
        this.f9496a = context;
        this.f9497b = interfaceC0452g;
        this.f9498c = bVar;
        this.f9499d = aVar;
    }
}
