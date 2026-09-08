package io.grpc;

/* loaded from: classes4.dex */
public final class InternalChannelz$ChannelTrace$Event {

    /* renamed from: a, reason: collision with root package name */
    public final String f32317a;

    /* renamed from: b, reason: collision with root package name */
    public final Severity f32318b;

    /* renamed from: c, reason: collision with root package name */
    public final long f32319c;

    /* renamed from: d, reason: collision with root package name */
    public final j9.z f32320d;

    /* renamed from: e, reason: collision with root package name */
    public final j9.z f32321e;

    /* loaded from: classes4.dex */
    public enum Severity {
        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f32327a;

        /* renamed from: b, reason: collision with root package name */
        public Severity f32328b;

        /* renamed from: c, reason: collision with root package name */
        public Long f32329c;

        /* renamed from: d, reason: collision with root package name */
        public j9.z f32330d;

        /* renamed from: e, reason: collision with root package name */
        public j9.z f32331e;

        public InternalChannelz$ChannelTrace$Event a() {
            boolean z10;
            com.google.common.base.k.p(this.f32327a, "description");
            com.google.common.base.k.p(this.f32328b, "severity");
            com.google.common.base.k.p(this.f32329c, "timestampNanos");
            if (this.f32330d != null && this.f32331e != null) {
                z10 = false;
            } else {
                z10 = true;
            }
            com.google.common.base.k.v(z10, "at least one of channelRef and subchannelRef must be null");
            return new InternalChannelz$ChannelTrace$Event(this.f32327a, this.f32328b, this.f32329c.longValue(), this.f32330d, this.f32331e);
        }

        public a b(String str) {
            this.f32327a = str;
            return this;
        }

        public a c(Severity severity) {
            this.f32328b = severity;
            return this;
        }

        public a d(j9.z zVar) {
            this.f32331e = zVar;
            return this;
        }

        public a e(long j10) {
            this.f32329c = Long.valueOf(j10);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InternalChannelz$ChannelTrace$Event)) {
            return false;
        }
        InternalChannelz$ChannelTrace$Event internalChannelz$ChannelTrace$Event = (InternalChannelz$ChannelTrace$Event) obj;
        if (!com.google.common.base.h.a(this.f32317a, internalChannelz$ChannelTrace$Event.f32317a) || !com.google.common.base.h.a(this.f32318b, internalChannelz$ChannelTrace$Event.f32318b) || this.f32319c != internalChannelz$ChannelTrace$Event.f32319c || !com.google.common.base.h.a(this.f32320d, internalChannelz$ChannelTrace$Event.f32320d) || !com.google.common.base.h.a(this.f32321e, internalChannelz$ChannelTrace$Event.f32321e)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return com.google.common.base.h.b(this.f32317a, this.f32318b, Long.valueOf(this.f32319c), this.f32320d, this.f32321e);
    }

    public String toString() {
        return com.google.common.base.f.c(this).d("description", this.f32317a).d("severity", this.f32318b).c("timestampNanos", this.f32319c).d("channelRef", this.f32320d).d("subchannelRef", this.f32321e).toString();
    }

    public InternalChannelz$ChannelTrace$Event(String str, Severity severity, long j10, j9.z zVar, j9.z zVar2) {
        this.f32317a = str;
        this.f32318b = (Severity) com.google.common.base.k.p(severity, "severity");
        this.f32319c = j10;
        this.f32320d = zVar;
        this.f32321e = zVar2;
    }
}
