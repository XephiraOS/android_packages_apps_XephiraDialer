package com.customize.contacts.manager;

import android.database.Cursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import com.customize.contacts.model.IdRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ContactsNumberSelectManager.java */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final DataSetObservable f21540a = new DataSetObservable();

    /* renamed from: b, reason: collision with root package name */
    public int f21541b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f21542c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f21543d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f21544e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f21545f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f21546g = -1;

    /* renamed from: h, reason: collision with root package name */
    public Cursor f21547h = null;

    /* renamed from: i, reason: collision with root package name */
    public HashMap<String, IdRecord> f21548i;

    public g() {
        this.f21548i = null;
        this.f21548i = new HashMap<>();
    }

    public final IdRecord a(Cursor cursor) {
        return new IdRecord(cursor.getLong(this.f21544e), cursor.getString(this.f21546g), cursor.getString(this.f21545f), true);
    }

    public boolean b(long j10, String str, String str2) {
        String str3 = str2 + j10;
        if (this.f21548i.containsKey(str3) && this.f21548i.get(str3).b() == j10) {
            return true;
        }
        return false;
    }

    public int c() {
        return this.f21543d;
    }

    public ArrayList<IdRecord> d() {
        ArrayList<IdRecord> arrayList = new ArrayList<>();
        arrayList.addAll(this.f21548i.values());
        return arrayList;
    }

    public int e() {
        Cursor cursor = this.f21547h;
        if (cursor != null && !cursor.isClosed()) {
            int count = this.f21547h.getCount();
            int i10 = this.f21542c;
            if (count > i10) {
                int count2 = this.f21547h.getCount();
                this.f21542c = count2;
                return count2;
            }
            return i10;
        }
        return this.f21542c;
    }

    public void f(Cursor cursor) {
        if (cursor != null && cursor.getCount() != 0) {
            if (this.f21548i == null) {
                this.f21548i = new HashMap<>();
            }
            this.f21548i.clear();
            this.f21541b = 0;
            this.f21542c = cursor.getCount();
            this.f21547h = cursor;
            try {
                int columnIndex = cursor.getColumnIndex("contact_id");
                this.f21544e = columnIndex;
                if (columnIndex == -1) {
                    if (H7.a.b()) {
                        H7.b.b("NumberSelectManager", "The cursor should contain a column named '_id'!");
                        return;
                    }
                    return;
                }
                int columnIndex2 = cursor.getColumnIndex("data1");
                this.f21545f = columnIndex2;
                if (columnIndex2 == -1) {
                    if (H7.a.b()) {
                        H7.b.b("NumberSelectManager", "The cursor should contain a column named 'account_type'!");
                        return;
                    }
                    return;
                } else {
                    int columnIndex3 = cursor.getColumnIndex("display_name");
                    this.f21546g = columnIndex3;
                    if (columnIndex3 == -1 && H7.a.b()) {
                        H7.b.b("NumberSelectManager", "The cursor should contain a column named 'account_type'!");
                        return;
                    }
                    return;
                }
            } catch (Exception e10) {
                H7.b.c("NumberSelectManager", "Exception e: " + e10);
                return;
            }
        }
        i();
    }

    public void g(Cursor cursor) {
        this.f21547h = cursor;
    }

    public void h(Cursor cursor, boolean z10) {
        if (cursor != null && cursor.getCount() != 0) {
            this.f21547h = cursor;
            try {
                int columnIndex = cursor.getColumnIndex("contact_id");
                this.f21544e = columnIndex;
                if (columnIndex == -1) {
                    if (H7.a.b()) {
                        H7.b.b("NumberSelectManager", "The cursor should contain a column named '_id'!");
                        return;
                    }
                    return;
                }
                int columnIndex2 = cursor.getColumnIndex("data1");
                this.f21545f = columnIndex2;
                if (columnIndex2 == -1) {
                    if (H7.a.b()) {
                        H7.b.b("NumberSelectManager", "The cursor should contain a column named 'account_type'!");
                        return;
                    }
                    return;
                }
                int columnIndex3 = cursor.getColumnIndex("display_name");
                this.f21546g = columnIndex3;
                if (columnIndex3 == -1) {
                    if (H7.a.b()) {
                        H7.b.b("NumberSelectManager", "The cursor should contain a column named 'account_type'!");
                        return;
                    }
                    return;
                }
                int i10 = 0;
                if (z10) {
                    cursor.moveToPosition(-1);
                    while (cursor.moveToNext()) {
                        if (this.f21548i.containsKey(cursor.getString(this.f21545f) + cursor.getLong(this.f21544e)) && (i10 = i10 + 1) >= this.f21548i.size()) {
                            break;
                        }
                    }
                } else {
                    this.f21548i.clear();
                }
                this.f21541b = i10;
                i();
                if (H7.a.b()) {
                    H7.b.b("NumberSelectManager", "intiCurrentContactsChecked(), cursor count = " + cursor.getCount());
                    H7.b.b("NumberSelectManager", "intiCurrentContactsChecked(), mCurrentListMarkCount = " + this.f21541b);
                    return;
                }
                return;
            } catch (Exception e10) {
                H7.b.c("NumberSelectManager", "Exception e: " + e10);
                return;
            }
        }
        i();
    }

    public void i() {
        this.f21540a.notifyChanged();
    }

    public void j(DataSetObserver dataSetObserver) {
        this.f21540a.registerObserver(dataSetObserver);
    }

    public void k(long j10, String str, String str2, boolean z10) {
        l(j10, str, str2, z10, true);
    }

    public void l(long j10, String str, String str2, boolean z10, boolean z11) {
        IdRecord idRecord;
        if (z10) {
            if (B3.a.d0() && !z11) {
                idRecord = new IdRecord(j10, str, str2, z10, true);
            } else {
                idRecord = new IdRecord(j10, str, str2, z10);
            }
            this.f21548i.put(str2 + j10, idRecord);
            return;
        }
        this.f21548i.remove(str2 + j10);
    }

    public void m(long j10, String str, String str2, boolean z10) {
        if (z10) {
            if (!this.f21548i.containsKey(str2 + j10)) {
                IdRecord idRecord = new IdRecord(j10, str, str2, z10);
                this.f21548i.put(str2 + j10, idRecord);
                this.f21543d = this.f21543d + 1;
                this.f21541b = this.f21541b + 1;
            }
        } else {
            if (this.f21548i.containsKey(str2 + j10)) {
                this.f21548i.remove(str2 + j10);
                this.f21543d = this.f21543d + (-1);
                this.f21541b = this.f21541b + (-1);
            }
        }
        int e10 = e();
        int i10 = this.f21543d;
        if (i10 > e10) {
            this.f21543d = e10;
        } else if (i10 < 0) {
            this.f21543d = 0;
        }
        int count = this.f21547h.getCount();
        int i11 = this.f21541b;
        if (i11 > count) {
            this.f21541b = count;
        } else if (i11 < 0) {
            this.f21541b = 0;
        }
        int i12 = this.f21541b;
        if (i12 > this.f21542c) {
            this.f21542c = i12;
        }
        i();
    }

    public void n(Cursor cursor, boolean z10) {
        if (z10) {
            h(cursor, z10);
        } else {
            this.f21547h = cursor;
            if (cursor == null) {
                i();
                return;
            }
            this.f21542c = cursor.getCount();
            HashMap hashMap = new HashMap();
            if (this.f21548i.size() > 0) {
                cursor.moveToPosition(-1);
                if (B3.a.d0() && this.f21542c == 1) {
                    this.f21544e = cursor.getColumnIndex("contact_id");
                    this.f21545f = cursor.getColumnIndex("data1");
                    this.f21546g = cursor.getColumnIndex("display_name");
                }
                while (cursor.moveToNext()) {
                    long j10 = cursor.getLong(this.f21544e);
                    String str = cursor.getString(this.f21545f) + Long.valueOf(j10);
                    if (this.f21548i.containsKey(str) && this.f21548i.get(str).b() == j10) {
                        hashMap.put(str, a(cursor));
                    }
                }
                if (B3.a.d0()) {
                    for (Map.Entry<String, IdRecord> entry : this.f21548i.entrySet()) {
                        if (entry.getValue().j()) {
                            hashMap.put(entry.getKey(), entry.getValue());
                            entry.getValue().n(false);
                        }
                    }
                }
                this.f21548i.clear();
                this.f21548i.putAll(hashMap);
                hashMap.clear();
            }
            int size = this.f21548i.size();
            this.f21543d = size;
            this.f21541b = size;
        }
        i();
        if (H7.a.b()) {
            H7.b.b("NumberSelectManager", "intiCurrentContactsChecked(), cursor count = " + cursor.getCount() + "intiCurrentContactsChecked(), mCurrentListMarkCount = " + this.f21541b);
        }
    }

    public void o(boolean z10) {
        int i10;
        int i11;
        int i12 = this.f21543d;
        int i13 = -1;
        if (z10) {
            i10 = 1;
        } else {
            i10 = -1;
        }
        this.f21543d = i12 + i10;
        int e10 = e();
        int i14 = this.f21543d;
        if (i14 > e10) {
            this.f21543d = e10;
        } else if (i14 < 0) {
            this.f21543d = 0;
        }
        int i15 = this.f21541b;
        if (z10) {
            i13 = 1;
        }
        this.f21541b = i15 + i13;
        Cursor cursor = this.f21547h;
        if (cursor != null) {
            i11 = cursor.getCount();
        } else {
            i11 = 0;
        }
        int i16 = this.f21541b;
        if (i16 > i11) {
            this.f21541b = i11;
        } else if (i16 < 0) {
            this.f21541b = 0;
        }
        int i17 = this.f21541b;
        if (i17 > this.f21542c) {
            this.f21542c = i17;
        }
        i();
    }
}
