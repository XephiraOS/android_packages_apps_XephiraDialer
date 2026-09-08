package d3;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class k implements i {

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, List<j>> f29971c;

    /* renamed from: d, reason: collision with root package name */
    public volatile Map<String, String> f29972d;

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        public static final String f29973d;

        /* renamed from: e, reason: collision with root package name */
        public static final Map<String, List<j>> f29974e;

        /* renamed from: a, reason: collision with root package name */
        public boolean f29975a = true;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, List<j>> f29976b = f29974e;

        /* renamed from: c, reason: collision with root package name */
        public boolean f29977c = true;

        static {
            String b10 = b();
            f29973d = b10;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b10)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(b10)));
            }
            f29974e = Collections.unmodifiableMap(hashMap);
        }

        public static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = property.charAt(i10);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public k a() {
            this.f29975a = true;
            return new k(this.f29976b);
        }
    }

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    public static final class b implements j {

        /* renamed from: a, reason: collision with root package name */
        public final String f29978a;

        public b(String str) {
            this.f29978a = str;
        }

        @Override // d3.j
        public String a() {
            return this.f29978a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f29978a.equals(((b) obj).f29978a);
            }
            return false;
        }

        public int hashCode() {
            return this.f29978a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f29978a + "'}";
        }
    }

    public k(Map<String, List<j>> map) {
        this.f29971c = Collections.unmodifiableMap(map);
    }

    @Override // d3.i
    public Map<String, String> a() {
        if (this.f29972d == null) {
            synchronized (this) {
                try {
                    if (this.f29972d == null) {
                        this.f29972d = Collections.unmodifiableMap(c());
                    }
                } finally {
                }
            }
        }
        return this.f29972d;
    }

    public final String b(List<j> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String a10 = list.get(i10).a();
            if (!TextUtils.isEmpty(a10)) {
                sb.append(a10);
                if (i10 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public final Map<String, String> c() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<j>> entry : this.f29971c.entrySet()) {
            String b10 = b(entry.getValue());
            if (!TextUtils.isEmpty(b10)) {
                hashMap.put(entry.getKey(), b10);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f29971c.equals(((k) obj).f29971c);
        }
        return false;
    }

    public int hashCode() {
        return this.f29971c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f29971c + '}';
    }
}
