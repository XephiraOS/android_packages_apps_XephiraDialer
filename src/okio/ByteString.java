package okio;

import G9.p;
import H9.b;
import com.heytap.accessory.constant.FastPairConstants;
import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import kotlin.collections.C1228i;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.n;

/* compiled from: ByteString.kt */
/* loaded from: classes4.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: c, reason: collision with root package name */
    public static final a f35786c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f35787d = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    public transient int f35788a;

    /* renamed from: b, reason: collision with root package name */
    public transient String f35789b;
    private final byte[] data;

    /* compiled from: ByteString.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public final ByteString a(String str) {
            i.f(str, "<this>");
            ByteString byteString = new ByteString(p.a(str));
            byteString.n(str);
            return byteString;
        }

        public final ByteString b(InputStream inputStream, int i10) {
            i.f(inputStream, "<this>");
            if (i10 >= 0) {
                byte[] bArr = new byte[i10];
                int i11 = 0;
                while (i11 < i10) {
                    int read = inputStream.read(bArr, i11, i10 - i11);
                    if (read != -1) {
                        i11 += read;
                    } else {
                        throw new EOFException();
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("byteCount < 0: " + i10).toString());
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public ByteString(byte[] data) {
        i.f(data, "data");
        this.data = data;
    }

    public static final ByteString b(String str) {
        return f35786c.a(str);
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        ByteString b10 = f35786c.b(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, b10.data);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.i.f(r10, r0)
            int r0 = r9.o()
            int r1 = r10.o()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2e
            byte r7 = r9.c(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.c(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L2c
        L2a:
            r3 = r5
            goto L34
        L2c:
            r3 = r6
            goto L34
        L2e:
            if (r0 != r1) goto L31
            goto L34
        L31:
            if (r0 >= r1) goto L2c
            goto L2a
        L34:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final byte c(int i10) {
        return j(i10);
    }

    public final byte[] d() {
        return this.data;
    }

    public final int e() {
        return this.f35788a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.o() == d().length && byteString.l(0, d(), 0, d().length)) {
                return true;
            }
        }
        return false;
    }

    public int f() {
        return d().length;
    }

    public final String g() {
        return this.f35789b;
    }

    public String h() {
        String m10;
        char[] cArr = new char[d().length * 2];
        int i10 = 0;
        for (byte b10 : d()) {
            int i11 = i10 + 1;
            cArr[i10] = b.c()[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = b.c()[b10 & FastPairConstants.GO_INTENT_MAX];
        }
        m10 = n.m(cArr);
        return m10;
    }

    public int hashCode() {
        int e10 = e();
        if (e10 == 0) {
            int hashCode = Arrays.hashCode(d());
            m(hashCode);
            return hashCode;
        }
        return e10;
    }

    public byte[] i() {
        return d();
    }

    public byte j(int i10) {
        return d()[i10];
    }

    public boolean k(int i10, ByteString other, int i11, int i12) {
        i.f(other, "other");
        return other.l(i11, d(), i10, i12);
    }

    public boolean l(int i10, byte[] other, int i11, int i12) {
        i.f(other, "other");
        if (i10 >= 0 && i10 <= d().length - i12 && i11 >= 0 && i11 <= other.length - i12 && G9.a.a(d(), i10, other, i11, i12)) {
            return true;
        }
        return false;
    }

    public final void m(int i10) {
        this.f35788a = i10;
    }

    public final void n(String str) {
        this.f35789b = str;
    }

    public final int o() {
        return f();
    }

    public final boolean p(ByteString prefix) {
        i.f(prefix, "prefix");
        return k(0, prefix, 0, prefix.o());
    }

    public String q() {
        String g10 = g();
        if (g10 == null) {
            String b10 = p.b(i());
            n(b10);
            return b10;
        }
        return g10;
    }

    public String toString() {
        int b10;
        String t10;
        String t11;
        String t12;
        byte[] n10;
        if (d().length != 0) {
            b10 = b.b(d(), 64);
            if (b10 == -1) {
                if (d().length <= 64) {
                    return "[hex=" + h() + ']';
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[size=");
                sb.append(d().length);
                sb.append(" hex=");
                ByteString byteString = this;
                int c10 = G9.a.c(byteString, 64);
                if (c10 <= d().length) {
                    if (c10 >= 0) {
                        if (c10 != d().length) {
                            n10 = C1228i.n(d(), 0, c10);
                            byteString = new ByteString(n10);
                        }
                        sb.append(byteString.h());
                        sb.append("…]");
                        return sb.toString();
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                throw new IllegalArgumentException(("endIndex > length(" + d().length + ')').toString());
            }
            String q10 = q();
            String substring = q10.substring(0, b10);
            i.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            t10 = n.t(substring, "\\", "\\\\", false, 4, null);
            t11 = n.t(t10, "\n", "\\n", false, 4, null);
            t12 = n.t(t11, "\r", "\\r", false, 4, null);
            if (b10 < q10.length()) {
                return "[size=" + d().length + " text=" + t12 + "…]";
            }
            return "[text=" + t12 + ']';
        }
        return "[size=0]";
    }
}
