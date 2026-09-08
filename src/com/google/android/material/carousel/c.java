package com.google.android.material.carousel;

import com.google.android.material.carousel.b;
import f4.C1001b;
import j4.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: KeylineStateList.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f22968a;

    /* renamed from: b, reason: collision with root package name */
    public final List<b> f22969b;

    /* renamed from: c, reason: collision with root package name */
    public final List<b> f22970c;

    /* renamed from: d, reason: collision with root package name */
    public final float[] f22971d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f22972e;

    /* renamed from: f, reason: collision with root package name */
    public final float f22973f;

    /* renamed from: g, reason: collision with root package name */
    public final float f22974g;

    public c(b bVar, List<b> list, List<b> list2) {
        this.f22968a = bVar;
        this.f22969b = Collections.unmodifiableList(list);
        this.f22970c = Collections.unmodifiableList(list2);
        float f10 = list.get(list.size() - 1).c().f22960a - bVar.c().f22960a;
        this.f22973f = f10;
        float f11 = bVar.j().f22960a - list2.get(list2.size() - 1).j().f22960a;
        this.f22974g = f11;
        this.f22971d = m(f10, list, true);
        this.f22972e = m(f11, list2, false);
    }

    public static int b(b bVar, float f10) {
        for (int i10 = bVar.i(); i10 < bVar.g().size(); i10++) {
            if (f10 == bVar.g().get(i10).f22962c) {
                return i10;
            }
        }
        return bVar.g().size() - 1;
    }

    public static int c(b bVar) {
        for (int i10 = 0; i10 < bVar.g().size(); i10++) {
            if (!bVar.g().get(i10).f22964e) {
                return i10;
            }
        }
        return -1;
    }

    public static int d(b bVar, float f10) {
        for (int b10 = bVar.b() - 1; b10 >= 0; b10--) {
            if (f10 == bVar.g().get(b10).f22962c) {
                return b10;
            }
        }
        return 0;
    }

    public static int e(b bVar) {
        for (int size = bVar.g().size() - 1; size >= 0; size--) {
            if (!bVar.g().get(size).f22964e) {
                return size;
            }
        }
        return -1;
    }

    public static c f(j4.b bVar, b bVar2, float f10, float f11, float f12) {
        return new c(bVar2, p(bVar, bVar2, f10, f11), n(bVar, bVar2, f10, f12));
    }

    public static float[] m(float f10, List<b> list, boolean z10) {
        float f11;
        float f12;
        int size = list.size();
        float[] fArr = new float[size];
        for (int i10 = 1; i10 < size; i10++) {
            int i11 = i10 - 1;
            b bVar = list.get(i11);
            b bVar2 = list.get(i10);
            if (z10) {
                f11 = bVar2.c().f22960a - bVar.c().f22960a;
            } else {
                f11 = bVar.j().f22960a - bVar2.j().f22960a;
            }
            float f13 = f11 / f10;
            if (i10 == size - 1) {
                f12 = 1.0f;
            } else {
                f12 = fArr[i11] + f13;
            }
            fArr[i10] = f12;
        }
        return fArr;
    }

    public static List<b> n(j4.b bVar, b bVar2, float f10, float f11) {
        int b10;
        int i10;
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar2);
        int e10 = e(bVar2);
        if (bVar.d()) {
            b10 = bVar.a();
        } else {
            b10 = bVar.b();
        }
        float f12 = b10;
        if (!r(bVar, bVar2) && e10 != -1) {
            int i11 = e10 - bVar2.i();
            float f13 = bVar2.c().f22961b - (bVar2.c().f22963d / 2.0f);
            if (i11 <= 0 && bVar2.h().f22965f > 0.0f) {
                arrayList.add(v(bVar2, f13 - bVar2.h().f22965f, f12));
                return arrayList;
            }
            float f14 = 0.0f;
            int i12 = 0;
            while (i12 < i11) {
                b bVar3 = (b) arrayList.get(arrayList.size() - 1);
                int i13 = e10 - i12;
                float f15 = f14 + bVar2.g().get(i13).f22965f;
                int i14 = i13 + 1;
                if (i14 < bVar2.g().size()) {
                    i10 = d(bVar3, bVar2.g().get(i14).f22962c) + 1;
                } else {
                    i10 = 0;
                }
                int i15 = i12;
                b t10 = t(bVar3, e10, i10, f13 - f15, bVar2.b() + i12 + 1, bVar2.i() + i12 + 1, f12);
                if (i15 == i11 - 1 && f11 > 0.0f) {
                    t10 = u(t10, f11, f12, false, f10);
                }
                arrayList.add(t10);
                i12 = i15 + 1;
                f14 = f15;
            }
            return arrayList;
        }
        if (f11 > 0.0f) {
            arrayList.add(u(bVar2, f11, f12, false, f10));
        }
        return arrayList;
    }

    public static float[] o(List<b> list, float f10, float[] fArr) {
        int size = list.size();
        float f11 = fArr[0];
        int i10 = 1;
        while (i10 < size) {
            float f12 = fArr[i10];
            if (f10 <= f12) {
                return new float[]{C1001b.b(0.0f, 1.0f, f11, f12, f10), i10 - 1, i10};
            }
            i10++;
            f11 = f12;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    public static List<b> p(j4.b bVar, b bVar2, float f10, float f11) {
        int b10;
        int i10;
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar2);
        int c10 = c(bVar2);
        if (bVar.d()) {
            b10 = bVar.a();
        } else {
            b10 = bVar.b();
        }
        float f12 = b10;
        int i11 = 1;
        if (!q(bVar2) && c10 != -1) {
            int b11 = bVar2.b() - c10;
            float f13 = bVar2.c().f22961b - (bVar2.c().f22963d / 2.0f);
            if (b11 <= 0 && bVar2.a().f22965f > 0.0f) {
                arrayList.add(v(bVar2, f13 + bVar2.a().f22965f, f12));
                return arrayList;
            }
            int i12 = 0;
            float f14 = 0.0f;
            while (i12 < b11) {
                b bVar3 = (b) arrayList.get(arrayList.size() - i11);
                int i13 = c10 + i12;
                int size = bVar2.g().size() - i11;
                float f15 = f14 + bVar2.g().get(i13).f22965f;
                int i14 = i13 - i11;
                if (i14 >= 0) {
                    i10 = b(bVar3, bVar2.g().get(i14).f22962c) - i11;
                } else {
                    i10 = size;
                }
                int i15 = i12;
                b t10 = t(bVar3, c10, i10, f13 + f15, (bVar2.b() - i12) - 1, (bVar2.i() - i12) - 1, f12);
                if (i15 == b11 - 1 && f11 > 0.0f) {
                    t10 = u(t10, f11, f12, true, f10);
                }
                arrayList.add(t10);
                i12 = i15 + 1;
                f14 = f15;
                i11 = 1;
            }
            return arrayList;
        }
        if (f11 > 0.0f) {
            arrayList.add(u(bVar2, f11, f12, true, f10));
        }
        return arrayList;
    }

    public static boolean q(b bVar) {
        if (bVar.a().f22961b - (bVar.a().f22963d / 2.0f) >= 0.0f && bVar.a() == bVar.d()) {
            return true;
        }
        return false;
    }

    public static boolean r(j4.b bVar, b bVar2) {
        int b10 = bVar.b();
        if (bVar.d()) {
            b10 = bVar.a();
        }
        if (bVar2.h().f22961b + (bVar2.h().f22963d / 2.0f) <= b10 && bVar2.h() == bVar2.k()) {
            return true;
        }
        return false;
    }

    public static b s(List<b> list, float f10, float[] fArr) {
        float[] o10 = o(list, f10, fArr);
        return b.m(list.get((int) o10[1]), list.get((int) o10[2]), o10[0]);
    }

    public static b t(b bVar, int i10, int i11, float f10, int i12, int i13, float f11) {
        boolean z10;
        ArrayList arrayList = new ArrayList(bVar.g());
        arrayList.add(i11, (b.c) arrayList.remove(i10));
        b.C0210b c0210b = new b.C0210b(bVar.f(), f11);
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            b.c cVar = (b.c) arrayList.get(i14);
            float f12 = cVar.f22963d;
            float f13 = f10 + (f12 / 2.0f);
            if (i14 >= i12 && i14 <= i13) {
                z10 = true;
            } else {
                z10 = false;
            }
            c0210b.e(f13, cVar.f22962c, f12, z10, cVar.f22964e, cVar.f22965f);
            f10 += cVar.f22963d;
        }
        return c0210b.i();
    }

    public static b u(b bVar, float f10, float f11, boolean z10, float f12) {
        float f13;
        boolean z11;
        float f14;
        float f15;
        ArrayList arrayList = new ArrayList(bVar.g());
        b.C0210b c0210b = new b.C0210b(bVar.f(), f11);
        float l10 = f10 / bVar.l();
        if (z10) {
            f13 = f10;
        } else {
            f13 = 0.0f;
        }
        float f16 = f13;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            b.c cVar = (b.c) arrayList.get(i10);
            if (cVar.f22964e) {
                c0210b.e(cVar.f22961b, cVar.f22962c, cVar.f22963d, false, true, cVar.f22965f);
            } else {
                if (i10 >= bVar.b() && i10 <= bVar.i()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                float f17 = cVar.f22963d - l10;
                float b10 = f.b(f17, bVar.f(), f12);
                float f18 = (f17 / 2.0f) + f16;
                float f19 = f18 - cVar.f22961b;
                float f20 = cVar.f22965f;
                if (z10) {
                    f14 = f19;
                } else {
                    f14 = 0.0f;
                }
                if (z10) {
                    f15 = 0.0f;
                } else {
                    f15 = f19;
                }
                c0210b.f(f18, b10, f17, z11, false, f20, f14, f15);
                f16 += f17;
            }
        }
        return c0210b.i();
    }

    public static b v(b bVar, float f10, float f11) {
        return t(bVar, 0, 0, f10, bVar.b(), bVar.i(), f11);
    }

    public final b a(List<b> list, float f10, float[] fArr) {
        float[] o10 = o(list, f10, fArr);
        if (o10[0] >= 0.5f) {
            return list.get((int) o10[2]);
        }
        return list.get((int) o10[1]);
    }

    public b g() {
        return this.f22968a;
    }

    public b h() {
        return this.f22970c.get(r1.size() - 1);
    }

    public Map<Integer, b> i(int i10, int i11, int i12, boolean z10) {
        int i13;
        int i14;
        int i15;
        float f10 = this.f22968a.f();
        HashMap hashMap = new HashMap();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = -1;
            if (i16 >= i10) {
                break;
            }
            if (z10) {
                i15 = (i10 - i16) - 1;
            } else {
                i15 = i16;
            }
            float f11 = i15 * f10;
            if (!z10) {
                i18 = 1;
            }
            if (f11 * i18 > i12 - this.f22974g || i16 >= i10 - this.f22970c.size()) {
                Integer valueOf = Integer.valueOf(i15);
                List<b> list = this.f22970c;
                hashMap.put(valueOf, list.get(E.a.b(i17, 0, list.size() - 1)));
                i17++;
            }
            i16++;
        }
        int i19 = 0;
        for (int i20 = i10 - 1; i20 >= 0; i20--) {
            if (z10) {
                i13 = (i10 - i20) - 1;
            } else {
                i13 = i20;
            }
            float f12 = i13 * f10;
            if (z10) {
                i14 = -1;
            } else {
                i14 = 1;
            }
            if (f12 * i14 < i11 + this.f22973f || i20 < this.f22969b.size()) {
                Integer valueOf2 = Integer.valueOf(i13);
                List<b> list2 = this.f22969b;
                hashMap.put(valueOf2, list2.get(E.a.b(i19, 0, list2.size() - 1)));
                i19++;
            }
        }
        return hashMap;
    }

    public b j(float f10, float f11, float f12) {
        return k(f10, f11, f12, false);
    }

    public b k(float f10, float f11, float f12, boolean z10) {
        float b10;
        List<b> list;
        float[] fArr;
        float f13 = this.f22973f + f11;
        float f14 = f12 - this.f22974g;
        float f15 = l().a().f22966g;
        float f16 = h().h().f22967h;
        if (this.f22973f == f15) {
            f13 += f15;
        }
        if (this.f22974g == f16) {
            f14 -= f16;
        }
        if (f10 < f13) {
            b10 = C1001b.b(1.0f, 0.0f, f11, f13, f10);
            list = this.f22969b;
            fArr = this.f22971d;
        } else if (f10 > f14) {
            b10 = C1001b.b(0.0f, 1.0f, f14, f12, f10);
            list = this.f22970c;
            fArr = this.f22972e;
        } else {
            return this.f22968a;
        }
        if (z10) {
            return a(list, b10, fArr);
        }
        return s(list, b10, fArr);
    }

    public b l() {
        return this.f22969b.get(r1.size() - 1);
    }
}
