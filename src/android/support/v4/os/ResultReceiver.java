package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;

/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7048a = false;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f7049b = null;

    /* renamed from: c, reason: collision with root package name */
    public IResultReceiver f7050c;

    /* loaded from: classes.dex */
    public class MyResultReceiver extends IResultReceiver.Stub {
        public MyResultReceiver() {
        }

        @Override // android.support.v4.os.IResultReceiver
        public void Z(int i10, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f7049b;
            if (handler != null) {
                handler.post(new b(i10, bundle));
            } else {
                resultReceiver.b(i10, bundle);
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<ResultReceiver> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResultReceiver[] newArray(int i10) {
            return new ResultReceiver[i10];
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f7052a;

        /* renamed from: b, reason: collision with root package name */
        public final Bundle f7053b;

        public b(int i10, Bundle bundle) {
            this.f7052a = i10;
            this.f7053b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.b(this.f7052a, this.f7053b);
        }
    }

    public ResultReceiver(Parcel parcel) {
        this.f7050c = IResultReceiver.Stub.N7(parcel.readStrongBinder());
    }

    public void d(int i10, Bundle bundle) {
        if (this.f7048a) {
            Handler handler = this.f7049b;
            if (handler != null) {
                handler.post(new b(i10, bundle));
                return;
            } else {
                b(i10, bundle);
                return;
            }
        }
        IResultReceiver iResultReceiver = this.f7050c;
        if (iResultReceiver != null) {
            try {
                iResultReceiver.Z(i10, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        synchronized (this) {
            try {
                if (this.f7050c == null) {
                    this.f7050c = new MyResultReceiver();
                }
                parcel.writeStrongBinder(this.f7050c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(int i10, Bundle bundle) {
    }
}
