package com.oplus.ocs.icdf.commonchannel.oaf;

import a8.C0425a;
import com.oplus.ocs.icdf.a;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.commonchannel.oaf.inner.OAFConnectionSocket;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;

/* loaded from: classes3.dex */
class g implements a.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f28553a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0425a f28554b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ byte[] f28555c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ i f28556d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ OAFConnectionSocket f28557e;

    /* loaded from: classes3.dex */
    public class a implements CommonChannel.ChannelListener {
        public a() {
        }

        @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel.ChannelListener
        public void onClosed(int i10) {
            g.this.f28556d.a((com.oplus.ocs.icdf.commonchannel.c) null);
            g.this.f28557e.a(2000);
        }
    }

    public g(f fVar, String str, C0425a c0425a, byte[] bArr, i iVar, OAFConnectionSocket oAFConnectionSocket) {
        this.f28553a = str;
        this.f28554b = c0425a;
        this.f28555c = bArr;
        this.f28556d = iVar;
        this.f28557e = oAFConnectionSocket;
    }

    @Override // com.oplus.ocs.icdf.a.b
    public void a(int i10, CommonChannel commonChannel) {
        if (commonChannel == null) {
            ICDFLog.i("ICDF.OafCommonChannelServer", "create nettyChannel failed " + this.f28553a);
            return;
        }
        ICDFLog.i("ICDF.OafCommonChannelServer", "create nettyChannel succeed " + this.f28553a);
        com.oplus.ocs.icdf.commonchannel.netty.a aVar = (com.oplus.ocs.icdf.commonchannel.netty.a) commonChannel;
        this.f28554b.c(this.f28555c);
        aVar.a(this.f28554b);
        this.f28556d.a(aVar);
        aVar.setChannelListener(new a());
    }
}
