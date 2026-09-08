package com.customize.contacts.model;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.net.Uri;
import com.android.contacts.model.EntityDelta;
import com.customize.contacts.util.C0811w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class GroupValueDelta extends EntityDelta.ValuesDelta {

    /* renamed from: k, reason: collision with root package name */
    public static int f21709k = 2147483547;

    /* renamed from: h, reason: collision with root package name */
    public final int f21710h;

    /* renamed from: i, reason: collision with root package name */
    public ContentValues f21711i;

    /* renamed from: j, reason: collision with root package name */
    public a f21712j;

    /* loaded from: classes3.dex */
    public interface a {
        void a(GroupValueDelta groupValueDelta);
    }

    public GroupValueDelta() {
        int i10 = f21709k;
        f21709k = i10 - 1;
        this.f21710h = i10;
        this.f21711i = null;
        this.f21712j = null;
    }

    public static GroupValueDelta w0(ContentValues contentValues) {
        GroupValueDelta groupValueDelta = new GroupValueDelta();
        groupValueDelta.f16992a = null;
        groupValueDelta.f21711i = new ContentValues();
        groupValueDelta.f16993b = contentValues;
        String str = groupValueDelta.f16994c;
        int i10 = EntityDelta.ValuesDelta.f16991g;
        EntityDelta.ValuesDelta.f16991g = i10 - 1;
        contentValues.put(str, Integer.valueOf(i10));
        return groupValueDelta;
    }

    public void A0(String str) {
        this.f21711i.put("account_type", str);
    }

    public void B0(Long l10) {
        C0("contact_id", l10);
    }

    public void C0(String str, Long l10) {
        if (this.f16993b == null) {
            this.f16993b = new ContentValues();
        }
        this.f16993b.put(str, l10);
    }

    public void D0(a aVar) {
        this.f21712j = aVar;
    }

    @Override // com.android.contacts.model.EntityDelta.ValuesDelta
    public void Y() {
        if (this.f21712j != null) {
            if (H7.a.b()) {
                H7.b.b("GroupValueDelta", "-----------------------markDeleted()");
            }
            this.f21712j.a(this);
        }
        super.Y();
    }

    @Override // com.android.contacts.model.EntityDelta.ValuesDelta
    public void d0(String str, long j10) {
        this.f21711i.put("customize_key_display_name", str);
        this.f21711i.put("customize_key_photo_id", Long.valueOf(j10));
    }

    @Override // com.android.contacts.model.EntityDelta.ValuesDelta
    public boolean equals(Object obj) {
        if (!(obj instanceof GroupValueDelta) || this.f21710h != ((GroupValueDelta) obj).f21710h) {
            return false;
        }
        return true;
    }

    @Override // com.android.contacts.model.EntityDelta.ValuesDelta
    public boolean h() {
        if (this.f16992a != null) {
            return true;
        }
        return false;
    }

    @Override // com.android.contacts.model.EntityDelta.ValuesDelta
    public int hashCode() {
        return super.hashCode();
    }

    public List<ContentProviderOperation.Builder> v0(Uri uri, ArrayList<Long> arrayList) {
        Long x02 = x0();
        ArrayList arrayList2 = null;
        if (x02 == null) {
            if (H7.a.b()) {
                H7.b.b("GroupValueDelta", "customizeBuildDiff(), contactId = " + x02);
            }
            return null;
        }
        if (C0811w.g(arrayList)) {
            if (H7.a.b()) {
                H7.b.b("GroupValueDelta", "customizeBuildDiff(), rawContacts is empty,contactId = " + x02);
            }
            return null;
        }
        if (K()) {
            this.f16993b.remove(this.f16994c);
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                if (next != null) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(arrayList.size());
                    }
                    ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(uri));
                    newInsert.withValue("data1", y0());
                    newInsert.withValue("mimetype", "vnd.android.cursor.item/group_membership");
                    newInsert.withValue("raw_contact_id", next);
                    arrayList2.add(newInsert);
                    if (H7.a.b()) {
                        H7.b.b("GroupValueDelta", "customizeBuildDiff(), insert, rawContactId = " + next + " lstBuilder size = " + arrayList2.size());
                    }
                }
            }
            if (H7.a.b()) {
                H7.b.b("GroupValueDelta", "customizeBuildDiff(), insert, mAfter = " + this.f16993b);
            }
            return arrayList2;
        }
        if (H()) {
            Iterator<Long> it2 = arrayList.iterator();
            ArrayList arrayList3 = null;
            while (it2.hasNext()) {
                Long next2 = it2.next();
                if (next2 != null) {
                    ContentProviderOperation.Builder newDelete = ContentProviderOperation.newDelete(uri);
                    Long y02 = y0();
                    y02.longValue();
                    String format = String.format(Locale.US, "mimetype='vnd.android.cursor.item/group_membership' AND raw_contact_id= %d  AND data1= %d", next2, y02);
                    if (H7.a.b()) {
                        H7.b.b("GroupValueDelta", "customizeBuildDiff(), delete, where = " + format);
                    }
                    newDelete.withSelection(format, null);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList(arrayList.size());
                    }
                    arrayList3.add(newDelete);
                }
            }
            arrayList.clear();
            return arrayList3;
        }
        H7.b.i("GroupValueDelta", "customizeBuildDiff(), this shouldn't happen");
        return null;
    }

    public Long x0() {
        return x("contact_id");
    }

    public Long y0() {
        return this.f21711i.getAsLong("data1");
    }

    public void z0(String str) {
        this.f21711i.put("account_name", str);
    }
}
