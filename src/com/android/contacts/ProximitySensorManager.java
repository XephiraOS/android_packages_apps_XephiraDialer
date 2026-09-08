package com.android.contacts;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: classes.dex */
public class ProximitySensorManager {

    /* renamed from: a, reason: collision with root package name */
    public c f13185a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13186b;

    /* renamed from: c, reason: collision with root package name */
    public Context f13187c;

    /* renamed from: d, reason: collision with root package name */
    public b f13188d;

    /* loaded from: classes.dex */
    public enum State {
        NEAR,
        FAR
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13192a;

        static {
            int[] iArr = new int[State.values().length];
            f13192a = iArr;
            try {
                iArr[State.NEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13192a[State.FAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b();
    }

    public ProximitySensorManager(Context context, b bVar) {
        this.f13187c = context;
        this.f13188d = bVar;
    }

    public void a(boolean z10) {
        if (c() != null && this.f13186b) {
            if (z10) {
                c().d();
            } else {
                c().c();
            }
            this.f13186b = false;
        }
    }

    public void b() {
        if (c() != null && !this.f13186b) {
            c().b();
            this.f13186b = true;
        }
    }

    public final c c() {
        SensorManager sensorManager;
        Sensor defaultSensor;
        if (this.f13185a == null && (defaultSensor = (sensorManager = (SensorManager) this.f13187c.getSystemService("sensor")).getDefaultSensor(8)) != null) {
            this.f13185a = new c(sensorManager, defaultSensor, this.f13188d);
        }
        return this.f13185a;
    }

    /* loaded from: classes.dex */
    public static class c implements SensorEventListener {

        /* renamed from: a, reason: collision with root package name */
        public final SensorManager f13193a;

        /* renamed from: b, reason: collision with root package name */
        public final Sensor f13194b;

        /* renamed from: c, reason: collision with root package name */
        public final float f13195c;

        /* renamed from: d, reason: collision with root package name */
        public final b f13196d;

        /* renamed from: e, reason: collision with root package name */
        public State f13197e = State.FAR;

        /* renamed from: f, reason: collision with root package name */
        public boolean f13198f = false;

        public c(SensorManager sensorManager, Sensor sensor, b bVar) {
            this.f13193a = sensorManager;
            this.f13194b = sensor;
            this.f13195c = sensor.getMaximumRange();
            this.f13196d = bVar;
        }

        public final State a(float f10) {
            if (f10 <= 5.0f && f10 != this.f13195c) {
                return State.NEAR;
            }
            return State.FAR;
        }

        public synchronized void b() {
            this.f13193a.registerListener(this, this.f13194b, 2);
            this.f13198f = false;
        }

        public void c() {
            State state;
            State state2;
            synchronized (this) {
                e();
                state = this.f13197e;
                state2 = State.FAR;
                this.f13197e = state2;
            }
            if (state != state2) {
                this.f13196d.b();
            }
        }

        public synchronized void d() {
            try {
                if (this.f13197e == State.FAR) {
                    e();
                } else {
                    this.f13198f = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public final void e() {
            this.f13193a.unregisterListener(this);
            this.f13198f = false;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = sensorEvent.values;
            if (fArr == null || fArr.length == 0) {
                return;
            }
            State a10 = a(fArr[0]);
            synchronized (this) {
                try {
                    if (a10 == this.f13197e) {
                        return;
                    }
                    this.f13197e = a10;
                    if (this.f13198f && a10 == State.FAR) {
                        e();
                    }
                    int i10 = a.f13192a[a10.ordinal()];
                    if (i10 != 1) {
                        if (i10 == 2) {
                            this.f13196d.b();
                            return;
                        }
                        return;
                    }
                    this.f13196d.a();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i10) {
        }
    }
}
