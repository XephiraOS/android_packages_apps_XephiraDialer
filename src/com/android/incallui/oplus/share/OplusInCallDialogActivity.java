package com.android.incallui.oplus.share;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUserActionStatistics;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.oplus.widgets.COUIThemeActivity;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import java.util.HashMap;
import n2.n;

/* loaded from: classes.dex */
public class OplusInCallDialogActivity extends COUIThemeActivity implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public boolean f19060a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f19061b = 0;

    /* renamed from: c, reason: collision with root package name */
    public Handler f19062c = new Handler();

    /* renamed from: d, reason: collision with root package name */
    public Runnable f19063d = new i();

    /* loaded from: classes.dex */
    public class a implements DialogInterface.OnKeyListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            Log.d("OplusInCallDialogActivity", "mInterceptDialog onKey = " + i10);
            if (i10 == 4) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Log.d("OplusInCallDialogActivity", "mInterceptDialog onDismiss");
            D2.f.M(-1);
            D2.f.I(OplusInCallDialogActivity.this.getApplicationContext(), OplusInCallDialogActivity.this.f19060a);
            OplusInCallDialogActivity.this.l0();
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            Log.d("OplusInCallDialogActivity", "mInterceptDialog OnClick Positive");
            if (!n.b(OplusInCallDialogActivity.this.getApplicationContext(), OplusPhoneUtils.OPLUS_BLACK_LIST_PACKAGE)) {
                D2.f.S(OplusInCallDialogActivity.this.getApplicationContext());
                OplusInCallDialogActivity oplusInCallDialogActivity = OplusInCallDialogActivity.this;
                oplusInCallDialogActivity.f19060a = true;
                oplusInCallDialogActivity.l0();
                return;
            }
            n.d(OplusInCallDialogActivity.this.getApplicationContext(), 3);
            OplusInCallDialogActivity oplusInCallDialogActivity2 = OplusInCallDialogActivity.this;
            oplusInCallDialogActivity2.f19060a = true;
            oplusInCallDialogActivity2.l0();
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            Log.d("OplusInCallDialogActivity", "mInterceptDialog OnClick Negative");
            D2.f.d(OplusInCallDialogActivity.this.getApplicationContext());
            OplusInCallDialogActivity.this.l0();
        }
    }

    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnKeyListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            OplusInCallDialogActivity.this.l0();
        }
    }

    /* loaded from: classes.dex */
    public class g implements DialogInterface.OnClickListener {
        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            HashMap hashMap = new HashMap();
            hashMap.put("event", 1);
            OplusPhoneUserActionStatistics.onCommon(OplusInCallDialogActivity.this, OplusPhoneUserActionStatistics.TAG_AUTO_RECORD, OplusPhoneUserActionStatistics.EVENT_RECORD_PROMPT_DIALOG_CLICK, hashMap);
            i2.c.g(OplusInCallDialogActivity.this);
            OplusInCallDialogActivity.this.l0();
        }
    }

    /* loaded from: classes.dex */
    public class h implements DialogInterface.OnClickListener {
        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            HashMap hashMap = new HashMap();
            hashMap.put("event", 0);
            OplusPhoneUserActionStatistics.onCommon(OplusInCallDialogActivity.this, OplusPhoneUserActionStatistics.TAG_AUTO_RECORD, OplusPhoneUserActionStatistics.EVENT_RECORD_PROMPT_DIALOG_CLICK, hashMap);
            OplusInCallDialogActivity.this.l0();
        }
    }

    /* loaded from: classes.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d("OplusInCallDialogActivity", "run to finish activity");
            if (!OplusInCallDialogActivity.this.isFinishing()) {
                OplusInCallDialogActivity.this.finish();
            }
        }
    }

    private void g0() {
        Log.d("OplusInCallDialogActivity", "delayToFinishActivity");
        this.f19062c.postDelayed(this.f19063d, 300L);
    }

    private void k0(int i10) {
        try {
            Log.d("OplusInCallDialogActivity", "dismissDialogSafely, id = " + i10);
            dismissDialog(i10);
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Log.d("OplusInCallDialogActivity", "finish");
        D2.f.O(null);
        super.finish();
    }

    public void l0() {
        Log.d("OplusInCallDialogActivity", "oplusFinishActivity");
        k0(this.f19061b);
        this.f19062c.postDelayed(this.f19063d, 300L);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        Log.d("OplusInCallDialogActivity", "onCancel");
        g0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("dialog_id", -1);
        if (intExtra != -1) {
            showDialog(intExtra);
        }
        if (intExtra == 1) {
            D2.f.O(this);
            D2.f.G(getApplicationContext());
        }
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10) {
        androidx.appcompat.app.b create;
        if (i10 != 1) {
            if (i10 != 2) {
                create = null;
            } else {
                create = new COUIAlertDialogBuilder(this).setTitle((CharSequence) getString(R.string.oplus_auto_record_tips)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) new h()).setPositiveButton(R.string.oplus_set, (DialogInterface.OnClickListener) new g()).setOnDismissListener(new f()).setOnKeyListener(new e()).create();
            }
        } else {
            create = new COUIAlertDialogBuilder(this).setTitle((CharSequence) getString(R.string.oplus_intercept_tips)).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) new d()).setPositiveButton(R.string.oplus_set, (DialogInterface.OnClickListener) new c()).setOnDismissListener(new b()).setOnKeyListener(new a()).create();
        }
        if (create == null) {
            return null;
        }
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        A2.d.e(attributes);
        window.setAttributes(attributes);
        return create;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Log.d("OplusInCallDialogActivity", "onDismiss");
        g0();
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i10, Dialog dialog) {
        super.onPrepareDialog(i10, dialog);
        this.f19061b = i10;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
    }
}
