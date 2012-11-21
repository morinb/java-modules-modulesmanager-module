package org.bm.modules.modulesmanager.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.bm.modules.shared.IModule;

public class ModuleStateListener implements ActionListener {

    private IModule module;
    private JButton buttonActivate;
    private JButton buttonDeactivate;

    public ModuleStateListener(JButton buttonActivate, JButton buttonDeactivate) {
        this.buttonActivate = buttonActivate;
        this.buttonDeactivate = buttonDeactivate;
    }

    public void setModule(IModule module) {
        this.module = module;
    }

    public IModule getModule() {
        return module;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (module.isActive()) {
            module.deattach();
            module.setActive(false);

        } else {
            module.attach();
            module.setActive(true);
        }
        buttonActivate.setEnabled(!module.isActive());
        buttonDeactivate.setEnabled(module.isActive() && module.isDeactivable());

        module.getModuleFrame().getComponentContainer().getWindowManager().refreshDisplay();
    }

}
