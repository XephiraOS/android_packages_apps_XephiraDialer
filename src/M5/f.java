package m5;

import org.json.JSONObject;

/* compiled from: FileSendEntity.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public String f35119a;

    /* renamed from: b, reason: collision with root package name */
    public String f35120b;

    /* renamed from: c, reason: collision with root package name */
    public String f35121c;

    /* renamed from: d, reason: collision with root package name */
    public String f35122d;

    /* renamed from: e, reason: collision with root package name */
    public long f35123e;

    /* renamed from: f, reason: collision with root package name */
    public long f35124f;

    /* renamed from: g, reason: collision with root package name */
    public String f35125g;

    /* renamed from: h, reason: collision with root package name */
    public String f35126h;

    /* renamed from: i, reason: collision with root package name */
    public String f35127i;

    /* renamed from: j, reason: collision with root package name */
    public String f35128j;

    /* renamed from: k, reason: collision with root package name */
    public String f35129k;

    public f(String str, String str2, String str3, String str4, String str5, long j10, long j11, String str6, String str7, String str8, String str9) {
        this.f35119a = str;
        this.f35120b = str2;
        this.f35129k = str3;
        this.f35121c = str4;
        this.f35122d = str5;
        this.f35123e = j10;
        this.f35124f = j11;
        this.f35125g = str6;
        this.f35126h = str7;
        this.f35127i = str8;
        this.f35128j = str9;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SourcePath", this.f35119a);
        jSONObject.put("DestinationPath", this.f35120b);
        jSONObject.put("PeerId", this.f35121c);
        jSONObject.put("ContainerId", this.f35122d);
        jSONObject.put("AccessoryId", this.f35123e);
        jSONObject.put("FileSize", this.f35124f);
        jSONObject.put("FileName", this.f35125g);
        jSONObject.put("FileURI", this.f35126h);
        jSONObject.put("PackageName", this.f35127i);
        jSONObject.put("AgentClassName", this.f35128j);
        jSONObject.put("FileInfo", this.f35129k);
        return jSONObject;
    }
}
