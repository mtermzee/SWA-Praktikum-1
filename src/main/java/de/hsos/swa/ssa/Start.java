/* 
 * Authors: Termzee & Borko
 * Created: 2022.10.16
 * Name: Simple Shop Application
*/
package de.hsos.swa.ssa;

import de.hsos.swa.ssa.ui.controller.MenueControl;

public class Start {
    public static void main(String[] args) {
        MenueControl menueControl = new MenueControl();
        menueControl.handleMenueView();
    }
}