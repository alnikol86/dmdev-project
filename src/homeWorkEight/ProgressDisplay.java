package src.homeWorkEight;

import java.util.concurrent.atomic.AtomicInteger;

public class ProgressDisplay {
    private final Integer targetCrystals;
    private final AtomicInteger fireRedProgress = new AtomicInteger(0);
    private final AtomicInteger fireWhiteProgress = new AtomicInteger(0);
    private final AtomicInteger airRedProgress = new AtomicInteger(0);
    private final AtomicInteger airWhiteProgress = new AtomicInteger(0);

    public ProgressDisplay(int targetCrystals) {
        this.targetCrystals = targetCrystals;
    }

    public void updateProgress(String raceName, int red, int white) {
        if (raceName.equals("Fire Mage")) {
            fireRedProgress.set(red);
            fireWhiteProgress.set(white);
        } else {
            airRedProgress.set(red);
            airWhiteProgress.set(white);
        }
    }

    public void displayProgress() {
        while (true) {
            System.out.print("\rFire Mage Progress: " + progressBar(fireRedProgress.get(), targetCrystals, "RED") +
                    " | " + progressBar(fireWhiteProgress.get(), targetCrystals, "WHITE") + "\t" +
                    "<-VS->" + " Air Mage Progress: " + progressBar(airRedProgress.get(), targetCrystals, "RED") +
                    " | " + progressBar(airWhiteProgress.get(), targetCrystals, "WHITE"));
            try {
                Thread.sleep(100); // Обновление каждые 0,1 с
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private String progressBar(int current, int total, String color) {
        int progressWidth = 20;
        int filled = (int) ((double) current / total * progressWidth); //Количество символов, которые будут заплнены в прогресс-баре
        StringBuilder bar = new StringBuilder(color + ": [");
        for (int i = 0; i < progressWidth; i++) {
            if (i < filled) {
                bar.append("=");
            } else {
                bar.append(" ");
            }
        }
        bar.append("] ").append(current).append("/").append(total);
        return bar.toString();
    }
}
