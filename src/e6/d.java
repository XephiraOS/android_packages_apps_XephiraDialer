package e6;

import g6.k;
import java.util.List;

/* compiled from: FontCharacter.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final List<k> f31639a;

    /* renamed from: b, reason: collision with root package name */
    public final char f31640b;

    /* renamed from: c, reason: collision with root package name */
    public final double f31641c;

    /* renamed from: d, reason: collision with root package name */
    public final double f31642d;

    /* renamed from: e, reason: collision with root package name */
    public final String f31643e;

    /* renamed from: f, reason: collision with root package name */
    public final String f31644f;

    public d(List<k> list, char c10, double d10, double d11, String str, String str2) {
        this.f31639a = list;
        this.f31640b = c10;
        this.f31641c = d10;
        this.f31642d = d11;
        this.f31643e = str;
        this.f31644f = str2;
    }

    public static int c(char c10, String str, String str2) {
        return (((c10 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<k> a() {
        return this.f31639a;
    }

    public double b() {
        return this.f31642d;
    }

    public int hashCode() {
        return c(this.f31640b, this.f31644f, this.f31643e);
    }
}
