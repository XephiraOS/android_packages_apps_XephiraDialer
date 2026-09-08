package com.customize.contacts.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.contacts.model.EntityDelta;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class EntitySet extends ArrayList<EntityDelta> implements Parcelable {
    public static final Parcelable.Creator<EntitySet> CREATOR = new a();

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<EntitySet> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EntitySet createFromParcel(Parcel parcel) {
            EntitySet entitySet = new EntitySet();
            entitySet.i(parcel);
            return entitySet;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EntitySet[] newArray(int i10) {
            return new EntitySet[i10];
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.customize.contacts.model.EntitySet h(android.content.ContentResolver r7, java.lang.String r8, java.lang.String[] r9, java.lang.String r10) {
        /*
            r0 = 0
            android.net.Uri r2 = android.provider.ContactsContract.RawContactsEntity.CONTENT_URI     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            r3 = 0
            r1 = r7
            r4 = r8
            r5 = r9
            r6 = r10
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L53
            if (r7 != 0) goto L1a
            if (r7 == 0) goto L19
            boolean r8 = r7.isClosed()
            if (r8 != 0) goto L19
            r7.close()
        L19:
            return r0
        L1a:
            android.content.EntityIterator r8 = android.provider.ContactsContract.RawContacts.newEntityIterator(r7)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            com.customize.contacts.model.EntitySet r9 = new com.customize.contacts.model.EntitySet     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            r9.<init>()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
        L23:
            boolean r10 = r8.hasNext()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            if (r10 == 0) goto L3c
            java.lang.Object r10 = r8.next()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            android.content.Entity r10 = (android.content.Entity) r10     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            com.android.contacts.model.EntityDelta r10 = com.android.contacts.model.EntityDelta.q(r10)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            r9.add(r10)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            goto L23
        L37:
            r9 = move-exception
            r0 = r8
            goto L7d
        L3a:
            r9 = move-exception
            goto L56
        L3c:
            r8.close()
            if (r7 == 0) goto L4a
            boolean r8 = r7.isClosed()
            if (r8 != 0) goto L4a
            r7.close()
        L4a:
            return r9
        L4b:
            r9 = move-exception
            goto L7d
        L4d:
            r9 = move-exception
            r8 = r0
            goto L56
        L50:
            r9 = move-exception
            r7 = r0
            goto L7d
        L53:
            r9 = move-exception
            r7 = r0
            r8 = r7
        L56:
            java.lang.String r10 = "EntitySet"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L37
            r1.<init>()     // Catch: java.lang.Throwable -> L37
            java.lang.String r2 = "Exception e: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L37
            r1.append(r9)     // Catch: java.lang.Throwable -> L37
            java.lang.String r9 = r1.toString()     // Catch: java.lang.Throwable -> L37
            H7.b.c(r10, r9)     // Catch: java.lang.Throwable -> L37
            if (r8 == 0) goto L71
            r8.close()
        L71:
            if (r7 == 0) goto L7c
            boolean r8 = r7.isClosed()
            if (r8 != 0) goto L7c
            r7.close()
        L7c:
            return r0
        L7d:
            if (r0 == 0) goto L82
            r0.close()
        L82:
            if (r7 == 0) goto L8d
            boolean r8 = r7.isClosed()
            if (r8 != 0) goto L8d
            r7.close()
        L8d:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.model.EntitySet.h(android.content.ContentResolver, java.lang.String, java.lang.String[], java.lang.String):com.customize.contacts.model.EntitySet");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void i(Parcel parcel) {
        ClassLoader classLoader = getClass().getClassLoader();
        int readInt = parcel.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            add((EntityDelta) parcel.readParcelable(classLoader));
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(size());
        Iterator<EntityDelta> it = iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), i10);
        }
    }

    private EntitySet() {
    }
}
