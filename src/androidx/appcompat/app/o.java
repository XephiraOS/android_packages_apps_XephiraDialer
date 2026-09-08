package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* compiled from: TwilightManager.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: d, reason: collision with root package name */
    public static o f7409d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7410a;

    /* renamed from: b, reason: collision with root package name */
    public final LocationManager f7411b;

    /* renamed from: c, reason: collision with root package name */
    public final a f7412c = new a();

    /* compiled from: TwilightManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7413a;

        /* renamed from: b, reason: collision with root package name */
        public long f7414b;
    }

    public o(Context context, LocationManager locationManager) {
        this.f7410a = context;
        this.f7411b = locationManager;
    }

    public static o a(Context context) {
        if (f7409d == null) {
            Context applicationContext = context.getApplicationContext();
            f7409d = new o(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f7409d;
    }

    public final Location b() {
        Location location;
        Location location2 = null;
        if (androidx.core.content.e.b(this.f7410a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            location = c("network");
        } else {
            location = null;
        }
        if (androidx.core.content.e.b(this.f7410a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location2 = c("gps");
        }
        if (location2 != null && location != null) {
            if (location2.getTime() > location.getTime()) {
                return location2;
            }
            return location;
        }
        if (location2 != null) {
            return location2;
        }
        return location;
    }

    public final Location c(String str) {
        try {
            if (this.f7411b.isProviderEnabled(str)) {
                return this.f7411b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e10) {
            Log.d("TwilightManager", "Failed to get last known location", e10);
            return null;
        }
    }

    public boolean d() {
        a aVar = this.f7412c;
        if (e()) {
            return aVar.f7413a;
        }
        Location b10 = b();
        if (b10 != null) {
            f(b10);
            return aVar.f7413a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i10 = Calendar.getInstance().get(11);
        if (i10 >= 6 && i10 < 22) {
            return false;
        }
        return true;
    }

    public final boolean e() {
        if (this.f7412c.f7414b > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public final void f(Location location) {
        long j10;
        a aVar = this.f7412c;
        long currentTimeMillis = System.currentTimeMillis();
        n b10 = n.b();
        b10.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        b10.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z10 = true;
        if (b10.f7408c != 1) {
            z10 = false;
        }
        boolean z11 = z10;
        long j11 = b10.f7407b;
        long j12 = b10.f7406a;
        b10.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j13 = b10.f7407b;
        if (j11 != -1 && j12 != -1) {
            if (currentTimeMillis > j12) {
                j11 = j13;
            } else if (currentTimeMillis > j11) {
                j11 = j12;
            }
            j10 = j11 + 60000;
        } else {
            j10 = currentTimeMillis + 43200000;
        }
        aVar.f7413a = z11;
        aVar.f7414b = j10;
    }
}
