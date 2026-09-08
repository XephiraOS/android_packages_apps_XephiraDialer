package o6;

import com.oplus.utils.C0846g;

/* compiled from: NumberMatchRuleProcessorFactory.java */
/* loaded from: classes3.dex */
public class h {
    public static AbstractC1405a a(int i10, int i11) {
        C0846g.i("ProcessorFactory", " create matchPattern:" + i10 + " blockPattern:" + i11);
        if (i11 != 1 && i11 != 2) {
            return new C1407c();
        }
        if (i10 == 0) {
            return new e();
        }
        if (i10 == 1) {
            return new g();
        }
        if (i10 == 2) {
            return new f();
        }
        if (i10 == 3) {
            if (i11 == 1) {
                return new d();
            }
            if (i11 == 2) {
                return new e();
            }
            return null;
        }
        if (i10 == 4) {
            if (i11 == 2) {
                return new C1406b();
            }
            if (i11 == 1) {
                return new e();
            }
            return null;
        }
        return null;
    }
}
