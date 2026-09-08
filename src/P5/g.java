package p5;

import org.json.JSONObject;

/* compiled from: StreamSendEntity.java */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public String f36034a;

    /* renamed from: b, reason: collision with root package name */
    public String f36035b;

    /* renamed from: c, reason: collision with root package name */
    public long f36036c;

    /* renamed from: d, reason: collision with root package name */
    public String f36037d;

    /* renamed from: e, reason: collision with root package name */
    public String f36038e;

    public g(String str, String str2, long j10, String str3, String str4) {
        this.f36034a = str;
        this.f36035b = str2;
        this.f36036c = j10;
        this.f36037d = str3;
        this.f36038e = str4;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("PeerId", this.f36034a);
        jSONObject.put("ContainerId", this.f36035b);
        jSONObject.put("AccessoryId", this.f36036c);
        jSONObject.put("PackageName", this.f36037d);
        jSONObject.put("AgentClassName", this.f36038e);
        return jSONObject;
    }
}
