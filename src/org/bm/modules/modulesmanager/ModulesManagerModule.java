package org.bm.modules.modulesmanager;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import org.bm.modules.modulesmanager.frame.ModulesManagerModuleFrame;
import org.bm.modules.shared.IModule;
import org.bm.modules.shared.ModuleFrame;

public class ModulesManagerModule implements IModule {

   ModulesManagerModuleFrame frame = new ModulesManagerModuleFrame();

   @Override
   public void attach() {
      frame.initComponents();
   }

   @Override
   public void deattach() {}

   @Override
   public int getMenuIndex() {
      // TODO Auto-generated method stub
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
      // TODO Auto-generated method stub
      return KeyEvent.VK_M;
   }

   @Override
   public boolean hasAccelerator() {
      // TODO Auto-generated method stub
      return true;
   }

   @Override
   public KeyStroke getAccelerator() {
      // TODO Auto-generated method stub
      return KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_DOWN_MASK);
   }

   @Override
   public ModuleFrame getModuleFrame() {
      return frame;
   }

}
