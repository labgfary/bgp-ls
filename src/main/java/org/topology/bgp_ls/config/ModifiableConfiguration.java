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
 * File: org.bgp4.config.ModifiableConfiguration.java 
 */
package org.topology.bgp_ls.config;

import org.topology.bgp_ls.config.nodes.ServerConfiguration;
import org.topology.bgp_ls.config.nodes.RoutingProcessorConfiguration;

/**
 * Interface implemented by configuration obejct which support modifications of its contents
 * 
 * @author Rainer Bieniek (Rainer.Bieniek@web.de)
 *
 */
public interface ModifiableConfiguration extends Configuration {
	/**
	 * 
	 * 
	 * @param serverConfiguration
	 */
	public void setBgpServerConfiguration(ServerConfiguration serverConfiguration);

	/**
	 * 
	 * 
	 * @param serverConfiguration
	 */
	public void setHttpServerConfiguration(ServerConfiguration serverConfiguration);
	
	/**
	 * 
	 * @param routingProcessorConfiguration
	 */
	public void setRoutingProcessorConfiguration(RoutingProcessorConfiguration routingProcessorConfiguration);
}
