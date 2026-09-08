package com.heytap.accessory.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.accessory.discovery.IScanFilter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class ClassScanFilter implements IScanFilter {
    public static final Parcelable.Creator<ClassScanFilter> CREATOR = new Parcelable.Creator<ClassScanFilter>() { // from class: com.heytap.accessory.bean.ClassScanFilter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClassScanFilter createFromParcel(Parcel parcel) {
            return new ClassScanFilter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClassScanFilter[] newArray(int i10) {
            return new ClassScanFilter[i10];
        }
    };
    public static final String KEY = "ClassScanFilter";
    private Map<Integer, HashSet<Integer>> mMap;

    private ClassScanFilter() {
        this.mMap = new HashMap();
    }

    public static ClassScanFilter create() {
        return new ClassScanFilter();
    }

    private HashSet<Integer> getMajorSet(int i10) {
        HashSet<Integer> hashSet = this.mMap.get(Integer.valueOf(i10));
        if (hashSet == null) {
            HashSet<Integer> hashSet2 = new HashSet<>();
            this.mMap.put(Integer.valueOf(i10), hashSet2);
            return hashSet2;
        }
        return hashSet;
    }

    private boolean validityCheck(int i10, int i11, int i12) {
        if (i12 >= i10 && i12 <= i11) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.heytap.accessory.discovery.IScanFilter
    public String getKey() {
        return KEY;
    }

    public Map<Integer, HashSet<Integer>> getMap() {
        return this.mMap;
    }

    public ClassScanFilter put(int i10, int i11) {
        if (!validityCheck(1, 10, i10)) {
            switch (i10) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                    if (!validityCheck(0, 0, i11)) {
                        getMajorSet(i10).add(Integer.valueOf(i11));
                        return this;
                    }
                    throw new IllegalArgumentException("unknown major: " + i10 + ", minor: " + i11);
                case 2:
                case 9:
                default:
                    throw new IllegalArgumentException("unknown major in switch: " + i10);
            }
        }
        throw new IllegalArgumentException("unknown major: " + i10);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClassScanFilter {\n");
        for (Map.Entry<Integer, HashSet<Integer>> entry : this.mMap.entrySet()) {
            sb.append("major " + entry.getKey() + ", minor [");
            Iterator<Integer> it = entry.getValue().iterator();
            while (it.hasNext()) {
                sb.append(" " + it.next());
            }
            sb.append(" ]\n");
        }
        sb.append("\n}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mMap.size());
        for (Map.Entry<Integer, HashSet<Integer>> entry : this.mMap.entrySet()) {
            parcel.writeValue(entry.getKey());
            parcel.writeInt(entry.getValue().size());
            Iterator<Integer> it = entry.getValue().iterator();
            while (it.hasNext()) {
                parcel.writeValue(it.next());
            }
        }
    }

    public ClassScanFilter(Parcel parcel) {
        this.mMap = new HashMap();
        int readInt = parcel.readInt();
        this.mMap = new HashMap(readInt);
        if (readInt > 0) {
            for (int i10 = 0; i10 < readInt; i10++) {
                Integer num = (Integer) parcel.readValue(Integer.class.getClassLoader());
                if (num == null) {
                    return;
                }
                HashSet<Integer> hashSet = new HashSet<>();
                this.mMap.put(num, hashSet);
                int readInt2 = parcel.readInt();
                if (readInt2 > 0) {
                    for (int i11 = 0; i11 < readInt2; i11++) {
                        hashSet.add((Integer) parcel.readValue(Integer.class.getClassLoader()));
                    }
                }
            }
        }
    }
}
