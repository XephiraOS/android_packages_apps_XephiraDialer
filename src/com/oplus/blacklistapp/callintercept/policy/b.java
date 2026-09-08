package com.oplus.blacklistapp.callintercept.policy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import v6.C1627a;

/* compiled from: ContactsAsyncHelper.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static Handler f26650b;

    /* renamed from: c, reason: collision with root package name */
    public static b f26651c = new b();

    /* renamed from: a, reason: collision with root package name */
    public final Handler f26652a = new a();

    /* compiled from: ContactsAsyncHelper.java */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = (c) message.obj;
            if (message.arg1 == 1 && cVar.f26659f != null) {
                C1627a.a(this, "Notifying listener: " + cVar.f26659f.toString() + " image: " + cVar.f26655b + " completed");
                cVar.f26659f.onImageLoadComplete(message.what, cVar.f26656c, cVar.f26657d, cVar.f26658e);
            }
        }
    }

    /* compiled from: ContactsAsyncHelper.java */
    /* renamed from: com.oplus.blacklistapp.callintercept.policy.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0240b {
        void onImageLoadComplete(int i10, Drawable drawable, Bitmap bitmap, Object obj);
    }

    /* compiled from: ContactsAsyncHelper.java */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public Context f26654a;

        /* renamed from: b, reason: collision with root package name */
        public Uri f26655b;

        /* renamed from: c, reason: collision with root package name */
        public Drawable f26656c;

        /* renamed from: d, reason: collision with root package name */
        public Bitmap f26657d;

        /* renamed from: e, reason: collision with root package name */
        public Object f26658e;

        /* renamed from: f, reason: collision with root package name */
        public InterfaceC0240b f26659f;

        public c() {
        }
    }

    /* compiled from: ContactsAsyncHelper.java */
    /* loaded from: classes3.dex */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleMessage(android.os.Message r9) {
            /*
                r8 = this;
                java.lang.String r0 = "Unable to close input stream."
                java.lang.Object r1 = r9.obj
                com.oplus.blacklistapp.callintercept.policy.b$c r1 = (com.oplus.blacklistapp.callintercept.policy.b.c) r1
                int r2 = r9.arg1
                r3 = 1
                if (r2 == r3) goto Ld
                goto Lbc
            Ld:
                r2 = 0
                android.content.Context r3 = r1.f26654a     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1e
                android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1e
                android.net.Uri r4 = r1.f26655b     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1e
                java.io.InputStream r3 = r3.openInputStream(r4)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L1e
                goto L34
            L1b:
                r9 = move-exception
                goto Ld4
            L1e:
                r3 = move-exception
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b
                r4.<init>()     // Catch: java.lang.Throwable -> L1b
                java.lang.String r5 = "Error opening photo input stream"
                r4.append(r5)     // Catch: java.lang.Throwable -> L1b
                r4.append(r3)     // Catch: java.lang.Throwable -> L1b
                java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L1b
                v6.C1627a.g(r8, r3)     // Catch: java.lang.Throwable -> L1b
                r3 = r2
            L34:
                java.lang.String r4 = " image URI: "
                java.lang.String r5 = " token: "
                if (r3 == 0) goto L72
                android.net.Uri r2 = r1.f26655b     // Catch: java.lang.Throwable -> L6f
                java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L6f
                android.graphics.drawable.Drawable r2 = android.graphics.drawable.Drawable.createFromStream(r3, r2)     // Catch: java.lang.Throwable -> L6f
                r1.f26656c = r2     // Catch: java.lang.Throwable -> L6f
                com.oplus.blacklistapp.callintercept.policy.b r2 = com.oplus.blacklistapp.callintercept.policy.b.this     // Catch: java.lang.Throwable -> L6f
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f
                r6.<init>()     // Catch: java.lang.Throwable -> L6f
                java.lang.String r7 = "Loading image: "
                r6.append(r7)     // Catch: java.lang.Throwable -> L6f
                int r7 = r9.arg1     // Catch: java.lang.Throwable -> L6f
                r6.append(r7)     // Catch: java.lang.Throwable -> L6f
                r6.append(r5)     // Catch: java.lang.Throwable -> L6f
                int r5 = r9.what     // Catch: java.lang.Throwable -> L6f
                r6.append(r5)     // Catch: java.lang.Throwable -> L6f
                r6.append(r4)     // Catch: java.lang.Throwable -> L6f
                android.net.Uri r1 = r1.f26655b     // Catch: java.lang.Throwable -> L6f
                r6.append(r1)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> L6f
                v6.C1627a.a(r2, r1)     // Catch: java.lang.Throwable -> L6f
                goto La3
            L6f:
                r9 = move-exception
                r2 = r3
                goto Ld4
            L72:
                r1.f26656c = r2     // Catch: java.lang.Throwable -> L6f
                r1.f26657d = r2     // Catch: java.lang.Throwable -> L6f
                com.oplus.blacklistapp.callintercept.policy.b r2 = com.oplus.blacklistapp.callintercept.policy.b.this     // Catch: java.lang.Throwable -> L6f
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f
                r6.<init>()     // Catch: java.lang.Throwable -> L6f
                java.lang.String r7 = "Problem with image: "
                r6.append(r7)     // Catch: java.lang.Throwable -> L6f
                int r7 = r9.arg1     // Catch: java.lang.Throwable -> L6f
                r6.append(r7)     // Catch: java.lang.Throwable -> L6f
                r6.append(r5)     // Catch: java.lang.Throwable -> L6f
                int r5 = r9.what     // Catch: java.lang.Throwable -> L6f
                r6.append(r5)     // Catch: java.lang.Throwable -> L6f
                r6.append(r4)     // Catch: java.lang.Throwable -> L6f
                android.net.Uri r1 = r1.f26655b     // Catch: java.lang.Throwable -> L6f
                r6.append(r1)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r1 = ", using default image."
                r6.append(r1)     // Catch: java.lang.Throwable -> L6f
                java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> L6f
                v6.C1627a.a(r2, r1)     // Catch: java.lang.Throwable -> L6f
            La3:
                if (r3 == 0) goto Lbc
                r3.close()     // Catch: java.io.IOException -> La9
                goto Lbc
            La9:
                r1 = move-exception
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r0)
                r2.append(r1)
                java.lang.String r0 = r2.toString()
                v6.C1627a.g(r8, r0)
            Lbc:
                com.oplus.blacklistapp.callintercept.policy.b r8 = com.oplus.blacklistapp.callintercept.policy.b.this
                android.os.Handler r8 = com.oplus.blacklistapp.callintercept.policy.b.a(r8)
                int r0 = r9.what
                android.os.Message r8 = r8.obtainMessage(r0)
                int r0 = r9.arg1
                r8.arg1 = r0
                java.lang.Object r9 = r9.obj
                r8.obj = r9
                r8.sendToTarget()
                return
            Ld4:
                if (r2 == 0) goto Led
                r2.close()     // Catch: java.io.IOException -> Lda
                goto Led
            Lda:
                r1 = move-exception
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r0)
                r2.append(r1)
                java.lang.String r0 = r2.toString()
                v6.C1627a.g(r8, r0)
            Led:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.policy.b.d.handleMessage(android.os.Message):void");
        }
    }

    public b() {
        HandlerThread handlerThread = new HandlerThread("ContactsAsyncWorker");
        handlerThread.start();
        f26650b = new d(handlerThread.getLooper());
    }

    public static final void b(int i10, Context context, Uri uri, InterfaceC0240b interfaceC0240b, Object obj) {
        if (uri == null) {
            C1627a.r("startObjectPhotoAsync", "Uri is missing");
            return;
        }
        c cVar = new c();
        cVar.f26658e = obj;
        cVar.f26654a = context;
        cVar.f26655b = uri;
        cVar.f26659f = interfaceC0240b;
        Message obtainMessage = f26650b.obtainMessage(i10);
        obtainMessage.arg1 = 1;
        obtainMessage.obj = cVar;
        C1627a.c("startObjectPhotoAsync", "Begin loading image: " + cVar.f26655b + ", displaying default image for now.");
        f26650b.sendMessage(obtainMessage);
    }
}
