package com.android.incallui.foldscreen.presentation.controller;

import L1.c;
import V5.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.databinding.i;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.foldscreen.presentation.activity.FoldScreenInCallActivity;
import com.android.incallui.foldscreen.presentation.model.FoldScreenControllerModel;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: FoldInCallController.kt */
/* loaded from: classes.dex */
public final class FoldInCallController implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final FoldInCallController f18405a = new FoldInCallController();

    /* renamed from: b, reason: collision with root package name */
    public static final FoldScreenControllerModel f18406b = new FoldScreenControllerModel();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f18407c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public static final a f18408d = new a();

    /* renamed from: e, reason: collision with root package name */
    public static final FoldInCallController$onReceiveVideoUpgradeRequest$1 f18409e = new BroadcastReceiver() { // from class: com.android.incallui.foldscreen.presentation.controller.FoldInCallController$onReceiveVideoUpgradeRequest$1

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f18410a = new AtomicBoolean(false);

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean a10 = L1.b.a(intent);
            boolean andSet = this.f18410a.getAndSet(a10);
            if (a10 && !andSet) {
                FoldInCallController.f18405a.g();
            }
        }
    };

    /* compiled from: FoldInCallController.kt */
    /* loaded from: classes.dex */
    public static final class a extends i.a {
        @Override // androidx.databinding.i.a
        public void d(i iVar, int i10) {
            FoldInCallController.f18405a.g();
        }
    }

    @Override // V5.b
    public void f() {
        if (!f18407c.compareAndSet(false, true) || !c.f()) {
            return;
        }
        Log.d("FoldInCallController", "setUp: ");
        FoldScreenControllerModel foldScreenControllerModel = f18406b;
        foldScreenControllerModel.d();
        foldScreenControllerModel.c().f(f18408d);
        L1.b.b(f18409e);
    }

    @Override // V5.b
    public void g() {
        if (!f18406b.c().s0().booleanValue()) {
            Log.i("FoldInCallController", "startFoldScreenInCallActivity: launchTrigger is false, ignore");
            return;
        }
        if (FoldScreenInCallActivity.f18394h.c()) {
            Log.i("FoldInCallController", "startFoldScreenInCallActivity: activity is foreground, ignore");
            return;
        }
        Log.d("FoldInCallController", "startFoldScreenInCallActivity: ");
        Context defaultDisplayUiContext = OplusInCallApp.getDefaultDisplayUiContext();
        kotlin.jvm.internal.i.e(defaultDisplayUiContext, "getDefaultDisplayUiContext()");
        c.j(defaultDisplayUiContext);
    }
}
