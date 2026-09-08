package com.android.contacts.model;

import android.content.Entity;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.model.EntityDelta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import n1.AbstractC1362a;

/* loaded from: classes.dex */
public class EntityDeltaList extends ArrayList<EntityDelta> implements Parcelable {
    public static final Parcelable.Creator<EntityDeltaList> CREATOR = new a();
    private long[] mJoinWithRawContactIds;
    private EntityDelta.b mMenu;
    private boolean mSplitRawContacts;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<EntityDeltaList> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EntityDeltaList createFromParcel(Parcel parcel) {
            EntityDeltaList entityDeltaList = new EntityDeltaList();
            entityDeltaList.n(parcel);
            return entityDeltaList;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EntityDeltaList[] newArray(int i10) {
            return new EntityDeltaList[i10];
        }
    }

    public static EntityDeltaList k(Iterator<Entity> it) {
        EntityDeltaList entityDeltaList = new EntityDeltaList();
        while (it.hasNext()) {
            entityDeltaList.add(EntityDelta.q(it.next()));
        }
        return entityDeltaList;
    }

    public static EntityDeltaList m(EntityDelta entityDelta) {
        EntityDeltaList entityDeltaList = new EntityDeltaList();
        entityDeltaList.add(entityDelta);
        return entityDeltaList;
    }

    public static EntityDelta q(EntityDeltaList entityDeltaList, long j10, AbstractC1362a abstractC1362a) {
        EntityDelta entityDelta;
        if (entityDeltaList.size() == 1) {
            return entityDeltaList.get(0);
        }
        EntityDelta entityDelta2 = new EntityDelta(new EntityDelta.ValuesDelta());
        Iterator<EntityDelta> it = entityDeltaList.iterator();
        EntityDelta entityDelta3 = null;
        EntityDelta entityDelta4 = null;
        while (it.hasNext()) {
            entityDelta = it.next();
            EntityDelta.ValuesDelta N10 = entityDelta.N();
            boolean b10 = abstractC1362a.c(N10.z("account_type"), null).b();
            try {
                if (j10 == N10.x(BreenoCallContract.BaseColumns._ID).longValue()) {
                    entityDelta4 = entityDelta;
                    if (b10) {
                        break;
                    }
                } else if (b10 && entityDelta3 == null) {
                    entityDelta3 = entityDelta;
                    if (entityDelta4 != null) {
                        break;
                    }
                }
            } catch (Exception e10) {
                H7.b.c("EntityDeltaList", e10.toString());
            }
        }
        entityDelta = null;
        if (entityDelta == null) {
            if (entityDelta3 != null) {
                entityDelta = entityDelta3;
            } else if (entityDelta4 != null) {
                entityDelta = entityDelta4;
            } else {
                entityDelta = entityDeltaList.get(0);
            }
        }
        for (Map.Entry<String, ArrayList<EntityDelta.ValuesDelta>> entry : entityDelta.x().entrySet()) {
            entityDelta2.b(entry.getKey(), entry.getValue());
        }
        long longValue = entityDelta.N().E().longValue();
        Iterator<EntityDelta> it2 = entityDeltaList.iterator();
        while (it2.hasNext()) {
            EntityDelta next = it2.next();
            EntityDelta.ValuesDelta N11 = next.N();
            if (longValue != N11.x(BreenoCallContract.BaseColumns._ID).longValue()) {
                boolean b11 = abstractC1362a.c(N11.z("account_type"), null).b();
                for (Map.Entry<String, ArrayList<EntityDelta.ValuesDelta>> entry2 : next.x().entrySet()) {
                    if (!b11) {
                        entityDelta2.h(entry2.getKey(), entry2.getValue());
                    }
                    entityDelta2.b(entry2.getKey(), entry2.getValue());
                }
            }
        }
        entityDelta2.A0(entityDelta.N());
        entityDelta2.N().s0(BreenoCallContract.BaseColumns._ID);
        return entityDelta2;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends EntityDelta> collection) {
        if (this.mMenu != null) {
            Iterator<? extends EntityDelta> it = collection.iterator();
            while (it.hasNext()) {
                it.next().s0(this.mMenu);
            }
        }
        return super.addAll(collection);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void add(int i10, EntityDelta entityDelta) {
        EntityDelta.b bVar = this.mMenu;
        if (bVar != null) {
            entityDelta.s0(bVar);
        }
        super.add(i10, entityDelta);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean add(EntityDelta entityDelta) {
        EntityDelta.b bVar = this.mMenu;
        if (bVar != null) {
            entityDelta.s0(bVar);
        }
        return super.add(entityDelta);
    }

    public final void n(Parcel parcel) {
        ClassLoader classLoader = getClass().getClassLoader();
        int readInt = parcel.readInt();
        boolean z10 = false;
        for (int i10 = 0; i10 < readInt; i10++) {
            add((EntityDelta) parcel.readParcelable(classLoader));
        }
        this.mJoinWithRawContactIds = parcel.createLongArray();
        if (parcel.readInt() != 0) {
            z10 = true;
        }
        this.mSplitRawContacts = z10;
    }

    public void p(EntityDelta.b bVar) {
        this.mMenu = bVar;
        if (bVar != null) {
            Iterator<EntityDelta> it = iterator();
            while (it.hasNext()) {
                it.next().s0(this.mMenu);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        try {
            parcel.writeInt(size());
            Iterator<EntityDelta> it = iterator();
            while (it.hasNext()) {
                parcel.writeParcelable(it.next(), i10);
            }
            parcel.writeLongArray(this.mJoinWithRawContactIds);
            parcel.writeInt(this.mSplitRawContacts ? 1 : 0);
        } catch (Exception e10) {
            H7.b.b("EntityDeltaList", "Exception = " + e10);
        }
    }

    private EntityDeltaList() {
        this.mMenu = null;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends EntityDelta> collection) {
        if (this.mMenu != null) {
            Iterator<? extends EntityDelta> it = collection.iterator();
            while (it.hasNext()) {
                it.next().s0(this.mMenu);
            }
        }
        return super.addAll(i10, collection);
    }
}
