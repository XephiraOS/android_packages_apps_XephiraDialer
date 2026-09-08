package S3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.vcard.r;
import com.android.contacts.framework.vcard.s;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.dialer.R;

/* compiled from: ContactsInfoHandler.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public Activity f3445a;

    /* renamed from: e, reason: collision with root package name */
    public String f3449e;

    /* renamed from: c, reason: collision with root package name */
    public m f3447c = new m();

    /* renamed from: d, reason: collision with root package name */
    public h f3448d = new h();

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f3450f = false;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f3446b = new Handler(Looper.getMainLooper());

    /* compiled from: ContactsInfoHandler.java */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.appcompat.app.b f3451a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f3452b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f3453c;

        public a(androidx.appcompat.app.b bVar, boolean z10, boolean z11) {
            this.f3451a = bVar;
            this.f3452b = z10;
            this.f3453c = z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.appcompat.app.b bVar = this.f3451a;
            if (bVar != null && this.f3452b) {
                bVar.dismiss();
            }
            if (this.f3453c) {
                d dVar = d.this;
                dVar.k(dVar.f3449e);
            }
        }
    }

    public d(Activity activity) {
        this.f3445a = activity;
        this.f3449e = activity.getString(R.string.illegal_qrcode_tips);
    }

    public static R3.b i(String str) {
        return R3.b.m(str);
    }

    public static String j(String str) {
        String replaceAll = str.replaceAll("\t|\r|\n", "");
        if (replaceAll.contains("MECARD:")) {
            String replaceAll2 = replaceAll.replaceAll("^\\s*(?=MECARD)", "");
            replaceAll = replaceAll2.substring(replaceAll2.indexOf("MECARD:"));
        }
        String substring = replaceAll.substring(0, replaceAll.lastIndexOf(Constants.DataMigration.SPLIT_TAG));
        if (substring.endsWith(Constants.DataMigration.SPLIT_TAG)) {
            return substring;
        }
        return replaceAll;
    }

    public Handler a() {
        return this.f3446b;
    }

    public final com.android.contacts.framework.vcard.m b(String str) {
        if (str.contains("VERSION:2.1")) {
            return new com.android.contacts.framework.vcard.q();
        }
        if (str.contains("VERSION:3.0")) {
            return new r();
        }
        if (str.contains("VERSION:4.0")) {
            return new s();
        }
        return null;
    }

    public void c(String str, androidx.appcompat.app.b bVar) {
        this.f3450f = true;
        Bitmap b10 = m.b(str);
        if (b10 == null) {
            H7.b.b("ContactsInfoHandler", "handleAlbumQrcode bitmap is null");
            e(bVar, false, true);
            this.f3450f = false;
            return;
        }
        String c10 = this.f3447c.c(b10);
        H7.b.g("ContactsInfoHandler", "handleAlbumQrcode content  =" + c10);
        if (c10 == null) {
            H7.b.b("ContactsInfoHandler", "handleAlbumQrcode recogQRcode(bitmap) return  is null");
            e(bVar, true, true);
            this.f3450f = false;
        } else if (c10.contains("MECARD:")) {
            f(c10, bVar);
        } else if (c10.contains(":VCARD")) {
            h(c10, bVar);
        } else {
            g(c10, bVar);
        }
    }

    public boolean d(byte[] bArr, int i10, int i11) {
        this.f3450f = true;
        String d10 = this.f3447c.d(bArr, i10, i11);
        H7.b.g("ContactsInfoHandler", "handlePreviewFrameQrcode content  =" + d10);
        if (d10 == null) {
            H7.b.b("ContactsInfoHandler", "handlePreviewFrameQrcode  return  is null");
            this.f3450f = false;
            return false;
        }
        if (d10.contains("MECARD:")) {
            return f(d10, null);
        }
        if (d10.contains(":VCARD")) {
            return h(d10, null);
        }
        g(d10, null);
        return false;
    }

    public final void e(androidx.appcompat.app.b bVar, boolean z10, boolean z11) {
        this.f3446b.post(new a(bVar, z11, z10));
    }

    public final boolean f(String str, androidx.appcompat.app.b bVar) {
        H7.b.b("ContactsInfoHandler", "handleMecard");
        R3.b i10 = i(j(str));
        if (i10 == null) {
            H7.b.b("ContactsInfoHandler", "parseMecard parseContent return null");
            e(bVar, true, true);
            this.f3450f = false;
            return false;
        }
        e(bVar, false, true);
        this.f3448d.e(i10, this.f3445a, a());
        A.a(this.f3445a, 2000324, 200032403, null, false);
        this.f3450f = false;
        return true;
    }

    public final void g(String str, androidx.appcompat.app.b bVar) {
        H7.b.b("ContactsInfoHandler", "handleOtherContent");
        e(bVar, true, true);
        this.f3450f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(java.lang.String r8, androidx.appcompat.app.b r9) {
        /*
            r7 = this;
            java.lang.String r0 = "e="
            java.lang.String r1 = "parseVcard"
            java.lang.String r2 = "ContactsInfoHandler"
            H7.b.b(r2, r1)
            r1 = 0
            r3 = 0
            com.android.contacts.framework.vcard.m r4 = r7.b(r8)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            S3.q r5 = new S3.q     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r5.<init>()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            if (r4 != 0) goto L17
            return r1
        L17:
            r4.a(r5)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            byte[] r8 = r8.getBytes()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r4.c(r6)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            com.android.contacts.framework.vcard.VCardEntry r8 = r5.f()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L46
            r6.close()     // Catch: java.io.IOException -> L2e
            goto L7b
        L2e:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            r5.append(r4)
            java.lang.String r0 = r5.toString()
            H7.b.c(r2, r0)
            goto L7b
        L42:
            r7 = move-exception
            r3 = r6
            goto Lc2
        L46:
            r8 = move-exception
            goto L4d
        L48:
            r7 = move-exception
            goto Lc2
        L4b:
            r8 = move-exception
            r6 = r3
        L4d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
            r4.<init>()     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = "e ="
            r4.append(r5)     // Catch: java.lang.Throwable -> L42
            r4.append(r8)     // Catch: java.lang.Throwable -> L42
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L42
            H7.b.c(r2, r8)     // Catch: java.lang.Throwable -> L42
            if (r6 == 0) goto L7a
            r6.close()     // Catch: java.io.IOException -> L67
            goto L7a
        L67:
            r8 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            H7.b.c(r2, r8)
        L7a:
            r8 = r3
        L7b:
            if (r8 != 0) goto L80
            java.lang.String r0 = "null"
            goto L84
        L80:
            java.lang.String r0 = r8.toString()
        L84:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "cardContent ="
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            H7.b.g(r2, r0)
            r0 = 1
            if (r8 != 0) goto La6
            java.lang.String r8 = "parseVcard parseContent return null"
            H7.b.b(r2, r8)
            r7.e(r9, r0, r0)
            r7.f3450f = r1
            return r1
        La6:
            r7.e(r9, r1, r0)
            S3.h r9 = r7.f3448d
            android.app.Activity r2 = r7.f3445a
            android.os.Handler r4 = r7.a()
            r9.f(r8, r2, r4)
            android.app.Activity r8 = r7.f3445a
            r9 = 2000324(0x1e85c4, float:2.803051E-39)
            r2 = 200032403(0xbec4093, float:9.1001054E-32)
            com.android.contacts.framework.baseui.util.A.a(r8, r9, r2, r3, r1)
            r7.f3450f = r1
            return r0
        Lc2:
            if (r3 == 0) goto Ldb
            r3.close()     // Catch: java.io.IOException -> Lc8
            goto Ldb
        Lc8:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            H7.b.c(r2, r8)
        Ldb:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: S3.d.h(java.lang.String, androidx.appcompat.app.b):boolean");
    }

    public void k(String str) {
        com.oplus.foundation.util.ui.c.e(this.f3445a, str);
    }
}
