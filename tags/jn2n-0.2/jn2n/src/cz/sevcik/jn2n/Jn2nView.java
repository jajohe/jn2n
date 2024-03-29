package cz.sevcik.jn2n;

import java.awt.Color;
import java.net.UnknownHostException;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * The application's main frame.
 *
 * @author Jaroslav Sevcik
 *
 * @version $Rev$
 */
public class Jn2nView extends FrameView {

    private Connector connector;
    private ResourceMap resMap = Jn2nApp.getInstance().getContext().getResourceMap(Jn2nView.class);

    public Jn2nView(SingleFrameApplication app) {
        super(app);
        initComponents();
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);
        // </editor-fold>
        initTaskMonitor();
        disconnectButton.setEnabled(false);
    }

    /**
     * Show connection status
     * @param connected
     */
    public void showConnectionStatus(boolean connected) {
        disconnectButton.setEnabled(connected);
        connectButton.setEnabled(!connected);

        edgeNodeTextField.setEditable(!connected);
        communityTextField.setEditable(!connected);
        encryptionKeyTextField.setEditable(!connected);
        superNodeTextField.setEditable(!connected);
        
        if (connected) {
            showMessage(resMap.getString("message.success.connected"), MessageType.SUCCESS);
        } else {
            showMessage(resMap.getString("message.success.disconnected"), MessageType.SUCCESS);
        }
    }

    /**
     * Show status message
     * @param message
     * @param type 
     */
    public void showMessage(String message, MessageType type) {
        switch (type) {
            case SUCCESS:
                Color green = new Color(0, 150, 0);
                statusMessageLabel.setForeground(green);
                break;
            case ERROR:
                statusMessageLabel.setForeground(Color.RED);
                break;
            case INFO:
                statusMessageLabel.setForeground(Color.DARK_GRAY);
                break;
        }
        statusMessageLabel.setText(message);
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = Jn2nApp.getApplication().getMainFrame();
            aboutBox = new Jn2nAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        Jn2nApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        edgeNodeLabel = new javax.swing.JLabel();
        communityLabel = new javax.swing.JLabel();
        encryptionKeyLabel = new javax.swing.JLabel();
        superNodeLabel = new javax.swing.JLabel();
        edgeNodeTextField = new javax.swing.JTextField();
        communityTextField = new javax.swing.JTextField();
        encryptionKeyTextField = new javax.swing.JTextField();
        superNodeTextField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N

        edgeNodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cz.sevcik.jn2n.Jn2nApp.class).getContext().getResourceMap(Jn2nView.class);
        edgeNodeLabel.setText(resourceMap.getString("edgeNodeLabel.text")); // NOI18N
        edgeNodeLabel.setToolTipText(resourceMap.getString("edgeNodeLabel.toolTipText")); // NOI18N
        edgeNodeLabel.setName("edgeNodeLabel"); // NOI18N

        communityLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        communityLabel.setText(resourceMap.getString("communityLabel.text")); // NOI18N
        communityLabel.setToolTipText(resourceMap.getString("communityLabel.toolTipText")); // NOI18N
        communityLabel.setName("communityLabel"); // NOI18N

        encryptionKeyLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        encryptionKeyLabel.setText(resourceMap.getString("encryptionKeyLabel.text")); // NOI18N
        encryptionKeyLabel.setToolTipText(resourceMap.getString("encryptionKeyLabel.toolTipText")); // NOI18N
        encryptionKeyLabel.setName("encryptionKeyLabel"); // NOI18N

        superNodeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        superNodeLabel.setText(resourceMap.getString("superNodeLabel.text")); // NOI18N
        superNodeLabel.setToolTipText(resourceMap.getString("superNodeLabel.toolTipText")); // NOI18N
        superNodeLabel.setName("superNodeLabel"); // NOI18N

        edgeNodeTextField.setText(resourceMap.getString("edgeNodeTextField.text")); // NOI18N
        edgeNodeTextField.setToolTipText(resourceMap.getString("edgeNodeTextField.toolTipText")); // NOI18N
        edgeNodeTextField.setName("edgeNodeTextField"); // NOI18N

        communityTextField.setText(resourceMap.getString("communityTextField.text")); // NOI18N
        communityTextField.setToolTipText(resourceMap.getString("communityTextField.toolTipText")); // NOI18N
        communityTextField.setName("communityTextField"); // NOI18N

        encryptionKeyTextField.setText(resourceMap.getString("encryptionKeyTextField.text")); // NOI18N
        encryptionKeyTextField.setToolTipText(resourceMap.getString("encryptionKeyTextField.toolTipText")); // NOI18N
        encryptionKeyTextField.setName("encryptionKeyTextField"); // NOI18N

        superNodeTextField.setText(resourceMap.getString("superNodeTextField.text")); // NOI18N
        superNodeTextField.setToolTipText(resourceMap.getString("superNodeTextField.toolTipText")); // NOI18N
        superNodeTextField.setName("superNodeTextField"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cz.sevcik.jn2n.Jn2nApp.class).getContext().getActionMap(Jn2nView.class, this);
        connectButton.setAction(actionMap.get("connect")); // NOI18N
        connectButton.setText(resourceMap.getString("connectButton.text")); // NOI18N
        connectButton.setName("connectButton"); // NOI18N

        disconnectButton.setAction(actionMap.get("disconnect")); // NOI18N
        disconnectButton.setText(resourceMap.getString("disconnectButton.text")); // NOI18N
        disconnectButton.setName("disconnectButton"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(superNodeLabel)
                            .addComponent(edgeNodeLabel)
                            .addComponent(communityLabel)
                            .addComponent(encryptionKeyLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edgeNodeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(communityTextField)
                            .addComponent(encryptionKeyTextField)
                            .addComponent(superNodeTextField))))
                .addGap(26, 26, 26))
        );

        mainPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {communityLabel, edgeNodeLabel, encryptionKeyLabel, superNodeLabel});

        mainPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {connectButton, disconnectButton});

        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edgeNodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edgeNodeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(communityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(communityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encryptionKeyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(encryptionKeyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(superNodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(superNodeLabel))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectButton)
                    .addComponent(disconnectButton))
                .addContainerGap())
        );

        mainPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {communityLabel, edgeNodeLabel, encryptionKeyLabel});

        mainPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {communityTextField, edgeNodeTextField, encryptionKeyTextField, superNodeTextField});

        mainPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {connectButton, disconnectButton});

        superNodeTextField.getAccessibleContext().setAccessibleDescription(resourceMap.getString("supernodeJTextField.AccessibleContext.accessibleDescription")); // NOI18N

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        loadMenuItem.setAction(actionMap.get("load")); // NOI18N
        loadMenuItem.setName("loadMenuItem"); // NOI18N
        fileMenu.add(loadMenuItem);

        saveMenuItem.setAction(actionMap.get("save")); // NOI18N
        saveMenuItem.setName("saveMenuItem"); // NOI18N
        fileMenu.add(saveMenuItem);

        jSeparator1.setName("jSeparator1"); // NOI18N
        fileMenu.add(jSeparator1);

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void connect() {
        if (connector != null) {
            connector.disconnect();
        }
        N2N tunnel = createTunnel();
        if (tunnel != null) {
            connector = new Connector(tunnel);
            connector.connect();
        }
    }

    @Action
    public void disconnect() {
        if (connector != null) {
            connector.disconnect();
        }
    }

    @Action
    public void load() {
        File file = chooseFileToOpen();
        if (file != null) {
            if (file.exists()) {
                try {
                    JAXBContext context = JAXBContext.newInstance(N2N.class);
                    Unmarshaller unmarshaller = context.createUnmarshaller();
                    N2N tunnel = (N2N) unmarshaller.unmarshal(file);
                    setTextFieldValue(tunnel);
                    disconnect();
                    showMessage(resMap.getString("message.success.loaded"), MessageType.INFO);

                } catch (JAXBException ex) {
                    if (ex.getMessage().startsWith("unexpected element")) {
                        showMessage(resMap.getString("message.error.badconfigFile"), MessageType.ERROR);
                    } else {
                        showMessage(ex.getLocalizedMessage(), MessageType.ERROR);
                    }
                }
            } else {
                showMessage(resMap.getString("message.error.fileNotFound"), MessageType.ERROR);
            }
        }
    }

    @Action
    public void save() {
        N2N tunnel = createTunnel();
        if (tunnel != null) {
            File file = chooseFileToSave(tunnel);
            if (file != null) {
                try {
                    JAXBContext context = JAXBContext.newInstance(N2N.class);
                    Marshaller marshaller = context.createMarshaller();
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    marshaller.marshal(tunnel, file);
                    showMessage(resMap.getString("message.success.saved"), MessageType.INFO);

                } catch (JAXBException ex) {
                    showMessage(ex.getLocalizedMessage(), MessageType.ERROR);
                }
            }
        }
    }

    /**
     * Choose file to open
     * @return
     */
    private File chooseFileToOpen() {
        JFileChooser fileChooser = createFileChooser();
        fileChooser.setDialogTitle(resMap.getString("load.Action.shortDescription"));
        fileChooser.setApproveButtonText(resMap.getString("load.Action.text"));
        int result = fileChooser.showOpenDialog(this.getComponent());

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    /**
     * Choose file to save
     * @return
     */
    private File chooseFileToSave(N2N tunnel) {
        JFileChooser fileChooser = createFileChooser();
        String extension = ".n2n";
        String suggestedFileName = tunnel.getCommunityName() + extension;
        String suggestedUrl = fileChooser.getCurrentDirectory() + File.separator + suggestedFileName;
        File suggestedFile = new File(suggestedUrl);
        fileChooser.setSelectedFile(suggestedFile);

        fileChooser.setDialogTitle(resMap.getString("save.Action.shortDescription"));
        fileChooser.setApproveButtonText(resMap.getString("save.Action.text"));
        int result = fileChooser.showSaveDialog(this.getComponent());

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String url = file.toString().toLowerCase();

            if (!url.endsWith(extension)) {
                return new File(file.toString() + extension);
            }
            return file;
        }
        return null;
    }

    /**
     * Create file chooser
     * @return
     */
    private JFileChooser createFileChooser() {
        File dir = new File(("user.home") + File.separator + ".jn2n");
        FileFilter filter = new ExtensionFilter("jn2n config (.n2n)", "n2n");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(dir);
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setFileFilter(filter);
        return fileChooser;
    }

    /**
     * Create tunnel
     * @return
     */
    private N2N createTunnel() {
        N2N tunnel = new N2N();
        try {
            tunnel.setEdgeNode(edgeNodeTextField.getText());
        } catch (UnknownHostException uhe) {
            showMessage(resMap.getString("message.error.badEdgeNode") + " " + uhe.getMessage(), MessageType.ERROR);
            return null;
        }

        if (communityTextField.getText().isEmpty()) {
            showMessage(resMap.getString("message.error.emptyComunity"), MessageType.ERROR);
            return null;
        }
        tunnel.setCommunityName(communityTextField.getText());

        if (encryptionKeyTextField.getText().isEmpty()) {
            showMessage(resMap.getString("message.error.emptyEncryptionKey"), MessageType.ERROR);
            return null;
        }
        tunnel.setEncryptionKey(encryptionKeyTextField.getText());

        try {
            tunnel.setSuperNode(superNodeTextField.getText());
        } catch (UnknownHostException uhe) {
            showMessage(resMap.getString("message.error.badSuperNode") + " " + uhe.getMessage(), MessageType.ERROR);
            return null;
        }
        return tunnel;
    }

    /**
     * load text field values
     * @param tunnel
     */
    private void setTextFieldValue(N2N tunnel) {
        edgeNodeTextField.setText(tunnel.getEdgeNodeString());
        communityTextField.setText(tunnel.getCommunityName());
        encryptionKeyTextField.setText(tunnel.getEncryptionKey());
        superNodeTextField.setText(tunnel.getSuperNodeString());
    }

    private void initTaskMonitor() {
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();


                if (java.util.ResourceBundle.getBundle("cz/sevcik/jn2n/resources/Jn2nView").getString("STARTED").equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();


                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);


                } else if (java.util.ResourceBundle.getBundle("cz/sevcik/jn2n/resources/Jn2nView").getString("DONE").equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);


                } else if (java.util.ResourceBundle.getBundle("cz/sevcik/jn2n/resources/Jn2nView").getString("MESSAGE").equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();


                } else if (java.util.ResourceBundle.getBundle("cz/sevcik/jn2n/resources/Jn2nView").getString("PROGRESS").equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);


                }
            }
        });// </editor-fold>
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel communityLabel;
    private javax.swing.JTextField communityTextField;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JLabel edgeNodeLabel;
    private javax.swing.JTextField edgeNodeTextField;
    private javax.swing.JLabel encryptionKeyLabel;
    private javax.swing.JTextField encryptionKeyTextField;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel superNodeLabel;
    private javax.swing.JTextField superNodeTextField;
    // End of variables declaration//GEN-END:variables
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;
}
