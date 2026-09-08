package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* compiled from: OpReorderer.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public final a f11199a;

    /* compiled from: OpReorderer.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(a.b bVar);

        a.b b(int i10, int i11, int i12, Object obj);
    }

    public r(a aVar) {
        this.f11199a = aVar;
    }

    public final int a(List<a.b> list) {
        boolean z10 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f11007a == 8) {
                if (z10) {
                    return size;
                }
            } else {
                z10 = true;
            }
        }
        return -1;
    }

    public void b(List<a.b> list) {
        while (true) {
            int a10 = a(list);
            if (a10 != -1) {
                d(list, a10, a10 + 1);
            } else {
                return;
            }
        }
    }

    public final void c(List<a.b> list, int i10, a.b bVar, int i11, a.b bVar2) {
        int i12;
        int i13 = bVar.f11010d;
        int i14 = bVar2.f11008b;
        if (i13 < i14) {
            i12 = -1;
        } else {
            i12 = 0;
        }
        int i15 = bVar.f11008b;
        if (i15 < i14) {
            i12++;
        }
        if (i14 <= i15) {
            bVar.f11008b = i15 + bVar2.f11010d;
        }
        int i16 = bVar2.f11008b;
        if (i16 <= i13) {
            bVar.f11010d = i13 + bVar2.f11010d;
        }
        bVar2.f11008b = i16 + i12;
        list.set(i10, bVar2);
        list.set(i11, bVar);
    }

    public final void d(List<a.b> list, int i10, int i11) {
        a.b bVar = list.get(i10);
        a.b bVar2 = list.get(i11);
        int i12 = bVar2.f11007a;
        if (i12 != 1) {
            if (i12 != 2) {
                if (i12 == 4) {
                    f(list, i10, bVar, i11, bVar2);
                    return;
                }
                return;
            }
            e(list, i10, bVar, i11, bVar2);
            return;
        }
        c(list, i10, bVar, i11, bVar2);
    }

    public void e(List<a.b> list, int i10, a.b bVar, int i11, a.b bVar2) {
        boolean z10;
        int i12 = bVar.f11008b;
        int i13 = bVar.f11010d;
        boolean z11 = false;
        if (i12 < i13) {
            if (bVar2.f11008b == i12 && bVar2.f11010d == i13 - i12) {
                z10 = false;
                z11 = true;
            } else {
                z10 = false;
            }
        } else if (bVar2.f11008b == i13 + 1 && bVar2.f11010d == i12 - i13) {
            z10 = true;
            z11 = true;
        } else {
            z10 = true;
        }
        int i14 = bVar2.f11008b;
        if (i13 < i14) {
            bVar2.f11008b = i14 - 1;
        } else {
            int i15 = bVar2.f11010d;
            if (i13 < i14 + i15) {
                bVar2.f11010d = i15 - 1;
                bVar.f11007a = 2;
                bVar.f11010d = 1;
                if (bVar2.f11010d == 0) {
                    list.remove(i11);
                    this.f11199a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i16 = bVar.f11008b;
        int i17 = bVar2.f11008b;
        a.b bVar3 = null;
        if (i16 <= i17) {
            bVar2.f11008b = i17 + 1;
        } else {
            int i18 = bVar2.f11010d;
            if (i16 < i17 + i18) {
                bVar3 = this.f11199a.b(2, i16 + 1, (i17 + i18) - i16, null);
                bVar2.f11010d = bVar.f11008b - bVar2.f11008b;
            }
        }
        if (z11) {
            list.set(i10, bVar2);
            list.remove(i11);
            this.f11199a.a(bVar);
            return;
        }
        if (z10) {
            if (bVar3 != null) {
                int i19 = bVar.f11008b;
                if (i19 > bVar3.f11008b) {
                    bVar.f11008b = i19 - bVar3.f11010d;
                }
                int i20 = bVar.f11010d;
                if (i20 > bVar3.f11008b) {
                    bVar.f11010d = i20 - bVar3.f11010d;
                }
            }
            int i21 = bVar.f11008b;
            if (i21 > bVar2.f11008b) {
                bVar.f11008b = i21 - bVar2.f11010d;
            }
            int i22 = bVar.f11010d;
            if (i22 > bVar2.f11008b) {
                bVar.f11010d = i22 - bVar2.f11010d;
            }
        } else {
            if (bVar3 != null) {
                int i23 = bVar.f11008b;
                if (i23 >= bVar3.f11008b) {
                    bVar.f11008b = i23 - bVar3.f11010d;
                }
                int i24 = bVar.f11010d;
                if (i24 >= bVar3.f11008b) {
                    bVar.f11010d = i24 - bVar3.f11010d;
                }
            }
            int i25 = bVar.f11008b;
            if (i25 >= bVar2.f11008b) {
                bVar.f11008b = i25 - bVar2.f11010d;
            }
            int i26 = bVar.f11010d;
            if (i26 >= bVar2.f11008b) {
                bVar.f11010d = i26 - bVar2.f11010d;
            }
        }
        list.set(i10, bVar2);
        if (bVar.f11008b != bVar.f11010d) {
            list.set(i11, bVar);
        } else {
            list.remove(i11);
        }
        if (bVar3 != null) {
            list.add(i10, bVar3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(java.util.List<androidx.recyclerview.widget.a.b> r9, int r10, androidx.recyclerview.widget.a.b r11, int r12, androidx.recyclerview.widget.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f11010d
            int r1 = r13.f11008b
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.f11008b = r1
            goto L20
        Ld:
            int r5 = r13.f11010d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.f11010d = r5
            androidx.recyclerview.widget.r$a r0 = r8.f11199a
            int r1 = r11.f11008b
            java.lang.Object r5 = r13.f11009c
            androidx.recyclerview.widget.a$b r0 = r0.b(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.f11008b
            int r5 = r13.f11008b
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.f11008b = r5
            goto L41
        L2b:
            int r6 = r13.f11010d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.r$a r4 = r8.f11199a
            int r1 = r1 + r3
            java.lang.Object r3 = r13.f11009c
            androidx.recyclerview.widget.a$b r4 = r4.b(r2, r1, r5, r3)
            int r1 = r13.f11010d
            int r1 = r1 - r5
            r13.f11010d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f11010d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.r$a r8 = r8.f11199a
            r8.a(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.r.f(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }
}
