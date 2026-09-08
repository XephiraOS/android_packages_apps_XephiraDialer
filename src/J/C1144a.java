package j;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import e.C0961a;
import e.j;

/* compiled from: ActionBarPolicy.java */
/* renamed from: j.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1144a {

    /* renamed from: a, reason: collision with root package name */
    public Context f33671a;

    public C1144a(Context context) {
        this.f33671a = context;
    }

    public static C1144a b(Context context) {
        return new C1144a(context);
    }

    public boolean a() {
        if (this.f33671a.getApplicationInfo().targetSdkVersion < 14) {
            return true;
        }
        return false;
    }

    public int c() {
        return this.f33671a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f33671a.getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && i10 <= 600) {
            if (i10 <= 960 || i11 <= 720) {
                if (i10 <= 720 || i11 <= 960) {
                    if (i10 < 500) {
                        if (i10 <= 640 || i11 <= 480) {
                            if (i10 <= 480 || i11 <= 640) {
                                if (i10 >= 360) {
                                    return 3;
                                }
                                return 2;
                            }
                            return 4;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 5;
            }
            return 5;
        }
        return 5;
    }

    public int e() {
        return this.f33671a.getResources().getDimensionPixelSize(e.d.f30138b);
    }

    public int f() {
        TypedArray obtainStyledAttributes = this.f33671a.obtainStyledAttributes(null, j.f30412a, C0961a.f30104c, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(j.f30460j, 0);
        Resources resources = this.f33671a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(e.d.f30137a));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f33671a.getResources().getBoolean(e.b.f30128a);
    }

    public boolean h() {
        return true;
    }
}
