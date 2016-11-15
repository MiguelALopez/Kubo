package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuArchivo extends JMenuBar {
    private MenuVer menuVer;
    public MenuArchivo(MenuVer menuVer)
    {
        this.menuVer = menuVer;
        JMenu fileMenu = new JMenu();
        fileMenu.setText("Archivo");
        JMenuItem itemFirstMenu = new JMenuItem();
        itemFirstMenu.setText("Score");
        itemFirstMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuVer.showScore();
            }
        });
        fileMenu.add(itemFirstMenu);
        add(fileMenu);
    }
}
