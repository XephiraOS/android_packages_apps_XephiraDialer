package H;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final H.c f1194a = new e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final H.c f1195b = new e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final H.c f1196c;

    /* renamed from: d, reason: collision with root package name */
    public static final H.c f1197d;

    /* renamed from: e, reason: collision with root package name */
    public static final H.c f1198e;

    /* renamed from: f, reason: collision with root package name */
    public static final H.c f1199f;

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        public static final a f1200b = new a(true);

        /* renamed from: a, reason: collision with root package name */
        public final boolean f1201a;

        public a(boolean z10) {
            this.f1201a = z10;
        }

        @Override // H.d.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (i10 < i12) {
                int a10 = d.a(Character.getDirectionality(charSequence.charAt(i10)));
                if (a10 != 0) {
                    if (a10 == 1) {
                        if (!this.f1201a) {
                            return 1;
                        }
                    } else {
                        continue;
                        i10++;
                        z10 = z10;
                    }
                } else if (this.f1201a) {
                    return 0;
                }
                z10 = true;
                i10++;
                z10 = z10;
            }
            if (z10) {
                return this.f1201a ? 1 : 0;
            }
            return 2;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f1202a = new b();

        @Override // H.d.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            int i13 = 2;
            while (i10 < i12 && i13 == 2) {
                i13 = d.b(Character.getDirectionality(charSequence.charAt(i10)));
                i10++;
            }
            return i13;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i10, int i11);
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* renamed from: H.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0024d implements H.c {

        /* renamed from: a, reason: collision with root package name */
        public final c f1203a;

        public AbstractC0024d(c cVar) {
            this.f1203a = cVar;
        }

        @Override // H.c
        public boolean a(CharSequence charSequence, int i10, int i11) {
            if (charSequence != null && i10 >= 0 && i11 >= 0 && charSequence.length() - i11 >= i10) {
                if (this.f1203a == null) {
                    return b();
                }
                return c(charSequence, i10, i11);
            }
            throw new IllegalArgumentException();
        }

        public abstract boolean b();

        public final boolean c(CharSequence charSequence, int i10, int i11) {
            int a10 = this.f1203a.a(charSequence, i10, i11);
            if (a10 == 0) {
                return true;
            }
            if (a10 != 1) {
                return b();
            }
            return false;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public static class e extends AbstractC0024d {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f1204b;

        public e(c cVar, boolean z10) {
            super(cVar);
            this.f1204b = z10;
        }

        @Override // H.d.AbstractC0024d
        public boolean b() {
            return this.f1204b;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat.java */
    /* loaded from: classes.dex */
    public static class f extends AbstractC0024d {

        /* renamed from: b, reason: collision with root package name */
        public static final f f1205b = new f();

        public f() {
            super(null);
        }

        @Override // H.d.AbstractC0024d
        public boolean b() {
            if (H.e.a(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    static {
        b bVar = b.f1202a;
        f1196c = new e(bVar, false);
        f1197d = new e(bVar, true);
        f1198e = new e(a.f1200b, false);
        f1199f = f.f1205b;
    }

    public static int a(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 != 1 && i10 != 2) {
            return 2;
        }
        return 0;
    }

    public static int b(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return 0;
            }
            switch (i10) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
