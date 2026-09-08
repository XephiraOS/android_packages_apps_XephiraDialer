package com.oplus.aiunit.core.data;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class AIConfig {

    /* renamed from: g, reason: collision with root package name */
    public static final a f25576g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public String f25577a;

    /* renamed from: b, reason: collision with root package name */
    public int f25578b;

    /* renamed from: c, reason: collision with root package name */
    public long f25579c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f25580d;

    /* renamed from: e, reason: collision with root package name */
    public int f25581e;

    /* renamed from: f, reason: collision with root package name */
    public int f25582f;

    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final AIConfig a(JSONObject json) {
            i.f(json, "json");
            String optString = json.optString("detectName", "");
            i.e(optString, "optString(...)");
            AIConfig aIConfig = new AIConfig(optString, json.optInt("unitId", 0), json.optLong("unitVersion", 0L));
            aIConfig.c(json.optBoolean("support", true));
            aIConfig.b(json.optInt("minSdk", 0));
            aIConfig.a(json.optInt("minApi", 0));
            return aIConfig;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public AIConfig(String detectName, int i10, long j10) {
        i.f(detectName, "detectName");
        this.f25577a = detectName;
        this.f25578b = i10;
        this.f25579c = j10;
        this.f25580d = true;
    }

    public final void a(int i10) {
        this.f25582f = i10;
    }

    public final void b(int i10) {
        this.f25581e = i10;
    }

    public final void c(boolean z10) {
        this.f25580d = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AIConfig)) {
            return false;
        }
        AIConfig aIConfig = (AIConfig) obj;
        if (i.b(this.f25577a, aIConfig.f25577a) && this.f25578b == aIConfig.f25578b && this.f25579c == aIConfig.f25579c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Long.hashCode(this.f25579c) + ((Integer.hashCode(this.f25578b) + (this.f25577a.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "AI(" + this.f25577a + ", " + this.f25578b + ", " + this.f25579c + ", " + this.f25580d + ", " + this.f25581e + ", " + this.f25582f + ')';
    }
}
