package p5;

import com.heytap.accessory.constant.AFConstants;
import org.json.JSONObject;

/* compiled from: CancelStreamRequest.java */
/* renamed from: p5.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1443c {

    /* renamed from: a, reason: collision with root package name */
    public long f36023a;

    /* renamed from: b, reason: collision with root package name */
    public int f36024b;

    public C1443c(long j10, int i10) {
        this.f36023a = j10;
        this.f36024b = i10;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AFConstants.EXTRA_CONNECTION_ID, this.f36023a);
        jSONObject.put("TransactionId", this.f36024b);
        return jSONObject;
    }
}
