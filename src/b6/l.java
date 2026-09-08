package b6;

import android.graphics.Path;
import com.oplus.anim.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: MergePathsContent.java */
/* loaded from: classes3.dex */
public class l implements m, j {

    /* renamed from: d, reason: collision with root package name */
    public final String f12272d;

    /* renamed from: f, reason: collision with root package name */
    public final MergePaths f12274f;

    /* renamed from: a, reason: collision with root package name */
    public final Path f12269a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final Path f12270b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final Path f12271c = new Path();

    /* renamed from: e, reason: collision with root package name */
    public final List<m> f12273e = new ArrayList();

    /* compiled from: MergePathsContent.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12275a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f12275a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12275a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12275a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12275a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12275a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(MergePaths mergePaths) {
        this.f12272d = mergePaths.c();
        this.f12274f = mergePaths;
    }

    public final void a() {
        for (int i10 = 0; i10 < this.f12273e.size(); i10++) {
            this.f12271c.addPath(this.f12273e.get(i10).d());
        }
    }

    @Override // b6.c
    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < this.f12273e.size(); i10++) {
            this.f12273e.get(i10).b(list, list2);
        }
    }

    @Override // b6.m
    public Path d() {
        this.f12271c.reset();
        if (this.f12274f.d()) {
            return this.f12271c;
        }
        int i10 = a.f12275a[this.f12274f.b().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 == 5) {
                            g(Path.Op.XOR);
                        }
                    } else {
                        g(Path.Op.INTERSECT);
                    }
                } else {
                    g(Path.Op.REVERSE_DIFFERENCE);
                }
            } else {
                g(Path.Op.UNION);
            }
        } else {
            a();
        }
        return this.f12271c;
    }

    @Override // b6.j
    public void f(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c previous = listIterator.previous();
            if (previous instanceof m) {
                this.f12273e.add((m) previous);
                listIterator.remove();
            }
        }
    }

    public final void g(Path.Op op) {
        this.f12270b.reset();
        this.f12269a.reset();
        for (int size = this.f12273e.size() - 1; size >= 1; size--) {
            m mVar = this.f12273e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> l10 = dVar.l();
                for (int size2 = l10.size() - 1; size2 >= 0; size2--) {
                    Path d10 = l10.get(size2).d();
                    d10.transform(dVar.m());
                    this.f12270b.addPath(d10);
                }
            } else {
                this.f12270b.addPath(mVar.d());
            }
        }
        m mVar2 = this.f12273e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> l11 = dVar2.l();
            for (int i10 = 0; i10 < l11.size(); i10++) {
                Path d11 = l11.get(i10).d();
                d11.transform(dVar2.m());
                this.f12269a.addPath(d11);
            }
        } else {
            this.f12269a.set(mVar2.d());
        }
        this.f12271c.op(this.f12269a, this.f12270b, op);
    }
}
