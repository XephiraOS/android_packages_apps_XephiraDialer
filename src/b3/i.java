package b3;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.android.incallui.OplusPhoneUtils;

/* compiled from: MemorySizeCalculator.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f12119a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12120b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f12121c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12122d;

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: i, reason: collision with root package name */
        public static final int f12123i = 1;

        /* renamed from: a, reason: collision with root package name */
        public final Context f12124a;

        /* renamed from: b, reason: collision with root package name */
        public ActivityManager f12125b;

        /* renamed from: c, reason: collision with root package name */
        public c f12126c;

        /* renamed from: e, reason: collision with root package name */
        public float f12128e;

        /* renamed from: d, reason: collision with root package name */
        public float f12127d = 2.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f12129f = 0.4f;

        /* renamed from: g, reason: collision with root package name */
        public float f12130g = 0.33f;

        /* renamed from: h, reason: collision with root package name */
        public int f12131h = 4194304;

        public a(Context context) {
            this.f12128e = f12123i;
            this.f12124a = context;
            this.f12125b = (ActivityManager) context.getSystemService("activity");
            this.f12126c = new b(context.getResources().getDisplayMetrics());
            if (i.e(this.f12125b)) {
                this.f12128e = 0.0f;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public final DisplayMetrics f12132a;

        public b(DisplayMetrics displayMetrics) {
            this.f12132a = displayMetrics;
        }

        @Override // b3.i.c
        public int a() {
            return this.f12132a.heightPixels;
        }

        @Override // b3.i.c
        public int b() {
            return this.f12132a.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    public interface c {
        int a();

        int b();
    }

    public i(a aVar) {
        int i10;
        boolean z10;
        this.f12121c = aVar.f12124a;
        if (e(aVar.f12125b)) {
            i10 = aVar.f12131h / 2;
        } else {
            i10 = aVar.f12131h;
        }
        this.f12122d = i10;
        int c10 = c(aVar.f12125b, aVar.f12129f, aVar.f12130g);
        float b10 = aVar.f12126c.b() * aVar.f12126c.a() * 4;
        int round = Math.round(aVar.f12128e * b10);
        int round2 = Math.round(b10 * aVar.f12127d);
        int i11 = c10 - i10;
        int i12 = round2 + round;
        if (i12 <= i11) {
            this.f12120b = round2;
            this.f12119a = round;
        } else {
            float f10 = i11;
            float f11 = aVar.f12128e;
            float f12 = aVar.f12127d;
            float f13 = f10 / (f11 + f12);
            this.f12120b = Math.round(f12 * f13);
            this.f12119a = Math.round(f13 * aVar.f12128e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f12120b));
            sb.append(", pool size: ");
            sb.append(f(this.f12119a));
            sb.append(", byte array size: ");
            sb.append(f(i10));
            sb.append(", memory class limited? ");
            if (i12 > c10) {
                z10 = true;
            } else {
                z10 = false;
            }
            sb.append(z10);
            sb.append(", max size: ");
            sb.append(f(c10));
            sb.append(", memoryClass: ");
            sb.append(aVar.f12125b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.f12125b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    public static int c(ActivityManager activityManager, float f10, float f11) {
        float memoryClass = activityManager.getMemoryClass() * OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS;
        if (e(activityManager)) {
            f10 = f11;
        }
        return Math.round(memoryClass * f10);
    }

    public static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    public int a() {
        return this.f12122d;
    }

    public int b() {
        return this.f12119a;
    }

    public int d() {
        return this.f12120b;
    }

    public final String f(int i10) {
        return Formatter.formatFileSize(this.f12121c, i10);
    }
}
