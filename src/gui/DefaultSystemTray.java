package gui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

//FAIRE JAVADOC
public class DefaultSystemTray {
    private PopupMenu _trayMenu;
    private ArrayList<MenuItem> _menuList;

    public DefaultSystemTray() {
        if(SystemTray.isSupported()) {
            _trayMenu = new PopupMenu();
            _menuList = new ArrayList<>();
        }
        else
            throw new RuntimeException("SystemTray: SystemTray is not supported");
    }

    public DefaultSystemTray(Image icone, String caption) {
        if(SystemTray.isSupported()) {
            _trayMenu = new PopupMenu();
            _menuList = new ArrayList<>();
            TrayIcon trayIcon = new TrayIcon(icone, caption, _trayMenu);
            trayIcon.setImageAutoSize(true);
            SystemTray tray = SystemTray.getSystemTray();
            try {
                tray.add(trayIcon);
            }
            catch(AWTException ex) {
                ex.printStackTrace();
                throw new RuntimeException("SystemTray: " + ex);
            }
        }
        else
            throw new RuntimeException("SystemTray: SystemTray is not supported");
    }

    public void create(Image icone, String caption) {
        TrayIcon trayIcon = new TrayIcon(icone, caption, _trayMenu);
        trayIcon.setImageAutoSize(true);
        SystemTray tray = SystemTray.getSystemTray();
        try {
            tray.add(trayIcon);
        }
        catch(AWTException ex) {
            ex.printStackTrace();
            throw new RuntimeException("SystemTray: " + ex);
        }
    }

    public void add(String name, ActionListener action) {
        MenuItem optionTrayMenu = new MenuItem(name);
        optionTrayMenu.addActionListener(action);
        _trayMenu.add(optionTrayMenu);
        _menuList.add(optionTrayMenu);
    }

    public void delete(String name) {
        _menuList.stream().filter(item -> Objects.equals(item.getLabel(), name)).forEach(item -> _trayMenu.remove(item));
    }
}
