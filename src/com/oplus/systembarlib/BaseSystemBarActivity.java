package com.oplus.systembarlib;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.X;
import com.oplus.systembarlib.ActivitySystemBarController;

/* compiled from: BaseSystemBarActivity.kt */
/* loaded from: classes3.dex */
public class BaseSystemBarActivity extends AppCompatActivity implements e, ActivitySystemBarController.b, m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivitySystemBarController f28986a = new ActivitySystemBarController();

    @Override // com.oplus.systembarlib.h
    public boolean B() {
        return this.f28986a.B();
    }

    @Override // com.oplus.systembarlib.m
    public void F0(X windowInsets) {
        kotlin.jvm.internal.i.f(windowInsets, "windowInsets");
    }

    @Override // com.oplus.systembarlib.h
    public void b0() {
        this.f28986a.b0();
    }

    @Override // com.oplus.systembarlib.ActivitySystemBarController.b
    public b e() {
        return new b();
    }

    public void g0(AppCompatActivity activity, ActivitySystemBarController.b styleGetter) {
        kotlin.jvm.internal.i.f(activity, "activity");
        kotlin.jvm.internal.i.f(styleGetter, "styleGetter");
        this.f28986a.g(activity, styleGetter);
    }

    @Override // com.oplus.systembarlib.f
    public void h0(int i10) {
        this.f28986a.h0(i10);
    }

    public void k0(Configuration config) {
        kotlin.jvm.internal.i.f(config, "config");
        this.f28986a.i(config);
    }

    public void l0(m listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.f28986a.j(listener);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        k0(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g0(this, this);
        l0(this);
    }

    @Override // com.oplus.systembarlib.g
    public void v(boolean z10) {
        this.f28986a.v(z10);
    }
}
