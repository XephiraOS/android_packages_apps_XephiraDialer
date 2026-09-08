package com.customize.contacts.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.coloros.contacts.common.ContactParcelable;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.util.C0808t;
import com.customize.contacts.util.C0814z;
import com.customize.contacts.util.ContactsPhonesUtils$PhoneItem;
import com.oplus.dialer.R;
import java.util.ArrayList;
import o1.C1393c;

/* loaded from: classes3.dex */
public class MultiContactsSendSmsActivity extends BasicActivity {

    /* renamed from: F, reason: collision with root package name */
    public static final String[] f20504F = {"contact_id", "data1", "data2", "data3", "display_name", "is_super_primary", "mimetype"};

    /* renamed from: G, reason: collision with root package name */
    public static final String[] f20505G = {BreenoCallContract.BaseColumns._ID};

    /* renamed from: E, reason: collision with root package name */
    public C1393c f20510E;

    /* renamed from: p, reason: collision with root package name */
    public int f20512p;

    /* renamed from: q, reason: collision with root package name */
    public String f20513q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence[] f20514r;

    /* renamed from: x, reason: collision with root package name */
    public ArrayList<ContactParcelable> f20515x;

    /* renamed from: y, reason: collision with root package name */
    public a f20516y;

    /* renamed from: o, reason: collision with root package name */
    public final Handler f20511o = new Handler(Looper.getMainLooper());

    /* renamed from: z, reason: collision with root package name */
    public Bundle f20517z = null;

    /* renamed from: A, reason: collision with root package name */
    public final Object f20506A = new Object();

    /* renamed from: B, reason: collision with root package name */
    public boolean f20507B = false;

    /* renamed from: C, reason: collision with root package name */
    public boolean f20508C = true;

    /* renamed from: D, reason: collision with root package name */
    public androidx.appcompat.app.b f20509D = null;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f20518a;

        /* renamed from: b, reason: collision with root package name */
        public final Intent f20519b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f20520c = false;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f20521d;

        public a(int i10, Intent intent) {
            this.f20518a = i10;
            this.f20519b = intent;
            this.f20521d = C7.e.c(intent, "contain_email", false);
        }

        public void a() {
            this.f20520c = true;
        }

        public final void b(ArrayList<C0808t> arrayList) {
            MultiContactsSendSmsActivity.this.f20511o.post(new b(arrayList));
        }

        @Override // java.lang.Runnable
        public void run() {
            String C12;
            ArrayList<C0808t> E12;
            int i10 = this.f20518a;
            if (i10 != 1) {
                if (i10 != 2 && i10 != 3) {
                    C12 = null;
                } else {
                    C12 = G7.b.a(C7.e.e(this.f20519b, "CONTACTS_IDS_ARRAY"));
                }
            } else {
                C12 = MultiContactsSendSmsActivity.C1(MultiContactsSendSmsActivity.this, C7.e.e(this.f20519b, "GROUPS_IDS_ARRAY"));
            }
            if (TextUtils.isEmpty(C12)) {
                C12 = "(-1)";
            }
            if (H7.a.b()) {
                H7.b.b("MultiContactsSend", "QueryContactsRunnable(), id_set = " + C12);
            }
            if (!this.f20520c) {
                MultiContactsSendSmsActivity.this.f20515x = new ArrayList();
                boolean z10 = false;
                if (2 == C7.e.d(this.f20519b, "group_mode", 0)) {
                    if (com.android.contacts.group.l.g()) {
                        MultiContactsSendSmsActivity multiContactsSendSmsActivity = MultiContactsSendSmsActivity.this;
                        E12 = com.android.contacts.group.l.e(multiContactsSendSmsActivity, multiContactsSendSmsActivity.f20510E, C12, MultiContactsSendSmsActivity.this.f20515x, C7.e.l(this.f20519b, "city_name"));
                    } else {
                        MultiContactsSendSmsActivity multiContactsSendSmsActivity2 = MultiContactsSendSmsActivity.this;
                        E12 = MultiContactsSendSmsActivity.F1(multiContactsSendSmsActivity2, C12, multiContactsSendSmsActivity2.f20515x, C7.e.l(this.f20519b, "group_areano"));
                    }
                } else {
                    MultiContactsSendSmsActivity multiContactsSendSmsActivity3 = MultiContactsSendSmsActivity.this;
                    ArrayList arrayList = multiContactsSendSmsActivity3.f20515x;
                    boolean z11 = this.f20521d;
                    if (this.f20518a == 3) {
                        z10 = true;
                    }
                    E12 = MultiContactsSendSmsActivity.E1(multiContactsSendSmsActivity3, C12, arrayList, z11, z10);
                }
                b(E12);
            }
            MultiContactsSendSmsActivity.this.f20507B = true;
            synchronized (MultiContactsSendSmsActivity.this.f20506A) {
                MultiContactsSendSmsActivity.this.f20506A.notifyAll();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList<C0808t> f20523a;

        public b(ArrayList<C0808t> arrayList) {
            this.f20523a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size;
            int i10;
            MultiContactsSendSmsActivity.this.B1();
            ArrayList<C0808t> arrayList = this.f20523a;
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            if (size + MultiContactsSendSmsActivity.this.f20515x.size() > 200) {
                if (!MultiContactsSendSmsActivity.this.f20508C) {
                    i10 = R.string.too_many_contacts_tips;
                } else {
                    i10 = R.string.too_many_recipients;
                }
                MultiContactsSendSmsActivity multiContactsSendSmsActivity = MultiContactsSendSmsActivity.this;
                multiContactsSendSmsActivity.I1(multiContactsSendSmsActivity.getString(i10, 200));
                MultiContactsSendSmsActivity.this.finish();
                return;
            }
            ArrayList<C0808t> arrayList2 = this.f20523a;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                Intent intent = new Intent(MultiContactsSendSmsActivity.this, (Class<?>) MultiPhonesSelectActivity.class);
                MultiPhonesSelectActivity.f20525B.addAll(this.f20523a);
                intent.putExtra("mode", MultiContactsSendSmsActivity.this.f20512p);
                if (MultiContactsSendSmsActivity.this.f20517z == null) {
                    Q7.b.b(MultiContactsSendSmsActivity.this, intent, 10, 0);
                    return;
                }
                return;
            }
            MultiContactsSendSmsActivity multiContactsSendSmsActivity2 = MultiContactsSendSmsActivity.this;
            multiContactsSendSmsActivity2.G1(multiContactsSendSmsActivity2.f20515x);
            MultiContactsSendSmsActivity.this.finish();
        }
    }

    public static String C1(Context context, long[] jArr) {
        if (jArr != null && jArr.length != 0) {
            String str = "group_id IN " + G7.b.a(jArr);
            ArrayList arrayList = new ArrayList();
            try {
                Cursor query = context.getContentResolver().query(C0814z.f22204b, f20505G, str, null, BreenoCallContract.BaseColumns._ID);
                if (query != null) {
                    long j10 = 0;
                    while (query.moveToNext()) {
                        try {
                            long j11 = query.getLong(0);
                            if (j11 != j10) {
                                arrayList.add(Long.valueOf(j11));
                                j10 = j11;
                            }
                        } finally {
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e10) {
                H7.b.c("MultiContactsSend", "getGroupsContactsIdsSet: exception: " + e10);
            }
            return G7.a.d(arrayList);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    public static ArrayList<C0808t> E1(Context context, String str, ArrayList<ContactParcelable> arrayList, boolean z10, boolean z11) {
        String str2;
        Cursor cursor;
        long j10;
        long j11;
        ?? r62;
        long j12;
        int i10;
        int i11;
        ArrayList<ContactParcelable> arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
        if (z11) {
            str2 = "contact_id IN " + str + " AND  mimetype='vnd.android.cursor.item/email_v2'";
        } else if (z10) {
            str2 = "contact_id IN " + str + " AND  mimetype in ('vnd.android.cursor.item/phone_v2','vnd.android.cursor.item/email_v2') ";
        } else {
            str2 = "contact_id IN " + str + " AND  mimetype in ('vnd.android.cursor.item/phone_v2') ";
        }
        C0808t c0808t = null;
        try {
            cursor = context.getContentResolver().query(ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter(R0.c.f3185c, "true").build(), f20504F, str2, null, "contact_id");
        } catch (Exception e10) {
            H7.b.c("MultiContactsSend", "" + e10);
            cursor = null;
        }
        if (cursor == null) {
            return null;
        }
        ArrayList<C0808t> arrayList3 = new ArrayList<>();
        try {
            int i12 = -1;
            int i13 = 0;
            if (cursor.moveToFirst()) {
                j10 = cursor.getLong(0);
                cursor.move(-1);
            } else {
                j10 = -1;
            }
            C0808t c0808t2 = null;
            while (cursor.moveToNext()) {
                long j13 = cursor.getLong(i13);
                if (j13 != j10 && c0808t2 != null) {
                    int size = c0808t2.f22181c.size();
                    if (size == 1) {
                        ContactParcelable contactParcelable = new ContactParcelable();
                        contactParcelable.t(c0808t2.f22179a);
                        contactParcelable.w(c0808t2.f22181c.get(i13).f21872e);
                        contactParcelable.q(c0808t2.f22180b);
                        arrayList2.add(contactParcelable);
                    } else if (size > 1) {
                        int i14 = i12;
                        int i15 = i13;
                        int i16 = i15;
                        while (i15 < size) {
                            if (c0808t2.f22181c.get(i15).f21874g == 1) {
                                i16++;
                                i14 = i15;
                            }
                            i15++;
                        }
                        if (i14 != i12) {
                            ContactParcelable contactParcelable2 = new ContactParcelable();
                            contactParcelable2.t(c0808t2.f22179a);
                            contactParcelable2.w(c0808t2.f22181c.get(i14).f21872e);
                            contactParcelable2.q(c0808t2.f22180b);
                            if (i16 > 1) {
                                ArrayList<ContactsPhonesUtils$PhoneItem> arrayList4 = new ArrayList<>();
                                for (int i17 = i13; i17 < size; i17++) {
                                    if (c0808t2.f22181c.get(i17).f21874g == 1) {
                                        arrayList4.add(c0808t2.f22181c.get(i17));
                                    }
                                }
                                c0808t2.f22181c = arrayList4;
                                c0808t2.f22180b = j13;
                                arrayList4.get(i13).b(true);
                                arrayList3.add(c0808t2);
                            } else {
                                arrayList2.add(contactParcelable2);
                            }
                        } else {
                            c0808t2.f22181c.get(i13).b(true);
                            arrayList3.add(c0808t2);
                        }
                    }
                    if (!cursor.moveToPrevious()) {
                        cursor.move(i12);
                    }
                    i11 = i13;
                    c0808t2 = c0808t;
                    i10 = i12;
                } else {
                    if (c0808t2 == null) {
                        c0808t2 = new C0808t();
                    }
                    String string = cursor.getString(1);
                    int i18 = cursor.getInt(2);
                    String string2 = cursor.getString(3);
                    c0808t2.f22179a = cursor.getString(4);
                    c0808t2.f22180b = j13;
                    int i19 = cursor.getInt(5);
                    if (c0808t2.a(string)) {
                        j11 = j10;
                        r62 = 1;
                        j12 = j13;
                    } else {
                        String string3 = cursor.getString(6);
                        j11 = j10;
                        r62 = 1;
                        j12 = j13;
                        ContactsPhonesUtils$PhoneItem contactsPhonesUtils$PhoneItem = new ContactsPhonesUtils$PhoneItem(j13, string, string2, i18, false);
                        contactsPhonesUtils$PhoneItem.f(i19);
                        contactsPhonesUtils$PhoneItem.d(string3);
                        contactsPhonesUtils$PhoneItem.f21870c = c0808t2.f22179a;
                        c0808t2.f22181c.add(contactsPhonesUtils$PhoneItem);
                    }
                    if (cursor.isLast()) {
                        int size2 = c0808t2.f22181c.size();
                        if (size2 == r62) {
                            ContactParcelable contactParcelable3 = new ContactParcelable();
                            contactParcelable3.t(c0808t2.f22179a);
                            contactParcelable3.w(c0808t2.f22181c.get(0).f21872e);
                            contactParcelable3.q(c0808t2.f22180b);
                            arrayList2.add(contactParcelable3);
                        } else if (size2 > r62) {
                            int i20 = 0;
                            int i21 = -1;
                            for (int i22 = 0; i22 < size2; i22++) {
                                if (c0808t2.f22181c.get(i22).f21874g == r62) {
                                    i20++;
                                    i21 = i22;
                                }
                            }
                            i10 = -1;
                            if (i21 != -1 && i20 < 2) {
                                ContactParcelable contactParcelable4 = new ContactParcelable();
                                contactParcelable4.t(c0808t2.f22179a);
                                contactParcelable4.w(c0808t2.f22181c.get(i21).f21872e);
                                contactParcelable4.q(c0808t2.f22180b);
                                arrayList2.add(contactParcelable4);
                            } else if (i20 >= 2) {
                                ArrayList<ContactsPhonesUtils$PhoneItem> arrayList5 = new ArrayList<>();
                                for (int i23 = 0; i23 < size2; i23++) {
                                    if (c0808t2.f22181c.get(i23).f21874g == r62) {
                                        arrayList5.add(c0808t2.f22181c.get(i23));
                                    }
                                }
                                c0808t2.f22181c = arrayList5;
                                c0808t2.f22180b = j12;
                                arrayList5.get(0).b(r62);
                                arrayList3.add(c0808t2);
                            } else {
                                i11 = 0;
                                c0808t2.f22181c.get(0).b(r62);
                                arrayList3.add(c0808t2);
                                j13 = j11;
                            }
                            i11 = 0;
                            j13 = j11;
                        }
                    }
                    i10 = -1;
                    i11 = 0;
                    j13 = j11;
                }
                i12 = i10;
                i13 = i11;
                j10 = j13;
                c0808t = null;
            }
            cursor.close();
            return arrayList3;
        } catch (Throwable th) {
            cursor.close();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x00aa, code lost:
    
        if (r8 == null) goto L25;
     */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0082: MOVE (r4 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:131), block:B:169:0x0082 */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0332  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<com.customize.contacts.util.C0808t> F1(android.content.Context r24, java.lang.String r25, java.util.ArrayList<com.coloros.contacts.common.ContactParcelable> r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 828
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.activities.MultiContactsSendSmsActivity.F1(android.content.Context, java.lang.String, java.util.ArrayList, java.lang.String):java.util.ArrayList");
    }

    public void B1() {
        androidx.appcompat.app.b bVar = this.f20509D;
        if (bVar != null && bVar.isShowing()) {
            this.f20509D.dismiss();
        }
        this.f20509D = null;
    }

    public final Dialog D1() {
        String str = this.f20513q;
        if (TextUtils.isEmpty(str)) {
            str = getString(android.R.string.unknownName);
        }
        if (this.f20514r == null) {
            return null;
        }
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this);
        cOUIAlertDialogBuilder.setTitle((CharSequence) str).setSingleChoiceItems(this.f20514r, -1, (DialogInterface.OnClickListener) null).setOnCancelListener(null).setPositiveButton(R.string.skip_current, (DialogInterface.OnClickListener) null).setNegativeButton(R.string.cancel_send, (DialogInterface.OnClickListener) null);
        return cOUIAlertDialogBuilder.show();
    }

    public final void G1(ArrayList<ContactParcelable> arrayList) {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("SELECTED_CONTACTS", arrayList);
        setResult(-1, intent);
    }

    public final void H1(ArrayList<ContactParcelable> arrayList, boolean z10) {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("SELECTED_CONTACTS", arrayList);
        intent.putExtra("click_complete", z10);
        setResult(-1, intent);
    }

    public final void I1(String str) {
        com.oplus.foundation.util.ui.c.e(this, str);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (-1 == i11 && 10 == i10 && intent != null) {
            ArrayList i12 = C7.e.i(intent, "SELECTED_CONTACTS");
            if (this.f20515x == null) {
                this.f20515x = new ArrayList<>();
            }
            if (i12 != null && i12.size() > 0) {
                this.f20515x.addAll(i12);
            }
            H1(this.f20515x, true);
        }
        finish();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f20510E = new C1393c(P7.a.f2962b);
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("com.oplus.contacts.ui.GET_CONTACTS_PHONES_FOR_SMS_2".equals(action)) {
            this.f20512p = 2;
        } else if ("com.oplus.contacts.ui.GET_GROUPS_CONTACTS_PHONES_FOR_SMS".equals(action)) {
            this.f20512p = 1;
        } else if ("com.oplus.contacts.ui.GET_CONTACTS_EMAILS_FOR_EMAIL".equals(action)) {
            this.f20512p = 3;
        }
        this.f20508C = intent.getBooleanExtra("from_sms", true);
        this.f20517z = bundle;
        this.f20507B = false;
        this.f20516y = new a(this.f20512p, intent);
        new Thread(this.f20516y, "queryforgroupsms").start();
        synchronized (this.f20506A) {
            try {
                this.f20506A.wait(1000L);
            } catch (InterruptedException unused) {
            }
        }
        if (!this.f20507B) {
            this.f20509D = U0.k.o(this, getString(R.string.in_processing));
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10) {
        if (i10 == 30) {
            return D1();
        }
        return super.onCreateDialog(i10);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        a aVar = this.f20516y;
        if (aVar != null) {
            aVar.a();
        }
        B1();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.android.contacts.framework.baseui.util.A.g(this);
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i10, Dialog dialog, Bundle bundle) {
        super.onPrepareDialog(i10, dialog, bundle);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.android.contacts.framework.baseui.util.A.h(this);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
