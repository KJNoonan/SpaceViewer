
import display.ConsoleItem;
import display.ConsoleItemImpl;
import display.ViewManager;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utils.ColorMaker;
import utils.Point3D;
import utils.PolygonPlus;
import utils.SoundUtility;

/* 
 This is the test "driver" program that will test the Display subsystem.
 This driver executes tests as described in the Quarter Programming Project 
 document.
 Do not change this file.
 */
public class Driver {

    public static void main(String[] args) throws InterruptedException {

        testSoundUtility();
        testViewScreen();
        System.exit(0);
    }

    private static void testSoundUtility() throws InterruptedException {

        JOptionPane.showMessageDialog(null, "Testing Sounds (please check your volume)", "Test Sound", JOptionPane.INFORMATION_MESSAGE);

        System.out.println("Testing Sounds (please check your volume)");
        SoundUtility.getInstance();

        JOptionPane.showMessageDialog(null, "1) Testing Sounds (Test Sound 1 - Explosion)", "Test Sound", JOptionPane.INFORMATION_MESSAGE);
        SoundUtility.getInstance().playSound("sounds" + File.separator + "Blast.wav");
        Thread.sleep(2000);

        JOptionPane.showMessageDialog(null, "2) Testing Sounds (Test Sound 2 - Missile Launch)", "Test Sound", JOptionPane.INFORMATION_MESSAGE);
        SoundUtility.getInstance().playSound("sounds" + File.separator + "Launch.wav");
        Thread.sleep(1000);

        JOptionPane.showMessageDialog(null, "3) Testing Sounds (Test Sound 3 - Missile Explosion)", "Test Sound", JOptionPane.INFORMATION_MESSAGE);
        SoundUtility.getInstance().playSound("sounds" + File.separator + "MissileBlast.wav");
        Thread.sleep(1000);

        JOptionPane.showMessageDialog(null, "4) Testing Sounds (Test Sound 4 - Rail Gun)", "Test Sound", JOptionPane.INFORMATION_MESSAGE);
        SoundUtility.getInstance().playSound("sounds" + File.separator + "Rail.wav");
        Thread.sleep(1000);

        JOptionPane.showMessageDialog(null, "5) Testing Sounds (Test Sound 5 - Debris Cloud)", "Test Sound", JOptionPane.INFORMATION_MESSAGE);
        SoundUtility.getInstance().playSound("sounds" + File.separator + "Cloud.wav");
        Thread.sleep(1000);

        SoundUtility.getInstance().setRunning(false);
    }

    private static final PolygonPlus shape = new PolygonPlus(new int[]{15, 0, -15}, new int[]{15, -15, 15}, 3);
    private static final Point3D point = new Point3D(200, 100, 600);
    private static final Color color = ColorMaker.makeColor("YELLOW");

    private static void testViewScreen() throws InterruptedException {

        JOptionPane.showMessageDialog(null, "6) Testing View Screen\nClick 'OK' to Launch View Screen", "Test View Screen", JOptionPane.INFORMATION_MESSAGE);
        Thread.sleep(500);
        int screenX = 800;
        int screenY = 800;
        int screenZ = 800;
        ViewManager.setup(screenX, screenY, screenZ);
        ViewManager.getInstance();
        Thread.sleep(1500);

        JOptionPane.showMessageDialog(null, "7) Click 'OK' to Add a Test Shape to the View Screen", "Add Test Shape", JOptionPane.INFORMATION_MESSAGE);
        ViewManager.getInstance().updateItem(new ConsoleItemImpl("Test Item 1", point, color, 0, shape, "Test Item 1 " + point, false, false));
        Thread.sleep(1000);

        JOptionPane.showMessageDialog(null, "8) Click 'OK' to Move the Shape at a Slow and Fast Speed", "Move Test Shape", JOptionPane.INFORMATION_MESSAGE);
        moveTestItem(15, false);
        moveTestItem(3, false);

        JOptionPane.showMessageDialog(null, "9) Click 'OK' to Move the Shape\n(Color will dim and rotate halfway through the movement path)", "Move Test Shape", JOptionPane.INFORMATION_MESSAGE);
        moveTestItem(10, true);

        JOptionPane.showMessageDialog(null, "10) Click 'OK' to place 500 shapes at random locations, random colors, random rotation", "Add Test Shapes", JOptionPane.INFORMATION_MESSAGE);
        Point3D pScr = new Point3D(800,800,800);
        ArrayList<ConsoleItem> allShapes = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Point3D p = new Point3D(pScr.getX() * Math.random(), pScr.getY() * Math.random(), pScr.getZ() * Math.random());
            Color c = ColorMaker.makeColor(ColorMaker.randomColorName());
            ConsoleItem ci = new ConsoleItemImpl("Test Item " + i, p, c, i, shape, "Test Item 1 " + p, false, false);
            allShapes.add(ci);
            ViewManager.getInstance().updateItem(ci);
            Thread.sleep(5);
        }

        JOptionPane.showMessageDialog(null, "11) Click 'OK' to rotate all shapes", "Rotate Test Shape", JOptionPane.INFORMATION_MESSAGE);
        for (int i = 0; i < 100; i++) {
            for (ConsoleItem ci : allShapes) {
                ConsoleItem cii = new ConsoleItemImpl(ci.getId(), ci.getLocation(), ci.getColor(), ci.getAngle() + (double) i / 4.0, shape, ci.getInfoText(), ci.isDestroyed(), ci.isDamaged());
                ViewManager.getInstance().updateItem(cii);
            }
            Thread.sleep(50);

        }

        JOptionPane.showMessageDialog(null, "11) Click 'OK' to remove the shapes", "Remove Test Shapes", JOptionPane.INFORMATION_MESSAGE);
        for (ConsoleItem ci : allShapes) {
            ViewManager.getInstance().removeItem(ci.getId());
            Thread.sleep(5);
        }

        JOptionPane.showMessageDialog(null, "The Test is Complete.\nClick 'OK' to exit", "Complete", JOptionPane.INFORMATION_MESSAGE);

    }

    private static void moveTestItem(long delay, boolean dim) throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            int angle = 0;
            boolean useDim = false;
            if (dim && i > 250) {
                useDim = true;
                angle = i;
            }

            Point3D p = new Point3D(point.getX() + i, point.getY() + i, point.getZ() + i);
            ViewManager.getInstance().updateItem(new ConsoleItemImpl("Test Item 1", p, ColorMaker.makeColor("YELLOW"), angle, shape, "Test Item 1 " + p, false, useDim));
            Thread.sleep(delay);
        }
    }
}
