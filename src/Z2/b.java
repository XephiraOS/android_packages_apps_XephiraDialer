package Z2;

import b3.InterfaceC0520a;
import java.io.File;

/* compiled from: DataCacheWriter.java */
/* loaded from: classes.dex */
public class b<DataType> implements InterfaceC0520a.b {

    /* renamed from: a, reason: collision with root package name */
    public final X2.a<DataType> f5867a;

    /* renamed from: b, reason: collision with root package name */
    public final DataType f5868b;

    /* renamed from: c, reason: collision with root package name */
    public final X2.d f5869c;

    public b(X2.a<DataType> aVar, DataType datatype, X2.d dVar) {
        this.f5867a = aVar;
        this.f5868b = datatype;
        this.f5869c = dVar;
    }

    @Override // b3.InterfaceC0520a.b
    public boolean a(File file) {
        return this.f5867a.b(this.f5868b, file, this.f5869c);
    }
}
