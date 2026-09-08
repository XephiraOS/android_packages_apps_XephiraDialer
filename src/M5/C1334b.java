package m5;

import com.heytap.accessory.constant.AFConstants;
import org.json.JSONObject;

/* compiled from: CancelFileRequest.java */
/* renamed from: m5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1334b {

    /* renamed from: a, reason: collision with root package name */
    public long f35104a;

    /* renamed from: b, reason: collision with root package name */
    public int f35105b;

    public C1334b(long j10, int i10) {
        this.f35104a = j10;
        this.f35105b = i10;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AFConstants.EXTRA_CONNECTION_ID, this.f35104a);
        jSONObject.put("TransactionId", this.f35105b);
        return jSONObject;
    }
}
