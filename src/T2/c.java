package T2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: ByteArrayPool.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    public static final Comparator<byte[]> f3712e = new a();

    /* renamed from: a, reason: collision with root package name */
    public final List<byte[]> f3713a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final List<byte[]> f3714b = new ArrayList(64);

    /* renamed from: c, reason: collision with root package name */
    public int f3715c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final int f3716d;

    /* compiled from: ByteArrayPool.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public c(int i10) {
        this.f3716d = i10;
    }

    public synchronized byte[] a(int i10) {
        for (int i11 = 0; i11 < this.f3714b.size(); i11++) {
            byte[] bArr = this.f3714b.get(i11);
            if (bArr.length >= i10) {
                this.f3715c -= bArr.length;
                this.f3714b.remove(i11);
                this.f3713a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i10];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f3716d) {
                this.f3713a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f3714b, bArr, f3712e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f3714b.add(binarySearch, bArr);
                this.f3715c += bArr.length;
                c();
            }
        }
    }

    public final synchronized void c() {
        while (this.f3715c > this.f3716d) {
            byte[] remove = this.f3713a.remove(0);
            this.f3714b.remove(remove);
            this.f3715c -= remove.length;
        }
    }
}
