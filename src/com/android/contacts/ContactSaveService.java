package com.android.contacts;

import android.app.Activity;
import android.app.IntentService;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.contacts.model.EntityDelta;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.customize.contacts.util.C0811w;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import h1.C1074c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import n1.AbstractC1362a;

/* loaded from: classes.dex */
public class ContactSaveService extends IntentService {

    /* renamed from: d, reason: collision with root package name */
    public static final HashSet<String> f13078d = com.google.common.collect.y.e("mimetype", "is_primary", "data1", "data2", "data3", "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", "data12", "data13", "data14", "data15");

    /* renamed from: e, reason: collision with root package name */
    public static final CopyOnWriteArrayList<b> f13079e = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public static EntityDelta f13080f;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f13081a;

    /* renamed from: b, reason: collision with root package name */
    public String f13082b;

    /* renamed from: c, reason: collision with root package name */
    public String f13083c;

    /* loaded from: classes.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f13084a = {BreenoCallContract.BaseColumns._ID, "contact_id", "name_verified", "display_name_source"};
    }

    /* loaded from: classes.dex */
    public interface b {
        void C(Intent intent);
    }

    public ContactSaveService() {
        super("ContactSaveService");
        this.f13082b = null;
        this.f13083c = null;
        setIntentRedelivery(true);
        this.f13081a = new Handler(Looper.getMainLooper());
    }

    public static void A(b bVar) {
        if (!(bVar instanceof Activity)) {
            H7.b.e("ContactSaveService", "Only activities can be registered to receive callback from " + ContactSaveService.class.getName());
            return;
        }
        H7.b.b("ContactSaveService", "registerListener: " + bVar);
        f13079e.add(0, bVar);
    }

    public static void H(b bVar) {
        f13079e.remove(bVar);
    }

    public static Intent h(Context context, ArrayList<String> arrayList, boolean z10) {
        Intent intent = new Intent(context, (Class<?>) ContactSaveService.class);
        intent.setAction("clearPrimary");
        intent.putStringArrayListExtra("dataId", arrayList);
        intent.putExtra("isProfile", z10);
        return intent;
    }

    public static Intent i(Context context, long j10, long j11, boolean z10, Class<?> cls, String str) {
        Intent intent = new Intent(context, (Class<?>) ContactSaveService.class);
        intent.setAction("joinContacts");
        intent.putExtra("contactId1", j10);
        intent.putExtra("contactId2", j11);
        intent.putExtra("contactWritable", z10);
        Intent intent2 = new Intent(context, cls);
        intent2.setAction(str);
        intent.putExtra("callbackIntent", intent2);
        return intent;
    }

    public static Intent k(Context context, EntityDelta entityDelta, String str, int i10, boolean z10, Class<?> cls, String str2) {
        Intent intent = new Intent(context, (Class<?>) ContactSaveService.class);
        intent.setAction("saveContact");
        f13080f = entityDelta;
        intent.putExtra("saveIsProfile", z10);
        Intent intent2 = new Intent(context, cls);
        intent2.putExtra(str, i10);
        intent2.setAction(str2);
        intent.putExtra("callbackIntent", intent2);
        return intent;
    }

    public static Intent l(Context context, long j10) {
        Intent intent = new Intent(context, (Class<?>) ContactSaveService.class);
        intent.setAction("setSuperPrimary");
        intent.putExtra("dataId", j10);
        return intent;
    }

    public static void o() {
        f13080f = null;
    }

    public final void B() {
        ArrayList<EntityDelta.ValuesDelta> q10 = q();
        if (q10 != null && q10.size() != 0) {
            Iterator<EntityDelta.ValuesDelta> it = q10.iterator();
            while (it.hasNext()) {
                EntityDelta.ValuesDelta next = it.next();
                if (next.j("showReminder")) {
                    next.n0("showReminder");
                }
            }
        }
    }

    public final void C(Intent intent) {
        B();
        if (f13080f != null) {
            E(intent);
            com.customize.contacts.util.h0.j(getBaseContext(), q());
            f13080f = null;
        }
    }

    public final boolean D(EntityDelta entityDelta, Intent intent) {
        String z10;
        String z11;
        EntityDelta.ValuesDelta valuesDelta;
        String str;
        String str2;
        String str3;
        String str4;
        EntityDelta.ValuesDelta H10 = entityDelta.H("vnd.android.cursor.item/name");
        if (H10 == null) {
            z10 = null;
        } else {
            z10 = H10.z("data1");
        }
        ArrayList<EntityDelta.ValuesDelta> D10 = entityDelta.D("vnd.android.cursor.item/phone_v2");
        EntityDelta.ValuesDelta H11 = entityDelta.H("vnd.android.cursor.item/email_v2");
        if (H11 == null) {
            z11 = null;
        } else {
            z11 = H11.z("data1");
        }
        if (!C0811w.g(D10)) {
            Iterator<EntityDelta.ValuesDelta> it = D10.iterator();
            while (true) {
                if (it.hasNext()) {
                    valuesDelta = it.next();
                    if (valuesDelta.R() && !TextUtils.isEmpty(valuesDelta.z("data1"))) {
                        valuesDelta.b0("data3", 1);
                        break;
                    }
                } else {
                    valuesDelta = null;
                    break;
                }
            }
            if (valuesDelta == null) {
                valuesDelta = D10.get(0);
            }
        } else {
            valuesDelta = null;
        }
        if (valuesDelta != null) {
            str = valuesDelta.z("data1");
        } else {
            str = null;
        }
        if (str != null && !C0811w.g(D10) && D10.size() > 1) {
            Iterator<EntityDelta.ValuesDelta> it2 = D10.iterator();
            while (it2.hasNext()) {
                EntityDelta.ValuesDelta next = it2.next();
                if (next != valuesDelta) {
                    str2 = next.z("data1");
                    break;
                }
            }
        }
        str2 = null;
        H7.b.b("ContactSaveService", "saveContactToSimCard(), phone = " + H7.a.d(str));
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(z10) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(z11)) {
            return true;
        }
        if (TextUtils.equals("com.android.oplus.sim", this.f13082b)) {
            str3 = com.customize.contacts.simcontacts.b.d(getApplicationContext(), this.f13083c);
        } else {
            str3 = this.f13083c;
        }
        String str5 = str3;
        if (entityDelta.Y()) {
            entityDelta.N().b0("aggregation_mode", 3);
            int K10 = com.customize.contacts.util.b0.K(getApplicationContext(), str5);
            Uri v10 = v(this, z10, str, str2, z11, K10, com.customize.contacts.util.b0.P0(getApplicationContext(), str5));
            if (v10 == null) {
                int R10 = com.customize.contacts.util.b0.R(this, K10);
                com.customize.contacts.util.c0.w(R10);
                H7.b.b("ContactSaveService", "saveContactToSimCard(), insert failed!!!, phone:" + H7.a.d(str) + ", index:" + R10);
                return false;
            }
            long parseId = ContentUris.parseId(v10);
            if (B3.a.o()) {
                parseId--;
            }
            entityDelta.N().e0("account_name", this.f13083c);
            if (TextUtils.equals("com.oplus.contacts.sim", this.f13082b) || TextUtils.equals("com.android.oplus.sim", this.f13082b)) {
                SimContactInfo simContactInfo = new SimContactInfo(parseId, z10, str, str2, z11);
                simContactInfo.f(str5);
                simContactInfo.j(parseId);
                intent.putExtra("sim_contacts_info", simContactInfo);
            }
            intent.setData(v10);
            com.android.contacts.framework.api.infocollection.a.c();
            return true;
        }
        H7.b.b("ContactSaveService", "saveContactToSimCard(), state.getValues() = " + entityDelta.N());
        long j10 = 0;
        if (entityDelta.N().H()) {
            if (TextUtils.equals(this.f13082b, "com.android.oplus.sim")) {
                Integer v11 = entityDelta.N().v(com.customize.contacts.simcontacts.b.f21805a);
                if (v11 != null) {
                    j10 = v11.intValue();
                }
            } else {
                j10 = entityDelta.N().E().longValue();
            }
            H7.b.b("ContactSaveService", "saveContactToSimCard(), delete, rawContactId = " + j10 + "AccountName:" + this.f13083c);
            return com.customize.contacts.util.b0.f(this, j10, str5);
        }
        entityDelta.N().b0("aggregation_mode", 3);
        if (TextUtils.equals("com.android.oplus.sim", this.f13082b)) {
            Integer v12 = entityDelta.N().v(com.customize.contacts.simcontacts.b.f21805a);
            if (v12 != null) {
                j10 = v12.intValue();
            }
        } else {
            Long E10 = entityDelta.N().E();
            if (E10 != null) {
                j10 = E10.longValue();
            }
        }
        long j11 = j10;
        H7.b.b("ContactSaveService", "saveContactToSimCard(), update, rawContactId = " + j11 + "AccountName:" + this.f13083c);
        Uri I02 = com.customize.contacts.util.b0.I0(getBaseContext(), com.customize.contacts.util.b0.K(getBaseContext(), str5));
        if (!TextUtils.equals("com.oplus.contacts.sim", this.f13082b) && !TextUtils.equals("com.android.oplus.sim", this.f13082b)) {
            str4 = str5;
        } else {
            str4 = str5;
            SimContactInfo simContactInfo2 = new SimContactInfo(j11, z10, str, str2, z11);
            simContactInfo2.f(str4);
            simContactInfo2.j(j11);
            intent.putExtra("sim_contacts_info", simContactInfo2);
        }
        intent.setData(I02);
        return com.customize.contacts.util.b0.O0(this, j11, z10, str, str2, z11, str4);
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x0362 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0380  */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(android.content.Intent r31) {
        /*
            Method dump skipped, instructions count: 951
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.ContactSaveService.E(android.content.Intent):void");
    }

    public final void F(Intent intent) {
        long f10 = C7.e.f(intent, "dataId", -1L);
        if (f10 == -1) {
            H7.b.c("ContactSaveService", "Invalid arguments for setSuperPrimary request");
            return;
        }
        if (H7.a.b()) {
            H7.b.b("ContactSaveService", "clearPrimary dataId  = " + f10);
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("is_super_primary", (Integer) 1);
        contentValues.put("is_primary", (Integer) 1);
        G7.c.g(getContentResolver(), R0.d.a(ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, f10)), contentValues, null, null);
    }

    public final void G(final int i10) {
        this.f13081a.post(new Runnable() { // from class: com.android.contacts.l
            @Override // java.lang.Runnable
            public final void run() {
                ContactSaveService.this.z(i10);
            }
        });
    }

    public final void d(ArrayList<ContentProviderOperation> arrayList, int i10, String str, String str2) {
        ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(R0.d.f3216c);
        newUpdate.withValueBackReference(BreenoCallContract.BaseColumns._ID, i10);
        newUpdate.withValue("custom_ringtone", str);
        if (com.customize.contacts.manager.h.g()) {
            newUpdate.withValue("custom_vibration", str2);
        }
        arrayList.add(newUpdate.build());
    }

    public final int e(ArrayList<ContentProviderOperation> arrayList, String str, String str2, boolean z10, long j10) {
        int size = arrayList.size();
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(R0.d.f3215b));
        if (j10 != -1) {
            newInsert.withValue(BreenoCallContract.BaseColumns._ID, Long.valueOf(j10));
        } else {
            int i10 = -1;
            for (int i11 = 0; i11 < size; i11++) {
                ContentProviderOperation contentProviderOperation = arrayList.get(i11);
                try {
                    if (C7.b.a(30, 1)) {
                        new com.oplus.wrapper.content.ContentProviderOperation(contentProviderOperation).getType();
                    } else {
                        J6.a.a(contentProviderOperation);
                    }
                } catch (UnSupportedApiVersionException e10) {
                    H7.b.c("ContactSaveService", "UnSupportedApiVersionException e: " + e10);
                }
                if (contentProviderOperation.isInsert() && contentProviderOperation.getUri().getEncodedPath().contains(ContactsContract.RawContacts.CONTENT_URI.getEncodedPath())) {
                    i10 = i11;
                }
            }
            newInsert.withValueBackReference(BreenoCallContract.BaseColumns._ID, i10);
        }
        arrayList.add(newInsert.build());
        if (z10) {
            d(arrayList, size, str, str2);
        }
        return size;
    }

    public final void f(ArrayList<ContentProviderOperation> arrayList, long j10, long j11) {
        ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI);
        newUpdate.withValue(OplusAutoRedialNotificationUI.TYPE, 1);
        newUpdate.withValue("raw_contact_id1", Long.valueOf(j10));
        newUpdate.withValue("raw_contact_id2", Long.valueOf(j11));
        arrayList.add(newUpdate.build());
    }

    public final void g(Intent intent) {
        Uri uri;
        ArrayList<String> k10 = C7.e.k(intent, "dataId");
        boolean c10 = C7.e.c(intent, "isProfile", false);
        if (k10 != null && k10.size() != 0) {
            StringBuilder sb = new StringBuilder("_id IN(");
            int i10 = 0;
            boolean z10 = true;
            while (i10 < k10.size()) {
                if (H7.a.b()) {
                    H7.b.b("ContactSaveService", "clearPrimary dataId  = " + k10.get(i10));
                }
                if (!z10) {
                    sb.append(',');
                }
                sb.append(k10.get(i10));
                i10++;
                z10 = false;
            }
            sb.append(")");
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("is_super_primary", (Integer) 0);
            contentValues.put("is_primary", (Integer) 0);
            ContentResolver contentResolver = getContentResolver();
            if (c10) {
                uri = ContactsContract.Profile.CONTENT_URI.buildUpon().appendPath("data").build();
            } else {
                uri = ContactsContract.Data.CONTENT_URI;
            }
            G7.c.g(contentResolver, R0.d.a(uri), contentValues, sb.toString(), null);
            return;
        }
        H7.b.c("ContactSaveService", "Invalid arguments for clearPrimary request");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if (systemService != null) {
            return systemService;
        }
        return getApplicationContext().getSystemService(str);
    }

    public final void j(Intent intent) {
        ContentProviderResult[] contentProviderResultArr;
        String l10 = C7.e.l(intent, "accountName");
        String l11 = C7.e.l(intent, "accountType");
        String l12 = C7.e.l(intent, "dataSet");
        ArrayList i10 = C7.e.i(intent, "contentValues");
        Intent intent2 = (Intent) C7.e.j(intent, "callbackIntent");
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(ContentProviderOperation.newInsert(R0.d.a(ContactsContract.RawContacts.CONTENT_URI)).withValue("account_name", l10).withValue("account_type", l11).withValue("data_set", l12).build());
        int size = i10.size();
        for (int i11 = 0; i11 < size; i11++) {
            ContentValues contentValues = (ContentValues) i10.get(i11);
            contentValues.keySet().retainAll(f13078d);
            arrayList.add(ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI)).withValueBackReference("raw_contact_id", 0).withValues(contentValues).build());
        }
        ContentResolver contentResolver = getContentResolver();
        try {
            contentProviderResultArr = contentResolver.applyBatch("com.android.contacts", arrayList);
        } catch (Exception e10) {
            H7.b.c("ContactSaveService", "Failed to store new contact" + e10);
            contentProviderResultArr = null;
        }
        if (contentProviderResultArr != null) {
            intent2.setData(ContactsContract.RawContacts.getContactLookupUri(contentResolver, contentProviderResultArr[0].uri));
            m(intent2);
        }
    }

    public final void m(final Intent intent) {
        this.f13081a.post(new Runnable() { // from class: com.android.contacts.m
            @Override // java.lang.Runnable
            public final void run() {
                ContactSaveService.this.x(intent);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(Intent intent) {
        Iterator<b> it = f13079e.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (intent.getComponent().equals(((Activity) next).getIntent().getComponent())) {
                next.C(intent);
            }
        }
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (intent == null) {
            H7.b.b("ContactSaveService", "onHandleIntent: could not handle null intent");
            return;
        }
        String action = intent.getAction();
        if ("newRawContact".equals(action)) {
            j(intent);
            return;
        }
        if ("saveContact".equals(action)) {
            C(intent);
            return;
        }
        if ("setSuperPrimary".equals(action)) {
            F(intent);
        } else if ("clearPrimary".equals(action)) {
            g(intent);
        } else if ("joinContacts".equals(action)) {
            w(intent);
        }
    }

    public final int p(ArrayList<ContentProviderOperation> arrayList, ContentProviderResult[] contentProviderResultArr) {
        int size = arrayList.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            ContentProviderOperation contentProviderOperation = arrayList.get(i11);
            try {
                if (C7.b.a(30, 1)) {
                    new com.oplus.wrapper.content.ContentProviderOperation(contentProviderOperation).getType();
                } else {
                    J6.a.a(contentProviderOperation);
                }
            } catch (UnSupportedApiVersionException e10) {
                H7.b.c("ContactSaveService", "UnSupportedApiVersionException e: " + e10);
            }
            if (contentProviderOperation.isDelete() && contentProviderOperation.getUri().getEncodedPath().contains(ContactsContract.RawContacts.CONTENT_URI.getEncodedPath()) && contentProviderResultArr[i11].count.intValue() > 0) {
                i10 += contentProviderResultArr[i11].count.intValue();
            }
        }
        return i10;
    }

    public final ArrayList<EntityDelta.ValuesDelta> q() {
        ArrayList<EntityDelta.ValuesDelta> arrayList = new ArrayList<>();
        EntityDelta entityDelta = f13080f;
        if (entityDelta != null) {
            return entityDelta.D("vnd.android.cursor.item/contact_event");
        }
        return arrayList;
    }

    public final long r(EntityDelta entityDelta, ArrayList<ContentProviderOperation> arrayList, ContentProviderResult[] contentProviderResultArr, ArrayList<Long> arrayList2) {
        if (entityDelta.W()) {
            return -1L;
        }
        long s10 = s(entityDelta, arrayList2);
        if (s10 != -1) {
            return s10;
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ContentProviderOperation contentProviderOperation = arrayList.get(i10);
            try {
                if (C7.b.a(30, 1)) {
                    new com.oplus.wrapper.content.ContentProviderOperation(contentProviderOperation).getType();
                } else {
                    J6.a.a(contentProviderOperation);
                }
            } catch (UnSupportedApiVersionException e10) {
                H7.b.c("ContactSaveService", "UnSupportedApiVersionException e: " + e10);
            }
            if (contentProviderOperation.isInsert() && contentProviderOperation.getUri().getEncodedPath().contains(ContactsContract.RawContacts.CONTENT_URI.getEncodedPath()) && contentProviderResultArr != null && i10 < contentProviderResultArr.length) {
                return ContentUris.parseId(contentProviderResultArr[i10].uri);
            }
        }
        return -1L;
    }

    public final long s(EntityDelta entityDelta, ArrayList<Long> arrayList) {
        Long E10 = entityDelta.N().E();
        if (E10 == null) {
            E10 = -1L;
        }
        if (arrayList.contains(E10) || (-1 != E10.longValue() && entityDelta.K() == E10.longValue())) {
            boolean z10 = false;
            ArrayList<Long> v10 = entityDelta.v(false);
            int i10 = 0;
            while (true) {
                if (i10 >= v10.size()) {
                    break;
                }
                Long l10 = v10.get(i10);
                long longValue = l10.longValue();
                if (!arrayList.contains(l10) && longValue != entityDelta.K()) {
                    E10 = v10.get(i10);
                    z10 = true;
                    break;
                }
                i10++;
            }
            if (!z10) {
                E10 = Long.valueOf(entityDelta.K());
            }
        }
        return E10.longValue();
    }

    public boolean t() {
        return com.android.contacts.model.d.p(f13080f, AbstractC1362a.h(this));
    }

    public boolean u() {
        if (f13080f != null) {
            AbstractC1362a h10 = AbstractC1362a.h(this);
            EntityDelta.ValuesDelta N10 = f13080f.N();
            return com.android.contacts.model.d.s(f13080f, h10.c(N10.z("account_type"), N10.z("data_set")));
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.net.Uri v(final android.content.Context r12, final java.lang.String r13, final java.lang.String r14, final java.lang.String r15, final java.lang.String r16, final int r17, final boolean r18) {
        /*
            r11 = this;
            boolean r0 = H7.a.b()
            java.lang.String r1 = "ContactSaveService"
            if (r0 == 0) goto Ld
            java.lang.String r0 = "insertToSim begin."
            H7.b.b(r1, r0)
        Ld:
            r0 = 1
            java.util.concurrent.ExecutorService r2 = java.util.concurrent.Executors.newFixedThreadPool(r0)
            com.android.contacts.k r0 = new com.android.contacts.k
            r3 = r0
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r10 = r18
            r3.<init>()
            java.util.concurrent.Future r0 = r2.submit(r0)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36 java.lang.InterruptedException -> L3f java.util.concurrent.TimeoutException -> L45
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36 java.lang.InterruptedException -> L3f java.util.concurrent.TimeoutException -> L45
            r4 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r0 = r0.get(r4, r3)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36 java.lang.InterruptedException -> L3f java.util.concurrent.TimeoutException -> L45
            android.net.Uri r0 = (android.net.Uri) r0     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36 java.lang.InterruptedException -> L3f java.util.concurrent.TimeoutException -> L45
            r2.shutdown()
            goto L4c
        L34:
            r0 = move-exception
            goto L67
        L36:
            java.lang.String r0 = "isAppInstalled has an error."
            H7.b.c(r1, r0)     // Catch: java.lang.Throwable -> L34
        L3b:
            r2.shutdown()
            goto L4b
        L3f:
            java.lang.String r0 = "isAppInstalled is interrupted."
            H7.b.c(r1, r0)     // Catch: java.lang.Throwable -> L34
            goto L3b
        L45:
            java.lang.String r0 = "isAppInstalled is time out."
            H7.b.c(r1, r0)     // Catch: java.lang.Throwable -> L34
            goto L3b
        L4b:
            r0 = 0
        L4c:
            boolean r2 = H7.a.b()
            if (r2 == 0) goto L66
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "insertToSim end.Uri = "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            H7.b.b(r1, r2)
        L66:
            return r0
        L67:
            r2.shutdown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.ContactSaveService.v(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean):android.net.Uri");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[Catch: Exception -> 0x0188, SYNTHETIC, TRY_LEAVE, TryCatch #7 {Exception -> 0x0188, blocks: (B:32:0x0198, B:31:0x0195, B:93:0x0184, B:25:0x018f), top: B:6:0x002c, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0171 A[Catch: all -> 0x0145, TryCatch #3 {all -> 0x0145, blocks: (B:89:0x0167, B:91:0x0171, B:92:0x0181, B:105:0x013e, B:99:0x0151), top: B:83:0x0114 }] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r2v1, types: [long] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(android.content.Intent r26) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.ContactSaveService.w(android.content.Intent):void");
    }

    public final /* synthetic */ void x(Intent intent) {
        H7.b.b("ContactSaveService", "run: ");
        n(intent);
    }

    public final /* synthetic */ void z(int i10) {
        try {
            com.oplus.foundation.util.ui.c.b(this, i10);
        } catch (Exception e10) {
            H7.b.c("ContactSaveService", "exception when show long toast " + e10);
        }
    }

    /* loaded from: classes.dex */
    public final class c extends AsyncTask<Integer, Void, Object> {

        /* renamed from: a, reason: collision with root package name */
        public String f13085a;

        public c(String str) {
            this.f13085a = str;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object doInBackground(Integer... numArr) {
            ContactSaveService contactSaveService = ContactSaveService.this;
            String b10 = C1074c.b(contactSaveService);
            com.android.contacts.calllog.y i10 = new com.android.contacts.calllog.A(contactSaveService, null).i(this.f13085a);
            if (i10 == null) {
                H7.b.c("ContactSaveService", "doInBackground, we should not be here!");
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", i10.f14058c);
            contentValues.put("lookup_uri", U7.g.c(i10.f14057b));
            contentValues.put("photo_id", Long.valueOf(i10.f14066k));
            try {
                String str = this.f13085a;
                contactSaveService.getContentResolver().update(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, contentValues, "number = ? OR matched_number = ? AND countryiso = '" + b10 + "'", new String[]{str, str});
            } catch (Exception e10) {
                H7.b.c("ContactSaveService", "Exception e: " + e10);
            }
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Object obj) {
        }
    }
}
