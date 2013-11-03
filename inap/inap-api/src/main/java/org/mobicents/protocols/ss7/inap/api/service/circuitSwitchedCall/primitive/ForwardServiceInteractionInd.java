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

package org.mobicents.protocols.ss7.inap.api.service.circuitSwitchedCall.primitive;

import java.io.Serializable;

/**
*
ForwardServiceInteractionInd ::= SEQUENCE {
conferenceTreatmentIndicator [1] OCTET STRING (SIZE(1)) OPTIONAL,
-- acceptConferenceRequest 'xxxx xx01'B
-- rejectConferenceRequest 'xxxx xx10'B
-- network default is accept conference request
callDiversionTreatmentIndicator [2] OCTET STRING (SIZE(1)) OPTIONAL,
-- callDiversionAllowed 'xxxx xx01'B
-- callDiversionNotAllowed 'xxxx xx10'B
-- network default is Call Diversion allowed
callOfferingTreatmentIndicator [3] OCTET STRING (SIZE(1)) OPTIONAL,
-- callOfferingNotAllowed 'xxxx xx01'B,
-- callOfferingAllowed 'xxxx xx10'B
-- network default is Call Offering not allowed
callingPartyRestrictionIndicator [4] OCTET STRING (SIZE(1)) OPTIONAL,
-- noINImpact 'xxxx xx01'B,
-- presentationRestricted 'xxxx xx10'B
-- network default is noINImpact
...
}

*
* @author sergey vetyutnev
*
*/
public interface ForwardServiceInteractionInd extends Serializable {

    ConferenceTreatmentIndicator getConferenceTreatmentIndicator();

    CallDiversionTreatmentIndicator getCallDiversionTreatmentIndicator();

    CallOfferingTreatmentIndicator getCallOfferingTreatmentIndicator();

    CallingPartyRestrictionIndicator getCallingPartyRestrictionIndicator();

}
