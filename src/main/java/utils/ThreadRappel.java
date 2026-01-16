package utils;

import controller.HopitalManager;
import model.RendezVous;

public class ThreadRappel extends Thread {

    private HopitalManager manager;

    public ThreadRappel(HopitalManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                for (RendezVous rv : manager.getRendezVous()) {
                    System.out.println("⏰ Rappel RV : " + rv.getId() +
                            " le " + rv.getDate());
                }
                Thread.sleep(120000); // 2 min
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
