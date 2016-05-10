package general;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * <b>Wav layer is the class for reading and controlling a wav file.</b>
 *
 * @author Lempereur Benjamin
 *
 * @version 1.0
 */
final public class WavPlayer {
    /**
     * The sound in memory.
     *
     * @see WavPlayer#play(String)
     */
    private static Clip _clip = null;

    /**
     * Method to start the wav file whose path is passed as parameter.
     * @param filepath
     *       The path of the wav file.
     */
    public static void play(String filepath) {
        try {
            _clip = AudioSystem.getClip();
            File file = new File(filepath);
            if(file.exists()) {
                AudioInputStream ais = AudioSystem.getAudioInputStream(file);
                _clip.open(ais);
                _clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else
                throw new RuntimeException("WavPlayer: file not found: " + filepath);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("WavPlayer: Line Unavailable Exception Error: " + e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("WavPlayer: Input/Output Error: " + e);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("WavPlayer: Unsupported Audio File: " + e);
        }

    }

    /**
     * Method to stop the reading.
     *
     */
    public static void stop() {
        _clip.stop();
    }

    /**
     * Method to replay the wav file.
     *
     */
    public static void replay() {
        _clip.start();
    }

    /**
     * Method to replay the wav file at the beginning.
     *
     */
    public static void playAgain() {
        _clip.setFramePosition(0);
        _clip.start();
    }
}
