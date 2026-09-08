package com.android.contacts.group;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.coloros.contacts.common.ContactParcelable;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.SmartGroupActivity;
import com.customize.contacts.util.C0808t;
import com.customize.contacts.util.ContactsPhonesUtils$PhoneItem;
import com.oplus.dialer.R;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.Result;
import m9.q;
import o1.C1393c;

/* compiled from: LargeContactsLocationGroupStrategy.kt */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f16689a = new l();

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f16690b = {BreenoCallContract.BaseColumns._ID, "display_name", "data1"};

    /* renamed from: c, reason: collision with root package name */
    public static int f16691c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static int f16692d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static final Uri f16693e;

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f16694f;

    /* renamed from: g, reason: collision with root package name */
    public static final Uri f16695g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f16696h;

    /* renamed from: i, reason: collision with root package name */
    public static volatile boolean f16697i;

    /* renamed from: j, reason: collision with root package name */
    public static int f16698j;

    static {
        Uri uri = ContactsContract.AUTHORITY_URI;
        f16693e = Uri.withAppendedPath(uri, "oplus_check_contacts_location_init_state");
        f16694f = Uri.withAppendedPath(uri, "oplus_view_contacts_by_location_group");
        f16695g = Uri.withAppendedPath(uri, "oplus_contacts_group_by_location");
        f16696h = M7.a.h(P7.a.f2961a.a(), "com.android.providers.contacts", "support_contact_location_data", "true");
    }

    public static final void a() {
        Object b10;
        Cursor query;
        int columnIndex;
        try {
            Result.a aVar = Result.f34166a;
            P7.a aVar2 = P7.a.f2961a;
            Cursor query2 = aVar2.a().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            if (query2 != null) {
                try {
                    int count = query2.getCount();
                    f16698j = count;
                    H7.b.e("LargeContactsLocationGroupStrategy", "contactCount = " + count);
                    q qVar = q.f35511a;
                    kotlin.io.a.a(query2, null);
                } finally {
                }
            }
            if (f16698j >= 500 && (query = aVar2.a().getContentResolver().query(f16693e, null, null, null)) != null) {
                try {
                    boolean z10 = false;
                    if (query.moveToFirst() && (columnIndex = query.getColumnIndex("state")) >= 0 && query.getInt(columnIndex) == 1) {
                        z10 = true;
                    }
                    f16697i = z10;
                    H7.b.e("LargeContactsLocationGroupStrategy", "contactsProviderIsInit = " + f16697i);
                    q qVar2 = q.f35511a;
                    kotlin.io.a.a(query, null);
                } finally {
                }
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar3 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("LargeContactsLocationGroupStrategy", "checkInitState " + d10 + " " + d10.getMessage());
        }
        Result.f(b10);
    }

    public static final SmartGroupActivity.c b(Cursor cursor) {
        kotlin.jvm.internal.i.f(cursor, "cursor");
        if (f16691c == -1 || f16692d == -1) {
            f16691c = cursor.getColumnIndex("cityname");
            f16692d = cursor.getColumnIndex(BreenoCallContract.SummaryColumns.COUNT);
        }
        String string = cursor.getString(f16691c);
        if (string == null || string.length() == 0) {
            string = P7.a.f2961a.a().getString(R.string.oplus_unknow_city);
        }
        kotlin.jvm.internal.i.e(string, "if (cityName.isNullOrEmp…nknow_city) else cityName");
        return new SmartGroupActivity.c(string, cursor.getInt(f16692d), null, 2);
    }

    public static final String[] c() {
        return null;
    }

    public static final Uri d() {
        Uri CONTACTS_GROUP_BY_LOCATION_URI = f16695g;
        kotlin.jvm.internal.i.e(CONTACTS_GROUP_BY_LOCATION_URI, "CONTACTS_GROUP_BY_LOCATION_URI");
        return CONTACTS_GROUP_BY_LOCATION_URI;
    }

    public static final ArrayList<C0808t> e(Context context, C1393c contactsPreferences, String ids, ArrayList<ContactParcelable> singleNumberContactParcelableList, String str) {
        Object b10;
        String str2;
        long j10;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(contactsPreferences, "contactsPreferences");
        kotlin.jvm.internal.i.f(ids, "ids");
        kotlin.jvm.internal.i.f(singleNumberContactParcelableList, "singleNumberContactParcelableList");
        ArrayList<C0808t> arrayList = new ArrayList<>();
        try {
            Result.a aVar = Result.f34166a;
            Uri.Builder appendQueryParameter = f16694f.buildUpon().appendQueryParameter("number", "true");
            if (!kotlin.jvm.internal.i.b(str, P7.a.f2961a.a().getString(R.string.oplus_unknow_city))) {
                appendQueryParameter.appendQueryParameter("cityname", str);
            }
            if (contactsPreferences.h() == 1) {
                str2 = "sort_key";
            } else {
                str2 = "sort_key_alt";
            }
            ContentResolver contentResolver = context.getContentResolver();
            Uri build = appendQueryParameter.build();
            String[] strArr = f16690b;
            Cursor query = contentResolver.query(build, strArr, "contact_id IN " + ids, null, str2 + " , contact_id ");
            q qVar = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        j10 = query.getLong(0);
                        query.move(-1);
                    } else {
                        j10 = -1;
                    }
                    C0808t c0808t = null;
                    while (query.moveToNext()) {
                        long j11 = query.getLong(0);
                        if (j11 != j10 && c0808t != null) {
                            int size = c0808t.f22181c.size();
                            if (size == 1) {
                                ContactParcelable contactParcelable = new ContactParcelable();
                                contactParcelable.t(c0808t.f22179a);
                                contactParcelable.w(c0808t.f22181c.get(0).f21872e);
                                contactParcelable.q(c0808t.f22180b);
                                singleNumberContactParcelableList.add(contactParcelable);
                            } else if (size > 1) {
                                c0808t.f22181c.get(0).b(true);
                                arrayList.add(c0808t);
                            }
                            if (!query.moveToPrevious()) {
                                query.move(-1);
                            }
                            c0808t = null;
                            j10 = j11;
                        } else {
                            if (c0808t == null) {
                                c0808t = new C0808t();
                            }
                            String string = query.getString(2);
                            c0808t.f22179a = query.getString(1);
                            c0808t.f22180b = j11;
                            if (!c0808t.a(string)) {
                                ContactsPhonesUtils$PhoneItem contactsPhonesUtils$PhoneItem = new ContactsPhonesUtils$PhoneItem(j11, string, "", 0, false);
                                contactsPhonesUtils$PhoneItem.d("vnd.android.cursor.item/phone_v2");
                                contactsPhonesUtils$PhoneItem.f21870c = c0808t.f22179a;
                                c0808t.f22181c.add(contactsPhonesUtils$PhoneItem);
                            }
                            if (query.isLast()) {
                                int size2 = c0808t.f22181c.size();
                                if (size2 == 1) {
                                    ContactParcelable contactParcelable2 = new ContactParcelable();
                                    contactParcelable2.t(c0808t.f22179a);
                                    contactParcelable2.w(c0808t.f22181c.get(0).f21872e);
                                    contactParcelable2.q(c0808t.f22180b);
                                    singleNumberContactParcelableList.add(contactParcelable2);
                                } else if (size2 > 1) {
                                    c0808t.f22181c.get(0).b(true);
                                    arrayList.add(c0808t);
                                }
                            }
                        }
                    }
                    q qVar2 = q.f35511a;
                    kotlin.io.a.a(query, null);
                    qVar = q.f35511a;
                } finally {
                }
            }
            b10 = Result.b(qVar);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("LargeContactsLocationGroupStrategy", "getSelectedContactsPhonesAsLocation " + d10 + " " + d10.getMessage());
        }
        return arrayList;
    }

    public static final boolean g() {
        boolean z10;
        if (FeatureOption.i() && f16698j >= 500 && f16696h && f16697i) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (H7.a.b()) {
            H7.b.b("LargeContactsLocationGroupStrategy", "isSupportContactDataLocation: " + z10);
        }
        return z10;
    }

    public final Pair<Uri, String> f(String str) {
        Uri.Builder buildUpon = f16694f.buildUpon();
        if (!kotlin.jvm.internal.i.b(str, P7.a.f2961a.a().getString(R.string.oplus_unknow_city))) {
            buildUpon.appendQueryParameter("cityname", str).build();
        }
        return new Pair<>(buildUpon.build(), null);
    }
}
