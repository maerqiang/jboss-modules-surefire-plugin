package org.apache.maven.surefire.booter.output;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.surefire.report.ReportEntry;

/**
 * Surefire output consumer that will delegate to another {@link OutputConsumer}
 *
 * @author <a href="mailto:carlos@apache.org">Carlos Sanchez</a>
 * @version $Id: OutputConsumerProxy.java 510866 2007-02-23 08:13:49Z brett $
 * @since 2.1
 */
public class OutputConsumerProxy
    implements OutputConsumer
{

    private OutputConsumer outputConsumer;

    /**
     * Create a output consumer that will delegate all calls to the proxied output consumer
     *
     * @param outputConsumer output consumer to delegate to
     */
    public OutputConsumerProxy( OutputConsumer outputConsumer )
    {
        this.setOutputConsumer( outputConsumer );
    }

    /**
     * {@link OutputConsumer} that calls will be delegated to
     *
     * @param outputConsumer the proxied {@link OutputConsumer}
     */
    public void setOutputConsumer( OutputConsumer outputConsumer )
    {
        this.outputConsumer = outputConsumer;
    }

    /**
     * {@link OutputConsumer} that calls will be delegated to
     *
     * @return the proxied {@link OutputConsumer}
     */
    public OutputConsumer getOutputConsumer()
    {
        return outputConsumer;
    }

    /**
     * Delegate to proxied {@link OutputConsumer}
     */
    public void consumeHeaderLine( String line )
    {
        getOutputConsumer().consumeHeaderLine( line );
    }

    /**
     * Delegate to proxied {@link OutputConsumer}
     */
    public void consumeMessageLine( String line )
    {
        getOutputConsumer().consumeMessageLine( line );
    }

    /**
     * Delegate to proxied {@link OutputConsumer}
     */
    public void consumeFooterLine( String line )
    {
        getOutputConsumer().consumeFooterLine( line );
    }

    /**
     * Delegate to proxied {@link OutputConsumer}
     */
    public void consumeOutputLine( String line )
    {
        getOutputConsumer().consumeOutputLine( line );
    }

    /**
     * Delegate to proxied {@link OutputConsumer}
     */
    public void testSetStarting( ReportEntry reportEntry )
    {
        getOutputConsumer().testSetStarting( reportEntry );
    }

    /**
     * Delegate to proxied {@link OutputConsumer}
     */
    public void testSetCompleted()
    {
        getOutputConsumer().testSetCompleted();
    }

}
