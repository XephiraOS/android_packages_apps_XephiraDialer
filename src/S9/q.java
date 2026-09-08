package S9;

import java.io.InputStream;
import org.apache.james.mime4j.stream.EntityState;
import org.apache.james.mime4j.stream.RecursionMode;

/* compiled from: RawEntity.java */
/* loaded from: classes4.dex */
public class q implements f {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f3675a;

    /* renamed from: b, reason: collision with root package name */
    public EntityState f3676b = EntityState.T_RAW_ENTITY;

    public q(InputStream inputStream) {
        this.f3675a = inputStream;
    }

    @Override // S9.f
    public f a() {
        this.f3676b = EntityState.T_END_OF_STREAM;
        return null;
    }

    @Override // S9.f
    public b c() {
        return null;
    }

    @Override // S9.f
    public InputStream d() {
        return this.f3675a;
    }

    @Override // S9.f
    public InputStream f() {
        throw new IllegalStateException("Raw entity does not support stream decoding");
    }

    @Override // S9.f
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public r b() {
        return null;
    }

    @Override // S9.f
    public EntityState getState() {
        return this.f3676b;
    }

    @Override // S9.f
    public void e(RecursionMode recursionMode) {
    }
}
