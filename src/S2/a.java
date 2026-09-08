package S2;

import com.android.volley.VolleyError;

/* compiled from: DefaultRetryPolicy.java */
/* loaded from: classes.dex */
public class a implements h {

    /* renamed from: a, reason: collision with root package name */
    public int f3378a;

    /* renamed from: b, reason: collision with root package name */
    public int f3379b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3380c;

    /* renamed from: d, reason: collision with root package name */
    public final float f3381d;

    public a() {
        this(2500, 1, 1.0f);
    }

    @Override // S2.h
    public void a(VolleyError volleyError) {
        this.f3379b++;
        int i10 = this.f3378a;
        this.f3378a = i10 + ((int) (i10 * this.f3381d));
        if (d()) {
        } else {
            throw volleyError;
        }
    }

    @Override // S2.h
    public int b() {
        return this.f3378a;
    }

    @Override // S2.h
    public int c() {
        return this.f3379b;
    }

    public boolean d() {
        if (this.f3379b <= this.f3380c) {
            return true;
        }
        return false;
    }

    public a(int i10, int i11, float f10) {
        this.f3378a = i10;
        this.f3380c = i11;
        this.f3381d = f10;
    }
}
