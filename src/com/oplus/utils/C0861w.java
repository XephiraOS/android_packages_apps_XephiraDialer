package com.oplus.utils;

import android.content.Context;
import android.media.SoundPool;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

/* compiled from: GlobalSoundManager.java */
/* renamed from: com.oplus.utils.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0861w {

    /* renamed from: i, reason: collision with root package name */
    public static volatile C0861w f29194i;

    /* renamed from: a, reason: collision with root package name */
    public U f29195a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f29196b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f29197c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f29198d = false;

    /* renamed from: e, reason: collision with root package name */
    public final Context f29199e;

    /* renamed from: f, reason: collision with root package name */
    public final b f29200f;

    /* renamed from: g, reason: collision with root package name */
    public final HandlerThread f29201g;

    /* renamed from: h, reason: collision with root package name */
    public Y f29202h;

    /* compiled from: GlobalSoundManager.java */
    /* renamed from: com.oplus.utils.w$a */
    /* loaded from: classes3.dex */
    public class a implements SoundPool.OnLoadCompleteListener {
        public a() {
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i10, int i11) {
            C0861w.this.f29197c = true;
            C0861w.this.f29201g.quitSafely();
        }
    }

    /* compiled from: GlobalSoundManager.java */
    /* renamed from: com.oplus.utils.w$b */
    /* loaded from: classes3.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                C0861w.this.j();
            } else if (i10 == 2) {
                C0861w c0861w = C0861w.this;
                c0861w.f29202h = new Y(c0861w.f29199e);
                C0861w.this.f29198d = true;
            }
        }
    }

    public C0861w(Context context) {
        HandlerThread handlerThread = new HandlerThread("global_sound_thread");
        this.f29201g = handlerThread;
        handlerThread.start();
        this.f29200f = new b(handlerThread.getLooper());
        this.f29199e = context.getApplicationContext();
    }

    public static C0861w g(Context context) {
        if (f29194i == null) {
            synchronized (C0861w.class) {
                try {
                    if (f29194i == null) {
                        f29194i = new C0861w(context);
                    }
                } finally {
                }
            }
        }
        return f29194i;
    }

    public final String h() {
        return i("global_delete.ogg");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0062, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        if (r7 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003f, code lost:
    
        if (r7 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0041, code lost:
    
        r7.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String i(java.lang.String r8) {
        /*
            r7 = this;
            boolean r7 = android.text.TextUtils.isEmpty(r8)
            r0 = 0
            if (r7 != 0) goto L69
            com.oplus.utils.w r7 = com.oplus.utils.C0861w.f29194i
            android.content.Context r7 = r7.f29199e
            if (r7 != 0) goto Le
            goto L69
        Le:
            com.oplus.utils.w r7 = com.oplus.utils.C0861w.f29194i     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            android.content.Context r7 = r7.f29199e     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            android.net.Uri r2 = android.provider.MediaStore.Audio.Media.INTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            java.lang.String r7 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r7}     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            java.lang.String r4 = "_display_name like ?"
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            if (r7 == 0) goto L3f
            boolean r8 = r7.moveToFirst()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            if (r8 == 0) goto L3f
            r8 = 0
            java.lang.String r8 = r7.getString(r8)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r7.close()
            return r8
        L3a:
            r8 = move-exception
            r0 = r7
            goto L63
        L3d:
            r8 = move-exception
            goto L49
        L3f:
            if (r7 == 0) goto L62
        L41:
            r7.close()
            goto L62
        L45:
            r8 = move-exception
            goto L63
        L47:
            r8 = move-exception
            r7 = r0
        L49:
            java.lang.String r1 = "GlobalSoundManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            r2.<init>()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = "getSoundPathByProvider error:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L3a
            r2.append(r8)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L3a
            android.util.Log.e(r1, r8)     // Catch: java.lang.Throwable -> L3a
            if (r7 == 0) goto L62
            goto L41
        L62:
            return r0
        L63:
            if (r0 == 0) goto L68
            r0.close()
        L68:
            throw r8
        L69:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.utils.C0861w.i(java.lang.String):java.lang.String");
    }

    public final void j() {
        if (this.f29197c) {
            return;
        }
        this.f29195a = U.a();
        try {
            String h10 = h();
            if (!TextUtils.isEmpty(h10)) {
                this.f29196b = this.f29195a.c(h10, 1);
                this.f29195a.e(new a());
            }
        } catch (Exception e10) {
            Log.w("GlobalSoundManager", "Exception thrown during initDeleteSound :" + e10);
        }
    }

    public void k() {
        if (this.f29197c) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.f29200f.sendMessage(obtain);
    }

    public void l() {
        if (!C0848i.r(this.f29199e)) {
            return;
        }
        if (this.f29195a == null) {
            this.f29195a = U.a();
        }
        try {
            int i10 = this.f29196b;
            if (i10 != 0 && this.f29197c) {
                this.f29195a.d(i10, 1.0f, 1.0f, 1, 0, 1.0f);
            }
        } catch (Exception e10) {
            Log.w("GlobalSoundManager", "Exception thrown during playDeleteSound :" + e10);
        }
    }
}
