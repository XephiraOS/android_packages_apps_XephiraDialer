package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: h, reason: collision with root package name */
    public static final Object f9335h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static final HashMap<ComponentName, g> f9336i = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public b f9337a;

    /* renamed from: b, reason: collision with root package name */
    public g f9338b;

    /* renamed from: c, reason: collision with root package name */
    public a f9339c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9340d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9341e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9342f = false;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<c> f9343g = null;

    /* loaded from: classes.dex */
    public final class a extends AsyncTask<Void, Void, Void> {
        public a() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            while (true) {
                d a10 = JobIntentService.this.a();
                if (a10 != null) {
                    JobIntentService.this.g(a10.getIntent());
                    a10.a();
                } else {
                    return null;
                }
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onCancelled(Void r12) {
            JobIntentService.this.i();
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r12) {
            JobIntentService.this.i();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        IBinder a();

        d b();
    }

    /* loaded from: classes.dex */
    public final class c implements d {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f9345a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9346b;

        public c(Intent intent, int i10) {
            this.f9345a = intent;
            this.f9346b = i10;
        }

        @Override // androidx.core.app.JobIntentService.d
        public void a() {
            JobIntentService.this.stopSelf(this.f9346b);
        }

        @Override // androidx.core.app.JobIntentService.d
        public Intent getIntent() {
            return this.f9345a;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        Intent getIntent();
    }

    /* loaded from: classes.dex */
    public static final class e extends JobServiceEngine implements b {

        /* renamed from: a, reason: collision with root package name */
        public final JobIntentService f9348a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f9349b;

        /* renamed from: c, reason: collision with root package name */
        public JobParameters f9350c;

        /* loaded from: classes.dex */
        public final class a implements d {

            /* renamed from: a, reason: collision with root package name */
            public final JobWorkItem f9351a;

            public a(JobWorkItem jobWorkItem) {
                this.f9351a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.d
            public void a() {
                synchronized (e.this.f9349b) {
                    try {
                        JobParameters jobParameters = e.this.f9350c;
                        if (jobParameters != null) {
                            jobParameters.completeWork(this.f9351a);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.d
            public Intent getIntent() {
                return this.f9351a.getIntent();
            }
        }

        public e(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f9349b = new Object();
            this.f9348a = jobIntentService;
        }

        @Override // androidx.core.app.JobIntentService.b
        public IBinder a() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.b
        public d b() {
            synchronized (this.f9349b) {
                try {
                    JobParameters jobParameters = this.f9350c;
                    if (jobParameters == null) {
                        return null;
                    }
                    JobWorkItem dequeueWork = jobParameters.dequeueWork();
                    if (dequeueWork == null) {
                        return null;
                    }
                    dequeueWork.getIntent().setExtrasClassLoader(this.f9348a.getClassLoader());
                    return new a(dequeueWork);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f9350c = jobParameters;
            this.f9348a.e(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            boolean b10 = this.f9348a.b();
            synchronized (this.f9349b) {
                this.f9350c = null;
            }
            return b10;
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends g {

        /* renamed from: d, reason: collision with root package name */
        public final JobInfo f9353d;

        /* renamed from: e, reason: collision with root package name */
        public final JobScheduler f9354e;

        public f(Context context, ComponentName componentName, int i10) {
            super(componentName);
            b(i10);
            this.f9353d = new JobInfo.Builder(i10, this.f9355a).setOverrideDeadline(0L).build();
            this.f9354e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.g
        public void a(Intent intent) {
            this.f9354e.enqueue(this.f9353d, new JobWorkItem(intent));
        }
    }

    public static void c(Context context, ComponentName componentName, int i10, Intent intent) {
        if (intent != null) {
            synchronized (f9335h) {
                g f10 = f(context, componentName, true, i10);
                f10.b(i10);
                f10.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    public static void d(Context context, Class<?> cls, int i10, Intent intent) {
        c(context, new ComponentName(context, cls), i10, intent);
    }

    public static g f(Context context, ComponentName componentName, boolean z10, int i10) {
        HashMap<ComponentName, g> hashMap = f9336i;
        g gVar = hashMap.get(componentName);
        if (gVar == null) {
            if (z10) {
                f fVar = new f(context, componentName, i10);
                hashMap.put(componentName, fVar);
                return fVar;
            }
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        return gVar;
    }

    public d a() {
        b bVar = this.f9337a;
        if (bVar != null) {
            return bVar.b();
        }
        synchronized (this.f9343g) {
            try {
                if (this.f9343g.size() > 0) {
                    return this.f9343g.remove(0);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        a aVar = this.f9339c;
        if (aVar != null) {
            aVar.cancel(this.f9340d);
        }
        this.f9341e = true;
        return h();
    }

    public void e(boolean z10) {
        if (this.f9339c == null) {
            this.f9339c = new a();
            g gVar = this.f9338b;
            if (gVar != null && z10) {
                gVar.d();
            }
            this.f9339c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public abstract void g(Intent intent);

    public boolean h() {
        return true;
    }

    public void i() {
        ArrayList<c> arrayList = this.f9343g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f9339c = null;
                    ArrayList<c> arrayList2 = this.f9343g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        e(false);
                    } else if (!this.f9342f) {
                        this.f9338b.c();
                    }
                } finally {
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b bVar = this.f9337a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f9337a = new e(this);
        this.f9338b = null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<c> arrayList = this.f9343g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f9342f = true;
                this.f9338b.c();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (this.f9343g != null) {
            this.f9338b.e();
            synchronized (this.f9343g) {
                ArrayList<c> arrayList = this.f9343g;
                if (intent == null) {
                    intent = new Intent();
                }
                arrayList.add(new c(intent, i11));
                e(true);
            }
            return 3;
        }
        return 2;
    }

    /* loaded from: classes.dex */
    public static abstract class g {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f9355a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f9356b;

        /* renamed from: c, reason: collision with root package name */
        public int f9357c;

        public g(ComponentName componentName) {
            this.f9355a = componentName;
        }

        public abstract void a(Intent intent);

        public void b(int i10) {
            if (!this.f9356b) {
                this.f9356b = true;
                this.f9357c = i10;
            } else {
                if (this.f9357c == i10) {
                    return;
                }
                throw new IllegalArgumentException("Given job ID " + i10 + " is different than previous " + this.f9357c);
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }
}
