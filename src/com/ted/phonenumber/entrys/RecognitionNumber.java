package com.ted.phonenumber.entrys;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.utils.C0846g;
import java.util.List;

/* loaded from: classes4.dex */
public class RecognitionNumber implements Parcelable {
    public static final Parcelable.Creator<RecognitionNumber> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f29873a;

    /* renamed from: b, reason: collision with root package name */
    public String f29874b;

    /* renamed from: c, reason: collision with root package name */
    public String f29875c;

    /* renamed from: d, reason: collision with root package name */
    public CallerIdItem$MarkerData f29876d;

    /* renamed from: e, reason: collision with root package name */
    public List<ContactItem$RelevantNumber> f29877e;

    /* renamed from: f, reason: collision with root package name */
    public List<ContactItem$ContactMenu> f29878f;

    /* renamed from: g, reason: collision with root package name */
    public List<MessageItem$MessageMenu> f29879g;

    /* renamed from: h, reason: collision with root package name */
    public List<ContactItem$DealItem> f29880h;

    /* renamed from: i, reason: collision with root package name */
    public String f29881i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f29882j;

    /* renamed from: k, reason: collision with root package name */
    public String f29883k;

    /* renamed from: l, reason: collision with root package name */
    public String f29884l;

    /* renamed from: m, reason: collision with root package name */
    public String f29885m;

    /* renamed from: n, reason: collision with root package name */
    public String f29886n;

    /* renamed from: o, reason: collision with root package name */
    public Bundle f29887o;

    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<RecognitionNumber> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecognitionNumber createFromParcel(Parcel parcel) {
            return new RecognitionNumber(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RecognitionNumber[] newArray(int i10) {
            return new RecognitionNumber[i10];
        }
    }

    public RecognitionNumber() {
    }

    public static <E> boolean f(List<E> list, List<E> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list != null && list2 != null && list.size() == list2.size()) {
            return true;
        }
        return false;
    }

    public static boolean h(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public boolean a() {
        Bundle bundle = this.f29887o;
        if (bundle == null || bundle.getInt("additional_mark_type") != 7) {
            return false;
        }
        return true;
    }

    public CallerIdItem$MarkerData b() {
        return this.f29876d;
    }

    public String c0() {
        return this.f29874b;
    }

    public String d() {
        return this.f29881i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecognitionNumber)) {
            return false;
        }
        RecognitionNumber recognitionNumber = (RecognitionNumber) obj;
        if (h(this.f29873a, recognitionNumber.f29873a) && h(this.f29874b, recognitionNumber.f29874b) && h(this.f29875c, recognitionNumber.f29875c) && h(this.f29876d, recognitionNumber.f29876d) && f(this.f29877e, recognitionNumber.f29877e) && f(this.f29878f, recognitionNumber.f29878f) && f(this.f29879g, recognitionNumber.f29879g) && f(this.f29880h, recognitionNumber.f29880h)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.f29873a;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final void i(Parcel parcel) {
        this.f29873a = parcel.readString();
        this.f29874b = parcel.readString();
        this.f29875c = parcel.readString();
        boolean z10 = false;
        this.f29876d = ((CallerIdItem$MarkerData[]) parcel.createTypedArray(CallerIdItem$MarkerData.CREATOR))[0];
        this.f29877e = parcel.createTypedArrayList(ContactItem$RelevantNumber.CREATOR);
        this.f29878f = parcel.createTypedArrayList(ContactItem$ContactMenu.CREATOR);
        this.f29879g = parcel.createTypedArrayList(MessageItem$MessageMenu.CREATOR);
        this.f29880h = parcel.createTypedArrayList(ContactItem$DealItem.CREATOR);
        this.f29881i = parcel.readString();
        this.f29883k = parcel.readString();
        this.f29884l = parcel.readString();
        if (parcel.readInt() != 0) {
            z10 = true;
        }
        this.f29882j = z10;
        this.f29885m = parcel.readString();
        this.f29886n = parcel.readString();
        this.f29887o = parcel.readBundle();
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("RecognitionNumber{, mLogo='");
        sb.append(this.f29874b);
        sb.append('\'');
        sb.append(", mAddress='");
        sb.append(this.f29875c);
        sb.append('\'');
        sb.append(", mMarkerData=");
        sb.append(this.f29876d);
        sb.append(", mOtherTels=");
        sb.append(this.f29877e);
        sb.append(", mContactMenus=");
        sb.append(this.f29878f);
        sb.append(", mMessageMenus=");
        sb.append(this.f29879g);
        sb.append(", mDealItems=");
        sb.append(this.f29880h);
        sb.append(", mNumber='");
        sb.append(C0846g.f(this.f29881i));
        sb.append('\'');
        sb.append(", mIsHuPush=");
        sb.append(this.f29882j);
        sb.append(", mShopId='");
        sb.append(this.f29883k);
        sb.append('\'');
        sb.append(", mRealNumber='");
        sb.append(C0846g.f(this.f29884l));
        sb.append('\'');
        sb.append(", mSource='");
        sb.append(this.f29885m);
        sb.append('\'');
        sb.append(", mDesc='");
        sb.append(this.f29886n);
        sb.append('\'');
        sb.append(", mExtraData='");
        Bundle bundle = this.f29887o;
        if (bundle == null) {
            obj = "null";
        } else {
            obj = bundle.get("additional_mark_type");
        }
        sb.append(obj);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f29873a);
        parcel.writeString(this.f29874b);
        parcel.writeString(this.f29875c);
        parcel.writeTypedArray(new CallerIdItem$MarkerData[]{this.f29876d}, 0);
        parcel.writeTypedList(this.f29877e);
        parcel.writeTypedList(this.f29878f);
        parcel.writeTypedList(this.f29879g);
        parcel.writeTypedList(this.f29880h);
        parcel.writeString(this.f29881i);
        parcel.writeString(this.f29883k);
        parcel.writeString(this.f29884l);
        parcel.writeByte(this.f29882j ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f29885m);
        parcel.writeString(this.f29886n);
        parcel.writeBundle(this.f29887o);
    }

    public RecognitionNumber(Parcel parcel) {
        i(parcel);
    }
}
