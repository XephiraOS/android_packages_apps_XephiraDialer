package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public int f11261a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, String> f11262b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final RemoteCallbackList<IMultiInstanceInvalidationCallback> f11263c = new a();

    /* renamed from: d, reason: collision with root package name */
    public final IMultiInstanceInvalidationService.Stub f11264d = new IMultiInstanceInvalidationService.Stub() { // from class: androidx.room.MultiInstanceInvalidationService.2
        @Override // androidx.room.IMultiInstanceInvalidationService
        public void B7(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i10) {
            synchronized (MultiInstanceInvalidationService.this.f11263c) {
                MultiInstanceInvalidationService.this.f11263c.unregister(iMultiInstanceInvalidationCallback);
                MultiInstanceInvalidationService.this.f11262b.remove(Integer.valueOf(i10));
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public int Z1(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f11263c) {
                try {
                    MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                    int i10 = multiInstanceInvalidationService.f11261a + 1;
                    multiInstanceInvalidationService.f11261a = i10;
                    if (multiInstanceInvalidationService.f11263c.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i10))) {
                        MultiInstanceInvalidationService.this.f11262b.put(Integer.valueOf(i10), str);
                        return i10;
                    }
                    MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                    multiInstanceInvalidationService2.f11261a--;
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationService
        public void c7(int i10, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f11263c) {
                try {
                    String str = MultiInstanceInvalidationService.this.f11262b.get(Integer.valueOf(i10));
                    if (str == null) {
                        Log.w("ROOM", "Remote invalidation client ID not registered");
                        return;
                    }
                    int beginBroadcast = MultiInstanceInvalidationService.this.f11263c.beginBroadcast();
                    for (int i11 = 0; i11 < beginBroadcast; i11++) {
                        try {
                            Integer num = (Integer) MultiInstanceInvalidationService.this.f11263c.getBroadcastCookie(i11);
                            int intValue = num.intValue();
                            String str2 = MultiInstanceInvalidationService.this.f11262b.get(num);
                            if (i10 != intValue && str.equals(str2)) {
                                try {
                                    MultiInstanceInvalidationService.this.f11263c.getBroadcastItem(i11).o1(strArr);
                                } catch (RemoteException e10) {
                                    Log.w("ROOM", "Error invoking a remote callback", e10);
                                }
                            }
                        } finally {
                            MultiInstanceInvalidationService.this.f11263c.finishBroadcast();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public class a extends RemoteCallbackList<IMultiInstanceInvalidationCallback> {
        public a() {
        }

        @Override // android.os.RemoteCallbackList
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
            HashMap<Integer, String> hashMap = MultiInstanceInvalidationService.this.f11262b;
            Integer num = (Integer) obj;
            num.intValue();
            hashMap.remove(num);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f11264d;
    }
}
