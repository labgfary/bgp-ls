/**
 *  Copyright 2012 Rainer Bieniek (Rainer.Bieniek@web.de)
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
 * File: org.topology.bgp_ls.netty.protocol.update.MultiExitDiscPathAttributeCodecHandler.java 
 */
package org.topology.bgp_ls.netty.protocol.update;

import org.topology.bgp_ls.net.attributes.MultiExitDiscPathAttribute;
import org.topology.bgp_ls.netty.BGPv4Constants;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

/**
 * @author Rainer Bieniek (Rainer.Bieniek@web.de)
 *
 */
public class MultiExitDiscPathAttributeCodecHandler extends
		PathAttributeCodecHandler<MultiExitDiscPathAttribute> {

	/* (non-Javadoc)
	 * @see org.topology.bgp_ls.netty.protocol.update.PathAttributeCodecHandler#typeCode(org.topology.bgp_ls.netty.protocol.update.PathAttribute)
	 */
	@Override
	public int typeCode(MultiExitDiscPathAttribute attr) {
		return BGPv4Constants.BGP_PATH_ATTRIBUTE_TYPE_MULTI_EXIT_DISC;
	}

	/* (non-Javadoc)
	 * @see org.topology.bgp_ls.netty.protocol.update.PathAttributeCodecHandler#valueLength(org.topology.bgp_ls.netty.protocol.update.PathAttribute)
	 */
	@Override
	public int valueLength(MultiExitDiscPathAttribute attr) {
		return 4;
	}

	/* (non-Javadoc)
	 * @see org.topology.bgp_ls.netty.protocol.update.PathAttributeCodecHandler#encodeValue(org.topology.bgp_ls.netty.protocol.update.PathAttribute)
	 */
	@Override
	public ChannelBuffer encodeValue(MultiExitDiscPathAttribute attr) {
		ChannelBuffer buffer = ChannelBuffers.buffer(4);
		
		buffer.writeInt(attr.getDiscriminator());
		
		return buffer;
	}

}
