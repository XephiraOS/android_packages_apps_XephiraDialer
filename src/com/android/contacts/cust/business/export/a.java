package com.android.contacts.cust.business.export;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.SubscriptionInfo;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import com.oplus.foundation.util.OsUtils;
import java.util.Iterator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import t0.C1577a;

/* compiled from: CustAppFeatureUtils.kt */
/* loaded from: classes.dex */
public final class a extends AppFeatureProviderUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final C0159a f14149a = new C0159a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f14150b = true;

    /* compiled from: CustAppFeatureUtils.kt */
    /* renamed from: com.android.contacts.cust.business.export.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0159a {
        public C0159a() {
        }

        public final AppFeatureProviderUtils.FeatureID a(int i10) {
            if (i10 == 0) {
                return AppFeatureProviderUtils.FeatureID.DYNAMIC_SIMSLOT_1;
            }
            return AppFeatureProviderUtils.FeatureID.DYNAMIC_SIMSLOT_2;
        }

        public final boolean b(PackageManager packageManager, ContentResolver contentResolver, String featureNameQ, String featureNameR, boolean z10) {
            i.f(featureNameQ, "featureNameQ");
            i.f(featureNameR, "featureNameR");
            if (a.f14150b) {
                if (z10) {
                    return true;
                }
                return AppFeatureProviderUtils.p(contentResolver, featureNameR);
            }
            if (packageManager != null) {
                return packageManager.hasSystemFeature(featureNameQ);
            }
            return false;
        }

        public final boolean c(Context context, ContentResolver contentResolver, String featureName) {
            i.f(featureName, "featureName");
            if (OsUtils.k() && context != null) {
                Iterator<SubscriptionInfo> it = C1577a.a(context).iterator();
                while (it.hasNext()) {
                    if (AppFeatureProviderUtils.o(contentResolver, a.f14149a.a(it.next().getSimSlotIndex()), featureName)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public /* synthetic */ C0159a(f fVar) {
            this();
        }
    }
}
