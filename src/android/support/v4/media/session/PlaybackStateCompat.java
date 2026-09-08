package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.d;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f7023a;

    /* renamed from: b, reason: collision with root package name */
    public final long f7024b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7025c;

    /* renamed from: d, reason: collision with root package name */
    public final float f7026d;

    /* renamed from: e, reason: collision with root package name */
    public final long f7027e;

    /* renamed from: f, reason: collision with root package name */
    public final int f7028f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f7029g;

    /* renamed from: h, reason: collision with root package name */
    public final long f7030h;

    /* renamed from: i, reason: collision with root package name */
    public List<CustomAction> f7031i;

    /* renamed from: j, reason: collision with root package name */
    public final long f7032j;

    /* renamed from: k, reason: collision with root package name */
    public final Bundle f7033k;

    /* renamed from: l, reason: collision with root package name */
    public Object f7034l;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<PlaybackStateCompat> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i10) {
            return new PlaybackStateCompat[i10];
        }
    }

    public PlaybackStateCompat(int i10, long j10, long j11, float f10, long j12, int i11, CharSequence charSequence, long j13, List<CustomAction> list, long j14, Bundle bundle) {
        this.f7023a = i10;
        this.f7024b = j10;
        this.f7025c = j11;
        this.f7026d = f10;
        this.f7027e = j12;
        this.f7028f = i11;
        this.f7029g = charSequence;
        this.f7030h = j13;
        this.f7031i = new ArrayList(list);
        this.f7032j = j14;
        this.f7033k = bundle;
    }

    public static PlaybackStateCompat b(Object obj) {
        ArrayList arrayList = null;
        if (obj == null) {
            return null;
        }
        List<Object> d10 = d.d(obj);
        if (d10 != null) {
            arrayList = new ArrayList(d10.size());
            Iterator<Object> it = d10.iterator();
            while (it.hasNext()) {
                arrayList.add(CustomAction.b(it.next()));
            }
        }
        Bundle a10 = e.a(obj);
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(d.i(obj), d.h(obj), d.c(obj), d.g(obj), d.a(obj), 0, d.e(obj), d.f(obj), arrayList, d.b(obj), a10);
        playbackStateCompat.f7034l = obj;
        return playbackStateCompat;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f7023a + ", position=" + this.f7024b + ", buffered position=" + this.f7025c + ", speed=" + this.f7026d + ", updated=" + this.f7030h + ", actions=" + this.f7027e + ", error code=" + this.f7028f + ", error message=" + this.f7029g + ", custom actions=" + this.f7031i + ", active item id=" + this.f7032j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f7023a);
        parcel.writeLong(this.f7024b);
        parcel.writeFloat(this.f7026d);
        parcel.writeLong(this.f7030h);
        parcel.writeLong(this.f7025c);
        parcel.writeLong(this.f7027e);
        TextUtils.writeToParcel(this.f7029g, parcel, i10);
        parcel.writeTypedList(this.f7031i);
        parcel.writeLong(this.f7032j);
        parcel.writeBundle(this.f7033k);
        parcel.writeInt(this.f7028f);
    }

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final String f7035a;

        /* renamed from: b, reason: collision with root package name */
        public final CharSequence f7036b;

        /* renamed from: c, reason: collision with root package name */
        public final int f7037c;

        /* renamed from: d, reason: collision with root package name */
        public final Bundle f7038d;

        /* renamed from: e, reason: collision with root package name */
        public Object f7039e;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<CustomAction> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i10) {
                return new CustomAction[i10];
            }
        }

        public CustomAction(String str, CharSequence charSequence, int i10, Bundle bundle) {
            this.f7035a = str;
            this.f7036b = charSequence;
            this.f7037c = i10;
            this.f7038d = bundle;
        }

        public static CustomAction b(Object obj) {
            if (obj != null) {
                CustomAction customAction = new CustomAction(d.a.a(obj), d.a.d(obj), d.a.c(obj), d.a.b(obj));
                customAction.f7039e = obj;
                return customAction;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f7036b) + ", mIcon=" + this.f7037c + ", mExtras=" + this.f7038d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f7035a);
            TextUtils.writeToParcel(this.f7036b, parcel, i10);
            parcel.writeInt(this.f7037c);
            parcel.writeBundle(this.f7038d);
        }

        public CustomAction(Parcel parcel) {
            this.f7035a = parcel.readString();
            this.f7036b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f7037c = parcel.readInt();
            this.f7038d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f7023a = parcel.readInt();
        this.f7024b = parcel.readLong();
        this.f7026d = parcel.readFloat();
        this.f7030h = parcel.readLong();
        this.f7025c = parcel.readLong();
        this.f7027e = parcel.readLong();
        this.f7029g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f7031i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f7032j = parcel.readLong();
        this.f7033k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f7028f = parcel.readInt();
    }
}
