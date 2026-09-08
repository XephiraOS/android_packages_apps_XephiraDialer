package com.oplus.ocs.icdf.commonchannel.oaf;

import com.oplus.ocs.icdf.a;
import com.oplus.ocs.icdf.commonchannel.oaf.i;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f28524a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f28525b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a.b f28526c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ a f28527d;

    public d(a aVar, String str, i iVar, a.b bVar) {
        this.f28527d = aVar;
        this.f28524a = str;
        this.f28525b = iVar;
        this.f28526c = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map map;
        map = this.f28527d.f28506j;
        if (map.remove(this.f28524a) == null) {
            return;
        }
        ICDFLog.w("ICDF.OafCommonChannelClientAdapter", "wait createExtraNettyChannel response timeout, peerAgent " + this.f28524a);
        this.f28525b.a((i.d) null);
        this.f28526c.a(1, null);
    }
}
