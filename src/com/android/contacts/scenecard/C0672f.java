package com.android.contacts.scenecard;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.incallui.OplusPhoneCapabilities;
import com.oplus.content.OplusIntent;
import kotlin.Pair;

/* compiled from: SceneContineUtils.kt */
/* renamed from: com.android.contacts.scenecard.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0672f {

    /* renamed from: a, reason: collision with root package name */
    public static final C0672f f17272a = new C0672f();

    public static /* synthetic */ Pair b(C0672f c0672f, Context context, int i10, Integer num, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            num = null;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return c0672f.a(context, i10, num, i11);
    }

    public final Pair<Intent, Bundle> a(Context context, int i10, Integer num, int i11) {
        kotlin.jvm.internal.i.f(context, "context");
        ActivityOptions makeBasic = ActivityOptions.makeBasic();
        makeBasic.setLaunchDisplayId(i10);
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setPackage(context.getPackageName());
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        if (num != null) {
            intent.putExtra("scene_redirect_type", num.intValue());
        }
        intent.putExtra("from_scene", true);
        if (i10 == 1) {
            if (C7.b.a(30, 1)) {
                OplusIntent.setOplusFlags(intent, 805306368);
            } else {
                J6.c.d(intent, 805306368);
            }
            if (i11 != 0) {
                intent.putExtra("oplus.intent.extra.DESCRIPTION", context.getString(i11));
            }
        }
        return new Pair<>(intent, makeBasic.toBundle());
    }
}
