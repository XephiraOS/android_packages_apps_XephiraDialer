package com.android.contacts.vcard;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import com.android.contacts.ContactsActivity;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.C0701b;
import com.android.contacts.vcard.VCardService;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.util.C;
import com.oplus.dialer.R;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class ImportVCardActivity extends ContactsActivity {

    /* renamed from: A, reason: collision with root package name */
    public List<h> f17654A;

    /* renamed from: B, reason: collision with root package name */
    public VCardScanThread f17655B;

    /* renamed from: C, reason: collision with root package name */
    public g f17656C;

    /* renamed from: D, reason: collision with root package name */
    public e f17657D;

    /* renamed from: E, reason: collision with root package name */
    public String f17658E;

    /* renamed from: F, reason: collision with root package name */
    public Handler f17659F = new Handler();

    /* renamed from: G, reason: collision with root package name */
    public c f17660G = new c();

    /* renamed from: q, reason: collision with root package name */
    public s f17661q;

    /* renamed from: r, reason: collision with root package name */
    public C0701b.c f17662r;

    /* renamed from: x, reason: collision with root package name */
    public AccountWithDataSet f17663x;

    /* renamed from: y, reason: collision with root package name */
    public ProgressDialog f17664y;

    /* renamed from: z, reason: collision with root package name */
    public ProgressDialog f17665z;

    /* loaded from: classes.dex */
    public class VCardScanThread extends Thread implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {

        /* renamed from: c, reason: collision with root package name */
        public File f17668c;

        /* renamed from: e, reason: collision with root package name */
        public PowerManager.WakeLock f17670e;

        /* renamed from: a, reason: collision with root package name */
        public boolean f17666a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f17667b = false;

        /* renamed from: d, reason: collision with root package name */
        public Set<String> f17669d = new HashSet();

        /* loaded from: classes.dex */
        public class CanceledException extends Exception {
            public CanceledException() {
            }
        }

        public VCardScanThread(File file) {
            this.f17668c = file;
            this.f17670e = ((PowerManager) ImportVCardActivity.this.getSystemService("power")).newWakeLock(536870918, "Contacts:ImportVcardWakeLock");
        }

        public final void a(File file) {
            if (!this.f17666a) {
                if (file.listFiles() == null) {
                    if (!TextUtils.equals(file.getCanonicalPath(), this.f17668c.getCanonicalPath().concat(".android_secure"))) {
                        H7.b.i("VCardImport", "listFiles() returned null (directory: " + file + ")");
                        return;
                    }
                    return;
                }
                for (File file2 : file.listFiles()) {
                    if (!this.f17666a) {
                        String canonicalPath = file2.getCanonicalPath();
                        if (!this.f17669d.contains(canonicalPath)) {
                            this.f17669d.add(canonicalPath);
                            if (file2.isDirectory()) {
                                a(file2);
                            } else if (canonicalPath.toLowerCase().endsWith(".vcf") && file2.canRead()) {
                                ImportVCardActivity.this.f17654A.add(new h(file2.getName(), canonicalPath, file2.lastModified()));
                            }
                        }
                    } else {
                        throw new CanceledException();
                    }
                }
                return;
            }
            throw new CanceledException();
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f17666a = true;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -2) {
                this.f17666a = true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r2 = this;
                com.android.contacts.vcard.ImportVCardActivity r0 = com.android.contacts.vcard.ImportVCardActivity.this
                java.util.Vector r1 = new java.util.Vector
                r1.<init>()
                com.android.contacts.vcard.ImportVCardActivity.v1(r0, r1)
                r0 = 1
                android.os.PowerManager$WakeLock r1 = r2.f17670e     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L28 com.android.contacts.vcard.ImportVCardActivity.VCardScanThread.CanceledException -> L2b
                r1.acquire()     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L28 com.android.contacts.vcard.ImportVCardActivity.VCardScanThread.CanceledException -> L2b
                java.io.File r1 = r2.f17668c     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L28 com.android.contacts.vcard.ImportVCardActivity.VCardScanThread.CanceledException -> L2b
                r2.a(r1)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L28 com.android.contacts.vcard.ImportVCardActivity.VCardScanThread.CanceledException -> L2b
            L15:
                android.os.PowerManager$WakeLock r0 = r2.f17670e
                r0.release()
                goto L2e
            L1b:
                r0 = move-exception
                java.lang.String r1 = "VCardImport"
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L26
                H7.b.c(r1, r0)     // Catch: java.lang.Throwable -> L26
                goto L15
            L26:
                r0 = move-exception
                goto L80
            L28:
                r2.f17667b = r0     // Catch: java.lang.Throwable -> L26
                goto L15
            L2b:
                r2.f17666a = r0     // Catch: java.lang.Throwable -> L26
                goto L15
            L2e:
                boolean r0 = r2.f17666a
                r1 = 0
                if (r0 == 0) goto L38
                com.android.contacts.vcard.ImportVCardActivity r0 = com.android.contacts.vcard.ImportVCardActivity.this
                com.android.contacts.vcard.ImportVCardActivity.v1(r0, r1)
            L38:
                com.android.contacts.vcard.ImportVCardActivity r0 = com.android.contacts.vcard.ImportVCardActivity.this
                android.app.ProgressDialog r0 = com.android.contacts.vcard.ImportVCardActivity.t1(r0)
                r0.dismiss()
                com.android.contacts.vcard.ImportVCardActivity r0 = com.android.contacts.vcard.ImportVCardActivity.this
                com.android.contacts.vcard.ImportVCardActivity.y1(r0, r1)
                boolean r0 = r2.f17667b
                if (r0 == 0) goto L58
                com.android.contacts.vcard.ImportVCardActivity r2 = com.android.contacts.vcard.ImportVCardActivity.this
                com.android.contacts.vcard.ImportVCardActivity$d r0 = new com.android.contacts.vcard.ImportVCardActivity$d
                r1 = 2131427896(0x7f0b0238, float:1.8477421E38)
                r0.<init>(r1)
                r2.runOnUiThread(r0)
                goto L7f
            L58:
                boolean r0 = r2.f17666a
                if (r0 == 0) goto L62
                com.android.contacts.vcard.ImportVCardActivity r2 = com.android.contacts.vcard.ImportVCardActivity.this
                r2.finish()
                goto L7f
            L62:
                com.android.contacts.vcard.ImportVCardActivity r0 = com.android.contacts.vcard.ImportVCardActivity.this
                java.util.List r0 = com.android.contacts.vcard.ImportVCardActivity.q1(r0)
                int r0 = r0.size()
                com.android.contacts.vcard.ImportVCardActivity r2 = com.android.contacts.vcard.ImportVCardActivity.this
                if (r0 != 0) goto L7c
                com.android.contacts.vcard.ImportVCardActivity$d r0 = new com.android.contacts.vcard.ImportVCardActivity$d
                r1 = 2131427906(0x7f0b0242, float:1.8477441E38)
                r0.<init>(r1)
                r2.runOnUiThread(r0)
                goto L7f
            L7c:
                com.android.contacts.vcard.ImportVCardActivity.C1(r2)
            L7f:
                return
            L80:
                android.os.PowerManager$WakeLock r2 = r2.f17670e
                r2.release()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.vcard.ImportVCardActivity.VCardScanThread.run():void");
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri[] f17672a;

        public a(Uri[] uriArr) {
            this.f17672a = uriArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImportVCardActivity.this.f17656C = new g(this.f17672a);
            ImportVCardActivity importVCardActivity = ImportVCardActivity.this;
            importVCardActivity.f17661q = new p(importVCardActivity);
            try {
                ImportVCardActivity.this.showDialog(R.id.dialog_cache_vcard);
            } catch (Exception e10) {
                H7.b.c("VCardImport", "Exception e: " + e10);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ImportVCardActivity importVCardActivity = ImportVCardActivity.this;
            com.oplus.foundation.util.ui.c.c(importVCardActivity, importVCardActivity.getString(R.string.vcard_import_failed));
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ImportVCardActivity.this.finish();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            ImportVCardActivity.this.finish();
        }

        public c() {
        }
    }

    /* loaded from: classes.dex */
    public class e implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public VCardService f17678a;

        public void a(List<k> list) {
            H7.b.e("VCardImport", "Send an import request");
            this.f17678a.m(list, ImportVCardActivity.this.f17661q);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f17678a = ((VCardService.b) iBinder).a();
            H7.b.e("VCardImport", String.format("Connected com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel.tablayout VCardService. Kick a vCard cache thread (uri: %s)", Arrays.toString(ImportVCardActivity.this.f17656C.d())));
            ImportVCardActivity.this.f17656C.start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            H7.b.e("VCardImport", "Disconnected from VCardService");
        }

        public e() {
        }
    }

    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public int f17680a;

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -1) {
                int i11 = this.f17680a;
                if (i11 != 1) {
                    if (i11 != 2) {
                        ImportVCardActivity.this.showDialog(R.id.dialog_select_one_vcard);
                        return;
                    } else {
                        ImportVCardActivity importVCardActivity = ImportVCardActivity.this;
                        importVCardActivity.K1(importVCardActivity.f17654A);
                        return;
                    }
                }
                ImportVCardActivity.this.showDialog(R.id.dialog_select_multiple_vcard);
                return;
            }
            if (i10 == -2) {
                ImportVCardActivity.this.finish();
            } else {
                this.f17680a = i10;
            }
        }

        public f() {
        }
    }

    /* loaded from: classes.dex */
    public class g extends Thread implements DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public final Uri[] f17682a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f17683b = null;

        /* renamed from: c, reason: collision with root package name */
        public final String f17684c = null;

        /* renamed from: d, reason: collision with root package name */
        public boolean f17685d;

        /* renamed from: e, reason: collision with root package name */
        public PowerManager.WakeLock f17686e;

        /* renamed from: f, reason: collision with root package name */
        public com.android.contacts.framework.vcard.m f17687f;

        public g(Uri[] uriArr) {
            this.f17682a = uriArr;
            this.f17686e = ((PowerManager) ImportVCardActivity.this.getSystemService("power")).newWakeLock(536870918, "Contacts:ImportVcardWakeLock");
        }

        public void a() {
            this.f17685d = true;
            com.android.contacts.framework.vcard.m mVar = this.f17687f;
            if (mVar != null) {
                mVar.b();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0042 A[Catch: all -> 0x003a, TRY_ENTER, TryCatch #4 {all -> 0x003a, blocks: (B:6:0x001a, B:27:0x003d, B:29:0x0042, B:31:0x004e, B:33:0x0055, B:41:0x0099, B:42:0x00a1, B:43:0x0049), top: B:5:0x001a, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0049 A[Catch: all -> 0x003a, TryCatch #4 {all -> 0x003a, blocks: (B:6:0x001a, B:27:0x003d, B:29:0x0042, B:31:0x004e, B:33:0x0055, B:41:0x0099, B:42:0x00a1, B:43:0x0049), top: B:5:0x001a, inners: #0 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.android.contacts.vcard.k b(byte[] r12, android.net.Uri r13, java.lang.String r14) {
            /*
                r11 = this;
                com.android.contacts.vcard.ImportVCardActivity r1 = com.android.contacts.vcard.ImportVCardActivity.this
                android.content.ContentResolver r1 = r1.getContentResolver()
                if (r12 == 0) goto Le
                java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
                r4.<init>(r12)
                goto L12
            Le:
                java.io.InputStream r4 = r1.openInputStream(r13)
            L12:
                com.android.contacts.framework.vcard.q r5 = new com.android.contacts.framework.vcard.q
                r5.<init>()
                r11.f17687f = r5
                r5 = 1
                com.android.contacts.framework.vcard.j r6 = new com.android.contacts.framework.vcard.j     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L3d
                r6.<init>()     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L3d
                com.android.contacts.framework.vcard.v r7 = new com.android.contacts.framework.vcard.v     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L3d
                r7.<init>()     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L3d
                com.android.contacts.framework.vcard.m r8 = r11.f17687f     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L3d
                r8.a(r6)     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L3d
                com.android.contacts.framework.vcard.m r8 = r11.f17687f     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L3d
                r8.a(r7)     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L3d
                com.android.contacts.framework.vcard.m r8 = r11.f17687f     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L3d
                r8.c(r4)     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L3d
                if (r4 == 0) goto L38
                r4.close()     // Catch: java.io.IOException -> L38
            L38:
                r1 = 0
                goto L74
            L3a:
                r0 = move-exception
                goto La2
            L3d:
                r4.close()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L40
            L40:
                if (r12 == 0) goto L49
                java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L3a
                r1.<init>(r12)     // Catch: java.lang.Throwable -> L3a
            L47:
                r4 = r1
                goto L4e
            L49:
                java.io.InputStream r1 = r1.openInputStream(r13)     // Catch: java.lang.Throwable -> L3a
                goto L47
            L4e:
                com.android.contacts.framework.vcard.r r1 = new com.android.contacts.framework.vcard.r     // Catch: java.lang.Throwable -> L3a
                r1.<init>()     // Catch: java.lang.Throwable -> L3a
                r11.f17687f = r1     // Catch: java.lang.Throwable -> L3a
                com.android.contacts.framework.vcard.j r6 = new com.android.contacts.framework.vcard.j     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L99
                r6.<init>()     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L99
                com.android.contacts.framework.vcard.v r7 = new com.android.contacts.framework.vcard.v     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L99
                r7.<init>()     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L99
                com.android.contacts.framework.vcard.m r1 = r11.f17687f     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L99
                r1.a(r6)     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L99
                com.android.contacts.framework.vcard.m r1 = r11.f17687f     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L99
                r1.a(r7)     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L99
                com.android.contacts.framework.vcard.m r1 = r11.f17687f     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L99
                r1.c(r4)     // Catch: java.lang.Throwable -> L3a com.android.contacts.framework.vcard.exception.VCardVersionException -> L99
                if (r4 == 0) goto L73
                r4.close()     // Catch: java.io.IOException -> L73
            L73:
                r1 = r5
            L74:
                if (r1 == 0) goto L79
                r1 = 2
                r8 = r1
                goto L7a
            L79:
                r8 = r5
            L7a:
                com.android.contacts.vcard.k r9 = new com.android.contacts.vcard.k
                com.android.contacts.vcard.ImportVCardActivity r0 = com.android.contacts.vcard.ImportVCardActivity.this
                com.android.contacts.model.AccountWithDataSet r1 = com.android.contacts.vcard.ImportVCardActivity.p1(r0)
                int r5 = r7.g()
                java.lang.String r7 = r7.f()
                int r10 = r6.f()
                r0 = r9
                r2 = r12
                r3 = r13
                r4 = r14
                r6 = r7
                r7 = r8
                r8 = r10
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
                return r9
            L99:
                com.android.contacts.framework.vcard.exception.VCardException r0 = new com.android.contacts.framework.vcard.exception.VCardException     // Catch: java.lang.Throwable -> L3a
                java.lang.String r1 = "vCard with unspported version."
                r0.<init>(r1)     // Catch: java.lang.Throwable -> L3a
                throw r0     // Catch: java.lang.Throwable -> L3a
            La2:
                if (r4 == 0) goto La7
                r4.close()     // Catch: java.io.IOException -> La7
            La7:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.vcard.ImportVCardActivity.g.b(byte[], android.net.Uri, java.lang.String):com.android.contacts.vcard.k");
        }

        public final Uri c(Uri uri, String str) {
            FileChannel fileChannel;
            H7.b.e("VCardImport", String.format("Copy a Uri com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel.tablayout app local storage (%s -> %s)", uri, str));
            ImportVCardActivity importVCardActivity = ImportVCardActivity.this;
            ReadableByteChannel readableByteChannel = null;
            try {
                ReadableByteChannel newChannel = Channels.newChannel(importVCardActivity.getContentResolver().openInputStream(uri));
                try {
                    Uri parse = Uri.parse(importVCardActivity.getFileStreamPath(str).toURI().toString());
                    fileChannel = importVCardActivity.openFileOutput(str, 0).getChannel();
                    try {
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(8192);
                        while (newChannel.read(allocateDirect) != -1) {
                            if (this.f17685d) {
                                H7.b.b("VCardImport", "Canceled during caching " + uri);
                                try {
                                    newChannel.close();
                                } catch (IOException unused) {
                                    H7.b.i("VCardImport", "Failed com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel.tablayout close inputChannel.");
                                }
                                if (fileChannel != null) {
                                    try {
                                        fileChannel.close();
                                    } catch (IOException unused2) {
                                        H7.b.i("VCardImport", "Failed com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel.tablayout close outputChannel");
                                    }
                                }
                                return null;
                            }
                            allocateDirect.flip();
                            fileChannel.write(allocateDirect);
                            allocateDirect.compact();
                        }
                        allocateDirect.flip();
                        while (allocateDirect.hasRemaining()) {
                            fileChannel.write(allocateDirect);
                        }
                        try {
                            newChannel.close();
                        } catch (IOException unused3) {
                            H7.b.i("VCardImport", "Failed com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel.tablayout close inputChannel.");
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused4) {
                                H7.b.i("VCardImport", "Failed com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel.tablayout close outputChannel");
                            }
                        }
                        return parse;
                    } catch (Throwable th) {
                        th = th;
                        readableByteChannel = newChannel;
                        if (readableByteChannel != null) {
                            try {
                                readableByteChannel.close();
                            } catch (IOException unused5) {
                                H7.b.i("VCardImport", "Failed com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel.tablayout close inputChannel.");
                            }
                        }
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                                throw th;
                            } catch (IOException unused6) {
                                H7.b.i("VCardImport", "Failed com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel.tablayout close outputChannel");
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
            }
        }

        public Uri[] d() {
            return this.f17682a;
        }

        public void finalize() {
            PowerManager.WakeLock wakeLock = this.f17686e;
            if (wakeLock != null && wakeLock.isHeld()) {
                H7.b.i("VCardImport", "WakeLock is being held.");
                this.f17686e.release();
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            H7.b.e("VCardImport", "Cancel request has come. Abort caching vCard.");
            a();
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x0176, code lost:
        
            if (r13 != null) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x0178, code lost:
        
            r13.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:102:0x017b, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:0x013c, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x0252, code lost:
        
            if (r13 != null) goto L101;
         */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x0254, code lost:
        
            r13.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:107:0x0257, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0157, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x0158, code lost:
        
            r13 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x0153, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x0154, code lost:
        
            r13 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x015a, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x015b, code lost:
        
            r20 = r13;
            r21 = r14;
            r22 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x00f0, code lost:
        
            H7.b.i("VCardImport", "destUri is null");
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x00e9, code lost:
        
            H7.b.e("VCardImport", "vCard cache operation is canceled.");
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00e1, code lost:
        
            r6 = c(r11, r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00e7, code lost:
        
            if (r23.f17685d == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00ee, code lost:
        
            if (r6 != null) goto L150;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00fb, code lost:
        
            r20 = r13;
            r21 = r14;
            r22 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x010b, code lost:
        
            r13 = r19.query(r11, new java.lang.String[]{"_display_name"}, null, null, null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x010f, code lost:
        
            if (r13 == null) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x014c, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x014d, code lost:
        
            if (r13 == null) goto L74;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x014f, code lost:
        
            r13.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0180, code lost:
        
            if (android.text.TextUtils.isEmpty(r0) != false) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0182, code lost:
        
            r0 = r11.getLastPathSegment();
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0187, code lost:
        
            r0 = b(null, r6, r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x018d, code lost:
        
            if (r23.f17685d == false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x018f, code lost:
        
            H7.b.e("VCardImport", "vCard cache operation is canceled.");
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x01b7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x020e, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0210, code lost:
        
            H7.b.c("VCardImport", "Maybe the file is com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel wrong format" + r0);
            r23.f17688g.L1(com.oplus.dialer.R.string.fail_reason_not_supported);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x022a, code lost:
        
            H7.b.e("VCardImport", "Finished caching vCard.");
            r23.f17686e.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x0232, code lost:
        
            r23.f17688g.unbindService(r23.f17688g.f17657D);
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x023d, code lost:
        
            r23.f17688g.f17665z.dismiss();
            r23.f17688g.f17665z = null;
            r23.f17688g.finish();
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x0251, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x01c8, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x01c9, code lost:
        
            H7.b.c("VCardImport", "Unexpected IOException" + r0);
            r23.f17688g.L1(com.oplus.dialer.R.string.fail_reason_io_error);
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x01e6, code lost:
        
            H7.b.e("VCardImport", "Finished caching vCard.");
            r23.f17686e.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x01ee, code lost:
        
            r23.f17688g.unbindService(r23.f17688g.f17657D);
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x01f9, code lost:
        
            r23.f17688g.f17665z.dismiss();
            r23.f17688g.f17665z = null;
            r23.f17688g.finish();
         */
        /* JADX WARN: Code restructure failed: missing block: B:82:0x020d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0115, code lost:
        
            if (r13.getCount() <= 0) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x011b, code lost:
        
            if (r13.moveToFirst() == false) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0121, code lost:
        
            if (r13.getCount() <= 1) goto L56;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0123, code lost:
        
            H7.b.i("VCardImport", "Unexpected multiple rows: " + r13.getCount());
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0141, code lost:
        
            r0 = r13.getColumnIndex("_display_name");
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x0145, code lost:
        
            if (r0 < 0) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0147, code lost:
        
            r0 = r13.getString(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x013f, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0162, code lost:
        
            H7.b.c("VCardImport", "Exception e: " + r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:101:0x0178 A[Catch: all -> 0x0053, IOException -> 0x0056, OutOfMemoryError -> 0x02e8, TRY_ENTER, TryCatch #0 {OutOfMemoryError -> 0x02e8, blocks: (B:9:0x0023, B:12:0x002b, B:20:0x0059, B:131:0x0069, B:118:0x0279, B:120:0x027f, B:126:0x0289, B:23:0x00b1, B:25:0x00be, B:26:0x00c1, B:35:0x00e1, B:128:0x00e9, B:117:0x00f0, B:46:0x014f, B:47:0x017c, B:49:0x0182, B:52:0x0187, B:53:0x018b, B:57:0x018f, B:55:0x01b8, B:77:0x01c9, B:68:0x0210, B:106:0x0254, B:107:0x0257, B:101:0x0178, B:30:0x0266, B:32:0x0271, B:33:0x0278, B:134:0x0075), top: B:8:0x0023, outer: #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0182 A[Catch: all -> 0x0053, IOException -> 0x0056, OutOfMemoryError -> 0x02e8, TRY_LEAVE, TryCatch #0 {OutOfMemoryError -> 0x02e8, blocks: (B:9:0x0023, B:12:0x002b, B:20:0x0059, B:131:0x0069, B:118:0x0279, B:120:0x027f, B:126:0x0289, B:23:0x00b1, B:25:0x00be, B:26:0x00c1, B:35:0x00e1, B:128:0x00e9, B:117:0x00f0, B:46:0x014f, B:47:0x017c, B:49:0x0182, B:52:0x0187, B:53:0x018b, B:57:0x018f, B:55:0x01b8, B:77:0x01c9, B:68:0x0210, B:106:0x0254, B:107:0x0257, B:101:0x0178, B:30:0x0266, B:32:0x0271, B:33:0x0278, B:134:0x0075), top: B:8:0x0023, outer: #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01b8 A[Catch: all -> 0x0053, IOException -> 0x0056, OutOfMemoryError -> 0x02e8, LOOP:0: B:24:0x00bc->B:55:0x01b8, LOOP_END, TRY_ENTER, TryCatch #0 {OutOfMemoryError -> 0x02e8, blocks: (B:9:0x0023, B:12:0x002b, B:20:0x0059, B:131:0x0069, B:118:0x0279, B:120:0x027f, B:126:0x0289, B:23:0x00b1, B:25:0x00be, B:26:0x00c1, B:35:0x00e1, B:128:0x00e9, B:117:0x00f0, B:46:0x014f, B:47:0x017c, B:49:0x0182, B:52:0x0187, B:53:0x018b, B:57:0x018f, B:55:0x01b8, B:77:0x01c9, B:68:0x0210, B:106:0x0254, B:107:0x0257, B:101:0x0178, B:30:0x0266, B:32:0x0271, B:33:0x0278, B:134:0x0075), top: B:8:0x0023, outer: #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x018f A[SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 823
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.vcard.ImportVCardActivity.g.run():void");
        }
    }

    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public final String f17689a;

        /* renamed from: b, reason: collision with root package name */
        public final String f17690b;

        /* renamed from: c, reason: collision with root package name */
        public final long f17691c;

        public h(String str, String str2, long j10) {
            this.f17689a = str;
            this.f17690b = str2;
            this.f17691c = j10;
        }

        public String a() {
            return this.f17690b;
        }

        public long b() {
            return this.f17691c;
        }

        public String c() {
            return this.f17689a;
        }
    }

    public final void D1() {
        File a10 = C.a(getApplicationContext());
        if (a10 != null && (!a10.exists() || !a10.isDirectory() || !a10.canRead())) {
            showDialog(R.id.dialog_sdcard_not_found);
        } else {
            this.f17655B = new VCardScanThread(a10);
            showDialog(R.id.dialog_searching_vcard);
        }
    }

    public final Dialog E1() {
        f fVar = new f();
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this);
        cOUIAlertDialogBuilder.setTitle(R.string.select_vcard_title).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) fVar).setOnCancelListener(this.f17660G).setNegativeButton(android.R.string.cancel, this.f17660G);
        return cOUIAlertDialogBuilder.setSingleChoiceItems(new String[]{getString(R.string.import_one_vcard_string), getString(R.string.import_multiple_vcard_string), getString(R.string.import_all_vcard_string)}, 0, fVar).show();
    }

    public final Dialog F1(boolean z10) {
        String c10;
        int size = this.f17654A.size();
        i iVar = new i(z10);
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this);
        cOUIAlertDialogBuilder.setTitle(R.string.select_vcard_title).setPositiveButton(android.R.string.ok, (DialogInterface.OnClickListener) iVar).setOnCancelListener(this.f17660G).setNegativeButton(android.R.string.cancel, this.f17660G);
        CharSequence[] charSequenceArr = new CharSequence[size];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i10 = 0; i10 < size; i10++) {
            h hVar = this.f17654A.get(i10);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (hVar.c() == null) {
                c10 = "";
            } else {
                c10 = hVar.c();
            }
            spannableStringBuilder.append((CharSequence) c10);
            spannableStringBuilder.append('\n');
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) ("(" + simpleDateFormat.format(new Date(hVar.b())) + ")"));
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.7f), length, spannableStringBuilder.length(), 33);
            charSequenceArr[i10] = spannableStringBuilder;
        }
        if (z10) {
            cOUIAlertDialogBuilder.setMultiChoiceItems(charSequenceArr, (boolean[]) null, iVar);
        } else {
            cOUIAlertDialogBuilder.setSingleChoiceItems(charSequenceArr, 0, iVar);
        }
        return cOUIAlertDialogBuilder.show();
    }

    public final void G1(Uri uri) {
        H1(new Uri[]{uri});
    }

    public final void H1(Uri[] uriArr) {
        runOnUiThread(new a(uriArr));
    }

    public final void I1(String[] strArr) {
        int length = strArr.length;
        Uri[] uriArr = new Uri[length];
        for (int i10 = 0; i10 < length; i10++) {
            uriArr[i10] = Uri.parse(strArr[i10]);
        }
        H1(uriArr);
    }

    public final void J1(h hVar) {
        H1(new Uri[]{Uri.parse("file://" + hVar.a())});
    }

    public final void K1(List<h> list) {
        String[] strArr = new String[list.size()];
        Iterator<h> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            strArr[i10] = "file://" + it.next().a();
            i10++;
        }
        I1(strArr);
    }

    public void L1(int i10) {
        this.f17659F.post(new b());
    }

    public final void M1() {
        Uri data = getIntent().getData();
        if (data != null) {
            H7.b.e("VCardImport", "Starting vCard import using Uri " + data);
            G1(data);
            return;
        }
        H7.b.e("VCardImport", "Start vCard without Uri. The user will com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel.tablayout vCard manually.");
        D1();
    }

    public final void N1() {
        int size = this.f17654A.size();
        if (!getResources().getBoolean(R.bool.config_import_all_vcard_from_sdcard_automatically) && size != 1) {
            if (getResources().getBoolean(R.bool.config_allow_users_select_all_vcard_import)) {
                runOnUiThread(new d(R.id.dialog_select_import_type));
                return;
            } else {
                runOnUiThread(new d(R.id.dialog_select_one_vcard));
                return;
            }
        }
        K1(this.f17654A);
    }

    public void O1() {
        this.f17657D = new e();
        H7.b.e("VCardImport", "Bind com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel.tablayout VCardService.");
        startService(new Intent(this, (Class<?>) VCardService.class));
        bindService(new Intent(this, (Class<?>) VCardService.class), this.f17657D, 1);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 0) {
            if (i11 == -1) {
                try {
                    this.f17663x = new AccountWithDataSet(C7.e.l(intent, "account_name"), C7.e.l(intent, "account_type"), C7.e.l(intent, "data_set"));
                } catch (Exception e10) {
                    H7.b.c("VCardImport", "" + e10);
                }
                M1();
                return;
            }
            if (i11 != 0) {
                H7.b.i("VCardImport", "Result code was not OK nor CANCELED: " + i11);
            }
            finish();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        finish();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r0 = "VCardImport"
            r1 = 0
            if (r7 == 0) goto L3d
            java.lang.String r2 = "account_name"
            java.lang.String r2 = C7.e.l(r7, r2)     // Catch: java.lang.Exception -> L24
            java.lang.String r3 = "account_type"
            java.lang.String r3 = C7.e.l(r7, r3)     // Catch: java.lang.Exception -> L21
            java.lang.String r4 = "data_set"
            java.lang.String r7 = C7.e.l(r7, r4)     // Catch: java.lang.Exception -> L1f
            goto L45
        L1f:
            r7 = move-exception
            goto L27
        L21:
            r7 = move-exception
            r3 = r1
            goto L27
        L24:
            r7 = move-exception
            r2 = r1
            r3 = r2
        L27:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = ""
            r4.append(r5)
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            H7.b.c(r0, r7)
            r7 = r1
            goto L45
        L3d:
            java.lang.String r7 = "intent does not exist"
            H7.b.c(r0, r7)
            r7 = r1
            r2 = r7
            r3 = r2
        L45:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L59
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L59
            com.android.contacts.model.AccountWithDataSet r0 = new com.android.contacts.model.AccountWithDataSet
            r0.<init>(r2, r3, r7)
            r6.f17663x = r0
            goto L7a
        L59:
            n1.a r7 = n1.AbstractC1362a.h(r6)
            r0 = 1
            java.util.List r7 = r7.g(r0)
            int r2 = r7.size()
            if (r2 != 0) goto L6b
            r6.f17663x = r1
            goto L7a
        L6b:
            int r1 = r7.size()
            r2 = 0
            if (r1 != r0) goto L7e
            java.lang.Object r7 = r7.get(r2)
            com.android.contacts.model.AccountWithDataSet r7 = (com.android.contacts.model.AccountWithDataSet) r7
            r6.f17663x = r7
        L7a:
            r6.M1()
            return
        L7e:
            android.content.Intent r7 = new android.content.Intent
            java.lang.Class<com.android.contacts.vcard.SelectAccountActivity> r0 = com.android.contacts.vcard.SelectAccountActivity.class
            r7.<init>(r6, r0)
            Q7.b.b(r6, r7, r2, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.vcard.ImportVCardActivity.onCreate(android.os.Bundle):void");
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, android.app.Activity
    public Dialog onCreateDialog(int i10, Bundle bundle) {
        switch (i10) {
            case R.id.dialog_cache_vcard /* 2131427887 */:
                if (this.f17665z == null) {
                    String string = getString(R.string.caching_vcard_title);
                    String string2 = getString(R.string.caching_vcard_message);
                    ProgressDialog progressDialog = new ProgressDialog(this);
                    this.f17665z = progressDialog;
                    progressDialog.setTitle(string);
                    this.f17665z.setMessage(string2);
                    this.f17665z.setCanceledOnTouchOutside(false);
                    this.f17665z.setProgressStyle(0);
                    this.f17665z.setOnCancelListener(this.f17656C);
                    O1();
                }
                return this.f17665z;
            case R.id.dialog_error_with_message /* 2131427893 */:
                String str = this.f17658E;
                if (TextUtils.isEmpty(str)) {
                    H7.b.c("VCardImport", "Error message is null while com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel.preference must not.");
                    str = getString(R.string.fail_reason_unknown);
                }
                return new COUIAlertDialogBuilder(this).setTitle((CharSequence) getString(R.string.reading_vcard_failed_title)).setIconAttribute(android.R.attr.alertDialogIcon).setMessage(str).setOnCancelListener(this.f17660G).setPositiveButton(android.R.string.ok, this.f17660G).show();
            case R.id.dialog_io_exception /* 2131427896 */:
                return new COUIAlertDialogBuilder(this).setTitle(R.string.scanning_sdcard_failed_title).setIconAttribute(android.R.attr.alertDialogIcon).setMessage(getString(R.string.scanning_sdcard_failed_message, getString(R.string.fail_reason_io_error))).setOnCancelListener(this.f17660G).setPositiveButton(android.R.string.ok, this.f17660G).show();
            case R.id.dialog_vcard_not_found /* 2131427906 */:
                return new COUIAlertDialogBuilder(this).setTitle(R.string.scanning_sdcard_failed_title).setMessage((CharSequence) getString(R.string.import_failure_no_vcard_file)).setOnCancelListener(this.f17660G).setPositiveButton(android.R.string.ok, this.f17660G).show();
            case R.string.import_from_sdcard /* 2132018410 */:
                C0701b.c cVar = this.f17662r;
                if (cVar != null) {
                    return C0701b.e(this, i10, cVar, this.f17660G);
                }
                throw new NullPointerException("mAccountSelectionListener must not be null.");
            default:
                switch (i10) {
                    case R.id.dialog_sdcard_not_found /* 2131427900 */:
                        return new COUIAlertDialogBuilder(this).setTitle(R.string.no_sdcard_title).setIconAttribute(android.R.attr.alertDialogIcon).setMessage(R.string.no_sdcard_message).setOnCancelListener(this.f17660G).setPositiveButton(android.R.string.ok, this.f17660G).show();
                    case R.id.dialog_searching_vcard /* 2131427901 */:
                        if (this.f17664y == null) {
                            ProgressDialog show = ProgressDialog.show(this, getString(R.string.searching_vcard_title), getString(R.string.searching_vcard_message), true, false);
                            this.f17664y = show;
                            show.setOnCancelListener(this.f17655B);
                            this.f17664y.setCanceledOnTouchOutside(false);
                            this.f17655B.start();
                        }
                        return this.f17664y;
                    case R.id.dialog_select_import_type /* 2131427902 */:
                        return E1();
                    case R.id.dialog_select_multiple_vcard /* 2131427903 */:
                        return F1(true);
                    case R.id.dialog_select_one_vcard /* 2131427904 */:
                        return F1(false);
                    default:
                        return super.onCreateDialog(i10, bundle);
                }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (this.f17665z != null) {
            H7.b.e("VCardImport", "Cache thread is still running. Show progress dialog again.");
            showDialog(R.id.dialog_cache_vcard);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f17676a;

        public d(int i10) {
            this.f17676a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ImportVCardActivity.this.isFinishing()) {
                ImportVCardActivity.this.showDialog(this.f17676a);
            }
        }

        public d(String str) {
            this.f17676a = R.id.dialog_error_with_message;
            ImportVCardActivity.this.f17658E = str;
        }
    }

    /* loaded from: classes.dex */
    public class i implements DialogInterface.OnClickListener, DialogInterface.OnMultiChoiceClickListener {

        /* renamed from: a, reason: collision with root package name */
        public int f17692a = 0;

        /* renamed from: b, reason: collision with root package name */
        public Set<Integer> f17693b;

        public i(boolean z10) {
            if (z10) {
                this.f17693b = new HashSet();
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 != -1) {
                if (i10 == -2) {
                    ImportVCardActivity.this.finish();
                    return;
                }
                this.f17692a = i10;
                Set<Integer> set = this.f17693b;
                if (set != null) {
                    if (set.contains(Integer.valueOf(i10))) {
                        this.f17693b.remove(Integer.valueOf(i10));
                        return;
                    } else {
                        this.f17693b.add(Integer.valueOf(i10));
                        return;
                    }
                }
                return;
            }
            if (this.f17693b != null) {
                ArrayList arrayList = new ArrayList();
                int size = ImportVCardActivity.this.f17654A.size();
                for (int i11 = 0; i11 < size; i11++) {
                    if (this.f17693b.contains(Integer.valueOf(i11))) {
                        arrayList.add((h) ImportVCardActivity.this.f17654A.get(i11));
                    }
                }
                ImportVCardActivity.this.K1(arrayList);
                return;
            }
            ImportVCardActivity importVCardActivity = ImportVCardActivity.this;
            importVCardActivity.J1((h) importVCardActivity.f17654A.get(this.f17692a));
        }

        @Override // android.content.DialogInterface.OnMultiChoiceClickListener
        public void onClick(DialogInterface dialogInterface, int i10, boolean z10) {
            Set<Integer> set = this.f17693b;
            if (set != null && set.contains(Integer.valueOf(i10)) != z10) {
                onClick(dialogInterface, i10);
            } else {
                H7.b.c("VCardImport", String.format("Inconsist state com.coui.appcompat.dialog.chip.lockview.dialog.snackbar.panel.dialog.poplist.panel.dialog.reddot.edittext.cardview.poplist.picker.panel.slideview.touchhelper.tintimageview.unitconversionutil.list.couiswitch.searchview.indicator.animation.clickablespan.seekbar.uiutil.checkbox.lockview.progressbar.panel.picker.bottomnavigation.seekbar.progressbar.dialog.statelistutil.rotateview.menu.poplist.expandable.panel.dialog.soundloadutil.tablayout.seekbar.lockview.dialog.theme.math.tintimageview.roundRect.slideview.progressbar.edittext.theme.toolbar.edittext.version.bottomnavigation.statusbar.menu.floatingactionbutton.button.toolbar.textview.textviewcompatutil.progressbar.picker.bottomnavigation.slideview.panel.slideview.checklayout.statusbar.bottomnavigation.dialog.floatingactionbutton.dialog.picker.bottomnavigation.dialog.rippleutil.edittext.contextutil.preference.button.roundRect.tooltips.touchsearchview.textutil.searchview.seekbar.vibrateutil.grid.bottomnavigation.imageview.edittext.dialog.buttonBar.panel.toolbar.statement.panel.expandable.darkmode.tablayout.orientationutil.lockview.expandable.scroll.floatingactionbutton.reddot.scroll.roundRect.panel.tintimageview.bottomnavigation.dateutils.animation.progressbar.poplist.touchsearchview.panel.list.darkmode.statement.poplist.panel.tablayout.log.indicator.panel.lunarutil.poplist.tablayout.list.bottomnavigation.slideview.list.tintimageview.panel.picker.toolbar.hapticfeedback.poplist.bottomnavigation.tablayout.panel index %d (%s)", Integer.valueOf(i10), ((h) ImportVCardActivity.this.f17654A.get(i10)).a()));
            }
        }
    }
}
