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
 * File: org.topology.bgp_ls.netty.protocol.update.ClusterListPathAttributeCodecHandler.java 
 */
package org.topology.bgp_ls.netty.protocol.update;

import org.topology.bgp_ls.net.attributes.ClusterListPathAttribute;
import org.topology.bgp_ls.netty.BGPv4Constants;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

/**
 * @author Rainer Bieniek (Rainer.Bieniek@web.de)
 *
 */
public class ClusterListPathAttributeCodecHandler extends
		PathAttributeCodecHandler<ClusterListPathAttribute> {

	/* (non-Javadoc)
	 * @see org.topology.bgp_ls.netty.protocol.update.PathAttributeCodecHandler#typeCode(org.topology.bgp_ls.netty.protocol.update.PathAttribute)
	 */
	@Override
	public int typeCode(ClusterListPathAttribute attr) {
		return BGPv4Constants.BGP_PATH_ATTRIBUTE_TYPE_CLUSTER_LIST;
	}

	/* (non-Javadoc)
	 * @see org.topology.bgp_ls.netty.protocol.update.PathAttributeCodecHandler#valueLength(org.topology.bgp_ls.netty.protocol.update.PathAttribute)
	 */
	@Override
	public int valueLength(ClusterListPathAttribute attr) {
		int size = 0;
		
		if(attr.getClusterIds() != null)
			size += attr.getClusterIds().size() * 4;
		
		return size;
	}

	/* (non-Javadoc)
	 * @see org.topology.bgp_ls.netty.protocol.update.PathAttributeCodecHandler#encodeValue(org.topology.bgp_ls.netty.protocol.update.PathAttribute)
	 */
	@Override
	public ChannelBuffer encodeValue(ClusterListPathAttribute attr) {
		ChannelBuffer buffer = ChannelBuffers.buffer(valueLength(attr));
		
		for(int clusterId : attr.getClusterIds())
			buffer.writeInt(clusterId);
		
		return buffer;
	}

}
