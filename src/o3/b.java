package O3;

import O3.g;
import android.app.Application;
import android.content.ContentProviderOperation;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.contacts.model.Account;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.SimContactsOrderHelper;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.C0798i;
import com.customize.contacts.util.C0810v;
import com.customize.contacts.util.C0812x;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.c0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* compiled from: ContactsProcessThreadsHelper.java */
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<IdRecord> f2679o;

    /* renamed from: p, reason: collision with root package name */
    public Account f2680p;

    /* renamed from: q, reason: collision with root package name */
    public Account f2681q;

    public b(Application application, ArrayList<IdRecord> arrayList, Account account) {
        super(application);
        this.f2679o = arrayList;
        this.f2680p = account;
        this.f2681q = null;
    }

    @Override // O3.g
    public void l() {
        Account account = this.f2681q;
        if (account != null) {
            s(this.f2679o, account.f16941a, this.f2680p);
            C0798i.c(this.f2696a);
        } else {
            r(this.f2679o, this.f2680p);
        }
        C0810v.g(null);
        C0798i.b(this.f2696a);
    }

    public final void r(ArrayList<IdRecord> arrayList, Account account) {
        int i10;
        int i11;
        int i12;
        C0812x c0812x;
        int i13;
        ArrayList<IdRecord> arrayList2 = arrayList;
        Account account2 = account;
        if (arrayList2 != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            q(size);
            this.f2702g.I(1, null, null);
            int[] iArr = new int[2];
            if (TextUtils.equals("com.android.oplus.sim", account2.f16942b)) {
                com.customize.contacts.model.a.f();
                try {
                    this.f2703h.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Exception e10) {
                    H7.b.c("ContactsProcessThread", "Exception in copyContactsFromSim when await the query sim status thread complete " + e10);
                }
                int i14 = 0;
                while (true) {
                    if (i14 == size || isInterrupted() || this.f2700e) {
                        break;
                    }
                    m(i14);
                    String d10 = com.customize.contacts.simcontacts.b.d(this.f2696a, account2.f16941a);
                    int i15 = i14;
                    int[] iArr2 = iArr;
                    C0812x b10 = c0.b(this.f2696a, arrayList2.get(i14).b(), d10, iArr, b0.P0(this.f2696a, d10));
                    boolean z10 = b10.f22187a;
                    if (H7.a.b()) {
                        H7.b.b("ContactsProcessThread", "copyContacts: to sim success? " + z10);
                    }
                    if (z10) {
                        ArrayList<ContentProviderOperation> arrayList3 = new ArrayList<>();
                        int i16 = 0;
                        while (i16 < b10.f22188b.size()) {
                            int size2 = arrayList3.size();
                            Long l10 = b10.f22188b.get(i16);
                            l10.longValue();
                            SimContactInfo simContactInfo = b10.f22189c.get(i16);
                            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI);
                            newInsert.withValue(com.customize.contacts.simcontacts.b.f21805a, l10);
                            newInsert.withValue("aggregation_mode", 3);
                            newInsert.withValue("aggregation_needed", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                            newInsert.withValue("account_name", account2.f16941a);
                            newInsert.withValue("account_type", account2.f16942b);
                            arrayList3.add(newInsert.build());
                            if (!TextUtils.isEmpty(simContactInfo.f15824d)) {
                                ContentProviderOperation.Builder newInsert2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
                                newInsert2.withValueBackReference("raw_contact_id", size2);
                                c0812x = b10;
                                newInsert2.withValue("mimetype", "vnd.android.cursor.item/name");
                                newInsert2.withValue("data2", simContactInfo.f15824d);
                                arrayList3.add(newInsert2.build());
                            } else {
                                c0812x = b10;
                            }
                            if (!TextUtils.isEmpty(simContactInfo.f15825e)) {
                                ContentProviderOperation.Builder newInsert3 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
                                newInsert3.withValueBackReference("raw_contact_id", size2);
                                newInsert3.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
                                newInsert3.withValue("data2", 2);
                                i13 = size;
                                newInsert3.withValue("data1", simContactInfo.f15825e);
                                newInsert3.withValue("data3", 1);
                                arrayList3.add(newInsert3.build());
                            } else {
                                i13 = size;
                            }
                            if (!TextUtils.isEmpty(simContactInfo.f15827g)) {
                                ContentProviderOperation.Builder newInsert4 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
                                newInsert4.withValueBackReference("raw_contact_id", size2);
                                newInsert4.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
                                newInsert4.withValue("data2", 2);
                                newInsert4.withValue("data1", simContactInfo.f15827g);
                                arrayList3.add(newInsert4.build());
                            }
                            if (!TextUtils.isEmpty(simContactInfo.f15828h)) {
                                ContentProviderOperation.Builder newInsert5 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
                                newInsert5.withValueBackReference("raw_contact_id", size2);
                                newInsert5.withValue("mimetype", "vnd.android.cursor.item/email_v2");
                                newInsert5.withValue("data2", 1);
                                newInsert5.withValue("data1", simContactInfo.f15828h);
                                arrayList3.add(newInsert5.build());
                            }
                            i16++;
                            account2 = account;
                            b10 = c0812x;
                            size = i13;
                        }
                        i11 = size;
                        if (arrayList3.size() > 0) {
                            try {
                                try {
                                    this.f2696a.getContentResolver().applyBatch("com.android.contacts", arrayList3);
                                } catch (Exception e11) {
                                    H7.b.c("ContactsProcessThread", String.format("%s: %s", e11.toString(), e11.getMessage()));
                                }
                            } finally {
                                arrayList3.clear();
                            }
                        }
                    } else {
                        i11 = size;
                    }
                    if (H7.a.b()) {
                        H7.b.b("ContactsProcessThread", "copyContacts: to db success? " + z10);
                    }
                    if (z10) {
                        a(iArr2[1]);
                        this.f2702g.I(2, null, null);
                        iArr2[1] = 0;
                        i14 = i15 + 1;
                        account2 = account;
                        iArr = iArr2;
                        size = i11;
                        arrayList2 = arrayList;
                    } else {
                        a(iArr2[1]);
                        if (c0.k() == 0) {
                            i12 = 4;
                            n(4);
                        } else {
                            i12 = 4;
                            if (c0.k() == 1) {
                                n(14);
                            } else {
                                n(8);
                            }
                        }
                        this.f2702g.I(i12, null, null);
                        iArr2[1] = 0;
                    }
                }
                com.customize.contacts.model.a.e(this.f2696a);
                return;
            }
            if (M3.c.t(account)) {
                boolean P02 = b0.P0(this.f2696a, account.f16941a);
                for (int i17 = 0; i17 != size && !isInterrupted() && !this.f2700e; i17++) {
                    m(i17);
                    if (c0.b(this.f2696a, arrayList.get(i17).b(), account.f16941a, iArr, P02).f22187a) {
                        a(iArr[1]);
                        this.f2702g.I(2, null, null);
                        iArr[1] = 0;
                    } else {
                        a(iArr[1]);
                        if (c0.k() == 0) {
                            i10 = 4;
                            n(4);
                        } else {
                            i10 = 4;
                            if (c0.k() == 1) {
                                n(14);
                            } else {
                                n(8);
                            }
                        }
                        this.f2702g.I(i10, null, null);
                        iArr[1] = 0;
                        return;
                    }
                }
                return;
            }
            com.customize.contacts.model.a.f();
            int i18 = 0;
            while (true) {
                if (i18 == size || isInterrupted() || this.f2700e) {
                    break;
                }
                m(i18);
                ArrayList<g.a> g10 = g(arrayList.get(i18).b());
                if (g10 != null) {
                    Iterator<g.a> it = g10.iterator();
                    boolean z11 = true;
                    while (it.hasNext()) {
                        g.a next = it.next();
                        if (!next.f2711c.equals(account.f16941a) || !next.f2710b.equals(account.f16942b)) {
                            z11 = com.customize.contacts.model.a.h(this.f2696a, next.f2709a, null, this.f2680p, false, iArr);
                        }
                    }
                    if (!z11) {
                        n(9);
                        this.f2702g.I(4, null, null);
                        break;
                    }
                }
                a(iArr[1]);
                this.f2702g.I(2, null, null);
                iArr[1] = 0;
                i18++;
            }
            com.customize.contacts.model.a.e(this.f2696a);
            return;
        }
        n(2);
        this.f2702g.I(4, null, null);
    }

    public final void s(ArrayList<IdRecord> arrayList, String str, Account account) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            q(size);
            this.f2702g.I(1, null, null);
            HashSet hashSet = new HashSet();
            for (int i10 = 0; i10 < size; i10++) {
                hashSet.add(Long.valueOf(arrayList.get(i10).b()));
            }
            if (account != null && TextUtils.equals("com.android.oplus.sim", account.f16942b)) {
                try {
                    this.f2703h.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Exception e10) {
                    H7.b.c("ContactsProcessThread", "Exception in copyContactsFromSim when await the query sim status thread complete " + e10);
                }
            }
            CopyOnWriteArrayList<SimContactInfo> b10 = SimContactsOrderHelper.b();
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < b10.size(); i11++) {
                try {
                    SimContactInfo simContactInfo = b10.get(i11);
                    if (simContactInfo != null && hashSet.contains(Long.valueOf(simContactInfo.f15821a))) {
                        arrayList2.add(simContactInfo);
                    }
                } catch (Exception e11) {
                    H7.b.c("ContactsProcessThread", "e = " + e11);
                }
            }
            int[] iArr = new int[2];
            com.customize.contacts.model.a.f();
            int size2 = arrayList2.size();
            int i12 = 0;
            while (true) {
                if (i12 != size2 && !isInterrupted() && !this.f2700e) {
                    m(i12);
                    SimContactInfo simContactInfo2 = (SimContactInfo) arrayList2.get(i12);
                    if (com.customize.contacts.model.a.g(this.f2696a, this.f2680p, simContactInfo2.f15824d, simContactInfo2.f15825e, simContactInfo2.f15827g, simContactInfo2.f15828h, iArr)) {
                        a(iArr[1]);
                        this.f2702g.I(2, null, null);
                        iArr[1] = 0;
                        i12++;
                    } else {
                        n(9);
                        this.f2702g.I(4, null, null);
                        break;
                    }
                } else {
                    break;
                }
            }
            com.customize.contacts.model.a.e(this.f2696a);
            return;
        }
        n(2);
        this.f2702g.I(4, null, null);
    }

    public b(Application application, ArrayList<IdRecord> arrayList, Account account, Account account2) {
        super(application);
        this.f2679o = arrayList;
        this.f2680p = account2;
        this.f2681q = account;
    }
}
