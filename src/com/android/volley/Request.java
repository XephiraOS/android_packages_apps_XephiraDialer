package com.android.volley;

import S2.h;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.a;
import com.android.volley.d;
import com.android.volley.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class Request<T> implements Comparable<Request<T>> {

    /* renamed from: a, reason: collision with root package name */
    public final e.a f19201a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19202b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19203c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19204d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f19205e;

    /* renamed from: f, reason: collision with root package name */
    public d.a f19206f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f19207g;

    /* renamed from: h, reason: collision with root package name */
    public S2.f f19208h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f19209i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f19210j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f19211k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f19212l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f19213m;

    /* renamed from: n, reason: collision with root package name */
    public h f19214n;

    /* renamed from: o, reason: collision with root package name */
    public a.C0186a f19215o;

    /* renamed from: p, reason: collision with root package name */
    public b f19216p;

    /* loaded from: classes.dex */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19222a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f19223b;

        public a(String str, long j10) {
            this.f19222a = str;
            this.f19223b = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Request.this.f19201a.a(this.f19222a, this.f19223b);
            Request.this.f19201a.b(Request.this.toString());
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(Request<?> request);

        void b(Request<?> request, d<?> dVar);
    }

    public Request(int i10, String str, d.a aVar) {
        e.a aVar2;
        if (e.a.f19254c) {
            aVar2 = new e.a();
        } else {
            aVar2 = null;
        }
        this.f19201a = aVar2;
        this.f19205e = new Object();
        this.f19209i = true;
        this.f19210j = false;
        this.f19211k = false;
        this.f19212l = false;
        this.f19213m = false;
        this.f19215o = null;
        this.f19202b = i10;
        this.f19203c = str;
        this.f19206f = aVar;
        K(new S2.a());
        this.f19204d = h(str);
    }

    public static int h(String str) {
        Uri parse;
        String host;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            return host.hashCode();
        }
        return 0;
    }

    public boolean A() {
        boolean z10;
        synchronized (this.f19205e) {
            z10 = this.f19210j;
        }
        return z10;
    }

    public void B() {
        synchronized (this.f19205e) {
            this.f19211k = true;
        }
    }

    public void C() {
        b bVar;
        synchronized (this.f19205e) {
            bVar = this.f19216p;
        }
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void D(d<?> dVar) {
        b bVar;
        synchronized (this.f19205e) {
            bVar = this.f19216p;
        }
        if (bVar != null) {
            bVar.b(this, dVar);
        }
    }

    public abstract d<T> F(S2.e eVar);

    public void G(int i10) {
        S2.f fVar = this.f19208h;
        if (fVar != null) {
            fVar.e(this, i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> H(a.C0186a c0186a) {
        this.f19215o = c0186a;
        return this;
    }

    public void I(b bVar) {
        synchronized (this.f19205e) {
            this.f19216p = bVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> J(S2.f fVar) {
        this.f19208h = fVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> K(h hVar) {
        this.f19214n = hVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> L(int i10) {
        this.f19207g = Integer.valueOf(i10);
        return this;
    }

    public final boolean M() {
        return this.f19209i;
    }

    public final boolean N() {
        return this.f19213m;
    }

    public final boolean O() {
        return this.f19212l;
    }

    public void b(String str) {
        if (e.a.f19254c) {
            this.f19201a.a(str, Thread.currentThread().getId());
        }
    }

    public void c() {
        synchronized (this.f19205e) {
            this.f19210j = true;
            this.f19206f = null;
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(Request<T> request) {
        int ordinal;
        int ordinal2;
        Priority u10 = u();
        Priority u11 = request.u();
        if (u10 == u11) {
            ordinal = this.f19207g.intValue();
            ordinal2 = request.f19207g.intValue();
        } else {
            ordinal = u11.ordinal();
            ordinal2 = u10.ordinal();
        }
        return ordinal - ordinal2;
    }

    public void e(VolleyError volleyError) {
        d.a aVar;
        synchronized (this.f19205e) {
            aVar = this.f19206f;
        }
        if (aVar != null) {
            aVar.b(volleyError);
        }
    }

    public abstract void f(T t10);

    public final byte[] g(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append('=');
                    sb.append(URLEncoder.encode(entry.getValue(), str));
                    sb.append('&');
                } else {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("Encoding not supported: " + str, e10);
        }
    }

    public void i(String str) {
        S2.f fVar = this.f19208h;
        if (fVar != null) {
            fVar.c(this);
        }
        if (e.a.f19254c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id));
            } else {
                this.f19201a.a(str, id);
                this.f19201a.b(toString());
            }
        }
    }

    public byte[] j() {
        Map<String, String> p10 = p();
        if (p10 != null && p10.size() > 0) {
            return g(p10, q());
        }
        return null;
    }

    public String k() {
        return "application/x-www-form-urlencoded; charset=" + q();
    }

    public a.C0186a l() {
        return this.f19215o;
    }

    public String m() {
        String y10 = y();
        int o10 = o();
        if (o10 != 0 && o10 != -1) {
            return Integer.toString(o10) + '-' + y10;
        }
        return y10;
    }

    public Map<String, String> n() {
        return Collections.emptyMap();
    }

    public int o() {
        return this.f19202b;
    }

    public Map<String, String> p() {
        return null;
    }

    public String q() {
        return "UTF-8";
    }

    @Deprecated
    public byte[] r() {
        Map<String, String> s10 = s();
        if (s10 != null && s10.size() > 0) {
            return g(s10, t());
        }
        return null;
    }

    @Deprecated
    public Map<String, String> s() {
        return p();
    }

    @Deprecated
    public String t() {
        return q();
    }

    public String toString() {
        String str;
        String str2 = "0x" + Integer.toHexString(x());
        StringBuilder sb = new StringBuilder();
        if (A()) {
            str = "[X] ";
        } else {
            str = "[ ] ";
        }
        sb.append(str);
        sb.append(y());
        sb.append(" ");
        sb.append(str2);
        sb.append(" ");
        sb.append(u());
        sb.append(" ");
        sb.append(this.f19207g);
        return sb.toString();
    }

    public Priority u() {
        return Priority.NORMAL;
    }

    public h v() {
        return this.f19214n;
    }

    public final int w() {
        return v().b();
    }

    public int x() {
        return this.f19204d;
    }

    public String y() {
        return this.f19203c;
    }

    public boolean z() {
        boolean z10;
        synchronized (this.f19205e) {
            z10 = this.f19211k;
        }
        return z10;
    }

    public VolleyError E(VolleyError volleyError) {
        return volleyError;
    }
}
