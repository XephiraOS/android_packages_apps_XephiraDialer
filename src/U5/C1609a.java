package u5;

import android.content.Context;
import android.content.pm.PackageManager;
import com.oplus.content.OplusFeatureConfigManager;

/* compiled from: OplusFeatureConfigManager.java */
/* renamed from: u5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1609a {

    /* renamed from: c, reason: collision with root package name */
    public static String f37346c;

    /* renamed from: d, reason: collision with root package name */
    public static String f37347d;

    /* renamed from: e, reason: collision with root package name */
    public static C1609a f37348e;

    /* renamed from: a, reason: collision with root package name */
    public OplusFeatureConfigManager f37349a;

    /* renamed from: b, reason: collision with root package name */
    public PackageManager f37350b;

    static {
        if (A5.a.b()) {
            f37346c = "oplus.software.radio.support_5g";
            f37347d = "oplus.software.display.screen_heteromorphism";
        } else {
            f37346c = "oppo.phone.5g.support";
            f37347d = "com.oppo.feature.screen.heteromorphism";
        }
    }

    public C1609a(OplusFeatureConfigManager oplusFeatureConfigManager) {
        this.f37349a = oplusFeatureConfigManager;
    }

    public static C1609a a(Context context) {
        if (f37348e == null) {
            synchronized (C1609a.class) {
                try {
                    if (f37348e == null) {
                        if (A5.a.b()) {
                            f37348e = new C1609a(OplusFeatureConfigManager.getInstance());
                        } else {
                            f37348e = new C1609a(context);
                        }
                    }
                } finally {
                }
            }
        }
        return f37348e;
    }

    public boolean b(String str) {
        if (A5.a.b()) {
            return this.f37349a.hasFeature(str);
        }
        return this.f37350b.hasSystemFeature(str);
    }

    public C1609a(Context context) {
        this.f37350b = context.getPackageManager();
    }
}
