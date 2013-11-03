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

package org.mobicents.protocols.ss7.map.api.service.supplementary;

import org.mobicents.protocols.ss7.map.api.datacoding.CBSDataCodingScheme;
import org.mobicents.protocols.ss7.map.api.primitives.AlertingPattern;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.USSDString;

/**
 * MAP V2:
 *
 * processUnstructuredSS-Request OPERATION ::= { --Timer 10 minutes ARGUMENT USSD-Arg RESULT USSD-Res ERRORS { systemFailure |
 * dataMissing | unexpectedDataValue | unknownAlphabet | callBarred} CODE local:59 }
 *
 * USSD-Arg ::= SEQUENCE { ussd-DataCodingScheme USSD-DataCodingScheme, ussd-String USSD-String, ... , alertingPattern
 * AlertingPattern OPTIONAL, msisdn [0] ISDN-AddressString OPTIONAL }
 *
 * This service is used between the MSC and the VLR and between the VLR and the HLR to relay information in order to allow
 * unstructured supplementary service operation.
 *
 *
 * @author amit bhayani
 *
 */
public interface ProcessUnstructuredSSRequest extends SupplementaryMessage {

    /**
     * This parameter contains the information of the alphabet and the language used for the unstructured information in an
     * Unstructured Supplementary Service Data operation. The coding of this parameter is according to the Cell Broadcast Data
     * Coding Scheme as specified in GSM 03.38.
     *
     * @return
     */
    CBSDataCodingScheme getDataCodingScheme();

    /**
     * <p>
     * This parameter contains a string of unstructured information in an Unstructured Supplementary Service Data operation. The
     * string is sent either by the mobile user or the network. The contents of a string sent by the MS are interpreted by the
     * network as specified in GSM 02.90.
     * </p>
     * <br/>
     * <p>
     * USSD String is OCTET STRING (SIZE (1..160))
     * </p>
     *
     * <br/>
     *
     * <p>
     * The structure of the contents of the USSD-String is dependent -- on the USSD-DataCodingScheme as described in TS GSM
     * 03.38.
     * </p>
     *
     *
     *
     * @return
     */
    USSDString getUSSDString();

    ISDNAddressString getMSISDNAddressString();

    AlertingPattern getAlertingPattern();

}