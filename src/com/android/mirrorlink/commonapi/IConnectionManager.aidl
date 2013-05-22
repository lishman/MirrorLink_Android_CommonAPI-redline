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
 * Provides the interface related to 4.3 Connection Information
 */

package com.android.mirrorlink.commonapi;

import android.os.Bundle;

import com.android.mirrorlink.commonapi.IConnectionListener;

/**
 * Interface used to access the Connection Information related features
 */
interface IConnectionManager {

    /**
     *  indicates whether a MirrorLink session is currently established.
     *  A MirrorLink is considered established if a ClientProfile has been
     *  set on the MirrorLink Server for the current tethering session
     */
    boolean isMirrorLinkSessionEstablished();

    /**
     * 4.3.1 Established Audio Connections
     * Established Audio connections within MirrorLink Session
     *
     * @return Bundle containing the status of the audio connections available
     */
    Bundle getAudioConnections();

    /**
     * 4.3.3 Established Remote Display Connection
     * Established remote display connection within MirrorLink Session
     *
     * @return Bundle containing the status of the remote display connections available
     */
    byte getRemoteDisplayConnections();

    /**
     * Register the listener for monitoring the ConnectionManager
     *
     * @param   listener the listener to register
     *
     * @return  true is the listener was registered, false otherwise
     */
    boolean registerListener(in IConnectionListener listener);

    /**
     * UnRegister the listener monitoring the ConnectionManager
     *
     * @param   listener the listener to unregister
     *
     * @return  true is the listener was registered, false otherwise
     */
    boolean unregisterListener(in IConnectionListener listener);
}
