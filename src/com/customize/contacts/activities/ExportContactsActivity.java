package com.customize.contacts.activities;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.provider.MediaStore;
import android.text.BidiFormatter;
import android.text.Editable;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.contacts.activities.RequestImportVCardPermissionsActivity;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.list.AccountFilterActivity;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.list.c;
import com.android.contacts.model.Account;
import com.android.contacts.vcard.VCardService;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.progressbar.COUIHorizontalProgressBar;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class ExportContactsActivity extends BasicActivity implements ServiceConnection, Y0.a {

    /* renamed from: X, reason: collision with root package name */
    public static final BidiFormatter f20327X = BidiFormatter.getInstance();

    /* renamed from: A, reason: collision with root package name */
    public String f20328A;

    /* renamed from: B, reason: collision with root package name */
    public Account f20329B;

    /* renamed from: C, reason: collision with root package name */
    public List<ContactListFilter> f20330C;

    /* renamed from: D, reason: collision with root package name */
    public Dialog f20331D;

    /* renamed from: E, reason: collision with root package name */
    public androidx.appcompat.app.b f20332E;

    /* renamed from: F, reason: collision with root package name */
    public COUIHorizontalProgressBar f20333F;

    /* renamed from: G, reason: collision with root package name */
    public VCardService f20334G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f20335H;

    /* renamed from: M, reason: collision with root package name */
    public ThreadPoolExecutor f20340M;

    /* renamed from: N, reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f20341N;

    /* renamed from: U, reason: collision with root package name */
    public U0.b f20348U;

    /* renamed from: V, reason: collision with root package name */
    public U0.h f20349V;

    /* renamed from: p, reason: collision with root package name */
    public String f20352p;

    /* renamed from: q, reason: collision with root package name */
    public String f20353q;

    /* renamed from: r, reason: collision with root package name */
    public String f20354r;

    /* renamed from: x, reason: collision with root package name */
    public String f20355x;

    /* renamed from: y, reason: collision with root package name */
    public String f20356y;

    /* renamed from: z, reason: collision with root package name */
    public String f20357z;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20351o = false;

    /* renamed from: I, reason: collision with root package name */
    public int f20336I = 0;

    /* renamed from: J, reason: collision with root package name */
    public int f20337J = 0;

    /* renamed from: K, reason: collision with root package name */
    public String f20338K = null;

    /* renamed from: L, reason: collision with root package name */
    public boolean f20339L = false;

    /* renamed from: O, reason: collision with root package name */
    public g f20342O = null;

    /* renamed from: P, reason: collision with root package name */
    public i f20343P = null;

    /* renamed from: Q, reason: collision with root package name */
    public j f20344Q = null;

    /* renamed from: R, reason: collision with root package name */
    public f f20345R = null;

    /* renamed from: S, reason: collision with root package name */
    public e f20346S = new e(this);

    /* renamed from: T, reason: collision with root package name */
    public h f20347T = new h(this);

    /* renamed from: W, reason: collision with root package name */
    public final BroadcastReceiver f20350W = new c();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<ContactListFilter> C12 = AccountFilterActivity.C1(ExportContactsActivity.this, ContactListFilter.h(-2), false);
            int size = C12.size();
            for (int i10 = size - 1; i10 >= 0; i10--) {
                if (H7.a.b()) {
                    H7.b.b("ExportContactsActivity", "the size is " + size + ", the type is " + C12.get(i10).f16738b);
                }
                if (C12.get(i10).f16738b == -3) {
                    C12.remove(i10);
                }
            }
            if (C12.size() == 2) {
                C12.remove(0);
            }
            ExportContactsActivity.this.f20330C = C12;
            if (H7.a.b()) {
                H7.b.b("ExportContactsActivity", "size = " + C12.size());
            }
            if (ExportContactsActivity.this.f20330C == null || ExportContactsActivity.this.f20330C.size() != 1) {
                ExportContactsActivity.this.l2(2);
            } else {
                ExportContactsActivity.this.L1(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ExportContactsActivity exportContactsActivity = ExportContactsActivity.this;
            int i10 = M3.c.i(exportContactsActivity, exportContactsActivity.f20329B);
            Message message = new Message();
            message.what = 12;
            message.arg1 = i10;
            ExportContactsActivity.this.f20346S.sendMessage(message);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20360a = false;

        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.MEDIA_PRE_SHARED") && !this.f20360a) {
                this.f20360a = true;
                ExportContactsActivity.this.M1();
                ExportContactsActivity.this.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ExportContactsActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<ExportContactsActivity> f20363a;

        public e(ExportContactsActivity exportContactsActivity) {
            this.f20363a = new WeakReference<>(exportContactsActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                ExportContactsActivity exportContactsActivity = this.f20363a.get();
                if (exportContactsActivity == null) {
                    return;
                }
                int i10 = message.what;
                if (i10 == 2) {
                    exportContactsActivity.o2();
                } else if (i10 != 8) {
                    if (i10 != 12) {
                        super.handleMessage(message);
                    } else if (message.arg1 != 0) {
                        exportContactsActivity.r2();
                    } else {
                        exportContactsActivity.showDialog(8);
                    }
                } else {
                    exportContactsActivity.showDialog(8);
                }
            } catch (Exception e10) {
                H7.b.b("ExportContactsActivity", "handleMessage: " + e10);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20364a;

        /* renamed from: b, reason: collision with root package name */
        public ExportContactsActivity f20365b;

        public f(ExportContactsActivity exportContactsActivity, boolean z10) {
            this.f20364a = z10;
            this.f20365b = exportContactsActivity;
        }

        public void a() {
            ExportContactsActivity exportContactsActivity = this.f20365b;
            if (exportContactsActivity == null) {
                return;
            }
            if (this.f20364a) {
                exportContactsActivity.R1();
            }
            if (!exportContactsActivity.isFinishing()) {
                exportContactsActivity.finish();
            }
            this.f20365b = null;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ExportContactsActivity exportContactsActivity = this.f20365b;
            if (exportContactsActivity == null) {
                return;
            }
            if (this.f20364a) {
                exportContactsActivity.R1();
            }
            if (!exportContactsActivity.isFinishing()) {
                exportContactsActivity.finish();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            ExportContactsActivity exportContactsActivity = this.f20365b;
            if (exportContactsActivity == null) {
                return;
            }
            if (this.f20364a) {
                exportContactsActivity.R1();
            }
            if (!exportContactsActivity.isFinishing()) {
                exportContactsActivity.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public ExportContactsActivity f20366a;

        public g(ExportContactsActivity exportContactsActivity) {
            this.f20366a = exportContactsActivity;
        }

        public void a() {
            this.f20366a = null;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ExportContactsActivity exportContactsActivity = this.f20366a;
            if (exportContactsActivity != null) {
                exportContactsActivity.M1();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            int i11;
            int i12;
            ExportContactsActivity exportContactsActivity = this.f20366a;
            if (exportContactsActivity == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            if (exportContactsActivity.f20333F != null) {
                i11 = exportContactsActivity.f20333F.getProgress();
            } else {
                i11 = 0;
            }
            if (exportContactsActivity.f20337J > 0) {
                i12 = (i11 * 100) / exportContactsActivity.f20337J;
            } else {
                i12 = 0;
            }
            hashMap.put("current_progress", Integer.valueOf(i12));
            com.android.contacts.framework.baseui.util.A.a(exportContactsActivity.getBaseContext(), 2000314, 200030120, hashMap, false);
            onCancel(dialogInterface);
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends K3.a {

        /* renamed from: c, reason: collision with root package name */
        public WeakReference<ExportContactsActivity> f20367c;

        public h(ExportContactsActivity exportContactsActivity) {
            this.f20367c = new WeakReference<>(exportContactsActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ExportContactsActivity exportContactsActivity = this.f20367c.get();
            if (exportContactsActivity == null) {
                return;
            }
            int i10 = message.what;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        exportContactsActivity.U1(message, this.f1627a);
                        return;
                    }
                    if (i10 != 3) {
                        if (i10 == 4) {
                            exportContactsActivity.R1();
                            exportContactsActivity.finish();
                            return;
                        } else {
                            if (i10 == 9 && !this.f1627a) {
                                exportContactsActivity.B2(message.arg1);
                                return;
                            }
                            return;
                        }
                    }
                    if (!this.f1627a) {
                        exportContactsActivity.T1();
                        exportContactsActivity.q2(message.arg1);
                        return;
                    }
                    return;
                }
                if (!this.f1627a) {
                    exportContactsActivity.f20338K = (String) message.obj;
                    exportContactsActivity.C2(message.arg1);
                    return;
                }
                return;
            }
            if (!this.f1627a) {
                exportContactsActivity.s2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public ExportContactsActivity f20368a;

        public i(ExportContactsActivity exportContactsActivity) {
            this.f20368a = exportContactsActivity;
        }

        public void a() {
            ExportContactsActivity exportContactsActivity = this.f20368a;
            if (exportContactsActivity != null && !exportContactsActivity.isFinishing()) {
                exportContactsActivity.finish();
            }
            this.f20368a = null;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ExportContactsActivity exportContactsActivity = this.f20368a;
            if (exportContactsActivity != null && !exportContactsActivity.isFinishing()) {
                exportContactsActivity.finish();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            ExportContactsActivity exportContactsActivity = this.f20368a;
            if (exportContactsActivity != null && !exportContactsActivity.isFinishing()) {
                exportContactsActivity.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class j implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public ExportContactsActivity f20369a;

        public j(ExportContactsActivity exportContactsActivity) {
            this.f20369a = exportContactsActivity;
        }

        public void a() {
            this.f20369a = null;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ExportContactsActivity exportContactsActivity = this.f20369a;
            if (exportContactsActivity != null && !exportContactsActivity.isFinishing()) {
                exportContactsActivity.finish();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            ExportContactsActivity exportContactsActivity = this.f20369a;
            if (exportContactsActivity == null) {
                return;
            }
            if (-3 == i10) {
                exportContactsActivity.v2();
            } else if (-2 == i10) {
                exportContactsActivity.r2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1(int i10) {
        if (i10 >= 0 && i10 < this.f20330C.size()) {
            if (i10 == 0) {
                this.f20329B = M3.c.g(getBaseContext());
            } else {
                this.f20329B = new Account(this.f20330C.get(i10).f16740d, this.f20330C.get(i10).f16739c);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("account_type", this.f20329B.f16942b);
            com.android.contacts.framework.baseui.util.A.a(getBaseContext(), 2000314, 200030115, hashMap, false);
            this.f20340M.execute(new b());
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1() {
        androidx.appcompat.app.b bVar = this.f20332E;
        if (bVar != null && bVar.isShowing()) {
            this.f20332E.dismiss();
        }
        this.f20332E = null;
    }

    private void p2() {
        this.f20340M.execute(new a());
    }

    public final void A2() {
        int i10;
        int i11;
        try {
            androidx.appcompat.app.b bVar = this.f20332E;
            if (bVar != null && bVar.isShowing() && (i10 = this.f20336I) <= this.f20337J) {
                if (this.f20339L) {
                    i11 = R.string.caching_vcard_title_v2;
                } else {
                    i11 = R.string.oplus_export_contacts_v2;
                }
                this.f20332E.setTitle(getString(i11, Integer.valueOf(i10), Integer.valueOf(this.f20337J)));
            }
        } catch (Exception e10) {
            H7.b.c("ExportContactsActivity", "updateProcessDialog Exception e: " + e10);
        }
    }

    public final void B2(int i10) {
        COUIHorizontalProgressBar cOUIHorizontalProgressBar;
        this.f20337J = i10;
        f2(this.f20332E);
        if (this.f20332E != null && (cOUIHorizontalProgressBar = this.f20333F) != null) {
            cOUIHorizontalProgressBar.setMax(i10);
            A2();
        }
    }

    public final void C2(int i10) {
        COUIHorizontalProgressBar cOUIHorizontalProgressBar;
        this.f20336I = i10;
        if (this.f20332E != null && (cOUIHorizontalProgressBar = this.f20333F) != null) {
            cOUIHorizontalProgressBar.setProgress(i10);
            A2();
        }
    }

    public final void M1() {
        VCardService vCardService = this.f20334G;
        if (vCardService != null) {
            this.f20334G.i(new com.android.contacts.vcard.c(vCardService.g(), this.f20338K), null);
        }
        z2();
    }

    public final int N1(String str) {
        this.f20356y = str;
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (!h2(this.f20356y)) {
            return 2;
        }
        return 0;
    }

    public final void O1() {
        if (TextUtils.isEmpty(this.f20356y)) {
            u2(1);
            return;
        }
        if (h2(this.f20356y)) {
            if (g2(d2())) {
                showDialog(4);
                return;
            }
            File file = new File(this.f20357z);
            if (!file.isDirectory()) {
                file.mkdirs();
            }
            v2();
            return;
        }
        u2(2);
    }

    public final HeaderFooterRecyclerView P1(Context context, com.android.contacts.list.c cVar) {
        HeaderFooterRecyclerView headerFooterRecyclerView = new HeaderFooterRecyclerView(context);
        headerFooterRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        headerFooterRecyclerView.setPadding(0, 0, 0, context.getResources().getDimensionPixelOffset(R.dimen.DP_16));
        headerFooterRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        headerFooterRecyclerView.setAdapter(cVar);
        return headerFooterRecyclerView;
    }

    public final androidx.appcompat.app.b Q1(Context context, int i10, View view, DialogInterface.OnCancelListener onCancelListener) {
        U0.b bVar = new U0.b(context, 2132083075);
        this.f20348U = bVar;
        bVar.setTitle(i10).setView(view).setOnCancelListener(onCancelListener);
        androidx.appcompat.app.b show = this.f20348U.show();
        show.setCanceledOnTouchOutside(true);
        return show;
    }

    public final boolean R1() {
        if (TextUtils.isEmpty(this.f20357z)) {
            return true;
        }
        String d22 = d2();
        if (TextUtils.isEmpty(d22)) {
            return true;
        }
        File file = new File(d22);
        if (!file.exists()) {
            return true;
        }
        return file.delete();
    }

    public final void S1() {
        androidx.appcompat.app.b j10;
        U0.b bVar = this.f20348U;
        if (bVar != null && (j10 = bVar.j()) != null && j10.isShowing()) {
            j10.dismiss();
        }
    }

    public final void U1(Message message, boolean z10) {
        int i10;
        if (!z10) {
            T1();
        }
        setResult(-1, null);
        HashMap hashMap = new HashMap();
        hashMap.put(BreenoCallContract.SummaryColumns.COUNT, Integer.valueOf(message.arg1));
        com.android.contacts.framework.baseui.util.A.a(getBaseContext(), 2000314, 200030122, hashMap, false);
        if (this.f20339L) {
            m2(d2(), (Uri) message.obj);
        } else {
            if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                i10 = R.string.odialer_send_tips;
            } else {
                i10 = R.string.oplus_send_tips;
            }
            com.oplus.foundation.util.ui.c.e(this, getString(i10));
        }
        finish();
    }

    public Dialog V1(int i10, int i11) {
        this.f20345R = new f(this, false);
        return new COUIAlertDialogBuilder(this).setTitle(i10).setMessage(i11).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) this.f20345R).setOnCancelListener(this.f20345R).show();
    }

    public final String W1(String str, String str2, String str3, int i10, String str4) {
        boolean z10;
        String str5;
        HashSet hashSet = new HashSet();
        hashSet.add(str3);
        int i11 = 0;
        for (int i12 = i10; i12 > 0; i12 /= 10) {
            i11++;
        }
        if (String.format("%s%0" + i11 + "d%s", str, 1, str2).length() <= 8 && str3.length() <= 3) {
            String str6 = "Contacts" + new SimpleDateFormat("-yyyy-MM-dd").format(new Date());
            for (int i13 = 0; i13 <= i10; i13++) {
                Iterator it = hashSet.iterator();
                String str7 = null;
                while (true) {
                    if (it.hasNext()) {
                        String str8 = (String) it.next();
                        if (i13 == 0) {
                            str5 = "";
                        } else {
                            str5 = "(" + i13 + ")";
                        }
                        String format = String.format("%s%s", str6, str5);
                        if (new File(String.format("%s/%s.%s", str4, format, str8)).exists()) {
                            z10 = false;
                            str7 = format;
                            break;
                        }
                        str7 = format;
                    } else {
                        z10 = true;
                        break;
                    }
                }
                if (z10) {
                    return str7;
                }
            }
        }
        return null;
    }

    public final String X1(String str) {
        return com.customize.contacts.util.C.h(str, getApplicationContext());
    }

    public final Intent Y1() {
        Uri fromFile = Uri.fromFile(new File(d2()));
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("text/x-vcard");
        intent.putExtra("android.intent.extra.TITLE", f20327X.unicodeWrap(fromFile.getLastPathSegment(), TextDirectionHeuristics.LTR));
        return intent;
    }

    public final String Z1(String str) {
        return W1(getString(R.string.config_export_file_prefix), getString(R.string.config_export_file_suffix), getString(R.string.config_export_file_extension), getResources().getInteger(R.integer.config_export_file_max_index), str);
    }

    public final String a2() {
        return MediaStore.Files.getContentUri("external").buildUpon().appendPath("Backup").appendPath("").build().toString();
    }

    public Dialog b2() {
        this.f20345R = new f(this, true);
        return new COUIAlertDialogBuilder(this).setTitle(R.string.operation_error).setMessage((CharSequence) this.f20354r).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) this.f20345R).setOnCancelListener(this.f20345R).show();
    }

    public Dialog c2() {
        this.f20343P = new i(this);
        return new COUIAlertDialogBuilder(this).setTitle(R.string.oplus_title_export_phonebook).setMessage((CharSequence) this.f20353q).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) this.f20343P).setOnCancelListener(this.f20343P).show();
    }

    public final String d2() {
        if (TextUtils.isEmpty(this.f20357z)) {
            return this.f20355x + this.f20328A;
        }
        return this.f20357z + this.f20356y + this.f20328A;
    }

    public final Dialog e2() {
        String format = String.format(getString(R.string.file_overwrite_warnning), this.f20356y);
        this.f20344Q = new j(this);
        this.f20345R = new f(this, false);
        return new U0.b(this, 2132083073).setMessage((CharSequence) format).setNeutralButton(R.string.overwrite_description, (DialogInterface.OnClickListener) this.f20344Q).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) this.f20344Q).setOnCancelListener(this.f20345R).show();
    }

    public final void f2(androidx.appcompat.app.b bVar) {
        if (this.f20333F == null) {
            this.f20333F = (COUIHorizontalProgressBar) bVar.getWindow().findViewById(R.id.progress);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        C0636a.b(this);
    }

    @Override // Y0.a
    public void g() {
        Editable text;
        String str = null;
        com.android.contacts.framework.baseui.util.A.a(this, 2000314, 200030117, null, false);
        n2();
        COUIEditText j10 = this.f20349V.j();
        if (j10 != null && (text = j10.getText()) != null) {
            str = text.toString();
        }
        int N12 = N1(str);
        if (N12 != 0) {
            u2(N12);
        } else {
            O1();
        }
        this.f20349V.n(false);
        this.f20349V.g();
    }

    public final boolean g2(String str) {
        return new File(str).exists();
    }

    public final boolean h2(String str) {
        return !Pattern.compile("^\\..*|.*[\\\\/*:?<>|\"]+?.*|.*\\.+$").matcher(str).matches();
    }

    public final /* synthetic */ void i2(View view, int i10) {
        S1();
        L1(i10);
    }

    public final /* synthetic */ void j2(DialogInterface dialogInterface) {
        S1();
        finish();
    }

    public final void k2() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_PRE_SHARED");
        this.f20351o = true;
        registerReceiver(this.f20350W, intentFilter, R0.b.f3175i, null, 2);
    }

    public final void l2(int i10) {
        this.f20346S.removeMessages(i10);
        this.f20346S.sendEmptyMessage(i10);
    }

    public final void m2(String str, Uri uri) {
        sendBroadcast(E7.a.a(str), R0.b.f3175i);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/x-vcard");
        if (uri == null) {
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
        } else {
            intent.putExtra("android.intent.extra.STREAM", uri);
        }
        intent.putExtra("send_entrance", getPackageName());
        R7.b.c(this, Intent.createChooser(intent, getText(R.string.share_via)));
    }

    public final void n2() {
        this.f20328A = this.f20352p;
    }

    public final void o2() {
        int i10;
        HeaderFooterRecyclerView P12 = P1(this, new com.android.contacts.list.c(this, this.f20330C, null, new c.InterfaceC0172c() { // from class: com.customize.contacts.activities.O
            @Override // com.android.contacts.list.c.InterfaceC0172c
            public final void onItemClick(View view, int i11) {
                ExportContactsActivity.this.i2(view, i11);
            }
        }));
        DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.customize.contacts.activities.P
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ExportContactsActivity.this.j2(dialogInterface);
            }
        };
        if (this.f20339L) {
            i10 = R.string.send_from;
        } else {
            i10 = R.string.export_from;
        }
        androidx.appcompat.app.b Q12 = Q1(this, i10, P12, onCancelListener);
        if (!Q12.isShowing()) {
            Q12.show();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 100) {
            if (i11 == -1 && this.f20334G != null && intent != null && intent.getData() != null) {
                w2(intent.getData());
                return;
            }
            if (this.f20334G == null) {
                H7.b.b("ExportContactsActivity", "No vCard service.");
            } else {
                H7.b.b("ExportContactsActivity", "create document cancelled or no data returned");
            }
            finish();
        }
    }

    @Override // Y0.a
    public void onCancel() {
        com.android.contacts.framework.baseui.util.A.a(this, 2000314, 200030116, null, false);
        this.f20349V.g();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RequestImportVCardPermissionsActivity.q2(this, true);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f20339L = extras.getBoolean("for_share_vcard");
        }
        String string = getString(R.string.config_vcard_file_extension);
        this.f20352p = string;
        this.f20328A = string;
        this.f20357z = a2();
        this.f20349V = new U0.h();
        if (TextUtils.isEmpty(this.f20357z)) {
            q2(5);
            return;
        }
        String Z12 = Z1(this.f20357z);
        this.f20355x = Z12;
        this.f20356y = Z12;
        this.f20341N = new LinkedBlockingQueue<>();
        this.f20340M = new ThreadPoolExecutor(1, 2, 180L, TimeUnit.SECONDS, this.f20341N);
        Intent intent = new Intent(this, (Class<?>) VCardService.class);
        intent.putExtra("for_share_vcard", this.f20339L);
        startService(intent);
        bindService(intent, this, 1);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10) {
        if (i10 != 4) {
            if (i10 != 5) {
                if (i10 != 6) {
                    if (i10 != 8) {
                        if (i10 != 9) {
                            return super.onCreateDialog(i10);
                        }
                        return V1(R.string.oplus_title_export_phonebook, R.string.simcard_not_available);
                    }
                    return V1(R.string.oplus_title_export_phonebook, R.string.no_contacts_warnning);
                }
                return b2();
            }
            return c2();
        }
        return e2();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        h hVar = this.f20347T;
        if (hVar != null) {
            hVar.a();
        }
        T1();
        y2();
        VCardService vCardService = this.f20334G;
        if (vCardService != null) {
            vCardService.p(null);
        }
        Dialog dialog = this.f20331D;
        if (dialog != null && dialog.isShowing()) {
            this.f20331D.dismiss();
        }
        this.f20331D = null;
        g gVar = this.f20342O;
        if (gVar != null) {
            gVar.a();
            this.f20342O = null;
        }
        i iVar = this.f20343P;
        if (iVar != null) {
            iVar.a();
            this.f20343P = null;
        }
        j jVar = this.f20344Q;
        if (jVar != null) {
            jVar.a();
            this.f20344Q = null;
        }
        f fVar = this.f20345R;
        if (fVar != null) {
            fVar.a();
            this.f20345R = null;
        }
        ThreadPoolExecutor threadPoolExecutor = this.f20340M;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdownNow();
            this.f20340M = null;
        }
        this.f20349V.g();
        z2();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i10, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i10, dialog, bundle);
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f20335H = true;
        this.f20334G = ((VCardService.b) iBinder).a();
        k2();
        p2();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName componentName) {
        this.f20335H = false;
        this.f20334G = null;
        y2();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public final void q2(int i10) {
        this.f20354r = getString(R.string.error_unknown_occured);
        showDialog(6);
    }

    public final void r2() {
        if (this.f20339L) {
            n2();
            O1();
        } else {
            t2();
        }
    }

    public final void s2() {
        int i10;
        T1();
        this.f20342O = new g(this);
        if (this.f20339L) {
            i10 = R.string.caching_vcard_title_v2;
        } else {
            i10 = R.string.oplus_export_contacts_v2;
        }
        if (this.f20332E == null) {
            this.f20332E = U0.k.j(this, getString(i10, Integer.valueOf(this.f20336I), Integer.valueOf(this.f20337J)), this.f20342O);
        }
        androidx.appcompat.app.b bVar = this.f20332E;
        if (bVar != null) {
            bVar.setTitle(getString(i10, Integer.valueOf(this.f20336I), Integer.valueOf(this.f20337J)));
            this.f20332E.setOnDismissListener(new d());
            J3.e.b(this.f20332E);
            this.f20332E.show();
        }
    }

    public final void t2() {
        int i10;
        U0.h hVar = this.f20349V;
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            i10 = R.string.oplus_title_export_phonebook;
        } else {
            i10 = R.string.oplus_title_export_contacts;
        }
        this.f20349V.k(hVar.p(this, R.layout.bottom_dialog_layout_with_edit_text, this, getString(i10), getString(R.string.cancel), getString(R.string.notify_export), true), false, getString(R.string.filename_hint), false);
        this.f20349V.m(X1(this.f20356y));
    }

    public final void u2(int i10) {
        this.f20353q = getString(R.string.error_unknown_occured);
        if (i10 != 1) {
            if (i10 == 2) {
                this.f20353q = getString(R.string.filename_is_illigal);
            }
        } else {
            this.f20353q = getString(R.string.filename_is_empty);
        }
        showDialog(5);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        super.unbindService(serviceConnection);
    }

    public final void v2() {
        if (this.f20339L) {
            x2();
        } else {
            startActivityForResult(Y1(), 100);
        }
    }

    public final void w2(Uri uri) {
        com.android.contacts.vcard.f fVar = new com.android.contacts.vcard.f(uri, null, this.f20329B, this.f20339L);
        this.f20334G.p(this.f20347T);
        this.f20334G.j(fVar, new com.android.contacts.vcard.p(this));
        z2();
    }

    public final void x2() {
        w2(Uri.fromFile(new File(d2())));
    }

    public final void y2() {
        BroadcastReceiver broadcastReceiver = this.f20350W;
        if (broadcastReceiver != null && this.f20351o) {
            unregisterReceiver(broadcastReceiver);
            this.f20351o = false;
        }
    }

    public final synchronized void z2() {
        if (this.f20335H) {
            unbindService(this);
            this.f20335H = false;
        }
    }
}
