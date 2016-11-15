package Interfaz;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuArchivo extends JMenuBar{
    public MenuArchivo()
    {
        JMenu fileMenu = new JMenu();
        fileMenu.setText("Archivo");
        JMenuItem itemFirstMenu = new JMenuItem();
        itemFirstMenu.setText("Score");
        fileMenu.add(itemFirstMenu);
        add(fileMenu);
    }
}
