package com.oplus.ocs.icdf.commonchannel.oaf;

import a8.C0425a;
import com.oplus.ocs.icdf.a;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class h implements a.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f28559a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0425a f28560b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ byte[] f28561c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ f f28562d;

    /* loaded from: classes3.dex */
    public class a implements CommonChannel.ChannelListener {
        public a() {
        }

        @Override // com.oplus.ocs.icdf.commonchannel.CommonChannel.ChannelListener
        public void onClosed(int i10) {
            Map map;
            map = h.this.f28562d.f28546j;
            map.remove(h.this.f28559a);
        }
    }

    public h(f fVar, String str, C0425a c0425a, byte[] bArr) {
        this.f28562d = fVar;
        this.f28559a = str;
        this.f28560b = c0425a;
        this.f28561c = bArr;
    }

    @Override // com.oplus.ocs.icdf.a.b
    public void a(int i10, CommonChannel commonChannel) {
        Map map;
        Map map2;
        Map map3;
        if (commonChannel == null) {
            ICDFLog.i("ICDF.OafCommonChannelServer", "create extra nettyChannel failed " + this.f28559a);
            map3 = this.f28562d.f28544h;
            ((a.b) map3.get(this.f28559a)).a(1, null);
            return;
        }
        ICDFLog.i("ICDF.OafCommonChannelServer", "create extra nettyChannel succeed " + this.f28559a);
        map = this.f28562d.f28546j;
        map.put(this.f28559a, commonChannel);
        com.oplus.ocs.icdf.commonchannel.netty.a aVar = (com.oplus.ocs.icdf.commonchannel.netty.a) commonChannel;
        aVar.setChannelListener(new a());
        this.f28560b.c(this.f28561c);
        aVar.a(this.f28560b);
        map2 = this.f28562d.f28544h;
        ((a.b) map2.get(this.f28559a)).a(0, aVar);
    }
}
