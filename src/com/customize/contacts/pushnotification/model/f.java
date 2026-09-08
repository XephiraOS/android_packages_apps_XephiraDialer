package com.customize.contacts.pushnotification.model;

import b0.AbstractC0515b;
import b0.InterfaceC0514a;
import com.customize.contacts.pushnotification.model.PushNotificationDatabase;

/* compiled from: PushNotificationDatabase_AutoMigration_1_2_Impl.java */
/* loaded from: classes3.dex */
public class f extends AbstractC0515b {

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0514a f21784c;

    public f() {
        super(1, 2);
        this.f21784c = new PushNotificationDatabase.a();
    }

    @Override // b0.AbstractC0515b
    public void a(e0.g gVar) {
        gVar.m("CREATE TABLE IF NOT EXISTS `_new_notification` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `last_display_time` INTEGER NOT NULL DEFAULT -1, `display_period` INTEGER NOT NULL DEFAULT 0, `has_ignored_time` INTEGER NOT NULL DEFAULT 0, `max_ignore_time` INTEGER NOT NULL DEFAULT 1, `priority` INTEGER NOT NULL DEFAULT 2147483647, `notification_string_id` TEXT NOT NULL DEFAULT '', `show_ignore_button` INTEGER NOT NULL DEFAULT false, `show_first_action_button` INTEGER NOT NULL DEFAULT false, `show_second_action_button` INTEGER NOT NULL DEFAULT false, `language_restrict` TEXT NOT NULL DEFAULT '', `region_restrict` TEXT NOT NULL DEFAULT '', `state` INTEGER NOT NULL DEFAULT 0, `last_query_time` INTEGER NOT NULL DEFAULT 0)");
        gVar.m("INSERT INTO `_new_notification` (`last_query_time`,`priority`,`notification_string_id`,`has_ignored_time`,`show_ignore_button`,`language_restrict`,`last_display_time`,`display_period`,`id`,`show_second_action_button`,`state`,`max_ignore_time`,`show_first_action_button`,`region_restrict`) SELECT `last_query_time`,`priority`,`notification_string_id`,`has_ignored_time`,`show_ignore_button`,`language_restrict`,`last_display_time`,`display_period`,`id`,`show_second_action_button`,`state`,`max_ignore_time`,`show_first_action_button`,`region_restrict` FROM `notification`");
        gVar.m("DROP TABLE `notification`");
        gVar.m("ALTER TABLE `_new_notification` RENAME TO `notification`");
        this.f21784c.a(gVar);
    }
}
