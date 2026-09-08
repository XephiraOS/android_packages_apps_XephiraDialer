package r0;

import com.android.incallui.OplusNumberMarkUtils;
import com.oplus.foundation.util.OsUtils;

/* compiled from: UriKeyMapping.kt */
/* loaded from: classes.dex */
public final class j implements com.android.contacts.compat.data.e {
    @Override // com.android.contacts.compat.data.b
    public String a(String key) {
        kotlin.jvm.internal.i.f(key, "key");
        if (OsUtils.f28275a.j()) {
            return key;
        }
        switch (key.hashCode()) {
            case -2122083248:
                if (key.equals("from_customize_app")) {
                    return OplusNumberMarkUtils.OplusContact.FROM_OPLUS_APP;
                }
                return key;
            case -2003514051:
                if (key.equals("fix_contacts")) {
                    return "oppo_fix_contacts";
                }
                return key;
            case -1881581015:
                if (key.equals("query_vip_by_contact_id")) {
                    return "oppo_query_vip_by_contact_id";
                }
                return key;
            case -1712458118:
                if (key.equals("query_contacts_count")) {
                    return "oppo_query_contacts_count";
                }
                return key;
            case -1699132179:
                if (key.equals("customize_voicemail")) {
                    return "oppo_voicemail";
                }
                return key;
            case -1588379543:
                if (key.equals("starred_position")) {
                    return "oppo_starred_position";
                }
                return key;
            case -1386652367:
                if (key.equals("all_contacts")) {
                    return "oppo_all_contacts";
                }
                return key;
            case -1386028127:
                if (key.equals("from_contact_editor")) {
                    return "oppo_from_contact_editor";
                }
                return key;
            case -1337891774:
                if (key.equals("dial_contacts")) {
                    return "oppo_dial_contacts";
                }
                return key;
            case -1091660781:
                if (key.equals("modify_date")) {
                    return "oppo_modify_date";
                }
                return key;
            case -1063583738:
                if (key.equals("ringtone_update")) {
                    return "oppo_ringtone_update";
                }
                return key;
            case -847776042:
                if (key.equals("contact_uri_query")) {
                    return "oppo_contact_uri_query";
                }
                return key;
            case -724533512:
                if (key.equals("query_blacklist_as_selection")) {
                    return "oppo_query_blacklist_as_selelction";
                }
                return key;
            case -716862294:
                if (key.equals("calls_contact_customized")) {
                    return "color_calls_customized";
                }
                return key;
            case -656020058:
                if (key.equals("calls_with_normalized")) {
                    return "oppo_calls_with_normalized";
                }
                return key;
            case -325971554:
                if (key.equals("location_groups")) {
                    return "oppo_location_groups/";
                }
                return key;
            case -211445689:
                if (key.equals("smart_company_group")) {
                    return "oppo_smart_company_group";
                }
                return key;
            case -203481928:
                if (key.equals("cancel_aggregate_contacts")) {
                    return "oppo_cancel_aggregate_contacts";
                }
                return key;
            case 0:
                if (key.equals("")) {
                    return "oppomarket://details?packagename=";
                }
                return key;
            case 99893977:
                if (key.equals("customize_calls")) {
                    return "oppo_calls";
                }
                return key;
            case 103145323:
                if (key.equals("local")) {
                    return "oppo";
                }
                return key;
            case 113412556:
                if (key.equals("customize_query")) {
                    return "oppo_query";
                }
                return key;
            case 363321659:
                if (key.equals("favorites_contacts")) {
                    return "oppo_favorites_contacts";
                }
                return key;
            case 622494323:
                if (key.equals("get_multiple_group_members")) {
                    return "oppo_get_multiple_group_members";
                }
                return key;
            case 1000109913:
                if (key.equals("group_members")) {
                    return "oppo_group_members";
                }
                return key;
            case 1282434032:
                if (key.equals("group_ring")) {
                    return "oppo_group_ring";
                }
                return key;
            case 1422049419:
                if (key.equals("view_all_contacts")) {
                    return "oppo_view_all_contacts";
                }
                return key;
            case 1443195344:
                if (key.equals("data_id")) {
                    return "oppo_data_id";
                }
                return key;
            case 1469067301:
                if (key.equals("group_member_count_by_title")) {
                    return "oppo_group_member_count_by_title";
                }
                return key;
            case 1540798847:
                if (key.equals("com.android.local")) {
                    return "com.oppo.contacts.device";
                }
                return key;
            case 1681394538:
                if (key.equals("sim_index")) {
                    return "oppo_sim_index";
                }
                return key;
            case 1742237198:
                if (key.equals("query_mimetypes")) {
                    return "oppo_query_mimetypes";
                }
                return key;
            case 1857657555:
                if (key.equals("aggregate_contacts")) {
                    return "oppo_aggregate_contacts";
                }
                return key;
            case 1961626259:
                if (key.equals("display_contacts_with_phones_settings")) {
                    return "oppo_display_contacts_with_phones_settings";
                }
                return key;
            case 1982636500:
                if (key.equals("contacts_and_raw")) {
                    return "oppo_contacts_and_raw";
                }
                return key;
            default:
                return key;
        }
    }
}
