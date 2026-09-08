package com.android.incallui.foldscreen.presentation.activity;

import D2.j;
import Y1.a;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.i;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.K;
import androidx.lifecycle.p;
import com.android.incallui.CallList;
import com.android.incallui.Log;
import com.android.incallui.foldscreen.presentation.controller.RespondViaSmsManager;
import com.android.incallui.foldscreen.presentation.controller.VideoUpgradeRequestManager;
import com.android.incallui.foldscreen.presentation.fragment.FoldScreenInCallDialogFragment;
import com.android.incallui.foldscreen.presentation.viewmodel.FoldScreenActivityViewModel;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.S;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: FoldScreenInCallActivity.kt */
/* loaded from: classes.dex */
public final class FoldScreenInCallActivity extends AppCompatActivity {

    /* renamed from: h, reason: collision with root package name */
    public static final a f18394h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static WeakReference<FoldScreenInCallActivity> f18395i = new WeakReference<>(null);

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f18396a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final String f18397b = FoldScreenInCallDialogFragment.class.getName();

    /* renamed from: c, reason: collision with root package name */
    public boolean f18398c;

    /* renamed from: d, reason: collision with root package name */
    public final d f18399d;

    /* renamed from: e, reason: collision with root package name */
    public final d f18400e;

    /* renamed from: f, reason: collision with root package name */
    public final b f18401f;

    /* renamed from: g, reason: collision with root package name */
    public final c f18402g;

    /* compiled from: FoldScreenInCallActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final boolean c() {
            FoldScreenInCallActivity foldScreenInCallActivity = (FoldScreenInCallActivity) FoldScreenInCallActivity.f18395i.get();
            if (foldScreenInCallActivity != null) {
                return foldScreenInCallActivity.f18398c;
            }
            return false;
        }

        public final void d(FoldScreenInCallActivity foldScreenInCallActivity) {
            FoldScreenInCallActivity foldScreenInCallActivity2 = (FoldScreenInCallActivity) FoldScreenInCallActivity.f18395i.get();
            if (foldScreenInCallActivity2 != null && !i.b(foldScreenInCallActivity2, foldScreenInCallActivity)) {
                Log.w("INCALLUI_FoldScreenInCallActivity", "setActivity: Setting a second activity before destroying the first.");
            }
            FoldScreenInCallActivity.f18395i = new WeakReference(foldScreenInCallActivity);
        }

        public final void e(FoldScreenInCallActivity foldScreenInCallActivity) {
            FoldScreenInCallActivity foldScreenInCallActivity2 = (FoldScreenInCallActivity) FoldScreenInCallActivity.f18395i.get();
            if (foldScreenInCallActivity2 == null) {
                Log.i("INCALLUI_FoldScreenInCallActivity", "unsetActivity: No InCallActivity currently set, no need to unset.");
            } else if (i.b(foldScreenInCallActivity2, foldScreenInCallActivity)) {
                FoldScreenInCallActivity.f18395i = new WeakReference(null);
            } else {
                Log.w("INCALLUI_FoldScreenInCallActivity", "unsetActivity: Second instance of InCallActivity is trying to unregister when another instance is active. Ignoring.");
            }
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: FoldScreenInCallActivity.kt */
    /* loaded from: classes.dex */
    public static final class b extends i.a {
        public b() {
        }

        @Override // androidx.databinding.i.a
        public void d(androidx.databinding.i iVar, int i10) {
            boolean booleanValue = FoldScreenInCallActivity.this.t0().v().s0().booleanValue();
            Log.d("INCALLUI_FoldScreenInCallActivity", "triggerWindowScreenOn: " + booleanValue);
            FoldScreenInCallActivity.this.setTurnScreenOn(booleanValue);
        }
    }

    /* compiled from: FoldScreenInCallActivity.kt */
    /* loaded from: classes.dex */
    public static final class c extends i.a {
        public c() {
        }

        @Override // androidx.databinding.i.a
        public void d(androidx.databinding.i iVar, int i10) {
            FoldScreenInCallActivity.this.q0();
        }
    }

    public FoldScreenInCallActivity() {
        d b10;
        d b11;
        b10 = kotlin.a.b(new InterfaceC1637a<FoldScreenActivityViewModel>() { // from class: com.android.incallui.foldscreen.presentation.activity.FoldScreenInCallActivity$viewModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final FoldScreenActivityViewModel invoke() {
                return (FoldScreenActivityViewModel) new K(FoldScreenInCallActivity.this, new Z1.d(a.f5520a)).a(FoldScreenActivityViewModel.class);
            }
        });
        this.f18399d = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<VideoUpgradeRequestManager>() { // from class: com.android.incallui.foldscreen.presentation.activity.FoldScreenInCallActivity$videoUpgradeRequestManager$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final VideoUpgradeRequestManager invoke() {
                FoldScreenInCallActivity foldScreenInCallActivity = FoldScreenInCallActivity.this;
                return new VideoUpgradeRequestManager(foldScreenInCallActivity, foldScreenInCallActivity.t0());
            }
        });
        this.f18400e = b11;
        this.f18401f = new b();
        this.f18402g = new c();
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            if (CallList.getInstance().hasAnyLiveCall()) {
                Log.i("INCALLUI_FoldScreenInCallActivity", "finish: moveTaskToBack");
                moveTaskToBack(true);
            } else {
                Log.i("INCALLUI_FoldScreenInCallActivity", "finish: real finish");
                super.finishAndRemoveTask();
            }
        } catch (Exception e10) {
            Log.e("INCALLUI_FoldScreenInCallActivity", e10.getMessage());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("INCALLUI_FoldScreenInCallActivity", "onCreate: " + this);
        t0().m();
        j.a(getWindow());
        u0();
        setTurnScreenOn(t0().B());
        t0().v().f(this.f18401f);
        t0().o().f(this.f18402g);
        RespondViaSmsManager.f18413a.k(true);
        s0().j();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d("INCALLUI_FoldScreenInCallActivity", "onDestroy: " + this);
        f18394h.e(this);
        t0().v().l0(this.f18401f);
        t0().o().l0(this.f18402g);
        RespondViaSmsManager.f18413a.k(false);
        s0().l();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("INCALLUI_FoldScreenInCallActivity", "onNewIntent: " + this);
        t0().m();
        setIntent(intent);
        u0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Log.d("INCALLUI_FoldScreenInCallActivity", "onPause: " + this);
        this.f18398c = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d("INCALLUI_FoldScreenInCallActivity", "onResume: " + this);
        this.f18398c = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Log.d("INCALLUI_FoldScreenInCallActivity", "onStart: " + this);
        super.onStart();
        f18394h.d(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Log.d("INCALLUI_FoldScreenInCallActivity", "onStop: " + this);
        f18394h.e(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        Log.d("INCALLUI_FoldScreenInCallActivity", "onWindowFocusChanged: " + z10);
        this.f18396a.compareAndSet(z10 ^ true, z10);
    }

    public final void q0() {
        if (!t0().o().s0().booleanValue() || isFinishing()) {
            return;
        }
        C1244g.d(p.a(this), S.c(), null, new FoldScreenInCallActivity$finishFoldScreenInCallActivity$1(this, null), 2, null);
    }

    public final FoldScreenInCallDialogFragment r0(FragmentManager fragmentManager) {
        Fragment m02 = fragmentManager.m0(this.f18397b);
        if (m02 instanceof FoldScreenInCallDialogFragment) {
            return (FoldScreenInCallDialogFragment) m02;
        }
        return null;
    }

    public final VideoUpgradeRequestManager s0() {
        return (VideoUpgradeRequestManager) this.f18400e.getValue();
    }

    public final FoldScreenActivityViewModel t0() {
        return (FoldScreenActivityViewModel) this.f18399d.getValue();
    }

    public final void u0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.i.e(supportFragmentManager, "supportFragmentManager");
        FoldScreenInCallDialogFragment r02 = r0(supportFragmentManager);
        if (r02 == null) {
            r02 = new FoldScreenInCallDialogFragment();
        }
        r02.show(getSupportFragmentManager(), this.f18397b);
    }
}
