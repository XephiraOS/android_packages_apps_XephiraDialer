package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes3.dex */
public final class CurrentParsingState {

    /* renamed from: a, reason: collision with root package name */
    public int f25077a = 0;

    /* renamed from: b, reason: collision with root package name */
    public State f25078b = State.NUMERIC;

    /* loaded from: classes3.dex */
    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int a() {
        return this.f25077a;
    }

    public void b(int i10) {
        this.f25077a += i10;
    }

    public boolean c() {
        if (this.f25078b == State.ALPHA) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f25078b == State.ISO_IEC_646) {
            return true;
        }
        return false;
    }

    public void e() {
        this.f25078b = State.ALPHA;
    }

    public void f() {
        this.f25078b = State.ISO_IEC_646;
    }

    public void g() {
        this.f25078b = State.NUMERIC;
    }

    public void h(int i10) {
        this.f25077a = i10;
    }
}
