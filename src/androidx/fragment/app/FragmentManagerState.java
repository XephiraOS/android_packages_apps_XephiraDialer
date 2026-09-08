package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<String> f10032a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f10033b;

    /* renamed from: c, reason: collision with root package name */
    public BackStackRecordState[] f10034c;

    /* renamed from: d, reason: collision with root package name */
    public int f10035d;

    /* renamed from: e, reason: collision with root package name */
    public String f10036e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<String> f10037f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<BackStackState> f10038g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<FragmentManager.LaunchedFragmentInfo> f10039h;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<FragmentManagerState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i10) {
            return new FragmentManagerState[i10];
        }
    }

    public FragmentManagerState() {
        this.f10036e = null;
        this.f10037f = new ArrayList<>();
        this.f10038g = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeStringList(this.f10032a);
        parcel.writeStringList(this.f10033b);
        parcel.writeTypedArray(this.f10034c, i10);
        parcel.writeInt(this.f10035d);
        parcel.writeString(this.f10036e);
        parcel.writeStringList(this.f10037f);
        parcel.writeTypedList(this.f10038g);
        parcel.writeTypedList(this.f10039h);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f10036e = null;
        this.f10037f = new ArrayList<>();
        this.f10038g = new ArrayList<>();
        this.f10032a = parcel.createStringArrayList();
        this.f10033b = parcel.createStringArrayList();
        this.f10034c = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        this.f10035d = parcel.readInt();
        this.f10036e = parcel.readString();
        this.f10037f = parcel.createStringArrayList();
        this.f10038g = parcel.createTypedArrayList(BackStackState.CREATOR);
        this.f10039h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
