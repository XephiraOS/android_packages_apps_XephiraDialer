package p5;

import com.heytap.accessory.constant.AFConstants;
import org.json.JSONObject;

/* compiled from: TransferErrorMsg.java */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public long f36039a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f36040b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f36041c = -1;

    /* renamed from: d, reason: collision with root package name */
    public String f36042d = "";

    public void a(Object obj) {
        JSONObject jSONObject = new JSONObject((String) obj);
        this.f36039a = jSONObject.getLong(AFConstants.EXTRA_CONNECTION_ID);
        this.f36040b = jSONObject.getInt("transactionId");
        this.f36041c = jSONObject.getInt("errorCode");
        this.f36042d = jSONObject.getString("errorMsg");
    }

    public long b() {
        return this.f36039a;
    }

    public int c() {
        return this.f36041c;
    }

    public int d() {
        return this.f36040b;
    }
}
