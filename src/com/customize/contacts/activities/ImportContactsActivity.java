package com.customize.contacts.activities;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.contacts.activities.RequestImportVCardPermissionsActivity;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.framework.bttransmission.pbapclient.ClientControler;
import com.android.contacts.list.AccountFilterActivity;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.list.c;
import com.android.contacts.model.Account;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.importcontact.ImportContactsService;
import com.customize.contacts.importcontact.ImportProgressActivity;
import com.customize.contacts.util.C0797h;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public class ImportContactsActivity extends BasicActivity implements ServiceConnection {

    /* renamed from: A, reason: collision with root package name */
    public Account f20375A;

    /* renamed from: B, reason: collision with root package name */
    public volatile List<ContactListFilter> f20376B;

    /* renamed from: C, reason: collision with root package name */
    public com.customize.contacts.importcontact.i f20377C;

    /* renamed from: E, reason: collision with root package name */
    public androidx.appcompat.app.b f20379E;

    /* renamed from: q, reason: collision with root package name */
    public boolean f20384q;

    /* renamed from: r, reason: collision with root package name */
    public String f20385r;

    /* renamed from: x, reason: collision with root package name */
    public ArrayList<String> f20386x;

    /* renamed from: y, reason: collision with root package name */
    public int f20387y;

    /* renamed from: z, reason: collision with root package name */
    public ArrayList<String> f20388z;

    /* renamed from: o, reason: collision with root package name */
    public final Object f20382o = new Object();

    /* renamed from: p, reason: collision with root package name */
    public int f20383p = 2;

    /* renamed from: D, reason: collision with root package name */
    public boolean f20378D = false;

    /* renamed from: F, reason: collision with root package name */
    public androidx.appcompat.app.b f20380F = null;

    /* renamed from: G, reason: collision with root package name */
    public boolean f20381G = false;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (ImportContactsActivity.this.f20379E != null && ImportContactsActivity.this.f20379E.isShowing()) {
                ImportContactsActivity.this.f20379E.dismiss();
            }
            ImportContactsActivity.this.finish();
        }

        public a() {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ImportContactsActivity.this.finish();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            ImportContactsActivity.this.finish();
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ImportContactsActivity.this.finish();
        }

        public b() {
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<ImportContactsActivity> f20391a;

        public c(ImportContactsActivity importContactsActivity) {
            this.f20391a = new WeakReference<>(importContactsActivity);
        }

        public final boolean a(ImportContactsActivity importContactsActivity, String str, String str2) {
            if (TextUtils.isEmpty(str2)) {
                d();
                return false;
            }
            Uri parse = Uri.parse(str);
            Uri parse2 = Uri.parse(Uri.decode(str));
            boolean e10 = e(importContactsActivity, str2, parse);
            if (!e10) {
                e10 = e(importContactsActivity, str2, parse2);
            }
            d();
            if (e10) {
                importContactsActivity.f20388z.add(str2);
            }
            if (H7.a.b()) {
                H7.b.b("ImportContacts", "copyToDefaultStorage: urlString: " + str + ", fileName: " + str2 + ", success: " + e10);
            }
            return e10;
        }

        /* JADX WARN: Removed duplicated region for block: B:156:0x031a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:161:0x0301 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Integer doInBackground(java.lang.Void... r15) {
            /*
                Method dump skipped, instructions count: 843
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.activities.ImportContactsActivity.c.doInBackground(java.lang.Void[]):java.lang.Integer");
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            ImportContactsActivity importContactsActivity = this.f20391a.get();
            if (importContactsActivity != null && !importContactsActivity.isDestroyed() && !importContactsActivity.isFinishing()) {
                if (importContactsActivity.f20380F != null && importContactsActivity.f20380F.isShowing()) {
                    importContactsActivity.f20380F.dismiss();
                    importContactsActivity.f20380F = null;
                }
                if (-1 != num.intValue()) {
                    importContactsActivity.f20383p = num.intValue();
                    if (3 == importContactsActivity.f20383p && !importContactsActivity.f20384q) {
                        importContactsActivity.showDialog(4);
                        return;
                    } else {
                        importContactsActivity.d2();
                        return;
                    }
                }
                importContactsActivity.finish();
            }
        }

        public final void d() {
            ImportContactsActivity importContactsActivity = this.f20391a.get();
            if (importContactsActivity != null) {
                importContactsActivity.f20381G = true;
                synchronized (importContactsActivity.f20382o) {
                    importContactsActivity.f20382o.notifyAll();
                }
            }
        }

        public final boolean e(Context context, String str, Uri uri) {
            FileOutputStream fileOutputStream;
            InputStream inputStream = null;
            FileOutputStream fileOutputStream2 = null;
            inputStream = null;
            try {
                byte[] bArr = new byte[1024];
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                boolean z10 = false;
                boolean z11 = false;
                while (true) {
                    try {
                        int read = openInputStream.read(bArr);
                        if (read != -1) {
                            if (!z10 && read > 30) {
                                String str2 = new String(bArr, 0, 30, Charset.defaultCharset());
                                z11 = str2.startsWith("BEGIN:VCARD");
                                if (H7.a.b()) {
                                    H7.b.b("ImportContacts", "header: " + str2 + ", isVcard:" + z11 + ", fileName: " + str + ", uri: " + uri);
                                }
                                z10 = true;
                            }
                            if (!z11) {
                                break;
                            }
                            if (fileOutputStream2 == null) {
                                fileOutputStream2 = new FileOutputStream(new File(str));
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            break;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        FileOutputStream fileOutputStream3 = fileOutputStream2;
                        inputStream = openInputStream;
                        fileOutputStream = fileOutputStream3;
                        try {
                            H7.b.c("ImportContacts", "writeToTargetFile: exception: " + str + ", e1 = " + e);
                            com.oplus.foundation.util.io.e.b(inputStream);
                            com.oplus.foundation.util.io.e.b(fileOutputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            com.oplus.foundation.util.io.e.b(inputStream);
                            com.oplus.foundation.util.io.e.b(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        FileOutputStream fileOutputStream4 = fileOutputStream2;
                        inputStream = openInputStream;
                        fileOutputStream = fileOutputStream4;
                        com.oplus.foundation.util.io.e.b(inputStream);
                        com.oplus.foundation.util.io.e.b(fileOutputStream);
                        throw th;
                    }
                }
                com.oplus.foundation.util.io.e.b(openInputStream);
                com.oplus.foundation.util.io.e.b(fileOutputStream2);
                if (H7.a.b()) {
                    H7.b.b("ImportContacts", "writeToTargetFile: success: " + z11);
                }
                return z11;
            } catch (Exception e11) {
                e = e11;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends AsyncTask<Integer, Integer, List<ContactListFilter>> {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<ImportContactsActivity> f20392a;

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<ContactListFilter> doInBackground(Integer... numArr) {
            ImportContactsActivity importContactsActivity = this.f20392a.get();
            if (importContactsActivity == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<ContactListFilter> C12 = AccountFilterActivity.C1(importContactsActivity, ContactListFilter.h(-2), true);
            if (H7.a.b()) {
                H7.b.b("ImportContacts", "showAccountsToImportTo(), size = " + C12.size());
            }
            for (int size = C12.size() - 1; size > 0; size--) {
                if (H7.a.b()) {
                    H7.b.b("ImportContacts", "the type is " + C12.get(size).f16738b);
                }
                if (C12.get(size).f16738b != -3 && (C12.get(size).f16738b != 0 || !TextUtils.equals(C12.get(size).f16739c, "com.android.oplus.sim"))) {
                    arrayList.add(C12.get(size));
                }
            }
            importContactsActivity.f20376B = arrayList;
            return arrayList;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<ContactListFilter> list) {
            ImportContactsActivity importContactsActivity = this.f20392a.get();
            if (importContactsActivity != null && !importContactsActivity.isDestroyed() && !importContactsActivity.isFinishing()) {
                if (list != null && !list.isEmpty()) {
                    if (list.size() == 1 && importContactsActivity.f20383p != 1) {
                        if ((!TextUtils.isEmpty(((ContactListFilter) importContactsActivity.f20376B.get(0)).f16740d) && !TextUtils.isEmpty(((ContactListFilter) importContactsActivity.f20376B.get(0)).f16739c)) || R0.a.f3166b == null) {
                            importContactsActivity.f20375A = new Account(((ContactListFilter) importContactsActivity.f20376B.get(0)).f16740d, ((ContactListFilter) importContactsActivity.f20376B.get(0)).f16739c);
                            importContactsActivity.X1();
                            return;
                        }
                        H7.b.i("ImportContacts", "showAccountsToImportTo(), no available account! accountName " + ((ContactListFilter) importContactsActivity.f20376B.get(0)).f16740d + " accountType " + ((ContactListFilter) importContactsActivity.f20376B.get(0)).f16739c);
                        importContactsActivity.finish();
                        return;
                    }
                    ClientControler.y().S(false);
                    importContactsActivity.f20379E = importContactsActivity.c2(list);
                    return;
                }
                H7.b.i("ImportContacts", "showAccountsToImportTo(), no available account!");
                importContactsActivity.finish();
            }
        }

        public d(ImportContactsActivity importContactsActivity) {
            this.f20392a = new WeakReference<>(importContactsActivity);
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ImportContactsActivity.this.finish();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 == i10) {
                ImportContactsActivity.this.d2();
            } else if (-2 == i10) {
                ImportContactsActivity.this.finish();
                ImportContactsActivity.this.overridePendingTransition(R.anim.dialog_open_enter, R.anim.dialog_open_exit);
            }
        }

        public e() {
        }
    }

    public static void T1(File file) {
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            String name = file2.getName();
                            if (name.endsWith(".vcf")) {
                                boolean delete = file2.delete();
                                if (H7.a.b()) {
                                    H7.b.b("ImportContacts", "Delete vcf cache file: " + name + ": " + delete);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
            } catch (Exception e10) {
                H7.b.c("ImportContacts", "cleanCacheDir: Exception: " + e10);
                return;
            }
        }
        H7.b.i("ImportContacts", "Not a directory: " + file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(View view, int i10) {
        androidx.appcompat.app.b bVar = this.f20379E;
        if (bVar != null && bVar.isShowing()) {
            this.f20379E.dismiss();
        }
        P1(i10);
    }

    private void e2(int i10) {
        String a10 = this.f20377C.a(i10);
        String b10 = this.f20377C.b(i10);
        if (H7.a.b()) {
            H7.b.b("ImportContacts", "showErrorDialog(), errorInfo = " + a10);
        }
        Bundle bundle = new Bundle(2);
        bundle.putString("key_error_info", a10);
        bundle.putString("key_error_toast", b10);
        showDialog(3, bundle);
    }

    public void P1(int i10) {
        if (i10 >= 0 && i10 < this.f20376B.size()) {
            Account account = new Account(this.f20376B.get(i10).f16740d, this.f20376B.get(i10).f16739c);
            this.f20375A = account;
            if ("account_save_as_file".equals(account.f16942b)) {
                H7.b.c("ImportContacts", "should not come here  ");
                return;
            } else {
                X1();
                return;
            }
        }
        finish();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    public final void Q1() {
        this.f20378D = true;
        if (H7.a.b()) {
            H7.b.b("ImportContacts", "bind service");
        }
        Intent intent = new Intent(this, (Class<?>) ImportContactsService.class);
        intent.putExtra("key_check_importing_state", true);
        bindService(intent, this, 1);
    }

    public final String R1(int i10) {
        return S1(i10, 0);
    }

    public final String S1(int i10, int i11) {
        String str;
        File cacheDir = getCacheDir();
        if (cacheDir != null) {
            str = cacheDir.getAbsolutePath();
        } else {
            str = null;
        }
        String trim = DateFormat.format("yyyyMMdd_hhmmss", new Date(System.currentTimeMillis())).toString().trim();
        if (i10 == 1) {
            return str + "/" + trim + "_" + i11 + ".vcf";
        }
        if (i10 != 0) {
            return null;
        }
        return str + "/" + trim + "_" + i11 + ".csv";
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean T0() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Uri U1(Uri uri, String str) {
        FileChannel fileChannel;
        H7.b.e("ImportContacts", String.format("Copy a Uri to app local storage (%s -> %s)", uri, str));
        FileChannel fileChannel2 = null;
        try {
            ReadableByteChannel newChannel = Channels.newChannel(getContentResolver().openInputStream(uri));
            try {
                Uri parse = Uri.parse(getFileStreamPath(str).toURI().toString());
                fileChannel2 = openFileOutput(str, 0).getChannel();
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(8192);
                while (newChannel.read(allocateDirect) != -1) {
                    allocateDirect.flip();
                    fileChannel2.write(allocateDirect);
                    allocateDirect.compact();
                }
                allocateDirect.flip();
                while (allocateDirect.hasRemaining()) {
                    fileChannel2.write(allocateDirect);
                }
                try {
                    newChannel.close();
                } catch (IOException unused) {
                    H7.b.i("ImportContacts", "Failed to close inputChannel.");
                }
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException unused2) {
                        H7.b.i("ImportContacts", "Failed to close outputChannel");
                    }
                }
                return parse;
            } catch (Throwable th) {
                th = th;
                FileChannel fileChannel3 = fileChannel2;
                fileChannel2 = newChannel;
                fileChannel = fileChannel3;
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException unused3) {
                        H7.b.i("ImportContacts", "Failed to close inputChannel.");
                    }
                }
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                        throw th;
                    } catch (IOException unused4) {
                        H7.b.i("ImportContacts", "Failed to close outputChannel");
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    public final HeaderFooterRecyclerView V1(com.android.contacts.list.c cVar) {
        HeaderFooterRecyclerView headerFooterRecyclerView = new HeaderFooterRecyclerView(this);
        headerFooterRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        headerFooterRecyclerView.setPadding(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.DP_16));
        headerFooterRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        headerFooterRecyclerView.setAdapter(cVar);
        return headerFooterRecyclerView;
    }

    public final String W1(Uri uri) {
        Cursor cursor = null;
        r1 = null;
        r1 = null;
        r1 = null;
        String string = null;
        if (uri == null) {
            return null;
        }
        try {
            Cursor query = getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0 && query.moveToFirst()) {
                        if (query.getCount() > 1) {
                            H7.b.i("ImportContacts", "Unexpected multiple rows: " + query.getCount());
                        }
                        int columnIndex = query.getColumnIndex("_display_name");
                        if (columnIndex >= 0) {
                            string = query.getString(columnIndex);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            if (TextUtils.isEmpty(string)) {
                return uri.getLastPathSegment();
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void X1() {
        int i10 = this.f20383p;
        if (2 == i10) {
            f2();
            return;
        }
        if (3 == i10 || 1 == i10) {
            if (this.f20385r == null) {
                if (this.f20386x != null) {
                    h2();
                    return;
                } else {
                    e2(1);
                    return;
                }
            }
            h2();
        }
    }

    public final Dialog Y1() {
        int i10;
        e eVar = new e();
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this);
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            i10 = R.string.odialer_import_contacts_warning;
        } else {
            i10 = R.string.oplus_import_contacts_warning;
        }
        cOUIAlertDialogBuilder.setTitle(i10).setPositiveButton(R.string.notify_import, (DialogInterface.OnClickListener) eVar).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) eVar);
        androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
        J3.e.b(show);
        show.setCancelable(false);
        return show;
    }

    public final String a2(Uri uri) {
        int i10 = 0;
        while (true) {
            String str = "import_tmp_" + i10 + ".vcf";
            if (!getFileStreamPath(str).exists()) {
                try {
                    U1(uri, str);
                    return str;
                } catch (IOException | SecurityException unused) {
                    com.oplus.foundation.util.ui.c.b(this, R.string.fail_reason_io_error);
                    return null;
                }
            }
            if (i10 != Integer.MAX_VALUE) {
                i10++;
            } else {
                throw new RuntimeException("Exceeded cache limit");
            }
        }
    }

    public final Uri b2(Uri uri) {
        String a22 = a2(uri);
        if (a22 == null) {
            return null;
        }
        H7.b.e("ImportContacts", "fileName = " + a22);
        return Uri.parse(getFileStreamPath(a22).toURI().toString());
    }

    public final androidx.appcompat.app.b c2(List<ContactListFilter> list) {
        com.android.contacts.list.c cVar = new com.android.contacts.list.c(this, list, null, new c.InterfaceC0172c() { // from class: com.customize.contacts.activities.Q
            @Override // com.android.contacts.list.c.InterfaceC0172c
            public final void onItemClick(View view, int i10) {
                ImportContactsActivity.this.Z1(view, i10);
            }
        });
        androidx.appcompat.app.b show = new U0.b(this, 2132083075).setTitle(R.string.import_to).setView(V1(cVar)).setOnCancelListener(new a()).show();
        show.setCanceledOnTouchOutside(true);
        Window window = show.getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
        return show;
    }

    public void d2() {
        new d().execute(0);
    }

    public final void f2() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("text/x-vcard");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        Q7.b.b(this, intent, 100, 0);
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        C0636a.b(this);
    }

    public final void g2() {
        this.f20388z = new ArrayList<>();
        this.f20377C = new com.customize.contacts.importcontact.i(this);
        this.f20381G = false;
        C0797h.a(this, new c(this), this.f20382o);
        if (!this.f20381G) {
            this.f20380F = U0.k.o(this, getString(R.string.loading));
        }
    }

    public final void h2() {
        Intent intent = new Intent(this, (Class<?>) ImportProgressActivity.class);
        intent.putExtra("import_account", this.f20375A);
        intent.putStringArrayListExtra("FILE_NAME", this.f20388z);
        intent.putExtra("key_file_type", this.f20387y);
        intent.putExtra("key_from_pbap", this.f20384q);
        intent.addFlags(67108864);
        Q7.b.b(this, intent, 101, 0);
        if (H7.a.b()) {
            H7.b.e("ImportContacts", "Import Contacts, acquireCpuWakeLock");
        }
    }

    public final void i2() {
        if (H7.a.b()) {
            H7.b.b("ImportContacts", "unBindService");
        }
        if (this.f20378D) {
            unbindService(this);
        }
        this.f20378D = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        Uri b22;
        super.onActivityResult(i10, i11, intent);
        if (i10 != 100) {
            if (i10 == 101) {
                finish();
                return;
            }
            return;
        }
        if (i11 == -1) {
            ClipData clipData = intent.getClipData();
            ArrayList arrayList = new ArrayList();
            if (clipData != null) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (int i12 = 0; i12 < clipData.getItemCount(); i12++) {
                    Uri uri = clipData.getItemAt(i12).getUri();
                    if (uri != null && (b22 = b2(uri)) != null) {
                        String W12 = W1(uri);
                        arrayList2.add(b22);
                        arrayList.add(b22.toString());
                        arrayList3.add(W12);
                    }
                }
                if (arrayList2.isEmpty()) {
                    H7.b.i("ImportContacts", "No vCard was selected for import");
                    finish();
                    return;
                }
                H7.b.e("ImportContacts", "Multiple vCards selected for import uris : ");
                if (this.f20388z == null) {
                    this.f20388z = new ArrayList<>();
                }
                this.f20388z.clear();
                this.f20388z.addAll(arrayList);
                h2();
                return;
            }
            Uri data = intent.getData();
            if (data != null) {
                H7.b.e("ImportContacts", "vCard selected for import uri : ");
                Uri b23 = b2(data);
                H7.b.e("ImportContacts", "vCard selected for import localUri : ");
                if (b23 != null) {
                    W1(data);
                    arrayList.add(b23.toString());
                    if (this.f20388z == null) {
                        this.f20388z = new ArrayList<>();
                    }
                    this.f20388z.clear();
                    this.f20388z.addAll(arrayList);
                    h2();
                    return;
                }
                H7.b.i("ImportContacts", "No local URI for vCard import");
                finish();
                return;
            }
            H7.b.i("ImportContacts", "No vCard was selected for import");
            finish();
            return;
        }
        if (i11 != 0) {
            H7.b.i("ImportContacts", "Result code was not OK nor CANCELED" + i11);
        }
        finish();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.import_contacts_activity);
        getWindow().clearFlags(2);
        RequestImportVCardPermissionsActivity.q2(this, true);
        Q1();
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10) {
        if (i10 != 4) {
            return super.onCreateDialog(i10);
        }
        return Y1();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (H7.a.b()) {
            H7.b.b("ImportContacts", "onDestroy()------------------");
        }
        i2();
        super.onDestroy();
        androidx.appcompat.app.b bVar = this.f20379E;
        if (bVar != null && bVar.isShowing()) {
            this.f20379E.dismiss();
        }
        this.f20379E = null;
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i10, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i10, dialog, bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (i10 == 0) {
            if (iArr.length == 1 && iArr[0] == 0) {
                Q1();
            } else {
                finish();
            }
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int c10 = ((ImportContactsService.d) iBinder).c();
        if (H7.a.b()) {
            H7.b.b("ImportContacts", "onServiceConnected, state = " + c10);
        }
        if (666 != c10) {
            i2();
            com.oplus.foundation.util.ui.c.c(this, getString(R.string.oplus_taost_importing_is_running));
            finish();
        } else {
            i2();
            g2();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        if (H7.a.b()) {
            H7.b.b("ImportContacts", "onStop()");
        }
        super.onStop();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, android.app.Activity
    public Dialog onCreateDialog(int i10, Bundle bundle) {
        String string;
        if (3 == i10) {
            if (bundle == null) {
                string = "";
            } else {
                string = bundle.getString("key_error_info");
            }
            if (TextUtils.isEmpty(string)) {
                string = getString(R.string.operation_error);
            }
            b bVar = new b();
            COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this);
            cOUIAlertDialogBuilder.setTitle(R.string.oplus_title_import_phonebook).setMessage((CharSequence) string).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) bVar).setOnCancelListener(bVar);
            androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
            show.setOnDismissListener(bVar);
            return show;
        }
        return super.onCreateDialog(i10, bundle);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
