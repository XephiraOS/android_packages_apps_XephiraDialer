package a3;

import android.graphics.Bitmap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import s3.C1541l;

/* compiled from: SizeConfigStrategy.java */
/* loaded from: classes.dex */
public class m implements k {

    /* renamed from: d, reason: collision with root package name */
    public static final Bitmap.Config[] f6383d;

    /* renamed from: e, reason: collision with root package name */
    public static final Bitmap.Config[] f6384e;

    /* renamed from: f, reason: collision with root package name */
    public static final Bitmap.Config[] f6385f;

    /* renamed from: g, reason: collision with root package name */
    public static final Bitmap.Config[] f6386g;

    /* renamed from: h, reason: collision with root package name */
    public static final Bitmap.Config[] f6387h;

    /* renamed from: a, reason: collision with root package name */
    public final c f6388a = new c();

    /* renamed from: b, reason: collision with root package name */
    public final g<b, Bitmap> f6389b = new g<>();

    /* renamed from: c, reason: collision with root package name */
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f6390c = new HashMap();

    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6391a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f6391a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6391a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6391a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6391a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static final class b implements l {

        /* renamed from: a, reason: collision with root package name */
        public final c f6392a;

        /* renamed from: b, reason: collision with root package name */
        public int f6393b;

        /* renamed from: c, reason: collision with root package name */
        public Bitmap.Config f6394c;

        public b(c cVar) {
            this.f6392a = cVar;
        }

        @Override // a3.l
        public void a() {
            this.f6392a.c(this);
        }

        public void b(int i10, Bitmap.Config config) {
            this.f6393b = i10;
            this.f6394c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f6393b != bVar.f6393b || !C1541l.d(this.f6394c, bVar.f6394c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i10;
            int i11 = this.f6393b * 31;
            Bitmap.Config config = this.f6394c;
            if (config != null) {
                i10 = config.hashCode();
            } else {
                i10 = 0;
            }
            return i11 + i10;
        }

        public String toString() {
            return m.h(this.f6393b, this.f6394c);
        }
    }

    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static class c extends a3.c<b> {
        @Override // a3.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b e(int i10, Bitmap.Config config) {
            b b10 = b();
            b10.b(i10, config);
            return b10;
        }
    }

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        f6383d = configArr;
        f6384e = configArr;
        f6385f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f6386g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f6387h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String h(int i10, Bitmap.Config config) {
        return "[" + i10 + "](" + config + ")";
    }

    public static Bitmap.Config[] i(Bitmap.Config config) {
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            return f6384e;
        }
        int i10 = a.f6391a[config.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        return new Bitmap.Config[]{config};
                    }
                    return f6387h;
                }
                return f6386g;
            }
            return f6385f;
        }
        return f6383d;
    }

    @Override // a3.k
    public String a(int i10, int i11, Bitmap.Config config) {
        return h(C1541l.g(i10, i11, config), config);
    }

    @Override // a3.k
    public int b(Bitmap bitmap) {
        return C1541l.h(bitmap);
    }

    @Override // a3.k
    public void c(Bitmap bitmap) {
        b e10 = this.f6388a.e(C1541l.h(bitmap), bitmap.getConfig());
        this.f6389b.d(e10, bitmap);
        NavigableMap<Integer, Integer> j10 = j(bitmap.getConfig());
        Integer num = j10.get(Integer.valueOf(e10.f6393b));
        Integer valueOf = Integer.valueOf(e10.f6393b);
        int i10 = 1;
        if (num != null) {
            i10 = 1 + num.intValue();
        }
        j10.put(valueOf, Integer.valueOf(i10));
    }

    @Override // a3.k
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        b g10 = g(C1541l.g(i10, i11, config), config);
        Bitmap a10 = this.f6389b.a(g10);
        if (a10 != null) {
            f(Integer.valueOf(g10.f6393b), a10);
            a10.reconfigure(i10, i11, config);
        }
        return a10;
    }

    @Override // a3.k
    public String e(Bitmap bitmap) {
        return h(C1541l.h(bitmap), bitmap.getConfig());
    }

    public final void f(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> j10 = j(bitmap.getConfig());
        Integer num2 = j10.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                j10.remove(num);
                return;
            } else {
                j10.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
    }

    public final b g(int i10, Bitmap.Config config) {
        b e10 = this.f6388a.e(i10, config);
        for (Bitmap.Config config2 : i(config)) {
            Integer ceilingKey = j(config2).ceilingKey(Integer.valueOf(i10));
            if (ceilingKey != null && ceilingKey.intValue() <= i10 * 8) {
                if (ceilingKey.intValue() == i10) {
                    if (config2 == null) {
                        if (config == null) {
                            return e10;
                        }
                    } else if (config2.equals(config)) {
                        return e10;
                    }
                }
                this.f6388a.c(e10);
                return this.f6388a.e(ceilingKey.intValue(), config2);
            }
        }
        return e10;
    }

    public final NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f6390c.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f6390c.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // a3.k
    public Bitmap removeLast() {
        Bitmap f10 = this.f6389b.f();
        if (f10 != null) {
            f(Integer.valueOf(C1541l.h(f10)), f10);
        }
        return f10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f6389b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f6390c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f6390c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
