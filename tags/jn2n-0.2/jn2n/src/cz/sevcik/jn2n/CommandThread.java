package cz.sevcik.jn2n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jdesktop.application.ResourceMap;

/**
 * Thread external command
 *
 * @author Jaroslav Sevcik
 *
 * @version $Rev$
 */
public class CommandThread extends Thread {

    /** External command*/
    private String command;
    /** Process object */
    private Process process;
    /** Application's main frame */
    private Jn2nView view;

    public CommandThread(String command) {
        this.command = command;
        view = Jn2nApp.getApplication().getView();
    }

    /**
     * Thread activity
     */
    @Override
    public void run() {
        try {
            System.out.println(command);
            process = Runtime.getRuntime().exec(command);
            view.showConnectionStatus(true);
            printOutput();

        } catch (IOException ex) {
            if (ex.getMessage().startsWith("Cannot run program \"edge\"")) {
                ResourceMap resMap =  Jn2nApp.getApplication().getContext().getResourceMap(Jn2nView.class);
                view.showMessage(resMap.getString("message.error.n2nNotAvailable"), MessageType.ERROR);
            } else {
                view.showMessage(ex.getLocalizedMessage(), MessageType.ERROR);
            }
        }
    }

    /**
     * Kills the process
     */
    public void exit() {
        if (process != null) {
            process.destroy();
        }
        view.showConnectionStatus(false);
    }

    /**
     * Print command output
     * @throws IOException
     */
    private void printOutput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
