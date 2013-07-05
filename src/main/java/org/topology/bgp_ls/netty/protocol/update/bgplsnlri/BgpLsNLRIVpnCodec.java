/**
 *  Copyright 2013 Nitin Bahadur (nitinb@gmail.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * 
 */
package org.topology.bgp_ls.netty.protocol.update.bgplsnlri;

import org.topology.bgp_ls.net.SubsequentAddressFamily;
import org.topology.bgp_ls.net.attributes.MultiProtocolNLRIInformation;
import org.topology.bgp_ls.net.attributes.bgplsnlri.BgpLsNLRIInformation;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author nitinb
 *
 */
public class BgpLsNLRIVpnCodec extends BgpLsNLRICodec {

	private static final Logger log = LoggerFactory.getLogger(BgpLsNLRIVpnCodec.class);

	/**
	 * 
	 */
	public BgpLsNLRIVpnCodec() {
	}

	public MultiProtocolNLRIInformation decodeNLRI(ChannelBuffer buffer) {
		
		BgpLsNLRIInformation nlriInfo;
		
		int type = buffer.readUnsignedShort();
		int length = buffer.readUnsignedShort();
	
		// not enough bytes in the buffer to read the NLRI
		if (buffer.readableBytes() < length) {
			log.error("Failed to decode BGP-LS NLRI type " + type + " due to completely read NLRI");
			return null;
		}
	
		// get the route distinguisher
		byte[] routeDistinguisher = new byte[8];
		buffer.readBytes(routeDistinguisher);
		
		ChannelBuffer valueBuffer = ChannelBuffers.buffer(length - 8);
		buffer.readBytes(valueBuffer);
	
		nlriInfo = decodeNLRIInternal(valueBuffer, SubsequentAddressFamily.NLRI_MPLS_VPN, type);
		if (nlriInfo != null) {
			nlriInfo.setRouteDistinguisher(routeDistinguisher);
		}
		
		return nlriInfo;
	}
}