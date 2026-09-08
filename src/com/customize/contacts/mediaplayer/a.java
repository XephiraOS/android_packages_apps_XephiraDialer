package com.customize.contacts.mediaplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: CallRecodingWiredHeadsetManager.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    public static final String f21695f = "a";

    /* renamed from: a, reason: collision with root package name */
    public final b f21696a = new b();

    /* renamed from: b, reason: collision with root package name */
    public boolean f21697b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21698c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC0204a f21699d;

    /* renamed from: e, reason: collision with root package name */
    public Context f21700e;

    /* compiled from: CallRecodingWiredHeadsetManager.java */
    /* renamed from: com.customize.contacts.mediaplayer.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0204a {
        void a(boolean z10, boolean z11);

        void b(boolean z10, boolean z11);
    }

    /* compiled from: CallRecodingWiredHeadsetManager.java */
    /* loaded from: classes3.dex */
    public class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z10 = true;
            if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                if (C7.e.d(intent, "state", 0) != 1) {
                    z10 = false;
                }
                H7.b.h(a.f21695f, "ACTION_HEADSET_PLUG event, plugged in: " + z10);
                if (z10) {
                    a.this.c(z10, "android.intent.action.HEADSET_PLUG");
                    return;
                }
                return;
            }
            if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                if (2 != C7.e.d(intent, "android.bluetooth.profile.extra.STATE", 0)) {
                    z10 = false;
                }
                H7.b.h(a.f21695f, "ACTION_CONNECTION_STATE_CHANGED event, plugged in: " + z10 + " the state is : ");
                a.this.c(z10, "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                return;
            }
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                H7.b.b(a.f21695f, "ACTION_AUDIO_BECOMING_NOISY, plugged out");
                a.this.c(false, "android.media.AUDIO_BECOMING_NOISY");
            }
        }

        public b() {
        }
    }

    public a(Context context) {
        this.f21700e = context;
    }

    public final void c(boolean z10, String str) {
        if ("android.intent.action.HEADSET_PLUG".equals(str) && this.f21697b != z10) {
            H7.b.h(f21695f, "onHeadsetPluggedInChanged, mIsPluggedIn: " + this.f21697b + " -> " + z10);
            boolean z11 = this.f21697b;
            this.f21697b = z10;
            InterfaceC0204a interfaceC0204a = this.f21699d;
            if (interfaceC0204a != null) {
                interfaceC0204a.a(z11, z10);
            }
        }
        if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(str) && this.f21698c != z10) {
            H7.b.h(f21695f, "onHeadsetPluggedInChanged, mIsPluggedIn: " + this.f21698c + " -> " + z10);
            boolean z12 = this.f21698c;
            this.f21698c = z10;
            InterfaceC0204a interfaceC0204a2 = this.f21699d;
            if (interfaceC0204a2 != null) {
                interfaceC0204a2.b(z12, z10);
            }
        }
        if ("android.media.AUDIO_BECOMING_NOISY".equals(str)) {
            if (this.f21698c && !z10) {
                this.f21698c = false;
                InterfaceC0204a interfaceC0204a3 = this.f21699d;
                if (interfaceC0204a3 != null) {
                    interfaceC0204a3.b(true, false);
                }
            }
            if (this.f21697b && !z10) {
                this.f21697b = false;
                InterfaceC0204a interfaceC0204a4 = this.f21699d;
                if (interfaceC0204a4 != null) {
                    interfaceC0204a4.a(true, false);
                }
            }
        }
    }

    public void d() {
        this.f21700e.registerReceiver(this.f21696a, new IntentFilter("android.intent.action.HEADSET_PLUG"), 2);
        this.f21700e.registerReceiver(this.f21696a, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"), 2);
        this.f21700e.registerReceiver(this.f21696a, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"), 2);
    }

    public void e(boolean z10) {
        H7.b.b(f21695f, "old isPlugin is : " + this.f21698c + " new value is : " + z10);
        this.f21698c = z10;
    }

    public void f(InterfaceC0204a interfaceC0204a) {
        this.f21699d = interfaceC0204a;
    }

    public void g(boolean z10) {
        H7.b.b(f21695f, "old isWiredHeadsetPluggedIn " + this.f21697b + " new value is : " + z10);
        this.f21697b = z10;
    }

    public void h() {
        this.f21700e.unregisterReceiver(this.f21696a);
    }
}
