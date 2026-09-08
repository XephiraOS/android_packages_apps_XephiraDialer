package com.oplus.blacklistapp.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coui.appcompat.button.COUIButton;
import com.coui.appcompat.button.SingleButtonWrap;
import com.oplus.blacklistapp.activities.NumberEditActivity;
import com.oplus.blacklistapp.fragment.EditFirstMatchFragment;
import com.oplus.blacklistapp.fragment.EditNumberFragment;
import com.oplus.blacklistapp.fragment.o;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: NumberEditActivity.kt */
/* loaded from: classes3.dex */
public final class NumberEditActivity extends BaseActivity {

    /* renamed from: g, reason: collision with root package name */
    public static final a f26385g = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public Fragment f26386e;

    /* renamed from: f, reason: collision with root package name */
    public SingleButtonWrap f26387f;

    /* compiled from: NumberEditActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void M0(Ref$ObjectRef fragment, View view) {
        i.f(fragment, "$fragment");
        ((o) fragment.element).onButtonClick();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, androidx.fragment.app.Fragment] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.oplus.blacklistapp.fragment.o, T] */
    public final void L0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        i.e(supportFragmentManager, "supportFragmentManager");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = supportFragmentManager.m0("number_edit");
        Log.i("NumberEditActivity", "initEditFunctionFragment mFragment = " + this.f26386e);
        if (!(ref$ObjectRef.element instanceof o)) {
            ref$ObjectRef.element = new o();
            supportFragmentManager.p().t(p.f27338H, (Fragment) ref$ObjectRef.element, "number_edit").i();
        }
        this.f26386e = (Fragment) ref$ObjectRef.element;
        View findViewById = findViewById(p.f27347L0);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        COUIButton cOUIButton = (COUIButton) findViewById(p.f27345K0);
        if (cOUIButton != null) {
            this.f26387f = new SingleButtonWrap(cOUIButton, 6);
        } else {
            cOUIButton = null;
        }
        if (cOUIButton != null) {
            cOUIButton.setOnClickListener(new View.OnClickListener() { // from class: p6.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NumberEditActivity.M0(Ref$ObjectRef.this, view);
                }
            });
        }
    }

    public final void N0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        i.e(supportFragmentManager, "supportFragmentManager");
        Fragment m02 = supportFragmentManager.m0("number_edit");
        this.f26386e = m02;
        Log.i("NumberEditActivity", "initEditNumberFragment mFragment = " + m02);
        if (!(this.f26386e instanceof EditNumberFragment)) {
            EditNumberFragment editNumberFragment = new EditNumberFragment();
            this.f26386e = editNumberFragment;
            supportFragmentManager.p().t(p.f27338H, editNumberFragment, "number_edit").i();
        }
    }

    public final void O0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        i.e(supportFragmentManager, "supportFragmentManager");
        Fragment m02 = supportFragmentManager.m0("number_edit");
        this.f26386e = m02;
        Log.i("NumberEditActivity", "initFirstMatchFragment mFragment = " + m02);
        if (!(this.f26386e instanceof EditFirstMatchFragment)) {
            EditFirstMatchFragment editFirstMatchFragment = new EditFirstMatchFragment();
            this.f26386e = editFirstMatchFragment;
            supportFragmentManager.p().t(p.f27338H, editFirstMatchFragment, "number_edit").i();
        }
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity
    public boolean o0() {
        return false;
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        SingleButtonWrap singleButtonWrap = this.f26387f;
        if (singleButtonWrap != null) {
            singleButtonWrap.onConfigurationChanged(newConfig);
        }
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(r.f27429A);
        String action = getIntent().getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -2095220280) {
                if (hashCode == 1302413190 && action.equals("oplus.intent.action.black_list.edit_first_match")) {
                    O0();
                    return;
                }
            } else if (action.equals("oplus.intent.action.black_list.edit_function")) {
                L0();
                return;
            }
        }
        N0();
    }
}
