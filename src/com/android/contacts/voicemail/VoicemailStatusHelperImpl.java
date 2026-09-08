package com.android.contacts.voicemail;

import U7.g;
import android.database.Cursor;
import android.net.Uri;
import com.android.contacts.voicemail.b;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class VoicemailStatusHelperImpl implements com.android.contacts.voicemail.b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f17910a;

    /* loaded from: classes.dex */
    public enum Action {
        NONE(-1),
        CALL_VOICEMAIL(R.string.voicemail_status_action_call_server),
        CONFIGURE_VOICEMAIL(R.string.voicemail_status_action_configure);

        private final int mMessageId;

        Action(int i10) {
            this.mMessageId = i10;
        }

        public int b() {
            return this.mMessageId;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'a' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class OverallState {

        /* renamed from: a, reason: collision with root package name */
        public static final OverallState f17915a;

        /* renamed from: b, reason: collision with root package name */
        public static final OverallState f17916b;

        /* renamed from: c, reason: collision with root package name */
        public static final OverallState f17917c;

        /* renamed from: d, reason: collision with root package name */
        public static final OverallState f17918d;

        /* renamed from: e, reason: collision with root package name */
        public static final OverallState f17919e;

        /* renamed from: f, reason: collision with root package name */
        public static final OverallState f17920f;

        /* renamed from: g, reason: collision with root package name */
        public static final OverallState f17921g;

        /* renamed from: h, reason: collision with root package name */
        public static final OverallState f17922h;

        /* renamed from: i, reason: collision with root package name */
        public static final OverallState f17923i;

        /* renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ OverallState[] f17924j;
        private final Action mAction;
        private final int mCallDetailsMessageId;
        private final int mCallLogMessageId;
        private final int mPriority;

        static {
            Action action = Action.CALL_VOICEMAIL;
            f17915a = new OverallState("NO_CONNECTION", 0, 0, action, R.string.voicemail_status_voicemail_not_available, R.string.voicemail_status_audio_not_available);
            f17916b = new OverallState("NO_DATA", 1, 1, action, R.string.voicemail_status_voicemail_not_available, R.string.voicemail_status_audio_not_available);
            f17917c = new OverallState("MESSAGE_WAITING", 2, 2, action, R.string.voicemail_status_messages_waiting, R.string.voicemail_status_audio_not_available);
            f17918d = new OverallState("NO_NOTIFICATIONS", 3, 3, action, R.string.voicemail_status_voicemail_not_available);
            f17919e = new OverallState("INVITE_FOR_CONFIGURATION", 4, 4, Action.CONFIGURE_VOICEMAIL, R.string.voicemail_status_configure_voicemail);
            Action action2 = Action.NONE;
            f17920f = new OverallState("NO_DETAILED_NOTIFICATION", 5, 5, action2, -1);
            f17921g = new OverallState("NOT_CONFIGURED", 6, 6, action2, -1);
            f17922h = new OverallState("OK", 7, 7, action2, -1);
            f17923i = new OverallState("INVALID", 8, 8, action2, -1);
            f17924j = a();
        }

        public OverallState(String str, int i10, int i11, Action action, int i12) {
            this(str, i10, i11, action, i12, -1);
        }

        public static /* synthetic */ OverallState[] a() {
            return new OverallState[]{f17915a, f17916b, f17917c, f17918d, f17919e, f17920f, f17921g, f17922h, f17923i};
        }

        public static OverallState valueOf(String str) {
            return (OverallState) Enum.valueOf(OverallState.class, str);
        }

        public static OverallState[] values() {
            return (OverallState[]) f17924j.clone();
        }

        public Action b() {
            return this.mAction;
        }

        public int c() {
            return this.mCallDetailsMessageId;
        }

        public int d() {
            return this.mCallLogMessageId;
        }

        public int e() {
            return this.mPriority;
        }

        public OverallState(String str, int i10, int i11, Action action, int i12, int i13) {
            this.mPriority = i11;
            this.mAction = action;
            this.mCallLogMessageId = i12;
            this.mCallDetailsMessageId = i13;
        }
    }

    /* loaded from: classes.dex */
    public class a implements Comparator<b> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.f17927b - bVar2.f17927b;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final b.a f17926a;

        /* renamed from: b, reason: collision with root package name */
        public final int f17927b;

        public b(b.a aVar, int i10) {
            this.f17926a = aVar;
            this.f17927b = i10;
        }
    }

    static {
        f17910a = r0;
        String[] strArr = {"source_package", "configuration_state", "data_channel_state", "notification_channel_state", "settings_uri", "voicemail_access_uri"};
    }

    public static String[] d() {
        return f17910a;
    }

    @Override // com.android.contacts.voicemail.b
    public List<b.a> a(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            b b10 = b(cursor);
            if (b10 != null) {
                arrayList.add(b10);
            }
        }
        return e(arrayList);
    }

    public final b b(Cursor cursor) {
        OverallState c10;
        Action b10;
        Uri uri;
        Uri b11;
        String string = cursor.getString(0);
        if (string == null || (b10 = (c10 = c(cursor.getInt(1), cursor.getInt(2), cursor.getInt(3))).b()) == Action.NONE) {
            return null;
        }
        if (b10 == Action.CALL_VOICEMAIL) {
            b11 = g.b(cursor.getString(5));
        } else if (b10 == Action.CONFIGURE_VOICEMAIL) {
            b11 = g.b(cursor.getString(4));
            if (b11 == null) {
                return null;
            }
        } else {
            uri = null;
            return new b(new b.a(string, c10.d(), c10.c(), b10.b(), uri), c10.e());
        }
        uri = b11;
        return new b(new b.a(string, c10.d(), c10.c(), b10.b(), uri), c10.e());
    }

    public final OverallState c(int i10, int i11, int i12) {
        if (i10 == 0) {
            if (i11 == 0) {
                if (i12 == 0) {
                    return OverallState.f17922h;
                }
                if (i12 == 2) {
                    return OverallState.f17920f;
                }
                if (i12 == 1) {
                    return OverallState.f17918d;
                }
            } else if (i11 == 1) {
                if (i12 == 0) {
                    return OverallState.f17916b;
                }
                if (i12 == 2) {
                    return OverallState.f17917c;
                }
                if (i12 == 1) {
                    return OverallState.f17915a;
                }
            }
        } else {
            if (i10 == 2) {
                return OverallState.f17919e;
            }
            if (i10 == 1) {
                return OverallState.f17921g;
            }
        }
        return OverallState.f17923i;
    }

    public final List<b.a> e(List<b> list) {
        Collections.sort(list, new a());
        ArrayList arrayList = new ArrayList();
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f17926a);
        }
        return arrayList;
    }
}
