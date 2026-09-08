package com.android.contacts.model;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Entity;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.ContactsApplication;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.statistics.InputFieldUploadStatus;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.google.common.collect.Maps;
import com.google.common.collect.n;
import com.google.common.collect.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import n1.AbstractC1362a;

/* loaded from: classes.dex */
public class EntityDelta implements Parcelable {
    public static final Parcelable.Creator<EntityDelta> CREATOR = new a();

    /* renamed from: x, reason: collision with root package name */
    public static b f16972x;

    /* renamed from: b, reason: collision with root package name */
    public ValuesDelta f16974b;

    /* renamed from: q, reason: collision with root package name */
    public InputFieldUploadStatus f16989q;

    /* renamed from: a, reason: collision with root package name */
    public long f16973a = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f16975c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f16976d = null;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<Account> f16977e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<Account> f16978f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<Long> f16979g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<Long> f16980h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<Long> f16981i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public HashMap<String, Long> f16982j = Maps.f();

    /* renamed from: k, reason: collision with root package name */
    public Uri f16983k = ContactsContract.RawContacts.CONTENT_URI;

    /* renamed from: l, reason: collision with root package name */
    public HashMap<String, ArrayList<ValuesDelta>> f16984l = Maps.f();

    /* renamed from: m, reason: collision with root package name */
    public HashMap<String, ArrayList<ValuesDelta>> f16985m = Maps.f();

    /* renamed from: n, reason: collision with root package name */
    public boolean f16986n = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f16987o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f16988p = true;

    /* renamed from: r, reason: collision with root package name */
    public b f16990r = null;

    /* loaded from: classes.dex */
    public static class ValuesDelta implements Parcelable {
        public static final Parcelable.Creator<ValuesDelta> CREATOR = new a();

        /* renamed from: g, reason: collision with root package name */
        public static int f16991g = -1;

        /* renamed from: a, reason: collision with root package name */
        public ContentValues f16992a;

        /* renamed from: b, reason: collision with root package name */
        public ContentValues f16993b;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<ValuesDelta> f16995d;

        /* renamed from: f, reason: collision with root package name */
        public boolean f16997f;

        /* renamed from: c, reason: collision with root package name */
        public String f16994c = BreenoCallContract.BaseColumns._ID;

        /* renamed from: e, reason: collision with root package name */
        public b f16996e = null;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<ValuesDelta> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ValuesDelta createFromParcel(Parcel parcel) {
                ValuesDelta valuesDelta = new ValuesDelta();
                valuesDelta.l0(parcel);
                return valuesDelta;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ValuesDelta[] newArray(int i10) {
                return new ValuesDelta[i10];
            }
        }

        public static ValuesDelta m(ContentValues contentValues) {
            ValuesDelta valuesDelta = new ValuesDelta();
            valuesDelta.f16992a = null;
            valuesDelta.f16993b = contentValues;
            String str = valuesDelta.f16994c;
            int i10 = f16991g;
            f16991g = i10 - 1;
            contentValues.put(str, Integer.valueOf(i10));
            return valuesDelta;
        }

        public static ValuesDelta n(ContentValues contentValues) {
            ValuesDelta valuesDelta = new ValuesDelta();
            valuesDelta.f16992a = contentValues;
            valuesDelta.f16993b = new ContentValues();
            return valuesDelta;
        }

        public ContentValues A() {
            return this.f16992a;
        }

        public ContentValues C() {
            ContentValues contentValues = new ContentValues();
            ContentValues contentValues2 = this.f16992a;
            if (contentValues2 != null) {
                contentValues.putAll(contentValues2);
            }
            ContentValues contentValues3 = this.f16993b;
            if (contentValues3 != null) {
                contentValues.putAll(contentValues3);
            }
            if (contentValues.containsKey("data1")) {
                contentValues.remove("group_sourceid");
            }
            return contentValues;
        }

        public ArrayList<ValuesDelta> D() {
            if (this.f16995d == null) {
                this.f16995d = new ArrayList<>();
            }
            return this.f16995d;
        }

        public Long E() {
            return x(this.f16994c);
        }

        public String F() {
            return z("mimetype");
        }

        public boolean H() {
            if (h() && this.f16993b == null) {
                return true;
            }
            return false;
        }

        public boolean J() {
            return this.f16997f;
        }

        public boolean K() {
            if (!h() && this.f16993b != null) {
                return true;
            }
            return false;
        }

        public boolean M() {
            ContentValues contentValues;
            if (h() && (contentValues = this.f16993b) != null && contentValues.size() == 0) {
                return true;
            }
            return false;
        }

        public boolean N() {
            Long x10 = x("is_primary");
            if (x10 == null || x10.longValue() == 0) {
                return false;
            }
            return true;
        }

        public boolean P() {
            if (this.f16992a == null && this.f16993b == null) {
                return true;
            }
            return false;
        }

        public boolean Q() {
            ContentValues contentValues;
            if (h() && (contentValues = this.f16993b) != null && contentValues.size() != 0) {
                for (String str : this.f16993b.keySet()) {
                    if (str.equals("custom_ringtone") && this.f16993b.containsKey(str) && !this.f16992a.containsKey(str)) {
                        return true;
                    }
                    if (str.equals("custom_vibration") && this.f16993b.containsKey(str) && !this.f16992a.containsKey(str)) {
                        return true;
                    }
                    ContentValues contentValues2 = this.f16993b;
                    if (contentValues2 == null || this.f16992a == null) {
                        break;
                    }
                    Object obj = contentValues2.get(str);
                    Object obj2 = this.f16992a.get(str);
                    if (obj != null && "vnd.android.cursor.item/phone_v2".equals(this.f16992a.get("mimetype"))) {
                        obj = TextUtils.equals(str, "data1") ? U7.f.d(obj.toString()) : U7.f.f(obj.toString());
                    }
                    if (obj2 != null && "vnd.android.cursor.item/phone_v2".equals(this.f16992a.get("mimetype"))) {
                        obj2 = TextUtils.equals(str, "data1") ? U7.f.d(obj2.toString()) : U7.f.f(obj2.toString());
                    }
                    if (C0637b.h() && "vnd.android.cursor.item/phone_v2".equals(this.f16992a.get("mimetype"))) {
                        return false;
                    }
                    if (obj2 == null) {
                        if (obj != null && !TextUtils.isEmpty(obj.toString())) {
                            return true;
                        }
                    } else {
                        if (obj != null && !obj2.toString().equals(obj.toString())) {
                            return true;
                        }
                        if (obj == null && !TextUtils.isEmpty(obj2.toString()) && ("vnd.android.cursor.item/photo".equals(this.f16992a.get("mimetype")) || str.equals("custom_vibration") || str.equals("custom_ringtone"))) {
                            return true;
                        }
                        if (obj == null && !TextUtils.isEmpty(obj2.toString())) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean R() {
            if (this.f16993b != null) {
                return true;
            }
            return false;
        }

        public final Set<String> W() {
            HashSet d10 = y.d();
            ContentValues contentValues = this.f16992a;
            if (contentValues != null) {
                Iterator<Map.Entry<String, Object>> it = contentValues.valueSet().iterator();
                while (it.hasNext()) {
                    d10.add(it.next().getKey());
                }
            }
            ContentValues contentValues2 = this.f16993b;
            if (contentValues2 != null) {
                Iterator<Map.Entry<String, Object>> it2 = contentValues2.valueSet().iterator();
                while (it2.hasNext()) {
                    d10.add(it2.next().getKey());
                }
            }
            return d10;
        }

        public void Y() {
            this.f16993b = null;
            ArrayList<ValuesDelta> arrayList = this.f16995d;
            if (arrayList != null) {
                Iterator<ValuesDelta> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().f16993b = null;
                }
            }
            b bVar = this.f16996e;
            if (bVar != null) {
                bVar.a();
                return;
            }
            b A10 = EntityDelta.A();
            if (A10 != null) {
                A10.a();
            }
        }

        public void b0(String str, int i10) {
            k();
            this.f16993b.put(str, Integer.valueOf(i10));
        }

        public void d(ValuesDelta valuesDelta) {
            if (this.f16995d == null) {
                this.f16995d = new ArrayList<>();
            }
            valuesDelta.f16993b = this.f16993b;
            this.f16995d.add(valuesDelta);
        }

        public void d0(String str, long j10) {
            k();
            this.f16993b.put(str, Long.valueOf(j10));
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void e0(String str, String str2) {
            k();
            this.f16993b.put(str, str2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ValuesDelta)) {
                return false;
            }
            ValuesDelta valuesDelta = (ValuesDelta) obj;
            if (!t0(valuesDelta) || !valuesDelta.t0(this)) {
                return false;
            }
            return true;
        }

        public boolean f(String str) {
            ContentValues contentValues = this.f16992a;
            if (contentValues != null && contentValues.containsKey(str)) {
                return true;
            }
            return false;
        }

        public boolean h() {
            ContentValues contentValues = this.f16992a;
            if (contentValues != null && contentValues.containsKey(this.f16994c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public ContentProviderOperation.Builder i(Uri uri) {
            ContentProviderOperation.Builder newUpdate;
            p0("account_writable");
            p0("account_name");
            if (K()) {
                this.f16993b.remove(this.f16994c);
                ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(uri));
                newInsert.withValues(this.f16993b);
                return newInsert;
            }
            if (H()) {
                ContentProviderOperation.Builder newDelete = ContentProviderOperation.newDelete(uri);
                newDelete.withSelection(this.f16994c + "=" + E(), null);
                return newDelete;
            }
            if (!Q()) {
                return null;
            }
            if (TextUtils.equals(F(), "vnd.android.cursor.item/omoji_photo") && E().longValue() < 0) {
                this.f16993b.remove(this.f16994c);
                newUpdate = ContentProviderOperation.newInsert(R0.d.a(uri));
            } else {
                newUpdate = ContentProviderOperation.newUpdate(uri);
                newUpdate.withSelection(this.f16994c + "=" + E(), null);
            }
            newUpdate.withValues(this.f16993b);
            return newUpdate;
        }

        public void i0(String str, byte[] bArr) {
            k();
            this.f16993b.put(str, bArr);
        }

        public boolean j(String str) {
            ContentValues contentValues;
            ContentValues contentValues2 = this.f16993b;
            if ((contentValues2 != null && contentValues2.containsKey(str)) || ((contentValues = this.f16992a) != null && contentValues.containsKey(str))) {
                return true;
            }
            return false;
        }

        public final void k() {
            if (this.f16993b == null) {
                this.f16993b = new ContentValues();
                ArrayList<ValuesDelta> arrayList = this.f16995d;
                if (arrayList != null) {
                    Iterator<ValuesDelta> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().f16993b = this.f16993b;
                    }
                }
            }
            b bVar = this.f16996e;
            if (bVar != null) {
                bVar.a();
                return;
            }
            b A10 = EntityDelta.A();
            H7.b.b("EntityDelta", "editorMenu = " + A10);
            if (A10 != null) {
                A10.a();
            }
        }

        public void k0(String str) {
            k();
            this.f16993b.putNull(str);
        }

        public void l0(Parcel parcel) {
            ClassLoader classLoader = getClass().getClassLoader();
            this.f16992a = (ContentValues) parcel.readParcelable(classLoader);
            this.f16993b = (ContentValues) parcel.readParcelable(classLoader);
            this.f16994c = parcel.readString();
        }

        public void n0(String str) {
            k();
            if (this.f16993b.containsKey(str)) {
                this.f16993b.remove(str);
            }
        }

        public ContentValues p() {
            return this.f16993b;
        }

        public void p0(String str) {
            ContentValues contentValues = this.f16992a;
            if (contentValues != null && contentValues.containsKey(str)) {
                this.f16992a.remove(str);
            }
        }

        public Boolean q(String str, Boolean bool) {
            ContentValues contentValues = this.f16993b;
            if (contentValues != null && contentValues.containsKey(str)) {
                return this.f16993b.getAsBoolean(str);
            }
            ContentValues contentValues2 = this.f16992a;
            if (contentValues2 != null && contentValues2.containsKey(str)) {
                return this.f16992a.getAsBoolean(str);
            }
            return bool;
        }

        public void q0(b bVar) {
            this.f16996e = bVar;
        }

        public void r0(boolean z10) {
            this.f16997f = z10;
        }

        public void s0(String str) {
            this.f16994c = str;
        }

        public byte[] t(String str) {
            ContentValues contentValues = this.f16993b;
            if (contentValues != null && contentValues.containsKey(str)) {
                return this.f16993b.getAsByteArray(str);
            }
            ContentValues contentValues2 = this.f16992a;
            if (contentValues2 != null && contentValues2.containsKey(str)) {
                return this.f16992a.getAsByteArray(str);
            }
            return null;
        }

        public final boolean t0(ValuesDelta valuesDelta) {
            for (String str : W()) {
                String z10 = z(str);
                String z11 = valuesDelta.z(str);
                if (z10 == null) {
                    if (z11 != null) {
                        return false;
                    }
                } else if (!z10.equals(z11)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            u0(sb);
            return sb.toString();
        }

        public final void u0(StringBuilder sb) {
            sb.append("{ ");
            for (String str : W()) {
                sb.append(str);
                sb.append("=");
                sb.append(z(str));
                sb.append(", ");
            }
            sb.append("}");
        }

        public Integer v(String str) {
            return w(str, null);
        }

        public Integer w(String str, Integer num) {
            ContentValues contentValues = this.f16993b;
            if (contentValues != null && contentValues.containsKey(str)) {
                return this.f16993b.getAsInteger(str);
            }
            ContentValues contentValues2 = this.f16992a;
            if (contentValues2 != null && contentValues2.containsKey(str)) {
                return this.f16992a.getAsInteger(str);
            }
            return num;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f16992a, i10);
            parcel.writeParcelable(this.f16993b, i10);
            parcel.writeString(this.f16994c);
        }

        public Long x(String str) {
            ContentValues contentValues = this.f16993b;
            if (contentValues != null && contentValues.containsKey(str)) {
                return this.f16993b.getAsLong(str);
            }
            ContentValues contentValues2 = this.f16992a;
            if (contentValues2 != null && contentValues2.containsKey(str)) {
                return this.f16992a.getAsLong(str);
            }
            return null;
        }

        public String z(String str) {
            ContentValues contentValues = this.f16993b;
            if (contentValues != null && contentValues.containsKey(str)) {
                return this.f16993b.getAsString(str);
            }
            ContentValues contentValues2 = this.f16992a;
            if (contentValues2 != null && contentValues2.containsKey(str)) {
                return this.f16992a.getAsString(str);
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<EntityDelta> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EntityDelta createFromParcel(Parcel parcel) {
            EntityDelta entityDelta = new EntityDelta();
            entityDelta.l0(parcel);
            return entityDelta;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EntityDelta[] newArray(int i10) {
            return new EntityDelta[i10];
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public EntityDelta() {
    }

    public static b A() {
        return f16972x;
    }

    public static EntityDelta q(Entity entity) {
        EntityDelta entityDelta = new EntityDelta();
        ValuesDelta n10 = ValuesDelta.n(entity.getEntityValues());
        entityDelta.f16974b = n10;
        n10.s0(BreenoCallContract.BaseColumns._ID);
        long E10 = entityDelta.f16974b.E();
        if (E10 == null) {
            E10 = -1L;
        }
        boolean b10 = AbstractC1362a.h(ContactsApplication.h()).c(entityDelta.f16974b.z("account_type"), null).b();
        String z10 = entityDelta.f16974b.z("account_name");
        Iterator<Entity.NamedContentValues> it = entity.getSubValues().iterator();
        while (it.hasNext()) {
            Entity.NamedContentValues next = it.next();
            next.values.put("raw_contact_id", E10);
            next.values.put("account_writable", Boolean.valueOf(b10));
            next.values.put("account_name", z10);
            entityDelta.d(ValuesDelta.n(next.values));
        }
        return entityDelta;
    }

    public static void t0(b bVar) {
        f16972x = bVar;
    }

    public void A0(ValuesDelta valuesDelta) {
        this.f16974b = valuesDelta;
        valuesDelta.q0(this.f16990r);
    }

    public InputFieldUploadStatus C() {
        return this.f16989q;
    }

    public ArrayList<ValuesDelta> D(String str) {
        return E(str, false);
    }

    public final ArrayList<ValuesDelta> E(String str, boolean z10) {
        ArrayList<ValuesDelta> arrayList = this.f16984l.get(str);
        if (arrayList == null && z10) {
            ArrayList<ValuesDelta> f10 = n.f();
            this.f16984l.put(str, f10);
            return f10;
        }
        return arrayList;
    }

    public int F(String str, boolean z10) {
        ArrayList<ValuesDelta> D10 = D(str);
        int i10 = 0;
        if (D10 == null) {
            return 0;
        }
        Iterator<ValuesDelta> it = D10.iterator();
        while (it.hasNext()) {
            ValuesDelta next = it.next();
            if (!z10 || next.R()) {
                i10++;
            }
        }
        return i10;
    }

    public ValuesDelta H(String str) {
        ArrayList<ValuesDelta> E10 = E(str, false);
        if (E10 == null) {
            return null;
        }
        Iterator<ValuesDelta> it = E10.iterator();
        while (it.hasNext()) {
            ValuesDelta next = it.next();
            if (next.N()) {
                return next;
            }
        }
        if (E10.size() <= 0) {
            return null;
        }
        return E10.get(0);
    }

    public Long J(String str) {
        return this.f16982j.get(str);
    }

    public long K() {
        return this.f16973a;
    }

    public final ArrayList<long[]> M(ArrayList<Long> arrayList) {
        ArrayList<long[]> arrayList2 = new ArrayList<>();
        int i10 = 0;
        while (i10 < arrayList.size() - 1) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < arrayList.size(); i12++) {
                arrayList2.add(new long[]{arrayList.get(i10).longValue(), arrayList.get(i12).longValue()});
            }
            i10 = i11;
        }
        return arrayList2;
    }

    public ValuesDelta N() {
        return this.f16974b;
    }

    public ArrayList<Long> P() {
        return this.f16981i;
    }

    public boolean Q(String str) {
        return this.f16984l.containsKey(str);
    }

    public boolean R() {
        if (this.f16977e.size() > 1) {
            return true;
        }
        return false;
    }

    public boolean W() {
        return this.f16974b.H();
    }

    public boolean Y() {
        return this.f16974b.K();
    }

    public void b(String str, ArrayList<ValuesDelta> arrayList) {
        if (this.f16990r != null) {
            Iterator<ValuesDelta> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().q0(this.f16990r);
            }
        }
        E(str, true).addAll(arrayList);
        b bVar = this.f16990r;
        if (bVar != null) {
            bVar.a();
            return;
        }
        b A10 = A();
        if (A10 != null) {
            A10.a();
        }
    }

    public boolean b0() {
        return this.f16988p;
    }

    public ValuesDelta d(ValuesDelta valuesDelta) {
        String F10;
        b bVar = this.f16990r;
        if (bVar != null) {
            valuesDelta.q0(bVar);
        }
        String F11 = valuesDelta.F();
        if ("#anniversary".equals(valuesDelta.F())) {
            F10 = "vnd.android.cursor.item/contact_event";
        } else {
            F10 = valuesDelta.F();
        }
        if (valuesDelta.p() != null) {
            valuesDelta.p().put("mimetype", F10);
        }
        E(F11, true).add(valuesDelta);
        b bVar2 = this.f16990r;
        if (bVar2 != null) {
            bVar2.a();
        } else {
            b A10 = A();
            if (A10 != null) {
                A10.a();
            }
        }
        return valuesDelta;
    }

    public boolean d0() {
        return this.f16987o;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e0() {
        return this.f16986n;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EntityDelta)) {
            return false;
        }
        EntityDelta entityDelta = (EntityDelta) obj;
        if (!entityDelta.f16974b.equals(this.f16974b)) {
            return false;
        }
        Iterator<ArrayList<ValuesDelta>> it = this.f16984l.values().iterator();
        while (it.hasNext()) {
            Iterator<ValuesDelta> it2 = it.next().iterator();
            while (it2.hasNext()) {
                if (!entityDelta.p(it2.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void f(int i10, int i11, Long l10, Account account) {
        if (l10 == null) {
            return;
        }
        if (-1 == i10) {
            this.f16979g.add(l10);
            this.f16977e.add(account);
        } else {
            this.f16979g.add(i10, l10);
            this.f16977e.add(i10, account);
        }
        if (-1 == i11) {
            this.f16980h.add(l10);
            this.f16978f.add(account);
        } else {
            this.f16980h.add(i10, l10);
            this.f16978f.add(i10, account);
        }
        this.f16982j.put(account.f16941a, l10);
    }

    public void h(String str, ArrayList<ValuesDelta> arrayList) {
        ArrayList<ValuesDelta> arrayList2 = this.f16985m.get(str);
        if (arrayList2 == null) {
            arrayList2 = n.f();
            this.f16985m.put(str, arrayList2);
        }
        arrayList2.addAll(arrayList);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void i(Long l10) {
        if (l10 != null) {
            this.f16981i.add(l10);
        }
    }

    public void i0() {
        this.f16974b.Y();
        Iterator<ArrayList<ValuesDelta>> it = this.f16984l.values().iterator();
        while (it.hasNext()) {
            Iterator<ValuesDelta> it2 = it.next().iterator();
            while (it2.hasNext()) {
                it2.next().Y();
            }
        }
    }

    public final ContentProviderOperation.Builder j() {
        ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(ContactsContract.AggregationExceptions.CONTENT_URI);
        newUpdate.withValue(OplusAutoRedialNotificationUI.TYPE, 1);
        return newUpdate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0596 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x042a  */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v27, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.android.contacts.model.EntityDelta] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.ArrayList<android.content.ContentProviderOperation> k(java.util.ArrayList<android.content.ContentProviderOperation> r34, java.util.ArrayList<java.lang.Long> r35) {
        /*
            Method dump skipped, instructions count: 2108
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.model.EntityDelta.k(java.util.ArrayList, java.util.ArrayList):java.util.ArrayList");
    }

    public final void k0(ArrayList<ContentProviderOperation> arrayList, ContentProviderOperation.Builder builder) {
        if (builder != null) {
            arrayList.add(builder.build());
        }
    }

    public void l0(Parcel parcel) {
        ClassLoader classLoader = getClass().getClassLoader();
        int readInt = parcel.readInt();
        this.f16974b = (ValuesDelta) parcel.readParcelable(classLoader);
        this.f16983k = (Uri) parcel.readParcelable(classLoader);
        for (int i10 = 0; i10 < readInt; i10++) {
            d((ValuesDelta) parcel.readParcelable(classLoader));
        }
    }

    public final ContentProviderOperation.Builder m(Long l10, int i10) {
        ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(this.f16983k);
        newUpdate.withValue("aggregation_mode", Integer.valueOf(i10));
        newUpdate.withSelection("_id=" + l10, null);
        return newUpdate;
    }

    public void n() {
        this.f16977e.clear();
        this.f16978f.clear();
        this.f16979g.clear();
        this.f16980h.clear();
        this.f16981i.clear();
        this.f16982j.clear();
    }

    public final void n0(ArrayList<ValuesDelta> arrayList) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ValuesDelta valuesDelta = arrayList.get(size);
                if (!valuesDelta.j("data1")) {
                    arrayList.remove(valuesDelta);
                }
            }
        }
    }

    public final boolean p(ValuesDelta valuesDelta) {
        Iterator<ArrayList<ValuesDelta>> it = this.f16984l.values().iterator();
        while (it.hasNext()) {
            Iterator<ValuesDelta> it2 = it.next().iterator();
            while (it2.hasNext()) {
                if (it2.next().equals(valuesDelta)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void p0() {
        for (Map.Entry<String, ArrayList<ValuesDelta>> entry : this.f16985m.entrySet()) {
            D(entry.getKey()).removeAll(entry.getValue());
        }
    }

    public Account q0(int i10, int i11) {
        this.f16979g.remove(i10);
        this.f16977e.remove(i10);
        this.f16980h.remove(i11);
        return this.f16978f.remove(i11);
    }

    public void r0() {
        this.f16973a = -1L;
    }

    public void s0(b bVar) {
        this.f16990r = bVar;
        this.f16974b.q0(bVar);
        Iterator<ArrayList<ValuesDelta>> it = this.f16984l.values().iterator();
        while (it.hasNext()) {
            Iterator<ValuesDelta> it2 = it.next().iterator();
            while (it2.hasNext()) {
                it2.next().q0(bVar);
            }
        }
    }

    public ArrayList<Account> t(boolean z10) {
        if (z10) {
            return this.f16978f;
        }
        return this.f16977e;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("\n(");
        ValuesDelta valuesDelta = this.f16974b;
        if (valuesDelta != null) {
            str = valuesDelta.toString();
        } else {
            str = "null";
        }
        sb.append(str);
        sb.append(") = {");
        Iterator<ArrayList<ValuesDelta>> it = this.f16984l.values().iterator();
        while (it.hasNext()) {
            Iterator<ValuesDelta> it2 = it.next().iterator();
            while (it2.hasNext()) {
                ValuesDelta next = it2.next();
                sb.append("\n\t");
                next.u0(sb);
            }
        }
        sb.append("\n}\n");
        return sb.toString();
    }

    public void u0(boolean z10) {
        this.f16988p = z10;
    }

    public ArrayList<Long> v(boolean z10) {
        if (z10) {
            return this.f16980h;
        }
        return this.f16979g;
    }

    public void v0(InputFieldUploadStatus inputFieldUploadStatus) {
        this.f16989q = inputFieldUploadStatus;
    }

    public String w(String str, String str2) {
        ArrayList<ValuesDelta> D10 = D(str);
        if (D10 != null) {
            Iterator<ValuesDelta> it = D10.iterator();
            while (it.hasNext()) {
                ValuesDelta next = it.next();
                if (next != null) {
                    String z10 = next.z(str2);
                    if (!TextUtils.isEmpty(z10)) {
                        return z10;
                    }
                }
            }
            return null;
        }
        return null;
    }

    public void w0(boolean z10) {
        this.f16987o = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(z(false));
        parcel.writeParcelable(this.f16974b, i10);
        parcel.writeParcelable(this.f16983k, i10);
        Iterator it = new CopyOnWriteArrayList(this.f16984l.values()).iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                parcel.writeParcelable((ValuesDelta) it2.next(), i10);
            }
        }
    }

    public HashMap<String, ArrayList<ValuesDelta>> x() {
        return this.f16984l;
    }

    public void x0(boolean z10) {
        this.f16986n = z10;
    }

    public void y0() {
        this.f16983k = ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI;
    }

    public final int z(boolean z10) {
        Iterator<String> it = this.f16984l.keySet().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += F(it.next(), z10);
        }
        return i10;
    }

    public void z0(Long l10) {
        if (l10 != null && l10.longValue() >= 1) {
            this.f16973a = l10.longValue();
        } else {
            this.f16973a = -1L;
        }
    }

    public EntityDelta(ValuesDelta valuesDelta) {
        this.f16974b = valuesDelta;
        valuesDelta.q0(null);
    }
}
