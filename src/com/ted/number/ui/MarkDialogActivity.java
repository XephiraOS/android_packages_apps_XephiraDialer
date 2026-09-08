package com.ted.number.ui;

import C7.e;
import E0.b;
import U0.n;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.contacts.framework.api.numberidentify.interfaces.INumberIdentifyApi;
import com.android.contacts.framework.api.numberidentify.interfaces.IRecognitionNumber;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.l;
import com.android.incallui.OplusNumberMarkUtils;
import com.customize.contacts.util.C0801l;
import com.ted.number.ui.MarkDialogActivity;
import com.ted.number.ui.a;

/* loaded from: classes4.dex */
public class MarkDialogActivity extends BasicActivity {

    /* renamed from: o, reason: collision with root package name */
    public boolean f29727o;

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        n.h();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (B3.a.u()) {
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: g9.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    MarkDialogActivity.this.q1(dialogInterface, i10);
                }
            };
            if (l.d(this, "com.ted.number")) {
                l.f(this, "com.ted.number", onClickListener, 0);
                return;
            }
        }
        s1();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f29727o) {
            if (l.d(this, "com.ted.number")) {
                finish();
            } else {
                s1();
            }
            this.f29727o = false;
        }
    }

    public final /* synthetic */ void q1(DialogInterface dialogInterface, int i10) {
        if (i10 == -2) {
            finish();
        } else if (i10 == -1) {
            this.f29727o = true;
        }
    }

    public void r1(Activity activity, String str, int i10, int i11, boolean z10, boolean z11) {
        String str2;
        boolean z12;
        int i12;
        if (!TextUtils.isEmpty(str)) {
            str2 = b.j(activity, str);
            z12 = b.w(str);
            i12 = b.i(activity, str);
        } else {
            str2 = null;
            z12 = false;
            i12 = 0;
        }
        com.ted.number.ui.a aVar = new com.ted.number.ui.a(activity);
        aVar.l(new a(str, activity, i10, i11, z11, z10));
        aVar.n(str2, true, z12, i12);
    }

    public final void s1() {
        if (B3.a.u()) {
            b.a();
        }
        String l10 = e.l(getIntent(), "number");
        int d10 = e.d(getIntent(), OplusNumberMarkUtils.OplusContact.OPLUS_MARK_CONTACTS_CALL_TYPE, 1);
        boolean c10 = e.c(getIntent(), "isInBlackList", false);
        boolean c11 = e.c(getIntent(), "isInWhiteList", false);
        if (TextUtils.isEmpty(l10)) {
            finish();
        } else {
            t1(this, l10, d10, c10, c11);
        }
    }

    public final void t1(Context context, String str, int i10, boolean z10, boolean z11) {
        r1((Activity) context, str, 0, i10, z10, z11);
    }

    /* loaded from: classes4.dex */
    public class a implements a.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f29728a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f29729b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f29730c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f29731d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f29732e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f29733f;

        /* renamed from: com.ted.number.ui.MarkDialogActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0285a implements INumberIdentifyApi.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f29735a;

            public C0285a(int i10) {
                this.f29735a = i10;
            }
        }

        public a(String str, Activity activity, int i10, int i11, boolean z10, boolean z11) {
            this.f29728a = str;
            this.f29729b = activity;
            this.f29730c = i10;
            this.f29731d = i11;
            this.f29732e = z10;
            this.f29733f = z11;
        }

        @Override // com.ted.number.ui.a.c
        public void b(String str, int i10) {
            c(str, str, i10);
        }

        @Override // com.ted.number.ui.a.c
        public void c(String str, String str2, int i10) {
            int i11;
            IRecognitionNumber h10 = b.h(this.f29728a);
            if (h10 != null && h10.B() != null) {
                i11 = h10.B().u();
            } else {
                i11 = 0;
            }
            if (!TextUtils.isEmpty(str)) {
                C0801l.y(this.f29728a, this.f29729b);
                b.A(new F0.b(this.f29728a, str, Integer.valueOf(this.f29730c), Integer.valueOf(this.f29731d), Integer.valueOf(i10), Boolean.valueOf(C0801l.o(this.f29731d))), new C0285a(i11));
            }
            b.C(this.f29728a);
        }

        @Override // com.ted.number.ui.a.c
        public void a() {
        }
    }
}
