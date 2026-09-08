package m5;

import com.heytap.accessory.constant.AFConstants;
import org.json.JSONObject;

/* compiled from: TransferProgress.java */
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public long f35141a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f35142b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f35143c = 0;

    public void a(Object obj) {
        JSONObject jSONObject = new JSONObject((String) obj);
        this.f35141a = jSONObject.getLong(AFConstants.EXTRA_CONNECTION_ID);
        this.f35142b = jSONObject.getInt("transactionId");
        this.f35143c = jSONObject.getLong("progress");
    }

    public long b() {
        return this.f35141a;
    }

    public long c() {
        return this.f35143c;
    }

    public int d() {
        return this.f35142b;
    }
}
