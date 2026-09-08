package io.grpc.internal;

import io.grpc.ChannelLogger;
import io.grpc.InternalChannelz$ChannelTrace$Event;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class ChannelTracer {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f32464f = Logger.getLogger(ChannelLogger.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final Object f32465a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final j9.w f32466b;

    /* renamed from: c, reason: collision with root package name */
    public final Collection<InternalChannelz$ChannelTrace$Event> f32467c;

    /* renamed from: d, reason: collision with root package name */
    public final long f32468d;

    /* renamed from: e, reason: collision with root package name */
    public int f32469e;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32470a;

        static {
            int[] iArr = new int[InternalChannelz$ChannelTrace$Event.Severity.values().length];
            f32470a = iArr;
            try {
                iArr[InternalChannelz$ChannelTrace$Event.Severity.CT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32470a[InternalChannelz$ChannelTrace$Event.Severity.CT_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ChannelTracer(j9.w wVar, final int i10, long j10, String str) {
        com.google.common.base.k.p(str, "description");
        this.f32466b = (j9.w) com.google.common.base.k.p(wVar, "logId");
        if (i10 > 0) {
            this.f32467c = new ArrayDeque<InternalChannelz$ChannelTrace$Event>() { // from class: io.grpc.internal.ChannelTracer.1
                @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public boolean add(InternalChannelz$ChannelTrace$Event internalChannelz$ChannelTrace$Event) {
                    if (size() == i10) {
                        removeFirst();
                    }
                    ChannelTracer.a(ChannelTracer.this);
                    return super.add(internalChannelz$ChannelTrace$Event);
                }
            };
        } else {
            this.f32467c = null;
        }
        this.f32468d = j10;
        e(new InternalChannelz$ChannelTrace$Event.a().b(str + " created").c(InternalChannelz$ChannelTrace$Event.Severity.CT_INFO).e(j10).a());
    }

    public static /* synthetic */ int a(ChannelTracer channelTracer) {
        int i10 = channelTracer.f32469e;
        channelTracer.f32469e = i10 + 1;
        return i10;
    }

    public static void d(j9.w wVar, Level level, String str) {
        Logger logger = f32464f;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + wVar + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public j9.w b() {
        return this.f32466b;
    }

    public boolean c() {
        boolean z10;
        synchronized (this.f32465a) {
            if (this.f32467c != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public void e(InternalChannelz$ChannelTrace$Event internalChannelz$ChannelTrace$Event) {
        Level level;
        int i10 = a.f32470a[internalChannelz$ChannelTrace$Event.f32318b.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                level = Level.FINEST;
            } else {
                level = Level.FINER;
            }
        } else {
            level = Level.FINE;
        }
        f(internalChannelz$ChannelTrace$Event);
        d(this.f32466b, level, internalChannelz$ChannelTrace$Event.f32317a);
    }

    public void f(InternalChannelz$ChannelTrace$Event internalChannelz$ChannelTrace$Event) {
        synchronized (this.f32465a) {
            try {
                Collection<InternalChannelz$ChannelTrace$Event> collection = this.f32467c;
                if (collection != null) {
                    collection.add(internalChannelz$ChannelTrace$Event);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
