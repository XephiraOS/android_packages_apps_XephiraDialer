package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.B;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f9874a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f9875b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f9876c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f9877d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9878e;

    /* renamed from: f, reason: collision with root package name */
    public final String f9879f;

    /* renamed from: g, reason: collision with root package name */
    public final int f9880g;

    /* renamed from: h, reason: collision with root package name */
    public final int f9881h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f9882i;

    /* renamed from: j, reason: collision with root package name */
    public final int f9883j;

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence f9884k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList<String> f9885l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList<String> f9886m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f9887n;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<BackStackRecordState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState[] newArray(int i10) {
            return new BackStackRecordState[i10];
        }
    }

    public BackStackRecordState(C0470a c0470a) {
        int size = c0470a.f9848c.size();
        this.f9874a = new int[size * 6];
        if (c0470a.f9854i) {
            this.f9875b = new ArrayList<>(size);
            this.f9876c = new int[size];
            this.f9877d = new int[size];
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                B.a aVar = c0470a.f9848c.get(i11);
                int i12 = i10 + 1;
                this.f9874a[i10] = aVar.f9865a;
                ArrayList<String> arrayList = this.f9875b;
                Fragment fragment = aVar.f9866b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f9874a;
                iArr[i12] = aVar.f9867c ? 1 : 0;
                iArr[i10 + 2] = aVar.f9868d;
                iArr[i10 + 3] = aVar.f9869e;
                int i13 = i10 + 5;
                iArr[i10 + 4] = aVar.f9870f;
                i10 += 6;
                iArr[i13] = aVar.f9871g;
                this.f9876c[i11] = aVar.f9872h.ordinal();
                this.f9877d[i11] = aVar.f9873i.ordinal();
            }
            this.f9878e = c0470a.f9853h;
            this.f9879f = c0470a.f9856k;
            this.f9880g = c0470a.f10106v;
            this.f9881h = c0470a.f9857l;
            this.f9882i = c0470a.f9858m;
            this.f9883j = c0470a.f9859n;
            this.f9884k = c0470a.f9860o;
            this.f9885l = c0470a.f9861p;
            this.f9886m = c0470a.f9862q;
            this.f9887n = c0470a.f9863r;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public final void b(C0470a c0470a) {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 < this.f9874a.length) {
                B.a aVar = new B.a();
                int i12 = i10 + 1;
                aVar.f9865a = this.f9874a[i10];
                if (FragmentManager.M0(2)) {
                    Log.v("FragmentManager", "Instantiate " + c0470a + " op #" + i11 + " base fragment #" + this.f9874a[i12]);
                }
                aVar.f9872h = Lifecycle.State.values()[this.f9876c[i11]];
                aVar.f9873i = Lifecycle.State.values()[this.f9877d[i11]];
                int[] iArr = this.f9874a;
                int i13 = i10 + 2;
                if (iArr[i12] == 0) {
                    z10 = false;
                }
                aVar.f9867c = z10;
                int i14 = iArr[i13];
                aVar.f9868d = i14;
                int i15 = iArr[i10 + 3];
                aVar.f9869e = i15;
                int i16 = i10 + 5;
                int i17 = iArr[i10 + 4];
                aVar.f9870f = i17;
                i10 += 6;
                int i18 = iArr[i16];
                aVar.f9871g = i18;
                c0470a.f9849d = i14;
                c0470a.f9850e = i15;
                c0470a.f9851f = i17;
                c0470a.f9852g = i18;
                c0470a.f(aVar);
                i11++;
            } else {
                c0470a.f9853h = this.f9878e;
                c0470a.f9856k = this.f9879f;
                c0470a.f9854i = true;
                c0470a.f9857l = this.f9881h;
                c0470a.f9858m = this.f9882i;
                c0470a.f9859n = this.f9883j;
                c0470a.f9860o = this.f9884k;
                c0470a.f9861p = this.f9885l;
                c0470a.f9862q = this.f9886m;
                c0470a.f9863r = this.f9887n;
                return;
            }
        }
    }

    public C0470a d(FragmentManager fragmentManager) {
        C0470a c0470a = new C0470a(fragmentManager);
        b(c0470a);
        c0470a.f10106v = this.f9880g;
        for (int i10 = 0; i10 < this.f9875b.size(); i10++) {
            String str = this.f9875b.get(i10);
            if (str != null) {
                c0470a.f9848c.get(i10).f9866b = fragmentManager.j0(str);
            }
        }
        c0470a.z(1);
        return c0470a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f9874a);
        parcel.writeStringList(this.f9875b);
        parcel.writeIntArray(this.f9876c);
        parcel.writeIntArray(this.f9877d);
        parcel.writeInt(this.f9878e);
        parcel.writeString(this.f9879f);
        parcel.writeInt(this.f9880g);
        parcel.writeInt(this.f9881h);
        TextUtils.writeToParcel(this.f9882i, parcel, 0);
        parcel.writeInt(this.f9883j);
        TextUtils.writeToParcel(this.f9884k, parcel, 0);
        parcel.writeStringList(this.f9885l);
        parcel.writeStringList(this.f9886m);
        parcel.writeInt(this.f9887n ? 1 : 0);
    }

    public BackStackRecordState(Parcel parcel) {
        this.f9874a = parcel.createIntArray();
        this.f9875b = parcel.createStringArrayList();
        this.f9876c = parcel.createIntArray();
        this.f9877d = parcel.createIntArray();
        this.f9878e = parcel.readInt();
        this.f9879f = parcel.readString();
        this.f9880g = parcel.readInt();
        this.f9881h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f9882i = (CharSequence) creator.createFromParcel(parcel);
        this.f9883j = parcel.readInt();
        this.f9884k = (CharSequence) creator.createFromParcel(parcel);
        this.f9885l = parcel.createStringArrayList();
        this.f9886m = parcel.createStringArrayList();
        this.f9887n = parcel.readInt() != 0;
    }
}
