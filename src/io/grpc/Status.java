package io.grpc;

import com.google.common.base.f;
import com.heytap.accessory.constant.FastPairConstants;
import io.grpc.u;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public final class Status {

    /* renamed from: d, reason: collision with root package name */
    public static final List<Status> f32367d = f();

    /* renamed from: e, reason: collision with root package name */
    public static final Status f32368e = Code.OK.b();

    /* renamed from: f, reason: collision with root package name */
    public static final Status f32369f = Code.CANCELLED.b();

    /* renamed from: g, reason: collision with root package name */
    public static final Status f32370g = Code.UNKNOWN.b();

    /* renamed from: h, reason: collision with root package name */
    public static final Status f32371h = Code.INVALID_ARGUMENT.b();

    /* renamed from: i, reason: collision with root package name */
    public static final Status f32372i = Code.DEADLINE_EXCEEDED.b();

    /* renamed from: j, reason: collision with root package name */
    public static final Status f32373j = Code.NOT_FOUND.b();

    /* renamed from: k, reason: collision with root package name */
    public static final Status f32374k = Code.ALREADY_EXISTS.b();

    /* renamed from: l, reason: collision with root package name */
    public static final Status f32375l = Code.PERMISSION_DENIED.b();

    /* renamed from: m, reason: collision with root package name */
    public static final Status f32376m = Code.UNAUTHENTICATED.b();

    /* renamed from: n, reason: collision with root package name */
    public static final Status f32377n = Code.RESOURCE_EXHAUSTED.b();

    /* renamed from: o, reason: collision with root package name */
    public static final Status f32378o = Code.FAILED_PRECONDITION.b();

    /* renamed from: p, reason: collision with root package name */
    public static final Status f32379p = Code.ABORTED.b();

    /* renamed from: q, reason: collision with root package name */
    public static final Status f32380q = Code.OUT_OF_RANGE.b();

    /* renamed from: r, reason: collision with root package name */
    public static final Status f32381r = Code.UNIMPLEMENTED.b();

    /* renamed from: s, reason: collision with root package name */
    public static final Status f32382s = Code.INTERNAL.b();

    /* renamed from: t, reason: collision with root package name */
    public static final Status f32383t = Code.UNAVAILABLE.b();

    /* renamed from: u, reason: collision with root package name */
    public static final Status f32384u = Code.DATA_LOSS.b();

    /* renamed from: v, reason: collision with root package name */
    public static final u.g<Status> f32385v;

    /* renamed from: w, reason: collision with root package name */
    public static final u.j<String> f32386w;

    /* renamed from: x, reason: collision with root package name */
    public static final u.g<String> f32387x;

    /* renamed from: a, reason: collision with root package name */
    public final Code f32388a;

    /* renamed from: b, reason: collision with root package name */
    public final String f32389b;

    /* renamed from: c, reason: collision with root package name */
    public final Throwable f32390c;

    /* loaded from: classes4.dex */
    public enum Code {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);

        private final int value;
        private final byte[] valueAscii;

        Code(int i10) {
            this.value = i10;
            this.valueAscii = Integer.toString(i10).getBytes(com.google.common.base.b.f24304a);
        }

        public Status b() {
            return (Status) Status.f32367d.get(this.value);
        }

        public int c() {
            return this.value;
        }

        public final byte[] d() {
            return this.valueAscii;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements u.j<Status> {
        public b() {
        }

        @Override // io.grpc.u.j
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Status b(byte[] bArr) {
            return Status.i(bArr);
        }

        @Override // io.grpc.u.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(Status status) {
            return status.m().d();
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements u.j<String> {

        /* renamed from: a, reason: collision with root package name */
        public static final byte[] f32409a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        public c() {
        }

        public static boolean c(byte b10) {
            if (b10 >= 32 && b10 < 126 && b10 != 37) {
                return false;
            }
            return true;
        }

        public static String e(byte[] bArr) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
            int i10 = 0;
            while (i10 < bArr.length) {
                if (bArr[i10] == 37 && i10 + 2 < bArr.length) {
                    try {
                        allocate.put((byte) Integer.parseInt(new String(bArr, i10 + 1, 2, com.google.common.base.b.f24304a), 16));
                        i10 += 3;
                    } catch (NumberFormatException unused) {
                    }
                }
                allocate.put(bArr[i10]);
                i10++;
            }
            return new String(allocate.array(), 0, allocate.position(), com.google.common.base.b.f24306c);
        }

        public static byte[] g(byte[] bArr, int i10) {
            byte[] bArr2 = new byte[((bArr.length - i10) * 3) + i10];
            if (i10 != 0) {
                System.arraycopy(bArr, 0, bArr2, 0, i10);
            }
            int i11 = i10;
            while (i10 < bArr.length) {
                byte b10 = bArr[i10];
                if (c(b10)) {
                    bArr2[i11] = 37;
                    byte[] bArr3 = f32409a;
                    bArr2[i11 + 1] = bArr3[(b10 >> 4) & 15];
                    bArr2[i11 + 2] = bArr3[b10 & FastPairConstants.GO_INTENT_MAX];
                    i11 += 3;
                } else {
                    bArr2[i11] = b10;
                    i11++;
                }
                i10++;
            }
            return Arrays.copyOf(bArr2, i11);
        }

        @Override // io.grpc.u.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String b(byte[] bArr) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                byte b10 = bArr[i10];
                if (b10 < 32 || b10 >= 126 || (b10 == 37 && i10 + 2 < bArr.length)) {
                    return e(bArr);
                }
            }
            return new String(bArr, 0);
        }

        @Override // io.grpc.u.j
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public byte[] a(String str) {
            byte[] bytes = str.getBytes(com.google.common.base.b.f24306c);
            for (int i10 = 0; i10 < bytes.length; i10++) {
                if (c(bytes[i10])) {
                    return g(bytes, i10);
                }
            }
            return bytes;
        }
    }

    static {
        f32385v = u.g.e("grpc-status", false, new b());
        c cVar = new c();
        f32386w = cVar;
        f32387x = u.g.e("grpc-message", false, cVar);
    }

    public Status(Code code) {
        this(code, null, null);
    }

    public static List<Status> f() {
        TreeMap treeMap = new TreeMap();
        for (Code code : Code.values()) {
            Status status = (Status) treeMap.put(Integer.valueOf(code.c()), new Status(code));
            if (status != null) {
                throw new IllegalStateException("Code value duplication between " + status.m().name() + " & " + code.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public static String g(Status status) {
        if (status.f32389b == null) {
            return status.f32388a.toString();
        }
        return status.f32388a + ": " + status.f32389b;
    }

    public static Status h(int i10) {
        if (i10 >= 0) {
            List<Status> list = f32367d;
            if (i10 < list.size()) {
                return list.get(i10);
            }
        }
        return f32370g.r("Unknown code " + i10);
    }

    public static Status i(byte[] bArr) {
        if (bArr.length == 1 && bArr[0] == 48) {
            return f32368e;
        }
        return j(bArr);
    }

    public static Status j(byte[] bArr) {
        byte b10;
        int length = bArr.length;
        char c10 = 1;
        int i10 = 0;
        if (length != 1) {
            if (length == 2 && (b10 = bArr[0]) >= 48 && b10 <= 57) {
                i10 = (b10 - 48) * 10;
            }
            return f32370g.r("Unknown code " + new String(bArr, com.google.common.base.b.f24304a));
        }
        c10 = 0;
        byte b11 = bArr[c10];
        if (b11 >= 48 && b11 <= 57) {
            int i11 = i10 + (b11 - 48);
            List<Status> list = f32367d;
            if (i11 < list.size()) {
                return list.get(i11);
            }
        }
        return f32370g.r("Unknown code " + new String(bArr, com.google.common.base.b.f24304a));
    }

    public static Status k(Throwable th) {
        for (Throwable th2 = (Throwable) com.google.common.base.k.p(th, "t"); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof StatusException) {
                return ((StatusException) th2).a();
            }
            if (th2 instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) th2).a();
            }
        }
        return f32370g.q(th);
    }

    public static u p(Throwable th) {
        for (Throwable th2 = (Throwable) com.google.common.base.k.p(th, "t"); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof StatusException) {
                return ((StatusException) th2).b();
            }
            if (th2 instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) th2).b();
            }
        }
        return null;
    }

    public StatusRuntimeException c() {
        return new StatusRuntimeException(this);
    }

    public StatusRuntimeException d(u uVar) {
        return new StatusRuntimeException(this, uVar);
    }

    public Status e(String str) {
        if (str == null) {
            return this;
        }
        if (this.f32389b == null) {
            return new Status(this.f32388a, str, this.f32390c);
        }
        return new Status(this.f32388a, this.f32389b + "\n" + str, this.f32390c);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Throwable l() {
        return this.f32390c;
    }

    public Code m() {
        return this.f32388a;
    }

    public String n() {
        return this.f32389b;
    }

    public boolean o() {
        if (Code.OK == this.f32388a) {
            return true;
        }
        return false;
    }

    public Status q(Throwable th) {
        if (com.google.common.base.h.a(this.f32390c, th)) {
            return this;
        }
        return new Status(this.f32388a, this.f32389b, th);
    }

    public Status r(String str) {
        if (com.google.common.base.h.a(this.f32389b, str)) {
            return this;
        }
        return new Status(this.f32388a, str, this.f32390c);
    }

    public String toString() {
        f.b d10 = com.google.common.base.f.c(this).d("code", this.f32388a.name()).d("description", this.f32389b);
        Throwable th = this.f32390c;
        Object obj = th;
        if (th != null) {
            obj = com.google.common.base.q.e(th);
        }
        return d10.d("cause", obj).toString();
    }

    public Status(Code code, String str, Throwable th) {
        this.f32388a = (Code) com.google.common.base.k.p(code, "code");
        this.f32389b = str;
        this.f32390c = th;
    }
}
