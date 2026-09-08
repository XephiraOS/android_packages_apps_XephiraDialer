package v7;

import android.util.Log;
import android.widget.SectionIndexer;
import java.util.Arrays;
import kotlin.jvm.internal.f;

/* compiled from: SectionCountIndexer.kt */
/* renamed from: v7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1634a implements SectionIndexer {

    /* renamed from: e, reason: collision with root package name */
    public static final C0370a f37490e = new C0370a(null);

    /* renamed from: a, reason: collision with root package name */
    public String[] f37491a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f37492b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f37493c;

    /* renamed from: d, reason: collision with root package name */
    public int f37494d;

    /* compiled from: SectionCountIndexer.kt */
    /* renamed from: v7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0370a {
        public C0370a() {
        }

        public /* synthetic */ C0370a(f fVar) {
            this();
        }
    }

    public C1634a(String[] strArr, int[] iArr) {
        int i10 = 0;
        if (strArr != null && strArr.length != 0 && iArr != null && iArr.length != 0) {
            if (strArr.length != iArr.length) {
                this.f37491a = new String[0];
                this.f37492b = new int[0];
                Log.w("SectionCountIndexer", "The sections and counts arrays must have the same length");
            } else {
                this.f37491a = strArr;
                this.f37492b = iArr;
            }
        } else {
            this.f37491a = new String[0];
            this.f37492b = new int[0];
        }
        int length = this.f37491a.length;
        int[] iArr2 = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr2[i11] = 0;
        }
        this.f37493c = iArr2;
        int[] iArr3 = this.f37492b;
        int length2 = iArr3.length;
        int i12 = 0;
        int i13 = 0;
        while (i10 < length2) {
            int i14 = iArr3[i10];
            this.f37493c[i13] = i12;
            i12 += i14;
            i10++;
            i13++;
        }
        this.f37494d = i12;
    }

    public final int[] a() {
        return this.f37492b;
    }

    @Override // android.widget.SectionIndexer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String[] getSections() {
        return this.f37491a;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i10) {
        if (i10 >= 0 && i10 < this.f37491a.length) {
            return this.f37493c[i10];
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i10) {
        if (i10 >= 0 && i10 < this.f37494d) {
            int binarySearch = Arrays.binarySearch(this.f37493c, i10);
            if (binarySearch < 0) {
                return (-binarySearch) - 2;
            }
            return binarySearch;
        }
        return -1;
    }
}
