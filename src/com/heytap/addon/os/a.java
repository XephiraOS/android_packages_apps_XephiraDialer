package com.heytap.addon.os;

import android.content.Context;
import com.oplus.os.LinearmotorVibrator;

/* compiled from: LinearmotorVibrator.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static String f25364c;

    /* renamed from: a, reason: collision with root package name */
    public LinearmotorVibrator f25365a;

    /* renamed from: b, reason: collision with root package name */
    public com.oppo.os.LinearmotorVibrator f25366b;

    static {
        if (A5.a.b()) {
            f25364c = "linearmotor";
        } else {
            f25364c = "linearmotor";
        }
    }

    public a(Context context) {
        if (A5.a.b()) {
            this.f25365a = (LinearmotorVibrator) context.getSystemService(f25364c);
        } else {
            this.f25366b = (com.oppo.os.LinearmotorVibrator) context.getSystemService(f25364c);
        }
    }

    public boolean a() {
        if ((A5.a.b() && this.f25365a != null) || (!A5.a.b() && this.f25366b != null)) {
            return true;
        }
        return false;
    }

    public void b(d dVar) {
        if (A5.a.b()) {
            LinearmotorVibrator linearmotorVibrator = this.f25365a;
            if (linearmotorVibrator != null) {
                linearmotorVibrator.vibrate(dVar.f25405a);
                return;
            }
            return;
        }
        com.oppo.os.LinearmotorVibrator linearmotorVibrator2 = this.f25366b;
        if (linearmotorVibrator2 != null) {
            linearmotorVibrator2.vibrate(dVar.f25406b);
        }
    }
}
