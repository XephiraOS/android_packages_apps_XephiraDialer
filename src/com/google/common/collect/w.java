package com.google.common.collect;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Serialization.java */
/* loaded from: classes3.dex */
public final class w {
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void a(p<K, V> pVar, ObjectInputStream objectInputStream, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            Collection collection = pVar.get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i12 = 0; i12 < readInt; i12++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    public static int b(ObjectInputStream objectInputStream) {
        return objectInputStream.readInt();
    }

    public static <K, V> void c(p<K, V> pVar, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(pVar.a().size());
        for (Map.Entry<K, Collection<V>> entry : pVar.a().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }
}
