package utils;

import controller.HopitalManager;

public class ThreadStock extends Thread {

    private HopitalManager manager;

    public ThreadStock(HopitalManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                manager.verifierStockMedicaments();
                Thread.sleep(120000); // 2 min
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
