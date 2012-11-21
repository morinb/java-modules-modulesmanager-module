package org.bm.modules.modulesmanager.frame;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.bm.modules.shared.ModuleFrame;

public class ModulesManagerModuleFrame extends ModuleFrame {

   private JList listModules;

   private JPanel panelDetails;

   public ModulesManagerModuleFrame() {
      this.setSize(800, 600);
      this.setMaximizable(true);
      this.setClosable(true);
      this.setIconifiable(true);

   }

   public void initComponents() {
      listModules = new JList(componentContainer.getModulesList().toArray());
      JScrollPane modulesListScrollPane = new JScrollPane(listModules);

      panelDetails = new JPanel();

      JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, modulesListScrollPane, panelDetails);

      this.setContentPane(splitPane);
   }
}
