package com.customize.contacts.util;

import R0.d;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MergeCursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.android.contacts.ContactsApplication;
import com.customize.contacts.util.HandlerC0795f;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: AsyncQueryHandler.java */
/* renamed from: com.customize.contacts.util.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class HandlerC0795f extends Handler {

    /* renamed from: e, reason: collision with root package name */
    public static Looper f22100e;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<ContentResolver> f22101a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f22102b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f22103c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f22104d = false;

    /* compiled from: AsyncQueryHandler.java */
    /* renamed from: com.customize.contacts.util.f$a */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public Uri f22105a;

        /* renamed from: b, reason: collision with root package name */
        public Handler f22106b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f22107c;

        /* renamed from: d, reason: collision with root package name */
        public String f22108d;

        /* renamed from: e, reason: collision with root package name */
        public String[] f22109e;

        /* renamed from: f, reason: collision with root package name */
        public String f22110f;

        /* renamed from: g, reason: collision with root package name */
        public Object f22111g;

        /* renamed from: h, reason: collision with root package name */
        public Object f22112h;

        /* renamed from: i, reason: collision with root package name */
        public ContentValues f22113i;
    }

    /* compiled from: AsyncQueryHandler.java */
    /* renamed from: com.customize.contacts.util.f$b */
    /* loaded from: classes3.dex */
    public class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public HashMap<String, String> f22114a;

        /* compiled from: AsyncQueryHandler.java */
        /* renamed from: com.customize.contacts.util.f$b$a */
        /* loaded from: classes3.dex */
        public class a extends MergeCursor {
            public a(Cursor[] cursorArr) {
                super(cursorArr);
            }
        }

        /* compiled from: AsyncQueryHandler.java */
        /* renamed from: com.customize.contacts.util.f$b$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0206b extends MergeCursor {
            public C0206b(Cursor[] cursorArr) {
                super(cursorArr);
            }
        }

        /* compiled from: AsyncQueryHandler.java */
        /* renamed from: com.customize.contacts.util.f$b$c */
        /* loaded from: classes3.dex */
        public class c extends MergeCursor {
            public c(Cursor[] cursorArr) {
                super(cursorArr);
            }
        }

        public b(Looper looper) {
            super(looper);
            this.f22114a = new HashMap<>();
        }

        public static /* synthetic */ void g(Cursor cursor) {
            if (cursor != null) {
                cursor.close();
            }
        }

        public final void b(String str, long j10) {
            if (this.f22114a == null) {
                this.f22114a = new HashMap<>();
            }
            this.f22114a.clear();
            this.f22114a.put("search_contacts_time", String.valueOf(System.currentTimeMillis() - j10));
            HashMap<String, String> hashMap = this.f22114a;
            if (str == null) {
                str = "";
            }
            hashMap.put("search_contacts_params", str);
            com.android.contacts.framework.baseui.util.A.a(ContactsApplication.h(), 2000303, 200030303, this.f22114a, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v0, types: [com.customize.contacts.util.f$b] */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v11, types: [android.database.Cursor] */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r9v22, types: [android.database.Cursor] */
        /* JADX WARN: Type inference failed for: r9v3, types: [android.database.Cursor] */
        public final void c(a aVar) {
            String[] strArr;
            String[] strArr2;
            if (aVar.f22105a.equals(R0.d.f3227n)) {
                try {
                    try {
                        this = HandlerC0795f.this.f22101a.get().query(R0.d.f3226m, R0.b.a(), null, null, null);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        int count = this.getCount();
                        if (count > 0) {
                            this.moveToPosition(-1);
                            strArr2 = new String[count * 6];
                            for (int i10 = 0; i10 < count; i10++) {
                                try {
                                    if (!this.moveToNext()) {
                                        break;
                                    }
                                    int i11 = i10 * 6;
                                    strArr2[i11] = this.getString(0);
                                    strArr2[i11 + 1] = this.getString(1);
                                    strArr2[i11 + 2] = this.getString(2);
                                    strArr2[i11 + 3] = this.getString(3);
                                    strArr2[i11 + 4] = this.getString(4);
                                    strArr2[i11 + 5] = this.getString(5);
                                } catch (Exception e10) {
                                    e = e10;
                                    H7.b.c("AsyncQuery", "handleMessage ALL_PHONES_URI error" + e);
                                    if (this != 0) {
                                        this.close();
                                    }
                                    if (TextUtils.isEmpty(aVar.f22108d)) {
                                        aVar.f22105a = R0.d.f3227n;
                                    } else {
                                        aVar.f22105a = R0.d.f3227n.buildUpon().appendQueryParameter("areano", aVar.f22108d).build();
                                    }
                                    aVar.f22108d = null;
                                    aVar.f22109e = strArr2;
                                    return;
                                }
                            }
                        } else {
                            strArr2 = null;
                        }
                        this.close();
                        if (TextUtils.isEmpty(aVar.f22108d)) {
                            aVar.f22105a = R0.d.f3227n;
                        } else {
                            aVar.f22105a = R0.d.f3227n.buildUpon().appendQueryParameter("areano", aVar.f22108d).build();
                        }
                        aVar.f22108d = null;
                        aVar.f22109e = strArr2;
                    } catch (Exception e11) {
                        e = e11;
                        strArr2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        strArr = null;
                        if (this != 0) {
                            this.close();
                        }
                        if (TextUtils.isEmpty(aVar.f22108d)) {
                            aVar.f22105a = R0.d.f3227n;
                        } else {
                            aVar.f22105a = R0.d.f3227n.buildUpon().appendQueryParameter("areano", aVar.f22108d).build();
                        }
                        aVar.f22108d = null;
                        aVar.f22109e = strArr;
                        throw th;
                    }
                } catch (Exception e12) {
                    e = e12;
                    this = 0;
                    strArr2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    this = 0;
                    strArr = null;
                }
            }
        }

        public final void d(final Cursor cursor) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.customize.contacts.util.g
                @Override // java.lang.Runnable
                public final void run() {
                    HandlerC0795f.b.g(cursor);
                }
            });
        }

        public final Cursor e(ContentResolver contentResolver, a aVar) {
            String str;
            String f10;
            if (aVar.f22105a.getPathSegments().size() > 2) {
                str = aVar.f22105a.getLastPathSegment();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri withAppendedPath = Uri.withAppendedPath(d.a.f3236e, str);
            String str2 = aVar.f22108d;
            if (!TextUtils.isEmpty(str2)) {
                f10 = "(" + C0801l.f() + ") AND (" + str2 + ")";
            } else {
                f10 = C0801l.f();
            }
            return contentResolver.query(withAppendedPath, aVar.f22107c, f10, aVar.f22109e, aVar.f22110f);
        }

        public final Cursor f(ContentResolver contentResolver, a aVar) {
            String str;
            Uri withAppendedPath;
            if (aVar.f22105a.getPathSegments().size() > 2) {
                str = aVar.f22105a.getLastPathSegment();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (aVar.f22105a.toString().contains(d.a.f3233b.toString())) {
                withAppendedPath = Uri.withAppendedPath(d.a.f3235d, str);
            } else {
                withAppendedPath = Uri.withAppendedPath(d.a.f3234c, str);
            }
            return contentResolver.query(withAppendedPath, aVar.f22107c, aVar.f22108d, aVar.f22109e, aVar.f22110f);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00c4 A[Catch: Exception -> 0x011f, TRY_LEAVE, TryCatch #0 {Exception -> 0x011f, blocks: (B:16:0x0051, B:19:0x0059, B:26:0x0089, B:29:0x00a9, B:30:0x00b7, B:32:0x00c4), top: B:15:0x0051 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x012d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x012e A[Catch: Exception -> 0x00eb, TryCatch #1 {Exception -> 0x00eb, blocks: (B:34:0x00de, B:36:0x00e4, B:37:0x00f2, B:39:0x00f7, B:41:0x011b, B:46:0x012e, B:48:0x0134, B:50:0x0143, B:51:0x0148, B:53:0x0150, B:55:0x0174, B:58:0x0178, B:60:0x01a3, B:87:0x01ab), top: B:17:0x0057 }] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0123  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleMessage(android.os.Message r21) {
            /*
                Method dump skipped, instructions count: 478
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.HandlerC0795f.b.handleMessage(android.os.Message):void");
        }
    }

    public HandlerC0795f(ContentResolver contentResolver) {
        this.f22101a = new WeakReference<>(contentResolver);
        synchronized (HandlerC0795f.class) {
            try {
                if (f22100e == null) {
                    HandlerThread handlerThread = new HandlerThread("AsyncQueryWorker");
                    handlerThread.start();
                    f22100e = handlerThread.getLooper();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f22102b = d(f22100e);
    }

    public final void c(int i10) {
        this.f22102b.removeMessages(i10);
    }

    public Handler d(Looper looper) {
        return new b(looper);
    }

    public void g(boolean z10) {
        this.f22103c = z10;
    }

    public void h(boolean z10) {
        this.f22104d = z10;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = (a) message.obj;
        int i10 = message.what;
        int i11 = message.arg1;
        if (i11 != 1) {
            if (i11 == 3) {
                f(i10, aVar.f22112h, ((Integer) aVar.f22111g).intValue());
                return;
            }
            return;
        }
        e(i10, aVar.f22112h, (Cursor) aVar.f22111g);
    }

    public void i(int i10, Object obj, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Message obtainMessage = this.f22102b.obtainMessage(i10);
        obtainMessage.arg1 = 1;
        a aVar = new a();
        aVar.f22106b = this;
        aVar.f22105a = uri;
        aVar.f22107c = strArr;
        aVar.f22108d = str;
        aVar.f22109e = strArr2;
        aVar.f22110f = str2;
        aVar.f22112h = obj;
        obtainMessage.obj = aVar;
        this.f22102b.sendMessage(obtainMessage);
    }

    public final void j(int i10, Object obj, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Message obtainMessage = this.f22102b.obtainMessage(i10);
        obtainMessage.arg1 = 3;
        a aVar = new a();
        aVar.f22106b = this;
        aVar.f22105a = uri;
        aVar.f22112h = obj;
        aVar.f22113i = contentValues;
        aVar.f22108d = str;
        aVar.f22109e = strArr;
        obtainMessage.obj = aVar;
        this.f22102b.sendMessage(obtainMessage);
    }

    public void e(int i10, Object obj, Cursor cursor) {
    }

    public void f(int i10, Object obj, int i11) {
    }
}
