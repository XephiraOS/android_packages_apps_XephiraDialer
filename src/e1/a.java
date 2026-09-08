package E1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import com.android.contacts.widget.PinnedHeaderListView;
import m1.C1320p;

/* compiled from: IndexerListAdapter.java */
/* loaded from: classes.dex */
public abstract class a extends com.android.contacts.widget.a implements SectionIndexer {

    /* renamed from: i, reason: collision with root package name */
    public Context f472i;

    /* renamed from: j, reason: collision with root package name */
    public SectionIndexer f473j;

    /* renamed from: k, reason: collision with root package name */
    public int f474k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f475l;

    /* renamed from: m, reason: collision with root package name */
    public View f476m;

    /* renamed from: n, reason: collision with root package name */
    public C0010a f477n;

    /* compiled from: IndexerListAdapter.java */
    /* renamed from: E1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0010a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f478a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f479b;

        /* renamed from: c, reason: collision with root package name */
        public String f480c;

        /* renamed from: d, reason: collision with root package name */
        public int f481d = -1;

        public void c() {
            this.f481d = -1;
        }
    }

    public a(Context context) {
        super(context);
        this.f474k = 0;
        this.f477n = new C0010a();
        this.f472i = context;
    }

    public abstract void G(View view);

    public abstract View H(Context context, ViewGroup viewGroup);

    public int I() {
        return this.f474k;
    }

    public SectionIndexer J() {
        return this.f473j;
    }

    public C0010a K(int i10) {
        if (this.f477n.f481d != i10) {
            this.f477n.f481d = i10;
            boolean z10 = false;
            if (M()) {
                int sectionForPosition = getSectionForPosition(i10);
                if (sectionForPosition != -1 && getPositionForSection(sectionForPosition) == i10) {
                    C0010a c0010a = this.f477n;
                    c0010a.f478a = true;
                    c0010a.f480c = (String) getSections()[sectionForPosition];
                } else {
                    C0010a c0010a2 = this.f477n;
                    c0010a2.f478a = false;
                    c0010a2.f480c = null;
                }
                C0010a c0010a3 = this.f477n;
                if (getPositionForSection(sectionForPosition + 1) - 1 == i10) {
                    z10 = true;
                }
                c0010a3.f479b = z10;
            } else {
                C0010a c0010a4 = this.f477n;
                c0010a4.f478a = false;
                c0010a4.f479b = false;
                c0010a4.f480c = null;
            }
            return this.f477n;
        }
        return this.f477n;
    }

    public int[] L() {
        SectionIndexer sectionIndexer = this.f473j;
        if (sectionIndexer == null) {
            return new int[]{0};
        }
        return ((C1320p) sectionIndexer).a();
    }

    public boolean M() {
        return this.f475l;
    }

    public void N(SectionIndexer sectionIndexer) {
        this.f473j = sectionIndexer;
        this.f477n.c();
    }

    public abstract void O(View view, String str);

    public void P(boolean z10) {
        this.f475l = z10;
    }

    @Override // com.android.contacts.widget.a, com.android.contacts.widget.PinnedHeaderListView.b
    public void a(PinnedHeaderListView pinnedHeaderListView) {
        int i10;
        int p10;
        super.a(pinnedHeaderListView);
        if (!M()) {
            return;
        }
        boolean z10 = true;
        int b10 = b() - 1;
        if (this.f473j != null && getCount() != 0) {
            int f10 = pinnedHeaderListView.f(pinnedHeaderListView.getTotalTopPinnedHeaderHeight());
            int headerViewsCount = f10 - pinnedHeaderListView.getHeaderViewsCount();
            if (s(headerViewsCount) == this.f474k && (p10 = p(headerViewsCount)) != -1) {
                i10 = getSectionForPosition(p10);
            } else {
                i10 = -1;
            }
            if (i10 == -1) {
                pinnedHeaderListView.k(b10, false);
                return;
            }
            O(this.f476m, (String) this.f473j.getSections()[i10]);
            if (i10 != 0) {
                G(this.f476m);
            }
            int t10 = t(this.f474k);
            if (v(this.f474k)) {
                t10++;
            }
            if (headerViewsCount != (t10 + getPositionForSection(i10 + 1)) - 1) {
                z10 = false;
            }
            pinnedHeaderListView.j(b10, f10, z10);
            return;
        }
        pinnedHeaderListView.k(b10, false);
    }

    @Override // com.android.contacts.widget.a, com.android.contacts.widget.PinnedHeaderListView.b
    public int b() {
        if (M()) {
            return super.b() + 1;
        }
        return super.b();
    }

    @Override // com.android.contacts.widget.a, com.android.contacts.widget.PinnedHeaderListView.b
    public View c(int i10, View view, ViewGroup viewGroup) {
        if (M() && i10 == b() - 1) {
            if (this.f476m == null) {
                this.f476m = H(this.f472i, viewGroup);
            }
            return this.f476m;
        }
        return super.c(i10, view, viewGroup);
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i10) {
        SectionIndexer sectionIndexer = this.f473j;
        if (sectionIndexer == null) {
            return -1;
        }
        return sectionIndexer.getPositionForSection(i10);
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i10) {
        SectionIndexer sectionIndexer = this.f473j;
        if (sectionIndexer == null) {
            return -1;
        }
        return sectionIndexer.getSectionForPosition(i10);
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        SectionIndexer sectionIndexer = this.f473j;
        if (sectionIndexer == null) {
            return new String[]{" "};
        }
        return sectionIndexer.getSections();
    }
}
