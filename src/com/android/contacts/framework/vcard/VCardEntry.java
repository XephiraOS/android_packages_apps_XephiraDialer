package com.android.contacts.framework.vcard;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.model.Account;
import com.coui.appcompat.calendar.COUIDateMonthView;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class VCardEntry {

    /* renamed from: C, reason: collision with root package name */
    public static final Map<String, Integer> f16342C;

    /* renamed from: D, reason: collision with root package name */
    public static final List<String> f16343D;

    /* renamed from: A, reason: collision with root package name */
    public List<VCardEntry> f16344A;

    /* renamed from: B, reason: collision with root package name */
    public long f16345B;

    /* renamed from: a, reason: collision with root package name */
    public ContentResolver f16346a;

    /* renamed from: b, reason: collision with root package name */
    public final m f16347b;

    /* renamed from: c, reason: collision with root package name */
    public List<q> f16348c;

    /* renamed from: d, reason: collision with root package name */
    public List<f> f16349d;

    /* renamed from: e, reason: collision with root package name */
    public List<s> f16350e;

    /* renamed from: f, reason: collision with root package name */
    public List<p> f16351f;

    /* renamed from: g, reason: collision with root package name */
    public List<j> f16352g;

    /* renamed from: h, reason: collision with root package name */
    public List<r> f16353h;

    /* renamed from: i, reason: collision with root package name */
    public List<w> f16354i;

    /* renamed from: j, reason: collision with root package name */
    public List<u> f16355j;

    /* renamed from: k, reason: collision with root package name */
    public List<n> f16356k;

    /* renamed from: l, reason: collision with root package name */
    public List<o> f16357l;

    /* renamed from: m, reason: collision with root package name */
    public List<b> f16358m;

    /* renamed from: n, reason: collision with root package name */
    public List<d> f16359n;

    /* renamed from: o, reason: collision with root package name */
    public c f16360o;

    /* renamed from: p, reason: collision with root package name */
    public List<i> f16361p;

    /* renamed from: q, reason: collision with root package name */
    public List<t> f16362q;

    /* renamed from: r, reason: collision with root package name */
    public List<e> f16363r;

    /* renamed from: s, reason: collision with root package name */
    public String f16364s;

    /* renamed from: t, reason: collision with root package name */
    public String f16365t;

    /* renamed from: u, reason: collision with root package name */
    public String f16366u;

    /* renamed from: v, reason: collision with root package name */
    public String f16367v;

    /* renamed from: w, reason: collision with root package name */
    public String f16368w;

    /* renamed from: x, reason: collision with root package name */
    public String f16369x;

    /* renamed from: y, reason: collision with root package name */
    public final int f16370y;

    /* renamed from: z, reason: collision with root package name */
    public final Account f16371z;

    /* loaded from: classes.dex */
    public enum EntryLabel {
        NAME,
        PHONE,
        EMAIL,
        POSTAL_ADDRESS,
        ORGANIZATION,
        IM,
        PHOTO,
        WEBSITE,
        SIP,
        NICKNAME,
        NOTE,
        GROUP,
        BIRTHDAY,
        ANNIVERSARY,
        ANDROID_CUSTOM
    }

    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public long f16388a;

        public long d() {
            return this.f16388a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean e() {
            if ((this instanceof g) && ((g) this).isEmpty()) {
                return true;
            }
            return false;
        }

        public a f(long j10) {
            this.f16388a = j10;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16389b;

        /* renamed from: c, reason: collision with root package name */
        public final List<String> f16390c;

        public b(String str, List<String> list) {
            this.f16389b = str;
            this.f16390c = list;
        }

        public static b g(List<String> list) {
            List<String> subList;
            String str = null;
            if (list == null) {
                subList = null;
            } else if (list.size() < 2) {
                str = list.get(0);
                subList = null;
            } else {
                int i10 = 16;
                if (list.size() < 16) {
                    i10 = list.size();
                }
                str = list.get(0);
                subList = list.subList(1, i10);
            }
            return new b(str, subList);
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", this.f16389b);
            for (int i11 = 0; i11 < this.f16390c.size(); i11++) {
                String str = this.f16390c.get(i11);
                if (!TextUtils.isEmpty(str)) {
                    newInsert.withValue("data" + (i11 + 1), str);
                }
            }
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            return null;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public EntryLabel c() {
            return EntryLabel.ANDROID_CUSTOM;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!TextUtils.equals(this.f16389b, bVar.f16389b)) {
                return false;
            }
            List<String> list = this.f16390c;
            if (list == null) {
                if (bVar.f16390c == null) {
                    return true;
                }
                return false;
            }
            int size = list.size();
            if (size != bVar.f16390c.size()) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (!TextUtils.equals(this.f16390c.get(i10), bVar.f16390c.get(i10))) {
                    return false;
                }
            }
            return true;
        }

        public List<String> h() {
            return this.f16390c;
        }

        public int hashCode() {
            int i10;
            int i11;
            String str = this.f16389b;
            if (str != null) {
                i10 = str.hashCode();
            } else {
                i10 = 0;
            }
            List<String> list = this.f16390c;
            if (list != null) {
                for (String str2 : list) {
                    int i12 = i10 * 31;
                    if (str2 != null) {
                        i11 = str2.hashCode();
                    } else {
                        i11 = 0;
                    }
                    i10 = i12 + i11;
                }
            }
            return i10;
        }

        public String i() {
            return this.f16389b;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            List<String> list;
            if (!TextUtils.isEmpty(this.f16389b) && (list = this.f16390c) != null && list.size() != 0) {
                return false;
            }
            return true;
        }

        public String toString() {
            String arrays;
            StringBuilder sb = new StringBuilder();
            sb.append("android-custom: " + this.f16389b + ", data: ");
            List<String> list = this.f16390c;
            if (list == null) {
                arrays = "null";
            } else {
                arrays = Arrays.toString(list.toArray());
            }
            sb.append(arrays);
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16391b;

        public c(String str) {
            this.f16391b = str;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/contact_event");
            newInsert.withValue("data1", this.f16391b);
            newInsert.withValue("data2", 1);
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            String str = this.f16391b;
            if (str == null) {
                return "";
            }
            return str;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public EntryLabel c() {
            return EntryLabel.ANNIVERSARY;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            return TextUtils.equals(this.f16391b, ((c) obj).f16391b);
        }

        public int hashCode() {
            String str = this.f16391b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f16391b);
        }

        public String toString() {
            return "anniversary: " + this.f16391b;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16392b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16393c;

        /* renamed from: d, reason: collision with root package name */
        public final int f16394d;

        public d(String str, int i10) {
            this(str, i10, -1);
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/contact_event");
            newInsert.withValue("data1", this.f16392b);
            newInsert.withValue("data2", Integer.valueOf(this.f16394d));
            newInsert.withValue("data10", Integer.valueOf(this.f16393c));
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            if (this.f16392b == null) {
                return "";
            }
            return this.f16392b + "," + this.f16393c + "," + this.f16394d;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public EntryLabel c() {
            return EntryLabel.BIRTHDAY;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            return TextUtils.equals(this.f16392b, ((d) obj).f16392b);
        }

        public int hashCode() {
            int i10;
            int i11 = ((this.f16393c * 31) + this.f16394d) * 31;
            String str = this.f16392b;
            if (str != null) {
                i10 = str.hashCode();
            } else {
                i10 = 0;
            }
            return i11 + i10;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f16392b);
        }

        public String toString() {
            return "birthday: " + this.f16392b + "," + this.f16393c + "," + this.f16394d;
        }

        public d(String str, int i10, int i11) {
            this.f16392b = str;
            this.f16393c = i10;
            if (i11 == -1) {
                this.f16394d = i10 == 0 ? 3 : 1000;
            } else {
                this.f16394d = i11;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16395b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16396c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f16397d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f16398e = null;

        public e(String str, byte[] bArr, int i10) {
            this.f16395b = str;
            this.f16397d = bArr;
            this.f16396c = i10;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/business_card_photo");
            newInsert.withValue("data15", this.f16397d);
            newInsert.withValue("data1", VCardEntry.b());
            newInsert.withValue("data2", Integer.valueOf(this.f16396c));
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            return null;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public final EntryLabel c() {
            return EntryLabel.PHOTO;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (TextUtils.equals(this.f16395b, eVar.f16395b) && Arrays.equals(this.f16397d, eVar.f16397d) && this.f16396c == eVar.f16396c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11;
            Integer num = this.f16398e;
            if (num != null) {
                return num.intValue();
            }
            String str = this.f16395b;
            if (str != null) {
                i10 = str.hashCode();
            } else {
                i10 = 0;
            }
            int i12 = i10 * 31;
            byte[] bArr = this.f16397d;
            if (bArr != null) {
                for (byte b10 : bArr) {
                    i12 += b10;
                }
            }
            int i13 = i12 * 31;
            if (this.f16396c == 0) {
                i11 = 1231;
            } else {
                i11 = 1237;
            }
            int i14 = i13 + i11;
            this.f16398e = Integer.valueOf(i14);
            return i14;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            byte[] bArr = this.f16397d;
            if (bArr != null && bArr.length != 0) {
                return false;
            }
            return true;
        }

        public String toString() {
            return String.format("format: %s: size: %d, isFront: %s", this.f16395b, Integer.valueOf(this.f16397d.length), Integer.valueOf(this.f16396c));
        }
    }

    /* loaded from: classes.dex */
    public static class f extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16399b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16400c;

        /* renamed from: d, reason: collision with root package name */
        public final String f16401d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f16402e;

        public f(String str, int i10, String str2, boolean z10) {
            this.f16400c = i10;
            this.f16399b = str;
            this.f16401d = str2;
            this.f16402e = z10;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/email_v2");
            newInsert.withValue("data2", Integer.valueOf(this.f16400c));
            if (this.f16400c == 0) {
                newInsert.withValue("data3", this.f16401d);
            }
            newInsert.withValue("data1", this.f16399b);
            if (this.f16402e) {
                newInsert.withValue("is_primary", 1);
                newInsert.withValue("is_super_primary", 1);
            }
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            return this.f16399b;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public final EntryLabel c() {
            return EntryLabel.EMAIL;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (this.f16400c == fVar.f16400c && TextUtils.equals(this.f16399b, fVar.f16399b) && TextUtils.equals(this.f16401d, fVar.f16401d) && this.f16402e == fVar.f16402e) {
                return true;
            }
            return false;
        }

        public String h() {
            return this.f16399b;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12 = this.f16400c * 31;
            String str = this.f16399b;
            int i13 = 0;
            if (str != null) {
                i10 = str.hashCode();
            } else {
                i10 = 0;
            }
            int i14 = (i12 + i10) * 31;
            String str2 = this.f16401d;
            if (str2 != null) {
                i13 = str2.hashCode();
            }
            int i15 = (i14 + i13) * 31;
            if (this.f16402e) {
                i11 = 1231;
            } else {
                i11 = 1237;
            }
            return i15 + i11;
        }

        public int i() {
            return this.f16400c;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f16399b);
        }

        public String toString() {
            return String.format("type: %d, data: %s, label: %s, isPrimary: %s", Integer.valueOf(this.f16400c), this.f16399b, this.f16401d, Boolean.valueOf(this.f16402e));
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(List<ContentProviderOperation> list, int i10);

        String b();

        EntryLabel c();

        boolean isEmpty();
    }

    /* loaded from: classes.dex */
    public interface h {
        void a();

        boolean b(g gVar);

        void c();

        void d(EntryLabel entryLabel);

        void e();
    }

    /* loaded from: classes.dex */
    public static class i extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16403b;

        /* renamed from: c, reason: collision with root package name */
        public final Account f16404c;

        /* renamed from: d, reason: collision with root package name */
        public ContentResolver f16405d;

        public i(String str, Account account, ContentResolver contentResolver) {
            this.f16403b = str;
            this.f16404c = account;
            this.f16405d = contentResolver;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            Account account = this.f16404c;
            if (account == null) {
                return;
            }
            if (VCardUtils.u(this.f16405d, this.f16403b, account) > 0) {
                long p10 = VCardUtils.p(this.f16405d, this.f16403b, this.f16404c);
                if (H7.a.b()) {
                    H7.b.b(com.android.contacts.framework.vcard.h.LOG_TAG, "GroupData, group exist: mGroupTitle = " + this.f16403b + " group id = " + p10);
                }
                if (p10 <= 0) {
                    H7.b.i(com.android.contacts.framework.vcard.h.LOG_TAG, "GroupData, groupId = " + p10);
                    return;
                }
                ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
                newInsert.withValue("data1", Long.valueOf(p10));
                newInsert.withValue("mimetype", "vnd.android.cursor.item/group_membership");
                newInsert.withValueBackReference("raw_contact_id", i10);
                list.add(newInsert.build());
                return;
            }
            if (H7.a.b()) {
                H7.b.b(com.android.contacts.framework.vcard.h.LOG_TAG, "GroupData, group not exist : groupTitle = " + this.f16403b);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", this.f16403b);
            contentValues.put("account_name", this.f16404c.f16941a);
            contentValues.put("account_type", this.f16404c.f16942b);
            int parseId = (int) ContentUris.parseId(this.f16405d.insert(VCardEntry.C(ContactsContract.Groups.CONTENT_URI), contentValues));
            ContentProviderOperation.Builder newInsert2 = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert2.withValue("data1", Integer.valueOf(parseId));
            newInsert2.withValue("mimetype", "vnd.android.cursor.item/group_membership");
            newInsert2.withValueBackReference("raw_contact_id", i10);
            list.add(newInsert2.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            return this.f16403b;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public EntryLabel c() {
            return EntryLabel.GROUP;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            return TextUtils.equals(this.f16403b, ((i) obj).f16403b);
        }

        public String g() {
            return this.f16403b;
        }

        public int hashCode() {
            String str = this.f16403b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f16403b);
        }

        public String toString() {
            return "group: " + this.f16403b;
        }
    }

    /* loaded from: classes.dex */
    public static class j extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16406b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16407c;

        /* renamed from: d, reason: collision with root package name */
        public final String f16408d;

        /* renamed from: e, reason: collision with root package name */
        public final int f16409e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f16410f;

        public j(int i10, String str, String str2, int i11, boolean z10) {
            this.f16407c = i10;
            this.f16408d = str;
            this.f16409e = i11;
            this.f16406b = str2;
            this.f16410f = z10;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/im");
            newInsert.withValue("data2", Integer.valueOf(this.f16409e));
            newInsert.withValue("data5", Integer.valueOf(this.f16407c));
            newInsert.withValue("data1", this.f16406b);
            if (this.f16407c == -1) {
                newInsert.withValue("data6", this.f16408d);
            }
            if (this.f16410f) {
                newInsert.withValue("is_primary", 1);
            }
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            StringBuilder sb = new StringBuilder();
            String str = this.f16406b;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(",");
            sb.append(this.f16407c);
            sb.append(",");
            String str3 = this.f16408d;
            if (str3 != null) {
                str2 = str3;
            }
            sb.append(str2);
            return sb.toString();
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public final EntryLabel c() {
            return EntryLabel.IM;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (this.f16409e == jVar.f16409e && this.f16407c == jVar.f16407c && TextUtils.equals(this.f16408d, jVar.f16408d) && TextUtils.equals(this.f16406b, jVar.f16406b) && this.f16410f == jVar.f16410f) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12 = ((this.f16409e * 31) + this.f16407c) * 31;
            String str = this.f16408d;
            int i13 = 0;
            if (str != null) {
                i10 = str.hashCode();
            } else {
                i10 = 0;
            }
            int i14 = (i12 + i10) * 31;
            String str2 = this.f16406b;
            if (str2 != null) {
                i13 = str2.hashCode();
            }
            int i15 = (i14 + i13) * 31;
            if (this.f16410f) {
                i11 = 1231;
            } else {
                i11 = 1237;
            }
            return i15 + i11;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f16406b);
        }

        public String toString() {
            return String.format("type: %d, protocol: %d, custom_protcol: %s, data: %s, isPrimary: %s", Integer.valueOf(this.f16409e), Integer.valueOf(this.f16407c), this.f16408d, this.f16406b, Boolean.valueOf(this.f16410f));
        }
    }

    /* loaded from: classes.dex */
    public static class l implements h {

        /* renamed from: a, reason: collision with root package name */
        public boolean f16413a;

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public boolean b(g gVar) {
            if (!gVar.isEmpty()) {
                this.f16413a = false;
                return false;
            }
            return true;
        }

        public boolean f() {
            return this.f16413a;
        }

        public l() {
            this.f16413a = true;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public void a() {
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public void c() {
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public void d(EntryLabel entryLabel) {
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public void e() {
        }
    }

    /* loaded from: classes.dex */
    public static class m extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public String f16414b;

        /* renamed from: c, reason: collision with root package name */
        public String f16415c;

        /* renamed from: d, reason: collision with root package name */
        public String f16416d;

        /* renamed from: e, reason: collision with root package name */
        public String f16417e;

        /* renamed from: f, reason: collision with root package name */
        public String f16418f;

        /* renamed from: g, reason: collision with root package name */
        public String f16419g;

        /* renamed from: h, reason: collision with root package name */
        public String f16420h;

        /* renamed from: i, reason: collision with root package name */
        public String f16421i;

        /* renamed from: j, reason: collision with root package name */
        public String f16422j;

        /* renamed from: k, reason: collision with root package name */
        public String f16423k;

        /* renamed from: l, reason: collision with root package name */
        public String f16424l;

        public boolean A() {
            if (TextUtils.isEmpty(this.f16414b) && TextUtils.isEmpty(this.f16415c) && TextUtils.isEmpty(this.f16416d) && TextUtils.isEmpty(this.f16417e) && TextUtils.isEmpty(this.f16418f)) {
                return true;
            }
            return false;
        }

        public String B() {
            return this.f16414b;
        }

        public String C() {
            return this.f16419g;
        }

        public String D() {
            return this.f16415c;
        }

        public String E() {
            return this.f16416d;
        }

        public String F() {
            return this.f16417e;
        }

        public String G() {
            return this.f16418f;
        }

        public void H(String str) {
            this.f16414b = str;
        }

        public void I(String str) {
            this.f16415c = str;
        }

        public void J(String str) {
            this.f16416d = str;
        }

        public void K(String str) {
            this.f16417e = str;
        }

        public void L(String str) {
            this.f16418f = str;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            boolean z10;
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/name");
            if (!TextUtils.isEmpty(this.f16415c)) {
                newInsert.withValue("data2", this.f16415c);
            }
            if (!TextUtils.isEmpty(this.f16414b)) {
                newInsert.withValue("data3", this.f16414b);
            }
            if (!TextUtils.isEmpty(this.f16416d)) {
                newInsert.withValue("data5", this.f16416d);
            }
            if (!TextUtils.isEmpty(this.f16417e)) {
                newInsert.withValue("data4", this.f16417e);
            }
            if (!TextUtils.isEmpty(this.f16418f)) {
                newInsert.withValue("data6", this.f16418f);
            }
            boolean z11 = true;
            if (!TextUtils.isEmpty(this.f16421i)) {
                newInsert.withValue("data7", this.f16421i);
                z10 = true;
            } else {
                z10 = false;
            }
            if (!TextUtils.isEmpty(this.f16420h)) {
                newInsert.withValue("data9", this.f16420h);
            } else {
                z11 = z10;
            }
            if (!TextUtils.isEmpty(this.f16422j)) {
                newInsert.withValue("data8", this.f16422j);
            } else if (!z11) {
                newInsert.withValue("data7", this.f16423k);
            }
            newInsert.withValue("data1", this.f16424l);
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            return null;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public final EntryLabel c() {
            return EntryLabel.NAME;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            if (TextUtils.equals(this.f16414b, mVar.f16414b) && TextUtils.equals(this.f16416d, mVar.f16416d) && TextUtils.equals(this.f16415c, mVar.f16415c) && TextUtils.equals(this.f16417e, mVar.f16417e) && TextUtils.equals(this.f16418f, mVar.f16418f) && TextUtils.equals(this.f16419g, mVar.f16419g) && TextUtils.equals(this.f16420h, mVar.f16420h) && TextUtils.equals(this.f16422j, mVar.f16422j) && TextUtils.equals(this.f16421i, mVar.f16421i) && TextUtils.equals(this.f16423k, mVar.f16423k)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            String[] strArr = {this.f16414b, this.f16416d, this.f16415c, this.f16417e, this.f16418f, this.f16419g, this.f16420h, this.f16422j, this.f16421i, this.f16423k};
            int i11 = 0;
            for (int i12 = 0; i12 < 10; i12++) {
                String str = strArr[i12];
                int i13 = i11 * 31;
                if (str != null) {
                    i10 = str.hashCode();
                } else {
                    i10 = 0;
                }
                i11 = i13 + i10;
            }
            return i11;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            if (TextUtils.isEmpty(this.f16414b) && TextUtils.isEmpty(this.f16416d) && TextUtils.isEmpty(this.f16415c) && TextUtils.isEmpty(this.f16417e) && TextUtils.isEmpty(this.f16418f) && TextUtils.isEmpty(this.f16419g) && TextUtils.isEmpty(this.f16420h) && TextUtils.isEmpty(this.f16422j) && TextUtils.isEmpty(this.f16421i) && TextUtils.isEmpty(this.f16423k)) {
                return true;
            }
            return false;
        }

        public String toString() {
            return String.format("family: %s, given: %s, middle: %s, prefix: %s, suffix: %s", this.f16414b, this.f16415c, this.f16416d, this.f16417e, this.f16418f);
        }

        public boolean z() {
            if (TextUtils.isEmpty(this.f16420h) && TextUtils.isEmpty(this.f16421i) && TextUtils.isEmpty(this.f16422j)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class n extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16425b;

        public n(String str) {
            this.f16425b = str;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/nickname");
            newInsert.withValue("data2", 1);
            newInsert.withValue("data1", this.f16425b);
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            return this.f16425b;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public EntryLabel c() {
            return EntryLabel.NICKNAME;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof n)) {
                return false;
            }
            return TextUtils.equals(this.f16425b, ((n) obj).f16425b);
        }

        public int hashCode() {
            String str = this.f16425b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f16425b);
        }

        public String toString() {
            return "nickname: " + this.f16425b;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16426b;

        public o(String str) {
            this.f16426b = str;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/note");
            newInsert.withValue("data1", this.f16426b);
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            return this.f16426b;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public EntryLabel c() {
            return EntryLabel.NOTE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof o)) {
                return false;
            }
            return TextUtils.equals(this.f16426b, ((o) obj).f16426b);
        }

        public int hashCode() {
            String str = this.f16426b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f16426b);
        }

        public String toString() {
            return "note: " + this.f16426b;
        }
    }

    /* loaded from: classes.dex */
    public static class p extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public String f16427b;

        /* renamed from: c, reason: collision with root package name */
        public String f16428c;

        /* renamed from: d, reason: collision with root package name */
        public String f16429d;

        /* renamed from: e, reason: collision with root package name */
        public final String f16430e;

        /* renamed from: f, reason: collision with root package name */
        public final int f16431f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f16432g;

        public p(String str, String str2, String str3, String str4, int i10, boolean z10) {
            this.f16431f = i10;
            this.f16427b = str;
            this.f16428c = str2;
            this.f16429d = str3;
            this.f16430e = str4;
            this.f16432g = z10;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/organization");
            newInsert.withValue("data2", Integer.valueOf(this.f16431f));
            String str = this.f16427b;
            if (str != null) {
                newInsert.withValue("data1", str);
            }
            String str2 = this.f16428c;
            if (str2 != null) {
                newInsert.withValue("data5", str2);
            }
            String str3 = this.f16429d;
            if (str3 != null) {
                newInsert.withValue("data4", str3);
            }
            String str4 = this.f16430e;
            if (str4 != null) {
                newInsert.withValue("data8", str4);
            }
            if (this.f16432g) {
                newInsert.withValue("is_primary", 1);
            }
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            StringBuilder sb = new StringBuilder();
            String str = this.f16427b;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(",");
            sb.append(this.f16431f);
            sb.append(",");
            String str3 = this.f16429d;
            if (str3 == null) {
                str3 = "";
            }
            sb.append(str3);
            sb.append(",");
            String str4 = this.f16428c;
            if (str4 == null) {
                str4 = "";
            }
            sb.append(str4);
            sb.append(",");
            String str5 = this.f16430e;
            if (str5 != null) {
                str2 = str5;
            }
            sb.append(str2);
            return sb.toString();
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public final EntryLabel c() {
            return EntryLabel.ORGANIZATION;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof p)) {
                return false;
            }
            p pVar = (p) obj;
            if (this.f16431f == pVar.f16431f && TextUtils.equals(this.f16427b, pVar.f16427b) && TextUtils.equals(this.f16428c, pVar.f16428c) && TextUtils.equals(this.f16429d, pVar.f16429d) && this.f16432g == pVar.f16432g) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12;
            int i13 = this.f16431f * 31;
            String str = this.f16427b;
            int i14 = 0;
            if (str != null) {
                i10 = str.hashCode();
            } else {
                i10 = 0;
            }
            int i15 = (i13 + i10) * 31;
            String str2 = this.f16428c;
            if (str2 != null) {
                i11 = str2.hashCode();
            } else {
                i11 = 0;
            }
            int i16 = (i15 + i11) * 31;
            String str3 = this.f16429d;
            if (str3 != null) {
                i14 = str3.hashCode();
            }
            int i17 = (i16 + i14) * 31;
            if (this.f16432g) {
                i12 = 1231;
            } else {
                i12 = 1237;
            }
            return i17 + i12;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            if (TextUtils.isEmpty(this.f16427b) && TextUtils.isEmpty(this.f16428c) && TextUtils.isEmpty(this.f16429d) && TextUtils.isEmpty(this.f16430e)) {
                return true;
            }
            return false;
        }

        public String n() {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.f16427b)) {
                sb.append(this.f16427b);
            }
            if (!TextUtils.isEmpty(this.f16428c)) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(this.f16428c);
            }
            if (!TextUtils.isEmpty(this.f16429d)) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(this.f16429d);
            }
            return sb.toString();
        }

        public String o() {
            return this.f16427b;
        }

        public String p() {
            return this.f16429d;
        }

        public int q() {
            return this.f16431f;
        }

        public String toString() {
            return String.format("type: %d, organization: %s, department: %s, title: %s, isPrimary: %s", Integer.valueOf(this.f16431f), this.f16427b, this.f16428c, this.f16429d, Boolean.valueOf(this.f16432g));
        }
    }

    /* loaded from: classes.dex */
    public static class q extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16433b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16434c;

        /* renamed from: d, reason: collision with root package name */
        public final String f16435d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f16436e;

        /* renamed from: f, reason: collision with root package name */
        public final String f16437f;

        /* renamed from: g, reason: collision with root package name */
        public final String f16438g;

        /* renamed from: h, reason: collision with root package name */
        public final String f16439h;

        /* renamed from: i, reason: collision with root package name */
        public final String f16440i;

        public q(String str, int i10, String str2, boolean z10, String str3, String str4, String str5, String str6) {
            this.f16433b = str;
            this.f16434c = i10;
            this.f16435d = str2;
            this.f16436e = z10;
            this.f16437f = str3;
            this.f16438g = str4;
            this.f16439h = str5;
            this.f16440i = str6;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
            newInsert.withValue("data2", Integer.valueOf(this.f16434c));
            if (this.f16434c == 0) {
                newInsert.withValue("data3", this.f16435d);
            }
            newInsert.withValue("data1", this.f16433b);
            if (this.f16436e) {
                newInsert.withValue("is_primary", 1);
                newInsert.withValue("is_super_primary", 1);
            }
            if (!TextUtils.isEmpty(this.f16438g)) {
                newInsert.withValue("data5", this.f16438g);
            }
            if (!TextUtils.isEmpty(this.f16439h)) {
                newInsert.withValue("data6", this.f16439h);
            }
            if (!TextUtils.isEmpty(this.f16440i) && !"NULL".equals(this.f16440i)) {
                newInsert.withValue("data9", this.f16440i);
            }
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            return this.f16433b;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public final EntryLabel c() {
            return EntryLabel.PHONE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof q)) {
                return false;
            }
            q qVar = (q) obj;
            if (this.f16434c == qVar.f16434c && TextUtils.equals(this.f16433b, qVar.f16433b) && TextUtils.equals(this.f16435d, qVar.f16435d) && this.f16436e == qVar.f16436e) {
                return true;
            }
            return false;
        }

        public String h() {
            return this.f16433b;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12 = this.f16434c * 31;
            String str = this.f16433b;
            int i13 = 0;
            if (str != null) {
                i10 = str.hashCode();
            } else {
                i10 = 0;
            }
            int i14 = (i12 + i10) * 31;
            String str2 = this.f16435d;
            if (str2 != null) {
                i13 = str2.hashCode();
            }
            int i15 = (i14 + i13) * 31;
            if (this.f16436e) {
                i11 = 1231;
            } else {
                i11 = 1237;
            }
            return i15 + i11;
        }

        public int i() {
            return this.f16434c;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f16433b);
        }

        public String toString() {
            return String.format("type: %d, data: %s, label: %s, isPrimary: %s", Integer.valueOf(this.f16434c), this.f16433b, this.f16435d, Boolean.valueOf(this.f16436e));
        }
    }

    /* loaded from: classes.dex */
    public static class r extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16441b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f16442c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f16443d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f16444e = null;

        public r(String str, byte[] bArr, boolean z10) {
            this.f16441b = str;
            this.f16443d = bArr;
            this.f16442c = z10;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/photo");
            newInsert.withValue("data15", this.f16443d);
            if (this.f16442c) {
                newInsert.withValue("is_primary", 1);
            }
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            return null;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public final EntryLabel c() {
            return EntryLabel.PHOTO;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof r)) {
                return false;
            }
            r rVar = (r) obj;
            if (TextUtils.equals(this.f16441b, rVar.f16441b) && Arrays.equals(this.f16443d, rVar.f16443d) && this.f16442c == rVar.f16442c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11;
            Integer num = this.f16444e;
            if (num != null) {
                return num.intValue();
            }
            String str = this.f16441b;
            if (str != null) {
                i10 = str.hashCode();
            } else {
                i10 = 0;
            }
            int i12 = i10 * 31;
            byte[] bArr = this.f16443d;
            if (bArr != null) {
                for (byte b10 : bArr) {
                    i12 += b10;
                }
            }
            int i13 = i12 * 31;
            if (this.f16442c) {
                i11 = 1231;
            } else {
                i11 = 1237;
            }
            int i14 = i13 + i11;
            this.f16444e = Integer.valueOf(i14);
            return i14;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            byte[] bArr = this.f16443d;
            if (bArr != null && bArr.length != 0) {
                return false;
            }
            return true;
        }

        public String toString() {
            return String.format("format: %s: size: %d, isPrimary: %s", this.f16441b, Integer.valueOf(this.f16443d.length), Boolean.valueOf(this.f16442c));
        }
    }

    /* loaded from: classes.dex */
    public static class s extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16445b;

        /* renamed from: c, reason: collision with root package name */
        public final String f16446c;

        /* renamed from: d, reason: collision with root package name */
        public final String f16447d;

        /* renamed from: e, reason: collision with root package name */
        public final String f16448e;

        /* renamed from: f, reason: collision with root package name */
        public final String f16449f;

        /* renamed from: g, reason: collision with root package name */
        public final String f16450g;

        /* renamed from: h, reason: collision with root package name */
        public final String f16451h;

        /* renamed from: i, reason: collision with root package name */
        public final int f16452i;

        /* renamed from: j, reason: collision with root package name */
        public final String f16453j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f16454k;

        /* renamed from: l, reason: collision with root package name */
        public int f16455l;

        public s(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, String str8, boolean z10, int i11) {
            this.f16452i = i10;
            this.f16445b = str;
            this.f16446c = str2;
            this.f16447d = str3;
            this.f16448e = str4;
            this.f16449f = str5;
            this.f16450g = str6;
            if (!TextUtils.isEmpty(str7) && str7.length() > 100) {
                this.f16451h = str7.substring(0, 100);
            } else {
                this.f16451h = str7;
            }
            this.f16453j = str8;
            this.f16454k = z10;
            this.f16455l = i11;
        }

        public static s g(List<String> list, int i10, String str, boolean z10, int i11) {
            String[] strArr = new String[7];
            int size = list.size();
            if (size > 7) {
                size = 7;
            }
            Iterator<String> it = list.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                strArr[i12] = it.next();
                i12++;
                if (i12 >= size) {
                    break;
                }
            }
            while (i12 < 7) {
                strArr[i12] = null;
                i12++;
            }
            return new s(strArr[0], strArr[1], strArr[2], strArr[3], strArr[4], strArr[5], strArr[6], i10, str, z10, i11);
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            String str;
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/postal-address_v2");
            newInsert.withValue("data2", Integer.valueOf(this.f16452i));
            if (this.f16452i == 0) {
                newInsert.withValue("data3", this.f16453j);
            }
            if (TextUtils.isEmpty(this.f16447d)) {
                if (TextUtils.isEmpty(this.f16446c)) {
                    str = null;
                } else {
                    str = this.f16446c;
                }
            } else if (TextUtils.isEmpty(this.f16446c)) {
                str = this.f16447d;
            } else {
                str = this.f16447d + " " + this.f16446c;
            }
            newInsert.withValue("data5", this.f16445b);
            newInsert.withValue("data4", str);
            newInsert.withValue("data7", this.f16448e);
            newInsert.withValue("data8", this.f16449f);
            newInsert.withValue("data9", this.f16450g);
            newInsert.withValue("data10", this.f16451h);
            newInsert.withValue("data1", h(this.f16455l));
            if (this.f16454k) {
                newInsert.withValue("is_primary", 1);
            }
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f16452i);
            sb.append(",");
            String str = this.f16453j;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(",");
            String str3 = this.f16447d;
            if (str3 == null) {
                str3 = "";
            }
            sb.append(str3);
            sb.append(",");
            String str4 = this.f16445b;
            if (str4 == null) {
                str4 = "";
            }
            sb.append(str4);
            sb.append(",");
            String str5 = this.f16448e;
            if (str5 == null) {
                str5 = "";
            }
            sb.append(str5);
            sb.append(",");
            String str6 = this.f16449f;
            if (str6 == null) {
                str6 = "";
            }
            sb.append(str6);
            sb.append(",");
            String str7 = this.f16450g;
            if (str7 == null) {
                str7 = "";
            }
            sb.append(str7);
            sb.append(",");
            String str8 = this.f16451h;
            if (str8 != null) {
                str2 = str8;
            }
            sb.append(str2);
            return sb.toString();
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public final EntryLabel c() {
            return EntryLabel.POSTAL_ADDRESS;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof s)) {
                return false;
            }
            s sVar = (s) obj;
            int i10 = this.f16452i;
            if (i10 == sVar.f16452i && ((i10 != 0 || TextUtils.equals(this.f16453j, sVar.f16453j)) && this.f16454k == sVar.f16454k && TextUtils.equals(this.f16445b, sVar.f16445b) && TextUtils.equals(this.f16446c, sVar.f16446c) && TextUtils.equals(this.f16447d, sVar.f16447d) && TextUtils.equals(this.f16448e, sVar.f16448e) && TextUtils.equals(this.f16449f, sVar.f16449f) && TextUtils.equals(this.f16450g, sVar.f16450g) && TextUtils.equals(this.f16451h, sVar.f16451h))) {
                return true;
            }
            return false;
        }

        public String h(int i10) {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {this.f16445b, this.f16446c, this.f16447d, this.f16448e, this.f16449f, this.f16450g, this.f16451h};
            boolean z10 = true;
            if (com.android.contacts.framework.vcard.e.e(i10)) {
                for (int i11 = 6; i11 >= 0; i11--) {
                    String str = strArr[i11];
                    if (!TextUtils.isEmpty(str)) {
                        if (!z10) {
                            sb.append(' ');
                        } else {
                            z10 = false;
                        }
                        sb.append(str);
                    }
                }
            } else {
                for (int i12 = 0; i12 < 7; i12++) {
                    String str2 = strArr[i12];
                    if (!TextUtils.isEmpty(str2)) {
                        if (!z10) {
                            sb.append(' ');
                        } else {
                            z10 = false;
                        }
                        sb.append(str2);
                    }
                }
            }
            return sb.toString().trim();
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12;
            int i13 = this.f16452i * 31;
            String str = this.f16453j;
            if (str != null) {
                i10 = str.hashCode();
            } else {
                i10 = 0;
            }
            int i14 = (i13 + i10) * 31;
            if (this.f16454k) {
                i11 = 1231;
            } else {
                i11 = 1237;
            }
            int i15 = i14 + i11;
            String[] strArr = {this.f16445b, this.f16446c, this.f16447d, this.f16448e, this.f16449f, this.f16450g, this.f16451h};
            for (int i16 = 0; i16 < 7; i16++) {
                String str2 = strArr[i16];
                int i17 = i15 * 31;
                if (str2 != null) {
                    i12 = str2.hashCode();
                } else {
                    i12 = 0;
                }
                i15 = i17 + i12;
            }
            return i15;
        }

        public int i() {
            return this.f16452i;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            if (TextUtils.isEmpty(this.f16445b) && TextUtils.isEmpty(this.f16446c) && TextUtils.isEmpty(this.f16447d) && TextUtils.isEmpty(this.f16448e) && TextUtils.isEmpty(this.f16449f) && TextUtils.isEmpty(this.f16450g) && TextUtils.isEmpty(this.f16451h)) {
                return true;
            }
            return false;
        }

        public String toString() {
            return String.format("type: %d, label: %s, isPrimary: %s, pobox: %s, extendedAddress: %s, street: %s, localty: %s, region: %s, postalCode %s, country: %s", Integer.valueOf(this.f16452i), this.f16453j, Boolean.valueOf(this.f16454k), this.f16445b, this.f16446c, this.f16447d, this.f16448e, this.f16449f, this.f16450g, this.f16451h);
        }
    }

    /* loaded from: classes.dex */
    public static class u extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16458b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16459c;

        /* renamed from: d, reason: collision with root package name */
        public final String f16460d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f16461e;

        public u(String str, int i10, String str2, boolean z10) {
            if (str.startsWith("sip:")) {
                this.f16458b = str.substring(4);
            } else {
                this.f16458b = str;
            }
            this.f16459c = i10;
            this.f16460d = str2;
            this.f16461e = z10;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/sip_address");
            newInsert.withValue("data1", this.f16458b);
            newInsert.withValue("data2", Integer.valueOf(this.f16459c));
            if (this.f16459c == 0) {
                newInsert.withValue("data3", this.f16460d);
            }
            boolean z10 = this.f16461e;
            if (z10) {
                newInsert.withValue("is_primary", Boolean.valueOf(z10));
            }
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f16459c);
            sb.append(",");
            String str = this.f16460d;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(",");
            String str3 = this.f16458b;
            if (str3 != null) {
                str2 = str3;
            }
            sb.append(str2);
            return sb.toString();
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public EntryLabel c() {
            return EntryLabel.SIP;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof u)) {
                return false;
            }
            u uVar = (u) obj;
            if (this.f16459c == uVar.f16459c && TextUtils.equals(this.f16460d, uVar.f16460d) && TextUtils.equals(this.f16458b, uVar.f16458b) && this.f16461e == uVar.f16461e) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11;
            int i12 = this.f16459c * 31;
            String str = this.f16460d;
            int i13 = 0;
            if (str != null) {
                i10 = str.hashCode();
            } else {
                i10 = 0;
            }
            int i14 = (i12 + i10) * 31;
            String str2 = this.f16458b;
            if (str2 != null) {
                i13 = str2.hashCode();
            }
            int i15 = (i14 + i13) * 31;
            if (this.f16461e) {
                i11 = 1231;
            } else {
                i11 = 1237;
            }
            return i15 + i11;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f16458b);
        }

        public String toString() {
            return "sip: " + this.f16458b;
        }
    }

    /* loaded from: classes.dex */
    public class v implements h {

        /* renamed from: a, reason: collision with root package name */
        public StringBuilder f16462a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f16463b;

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public void a() {
            this.f16462a.append("\n");
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public boolean b(g gVar) {
            if (!this.f16463b) {
                this.f16462a.append(", ");
                this.f16463b = false;
            }
            StringBuilder sb = this.f16462a;
            sb.append("[");
            sb.append(gVar.toString());
            sb.append("]");
            return true;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public void c() {
            StringBuilder sb = new StringBuilder();
            this.f16462a = sb;
            sb.append("[[hash: " + VCardEntry.this.hashCode() + "\n");
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public void d(EntryLabel entryLabel) {
            this.f16462a.append(entryLabel.toString() + ": ");
            this.f16463b = true;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public void e() {
            this.f16462a.append("]]\n");
        }

        public String toString() {
            return this.f16462a.toString();
        }

        public v() {
        }
    }

    /* loaded from: classes.dex */
    public static class w extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16465b;

        public w(String str) {
            this.f16465b = str;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(VCardEntry.C(ContactsContract.Data.CONTENT_URI));
            newInsert.withValueBackReference("raw_contact_id", i10);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/website");
            newInsert.withValue("data1", this.f16465b);
            newInsert.withValue("data2", 1);
            list.add(newInsert.build());
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            String str = this.f16465b;
            if (str == null) {
                return "";
            }
            return str;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public EntryLabel c() {
            return EntryLabel.WEBSITE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof w)) {
                return false;
            }
            return TextUtils.equals(this.f16465b, ((w) obj).f16465b);
        }

        public String g() {
            return this.f16465b;
        }

        public int hashCode() {
            String str = this.f16465b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f16465b);
        }

        public String toString() {
            return "website: " + this.f16465b;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f16342C = hashMap;
        hashMap.put("X-AIM", 0);
        hashMap.put("X-MSN", 1);
        hashMap.put("X-YAHOO", 2);
        hashMap.put("X-ICQ", 6);
        hashMap.put("X-JABBER", 7);
        hashMap.put("X-SKYPE-USERNAME", 3);
        hashMap.put("X-GOOGLE-TALK", 5);
        hashMap.put("X-GOOGLE TALK", 5);
        hashMap.put("X-QQ", 4);
        hashMap.put("X-WECHAT", 15);
        f16343D = Collections.unmodifiableList(new ArrayList(0));
    }

    public VCardEntry() {
        this(-1073741824);
    }

    public static Uri C(Uri uri) {
        return uri.buildUpon().appendQueryParameter(com.android.contacts.compat.data.f.c("from_customize_app"), "true").build();
    }

    public static String I() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static /* bridge */ /* synthetic */ String b() {
        return I();
    }

    public void A(String str, int i10, String str2, boolean z10) {
        z(0L, str, i10, str2, z10);
    }

    public void B(long j10, String str) {
        if (this.f16354i == null) {
            this.f16354i = new ArrayList(1);
        }
        this.f16354i.add((w) new w(str).f(j10));
    }

    public final String D(Map<String, Collection<String>> map) {
        Collection<String> collection = map.get("SORT-AS");
        if (collection != null && collection.size() != 0) {
            if (collection.size() > 1) {
                H7.b.i(com.android.contacts.framework.vcard.h.LOG_TAG, "Incorrect multiple SORT_AS parameters detected: " + Arrays.toString(collection.toArray()));
            }
            List<String> c10 = VCardUtils.c(collection.iterator().next(), this.f16370y);
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = c10.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            return sb.toString();
        }
        return null;
    }

    public void E() {
        this.f16347b.f16424l = F();
    }

    public final String F() {
        String n10;
        if (!TextUtils.isEmpty(this.f16347b.f16419g)) {
            n10 = this.f16347b.f16419g;
        } else if (!this.f16347b.A()) {
            n10 = VCardUtils.e(this.f16370y, this.f16347b.f16414b, this.f16347b.f16416d, this.f16347b.f16415c, this.f16347b.f16417e, this.f16347b.f16418f);
        } else if (!this.f16347b.z()) {
            n10 = VCardUtils.f(this.f16347b.f16420h, this.f16347b.f16422j, this.f16347b.f16421i);
        } else {
            List<f> list = this.f16349d;
            if (list != null && list.size() > 0) {
                n10 = this.f16349d.get(0).f16399b;
            } else {
                List<q> list2 = this.f16348c;
                if (list2 != null && list2.size() > 0) {
                    n10 = this.f16348c.get(0).f16433b;
                } else {
                    List<s> list3 = this.f16350e;
                    if (list3 != null && list3.size() > 0) {
                        n10 = this.f16350e.get(0).h(this.f16370y);
                    } else {
                        List<p> list4 = this.f16351f;
                        n10 = (list4 == null || list4.size() <= 0) ? null : this.f16351f.get(0).n();
                    }
                }
            }
        }
        if (n10 == null) {
            return "";
        }
        return n10;
    }

    public ArrayList<ContentProviderOperation> G(int i10) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        if (j0()) {
            H7.b.b("VCardEntry", "constructInsertOperations : isIgnorable.");
            return arrayList;
        }
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(C(ContactsContract.RawContacts.CONTENT_URI));
        Account account = this.f16371z;
        if (account != null) {
            newInsert.withValue("account_name", account.f16941a);
            newInsert.withValue("account_type", this.f16371z.f16942b);
        } else {
            newInsert.withValue("account_name", null);
            newInsert.withValue("account_type", null);
        }
        if (!TextUtils.isEmpty(this.f16364s)) {
            newInsert.withValue(R0.c.f3184b, this.f16364s);
        }
        if (!TextUtils.isEmpty(this.f16365t)) {
            newInsert.withValue("starred", this.f16365t);
        }
        arrayList.add(newInsert.build());
        k0(new k(arrayList, i10));
        return arrayList;
    }

    public ArrayList<ContentProviderOperation> H(ContentResolver contentResolver, ArrayList<ContentProviderOperation> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (j0()) {
            return arrayList;
        }
        if (this.f16346a == null) {
            this.f16346a = contentResolver;
        }
        int size = arrayList.size();
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(C(ContactsContract.RawContacts.CONTENT_URI));
        Account account = this.f16371z;
        if (account != null) {
            newInsert.withValue("account_name", account.f16941a);
            newInsert.withValue("account_type", this.f16371z.f16942b);
        } else {
            newInsert.withValue("account_name", null);
            newInsert.withValue("account_type", null);
        }
        if (!TextUtils.isEmpty(this.f16364s)) {
            newInsert.withValue(R0.c.f3184b, this.f16364s);
        }
        if (!TextUtils.isEmpty(this.f16365t)) {
            newInsert.withValue("starred", this.f16365t);
        }
        arrayList.add(newInsert.build());
        k0(new k(arrayList, size));
        return arrayList;
    }

    public List<b> J() {
        return this.f16358m;
    }

    public c K() {
        return this.f16360o;
    }

    public final List<d> L() {
        return this.f16359n;
    }

    public List<e> M() {
        return this.f16363r;
    }

    public String N() {
        m mVar = this.f16347b;
        if (mVar.f16424l == null) {
            mVar.f16424l = F();
        }
        return this.f16347b.f16424l;
    }

    public final List<f> O() {
        return this.f16349d;
    }

    public final List<i> P() {
        return this.f16361p;
    }

    public final List<j> Q() {
        return this.f16352g;
    }

    public int R() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        List<q> list = this.f16348c;
        int i24 = 0;
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        int i25 = 2 + i10;
        List<f> list2 = this.f16349d;
        if (list2 != null) {
            i11 = list2.size();
        } else {
            i11 = 0;
        }
        int i26 = i25 + i11;
        List<s> list3 = this.f16350e;
        if (list3 != null) {
            i12 = list3.size();
        } else {
            i12 = 0;
        }
        int i27 = i26 + i12;
        List<p> list4 = this.f16351f;
        if (list4 != null) {
            i13 = list4.size();
        } else {
            i13 = 0;
        }
        int i28 = i27 + i13;
        List<j> list5 = this.f16352g;
        if (list5 != null) {
            i14 = list5.size();
        } else {
            i14 = 0;
        }
        int i29 = i28 + i14;
        List<r> list6 = this.f16353h;
        if (list6 != null) {
            i15 = list6.size();
        } else {
            i15 = 0;
        }
        int i30 = i29 + i15;
        List<w> list7 = this.f16354i;
        if (list7 != null) {
            i16 = list7.size();
        } else {
            i16 = 0;
        }
        int i31 = i30 + i16;
        List<u> list8 = this.f16355j;
        if (list8 != null) {
            i17 = list8.size();
        } else {
            i17 = 0;
        }
        int i32 = i31 + i17;
        List<n> list9 = this.f16356k;
        if (list9 != null) {
            i18 = list9.size();
        } else {
            i18 = 0;
        }
        int i33 = i32 + i18;
        List<o> list10 = this.f16357l;
        if (list10 != null) {
            i19 = list10.size();
        } else {
            i19 = 0;
        }
        int i34 = i33 + i19;
        List<b> list11 = this.f16358m;
        if (list11 != null) {
            i20 = list11.size();
        } else {
            i20 = 0;
        }
        int i35 = i34 + i20;
        List<i> list12 = this.f16361p;
        if (list12 != null) {
            i21 = list12.size();
        } else {
            i21 = 0;
        }
        int i36 = i35 + i21;
        List<d> list13 = this.f16359n;
        if (list13 != null) {
            i22 = list13.size();
        } else {
            i22 = 0;
        }
        int i37 = i36 + i22;
        List<e> list14 = this.f16363r;
        if (list14 != null) {
            i23 = list14.size();
        } else {
            i23 = 0;
        }
        int i38 = i37 + i23;
        if (this.f16360o != null) {
            i24 = 1;
        }
        return i38 + i24;
    }

    public final m S() {
        return this.f16347b;
    }

    public final List<n> T() {
        return this.f16356k;
    }

    public final List<o> U() {
        return this.f16357l;
    }

    public final List<p> V() {
        return this.f16351f;
    }

    public final List<q> W() {
        return this.f16348c;
    }

    public final List<r> X() {
        return this.f16353h;
    }

    public final List<s> Y() {
        return this.f16350e;
    }

    public long Z() {
        return this.f16345B;
    }

    public final List<t> a0() {
        return this.f16362q;
    }

    public final List<u> b0() {
        return this.f16355j;
    }

    public final void c(String str, byte[] bArr, int i10) {
        if (this.f16363r == null) {
            this.f16363r = new ArrayList(1);
        }
        this.f16363r.add(new e(str, bArr, i10));
    }

    public final List<w> c0() {
        return this.f16354i;
    }

    public void d(VCardEntry vCardEntry) {
        if (this.f16344A == null) {
            this.f16344A = new ArrayList();
        }
        this.f16344A.add(vCardEntry);
    }

    public final void d0(List<String> list) {
        if (this.f16358m == null) {
            this.f16358m = new ArrayList();
        }
        this.f16358m.add(b.g(list));
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f16364s = String.valueOf(Long.valueOf(Long.parseLong(str)));
            } catch (Exception e10) {
                H7.b.c(com.android.contacts.framework.vcard.h.LOG_TAG, "addCustomizeModifyDate parseLong error " + e10);
            }
        }
    }

    public final void e0(List<String> list, Map<String, Collection<String>> map) {
        int size;
        s0(map);
        if (list != null && (size = list.size()) >= 1) {
            if (size > 5) {
                size = 5;
            }
            if (size != 2) {
                if (size != 3) {
                    if (size != 4) {
                        if (size == 5) {
                            this.f16347b.f16418f = q0(list.get(4), 200);
                        }
                        this.f16347b.f16414b = q0(list.get(0), 200);
                    }
                    this.f16347b.f16417e = q0(list.get(3), 200);
                }
                this.f16347b.f16416d = q0(list.get(2), 200);
            }
            this.f16347b.f16415c = q0(list.get(1), 200);
            this.f16347b.f16414b = q0(list.get(0), 200);
        }
    }

    public void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f16365t = String.valueOf(Long.valueOf(Long.parseLong(str)));
            } catch (Exception e10) {
                H7.b.c(com.android.contacts.framework.vcard.h.LOG_TAG, "addCustomizeStarred parseLong error " + e10);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f0(int r8, java.util.List<java.lang.String> r9, java.util.Map<java.lang.String, java.util.Collection<java.lang.String>> r10, boolean r11) {
        /*
            r7 = this;
            java.lang.String r4 = r7.D(r10)
            if (r9 != 0) goto L8
            java.util.List<java.lang.String> r9 = com.android.contacts.framework.vcard.VCardEntry.f16343D
        L8:
            int r10 = r9.size()
            r0 = 0
            if (r10 == 0) goto L44
            r1 = 0
            r2 = 1
            if (r10 == r2) goto L3b
            java.lang.Object r0 = r9.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r3 = r2
        L1f:
            if (r3 >= r10) goto L34
            if (r3 <= r2) goto L28
            r5 = 32
            r1.append(r5)
        L28:
            java.lang.Object r5 = r9.get(r3)
            java.lang.String r5 = (java.lang.String) r5
            r1.append(r5)
            int r3 = r3 + 1
            goto L1f
        L34:
            java.lang.String r9 = r1.toString()
            r2 = r9
            r1 = r0
            goto L47
        L3b:
            java.lang.Object r9 = r9.get(r1)
            java.lang.String r9 = (java.lang.String) r9
        L41:
            r1 = r9
            r2 = r0
            goto L47
        L44:
            java.lang.String r9 = ""
            goto L41
        L47:
            java.util.List<com.android.contacts.framework.vcard.VCardEntry$p> r9 = r7.f16351f
            if (r9 != 0) goto L53
            r3 = 0
            r0 = r7
            r5 = r8
            r6 = r11
            r0.n(r1, r2, r3, r4, r5, r6)
            return
        L53:
            java.util.Iterator r9 = r9.iterator()
        L57:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L79
            java.lang.Object r10 = r9.next()
            com.android.contacts.framework.vcard.VCardEntry$p r10 = (com.android.contacts.framework.vcard.VCardEntry.p) r10
            java.lang.String r0 = com.android.contacts.framework.vcard.VCardEntry.p.h(r10)
            if (r0 != 0) goto L57
            java.lang.String r0 = com.android.contacts.framework.vcard.VCardEntry.p.g(r10)
            if (r0 != 0) goto L57
            com.android.contacts.framework.vcard.VCardEntry.p.l(r10, r1)
            com.android.contacts.framework.vcard.VCardEntry.p.j(r10, r2)
            com.android.contacts.framework.vcard.VCardEntry.p.k(r10, r11)
            return
        L79:
            r3 = 0
            r0 = r7
            r5 = r8
            r6 = r11
            r0.n(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.vcard.VCardEntry.f0(int, java.util.List, java.util.Map, boolean):void");
    }

    public void g(int i10, String str, String str2, boolean z10) {
        h(0L, i10, str, str2, z10);
    }

    public final void g0(List<String> list) {
        int size;
        if (TextUtils.isEmpty(this.f16347b.f16420h) && TextUtils.isEmpty(this.f16347b.f16422j) && TextUtils.isEmpty(this.f16347b.f16421i) && list != null && (size = list.size()) >= 1) {
            if (size > 3) {
                size = 3;
            }
            if (list.get(0).length() > 0) {
                for (int i10 = 1; i10 < size; i10++) {
                    if (list.get(i10).length() <= 0) {
                    }
                }
                String[] split = list.get(0).split(" ");
                int length = split.length;
                if (length == 3) {
                    this.f16347b.f16420h = split[0];
                    this.f16347b.f16422j = split[1];
                    this.f16347b.f16421i = split[2];
                    return;
                } else if (length == 2) {
                    this.f16347b.f16420h = split[0];
                    this.f16347b.f16421i = split[1];
                    return;
                } else {
                    this.f16347b.f16421i = list.get(0);
                    return;
                }
            }
            if (size != 2) {
                if (size == 3) {
                    this.f16347b.f16422j = list.get(2);
                }
                this.f16347b.f16420h = list.get(0);
            }
            this.f16347b.f16421i = list.get(1);
            this.f16347b.f16420h = list.get(0);
        }
    }

    public void h(long j10, int i10, String str, String str2, boolean z10) {
        if (this.f16349d == null) {
            this.f16349d = new ArrayList();
        }
        this.f16349d.add((f) new f(str, i10, str2, z10).f(j10));
    }

    public final void h0(String str, Collection<String> collection) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("sip:")) {
            str = str.substring(4);
            if (str.length() == 0) {
                return;
            }
        }
        boolean z10 = false;
        int i10 = -1;
        String str2 = null;
        if (collection != null) {
            boolean z11 = false;
            for (String str3 : collection) {
                String upperCase = str3.toUpperCase();
                int i11 = 1;
                if (upperCase.equals("PREF")) {
                    z11 = true;
                } else {
                    if (!upperCase.equals("HOME")) {
                        i11 = 2;
                        if (!upperCase.equals("WORK")) {
                            if (i10 < 0) {
                                if (upperCase.startsWith("X-")) {
                                    str3 = str3.substring(2);
                                }
                                i10 = 0;
                                str2 = str3;
                            }
                        }
                    }
                    i10 = i11;
                }
            }
            z10 = z11;
        }
        if (i10 < 0) {
            i10 = 3;
        }
        A(str, i10, str2, z10);
    }

    public void i(long j10, String str, int i10, int i11) {
        if (this.f16359n == null) {
            this.f16359n = new ArrayList(2);
        }
        this.f16359n.add((d) new d(str, i10, i11).f(j10));
    }

    public final void i0(String str) {
        List<p> list = this.f16351f;
        if (list == null) {
            n(null, null, str, null, 1, false);
            return;
        }
        for (p pVar : list) {
            if (pVar.f16429d == null) {
                pVar.f16429d = str;
                return;
            }
        }
        n(null, null, str, null, 1, false);
    }

    public void j(String str) {
        if (H7.a.b()) {
            H7.b.b(com.android.contacts.framework.vcard.h.LOG_TAG, "addGroupTitle(), groupTitle = " + str);
        }
        if (str == null) {
            return;
        }
        String C10 = VCardUtils.C(str);
        if (this.f16361p == null) {
            this.f16361p = new ArrayList();
        }
        Iterator<i> it = this.f16361p.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(C10, it.next().g())) {
                return;
            }
        }
        this.f16361p.add(new i(C10, this.f16371z, this.f16346a));
    }

    public boolean j0() {
        l lVar = new l();
        k0(lVar);
        return lVar.f();
    }

    public void k(int i10, String str, String str2, int i11, boolean z10) {
        l(0L, i10, str, str2, i11, z10);
    }

    public final void k0(h hVar) {
        hVar.c();
        hVar.d(this.f16347b.c());
        hVar.b(this.f16347b);
        hVar.a();
        l0(this.f16348c, hVar);
        l0(this.f16349d, hVar);
        l0(this.f16350e, hVar);
        l0(this.f16351f, hVar);
        l0(this.f16352g, hVar);
        l0(this.f16353h, hVar);
        l0(this.f16354i, hVar);
        l0(this.f16355j, hVar);
        l0(this.f16356k, hVar);
        l0(this.f16357l, hVar);
        l0(this.f16358m, hVar);
        l0(this.f16361p, hVar);
        l0(this.f16359n, hVar);
        l0(this.f16363r, hVar);
        c cVar = this.f16360o;
        if (cVar != null) {
            hVar.d(cVar.c());
            hVar.b(this.f16360o);
            hVar.a();
        }
        hVar.e();
    }

    public void l(long j10, int i10, String str, String str2, int i11, boolean z10) {
        if (this.f16352g == null) {
            this.f16352g = new ArrayList();
        }
        this.f16352g.add((j) new j(i10, str, str2, i11, z10).f(j10));
    }

    public final void l0(List<? extends g> list, h hVar) {
        if (list != null && list.size() > 0) {
            hVar.d(list.get(0).c());
            Iterator<? extends g> it = list.iterator();
            while (it.hasNext()) {
                hVar.b(it.next());
            }
            hVar.a();
        }
    }

    public void m(long j10, String str, String str2, String str3, String str4, int i10, boolean z10) {
        if (this.f16351f == null) {
            this.f16351f = new ArrayList();
        }
        this.f16351f.add((p) new p(str, str2, str3, str4, i10, z10).f(j10));
    }

    public final String m0(List<String> list) {
        int size = list.size();
        if (size > 1) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (size - 1 > 0) {
                    sb.append(Constants.DataMigration.SPLIT_TAG);
                }
            }
            return sb.toString();
        }
        if (size == 1) {
            return list.get(0);
        }
        return "";
    }

    public void n(String str, String str2, String str3, String str4, int i10, boolean z10) {
        m(0L, str, str2, str3, str4, i10, z10);
    }

    public final void n0(String str) {
        if (str.length() >= 12) {
            if (str.contains("L") && str.indexOf(76) == 10) {
                int intValue = ((Integer.valueOf(str.substring(0, 4), 10).intValue() - 45) * 60) + Integer.valueOf(str.substring(4, 8), 10).intValue() + 3;
                String[] split = str.substring(8).split("L");
                if (split.length == 2) {
                    int intValue2 = Integer.valueOf(split[0], 10).intValue();
                    int intValue3 = Integer.valueOf(split[1], 10).intValue();
                    if (H7.a.b()) {
                        H7.b.b(com.android.contacts.framework.vcard.h.LOG_TAG, "contains L year month date -> " + intValue + " " + intValue2 + " " + intValue3);
                    }
                    int[] iArr = {intValue, intValue2, intValue3, 0};
                    int[] iArr2 = new int[3];
                    F7.c.a(iArr, iArr2);
                    this.f16359n.add(new d(F7.a.a(iArr2[0], iArr2[1], iArr2[2]), 1000));
                    return;
                }
                return;
            }
            if (!str.contains("L")) {
                int parseInt = ((Integer.parseInt(str.substring(0, 4), 10) - 45) * 60) + Integer.parseInt(str.substring(4, 8), 10) + 3;
                int parseInt2 = Integer.parseInt(str.substring(8));
                int i10 = parseInt2 / 100;
                int i11 = parseInt2 % 100;
                if (H7.a.b()) {
                    H7.b.b(com.android.contacts.framework.vcard.h.LOG_TAG, "year month date -> " + parseInt + " " + i10 + " " + i11);
                }
                int[] iArr3 = {parseInt, i10, i11, 1};
                int[] iArr4 = new int[3];
                F7.c.a(iArr3, iArr4);
                this.f16359n.add(new d(F7.a.a(iArr4[0], iArr4[1], iArr4[2]), 1000));
                return;
            }
            return;
        }
        if (str.length() >= 6 && str.startsWith("--")) {
            String replace = str.replace("--", String.valueOf(COUIDateMonthView.MIN_YEAR));
            if (H7.a.b()) {
                H7.b.b(com.android.contacts.framework.vcard.h.LOG_TAG, "date = " + replace);
            }
            this.f16359n.add(new d(replace, 1000));
        }
    }

    public void o(long j10, String str) {
        if (this.f16356k == null) {
            this.f16356k = new ArrayList();
        }
        this.f16356k.add((n) new n(str).f(j10));
    }

    public void o0(ContentResolver contentResolver) {
        this.f16346a = contentResolver;
    }

    public void p(String str) {
        o(0L, str);
    }

    public void p0(long j10) {
        this.f16345B = j10;
    }

    public void q(long j10, String str) {
        if (this.f16357l == null) {
            this.f16357l = new ArrayList(1);
        }
        this.f16357l.add((o) new o(str).f(j10));
    }

    public final String q0(String str, int i10) {
        if (str != null && str.length() > i10) {
            return str.substring(0, i10);
        }
        return str;
    }

    public void r(String str) {
        q(0L, str);
    }

    public final String r0(String str, String str2) {
        if ("TEL".equals(str)) {
            return q0(str2, 990);
        }
        if ("X-PHONETIC-FIRST-NAME".equals(str)) {
            return q0(str2, 200);
        }
        if ("X-PHONETIC-MIDDLE-NAME".equals(str)) {
            return q0(str2, 200);
        }
        if ("X-PHONETIC-LAST-NAME".equals(str)) {
            return q0(str2, 200);
        }
        return q0(str2, 1000);
    }

    public void s(int i10, String str, String str2, boolean z10, String str3, String str4, String str5, String str6) {
        t(0L, i10, str, str2, z10, str3, str4, str5, str6);
    }

    public final void s0(Map<String, Collection<String>> map) {
        Collection<String> collection;
        if ((!com.android.contacts.framework.vcard.e.g(this.f16370y) || (TextUtils.isEmpty(this.f16347b.f16420h) && TextUtils.isEmpty(this.f16347b.f16422j) && TextUtils.isEmpty(this.f16347b.f16421i))) && (collection = map.get("SORT-AS")) != null && collection.size() != 0) {
            if (collection.size() > 1) {
                H7.b.i(com.android.contacts.framework.vcard.h.LOG_TAG, "Incorrect multiple SORT_AS parameters detected: " + Arrays.toString(collection.toArray()));
            }
            List<String> c10 = VCardUtils.c(collection.iterator().next(), this.f16370y);
            int size = c10.size();
            if (size > 3) {
                size = 3;
            }
            if (size != 2) {
                if (size == 3) {
                    this.f16347b.f16422j = c10.get(2);
                }
                this.f16347b.f16420h = c10.get(0);
            }
            this.f16347b.f16421i = c10.get(1);
            this.f16347b.f16420h = c10.get(0);
        }
    }

    public void t(long j10, int i10, String str, String str2, boolean z10, String str3, String str4, String str5, String str6) {
        if (this.f16348c == null) {
            this.f16348c = new ArrayList();
        }
        StringBuilder sb = new StringBuilder();
        String trim = str.trim();
        if (i10 != 6 && !com.android.contacts.framework.vcard.e.k(this.f16370y)) {
            int length = trim.length();
            boolean z11 = false;
            for (int i11 = 0; i11 < length; i11++) {
                char charAt = trim.charAt(i11);
                if (charAt != 'p' && charAt != 'P') {
                    if (charAt != 'w' && charAt != 'W') {
                        if (charAt != '*' && charAt != '#') {
                            if (('0' <= charAt && charAt <= '9') || (i11 == 0 && charAt == '+')) {
                                sb.append(charAt);
                            }
                        } else {
                            sb.append(charAt);
                        }
                    } else {
                        sb.append(';');
                    }
                } else {
                    sb.append(',');
                }
                z11 = true;
            }
            trim = !z11 ? sb.toString() : sb.toString();
        }
        String str7 = trim;
        if (j10 == 0) {
            Iterator<q> it = this.f16348c.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(str7, it.next().f16433b)) {
                    H7.b.i(com.android.contacts.framework.vcard.h.LOG_TAG, "list not add, found duplicated number:" + H7.a.d(str7));
                    return;
                }
            }
        }
        q qVar = new q(str7, i10, str2, z10, str3, str4, str5, str6);
        qVar.f(j10);
        this.f16348c.add(qVar);
    }

    public String toString() {
        v vVar = new v();
        k0(vVar);
        return vVar.toString();
    }

    public final void u(String str, byte[] bArr, boolean z10) {
        if (this.f16353h == null) {
            this.f16353h = new ArrayList(1);
        }
        this.f16353h.add(new r(str, bArr, z10));
    }

    public void v(int i10, List<String> list, String str, boolean z10) {
        w(0L, i10, list, str, z10);
    }

    public void w(long j10, int i10, List<String> list, String str, boolean z10) {
        if (this.f16350e == null) {
            this.f16350e = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(q0(it.next(), 100));
        }
        this.f16350e.add((s) s.g(arrayList, i10, str, z10, this.f16370y).f(j10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:206:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x028a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x(com.android.contacts.framework.vcard.u r19) {
        /*
            Method dump skipped, instructions count: 1438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.vcard.VCardEntry.x(com.android.contacts.framework.vcard.u):void");
    }

    public void y(long j10, String str, String str2) {
        if (this.f16362q == null) {
            this.f16362q = new ArrayList();
        }
        this.f16362q.add((t) new t(str, str2).f(j10));
    }

    public void z(long j10, String str, int i10, String str2, boolean z10) {
        if (this.f16355j == null) {
            this.f16355j = new ArrayList();
        }
        this.f16355j.add((u) new u(str, i10, str2, z10).f(j10));
    }

    public VCardEntry(int i10) {
        this(i10, null);
    }

    public VCardEntry(int i10, Account account) {
        this.f16346a = null;
        this.f16347b = new m();
        this.f16366u = null;
        this.f16367v = null;
        this.f16368w = null;
        this.f16369x = null;
        this.f16370y = i10;
        this.f16371z = account;
    }

    /* loaded from: classes.dex */
    public static class k implements h {

        /* renamed from: a, reason: collision with root package name */
        public final List<ContentProviderOperation> f16411a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16412b;

        public k(List<ContentProviderOperation> list, int i10) {
            this.f16411a = list;
            this.f16412b = i10;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public boolean b(g gVar) {
            if (!gVar.isEmpty()) {
                gVar.a(this.f16411a, this.f16412b);
                return true;
            }
            return true;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public void a() {
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public void c() {
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public void d(EntryLabel entryLabel) {
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.h
        public void e() {
        }
    }

    /* loaded from: classes.dex */
    public static class t extends a implements g {

        /* renamed from: b, reason: collision with root package name */
        public final String f16456b;

        /* renamed from: c, reason: collision with root package name */
        public final String f16457c;

        public t(String str, String str2) {
            this.f16457c = str;
            this.f16456b = str2;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public String b() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f16457c);
            sb.append(",");
            String str = this.f16456b;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            return sb.toString();
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public EntryLabel c() {
            return EntryLabel.ANDROID_CUSTOM;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof t)) {
                return false;
            }
            return TextUtils.equals(this.f16456b, ((t) obj).f16456b);
        }

        public int hashCode() {
            String str = this.f16456b;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public boolean isEmpty() {
            return TextUtils.isEmpty(this.f16456b);
        }

        @Override // com.android.contacts.framework.vcard.VCardEntry.g
        public void a(List<ContentProviderOperation> list, int i10) {
        }
    }
}
