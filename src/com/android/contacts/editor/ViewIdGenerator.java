package com.android.contacts.editor;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.contacts.model.EntityDelta;

/* loaded from: classes.dex */
public final class ViewIdGenerator implements Parcelable {

    /* renamed from: c, reason: collision with root package name */
    public static final StringBuilder f15457c = new StringBuilder();
    public static final Parcelable.Creator<ViewIdGenerator> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public Bundle f15459b = new Bundle();

    /* renamed from: a, reason: collision with root package name */
    public int f15458a = 1;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<ViewIdGenerator> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ViewIdGenerator createFromParcel(Parcel parcel) {
            ViewIdGenerator viewIdGenerator = new ViewIdGenerator();
            viewIdGenerator.h(parcel);
            return viewIdGenerator;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ViewIdGenerator[] newArray(int i10) {
            return new ViewIdGenerator[i10];
        }
    }

    public static String f(EntityDelta entityDelta, com.android.contacts.model.c cVar, EntityDelta.ValuesDelta valuesDelta, int i10) {
        StringBuilder sb = f15457c;
        sb.setLength(0);
        if (entityDelta != null) {
            sb.append(entityDelta.N().E());
            if (cVar != null) {
                sb.append('*');
                sb.append(cVar.f17004c);
                if (valuesDelta != null) {
                    sb.append('*');
                    sb.append(valuesDelta.E());
                    if (i10 != -1) {
                        sb.append('*');
                        sb.append(i10);
                    }
                }
            }
        }
        return sb.toString();
    }

    public int d(EntityDelta entityDelta, com.android.contacts.model.c cVar, EntityDelta.ValuesDelta valuesDelta, int i10) {
        String f10 = f(entityDelta, cVar, valuesDelta, i10);
        int i11 = this.f15459b.getInt(f10, 0);
        if (i11 == 0) {
            int i12 = this.f15458a;
            this.f15458a = i12 + 1;
            int i13 = i12 & 65535;
            this.f15459b.putInt(f10, i13);
            return i13;
        }
        return i11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void h(Parcel parcel) {
        this.f15458a = parcel.readInt();
        this.f15459b = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f15458a);
        parcel.writeBundle(this.f15459b);
    }
}
