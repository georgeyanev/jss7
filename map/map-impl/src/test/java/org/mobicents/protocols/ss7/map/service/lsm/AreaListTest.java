/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and/or its affiliates, and individual
 * contributors as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a full listing
 * of individual contributors.
 * 
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU General Public License, v. 2.0.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License,
 * v. 2.0 along with this distribution; if not, write to the Free 
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */
package org.mobicents.protocols.ss7.map.service.lsm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mobicents.protocols.ss7.map.MapServiceFactoryImpl;
import org.mobicents.protocols.ss7.map.api.MapServiceFactory;
import org.mobicents.protocols.ss7.map.api.service.lsm.Area;
import org.mobicents.protocols.ss7.map.api.service.lsm.AreaList;
import org.mobicents.protocols.ss7.map.api.service.lsm.AreaType;
import org.mobicents.protocols.ss7.tcap.asn.TcapFactory;
import org.mobicents.protocols.ss7.tcap.asn.comp.Parameter;

/**
 * @author amit bhayani
 * 
 */
public class AreaListTest {
	MapServiceFactory mapServiceFactory = new MapServiceFactoryImpl();

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testDecode() throws Exception {
		//TODO this is self generated trace. We need trace from operator
		byte[] data = new byte[] { 0x30, 0x08, (byte) 0x80, 0x01, 0x05, (byte) 0x81, 0x03, 0x09, 0x70, 0x71, 0x30, 0x08, (byte) 0x80, 0x01, 0x03, (byte) 0x81,
				0x03, 0x04, 0x30, 0x31 };

		Parameter p = TcapFactory.createParameter();
		p.setPrimitive(false);
		p.setData(data);

		AreaList areaList = new AreaListImpl();
		areaList.decode(p);

		Area areas[] = areaList.getAreas();
		
		assertNotNull(areas);
		assertEquals(2, areas.length);

		assertNotNull(areas[0].getAreaIdentification());
		assertTrue(Arrays.equals(new byte[] { 0x09, 0x70, 0x71 }, areas[0].getAreaIdentification()));

	}

	@Test
	public void testEncode() throws Exception {
		//TODO this is self generated trace. We need trace from operator
		byte[] data = new byte[] { 0x30, 0x08, (byte) 0x80, 0x01, 0x05, (byte) 0x81, 0x03, 0x09, 0x70, 0x71, 0x30, 0x08, (byte) 0x80, 0x01, 0x03, (byte) 0x81,
				0x03, 0x04, 0x30, 0x31 };

		Area area1 = new AreaImpl(AreaType.utranCellId, new byte[] { 0x09, 0x70, 0x71 });
		Area area2 = new AreaImpl(AreaType.routingAreaId, new byte[] { 0x04, 0x30, 0x31 });

		AreaList areaList = new AreaListImpl(new Area[] { area1, area2 });

		Parameter param = areaList.encode();
		assertNotNull(param);
		assertTrue(param.isPrimitive());

		assertTrue(Arrays.equals(data, param.getData()));

	}
}