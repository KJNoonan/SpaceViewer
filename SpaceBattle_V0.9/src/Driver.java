import classes.CargoShip;
import classes.SpaceController;
import display.ViewManager;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utils.ColorMaker;
import utils.Point3D;
import utils.SoundUtility;

/* 
 This is the test "driver" program that will test the Display subsystem.
 This driver executes tests as described in the Quarter Programming Project 
 document.

 Slight changes might be needed below in order to get this to compile with your
 project. If you have trouble getting this to work with your code, email me.

 */
public class Driver {

    public static void main(String[] args) throws InterruptedException {

        // *** For the below - change "xSize", "ySize" and "zSize" to match the names of the
        // X, Y & Z data members in your SpaceController if they are not named as you see below.
        ViewManager.setup(SpaceController.xSize, SpaceController.ySize, SpaceController.zSize);

        ViewManager.getInstance();

        initTests();

        SoundUtility.getInstance().setRunning(false);

        System.exit(0);

    }

    private static void initTests() throws InterruptedException {

        showMessage("Create 3 Moving Cargo Ships\n(and Print Info Text of 3 Ships to the Console)", "Create Ships");
        CargoShip[] testShips = new CargoShip[3];
        testShips[0] = new CargoShip("CargoShip1", "YELLOW", new Point3D(100, 100, 800), new Point3D(500, 500, 400), 1000.0, 7.0, 50);
        testShips[1] = new CargoShip("CargoShip2", "GREEN", new Point3D(100, 200, 800), new Point3D(500, 600, 400), 1000.0, 7.0, 50);
        testShips[2] = new CargoShip("CargoShip3", "MAGENTA", new Point3D(100, 300, 800), new Point3D(500, 700, 400), 1000.0, 7.0, 50);
        for (CargoShip cs : testShips) {
            System.out.println("----");
            System.out.println(cs.getInfoText());
            System.out.println("----");
        }
        Thread.sleep(1500);

        showMessage("Apply Damage to the 3 Cargo Ships", "Apply Damage");
        for (CargoShip cs : testShips) {
            cs.applyDamage(100);
            System.out.println("----");
            System.out.println(cs.getInfoText());
            System.out.println("----");
        }
        Thread.sleep(1500);

        showMessage("Cargo Ships React to Radar-Lock\n(and reset to full strength)", "React to Radar Lock");
        for (CargoShip cs : testShips) {

            cs.reactToRadarLock(cs.getLocation());
            cs.resetStrength();
            System.out.println(cs.getInfoText());
        }
        Thread.sleep(1500);

        showMessage("Destroy the 3 Cargo Ships", "Destroy Ships");
        for (CargoShip cs : testShips) {

            cs.applyDamage(1000);
            System.out.println(cs.getInfoText());
        }
        Thread.sleep(1500);

        showMessage("Create a New Cargo Ship (Random Color)", "Create Ship");
        CargoShip s = new CargoShip("CargoShip4", ColorMaker.randomColorName(), new Point3D(10, 10, 800), new Point3D(200, 200, 700), 1000.0, 7.0, 50);
        Thread.sleep(1000);

        showMessage("Cargo Ship Reacts to Multiple Radar-Locks", "React to Radar Locks");
        s.reactToRadarLock(s.getLocation());
        Thread.sleep(1000);
        s.reactToRadarLock(s.getLocation());
        Thread.sleep(1000);
        s.reactToRadarLock(s.getLocation());
        Thread.sleep(1000);
        s.reactToRadarLock(s.getLocation());
        Thread.sleep(1000);

        showMessage("Destroy the Cargo Ship", "Destroy Ship");
        s.applyDamage(1000);
        Thread.sleep(1000);

        showMessage("Create 20 Random Cargo Ships", "Create Ships");
        ArrayList<CargoShip> ships = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ships.add(new CargoShip("CargoShip" + i, ColorMaker.randomColorName(), makePoint(), makePoint(), 1000.0, 7.0, 50));
            Thread.sleep(20);
        }
        Thread.sleep(1000);

        showMessage("Apply a Radar-Lock to All Cargo Ships", "React to Radar Locks");
        for (CargoShip cargo : ships) {
            cargo.reactToRadarLock(cargo.getLocation());
            Thread.sleep(150);
        }
        Thread.sleep(1000);

        showMessage("Destroy All Cargo Ships", "Destroy Ships");
        for (CargoShip cargo : ships) {
            cargo.applyDamage(1000);
            Thread.sleep(200);
        }
        Thread.sleep(1000);

        showMessage("The Test is Complete.\nClick 'OK' to exit", "Complete");

    }

    public static void showMessage(String message, String title) {
        final JOptionPane pane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
        final JDialog d = pane.createDialog(null, title);
        d.setLocation(200, 40);
        d.setVisible(true);
    }

    public static Point3D makePoint() {
        int xCoord = (int) (Math.random() * SpaceController.xSize);
        int yCoord = (int) (Math.random() * SpaceController.ySize);
        int zCoord = (int) (Math.random() * SpaceController.zSize);
        return new Point3D(xCoord, yCoord, zCoord);
    }

}