package com.heytap.addon.zoomwindow;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.color.zoomwindow.ColorZoomWindowInfo;

/* loaded from: classes3.dex */
public class OplusZoomWindowInfo implements Parcelable {
    public static final Parcelable.Creator<OplusZoomWindowInfo> CREATOR = new Parcelable.Creator<OplusZoomWindowInfo>() { // from class: com.heytap.addon.zoomwindow.OplusZoomWindowInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusZoomWindowInfo createFromParcel(Parcel parcel) {
            return new OplusZoomWindowInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusZoomWindowInfo[] newArray(int i10) {
            return new OplusZoomWindowInfo[i10];
        }
    };
    public String cpnName;
    public Bundle extension;
    public int inputMethodType;
    public boolean inputShow;
    public int lastExitMethod;
    public String lockPkg;
    public int lockUserId;
    public int rotation;
    public boolean windowShown;
    public String zoomPkg;
    public Rect zoomRect;
    public int zoomUserId;

    public OplusZoomWindowInfo(com.oplus.zoomwindow.OplusZoomWindowInfo oplusZoomWindowInfo) {
        this.zoomRect = oplusZoomWindowInfo.zoomRect;
        this.rotation = oplusZoomWindowInfo.rotation;
        this.windowShown = oplusZoomWindowInfo.windowShown;
        this.lockPkg = oplusZoomWindowInfo.lockPkg;
        this.zoomPkg = oplusZoomWindowInfo.zoomPkg;
        this.lockUserId = oplusZoomWindowInfo.lockUserId;
        this.zoomUserId = oplusZoomWindowInfo.zoomUserId;
        this.inputShow = oplusZoomWindowInfo.inputShow;
        this.cpnName = oplusZoomWindowInfo.cpnName;
        this.lastExitMethod = oplusZoomWindowInfo.lastExitMethod;
        this.inputMethodType = oplusZoomWindowInfo.inputMethodType;
        this.extension = oplusZoomWindowInfo.extension;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.zoomRect, i10);
        parcel.writeInt(this.rotation);
        parcel.writeByte(this.windowShown ? (byte) 1 : (byte) 0);
        parcel.writeString(this.lockPkg);
        parcel.writeString(this.zoomPkg);
        parcel.writeInt(this.lockUserId);
        parcel.writeInt(this.zoomUserId);
        parcel.writeByte(this.inputShow ? (byte) 1 : (byte) 0);
        parcel.writeString(this.cpnName);
        parcel.writeInt(this.lastExitMethod);
        parcel.writeInt(this.inputMethodType);
        parcel.writeBundle(this.extension);
    }

    public OplusZoomWindowInfo(ColorZoomWindowInfo colorZoomWindowInfo) {
        this.zoomRect = colorZoomWindowInfo.zoomRect;
        this.rotation = colorZoomWindowInfo.rotation;
        this.windowShown = colorZoomWindowInfo.windowShown;
        this.lockPkg = colorZoomWindowInfo.lockPkg;
        this.zoomPkg = colorZoomWindowInfo.zoomPkg;
        this.lockUserId = colorZoomWindowInfo.lockUserId;
        this.zoomUserId = colorZoomWindowInfo.zoomUserId;
        this.inputShow = colorZoomWindowInfo.inputShow;
    }

    public OplusZoomWindowInfo() {
    }

    public OplusZoomWindowInfo(Parcel parcel) {
        this.zoomRect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.rotation = parcel.readInt();
        this.windowShown = parcel.readByte() != 0;
        this.lockPkg = parcel.readString();
        this.zoomPkg = parcel.readString();
        this.lockUserId = parcel.readInt();
        this.zoomUserId = parcel.readInt();
        this.inputShow = parcel.readByte() != 0;
        this.cpnName = parcel.readString();
        this.lastExitMethod = parcel.readInt();
        this.inputMethodType = parcel.readInt();
        this.extension = parcel.readBundle();
    }
}
