package com.oplus.blacklistapp.callintercept.settings;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.B;
import androidx.fragment.app.Fragment;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.oplus.blacklistapp.activities.BaseActivity;
import com.oplus.blacklistapp.callintercept.CallInterceptController;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0863y;
import com.oplus.utils.StatisticsUtils;

/* compiled from: CallHarassInterceptMarkedNumberActivity.kt */
/* loaded from: classes3.dex */
public final class CallHarassInterceptMarkedNumberActivity extends BaseActivity implements CallInterceptController.b {

    /* renamed from: h, reason: collision with root package name */
    public static final a f26760h = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public COUIToolbar f26761e;

    /* renamed from: f, reason: collision with root package name */
    public CallHarassInterceptMarkedNumberFragment f26762f;

    /* renamed from: g, reason: collision with root package name */
    public int f26763g;

    /* compiled from: CallHarassInterceptMarkedNumberActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    private final void L0() {
        COUIToolbar cOUIToolbar = this.f26761e;
        if (cOUIToolbar != null) {
            cOUIToolbar.setNavigationIcon(X8.g.f4850c);
        }
        COUIToolbar cOUIToolbar2 = this.f26761e;
        if (cOUIToolbar2 != null) {
            cOUIToolbar2.setNavigationContentDescription(e.h.f30261a);
        }
        COUIToolbar cOUIToolbar3 = this.f26761e;
        if (cOUIToolbar3 != null) {
            cOUIToolbar3.setIsTitleCenterStyle(false);
        }
        COUIToolbar cOUIToolbar4 = this.f26761e;
        if (cOUIToolbar4 != null) {
            cOUIToolbar4.setTitle(com.oplus.blacklistapp.u.f27672p1);
        }
        COUIToolbar cOUIToolbar5 = this.f26761e;
        if (cOUIToolbar5 != null) {
            cOUIToolbar5.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.oplus.blacklistapp.callintercept.settings.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CallHarassInterceptMarkedNumberActivity.M0(CallHarassInterceptMarkedNumberActivity.this, view);
                }
            });
        }
    }

    public static final void M0(CallHarassInterceptMarkedNumberActivity this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.finish();
    }

    public final void N0() {
        Fragment m02 = getSupportFragmentManager().m0("call_harass_intercept_marked_number");
        if (m02 != null && (m02 instanceof CallHarassInterceptMarkedNumberFragment)) {
            this.f26762f = (CallHarassInterceptMarkedNumberFragment) m02;
        }
        if (this.f26762f == null) {
            this.f26762f = new CallHarassInterceptMarkedNumberFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("slotId", this.f26763g);
            CallHarassInterceptMarkedNumberFragment callHarassInterceptMarkedNumberFragment = this.f26762f;
            if (callHarassInterceptMarkedNumberFragment != null) {
                callHarassInterceptMarkedNumberFragment.setArguments(bundle);
            }
        }
        B p10 = getSupportFragmentManager().p();
        int i10 = com.oplus.blacklistapp.p.f27374Z;
        CallHarassInterceptMarkedNumberFragment callHarassInterceptMarkedNumberFragment2 = this.f26762f;
        kotlin.jvm.internal.i.c(callHarassInterceptMarkedNumberFragment2);
        p10.t(i10, callHarassInterceptMarkedNumberFragment2, "call_harass_intercept_marked_number");
        p10.j();
        getSupportFragmentManager().i0();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.oplus.blacklistapp.r.f27446a);
        this.f26763g = C0863y.b(getIntent(), "slotId", 0);
        boolean a10 = C0863y.a(getIntent(), "is_single_sim", false);
        this.f26761e = (COUIToolbar) findViewById(com.oplus.blacklistapp.p.f27363T0);
        L0();
        N0();
        StatisticsUtils.c(this, "mark_number_entry", a10, this.f26763g);
        CallInterceptController.e().d(this);
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        StatisticsUtils.e(this, "mark_number_back");
        CallInterceptController.e().m(this);
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        C0846g.i("CallHarassInterceptMarkedNumberActivity", "onStatusBarClicked");
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void u(int i10) {
        C0846g.i("CallHarassInterceptMarkedNumber", "handleHotPlugOut slot = " + i10);
        finish();
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void P0(int i10) {
    }
}
