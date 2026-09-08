package k0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
import p.C1415a;

/* compiled from: VersionedParcelParcel.java */
/* loaded from: classes.dex */
public class b extends AbstractC1206a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f34061d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f34062e;

    /* renamed from: f, reason: collision with root package name */
    public final int f34063f;

    /* renamed from: g, reason: collision with root package name */
    public final int f34064g;

    /* renamed from: h, reason: collision with root package name */
    public final String f34065h;

    /* renamed from: i, reason: collision with root package name */
    public int f34066i;

    /* renamed from: j, reason: collision with root package name */
    public int f34067j;

    /* renamed from: k, reason: collision with root package name */
    public int f34068k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C1415a(), new C1415a(), new C1415a());
    }

    @Override // k0.AbstractC1206a
    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f34062e.writeInt(bArr.length);
            this.f34062e.writeByteArray(bArr);
        } else {
            this.f34062e.writeInt(-1);
        }
    }

    @Override // k0.AbstractC1206a
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f34062e, 0);
    }

    @Override // k0.AbstractC1206a
    public void E(int i10) {
        this.f34062e.writeInt(i10);
    }

    @Override // k0.AbstractC1206a
    public void G(Parcelable parcelable) {
        this.f34062e.writeParcelable(parcelable, 0);
    }

    @Override // k0.AbstractC1206a
    public void I(String str) {
        this.f34062e.writeString(str);
    }

    @Override // k0.AbstractC1206a
    public void a() {
        int i10 = this.f34066i;
        if (i10 >= 0) {
            int i11 = this.f34061d.get(i10);
            int dataPosition = this.f34062e.dataPosition();
            this.f34062e.setDataPosition(i11);
            this.f34062e.writeInt(dataPosition - i11);
            this.f34062e.setDataPosition(dataPosition);
        }
    }

    @Override // k0.AbstractC1206a
    public AbstractC1206a b() {
        Parcel parcel = this.f34062e;
        int dataPosition = parcel.dataPosition();
        int i10 = this.f34067j;
        if (i10 == this.f34063f) {
            i10 = this.f34064g;
        }
        return new b(parcel, dataPosition, i10, this.f34065h + "  ", this.f34058a, this.f34059b, this.f34060c);
    }

    @Override // k0.AbstractC1206a
    public boolean g() {
        if (this.f34062e.readInt() != 0) {
            return true;
        }
        return false;
    }

    @Override // k0.AbstractC1206a
    public byte[] i() {
        int readInt = this.f34062e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f34062e.readByteArray(bArr);
        return bArr;
    }

    @Override // k0.AbstractC1206a
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f34062e);
    }

    @Override // k0.AbstractC1206a
    public boolean m(int i10) {
        while (this.f34067j < this.f34064g) {
            int i11 = this.f34068k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f34062e.setDataPosition(this.f34067j);
            int readInt = this.f34062e.readInt();
            this.f34068k = this.f34062e.readInt();
            this.f34067j += readInt;
        }
        if (this.f34068k != i10) {
            return false;
        }
        return true;
    }

    @Override // k0.AbstractC1206a
    public int o() {
        return this.f34062e.readInt();
    }

    @Override // k0.AbstractC1206a
    public <T extends Parcelable> T q() {
        return (T) this.f34062e.readParcelable(getClass().getClassLoader());
    }

    @Override // k0.AbstractC1206a
    public String s() {
        return this.f34062e.readString();
    }

    @Override // k0.AbstractC1206a
    public void w(int i10) {
        a();
        this.f34066i = i10;
        this.f34061d.put(i10, this.f34062e.dataPosition());
        E(0);
        E(i10);
    }

    @Override // k0.AbstractC1206a
    public void y(boolean z10) {
        this.f34062e.writeInt(z10 ? 1 : 0);
    }

    public b(Parcel parcel, int i10, int i11, String str, C1415a<String, Method> c1415a, C1415a<String, Method> c1415a2, C1415a<String, Class> c1415a3) {
        super(c1415a, c1415a2, c1415a3);
        this.f34061d = new SparseIntArray();
        this.f34066i = -1;
        this.f34068k = -1;
        this.f34062e = parcel;
        this.f34063f = i10;
        this.f34064g = i11;
        this.f34067j = i10;
        this.f34065h = str;
    }
}
