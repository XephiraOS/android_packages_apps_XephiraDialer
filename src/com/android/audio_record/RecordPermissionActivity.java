package com.android.audio_record;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.b;
import com.android.audio_record.RecordPermissionActivity;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import n0.C1360l;
import n0.n;
import n0.r;

/* compiled from: RecordPermissionActivity.kt */
/* loaded from: classes.dex */
public final class RecordPermissionActivity extends AppCompatActivity {

    /* renamed from: b, reason: collision with root package name */
    public static final a f13000b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public b f13001a;

    /* compiled from: RecordPermissionActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final void t0(RecordPermissionActivity this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        this$0.x0();
        this$0.finish();
    }

    public static final void u0(RecordPermissionActivity this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        this$0.finish();
    }

    public static final void v0(RecordPermissionActivity this$0, DialogInterface dialogInterface) {
        i.f(this$0, "this$0");
        this$0.finish();
    }

    private final void x0() {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + getPackageName()));
        OplusPhoneUtils.startSafeActivity(this, intent);
    }

    @Override // android.app.Activity
    public void finish() {
        b bVar = this.f13001a;
        if (bVar != null) {
            bVar.dismiss();
        }
        super.finish();
    }

    public final void m0() {
        Log.d("RecordPermissionActivity", "checkReadAudioRecordPermission");
        Q5.b a10 = Q5.a.a();
        if (a10 != null) {
            a10.b();
        }
        finish();
    }

    public final void n0() {
        r.a(this);
    }

    public final void o0() {
        Log.d("RecordPermissionActivity", "checkStoragePermission");
        Q5.b a10 = Q5.a.a();
        if (a10 != null) {
            a10.b();
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setShowWhenLocked(true);
        Log.d("RecordPermissionActivity", "onCreate");
        supportRequestWindowFeature(1);
        n0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        i.f(permissions, "permissions");
        i.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i10, permissions, grantResults);
        r.b(this, i10, grantResults);
    }

    public final void q0() {
        Log.d("RecordPermissionActivity", "requestReadAudioPermissionError");
        finish();
        int i10 = C1360l.f35544a;
        overridePendingTransition(i10, i10);
    }

    public final void r0() {
        finish();
        int i10 = C1360l.f35544a;
        overridePendingTransition(i10, i10);
    }

    public final void s0() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) getString(n.f35559n)).append((CharSequence) "\n").append((CharSequence) "\n").append((CharSequence) getString(n.f35556k));
        String string = getString(n.f35555j);
        i.e(string, "getString(R.string.permission_open)");
        b bVar = this.f13001a;
        if (bVar == null) {
            bVar = new COUIAlertDialogBuilder(this).setTitle((CharSequence) string).setMessage((CharSequence) spannableStringBuilder).setPositiveButton((CharSequence) getString(n.f35547b), new DialogInterface.OnClickListener() { // from class: n0.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    RecordPermissionActivity.t0(RecordPermissionActivity.this, dialogInterface, i10);
                }
            }).setNegativeButton((CharSequence) getString(n.f35548c), new DialogInterface.OnClickListener() { // from class: n0.p
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    RecordPermissionActivity.u0(RecordPermissionActivity.this, dialogInterface, i10);
                }
            }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: n0.q
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    RecordPermissionActivity.v0(RecordPermissionActivity.this, dialogInterface);
                }
            }).create();
        }
        this.f13001a = bVar;
        if (bVar != null) {
            bVar.show();
        }
    }

    public final void y0() {
        Log.d("RecordPermissionActivity", "startReadAudioPermissionSettings");
        s0();
    }

    public final void z0() {
        Log.d("RecordPermissionActivity", "startStoragePermissionSettings");
        s0();
    }
}
