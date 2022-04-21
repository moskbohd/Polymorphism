package com.MoskBohd;

public interface Shooting {
    boolean needReload();
    void changeShootingStyle(boolean keyPressed);
    boolean isShooting(boolean keyPressed);
    boolean hasMelee();
}
