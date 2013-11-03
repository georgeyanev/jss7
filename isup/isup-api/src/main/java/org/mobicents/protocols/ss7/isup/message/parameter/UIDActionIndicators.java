/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2013, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

/**
 * Start time:14:17:18 2009-07-23<br>
 * Project: mobicents-isup-stack<br>
 *
 * @author <a href="mailto:baranowb@gmail.com">Bartosz Baranowski </a>
 */
package org.mobicents.protocols.ss7.isup.message.parameter;

/**
 * Start time:14:17:18 2009-07-23<br>
 * Project: mobicents-isup-stack<br>
 *
 * @author <a href="mailto:baranowb@gmail.com">Bartosz Baranowski </a>
 */
public interface UIDActionIndicators extends ISUPParameter {

    int _PARAMETER_CODE = 0x74;
    // FIXME: add C defs
    /**
     * See Q.763 3.78 Through-connection instruction indicator : no indication
     */
    boolean _TCII_NO_INDICATION = false;

    /**
     * See Q.763 3.78 Through-connection instruction indicator : through-connect in both directions
     */
    boolean _TCII_TCIBD = true;

    /**
     * See Q.763 3.78 T9 timer instruction indicator : no indication
     */
    boolean _T9_TII_NO_INDICATION = false;

    /**
     * See Q.763 3.78 T9 timer instruction indicator : stop or do not start T9 timer
     */
    boolean _T9_TII_SDNST9T = false;

    byte[] getUdiActionIndicators();

    void setUdiActionIndicators(byte[] udiActionIndicators);

    byte createUIDAction(boolean TCII, boolean T9);

    boolean getT9Indicator(byte b);

    boolean getTCIIndicator(byte b);
}
