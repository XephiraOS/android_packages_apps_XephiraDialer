package com.customize.contacts.util;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;
import com.oplus.dialer.R;
import h1.C1075d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ProfileUtils.java */
/* loaded from: classes3.dex */
public class W {

    /* renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f21984a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public static Uri f21985b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Bitmap f21986c = null;

    /* compiled from: ProfileUtils.java */
    /* loaded from: classes3.dex */
    public static class a extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: d, reason: collision with root package name */
        public static String[] f21987d = {"data15", "data1"};

        /* renamed from: a, reason: collision with root package name */
        public ImageView f21988a;

        /* renamed from: b, reason: collision with root package name */
        public Uri f21989b;

        /* renamed from: c, reason: collision with root package name */
        public WeakReference<Context> f21990c;

        public a(Context context, ImageView imageView, Uri uri) {
            this.f21990c = new WeakReference<>(context);
            this.f21988a = imageView;
            this.f21989b = uri;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Void... voidArr) {
            Bitmap bitmap;
            Exception e10;
            Cursor cursor;
            Context context = this.f21990c.get();
            ?? r02 = 0;
            Bitmap bitmap2 = null;
            try {
                if (context == null) {
                    return null;
                }
                try {
                    cursor = context.getContentResolver().query(Uri.withAppendedPath(this.f21989b, "entities"), f21987d, "mimetype=?", new String[]{"vnd.android.cursor.item/photo"}, null);
                    if (cursor != null) {
                        bitmap = null;
                        while (cursor.moveToNext()) {
                            try {
                                byte[] blob = cursor.getBlob(0);
                                if (blob != null && blob.length > 0) {
                                    bitmap = BitmapFactory.decodeByteArray(blob, 0, blob.length, null);
                                }
                            } catch (Exception e11) {
                                e10 = e11;
                                H7.b.c("ProfileUtils", "Non-RuntimeException: load me photo fail!" + e10);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return bitmap;
                            }
                        }
                        bitmap2 = bitmap;
                    }
                    if (cursor != null) {
                        cursor.close();
                        return bitmap2;
                    }
                    return bitmap2;
                } catch (Exception e12) {
                    bitmap = null;
                    e10 = e12;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (r02 != 0) {
                        r02.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r02 = this;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            ImageView imageView = this.f21988a;
            if (imageView != null) {
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                } else {
                    imageView.setImageDrawable(this.f21990c.get().getResources().getDrawable(R.drawable.pb_ic_my_profile, this.f21990c.get().getTheme()));
                }
                W.f21986c = bitmap;
            }
        }
    }

    public static ArrayList<String> a(Context context) {
        String c10;
        String str;
        ArrayList<String> arrayList = new ArrayList<>();
        if (B3.a.i()) {
            c10 = C1075d.d(context, 0);
            str = C1075d.d(context, 1);
        } else {
            c10 = C1075d.c(context);
            str = null;
        }
        arrayList.add(c10);
        arrayList.add(str);
        return arrayList;
    }

    public static Uri b() {
        return f21985b;
    }

    public static Uri c(Context context) {
        if (f21984a.get()) {
            return f21985b;
        }
        return h(context);
    }

    public static void d(Context context, Intent intent) {
        if (context != null && intent != null) {
            ArrayList<String> a10 = a(context);
            if (a10.size() > 0) {
                String str = a10.get(0);
                String str2 = a10.get(1);
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra("phone", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    intent.putExtra("secondary_phone", str2);
                }
                intent.setPackage(context.getPackageName());
            }
        }
    }

    public static void e(Context context) {
        X.a b10;
        if (context != null && (b10 = X.a.b(context)) != null) {
            b10.d(new Intent("profile_lookup_uri_update"));
        }
    }

    public static void f(Context context, ImageView imageView) {
        if (imageView != null && context != null) {
            Bitmap bitmap = f21986c;
            if (bitmap != null && f21985b != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.pb_ic_my_profile, context.getTheme()));
            }
            if (f21985b != null) {
                new a(context, imageView, f21985b).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }
    }

    public static void g(boolean z10) {
        f21984a.set(z10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0047, code lost:
    
        if (r1 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
    
        if (r1 == null) goto L26;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0041: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:66), block:B:30:0x0041 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.net.Uri h(android.content.Context r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            android.net.Uri r2 = android.provider.ContactsContract.Profile.CONTENT_URI     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r3 = "_id"
            java.lang.String r4 = "lookup"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r5 = 0
            r6 = 0
            r4 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            if (r1 == 0) goto L45
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            if (r2 == 0) goto L45
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            r2 = 0
            long r2 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            r4 = 1
            java.lang.String r5 = r1.getString(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            android.net.Uri r2 = android.provider.ContactsContract.Contacts.getLookupUri(r2, r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            android.net.Uri r7 = com.android.contacts.util.h.a(r7, r2)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            com.customize.contacts.util.W.f21985b = r7     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            g(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            r1.close()
            return r7
        L40:
            r7 = move-exception
            r0 = r1
            goto L6b
        L43:
            r7 = move-exception
            goto L51
        L45:
            com.customize.contacts.util.W.f21985b = r0     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            if (r1 == 0) goto L6a
        L49:
            r1.close()
            goto L6a
        L4d:
            r7 = move-exception
            goto L6b
        L4f:
            r7 = move-exception
            r1 = r0
        L51:
            java.lang.String r2 = "ProfileUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r3.<init>()     // Catch: java.lang.Throwable -> L40
            java.lang.String r4 = "e = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L40
            r3.append(r7)     // Catch: java.lang.Throwable -> L40
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> L40
            H7.b.c(r2, r7)     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L6a
            goto L49
        L6a:
            return r0
        L6b:
            if (r0 == 0) goto L70
            r0.close()
        L70:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.W.h(android.content.Context):android.net.Uri");
    }
}
