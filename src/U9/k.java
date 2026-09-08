package U9;

import java.util.HashMap;

/* compiled from: Schema.java */
/* loaded from: classes4.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f3951a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public HashMap f3952b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public String f3953c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f3954d = "";

    /* renamed from: e, reason: collision with root package name */
    public d f3955e = null;

    public void a(String str, String str2, String str3, String str4) {
        d d10 = d(str);
        if (d10 != null) {
            d10.m(str2, str3, str4);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attribute ");
        stringBuffer.append(str2);
        stringBuffer.append(" specified for unknown element type ");
        stringBuffer.append(str);
        throw new Error(stringBuffer.toString());
    }

    public void b(String str, int i10, int i11, int i12) {
        d dVar = new d(str, i10, i11, i12, this);
        this.f3952b.put(str.toLowerCase(), dVar);
        if (i11 == Integer.MIN_VALUE) {
            this.f3955e = dVar;
        }
    }

    public void c(String str, int i10) {
        this.f3951a.put(str, new Integer(i10));
    }

    public d d(String str) {
        return (d) this.f3952b.get(str.toLowerCase());
    }

    public int e(String str) {
        Integer num = (Integer) this.f3951a.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String f() {
        return this.f3954d;
    }

    public String g() {
        return this.f3953c;
    }

    public void h(String str, String str2) {
        d d10 = d(str);
        d d11 = d(str2);
        if (d10 != null) {
            if (d11 != null) {
                d10.n(d11);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No parent ");
            stringBuffer.append(str2);
            stringBuffer.append(" for child ");
            stringBuffer.append(str);
            throw new Error(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("No child ");
        stringBuffer2.append(str);
        stringBuffer2.append(" for parent ");
        stringBuffer2.append(str2);
        throw new Error(stringBuffer2.toString());
    }

    public d i() {
        return this.f3955e;
    }

    public void j(String str) {
        this.f3954d = str;
    }

    public void k(String str) {
        this.f3953c = str;
    }
}
