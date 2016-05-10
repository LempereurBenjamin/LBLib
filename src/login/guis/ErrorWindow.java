package login.guis;
import java.awt.*;
import java.awt.event.*;

class ErrorWindow extends Dialog implements ActionListener, WindowListener {
    ErrorWindow(Frame parent, String msg) {
        super(parent, "Error !", true);
        setLayout(new FlowLayout());
        setResizable(false);
        setSize(200, 100);
        setLocationRelativeTo(null);

        add(new Label(msg));
        Button _ok = new Button("Ok");
        _ok.addActionListener(this);
        add(_ok);

        addWindowListener(this);

        KeyListener enterListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE ||e.getKeyCode() == KeyEvent.VK_SPACE) {
                    dispose();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        };

        _ok.addKeyListener(enterListener);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { this.dispose();}

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}
