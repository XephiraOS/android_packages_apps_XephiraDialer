package x7;

import android.database.Cursor;
import android.widget.SectionIndexer;
import kotlin.jvm.internal.i;
import v7.C1634a;
import y7.C1708a;

/* compiled from: IndexerCursorRecyclerAdapter.kt */
/* loaded from: classes3.dex */
public abstract class f<VH extends C1708a> extends AbstractC1684a<VH> implements SectionIndexer {

    /* renamed from: h, reason: collision with root package name */
    public a f38070h;

    /* renamed from: i, reason: collision with root package name */
    public C1634a f38071i;

    /* compiled from: IndexerCursorRecyclerAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f38072a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f38073b;

        /* renamed from: c, reason: collision with root package name */
        public String f38074c;

        /* renamed from: d, reason: collision with root package name */
        public int f38075d = -1;

        public final int a() {
            return this.f38075d;
        }

        public final String b() {
            return this.f38074c;
        }

        public final void c() {
            this.f38075d = -1;
        }

        public final void d(boolean z10) {
            this.f38072a = z10;
        }

        public final void e(boolean z10) {
            this.f38073b = z10;
        }

        public final void f(int i10) {
            this.f38075d = i10;
        }

        public final void g(String str) {
            this.f38074c = str;
        }
    }

    public f() {
        super(0, 1, null);
        this.f38070h = new a();
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i10) {
        C1634a c1634a = this.f38071i;
        if (c1634a != null) {
            return c1634a.getPositionForSection(i10);
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i10) {
        C1634a c1634a = this.f38071i;
        if (c1634a != null) {
            return c1634a.getSectionForPosition(i10);
        }
        return -1;
    }

    @Override // x7.AbstractC1684a
    public void h(Cursor cursor) {
        super.h(cursor);
        q(m(cursor));
    }

    public abstract C1634a m(Cursor cursor);

    public a n(int i10) {
        if (this.f38070h.a() == i10) {
            return this.f38070h;
        }
        this.f38070h.f(i10);
        int sectionForPosition = getSectionForPosition(i10);
        boolean z10 = false;
        if (sectionForPosition != -1 && getPositionForSection(sectionForPosition) == i10) {
            this.f38070h.d(true);
            this.f38070h.g(getSections()[sectionForPosition]);
        } else {
            this.f38070h.d(false);
            this.f38070h.g(null);
        }
        a aVar = this.f38070h;
        if (getPositionForSection(sectionForPosition + 1) - 1 == i10) {
            z10 = true;
        }
        aVar.e(z10);
        return this.f38070h;
    }

    public final int[] o() {
        int[] a10;
        C1634a c1634a = this.f38071i;
        if (c1634a == null || (a10 = c1634a.a()) == null) {
            return new int[0];
        }
        return a10;
    }

    @Override // android.widget.SectionIndexer
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public String[] getSections() {
        String[] sections;
        C1634a c1634a = this.f38071i;
        if (c1634a == null || (sections = c1634a.getSections()) == null) {
            return new String[0];
        }
        return sections;
    }

    public final void q(C1634a c1634a) {
        Integer num;
        Integer num2;
        Integer num3;
        int[] a10;
        String[] sections;
        int[] a11;
        String[] sections2;
        Integer num4 = null;
        if (c1634a != null && (sections2 = c1634a.getSections()) != null) {
            num = Integer.valueOf(sections2.length);
        } else {
            num = null;
        }
        if (c1634a != null && (a11 = c1634a.a()) != null) {
            num2 = Integer.valueOf(a11.length);
        } else {
            num2 = null;
        }
        if (!i.b(num, num2)) {
            if (c1634a != null && (sections = c1634a.getSections()) != null) {
                num3 = Integer.valueOf(sections.length);
            } else {
                num3 = null;
            }
            if (c1634a != null && (a10 = c1634a.a()) != null) {
                num4 = Integer.valueOf(a10.length);
            }
            throw new IllegalArgumentException(("the size of sections and sectionCounts must be equal! section:" + num3 + ", count:" + num4).toString());
        }
        this.f38071i = c1634a;
        this.f38070h.c();
    }
}
