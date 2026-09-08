package com.android.contacts.scenecard;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.oplus.dialer.R;

/* compiled from: SceneDialtactsActivity.kt */
/* loaded from: classes.dex */
public final class SceneDialtactsActivity extends AppCompatActivity implements InterfaceC0667a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f17201d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public SceneDialtactsFragment f17202a;

    /* renamed from: b, reason: collision with root package name */
    public P f17203b;

    /* renamed from: c, reason: collision with root package name */
    public SceneContinueLifecycleObserver f17204c;

    /* compiled from: SceneDialtactsActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    @Override // com.android.contacts.scenecard.InterfaceC0667a
    public void E() {
        androidx.fragment.app.B p10 = getSupportFragmentManager().p();
        SceneDialtactsFragment sceneDialtactsFragment = new SceneDialtactsFragment();
        this.f17202a = sceneDialtactsFragment;
        m9.q qVar = m9.q.f35511a;
        p10.s(R.id.scene_dial_fragment_container, sceneDialtactsFragment).j();
        this.f17203b = null;
    }

    @Override // com.android.contacts.scenecard.InterfaceC0667a
    public boolean G() {
        P p10 = this.f17203b;
        boolean z10 = false;
        if (p10 != null && p10.r1() == 2) {
            z10 = true;
        }
        H7.b.e("SceneDialtactsActivity", "isShowingSystemPermissionDialog: " + z10);
        return z10;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Configuration configuration;
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            configuration = resources.getConfiguration();
        } else {
            configuration = null;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.fontScale = 1.0f;
        applyOverrideConfiguration(configuration2);
        super.attachBaseContext(context);
    }

    @Override // com.android.contacts.scenecard.InterfaceC0667a
    public boolean i() {
        Boolean bool;
        SceneDialtactsFragment sceneDialtactsFragment = this.f17202a;
        if (sceneDialtactsFragment != null) {
            bool = Boolean.valueOf(sceneDialtactsFragment.isDialpadShow());
        } else {
            bool = null;
        }
        H7.b.e("SceneDialtactsActivity", "isDialpadShow: " + bool);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getDelegate().I(1);
        super.onCreate(bundle);
        H7.b.e("SceneDialtactsActivity", "onCreate");
        setContentView(R.layout.scene_activity_dialtacts);
        Lifecycle lifecycle = getLifecycle();
        SceneContinueLifecycleObserver sceneContinueLifecycleObserver = new SceneContinueLifecycleObserver(this);
        this.f17204c = sceneContinueLifecycleObserver;
        lifecycle.a(sceneContinueLifecycleObserver);
        if (SceneStatementAndPermissionChecker.f17245a.h()) {
            androidx.fragment.app.B p10 = getSupportFragmentManager().p();
            P p11 = new P();
            this.f17203b = p11;
            m9.q qVar = m9.q.f35511a;
            p10.s(R.id.scene_dial_fragment_container, p11).l();
            return;
        }
        E();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        H7.b.e("SceneDialtactsActivity", "onDestroy");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        H7.b.e("SceneDialtactsActivity", "onPause");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        H7.b.e("SceneDialtactsActivity", "onResume");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        H7.b.e("SceneDialtactsActivity", "onStart");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        H7.b.e("SceneDialtactsActivity", "onStop");
    }

    @Override // com.android.contacts.scenecard.InterfaceC0667a
    public boolean p() {
        P p10 = this.f17203b;
        boolean z10 = false;
        if (p10 != null && p10.r1() == 3) {
            z10 = true;
        }
        H7.b.e("SceneDialtactsActivity", "isShowingAppSetPermissionDialog: " + z10);
        return z10;
    }

    @Override // com.android.contacts.scenecard.InterfaceC0667a
    public void q() {
        SceneContinueLifecycleObserver sceneContinueLifecycleObserver = this.f17204c;
        if (sceneContinueLifecycleObserver != null) {
            sceneContinueLifecycleObserver.g();
        }
    }
}
