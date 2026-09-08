package d3;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import d3.o;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import r3.C1508b;

/* compiled from: ByteArrayLoader.java */
/* renamed from: d3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0952b<Data> implements o<byte[], Data> {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0291b<Data> f29935a;

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: d3.b$a */
    /* loaded from: classes.dex */
    public static class a implements p<byte[], ByteBuffer> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: d3.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0290a implements InterfaceC0291b<ByteBuffer> {
            public C0290a() {
            }

            @Override // d3.C0952b.InterfaceC0291b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            @Override // d3.C0952b.InterfaceC0291b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // d3.p
        public o<byte[], ByteBuffer> d(s sVar) {
            return new C0952b(new C0290a());
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: d3.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0291b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: d3.b$d */
    /* loaded from: classes.dex */
    public static class d implements p<byte[], InputStream> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: d3.b$d$a */
        /* loaded from: classes.dex */
        public class a implements InterfaceC0291b<InputStream> {
            public a() {
            }

            @Override // d3.C0952b.InterfaceC0291b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // d3.C0952b.InterfaceC0291b
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // d3.p
        public o<byte[], InputStream> d(s sVar) {
            return new C0952b(new a());
        }
    }

    public C0952b(InterfaceC0291b<Data> interfaceC0291b) {
        this.f29935a = interfaceC0291b;
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<Data> b(byte[] bArr, int i10, int i11, X2.d dVar) {
        return new o.a<>(new C1508b(bArr), new c(bArr, this.f29935a));
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(byte[] bArr) {
        return true;
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: d3.b$c */
    /* loaded from: classes.dex */
    public static class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f29937a;

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC0291b<Data> f29938b;

        public c(byte[] bArr, InterfaceC0291b<Data> interfaceC0291b) {
            this.f29937a = bArr;
            this.f29938b = interfaceC0291b;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Data> a() {
            return this.f29938b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(Priority priority, d.a<? super Data> aVar) {
            aVar.f(this.f29938b.b(this.f29937a));
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}
