package r0;

import com.android.incallui.OplusNumberMarkUtils;
import com.android.incallui.OplusPhoneUtils;
import com.internal_dependency.Constants;
import com.oplus.foundation.util.OsUtils;

/* compiled from: StringKeyMapping.kt */
/* loaded from: classes.dex */
public final class i implements com.android.contacts.compat.data.d {
    @Override // com.android.contacts.compat.data.b
    public String a(String key) {
        kotlin.jvm.internal.i.f(key, "key");
        OsUtils osUtils = OsUtils.f28275a;
        if (osUtils.j()) {
            return key;
        }
        switch (key.hashCode()) {
            case -1950572734:
                if (key.equals("opluswirelesssettings.log.switch")) {
                    return "oppowirelesssettings.log.switch";
                }
                return key;
            case -1891704417:
                if (key.equals(OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE)) {
                    return "oppo.permission.OPPO_COMPONENT_SAFE";
                }
                return key;
            case -862032226:
                if (key.equals(Constants.CONFIG_OPLUS_SUPPORT_VIWIFI_BOOL)) {
                    return "config_oppo_support_viwifi_bool#config_oplus_support_viwifi_bool";
                }
                return key;
            case -202752133:
                if (key.equals("ro.vendor.oplus.regionmark") && !osUtils.i()) {
                    return "ro.oppo.regionmark";
                }
                return key;
            case 2228640:
                if (key.equals("oplus.intent.action.simsettings.SET_DATA_ROAMING") && !OsUtils.m()) {
                    return "oppo.intent.action.simsettings.SET_DATA_ROAMING";
                }
                return key;
            case 1516351852:
                if (key.equals("oplus_set_starred")) {
                    return "oppo_set_starred";
                }
                return key;
            case 1627247451:
                if (key.equals("oplussimsettings.log.switch") && !OsUtils.c()) {
                    return "opposimsettings.log.switch";
                }
                return key;
            case 1767192355:
                if (key.equals("OPLUS_CUSTOM_CALL_URI") && !OsUtils.m()) {
                    return "OPPO_CUSTOM_CALL_URI";
                }
                return key;
            case 1805418580:
                if (key.equals("persist.sys.oplus.region") && !OsUtils.m()) {
                    return "persist.sys.oppo.region";
                }
                return key;
            case 1926758678:
                if (key.equals("from_oplus_app")) {
                    return OplusNumberMarkUtils.OplusContact.FROM_OPLUS_APP;
                }
                return key;
            default:
                return key;
        }
    }
}
