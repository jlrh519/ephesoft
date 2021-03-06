/********************************************************************************* 
* Ephesoft is a Intelligent Document Capture and Mailroom Automation program 
* developed by Ephesoft, Inc. Copyright (C) 2015 Ephesoft Inc. 
* 
* This program is free software; you can redistribute it and/or modify it under 
* the terms of the GNU Affero General Public License version 3 as published by the 
* Free Software Foundation with the addition of the following permission added 
* to Section 15 as permitted in Section 7(a): FOR ANY PART OF THE COVERED WORK 
* IN WHICH THE COPYRIGHT IS OWNED BY EPHESOFT, EPHESOFT DISCLAIMS THE WARRANTY 
* OF NON INFRINGEMENT OF THIRD PARTY RIGHTS. 
* 
* This program is distributed in the hope that it will be useful, but WITHOUT 
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
* FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more 
* details. 
* 
* You should have received a copy of the GNU Affero General Public License along with 
* this program; if not, see http://www.gnu.org/licenses or write to the Free 
* Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 
* 02110-1301 USA. 
* 
* You can contact Ephesoft, Inc. headquarters at 111 Academy Way, 
* Irvine, CA 92617, USA. or at email address info@ephesoft.com. 
* 
* The interactive user interfaces in modified source and object code versions 
* of this program must display Appropriate Legal Notices, as required under 
* Section 5 of the GNU Affero General Public License version 3. 
* 
* In accordance with Section 7(b) of the GNU Affero General Public License version 3, 
* these Appropriate Legal Notices must retain the display of the "Ephesoft" logo. 
* If the display of the logo is not reasonably feasible for 
* technical reasons, the Appropriate Legal Notices must display the words 
* "Powered by Ephesoft". 
********************************************************************************/ 

package com.ephesoft.dcma.da.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ephesoft.dcma.core.common.ServiceType;
import com.ephesoft.dcma.core.model.common.AbstractChangeableEntity;

/**
 * The <code>ServiceStatus</code> is a POJO that defines an entity for server_status table in Ephesoft DB. This domain object is used
 * for by fail-over mechanism to communicate and synchronise operation between servers.
 * 
 * @author Ephesoft
 * @version 1.0
 * @see AbstractChangeableEntity
 * 
 */
@Entity
@Table(name = "service_status")
public class ServiceStatus extends AbstractChangeableEntity implements Serializable {

	/**
	 * Serial Version ID.
	 */
	private static final long serialVersionUID = -3017024544649529446L;

	/**
	 * The serverRegistry {@link ServerRegistry} defines the parent entity on which it is dependent on.
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "server_registry_id")
	private ServerRegistry serverRegistry;

	/**
	 * The serviceType {@link ServiceType} defines the service type which needs to be handled for fail-over scenarios.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "service_type")
	private ServiceType serviceType;

	/**
	 * @param serverRegistry the serverRegistry to set
	 */
	public void setServerRegistry(ServerRegistry serverRegistry) {
		this.serverRegistry = serverRegistry;
	}

	/**
	 * @return the serverRegistry
	 */
	public ServerRegistry getServerRegistry() {
		return serverRegistry;
	}

	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * @return the serviceType
	 */
	public ServiceType getServiceType() {
		return serviceType;
	}

}
