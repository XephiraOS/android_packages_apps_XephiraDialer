package com.android.contacts;

import a4.C0421a;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.activities.ContactShortcutDetailActivity;
import com.android.contacts.activities.RequestPermissionsActivityBase;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.dialer.R;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class DynamicShortcuts {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f13109g = {BreenoCallContract.BaseColumns._ID, "display_name", "starred", "photo_uri", "lookup", "account_name", "account_type", "has_phone_number", S0.a.f3371a, "photo_id"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f13110h = {"data1", "data6", "is_primary", "is_super_primary"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f13111i = {"data15"};

    /* renamed from: a, reason: collision with root package name */
    public final Context f13112a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f13113b;

    /* renamed from: c, reason: collision with root package name */
    public final ShortcutManager f13114c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13115d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13116e;

    /* renamed from: f, reason: collision with root package name */
    public final JobScheduler f13117f;

    /* loaded from: classes.dex */
    public enum ShortcutType {
        CALL(""),
        DETAIL("detail-");

        final String idPrefix;

        ShortcutType(String str) {
            this.idPrefix = str;
        }

        public static ShortcutType b(String str) {
            ShortcutType shortcutType = DETAIL;
            if (str.startsWith(shortcutType.idPrefix)) {
                return shortcutType;
            }
            return CALL;
        }
    }

    /* loaded from: classes.dex */
    public class a extends c {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JobService f13121c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JobParameters f13122d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DynamicShortcuts dynamicShortcuts, Context context, JobService jobService, JobParameters jobParameters) {
            super(dynamicShortcuts, context);
            this.f13121c = jobService;
            this.f13122d = jobParameters;
        }

        @Override // com.android.contacts.DynamicShortcuts.c, android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            this.f13121c.jobFinished(this.f13122d, false);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            X.a.b(context).e(this);
            DynamicShortcuts.o(context);
        }

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public static class c extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public DynamicShortcuts f13123a;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference<Context> f13124b;

        public c(DynamicShortcuts dynamicShortcuts, Context context) {
            this.f13124b = null;
            this.f13123a = dynamicShortcuts;
            if (context != null) {
                this.f13124b = new WeakReference<>(context);
            } else {
                this.f13124b = null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            if (H7.a.b()) {
                H7.b.b("DynamicShortcuts", "ShorcutUpdateTask.doInBackground");
            }
            WeakReference<Context> weakReference = this.f13124b;
            if (weakReference == null) {
                this.f13123a.q();
                return Boolean.TRUE;
            }
            Context context = weakReference.get();
            if (context != null && !DynamicShortcuts.p(context)) {
                this.f13123a.q();
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (H7.a.b()) {
                H7.b.b("DynamicShortcuts", "ShorcutUpdateTask.onPostExecute needUpdate = " + bool);
            }
            if (bool.booleanValue()) {
                this.f13123a.s();
            }
        }
    }

    public DynamicShortcuts(Context context) {
        this(context, context.getContentResolver(), (ShortcutManager) context.getSystemService("shortcut"), (JobScheduler) context.getSystemService("jobscheduler"));
    }

    public static synchronized void o(Context context) {
        synchronized (DynamicShortcuts.class) {
            try {
                if (P7.e.d(context)) {
                    if (RequestPermissionsActivityBase.e2(context)) {
                        return;
                    }
                    DynamicShortcuts dynamicShortcuts = new DynamicShortcuts(context);
                    if (!dynamicShortcuts.n()) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("broadcastPermissionsGranted");
                        X.a.b(dynamicShortcuts.f13112a).c(new b(), intentFilter);
                    } else {
                        new c(dynamicShortcuts, context).execute(new Void[0]);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean p(Context context) {
        if (((JobScheduler) context.getSystemService("jobscheduler")).getPendingJob(401) != null) {
            return true;
        }
        return false;
    }

    public static void r(Context context, String str) {
        if (str == null) {
            return;
        }
        ((ShortcutManager) context.getSystemService("shortcut")).reportShortcutUsed(str);
    }

    public static void u(JobService jobService, JobParameters jobParameters) {
        new a(new DynamicShortcuts(jobService), null, jobService, jobParameters).execute(new Void[0]);
    }

    public final void d(Cursor cursor, ShortcutInfo.Builder builder) {
        long j10 = cursor.getLong(cursor.getColumnIndex("photo_id"));
        e(cursor.getString(1), String.valueOf(cursor.getLong(0)), j10, builder);
    }

    public final void e(String str, String str2, long j10, ShortcutInfo.Builder builder) {
        Bitmap g10;
        Bitmap j11 = j(j10);
        if (j11 == null) {
            g10 = com.android.contacts.util.f.c(this.f13112a, str, str2);
        } else {
            g10 = g(j11, j11.getWidth(), this.f13112a.getResources().getDimensionPixelSize(R.dimen.DP_8));
        }
        builder.setIcon(Icon.createWithBitmap(g10));
    }

    public final ShortcutInfo.Builder f(Cursor cursor, ShortcutType shortcutType) {
        String str;
        long j10 = cursor.getLong(0);
        String string = cursor.getString(4);
        String string2 = cursor.getString(1);
        if (H7.a.b()) {
            H7.b.b("DynamicShortcuts", "contactId = " + j10 + ", lookupKey= " + string);
        }
        String str2 = null;
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return null;
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putLong(BreenoCallContract.BaseColumns._ID, j10);
        persistableBundle.putInt("extraShortcutType", 1);
        persistableBundle.putBoolean("approval_dialog_disable", true);
        ShortcutInfo.Builder extras = new ShortcutInfo.Builder(this.f13112a, shortcutType.idPrefix + j10).setDisabledMessage(this.f13112a.getString(R.string.dynamic_shortcut_disabled_message)).setExtras(persistableBundle);
        if (C0637b.h()) {
            string2 = C0637b.c(string2);
        }
        t(extras, string2);
        if (shortcutType == ShortcutType.CALL) {
            Cursor query = this.f13113b.query(ContactsContract.Data.CONTENT_URI, f13110h, "(mimetype='vnd.android.cursor.item/phone_v2') AND contact_id=?", new String[]{String.valueOf(j10)}, null, null);
            if (query == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            if (query.getCount() > 0) {
                String str3 = null;
                while (true) {
                    if (query.moveToNext()) {
                        String string3 = query.getString(0);
                        if (!TextUtils.isEmpty(string3)) {
                            if (TextUtils.isEmpty(str3)) {
                                str3 = query.getString(1);
                            }
                            int i10 = query.getInt(2);
                            int i11 = query.getInt(3);
                            if (i10 == 1 && i11 == 1) {
                                if (H7.a.b()) {
                                    H7.b.b("DynamicShortcuts", "primaryNumber = " + H7.a.d(string3) + ", countryISO = " + str3);
                                }
                                str = str3;
                                str2 = string3;
                            } else {
                                if (!arrayList.contains(string3)) {
                                    arrayList.add(string3);
                                }
                                if (H7.a.b()) {
                                    H7.b.b("DynamicShortcuts", "number = " + H7.a.d(string3) + ", countryISO = " + str3);
                                }
                            }
                        }
                    } else {
                        str = str3;
                        break;
                    }
                }
                if (!query.isClosed()) {
                    query.close();
                }
                extras.setIntent(k(j10, string, str2, arrayList, str));
                extras.setActivity(new ComponentName(this.f13112a.getPackageName(), "com.android.contacts.DialtactsActivityAlias"));
            } else {
                if (!query.isClosed()) {
                    query.close();
                }
                return null;
            }
        } else if (shortcutType == ShortcutType.DETAIL) {
            extras.setActivity(new ComponentName(this.f13112a.getPackageName(), "com.android.contacts.PeopleActivityAlias"));
            extras.setIntent(l(j10, string));
        }
        return extras;
    }

    public final Bitmap g(Bitmap bitmap, int i10, int i11) {
        float f10;
        float f11;
        if (bitmap != null) {
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            if (width > height) {
                f10 = 0.0f;
                f11 = (width - height) / 2.0f;
                width = height;
            } else {
                f10 = (height - width) / 2.0f;
                f11 = 0.0f;
            }
            float f12 = i10;
            float f13 = (1.0f * f12) / width;
            Matrix matrix = new Matrix();
            matrix.setScale(f13, f13);
            int i12 = (int) width;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, (int) f11, (int) f10, i12, i12, matrix, true);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(createBitmap, tileMode, tileMode);
            Bitmap createBitmap2 = Bitmap.createBitmap(i10, i10, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            float f14 = i11;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, f12, f12), f14, f14, paint);
            return createBitmap2;
        }
        throw new NullPointerException("Bitmap can't be null");
    }

    public ShortcutInfo h(long j10, ShortcutType shortcutType) {
        Cursor query = this.f13113b.query(ContactsContract.Contacts.CONTENT_URI, f13109g, "_id=" + j10, null, null);
        if (query == null) {
            return null;
        }
        try {
            if (!query.moveToFirst()) {
                return null;
            }
            return i(query, shortcutType);
        } finally {
            query.close();
        }
    }

    public ShortcutInfo i(Cursor cursor, ShortcutType shortcutType) {
        if (cursor.getCount() <= 0) {
            return null;
        }
        ShortcutInfo.Builder f10 = f(cursor, shortcutType);
        if (f10 == null) {
            H7.b.i("DynamicShortcuts", "createShortcutFromRow builder is null");
            return null;
        }
        d(cursor, f10);
        return f10.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap j(long r9) {
        /*
            r8 = this;
            r0 = 0
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            r0 = 0
            android.content.Context r8 = r8.f13112a     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            android.net.Uri r3 = android.provider.ContactsContract.Data.CONTENT_URI     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String[] r4 = com.android.contacts.DynamicShortcuts.f13111i     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r5 = "_id=?"
            java.lang.String r8 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String[] r6 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r7 = 0
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            if (r8 == 0) goto L34
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            if (r9 == 0) goto L34
            byte[] r9 = r8.getBlob(r0)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            goto L35
        L2f:
            r9 = move-exception
            r1 = r8
            goto L64
        L32:
            r9 = move-exception
            goto L3f
        L34:
            r9 = r1
        L35:
            if (r8 == 0) goto L5b
            r8.close()
            goto L5b
        L3b:
            r9 = move-exception
            goto L64
        L3d:
            r9 = move-exception
            r8 = r1
        L3f:
            java.lang.String r10 = "DynamicShortcuts"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r2.<init>()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = "Exception e: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L2f
            r2.append(r9)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r9 = r2.toString()     // Catch: java.lang.Throwable -> L2f
            H7.b.c(r10, r9)     // Catch: java.lang.Throwable -> L2f
            if (r8 == 0) goto L5a
            r8.close()
        L5a:
            r9 = r1
        L5b:
            if (r9 == 0) goto L63
            int r8 = r9.length     // Catch: java.lang.Exception -> L63
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r9, r0, r8, r1)     // Catch: java.lang.Exception -> L63
        L63:
            return r1
        L64:
            if (r1 == 0) goto L69
            r1.close()
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.DynamicShortcuts.j(long):android.graphics.Bitmap");
    }

    public final Intent k(long j10, String str, String str2, ArrayList<String> arrayList, String str3) {
        if (arrayList.size() != 1 && TextUtils.isEmpty(str2)) {
            Uri lookupUri = ContactsContract.Contacts.getLookupUri(j10, str);
            Intent intent = new Intent("oplus.intent.action.SHORT_CUT_CALL", lookupUri);
            intent.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            intent.setData(lookupUri);
            return intent;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = arrayList.get(0);
        }
        Uri withAppendedId = ContentUris.withAppendedId(R0.d.c(str2), j10);
        Intent intent2 = new Intent(C0421a.f6395a, Uri.fromParts("tel", str2, null));
        intent2.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        intent2.putExtra("countryiso", str3);
        if (withAppendedId != null && PrimaryUserUtils.a()) {
            intent2.putExtra(R0.c.f3186d, withAppendedId.toString());
            return intent2;
        }
        return intent2;
    }

    public final Intent l(long j10, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(ContactsContract.Contacts.getLookupUri(j10, str));
        intent.setClass(this.f13112a, ContactShortcutDetailActivity.class);
        return intent;
    }

    public final List<ShortcutInfo> m() {
        Cursor query = this.f13113b.query(ContactsContract.Contacts.CONTENT_URI, f13109g, "starred=?", new String[]{OplusPhoneUtils.DeviceState.LOCK_DEVICE}, S0.a.f3371a + " ASC");
        if (query == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                ShortcutInfo i10 = i(query, ShortcutType.CALL);
                if (i10 != null) {
                    long j10 = i10.getExtras().getLong(BreenoCallContract.BaseColumns._ID);
                    if (H7.a.b()) {
                        H7.b.b("DynamicShortcuts", "contactId = " + j10);
                    }
                    arrayList.add(i10);
                    if (arrayList.size() >= 3) {
                        break;
                    }
                }
            } catch (Throwable th) {
                if (!query.isClosed()) {
                    query.close();
                }
                throw th;
            }
        }
        if (!query.isClosed()) {
            query.close();
        }
        return arrayList;
    }

    public final boolean n() {
        if (com.android.contacts.util.w.j(this.f13112a) && com.android.contacts.util.w.m(this.f13112a)) {
            return true;
        }
        return false;
    }

    public final void q() {
        try {
            if (!n()) {
                return;
            }
            List<ShortcutInfo> m10 = m();
            ShortcutManager shortcutManager = this.f13114c;
            if (shortcutManager != null) {
                shortcutManager.setDynamicShortcuts(m10);
            }
            if (H7.a.b()) {
                H7.b.b("DynamicShortcuts", "refresh, set dynamic shortcuts ");
            }
            if (this.f13114c != null) {
                v();
            }
        } catch (Exception e10) {
            H7.b.c("DynamicShortcuts", "Exception e: " + e10);
        }
    }

    public final void s() {
        try {
            this.f13117f.schedule(new JobInfo.Builder(401, new ComponentName(this.f13112a, (Class<?>) ContactsJobService.class)).addTriggerContentUri(new JobInfo.TriggerContentUri(ContactsContract.RawContacts.CONTENT_URI, 1)).setTriggerContentUpdateDelay(this.f13115d).setTriggerContentMaxDelay(this.f13116e).build());
        } catch (IllegalArgumentException e10) {
            H7.b.c("DynamicShortcuts", "Exception e: " + e10);
        }
    }

    public final void t(ShortcutInfo.Builder builder, String str) {
        if (str.length() < 30) {
            builder.setLongLabel(str);
        } else {
            builder.setLongLabel(str.substring(0, 29).trim() + "…");
        }
        if (str.length() < 12) {
            builder.setShortLabel(str);
            return;
        }
        builder.setShortLabel(str.substring(0, 11).trim() + "…");
    }

    public final void v() {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (ShortcutInfo shortcutInfo : this.f13114c.getPinnedShortcuts()) {
            PersistableBundle extras = shortcutInfo.getExtras();
            if (extras != null && extras.getInt("extraShortcutType", 0) == 1) {
                long j10 = extras.getLong(BreenoCallContract.BaseColumns._ID);
                ShortcutInfo h10 = h(j10, ShortcutType.b(shortcutInfo.getId()));
                if (h10 != null) {
                    arrayList.add(h10);
                    if (!shortcutInfo.isEnabled()) {
                        arrayList3.add(h10.getId());
                    }
                } else if (shortcutInfo.isEnabled()) {
                    Cursor cursor = null;
                    try {
                        try {
                            cursor = this.f13113b.query(ContactsContract.Contacts.CONTENT_URI, f13109g, "_id=" + j10, null, S0.a.f3371a + " ASC");
                            if (cursor != null) {
                                if (cursor.getCount() <= 0) {
                                    arrayList2.add(shortcutInfo.getId());
                                } else {
                                    cursor.moveToFirst();
                                    if (cursor.getInt(7) == 1) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    if (H7.a.b()) {
                                        H7.b.b("DynamicShortcuts", "hasPhoneNumber = " + z10);
                                    }
                                    if (!z10) {
                                        arrayList2.add(shortcutInfo.getId());
                                    }
                                }
                            } else {
                                arrayList2.add(shortcutInfo.getId());
                            }
                        } catch (Exception e10) {
                            H7.b.c("DynamicShortcuts", "Exception e: " + e10);
                            if (cursor != null && !cursor.isClosed()) {
                            }
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (Throwable th) {
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        throw th;
                    }
                } else if (H7.a.b()) {
                    H7.b.e("DynamicShortcuts", "disabling----------------");
                }
            }
        }
        if (H7.a.b()) {
            H7.b.b("DynamicShortcuts", "updating " + arrayList + " ,enabling " + arrayList3 + " ,disabling " + arrayList2);
        }
        try {
            this.f13114c.updateShortcuts(arrayList);
            this.f13114c.enableShortcuts(arrayList3);
            this.f13114c.disableShortcuts(arrayList2, this.f13112a.getString(R.string.dynamic_shortcut_contactPhonenumber_removed_message));
        } catch (Throwable th2) {
            H7.b.c("DynamicShortcuts", "" + th2);
        }
    }

    public DynamicShortcuts(Context context, ContentResolver contentResolver, ShortcutManager shortcutManager, JobScheduler jobScheduler) {
        this.f13112a = context;
        this.f13113b = contentResolver;
        this.f13114c = shortcutManager;
        this.f13117f = jobScheduler;
        this.f13115d = AFConstants.BIND_SERVICE_TIMEOUTMILLIS;
        this.f13116e = 10000;
    }
}
