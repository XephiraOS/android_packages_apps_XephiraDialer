package X7;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.TreeSet;

/* compiled from: PhonePrefixMapStorageStrategy.java */
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public int f4315a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final TreeSet<Integer> f4316b = new TreeSet<>();

    public abstract String a(int i10);

    public int b() {
        return this.f4315a;
    }

    public TreeSet<Integer> c() {
        return this.f4316b;
    }

    public abstract int d(int i10);

    public abstract void e(ObjectInput objectInput);

    public abstract void f(ObjectOutput objectOutput);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b10 = b();
        for (int i10 = 0; i10 < b10; i10++) {
            sb.append(d(i10));
            sb.append("|");
            sb.append(a(i10));
            sb.append("\n");
        }
        return sb.toString();
    }
}
