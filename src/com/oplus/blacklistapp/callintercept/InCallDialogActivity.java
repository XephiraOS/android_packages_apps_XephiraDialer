package com.oplus.blacklistapp.callintercept;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import c7.C0565a;
import com.oplus.blacklistapp.callintercept.b;
import com.oplus.blacklistapp.u;
import com.oplus.utils.C0863y;
import v6.C1627a;
import v6.C1632f;

/* loaded from: classes3.dex */
public class InCallDialogActivity extends Activity implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public boolean f26557a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f26558b = 0;

    /* renamed from: c, reason: collision with root package name */
    public Handler f26559c = new Handler();

    /* renamed from: d, reason: collision with root package name */
    public Runnable f26560d = new e();

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnKeyListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            C1627a.c("InCallDialogActivity", "mInterceptDialog onKey = " + i10);
            if (i10 == 4) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            C1627a.c("InCallDialogActivity", "mInterceptDialog onDismiss");
            C1632f.d0(-1);
            C1632f.S(InCallDialogActivity.this.getApplicationContext(), InCallDialogActivity.this.f26557a);
            InCallDialogActivity.this.c();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C1627a.c("InCallDialogActivity", "mInterceptDialog OnClick Positive");
            C1632f.h0(InCallDialogActivity.this.getApplicationContext());
            InCallDialogActivity inCallDialogActivity = InCallDialogActivity.this;
            inCallDialogActivity.f26557a = true;
            inCallDialogActivity.c();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            C1627a.c("InCallDialogActivity", "mInterceptDialog OnClick Negative");
            C1632f.g(InCallDialogActivity.this.getApplicationContext());
            InCallDialogActivity.this.c();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1627a.c("InCallDialogActivity", "run to finish activity");
            if (!InCallDialogActivity.this.isFinishing()) {
                InCallDialogActivity.this.finish();
            }
        }
    }

    public final void a() {
        C1627a.c("InCallDialogActivity", "delayToFinishActivity");
        this.f26559c.postDelayed(this.f26560d, 300L);
    }

    public final void b(int i10) {
        try {
            C1627a.c("InCallDialogActivity", "dismissDialogSafely, id = " + i10);
            dismissDialog(i10);
        } catch (IllegalArgumentException unused) {
        }
    }

    public void c() {
        C1627a.c("InCallDialogActivity", "finishActivity");
        b(this.f26558b);
        this.f26559c.postDelayed(this.f26560d, 300L);
    }

    @Override // android.app.Activity
    public void finish() {
        C1627a.c("InCallDialogActivity", "finish");
        C1632f.e0(null);
        super.finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        C1627a.c("InCallDialogActivity", "onCancel");
        a();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int b10 = C0863y.b(getIntent(), "dialog_id", -1);
        if (b10 != -1) {
            showDialog(b10);
        }
        if (b10 == 1) {
            C1632f.e0(this);
            C1632f.Q(getApplicationContext());
        }
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10) {
        com.oplus.blacklistapp.callintercept.b b10;
        if (i10 != 1) {
            b10 = null;
        } else {
            b10 = new b.a(this).g(getString(u.f27692t1)).c(R.string.cancel, new d()).f(u.f27594Z2, new c()).d(new b()).e(new a()).b();
        }
        if (b10 == null) {
            return null;
        }
        b10.setCanceledOnTouchOutside(false);
        Window window = b10.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        C0565a.a(window, attributes);
        window.setAttributes(attributes);
        return b10;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        C1627a.c("InCallDialogActivity", "onDismiss");
        a();
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i10, Dialog dialog) {
        super.onPrepareDialog(i10, dialog);
        this.f26558b = i10;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
    }
}
