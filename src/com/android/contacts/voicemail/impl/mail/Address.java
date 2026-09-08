package com.android.contacts.voicemail.impl.mail;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class Address implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public String f18070a;

    /* renamed from: b, reason: collision with root package name */
    public String f18071b;

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f18065c = Pattern.compile("^<?([^>]+)>?$");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f18066d = Pattern.compile("^\"?([^\"]*)\"?$");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f18067e = Pattern.compile("\\\\([\\\\\"])");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f18068f = Pattern.compile("\\A[^@]+@([[\\w][\\d]\\-\\(\\)\\[\\]]+\\.)+[[\\w][\\d]\\-\\(\\)\\[\\]]+\\z");

    /* renamed from: g, reason: collision with root package name */
    public static final Address[] f18069g = new Address[0];
    public static final Parcelable.Creator<Address> CREATOR = new a();

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<Address> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Address createFromParcel(Parcel parcel) {
            return new Address(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Address[] newArray(int i10) {
            return new Address[i10];
        }
    }

    public Address(String str, String str2) {
        j(str2);
        i(str);
    }

    public static String b(String str) {
        if (str != null) {
            String c10 = K9.d.c(f18067e.matcher(f18066d.matcher(str).replaceAll("$1")).replaceAll("$1"), K9.c.f1689a);
            if (c10.length() == 0) {
                return null;
            }
            return c10;
        }
        return str;
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        if (!str.matches("^\".*\"$")) {
            return "\"" + str + "\"";
        }
        return str;
    }

    public static boolean f(String str) {
        return f18068f.matcher(str).find();
    }

    public static Address[] h(String str) {
        if (str != null && str.length() != 0) {
            Rfc822Token[] rfc822TokenArr = Rfc822Tokenizer.tokenize(str);
            ArrayList arrayList = new ArrayList();
            for (Rfc822Token rfc822Token : rfc822TokenArr) {
                String address = rfc822Token.getAddress();
                if (!TextUtils.isEmpty(address) && f(address)) {
                    String name = rfc822Token.getName();
                    if (TextUtils.isEmpty(name)) {
                        name = null;
                    }
                    arrayList.add(new Address(address, name));
                }
            }
            return (Address[]) arrayList.toArray(new Address[arrayList.size()]);
        }
        return f18069g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            return getAddress().equals(((Address) obj).getAddress());
        }
        return super.equals(obj);
    }

    public String getAddress() {
        return this.f18070a;
    }

    public int hashCode() {
        return getAddress().hashCode();
    }

    public void i(String str) {
        this.f18070a = f18065c.matcher(str).replaceAll("$1");
    }

    public void j(String str) {
        this.f18071b = b(str);
    }

    public String toString() {
        String str = this.f18071b;
        if (str != null && !str.equals(this.f18070a)) {
            if (this.f18071b.matches(".*[\\(\\)<>@,;:\\\\\".\\[\\]].*")) {
                return d(this.f18071b) + " <" + this.f18070a + ">";
            }
            return this.f18071b + " <" + this.f18070a + ">";
        }
        return this.f18070a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f18071b);
        parcel.writeString(this.f18070a);
    }

    public Address(Parcel parcel) {
        j(parcel.readString());
        i(parcel.readString());
    }
}
