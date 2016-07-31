/**
 * Copyright (c) 2014 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.froeling.internal.config;

/**
 * @author Daniel Hillenbrand - Initial contribution
 */
public class FroelingConfiguration {
    private String controllerType;
    private String comPort;
    private Integer pollingInterval;

    public String getControllerType() {
        return controllerType;
    }

    public String getComPort() {
        return comPort;
    }

    public Integer getPollingInterval() {
        return pollingInterval;
    }

    public void setControllerType(String controllerType) {
        this.controllerType = controllerType;
    }

    public void setPort(String comPort) {
        this.comPort = comPort;
    }

    public void setPollingInterval(Integer pollingInterval) {
        this.pollingInterval = pollingInterval;
    }
}
