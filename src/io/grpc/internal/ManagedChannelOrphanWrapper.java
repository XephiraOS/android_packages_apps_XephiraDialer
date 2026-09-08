package io.grpc.internal;

import j9.AbstractC1190B;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class ManagedChannelOrphanWrapper extends A {

    /* renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue<ManagedChannelOrphanWrapper> f32763c = new ReferenceQueue<>();

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentMap<ManagedChannelReference, ManagedChannelReference> f32764d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f32765e = Logger.getLogger(ManagedChannelOrphanWrapper.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public final ManagedChannelReference f32766b;

    /* loaded from: classes4.dex */
    public static final class ManagedChannelReference extends WeakReference<ManagedChannelOrphanWrapper> {

        /* renamed from: f, reason: collision with root package name */
        public static final boolean f32767f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));

        /* renamed from: g, reason: collision with root package name */
        public static final RuntimeException f32768g = d();

        /* renamed from: a, reason: collision with root package name */
        public final ReferenceQueue<ManagedChannelOrphanWrapper> f32769a;

        /* renamed from: b, reason: collision with root package name */
        public final ConcurrentMap<ManagedChannelReference, ManagedChannelReference> f32770b;

        /* renamed from: c, reason: collision with root package name */
        public final String f32771c;

        /* renamed from: d, reason: collision with root package name */
        public final Reference<RuntimeException> f32772d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f32773e;

        public ManagedChannelReference(ManagedChannelOrphanWrapper managedChannelOrphanWrapper, AbstractC1190B abstractC1190B, ReferenceQueue<ManagedChannelOrphanWrapper> referenceQueue, ConcurrentMap<ManagedChannelReference, ManagedChannelReference> concurrentMap) {
            super(managedChannelOrphanWrapper, referenceQueue);
            RuntimeException runtimeException;
            this.f32773e = new AtomicBoolean();
            if (f32767f) {
                runtimeException = new RuntimeException("ManagedChannel allocation site");
            } else {
                runtimeException = f32768g;
            }
            this.f32772d = new SoftReference(runtimeException);
            this.f32771c = abstractC1190B.toString();
            this.f32769a = referenceQueue;
            this.f32770b = concurrentMap;
            concurrentMap.put(this, this);
            cleanQueue(referenceQueue);
        }

        public static int cleanQueue(ReferenceQueue<ManagedChannelOrphanWrapper> referenceQueue) {
            int i10 = 0;
            while (true) {
                ManagedChannelReference managedChannelReference = (ManagedChannelReference) referenceQueue.poll();
                if (managedChannelReference != null) {
                    RuntimeException runtimeException = managedChannelReference.f32772d.get();
                    managedChannelReference.b();
                    if (!managedChannelReference.f32773e.get()) {
                        i10++;
                        Level level = Level.SEVERE;
                        if (ManagedChannelOrphanWrapper.f32765e.isLoggable(level)) {
                            LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was garbage collected without being shut down! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow()");
                            logRecord.setLoggerName(ManagedChannelOrphanWrapper.f32765e.getName());
                            logRecord.setParameters(new Object[]{managedChannelReference.f32771c});
                            logRecord.setThrown(runtimeException);
                            ManagedChannelOrphanWrapper.f32765e.log(logRecord);
                        }
                    }
                } else {
                    return i10;
                }
            }
        }

        public static RuntimeException d() {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            return runtimeException;
        }

        public final void b() {
            super.clear();
            this.f32770b.remove(this);
            this.f32772d.clear();
        }

        public final void c() {
            if (!this.f32773e.getAndSet(true)) {
                clear();
            }
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            b();
            cleanQueue(this.f32769a);
        }
    }

    public ManagedChannelOrphanWrapper(AbstractC1190B abstractC1190B) {
        this(abstractC1190B, f32763c, f32764d);
    }

    @Override // io.grpc.internal.A, j9.AbstractC1190B
    public AbstractC1190B d() {
        this.f32766b.c();
        return super.d();
    }

    public ManagedChannelOrphanWrapper(AbstractC1190B abstractC1190B, ReferenceQueue<ManagedChannelOrphanWrapper> referenceQueue, ConcurrentMap<ManagedChannelReference, ManagedChannelReference> concurrentMap) {
        super(abstractC1190B);
        this.f32766b = new ManagedChannelReference(this, abstractC1190B, referenceQueue, concurrentMap);
    }
}
