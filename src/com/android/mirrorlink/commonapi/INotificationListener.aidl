/* Copyright 2013 RealVNC ltd.
 * Portions Copyright 2011-2013 Car Connectivity Consortium LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Provides the interface related to 4.9 Notifications
 */

package com.android.mirrorlink.commonapi;

import android.os.Bundle;

/**
 * Interface used to implement the CNotifications call backs
 */
oneway interface INotificationListener
{
    /**
     * 4.9.3 Notifications Enabled Callback
     * Notification that enablement has changed
     *
     * @param   notiEnabled the flag indicating the notifications are enabled or not
     */
    void onNotificationEnabledChanged(in boolean notiEnabled);

    /**
     * 4.9.5 Notification Configuration Callback
     * Notification Configuration information has changed.
     *
     * @param   notificationConfiguration the UPnP notification service related preference of Client
     */
    void onNotificationConfigurationChanged(in Bundle notificationConfiguration);

    /**
     * 4.9.10 Receive Action Callback
     * Receive action from the MirrorLink Client for a notification;
     *
     * @param notificationId Identifier of the notification
     *
     * @param actionId Action identifier
     */
    void onNotificationActionReceived(in long notificationId, in int actionId);
}
