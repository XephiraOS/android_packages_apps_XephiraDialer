package H9;

import kotlin.jvm.internal.i;
import okio.SegmentedByteString;

/* compiled from: SegmentedByteString.kt */
/* loaded from: classes4.dex */
public final class c {
    public static final int a(int[] iArr, int i10, int i11, int i12) {
        i.f(iArr, "<this>");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = iArr[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else if (i15 > i10) {
                i13 = i14 - 1;
            } else {
                return i14;
            }
        }
        return (-i11) - 1;
    }

    public static final int b(SegmentedByteString segmentedByteString, int i10) {
        i.f(segmentedByteString, "<this>");
        int a10 = a(segmentedByteString.r(), i10 + 1, 0, segmentedByteString.s().length);
        if (a10 < 0) {
            return ~a10;
        }
        return a10;
    }
}
