/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.froeling.internal;

import static org.openhab.binding.froeling.froelingBindingConstants.*;

import java.util.Set;

import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.openhab.binding.froeling.handler.IPBridgeHandler;
import org.openhab.binding.froeling.handler.froelingHandler;

import com.google.common.collect.ImmutableSet;

/**
 * The {@link froelingHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Daniel Hillenbrand - Initial contribution
 */
public class froelingHandlerFactory extends BaseThingHandlerFactory {

    public final static Set<ThingTypeUID> SUPPORTED_BRIDGE_THING_TYPES_UIDS = ImmutableSet.of(THING_TYPE_IPBRIDGE);
    public final static Set<ThingTypeUID> SUPPORTED_DEVICE_THING_TYPES_UIDS = ImmutableSet.of(THING_TYPE_CONTROLLER);

    private final static Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = ImmutableSet.of(THING_TYPE_IPBRIDGE,
            THING_TYPE_CONTROLLER);

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {

        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (thingTypeUID.equals(THING_TYPE_IPBRIDGE)) {
            return new IPBridgeHandler((Bridge) thing);
        } else if (thingTypeUID.equals(THING_TYPE_CONTROLLER)) {
            return new froelingHandler(thing);
        }

        return null;
    }
}
