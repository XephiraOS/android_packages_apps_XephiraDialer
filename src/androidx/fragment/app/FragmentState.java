package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f10048a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10049b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10050c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10051d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10052e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10053f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10054g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f10055h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f10056i;

    /* renamed from: j, reason: collision with root package name */
    public final Bundle f10057j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f10058k;

    /* renamed from: l, reason: collision with root package name */
    public final int f10059l;

    /* renamed from: m, reason: collision with root package name */
    public Bundle f10060m;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<FragmentState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i10) {
            return new FragmentState[i10];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f10048a = fragment.getClass().getName();
        this.f10049b = fragment.mWho;
        this.f10050c = fragment.mFromLayout;
        this.f10051d = fragment.mFragmentId;
        this.f10052e = fragment.mContainerId;
        this.f10053f = fragment.mTag;
        this.f10054g = fragment.mRetainInstance;
        this.f10055h = fragment.mRemoving;
        this.f10056i = fragment.mDetached;
        this.f10057j = fragment.mArguments;
        this.f10058k = fragment.mHidden;
        this.f10059l = fragment.mMaxState.ordinal();
    }

    public Fragment b(k kVar, ClassLoader classLoader) {
        Fragment a10 = kVar.a(classLoader, this.f10048a);
        Bundle bundle = this.f10057j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a10.setArguments(this.f10057j);
        a10.mWho = this.f10049b;
        a10.mFromLayout = this.f10050c;
        a10.mRestored = true;
        a10.mFragmentId = this.f10051d;
        a10.mContainerId = this.f10052e;
        a10.mTag = this.f10053f;
        a10.mRetainInstance = this.f10054g;
        a10.mRemoving = this.f10055h;
        a10.mDetached = this.f10056i;
        a10.mHidden = this.f10058k;
        a10.mMaxState = Lifecycle.State.values()[this.f10059l];
        Bundle bundle2 = this.f10060m;
        if (bundle2 != null) {
            a10.mSavedFragmentState = bundle2;
        } else {
            a10.mSavedFragmentState = new Bundle();
        }
        return a10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f10048a);
        sb.append(" (");
        sb.append(this.f10049b);
        sb.append(")}:");
        if (this.f10050c) {
            sb.append(" fromLayout");
        }
        if (this.f10052e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f10052e));
        }
        String str = this.f10053f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f10053f);
        }
        if (this.f10054g) {
            sb.append(" retainInstance");
        }
        if (this.f10055h) {
            sb.append(" removing");
        }
        if (this.f10056i) {
            sb.append(" detached");
        }
        if (this.f10058k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f10048a);
        parcel.writeString(this.f10049b);
        parcel.writeInt(this.f10050c ? 1 : 0);
        parcel.writeInt(this.f10051d);
        parcel.writeInt(this.f10052e);
        parcel.writeString(this.f10053f);
        parcel.writeInt(this.f10054g ? 1 : 0);
        parcel.writeInt(this.f10055h ? 1 : 0);
        parcel.writeInt(this.f10056i ? 1 : 0);
        parcel.writeBundle(this.f10057j);
        parcel.writeInt(this.f10058k ? 1 : 0);
        parcel.writeBundle(this.f10060m);
        parcel.writeInt(this.f10059l);
    }

    public FragmentState(Parcel parcel) {
        this.f10048a = parcel.readString();
        this.f10049b = parcel.readString();
        this.f10050c = parcel.readInt() != 0;
        this.f10051d = parcel.readInt();
        this.f10052e = parcel.readInt();
        this.f10053f = parcel.readString();
        this.f10054g = parcel.readInt() != 0;
        this.f10055h = parcel.readInt() != 0;
        this.f10056i = parcel.readInt() != 0;
        this.f10057j = parcel.readBundle();
        this.f10058k = parcel.readInt() != 0;
        this.f10060m = parcel.readBundle();
        this.f10059l = parcel.readInt();
    }
}
