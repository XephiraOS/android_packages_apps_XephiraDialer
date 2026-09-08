package com.juphoon.helper;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.juphoon.rcs.tool.RcsServiceManager;
import java.util.ArrayList;

/* compiled from: RcsContactDataHelper.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Context f25476a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f25477b = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f25478c = ContactsContract.RawContacts.CONTENT_URI;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f25479d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f25480e = false;

    /* renamed from: f, reason: collision with root package name */
    public static ContentObserver f25481f = new a(new Handler());

    /* compiled from: RcsContactDataHelper.java */
    /* loaded from: classes3.dex */
    public static class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            b.g();
        }
    }

    /* compiled from: RcsContactDataHelper.java */
    /* renamed from: com.juphoon.helper.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class AsyncTaskC0230b extends AsyncTask<Void, Void, Void> {
        public AsyncTaskC0230b() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            ArrayList arrayList = new ArrayList();
            Cursor query = b.f25476a.getContentResolver().query(b.f25477b, new String[]{"contact_id", "data1"}, null, null, BreenoCallContract.BaseColumns._ID);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        String d10 = com.juphoon.rcs.tool.b.d(query.getString(1), RcsServiceManager.A());
                        if (!TextUtils.isEmpty(d10) && d10.length() > 3 && !arrayList.contains(d10)) {
                            arrayList.add(d10);
                            com.juphoon.helper.a.g(d10, null, false);
                        }
                    } finally {
                        query.close();
                    }
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r22) {
            if (b.f25480e) {
                boolean unused = b.f25480e = false;
                boolean unused2 = b.f25479d = true;
                new AsyncTaskC0230b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
            boolean unused3 = b.f25479d = false;
        }

        public /* synthetic */ AsyncTaskC0230b(a aVar) {
            this();
        }
    }

    public static void f(Context context) {
        f25476a = context;
        context.getContentResolver().registerContentObserver(f25477b, true, f25481f);
        f25476a.getContentResolver().registerContentObserver(f25478c, true, f25481f);
    }

    public static void g() {
        if (RcsServiceManager.D()) {
            if (!f25479d) {
                f25479d = true;
                new AsyncTaskC0230b(null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                f25480e = true;
            }
        }
    }
}
