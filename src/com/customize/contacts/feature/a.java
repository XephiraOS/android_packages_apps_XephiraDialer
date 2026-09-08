package com.customize.contacts.feature;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.SubscriptionInfo;
import com.customize.contacts.util.b0;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import com.oplus.foundation.util.OsUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: AppFeatureUtils.kt */
/* loaded from: classes3.dex */
public final class a extends AppFeatureProviderUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final C0202a f21107a = new C0202a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f21108b = true;

    /* compiled from: AppFeatureUtils.kt */
    /* renamed from: com.customize.contacts.feature.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0202a {
        public C0202a() {
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
            if (a.f21108b) {
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
                List<SubscriptionInfo> e10 = b0.e(context);
                i.e(e10, "colorgetActiveSubInfoList(it)");
                if (e10 != null) {
                    Iterator<SubscriptionInfo> it = e10.iterator();
                    while (it.hasNext()) {
                        if (AppFeatureProviderUtils.o(contentResolver, a.f21107a.a(it.next().getSimSlotIndex()), featureName)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public /* synthetic */ C0202a(f fVar) {
            this();
        }
    }
}
