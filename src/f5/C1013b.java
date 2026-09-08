package f5;

import e5.C0980a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BarcodeValue.java */
/* renamed from: f5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1013b {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Integer, Integer> f31730a = new HashMap();

    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int i10 = -1;
        for (Map.Entry<Integer, Integer> entry : this.f31730a.entrySet()) {
            if (entry.getValue().intValue() > i10) {
                i10 = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == i10) {
                arrayList.add(entry.getKey());
            }
        }
        return C0980a.b(arrayList);
    }

    public void b(int i10) {
        Integer num = this.f31730a.get(Integer.valueOf(i10));
        if (num == null) {
            num = 0;
        }
        this.f31730a.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() + 1));
    }
}
