package com.oplus.compat.app;

import android.content.ComponentName;
import android.content.res.Configuration;
import android.graphics.ColorSpace;
import android.graphics.GraphicBuffer;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class TaskSnapshotNative implements Parcelable {
    public static final Parcelable.Creator<TaskSnapshotNative> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final long f27772a;

    /* renamed from: b, reason: collision with root package name */
    public final ComponentName f27773b;

    /* renamed from: c, reason: collision with root package name */
    public final GraphicBuffer f27774c;

    /* renamed from: d, reason: collision with root package name */
    @Configuration.Orientation
    public final int f27775d;

    /* renamed from: e, reason: collision with root package name */
    public final int f27776e;

    /* renamed from: f, reason: collision with root package name */
    public final Point f27777f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f27778g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f27779h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f27780i;

    /* renamed from: j, reason: collision with root package name */
    public final int f27781j;

    /* renamed from: k, reason: collision with root package name */
    public final int f27782k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f27783l;

    /* renamed from: m, reason: collision with root package name */
    public final ColorSpace f27784m;

    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator<TaskSnapshotNative> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TaskSnapshotNative createFromParcel(Parcel parcel) {
            return new TaskSnapshotNative(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TaskSnapshotNative[] newArray(int i10) {
            return new TaskSnapshotNative[i10];
        }
    }

    public /* synthetic */ TaskSnapshotNative(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        int i10;
        GraphicBuffer graphicBuffer = this.f27774c;
        int i11 = 0;
        if (graphicBuffer != null) {
            i10 = graphicBuffer.getWidth();
        } else {
            i10 = 0;
        }
        GraphicBuffer graphicBuffer2 = this.f27774c;
        if (graphicBuffer2 != null) {
            i11 = graphicBuffer2.getHeight();
        }
        return "TaskSnapshot{ mId=" + this.f27772a + " mTopActivityComponent=" + this.f27773b.flattenToShortString() + " mSnapshot=" + this.f27774c + " (" + i10 + "x" + i11 + ") mColorSpace=" + this.f27784m.toString() + " mOrientation=" + this.f27775d + " mRotation=" + this.f27776e + " mTaskSize=" + this.f27777f.toString() + " mContentInsets=" + this.f27778g.toShortString() + " mIsLowResolution=" + this.f27779h + " mIsRealSnapshot=" + this.f27780i + " mWindowingMode=" + this.f27781j + " mSystemUiVisibility=" + this.f27782k + " mIsTranslucent=" + this.f27783l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        GraphicBuffer graphicBuffer;
        parcel.writeLong(this.f27772a);
        ComponentName.writeToParcel(this.f27773b, parcel);
        GraphicBuffer graphicBuffer2 = this.f27774c;
        if (graphicBuffer2 != null && !graphicBuffer2.isDestroyed()) {
            graphicBuffer = this.f27774c;
        } else {
            graphicBuffer = null;
        }
        parcel.writeParcelable(graphicBuffer, 0);
        parcel.writeInt(this.f27784m.getId());
        parcel.writeInt(this.f27775d);
        parcel.writeInt(this.f27776e);
        parcel.writeParcelable(this.f27777f, 0);
        parcel.writeParcelable(this.f27778g, 0);
        parcel.writeBoolean(this.f27779h);
        parcel.writeBoolean(this.f27780i);
        parcel.writeInt(this.f27781j);
        parcel.writeInt(this.f27782k);
        parcel.writeBoolean(this.f27783l);
    }

    public TaskSnapshotNative(Parcel parcel) {
        ColorSpace colorSpace;
        this.f27772a = parcel.readLong();
        this.f27773b = ComponentName.readFromParcel(parcel);
        this.f27774c = parcel.readParcelable(null);
        int readInt = parcel.readInt();
        if (readInt >= 0 && readInt < ColorSpace.Named.values().length) {
            colorSpace = ColorSpace.get(ColorSpace.Named.values()[readInt]);
        } else {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        this.f27784m = colorSpace;
        this.f27775d = parcel.readInt();
        this.f27776e = parcel.readInt();
        this.f27777f = (Point) parcel.readParcelable(null);
        this.f27778g = (Rect) parcel.readParcelable(null);
        this.f27779h = parcel.readBoolean();
        this.f27780i = parcel.readBoolean();
        this.f27781j = parcel.readInt();
        this.f27782k = parcel.readInt();
        this.f27783l = parcel.readBoolean();
    }
}
