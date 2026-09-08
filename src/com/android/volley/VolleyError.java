package com.android.volley;

/* loaded from: classes.dex */
public class VolleyError extends Exception {
    public final S2.e networkResponse;
    private long networkTimeMs;

    public VolleyError() {
        this.networkResponse = null;
    }

    public void a(long j10) {
        this.networkTimeMs = j10;
    }

    public VolleyError(S2.e eVar) {
        this.networkResponse = eVar;
    }

    public VolleyError(Throwable th) {
        super(th);
        this.networkResponse = null;
    }
}
