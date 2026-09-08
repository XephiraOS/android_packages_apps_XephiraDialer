package U2;

import android.os.Parcel;
import android.os.Parcelable;
import com.appaac.haptic.sync.b;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator<b> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b createFromParcel(Parcel parcel) {
        return new b(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b[] newArray(int i10) {
        return new b[i10];
    }
}
