package Q;

import Q.b;
import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.OsConstants;
import android.util.Log;
import com.android.incallui.OplusAutoRedial;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.uiutil.UIUtil;
import com.oplus.media.OplusRecorder;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.opencv.imgcodecs.Imgcodecs;

/* compiled from: ExifInterface.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: T, reason: collision with root package name */
    public static SimpleDateFormat f3020T;

    /* renamed from: U, reason: collision with root package name */
    public static SimpleDateFormat f3021U;

    /* renamed from: Y, reason: collision with root package name */
    public static final d[] f3025Y;

    /* renamed from: Z, reason: collision with root package name */
    public static final d[] f3026Z;

    /* renamed from: a0, reason: collision with root package name */
    public static final d[] f3027a0;

    /* renamed from: b0, reason: collision with root package name */
    public static final d[] f3028b0;

    /* renamed from: c0, reason: collision with root package name */
    public static final d[] f3029c0;

    /* renamed from: d0, reason: collision with root package name */
    public static final d f3030d0;

    /* renamed from: e0, reason: collision with root package name */
    public static final d[] f3031e0;

    /* renamed from: f0, reason: collision with root package name */
    public static final d[] f3032f0;

    /* renamed from: g0, reason: collision with root package name */
    public static final d[] f3033g0;

    /* renamed from: h0, reason: collision with root package name */
    public static final d[] f3034h0;

    /* renamed from: i0, reason: collision with root package name */
    public static final d[][] f3035i0;

    /* renamed from: j0, reason: collision with root package name */
    public static final d[] f3036j0;

    /* renamed from: k0, reason: collision with root package name */
    public static final HashMap<Integer, d>[] f3037k0;

    /* renamed from: l0, reason: collision with root package name */
    public static final HashMap<String, d>[] f3038l0;

    /* renamed from: m0, reason: collision with root package name */
    public static final HashSet<String> f3039m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final HashMap<Integer, Integer> f3040n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final Charset f3041o0;

    /* renamed from: p0, reason: collision with root package name */
    public static final byte[] f3042p0;

    /* renamed from: q0, reason: collision with root package name */
    public static final byte[] f3043q0;

    /* renamed from: r0, reason: collision with root package name */
    public static final Pattern f3044r0;

    /* renamed from: s0, reason: collision with root package name */
    public static final Pattern f3045s0;

    /* renamed from: t0, reason: collision with root package name */
    public static final Pattern f3046t0;

    /* renamed from: u0, reason: collision with root package name */
    public static final Pattern f3048u0;

    /* renamed from: a, reason: collision with root package name */
    public String f3054a;

    /* renamed from: b, reason: collision with root package name */
    public FileDescriptor f3055b;

    /* renamed from: c, reason: collision with root package name */
    public AssetManager.AssetInputStream f3056c;

    /* renamed from: d, reason: collision with root package name */
    public int f3057d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3058e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap<String, c>[] f3059f;

    /* renamed from: g, reason: collision with root package name */
    public Set<Integer> f3060g;

    /* renamed from: h, reason: collision with root package name */
    public ByteOrder f3061h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3062i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3063j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3064k;

    /* renamed from: l, reason: collision with root package name */
    public int f3065l;

    /* renamed from: m, reason: collision with root package name */
    public int f3066m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f3067n;

    /* renamed from: o, reason: collision with root package name */
    public int f3068o;

    /* renamed from: p, reason: collision with root package name */
    public int f3069p;

    /* renamed from: q, reason: collision with root package name */
    public int f3070q;

    /* renamed from: r, reason: collision with root package name */
    public int f3071r;

    /* renamed from: s, reason: collision with root package name */
    public int f3072s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3073t;

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f3047u = Log.isLoggable("ExifInterface", 3);

    /* renamed from: v, reason: collision with root package name */
    public static final List<Integer> f3049v = Arrays.asList(1, 6, 3, 8);

    /* renamed from: w, reason: collision with root package name */
    public static final List<Integer> f3050w = Arrays.asList(2, 7, 4, 5);

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f3051x = {8, 8, 8};

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f3052y = {4};

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f3053z = {8};

    /* renamed from: A, reason: collision with root package name */
    public static final byte[] f3001A = {-1, -40, -1};

    /* renamed from: B, reason: collision with root package name */
    public static final byte[] f3002B = {102, 116, 121, 112};

    /* renamed from: C, reason: collision with root package name */
    public static final byte[] f3003C = {109, 105, 102, 49};

    /* renamed from: D, reason: collision with root package name */
    public static final byte[] f3004D = {104, 101, 105, 99};

    /* renamed from: E, reason: collision with root package name */
    public static final byte[] f3005E = {79, 76, 89, 77, 80, 0};

    /* renamed from: F, reason: collision with root package name */
    public static final byte[] f3006F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: G, reason: collision with root package name */
    public static final byte[] f3007G = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: H, reason: collision with root package name */
    public static final byte[] f3008H = {101, 88, 73, 102};

    /* renamed from: I, reason: collision with root package name */
    public static final byte[] f3009I = {73, 72, 68, 82};

    /* renamed from: J, reason: collision with root package name */
    public static final byte[] f3010J = {73, 69, 78, 68};

    /* renamed from: K, reason: collision with root package name */
    public static final byte[] f3011K = {82, 73, 70, 70};

    /* renamed from: L, reason: collision with root package name */
    public static final byte[] f3012L = {87, 69, 66, 80};

    /* renamed from: M, reason: collision with root package name */
    public static final byte[] f3013M = {69, 88, 73, 70};

    /* renamed from: N, reason: collision with root package name */
    public static final byte[] f3014N = {-99, 1, 42};

    /* renamed from: O, reason: collision with root package name */
    public static final byte[] f3015O = "VP8X".getBytes(Charset.defaultCharset());

    /* renamed from: P, reason: collision with root package name */
    public static final byte[] f3016P = "VP8L".getBytes(Charset.defaultCharset());

    /* renamed from: Q, reason: collision with root package name */
    public static final byte[] f3017Q = "VP8 ".getBytes(Charset.defaultCharset());

    /* renamed from: R, reason: collision with root package name */
    public static final byte[] f3018R = "ANIM".getBytes(Charset.defaultCharset());

    /* renamed from: S, reason: collision with root package name */
    public static final byte[] f3019S = "ANMF".getBytes(Charset.defaultCharset());

    /* renamed from: V, reason: collision with root package name */
    public static final String[] f3022V = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

    /* renamed from: W, reason: collision with root package name */
    public static final int[] f3023W = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: X, reason: collision with root package name */
    public static final byte[] f3024X = {65, 83, 67, 73, 73, 0, 0, 0};

    /* compiled from: ExifInterface.java */
    /* loaded from: classes.dex */
    public static class b extends InputStream implements DataInput {

        /* renamed from: e, reason: collision with root package name */
        public static final ByteOrder f3077e = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: f, reason: collision with root package name */
        public static final ByteOrder f3078f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a, reason: collision with root package name */
        public final DataInputStream f3079a;

        /* renamed from: b, reason: collision with root package name */
        public ByteOrder f3080b;

        /* renamed from: c, reason: collision with root package name */
        public int f3081c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f3082d;

        public b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f3081c;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f3079a.available();
        }

        public long c() {
            return readInt() & 4294967295L;
        }

        public void e(ByteOrder byteOrder) {
            this.f3080b = byteOrder;
        }

        public void f(int i10) {
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i10 - i11;
                int skip = (int) this.f3079a.skip(i12);
                if (skip <= 0) {
                    if (this.f3082d == null) {
                        this.f3082d = new byte[8192];
                    }
                    skip = this.f3079a.read(this.f3082d, 0, Math.min(8192, i12));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i10 + " bytes.");
                    }
                }
                i11 += skip;
            }
            this.f3081c += i11;
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() {
            this.f3081c++;
            return this.f3079a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f3081c++;
            return this.f3079a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            this.f3081c++;
            int read = this.f3079a.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f3081c += 2;
            return this.f3079a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i10, int i11) {
            this.f3081c += i11;
            this.f3079a.readFully(bArr, i10, i11);
        }

        @Override // java.io.DataInput
        public int readInt() {
            this.f3081c += 4;
            int read = this.f3079a.read();
            int read2 = this.f3079a.read();
            int read3 = this.f3079a.read();
            int read4 = this.f3079a.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.f3080b;
                if (byteOrder == f3077e) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f3078f) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.f3080b);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            this.f3081c += 8;
            int read = this.f3079a.read();
            int read2 = this.f3079a.read();
            int read3 = this.f3079a.read();
            int read4 = this.f3079a.read();
            int read5 = this.f3079a.read();
            int read6 = this.f3079a.read();
            int read7 = this.f3079a.read();
            int read8 = this.f3079a.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.f3080b;
                if (byteOrder == f3077e) {
                    return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f3078f) {
                    return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                }
                throw new IOException("Invalid byte order: " + this.f3080b);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() {
            int i10;
            this.f3081c += 2;
            int read = this.f3079a.read();
            int read2 = this.f3079a.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f3080b;
                if (byteOrder == f3077e) {
                    i10 = (read2 << 8) + read;
                } else if (byteOrder == f3078f) {
                    i10 = (read << 8) + read2;
                } else {
                    throw new IOException("Invalid byte order: " + this.f3080b);
                }
                return (short) i10;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f3081c += 2;
            return this.f3079a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f3081c++;
            return this.f3079a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            this.f3081c += 2;
            int read = this.f3079a.read();
            int read2 = this.f3079a.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f3080b;
                if (byteOrder == f3077e) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == f3078f) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.f3080b);
            }
            throw new EOFException();
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i10) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public b(InputStream inputStream, ByteOrder byteOrder) {
            this.f3080b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f3079a = dataInputStream;
            dataInputStream.mark(0);
            this.f3081c = 0;
            this.f3080b = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            int read = this.f3079a.read(bArr, i10, i11);
            this.f3081c += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            this.f3081c += bArr.length;
            this.f3079a.readFully(bArr);
        }
    }

    /* compiled from: ExifInterface.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f3083a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3084b;

        /* renamed from: c, reason: collision with root package name */
        public final long f3085c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f3086d;

        public c(int i10, int i11, byte[] bArr) {
            this(i10, i11, -1L, bArr);
        }

        public static c a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.f3041o0);
            return new c(2, bytes.length, bytes);
        }

        public static c b(long j10, ByteOrder byteOrder) {
            return c(new long[]{j10}, byteOrder);
        }

        public static c c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.f3023W[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j10 : jArr) {
                wrap.putInt((int) j10);
            }
            return new c(4, jArr.length, wrap.array());
        }

        public static c d(e eVar, ByteOrder byteOrder) {
            return e(new e[]{eVar}, byteOrder);
        }

        public static c e(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.f3023W[5] * eVarArr.length]);
            wrap.order(byteOrder);
            for (e eVar : eVarArr) {
                wrap.putInt((int) eVar.f3091a);
                wrap.putInt((int) eVar.f3092b);
            }
            return new c(5, eVarArr.length, wrap.array());
        }

        public static c f(int i10, ByteOrder byteOrder) {
            return g(new int[]{i10}, byteOrder);
        }

        public static c g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.f3023W[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i10 : iArr) {
                wrap.putShort((short) i10);
            }
            return new c(3, iArr.length, wrap.array());
        }

        public double h(ByteOrder byteOrder) {
            Object k10 = k(byteOrder);
            if (k10 != null) {
                if (k10 instanceof String) {
                    return Double.parseDouble((String) k10);
                }
                if (k10 instanceof long[]) {
                    if (((long[]) k10).length == 1) {
                        return r3[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (k10 instanceof int[]) {
                    if (((int[]) k10).length == 1) {
                        return r3[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (k10 instanceof double[]) {
                    double[] dArr = (double[]) k10;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (k10 instanceof e[]) {
                    e[] eVarArr = (e[]) k10;
                    if (eVarArr.length == 1) {
                        return eVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                throw new NumberFormatException("Couldn't find a double value");
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public int i(ByteOrder byteOrder) {
            Object k10 = k(byteOrder);
            if (k10 != null) {
                if (k10 instanceof String) {
                    return Integer.parseInt((String) k10);
                }
                if (k10 instanceof long[]) {
                    long[] jArr = (long[]) k10;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                if (k10 instanceof int[]) {
                    int[] iArr = (int[]) k10;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                }
                throw new NumberFormatException("Couldn't find a integer value");
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String j(ByteOrder byteOrder) {
            Object k10 = k(byteOrder);
            if (k10 == null) {
                return null;
            }
            if (k10 instanceof String) {
                return (String) k10;
            }
            StringBuilder sb = new StringBuilder();
            int i10 = 0;
            if (k10 instanceof long[]) {
                long[] jArr = (long[]) k10;
                while (i10 < jArr.length) {
                    sb.append(jArr[i10]);
                    i10++;
                    if (i10 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k10 instanceof int[]) {
                int[] iArr = (int[]) k10;
                while (i10 < iArr.length) {
                    sb.append(iArr[i10]);
                    i10++;
                    if (i10 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (k10 instanceof double[]) {
                double[] dArr = (double[]) k10;
                while (i10 < dArr.length) {
                    sb.append(dArr[i10]);
                    i10++;
                    if (i10 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(k10 instanceof e[])) {
                return null;
            }
            e[] eVarArr = (e[]) k10;
            while (i10 < eVarArr.length) {
                sb.append(eVarArr[i10].f3091a);
                sb.append('/');
                sb.append(eVarArr[i10].f3092b);
                i10++;
                if (i10 != eVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:49), block:B:166:0x0030 */
        /* JADX WARN: Removed duplicated region for block: B:169:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object k(java.nio.ByteOrder r12) {
            /*
                Method dump skipped, instructions count: 436
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: Q.a.c.k(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return "(" + a.f3022V[this.f3083a] + ", data length:" + this.f3086d.length + ")";
        }

        public c(int i10, int i11, long j10, byte[] bArr) {
            this.f3083a = i10;
            this.f3084b = i11;
            this.f3085c = j10;
            this.f3086d = bArr;
        }
    }

    /* compiled from: ExifInterface.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final long f3091a;

        /* renamed from: b, reason: collision with root package name */
        public final long f3092b;

        public e(long j10, long j11) {
            if (j11 == 0) {
                this.f3091a = 0L;
                this.f3092b = 1L;
            } else {
                this.f3091a = j10;
                this.f3092b = j11;
            }
        }

        public double a() {
            return this.f3091a / this.f3092b;
        }

        public String toString() {
            return this.f3091a + "/" + this.f3092b;
        }
    }

    static {
        d[] dVarArr = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256, 3, 4), new d("ImageLength", Imgcodecs.IMWRITE_TIFF_XDPI, 3, 4), new d("BitsPerSample", Imgcodecs.IMWRITE_TIFF_YDPI, 3), new d("Compression", Imgcodecs.IMWRITE_TIFF_COMPRESSION, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", COUIHapticFeedbackConstants.KEYBOARD_TOUCH_FEEDBACK, 3), new d("Software", COUIHapticFeedbackConstants.STEPPING_SHORT_VIBRATE, 2), new d("DateTime", COUIHapticFeedbackConstants.EDGE_SHORT_VIBRATE, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", UIUtil.CONSTANT_INT_THTEE_HUNDRED_THIRTY, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", OplusRecorder.NAMR_BYTES_P_SEC, 1)};
        f3025Y = dVarArr;
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        f3026Z = dVarArr2;
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        f3027a0 = dVarArr3;
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        f3028b0 = dVarArr4;
        d[] dVarArr5 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", Imgcodecs.IMWRITE_TIFF_XDPI, 3, 4), new d("BitsPerSample", Imgcodecs.IMWRITE_TIFF_YDPI, 3), new d("Compression", Imgcodecs.IMWRITE_TIFF_COMPRESSION, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", COUIHapticFeedbackConstants.KEYBOARD_TOUCH_FEEDBACK, 3), new d("Software", COUIHapticFeedbackConstants.STEPPING_SHORT_VIBRATE, 2), new d("DateTime", COUIHapticFeedbackConstants.EDGE_SHORT_VIBRATE, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", UIUtil.CONSTANT_INT_THTEE_HUNDRED_THIRTY, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        f3029c0 = dVarArr5;
        f3030d0 = new d("StripOffsets", 273, 3);
        d[] dVarArr6 = {new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)};
        f3031e0 = dVarArr6;
        d[] dVarArr7 = {new d("PreviewImageStart", Imgcodecs.IMWRITE_TIFF_XDPI, 4), new d("PreviewImageLength", Imgcodecs.IMWRITE_TIFF_YDPI, 4)};
        f3032f0 = dVarArr7;
        d[] dVarArr8 = {new d("AspectFrame", 4371, 3)};
        f3033g0 = dVarArr8;
        d[] dVarArr9 = {new d("ColorSpace", 55, 3)};
        f3034h0 = dVarArr9;
        d[][] dVarArr10 = {dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, dVarArr6, dVarArr7, dVarArr8, dVarArr9};
        f3035i0 = dVarArr10;
        f3036j0 = new d[]{new d("SubIFDPointer", UIUtil.CONSTANT_INT_THTEE_HUNDRED_THIRTY, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
        f3037k0 = new HashMap[dVarArr10.length];
        f3038l0 = new HashMap[dVarArr10.length];
        f3039m0 = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f3040n0 = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        f3041o0 = forName;
        f3042p0 = "Exif\u0000\u0000".getBytes(forName);
        f3043q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        f3020T = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        f3021U = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i10 = 0;
        while (true) {
            d[][] dVarArr11 = f3035i0;
            if (i10 < dVarArr11.length) {
                f3037k0[i10] = new HashMap<>();
                f3038l0[i10] = new HashMap<>();
                for (d dVar : dVarArr11[i10]) {
                    f3037k0[i10].put(Integer.valueOf(dVar.f3087a), dVar);
                    f3038l0[i10].put(dVar.f3088b, dVar);
                }
                i10++;
            } else {
                HashMap<Integer, Integer> hashMap = f3040n0;
                d[] dVarArr12 = f3036j0;
                hashMap.put(Integer.valueOf(dVarArr12[0].f3087a), 5);
                hashMap.put(Integer.valueOf(dVarArr12[1].f3087a), 1);
                hashMap.put(Integer.valueOf(dVarArr12[2].f3087a), 2);
                hashMap.put(Integer.valueOf(dVarArr12[3].f3087a), 3);
                hashMap.put(Integer.valueOf(dVarArr12[4].f3087a), 7);
                hashMap.put(Integer.valueOf(dVarArr12[5].f3087a), 8);
                f3044r0 = Pattern.compile(".*[1-9].*");
                f3045s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f3046t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f3048u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
        }
    }

    public a(InputStream inputStream) {
        this(inputStream, 0);
    }

    public static boolean K(int i10) {
        if (i10 != 4 && i10 != 9 && i10 != 13 && i10 != 14) {
            return true;
        }
        return false;
    }

    public static boolean q(BufferedInputStream bufferedInputStream) {
        byte[] bArr = f3042p0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i10 = 0;
        while (true) {
            byte[] bArr3 = f3042p0;
            if (i10 < bArr3.length) {
                if (bArr2[i10] != bArr3[i10]) {
                    return false;
                }
                i10++;
            } else {
                return true;
            }
        }
    }

    public static boolean s(byte[] bArr) {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = f3001A;
            if (i10 < bArr2.length) {
                if (bArr[i10] != bArr2[i10]) {
                    return false;
                }
                i10++;
            } else {
                return true;
            }
        }
    }

    public static boolean x(FileDescriptor fileDescriptor) {
        try {
            b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (f3047u) {
                Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                return false;
            }
            return false;
        }
    }

    public final boolean A(byte[] bArr) {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = f3011K;
            if (i10 < bArr2.length) {
                if (bArr[i10] != bArr2[i10]) {
                    return false;
                }
                i10++;
            } else {
                int i11 = 0;
                while (true) {
                    byte[] bArr3 = f3012L;
                    if (i11 < bArr3.length) {
                        if (bArr[f3011K.length + i11 + 4] != bArr3[i11]) {
                            return false;
                        }
                        i11++;
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    public final void B(InputStream inputStream) {
        if (inputStream != null) {
            for (int i10 = 0; i10 < f3035i0.length; i10++) {
                try {
                    try {
                        this.f3059f[i10] = new HashMap<>();
                    } catch (IOException | UnsupportedOperationException e10) {
                        boolean z10 = f3047u;
                        if (z10) {
                            Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e10);
                        }
                        a();
                        if (!z10) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    a();
                    if (f3047u) {
                        D();
                    }
                    throw th;
                }
            }
            if (!this.f3058e) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, OplusAutoRedial.DELAY_FIVE_SECOND);
                this.f3057d = g(bufferedInputStream);
                inputStream = bufferedInputStream;
            }
            if (K(this.f3057d)) {
                f fVar = new f(inputStream);
                if (this.f3058e) {
                    m(fVar);
                } else {
                    int i11 = this.f3057d;
                    if (i11 == 12) {
                        e(fVar);
                    } else if (i11 == 7) {
                        h(fVar);
                    } else if (i11 == 10) {
                        l(fVar);
                    } else {
                        k(fVar);
                    }
                }
                fVar.g(this.f3069p);
                J(fVar);
            } else {
                b bVar = new b(inputStream);
                int i12 = this.f3057d;
                if (i12 == 4) {
                    f(bVar, 0, 0);
                } else if (i12 == 13) {
                    i(bVar);
                } else if (i12 == 9) {
                    j(bVar);
                } else if (i12 == 14) {
                    n(bVar);
                }
            }
            a();
            if (!f3047u) {
                return;
            }
            D();
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    public final void C(b bVar) {
        ByteOrder E10 = E(bVar);
        this.f3061h = E10;
        bVar.e(E10);
        int readUnsignedShort = bVar.readUnsignedShort();
        int i10 = this.f3057d;
        if (i10 != 7 && i10 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = bVar.readInt();
        if (readInt >= 8) {
            int i11 = readInt - 8;
            if (i11 > 0) {
                bVar.f(i11);
                return;
            }
            return;
        }
        throw new IOException("Invalid first Ifd offset: " + readInt);
    }

    public final void D() {
        for (int i10 = 0; i10 < this.f3059f.length; i10++) {
            Log.d("ExifInterface", "The size of tag group[" + i10 + "]: " + this.f3059f[i10].size());
            for (Map.Entry<String, c> entry : this.f3059f[i10].entrySet()) {
                c value = entry.getValue();
                Log.d("ExifInterface", "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.j(this.f3061h) + "'");
            }
        }
    }

    public final ByteOrder E(b bVar) {
        short readShort = bVar.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                if (f3047u) {
                    Log.d("ExifInterface", "readExifSegment: Byte Align MM");
                }
                return ByteOrder.BIG_ENDIAN;
            }
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
        if (f3047u) {
            Log.d("ExifInterface", "readExifSegment: Byte Align II");
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    public final void F(byte[] bArr, int i10) {
        f fVar = new f(bArr);
        C(fVar);
        G(fVar, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x026e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(Q.a.f r26, int r27) {
        /*
            Method dump skipped, instructions count: 905
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Q.a.G(Q.a$f, int):void");
    }

    public final void H(int i10, String str, String str2) {
        if (!this.f3059f[i10].isEmpty() && this.f3059f[i10].get(str) != null) {
            HashMap<String, c> hashMap = this.f3059f[i10];
            hashMap.put(str2, hashMap.get(str));
            this.f3059f[i10].remove(str);
        }
    }

    public final void I(f fVar, int i10) {
        c cVar = this.f3059f[i10].get("ImageLength");
        c cVar2 = this.f3059f[i10].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            c cVar3 = this.f3059f[i10].get("JPEGInterchangeFormat");
            c cVar4 = this.f3059f[i10].get("JPEGInterchangeFormatLength");
            if (cVar3 != null && cVar4 != null) {
                int i11 = cVar3.i(this.f3061h);
                int i12 = cVar3.i(this.f3061h);
                fVar.g(i11);
                byte[] bArr = new byte[i12];
                fVar.read(bArr);
                f(new b(bArr), i11, i10);
            }
        }
    }

    public final void J(b bVar) {
        HashMap<String, c> hashMap = this.f3059f[4];
        c cVar = hashMap.get("Compression");
        if (cVar != null) {
            int i10 = cVar.i(this.f3061h);
            this.f3068o = i10;
            if (i10 != 1) {
                if (i10 != 6) {
                    if (i10 != 7) {
                        return;
                    }
                } else {
                    o(bVar, hashMap);
                    return;
                }
            }
            if (y(hashMap)) {
                p(bVar, hashMap);
                return;
            }
            return;
        }
        this.f3068o = 6;
        o(bVar, hashMap);
    }

    public final void L(int i10, int i11) {
        if (!this.f3059f[i10].isEmpty() && !this.f3059f[i11].isEmpty()) {
            c cVar = this.f3059f[i10].get("ImageLength");
            c cVar2 = this.f3059f[i10].get("ImageWidth");
            c cVar3 = this.f3059f[i11].get("ImageLength");
            c cVar4 = this.f3059f[i11].get("ImageWidth");
            if (cVar != null && cVar2 != null) {
                if (cVar3 != null && cVar4 != null) {
                    int i12 = cVar.i(this.f3061h);
                    int i13 = cVar2.i(this.f3061h);
                    int i14 = cVar3.i(this.f3061h);
                    int i15 = cVar4.i(this.f3061h);
                    if (i12 < i14 && i13 < i15) {
                        HashMap<String, c>[] hashMapArr = this.f3059f;
                        HashMap<String, c> hashMap = hashMapArr[i10];
                        hashMapArr[i10] = hashMapArr[i11];
                        hashMapArr[i11] = hashMap;
                        return;
                    }
                    return;
                }
                if (f3047u) {
                    Log.d("ExifInterface", "Second image does not contain valid size information");
                    return;
                }
                return;
            }
            if (f3047u) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (f3047u) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    public final void M(f fVar, int i10) {
        c f10;
        c f11;
        c cVar = this.f3059f[i10].get("DefaultCropSize");
        c cVar2 = this.f3059f[i10].get("SensorTopBorder");
        c cVar3 = this.f3059f[i10].get("SensorLeftBorder");
        c cVar4 = this.f3059f[i10].get("SensorBottomBorder");
        c cVar5 = this.f3059f[i10].get("SensorRightBorder");
        if (cVar != null) {
            if (cVar.f3083a == 5) {
                e[] eVarArr = (e[]) cVar.k(this.f3061h);
                if (eVarArr != null && eVarArr.length == 2) {
                    f10 = c.d(eVarArr[0], this.f3061h);
                    f11 = c.d(eVarArr[1], this.f3061h);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(eVarArr));
                    return;
                }
            } else {
                int[] iArr = (int[]) cVar.k(this.f3061h);
                if (iArr != null && iArr.length == 2) {
                    f10 = c.f(iArr[0], this.f3061h);
                    f11 = c.f(iArr[1], this.f3061h);
                } else {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
            }
            this.f3059f[i10].put("ImageWidth", f10);
            this.f3059f[i10].put("ImageLength", f11);
            return;
        }
        if (cVar2 != null && cVar3 != null && cVar4 != null && cVar5 != null) {
            int i11 = cVar2.i(this.f3061h);
            int i12 = cVar4.i(this.f3061h);
            int i13 = cVar5.i(this.f3061h);
            int i14 = cVar3.i(this.f3061h);
            if (i12 > i11 && i13 > i14) {
                c f12 = c.f(i12 - i11, this.f3061h);
                c f13 = c.f(i13 - i14, this.f3061h);
                this.f3059f[i10].put("ImageLength", f12);
                this.f3059f[i10].put("ImageWidth", f13);
                return;
            }
            return;
        }
        I(fVar, i10);
    }

    public final void N() {
        L(0, 5);
        L(0, 4);
        L(5, 4);
        c cVar = this.f3059f[1].get("PixelXDimension");
        c cVar2 = this.f3059f[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            this.f3059f[0].put("ImageWidth", cVar);
            this.f3059f[0].put("ImageLength", cVar2);
        }
        if (this.f3059f[4].isEmpty() && z(this.f3059f[5])) {
            HashMap<String, c>[] hashMapArr = this.f3059f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!z(this.f3059f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        H(0, "ThumbnailOrientation", "Orientation");
        H(0, "ThumbnailImageLength", "ImageLength");
        H(0, "ThumbnailImageWidth", "ImageWidth");
        H(5, "ThumbnailOrientation", "Orientation");
        H(5, "ThumbnailImageLength", "ImageLength");
        H(5, "ThumbnailImageWidth", "ImageWidth");
        H(4, "Orientation", "ThumbnailOrientation");
        H(4, "ImageLength", "ThumbnailImageLength");
        H(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public final void a() {
        String b10 = b("DateTimeOriginal");
        if (b10 != null && b("DateTime") == null) {
            this.f3059f[0].put("DateTime", c.a(b10));
        }
        if (b("ImageWidth") == null) {
            this.f3059f[0].put("ImageWidth", c.b(0L, this.f3061h));
        }
        if (b("ImageLength") == null) {
            this.f3059f[0].put("ImageLength", c.b(0L, this.f3061h));
        }
        if (b("Orientation") == null) {
            this.f3059f[0].put("Orientation", c.b(0L, this.f3061h));
        }
        if (b("LightSource") == null) {
            this.f3059f[1].put("LightSource", c.b(0L, this.f3061h));
        }
    }

    public String b(String str) {
        if (str != null) {
            c d10 = d(str);
            if (d10 != null) {
                if (!f3039m0.contains(str)) {
                    return d10.j(this.f3061h);
                }
                if (str.equals("GPSTimeStamp")) {
                    int i10 = d10.f3083a;
                    if (i10 != 5 && i10 != 10) {
                        Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + d10.f3083a);
                        return null;
                    }
                    e[] eVarArr = (e[]) d10.k(this.f3061h);
                    if (eVarArr != null && eVarArr.length == 3) {
                        e eVar = eVarArr[0];
                        Integer valueOf = Integer.valueOf((int) (((float) eVar.f3091a) / ((float) eVar.f3092b)));
                        e eVar2 = eVarArr[1];
                        Integer valueOf2 = Integer.valueOf((int) (((float) eVar2.f3091a) / ((float) eVar2.f3092b)));
                        e eVar3 = eVarArr[2];
                        return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (((float) eVar3.f3091a) / ((float) eVar3.f3092b))));
                    }
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr));
                    return null;
                }
                try {
                    return Double.toString(d10.h(this.f3061h));
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public int c(String str, int i10) {
        if (str != null) {
            c d10 = d(str);
            if (d10 == null) {
                return i10;
            }
            try {
                return d10.i(this.f3061h);
            } catch (NumberFormatException unused) {
                return i10;
            }
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final c d(String str) {
        if (str != null) {
            if ("ISOSpeedRatings".equals(str)) {
                if (f3047u) {
                    Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
                }
                str = "PhotographicSensitivity";
            }
            for (int i10 = 0; i10 < f3035i0.length; i10++) {
                c cVar = this.f3059f[i10].get(str);
                if (cVar != null) {
                    return cVar;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public final void e(f fVar) {
        String str;
        String str2;
        String str3;
        int i10;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                b.C0057b.a(mediaMetadataRetriever, new C0056a(fVar));
                String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(extractMetadata3)) {
                    str = mediaMetadataRetriever.extractMetadata(29);
                    str2 = mediaMetadataRetriever.extractMetadata(30);
                    str3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(extractMetadata4)) {
                    str = mediaMetadataRetriever.extractMetadata(18);
                    str2 = mediaMetadataRetriever.extractMetadata(19);
                    str3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                if (str != null) {
                    this.f3059f[0].put("ImageWidth", c.f(Integer.parseInt(str), this.f3061h));
                }
                if (str2 != null) {
                    this.f3059f[0].put("ImageLength", c.f(Integer.parseInt(str2), this.f3061h));
                }
                if (str3 != null) {
                    int parseInt = Integer.parseInt(str3);
                    if (parseInt != 90) {
                        if (parseInt != 180) {
                            if (parseInt != 270) {
                                i10 = 1;
                            } else {
                                i10 = 8;
                            }
                        } else {
                            i10 = 3;
                        }
                    } else {
                        i10 = 6;
                    }
                    this.f3059f[0].put("Orientation", c.f(i10, this.f3061h));
                }
                if (extractMetadata != null && extractMetadata2 != null) {
                    int parseInt2 = Integer.parseInt(extractMetadata);
                    int parseInt3 = Integer.parseInt(extractMetadata2);
                    if (parseInt3 > 6) {
                        fVar.g(parseInt2);
                        byte[] bArr = new byte[6];
                        if (fVar.read(bArr) == 6) {
                            int i11 = parseInt2 + 6;
                            int i12 = parseInt3 - 6;
                            if (Arrays.equals(bArr, f3042p0)) {
                                byte[] bArr2 = new byte[i12];
                                if (fVar.read(bArr2) == i12) {
                                    this.f3069p = i11;
                                    F(bArr2, 0);
                                } else {
                                    throw new IOException("Can't read exif");
                                }
                            } else {
                                throw new IOException("Invalid identifier");
                            }
                        } else {
                            throw new IOException("Can't read identifier");
                        }
                    } else {
                        throw new IOException("Invalid exif length");
                    }
                }
                if (f3047u) {
                    Log.d("ExifInterface", "Heif meta: " + str + "x" + str2 + ", rotation " + str3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0191, code lost:
    
        r22.e(r21.f3061h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017b A[LOOP:0: B:9:0x0037->B:33:0x017b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0182 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(Q.a.b r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Q.a.f(Q.a$b, int, int):void");
    }

    public final int g(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(OplusAutoRedial.DELAY_FIVE_SECOND);
        byte[] bArr = new byte[OplusAutoRedial.DELAY_FIVE_SECOND];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (s(bArr)) {
            return 4;
        }
        if (v(bArr)) {
            return 9;
        }
        if (r(bArr)) {
            return 12;
        }
        if (t(bArr)) {
            return 7;
        }
        if (w(bArr)) {
            return 10;
        }
        if (u(bArr)) {
            return 13;
        }
        if (A(bArr)) {
            return 14;
        }
        return 0;
    }

    public final void h(f fVar) {
        int i10;
        int i11;
        k(fVar);
        c cVar = this.f3059f[1].get("MakerNote");
        if (cVar != null) {
            f fVar2 = new f(cVar.f3086d);
            fVar2.e(this.f3061h);
            byte[] bArr = f3005E;
            byte[] bArr2 = new byte[bArr.length];
            fVar2.readFully(bArr2);
            fVar2.g(0L);
            byte[] bArr3 = f3006F;
            byte[] bArr4 = new byte[bArr3.length];
            fVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fVar2.g(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fVar2.g(12L);
            }
            G(fVar2, 6);
            c cVar2 = this.f3059f[7].get("PreviewImageStart");
            c cVar3 = this.f3059f[7].get("PreviewImageLength");
            if (cVar2 != null && cVar3 != null) {
                this.f3059f[5].put("JPEGInterchangeFormat", cVar2);
                this.f3059f[5].put("JPEGInterchangeFormatLength", cVar3);
            }
            c cVar4 = this.f3059f[8].get("AspectFrame");
            if (cVar4 != null) {
                int[] iArr = (int[]) cVar4.k(this.f3061h);
                if (iArr != null && iArr.length == 4) {
                    int i12 = iArr[2];
                    int i13 = iArr[0];
                    if (i12 > i13 && (i10 = iArr[3]) > (i11 = iArr[1])) {
                        int i14 = (i12 - i13) + 1;
                        int i15 = (i10 - i11) + 1;
                        if (i14 < i15) {
                            int i16 = i14 + i15;
                            i15 = i16 - i15;
                            i14 = i16 - i15;
                        }
                        c f10 = c.f(i14, this.f3061h);
                        c f11 = c.f(i15, this.f3061h);
                        this.f3059f[0].put("ImageWidth", f10);
                        this.f3059f[0].put("ImageLength", f11);
                        return;
                    }
                    return;
                }
                Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
            }
        }
    }

    public final void i(b bVar) {
        if (f3047u) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.e(ByteOrder.BIG_ENDIAN);
        byte[] bArr = f3007G;
        bVar.f(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int readInt = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int i10 = length + 8;
                    if (i10 == 16 && !Arrays.equals(bArr2, f3009I)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                    if (!Arrays.equals(bArr2, f3010J)) {
                        if (Arrays.equals(bArr2, f3008H)) {
                            byte[] bArr3 = new byte[readInt];
                            if (bVar.read(bArr3) == readInt) {
                                int readInt2 = bVar.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f3069p = i10;
                                    F(bArr3, 0);
                                    N();
                                    J(new b(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + Q.b.a(bArr2));
                        }
                        int i11 = readInt + 4;
                        bVar.f(i11);
                        length = i10 + i11;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void j(b bVar) {
        boolean z10 = f3047u;
        if (z10) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.f(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i10 = ByteBuffer.wrap(bArr).getInt();
        int i11 = ByteBuffer.wrap(bArr2).getInt();
        int i12 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i11];
        bVar.f(i10 - bVar.a());
        bVar.read(bArr4);
        f(new b(bArr4), i10, 5);
        bVar.f(i12 - bVar.a());
        bVar.e(ByteOrder.BIG_ENDIAN);
        int readInt = bVar.readInt();
        if (z10) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i13 = 0; i13 < readInt; i13++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f3030d0.f3087a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                c f10 = c.f(readShort, this.f3061h);
                c f11 = c.f(readShort2, this.f3061h);
                this.f3059f[0].put("ImageLength", f10);
                this.f3059f[0].put("ImageWidth", f11);
                if (f3047u) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            bVar.f(readUnsignedShort2);
        }
    }

    public final void k(f fVar) {
        c cVar;
        C(fVar);
        G(fVar, 0);
        M(fVar, 0);
        M(fVar, 5);
        M(fVar, 4);
        N();
        if (this.f3057d == 8 && (cVar = this.f3059f[1].get("MakerNote")) != null) {
            f fVar2 = new f(cVar.f3086d);
            fVar2.e(this.f3061h);
            fVar2.f(6);
            G(fVar2, 9);
            c cVar2 = this.f3059f[9].get("ColorSpace");
            if (cVar2 != null) {
                this.f3059f[1].put("ColorSpace", cVar2);
            }
        }
    }

    public final void l(f fVar) {
        if (f3047u) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + fVar);
        }
        k(fVar);
        c cVar = this.f3059f[0].get("JpgFromRaw");
        if (cVar != null) {
            f(new b(cVar.f3086d), (int) cVar.f3085c, 5);
        }
        c cVar2 = this.f3059f[0].get("ISO");
        c cVar3 = this.f3059f[1].get("PhotographicSensitivity");
        if (cVar2 != null && cVar3 == null) {
            this.f3059f[1].put("PhotographicSensitivity", cVar2);
        }
    }

    public final void m(f fVar) {
        byte[] bArr = f3042p0;
        fVar.f(bArr.length);
        byte[] bArr2 = new byte[fVar.available()];
        fVar.readFully(bArr2);
        this.f3069p = bArr.length;
        F(bArr2, 0);
    }

    public final void n(b bVar) {
        if (f3047u) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.e(ByteOrder.LITTLE_ENDIAN);
        bVar.f(f3011K.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = f3012L;
        bVar.f(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int readInt2 = bVar.readInt();
                    int i10 = length + 8;
                    if (Arrays.equals(f3013M, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (bVar.read(bArr3) == readInt2) {
                            this.f3069p = i10;
                            F(bArr3, 0);
                            J(new b(bArr3));
                            return;
                        } else {
                            throw new IOException("Failed to read given length for given PNG chunk type: " + Q.b.a(bArr2));
                        }
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i10 + readInt2;
                    if (length == readInt) {
                        return;
                    }
                    if (length <= readInt) {
                        bVar.f(readInt2);
                    } else {
                        throw new IOException("Encountered WebP file with invalid chunk size");
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void o(b bVar, HashMap hashMap) {
        c cVar = (c) hashMap.get("JPEGInterchangeFormat");
        c cVar2 = (c) hashMap.get("JPEGInterchangeFormatLength");
        if (cVar != null && cVar2 != null) {
            int i10 = cVar.i(this.f3061h);
            int i11 = cVar2.i(this.f3061h);
            if (this.f3057d == 7) {
                i10 += this.f3070q;
            }
            if (i10 > 0 && i11 > 0) {
                this.f3062i = true;
                if (this.f3054a == null && this.f3056c == null && this.f3055b == null) {
                    byte[] bArr = new byte[i11];
                    bVar.skip(i10);
                    bVar.read(bArr);
                    this.f3067n = bArr;
                }
                this.f3065l = i10;
                this.f3066m = i11;
            }
            if (f3047u) {
                Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + i10 + ", length: " + i11);
            }
        }
    }

    public final void p(b bVar, HashMap hashMap) {
        c cVar = (c) hashMap.get("StripOffsets");
        c cVar2 = (c) hashMap.get("StripByteCounts");
        if (cVar != null && cVar2 != null) {
            long[] b10 = Q.b.b(cVar.k(this.f3061h));
            long[] b11 = Q.b.b(cVar2.k(this.f3061h));
            if (b10 != null && b10.length != 0) {
                if (b11 != null && b11.length != 0) {
                    if (b10.length != b11.length) {
                        Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                        return;
                    }
                    long j10 = 0;
                    for (long j11 : b11) {
                        j10 += j11;
                    }
                    int i10 = (int) j10;
                    byte[] bArr = new byte[i10];
                    this.f3064k = true;
                    this.f3063j = true;
                    this.f3062i = true;
                    int i11 = 0;
                    int i12 = 0;
                    for (int i13 = 0; i13 < b10.length; i13++) {
                        int i14 = (int) b10[i13];
                        int i15 = (int) b11[i13];
                        if (i13 < b10.length - 1 && i14 + i15 != b10[i13 + 1]) {
                            this.f3064k = false;
                        }
                        int i16 = i14 - i11;
                        if (i16 < 0) {
                            Log.d("ExifInterface", "Invalid strip offset value");
                            return;
                        }
                        long j12 = i16;
                        if (bVar.skip(j12) != j12) {
                            Log.d("ExifInterface", "Failed to skip " + i16 + " bytes.");
                            return;
                        }
                        int i17 = i11 + i16;
                        byte[] bArr2 = new byte[i15];
                        if (bVar.read(bArr2) != i15) {
                            Log.d("ExifInterface", "Failed to read " + i15 + " bytes.");
                            return;
                        }
                        i11 = i17 + i15;
                        System.arraycopy(bArr2, 0, bArr, i12, i15);
                        i12 += i15;
                    }
                    this.f3067n = bArr;
                    if (this.f3064k) {
                        this.f3065l = (int) b10[0];
                        this.f3066m = i10;
                        return;
                    }
                    return;
                }
                Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                return;
            }
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
        }
    }

    public final boolean r(byte[] bArr) {
        b bVar;
        long readInt;
        byte[] bArr2;
        long j10;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            readInt = bVar.readInt();
            bArr2 = new byte[4];
            bVar.read(bArr2);
        } catch (Exception e11) {
            e = e11;
            bVar2 = bVar;
            if (f3047u) {
                Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
            }
            if (bVar2 != null) {
                bVar2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th;
        }
        if (!Arrays.equals(bArr2, f3002B)) {
            bVar.close();
            return false;
        }
        if (readInt == 1) {
            readInt = bVar.readLong();
            j10 = 16;
            if (readInt < 16) {
                bVar.close();
                return false;
            }
        } else {
            j10 = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j11 = readInt - j10;
        if (j11 < 8) {
            bVar.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z10 = false;
        boolean z11 = false;
        for (long j12 = 0; j12 < j11 / 4; j12++) {
            if (bVar.read(bArr3) != 4) {
                bVar.close();
                return false;
            }
            if (j12 != 1) {
                if (Arrays.equals(bArr3, f3003C)) {
                    z10 = true;
                } else if (Arrays.equals(bArr3, f3004D)) {
                    z11 = true;
                }
                if (z10 && z11) {
                    bVar.close();
                    return true;
                }
            }
        }
        bVar.close();
        return false;
    }

    public final boolean t(byte[] bArr) {
        boolean z10 = false;
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder E10 = E(bVar2);
                this.f3061h = E10;
                bVar2.e(E10);
                short readShort = bVar2.readShort();
                if (readShort == 20306 || readShort == 21330) {
                    z10 = true;
                }
                bVar2.close();
                return z10;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean u(byte[] bArr) {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = f3007G;
            if (i10 < bArr2.length) {
                if (bArr[i10] != bArr2[i10]) {
                    return false;
                }
                i10++;
            } else {
                return true;
            }
        }
    }

    public final boolean v(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i10 = 0; i10 < bytes.length; i10++) {
            if (bArr[i10] != bytes[i10]) {
                return false;
            }
        }
        return true;
    }

    public final boolean w(byte[] bArr) {
        boolean z10 = false;
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder E10 = E(bVar2);
                this.f3061h = E10;
                bVar2.e(E10);
                if (bVar2.readShort() == 85) {
                    z10 = true;
                }
                bVar2.close();
                return z10;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean y(HashMap hashMap) {
        c cVar;
        int i10;
        c cVar2 = (c) hashMap.get("BitsPerSample");
        if (cVar2 != null) {
            int[] iArr = (int[]) cVar2.k(this.f3061h);
            int[] iArr2 = f3051x;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f3057d == 3 && (cVar = (c) hashMap.get("PhotometricInterpretation")) != null && (((i10 = cVar.i(this.f3061h)) == 1 && Arrays.equals(iArr, f3053z)) || (i10 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (f3047u) {
            Log.d("ExifInterface", "Unsupported data type value");
            return false;
        }
        return false;
    }

    public final boolean z(HashMap hashMap) {
        c cVar = (c) hashMap.get("ImageLength");
        c cVar2 = (c) hashMap.get("ImageWidth");
        if (cVar != null && cVar2 != null) {
            int i10 = cVar.i(this.f3061h);
            int i11 = cVar2.i(this.f3061h);
            if (i10 <= 512 && i11 <= 512) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* compiled from: ExifInterface.java */
    /* loaded from: classes.dex */
    public static class f extends b {
        public f(byte[] bArr) {
            super(bArr);
            this.f3079a.mark(Integer.MAX_VALUE);
        }

        public void g(long j10) {
            int i10 = this.f3081c;
            if (i10 > j10) {
                this.f3081c = 0;
                this.f3079a.reset();
            } else {
                j10 -= i10;
            }
            f((int) j10);
        }

        public f(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f3079a.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    public a(InputStream inputStream, int i10) {
        d[][] dVarArr = f3035i0;
        this.f3059f = new HashMap[dVarArr.length];
        this.f3060g = new HashSet(dVarArr.length);
        this.f3061h = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.f3054a = null;
            if (i10 == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f3042p0.length);
                if (!q(bufferedInputStream)) {
                    Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.f3058e = true;
                this.f3056c = null;
                this.f3055b = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f3056c = (AssetManager.AssetInputStream) inputStream;
                this.f3055b = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (x(fileInputStream.getFD())) {
                        this.f3056c = null;
                        this.f3055b = fileInputStream.getFD();
                    }
                }
                this.f3056c = null;
                this.f3055b = null;
            }
            B(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }

    /* compiled from: ExifInterface.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f3087a;

        /* renamed from: b, reason: collision with root package name */
        public final String f3088b;

        /* renamed from: c, reason: collision with root package name */
        public final int f3089c;

        /* renamed from: d, reason: collision with root package name */
        public final int f3090d;

        public d(String str, int i10, int i11) {
            this.f3088b = str;
            this.f3087a = i10;
            this.f3089c = i11;
            this.f3090d = -1;
        }

        public boolean a(int i10) {
            int i11;
            int i12 = this.f3089c;
            if (i12 == 7 || i10 == 7 || i12 == i10 || (i11 = this.f3090d) == i10) {
                return true;
            }
            if ((i12 == 4 || i11 == 4) && i10 == 3) {
                return true;
            }
            if ((i12 == 9 || i11 == 9) && i10 == 8) {
                return true;
            }
            if ((i12 == 12 || i11 == 12) && i10 == 11) {
                return true;
            }
            return false;
        }

        public d(String str, int i10, int i11, int i12) {
            this.f3088b = str;
            this.f3087a = i10;
            this.f3089c = i11;
            this.f3090d = i12;
        }
    }

    /* compiled from: ExifInterface.java */
    /* renamed from: Q.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0056a extends MediaDataSource {

        /* renamed from: a, reason: collision with root package name */
        public long f3074a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f3075b;

        public C0056a(f fVar) {
            this.f3075b = fVar;
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j10, byte[] bArr, int i10, int i11) {
            if (i11 == 0) {
                return 0;
            }
            if (j10 < 0) {
                return -1;
            }
            try {
                long j11 = this.f3074a;
                if (j11 != j10) {
                    if (j11 >= 0 && j10 >= j11 + this.f3075b.available()) {
                        return -1;
                    }
                    this.f3075b.g(j10);
                    this.f3074a = j10;
                }
                if (i11 > this.f3075b.available()) {
                    i11 = this.f3075b.available();
                }
                int read = this.f3075b.read(bArr, i10, i11);
                if (read >= 0) {
                    this.f3074a += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f3074a = -1L;
            return -1;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }
}
