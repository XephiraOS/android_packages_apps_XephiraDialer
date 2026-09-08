package com.android.contacts.activities;

import C7.e;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.android.contacts.util.i;
import com.android.contacts.util.w;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.ui.c;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class AttachPhotoActivity extends Activity {

    /* renamed from: i, reason: collision with root package name */
    public static int f13583i;

    /* renamed from: a, reason: collision with root package name */
    public Long[] f13584a;

    /* renamed from: b, reason: collision with root package name */
    public int f13585b = 0;

    /* renamed from: c, reason: collision with root package name */
    public HashMap<Integer, Boolean> f13586c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public Uri f13587d;

    /* renamed from: e, reason: collision with root package name */
    public Uri f13588e;

    /* renamed from: f, reason: collision with root package name */
    public ContentResolver f13589f;

    /* renamed from: g, reason: collision with root package name */
    public Uri f13590g;

    /* renamed from: h, reason: collision with root package name */
    public ThreadPoolExecutor f13591h;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: com.android.contacts.activities.AttachPhotoActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0157a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ArrayList f13593a;

            public RunnableC0157a(ArrayList arrayList) {
                this.f13593a = arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AttachPhotoActivity.this.f13584a == null || this.f13593a.isEmpty()) {
                    c.b(AttachPhotoActivity.this, R.string.contactSavedErrorToast);
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.b(AttachPhotoActivity.this, R.string.contactSavedErrorToast);
                e.b(AttachPhotoActivity.this);
            }
        }

        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00f8  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 303
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.activities.AttachPhotoActivity.a.run():void");
        }
    }

    /* loaded from: classes.dex */
    public class b extends AsyncTask<String, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public Context f13596a;

        /* renamed from: b, reason: collision with root package name */
        public Long[] f13597b;

        /* renamed from: c, reason: collision with root package name */
        public Uri f13598c;

        public b(Context context, Long[] lArr, Uri uri) {
            this.f13596a = context;
            this.f13597b = lArr;
            this.f13598c = uri;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(String... strArr) {
            Bitmap bitmap;
            if (this.f13597b != null) {
                H7.b.e("AttachPhotoActivity", "doInBackground mResultUri: " + this.f13598c);
                try {
                    bitmap = I7.a.e(this.f13596a, this.f13598c);
                } catch (FileNotFoundException e10) {
                    H7.b.c("AttachPhotoActivity", "doInBackground e: " + e10);
                    bitmap = null;
                }
                this.f13596a.getContentResolver().delete(this.f13598c, null, null);
                for (Long l10 : this.f13597b) {
                    if (bitmap != null) {
                        AttachPhotoActivity.this.p(l10.longValue(), bitmap);
                    }
                }
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x005e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        if (r1 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<java.lang.Long> m(android.content.ContentResolver r8, long r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.net.Uri r3 = android.provider.ContactsContract.RawContacts.CONTENT_URI     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r2 = "_id"
            java.lang.String[] r4 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r2.<init>()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r5 = "contact_id="
            r2.append(r5)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r2.append(r9)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r6 = 0
            r7 = 0
            r2 = r8
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            if (r1 == 0) goto L3f
        L28:
            boolean r8 = r1.moveToNext()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            if (r8 == 0) goto L3f
            r8 = 0
            long r8 = r1.getLong(r8)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r0.add(r8)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            goto L28
        L3b:
            r8 = move-exception
            goto L5f
        L3d:
            r8 = move-exception
            goto L45
        L3f:
            if (r1 == 0) goto L5e
        L41:
            r1.close()
            goto L5e
        L45:
            java.lang.String r9 = "AttachPhotoActivity"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            r10.<init>()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r2 = ""
            r10.append(r2)     // Catch: java.lang.Throwable -> L3b
            r10.append(r8)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Throwable -> L3b
            H7.b.c(r9, r8)     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L5e
            goto L41
        L5e:
            return r0
        L5f:
            if (r1 == 0) goto L64
            r1.close()
        L64:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.activities.AttachPhotoActivity.m(android.content.ContentResolver, long):java.util.ArrayList");
    }

    public static Long[] q(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        Long[] lArr = new Long[jArr.length];
        for (int i10 = 0; i10 < jArr.length; i10++) {
            lArr[i10] = Long.valueOf(jArr[i10]);
        }
        return lArr;
    }

    public static long[] r(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        long[] jArr = new long[lArr.length];
        for (int i10 = 0; i10 < lArr.length; i10++) {
            jArr[i10] = lArr[i10].longValue();
        }
        return jArr;
    }

    public final void n() {
        if (f13583i == 0) {
            Cursor cursor = null;
            try {
                cursor = this.f13589f.query(ContactsContract.DisplayPhoto.CONTENT_MAX_DIMENSIONS_URI, new String[]{"display_max_dim"}, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    f13583i = cursor.getInt(0);
                }
            } catch (Throwable th) {
                try {
                    H7.b.c("AttachPhotoActivity", "readPhotoDimIfNeed " + th.getMessage());
                } finally {
                    com.oplus.foundation.util.io.e.a(cursor);
                }
            }
        }
    }

    public final void o(Long[] lArr, Uri uri) {
        if (lArr != null) {
            new b(getApplicationContext(), lArr, uri).execute("");
        }
        e.b(this);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i11 != -1) {
            e.b(this);
            return;
        }
        if (i10 == 1) {
            this.f13590g = intent.getData();
            this.f13591h.execute(new a());
        } else if (i10 == 2) {
            getContentResolver().delete(this.f13587d, null, null);
            this.f13586c.put(2, Boolean.FALSE);
            Long[] lArr = this.f13584a;
            if (lArr != null) {
                o(lArr, this.f13588e);
            } else {
                e.b(this);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Uri parse;
        super.onCreate(bundle);
        DisplayUtil.v(this);
        if (bundle != null) {
            String string = bundle.getString("contact_uri");
            if (string == null) {
                parse = null;
            } else {
                parse = Uri.parse(string);
            }
            this.f13590g = parse;
            this.f13587d = Uri.parse(bundle.getString("temp_photo_uri"));
            this.f13588e = Uri.parse(bundle.getString("cropped_photo_uri"));
            this.f13584a = q(bundle.getLongArray("raw_contact_uris"));
        } else {
            this.f13587d = i.i(this);
            this.f13588e = i.g(this);
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("vnd.android.cursor.dir/contact");
            intent.setPackage(getPackageName());
            e.m(intent, "photo_select", true);
            Q7.b.b(this, intent, 1, 0);
            overridePendingTransition(R.anim.coui_open_slide_enter, R.anim.coui_open_slide_exit);
        }
        this.f13589f = getContentResolver();
        this.f13591h = N7.a.a();
        if (w.k(this, "android.permission.READ_CONTACTS")) {
            n();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ThreadPoolExecutor threadPoolExecutor = this.f13591h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
            this.f13591h = null;
        }
        H7.b.e("AttachPhotoActivity", "onDestroy() -------------");
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f13585b == 2) {
            if (this.f13586c.get(2) != null && this.f13586c.get(2).booleanValue()) {
                e.b(this);
            } else {
                this.f13586c.put(2, Boolean.TRUE);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Long[] lArr = this.f13584a;
        if (lArr != null && lArr.length != 0) {
            bundle.putLongArray("raw_contact_uris", r(lArr));
        }
        Uri uri = this.f13590g;
        if (uri != null) {
            bundle.putString("contact_uri", uri.toString());
        }
        Uri uri2 = this.f13587d;
        if (uri2 != null) {
            bundle.putString("temp_photo_uri", uri2.toString());
        }
        Uri uri3 = this.f13588e;
        if (uri3 != null) {
            bundle.putString("cropped_photo_uri", uri3.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
    
        if (r5 == null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(long r12, android.graphics.Bitmap r14) {
        /*
            r11 = this;
            byte[] r14 = com.android.contacts.util.i.d(r14)
            java.lang.String r0 = "AttachPhotoActivity"
            if (r14 != 0) goto L11
            java.lang.String r12 = "could not create scaled and compressed Bitmap"
            H7.b.i(r0, r12)
            C7.e.b(r11)
            return
        L11:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "raw_contact_id = "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = " AND "
            r1.append(r2)
            java.lang.String r2 = "mimetype"
            r1.append(r2)
            java.lang.String r3 = "='"
            r1.append(r3)
            java.lang.String r3 = "vnd.android.cursor.item/photo"
            r1.append(r3)
            java.lang.String r4 = "'"
            r1.append(r4)
            java.lang.String r8 = r1.toString()
            r1 = 0
            r4 = -1
            android.content.ContentResolver r5 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            android.net.Uri r6 = android.provider.ContactsContract.Data.CONTENT_URI     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            r9 = 0
            r10 = 0
            r7 = 0
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            java.lang.String r6 = "_id"
            int r6 = r5.getColumnIndexOrThrow(r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L60
            boolean r7 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L60
            if (r7 == 0) goto L62
            int r4 = r5.getInt(r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L60
            goto L62
        L5c:
            r11 = move-exception
            r1 = r5
            goto Ld9
        L60:
            r6 = move-exception
            goto L6a
        L62:
            r5.close()
            goto L81
        L66:
            r11 = move-exception
            goto Ld9
        L68:
            r6 = move-exception
            r5 = r1
        L6a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r7.<init>()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r8 = ""
            r7.append(r8)     // Catch: java.lang.Throwable -> L5c
            r7.append(r6)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r6 = r7.toString()     // Catch: java.lang.Throwable -> L5c
            H7.b.c(r0, r6)     // Catch: java.lang.Throwable -> L5c
            if (r5 == 0) goto L81
            goto L62
        L81:
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            java.lang.String r13 = "raw_contact_id"
            r0.put(r13, r12)
            r12 = 1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r12)
            java.lang.String r5 = "is_primary"
            r0.put(r5, r13)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "is_super_primary"
            r0.put(r13, r12)
            r0.put(r2, r3)
            java.lang.String r12 = "data15"
            r0.put(r12, r14)
            if (r4 < 0) goto Lcb
            android.content.ContentResolver r11 = r11.getContentResolver()
            android.net.Uri r12 = android.provider.ContactsContract.Data.CONTENT_URI
            android.net.Uri r12 = R0.d.a(r12)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "_id = "
            r13.append(r14)
            r13.append(r4)
            java.lang.String r13 = r13.toString()
            G7.c.g(r11, r12, r0, r13, r1)
            goto Ld8
        Lcb:
            android.content.ContentResolver r11 = r11.getContentResolver()
            android.net.Uri r12 = android.provider.ContactsContract.Data.CONTENT_URI
            android.net.Uri r12 = R0.d.a(r12)
            G7.c.d(r11, r12, r0)
        Ld8:
            return
        Ld9:
            if (r1 == 0) goto Lde
            r1.close()
        Lde:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.activities.AttachPhotoActivity.p(long, android.graphics.Bitmap):void");
    }
}
