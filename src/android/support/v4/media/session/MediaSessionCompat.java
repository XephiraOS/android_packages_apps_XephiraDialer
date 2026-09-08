package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MediaSessionCompat {

    /* loaded from: classes.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public ResultReceiver f7014a;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<ResultReceiverWrapper> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i10) {
                return new ResultReceiverWrapper[i10];
            }
        }

        public ResultReceiverWrapper(Parcel parcel) {
            this.f7014a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            this.f7014a.writeToParcel(parcel, i10);
        }
    }

    /* loaded from: classes.dex */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final Object f7015a;

        /* renamed from: b, reason: collision with root package name */
        public IMediaSession f7016b;

        /* renamed from: c, reason: collision with root package name */
        public Bundle f7017c;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<Token> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i10) {
                return new Token[i10];
            }
        }

        public Token(Object obj) {
            this(obj, null, null);
        }

        public static Token b(Object obj) {
            return d(obj, null);
        }

        public static Token d(Object obj, IMediaSession iMediaSession) {
            if (obj != null) {
                return new Token(c.a(obj), iMediaSession);
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f7015a;
            if (obj2 == null) {
                if (token.f7015a == null) {
                    return true;
                }
                return false;
            }
            Object obj3 = token.f7015a;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public IMediaSession f() {
            return this.f7016b;
        }

        public Object h() {
            return this.f7015a;
        }

        public int hashCode() {
            Object obj = this.f7015a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void i(IMediaSession iMediaSession) {
            this.f7016b = iMediaSession;
        }

        public void j(Bundle bundle) {
            this.f7017c = bundle;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable((Parcelable) this.f7015a, i10);
        }

        public Token(Object obj, IMediaSession iMediaSession) {
            this(obj, iMediaSession, null);
        }

        public Token(Object obj, IMediaSession iMediaSession, Bundle bundle) {
            this.f7015a = obj;
            this.f7016b = iMediaSession;
            this.f7017c = bundle;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    /* loaded from: classes.dex */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final MediaDescriptionCompat f7011a;

        /* renamed from: b, reason: collision with root package name */
        public final long f7012b;

        /* renamed from: c, reason: collision with root package name */
        public Object f7013c;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<QueueItem> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i10) {
                return new QueueItem[i10];
            }
        }

        public QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j10) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if (j10 != -1) {
                this.f7011a = mediaDescriptionCompat;
                this.f7012b = j10;
                this.f7013c = obj;
                return;
            }
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }

        public static QueueItem b(Object obj) {
            if (obj != null) {
                return new QueueItem(obj, MediaDescriptionCompat.b(c.a.a(obj)), c.a.b(obj));
            }
            return null;
        }

        public static List<QueueItem> d(List<?> list) {
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<?> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(b(it.next()));
                }
                return arrayList;
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f7011a + ", Id=" + this.f7012b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            this.f7011a.writeToParcel(parcel, i10);
            parcel.writeLong(this.f7012b);
        }

        public QueueItem(Parcel parcel) {
            this.f7011a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f7012b = parcel.readLong();
        }
    }
}
