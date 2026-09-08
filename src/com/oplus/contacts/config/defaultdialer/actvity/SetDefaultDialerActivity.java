package com.oplus.contacts.config.defaultdialer.actvity;

import W6.b;
import W6.c;
import X6.d;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.oplus.contacts.config.defaultdialer.SetDefaultImpl;
import com.oplus.contacts.config.defaultdialer.actvity.SetDefaultDialerActivity;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: SetDefaultDialerActivity.kt */
/* loaded from: classes3.dex */
public final class SetDefaultDialerActivity extends BasicActivity {

    /* renamed from: p, reason: collision with root package name */
    public static final a f27808p = new a(null);

    /* renamed from: o, reason: collision with root package name */
    public d f27809o;

    /* compiled from: SetDefaultDialerActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final boolean q1(SetDefaultDialerActivity this$0, MenuItem menuItem) {
        i.f(this$0, "this$0");
        if (menuItem != null && menuItem.getItemId() == W6.a.f4211a) {
            this$0.finish();
            return true;
        }
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean R0() {
        return false;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        d dVar;
        super.onCreate(bundle);
        SetDefaultImpl.f27800e.a().e(this);
        setContentView(b.f4215a);
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(W6.a.f4214d);
        if (cOUIToolbar != null) {
            cOUIToolbar.inflateMenu(c.f4217a);
            cOUIToolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: X6.a
                @Override // androidx.appcompat.widget.Toolbar.g
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    boolean q12;
                    q12 = SetDefaultDialerActivity.q1(SetDefaultDialerActivity.this, menuItem);
                    return q12;
                }
            });
        }
        Fragment m02 = getSupportFragmentManager().m0("SetDefaultDialerActivity");
        if (m02 instanceof d) {
            dVar = (d) m02;
        } else {
            dVar = new d();
            getSupportFragmentManager().p().t(W6.a.f4212b, dVar, "SetDefaultDialerActivity").i();
        }
        this.f27809o = dVar;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (i.b(P7.d.a(this), getPackageName())) {
            H7.b.e("SetDefaultDialerActivity", "Is default dialer, start Dialer or previous intent !!!!!!");
            SetDefaultImpl.f27800e.a().f(this);
            finish();
        }
    }
}
