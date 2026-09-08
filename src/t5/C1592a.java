package t5;

import android.text.TextUtils;
import com.heytap.accessory.bean.ServiceChannel;
import com.heytap.accessory.bean.ServiceProfile;
import com.heytap.accessory.constant.AFConstants;
import com.heytap.accessory.utils.ResourceParserException;
import java.util.ArrayList;
import java.util.List;
import n5.C1371a;
import org.xmlpull.v1.XmlPullParser;
import r5.k;

/* compiled from: ServiceProfileBuilder.java */
/* renamed from: t5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1592a {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f37268b = {"ANY", "ONE_ACCESSORY", "ONE_PEERAGENT"};

    /* renamed from: a, reason: collision with root package name */
    public ServiceProfile f37269a = new ServiceProfile();

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("enable".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("disable".equalsIgnoreCase(str)) {
            return 0;
        }
        throw new ResourceParserException("Invalid XML attribute profile / awakenable value:" + str);
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C1371a.k("ServiceProfileBuilder", "Invalid attribute :" + str + " value:" + str2);
        }
    }

    public static int d(String str) {
        b("serviceChannel/id", str);
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new ResourceParserException("Invalid XML attributeserviceChannel/id value:" + str);
        }
    }

    public static int g(String str) {
        if (str == null) {
            return 1;
        }
        if ("filetransfer".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("streaming".equalsIgnoreCase(str)) {
            return 2;
        }
        if ("default".equalsIgnoreCase(str)) {
            return 1;
        }
        int l10 = l(str);
        C1371a.g("ServiceProfileBuilder", "user defined value " + str + " , " + l10);
        return l10;
    }

    public static int h(String str) {
        b("serviceChannel/priority", str);
        if ("Low".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("Medium".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("High".equalsIgnoreCase(str)) {
            return 2;
        }
        throw new ResourceParserException("Invalid XML attributeserviceChannel / priority value:" + str);
    }

    public static int i(String str) {
        b("serviceChannel / reliability", str);
        if ("enable".equalsIgnoreCase(str)) {
            return 5;
        }
        if ("disable".equalsIgnoreCase(str)) {
            return 4;
        }
        throw new ResourceParserException("Invalid XML attributeserviceChannel / reliability value:" + str);
    }

    public static int j(String str) {
        if (str == null) {
            return 0;
        }
        String[] strArr = f37268b;
        if (strArr[1].equalsIgnoreCase(str)) {
            return 1;
        }
        if (strArr[2].equalsIgnoreCase(str)) {
            return 2;
        }
        if (strArr[0].equalsIgnoreCase(str)) {
            return 0;
        }
        throw new ResourceParserException("Invalid XML attributeserviceProfile / serviceLimit value:" + str);
    }

    public static int k(String str) {
        if (str == null) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt >= 0) {
                return parseInt;
            }
            C1371a.k("ServiceProfileBuilder", "Negetive service timeout:" + str + " initializing timeout to 0");
            return 0;
        } catch (NumberFormatException unused) {
            throw new ResourceParserException("Invalid XML attributeserviceProfile / serviceTimeout value:" + str);
        }
    }

    public static int l(String str) {
        return (Math.abs(m(str)) % 245) + 10;
    }

    public static int m(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String lowerCase = str.toLowerCase();
        int i10 = 0;
        for (int i11 = 0; i11 < lowerCase.length(); i11++) {
            i10 = lowerCase.charAt(i11) + (31 * i10);
        }
        return i10;
    }

    public final void c(XmlPullParser xmlPullParser) {
        int d10 = d(xmlPullParser.getAttributeValue(null, "id"));
        String attributeValue = xmlPullParser.getAttributeValue(null, AFConstants.EXTRA_PRIORITY);
        if (attributeValue == null) {
            attributeValue = xmlPullParser.getAttributeValue(null, "qosPriority");
        }
        int h10 = h(attributeValue);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "reliability");
        if (attributeValue2 == null) {
            attributeValue2 = xmlPullParser.getAttributeValue(null, "qosType");
        }
        int i10 = i(attributeValue2);
        int g10 = g(xmlPullParser.getAttributeValue(null, "class"));
        List<ServiceChannel> serviceChannelList = this.f37269a.getServiceChannelList();
        if (serviceChannelList == null) {
            serviceChannelList = new ArrayList<>();
            this.f37269a.setServiceChannelList(serviceChannelList);
        }
        if (serviceChannelList.add(new ServiceChannel(d10, h10, i10, g10))) {
            this.f37269a.setIsSocketSupported(1);
            return;
        }
        throw new ResourceParserException("Duplicate Service channel description for channel ID:" + d10);
    }

    public final void e(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "impl");
        b("impl", attributeValue);
        this.f37269a.setServiceImpl(attributeValue);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "name");
        b("profile/name", attributeValue2);
        this.f37269a.setName(attributeValue2);
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "urn");
        String substring = attributeValue3.substring(0, attributeValue3.lastIndexOf(":"));
        b("profile/id", substring);
        this.f37269a.setId(substring);
        String substring2 = attributeValue3.substring(attributeValue3.lastIndexOf(":") + 1);
        b("profile/version", substring2);
        this.f37269a.setVersion(substring2);
        this.f37269a.setServiceLimit(j(xmlPullParser.getAttributeValue(null, "limit")));
        this.f37269a.setServiceTimeout(k(xmlPullParser.getAttributeValue(null, "timeout")));
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "connectionType");
        b("transport/type", attributeValue4);
        this.f37269a.setTransportType(k.a(attributeValue4));
        this.f37269a.setAwakenable(a(xmlPullParser.getAttributeValue(null, "awakenable")));
        String attributeValue5 = xmlPullParser.getAttributeValue(null, "features");
        if (attributeValue5 != null) {
            for (String str : attributeValue5.split("\\|")) {
                if (str.equalsIgnoreCase("MSGEXPY")) {
                    this.f37269a.setIsMexSupported(1);
                    return;
                }
            }
        }
    }

    public ServiceProfile f() {
        return this.f37269a;
    }

    public boolean n(XmlPullParser xmlPullParser) {
        if (!"provider".equals(xmlPullParser.getName()) && !"consumer".equals(xmlPullParser.getName())) {
            return false;
        }
        return true;
    }

    public void o(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        if ("provider".equals(name)) {
            this.f37269a.setRole(0);
            e(xmlPullParser);
        } else if ("consumer".equals(name)) {
            this.f37269a.setRole(1);
            e(xmlPullParser);
        } else if ("channel".equals(name)) {
            c(xmlPullParser);
        }
    }

    public void p() {
        this.f37269a = new ServiceProfile();
    }
}
