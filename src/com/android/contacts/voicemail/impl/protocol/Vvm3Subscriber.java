package com.android.contacts.voicemail.impl.protocol;

import S2.f;
import T2.h;
import T2.k;
import T2.l;
import T2.m;
import android.content.Context;
import android.net.Network;
import android.os.Build;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.util.ArrayMap;
import com.android.contacts.voicemail.impl.ActivationTask;
import com.android.contacts.voicemail.impl.OmtpEvents;
import com.android.contacts.voicemail.impl.c;
import com.android.contacts.voicemail.impl.sync.VvmNetworkRequest;
import com.android.volley.d;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import t1.C1580a;

/* loaded from: classes.dex */
public class Vvm3Subscriber {

    /* renamed from: a, reason: collision with root package name */
    public final ActivationTask f18132a;

    /* renamed from: b, reason: collision with root package name */
    public final PhoneAccountHandle f18133b;

    /* renamed from: c, reason: collision with root package name */
    public final com.android.contacts.voicemail.impl.b f18134c;

    /* renamed from: d, reason: collision with root package name */
    public final c.b f18135d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f18136e;

    /* renamed from: f, reason: collision with root package name */
    public final String f18137f;

    /* renamed from: g, reason: collision with root package name */
    public f f18138g;

    /* loaded from: classes.dex */
    public static class ProvisioningException extends Exception {
        public ProvisioningException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public class a extends l {
        public a(int i10, String str, d.b bVar, d.a aVar) {
            super(i10, str, bVar, aVar);
        }

        @Override // com.android.volley.Request
        public Map<String, String> p() {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("VZW_MDN", Vvm3Subscriber.this.f18137f);
            arrayMap.put("VZW_SERVICE", "BVVM");
            arrayMap.put("DEVICE_MODEL", "DROID_4G");
            arrayMap.put("APP_TOKEN", "q8e3t5u2o1");
            arrayMap.put("SPG_LANGUAGE_PARAM", "ENGLISH");
            return arrayMap;
        }
    }

    /* loaded from: classes.dex */
    public class b extends l {

        /* renamed from: x, reason: collision with root package name */
        public final /* synthetic */ String f18140x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i10, String str, d.b bVar, d.a aVar, String str2) {
            super(i10, str, bVar, aVar);
            this.f18140x = str2;
        }

        @Override // com.android.volley.Request
        public byte[] j() {
            return this.f18140x.getBytes();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends h {

        /* renamed from: b, reason: collision with root package name */
        public final Network f18142b;

        public c(Network network) {
            this.f18142b = network;
        }

        @Override // T2.h
        public HttpURLConnection f(URL url) {
            return (HttpURLConnection) this.f18142b.openConnection(url);
        }
    }

    static {
        CookieHandler.setDefault(new CookieManager());
    }

    public Vvm3Subscriber(ActivationTask activationTask, PhoneAccountHandle phoneAccountHandle, com.android.contacts.voicemail.impl.b bVar, c.b bVar2, Bundle bundle) {
        C1580a.d();
        this.f18132a = activationTask;
        this.f18133b = phoneAccountHandle;
        this.f18134c = bVar;
        this.f18135d = bVar2;
        this.f18136e = bundle;
        this.f18137f = ((TelephonyManager) bVar.g().getSystemService(TelephonyManager.class)).createForPhoneAccountHandle(phoneAccountHandle).getLine1Number();
    }

    public static String e(List<Pattern> list, String str) {
        if (!list.isEmpty()) {
            Spanned fromHtml = Html.fromHtml(str, 0);
            URLSpan[] uRLSpanArr = (URLSpan[]) fromHtml.getSpans(0, fromHtml.length(), URLSpan.class);
            StringBuilder sb = new StringBuilder();
            for (URLSpan uRLSpan : uRLSpanArr) {
                String charSequence = fromHtml.subSequence(fromHtml.getSpanStart(uRLSpan), fromHtml.getSpanEnd(uRLSpan)).toString();
                Iterator<Pattern> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().matcher(charSequence).matches()) {
                        return uRLSpan.getURL();
                    }
                }
                sb.append(charSequence);
            }
            throw new ProvisioningException("Subscribe link not found: " + ((Object) sb));
        }
        throw new IllegalArgumentException("empty patterns");
    }

    public static List<Pattern> h(Context context) {
        String b10 = s1.d.a(context).b("vvm3_subscribe_link_pattern_json_array", "[\"(?i)Subscribe to Basic Visual Voice Mail\",\"(?i)Subscribe to Basic Visual Voicemail\"]");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(b10);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                arrayList.add(Pattern.compile(jSONArray.getString(i10)));
            }
            return arrayList;
        } catch (JSONException e10) {
            throw new IllegalArgumentException("Unable to parse patterns" + e10);
        }
    }

    public final void b(String str) {
        H7.b.e("Vvm3Subscriber", "Clicking subscribe link");
        k d10 = k.d();
        this.f18138g.a(new l(1, str, d10, d10));
        try {
            d10.get(30L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            this.f18134c.r(this.f18135d, OmtpEvents.VVM3_SPG_CONNECTION_FAILED);
            throw new ProvisioningException(e10.toString());
        }
    }

    public final String c() {
        return String.valueOf(Math.abs(new Random().nextLong()));
    }

    public final String d(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("<" + str2 + ">(.*)<\\/" + str2 + ">").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        throw new ProvisioningException("Tag " + str2 + " not found in xml response");
    }

    public final String f(String str) {
        H7.b.e("Vvm3Subscriber", "Retrieving self provisioning response");
        k d10 = k.d();
        this.f18138g.a(new a(1, str, d10, d10));
        try {
            return (String) d10.get(30L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            this.f18134c.r(this.f18135d, OmtpEvents.VVM3_SPG_CONNECTION_FAILED);
            throw new ProvisioningException(e10.toString());
        }
    }

    public final String g() {
        H7.b.e("Vvm3Subscriber", "retrieving SPG URL");
        return d(k("retrieveSPGURL"), "spgurl");
    }

    public final void i() {
        try {
            b(e(h(this.f18134c.g()), f(g())));
        } catch (ProvisioningException e10) {
            H7.b.c("Vvm3Subscriber", e10.toString());
            this.f18132a.j();
        }
    }

    public void j() {
        C1580a.d();
        H7.b.e("Vvm3Subscriber", "Subscribing");
        try {
            VvmNetworkRequest.b a10 = VvmNetworkRequest.a(this.f18134c, this.f18133b, this.f18135d);
            try {
                Network a11 = a10.a();
                H7.b.b("Vvm3Subscriber", "provisioning: network available");
                this.f18138g = m.b(this.f18134c.g(), new c(a11));
                i();
                a10.close();
            } finally {
            }
        } catch (VvmNetworkRequest.RequestFailedException unused) {
            this.f18134c.r(this.f18135d, OmtpEvents.VVM3_VMG_CONNECTION_FAILED);
            this.f18132a.j();
        }
    }

    public final String k(String str) {
        H7.b.b("Vvm3Subscriber", "Sending vvm3XmlRequest for " + str);
        String string = this.f18136e.getString("vmg_url");
        if (string == null) {
            H7.b.c("Vvm3Subscriber", "voicemailManagementGateway url unknown");
            return null;
        }
        String c10 = c();
        String format = String.format(Locale.US, "<?xml version=\"1.0\" encoding=\"UTF-8\"?><VMGVVMRequest>  <MessageHeader>    <transactionid>%1$s</transactionid>  </MessageHeader>  <MessageBody>    <mdn>%2$s</mdn>    <operation>%3$s</operation>    <source>Device</source>    <devicemodel>%4$s</devicemodel>  </MessageBody></VMGVVMRequest>", c10, this.f18137f, str, Build.MODEL);
        k d10 = k.d();
        this.f18138g.a(new b(1, string, d10, d10, format));
        try {
            String str2 = (String) d10.get(30L, TimeUnit.SECONDS);
            if (c10.equals(d(str2, "transactionid"))) {
                return str2;
            }
            throw new ProvisioningException("transactionId mismatch");
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            this.f18134c.r(this.f18135d, OmtpEvents.VVM3_VMG_CONNECTION_FAILED);
            throw new ProvisioningException(e10.toString());
        }
    }
}
