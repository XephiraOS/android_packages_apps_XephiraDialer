package l7;

import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: AppFeatureUtils.kt */
/* renamed from: l7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1296a extends AppFeatureProviderUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final C0330a f34729a = new C0330a(null);

    /* compiled from: AppFeatureUtils.kt */
    /* renamed from: l7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0330a {
        public C0330a() {
        }

        public final String a(ContentResolver cr, String featureName, String defaultValue) {
            i.f(cr, "cr");
            i.f(featureName, "featureName");
            i.f(defaultValue, "defaultValue");
            try {
                String i10 = AppFeatureProviderUtils.i(cr, featureName, defaultValue);
                i.e(i10, "{\n                AppFea…faultValue)\n            }");
                return i10;
            } catch (Exception e10) {
                Log.e("AppFeatureUtils", "Exception : " + e10);
                return defaultValue;
            }
        }

        public final boolean b(PackageManager pm, ContentResolver cr, String featureNameQ, String featureNameR) {
            i.f(pm, "pm");
            i.f(cr, "cr");
            i.f(featureNameQ, "featureNameQ");
            i.f(featureNameR, "featureNameR");
            boolean z10 = false;
            try {
                if (c()) {
                    if (i.b("com.oplus.blacklistapp.disable_fake_bs", featureNameR)) {
                        if (!AppFeatureProviderUtils.p(cr, featureNameR)) {
                            z10 = true;
                        }
                    } else {
                        z10 = AppFeatureProviderUtils.p(cr, featureNameR);
                    }
                } else if (!TextUtils.isEmpty(featureNameQ)) {
                    z10 = pm.hasSystemFeature(featureNameQ);
                }
            } catch (Exception e10) {
                Log.e("AppFeatureUtils", "Exception : " + e10);
            }
            return z10;
        }

        public final boolean c() {
            return true;
        }

        public /* synthetic */ C0330a(f fVar) {
            this();
        }
    }

    public static final boolean t(PackageManager packageManager, ContentResolver contentResolver, String str, String str2) {
        return f34729a.b(packageManager, contentResolver, str, str2);
    }
}
