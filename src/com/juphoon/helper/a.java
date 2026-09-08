package com.juphoon.helper;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.juphoon.helper.RcsBroadcastHelper;
import com.juphoon.rcs.tool.RcsServiceManager;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.HashMap;

/* compiled from: RcsCapHelper.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, b> f25470a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static Context f25471b;

    public static b b(String str) {
        HashMap<String, b> hashMap = f25470a;
        synchronized (hashMap) {
            try {
                if (hashMap.containsKey(str)) {
                    return hashMap.get(str);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void c(Context context) {
        f25471b = context;
        f();
    }

    public static boolean d(b bVar) {
        int u10;
        long currentTimeMillis = System.currentTimeMillis();
        if (bVar.f25474c) {
            u10 = RcsServiceManager.v();
        } else {
            u10 = RcsServiceManager.u();
        }
        long j10 = u10;
        if (currentTimeMillis - bVar.f25473b >= j10 && j10 != 0) {
            return true;
        }
        return false;
    }

    public static boolean e(String str) {
        return true;
    }

    public static void f() {
        new AsyncTaskC0229a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static void g(String str, RcsBroadcastHelper.a aVar, boolean z10) {
        b b10;
        String d10 = com.juphoon.rcs.tool.b.d(str, RcsServiceManager.A());
        if (!z10 && (b10 = b(d10)) != null && !d(b10)) {
            if (aVar != null) {
                aVar.a(d10, b10.f25474c, b10.f25472a, b10.f25475d);
                return;
            }
            return;
        }
        RcsBroadcastHelper.p(d10, aVar);
    }

    public static void h(String str, boolean z10, String str2, boolean z11, long j10) {
        HashMap<String, b> hashMap = f25470a;
        synchronized (hashMap) {
            hashMap.put(str, new b(str2, j10, z10, z11));
        }
    }

    /* compiled from: RcsCapHelper.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f25472a;

        /* renamed from: b, reason: collision with root package name */
        public long f25473b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f25474c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f25475d;

        public b(String str, long j10, boolean z10, boolean z11) {
            this.f25472a = str;
            this.f25473b = j10;
            this.f25474c = z10;
            this.f25475d = z11;
        }

        public b(String str, long j10, boolean z10) {
            this.f25472a = str;
            this.f25473b = j10;
            this.f25474c = z10;
        }
    }

    /* compiled from: RcsCapHelper.java */
    /* renamed from: com.juphoon.helper.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class AsyncTaskC0229a extends AsyncTask<Void, Void, Void> {
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            Cursor query = a.f25471b.getContentResolver().query(P5.a.f2958a, null, null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        String string = query.getString(query.getColumnIndex("phone_number"));
                        int i10 = query.getInt(query.getColumnIndex("im_session"));
                        int i11 = query.getInt(query.getColumnIndex("file_transfer"));
                        int i12 = query.getInt(query.getColumnIndex("geolocation_push"));
                        int i13 = query.getInt(query.getColumnIndex("http_file_transfer"));
                        int i14 = query.getInt(query.getColumnIndex("file_transfer_via_sms"));
                        int i15 = query.getInt(query.getColumnIndex("geolocation_via_sms"));
                        String string2 = query.getString(query.getColumnIndex("extension"));
                        int i16 = query.getInt(query.getColumnIndex("rcs_enable"));
                        long j10 = query.getLong(query.getColumnIndex(BreenoCallContract.BaseColumns.DATE));
                        StringBuffer stringBuffer = new StringBuffer();
                        boolean z10 = true;
                        if (i10 == 1) {
                            stringBuffer.append("cap_im");
                            stringBuffer.append(Constants.DataMigration.SPLIT_TAG);
                        }
                        if (i11 == 1) {
                            stringBuffer.append("cap_ft");
                            stringBuffer.append(Constants.DataMigration.SPLIT_TAG);
                        }
                        if (i12 == 1) {
                            stringBuffer.append("cap_geopush");
                            stringBuffer.append(Constants.DataMigration.SPLIT_TAG);
                        }
                        if (i13 == 1) {
                            stringBuffer.append("cap_fthttp");
                            stringBuffer.append(Constants.DataMigration.SPLIT_TAG);
                        }
                        if (i14 == 1) {
                            stringBuffer.append("cap_up_ftsms");
                            stringBuffer.append(Constants.DataMigration.SPLIT_TAG);
                        }
                        if (i15 == 1) {
                            stringBuffer.append("cap_up_geosms");
                            stringBuffer.append(Constants.DataMigration.SPLIT_TAG);
                        }
                        if (!TextUtils.isEmpty(string2)) {
                            stringBuffer.append(string2);
                        }
                        HashMap<String, b> hashMap = a.f25470a;
                        synchronized (hashMap) {
                            String stringBuffer2 = stringBuffer.toString();
                            if (i16 != 1) {
                                z10 = false;
                            }
                            hashMap.put(string, new b(stringBuffer2, j10, z10));
                        }
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                query.close();
                return null;
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
        }
    }
}
