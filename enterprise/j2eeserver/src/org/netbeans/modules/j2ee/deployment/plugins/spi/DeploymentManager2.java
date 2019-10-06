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

package org.netbeans.modules.j2ee.deployment.plugins.spi;

import javax.enterprise.deploy.spi.status.ProgressObject;
import javax.enterprise.deploy.spi.DeploymentManager;
import javax.enterprise.deploy.spi.Target;
import javax.enterprise.deploy.spi.TargetModuleID;

/**
 * Deployment manager utilizing DeploymentContext to describe
 * module deployment.
 *
 * @since org.netbeans.modules.j2eeserver/4 1.70
 */
public interface DeploymentManager2 extends DeploymentManager {

    /**
     * Redeploy given module.
     */
    ProgressObject redeploy(TargetModuleID[] tmids, DeploymentContext deployment);

    /**
     * Deploy given module.
     */
    ProgressObject distribute(Target[] targets, DeploymentContext deployment);

}
