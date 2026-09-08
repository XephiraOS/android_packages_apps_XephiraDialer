package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.x.b {

    /* renamed from: b, reason: collision with root package name */
    public c[] f10944b;

    /* renamed from: c, reason: collision with root package name */
    public s f10945c;

    /* renamed from: d, reason: collision with root package name */
    public s f10946d;

    /* renamed from: e, reason: collision with root package name */
    public int f10947e;

    /* renamed from: f, reason: collision with root package name */
    public int f10948f;

    /* renamed from: g, reason: collision with root package name */
    public final n f10949g;

    /* renamed from: j, reason: collision with root package name */
    public BitSet f10952j;

    /* renamed from: o, reason: collision with root package name */
    public boolean f10957o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10958p;

    /* renamed from: q, reason: collision with root package name */
    public SavedState f10959q;

    /* renamed from: r, reason: collision with root package name */
    public int f10960r;

    /* renamed from: w, reason: collision with root package name */
    public int[] f10965w;

    /* renamed from: a, reason: collision with root package name */
    public int f10943a = -1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10950h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10951i = false;

    /* renamed from: k, reason: collision with root package name */
    public int f10953k = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f10954l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public LazySpanLookup f10955m = new LazySpanLookup();

    /* renamed from: n, reason: collision with root package name */
    public int f10956n = 2;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f10961s = new Rect();

    /* renamed from: t, reason: collision with root package name */
    public final b f10962t = new b();

    /* renamed from: u, reason: collision with root package name */
    public boolean f10963u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f10964v = true;

    /* renamed from: x, reason: collision with root package name */
    public final Runnable f10966x = new a();

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e, reason: collision with root package name */
        public c f10967e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f10968f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean e() {
            return this.f10968f;
        }

        public void f(boolean z10) {
            this.f10968f = z10;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f10975a;

        /* renamed from: b, reason: collision with root package name */
        public int f10976b;

        /* renamed from: c, reason: collision with root package name */
        public int f10977c;

        /* renamed from: d, reason: collision with root package name */
        public int[] f10978d;

        /* renamed from: e, reason: collision with root package name */
        public int f10979e;

        /* renamed from: f, reason: collision with root package name */
        public int[] f10980f;

        /* renamed from: g, reason: collision with root package name */
        public List<LazySpanLookup.FullSpanItem> f10981g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f10982h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f10983i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f10984j;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        public void b() {
            this.f10978d = null;
            this.f10977c = 0;
            this.f10975a = -1;
            this.f10976b = -1;
        }

        public void d() {
            this.f10978d = null;
            this.f10977c = 0;
            this.f10979e = 0;
            this.f10980f = null;
            this.f10981g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f10975a);
            parcel.writeInt(this.f10976b);
            parcel.writeInt(this.f10977c);
            if (this.f10977c > 0) {
                parcel.writeIntArray(this.f10978d);
            }
            parcel.writeInt(this.f10979e);
            if (this.f10979e > 0) {
                parcel.writeIntArray(this.f10980f);
            }
            parcel.writeInt(this.f10982h ? 1 : 0);
            parcel.writeInt(this.f10983i ? 1 : 0);
            parcel.writeInt(this.f10984j ? 1 : 0);
            parcel.writeList(this.f10981g);
        }

        public SavedState(Parcel parcel) {
            this.f10975a = parcel.readInt();
            this.f10976b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f10977c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f10978d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f10979e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f10980f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f10982h = parcel.readInt() == 1;
            this.f10983i = parcel.readInt() == 1;
            this.f10984j = parcel.readInt() == 1;
            this.f10981g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f10977c = savedState.f10977c;
            this.f10975a = savedState.f10975a;
            this.f10976b = savedState.f10976b;
            this.f10978d = savedState.f10978d;
            this.f10979e = savedState.f10979e;
            this.f10980f = savedState.f10980f;
            this.f10982h = savedState.f10982h;
            this.f10983i = savedState.f10983i;
            this.f10984j = savedState.f10984j;
            this.f10981g = savedState.f10981g;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.k();
        }
    }

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f10986a;

        /* renamed from: b, reason: collision with root package name */
        public int f10987b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f10988c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10989d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f10990e;

        /* renamed from: f, reason: collision with root package name */
        public int[] f10991f;

        public b() {
            c();
        }

        public void a() {
            int n10;
            if (this.f10988c) {
                n10 = StaggeredGridLayoutManager.this.f10945c.i();
            } else {
                n10 = StaggeredGridLayoutManager.this.f10945c.n();
            }
            this.f10987b = n10;
        }

        public void b(int i10) {
            if (this.f10988c) {
                this.f10987b = StaggeredGridLayoutManager.this.f10945c.i() - i10;
            } else {
                this.f10987b = StaggeredGridLayoutManager.this.f10945c.n() + i10;
            }
        }

        public void c() {
            this.f10986a = -1;
            this.f10987b = Integer.MIN_VALUE;
            this.f10988c = false;
            this.f10989d = false;
            this.f10990e = false;
            int[] iArr = this.f10991f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void d(c[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f10991f;
            if (iArr == null || iArr.length < length) {
                this.f10991f = new int[StaggeredGridLayoutManager.this.f10944b.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.f10991f[i10] = cVarArr[i10].p(Integer.MIN_VALUE);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<View> f10993a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        public int f10994b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        public int f10995c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        public int f10996d = 0;

        /* renamed from: e, reason: collision with root package name */
        public final int f10997e;

        public c(int i10) {
            this.f10997e = i10;
        }

        public void a(View view) {
            LayoutParams n10 = n(view);
            n10.f10967e = this;
            this.f10993a.add(view);
            this.f10995c = Integer.MIN_VALUE;
            if (this.f10993a.size() == 1) {
                this.f10994b = Integer.MIN_VALUE;
            }
            if (n10.c() || n10.b()) {
                this.f10996d += StaggeredGridLayoutManager.this.f10945c.e(view);
            }
        }

        public void b(boolean z10, int i10) {
            int p10;
            if (z10) {
                p10 = l(Integer.MIN_VALUE);
            } else {
                p10 = p(Integer.MIN_VALUE);
            }
            e();
            if (p10 == Integer.MIN_VALUE) {
                return;
            }
            if (!z10 || p10 >= StaggeredGridLayoutManager.this.f10945c.i()) {
                if (!z10 && p10 > StaggeredGridLayoutManager.this.f10945c.n()) {
                    return;
                }
                if (i10 != Integer.MIN_VALUE) {
                    p10 += i10;
                }
                this.f10995c = p10;
                this.f10994b = p10;
            }
        }

        public void c() {
            LazySpanLookup.FullSpanItem f10;
            ArrayList<View> arrayList = this.f10993a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams n10 = n(view);
            this.f10995c = StaggeredGridLayoutManager.this.f10945c.d(view);
            if (n10.f10968f && (f10 = StaggeredGridLayoutManager.this.f10955m.f(n10.a())) != null && f10.f10972b == 1) {
                this.f10995c += f10.b(this.f10997e);
            }
        }

        public void d() {
            LazySpanLookup.FullSpanItem f10;
            View view = this.f10993a.get(0);
            LayoutParams n10 = n(view);
            this.f10994b = StaggeredGridLayoutManager.this.f10945c.g(view);
            if (n10.f10968f && (f10 = StaggeredGridLayoutManager.this.f10955m.f(n10.a())) != null && f10.f10972b == -1) {
                this.f10994b -= f10.b(this.f10997e);
            }
        }

        public void e() {
            this.f10993a.clear();
            q();
            this.f10996d = 0;
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.f10950h) {
                return i(this.f10993a.size() - 1, -1, true);
            }
            return i(0, this.f10993a.size(), true);
        }

        public int g() {
            if (StaggeredGridLayoutManager.this.f10950h) {
                return i(0, this.f10993a.size(), true);
            }
            return i(this.f10993a.size() - 1, -1, true);
        }

        public int h(int i10, int i11, boolean z10, boolean z11, boolean z12) {
            int i12;
            boolean z13;
            int n10 = StaggeredGridLayoutManager.this.f10945c.n();
            int i13 = StaggeredGridLayoutManager.this.f10945c.i();
            if (i11 > i10) {
                i12 = 1;
            } else {
                i12 = -1;
            }
            while (i10 != i11) {
                View view = this.f10993a.get(i10);
                int g10 = StaggeredGridLayoutManager.this.f10945c.g(view);
                int d10 = StaggeredGridLayoutManager.this.f10945c.d(view);
                boolean z14 = false;
                if (!z12 ? g10 < i13 : g10 <= i13) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!z12 ? d10 > n10 : d10 >= n10) {
                    z14 = true;
                }
                if (z13 && z14) {
                    if (z10 && z11) {
                        if (g10 >= n10 && d10 <= i13) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z11) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (g10 < n10 || d10 > i13) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i10 += i12;
            }
            return -1;
        }

        public int i(int i10, int i11, boolean z10) {
            return h(i10, i11, false, false, z10);
        }

        public int j() {
            return this.f10996d;
        }

        public int k() {
            int i10 = this.f10995c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            c();
            return this.f10995c;
        }

        public int l(int i10) {
            int i11 = this.f10995c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f10993a.size() == 0) {
                return i10;
            }
            c();
            return this.f10995c;
        }

        public View m(int i10, int i11) {
            View view = null;
            if (i11 == -1) {
                int size = this.f10993a.size();
                int i12 = 0;
                while (i12 < size) {
                    View view2 = this.f10993a.get(i12);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f10950h && staggeredGridLayoutManager.getPosition(view2) <= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f10950h && staggeredGridLayoutManager2.getPosition(view2) >= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    i12++;
                    view = view2;
                }
            } else {
                int size2 = this.f10993a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f10993a.get(size2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f10950h && staggeredGridLayoutManager3.getPosition(view3) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f10950h && staggeredGridLayoutManager4.getPosition(view3) <= i10) || !view3.hasFocusable()) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }

        public LayoutParams n(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        public int o() {
            int i10 = this.f10994b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            d();
            return this.f10994b;
        }

        public int p(int i10) {
            int i11 = this.f10994b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f10993a.size() == 0) {
                return i10;
            }
            d();
            return this.f10994b;
        }

        public void q() {
            this.f10994b = Integer.MIN_VALUE;
            this.f10995c = Integer.MIN_VALUE;
        }

        public void r(int i10) {
            int i11 = this.f10994b;
            if (i11 != Integer.MIN_VALUE) {
                this.f10994b = i11 + i10;
            }
            int i12 = this.f10995c;
            if (i12 != Integer.MIN_VALUE) {
                this.f10995c = i12 + i10;
            }
        }

        public void s() {
            int size = this.f10993a.size();
            View remove = this.f10993a.remove(size - 1);
            LayoutParams n10 = n(remove);
            n10.f10967e = null;
            if (n10.c() || n10.b()) {
                this.f10996d -= StaggeredGridLayoutManager.this.f10945c.e(remove);
            }
            if (size == 1) {
                this.f10994b = Integer.MIN_VALUE;
            }
            this.f10995c = Integer.MIN_VALUE;
        }

        public void t() {
            View remove = this.f10993a.remove(0);
            LayoutParams n10 = n(remove);
            n10.f10967e = null;
            if (this.f10993a.size() == 0) {
                this.f10995c = Integer.MIN_VALUE;
            }
            if (n10.c() || n10.b()) {
                this.f10996d -= StaggeredGridLayoutManager.this.f10945c.e(remove);
            }
            this.f10994b = Integer.MIN_VALUE;
        }

        public void u(View view) {
            LayoutParams n10 = n(view);
            n10.f10967e = this;
            this.f10993a.add(0, view);
            this.f10994b = Integer.MIN_VALUE;
            if (this.f10993a.size() == 1) {
                this.f10995c = Integer.MIN_VALUE;
            }
            if (n10.c() || n10.b()) {
                this.f10996d += StaggeredGridLayoutManager.this.f10945c.e(view);
            }
        }

        public void v(int i10) {
            this.f10994b = i10;
            this.f10995c = i10;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.f10900a);
        S(properties.f10901b);
        setReverseLayout(properties.f10902c);
        this.f10949g = new n();
        o();
    }

    private void H(View view, int i10, int i11, boolean z10) {
        boolean shouldMeasureChild;
        calculateItemDecorationsForChild(view, this.f10961s);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.f10961s;
        int a02 = a0(i10, i12 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.f10961s;
        int a03 = a0(i11, i13 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z10) {
            shouldMeasureChild = shouldReMeasureChild(view, a02, a03, layoutParams);
        } else {
            shouldMeasureChild = shouldMeasureChild(view, a02, a03, layoutParams);
        }
        if (shouldMeasureChild) {
            view.measure(a02, a03);
        }
    }

    private int convertFocusDirectionToLayoutDirection(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 17) {
                    if (i10 != 33) {
                        if (i10 != 66) {
                            if (i10 == 130 && this.f10947e == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        }
                        if (this.f10947e == 0) {
                            return 1;
                        }
                        return Integer.MIN_VALUE;
                    }
                    if (this.f10947e == 1) {
                        return -1;
                    }
                    return Integer.MIN_VALUE;
                }
                if (this.f10947e == 0) {
                    return -1;
                }
                return Integer.MIN_VALUE;
            }
            if (this.f10947e != 1 && isLayoutRTL()) {
                return -1;
            }
            return 1;
        }
        if (this.f10947e == 1 || !isLayoutRTL()) {
            return -1;
        }
        return 1;
    }

    public final int A(int i10) {
        int p10 = this.f10944b[0].p(i10);
        for (int i11 = 1; i11 < this.f10943a; i11++) {
            int p11 = this.f10944b[i11].p(i10);
            if (p11 > p10) {
                p10 = p11;
            }
        }
        return p10;
    }

    public final int B(int i10) {
        int l10 = this.f10944b[0].l(i10);
        for (int i11 = 1; i11 < this.f10943a; i11++) {
            int l11 = this.f10944b[i11].l(i10);
            if (l11 < l10) {
                l10 = l11;
            }
        }
        return l10;
    }

    public final int C(int i10) {
        int p10 = this.f10944b[0].p(i10);
        for (int i11 = 1; i11 < this.f10943a; i11++) {
            int p11 = this.f10944b[i11].p(i10);
            if (p11 < p10) {
                p10 = p11;
            }
        }
        return p10;
    }

    public final c D(n nVar) {
        int i10;
        int i11;
        int i12;
        if (K(nVar.f11193e)) {
            i11 = this.f10943a - 1;
            i10 = -1;
            i12 = -1;
        } else {
            i10 = this.f10943a;
            i11 = 0;
            i12 = 1;
        }
        c cVar = null;
        if (nVar.f11193e == 1) {
            int n10 = this.f10945c.n();
            int i13 = Integer.MAX_VALUE;
            while (i11 != i10) {
                c cVar2 = this.f10944b[i11];
                int l10 = cVar2.l(n10);
                if (l10 < i13) {
                    cVar = cVar2;
                    i13 = l10;
                }
                i11 += i12;
            }
            return cVar;
        }
        int i14 = this.f10945c.i();
        int i15 = Integer.MIN_VALUE;
        while (i11 != i10) {
            c cVar3 = this.f10944b[i11];
            int p10 = cVar3.p(i14);
            if (p10 > i15) {
                cVar = cVar3;
                i15 = p10;
            }
            i11 += i12;
        }
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f10951i
            if (r0 == 0) goto L9
            int r0 = r6.y()
            goto Ld
        L9:
            int r0 = r6.x()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L17
            int r2 = r8 + 1
        L15:
            r3 = r7
            goto L1e
        L17:
            int r2 = r7 + 1
            r3 = r8
            goto L1e
        L1b:
            int r2 = r7 + r8
            goto L15
        L1e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.f10955m
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3d
            r5 = 2
            if (r9 == r5) goto L37
            if (r9 == r1) goto L2c
            goto L42
        L2c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f10955m
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.f10955m
            r7.j(r8, r4)
            goto L42
        L37:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f10955m
            r9.k(r7, r8)
            goto L42
        L3d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f10955m
            r9.j(r7, r8)
        L42:
            if (r2 > r0) goto L45
            return
        L45:
            boolean r7 = r6.f10951i
            if (r7 == 0) goto L4e
            int r7 = r6.x()
            goto L52
        L4e:
            int r7 = r6.y()
        L52:
            if (r3 > r7) goto L57
            r6.requestLayout()
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.E(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View F() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            int r1 = r0 + (-1)
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f10943a
            r2.<init>(r3)
            int r3 = r12.f10943a
            r4 = 0
            r5 = 1
            r2.set(r4, r3, r5)
            int r3 = r12.f10947e
            r6 = -1
            if (r3 != r5) goto L21
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L21
            r3 = r5
            goto L22
        L21:
            r3 = r6
        L22:
            boolean r7 = r12.f10951i
            if (r7 == 0) goto L28
            r0 = r6
            goto L29
        L28:
            r1 = r4
        L29:
            if (r1 >= r0) goto L2c
            r6 = r5
        L2c:
            if (r1 == r0) goto La4
            android.view.View r7 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f10967e
            int r9 = r9.f10997e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L52
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f10967e
            boolean r9 = r12.l(r9)
            if (r9 == 0) goto L4b
            return r7
        L4b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f10967e
            int r9 = r9.f10997e
            r2.clear(r9)
        L52:
            boolean r9 = r8.f10968f
            if (r9 == 0) goto L57
            goto La2
        L57:
            int r9 = r1 + r6
            if (r9 == r0) goto La2
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.f10951i
            if (r10 == 0) goto L75
            androidx.recyclerview.widget.s r10 = r12.f10945c
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.s r11 = r12.f10945c
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L72
            return r7
        L72:
            if (r10 != r11) goto La2
            goto L86
        L75:
            androidx.recyclerview.widget.s r10 = r12.f10945c
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.s r11 = r12.f10945c
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L84
            return r7
        L84:
            if (r10 != r11) goto La2
        L86:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r8.f10967e
            int r8 = r8.f10997e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r9.f10967e
            int r9 = r9.f10997e
            int r8 = r8 - r9
            if (r8 >= 0) goto L99
            r8 = r5
            goto L9a
        L99:
            r8 = r4
        L9a:
            if (r3 >= 0) goto L9e
            r9 = r5
            goto L9f
        L9e:
            r9 = r4
        L9f:
            if (r8 == r9) goto La2
            return r7
        La2:
            int r1 = r1 + r6
            goto L2c
        La4:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.F():android.view.View");
    }

    public void G() {
        this.f10955m.b();
        requestLayout();
    }

    public final void I(View view, LayoutParams layoutParams, boolean z10) {
        if (layoutParams.f10968f) {
            if (this.f10947e == 1) {
                H(view, this.f10960r, RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z10);
                return;
            } else {
                H(view, RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.f10960r, z10);
                return;
            }
        }
        if (this.f10947e == 1) {
            H(view, RecyclerView.o.getChildMeasureSpec(this.f10948f, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z10);
        } else {
            H(view, RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.o.getChildMeasureSpec(this.f10948f, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0152, code lost:
    
        if (k() != false) goto L87;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J(androidx.recyclerview.widget.RecyclerView.u r9, androidx.recyclerview.widget.RecyclerView.y r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.J(androidx.recyclerview.widget.RecyclerView$u, androidx.recyclerview.widget.RecyclerView$y, boolean):void");
    }

    public final boolean K(int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        if (this.f10947e == 0) {
            if (i10 == -1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12 == this.f10951i) {
                return false;
            }
            return true;
        }
        if (i10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 == this.f10951i) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 != isLayoutRTL()) {
            return false;
        }
        return true;
    }

    public void L(int i10, RecyclerView.y yVar) {
        int x10;
        int i11;
        if (i10 > 0) {
            x10 = y();
            i11 = 1;
        } else {
            x10 = x();
            i11 = -1;
        }
        this.f10949g.f11189a = true;
        X(x10, yVar);
        R(i11);
        n nVar = this.f10949g;
        nVar.f11191c = x10 + nVar.f11192d;
        nVar.f11190b = Math.abs(i10);
    }

    public final void M(View view) {
        for (int i10 = this.f10943a - 1; i10 >= 0; i10--) {
            this.f10944b[i10].u(view);
        }
    }

    public final void N(RecyclerView.u uVar, n nVar) {
        int min;
        int min2;
        if (nVar.f11189a && !nVar.f11197i) {
            if (nVar.f11190b == 0) {
                if (nVar.f11193e == -1) {
                    O(uVar, nVar.f11195g);
                    return;
                } else {
                    P(uVar, nVar.f11194f);
                    return;
                }
            }
            if (nVar.f11193e == -1) {
                int i10 = nVar.f11194f;
                int A10 = i10 - A(i10);
                if (A10 < 0) {
                    min2 = nVar.f11195g;
                } else {
                    min2 = nVar.f11195g - Math.min(A10, nVar.f11190b);
                }
                O(uVar, min2);
                return;
            }
            int B10 = B(nVar.f11195g) - nVar.f11195g;
            if (B10 < 0) {
                min = nVar.f11194f;
            } else {
                min = Math.min(B10, nVar.f11190b) + nVar.f11194f;
            }
            P(uVar, min);
        }
    }

    public final void O(RecyclerView.u uVar, int i10) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f10945c.g(childAt) >= i10 && this.f10945c.r(childAt) >= i10) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f10968f) {
                    for (int i11 = 0; i11 < this.f10943a; i11++) {
                        if (this.f10944b[i11].f10993a.size() == 1) {
                            return;
                        }
                    }
                    for (int i12 = 0; i12 < this.f10943a; i12++) {
                        this.f10944b[i12].s();
                    }
                } else if (layoutParams.f10967e.f10993a.size() == 1) {
                    return;
                } else {
                    layoutParams.f10967e.s();
                }
                removeAndRecycleView(childAt, uVar);
            } else {
                return;
            }
        }
    }

    public final void P(RecyclerView.u uVar, int i10) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f10945c.d(childAt) <= i10 && this.f10945c.q(childAt) <= i10) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f10968f) {
                    for (int i11 = 0; i11 < this.f10943a; i11++) {
                        if (this.f10944b[i11].f10993a.size() == 1) {
                            return;
                        }
                    }
                    for (int i12 = 0; i12 < this.f10943a; i12++) {
                        this.f10944b[i12].t();
                    }
                } else if (layoutParams.f10967e.f10993a.size() == 1) {
                    return;
                } else {
                    layoutParams.f10967e.t();
                }
                removeAndRecycleView(childAt, uVar);
            } else {
                return;
            }
        }
    }

    public final void Q() {
        if (this.f10946d.l() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            float e10 = this.f10946d.e(childAt);
            if (e10 >= f10) {
                if (((LayoutParams) childAt.getLayoutParams()).e()) {
                    e10 = (e10 * 1.0f) / this.f10943a;
                }
                f10 = Math.max(f10, e10);
            }
        }
        int i11 = this.f10948f;
        int round = Math.round(f10 * this.f10943a);
        if (this.f10946d.l() == Integer.MIN_VALUE) {
            round = Math.min(round, this.f10946d.o());
        }
        Y(round);
        if (this.f10948f == i11) {
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (!layoutParams.f10968f) {
                if (isLayoutRTL() && this.f10947e == 1) {
                    int i13 = this.f10943a;
                    int i14 = layoutParams.f10967e.f10997e;
                    childAt2.offsetLeftAndRight(((-((i13 - 1) - i14)) * this.f10948f) - ((-((i13 - 1) - i14)) * i11));
                } else {
                    int i15 = layoutParams.f10967e.f10997e;
                    int i16 = this.f10948f * i15;
                    int i17 = i15 * i11;
                    if (this.f10947e == 1) {
                        childAt2.offsetLeftAndRight(i16 - i17);
                    } else {
                        childAt2.offsetTopAndBottom(i16 - i17);
                    }
                }
            }
        }
    }

    public final void R(int i10) {
        boolean z10;
        n nVar = this.f10949g;
        nVar.f11193e = i10;
        boolean z11 = this.f10951i;
        int i11 = 1;
        if (i10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z11 != z10) {
            i11 = -1;
        }
        nVar.f11192d = i11;
    }

    public void S(int i10) {
        assertNotInLayoutOrScroll(null);
        if (i10 != this.f10943a) {
            G();
            this.f10943a = i10;
            this.f10952j = new BitSet(this.f10943a);
            this.f10944b = new c[this.f10943a];
            for (int i11 = 0; i11 < this.f10943a; i11++) {
                this.f10944b[i11] = new c(i11);
            }
            requestLayout();
        }
    }

    public final void T(int i10, int i11) {
        for (int i12 = 0; i12 < this.f10943a; i12++) {
            if (!this.f10944b[i12].f10993a.isEmpty()) {
                Z(this.f10944b[i12], i10, i11);
            }
        }
    }

    public final boolean U(RecyclerView.y yVar, b bVar) {
        int q10;
        if (this.f10957o) {
            q10 = u(yVar.b());
        } else {
            q10 = q(yVar.b());
        }
        bVar.f10986a = q10;
        bVar.f10987b = Integer.MIN_VALUE;
        return true;
    }

    public boolean V(RecyclerView.y yVar, b bVar) {
        int i10;
        int x10;
        int n10;
        boolean z10 = false;
        if (!yVar.e() && (i10 = this.f10953k) != -1) {
            if (i10 >= 0 && i10 < yVar.b()) {
                SavedState savedState = this.f10959q;
                if (savedState != null && savedState.f10975a != -1 && savedState.f10977c >= 1) {
                    bVar.f10987b = Integer.MIN_VALUE;
                    bVar.f10986a = this.f10953k;
                } else {
                    View findViewByPosition = findViewByPosition(this.f10953k);
                    if (findViewByPosition != null) {
                        if (this.f10951i) {
                            x10 = y();
                        } else {
                            x10 = x();
                        }
                        bVar.f10986a = x10;
                        if (this.f10954l != Integer.MIN_VALUE) {
                            if (bVar.f10988c) {
                                bVar.f10987b = (this.f10945c.i() - this.f10954l) - this.f10945c.d(findViewByPosition);
                            } else {
                                bVar.f10987b = (this.f10945c.n() + this.f10954l) - this.f10945c.g(findViewByPosition);
                            }
                            return true;
                        }
                        if (this.f10945c.e(findViewByPosition) > this.f10945c.o()) {
                            if (bVar.f10988c) {
                                n10 = this.f10945c.i();
                            } else {
                                n10 = this.f10945c.n();
                            }
                            bVar.f10987b = n10;
                            return true;
                        }
                        int g10 = this.f10945c.g(findViewByPosition) - this.f10945c.n();
                        if (g10 < 0) {
                            bVar.f10987b = -g10;
                            return true;
                        }
                        int i11 = this.f10945c.i() - this.f10945c.d(findViewByPosition);
                        if (i11 < 0) {
                            bVar.f10987b = i11;
                            return true;
                        }
                        bVar.f10987b = Integer.MIN_VALUE;
                    } else {
                        int i12 = this.f10953k;
                        bVar.f10986a = i12;
                        int i13 = this.f10954l;
                        if (i13 == Integer.MIN_VALUE) {
                            if (j(i12) == 1) {
                                z10 = true;
                            }
                            bVar.f10988c = z10;
                            bVar.a();
                        } else {
                            bVar.b(i13);
                        }
                        bVar.f10989d = true;
                    }
                }
                return true;
            }
            this.f10953k = -1;
            this.f10954l = Integer.MIN_VALUE;
        }
        return false;
    }

    public void W(RecyclerView.y yVar, b bVar) {
        if (V(yVar, bVar) || U(yVar, bVar)) {
            return;
        }
        bVar.a();
        bVar.f10986a = 0;
    }

    public final void X(int i10, RecyclerView.y yVar) {
        int i11;
        int i12;
        int c10;
        boolean z10;
        n nVar = this.f10949g;
        boolean z11 = false;
        nVar.f11190b = 0;
        nVar.f11191c = i10;
        if (isSmoothScrolling() && (c10 = yVar.c()) != -1) {
            boolean z12 = this.f10951i;
            if (c10 < i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z12 == z10) {
                i11 = this.f10945c.o();
                i12 = 0;
            } else {
                i12 = this.f10945c.o();
                i11 = 0;
            }
        } else {
            i11 = 0;
            i12 = 0;
        }
        if (getClipToPadding()) {
            this.f10949g.f11194f = this.f10945c.n() - i12;
            this.f10949g.f11195g = this.f10945c.i() + i11;
        } else {
            this.f10949g.f11195g = this.f10945c.h() + i11;
            this.f10949g.f11194f = -i12;
        }
        n nVar2 = this.f10949g;
        nVar2.f11196h = false;
        nVar2.f11189a = true;
        if (this.f10945c.l() == 0 && this.f10945c.h() == 0) {
            z11 = true;
        }
        nVar2.f11197i = z11;
    }

    public void Y(int i10) {
        this.f10948f = i10 / this.f10943a;
        this.f10960r = View.MeasureSpec.makeMeasureSpec(i10, this.f10946d.l());
    }

    public final void Z(c cVar, int i10, int i11) {
        int j10 = cVar.j();
        if (i10 == -1) {
            if (cVar.o() + j10 <= i11) {
                this.f10952j.set(cVar.f10997e, false);
            }
        } else if (cVar.k() - j10 >= i11) {
            this.f10952j.set(cVar.f10997e, false);
        }
    }

    public final int a0(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            return i10;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void assertNotInLayoutOrScroll(String str) {
        if (this.f10959q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollHorizontally() {
        if (this.f10947e == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollVertically() {
        if (this.f10947e == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.y yVar, RecyclerView.o.c cVar) {
        int l10;
        int i12;
        if (this.f10947e != 0) {
            i10 = i11;
        }
        if (getChildCount() != 0 && i10 != 0) {
            L(i10, yVar);
            int[] iArr = this.f10965w;
            if (iArr == null || iArr.length < this.f10943a) {
                this.f10965w = new int[this.f10943a];
            }
            int i13 = 0;
            for (int i14 = 0; i14 < this.f10943a; i14++) {
                n nVar = this.f10949g;
                if (nVar.f11192d == -1) {
                    l10 = nVar.f11194f;
                    i12 = this.f10944b[i14].p(l10);
                } else {
                    l10 = this.f10944b[i14].l(nVar.f11195g);
                    i12 = this.f10949g.f11195g;
                }
                int i15 = l10 - i12;
                if (i15 >= 0) {
                    this.f10965w[i13] = i15;
                    i13++;
                }
            }
            Arrays.sort(this.f10965w, 0, i13);
            for (int i16 = 0; i16 < i13 && this.f10949g.a(yVar); i16++) {
                cVar.a(this.f10949g.f11191c, this.f10965w[i16]);
                n nVar2 = this.f10949g;
                nVar2.f11191c += nVar2.f11192d;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollExtent(RecyclerView.y yVar) {
        return computeScrollExtent(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.y yVar) {
        return computeScrollOffset(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.y yVar) {
        return computeScrollRange(yVar);
    }

    public final int computeScrollExtent(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return v.a(yVar, this.f10945c, s(!this.f10964v), r(!this.f10964v), this, this.f10964v);
    }

    public final int computeScrollOffset(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return v.b(yVar, this.f10945c, s(!this.f10964v), r(!this.f10964v), this, this.f10964v, this.f10951i);
    }

    public final int computeScrollRange(RecyclerView.y yVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return v.c(yVar, this.f10945c, s(!this.f10964v), r(!this.f10964v), this, this.f10964v);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x.b
    public PointF computeScrollVectorForPosition(int i10) {
        int j10 = j(i10);
        PointF pointF = new PointF();
        if (j10 == 0) {
            return null;
        }
        if (this.f10947e == 0) {
            pointF.x = j10;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = j10;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollExtent(RecyclerView.y yVar) {
        return computeScrollExtent(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.y yVar) {
        return computeScrollOffset(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.y yVar) {
        return computeScrollRange(yVar);
    }

    public final void e(View view) {
        for (int i10 = this.f10943a - 1; i10 >= 0; i10--) {
            this.f10944b[i10].a(view);
        }
    }

    public final void f(b bVar) {
        int n10;
        SavedState savedState = this.f10959q;
        int i10 = savedState.f10977c;
        if (i10 > 0) {
            if (i10 == this.f10943a) {
                for (int i11 = 0; i11 < this.f10943a; i11++) {
                    this.f10944b[i11].e();
                    SavedState savedState2 = this.f10959q;
                    int i12 = savedState2.f10978d[i11];
                    if (i12 != Integer.MIN_VALUE) {
                        if (savedState2.f10983i) {
                            n10 = this.f10945c.i();
                        } else {
                            n10 = this.f10945c.n();
                        }
                        i12 += n10;
                    }
                    this.f10944b[i11].v(i12);
                }
            } else {
                savedState.d();
                SavedState savedState3 = this.f10959q;
                savedState3.f10975a = savedState3.f10976b;
            }
        }
        SavedState savedState4 = this.f10959q;
        this.f10958p = savedState4.f10984j;
        setReverseLayout(savedState4.f10982h);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.f10959q;
        int i13 = savedState5.f10975a;
        if (i13 != -1) {
            this.f10953k = i13;
            bVar.f10988c = savedState5.f10983i;
        } else {
            bVar.f10988c = this.f10951i;
        }
        if (savedState5.f10979e > 1) {
            LazySpanLookup lazySpanLookup = this.f10955m;
            lazySpanLookup.f10969a = savedState5.f10980f;
            lazySpanLookup.f10970b = savedState5.f10981g;
        }
    }

    public boolean g() {
        int l10 = this.f10944b[0].l(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f10943a; i10++) {
            if (this.f10944b[i10].l(Integer.MIN_VALUE) != l10) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.f10947e == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public boolean h() {
        int p10 = this.f10944b[0].p(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f10943a; i10++) {
            if (this.f10944b[i10].p(Integer.MIN_VALUE) != p10) {
                return false;
            }
        }
        return true;
    }

    public final void i(View view, LayoutParams layoutParams, n nVar) {
        if (nVar.f11193e == 1) {
            if (layoutParams.f10968f) {
                e(view);
                return;
            } else {
                layoutParams.f10967e.a(view);
                return;
            }
        }
        if (layoutParams.f10968f) {
            M(view);
        } else {
            layoutParams.f10967e.u(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean isAutoMeasureEnabled() {
        if (this.f10956n != 0) {
            return true;
        }
        return false;
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public final int j(int i10) {
        boolean z10;
        if (getChildCount() == 0) {
            if (!this.f10951i) {
                return -1;
            }
            return 1;
        }
        if (i10 < x()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 != this.f10951i) {
            return -1;
        }
        return 1;
    }

    public boolean k() {
        int x10;
        int y10;
        int i10;
        if (getChildCount() == 0 || this.f10956n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f10951i) {
            x10 = y();
            y10 = x();
        } else {
            x10 = x();
            y10 = y();
        }
        if (x10 == 0 && F() != null) {
            this.f10955m.b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.f10963u) {
            return false;
        }
        if (this.f10951i) {
            i10 = -1;
        } else {
            i10 = 1;
        }
        int i11 = y10 + 1;
        LazySpanLookup.FullSpanItem e10 = this.f10955m.e(x10, i11, i10, true);
        if (e10 == null) {
            this.f10963u = false;
            this.f10955m.d(i11);
            return false;
        }
        LazySpanLookup.FullSpanItem e11 = this.f10955m.e(x10, e10.f10971a, i10 * (-1), true);
        if (e11 == null) {
            this.f10955m.d(e10.f10971a);
        } else {
            this.f10955m.d(e11.f10971a + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    public final boolean l(c cVar) {
        if (this.f10951i) {
            if (cVar.k() < this.f10945c.i()) {
                ArrayList<View> arrayList = cVar.f10993a;
                return !cVar.n(arrayList.get(arrayList.size() - 1)).f10968f;
            }
        } else if (cVar.o() > this.f10945c.n()) {
            return !cVar.n(cVar.f10993a.get(0)).f10968f;
        }
        return false;
    }

    public final LazySpanLookup.FullSpanItem m(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f10973c = new int[this.f10943a];
        for (int i11 = 0; i11 < this.f10943a; i11++) {
            fullSpanItem.f10973c[i11] = i10 - this.f10944b[i11].l(i10);
        }
        return fullSpanItem;
    }

    public final LazySpanLookup.FullSpanItem n(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f10973c = new int[this.f10943a];
        for (int i11 = 0; i11 < this.f10943a; i11++) {
            fullSpanItem.f10973c[i11] = this.f10944b[i11].p(i10) - i10;
        }
        return fullSpanItem;
    }

    public final void o() {
        this.f10945c = s.b(this, this.f10947e);
        this.f10946d = s.b(this, 1 - this.f10947e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void offsetChildrenHorizontal(int i10) {
        super.offsetChildrenHorizontal(i10);
        for (int i11 = 0; i11 < this.f10943a; i11++) {
            this.f10944b[i11].r(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void offsetChildrenVertical(int i10) {
        super.offsetChildrenVertical(i10);
        for (int i11 = 0; i11 < this.f10943a; i11++) {
            this.f10944b[i11].r(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.f10955m.b();
        for (int i10 = 0; i10 < this.f10943a; i10++) {
            this.f10944b[i10].e();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.u uVar) {
        super.onDetachedFromWindow(recyclerView, uVar);
        removeCallbacks(this.f10966x);
        for (int i10 = 0; i10 < this.f10943a; i10++) {
            this.f10944b[i10].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View onFocusSearchFailed(View view, int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        View findContainingItemView;
        int x10;
        boolean z10;
        boolean z11;
        int g10;
        int g11;
        int g12;
        View m10;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z12 = layoutParams.f10968f;
        c cVar = layoutParams.f10967e;
        if (convertFocusDirectionToLayoutDirection == 1) {
            x10 = y();
        } else {
            x10 = x();
        }
        X(x10, yVar);
        R(convertFocusDirectionToLayoutDirection);
        n nVar = this.f10949g;
        nVar.f11191c = nVar.f11192d + x10;
        nVar.f11190b = (int) (this.f10945c.o() * 0.33333334f);
        n nVar2 = this.f10949g;
        nVar2.f11196h = true;
        nVar2.f11189a = false;
        p(uVar, nVar2, yVar);
        this.f10957o = this.f10951i;
        if (!z12 && (m10 = cVar.m(x10, convertFocusDirectionToLayoutDirection)) != null && m10 != findContainingItemView) {
            return m10;
        }
        if (K(convertFocusDirectionToLayoutDirection)) {
            for (int i11 = this.f10943a - 1; i11 >= 0; i11--) {
                View m11 = this.f10944b[i11].m(x10, convertFocusDirectionToLayoutDirection);
                if (m11 != null && m11 != findContainingItemView) {
                    return m11;
                }
            }
        } else {
            for (int i12 = 0; i12 < this.f10943a; i12++) {
                View m12 = this.f10944b[i12].m(x10, convertFocusDirectionToLayoutDirection);
                if (m12 != null && m12 != findContainingItemView) {
                    return m12;
                }
            }
        }
        boolean z13 = !this.f10950h;
        if (convertFocusDirectionToLayoutDirection == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z13 == z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z12) {
            if (z11) {
                g12 = cVar.f();
            } else {
                g12 = cVar.g();
            }
            View findViewByPosition = findViewByPosition(g12);
            if (findViewByPosition != null && findViewByPosition != findContainingItemView) {
                return findViewByPosition;
            }
        }
        if (K(convertFocusDirectionToLayoutDirection)) {
            for (int i13 = this.f10943a - 1; i13 >= 0; i13--) {
                if (i13 != cVar.f10997e) {
                    if (z11) {
                        g11 = this.f10944b[i13].f();
                    } else {
                        g11 = this.f10944b[i13].g();
                    }
                    View findViewByPosition2 = findViewByPosition(g11);
                    if (findViewByPosition2 != null && findViewByPosition2 != findContainingItemView) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i14 = 0; i14 < this.f10943a; i14++) {
                if (z11) {
                    g10 = this.f10944b[i14].f();
                } else {
                    g10 = this.f10944b[i14].g();
                }
                View findViewByPosition3 = findViewByPosition(g10);
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View s10 = s(false);
            View r10 = r(false);
            if (s10 != null && r10 != null) {
                int position = getPosition(s10);
                int position2 = getPosition(r10);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                } else {
                    accessibilityEvent.setFromIndex(position2);
                    accessibilityEvent.setToIndex(position);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        E(i10, i11, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f10955m.b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        E(i10, i11, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        E(i10, i11, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        E(i10, i11, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.u uVar, RecyclerView.y yVar) {
        J(uVar, yVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.y yVar) {
        super.onLayoutCompleted(yVar);
        this.f10953k = -1;
        this.f10954l = Integer.MIN_VALUE;
        this.f10959q = null;
        this.f10962t.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f10959q = savedState;
            if (this.f10953k != -1) {
                savedState.b();
                this.f10959q.d();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable onSaveInstanceState() {
        int x10;
        int p10;
        int n10;
        int[] iArr;
        if (this.f10959q != null) {
            return new SavedState(this.f10959q);
        }
        SavedState savedState = new SavedState();
        savedState.f10982h = this.f10950h;
        savedState.f10983i = this.f10957o;
        savedState.f10984j = this.f10958p;
        LazySpanLookup lazySpanLookup = this.f10955m;
        if (lazySpanLookup != null && (iArr = lazySpanLookup.f10969a) != null) {
            savedState.f10980f = iArr;
            savedState.f10979e = iArr.length;
            savedState.f10981g = lazySpanLookup.f10970b;
        } else {
            savedState.f10979e = 0;
        }
        if (getChildCount() > 0) {
            if (this.f10957o) {
                x10 = y();
            } else {
                x10 = x();
            }
            savedState.f10975a = x10;
            savedState.f10976b = t();
            int i10 = this.f10943a;
            savedState.f10977c = i10;
            savedState.f10978d = new int[i10];
            for (int i11 = 0; i11 < this.f10943a; i11++) {
                if (this.f10957o) {
                    p10 = this.f10944b[i11].l(Integer.MIN_VALUE);
                    if (p10 != Integer.MIN_VALUE) {
                        n10 = this.f10945c.i();
                        p10 -= n10;
                        savedState.f10978d[i11] = p10;
                    } else {
                        savedState.f10978d[i11] = p10;
                    }
                } else {
                    p10 = this.f10944b[i11].p(Integer.MIN_VALUE);
                    if (p10 != Integer.MIN_VALUE) {
                        n10 = this.f10945c.n();
                        p10 -= n10;
                        savedState.f10978d[i11] = p10;
                    } else {
                        savedState.f10978d[i11] = p10;
                    }
                }
            }
        } else {
            savedState.f10975a = -1;
            savedState.f10976b = -1;
            savedState.f10977c = 0;
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onScrollStateChanged(int i10) {
        if (i10 == 0) {
            k();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    public final int p(RecyclerView.u uVar, n nVar, RecyclerView.y yVar) {
        int i10;
        int n10;
        int z10;
        boolean z11;
        c cVar;
        int p10;
        int e10;
        int i11;
        int n11;
        int i12;
        int e11;
        boolean z12;
        int i13;
        boolean h10;
        int l10;
        ?? r92 = 0;
        this.f10952j.set(0, this.f10943a, true);
        if (this.f10949g.f11197i) {
            if (nVar.f11193e == 1) {
                i10 = Integer.MAX_VALUE;
            } else {
                i10 = Integer.MIN_VALUE;
            }
        } else if (nVar.f11193e == 1) {
            i10 = nVar.f11195g + nVar.f11190b;
        } else {
            i10 = nVar.f11194f - nVar.f11190b;
        }
        int i14 = i10;
        T(nVar.f11193e, i14);
        if (this.f10951i) {
            n10 = this.f10945c.i();
        } else {
            n10 = this.f10945c.n();
        }
        int i15 = n10;
        boolean z13 = false;
        while (nVar.a(yVar) && (this.f10949g.f11197i || !this.f10952j.isEmpty())) {
            View b10 = nVar.b(uVar);
            LayoutParams layoutParams = (LayoutParams) b10.getLayoutParams();
            int a10 = layoutParams.a();
            int g10 = this.f10955m.g(a10);
            if (g10 == -1) {
                z11 = true;
            } else {
                z11 = r92;
            }
            if (z11) {
                if (layoutParams.f10968f) {
                    cVar = this.f10944b[r92];
                } else {
                    cVar = D(nVar);
                }
                this.f10955m.n(a10, cVar);
            } else {
                cVar = this.f10944b[g10];
            }
            c cVar2 = cVar;
            layoutParams.f10967e = cVar2;
            if (nVar.f11193e == 1) {
                addView(b10);
            } else {
                addView(b10, r92);
            }
            I(b10, layoutParams, r92);
            if (nVar.f11193e == 1) {
                if (layoutParams.f10968f) {
                    l10 = z(i15);
                } else {
                    l10 = cVar2.l(i15);
                }
                int e12 = this.f10945c.e(b10) + l10;
                if (z11 && layoutParams.f10968f) {
                    LazySpanLookup.FullSpanItem m10 = m(l10);
                    m10.f10972b = -1;
                    m10.f10971a = a10;
                    this.f10955m.a(m10);
                }
                i11 = e12;
                e10 = l10;
            } else {
                if (layoutParams.f10968f) {
                    p10 = C(i15);
                } else {
                    p10 = cVar2.p(i15);
                }
                e10 = p10 - this.f10945c.e(b10);
                if (z11 && layoutParams.f10968f) {
                    LazySpanLookup.FullSpanItem n12 = n(p10);
                    n12.f10972b = 1;
                    n12.f10971a = a10;
                    this.f10955m.a(n12);
                }
                i11 = p10;
            }
            if (layoutParams.f10968f && nVar.f11192d == -1) {
                if (z11) {
                    this.f10963u = true;
                } else {
                    if (nVar.f11193e == 1) {
                        h10 = g();
                    } else {
                        h10 = h();
                    }
                    if (!h10) {
                        LazySpanLookup.FullSpanItem f10 = this.f10955m.f(a10);
                        if (f10 != null) {
                            f10.f10974d = true;
                        }
                        this.f10963u = true;
                    }
                }
            }
            i(b10, layoutParams, nVar);
            if (isLayoutRTL() && this.f10947e == 1) {
                if (layoutParams.f10968f) {
                    i13 = this.f10946d.i();
                } else {
                    i13 = this.f10946d.i() - (((this.f10943a - 1) - cVar2.f10997e) * this.f10948f);
                }
                e11 = i13;
                i12 = i13 - this.f10946d.e(b10);
            } else {
                if (layoutParams.f10968f) {
                    n11 = this.f10946d.n();
                } else {
                    n11 = (cVar2.f10997e * this.f10948f) + this.f10946d.n();
                }
                i12 = n11;
                e11 = this.f10946d.e(b10) + n11;
            }
            if (this.f10947e == 1) {
                layoutDecoratedWithMargins(b10, i12, e10, e11, i11);
            } else {
                layoutDecoratedWithMargins(b10, e10, i12, i11, e11);
            }
            if (layoutParams.f10968f) {
                T(this.f10949g.f11193e, i14);
            } else {
                Z(cVar2, this.f10949g.f11193e, i14);
            }
            N(uVar, this.f10949g);
            if (this.f10949g.f11196h && b10.hasFocusable()) {
                if (layoutParams.f10968f) {
                    this.f10952j.clear();
                } else {
                    z12 = false;
                    this.f10952j.set(cVar2.f10997e, false);
                    r92 = z12;
                    z13 = true;
                }
            }
            z12 = false;
            r92 = z12;
            z13 = true;
        }
        int i16 = r92;
        if (!z13) {
            N(uVar, this.f10949g);
        }
        if (this.f10949g.f11193e == -1) {
            z10 = this.f10945c.n() - C(this.f10945c.n());
        } else {
            z10 = z(this.f10945c.i()) - this.f10945c.i();
        }
        if (z10 > 0) {
            return Math.min(nVar.f11190b, z10);
        }
        return i16;
    }

    public final int q(int i10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            int position = getPosition(getChildAt(i11));
            if (position >= 0 && position < i10) {
                return position;
            }
        }
        return 0;
    }

    public View r(boolean z10) {
        int n10 = this.f10945c.n();
        int i10 = this.f10945c.i();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int g10 = this.f10945c.g(childAt);
            int d10 = this.f10945c.d(childAt);
            if (d10 > n10 && g10 < i10) {
                if (d10 > i10 && z10) {
                    if (view == null) {
                        view = childAt;
                    }
                } else {
                    return childAt;
                }
            }
        }
        return view;
    }

    public final void resolveShouldLayoutReverse() {
        if (this.f10947e != 1 && isLayoutRTL()) {
            this.f10951i = !this.f10950h;
        } else {
            this.f10951i = this.f10950h;
        }
    }

    public View s(boolean z10) {
        int n10 = this.f10945c.n();
        int i10 = this.f10945c.i();
        int childCount = getChildCount();
        View view = null;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int g10 = this.f10945c.g(childAt);
            if (this.f10945c.d(childAt) > n10 && g10 < i10) {
                if (g10 < n10 && z10) {
                    if (view == null) {
                        view = childAt;
                    }
                } else {
                    return childAt;
                }
            }
        }
        return view;
    }

    public int scrollBy(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        L(i10, yVar);
        int p10 = p(uVar, this.f10949g, yVar);
        if (this.f10949g.f11190b >= p10) {
            if (i10 < 0) {
                i10 = -p10;
            } else {
                i10 = p10;
            }
        }
        this.f10945c.s(-i10);
        this.f10957o = this.f10951i;
        n nVar = this.f10949g;
        nVar.f11190b = 0;
        N(uVar, nVar);
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        return scrollBy(i10, uVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void scrollToPosition(int i10) {
        SavedState savedState = this.f10959q;
        if (savedState != null && savedState.f10975a != i10) {
            savedState.b();
        }
        this.f10953k = i10;
        this.f10954l = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        return scrollBy(i10, uVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int chooseSize;
        int chooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f10947e == 1) {
            chooseSize2 = RecyclerView.o.chooseSize(i11, rect.height() + paddingTop, getMinimumHeight());
            chooseSize = RecyclerView.o.chooseSize(i10, (this.f10948f * this.f10943a) + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.o.chooseSize(i10, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize2 = RecyclerView.o.chooseSize(i11, (this.f10948f * this.f10943a) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i10 == this.f10947e) {
            return;
        }
        this.f10947e = i10;
        s sVar = this.f10945c;
        this.f10945c = this.f10946d;
        this.f10946d = sVar;
        requestLayout();
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.f10959q;
        if (savedState != null && savedState.f10982h != z10) {
            savedState.f10982h = z10;
        }
        this.f10950h = z10;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.y yVar, int i10) {
        o oVar = new o(recyclerView.getContext());
        oVar.setTargetPosition(i10);
        startSmoothScroll(oVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        if (this.f10959q == null) {
            return true;
        }
        return false;
    }

    public int t() {
        View s10;
        if (this.f10951i) {
            s10 = r(true);
        } else {
            s10 = s(true);
        }
        if (s10 == null) {
            return -1;
        }
        return getPosition(s10);
    }

    public final int u(int i10) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i10) {
                return position;
            }
        }
        return 0;
    }

    public final void v(RecyclerView.u uVar, RecyclerView.y yVar, boolean z10) {
        int i10;
        int z11 = z(Integer.MIN_VALUE);
        if (z11 != Integer.MIN_VALUE && (i10 = this.f10945c.i() - z11) > 0) {
            int i11 = i10 - (-scrollBy(-i10, uVar, yVar));
            if (z10 && i11 > 0) {
                this.f10945c.s(i11);
            }
        }
    }

    public final void w(RecyclerView.u uVar, RecyclerView.y yVar, boolean z10) {
        int n10;
        int C10 = C(Integer.MAX_VALUE);
        if (C10 != Integer.MAX_VALUE && (n10 = C10 - this.f10945c.n()) > 0) {
            int scrollBy = n10 - scrollBy(n10, uVar, yVar);
            if (z10 && scrollBy > 0) {
                this.f10945c.s(-scrollBy);
            }
        }
    }

    public int x() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int y() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final int z(int i10) {
        int l10 = this.f10944b[0].l(i10);
        for (int i11 = 1; i11 < this.f10943a; i11++) {
            int l11 = this.f10944b[i11].l(i10);
            if (l11 > l10) {
                l10 = l11;
            }
        }
        return l10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class LazySpanLookup {

        /* renamed from: a, reason: collision with root package name */
        public int[] f10969a;

        /* renamed from: b, reason: collision with root package name */
        public List<FullSpanItem> f10970b;

        public void a(FullSpanItem fullSpanItem) {
            if (this.f10970b == null) {
                this.f10970b = new ArrayList();
            }
            int size = this.f10970b.size();
            for (int i10 = 0; i10 < size; i10++) {
                FullSpanItem fullSpanItem2 = this.f10970b.get(i10);
                if (fullSpanItem2.f10971a == fullSpanItem.f10971a) {
                    this.f10970b.remove(i10);
                }
                if (fullSpanItem2.f10971a >= fullSpanItem.f10971a) {
                    this.f10970b.add(i10, fullSpanItem);
                    return;
                }
            }
            this.f10970b.add(fullSpanItem);
        }

        public void b() {
            int[] iArr = this.f10969a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f10970b = null;
        }

        public void c(int i10) {
            int[] iArr = this.f10969a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i10, 10) + 1];
                this.f10969a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[o(i10)];
                this.f10969a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f10969a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i10) {
            List<FullSpanItem> list = this.f10970b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f10970b.get(size).f10971a >= i10) {
                        this.f10970b.remove(size);
                    }
                }
            }
            return h(i10);
        }

        public FullSpanItem e(int i10, int i11, int i12, boolean z10) {
            List<FullSpanItem> list = this.f10970b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                FullSpanItem fullSpanItem = this.f10970b.get(i13);
                int i14 = fullSpanItem.f10971a;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || fullSpanItem.f10972b == i12 || (z10 && fullSpanItem.f10974d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i10) {
            List<FullSpanItem> list = this.f10970b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f10970b.get(size);
                if (fullSpanItem.f10971a == i10) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public int g(int i10) {
            int[] iArr = this.f10969a;
            if (iArr != null && i10 < iArr.length) {
                return iArr[i10];
            }
            return -1;
        }

        public int h(int i10) {
            int[] iArr = this.f10969a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int i11 = i(i10);
            if (i11 == -1) {
                int[] iArr2 = this.f10969a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f10969a.length;
            }
            int min = Math.min(i11 + 1, this.f10969a.length);
            Arrays.fill(this.f10969a, i10, min, -1);
            return min;
        }

        public final int i(int i10) {
            if (this.f10970b == null) {
                return -1;
            }
            FullSpanItem f10 = f(i10);
            if (f10 != null) {
                this.f10970b.remove(f10);
            }
            int size = this.f10970b.size();
            int i11 = 0;
            while (true) {
                if (i11 < size) {
                    if (this.f10970b.get(i11).f10971a >= i10) {
                        break;
                    }
                    i11++;
                } else {
                    i11 = -1;
                    break;
                }
            }
            if (i11 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.f10970b.get(i11);
            this.f10970b.remove(i11);
            return fullSpanItem.f10971a;
        }

        public void j(int i10, int i11) {
            int[] iArr = this.f10969a;
            if (iArr != null && i10 < iArr.length) {
                int i12 = i10 + i11;
                c(i12);
                int[] iArr2 = this.f10969a;
                System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
                Arrays.fill(this.f10969a, i10, i12, -1);
                l(i10, i11);
            }
        }

        public void k(int i10, int i11) {
            int[] iArr = this.f10969a;
            if (iArr != null && i10 < iArr.length) {
                int i12 = i10 + i11;
                c(i12);
                int[] iArr2 = this.f10969a;
                System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
                int[] iArr3 = this.f10969a;
                Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
                m(i10, i11);
            }
        }

        public final void l(int i10, int i11) {
            List<FullSpanItem> list = this.f10970b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f10970b.get(size);
                int i12 = fullSpanItem.f10971a;
                if (i12 >= i10) {
                    fullSpanItem.f10971a = i12 + i11;
                }
            }
        }

        public final void m(int i10, int i11) {
            List<FullSpanItem> list = this.f10970b;
            if (list == null) {
                return;
            }
            int i12 = i10 + i11;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f10970b.get(size);
                int i13 = fullSpanItem.f10971a;
                if (i13 >= i10) {
                    if (i13 < i12) {
                        this.f10970b.remove(size);
                    } else {
                        fullSpanItem.f10971a = i13 - i11;
                    }
                }
            }
        }

        public void n(int i10, c cVar) {
            c(i10);
            this.f10969a[i10] = cVar.f10997e;
        }

        public int o(int i10) {
            int length = this.f10969a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }

        /* loaded from: classes.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* renamed from: a, reason: collision with root package name */
            public int f10971a;

            /* renamed from: b, reason: collision with root package name */
            public int f10972b;

            /* renamed from: c, reason: collision with root package name */
            public int[] f10973c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f10974d;

            /* loaded from: classes.dex */
            public class a implements Parcelable.Creator<FullSpanItem> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i10) {
                    return new FullSpanItem[i10];
                }
            }

            public FullSpanItem(Parcel parcel) {
                this.f10971a = parcel.readInt();
                this.f10972b = parcel.readInt();
                this.f10974d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f10973c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int b(int i10) {
                int[] iArr = this.f10973c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f10971a + ", mGapDir=" + this.f10972b + ", mHasUnwantedGapAfter=" + this.f10974d + ", mGapPerSpan=" + Arrays.toString(this.f10973c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f10971a);
                parcel.writeInt(this.f10972b);
                parcel.writeInt(this.f10974d ? 1 : 0);
                int[] iArr = this.f10973c;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f10973c);
                } else {
                    parcel.writeInt(0);
                }
            }

            public FullSpanItem() {
            }
        }
    }
}
