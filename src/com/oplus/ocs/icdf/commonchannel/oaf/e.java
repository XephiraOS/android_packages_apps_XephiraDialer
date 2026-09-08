package com.oplus.ocs.icdf.commonchannel.oaf;

import a8.C0425a;
import com.oplus.ocs.icdf.a;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.commonchannel.oaf.i;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e implements i.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f28528a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScheduledFuture f28529b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.oplus.ocs.icdf.model.a f28530c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f28531d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ i f28532e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ a.b f28533f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ C0425a f28534g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ com.oplus.ocs.icdf.commonchannel.oaf.a f28535h;

    /* loaded from: classes3.dex */
    public class a implements CommonChannel.ChannelListener {
        public a() {
        }

        @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel.ChannelListener
        public void onClosed(int i10) {
            Map map;
            map = e.this.f28535h.f28502f;
            map.remove(e.this.f28528a);
        }
    }

    public e(com.oplus.ocs.icdf.commonchannel.oaf.a aVar, String str, ScheduledFuture scheduledFuture, com.oplus.ocs.icdf.model.a aVar2, String str2, i iVar, a.b bVar, C0425a c0425a) {
        this.f28535h = aVar;
        this.f28528a = str;
        this.f28529b = scheduledFuture;
        this.f28530c = aVar2;
        this.f28531d = str2;
        this.f28532e = iVar;
        this.f28533f = bVar;
        this.f28534g = c0425a;
    }

    @Override // com.oplus.ocs.icdf.commonchannel.oaf.i.d
    public boolean onBytesReceived(byte[] bArr) {
        Map map;
        Map map2;
        if (com.oplus.ocs.icdf.commonchannel.d.b(bArr)) {
            map = this.f28535h.f28506j;
            if (map.remove(this.f28528a) == null) {
                return true;
            }
            ICDFLog.v("ICDF.OafCommonChannelClientAdapter", "cancel time out task, state " + this.f28529b.cancel(false));
            com.oplus.ocs.icdf.commonchannel.netty.a a10 = com.oplus.ocs.icdf.commonchannel.oaf.a.a(this.f28535h, this.f28530c, this.f28531d, com.oplus.ocs.icdf.commonchannel.d.a(bArr));
            this.f28532e.a((i.d) null);
            if (a10 == null) {
                ICDFLog.e("ICDF.OafCommonChannelClientAdapter", "create extraNettyChannel failed");
                this.f28533f.a(1, null);
                return true;
            }
            if (!this.f28532e.isClosed()) {
                map2 = this.f28535h.f28502f;
                map2.put(this.f28528a, a10);
                a10.setChannelListener(new a());
                byte[] bArr2 = new byte[64];
                System.arraycopy(bArr, 14, bArr2, 0, 64);
                this.f28534g.c(bArr2);
                a10.a(this.f28534g);
                this.f28533f.a(0, a10);
                return true;
            }
            ICDFLog.e("ICDF.OafCommonChannelClientAdapter", "create extraNettyChannel failed, main channel closed");
            a10.close();
            this.f28533f.a(1, null);
            return true;
        }
        return false;
    }
}
