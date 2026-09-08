package h3;

import com.bumptech.glide.load.data.e;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder.java */
/* renamed from: h3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1077a implements e<ByteBuffer> {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f32053a;

    /* compiled from: ByteBufferRewinder.java */
    /* renamed from: h3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0302a implements e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.data.e.a
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public e<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new C1077a(byteBuffer);
        }
    }

    public C1077a(ByteBuffer byteBuffer) {
        this.f32053a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a() {
        this.f32053a.position(0);
        return this.f32053a;
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
    }
}
