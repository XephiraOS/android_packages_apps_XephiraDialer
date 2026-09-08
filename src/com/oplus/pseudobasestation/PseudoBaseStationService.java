package com.oplus.pseudobasestation;

import Z7.b;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.util.Log;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0863y;
import com.oplus.utils.P;

/* loaded from: classes3.dex */
public class PseudoBaseStationService extends IntentService {

    /* renamed from: a, reason: collision with root package name */
    public Context f28904a;

    /* renamed from: b, reason: collision with root package name */
    public b f28905b;

    /* renamed from: c, reason: collision with root package name */
    public a f28906c;

    /* renamed from: d, reason: collision with root package name */
    public int f28907d;

    /* renamed from: e, reason: collision with root package name */
    public double f28908e;

    /* renamed from: f, reason: collision with root package name */
    public double f28909f;

    /* loaded from: classes3.dex */
    public class a implements b.d {
        @Override // Z7.b.d
        public void a(Location location) {
            PseudoBaseStationService.this.f28908e = location.getLatitude();
            PseudoBaseStationService.this.f28909f = location.getLongitude();
            if (C0846g.c()) {
                Log.d("PseudoStationService", "--onLocationUpdated");
            }
            P.d(PseudoBaseStationService.this.f28904a, PseudoBaseStationService.this.f28907d, PseudoBaseStationService.this.f28908e, PseudoBaseStationService.this.f28909f);
            if (PseudoBaseStationService.this.f28905b != null) {
                PseudoBaseStationService.this.f28905b.e();
            }
        }

        public a() {
        }
    }

    public PseudoBaseStationService() {
        super("PseudoBaseStationService");
        this.f28906c = null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (C0846g.c()) {
            Log.d("PseudoStationService", "--onCreate--");
        }
        this.f28904a = this;
        this.f28905b = new b(this);
        a aVar = new a();
        this.f28906c = aVar;
        this.f28905b.i(aVar);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        if (C0846g.c()) {
            Log.d("PseudoStationService", "onDestroy");
        }
        super.onDestroy();
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (C0846g.c()) {
            Log.d("PseudoStationService", "--onHandleIntent--");
        }
        if (intent == null) {
            C0846g.i("PseudoStationService", "onHandleIntent: could not handle null intent");
        } else {
            this.f28907d = C0863y.b(intent, "arfcn", -1);
            this.f28905b.g();
        }
    }
}
