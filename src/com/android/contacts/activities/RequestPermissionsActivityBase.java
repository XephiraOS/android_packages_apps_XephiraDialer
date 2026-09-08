package com.android.contacts.activities;

import C7.e;
import U0.k;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Trace;
import android.view.KeyEvent;
import androidx.preference.j;
import com.android.contacts.activities.RequestPermissionsActivityBase;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.NumberIdentifyUtils;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.android.contacts.framework.baseui.util.l;
import com.android.contacts.framework.baseui.util.s;
import com.android.contacts.framework.baseui.util.u;
import com.android.contacts.util.w;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.statement.COUIUserStatementDialog;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.activities.FunctionsActivity;
import com.customize.contacts.util.h0;
import com.oplus.dialer.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import n1.AbstractC1362a;

/* loaded from: classes.dex */
public abstract class RequestPermissionsActivityBase extends BasicActivity {

    /* renamed from: A, reason: collision with root package name */
    public Bundle f13646A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f13647B;

    /* renamed from: C, reason: collision with root package name */
    public final N7.a f13648C = N7.a.a();

    /* renamed from: D, reason: collision with root package name */
    public boolean f13649D = true;

    /* renamed from: o, reason: collision with root package name */
    public Intent f13650o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13651p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13652q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f13653r;

    /* renamed from: x, reason: collision with root package name */
    public androidx.appcompat.app.b f13654x;

    /* renamed from: y, reason: collision with root package name */
    public COUIBottomSheetDialog f13655y;

    /* renamed from: z, reason: collision with root package name */
    public androidx.appcompat.app.b f13656z;

    /* loaded from: classes.dex */
    public class a implements COUIUserStatementDialog.OnButtonClickListener {
        public a() {
        }

        @Override // com.coui.appcompat.statement.COUIUserStatementDialog.OnButtonClickListener
        public void onBottomButtonClick() {
            RequestPermissionsActivityBase.this.I1(true, true);
        }

        @Override // com.coui.appcompat.statement.COUIUserStatementDialog.OnButtonClickListener
        public void onExitButtonClick() {
            if (RequestPermissionsActivityBase.this.f13655y != null) {
                RequestPermissionsActivityBase.this.f13655y.dismiss();
            }
            StatementUtils.e(RequestPermissionsActivityBase.this, false);
            RequestPermissionsActivityBase.this.finish();
        }
    }

    /* loaded from: classes.dex */
    public static class b extends AsyncTask<Void, Void, StatementUtils.DialogType> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<RequestPermissionsActivityBase> f13658a;

        public b(RequestPermissionsActivityBase requestPermissionsActivityBase) {
            this.f13658a = new WeakReference<>(requestPermissionsActivityBase);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StatementUtils.DialogType doInBackground(Void... voidArr) {
            Context b10 = b();
            if (b10 != null) {
                return StatementUtils.j(b10, true);
            }
            return null;
        }

        public final Context b() {
            RequestPermissionsActivityBase requestPermissionsActivityBase = this.f13658a.get();
            if (requestPermissionsActivityBase != null) {
                return requestPermissionsActivityBase.getApplicationContext();
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(StatementUtils.DialogType dialogType) {
            RequestPermissionsActivityBase requestPermissionsActivityBase = this.f13658a.get();
            if (dialogType != null && requestPermissionsActivityBase != null && !requestPermissionsActivityBase.isFinishing() && !requestPermissionsActivityBase.isDestroyed()) {
                if (dialogType != StatementUtils.DialogType.NONE) {
                    requestPermissionsActivityBase.i2(dialogType);
                } else if (requestPermissionsActivityBase.f13649D) {
                    requestPermissionsActivityBase.g2();
                } else if (!w.l(requestPermissionsActivityBase, requestPermissionsActivityBase.N1())) {
                    w.C(requestPermissionsActivityBase, false, null, null, requestPermissionsActivityBase.N1());
                } else {
                    requestPermissionsActivityBase.f2();
                }
                requestPermissionsActivityBase.f13649D = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends AsyncTask<Void, Void, StatementUtils.DialogType> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<RequestPermissionsActivityBase> f13659a;

        public c(RequestPermissionsActivityBase requestPermissionsActivityBase) {
            this.f13659a = new WeakReference<>(requestPermissionsActivityBase);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StatementUtils.DialogType doInBackground(Void... voidArr) {
            Context b10 = b();
            if (b10 != null) {
                return StatementUtils.j(b10, true);
            }
            return null;
        }

        public final Context b() {
            RequestPermissionsActivityBase requestPermissionsActivityBase = this.f13659a.get();
            if (requestPermissionsActivityBase != null) {
                return requestPermissionsActivityBase.getApplicationContext();
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(StatementUtils.DialogType dialogType) {
            RequestPermissionsActivityBase requestPermissionsActivityBase = this.f13659a.get();
            if (dialogType != null && requestPermissionsActivityBase != null && !requestPermissionsActivityBase.isFinishing() && !requestPermissionsActivityBase.isDestroyed()) {
                if (dialogType != StatementUtils.DialogType.NONE) {
                    requestPermissionsActivityBase.i2(dialogType);
                } else {
                    requestPermissionsActivityBase.K1();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends AsyncTask<Void, Void, StatementUtils.DialogType> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<RequestPermissionsActivityBase> f13660a;

        public d(RequestPermissionsActivityBase requestPermissionsActivityBase) {
            this.f13660a = new WeakReference<>(requestPermissionsActivityBase);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StatementUtils.DialogType doInBackground(Void... voidArr) {
            Context b10 = b();
            if (b10 != null) {
                return RequestPermissionsActivityBase.M1(b10, true);
            }
            return null;
        }

        public final Context b() {
            RequestPermissionsActivityBase requestPermissionsActivityBase = this.f13660a.get();
            if (requestPermissionsActivityBase != null) {
                return requestPermissionsActivityBase.getApplicationContext();
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(StatementUtils.DialogType dialogType) {
            RequestPermissionsActivityBase requestPermissionsActivityBase = this.f13660a.get();
            if (dialogType != null && requestPermissionsActivityBase != null && !requestPermissionsActivityBase.isFinishing() && !requestPermissionsActivityBase.isDestroyed()) {
                if (dialogType != StatementUtils.DialogType.NONE) {
                    requestPermissionsActivityBase.k2(dialogType);
                } else {
                    requestPermissionsActivityBase.o2();
                    requestPermissionsActivityBase.g2();
                }
            }
        }
    }

    public static boolean G1(Activity activity) {
        if (!(activity instanceof ContactsTabActivity) && !(activity instanceof FunctionsActivity)) {
            return false;
        }
        return true;
    }

    public static boolean L1(Context context) {
        if (context instanceof ContactsTabActivity) {
            if (FeatureOption.o()) {
                return d2(context, true);
            }
            return StatementUtils.r(context, true);
        }
        return false;
    }

    public static StatementUtils.DialogType M1(Context context, boolean z10) {
        SharedPreferences b10 = j.b(context);
        if (B3.a.u() && b10.getInt("identify_unfamiliar_number_recognition_dialog", 1) == 1 && s.h(context) && !NumberIdentifyUtils.e(context)) {
            return StatementUtils.DialogType.NORMAL;
        }
        if (z10) {
            if (StatementUtils.q(context) && NumberIdentifyUtils.e(context)) {
                return StatementUtils.DialogType.UPDATE;
            }
            return StatementUtils.DialogType.NONE;
        }
        return StatementUtils.DialogType.NONE;
    }

    public static boolean d2(Context context, boolean z10) {
        if (M1(context, z10) != StatementUtils.DialogType.NONE) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r2.getInt("contacts_permission_recognition_dialog", 1) == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean e2(android.content.Context r2) {
        /*
            android.content.SharedPreferences r2 = androidx.preference.j.b(r2)
            boolean r0 = com.customize.contacts.FeatureOption.i()
            if (r0 == 0) goto L14
            java.lang.String r0 = "contacts_permission_recognition_dialog"
            r1 = 1
            int r2 = r2.getInt(r0, r1)
            if (r2 != r1) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = "needShowUserNotice = "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = "RequestPermissionsActivityBase"
            H7.b.e(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.activities.RequestPermissionsActivityBase.e2(android.content.Context):boolean");
    }

    public static boolean h2(Activity activity, String[] strArr) {
        Trace.beginSection("requestPermissions");
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (!w.k(activity, str)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() == 0) {
                H7.b.c("RequestPermissionsActivityBase", "Request permission activity was called even though all permissions are satisfied.");
                Trace.endSection();
                return true;
            }
            H7.b.e("RequestPermissionsActivityBase", "request  unsatisfiedPermissions : " + arrayList);
            androidx.core.app.a.q(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 1);
            Trace.endSection();
            return false;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public static boolean m2(Activity activity, String[] strArr, Class<?> cls) {
        return n2(activity, strArr, false, cls);
    }

    public static boolean n2(Activity activity, String[] strArr, boolean z10, Class<?> cls) {
        if (w.l(activity, strArr) && ((!e2(activity) || !G1(activity)) && !L1(activity))) {
            AbstractC1362a.h(activity);
            return false;
        }
        Intent intent = new Intent(activity, cls);
        Intent intent2 = activity.getIntent();
        e.m(intent2, "started_permissions_activity", true);
        e.n(intent, "previous_intent", intent2);
        e.m(intent, "is_caller_self", z10);
        if (G1(activity)) {
            e.m(intent, "need_show_permissions_recognition_dialog", true);
        }
        if (activity instanceof ContactsTabActivity) {
            e.m(intent, "need_show_number_recognition_dialog", true);
        }
        R7.b.c(activity, intent);
        e.b(activity);
        return true;
    }

    public final void H1(boolean z10) {
        if (z10) {
            StatementUtils.d(this, true);
        }
        this.f13656z.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: p0.l
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RequestPermissionsActivityBase.this.R1(dialogInterface);
            }
        });
        this.f13656z.dismiss();
    }

    public void I1(boolean z10, boolean z11) {
        if (z10) {
            StatementUtils.e(this, true);
        }
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f13655y;
        if (cOUIBottomSheetDialog == null) {
            return;
        }
        cOUIBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: p0.p
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RequestPermissionsActivityBase.this.S1(dialogInterface);
            }
        });
        if (z11) {
            this.f13655y.dismiss();
        } else {
            this.f13655y.dismiss(false);
        }
    }

    public final void J1(boolean z10) {
        if (z10) {
            StatementUtils.d(getApplicationContext(), true);
        }
        this.f13654x.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: p0.r
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RequestPermissionsActivityBase.this.T1(dialogInterface);
            }
        });
        this.f13654x.dismiss();
    }

    public final void K1() {
        if (g2()) {
            Intent intent = this.f13650o;
            if (intent != null) {
                intent.setFlags(65536);
                if (this.f13651p) {
                    startActivityForResult(this.f13650o, 0);
                } else {
                    startActivity(this.f13650o);
                }
            }
            finish();
        }
    }

    public abstract String[] N1();

    public String[] O1() {
        return N1();
    }

    public boolean P1(String[] strArr, int[] iArr) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (iArr[i10] != 0 && Q1(strArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public final boolean Q1(String str) {
        return Arrays.asList(N1()).contains(str);
    }

    public final /* synthetic */ void R1(DialogInterface dialogInterface) {
        K1();
        this.f13656z = null;
    }

    public final /* synthetic */ void S1(DialogInterface dialogInterface) {
        new c(this).executeOnExecutor(this.f13648C, new Void[0]);
        this.f13655y = null;
    }

    public final /* synthetic */ void T1(DialogInterface dialogInterface) {
        K1();
        this.f13654x = null;
    }

    public final /* synthetic */ void U1(StatementUtils.DialogType dialogType, DialogInterface dialogInterface, int i10) {
        StatementUtils.d(this, false);
        this.f13656z.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: p0.o
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface2) {
                RequestPermissionsActivityBase.this.W1(dialogInterface2);
            }
        });
        this.f13656z.dismiss();
        if (dialogType == StatementUtils.DialogType.UPDATE) {
            h0.a(false);
        }
    }

    public final /* synthetic */ void V1(StatementUtils.DialogType dialogType, DialogInterface dialogInterface, int i10) {
        H1(true);
        if (dialogType == StatementUtils.DialogType.UPDATE) {
            h0.a(true);
        }
    }

    public final /* synthetic */ void W1(DialogInterface dialogInterface) {
        K1();
        this.f13656z = null;
    }

    public final /* synthetic */ void X1(StatementUtils.DialogType dialogType, DialogInterface dialogInterface, int i10) {
        J1(true);
        if (dialogType == StatementUtils.DialogType.UPDATE) {
            h0.a(true);
        }
    }

    public final /* synthetic */ void Y1(DialogInterface dialogInterface) {
        K1();
        this.f13654x = null;
    }

    public final /* synthetic */ void Z1(StatementUtils.DialogType dialogType, DialogInterface dialogInterface, int i10) {
        j.b(getApplicationContext()).edit().putInt("identify_unfamiliar_number_recognition_dialog", 0).apply();
        NumberIdentifyUtils.k(getApplicationContext(), 0);
        this.f13654x.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: p0.n
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface2) {
                RequestPermissionsActivityBase.this.Y1(dialogInterface2);
            }
        });
        this.f13654x.dismiss();
        if (dialogType == StatementUtils.DialogType.UPDATE) {
            h0.a(false);
        }
    }

    public final /* synthetic */ boolean a2(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            androidx.appcompat.app.b bVar = this.f13654x;
            if (bVar != null) {
                bVar.dismiss();
                this.f13654x = null;
            }
            finish();
            return false;
        }
        return false;
    }

    public final /* synthetic */ void b2(DialogInterface dialogInterface) {
        androidx.appcompat.app.b bVar = this.f13654x;
        if (bVar != null) {
            bVar.dismiss();
            this.f13654x = null;
        }
    }

    public final /* synthetic */ void c2(DialogInterface dialogInterface) {
        K1();
    }

    public void f2() {
        Intent intent = this.f13650o;
        if (intent != null) {
            intent.setFlags(65536);
            if (this.f13651p) {
                startActivityForResult(this.f13650o, 0);
            } else {
                startActivity(this.f13650o);
            }
        }
        finish();
        overridePendingTransition(0, 0);
        X.a.b(this).d(new Intent("broadcastPermissionsGranted"));
    }

    public boolean g2() {
        return h2(this, O1());
    }

    public final void i2(final StatementUtils.DialogType dialogType) {
        androidx.appcompat.app.b bVar = this.f13656z;
        if (bVar != null && bVar.isShowing()) {
            this.f13656z.dismiss();
            this.f13656z = null;
        }
        this.f13656z = k.g(this, false, null, new DialogInterface.OnClickListener() { // from class: p0.x
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                RequestPermissionsActivityBase.this.V1(dialogType, dialogInterface, i10);
            }
        }, new DialogInterface.OnClickListener() { // from class: p0.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                RequestPermissionsActivityBase.this.U1(dialogType, dialogInterface, i10);
            }
        }, dialogType);
        H7.b.e("RequestPermissionsActivityBase", "mDomesticNumberRecognitionDialog.show() ---------");
        this.f13656z.show();
    }

    public final void j2() {
        if (!isDestroyed() && !isFinishing()) {
            COUIBottomSheetDialog cOUIBottomSheetDialog = this.f13655y;
            if (cOUIBottomSheetDialog != null && cOUIBottomSheetDialog.isShowing()) {
                this.f13655y.dismiss();
                this.f13655y = null;
            }
            this.f13655y = k.m(this, new Runnable() { // from class: p0.q
                @Override // java.lang.Runnable
                public final void run() {
                    RequestPermissionsActivityBase.this.finish();
                }
            }, new a());
            H7.b.e("RequestPermissionsActivityBase", "mDomesticUserNoticeDialog.show() ---------");
            this.f13655y.show();
        }
    }

    public final void k2(final StatementUtils.DialogType dialogType) {
        androidx.appcompat.app.b bVar = this.f13654x;
        if (bVar != null && bVar.isShowing()) {
            return;
        }
        androidx.appcompat.app.b p10 = k.p(this, StatementUtils.i(this, dialogType), StatementUtils.g(this, dialogType), u.c(this, false, false), R.string.agree_and_use, R.string.disagree, new DialogInterface.OnClickListener() { // from class: p0.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                RequestPermissionsActivityBase.this.X1(dialogType, dialogInterface, i10);
            }
        }, new DialogInterface.OnClickListener() { // from class: p0.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                RequestPermissionsActivityBase.this.Z1(dialogType, dialogInterface, i10);
            }
        });
        this.f13654x = p10;
        p10.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: p0.u
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                boolean a22;
                a22 = RequestPermissionsActivityBase.this.a2(dialogInterface, i10, keyEvent);
                return a22;
            }
        });
        this.f13654x.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: p0.v
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RequestPermissionsActivityBase.this.b2(dialogInterface);
            }
        });
        this.f13654x.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: p0.w
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                RequestPermissionsActivityBase.this.c2(dialogInterface);
            }
        });
        if (!this.f13654x.isShowing()) {
            H7.b.e("RequestPermissionsActivityBase", "mExportRecognitionDialog.show() ---------");
            this.f13654x.show();
        }
    }

    public final void l2() {
        if (this.f13652q) {
            SharedPreferences b10 = j.b(this);
            if (FeatureOption.i()) {
                if (b10.getInt("contacts_permission_recognition_dialog", 1) == 1) {
                    this.f13649D = false;
                    j2();
                    return;
                } else {
                    new b(this).executeOnExecutor(this.f13648C, new Void[0]);
                    return;
                }
            }
            this.f13649D = false;
            if (this.f13653r) {
                new d(this).executeOnExecutor(this.f13648C, new Void[0]);
                return;
            } else {
                if (this.f13646A == null) {
                    g2();
                    return;
                }
                return;
            }
        }
        if (this.f13646A == null) {
            this.f13649D = false;
            g2();
        }
    }

    public final void o2() {
        androidx.appcompat.app.b bVar = this.f13654x;
        if (bVar != null && bVar.isShowing()) {
            this.f13654x.dismiss();
        }
        this.f13654x = null;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.request_permissions_empty_layout);
        this.f13646A = bundle;
        Intent intent = getIntent();
        Parcelable j10 = e.j(intent, "previous_intent");
        if (j10 instanceof Intent) {
            this.f13650o = (Intent) j10;
        } else {
            H7.b.c("RequestPermissionsActivityBase", "onCreate get intent extras error");
        }
        this.f13651p = e.c(intent, "is_caller_self", false);
        this.f13652q = e.c(intent, "need_show_permissions_recognition_dialog", false);
        this.f13653r = e.c(intent, "need_show_number_recognition_dialog", false);
        if (bundle != null) {
            this.f13649D = bundle.getBoolean("need_request_permissions");
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f13648C.shutdown();
        super.onDestroy();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Parcelable j10 = e.j(intent, "previous_intent");
        if (j10 instanceof Intent) {
            this.f13650o = (Intent) j10;
            if (H7.a.b()) {
                H7.b.b("RequestPermissionsActivityBase", "pull requestPermissons page again, and this time the componentName is " + this.f13650o.getComponent().getClassName());
                return;
            }
            return;
        }
        H7.b.c("RequestPermissionsActivityBase", "onNewIntent: get intent extras error");
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        H7.b.e("RequestPermissionsActivityBase", "onRestart");
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f13655y;
        if (cOUIBottomSheetDialog != null && cOUIBottomSheetDialog.isShowing()) {
            if (!e2(this)) {
                I1(false, false);
                return;
            }
            return;
        }
        androidx.appcompat.app.b bVar = this.f13656z;
        if (bVar != null && bVar.isShowing()) {
            if (!StatementUtils.r(this, true)) {
                H1(false);
            }
        } else {
            androidx.appcompat.app.b bVar2 = this.f13654x;
            if (bVar2 != null && bVar2.isShowing() && !d2(this, true)) {
                J1(false);
            }
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        H7.b.e("RequestPermissionsActivityBase", "onResume");
        if (!l.e(this)) {
            if (!this.f13647B) {
                l2();
                this.f13647B = true;
                return;
            }
            return;
        }
        this.f13649D = false;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("need_request_permissions", this.f13649D);
        super.onSaveInstanceState(bundle);
    }
}
