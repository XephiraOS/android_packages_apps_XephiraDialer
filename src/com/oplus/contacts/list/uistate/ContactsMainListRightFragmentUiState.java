package com.oplus.contacts.list.uistate;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ContactsMainListRightFragmentUiState.kt */
/* loaded from: classes3.dex */
public abstract class ContactsMainListRightFragmentUiState implements Parcelable {

    /* renamed from: c, reason: collision with root package name */
    public static final a f28068c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f28069a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f28070b;

    /* compiled from: ContactsMainListRightFragmentUiState.kt */
    /* loaded from: classes3.dex */
    public static final class DetailUiState extends ContactsMainListRightFragmentUiState {
        public static final Parcelable.Creator<DetailUiState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public final Intent f28071d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f28072e;

        /* compiled from: ContactsMainListRightFragmentUiState.kt */
        /* loaded from: classes3.dex */
        public static final class a implements Parcelable.Creator<DetailUiState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final DetailUiState createFromParcel(Parcel parcel) {
                boolean z10;
                i.f(parcel, "parcel");
                Intent intent = (Intent) parcel.readParcelable(DetailUiState.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                return new DetailUiState(intent, z10);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final DetailUiState[] newArray(int i10) {
                return new DetailUiState[i10];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DetailUiState(Intent intent, boolean z10) {
            super("right_fragment_tag_show_detail", z10, null);
            i.f(intent, "intent");
            this.f28071d = intent;
            this.f28072e = z10;
        }

        public boolean d() {
            return this.f28072e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DetailUiState)) {
                return false;
            }
            DetailUiState detailUiState = (DetailUiState) obj;
            if (i.b(this.f28071d, detailUiState.f28071d) && d() == detailUiState.d()) {
                return true;
            }
            return false;
        }

        public final Intent f() {
            return this.f28071d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public int hashCode() {
            int hashCode = this.f28071d.hashCode() * 31;
            boolean d10 = d();
            ?? r12 = d10;
            if (d10) {
                r12 = 1;
            }
            return hashCode + r12;
        }

        public String toString() {
            return "DetailUiState(intent=" + this.f28071d + ", animate=" + d() + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i10) {
            i.f(out, "out");
            out.writeParcelable(this.f28071d, i10);
            out.writeInt(this.f28072e ? 1 : 0);
        }
    }

    /* compiled from: ContactsMainListRightFragmentUiState.kt */
    /* loaded from: classes3.dex */
    public static final class MyGroupUiState extends ContactsMainListRightFragmentUiState {
        public static final Parcelable.Creator<MyGroupUiState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public final boolean f28073d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f28074e;

        /* compiled from: ContactsMainListRightFragmentUiState.kt */
        /* loaded from: classes3.dex */
        public static final class a implements Parcelable.Creator<MyGroupUiState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final MyGroupUiState createFromParcel(Parcel parcel) {
                boolean z10;
                i.f(parcel, "parcel");
                boolean z11 = false;
                if (parcel.readInt() != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (parcel.readInt() != 0) {
                    z11 = true;
                }
                return new MyGroupUiState(z10, z11);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final MyGroupUiState[] newArray(int i10) {
                return new MyGroupUiState[i10];
            }
        }

        public MyGroupUiState(boolean z10, boolean z11) {
            super("right_fragment_tag_show_group", z10, null);
            this.f28073d = z10;
            this.f28074e = z11;
        }

        public boolean d() {
            return this.f28073d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MyGroupUiState)) {
                return false;
            }
            MyGroupUiState myGroupUiState = (MyGroupUiState) obj;
            if (d() == myGroupUiState.d() && this.f28074e == myGroupUiState.f28074e) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean d10 = d();
            int i10 = 1;
            ?? r02 = d10;
            if (d10) {
                r02 = 1;
            }
            int i11 = r02 * 31;
            boolean z10 = this.f28074e;
            if (!z10) {
                i10 = z10 ? 1 : 0;
            }
            return i11 + i10;
        }

        public String toString() {
            return "MyGroupUiState(animate=" + d() + ", isUnFold=" + this.f28074e + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i10) {
            i.f(out, "out");
            out.writeInt(this.f28073d ? 1 : 0);
            out.writeInt(this.f28074e ? 1 : 0);
        }
    }

    /* compiled from: ContactsMainListRightFragmentUiState.kt */
    /* loaded from: classes3.dex */
    public static final class MyProfileUiState extends ContactsMainListRightFragmentUiState {
        public static final Parcelable.Creator<MyProfileUiState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public final Intent f28075d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f28076e;

        /* compiled from: ContactsMainListRightFragmentUiState.kt */
        /* loaded from: classes3.dex */
        public static final class a implements Parcelable.Creator<MyProfileUiState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final MyProfileUiState createFromParcel(Parcel parcel) {
                boolean z10;
                i.f(parcel, "parcel");
                Intent intent = (Intent) parcel.readParcelable(MyProfileUiState.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                return new MyProfileUiState(intent, z10);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final MyProfileUiState[] newArray(int i10) {
                return new MyProfileUiState[i10];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyProfileUiState(Intent intent, boolean z10) {
            super("right_fragment_tag_show_profile", z10, null);
            i.f(intent, "intent");
            this.f28075d = intent;
            this.f28076e = z10;
        }

        public boolean d() {
            return this.f28076e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MyProfileUiState)) {
                return false;
            }
            MyProfileUiState myProfileUiState = (MyProfileUiState) obj;
            if (i.b(this.f28075d, myProfileUiState.f28075d) && d() == myProfileUiState.d()) {
                return true;
            }
            return false;
        }

        public final Intent f() {
            return this.f28075d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public int hashCode() {
            int hashCode = this.f28075d.hashCode() * 31;
            boolean d10 = d();
            ?? r12 = d10;
            if (d10) {
                r12 = 1;
            }
            return hashCode + r12;
        }

        public String toString() {
            return "MyProfileUiState(intent=" + this.f28075d + ", animate=" + d() + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i10) {
            i.f(out, "out");
            out.writeParcelable(this.f28075d, i10);
            out.writeInt(this.f28076e ? 1 : 0);
        }
    }

    /* compiled from: ContactsMainListRightFragmentUiState.kt */
    /* loaded from: classes3.dex */
    public static final class NoContactSelectedUiState extends ContactsMainListRightFragmentUiState {
        public static final Parcelable.Creator<NoContactSelectedUiState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public final boolean f28077d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f28078e;

        /* compiled from: ContactsMainListRightFragmentUiState.kt */
        /* loaded from: classes3.dex */
        public static final class a implements Parcelable.Creator<NoContactSelectedUiState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final NoContactSelectedUiState createFromParcel(Parcel parcel) {
                boolean z10;
                i.f(parcel, "parcel");
                boolean z11 = false;
                if (parcel.readInt() != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (parcel.readInt() != 0) {
                    z11 = true;
                }
                return new NoContactSelectedUiState(z10, z11);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final NoContactSelectedUiState[] newArray(int i10) {
                return new NoContactSelectedUiState[i10];
            }
        }

        public NoContactSelectedUiState(boolean z10, boolean z11) {
            super("right_fragment_tag_no_contact_selected", z11, null);
            this.f28077d = z10;
            this.f28078e = z11;
        }

        public boolean d() {
            return this.f28078e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NoContactSelectedUiState)) {
                return false;
            }
            NoContactSelectedUiState noContactSelectedUiState = (NoContactSelectedUiState) obj;
            if (this.f28077d == noContactSelectedUiState.f28077d && d() == noContactSelectedUiState.d()) {
                return true;
            }
            return false;
        }

        public final boolean f() {
            return this.f28077d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean z10 = this.f28077d;
            ?? r12 = 1;
            ?? r02 = z10;
            if (z10) {
                r02 = 1;
            }
            int i10 = r02 * 31;
            boolean d10 = d();
            if (!d10) {
                r12 = d10;
            }
            return i10 + r12;
        }

        public String toString() {
            return "NoContactSelectedUiState(unfoldStatus=" + this.f28077d + ", animate=" + d() + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i10) {
            i.f(out, "out");
            out.writeInt(this.f28077d ? 1 : 0);
            out.writeInt(this.f28078e ? 1 : 0);
        }
    }

    /* compiled from: ContactsMainListRightFragmentUiState.kt */
    /* loaded from: classes3.dex */
    public static final class NoContactsUiState extends ContactsMainListRightFragmentUiState {
        public static final Parcelable.Creator<NoContactsUiState> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public final boolean f28079d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f28080e;

        /* compiled from: ContactsMainListRightFragmentUiState.kt */
        /* loaded from: classes3.dex */
        public static final class a implements Parcelable.Creator<NoContactsUiState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final NoContactsUiState createFromParcel(Parcel parcel) {
                boolean z10;
                i.f(parcel, "parcel");
                boolean z11 = false;
                if (parcel.readInt() != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (parcel.readInt() != 0) {
                    z11 = true;
                }
                return new NoContactsUiState(z10, z11);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final NoContactsUiState[] newArray(int i10) {
                return new NoContactsUiState[i10];
            }
        }

        public NoContactsUiState(boolean z10, boolean z11) {
            super("right_fragment_tag_no_contacts", z11, null);
            this.f28079d = z10;
            this.f28080e = z11;
        }

        public boolean d() {
            return this.f28080e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NoContactsUiState)) {
                return false;
            }
            NoContactsUiState noContactsUiState = (NoContactsUiState) obj;
            if (this.f28079d == noContactsUiState.f28079d && d() == noContactsUiState.d()) {
                return true;
            }
            return false;
        }

        public final boolean f() {
            return this.f28079d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean z10 = this.f28079d;
            ?? r12 = 1;
            ?? r02 = z10;
            if (z10) {
                r02 = 1;
            }
            int i10 = r02 * 31;
            boolean d10 = d();
            if (!d10) {
                r12 = d10;
            }
            return i10 + r12;
        }

        public String toString() {
            return "NoContactsUiState(unfoldStatus=" + this.f28079d + ", animate=" + d() + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i10) {
            i.f(out, "out");
            out.writeInt(this.f28079d ? 1 : 0);
            out.writeInt(this.f28080e ? 1 : 0);
        }
    }

    /* compiled from: ContactsMainListRightFragmentUiState.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public /* synthetic */ ContactsMainListRightFragmentUiState(String str, boolean z10, f fVar) {
        this(str, z10);
    }

    public String b() {
        return this.f28069a;
    }

    public ContactsMainListRightFragmentUiState(String str, boolean z10) {
        this.f28069a = str;
        this.f28070b = z10;
    }
}
