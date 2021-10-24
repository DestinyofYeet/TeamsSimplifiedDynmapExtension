package me.destinyofyeet.TeamsSimplifiedDynmapExtension.dynmapStuff;

import java.util.concurrent.TimeUnit;

public class ThreadManager extends Thread {
    private boolean running;


    public ThreadManager(){
        this.running = true;

        start();
    }

    @Override
    public void run() {
        while (running){
            Sync.doSync();

            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
