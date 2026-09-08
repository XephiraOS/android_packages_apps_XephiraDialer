package m5;

import com.heytap.accessory.constant.AFConstants;
import org.json.JSONObject;

/* compiled from: TransferCompleteMsg.java */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public long f35133a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f35134b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f35135c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f35136d = "";

    public void a(Object obj) {
        JSONObject jSONObject = new JSONObject((String) obj);
        this.f35133a = jSONObject.getLong(AFConstants.EXTRA_CONNECTION_ID);
        this.f35134b = jSONObject.getInt("transactionId");
        this.f35135c = jSONObject.getString("sourcePath");
        this.f35136d = jSONObject.getString("destPath");
    }

    public long b() {
        return this.f35133a;
    }

    public String c() {
        return this.f35136d;
    }

    public String d() {
        return this.f35135c;
    }

    public int e() {
        return this.f35134b;
    }
}
