package S9;

/* compiled from: ParserCursor.java */
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public final int f3670a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3671b;

    /* renamed from: c, reason: collision with root package name */
    public int f3672c;

    public o(int i10, int i11) {
        if (i10 >= 0) {
            if (i10 <= i11) {
                this.f3670a = i10;
                this.f3671b = i11;
                this.f3672c = i10;
                return;
            }
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
        throw new IndexOutOfBoundsException("Lower bound cannot be negative");
    }

    public boolean a() {
        if (this.f3672c >= this.f3671b) {
            return true;
        }
        return false;
    }

    public int b() {
        return this.f3672c;
    }

    public int c() {
        return this.f3671b;
    }

    public void d(int i10) {
        if (i10 >= this.f3670a) {
            if (i10 <= this.f3671b) {
                this.f3672c = i10;
                return;
            }
            throw new IndexOutOfBoundsException("pos: " + i10 + " > upperBound: " + this.f3671b);
        }
        throw new IndexOutOfBoundsException("pos: " + i10 + " < lowerBound: " + this.f3670a);
    }

    public String toString() {
        return '[' + Integer.toString(this.f3670a) + '>' + Integer.toString(this.f3672c) + '>' + Integer.toString(this.f3671b) + ']';
    }
}
