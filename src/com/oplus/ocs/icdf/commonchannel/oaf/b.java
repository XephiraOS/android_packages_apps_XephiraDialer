package com.oplus.ocs.icdf.commonchannel.oaf;

import com.oplus.ocs.icdf.commonchannel.oaf.i;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.util.Map;

/* loaded from: classes3.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f28511a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f28512b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.oplus.ocs.icdf.model.a f28513c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ a f28514d;

    public b(a aVar, String str, i iVar, com.oplus.ocs.icdf.model.a aVar2) {
        this.f28514d = aVar;
        this.f28511a = str;
        this.f28512b = iVar;
        this.f28513c = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map map;
        map = this.f28514d.f28505i;
        if (map.remove(this.f28511a) == null) {
            return;
        }
        ICDFLog.w("ICDF.OafCommonChannelClientAdapter", "wait createNettyChannel response timeout, peerAgent " + this.f28511a);
        this.f28512b.a((i.d) null);
        this.f28514d.a(this.f28513c, 2, this.f28512b);
    }
}
