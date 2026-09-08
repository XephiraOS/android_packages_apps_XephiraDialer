package com.android.incallui.foldscreen.presentation.controller;

import L1.b;
import P1.c;
import P1.e;
import P1.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.InterfaceC0480c;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import com.android.incallui.Log;
import com.android.incallui.foldscreen.presentation.controller.VideoUpgradeRequestManager;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import f.C0991a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: VideoUpgradeRequestManager.kt */
/* loaded from: classes.dex */
public final class VideoUpgradeRequestManager {

    /* renamed from: g, reason: collision with root package name */
    public static final a f18422g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final ComponentActivity f18423a;

    /* renamed from: b, reason: collision with root package name */
    public final FoldScreenActivityViewModel f18424b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f18425c;

    /* renamed from: d, reason: collision with root package name */
    public COUIBottomSheetDialog f18426d;

    /* renamed from: e, reason: collision with root package name */
    public final VideoUpgradeRequestManager$requestReceiver$1 f18427e;

    /* renamed from: f, reason: collision with root package name */
    public final VideoUpgradeRequestManager$lifeCycleObserver$1 f18428f;

    /* compiled from: VideoUpgradeRequestManager.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.android.incallui.foldscreen.presentation.controller.VideoUpgradeRequestManager$requestReceiver$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.android.incallui.foldscreen.presentation.controller.VideoUpgradeRequestManager$lifeCycleObserver$1] */
    public VideoUpgradeRequestManager(ComponentActivity activity, FoldScreenActivityViewModel viewModel) {
        i.f(activity, "activity");
        i.f(viewModel, "viewModel");
        this.f18423a = activity;
        this.f18424b = viewModel;
        this.f18425c = new AtomicBoolean(true);
        this.f18427e = new BroadcastReceiver() { // from class: com.android.incallui.foldscreen.presentation.controller.VideoUpgradeRequestManager$requestReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                AtomicBoolean atomicBoolean;
                boolean a10 = b.a(intent);
                StringBuilder sb = new StringBuilder();
                sb.append("onReceive: action = ");
                if (intent != null) {
                    str = intent.getAction();
                } else {
                    str = null;
                }
                sb.append(str);
                sb.append(", isShowDialog = ");
                sb.append(a10);
                Log.d("VideoUpgradeRequestManager", sb.toString());
                atomicBoolean = VideoUpgradeRequestManager.this.f18425c;
                atomicBoolean.set(!a10);
                if (a10) {
                    VideoUpgradeRequestManager.this.k();
                } else {
                    VideoUpgradeRequestManager.this.i();
                }
            }
        };
        this.f18428f = new InterfaceC0480c() { // from class: com.android.incallui.foldscreen.presentation.controller.VideoUpgradeRequestManager$lifeCycleObserver$1
            @Override // androidx.lifecycle.InterfaceC0480c
            public void onDestroy(InterfaceC0492o owner) {
                i.f(owner, "owner");
                Log.d("VideoUpgradeRequestManager", "onDestroy: ");
                VideoUpgradeRequestManager.this.i();
            }

            @Override // androidx.lifecycle.InterfaceC0480c
            public void onResume(InterfaceC0492o owner) {
                i.f(owner, "owner");
                Log.d("VideoUpgradeRequestManager", "onResume: ");
                VideoUpgradeRequestManager.this.k();
            }
        };
    }

    public static final void g(COUIBottomSheetDialog dialog, VideoUpgradeRequestManager this$0, DialogInterface dialogInterface) {
        i.f(dialog, "$dialog");
        i.f(this$0, "this$0");
        dialog.setPanelBackground(C0991a.b(this$0.f18423a, c.f2833a));
        L1.a.a(dialog);
    }

    public static final void h(VideoUpgradeRequestManager this$0, COUIBottomSheetDialog dialog, DialogInterface dialogInterface) {
        i.f(this$0, "this$0");
        i.f(dialog, "$dialog");
        if (!this$0.f18425c.get() && L1.a.b(dialog)) {
            this$0.f18424b.n();
        }
    }

    public final COUIBottomSheetDialog f() {
        final COUIBottomSheetDialog cOUIBottomSheetDialog = new COUIBottomSheetDialog(this.f18423a, g.f2877a);
        cOUIBottomSheetDialog.setContentView(cOUIBottomSheetDialog.getLayoutInflater().inflate(e.f2869f, (ViewGroup) null));
        cOUIBottomSheetDialog.setIsShowInMaxHeight(true);
        cOUIBottomSheetDialog.setCanceledOnTouchOutside(false);
        cOUIBottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: X1.c
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                VideoUpgradeRequestManager.g(COUIBottomSheetDialog.this, this, dialogInterface);
            }
        });
        cOUIBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: X1.d
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VideoUpgradeRequestManager.h(VideoUpgradeRequestManager.this, cOUIBottomSheetDialog, dialogInterface);
            }
        });
        return cOUIBottomSheetDialog;
    }

    public final void i() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18426d;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.dismiss();
        }
        this.f18426d = null;
    }

    public final void j() {
        this.f18423a.getLifecycle().a(this.f18428f);
        b.b(this.f18427e);
    }

    public final void k() {
        if (this.f18425c.get() || !this.f18423a.getLifecycle().b().b(Lifecycle.State.RESUMED)) {
            return;
        }
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18426d;
        if (cOUIBottomSheetDialog != null && cOUIBottomSheetDialog.isShowing()) {
            return;
        }
        COUIBottomSheetDialog cOUIBottomSheetDialog2 = this.f18426d;
        if (cOUIBottomSheetDialog2 == null) {
            cOUIBottomSheetDialog2 = f();
        }
        this.f18426d = cOUIBottomSheetDialog2;
        if (cOUIBottomSheetDialog2 != null) {
            cOUIBottomSheetDialog2.show();
        }
    }

    public final void l() {
        b.d(this.f18427e);
        this.f18423a.getLifecycle().d(this.f18428f);
    }
}
