/*
 * Jn2nApp.java
 */
package cz.sevcik.jn2n;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 *
 * @author Jaroslav Sevcik
 *
 * @version $Rev$
 */
public class Jn2nApp extends SingleFrameApplication {

    /** main frame of the application */
    private Jn2nView view;

    public Jn2nView getView() {
        return view;
    }

    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {
        view = new Jn2nView(this);
        show(view);
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of Jn2nApp
     */
    public static Jn2nApp getApplication() {
        return Application.getInstance(Jn2nApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(Jn2nApp.class, args);
    }
}
