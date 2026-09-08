package org.opencv.engine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public interface OpenCVEngineInterface extends IInterface {

    /* loaded from: classes4.dex */
    public static class Default implements OpenCVEngineInterface {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // org.opencv.engine.OpenCVEngineInterface
        public int getEngineVersion() {
            return 0;
        }

        @Override // org.opencv.engine.OpenCVEngineInterface
        public String getLibPathByVersion(String str) {
            return null;
        }

        @Override // org.opencv.engine.OpenCVEngineInterface
        public String getLibraryList(String str) {
            return null;
        }

        @Override // org.opencv.engine.OpenCVEngineInterface
        public boolean installVersion(String str) {
            return false;
        }
    }

    int getEngineVersion();

    String getLibPathByVersion(String str);

    String getLibraryList(String str);

    boolean installVersion(String str);

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements OpenCVEngineInterface {
        private static final String DESCRIPTOR = "org.opencv.engine.OpenCVEngineInterface";
        static final int TRANSACTION_getEngineVersion = 1;
        static final int TRANSACTION_getLibPathByVersion = 2;
        static final int TRANSACTION_getLibraryList = 4;
        static final int TRANSACTION_installVersion = 3;

        /* loaded from: classes4.dex */
        public static class Proxy implements OpenCVEngineInterface {
            public static OpenCVEngineInterface sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // org.opencv.engine.OpenCVEngineInterface
            public int getEngineVersion() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getEngineVersion();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // org.opencv.engine.OpenCVEngineInterface
            public String getLibPathByVersion(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLibPathByVersion(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.opencv.engine.OpenCVEngineInterface
            public String getLibraryList(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getLibraryList(str);
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.opencv.engine.OpenCVEngineInterface
            public boolean installVersion(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z10 = false;
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().installVersion(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static OpenCVEngineInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof OpenCVEngineInterface)) {
                return (OpenCVEngineInterface) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static OpenCVEngineInterface getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(OpenCVEngineInterface openCVEngineInterface) {
            if (Proxy.sDefaultImpl == null && openCVEngineInterface != null) {
                Proxy.sDefaultImpl = openCVEngineInterface;
                return true;
            }
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 1598968902) {
                                return super.onTransact(i10, parcel, parcel2, i11);
                            }
                            parcel2.writeString(DESCRIPTOR);
                            return true;
                        }
                        parcel.enforceInterface(DESCRIPTOR);
                        String libraryList = getLibraryList(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(libraryList);
                        return true;
                    }
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean installVersion = installVersion(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(installVersion ? 1 : 0);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                String libPathByVersion = getLibPathByVersion(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(libPathByVersion);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            int engineVersion = getEngineVersion();
            parcel2.writeNoException();
            parcel2.writeInt(engineVersion);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
