package com.oplus.ocs.icdf.commonchannel.oaf;

import a8.C0425a;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.commonchannel.oaf.i;
import com.oplus.ocs.icdf.commonchannel.oaf.inner.OAFConnectionSocket;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/* loaded from: classes3.dex */
class c implements i.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f28515a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScheduledFuture f28516b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.oplus.ocs.icdf.model.a f28517c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f28518d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ i f28519e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ C0425a f28520f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ OAFConnectionSocket f28521g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ com.oplus.ocs.icdf.commonchannel.oaf.a f28522h;

    /* loaded from: classes3.dex */
    public class a implements CommonChannel.ChannelListener {
        public a() {
        }

        @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel.ChannelListener
        public void onClosed(int i10) {
            c.this.f28519e.a((com.oplus.ocs.icdf.commonchannel.c) null);
            c.this.f28521g.a(1000);
        }
    }

    public c(com.oplus.ocs.icdf.commonchannel.oaf.a aVar, String str, ScheduledFuture scheduledFuture, com.oplus.ocs.icdf.model.a aVar2, String str2, i iVar, C0425a c0425a, OAFConnectionSocket oAFConnectionSocket) {
        this.f28522h = aVar;
        this.f28515a = str;
        this.f28516b = scheduledFuture;
        this.f28517c = aVar2;
        this.f28518d = str2;
        this.f28519e = iVar;
        this.f28520f = c0425a;
        this.f28521g = oAFConnectionSocket;
    }

    @Override // com.oplus.ocs.icdf.commonchannel.oaf.i.d
    public boolean onBytesReceived(byte[] bArr) {
        Map map;
        if (com.oplus.ocs.icdf.commonchannel.d.b(bArr)) {
            map = this.f28522h.f28505i;
            if (map.remove(this.f28515a) == null) {
                return true;
            }
            ICDFLog.v("ICDF.OafCommonChannelClientAdapter", "cancel time out task, state " + this.f28516b.cancel(false));
            com.oplus.ocs.icdf.commonchannel.netty.a a10 = com.oplus.ocs.icdf.commonchannel.oaf.a.a(this.f28522h, this.f28517c, this.f28518d, com.oplus.ocs.icdf.commonchannel.d.a(bArr));
            this.f28519e.a((i.d) null);
            if (a10 == null) {
                this.f28522h.a(this.f28517c, 2, this.f28519e);
                return true;
            }
            byte[] bArr2 = new byte[64];
            System.arraycopy(bArr, 14, bArr2, 0, 64);
            this.f28520f.c(bArr2);
            a10.a(this.f28520f);
            this.f28519e.a(a10);
            a10.setChannelListener(new a());
            this.f28522h.a(this.f28517c, 0, this.f28519e);
            return true;
        }
        return false;
    }
}
