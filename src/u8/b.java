package u8;

import android.content.Context;
import java.util.Map;
import y8.C1713e;

/* compiled from: CommonBean.java */
/* loaded from: classes3.dex */
public class b extends f {

    /* renamed from: g, reason: collision with root package name */
    public String f37353g;

    /* renamed from: h, reason: collision with root package name */
    public String f37354h;

    /* renamed from: i, reason: collision with root package name */
    public String f37355i;

    /* renamed from: j, reason: collision with root package name */
    public int f37356j;

    public b(Context context) {
        super(context);
        this.f37353g = "";
        this.f37354h = "";
        this.f37355i = "";
        this.f37356j = 0;
    }

    @Override // u8.f
    public int g() {
        return 1006;
    }

    public int l() {
        return this.f37356j;
    }

    public String m() {
        return this.f37355i;
    }

    public String n() {
        return this.f37353g;
    }

    public String o() {
        return this.f37354h;
    }

    public void p(String str) {
        this.f37355i = str;
        d("eventID", str);
    }

    public void q(Map<String, String> map) {
        String jSONObject = C1713e.a(map).toString();
        this.f37353g = jSONObject;
        d("logMap", jSONObject);
    }

    public void r(String str) {
        this.f37354h = str;
        d("logTag", str);
    }

    public String toString() {
        return " type is :" + g() + ", tag is :" + o() + ", eventID is :" + m() + ", map is :" + n();
    }

    public b(Context context, String str, String str2, String str3) {
        super(context);
        this.f37353g = "";
        this.f37356j = 0;
        this.f37354h = str2;
        this.f37355i = str3;
        k(str);
        d("logTag", this.f37354h);
        d("eventID", this.f37355i);
    }
}
