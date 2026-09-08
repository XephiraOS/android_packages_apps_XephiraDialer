package com.android.contacts.dialpad;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.android.contacts.dialpad.i;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.VirtualSupportUtils;

/* compiled from: SpeedDialManageActivity.kt */
/* loaded from: classes.dex */
public final class SpeedDialManageActivity extends BasicActivity {

    /* renamed from: G, reason: collision with root package name */
    public static final a f14891G = new a(null);

    /* renamed from: E, reason: collision with root package name */
    public COUIAlertDialogBuilder f14896E;

    /* renamed from: F, reason: collision with root package name */
    public androidx.appcompat.app.b f14897F;

    /* renamed from: o, reason: collision with root package name */
    public TextView f14898o;

    /* renamed from: p, reason: collision with root package name */
    public COUIRecyclerView f14899p;

    /* renamed from: q, reason: collision with root package name */
    public i f14900q;

    /* renamed from: r, reason: collision with root package name */
    public g f14901r;

    /* renamed from: x, reason: collision with root package name */
    public SharedPreferences f14902x;

    /* renamed from: y, reason: collision with root package name */
    public int f14903y = -1;

    /* renamed from: z, reason: collision with root package name */
    public int f14904z = -1;

    /* renamed from: A, reason: collision with root package name */
    public ContactInfoForSpeedDial[] f14892A = new ContactInfoForSpeedDial[0];

    /* renamed from: B, reason: collision with root package name */
    public String[] f14893B = {"", "", "", "", "", "", "", "", "", ""};

    /* renamed from: C, reason: collision with root package name */
    public String[] f14894C = {"", "", "", "", "", "", "", "", "", ""};

    /* renamed from: D, reason: collision with root package name */
    public String[] f14895D = {"", "", "", "", "", "", "", "", "", ""};

    /* compiled from: SpeedDialManageActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final int a(int i10) {
            return i10 + 300;
        }

        public final int b(int i10) {
            return i10 + 100;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SpeedDialManageActivity.kt */
    /* loaded from: classes.dex */
    public final class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int i10) {
            kotlin.jvm.internal.i.f(dialog, "dialog");
            if (i10 == 0) {
                SpeedDialManageActivity speedDialManageActivity = SpeedDialManageActivity.this;
                speedDialManageActivity.f14904z = speedDialManageActivity.f14903y;
                SpeedDialManageActivity.this.A1();
            } else if (1 == i10) {
                g gVar = SpeedDialManageActivity.this.f14901r;
                if (gVar == null) {
                    kotlin.jvm.internal.i.q("speedDialManager");
                    gVar = null;
                }
                gVar.q(1);
            }
        }
    }

    /* compiled from: SpeedDialManageActivity.kt */
    /* loaded from: classes.dex */
    public final class c extends AsyncTask<Void, Void, ContactInfoForSpeedDial[]> {
        public c() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactInfoForSpeedDial[] doInBackground(Void... voidArr) {
            kotlin.jvm.internal.i.f(voidArr, "void");
            SpeedDialManageActivity.this.F1();
            return SpeedDialManageActivity.this.E1();
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(ContactInfoForSpeedDial[] result) {
            kotlin.jvm.internal.i.f(result, "result");
            SpeedDialManageActivity.this.f14892A = result;
            i iVar = SpeedDialManageActivity.this.f14900q;
            if (iVar == null) {
                kotlin.jvm.internal.i.q("adapter");
                iVar = null;
            }
            iVar.l(SpeedDialManageActivity.this.f14892A);
            SpeedDialManageActivity.this.H1();
        }
    }

    /* compiled from: SpeedDialManageActivity.kt */
    /* loaded from: classes.dex */
    public static final class d implements i.b {
        public d() {
        }

        @Override // com.android.contacts.dialpad.i.b
        public void onItemClick(View view, int i10) {
            kotlin.jvm.internal.i.f(view, "view");
            if (C7.a.a()) {
                return;
            }
            if (i10 == 0) {
                if (!VirtualSupportUtils.m()) {
                    com.oplus.foundation.util.ui.c.b(SpeedDialManageActivity.this.getApplicationContext(), R.string.button_used_by_voicemail);
                    return;
                }
                return;
            }
            if (2 != i10 || !B3.a.E()) {
                SpeedDialManageActivity.this.f14903y = i10;
                H7.b.b("SpeedDialManageActivity", "[startActivityForResult]mAddPosition:" + SpeedDialManageActivity.this.f14903y);
                if (TextUtils.isEmpty(SpeedDialManageActivity.this.f14895D[SpeedDialManageActivity.this.f14903y + 1])) {
                    g gVar = SpeedDialManageActivity.this.f14901r;
                    if (gVar == null) {
                        kotlin.jvm.internal.i.q("speedDialManager");
                        gVar = null;
                    }
                    gVar.q(1);
                    return;
                }
                SpeedDialManageActivity.this.G1();
                return;
            }
            com.oplus.foundation.util.ui.c.b(SpeedDialManageActivity.this.getApplicationContext(), R.string.button_used_by_voicemail);
        }
    }

    private final void C1() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.A(getText(R.string.oplus_speed_dial));
            supportActionBar.u(7);
            supportActionBar.x(true);
            supportActionBar.w(false);
        }
    }

    public final void A1() {
        H7.b.e("SpeedDialManageActivity", "[actuallyRemove]mRemovePosition:" + this.f14904z);
        String[] strArr = this.f14894C;
        int i10 = this.f14904z;
        strArr[i10 + 1] = "";
        this.f14895D[i10 + 1] = "";
        this.f14893B[i10 + 1] = "";
        g gVar = this.f14901r;
        i iVar = null;
        if (gVar == null) {
            kotlin.jvm.internal.i.q("speedDialManager");
            gVar = null;
        }
        gVar.t(this.f14904z + 1, null);
        this.f14892A[this.f14904z] = new ContactInfoForSpeedDial(null, null, null, 0L, null, null, 0L, 127, null);
        i iVar2 = this.f14900q;
        if (iVar2 == null) {
            kotlin.jvm.internal.i.q("adapter");
        } else {
            iVar = iVar2;
        }
        iVar.notifyDataSetChanged();
    }

    public final void B1() {
        i iVar = this.f14900q;
        if (iVar == null) {
            kotlin.jvm.internal.i.q("adapter");
            iVar = null;
        }
        iVar.m(new d());
    }

    public final ContactInfoForSpeedDial D1(int i10) {
        int i11 = i10 + 1;
        if (TextUtils.isEmpty(this.f14895D[i11])) {
            return new ContactInfoForSpeedDial(null, null, null, 0L, null, null, 0L, 127, null);
        }
        g gVar = this.f14901r;
        if (gVar == null) {
            kotlin.jvm.internal.i.q("speedDialManager");
            gVar = null;
        }
        return gVar.l(this.f14893B[i11], this.f14895D[i11], this.f14894C[i11]);
    }

    public final ContactInfoForSpeedDial[] E1() {
        ContactInfoForSpeedDial[] contactInfoForSpeedDialArr = new ContactInfoForSpeedDial[9];
        for (int i10 = 0; i10 < 9; i10++) {
            contactInfoForSpeedDialArr[i10] = D1(i10);
        }
        return contactInfoForSpeedDialArr;
    }

    public final void F1() {
        SharedPreferences sharedPreferences = getSharedPreferences("speed_dial", 0);
        kotlin.jvm.internal.i.e(sharedPreferences, "getSharedPreferences(PRE…ME, Context.MODE_PRIVATE)");
        this.f14902x = sharedPreferences;
        for (int i10 = 2; i10 < 10; i10++) {
            String[] strArr = this.f14895D;
            SharedPreferences sharedPreferences2 = this.f14902x;
            SharedPreferences sharedPreferences3 = null;
            if (sharedPreferences2 == null) {
                kotlin.jvm.internal.i.q("pref");
                sharedPreferences2 = null;
            }
            a aVar = f14891G;
            String string = sharedPreferences2.getString(String.valueOf(aVar.b(i10)), "");
            kotlin.jvm.internal.i.c(string);
            strArr[i10] = string;
            String[] strArr2 = this.f14894C;
            SharedPreferences sharedPreferences4 = this.f14902x;
            if (sharedPreferences4 == null) {
                kotlin.jvm.internal.i.q("pref");
                sharedPreferences4 = null;
            }
            String string2 = sharedPreferences4.getString(String.valueOf(i10), "");
            kotlin.jvm.internal.i.c(string2);
            strArr2[i10] = string2;
            String[] strArr3 = this.f14893B;
            SharedPreferences sharedPreferences5 = this.f14902x;
            if (sharedPreferences5 == null) {
                kotlin.jvm.internal.i.q("pref");
            } else {
                sharedPreferences3 = sharedPreferences5;
            }
            String string3 = sharedPreferences3.getString(String.valueOf(aVar.a(i10)), "");
            kotlin.jvm.internal.i.c(string3);
            strArr3[i10] = string3;
        }
    }

    public final void G1() {
        b bVar = new b();
        String[] strArr = {getString(R.string.speed_dial_remove), getString(R.string.speed_dial_edit)};
        U0.b bVar2 = new U0.b(this, 2132083073);
        bVar2.setMessage(R.string.speed_dial_modify);
        bVar2.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        bVar2.setItems((CharSequence[]) strArr, (DialogInterface.OnClickListener) bVar);
        bVar2.setWindowGravity(bVar2.getBottomAlertDialogWindowGravity(getApplicationContext()));
        bVar2.setWindowAnimStyle(bVar2.getBottomAlertDialogWindowAnimStyle(getApplicationContext()));
        this.f14896E = bVar2;
        this.f14897F = bVar2.show();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    public final void H1() {
        for (int i10 = 2; i10 < 10; i10++) {
            g gVar = this.f14901r;
            if (gVar == null) {
                kotlin.jvm.internal.i.q("speedDialManager");
                gVar = null;
            }
            int i11 = i10 - 1;
            gVar.t(i10, this.f14892A[i11]);
            this.f14894C[i10] = this.f14892A[i11].h();
            this.f14895D[i10] = this.f14892A[i11].f();
            this.f14893B[i10] = this.f14892A[i11].d();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (C7.e.c(getIntent(), "open_from_dialog", false)) {
            overridePendingTransition(R.anim.dialog_open_enter, R.anim.dialog_open_exit);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        String str;
        super.onActivityResult(i10, i11, intent);
        H7.b.e("SpeedDialManageActivity", "[onActivityResult]mAddPosition:" + this.f14903y);
        if (1 == i10 && -1 == i11 && intent != null) {
            Uri data = intent.getData();
            i iVar = null;
            if (data != null) {
                str = data.getLastPathSegment();
            } else {
                str = null;
            }
            g gVar = this.f14901r;
            if (gVar == null) {
                kotlin.jvm.internal.i.q("speedDialManager");
                gVar = null;
            }
            kotlin.jvm.internal.i.c(str);
            ContactInfoForSpeedDial l10 = gVar.l(str, "", "");
            this.f14892A[this.f14903y] = l10;
            g gVar2 = this.f14901r;
            if (gVar2 == null) {
                kotlin.jvm.internal.i.q("speedDialManager");
                gVar2 = null;
            }
            gVar2.t(this.f14903y + 1, l10);
            this.f14893B[this.f14903y + 1] = l10.d();
            this.f14895D[this.f14903y + 1] = l10.f();
            this.f14894C[this.f14903y + 1] = l10.h();
            i iVar2 = this.f14900q;
            if (iVar2 == null) {
                kotlin.jvm.internal.i.q("adapter");
            } else {
                iVar = iVar2;
            }
            iVar.notifyDataSetChanged();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Integer num;
        Window window;
        Window window2;
        WindowManager.LayoutParams attributes;
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        androidx.appcompat.app.b bVar = this.f14897F;
        if (bVar != null && bVar.isShowing() && this.f14896E != null) {
            androidx.appcompat.app.b bVar2 = this.f14897F;
            androidx.appcompat.app.b bVar3 = null;
            if (bVar2 != null && (window2 = bVar2.getWindow()) != null && (attributes = window2.getAttributes()) != null) {
                num = Integer.valueOf(attributes.gravity);
            } else {
                num = null;
            }
            int d10 = com.oplus.foundation.util.ui.b.d(this, null, 2, null);
            if (num == null || num.intValue() != d10) {
                androidx.appcompat.app.b bVar4 = this.f14897F;
                if (bVar4 != null && (window = bVar4.getWindow()) != null) {
                    window.setWindowAnimations(0);
                }
                androidx.appcompat.app.b bVar5 = this.f14897F;
                if (bVar5 != null) {
                    bVar5.dismiss();
                }
                COUIAlertDialogBuilder cOUIAlertDialogBuilder = this.f14896E;
                if (cOUIAlertDialogBuilder != null) {
                    cOUIAlertDialogBuilder.setWindowGravity(d10);
                }
                COUIAlertDialogBuilder cOUIAlertDialogBuilder2 = this.f14896E;
                if (cOUIAlertDialogBuilder2 != null) {
                    cOUIAlertDialogBuilder2.setWindowAnimStyle(com.oplus.foundation.util.ui.b.b(this, false, null, 6, null));
                }
                COUIAlertDialogBuilder cOUIAlertDialogBuilder3 = this.f14896E;
                if (cOUIAlertDialogBuilder3 != null) {
                    bVar3 = cOUIAlertDialogBuilder3.show();
                }
                this.f14897F = bVar3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fc, code lost:
    
        if (r0 == null) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r11) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.SpeedDialManageActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        kotlin.jvm.internal.i.f(item, "item");
        if (item.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.i.f(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt("add_position", this.f14903y);
        outState.putParcelableArray("details", this.f14892A);
        outState.putStringArray("id_state", this.f14893B);
        outState.putStringArray("display_name_state", this.f14895D);
        outState.putStringArray("number_state", this.f14894C);
    }
}
