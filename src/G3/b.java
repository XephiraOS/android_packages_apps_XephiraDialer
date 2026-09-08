package G3;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CustomizeMaster.java */
/* loaded from: classes3.dex */
public class b extends a implements Comparable<b> {

    /* renamed from: o, reason: collision with root package name */
    public String f1105o;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1102l = true;

    /* renamed from: m, reason: collision with root package name */
    public long f1103m = 0;

    /* renamed from: n, reason: collision with root package name */
    public long f1104n = 0;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList<a> f1101k = new ArrayList<>();

    public void b(a aVar) {
        if (this.f1101k == null) {
            this.f1101k = new ArrayList<>();
        }
        Iterator<a> it = this.f1101k.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f1091a == aVar.f1091a && next.f1092b == aVar.f1092b) {
                return;
            }
        }
        if (this.f1097g == 0 && this.f1103m == 0) {
            long j10 = aVar.f1097g;
            if (j10 > 0) {
                this.f1103m = j10;
                this.f1104n = aVar.f1091a;
            }
        }
        this.f1101k.add(aVar);
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        if (bVar != null && this.f1098h == bVar.f1098h && TextUtils.equals(this.f1093c, bVar.f1093c)) {
            ArrayList<String> arrayList = this.f1096f;
            if (arrayList == null && bVar.f1096f == null) {
                return 0;
            }
            if (arrayList == null || bVar.f1096f == null || arrayList.size() != bVar.f1096f.size()) {
                return -1;
            }
            for (int i10 = 0; i10 < this.f1096f.size(); i10++) {
                if (!bVar.f1096f.contains(this.f1096f.get(i10))) {
                    return -1;
                }
            }
            return 0;
        }
        return -1;
    }

    public boolean d() {
        return this.f1102l;
    }
}
