package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

/* loaded from: classes.dex */
public interface IMediaSession extends IInterface {
    boolean A0();

    void A1();

    PlaybackStateCompat C4();

    void E0(RatingCompat ratingCompat);

    void F5();

    void G2(String str, Bundle bundle);

    int G6();

    void H0(int i10, int i11, String str);

    void I0(Uri uri, Bundle bundle);

    void J6(long j10);

    void L2();

    boolean L3(KeyEvent keyEvent);

    void L5(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper);

    List<MediaSessionCompat.QueueItem> M5();

    void M6(boolean z10);

    ParcelableVolumeInfo Q6();

    void R2(Uri uri, Bundle bundle);

    int T4();

    void V5(int i10);

    void Y0(MediaDescriptionCompat mediaDescriptionCompat);

    void Z3(int i10, int i11, String str);

    void a5(int i10);

    boolean b1();

    void d1(MediaDescriptionCompat mediaDescriptionCompat);

    void d6();

    void e3(long j10);

    CharSequence f2();

    void f4(RatingCompat ratingCompat, Bundle bundle);

    void g7(int i10);

    Bundle getExtras();

    String getPackageName();

    String getTag();

    PendingIntent j1();

    void j4(MediaDescriptionCompat mediaDescriptionCompat, int i10);

    void l0(String str, Bundle bundle);

    MediaMetadataCompat m2();

    int n1();

    void n2(String str, Bundle bundle);

    void next();

    void o();

    boolean o5();

    void p1(String str, Bundle bundle);

    void p4(boolean z10);

    void previous();

    void q2(IMediaControllerCallback iMediaControllerCallback);

    void r0(IMediaControllerCallback iMediaControllerCallback);

    void stop();

    long w6();

    void x2(String str, Bundle bundle);

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMediaSession {

        /* loaded from: classes.dex */
        public static class Proxy implements IMediaSession {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f6992f;

            public Proxy(IBinder iBinder) {
                this.f6992f = iBinder;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean L3(KeyEvent keyEvent) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z10 = true;
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f6992f.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z10 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6992f;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void r0(IMediaControllerCallback iMediaControllerCallback) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (iMediaControllerCallback != null) {
                        iBinder = iMediaControllerCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f6992f.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, "android.support.v4.media.session.IMediaSession");
        }

        public static IMediaSession N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMediaSession)) {
                return (IMediaSession) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            RatingCompat ratingCompat;
            Bundle bundle;
            Uri uri;
            Uri uri2;
            Bundle bundle2 = null;
            MediaDescriptionCompat mediaDescriptionCompat = null;
            MediaDescriptionCompat mediaDescriptionCompat2 = null;
            MediaDescriptionCompat mediaDescriptionCompat3 = null;
            Bundle bundle3 = null;
            Bundle bundle4 = null;
            Bundle bundle5 = null;
            Bundle bundle6 = null;
            RatingCompat ratingCompat2 = null;
            Bundle bundle7 = null;
            Bundle bundle8 = null;
            Bundle bundle9 = null;
            KeyEvent keyEvent = null;
            MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper = null;
            if (i10 != 51) {
                if (i10 != 1598968902) {
                    boolean z10 = false;
                    switch (i10) {
                        case 1:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String readString = parcel.readString();
                            if (parcel.readInt() != 0) {
                                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            } else {
                                bundle = null;
                            }
                            if (parcel.readInt() != 0) {
                                resultReceiverWrapper = MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(parcel);
                            }
                            L5(readString, bundle, resultReceiverWrapper);
                            parcel2.writeNoException();
                            return true;
                        case 2:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if (parcel.readInt() != 0) {
                                keyEvent = (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel);
                            }
                            boolean L32 = L3(keyEvent);
                            parcel2.writeNoException();
                            parcel2.writeInt(L32 ? 1 : 0);
                            return true;
                        case 3:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            r0(IMediaControllerCallback.Stub.N7(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 4:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            q2(IMediaControllerCallback.Stub.N7(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 5:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            boolean b12 = b1();
                            parcel2.writeNoException();
                            parcel2.writeInt(b12 ? 1 : 0);
                            return true;
                        case 6:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String packageName = getPackageName();
                            parcel2.writeNoException();
                            parcel2.writeString(packageName);
                            return true;
                        case 7:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String tag = getTag();
                            parcel2.writeNoException();
                            parcel2.writeString(tag);
                            return true;
                        case 8:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            PendingIntent j12 = j1();
                            parcel2.writeNoException();
                            if (j12 != null) {
                                parcel2.writeInt(1);
                                j12.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 9:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            long w62 = w6();
                            parcel2.writeNoException();
                            parcel2.writeLong(w62);
                            return true;
                        case 10:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            ParcelableVolumeInfo Q62 = Q6();
                            parcel2.writeNoException();
                            if (Q62 != null) {
                                parcel2.writeInt(1);
                                Q62.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 11:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            Z3(parcel.readInt(), parcel.readInt(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 12:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            H0(parcel.readInt(), parcel.readInt(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 13:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            F5();
                            parcel2.writeNoException();
                            return true;
                        case 14:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String readString2 = parcel.readString();
                            if (parcel.readInt() != 0) {
                                bundle9 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            }
                            x2(readString2, bundle9);
                            parcel2.writeNoException();
                            return true;
                        case 15:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String readString3 = parcel.readString();
                            if (parcel.readInt() != 0) {
                                bundle8 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            }
                            G2(readString3, bundle8);
                            parcel2.writeNoException();
                            return true;
                        case 16:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if (parcel.readInt() != 0) {
                                uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                            } else {
                                uri = null;
                            }
                            if (parcel.readInt() != 0) {
                                bundle7 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            }
                            R2(uri, bundle7);
                            parcel2.writeNoException();
                            return true;
                        case 17:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            J6(parcel.readLong());
                            parcel2.writeNoException();
                            return true;
                        case 18:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            o();
                            parcel2.writeNoException();
                            return true;
                        case 19:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            stop();
                            parcel2.writeNoException();
                            return true;
                        case 20:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            next();
                            parcel2.writeNoException();
                            return true;
                        case 21:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            previous();
                            parcel2.writeNoException();
                            return true;
                        case 22:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            L2();
                            parcel2.writeNoException();
                            return true;
                        case 23:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            d6();
                            parcel2.writeNoException();
                            return true;
                        case 24:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            e3(parcel.readLong());
                            parcel2.writeNoException();
                            return true;
                        case 25:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if (parcel.readInt() != 0) {
                                ratingCompat2 = RatingCompat.CREATOR.createFromParcel(parcel);
                            }
                            E0(ratingCompat2);
                            parcel2.writeNoException();
                            return true;
                        case 26:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String readString4 = parcel.readString();
                            if (parcel.readInt() != 0) {
                                bundle6 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            }
                            l0(readString4, bundle6);
                            parcel2.writeNoException();
                            return true;
                        case 27:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            MediaMetadataCompat m22 = m2();
                            parcel2.writeNoException();
                            if (m22 != null) {
                                parcel2.writeInt(1);
                                m22.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 28:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            PlaybackStateCompat C42 = C4();
                            parcel2.writeNoException();
                            if (C42 != null) {
                                parcel2.writeInt(1);
                                C42.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 29:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            List<MediaSessionCompat.QueueItem> M52 = M5();
                            parcel2.writeNoException();
                            parcel2.writeTypedList(M52);
                            return true;
                        case 30:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            CharSequence f22 = f2();
                            parcel2.writeNoException();
                            if (f22 != null) {
                                parcel2.writeInt(1);
                                TextUtils.writeToParcel(f22, parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 31:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            Bundle extras = getExtras();
                            parcel2.writeNoException();
                            if (extras != null) {
                                parcel2.writeInt(1);
                                extras.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 32:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            int n12 = n1();
                            parcel2.writeNoException();
                            parcel2.writeInt(n12);
                            return true;
                        case 33:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            A1();
                            parcel2.writeNoException();
                            return true;
                        case 34:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String readString5 = parcel.readString();
                            if (parcel.readInt() != 0) {
                                bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            }
                            n2(readString5, bundle5);
                            parcel2.writeNoException();
                            return true;
                        case 35:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String readString6 = parcel.readString();
                            if (parcel.readInt() != 0) {
                                bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            }
                            p1(readString6, bundle4);
                            parcel2.writeNoException();
                            return true;
                        case 36:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if (parcel.readInt() != 0) {
                                uri2 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                            } else {
                                uri2 = null;
                            }
                            if (parcel.readInt() != 0) {
                                bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            }
                            I0(uri2, bundle3);
                            parcel2.writeNoException();
                            return true;
                        case 37:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            int G62 = G6();
                            parcel2.writeNoException();
                            parcel2.writeInt(G62);
                            return true;
                        case 38:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            boolean A02 = A0();
                            parcel2.writeNoException();
                            parcel2.writeInt(A02 ? 1 : 0);
                            return true;
                        case 39:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            V5(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 40:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if (parcel.readInt() != 0) {
                                z10 = true;
                            }
                            M6(z10);
                            parcel2.writeNoException();
                            return true;
                        case 41:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if (parcel.readInt() != 0) {
                                mediaDescriptionCompat3 = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                            }
                            d1(mediaDescriptionCompat3);
                            parcel2.writeNoException();
                            return true;
                        case 42:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if (parcel.readInt() != 0) {
                                mediaDescriptionCompat2 = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                            }
                            j4(mediaDescriptionCompat2, parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 43:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if (parcel.readInt() != 0) {
                                mediaDescriptionCompat = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                            }
                            Y0(mediaDescriptionCompat);
                            parcel2.writeNoException();
                            return true;
                        case 44:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            a5(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 45:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            boolean o52 = o5();
                            parcel2.writeNoException();
                            parcel2.writeInt(o52 ? 1 : 0);
                            return true;
                        case 46:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if (parcel.readInt() != 0) {
                                z10 = true;
                            }
                            p4(z10);
                            parcel2.writeNoException();
                            return true;
                        case 47:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            int T42 = T4();
                            parcel2.writeNoException();
                            parcel2.writeInt(T42);
                            return true;
                        case 48:
                            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                            g7(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        default:
                            return super.onTransact(i10, parcel, parcel2, i11);
                    }
                }
                parcel2.writeString("android.support.v4.media.session.IMediaSession");
                return true;
            }
            parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (parcel.readInt() != 0) {
                ratingCompat = RatingCompat.CREATOR.createFromParcel(parcel);
            } else {
                ratingCompat = null;
            }
            if (parcel.readInt() != 0) {
                bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
            }
            f4(ratingCompat, bundle2);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
