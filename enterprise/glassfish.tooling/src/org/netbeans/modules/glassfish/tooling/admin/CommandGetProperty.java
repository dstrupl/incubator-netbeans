/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.glassfish.tooling.admin;

import java.util.concurrent.*;
import org.netbeans.modules.glassfish.tooling.GlassFishIdeException;
import org.netbeans.modules.glassfish.tooling.data.GlassFishServer;
import org.netbeans.modules.glassfish.tooling.logging.Logger;

/**
 * Command that retrieves property (properties) from server.
 * <p/>
 * @author Tomas Kraus, Peter Benedikovic
 */
@RunnerHttpClass(runner=RunnerHttpGetProperty.class)
@RunnerRestClass(runner=RunnerRestGetProperty.class)
public class CommandGetProperty extends Command {

    ////////////////////////////////////////////////////////////////////////////
    // Class attributes                                                       //
    ////////////////////////////////////////////////////////////////////////////

    /** Logger instance for this class. */
    private static final Logger LOGGER = new Logger(CommandGetProperty.class);

    /** Command string for create-cluster command. */
    private static final String COMMAND = "get";
    
    ////////////////////////////////////////////////////////////////////////////
    // Instance attributes                                                    //
    ////////////////////////////////////////////////////////////////////////////
    
    /** Pattern that defines properties to retrieve. */
    String propertyPattern;
    

    ////////////////////////////////////////////////////////////////////////////
    // Static methods                                                         //
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Retrieve properties from server.
     * <p/>
     * @param server          GlassFish server entity.
     * @param propertyPattern Pattern that defines properties to retrieve.
     * @return GlassFish command result containing map with key-value pairs
     *         returned by server.
     * @throws GlassFishIdeException When error occurred during administration
     *         command execution.
     */
    public static ResultMap<String, String> getProperties(
            final GlassFishServer server, final String propertyPattern)
            throws GlassFishIdeException {
        final String METHOD = "getProperties";
        Future<ResultMap<String, String>> future =
                ServerAdmin.<ResultMap<String, String>>exec(
                server, new CommandGetProperty(propertyPattern));
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException
                | CancellationException ee) {
            throw new GlassFishIdeException(
                    LOGGER.excMsg(METHOD, "exception", propertyPattern), ee);
        }
    }
    
    /**
     * Retrieve properties from server with timeout.
     * <p/>
     * @param server          GlassFish server entity.
     * @param propertyPattern Pattern that defines properties to retrieve.
     * @param timeout         Administration command execution timeout [ms].
     * @return GlassFish command result containing map with key-value pairs
     *         returned by server.
     * @throws GlassFishIdeException When error occurred during administration
     *         command execution.
     */
    public static ResultMap<String, String> getProperties(
            final GlassFishServer server, final String propertyPattern,
            final long timeout)
            throws GlassFishIdeException {
        final String METHOD = "getProperties";
        Future<ResultMap<String, String>> future =
                ServerAdmin.<ResultMap<String, String>>exec(
                server, new CommandGetProperty(propertyPattern));
        try {
            return future.get(timeout, TimeUnit.MILLISECONDS);
        } catch (ExecutionException | InterruptedException
                | CancellationException ee) {
            throw new GlassFishIdeException(
                    LOGGER.excMsg(METHOD, "exception", propertyPattern), ee);
        } catch (TimeoutException te) {
            throw new GlassFishIdeException(
                    LOGGER.excMsg(METHOD, "exceptionWithTimeout",
                    propertyPattern, Long.toString(timeout)), te);
        }

    }

    ////////////////////////////////////////////////////////////////////////////
    // Constructors                                                           //
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Constructs an instance of GlassFish server get property command entity.
     * <p/>
     * @param property Pattern that defines property tor retrieve.
     */
    public CommandGetProperty(final String property) {
        super(COMMAND);
        propertyPattern = property;
    }
}
