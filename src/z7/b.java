package Z7;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;

/* compiled from: LocationHelper.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f5965a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f5966b;

    /* renamed from: c, reason: collision with root package name */
    public LocationManager f5967c;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f5969e;

    /* renamed from: d, reason: collision with root package name */
    public d f5968d = null;

    /* renamed from: f, reason: collision with root package name */
    public LocationListener f5970f = new C0093b();

    /* compiled from: LocationHelper.java */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0849j.s(b.this.f5965a)) {
                b.this.h("network", 10000L);
            } else {
                b.this.h("gps", 45000L);
            }
        }
    }

    /* compiled from: LocationHelper.java */
    /* renamed from: Z7.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0093b implements LocationListener {
        public C0093b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (C0846g.c()) {
                Log.d("LocationHelper", "onLocationChanged");
            }
            if (b.this.f5968d != null) {
                b.this.f5968d.a(location);
            }
            b.this.f();
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            Log.i("LocationHelper", "onProviderDisabled");
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            Log.i("LocationHelper", "onProviderEnabled");
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i10, Bundle bundle) {
            Log.i("LocationHelper", "onStatusChanged status = " + i10);
        }
    }

    /* compiled from: LocationHelper.java */
    /* loaded from: classes3.dex */
    public class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            b.this.f();
        }

        public c() {
        }
    }

    /* compiled from: LocationHelper.java */
    /* loaded from: classes3.dex */
    public interface d {
        void a(Location location);
    }

    public b(Context context) {
        this.f5965a = null;
        this.f5966b = null;
        this.f5967c = null;
        this.f5969e = null;
        this.f5965a = context;
        this.f5966b = new Handler();
        this.f5967c = (LocationManager) this.f5965a.getSystemService("location");
        this.f5969e = new c();
    }

    public void e() {
        f();
        this.f5970f = null;
        this.f5967c = null;
        this.f5965a = null;
        this.f5966b = null;
    }

    public final void f() {
        LocationListener locationListener;
        if (C0846g.c()) {
            Log.d("LocationHelper", "--removeUpdates--");
        }
        LocationManager locationManager = this.f5967c;
        if (locationManager != null && (locationListener = this.f5970f) != null) {
            try {
                locationManager.removeUpdates(locationListener);
                this.f5966b.removeCallbacks(this.f5969e);
            } catch (Exception e10) {
                Log.v("LocationHelper", "fail to remove location listners, ignore" + e10);
            }
        }
    }

    public void g() {
        this.f5966b.postDelayed(new a(), 1000L);
    }

    public final void h(String str, long j10) {
        if (C0846g.c()) {
            Log.d("LocationHelper", "requestLocationUpdates");
        }
        if (this.f5967c == null) {
            this.f5967c = (LocationManager) this.f5965a.getSystemService("location");
        }
        try {
            this.f5967c.requestLocationUpdates(str, 1000L, 0.0f, this.f5970f);
        } catch (SecurityException e10) {
            Log.e("LocationHelper", "fail to request location update, ignore" + e10);
        } catch (Exception e11) {
            Log.e("LocationHelper", "provider does not exist " + e11);
        }
        this.f5966b.postDelayed(this.f5969e, j10);
    }

    public void i(d dVar) {
        this.f5968d = dVar;
    }
}
