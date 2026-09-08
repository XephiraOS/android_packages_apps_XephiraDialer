package com.oplus.contacts.googlecontacts.actvities;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.coui.appcompat.toolbar.COUIToolbar;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: MoveContactsToGoogleActivity.kt */
/* loaded from: classes3.dex */
public final class MoveContactsToGoogleActivity extends BasicActivity {

    /* renamed from: q, reason: collision with root package name */
    public static final a f27819q = new a(null);

    /* renamed from: o, reason: collision with root package name */
    public MoveContactsToGoogleFragment f27820o;

    /* renamed from: p, reason: collision with root package name */
    public int f27821p;

    /* compiled from: MoveContactsToGoogleActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void O0(int i10) {
        this.f27821p = i10;
        MoveContactsToGoogleFragment moveContactsToGoogleFragment = this.f27820o;
        if (moveContactsToGoogleFragment != null) {
            moveContactsToGoogleFragment.f1();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean T0() {
        return false;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(Y6.c.f5555b);
        setSupportActionBar((COUIToolbar) findViewById(Y6.b.f5553h));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.x(true);
            supportActionBar.t(true);
            supportActionBar.w(false);
        }
        Fragment m02 = getSupportFragmentManager().m0("move_contacts_to_google");
        if (m02 instanceof MoveContactsToGoogleFragment) {
            this.f27820o = (MoveContactsToGoogleFragment) m02;
            return;
        }
        MoveContactsToGoogleFragment moveContactsToGoogleFragment = new MoveContactsToGoogleFragment();
        getSupportFragmentManager().p().t(Y6.b.f5550e, moveContactsToGoogleFragment, "move_contacts_to_google").i();
        this.f27820o = moveContactsToGoogleFragment;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        i.f(item, "item");
        if (item.getItemId() == 16908332) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public final int p1() {
        return this.f27821p;
    }
}
