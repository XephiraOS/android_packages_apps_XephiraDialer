package com.customize.contacts.importcontact;

import android.content.Context;
import com.android.contacts.framework.vcard.exception.VCardException;
import com.android.contacts.framework.vcard.exception.VCardNotSupportedException;
import com.android.contacts.framework.vcard.exception.VCardVersionException;
import com.android.contacts.framework.vcard.r;
import com.android.contacts.model.Account;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: VcardImportRunnable.java */
/* loaded from: classes3.dex */
public class q extends c {

    /* renamed from: i, reason: collision with root package name */
    public boolean f21444i;

    /* renamed from: j, reason: collision with root package name */
    public com.android.contacts.framework.vcard.m f21445j;

    /* renamed from: k, reason: collision with root package name */
    public com.android.contacts.framework.vcard.h f21446k;

    public q(Context context, String str, Account account) {
        super(context, str, account);
        this.f21444i = false;
    }

    @Override // com.customize.contacts.importcontact.c
    public void d() {
        k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x016b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x016c  */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.customize.contacts.importcontact.c, com.customize.contacts.importcontact.q] */
    /* JADX WARN: Type inference failed for: r5v28, types: [com.android.contacts.framework.vcard.m] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:176:0x00b5 -> B:128:0x0142). Please report as a decompilation issue!!! */
    @Override // com.customize.contacts.importcontact.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int f() {
        /*
            Method dump skipped, instructions count: 491
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.importcontact.q.f():int");
    }

    @Override // com.customize.contacts.importcontact.c
    public void g(boolean z10) {
        super.g(z10);
        com.android.contacts.framework.vcard.h hVar = this.f21446k;
        if (hVar instanceof o) {
            ((o) hVar).setIsBackground(z10);
        }
    }

    public final com.android.contacts.framework.vcard.h i() {
        o oVar = new o(this.f21410b);
        if (this.f21415g) {
            oVar.onCancel();
        }
        oVar.setIsBackground(e());
        oVar.setImportListener(this);
        return oVar;
    }

    public final boolean j(InputStream inputStream, int i10, String str, com.android.contacts.framework.vcard.l lVar, int[] iArr) {
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
                            H7.b.c("VcardImportRunnable", e10.toString());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                        }
                    } catch (IOException e11) {
                        H7.b.c("VcardImportRunnable", "IOException was emitted: " + e11.getMessage());
                        if (inputStream == null) {
                        }
                        inputStream.close();
                    }
                } catch (VCardVersionException unused2) {
                    if (i11 == length - 1) {
                        H7.b.c("VcardImportRunnable", "Appropriate version for this vCard is not found.");
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (VCardException e12) {
                    try {
                        H7.b.c("VcardImportRunnable", e12.toString());
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
                        qVar = new r(i10);
                    } else {
                        qVar = new com.android.contacts.framework.vcard.q(i10);
                    }
                    this.f21445j = qVar;
                    if (this.f21415g) {
                        if (H7.a.b()) {
                            H7.b.b("VcardImportRunnable", "ImportProcessor already recieves cancel request, so send cancel request to vCard parser too.");
                        }
                        this.f21445j.b();
                    }
                } finally {
                }
            }
            this.f21445j.d(inputStream, lVar);
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

    public void k() {
        this.f21415g = true;
        com.android.contacts.framework.vcard.m mVar = this.f21445j;
        if (mVar != null) {
            mVar.b();
        }
    }

    public q(Context context, String str, Account account, boolean z10) {
        super(context, str, account);
        this.f21444i = z10;
    }
}
