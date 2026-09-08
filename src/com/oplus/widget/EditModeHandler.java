package com.oplus.widget;

import G6.b;
import android.app.Activity;
import android.widget.BaseAdapter;
import com.oplus.blacklistapp.u;
import com.oplus.utils.B;
import com.oplus.utils.C0845f;
import com.oplus.utils.InterfaceC0859u;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import x6.C1681a;

/* loaded from: classes4.dex */
public class EditModeHandler {

    /* renamed from: a, reason: collision with root package name */
    public Activity f29237a;

    /* renamed from: b, reason: collision with root package name */
    public BaseAdapter f29238b;

    /* renamed from: c, reason: collision with root package name */
    public B f29239c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC0859u f29240d;

    /* renamed from: e, reason: collision with root package name */
    public Mode f29241e;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap<Long, C0845f> f29242f = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public ConcurrentHashMap<Long, C0845f> f29243g = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public Set<Long> f29244h = b.a();

    /* renamed from: i, reason: collision with root package name */
    public Set<Long> f29245i = b.a();

    /* renamed from: j, reason: collision with root package name */
    public ConcurrentHashMap<Long, String> f29246j = new ConcurrentHashMap<>();

    /* renamed from: k, reason: collision with root package name */
    public ConcurrentHashMap<Long, String> f29247k = new ConcurrentHashMap<>();

    /* renamed from: l, reason: collision with root package name */
    public ConcurrentHashMap<Integer, C1681a.c> f29248l = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    public ConcurrentHashMap<Integer, C1681a.c> f29249m = new ConcurrentHashMap<>();

    /* renamed from: n, reason: collision with root package name */
    public boolean f29250n;

    /* loaded from: classes4.dex */
    public enum Mode {
        BLACK_LIST_MODE,
        WHITE_LIST_MODE,
        INTERCEPT_BY_COUNTRY_MODE,
        FAKE_STATION_MODE,
        KEY_WORD_MODE
    }

    public EditModeHandler(Activity activity, BaseAdapter baseAdapter, InterfaceC0859u interfaceC0859u, B b10, Mode mode) {
        this.f29241e = Mode.BLACK_LIST_MODE;
        this.f29237a = activity;
        this.f29238b = baseAdapter;
        this.f29239c = b10;
        this.f29240d = interfaceC0859u;
        this.f29241e = mode;
    }

    public void a() {
        this.f29250n = true;
        this.f29240d.b();
    }

    public String b() {
        int c10 = c();
        if (c10 == 0) {
            return this.f29237a.getString(u.f27570T2);
        }
        return this.f29237a.getString(u.f27574U2, Integer.valueOf(c10));
    }

    public int c() {
        Mode mode = this.f29241e;
        if (mode != Mode.BLACK_LIST_MODE && mode != Mode.WHITE_LIST_MODE) {
            if (mode == Mode.KEY_WORD_MODE) {
                return this.f29245i.size();
            }
            if (mode == Mode.INTERCEPT_BY_COUNTRY_MODE) {
                return this.f29248l.size();
            }
            if (mode == Mode.FAKE_STATION_MODE) {
                return this.f29246j.size();
            }
            return 0;
        }
        return this.f29242f.size();
    }

    public boolean d() {
        return this.f29250n;
    }

    public void e() {
        this.f29250n = false;
        this.f29240d.c();
    }

    public void f() {
        if (c() == this.f29238b.getCount()) {
            p();
        } else {
            g();
        }
        this.f29240d.d();
        this.f29238b.notifyDataSetChanged();
    }

    public final void g() {
        Mode mode = this.f29241e;
        if (mode != Mode.BLACK_LIST_MODE && mode != Mode.WHITE_LIST_MODE) {
            if (mode == Mode.KEY_WORD_MODE) {
                this.f29245i.clear();
                this.f29245i.addAll(this.f29244h);
            } else if (mode == Mode.INTERCEPT_BY_COUNTRY_MODE) {
                this.f29248l.clear();
                this.f29248l.putAll(this.f29249m);
            } else if (mode == Mode.FAKE_STATION_MODE) {
                this.f29246j.clear();
                this.f29246j.putAll(this.f29247k);
            }
        } else {
            this.f29242f.clear();
            this.f29242f.putAll(this.f29243g);
        }
        B b10 = this.f29239c;
        if (b10 != null) {
            b10.b();
        }
    }

    public void h(Set<Long> set) {
        this.f29244h.clear();
        this.f29244h.addAll(set);
    }

    public void i(ConcurrentHashMap<Long, C0845f> concurrentHashMap) {
        this.f29243g.clear();
        this.f29243g.putAll(concurrentHashMap);
    }

    public void j(ConcurrentHashMap<Integer, C1681a.c> concurrentHashMap) {
        this.f29249m.clear();
        this.f29249m.putAll(concurrentHashMap);
    }

    public void k(ConcurrentHashMap<Long, String> concurrentHashMap) {
        this.f29247k.clear();
        this.f29247k.putAll(concurrentHashMap);
    }

    public void l(Set<Long> set) {
        this.f29245i.clear();
        this.f29245i.addAll(set);
    }

    public void m(ConcurrentHashMap<Long, C0845f> concurrentHashMap) {
        this.f29242f.clear();
        this.f29242f.putAll(concurrentHashMap);
    }

    public void n(ConcurrentHashMap<Integer, C1681a.c> concurrentHashMap) {
        this.f29248l.clear();
        this.f29248l.putAll(concurrentHashMap);
    }

    public void o(ConcurrentHashMap<Long, String> concurrentHashMap) {
        this.f29246j.clear();
        this.f29246j.putAll(concurrentHashMap);
    }

    public final void p() {
        Mode mode = this.f29241e;
        if (mode != Mode.BLACK_LIST_MODE && mode != Mode.WHITE_LIST_MODE) {
            if (mode == Mode.KEY_WORD_MODE) {
                this.f29245i.clear();
            } else if (mode == Mode.INTERCEPT_BY_COUNTRY_MODE) {
                this.f29248l.clear();
            } else if (mode == Mode.FAKE_STATION_MODE) {
                this.f29246j.clear();
            }
        } else {
            this.f29242f.clear();
        }
        B b10 = this.f29239c;
        if (b10 != null) {
            b10.c();
        }
    }
}
