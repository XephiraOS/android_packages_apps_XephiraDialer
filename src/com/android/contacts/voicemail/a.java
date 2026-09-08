package com.android.contacts.voicemail;

import android.content.Context;
import android.database.Cursor;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import java.util.List;

/* compiled from: VoicemailDetailAdapter.java */
/* loaded from: classes.dex */
public class a extends CursorAdapter {

    /* renamed from: a, reason: collision with root package name */
    public VoicemailPlaybackPresenter f17928a;

    /* renamed from: b, reason: collision with root package name */
    public long f17929b;

    /* renamed from: c, reason: collision with root package name */
    public long f17930c;

    /* renamed from: d, reason: collision with root package name */
    public String f17931d;

    /* renamed from: e, reason: collision with root package name */
    public String f17932e;

    /* renamed from: f, reason: collision with root package name */
    public int f17933f;

    /* renamed from: g, reason: collision with root package name */
    public Context f17934g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f17935h;

    /* compiled from: VoicemailDetailAdapter.java */
    /* renamed from: com.android.contacts.voicemail.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0175a {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f17936a = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", "simid", "voicemail_uri", "is_read", "subscription_id", "transcription"};
    }

    /* compiled from: VoicemailDetailAdapter.java */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public VoicemailPlaybackLayout f17937a;

        public b() {
        }
    }

    public a(Context context, Cursor cursor) {
        super(context, cursor);
        this.f17929b = -1L;
        this.f17930c = -1L;
        this.f17934g = context;
        this.f17935h = a();
    }

    public final boolean a() {
        for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) this.f17934g.getSystemService("audio")).getDevices(2)) {
            if (audioDeviceInfo.getType() == 1) {
                return true;
            }
        }
        return false;
    }

    public void b() {
        int size;
        if (B3.a.i()) {
            List<SubscriptionInfo> e10 = b0.e(this.f17934g);
            if (e10.isEmpty()) {
                size = 0;
            } else {
                size = e10.size();
            }
            this.f17933f = size;
            for (int i10 = 0; i10 < e10.size(); i10++) {
                SubscriptionInfo subscriptionInfo = e10.get(i10);
                int simSlotIndex = subscriptionInfo.getSimSlotIndex();
                if (simSlotIndex == 0) {
                    this.f17929b = subscriptionInfo.getSubscriptionId();
                    this.f17931d = subscriptionInfo.getIccId();
                } else if (simSlotIndex == 1) {
                    this.f17930c = subscriptionInfo.getSubscriptionId();
                    this.f17932e = subscriptionInfo.getIccId();
                }
            }
        }
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        boolean z10;
        b bVar = (b) view.getTag();
        long j10 = cursor.getLong(2);
        long j11 = cursor.getLong(4);
        if (cursor.getInt(6) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        bVar.f17937a.q(j10, j11, cursor.getString(7), this.f17929b, this.f17930c, this.f17931d, this.f17932e, this.f17933f, z10, cursor.getInt(3), cursor.getString(8), this.f17935h);
        cursor.getLong(0);
        String string = cursor.getString(5);
        if (!TextUtils.isEmpty(string)) {
            bVar.f17937a.v(this.f17928a, Uri.parse(string));
        }
    }

    public void c(VoicemailPlaybackPresenter voicemailPlaybackPresenter) {
        this.f17928a = voicemailPlaybackPresenter;
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = newView(this.f17934g, getCursor(), viewGroup);
            b bVar = new b();
            bVar.f17937a = (VoicemailPlaybackLayout) view.findViewById(R.id.voicemail_playback_layout);
            view.setTag(bVar);
        }
        getCursor().moveToPosition(i10);
        bindView(view, this.f17934g, getCursor());
        return view;
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.voicemail_detail_item, viewGroup, false);
    }
}
