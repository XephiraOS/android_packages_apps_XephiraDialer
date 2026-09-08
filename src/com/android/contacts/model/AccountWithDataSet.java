package com.android.contacts.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.incallui.OplusPhoneUtils;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class AccountWithDataSet extends Account {

    /* renamed from: c, reason: collision with root package name */
    public final String f16970c;

    /* renamed from: d, reason: collision with root package name */
    public final n1.d f16971d;

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f16966e = Pattern.compile(Pattern.quote("\u0001"));

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f16967f = Pattern.compile(Pattern.quote("\u0002"));

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f16968g = {BreenoCallContract.BaseColumns._ID};

    /* renamed from: h, reason: collision with root package name */
    public static final Uri f16969h = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("limit", OplusPhoneUtils.DeviceState.LOCK_DEVICE).build();
    public static final Parcelable.Creator<AccountWithDataSet> CREATOR = new a();

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<AccountWithDataSet> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AccountWithDataSet createFromParcel(Parcel parcel) {
            return new AccountWithDataSet(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AccountWithDataSet[] newArray(int i10) {
            return new AccountWithDataSet[i10];
        }
    }

    public AccountWithDataSet(String str, String str2, String str3) {
        super(str, str2);
        this.f16970c = str3;
        this.f16971d = n1.d.a(str2, str3);
    }

    public static StringBuilder f(StringBuilder sb, AccountWithDataSet accountWithDataSet) {
        sb.append(accountWithDataSet.f16941a);
        sb.append("\u0001");
        sb.append(accountWithDataSet.f16942b);
        sb.append("\u0001");
        if (!TextUtils.isEmpty(accountWithDataSet.f16970c)) {
            sb.append(accountWithDataSet.f16970c);
        }
        return sb;
    }

    public static String k(List<AccountWithDataSet> list) {
        StringBuilder sb = new StringBuilder();
        for (AccountWithDataSet accountWithDataSet : list) {
            if (sb.length() > 0) {
                sb.append("\u0002");
            }
            f(sb, accountWithDataSet);
        }
        return sb.toString();
    }

    @Override // com.android.contacts.model.Account
    public boolean d() {
        if (this.f16941a == null && this.f16942b == null && this.f16970c == null) {
            return true;
        }
        return false;
    }

    @Override // com.android.contacts.model.Account, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.android.contacts.model.Account
    public boolean equals(Object obj) {
        if ((obj instanceof AccountWithDataSet) && super.equals(obj) && com.google.common.base.h.a(((AccountWithDataSet) obj).f16970c, this.f16970c)) {
            return true;
        }
        return false;
    }

    public n1.d h() {
        return this.f16971d;
    }

    @Override // com.android.contacts.model.Account
    public int hashCode() {
        int hashCode;
        int hashCode2 = super.hashCode() * 31;
        String str = this.f16970c;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public boolean i(Context context) {
        String[] strArr;
        String str;
        if (TextUtils.isEmpty(this.f16970c)) {
            strArr = new String[]{this.f16942b, this.f16941a};
            str = "account_type = ? AND account_name = ? AND data_set IS NULL";
        } else {
            strArr = new String[]{this.f16942b, this.f16941a, this.f16970c};
            str = "account_type = ? AND account_name = ? AND data_set = ?";
        }
        String str2 = str;
        Cursor cursor = null;
        try {
            try {
                Cursor query = context.getContentResolver().query(f16969h, f16968g, str2, strArr, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return false;
                }
                boolean moveToFirst = query.moveToFirst();
                query.close();
                return moveToFirst;
            } catch (Exception e10) {
                H7.b.c("AccountWithDataSet", "Exception e: " + e10);
                if (0 != 0) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public String j() {
        return f(new StringBuilder(), this).toString();
    }

    public String toString() {
        return "AccountWithDataSet {name=" + this.f16941a + ", type=" + this.f16942b + ", dataSet=" + this.f16970c + "}";
    }

    @Override // com.android.contacts.model.Account, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f16970c);
    }

    public AccountWithDataSet(Parcel parcel) {
        super(parcel);
        String readString = parcel.readString();
        this.f16970c = readString;
        this.f16971d = n1.d.a(this.f16942b, readString);
    }
}
