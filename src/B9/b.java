package B9;

import java.util.NoSuchElementException;
import kotlin.collections.AbstractC1231l;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes4.dex */
public final class b extends AbstractC1231l {

    /* renamed from: a, reason: collision with root package name */
    public final int f290a;

    /* renamed from: b, reason: collision with root package name */
    public final int f291b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f292c;

    /* renamed from: d, reason: collision with root package name */
    public int f293d;

    public b(char c10, char c11, int i10) {
        this.f290a = i10;
        this.f291b = c11;
        boolean z10 = false;
        if (i10 <= 0 ? kotlin.jvm.internal.i.g(c10, c11) >= 0 : kotlin.jvm.internal.i.g(c10, c11) <= 0) {
            z10 = true;
        }
        this.f292c = z10;
        this.f293d = z10 ? c10 : c11;
    }

    @Override // kotlin.collections.AbstractC1231l
    public char a() {
        int i10 = this.f293d;
        if (i10 == this.f291b) {
            if (this.f292c) {
                this.f292c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f293d = this.f290a + i10;
        }
        return (char) i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f292c;
    }
}
