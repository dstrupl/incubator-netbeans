// <editor-fold defaultstate="collapsed" desc=" License Header ">
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
//</editor-fold>

package org.netbeans.modules.payara.common.ui;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import org.openide.util.NbBundle;

public class JdbcResourceCustomizer extends BasePanel {

    /** Creates new form JdbcResourceCustomizer */
    public JdbcResourceCustomizer() {
        initComponents();
        String val = NbBundle.getMessage(JdbcResourceCustomizer.class, "MSG_FETCHING_DATA");
        poolNameCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { val }));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        poolNameLabel = new javax.swing.JLabel();
        resourceEnabledCB = new javax.swing.JCheckBox();
        poolNameCombo = new javax.swing.JComboBox();

        poolNameLabel.setLabelFor(poolNameCombo);
        org.openide.awt.Mnemonics.setLocalizedText(poolNameLabel, org.openide.util.NbBundle.getMessage(JdbcResourceCustomizer.class, "JdbcResourceCustomizer.poolNameLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(resourceEnabledCB, org.openide.util.NbBundle.getMessage(JdbcResourceCustomizer.class, "JdbcResourceCustomizer.enabled.text")); // NOI18N
        resourceEnabledCB.setName("enabled"); // NOI18N

        poolNameCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "fetching data...." }));
        poolNameCombo.setActionCommand("resources\\.jdbc-connection-pool\\..*\\.name"); // NOI18N
        poolNameCombo.setName("pool-name"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resourceEnabledCB)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(poolNameLabel)
                        .addGap(2, 2, 2)
                        .addComponent(poolNameCombo, 0, 260, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poolNameLabel)
                    .addComponent(poolNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resourceEnabledCB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox poolNameCombo;
    private javax.swing.JLabel poolNameLabel;
    private javax.swing.JCheckBox resourceEnabledCB;
    // End of variables declaration//GEN-END:variables

    protected String getPrefix() {
        return "resources.jdbc-resource."; // NOI18N
    }

    protected List<Component> getDataComponents() {
        return Arrays.asList(new Component[] {poolNameCombo,resourceEnabledCB});
    }

}
