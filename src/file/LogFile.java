package file;

import java.io.*;
import java.time.LocalDateTime;
/**
 * <b>LogFileBean is a Javabean used to manage a log file.</b>
 *
 * @author Lempereur Rocca
 *
 * @see Serializable
 *
 * @version 1.0
 */
@SuppressWarnings("unused")
public class LogFile implements Serializable{
    /**
     * The file path.
     *
     * @see LogFile#LogFile()
     */
    private String _path;

    /**
     * FichierLogBean default Constructor.
     * <p>
     *     The file path is set to null.
     * </p>
     */
    public LogFile() {
        _path = null;
    }

    /**
     * Method used to write a line in the log file.
     * <p>
     *     The line passed in parameter is written to the log file on a new line.
     * </p>
     * @param line
     *       The line to write.
     */
    private void writeLine(String line)
    {
        if(_path != null) {
            try
            {
                FileWriter f = new FileWriter(_path, true);
                BufferedWriter bf = new BufferedWriter(f);
                LocalDateTime d = LocalDateTime.now();
                bf.write("[" + d.toString() + "] : " + line);
                bf.newLine();
                bf.close();
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
                throw new RuntimeException("WavPlayer: Input/Output Error: " + ex);
            }
        }
        else
            throw new RuntimeException("LogFile: File path is null");
    }

    /**
     * Method used to write a formatted line in the log file.
     * <p>
     *     The line passed in parameter is written to the log file on a new formatted line.
     * </p>
     * @param head
     *       The header of the line.
     * @param line
     *       The line to write.
     */
    public void writeFormattedLine(String head, String line)
    {
        writeLine(head + " > " + line);
    }

    /**
     * Return the path.
     *
     * @return The path.
     */
    public String get_path() {
        return _path;
    }

    /**
     * Updates the file path.
     *
     * @param _path
     *          The new file path.
     */
    public void set_path(String _path) {
        this._path = _path + "log.txt";
    }
}
