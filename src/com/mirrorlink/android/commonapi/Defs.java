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

package com.mirrorlink.android.commonapi;

/**
 * The Common API specifies an interface to the MirrorLink Server,
 * which allows any application to either get information about
 * MirrorLink Server or Client properties or to set them to specific values.
 * In addition, the API specifies callback functions, which are used from the
 * MirrorLink Server to inform the application about any change.
 * <br>
 * The Common API uses a set of Data Types, given in the table below, together
 * with the Java type used to represent the original Data type.
 * <br>
 * Please note that all the integer types defined in the MirrorLink protocol are used as int in the
 * Common API.
 * <pre>
 * Data Type  | Java Type  | Default Value | Description
 * -----------|------------|---------------|------------------------------------------------------
 * bool       | boolean    | false         | the logical values true and false.
 * uint8      | int        | 0             | integer values
 * uint16     | int        | 0             | integer values
 * uint32     | int        | 0             | integer values
 * int8       | int        | 0             | integer values
 * int16      | int        | 0             | integer values
 * int32      | int        | 0             | integer values
 * float      | Float      | 0.0           | a 32 bit  floating point value according IEEE754-1985, single-precision
 * double     | Double     | 0.0           | a 64 bit  floating point value according IEEE754-1985, double-precision
 * string8    | String     | null          | Array of UTF8 characters. Each character takes 1 byte (UTF8).
 * string16   | String     | null          | Array of UTF16 characters. Each character takes 2 bytes (UTF16).
 * url        | String     | null          | Data type representing a URL
 * typeName[] | List       | empty array   | Data type representing an array of values of type typename
 * typeName   | typeName   | default for   | Data type representing the structure typeName
 *            |            | all elements  |
 * void*      | Object     | null          | Reference to a data structure
 * </pre>
 */
public class Defs {
    /**
     * Common API Level provided by this interface.
     */
    public static final int API_LEVEL = 1;

    /**
     * Intents used to communicate between the MirrorLink server and MirrorLink aware applications.
     */
    public static final class Intents {
        /**
         * Intents used by applications to bind to the MirrorLink Server CommonAPI service.
         */
        public static final String BIND_MIRRORLINK_API = "com.mirrorlink.android.service.BIND";
        /**
         * Intent used by the MirrorLink service to ask applications to launch. All the MirrorLink
         * aware applications must handle this Intent and connect to the MirrorLink service once
         * started by using {@link #BIND_MIRRORLINK_API}.
         */
        public static final String LAUNCH_MIRRORLINK_APP = "com.mirrorlink.android.app.LAUNCH";
        /**
         * Intent used by the MirrorLink service to ask applications to terminate. All the MirrorLink
         * aware applications must handle this Intent and disconnect from the MirrorLink service.
         */
        public static final String TERMINATE_MIRRORLINK_APP = "com.mirrorlink.android.app.TERMINATE";
        /**
         * The category that the intent MUST use when an application is launched, or terminated.
         */
        public static final String INTENT_CATEGORY = "android.intent.category.DEFAULT";
    }
    /*****************************************************************************
     3 DEFINITIONS
     *****************************************************************************/
    /**
     * 3.1 Rect Bundle property names.
     * <br>
     * <i>Structure reference: 0xE001.</i>
     */
    public static final class Rect {
        /**
         * Horizontal offset of the upper left corner.
         * uint16 packaged as an int
         */
        public static final String X = "X";
        /**
         * Vertical offset of the upper left corner.
         * uint16 packaged as an int
         */
        public static final String Y = "Y";
        /**
         * Width of the rectangle.
         * uint16 packaged as an int
         */
        public static final String WIDTH = "WIDTH";
        /**
         * Height of the rectangle.
         * uint16 packaged as an int
         */
        public static final String HEIGHT = "HEIGHT";

    }
    /**
     * 3.2 ServiceInformation Bundle property names.
     * <br>
     * <i>Structure reference: 0xE002.</i>
     */
    public static final class ServiceInformation {
        /**
         * Major service version.
         * uint8 packaged as a int
         */
        public static final String VERSION_MAJOR = "VERSION_MAJOR";
        /**
         * Minor service version.
         * uint8 packaged as a int
         */
        public static final String VERSION_MINOR = "VERSION_MINOR";
        /**
         * Service identifier.
         * uint16 packaged as an int
         */
        public static final String SERVICE_ID = "SERVICE_ID";
        /**
         * Service name.
         * String
         */
        public static final String SERVICE_NAME = "SERVICE_NAME";
    }
    /**
     * 3.3 Action Bundle property names.
     * <br>
     * <i>Structure reference: 0xE003.</i>
     */
    public static final class Action {
        /**
         * Action identifier.
         * uint16 packaged as an int
         */
        public static final String ACTION_ID = "ACTION_ID";
        /**
         * Action name.
         * String
         */
        public static final String ACTION_NAME = "ACTION_NAME";
        /**
         * Flag whether to launch the app.
         * boolean
         */
        public static final String LAUNCH_APP = "LAUNCH_APP";
        /**
         * URL to the con associated with the action.
         * url packaged as a String
         */
        public static final String ICON_URL = "ICON_URL";
    }
    /*****************************************************************************
     4 COMMON API ELEMENTS
     *****************************************************************************/
    /** 4.2 MirrorLink Device Info */

    /**
     * 4.2.4 ClientInformation Bundle property names.
     */
    public static final class ClientInformation {
        /**
         * Identifier of the MirrorLink client.
         * String
         */
        public static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER";
        /**
         * Short user-friendly description of the MirrorLink client.
         * String
         */
        public static final String CLIENT_FRIENDLY_NAME = "CLIENT_FRIENDLY_NAME";
        /**
         * Manufacturer Name of the MirrorLink client.
         * String
         */
        public static final String CLIENT_MANUFACTURER = "CLIENT_MANUFACTURER";
        /**
         * Model name of the MirrorLink client.
         * String
         */
        public static final String CLIENT_MODEL_NAME = "CLIENT_MODEL_NAME";
        /**
         * Model number of the MirrorLink client.
         * String
         */
        public static final String CLIENT_MODEL_NUMBER = "CLIENT_MODEL_NUMBER";
    }

    /**
     * 4.2.5 Server Device Virtual Keyboard Support property names.
     */
    public static final class VirtualKeyboardSupport {
        /**
         * Flag, to indicate the availability of a virtual keyboard 
         * from the MirrorLink Server. 
         * boolean
         */
        public static final String AVAILABLE = "AVAILABLE";
        /**
         * Flag, to indicate whether the virtual keyboard supports 
         * touch events. 
         * boolean
         */
        public static final String TOUCH_SUPPORT = "TOUCH_SUPPORT";
        /**
         * Flag, to indicate whether the virtual keyboard supports 
         * knob events. 
         * boolean
         */
        public static final String KNOB_SUPPORT = "KNOB_SUPPORT";
        /**
         * Flag, to indicate whether the virtual keyboard is following driver distraction ruling,
         * as set force for CCC drive-certification.
         * boolean
         */
        public static final String DRIVE_MODE = "DRIVE_MODE";
    }


    /** 4.3 Certification Information */

    /**
     * 4.3.1 ApplicationCertificationStatus Bundle property names and values.
     */
    public static final class ApplicationCertificationStatus {
        /**
         * Flag, indicating whether the MirrorLink server has a valid certificate for the
         * application.
         * boolean
         */
        public static final String HAS_VALID_CERTIFICATE = "HAS_VALID_CERTIFICATE";
        /**
         * Flag, indicating, whether the MirrorLink server has included the application into its
         * UPnP advertisements as a certified application. If the application is only certified by a
         * manufacturer, the value of this will be false, unless the server is connected to a client
         * that matches the manufacturer name.
         * boolean
         */
        public static final String ADVERTISED_AS_CERTIFIEDAPP = "ADVERTISED_AS_CERTIFIEDAPP";
    }
    /**
     * 4.3.3 CertificateInformation Bundle property names and values
     */
    public static final class CertificateInformation {
        /**
         * Name of the certifying entity.
         * String
         */
        public static final String ENTITY = "ENTITY";
        /**
         * Flag, whether the application has been certified from the given entity.
         * boolean
         */
        public static final String CERTIFIED = "CERTIFIED";
        /**
         * Comma-separated list of locales for which the application has been certified
         * for restricted use (drive-level) from the given entity.
         * String
         */
        public static final String RESTRICTED = "RESTRICTED";
        /**
         * Comma-separated list of locales for which the application has been certified
         * for non-restricted use (base-level) from the given entity.
         * String
         */
        public static final String NONRESTRICTED = "NONRESTRICTED";
    }

    /** 4.4 Connection Information */

    /**
     * 4.4.3 AudioConnections Bundle property names and values
     */
    public static final class AudioConnections {
        /**
         * Identifier of the audio connection for media audio (output).
         * uint8 packaged as a int
         */
        public static final String MEDIA_AUDIO_OUT = "MEDIA_AUDIO_OUT";
        /**
         * Identifier of the audio connection for media audio (input).
         * uint8 packaged as a int
         */
        public static final String MEDIA_AUDIO_IN = "MEDIA_AUDIO_IN";
        /**
         * Identifier of the audio connection for Voice Control audio (input).
         * uint8 packaged as a int
         */
        public static final String VOICE_CONTROL = "VOICE_CONTROL";
        /**
         * Identifier of the audio connection for Phone audio (input & output).
         * uint8 packaged as a int
         */
        public static final String PHONE_AUDIO = "PHONE_AUDIO";
        /**
         * Comma separated list of supported RTP payload types in case an RTP connection is used.
         * String
         */
        public static final String PAYLOAD_TYPES = "PAYLOAD_TYPES";

        /**
         * AudioConnections MEDIA_AUDIO_OUT values.
         */
        /** Not established */
        public static final int MEDIA_OUT_NONE = 0x00;
        /** BT A2DP */
        public static final int MEDIA_OUT_BT_AD2DP = 0x01;
        /** RTP */
        public static final int MEDIA_OUT_RTP = 0x02;

        /**
         * AudioConnections MEDIA_AUDIO_IN values.
         */
        /** Not established */
        public static final int MEDIA_IN_NONE = 0x00;
        /** RTP */
        public static final int MEDIA_IN_RTP = 0x02;

        /**
         * AudioConnections VOICE_CONTROL values.
         */
        /** Not established */
        public static final int VOICE_CONTROL_NONE = 0x00;
        /** BT HFP + BVRA (Voice Control is outside MirrorLink Server’s responsibility; application must use existing platform APIs) */
        public static final int VOICE_CONTROL_BT_HFP = 0x01;
        /** RTP */
        public static final int VOICE_CONTROL_RTP = 0x02;

        /**
         * AudioConnections PHONE_AUDIO values.
         */
        /** Not established */
        public static final int INCALL_AUDIO_NONE = 0x00;
        /** BT HFP */
        public static final int INCALL_AUDIO_BT_HFP = 0x01;
        /** RTP */
        public static final int INCALL_AUDIO_RTP = 0x02;
    }
    /**
     * 4.4.5 RemoteDisplayConnection Bundle property names and values.
     */
    public static final class RemoteDisplayConnection {
        /**
         * RemoteDisplayConnection.RemoteDisplayType values.
         */
        public static final int REMOTEDISPLAY_NONE = 0x00;
        public static final int REMOTEDISPLAY_VNC = 0x01;
        public static final int REMOTEDISPLAY_HSML = 0x02;
        public static final int REMOTEDISPLAY_WFD = 0x03;
        public static final int REMOTEDISPLAY_OTHER = 0xFF;
    }

    /** 4.5 Display Information */

    /**
     * 4.5.1 DisplayConfiguration Bundle property names and values.
     */
    public static final class DisplayConfiguration {
        /**
         * Horizontal resolution in pixels of the framebuffer the application is rendering into.
         * uint16 packaged as an int
         */
        public static final String APP_PIXEL_WIDTH = "APP_PIXEL_WIDTH";
        /**
         * Vertical resolution in pixels of the framebuffer the application is rendering into.
         * uint16 packaged as an int
         */
        public static final String APP_PIXEL_HEIGHT = "APP_PIXEL_HEIGHT";
        /**
         * Horizontal resolution in pixel, after the MirrorLink Server has scaled the application
         * framebuffer.
         * uint16 packaged as an int
         */
        public static final String SERVER_PIXEL_WIDTH = "SERVER_PIXEL_WIDTH";
        /**
         * Vertical resolution in pixel, after the MirrorLink Server has scaled the application
         * framebuffer. 
         * uint16 packaged as an int
         */
        public static final String SERVER_PIXEL_HEIGHT = "SERVER_PIXEL_HEIGHT";
        /**
         * Number of pad rows added from the MirrorLink Server to the scaled application
         * framebuffer.
         * uint16 packaged as an int
         */
        public static final String SERVER_PAD_ROWS = "SERVER_PAD_ROWS";
        /**
         * Number of pad columns added from the MirrorLink Server to the scaled application
         * framebuffer.
         * uint16 packaged as an int
         */
        public static final String SERVER_PAD_COLUMNS = "SERVER_PAD_COLUMNS";
        /**
         * Horizontal resolution in pixels of the MirrorLink Client framebuffer,
         * available for rendering the MirrorLink Server’s screen.
         * uint16 packaged as an int
         */
        public static final String CLIENT_PIXEL_WIDTH = "CLIENT_PIXEL_WIDTH";
        /**
         * Vertical resolution in pixels of the MirrorLink Client framebuffer,
         * available for rendering the MirrorLink Server’s screen.
         * uint16 packaged as an int
         */
        public static final String CLIENT_PIXEL_HEIGHT = "CLIENT_PIXEL_HEIGHT";
        /**
         * Physical width in mm of the MirrorLink Client display,
         * where the MirrorLink Server’s screen appears.
         * uint16 packaged as an int
         */
        public static final String MM_WIDTH = "MM_WIDTH";
        /**
         * Physical height in mm of the MirrorLink Client display,
         * where the MirrorLink Server’s screen appears.
         * uint16 packaged as an int
         */
        public static final String MM_HEIGHT = "MM_HEIGHT";
        /**
         * Physical distance in mm of the MirrorLink Client display
         * from the driver’s head position.
         * uint16 packaged as an int
         */
        public static final String DISTANCE = "DISTANCE";
        /**
         * Number of application-level pixels, which will fit into 1 mm of Client Display space. 
         * float
         * <br>
         * Note: This value is the same for the horizontal and vertical dimension.
         */
        public static final String APP_PIXELS_PER_CLIENT_MM = "APP_PIXELS_PER_CLIENT_MM";
    }
    /**
     * 4.5.3 IDisplayManager.getClientPixelFormat values.
     */
    public static final class ClientPixelFormat {
        public static final int ARGB8888 = 0x01;
        public static final int RGB888 = 0x02;
        public static final int RGB565 = 0x03;
        public static final int RGB555 = 0x04;
        public static final int RGB444 = 0x05;
        public static final int RGB343 = 0x06;
        public static final int GRAY16 = 0x07;
        public static final int GRAY8 = 0x08;
    }
    /**
     * 4.5.5 Set Framebuffer Orientation Support.
     */
    public static final class FramebufferOrientationSupport {
        public static final int LANDSCAPE_ONLY = 0x01;
        public static final int PORTRAIT_ONLY = 0x02;
        public static final int LANDSCAPE_AND_PORTRAIT = 0x03;
    }

    /** 4.6 Event Related Features */
    /**
     * 4.6.1 EventConfiguration Bundle property names and values.
     */
    public static final class EventConfiguration {
        /**
         * Supported knob events from the MirrorLink Session.
         * Bit mask as defined in the VNC specification.
         * uint32 packaged as a int
         */
        public static final String KNOB_KEY_SUPPORT = "KNOB_KEY_SUPPORT";
        /**
         * Supported device key events from the MirrorLink Session.
         * Bit mask as defined in the VNC specification.
         * uint32 packaged as a int
         */
        public static final String DEVICE_KEY_SUPPORT = "DEVICE_KEY_SUPPORT";
        /**
         * Supported multimedia key events from the MirrorLink Session.
         * Bit mask as defined in the VNC specification.
         * uint32 packaged as a int
         */
        public static final String MULTIMEDIA_KEY_SUPPORT = "MULTIMEDIA_KEY_SUPPORT";
        /**
         * Number of supported function keys from the MirrorLink Session.
         * uint8 packaged as a int
         */
        public static final String FUNC_KEY_SUPPORT = "FUNC_KEY_SUPPORT";
        /**
         * Support for ITU keys from the MirrorLink Session.
         * boolean
         */
        public static final String ITU_KEY_SUPPORT = "ITU_KEY_SUPPORT";
        /**
         * Number of simultaneous touch events, supported from the MirrorLink Client.
         * uint8 packaged as a int
         */
        public static final String TOUCH_SUPPORT = "TOUCH_SUPPORT";
        /**
         * The pressure mask indicates how many pressure levels can be distinguished from the
         * MirrorLink Server and Client.
         */
        public static final String PRESSURE_MASK = "PRESSURE_MASK";
        /**
         * KNOB_KEY_SUPPORT values.
         */
        public static final int KNOB_KEY_SUPPORT_SHIFT_Y_0  = 0x00000002;
        public static final int KNOB_KEY_SUPPORT_SHIFT_XY_0 = 0x00000004;
        public static final int KNOB_KEY_SUPPORT_PUSH_Z_0   = 0x00000008;
        public static final int KNOB_KEY_SUPPORT_PULL_Z_0   = 0x00000010;
        public static final int KNOB_KEY_SUPPORT_ROTATE_X_0 = 0x00000020;
        public static final int KNOB_KEY_SUPPORT_ROTATE_Y_0 = 0x00000040;
        public static final int KNOB_KEY_SUPPORT_ROTATE_Z_0 = 0x00000080;
        public static final int KNOB_KEY_SUPPORT_SHIFT_X_1  = 0x00000100;
        public static final int KNOB_KEY_SUPPORT_SHIFT_Y_1  = 0x00000200;
        public static final int KNOB_KEY_SUPPORT_SHIFT_XY_1 = 0x00000400;
        public static final int KNOB_KEY_SUPPORT_PUSH_Z_1   = 0x00000800;
        public static final int KNOB_KEY_SUPPORT_PULL_Z_1   = 0x00001000;
        public static final int KNOB_KEY_SUPPORT_ROTATE_X_1 = 0x00002000;
        public static final int KNOB_KEY_SUPPORT_ROTATE_Y_1 = 0x00004000;
        public static final int KNOB_KEY_SUPPORT_ROTATE_Z_1 = 0x00008000;
        public static final int KNOB_KEY_SUPPORT_SHIFT_X_2  = 0x00010000;
        public static final int KNOB_KEY_SUPPORT_SHIFT_Y_2  = 0x00020000;
        public static final int KNOB_KEY_SUPPORT_SHIFT_XY_2 = 0x00040000;
        public static final int KNOB_KEY_SUPPORT_PUSH_Z_2   = 0x00080000;
        public static final int KNOB_KEY_SUPPORT_PULL_Z_2   = 0x00100000;
        public static final int KNOB_KEY_SUPPORT_ROTATE_X_2 = 0x00200000;
        public static final int KNOB_KEY_SUPPORT_ROTATE_Y_2 = 0x00400000;
        public static final int KNOB_KEY_SUPPORT_ROTATE_Z_2 = 0x00800000;
        public static final int KNOB_KEY_SUPPORT_SHIFT_X_3  = 0x01000000;
        public static final int KNOB_KEY_SUPPORT_SHIFT_Y_3  = 0x02000000;
        public static final int KNOB_KEY_SUPPORT_SHIFT_XY_3 = 0x04000000;
        public static final int KNOB_KEY_SUPPORT_PUSH_Z_3   = 0x08000000;
        public static final int KNOB_KEY_SUPPORT_PULL_Z_3   = 0x10000000;
        public static final int KNOB_KEY_SUPPORT_ROTATE_X_3 = 0x20000000;
        public static final int KNOB_KEY_SUPPORT_ROTATE_Y_3 = 0x40000000;
        public static final int KNOB_KEY_SUPPORT_ROTATE_Z_3 = 0x80000000;
        /**
         * DEVICE_KEY_SUPPORT values.
         */
        public static final int DEVICE_KEY_SUPPORT_PHONE_CALL  = 0x00000001;
        public static final int DEVICE_KEY_SUPPORT_PHONE_END   = 0x00000002;
        public static final int DEVICE_KEY_SUPPORT_SOFT_LEFT   = 0x00000004;
        public static final int DEVICE_KEY_SUPPORT_SOFT_MIDDLE = 0x00000008;
        public static final int DEVICE_KEY_SUPPORT_SOFT_RIGHT  = 0x00000010;
        public static final int DEVICE_KEY_SUPPORT_APPLICATION = 0x00000020;
        public static final int DEVICE_KEY_SUPPORT_OK          = 0x00000040;
        public static final int DEVICE_KEY_SUPPORT_DELETE      = 0x00000080;
        public static final int DEVICE_KEY_SUPPORT_ZOOM_IN     = 0x00000100;
        public static final int DEVICE_KEY_SUPPORT_ZOOM_OUT    = 0x00000200;
        public static final int DEVICE_KEY_SUPPORT_CLEAR       = 0x00000400;
        public static final int DEVICE_KEY_SUPPORT_FORWARD     = 0x00000800;
        public static final int DEVICE_KEY_SUPPORT_BACKWARD    = 0x00001000;
        public static final int DEVICE_KEY_SUPPORT_HOME        = 0x00002000;
        public static final int DEVICE_KEY_SUPPORT_SEARCH      = 0x00004000;
        public static final int DEVICE_KEY_SUPPORT_MENU        = 0x00008000;
        public static final int DEVICE_KEY_SUPPORT_ALL         = 0x00007fff;
        /**
         * MULTIMEDIA_KEY_SUPPORT values.
         */
        public static final int MULTIMEDIA_KEY_SUPPORT_PLAY     = 0x00000001;
        public static final int MULTIMEDIA_KEY_SUPPORT_PAUSE    = 0x00000002;
        public static final int MULTIMEDIA_KEY_SUPPORT_STOP     = 0x00000004;
        public static final int MULTIMEDIA_KEY_SUPPORT_FORWARD  = 0x00000008;
        public static final int MULTIMEDIA_KEY_SUPPORT_REWIND   = 0x00000010;
        public static final int MULTIMEDIA_KEY_SUPPORT_NEXT     = 0x00000020;
        public static final int MULTIMEDIA_KEY_SUPPORT_PREVIOUS = 0x00000040;
        public static final int MULTIMEDIA_KEY_SUPPORT_MUTE     = 0x00000080;
        public static final int MULTIMEDIA_KEY_SUPPORT_UNMUTE   = 0x00000100;
        public static final int MULTIMEDIA_KEY_SUPPORT_PHOTO    = 0x00000200;
        /**
         * TOUCH_SUPPORT values.
         */
        public static final int TOUCH_SUPPORT_NONE                     = 0x00;
        public static final int TOUCH_SUPPORT_SINGLE                   = 0x01;
        /**
         * The multi touch value will be a number greater or equal than 2. It will represent the
         * number of touches supported.
         */
        public static final int TOUCH_SUPPORT_MULTI                    = 0xFF;
    }
    /**
     * 4.6.4 EventMapping Bundle property names and values.
     */
    public static final class EventMapping {
        /**
         * Key event value of the remote event.
         */
        public static final String REMOTE_EVENT = "REMOTE_EVENT";
        /**
         * Key event value of the local event, as it will be emulated on the
         * MirrorLink Server device in response to the received remote event.
         */
        public static final String LOCAL_EVENT = "LOCAL_EVENT";
    }

    /** 4.9 Context Information Related Features */
    /**
     * 4.9.3 BlockingInformation values.
     */
    public static final class BlockingInformation {
        /**
         * IContextListener.onAudioBlocked reason values.
         */
        public static final int AUDIOBLOCKED_APPLICATION_CATEGORY_NOT_ALLOWED = 0x0001;
        public static final int AUDIOBLOCKED_APPLICATION_NOT_TRUSTED = 0x0002;
        public static final int AUDIOBLOCKED_APPLICATION_UNIQUE_ID_NOT_ALLOWED = 0x0004;
        public static final int AUDIOBLOCKED_GLOBALLY_MUTED = 0x0008;
        public static final int AUDIOBLOCKED_STREAM_MUTED = 0x0010;
        /**
         * IContextListener.onFramebufferBlocked reason values.
         */
        public static final int DISPLAYBLOCKED_CONTENT_CATEGORY_NOT_ALLOWED = 0x0001;
        public static final int DISPLAYBLOCKED_APPLICATION_CATEGORY_NOT_ALLOWED = 0x0002;
        public static final int DISPLAYBLOCKED_CONTENT_NOT_TRUSTED = 0x0004;
        public static final int DISPLAYBLOCKED_APPLICATION_NOT_TRUSTED = 0x0008;
        public static final int DISPLAYBLOCKED_CONTENT_RULES_NOT_FOLLOWED = 0x0010;
        public static final int DISPLAYBLOCKED_APPLICATION_UNIQUE_ID_NOT_ALLOWED = 0x0020;
        public static final int DISPLAYBLOCKED_UI_NOT_IN_FOCUS = 0x0100;
        public static final int DISPLAYBLOCKED_UI_NOT_VISIBLE = 0x0200;
        /**
         * IContextListener.onFramebufferOrientationBlocked values.
         */
        public static final int ORIENTATIONBLOCKED_LANDSCAPE = 0x01;
        public static final int ORIENTATIONBLOCKED_PORTRAIT = 0x02;
    }
    /**
     * 4.9.1, 4.9.3 Framebuffer and Audio Context Information values.
     */
    public static final class ContextInformation {
        /**
         * Application Categories.
         */
        public static final int APPLICATION_CATEGORY_MASK = 0xffff0000;
        public static final int APPLICATION_CATEGORY_UNKNOWN = 0x00000000;
        public static final int APPLICATION_CATEGORY_PHONE = 0x00020000;
        public static final int APPLICATION_CATEGORY_PHONE_CONTACT_LIST = 0x00020001;
        public static final int APPLICATION_CATEGORY_PHONE_CALL_LOG = 0x00020002;
        public static final int APPLICATION_CATEGORY_MEDIA = 0x00030000;
        public static final int APPLICATION_CATEGORY_MEDIA_MUSIC = 0x00030001;
        public static final int APPLICATION_CATEGORY_MEDIA_VIDEO = 0x00030002;
        public static final int APPLICATION_CATEGORY_MEDIA_GAMING = 0x00030003;
        public static final int APPLICATION_CATEGORY_MEDIA_IMAGE = 0x00030004;
        public static final int APPLICATION_CATEGORY_MESSAGING = 0x00040000;
        public static final int APPLICATION_CATEGORY_MESSAGING_SMS = 0x00040001;
        public static final int APPLICATION_CATEGORY_MESSAGING_MMS = 0x00040002;
        public static final int APPLICATION_CATEGORY_MESSAGING_EMAIL = 0x00040003;
        public static final int APPLICATION_CATEGORY_NAVIGATION = 0x00050000;
        public static final int APPLICATION_CATEGORY_BROWSER = 0x00060000;
        public static final int APPLICATION_CATEGORY_BROWSER_APPLICATION_STORE = 0x00060001;
        public static final int APPLICATION_CATEGORY_PRODUCTIVITY = 0x00070000;
        public static final int APPLICATION_CATEGORY_PRODUCTIVITY_DOCUMENT_VIEWER = 0x00070001;
        public static final int APPLICATION_CATEGORY_PRODUCTIVITY_DOCUMENT_EDITOR = 0x00070002;
        public static final int APPLICATION_CATEGORY_INFORMATION = 0x00080000;
        public static final int APPLICATION_CATEGORY_INFORMATION_NEWS = 0x00080001;
        public static final int APPLICATION_CATEGORY_INFORMATION_WEATHER = 0x00080002;
        public static final int APPLICATION_CATEGORY_INFORMATION_STOCKS = 0x00080003;
        public static final int APPLICATION_CATEGORY_INFORMATION_TRAVEL = 0x00080004;
        public static final int APPLICATION_CATEGORY_INFORMATION_SPORTS = 0x00080005;
        public static final int APPLICATION_CATEGORY_INFORMATION_CLOCK = 0x00080006;
        public static final int APPLICATION_CATEGORY_SOCIAL_NETWORKING = 0x00090000;
        public static final int APPLICATION_CATEGORY_PIM = 0x000a0000;
        public static final int APPLICATION_CATEGORY_PIM_CALENDAR = 0x000a0001;
        public static final int APPLICATION_CATEGORY_PIM_NOTES = 0x000a0002;
        /**
         * Content Categories.
         */
        public static final int VISUAL_CONTENT_CATEGORY_TEXT = 0x00000001;
        public static final int VISUAL_CONTENT_CATEGORY_VIDEO = 0x00000002;
        public static final int VISUAL_CONTENT_CATEGORY_IMAGE = 0x00000004;
        public static final int VISUAL_CONTENT_CATEGORY_GRAPHICS_VECTOR = 0x00000080;
        public static final int VISUAL_CONTENT_CATEGORY_GRAPHICS_3D = 0x00000010;
        public static final int VISUAL_CONTENT_CATEGORY_UI = 0x00000020;
        public static final int VISUAL_CONTENT_CATEGORY_CAR_MODE = 0x00010000;
        public static final int VISUAL_CONTENT_CATEGORY_MISC = 0x80000000;
    }

    /** 4.11 Data Services  */

    /**
     * Constants used for the types of subscriptions. A value defined here is used in the {@link
     * IDataServicesListener#onSubscribeResponse}.
     */
    public static final class SubscriptionType {
        public static final int REGULAR_INTERVAL = 0x00;
        public static final int ON_CHANGE        = 0x01;
        public static final int AUTOMATIC        = 0x02;
    }

    /**
     * Constants used when interacting with the Location data service.
     */
    public static final class LocationService {
        /**
         * Location Service name.
         */
        public static final String SERVICE_NAME = "com.mirrorlink.location";
        /**
         * Location Object uid.
         */
        public static final int LOCATION_OBJECT_UID = 0x572a6461;
        /**
         * Location Object Bundle property names.
         */
        public static final String COORD_FIELD_UID = "0xbad026d0";
        public static final String LATITUDE_FIELD_UID = "0x64f8f3f1";
        public static final String LONGITUDE_FIELD_UID = "0x7581892a";
        public static final String ACCURACY_FIELD_UID = "0x5ec654de";
        public static final String ALTITUDE_FIELD_UID = "0x970e9047";
        public static final String ALTITUDEACCURACY_FIELD_UID = "0xc28b9440";
        public static final String HEADING_FIELD_UID = "0x813c675d";
        public static final String SPEED_FIELD_UID = "0x23234962";
        public static final String TIMESTAMP_FIELD_UID = "0x59413fd1";
    }
    /**
     * Constants used when interacting with the GPS data service.
     */
    public static final class GPSService {
        /**
         * GPS Service name.
         */
        public static final String SERVICE_NAME = "com.mirrorlink.gps";
        /**
         * NMEA Object uid.
         */
        public static final int NMEA_OBJECT_UID = 0x0aac4540;
        /**
         * NMEA Object Bundle property names.
         */
        public static final String NMEA_DATA_FIELD_UID      = "0x144a776f";
        public static final String NMEA_TIMESTAMP_FIELD_UID = "0x59413fd1";
        /**
         * NMEADescription Object uid.
         */
        public static final int NMEADESCRIPTION_OBJECT_UID = 0x9d08b19d;
        /**
         * NMEADescription Object Bundle property names.
         */
        public static final String NMEADESCRIPTION_SUPPORTED_FIELD_UID = "0x6e72b167";
        /**
         * GPS supported sentences flags.
         */
        public static final int SUPPORT_GGA              = 0x01;
        public static final int SUPPORT_GLL              = 0x02;
        public static final int SUPPORT_GSA              = 0x04;
        public static final int SUPPORT_GSV              = 0x08;
        public static final int SUPPORT_RMC              = 0x10;
        public static final int SUPPORT_VTG              = 0x20;
        public static final int SUPPORT_GST              = 0x40;
    }

    /** 4.12 Notifications */
    /**
     * 4.12.4 NotificationConfiguration Bundle property names.
     */
    public static final class NotificationConfiguration {
        /**
         * Flag, whether the MirrorLink client supports its own notification UI.
         * boolean
         */
        public static final String NOTIFICATION_SUPPORTED = "NOTIFICATION_SUPPORTED";
        /**
         * Maximum number of actions.
         */
        public static final String MAX_ACTIONS = "MAX_ACTIONS";
        /**
         * Maximum number of characters of the Action Name.
         */
        public static final String MAX_ACTION_NAME_LENGTH = "MAX_ACTION_NAME_LENGTH";
        /**
         * Maximum number of characters of the notification title.
         */
        public static final String MAX_TITLE_LENGTH = "MAX_TITLE_LENGTH";
        /**
         * Maximum number of characters of the notification body.
         */
        public static final String MAX_BODY_LENGTH = "MAX_BODY_LENGTH";
    }
}
