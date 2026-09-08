package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* compiled from: InvalidationLiveDataContainer.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final Set<LiveData> f11355a = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: b, reason: collision with root package name */
    public final RoomDatabase f11356b;

    public q(RoomDatabase roomDatabase) {
        this.f11356b = roomDatabase;
    }
}
