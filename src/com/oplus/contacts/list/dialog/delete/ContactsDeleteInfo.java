package com.oplus.contacts.list.dialog.delete;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.i;

/* compiled from: ContactsDeleteInfo.kt */
/* loaded from: classes3.dex */
public final class ContactsDeleteInfo implements Parcelable {
    public static final Parcelable.Creator<ContactsDeleteInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f27904a;

    /* renamed from: b, reason: collision with root package name */
    public final int f27905b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f27906c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f27907d;

    /* compiled from: ContactsDeleteInfo.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Parcelable.Creator<ContactsDeleteInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ContactsDeleteInfo createFromParcel(Parcel parcel) {
            boolean z10;
            i.f(parcel, "parcel");
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            boolean z11 = false;
            if (parcel.readInt() != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (parcel.readInt() != 0) {
                z11 = true;
            }
            return new ContactsDeleteInfo(readInt, readInt2, z10, z11);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ContactsDeleteInfo[] newArray(int i10) {
            return new ContactsDeleteInfo[i10];
        }
    }

    public ContactsDeleteInfo(int i10, int i11, boolean z10, boolean z11) {
        this.f27904a = i10;
        this.f27905b = i11;
        this.f27906c = z10;
        this.f27907d = z11;
    }

    public final int b() {
        return this.f27904a;
    }

    public final boolean d() {
        return this.f27907d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactsDeleteInfo)) {
            return false;
        }
        ContactsDeleteInfo contactsDeleteInfo = (ContactsDeleteInfo) obj;
        if (this.f27904a == contactsDeleteInfo.f27904a && this.f27905b == contactsDeleteInfo.f27905b && this.f27906c == contactsDeleteInfo.f27906c && this.f27907d == contactsDeleteInfo.f27907d) {
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f27905b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.f27904a) * 31) + Integer.hashCode(this.f27905b)) * 31;
        boolean z10 = this.f27906c;
        int i10 = 1;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        int i12 = (hashCode + i11) * 31;
        boolean z11 = this.f27907d;
        if (!z11) {
            i10 = z11 ? 1 : 0;
        }
        return i12 + i10;
    }

    public String toString() {
        return "ContactsDeleteInfo(markedCount=" + this.f27904a + ", totalCount=" + this.f27905b + ", hasOtherAccountItem=" + this.f27906c + ", showSyncTips=" + this.f27907d + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i10) {
        i.f(out, "out");
        out.writeInt(this.f27904a);
        out.writeInt(this.f27905b);
        out.writeInt(this.f27906c ? 1 : 0);
        out.writeInt(this.f27907d ? 1 : 0);
    }
}
