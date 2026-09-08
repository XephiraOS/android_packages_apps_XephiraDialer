package com.customize.contacts.simcontacts;

import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.contacts.model.Account;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.c0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import m9.q;

/* compiled from: SimContactsLoader.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f21809d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static AtomicBoolean f21810e = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    public final Context f21811a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f21812b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f21813c;

    /* compiled from: SimContactsLoader.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final void d(Cursor cursor, Account account, ArrayList<ContentProviderOperation> arrayList) {
            String str;
            String str2;
            String[] strArr;
            List Y9;
            List Y10;
            i.c(cursor);
            int i10 = cursor.getInt(0);
            String string = cursor.getString(1);
            String string2 = cursor.getString(2);
            int size = arrayList.size();
            String[] strArr2 = null;
            try {
                str = cursor.getString(3);
            } catch (Exception unused) {
                str = null;
            }
            try {
                str2 = cursor.getString(4);
            } catch (Exception e10) {
                H7.b.c("SimContactsLoader", "exception when actuallyImportOneSimContact " + e10);
                str2 = null;
            }
            if (!TextUtils.isEmpty(str)) {
                i.c(str);
                Y10 = StringsKt__StringsKt.Y(str, new String[]{","}, false, 0, 6, null);
                strArr = (String[]) Y10.toArray(new String[0]);
            } else {
                strArr = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                i.c(str2);
                Y9 = StringsKt__StringsKt.Y(str2, new String[]{":"}, false, 0, 6, null);
                strArr2 = (String[]) Y9.toArray(new String[0]);
            }
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
            i.e(newInsert, "newInsert(ContactsContra….RawContacts.CONTENT_URI)");
            newInsert.withValue(b.f21805a, Integer.valueOf(i10));
            newInsert.withValue("aggregation_mode", 3);
            newInsert.withValue("aggregation_needed", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
            if (account != null) {
                newInsert.withValue("account_name", account.f16941a);
                newInsert.withValue("account_type", account.f16942b);
            }
            arrayList.add(newInsert.build());
            if (!TextUtils.isEmpty(string)) {
                ContentProviderOperation.Builder newInsert2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
                i.e(newInsert2, "newInsert(ContactsContract.Data.CONTENT_URI)");
                newInsert2.withValueBackReference("raw_contact_id", size);
                newInsert2.withValue("mimetype", "vnd.android.cursor.item/name");
                newInsert2.withValue("data2", string);
                arrayList.add(newInsert2.build());
            }
            if (!TextUtils.isEmpty(string2)) {
                ContentProviderOperation.Builder newInsert3 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
                i.e(newInsert3, "newInsert(ContactsContract.Data.CONTENT_URI)");
                newInsert3.withValueBackReference("raw_contact_id", size);
                newInsert3.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
                newInsert3.withValue("data2", 2);
                newInsert3.withValue("data1", string2);
                newInsert3.withValue("data3", 1);
                arrayList.add(newInsert3.build());
            }
            if (strArr2 != null) {
                Iterator a10 = kotlin.jvm.internal.b.a(strArr2);
                while (a10.hasNext()) {
                    String str3 = (String) a10.next();
                    ContentProviderOperation.Builder newInsert4 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
                    i.e(newInsert4, "newInsert(ContactsContract.Data.CONTENT_URI)");
                    newInsert4.withValueBackReference("raw_contact_id", size);
                    newInsert4.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
                    newInsert4.withValue("data2", 2);
                    newInsert4.withValue("data1", str3);
                    arrayList.add(newInsert4.build());
                }
            }
            if (strArr != null) {
                Iterator a11 = kotlin.jvm.internal.b.a(strArr);
                while (a11.hasNext()) {
                    String str4 = (String) a11.next();
                    ContentProviderOperation.Builder newInsert5 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
                    i.e(newInsert5, "newInsert(ContactsContract.Data.CONTENT_URI)");
                    newInsert5.withValueBackReference("raw_contact_id", size);
                    newInsert5.withValue("mimetype", "vnd.android.cursor.item/email_v2");
                    newInsert5.withValue("data2", 1);
                    newInsert5.withValue("data1", str4);
                    arrayList.add(newInsert5.build());
                }
            }
        }

        public final Account e(Context context, int i10, boolean z10) {
            i.f(context, "context");
            String accountName = b.g(i10);
            if (z10) {
                i.e(accountName, "accountName");
                i(context, accountName, "com.android.oplus.sim");
            }
            return new Account(accountName, "com.android.oplus.sim");
        }

        public final String[] f(int i10) {
            String g10 = b.g(i10);
            i.e(g10, "getSimAccountName(slotId)");
            return new String[]{"com.android.oplus.sim", g10, OplusPhoneUtils.DeviceState.UNLOCK_DEVICE};
        }

        public final boolean g(Context context) {
            boolean z10;
            ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("com.android.contacts");
            if (acquireContentProviderClient != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (acquireContentProviderClient != null) {
                acquireContentProviderClient.release();
            }
            return z10;
        }

        public final AtomicBoolean h() {
            return c.f21810e;
        }

        public final void i(Context context, String str, String str2) {
            if (!g(context)) {
                H7.b.b("SimContactsLoader", "contacts content provider not exist");
                return;
            }
            ContentResolver contentResolver = context.getContentResolver();
            H7.b.b("SimContactsLoader", "updateAccountVisible account is " + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("account_name", str);
            contentValues.put("account_type", str2);
            contentValues.put("should_sync", (Integer) 1);
            contentValues.put("ungrouped_visible", (Integer) 1);
            contentResolver.insert(ContactsContract.Settings.CONTENT_URI, contentValues);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public c(Context mContext) {
        i.f(mContext, "mContext");
        this.f21811a = mContext;
        this.f21812b = new String[]{BreenoCallContract.BaseColumns._ID, b.f21805a, "display_name"};
        this.f21813c = new String[]{"raw_contact_id", "mimetype", "data1", "data3"};
    }

    public static final Account f(Context context, int i10, boolean z10) {
        return f21809d.e(context, i10, z10);
    }

    public static final AtomicBoolean m() {
        return f21809d.h();
    }

    public final void b(String str, ArrayList<ContentProviderOperation> arrayList) {
        Uri build = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
        i.c(build);
        ContentProviderOperation.Builder newDelete = ContentProviderOperation.newDelete(ContentUris.withAppendedId(build, Long.parseLong(str)));
        i.e(newDelete, "newDelete(uri)");
        arrayList.add(newDelete.build());
    }

    public final void c(Cursor cursor, HashMap<String, String> contactNumber, HashMap<String, String> contactAddNumber, HashMap<String, String> contactEmail, Cursor cursor2, ArrayList<ContentProviderOperation> operationList) {
        i.f(contactNumber, "contactNumber");
        i.f(contactAddNumber, "contactAddNumber");
        i.f(contactEmail, "contactEmail");
        i.f(operationList, "operationList");
        if (cursor != null && cursor2 != null) {
            String rawId = cursor.getString(0);
            String string = cursor.getString(2);
            String string2 = cursor.getString(1);
            i.e(string2, "contactInDb.getString(1)");
            SimContactInfo simContactInfo = new SimContactInfo(Long.parseLong(string2), cursor.getString(2), contactNumber.get(rawId), contactAddNumber.get(rawId), contactEmail.get(rawId));
            int i10 = cursor2.getInt(cursor2.getColumnIndex(BreenoCallContract.BaseColumns._ID));
            String string3 = cursor2.getString(cursor2.getColumnIndex("name"));
            SimContactInfo simContactInfo2 = new SimContactInfo(i10, string3, cursor2.getString(cursor2.getColumnIndex("number")), cursor2.getString(cursor2.getColumnIndex("additionalNumber")), cursor2.getString(cursor2.getColumnIndex("emails")));
            if (!i.b(string3, string)) {
                ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI);
                i.e(newUpdate, "newUpdate(ContactsContract.Data.CONTENT_URI)");
                newUpdate.withSelection("mimetype = ? and raw_contact_id = ?", new String[]{"vnd.android.cursor.item/name", rawId});
                newUpdate.withValue("data2", string3);
                operationList.add(newUpdate.build());
            }
            i.e(rawId, "rawId");
            c0.x(Long.parseLong(rawId), simContactInfo, simContactInfo2, operationList);
            H7.b.b("SimContactsLoader", "update contact " + rawId + " complete");
            return;
        }
        H7.b.b("SimContactsLoader", "the contact is empty ,return");
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x03ce, code lost:
    
        r1 = r30;
     */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03af A[Catch: all -> 0x03c8, TryCatch #5 {all -> 0x03c8, blocks: (B:77:0x0405, B:154:0x0392, B:155:0x03a9, B:157:0x03af, B:159:0x03b6), top: B:153:0x0392 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03ce A[ADDED_TO_REGION, EDGE_INSN: B:165:0x03ce->B:164:0x03ce BREAK  A[LOOP:1: B:40:0x025f->B:60:0x025f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x04d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x04c5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(int r31, android.database.Cursor r32) {
        /*
            Method dump skipped, instructions count: 1332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.simcontacts.c.d(int, android.database.Cursor):void");
    }

    public final boolean e(int i10, ContentResolver contentResolver, ArrayList<ContentProviderOperation> arrayList) {
        if (i10 < 20 && arrayList.size() < 200) {
            return false;
        }
        try {
            try {
                contentResolver.applyBatch("com.android.contacts", arrayList);
                arrayList.clear();
                return true;
            } catch (Exception e10) {
                H7.b.c("SimContactsLoader", "Exception when apply barch 0 in addAllSimContactsIntoDatabase " + e10);
                arrayList.clear();
                return false;
            }
        } catch (Throwable th) {
            arrayList.clear();
            throw th;
        }
    }

    public final void g(int i10) {
        a aVar = f21809d;
        if (!aVar.g(this.f21811a)) {
            H7.b.b("SimContactsLoader", "contacts content provider not exist");
            return;
        }
        Uri build = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", b.g(i10)).appendQueryParameter("account_type", "com.android.oplus.sim").appendQueryParameter("delete_all_sim_contacts", "true").build();
        f21810e.set(true);
        try {
            this.f21811a.getContentResolver().delete(build, "account_type=? AND account_name=? AND deleted=?", aVar.f(i10));
        } catch (Exception e10) {
            H7.b.c("SimContactsLoader", "Exception when deleteDatabaseSimContacts " + e10);
        }
        f21810e.set(false);
        H7.b.b("SimContactsLoader", "deleted DatabaseSimContacts: " + i10 + " for 0 contacts");
    }

    public final void h(int i10) {
        try {
            this.f21811a.getContentResolver().delete(ContactsContract.Settings.CONTENT_URI, "account_type = 'com.android.oplus.sim' AND account_name = '" + b.g(i10) + "'", null);
        } catch (Exception e10) {
            H7.b.c("SimContactsLoader", "deleteSim() Settings.CONTENT_URI fail info:" + e10);
        }
    }

    public final void i(int i10) {
        synchronized (c.class) {
            k(i10);
            q qVar = q.f35511a;
        }
    }

    public final Cursor j(int i10) {
        Uri b10 = W3.a.b(this.f21811a, i10);
        H7.b.b("SimContactsLoader", "querySimContacts: starting an async query:" + b10 + " for " + i10);
        try {
            return this.f21811a.getContentResolver().query(b10, W3.a.a(), null, null, "_id ASC");
        } catch (Exception e10) {
            H7.b.c("SimContactsLoader", "exception when query sim contact " + e10);
            return null;
        }
    }

    public final void k(int i10) {
        H7.b.b("SimContactsLoader", "handle no sim on sub : " + i10);
        g(i10);
        h(i10);
        o(i10, 2);
    }

    public final void l(int i10) {
        H7.b.b("SimContactsLoader", "handleSimOp() at sub " + i10);
        if (!b0.m0(this.f21811a, i10)) {
            H7.b.b("SimContactsLoader", "the sim " + i10 + " is absent ,delete all contacts which account is " + b.g(i10));
            k(i10);
            return;
        }
        Cursor j10 = j(i10);
        if (j10 != null) {
            try {
                d(i10, j10);
                q qVar = q.f35511a;
                kotlin.io.a.a(j10, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.a.a(j10, th);
                    throw th2;
                }
            }
        }
    }

    public final void n(int i10) {
        synchronized (c.class) {
            l(i10);
            q qVar = q.f35511a;
        }
    }

    public final void o(int i10, int i11) {
        X.a b10 = X.a.b(this.f21811a);
        i.e(b10, "getInstance(mContext)");
        Intent intent = new Intent("contacts.intent.action.SIM_STATE_CHANGED_LOCAL");
        if (i11 != 1) {
            if (i11 != 2) {
                H7.b.b("SimContactsLoader", "unknown state");
            } else {
                b0.K0(i10, false);
            }
        } else {
            intent.putExtra("sim_state", "LOADED");
            b0.K0(i10, true);
        }
        b10.d(intent);
        H7.b.b("SimContactsLoader", "onHandleSimOpComplete  " + i10);
    }
}
