package com.juphoon.service.im;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes3.dex */
public interface IRcsImService extends IInterface {
    int A2(String str);

    String C2(String str);

    boolean C3();

    int D2(boolean z10, String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, int i12);

    boolean E5();

    int E6(String str);

    int F2(String str, String str2);

    int F6(String str, String str2);

    String G1(String str, String str2, String str3, String str4, String str5, String str6);

    String G3(String str, String str2, String str3);

    int G5(String str);

    String H2(String str, String str2, String str3);

    int H5(String str);

    int I3(String str, String str2);

    int I4();

    int I6(String str);

    int I7(boolean z10, String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, int i12, byte[] bArr);

    int J1(String str, String str2, String str3, String str4, String str5, int i10, int i11, int i12, String str6, String str7, long j10);

    int J5();

    String K1(String str, double d10, double d11, float f10, String str2, String str3);

    int K2(String str, String str2);

    String K3(String str, String str2, int i10, String str3, String str4, long j10);

    String K4(String str, String str2, String str3, String str4, String str5, int i10, String str6, boolean z10);

    String L7(String str, double d10, double d11, float f10, String str2, String str3);

    String N1(String str, double d10, double d11, float f10, String str2, String str3, boolean z10);

    String N2(String str, String str2, String str3);

    int N4(String str);

    int O0(String str, String str2, String str3, double d10, double d11, float f10, String str4, boolean z10);

    String O1(String str, String str2, String str3);

    String O3(String str, String str2, String str3);

    String O4(String str, String str2, String str3);

    int P2(String str);

    int P3(String str);

    int P4(String str);

    int R0(String str, String str2, String str3, String str4);

    String R3(String str, String str2, String str3, String str4, long j10);

    String R4(String str, String str2, String str3, String str4, String str5, String str6, int i10, byte[] bArr);

    int R5(String str, int i10);

    int S2(String str, String str2, String str3);

    int S4(String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, int i12, byte[] bArr);

    boolean T3();

    String T6(String str, String str2, double d10, double d11, float f10, String str3, String str4);

    String U0(String str, String str2, String str3);

    int U2(String str, String str2, String str3, String str4, String str5, String str6);

    String U5(String str, double d10, double d11, float f10, String str2, String str3);

    int U6(String str);

    int V1(String str);

    String W0(String str, String str2, String str3, String str4, int i10, byte[] bArr);

    String W3(String str, String str2, String str3, String str4, int i10, byte[] bArr);

    int X0();

    String X1(String str, String str2, String str3, String str4);

    String X3(String str, String str2, String str3);

    String Y4(String str, double d10, double d11, float f10, String str2, String str3);

    int Z0(String str, String str2);

    int Z5(String str, String str2);

    int a0(String str, String str2);

    String a4(String str, double d10, double d11, float f10, String str2, String str3, String str4, String str5);

    String b3(String str, String str2, String str3, String str4);

    String b5(String str, String str2, String str3);

    String c0(String str, String str2, String str3);

    int d5(String str, String str2, int i10, int i11);

    boolean d7();

    String e1(String str, String str2, String str3);

    String e4(String str, String str2, String str3);

    String f1(String str, String str2, String str3);

    int f7();

    String g0(String str, String str2, double d10, double d11, float f10, String str3, boolean z10);

    int g2(String str);

    int g3(String str, String str2);

    String g4(String str, String str2, double d10, double d11, float f10, String str3, String str4);

    String h0(String str, String str2, String str3, String str4);

    boolean h1(String str);

    int h3(String str, double d10, double d11, float f10, String str2, String str3);

    String h4(String str, String str2, String str3);

    String h6(String str, String str2, String str3);

    String h7(String str, String str2, String str3);

    boolean i3();

    String i6(String str, String str2, String str3);

    int j0(String str);

    int j2(String str, int i10);

    int j3(String str, String str2, String str3, String str4, String str5, int i10);

    String j6(String str, String str2, String str3);

    int k3();

    int k4(String str, String str2, String str3);

    String k5(String str, String str2, String str3);

    String k7(String str, String str2, String str3);

    String l1(String str, String str2, String str3);

    int l5(String str, String str2, String str3, String str4, String str5, int i10, int i11, int i12, String str6);

    int l6(String str, boolean z10);

    int m3(String str);

    String n6(String str, String str2, String str3, String str4, int i10, byte[] bArr, int i11);

    String o3(String str, String str2, String str3);

    int o4(String str, boolean z10);

    int p0(String str);

    int p7(String str, String str2);

    int q4(String str);

    String q6(String str, String str2, String str3);

    int q7(boolean z10, String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, int i12, byte[] bArr);

    String r1(String str, String str2, String str3, String str4);

    String r2(String str, String str2, String str3, String str4, long j10);

    String r3(String str, String str2, String str3);

    String r4(String str, String str2, String str3);

    String r7(String str, String str2, String str3, String str4, int i10);

    String s3(String str, double d10, double d11, float f10, String str2, String str3, String str4, long j10);

    int s6(String str, String str2);

    int t5(String str, int i10);

    String t7(String str, String str2, String str3, String str4, int i10, byte[] bArr);

    String u0(int i10);

    String u1(String str, String str2, String str3);

    String u2(int i10, int i11, String str, double d10, double d11, float f10, String str2, String str3);

    String v5(String str, String str2, String str3);

    String v7(int i10, String str, String str2);

    int w1(String str, String str2, String str3, String str4);

    String w3(String str, String str2, String str3);

    String y0(String str, String str2, double d10, double d11, float f10, String str3, String str4);

    boolean y1();

    int y2(String str, String str2, String str3, String str4);

    boolean y7();

    int z0(boolean z10, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, int i11, int i12, byte[] bArr);

    int z1(String str, String str2);

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IRcsImService {

        /* loaded from: classes3.dex */
        public static class Proxy implements IRcsImService {

            /* renamed from: f, reason: collision with root package name */
            public IBinder f25573f;

            public Proxy(IBinder iBinder) {
                this.f25573f = iBinder;
            }

            @Override // com.juphoon.service.im.IRcsImService
            public int I4() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.juphoon.service.im.IRcsImService");
                    this.f25573f.transact(80, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25573f;
            }

            @Override // com.juphoon.service.im.IRcsImService
            public int f7() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.juphoon.service.im.IRcsImService");
                    this.f25573f.transact(89, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.juphoon.service.im.IRcsImService");
        }

        public static IRcsImService N7(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.juphoon.service.im.IRcsImService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRcsImService)) {
                return (IRcsImService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15;
            boolean z16;
            boolean z17;
            if (i10 != 1598968902) {
                boolean z18 = false;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        boolean i32 = i3();
                        parcel2.writeNoException();
                        parcel2.writeInt(i32 ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String u12 = u1(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(u12);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String O32 = O3(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(O32);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String N22 = N2(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(N22);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String r22 = r2(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeString(r22);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String l12 = l1(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(l12);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String r42 = r4(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(r42);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String h72 = h7(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(h72);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String e42 = e4(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(e42);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String j62 = j6(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(j62);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String o32 = o3(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(o32);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String H22 = H2(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(H22);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String h62 = h6(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(h62);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String k52 = k5(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(k52);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String R32 = R3(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeString(R32);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String U02 = U0(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(U02);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String e12 = e1(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(e12);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String f12 = f1(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(f12);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String i62 = i6(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(i62);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String c02 = c0(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(c02);
                        return true;
                    case 21:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String b52 = b5(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(b52);
                        return true;
                    case 22:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String t72 = t7(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeString(t72);
                        return true;
                    case 23:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String R42 = R4(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeString(R42);
                        return true;
                    case 24:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String W02 = W0(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeString(W02);
                        return true;
                    case 25:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String r72 = r7(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(r72);
                        return true;
                    case 26:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String W32 = W3(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeString(W32);
                        return true;
                    case 27:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String K32 = K3(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeString(K32);
                        return true;
                    case 28:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        if (parcel.readInt() != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        int q72 = q7(z10, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(q72);
                        return true;
                    case 29:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        if (parcel.readInt() != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        int I72 = I7(z11, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(I72);
                        return true;
                    case 30:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int d52 = d5(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(d52);
                        return true;
                    case 31:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int w12 = w1(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(w12);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        int o42 = o4(readString, z18);
                        parcel2.writeNoException();
                        parcel2.writeInt(o42);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String U52 = U5(parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(U52);
                        return true;
                    case 34:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String K12 = K1(parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(K12);
                        return true;
                    case 35:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String Y42 = Y4(parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(Y42);
                        return true;
                    case 36:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String s32 = s3(parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeString(s32);
                        return true;
                    case 37:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String T62 = T6(parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(T62);
                        return true;
                    case 38:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String y02 = y0(parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(y02);
                        return true;
                    case 39:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String g42 = g4(parcel.readString(), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(g42);
                        return true;
                    case 40:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int A22 = A2(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(A22);
                        return true;
                    case 41:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int g22 = g2(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(g22);
                        return true;
                    case 42:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        boolean h12 = h1(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(h12 ? 1 : 0);
                        return true;
                    case 43:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String r32 = r3(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(r32);
                        return true;
                    case 44:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int R02 = R0(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(R02);
                        return true;
                    case 45:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int S22 = S2(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(S22);
                        return true;
                    case 46:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int F22 = F2(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(F22);
                        return true;
                    case 47:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int p72 = p7(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(p72);
                        return true;
                    case 48:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int I32 = I3(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(I32);
                        return true;
                    case 49:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int z19 = z1(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(z19);
                        return true;
                    case 50:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int a02 = a0(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(a02);
                        return true;
                    case 51:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int q42 = q4(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(q42);
                        return true;
                    case 52:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int t52 = t5(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(t52);
                        return true;
                    case 53:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int R52 = R5(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(R52);
                        return true;
                    case 54:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int G52 = G5(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(G52);
                        return true;
                    case 55:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int p02 = p0(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(p02);
                        return true;
                    case 56:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String r12 = r1(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(r12);
                        return true;
                    case 57:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String X12 = X1(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(X12);
                        return true;
                    case 58:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String h02 = h0(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(h02);
                        return true;
                    case 59:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String b32 = b3(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(b32);
                        return true;
                    case 60:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String X32 = X3(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(X32);
                        return true;
                    case 61:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String v52 = v5(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(v52);
                        return true;
                    case 62:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String w32 = w3(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(w32);
                        return true;
                    case 63:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        if (parcel.readInt() != 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        int z02 = z0(z12, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(z02);
                        return true;
                    case 64:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int S42 = S4(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                        parcel2.writeNoException();
                        parcel2.writeInt(S42);
                        return true;
                    case 65:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int J12 = J1(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(J12);
                        return true;
                    case 66:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        if (parcel.readInt() != 0) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        int D22 = D2(z13, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(D22);
                        return true;
                    case 67:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int U22 = U2(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(U22);
                        return true;
                    case 68:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String a42 = a4(parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(a42);
                        return true;
                    case 69:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        boolean y72 = y7();
                        parcel2.writeNoException();
                        parcel2.writeInt(y72 ? 1 : 0);
                        return true;
                    case 70:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        boolean d72 = d7();
                        parcel2.writeNoException();
                        parcel2.writeInt(d72 ? 1 : 0);
                        return true;
                    case 71:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String q62 = q6(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(q62);
                        return true;
                    case 72:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String O12 = O1(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(O12);
                        return true;
                    case 73:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int y22 = y2(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(y22);
                        return true;
                    case 74:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int g32 = g3(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(g32);
                        return true;
                    case 75:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String readString2 = parcel.readString();
                        String readString3 = parcel.readString();
                        double readDouble = parcel.readDouble();
                        double readDouble2 = parcel.readDouble();
                        float readFloat = parcel.readFloat();
                        String readString4 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        String g02 = g0(readString2, readString3, readDouble, readDouble2, readFloat, readString4, z14);
                        parcel2.writeNoException();
                        parcel2.writeString(g02);
                        return true;
                    case 76:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String readString5 = parcel.readString();
                        String readString6 = parcel.readString();
                        String readString7 = parcel.readString();
                        double readDouble3 = parcel.readDouble();
                        double readDouble4 = parcel.readDouble();
                        float readFloat2 = parcel.readFloat();
                        String readString8 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        int O02 = O0(readString5, readString6, readString7, readDouble3, readDouble4, readFloat2, readString8, z15);
                        parcel2.writeNoException();
                        parcel2.writeInt(O02);
                        return true;
                    case 77:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        boolean T32 = T3();
                        parcel2.writeNoException();
                        parcel2.writeInt(T32 ? 1 : 0);
                        return true;
                    case 78:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        boolean C32 = C3();
                        parcel2.writeNoException();
                        parcel2.writeInt(C32 ? 1 : 0);
                        return true;
                    case 79:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int J52 = J5();
                        parcel2.writeNoException();
                        parcel2.writeInt(J52);
                        return true;
                    case 80:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int I42 = I4();
                        parcel2.writeNoException();
                        parcel2.writeInt(I42);
                        return true;
                    case 81:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int X02 = X0();
                        parcel2.writeNoException();
                        parcel2.writeInt(X02);
                        return true;
                    case 82:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int K22 = K2(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(K22);
                        return true;
                    case 83:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int P22 = P2(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(P22);
                        return true;
                    case 84:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int I62 = I6(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(I62);
                        return true;
                    case 85:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int F62 = F6(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(F62);
                        return true;
                    case 86:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int P32 = P3(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(P32);
                        return true;
                    case 87:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int N42 = N4(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(N42);
                        return true;
                    case 88:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int s62 = s6(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(s62);
                        return true;
                    case 89:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int f72 = f7();
                        parcel2.writeNoException();
                        parcel2.writeInt(f72);
                        return true;
                    case 90:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int m32 = m3(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(m32);
                        return true;
                    case 91:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int j02 = j0(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(j02);
                        return true;
                    case 92:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String u02 = u0(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(u02);
                        return true;
                    case 93:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int k32 = k3();
                        parcel2.writeNoException();
                        parcel2.writeInt(k32);
                        return true;
                    case 94:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int Z02 = Z0(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(Z02);
                        return true;
                    case 95:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String u22 = u2(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(u22);
                        return true;
                    case 96:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String v72 = v7(parcel.readInt(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(v72);
                        return true;
                    case 97:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        boolean E52 = E5();
                        parcel2.writeNoException();
                        parcel2.writeInt(E52 ? 1 : 0);
                        return true;
                    case 98:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        boolean y12 = y1();
                        parcel2.writeNoException();
                        parcel2.writeInt(y12 ? 1 : 0);
                        return true;
                    case 99:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String C22 = C2(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(C22);
                        return true;
                    case 100:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int Z52 = Z5(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(Z52);
                        return true;
                    case 101:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int k42 = k4(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(k42);
                        return true;
                    case 102:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int j22 = j2(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(j22);
                        return true;
                    case 103:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String readString9 = parcel.readString();
                        double readDouble5 = parcel.readDouble();
                        double readDouble6 = parcel.readDouble();
                        float readFloat3 = parcel.readFloat();
                        String readString10 = parcel.readString();
                        String readString11 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        String N12 = N1(readString9, readDouble5, readDouble6, readFloat3, readString10, readString11, z16);
                        parcel2.writeNoException();
                        parcel2.writeString(N12);
                        return true;
                    case 104:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String L72 = L7(parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(L72);
                        return true;
                    case 105:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int E62 = E6(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(E62);
                        return true;
                    case 106:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int P42 = P4(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(P42);
                        return true;
                    case 107:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int H52 = H5(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(H52);
                        return true;
                    case 108:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int V12 = V1(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(V12);
                        return true;
                    case 109:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int U62 = U6(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(U62);
                        return true;
                    case 110:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String readString12 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z18 = true;
                        }
                        int l62 = l6(readString12, z18);
                        parcel2.writeNoException();
                        parcel2.writeInt(l62);
                        return true;
                    case 111:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String O42 = O4(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(O42);
                        return true;
                    case 112:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String G32 = G3(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(G32);
                        return true;
                    case 113:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String k72 = k7(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(k72);
                        return true;
                    case 114:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String h42 = h4(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(h42);
                        return true;
                    case 115:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String G12 = G1(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(G12);
                        return true;
                    case 116:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String n62 = n6(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.createByteArray(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(n62);
                        return true;
                    case 117:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        String readString13 = parcel.readString();
                        String readString14 = parcel.readString();
                        String readString15 = parcel.readString();
                        String readString16 = parcel.readString();
                        String readString17 = parcel.readString();
                        int readInt = parcel.readInt();
                        String readString18 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        String K42 = K4(readString13, readString14, readString15, readString16, readString17, readInt, readString18, z17);
                        parcel2.writeNoException();
                        parcel2.writeString(K42);
                        return true;
                    case 118:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int j32 = j3(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(j32);
                        return true;
                    case 119:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int l52 = l5(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(l52);
                        return true;
                    case 120:
                        parcel.enforceInterface("com.juphoon.service.im.IRcsImService");
                        int h32 = h3(parcel.readString(), parcel.readDouble(), parcel.readDouble(), parcel.readFloat(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(h32);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            }
            parcel2.writeString("com.juphoon.service.im.IRcsImService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
