package m1;

import android.text.TextUtils;
import android.widget.SectionIndexer;
import java.util.Arrays;

/* compiled from: ContactsSectionIndexer.java */
/* renamed from: m1.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1320p implements SectionIndexer {

    /* renamed from: a, reason: collision with root package name */
    public String[] f35017a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f35018b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f35019c;

    /* renamed from: d, reason: collision with root package name */
    public int f35020d;

    public C1320p(String[] strArr, int[] iArr) {
        if (strArr == null || iArr == null) {
            strArr = new String[0];
            iArr = new int[0];
        }
        if (strArr.length != iArr.length) {
            H7.b.c("ContactsSectionIndexer", "The sections and counts arrays must have the same length");
            strArr = new String[0];
            iArr = new int[0];
        }
        this.f35017a = strArr;
        this.f35019c = iArr;
        this.f35018b = new int[iArr.length];
        int i10 = 0;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (TextUtils.isEmpty(this.f35017a[i11])) {
                this.f35017a[i11] = " ";
            } else if (!this.f35017a[i11].equals(" ")) {
                String[] strArr2 = this.f35017a;
                strArr2[i11] = strArr2[i11].trim();
            }
            this.f35018b[i11] = i10;
            i10 += iArr[i11];
        }
        this.f35020d = i10;
    }

    public int[] a() {
        return this.f35019c;
    }

    public void b(String str) {
        String[] strArr = this.f35017a;
        if (strArr != null) {
            if (strArr.length > 0 && str.equals(strArr[0])) {
                return;
            }
            String[] strArr2 = new String[this.f35017a.length + 1];
            int[] iArr = new int[this.f35018b.length + 1];
            strArr2[0] = str;
            iArr[0] = 0;
            int i10 = 1;
            while (true) {
                int[] iArr2 = this.f35018b;
                if (i10 <= iArr2.length) {
                    int i11 = i10 - 1;
                    strArr2[i10] = this.f35017a[i11];
                    iArr[i10] = iArr2[i11] + 1;
                    i10++;
                } else {
                    this.f35017a = strArr2;
                    this.f35018b = iArr;
                    this.f35020d++;
                    return;
                }
            }
        }
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i10) {
        if (i10 >= 0 && i10 < this.f35017a.length) {
            return this.f35018b[i10];
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i10) {
        if (i10 >= 0 && i10 < this.f35020d) {
            int binarySearch = Arrays.binarySearch(this.f35018b, i10);
            if (binarySearch < 0) {
                return (-binarySearch) - 2;
            }
            return binarySearch;
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.f35017a;
    }
}
