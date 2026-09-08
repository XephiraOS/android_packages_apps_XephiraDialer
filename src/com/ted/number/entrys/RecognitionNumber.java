package com.ted.number.entrys;

import D2.g;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes4.dex */
public class RecognitionNumber implements Parcelable {
    public static final Parcelable.Creator<RecognitionNumber> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f29643a;

    /* renamed from: b, reason: collision with root package name */
    public String f29644b;

    /* renamed from: c, reason: collision with root package name */
    public String f29645c;

    /* renamed from: d, reason: collision with root package name */
    public CallerIdItem$MarkerData f29646d;

    /* renamed from: e, reason: collision with root package name */
    public List<ContactItem$RelevantNumber> f29647e;

    /* renamed from: f, reason: collision with root package name */
    public List<ContactItem$ContactMenu> f29648f;

    /* renamed from: g, reason: collision with root package name */
    public List<MessageItem$MessageMenu> f29649g;

    /* renamed from: h, reason: collision with root package name */
    public List<ContactItem$DealItem> f29650h;

    /* renamed from: i, reason: collision with root package name */
    public String f29651i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f29652j;

    /* renamed from: k, reason: collision with root package name */
    public String f29653k;

    /* renamed from: l, reason: collision with root package name */
    public String f29654l;

    /* renamed from: m, reason: collision with root package name */
    public String f29655m;

    /* renamed from: n, reason: collision with root package name */
    public String f29656n;

    /* renamed from: o, reason: collision with root package name */
    public Bundle f29657o;

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

    public RecognitionNumber(Parcel parcel) {
        j(parcel);
    }

    public static <E> boolean h(List<E> list, List<E> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list != null && list2 != null && list.size() == list2.size()) {
            return true;
        }
        return false;
    }

    public static boolean i(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public Bundle b() {
        return this.f29657o;
    }

    public String c0() {
        return this.f29644b;
    }

    public CallerIdItem$MarkerData d() {
        return this.f29646d;
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
        if (i(this.f29643a, recognitionNumber.f29643a) && i(this.f29644b, recognitionNumber.f29644b) && i(this.f29645c, recognitionNumber.f29645c) && i(this.f29646d, recognitionNumber.f29646d) && h(this.f29647e, recognitionNumber.f29647e) && h(this.f29648f, recognitionNumber.f29648f) && h(this.f29649g, recognitionNumber.f29649g) && h(this.f29650h, recognitionNumber.f29650h)) {
            return true;
        }
        return false;
    }

    public boolean f() {
        Bundle bundle = this.f29657o;
        if (bundle == null || bundle.getInt("additional_mark_type") != 7) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.f29643a;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final void j(Parcel parcel) {
        this.f29643a = parcel.readString();
        this.f29644b = parcel.readString();
        this.f29645c = parcel.readString();
        boolean z10 = false;
        this.f29646d = ((CallerIdItem$MarkerData[]) parcel.createTypedArray(CallerIdItem$MarkerData.CREATOR))[0];
        this.f29647e = parcel.createTypedArrayList(ContactItem$RelevantNumber.CREATOR);
        this.f29648f = parcel.createTypedArrayList(ContactItem$ContactMenu.CREATOR);
        this.f29649g = parcel.createTypedArrayList(MessageItem$MessageMenu.CREATOR);
        this.f29650h = parcel.createTypedArrayList(ContactItem$DealItem.CREATOR);
        this.f29651i = parcel.readString();
        this.f29653k = parcel.readString();
        this.f29654l = parcel.readString();
        if (parcel.readInt() != 0) {
            z10 = true;
        }
        this.f29652j = z10;
        this.f29655m = parcel.readString();
        this.f29656n = parcel.readString();
        this.f29657o = parcel.readBundle();
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("RecognitionNumber{, mLogo='");
        sb.append(this.f29644b);
        sb.append('\'');
        sb.append(", mAddress='");
        sb.append(g.l(this.f29645c));
        sb.append('\'');
        sb.append(", mMarkerData=");
        sb.append(this.f29646d);
        sb.append(", mOtherTels=");
        sb.append(this.f29647e);
        sb.append(", mContactMenus=");
        sb.append(this.f29648f);
        sb.append(", mMessageMenus=");
        sb.append(this.f29649g);
        sb.append(", mDealItems=");
        sb.append(this.f29650h);
        sb.append(", mNumber='");
        sb.append(g.l(this.f29651i));
        sb.append('\'');
        sb.append(", mIsHuPush=");
        sb.append(this.f29652j);
        sb.append(", mShopId='");
        sb.append(this.f29653k);
        sb.append('\'');
        sb.append(", mRealNumber='");
        sb.append(g.l(this.f29654l));
        sb.append('\'');
        sb.append(", mSource='");
        sb.append(this.f29655m);
        sb.append('\'');
        sb.append(", mDesc='");
        sb.append(this.f29656n);
        sb.append('\'');
        sb.append(", mExtraData='");
        Bundle bundle = this.f29657o;
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
        parcel.writeString(this.f29643a);
        parcel.writeString(this.f29644b);
        parcel.writeString(this.f29645c);
        parcel.writeTypedArray(new CallerIdItem$MarkerData[]{this.f29646d}, 0);
        parcel.writeTypedList(this.f29647e);
        parcel.writeTypedList(this.f29648f);
        parcel.writeTypedList(this.f29649g);
        parcel.writeTypedList(this.f29650h);
        parcel.writeString(this.f29651i);
        parcel.writeString(this.f29653k);
        parcel.writeString(this.f29654l);
        parcel.writeByte(this.f29652j ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f29655m);
        parcel.writeString(this.f29656n);
        parcel.writeBundle(this.f29657o);
    }
}
