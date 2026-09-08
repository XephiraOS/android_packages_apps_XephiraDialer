package com.android.contacts.vcard;

import android.content.ContentResolver;
import android.net.Uri;
import com.android.contacts.framework.vcard.VCardEntry;
import com.android.contacts.framework.vcard.exception.VCardException;
import com.android.contacts.framework.vcard.exception.VCardNotSupportedException;
import com.android.contacts.framework.vcard.exception.VCardVersionException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImportProcessor.java */
/* loaded from: classes.dex */
public class j extends q implements com.android.contacts.framework.vcard.k {

    /* renamed from: a, reason: collision with root package name */
    public final VCardService f17756a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f17757b;

    /* renamed from: c, reason: collision with root package name */
    public final k f17758c;

    /* renamed from: d, reason: collision with root package name */
    public final int f17759d;

    /* renamed from: e, reason: collision with root package name */
    public final s f17760e;

    /* renamed from: g, reason: collision with root package name */
    public com.android.contacts.framework.vcard.m f17762g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f17763h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f17764i;

    /* renamed from: f, reason: collision with root package name */
    public final List<Uri> f17761f = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public int f17765j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f17766k = 0;

    public j(VCardService vCardService, s sVar, k kVar, int i10) {
        this.f17756a = vCardService;
        this.f17757b = vCardService.getContentResolver();
        this.f17760e = sVar;
        this.f17758c = kVar;
        this.f17759d = i10;
    }

    @Override // com.android.contacts.vcard.q
    public final int a() {
        return 1;
    }

    public final boolean b(InputStream inputStream, int i10, String str, com.android.contacts.framework.vcard.l lVar, int[] iArr) {
        com.android.contacts.framework.vcard.m qVar;
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = iArr[i11];
            if (i11 > 0) {
                try {
                    try {
                        try {
                            if (lVar instanceof com.android.contacts.framework.vcard.i) {
                                ((com.android.contacts.framework.vcard.i) lVar).g();
                            }
                        } catch (VCardNotSupportedException e10) {
                            H7.b.c("VCardImport", e10.toString());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                        }
                    } catch (IOException e11) {
                        H7.b.c("VCardImport", "IOException was emitted: " + e11.getMessage());
                        if (inputStream == null) {
                        }
                        inputStream.close();
                    }
                } catch (VCardVersionException unused2) {
                    if (i11 == length - 1) {
                        H7.b.c("VCardImport", "Appropriate version for this vCard is not found.");
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (VCardException e12) {
                    try {
                        H7.b.c("VCardImport", e12.toString());
                        if (inputStream == null) {
                        }
                        inputStream.close();
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
            }
            synchronized (this) {
                try {
                    if (i12 == 2) {
                        qVar = new com.android.contacts.framework.vcard.r(i10);
                    } else {
                        qVar = new com.android.contacts.framework.vcard.q(i10);
                    }
                    this.f17762g = qVar;
                    if (isCancelled()) {
                        this.f17762g.b();
                    }
                } finally {
                }
            }
            this.f17762g.d(inputStream, lVar);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.vcard.j.c():void");
    }

    @Override // com.android.contacts.vcard.q, java.util.concurrent.Future
    public synchronized boolean cancel(boolean z10) {
        if (!this.f17764i && !this.f17763h) {
            this.f17763h = true;
            synchronized (this) {
                try {
                    com.android.contacts.framework.vcard.m mVar = this.f17762g;
                    if (mVar != null) {
                        mVar.b();
                    }
                } finally {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f17763h;
    }

    @Override // com.android.contacts.vcard.q, java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.f17764i;
    }

    @Override // com.android.contacts.framework.vcard.k
    public void onEntryCreated(VCardEntry vCardEntry) {
        int i10 = this.f17765j + 1;
        this.f17765j = i10;
        s sVar = this.f17760e;
        if (sVar != null) {
            sVar.f(this.f17758c, this.f17759d, vCardEntry, i10, this.f17766k);
        }
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        s sVar;
        try {
            try {
                c();
                if (isCancelled() && (sVar = this.f17760e) != null) {
                    sVar.A(this.f17758c, this.f17759d);
                }
                synchronized (this) {
                    this.f17764i = true;
                }
            } catch (OutOfMemoryError e10) {
                H7.b.c("VCardImport", "OutOfMemoryError thrown during import" + e10);
                throw e10;
            } catch (RuntimeException e11) {
                H7.b.c("VCardImport", "RuntimeException thrown during import" + e11);
                throw e11;
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.f17764i = true;
                throw th;
            }
        }
    }

    @Override // com.android.contacts.framework.vcard.k
    public void onEnd() {
    }

    @Override // com.android.contacts.framework.vcard.k
    public void onStart() {
    }
}
