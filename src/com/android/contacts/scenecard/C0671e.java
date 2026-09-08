package com.android.contacts.scenecard;

import android.app.Activity;
import android.content.Intent;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.customize.contacts.FeatureOption;

/* compiled from: SceneCommonUtils.kt */
/* renamed from: com.android.contacts.scenecard.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0671e {

    /* renamed from: a, reason: collision with root package name */
    public static final C0671e f17271a = new C0671e();

    public static final boolean a(Activity activity, Intent intent) {
        kotlin.jvm.internal.i.f(activity, "activity");
        int d10 = C7.e.d(intent, "scene_redirect_type", 0);
        H7.b.e("SceneCommonUtils", "redirectSceneIntentIfNeed : " + d10);
        if (d10 <= 0) {
            return false;
        }
        if (intent != null) {
            intent.putExtra("scene_redirect_type", 0);
        }
        if (d10 != 1) {
            if (d10 != 2) {
                if (d10 != 3) {
                    if (d10 != 4) {
                        if (d10 == 5) {
                            K7.b.c(activity, C7.e.l(intent, "ungranted_permission"), 1, FeatureOption.i());
                        }
                    } else {
                        StatementUtils.B(activity, 13, false, 0, 8, null);
                    }
                } else {
                    StatementUtils.B(activity, 1, false, 0, 8, null);
                }
            } else {
                StatementUtils.B(activity, 2, false, 0, 8, null);
            }
        } else {
            StatementUtils.B(activity, 17, false, 0, 8, null);
        }
        activity.overridePendingTransition(0, 0);
        return true;
    }
}
