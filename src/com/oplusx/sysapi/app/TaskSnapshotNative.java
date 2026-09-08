package com.oplusx.sysapi.app;

import android.content.ComponentName;
import android.content.res.Configuration;
import android.graphics.ColorSpace;
import android.graphics.GraphicBuffer;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class TaskSnapshotNative implements Parcelable {
    public static final Parcelable.Creator<TaskSnapshotNative> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final long f29352a;

    /* renamed from: b, reason: collision with root package name */
    public final ComponentName f29353b;

    /* renamed from: c, reason: collision with root package name */
    public final GraphicBuffer f29354c;

    /* renamed from: d, reason: collision with root package name */
    @Configuration.Orientation
    public final int f29355d;

    /* renamed from: e, reason: collision with root package name */
    public final int f29356e;

    /* renamed from: f, reason: collision with root package name */
    public final Point f29357f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f29358g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f29359h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f29360i;

    /* renamed from: j, reason: collision with root package name */
    public final int f29361j;

    /* renamed from: k, reason: collision with root package name */
    public final int f29362k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f29363l;

    /* renamed from: m, reason: collision with root package name */
    public final ColorSpace f29364m;

    /* loaded from: classes4.dex */
    public class a implements Parcelable.Creator<TaskSnapshotNative> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TaskSnapshotNative createFromParcel(Parcel parcel) {
            return new TaskSnapshotNative(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TaskSnapshotNative[] newArray(int i10) {
            return new TaskSnapshotNative[i10];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        int i10;
        GraphicBuffer graphicBuffer = this.f29354c;
        int i11 = 0;
        if (graphicBuffer != null) {
            i10 = graphicBuffer.getWidth();
        } else {
            i10 = 0;
        }
        GraphicBuffer graphicBuffer2 = this.f29354c;
        if (graphicBuffer2 != null) {
            i11 = graphicBuffer2.getHeight();
        }
        return "TaskSnapshot{ mId=" + this.f29352a + " mTopActivityComponent=" + this.f29353b.flattenToShortString() + " mSnapshot=" + this.f29354c + " (" + i10 + "x" + i11 + ") mColorSpace=" + this.f29364m.toString() + " mOrientation=" + this.f29355d + " mRotation=" + this.f29356e + " mTaskSize=" + this.f29357f.toString() + " mContentInsets=" + this.f29358g.toShortString() + " mIsLowResolution=" + this.f29359h + " mIsRealSnapshot=" + this.f29360i + " mWindowingMode=" + this.f29361j + " mSystemUiVisibility=" + this.f29362k + " mIsTranslucent=" + this.f29363l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        GraphicBuffer graphicBuffer;
        parcel.writeLong(this.f29352a);
        ComponentName.writeToParcel(this.f29353b, parcel);
        GraphicBuffer graphicBuffer2 = this.f29354c;
        if (graphicBuffer2 != null && !graphicBuffer2.isDestroyed()) {
            graphicBuffer = this.f29354c;
        } else {
            graphicBuffer = null;
        }
        parcel.writeParcelable(graphicBuffer, 0);
        parcel.writeInt(this.f29364m.getId());
        parcel.writeInt(this.f29355d);
        parcel.writeInt(this.f29356e);
        parcel.writeParcelable(this.f29357f, 0);
        parcel.writeParcelable(this.f29358g, 0);
        parcel.writeBoolean(this.f29359h);
        parcel.writeBoolean(this.f29360i);
        parcel.writeInt(this.f29361j);
        parcel.writeInt(this.f29362k);
        parcel.writeBoolean(this.f29363l);
    }

    public TaskSnapshotNative(Parcel parcel) {
        ColorSpace colorSpace;
        this.f29352a = parcel.readLong();
        this.f29353b = ComponentName.readFromParcel(parcel);
        this.f29354c = parcel.readParcelable(null);
        int readInt = parcel.readInt();
        if (readInt >= 0 && readInt < ColorSpace.Named.values().length) {
            colorSpace = ColorSpace.get(ColorSpace.Named.values()[readInt]);
        } else {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        this.f29364m = colorSpace;
        this.f29355d = parcel.readInt();
        this.f29356e = parcel.readInt();
        this.f29357f = (Point) parcel.readParcelable(null);
        this.f29358g = (Rect) parcel.readParcelable(null);
        this.f29359h = parcel.readBoolean();
        this.f29360i = parcel.readBoolean();
        this.f29361j = parcel.readInt();
        this.f29362k = parcel.readInt();
        this.f29363l = parcel.readBoolean();
    }
}
