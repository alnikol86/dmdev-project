package src.homeWorkEight;

public class CrystalRaceSimulation {
    public static void main(String[] args) {
        Crystal crystal = new Crystal();
        ProgressDisplay progressDisplay = new ProgressDisplay(500);
        Race fireRace = new Race("Fire Mage", crystal, progressDisplay);
        Race airRace = new Race("Air Mage", crystal, progressDisplay);

        Thread generator = new Thread(() -> {
            while (true) {
                crystal.generateCrystals();
                try {
                    Thread.sleep(100); // Генерация кристаллов каждый день
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread fireMageThread = new Thread(fireRace);
        Thread airMageThread = new Thread(airRace);
        Thread progressThread = new Thread(progressDisplay::displayProgress);

        generator.start();
        fireMageThread.start();
        airMageThread.start();
        progressThread.start();
    }
}
