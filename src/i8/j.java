package i8;

/* compiled from: FloatValueHolder.java */
/* loaded from: classes3.dex */
public class j extends i<m> {

    /* renamed from: f, reason: collision with root package name */
    public float f32239f;

    public j(float f10) {
        this("floatValue", f10);
    }

    @Override // i8.i
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public float a(m mVar) {
        return this.f32239f;
    }

    @Override // i8.i
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void b(m mVar, float f10) {
        this.f32239f = f10;
    }

    @Override // i8.i
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(m mVar) {
        d(mVar, mVar.f32262h.f32251a);
    }

    @Override // i8.i
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void f(m mVar) {
        super.f(mVar);
        mVar.f32259e.f31799a = this.f32237d;
    }

    public j(String str, float f10) {
        this(str, f10, 1.0f);
    }

    public j(String str, float f10, float f11) {
        super(str, f11);
        this.f32239f = f10;
    }
}
