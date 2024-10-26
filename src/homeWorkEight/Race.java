package src.homeWorkEight;

import java.util.concurrent.atomic.AtomicInteger;

class Race implements Runnable {
    private final String raceName;
    private final Crystal crystal;
    private final AtomicInteger redCrystalsCollected = new AtomicInteger(0);
    private final AtomicInteger whiteCrystalsCollected = new AtomicInteger(0);
    private static final Integer TARGET_CRYSTALS = 500;
    private final ProgressDisplay progressDisplay;

    public Race(String raceName, Crystal crystal, ProgressDisplay progressDisplay) {
        this.raceName = raceName;
        this.crystal = crystal;
        this.progressDisplay = progressDisplay;
    }

    public boolean hasWon() {
        return redCrystalsCollected.get() >= TARGET_CRYSTALS && whiteCrystalsCollected.get() >= TARGET_CRYSTALS;
    }

    @Override
    public void run() {
        while (!hasWon()) {
            int[] collected = crystal.collectCrystals();
            redCrystalsCollected.addAndGet(collected[0]);
            whiteCrystalsCollected.addAndGet(collected[1]);
            progressDisplay.updateProgress(raceName, redCrystalsCollected.get(), whiteCrystalsCollected.get());
            try {
                Thread.sleep(10); // Симуляция одного дня
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\n" + raceName + " has won with " + redCrystalsCollected + " red and " + whiteCrystalsCollected + " white crystals!");
        System.exit(0);
    }
}
