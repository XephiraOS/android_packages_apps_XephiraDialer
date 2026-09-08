package com.juphoon.service.ffmpeg;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface FfmpegService extends IInterface {
    void a1(String str, String str2, String str3);

    void cancel();

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements FfmpegService {

        /* loaded from: classes3.dex */
        public static class Proxy implements FfmpegService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25572f;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25572f;
            }
        }

        public Stub() {
            attachInterface(this, "com.juphoon.service.ffmpeg.FfmpegService");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 1598968902) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    parcel2.writeString("com.juphoon.service.ffmpeg.FfmpegService");
                    return true;
                }
                parcel.enforceInterface("com.juphoon.service.ffmpeg.FfmpegService");
                cancel();
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface("com.juphoon.service.ffmpeg.FfmpegService");
            a1(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
