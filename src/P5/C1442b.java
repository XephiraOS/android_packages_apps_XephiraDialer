package p5;

import org.json.JSONObject;

/* compiled from: CancelAllRequest.java */
/* renamed from: p5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1442b {

    /* renamed from: a, reason: collision with root package name */
    public String f36021a;

    /* renamed from: b, reason: collision with root package name */
    public long f36022b;

    public C1442b(String str, long j10) {
        this.f36021a = str;
        this.f36022b = j10;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("AgentId", this.f36021a);
        jSONObject.put("ConnectionId", this.f36022b);
        return jSONObject;
    }
}
