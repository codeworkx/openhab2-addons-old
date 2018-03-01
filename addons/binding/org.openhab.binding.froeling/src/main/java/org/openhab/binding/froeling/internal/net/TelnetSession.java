/**
 * Copyright (c) 2014 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.froeling.internal.net;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.net.telnet.TelnetClient;

/**
 * A single telnet session.
 *
 * @author Allan Tong - Initial contribution
 */
public class TelnetSession implements Closeable {

    private TelnetClient telnetClient = null;
    private NonblockingBufferedReader nbreader = null;

    public TelnetSession() {
        this.telnetClient = new TelnetClient();
    }

    public void open(String host, int port) throws IOException {
        if (this.telnetClient != null) {
            this.telnetClient.connect(host, port);
            this.telnetClient.setKeepAlive(true);

            this.nbreader = new NonblockingBufferedReader(new BufferedReader(
                    new InputStreamReader(this.telnetClient.getInputStream(), StandardCharsets.ISO_8859_1), 1024));
        }
    }

    @Override
    public void close() throws IOException {
        if (this.telnetClient != null) {
            this.telnetClient.setKeepAlive(false);
            this.telnetClient.disconnect();
        }
    }

    public boolean isConnected() {
        if (this.telnetClient != null) {
            return this.telnetClient.isConnected();
        } else {
            return false;
        }
    }

    public String readline() throws IOException {
        String buffer = "";

        if (this.nbreader != null) {
            buffer = this.nbreader.readLine();
        }
        return buffer;
    }
}
