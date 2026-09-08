package m5;

import com.heytap.accessory.constant.AFConstants;
import org.json.JSONObject;

/* compiled from: TransferErrorMsg.java */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public long f35137a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f35138b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f35139c = -1;

    /* renamed from: d, reason: collision with root package name */
    public String f35140d = "";

    public void a(Object obj) {
        JSONObject jSONObject = new JSONObject((String) obj);
        this.f35137a = jSONObject.getLong(AFConstants.EXTRA_CONNECTION_ID);
        this.f35138b = jSONObject.getInt("transactionId");
        this.f35139c = jSONObject.getInt("errorCode");
        this.f35140d = jSONObject.getString("errorMsg");
    }

    public long b() {
        return this.f35137a;
    }

    public int c() {
        return this.f35139c;
    }

    public int d() {
        return this.f35138b;
    }
}
