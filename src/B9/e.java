package B9;

import java.util.NoSuchElementException;
import kotlin.collections.A;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes4.dex */
public final class e extends A {

    /* renamed from: a, reason: collision with root package name */
    public final int f300a;

    /* renamed from: b, reason: collision with root package name */
    public final int f301b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f302c;

    /* renamed from: d, reason: collision with root package name */
    public int f303d;

    public e(int i10, int i11, int i12) {
        this.f300a = i12;
        this.f301b = i11;
        boolean z10 = false;
        if (i12 <= 0 ? i10 >= i11 : i10 <= i11) {
            z10 = true;
        }
        this.f302c = z10;
        this.f303d = z10 ? i10 : i11;
    }

    @Override // kotlin.collections.A
    public int a() {
        int i10 = this.f303d;
        if (i10 == this.f301b) {
            if (this.f302c) {
                this.f302c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f303d = this.f300a + i10;
        }
        return i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f302c;
    }
}
