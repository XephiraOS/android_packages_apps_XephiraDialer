package p5;

import com.heytap.accessory.constant.AFConstants;
import org.json.JSONObject;

/* compiled from: StreamReceiveEntity.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public int f36030a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f36031b;

    /* renamed from: c, reason: collision with root package name */
    public long f36032c;

    /* renamed from: d, reason: collision with root package name */
    public int f36033d;

    public f(long j10, int i10, boolean z10, int i11) {
        this.f36032c = j10;
        this.f36030a = i10;
        this.f36031b = z10;
        this.f36033d = i11;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f36030a);
        jSONObject.put(AFConstants.EXTRA_CONNECTION_ID, this.f36032c);
        jSONObject.put("accepted", this.f36031b);
        jSONObject.put("reason", this.f36033d);
        return jSONObject;
    }
}
