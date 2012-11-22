package org.bm.modules.modulesmanager.frame;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.bm.modules.modulesmanager.listeners.ModuleStateListener;
import org.bm.modules.shared.IModule;
import org.bm.modules.shared.ModuleFrame;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.layout.FormLayout;

public class ModulesManagerModuleFrame extends ModuleFrame {

   private JList<IModule> listModules;

   private JPanel panelDetails;

   private JTextField textFieldModuleName;

   private JTextField textFieldModuleVersion;

   private JButton buttonActivate;

   private JButton buttonDeactivate;

   private ModuleStateListener moduleStateListener;

   public ModulesManagerModuleFrame() {
      this.setSize(800, 600);
      this.setMaximizable(true);
      this.setResizable(true);
      this.setClosable(true);
      this.setIconifiable(true);

   }

   public void initComponents() {
      listModules = new JList<IModule>(componentContainer.getModulesList().toArray(new IModule[] {}));
      listModules.addListSelectionListener(new ListSelectionListener() {

         @Override
         public void valueChanged(ListSelectionEvent e) {
            IModule module = listModules.getSelectedValue();
            displayDetail(module);
         }
      });

      JScrollPane modulesListScrollPane = new JScrollPane(listModules);

      textFieldModuleName = new JTextField();
      textFieldModuleName.setEditable(false);
      textFieldModuleVersion = new JTextField();
      textFieldModuleVersion.setEditable(false);

      buttonActivate = new JButton("Activate");
      buttonDeactivate = new JButton("Deactivate");
      moduleStateListener = new ModuleStateListener(buttonActivate, buttonDeactivate);
      buttonActivate.addActionListener(moduleStateListener);
      buttonDeactivate.addActionListener(moduleStateListener);

      FormLayout layout = new FormLayout("right:pref, 3dlu, max(80dlu;pref), 7dlu, right:max(40dlu;pref), 3dlu, max(80dlu;pref)",
         "");

      DefaultFormBuilder builder = new DefaultFormBuilder(layout);
      builder.border(Borders.DIALOG);

      builder.appendSeparator("Module");
      builder.append("Name", textFieldModuleName);
      builder.append("Version", textFieldModuleVersion);
      builder.nextLine();
      builder.append(buttonActivate, 3);
      builder.append(buttonDeactivate, 3);

      panelDetails = builder.build();

      JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, modulesListScrollPane, panelDetails);

      this.setContentPane(splitPane);

   }

   public void selectFirstElementFromList() {
      if (componentContainer.getModulesList().size() > 0) {
         listModules.setSelectedIndex(0);
      }
   }

   protected void displayDetail(IModule module) {
      textFieldModuleName.setText(module.getName());
      textFieldModuleVersion.setText(module.getVersion());

      moduleStateListener.setModule(module);

      buttonActivate.setEnabled(!module.isActive());
      buttonDeactivate.setEnabled(module.isActive() && module.isDeactivable());

   }
}
