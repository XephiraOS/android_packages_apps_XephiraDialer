package io.grpc.internal;

import com.android.incallui.OplusAutoRedialNotificationUI;
import io.grpc.ChannelLogger;
import io.grpc.InternalChannelz$ChannelTrace$Event;
import java.text.MessageFormat;
import java.util.logging.Level;

/* compiled from: ChannelLoggerImpl.java */
/* renamed from: io.grpc.internal.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1126h extends ChannelLogger {

    /* renamed from: a, reason: collision with root package name */
    public final ChannelTracer f33177a;

    /* renamed from: b, reason: collision with root package name */
    public final v0 f33178b;

    /* compiled from: ChannelLoggerImpl.java */
    /* renamed from: io.grpc.internal.h$a */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33179a;

        static {
            int[] iArr = new int[ChannelLogger.ChannelLogLevel.values().length];
            f33179a = iArr;
            try {
                iArr[ChannelLogger.ChannelLogLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33179a[ChannelLogger.ChannelLogLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33179a[ChannelLogger.ChannelLogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C1126h(ChannelTracer channelTracer, v0 v0Var) {
        this.f33177a = (ChannelTracer) com.google.common.base.k.p(channelTracer, "tracer");
        this.f33178b = (v0) com.google.common.base.k.p(v0Var, OplusAutoRedialNotificationUI.TIME);
    }

    public static void d(j9.w wVar, ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
        Level f10 = f(channelLogLevel);
        if (ChannelTracer.f32464f.isLoggable(f10)) {
            ChannelTracer.d(wVar, f10, str);
        }
    }

    public static void e(j9.w wVar, ChannelLogger.ChannelLogLevel channelLogLevel, String str, Object... objArr) {
        Level f10 = f(channelLogLevel);
        if (ChannelTracer.f32464f.isLoggable(f10)) {
            ChannelTracer.d(wVar, f10, MessageFormat.format(str, objArr));
        }
    }

    public static Level f(ChannelLogger.ChannelLogLevel channelLogLevel) {
        int i10 = a.f33179a[channelLogLevel.ordinal()];
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return Level.FINEST;
            }
            return Level.FINER;
        }
        return Level.FINE;
    }

    public static InternalChannelz$ChannelTrace$Event.Severity g(ChannelLogger.ChannelLogLevel channelLogLevel) {
        int i10 = a.f33179a[channelLogLevel.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                return InternalChannelz$ChannelTrace$Event.Severity.CT_INFO;
            }
            return InternalChannelz$ChannelTrace$Event.Severity.CT_WARNING;
        }
        return InternalChannelz$ChannelTrace$Event.Severity.CT_ERROR;
    }

    @Override // io.grpc.ChannelLogger
    public void a(ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
        d(this.f33177a.b(), channelLogLevel, str);
        if (c(channelLogLevel)) {
            h(channelLogLevel, str);
        }
    }

    @Override // io.grpc.ChannelLogger
    public void b(ChannelLogger.ChannelLogLevel channelLogLevel, String str, Object... objArr) {
        String format;
        Level f10 = f(channelLogLevel);
        if (!c(channelLogLevel) && !ChannelTracer.f32464f.isLoggable(f10)) {
            format = null;
        } else {
            format = MessageFormat.format(str, objArr);
        }
        a(channelLogLevel, format);
    }

    public final boolean c(ChannelLogger.ChannelLogLevel channelLogLevel) {
        if (channelLogLevel != ChannelLogger.ChannelLogLevel.DEBUG && this.f33177a.c()) {
            return true;
        }
        return false;
    }

    public final void h(ChannelLogger.ChannelLogLevel channelLogLevel, String str) {
        if (channelLogLevel == ChannelLogger.ChannelLogLevel.DEBUG) {
            return;
        }
        this.f33177a.f(new InternalChannelz$ChannelTrace$Event.a().b(str).c(g(channelLogLevel)).e(this.f33178b.a()).a());
    }
}
