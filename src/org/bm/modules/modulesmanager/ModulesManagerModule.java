package org.bm.modules.modulesmanager;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.JPanel;
import javax.swing.KeyStroke;

import org.bm.modules.modulesmanager.frame.ModulesManagerModuleFrame;
import org.bm.modules.shared.IModule;
import org.bm.modules.shared.ModuleFrame;

public class ModulesManagerModule implements IModule {

    ModulesManagerModuleFrame frame = new ModulesManagerModuleFrame();
    private Boolean active = Boolean.TRUE;

    @Override
    public void attach() {
        frame.initComponents();
        frame.selectFirstElementFromList();
    }

    @Override
    public void deattach() {
    }

    @Override
    public int getMenuIndex() {
        return IModule.MENU_WINDOWS;
    }

    @Override
    public int getMenuItemIndex() {
        return 0;
    }

    @Override
    public String getName() {

        return "Modules Manager";
    }

    @Override
    public boolean hasMnemonic() {
        return true;
    }

    @Override
    public int getMnemonic() {
        return KeyEvent.VK_M;
    }

    @Override
    public boolean hasAccelerator() {
        return true;
    }

    @Override
    public KeyStroke getAccelerator() {
        return KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_DOWN_MASK);
    }

    @Override
    public ModuleFrame getModuleFrame() {
        return frame;
    }

    @Override
    public String getVersion() {
        return "0.0.0.1";
    }

    @Override
    public String toString() {
        return getName() + " [" + getVersion() + "]";
    }

    @Override
    public Boolean isActive() {
        return active;
    }

    @Override
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    @Override
    public Boolean isDeactivable() {
        return false;
    }
}
