package login.guis;
import login.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.Objects;

public class DialLogin extends Dialog implements  ActionListener, WindowListener{
    private final TextField _password;
    private final TextField _username;
    private Hashtable tp = new Hashtable<>();

    public DialLogin(Frame parent, Hashtable logins) {
        super(parent, "Hospital - Login", true);
        Panel user = new Panel();
        user.setLayout(new FlowLayout());
        Panel pass = new Panel();
        pass.setLayout(new FlowLayout());
        Panel buttons = new Panel();
        buttons.setLayout(new FlowLayout());

        setPreferredSize(new Dimension(450, 143));
        setLayout(new GridLayout(3, 1));
        setResizable(false);
        setLocationRelativeTo(null);

        user.add(new Label("Username :"));
        _username = new TextField("", 20);
        user.add(_username);

        pass.add(new Label("Password :"));
        _password = new TextField("", 20);
        _password.setEchoChar('*');
        pass.add(_password);

        Button _ok = new Button("Enter");
        _ok.addActionListener(this);
        buttons.add(_ok);
        Button _cancel = new Button("Cancel");
        _cancel.addActionListener(this);
        buttons.add(_cancel);

        tp = logins;

        add(user);
        add(pass);
        add(buttons);
        addWindowListener(this);

        KeyListener enterListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        new VerifyPasswordClassicHashSecure(tp, _username.getText(), _password.getText());
                        dispose();
                    } catch (InvalidLoginPasswordException | UnknownLoginPasswordException | PasswordNotFoundException e1) {
                        e1.printStackTrace();
                        new ErrorWindow((Frame)getParent(), e1.getMessage());
                    }
                }
                else {
                    if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        System.exit(0);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        };

        //Evenement (Lambda) permettant de sélectionner le contenu d'un textfield lorsque l'on clique dessus (version globale a tous les textfield)
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("permanentFocusOwner", evt -> {
            if(evt.getNewValue() instanceof TextField) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    TextField textField = (TextField) evt.getNewValue();
                    textField.selectAll();
                });
            }
        });

        _password.addKeyListener(enterListener);
        _username.addKeyListener(enterListener);

        pack();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2, (Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(e.getActionCommand(), "Enter")) {
            try {
                new VerifyPasswordClassicHashSecure(tp, _username.getText(), _password.getText());
                dispose();
            } catch (InvalidLoginPasswordException | UnknownLoginPasswordException | PasswordNotFoundException e1) {
                //e1.printStackTrace();
                new ErrorWindow((Frame)this.getParent(), e1.getMessage());
            }
        }
        else {
            if(Objects.equals(e.getActionCommand(), "Cancel")) {
                System.exit(0);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) { System.exit(0);}

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
