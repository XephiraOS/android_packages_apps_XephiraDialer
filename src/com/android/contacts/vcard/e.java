package com.android.contacts.vcard;

import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import com.android.contacts.model.Account;
import com.oplus.dialer.R;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ExportProcessor.java */
/* loaded from: classes.dex */
public class e extends q {

    /* renamed from: l, reason: collision with root package name */
    public static int f17738l;

    /* renamed from: a, reason: collision with root package name */
    public final VCardService f17739a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f17740b;

    /* renamed from: c, reason: collision with root package name */
    public final NotificationManager f17741c;

    /* renamed from: d, reason: collision with root package name */
    public final f f17742d;

    /* renamed from: e, reason: collision with root package name */
    public final int f17743e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f17744f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f17745g;

    /* renamed from: h, reason: collision with root package name */
    public final Account f17746h;

    /* renamed from: i, reason: collision with root package name */
    public int f17747i;

    /* renamed from: j, reason: collision with root package name */
    public K3.a f17748j;

    /* renamed from: k, reason: collision with root package name */
    public final ExecutorService f17749k = Executors.newFixedThreadPool(2);

    public e(VCardService vCardService, f fVar, int i10, K3.a aVar) {
        this.f17748j = null;
        this.f17739a = vCardService;
        this.f17740b = vCardService.getContentResolver();
        this.f17741c = (NotificationManager) vCardService.getSystemService("notification");
        this.f17742d = fVar;
        this.f17743e = i10;
        this.f17746h = fVar.f17752c;
        this.f17748j = aVar;
    }

    @Override // com.android.contacts.vcard.q
    public final int a() {
        return 2;
    }

    public final String c() {
        if (111 == this.f17747i) {
            return null;
        }
        if (this.f17746h.d()) {
            return "account_type IS NULL AND account_name IS NULL";
        }
        return "account_type= ? AND account_name = ?";
    }

    @Override // com.android.contacts.vcard.q, java.util.concurrent.Future
    public synchronized boolean cancel(boolean z10) {
        H7.b.b("ExportProcessor", "received cancel request() mDone:" + this.f17745g + ", mCanceled:" + this.f17744f);
        if (!this.f17745g && !this.f17744f) {
            this.f17744f = true;
            return true;
        }
        return false;
    }

    public final String[] d() {
        if (111 == this.f17747i || this.f17746h.d()) {
            return null;
        }
        Account account = this.f17746h;
        return new String[]{account.f16942b, account.f16941a};
    }

    public f e() {
        return this.f17742d;
    }

    public final Uri f(Context context, Uri uri) {
        try {
            ContentValues contentValues = new ContentValues(7);
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("mime_type", "text/x-vcard");
            contentValues.put("title", uri.getLastPathSegment());
            contentValues.put("_display_name", uri.getLastPathSegment());
            contentValues.put("relative_path", "Documents/Backup");
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            contentValues.put("date_added", Long.valueOf(currentTimeMillis));
            contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
            Uri contentUri = MediaStore.Files.getContentUri("external");
            H7.b.b("ExportProcessor", "insertMediaDb providerUri : " + contentUri);
            Uri insert = context.getContentResolver().insert(contentUri, contentValues);
            H7.b.b("ExportProcessor", "insertMediaDb insertUri : " + insert);
            return insert;
        } catch (Exception e10) {
            H7.b.b("ExportProcessor", "insertMediaDb error : " + e10);
            return null;
        }
    }

    public boolean g(Account account) {
        if (this.f17739a.getString(R.string.oplus_account_name_as_all).equals(account.f16941a) && "com.oplus.contacts.all".equals(account.f16942b)) {
            return true;
        }
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 148
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public final /* synthetic */ void h(android.net.Uri r7, java.lang.StringBuilder r8, java.lang.StringBuilder r9, int r10, com.android.contacts.framework.vcard.d r11, java.lang.StringBuilder r12, java.util.concurrent.CountDownLatch r13) {
        /*
            r6 = this;
            android.content.ContentResolver r0 = r6.f17740b
            java.lang.String[] r2 = com.android.contacts.framework.vcard.d.b.f16519a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "contact_id IN ("
            r1.append(r3)
            java.lang.String r8 = r8.toString()
            r1.append(r8)
            java.lang.String r8 = ")"
            r1.append(r8)
            int r8 = r9.length()
            if (r8 != 0) goto L23
            java.lang.String r8 = ""
            goto L34
        L23:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r3 = " AND "
            r8.append(r3)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
        L34:
            r1.append(r8)
            java.lang.String r3 = r1.toString()
            java.lang.String[] r4 = r6.d()
            java.lang.String r5 = "contact_id , _id"
            r1 = r7
            android.database.Cursor r7 = G7.c.e(r0, r1, r2, r3, r4, r5)
            if (r7 != 0) goto L49
            return
        L49:
            int r8 = r7.getCount()
            int r8 = r8 / 2
            r9 = 1
            if (r10 != r9) goto L56
            r7.moveToFirst()
            goto L73
        L56:
            int r8 = r8 + (-1)
            r7.moveToPosition(r8)
            int r8 = r7.getCount()
            r10 = 13
            long r0 = r7.getLong(r10)
        L65:
            boolean r2 = r7.moveToNext()
            if (r2 == 0) goto L73
            long r2 = r7.getLong(r10)
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 == 0) goto L65
        L73:
            boolean r10 = r11.q()
            if (r10 != 0) goto Lb7
            int r10 = r7.getPosition()
            if (r10 < r8) goto L80
            goto Lb7
        L80:
            boolean r10 = r6.isCancelled()
            java.lang.String r0 = "ExportProcessor"
            if (r10 == 0) goto L8e
            java.lang.String r6 = "Export request is cancelled during composing vCard"
            H7.b.e(r0, r6)
            goto Lb7
        L8e:
            r10 = 0
            java.lang.String r1 = r11.e(r7, r10)     // Catch: java.lang.Exception -> Laa
            r12.append(r1)     // Catch: java.lang.Exception -> Laa
            int r10 = com.android.contacts.vcard.e.f17738l
            int r10 = r10 + r9
            com.android.contacts.vcard.e.f17738l = r10
            K3.a r0 = r6.f17748j
            if (r0 == 0) goto L73
            int r1 = r10 % 50
            if (r1 == 0) goto La5
            if (r10 != r8) goto L73
        La5:
            r1 = 0
            r0.g(r1, r10)
            goto L73
        Laa:
            java.lang.String r7 = "Failed to read contact: Failed to get database information"
            H7.b.c(r0, r7)
            K3.a r6 = r6.f17748j
            if (r6 == 0) goto Lb6
            r6.d(r10, r10)
        Lb6:
            return
        Lb7:
            java.lang.AutoCloseable[] r6 = new java.lang.AutoCloseable[]{r7}
            com.oplus.foundation.util.io.CloseableUtils.a(r6)
            r13.countDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.vcard.e.h(android.net.Uri, java.lang.StringBuilder, java.lang.StringBuilder, int, com.android.contacts.framework.vcard.d, java.lang.StringBuilder, java.util.concurrent.CountDownLatch):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x05e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x061f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 1611
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.vcard.e.i():void");
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f17744f;
    }

    @Override // com.android.contacts.vcard.q, java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.f17745g;
    }

    public final void j() {
        Account account = this.f17746h;
        if (account != null && !g(account)) {
            if (M3.c.t(this.f17746h)) {
                this.f17747i = 222;
                return;
            } else {
                this.f17747i = 333;
                return;
            }
        }
        this.f17747i = 111;
    }

    public final void k(final Uri uri, final StringBuilder sb, final StringBuilder sb2, final com.android.contacts.framework.vcard.d dVar, final int i10, final StringBuilder sb3, final CountDownLatch countDownLatch, ExecutorService executorService) {
        executorService.execute(new Runnable() { // from class: com.android.contacts.vcard.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.h(uri, sb, sb2, i10, dVar, sb3, countDownLatch);
            }
        });
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        K3.a aVar;
        try {
            try {
                j();
                Z3.c.a(this.f17739a);
                i();
                if (isCancelled() && (aVar = this.f17748j) != null) {
                    aVar.b(0);
                }
                synchronized (this) {
                    this.f17745g = true;
                    Z3.c.b();
                }
            } catch (OutOfMemoryError e10) {
                H7.b.c("ExportProcessor", "OutOfMemoryError thrown during import" + e10);
                throw e10;
            } catch (RuntimeException e11) {
                H7.b.c("ExportProcessor", "RuntimeException thrown during export" + e11);
                throw e11;
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.f17745g = true;
                Z3.c.b();
                throw th;
            }
        }
    }
}
