package gui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * <b>LogFileBean is a class used to manage a System Tray.</b>
 *
 * @author Lempereur
 *
 *
 * @version 1.0
 */
public class DefaultSystemTray {
    /**
     * The menu of the System Tray.
     *
     * @see DefaultSystemTray#DefaultSystemTray()
     * @see DefaultSystemTray#DefaultSystemTray(Image, String)
     */
    private PopupMenu _trayMenu;

    /**
     * The list of the items in the menu.
     *
     * @see DefaultSystemTray#DefaultSystemTray()
     * @see DefaultSystemTray#DefaultSystemTray(Image, String)
     */
    private ArrayList<MenuItem> _menuList;

    /**
     * DefaultSystemTray default Constructor.
     * <p>
     *     Instantiation of the menu and the list of items.
     * </p>
     */
    public DefaultSystemTray() {
        if(SystemTray.isSupported()) {
            _trayMenu = new PopupMenu();
            _menuList = new ArrayList<>();
        }
        else
            throw new RuntimeException("SystemTray: SystemTray is not supported");
    }

    /**
     * DefaultSystemTray Constructor.
     * <p>
     *     Instantiation of the menu and the list of items and adding the new tray to the System Tray.
     * </p>
     *
     * @param icone
     *          Icon of the Tray.
     * @param caption
     *          Text of the Tray.
     */
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

    /**
     * Method to create the Tray.
     * <p>
     *     Use to add the new tray to the System Tray after using the default constructor.
     * </p>
     *
     * @param icone
     *          Icon of the Tray.
     * @param caption
     *          Text of the Tray.
     */
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

    /**
     * Method to add an option to the tray.
     * <p>
     *     Use to add an ption to the tray.
     * </p>
     *
     * @param name
     *          Name of the option.
     * @param action
     *          Action of the option.
     */
    public void add(String name, ActionListener action) {
        for (MenuItem item:_menuList) {
            if(Objects.equals(name, item.getLabel())) {
                throw new RuntimeException("SystemTray: Option already added");
            }
        }
        MenuItem optionTrayMenu = new MenuItem(name);
        optionTrayMenu.addActionListener(action);
        _trayMenu.add(optionTrayMenu);
        _menuList.add(optionTrayMenu);
    }

    /**
     * Method to remove an option of the tray.
     * <p>
     *     Use to remove an option of the tray.
     * </p>
     *
     * @param name
     *          Name of the option.
     */
    public void remove(String name) {
        _menuList.stream().filter(item -> Objects.equals(item.getLabel(), name)).forEach(item -> _trayMenu.remove(item));
    }
}
