package com.android.contacts.list;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.contacts.compat.data.PreferenceWrapper;
import com.android.contacts.compat.data.WashManager;
import org.opencv.core.Core;

/* loaded from: classes.dex */
public final class ContactListFilter implements Comparable<ContactListFilter>, Parcelable {
    public static final Parcelable.Creator<ContactListFilter> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f16737a = false;

    /* renamed from: b, reason: collision with root package name */
    public final int f16738b;

    /* renamed from: c, reason: collision with root package name */
    public final String f16739c;

    /* renamed from: d, reason: collision with root package name */
    public final String f16740d;

    /* renamed from: e, reason: collision with root package name */
    public final String f16741e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f16742f;

    /* renamed from: g, reason: collision with root package name */
    public String f16743g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16744h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16745i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16746j;

    /* renamed from: k, reason: collision with root package name */
    public String f16747k;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<ContactListFilter> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ContactListFilter createFromParcel(Parcel parcel) {
            boolean z10;
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            return new ContactListFilter(readInt, readString2, readString, readString3, null, z10, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ContactListFilter[] newArray(int i10) {
            return new ContactListFilter[i10];
        }
    }

    public ContactListFilter(int i10, String str, String str2, String str3, Drawable drawable, String str4) {
        this.f16738b = i10;
        this.f16739c = str;
        this.f16740d = str2;
        this.f16741e = str3;
        this.f16742f = drawable;
        this.f16743g = str4;
    }

    public static ContactListFilter f(String str, String str2, String str3, Drawable drawable, boolean z10, String str4) {
        return new ContactListFilter(0, str, str2, str3, drawable, z10, str4);
    }

    public static ContactListFilter h(int i10) {
        String str;
        if (i10 == -2) {
            str = "ALL";
        } else if (i10 == -3) {
            str = "CUSTOM";
        } else {
            str = null;
        }
        String str2 = str;
        return new ContactListFilter(i10, str2, str2, null, null, null);
    }

    public static ContactListFilter i(int i10, boolean z10) {
        String str;
        if (i10 == -2) {
            str = "ALL";
        } else if (i10 == -3) {
            str = "CUSTOM";
        } else {
            str = null;
        }
        String str2 = str;
        return new ContactListFilter(i10, str2, str2, null, null, z10, null);
    }

    public static ContactListFilter n(SharedPreferences sharedPreferences) {
        ContactListFilter p10 = p(sharedPreferences);
        if (p10 == null) {
            p10 = h(-2);
            p10.f16744h = new PreferenceWrapper(sharedPreferences).a("filter.onlyPhone", false);
        }
        int i10 = p10.f16738b;
        if (i10 == 1 || i10 == -6) {
            return h(-2);
        }
        return p10;
    }

    public static ContactListFilter p(SharedPreferences sharedPreferences) {
        PreferenceWrapper preferenceWrapper = new PreferenceWrapper(sharedPreferences);
        int b10 = preferenceWrapper.b("filter.type", -1);
        if (b10 == -1) {
            return null;
        }
        String d10 = preferenceWrapper.d("filter.accountType", null);
        if (!TextUtils.isEmpty(d10)) {
            d10 = WashManager.g(d10);
        }
        String str = d10;
        String d11 = preferenceWrapper.d("filter.accountName", null);
        if (!TextUtils.isEmpty(d11)) {
            d11 = WashManager.g(d11);
        }
        return new ContactListFilter(b10, str, d11, preferenceWrapper.d("filter.dataSet", null), null, preferenceWrapper.a("filter.onlyPhone", false), sharedPreferences.getString("filter.displayLabel", null));
    }

    public static void t(SharedPreferences sharedPreferences, ContactListFilter contactListFilter) {
        int i10;
        String str;
        String str2;
        String str3;
        boolean z10;
        if (contactListFilter != null && contactListFilter.f16738b == -6) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (contactListFilter == null) {
            i10 = -1;
        } else {
            i10 = contactListFilter.f16738b;
        }
        SharedPreferences.Editor putInt = edit.putInt("filter.type", i10);
        String str4 = null;
        if (contactListFilter == null) {
            str = null;
        } else {
            str = contactListFilter.f16740d;
        }
        SharedPreferences.Editor putString = putInt.putString("filter.accountName", str);
        if (contactListFilter == null) {
            str2 = null;
        } else {
            str2 = contactListFilter.f16739c;
        }
        SharedPreferences.Editor putString2 = putString.putString("filter.accountType", str2);
        if (contactListFilter == null) {
            str3 = null;
        } else {
            str3 = contactListFilter.f16741e;
        }
        SharedPreferences.Editor putString3 = putString2.putString("filter.dataSet", str3);
        if (contactListFilter == null) {
            z10 = false;
        } else {
            z10 = contactListFilter.f16744h;
        }
        SharedPreferences.Editor putBoolean = putString3.putBoolean("filter.onlyPhone", z10);
        if (contactListFilter != null) {
            str4 = contactListFilter.f16743g;
        }
        putBoolean.putString("filter.displayLabel", str4).apply();
    }

    public Uri.Builder b(Uri.Builder builder) {
        if (this.f16738b == 0) {
            String str = this.f16740d;
            if (str != null && this.f16739c != null) {
                builder.appendQueryParameter("account_name", str);
                builder.appendQueryParameter("account_type", this.f16739c);
            }
            if (!TextUtils.isEmpty(this.f16741e)) {
                builder.appendQueryParameter("data_set", this.f16741e);
            }
            return builder;
        }
        throw new IllegalStateException("filterType must be FILTER_TYPE_ACCOUNT");
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(ContactListFilter contactListFilter) {
        int compareTo = this.f16740d.compareTo(contactListFilter.f16740d);
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = this.f16739c.compareTo(contactListFilter.f16739c);
        if (compareTo2 != 0) {
            return compareTo2;
        }
        return this.f16738b - contactListFilter.f16738b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ContactListFilter)) {
            return false;
        }
        ContactListFilter contactListFilter = (ContactListFilter) obj;
        if (this.f16738b == contactListFilter.f16738b && TextUtils.equals(this.f16740d, contactListFilter.f16740d) && TextUtils.equals(this.f16739c, contactListFilter.f16739c) && TextUtils.equals(this.f16741e, contactListFilter.f16741e) && (!this.f16744h) != contactListFilter.f16744h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10 = this.f16738b;
        String str = this.f16739c;
        if (str != null) {
            i10 = (((i10 * 31) + str.hashCode()) * 31) + this.f16740d.hashCode();
        }
        String str2 = this.f16741e;
        if (str2 != null) {
            return (i10 * 31) + str2.hashCode();
        }
        return i10;
    }

    public String j() {
        if (this.f16747k == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f16738b);
            if (this.f16739c != null) {
                sb.append('-');
                sb.append(this.f16739c);
            }
            if (this.f16741e != null) {
                sb.append('/');
                sb.append(this.f16741e);
            }
            if (this.f16740d != null) {
                sb.append('-');
                sb.append(this.f16740d.replace('-', '_'));
            }
            this.f16747k = sb.toString();
        }
        return this.f16747k;
    }

    public boolean k() {
        return this.f16737a;
    }

    public boolean m() {
        if (this.f16738b != 0 || !TextUtils.equals(R0.a.f3165a, this.f16740d) || !TextUtils.equals(R0.a.f3166b, this.f16739c)) {
            return false;
        }
        return true;
    }

    public void q(boolean z10) {
        this.f16737a = z10;
    }

    public String toString() {
        String str;
        switch (this.f16738b) {
            case Core.StsBadFunc /* -6 */:
                return "single";
            case Core.StsBadArg /* -5 */:
                return "with_phones";
            case Core.StsNoMem /* -4 */:
                return "starred";
            case -3:
                return "custom";
            case -2:
                return "all_accounts";
            case -1:
                return "default";
            case 0:
                StringBuilder sb = new StringBuilder();
                sb.append("account: ");
                sb.append(this.f16739c);
                if (this.f16741e != null) {
                    str = "/" + this.f16741e;
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append(" ");
                sb.append(this.f16740d);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f16738b);
        parcel.writeString(this.f16740d);
        parcel.writeString(this.f16739c);
        parcel.writeString(this.f16741e);
        parcel.writeInt(this.f16744h ? 1 : 0);
        parcel.writeString(this.f16743g);
    }

    public ContactListFilter(int i10, String str, String str2, String str3, Drawable drawable, boolean z10, String str4) {
        this.f16738b = i10;
        this.f16739c = str;
        this.f16740d = str2;
        this.f16741e = str3;
        this.f16742f = drawable;
        this.f16744h = z10;
        this.f16743g = str4;
    }
}
