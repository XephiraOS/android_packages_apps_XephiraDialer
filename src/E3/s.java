package E3;

import android.widget.TextView;

/* compiled from: CallLogNumberPlaceLoaderData.kt */
/* loaded from: classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f675a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f676b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f677c;

    /* renamed from: d, reason: collision with root package name */
    public Q0.a f678d;

    /* renamed from: e, reason: collision with root package name */
    public int f679e;

    /* renamed from: f, reason: collision with root package name */
    public int f680f;

    /* renamed from: g, reason: collision with root package name */
    public String f681g;

    /* renamed from: h, reason: collision with root package name */
    public String f682h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f683i;

    /* renamed from: j, reason: collision with root package name */
    public String f684j;

    public s(TextView placeView) {
        kotlin.jvm.internal.i.f(placeView, "placeView");
        this.f675a = placeView;
        this.f680f = -1;
    }

    public final TextView a() {
        return this.f675a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof s) && kotlin.jvm.internal.i.b(this.f675a, ((s) obj).f675a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f675a.hashCode();
    }

    public String toString() {
        return "CallLogNumberPlaceLoaderData(placeView=" + this.f675a + ")";
    }
}
