package com.android.contacts.framework.baseui.util;

import android.os.AsyncTask;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusSpecialNumberUtils;
import java.util.HashMap;

/* compiled from: SpecialNumberCache.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f15976b = {BreenoCallContract.BaseColumns._ID, "number", OplusSpecialNumberUtils.OplusSpecialNumColumns.CN_NAME, OplusSpecialNumberUtils.OplusSpecialNumColumns.PHOTO_DATA};

    /* renamed from: c, reason: collision with root package name */
    public static w f15977c;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, b> f15978a;

    /* compiled from: SpecialNumberCache.java */
    /* loaded from: classes.dex */
    public class a extends AsyncTask<Void, Void, Void> {
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            w.this.f();
            return null;
        }

        public void b() {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }

        public a() {
        }
    }

    /* compiled from: SpecialNumberCache.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f15980a;

        /* renamed from: b, reason: collision with root package name */
        public int f15981b;

        public String a() {
            return this.f15980a;
        }

        public int b() {
            return this.f15981b;
        }

        public void c(String str) {
            this.f15980a = str;
        }

        public void d(int i10) {
            this.f15981b = i10;
        }
    }

    public w() {
        HashMap<String, b> hashMap = new HashMap<>();
        this.f15978a = hashMap;
        hashMap.clear();
        new a().b();
    }

    public static synchronized w e() {
        w wVar;
        synchronized (w.class) {
            try {
                if (f15977c == null) {
                    f15977c = new w();
                }
                wVar = f15977c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002d A[Catch: Exception -> 0x0028, TRY_LEAVE, TryCatch #1 {Exception -> 0x0028, blocks: (B:3:0x0001, B:7:0x002d, B:18:0x0027, B:21:0x0024, B:17:0x001f, B:11:0x0016), top: B:2:0x0001, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean g(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch: java.lang.Exception -> L28
            android.net.Uri r2 = R0.d.f3230q     // Catch: java.lang.Exception -> L28
            java.lang.String[] r3 = com.android.contacts.framework.baseui.util.w.f15976b     // Catch: java.lang.Exception -> L28
            java.lang.String r4 = "number=?"
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch: java.lang.Exception -> L28
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L28
            if (r7 == 0) goto L2a
            int r8 = r7.getCount()     // Catch: java.lang.Throwable -> L1e
            if (r8 <= 0) goto L2a
            r8 = 1
            goto L2b
        L1e:
            r8 = move-exception
            r7.close()     // Catch: java.lang.Throwable -> L23
            goto L27
        L23:
            r7 = move-exception
            r8.addSuppressed(r7)     // Catch: java.lang.Exception -> L28
        L27:
            throw r8     // Catch: java.lang.Exception -> L28
        L28:
            r7 = move-exception
            goto L31
        L2a:
            r8 = r0
        L2b:
            if (r7 == 0) goto L30
            r7.close()     // Catch: java.lang.Exception -> L28
        L30:
            return r8
        L31:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "isSpecialNumber query exception: "
            r8.append(r1)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.String r8 = "SpecialNumberCache"
            H7.b.c(r8, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.baseui.util.w.g(android.content.Context, java.lang.String):boolean");
    }

    public static synchronized void h(w wVar) {
        synchronized (w.class) {
            f15977c = wVar;
        }
    }

    public void b() {
        this.f15978a.clear();
        h(null);
    }

    public boolean c(String str) {
        return this.f15978a.containsKey(str);
    }

    public b d(String str) {
        return this.f15978a.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (r0.moveToFirst() != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        r1 = 0 - r0.getInt(0);
        r2 = r0.getString(1);
        r3 = r0.getString(2);
        r4 = new com.android.contacts.framework.baseui.util.w.b();
        r4.c(r3);
        r4.d(r1);
        r8.f15978a.put(r2, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003e, code lost:
    
        if (r0.moveToNext() != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r8 = this;
            r0 = 0
            android.content.Context r1 = P7.a.f2962b     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            android.net.Uri r3 = R0.d.f3230q     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.lang.String[] r4 = com.android.contacts.framework.baseui.util.w.f15976b     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r6 = 0
            r7 = 0
            r5 = 0
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r0 == 0) goto L45
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r1 == 0) goto L45
        L1a:
            r1 = 0
            int r2 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            int r1 = r1 - r2
            r2 = 1
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3 = 2
            java.lang.String r3 = r0.getString(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            com.android.contacts.framework.baseui.util.w$b r4 = new com.android.contacts.framework.baseui.util.w$b     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r4.<init>()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r4.c(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r4.d(r1)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.util.HashMap<java.lang.String, com.android.contacts.framework.baseui.util.w$b> r1 = r8.f15978a     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r1.put(r2, r4)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            boolean r1 = r0.moveToNext()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r1 != 0) goto L1a
            goto L45
        L41:
            r8 = move-exception
            goto L65
        L43:
            r8 = move-exception
            goto L4b
        L45:
            if (r0 == 0) goto L64
        L47:
            r0.close()
            goto L64
        L4b:
            java.lang.String r1 = "SpecialNumberCache"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41
            r2.<init>()     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = "initSpecialNumber RuntimeException: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L41
            r2.append(r8)     // Catch: java.lang.Throwable -> L41
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L41
            H7.b.c(r1, r8)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L64
            goto L47
        L64:
            return
        L65:
            if (r0 == 0) goto L6a
            r0.close()
        L6a:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.baseui.util.w.f():void");
    }
}
