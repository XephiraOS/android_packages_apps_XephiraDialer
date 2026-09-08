package c5;

import java.util.List;

/* compiled from: BitArrayBuilder.java */
/* renamed from: c5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0554a {
    public static S4.a a(List<C0555b> list) {
        int size = list.size() << 1;
        int i10 = size - 1;
        if (list.get(list.size() - 1).c() == null) {
            i10 = size - 2;
        }
        S4.a aVar = new S4.a(i10 * 12);
        int i11 = 0;
        int b10 = list.get(0).c().b();
        for (int i12 = 11; i12 >= 0; i12--) {
            if (((1 << i12) & b10) != 0) {
                aVar.p(i11);
            }
            i11++;
        }
        for (int i13 = 1; i13 < list.size(); i13++) {
            C0555b c0555b = list.get(i13);
            int b11 = c0555b.b().b();
            for (int i14 = 11; i14 >= 0; i14--) {
                if (((1 << i14) & b11) != 0) {
                    aVar.p(i11);
                }
                i11++;
            }
            if (c0555b.c() != null) {
                int b12 = c0555b.c().b();
                for (int i15 = 11; i15 >= 0; i15--) {
                    if (((1 << i15) & b12) != 0) {
                        aVar.p(i11);
                    }
                    i11++;
                }
            }
        }
        return aVar;
    }
}
