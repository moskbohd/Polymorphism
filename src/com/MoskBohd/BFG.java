package com.MoskBohd;

import java.util.Locale;

public class BFG extends Gun implements Shooting, Killing{

    String target;
    boolean keyPressed;

    public BFG() {
    }

    public BFG(String shootingStyleCurrent, boolean keyPressed, int ammoCurrent, int meleeDamage, int damage, String target) {
        this.shootingStyleCurrent = shootingStyleCurrent;
        this.keyPressed = keyPressed;
        this.ammoCurrent = ammoCurrent;
        this.meleeDamage = meleeDamage;
        this.damage = damage;
        this.target = target;
    }

    public String getShootingStyleCurrent() {
        return shootingStyleCurrent;
    }

    public void setShootingStyleCurrent(String shootingStyleCurrent) {
        this.shootingStyleCurrent = shootingStyleCurrent;
    }

    public boolean isKeyPressed() {
        return keyPressed;
    }

    public void setKeyPressed(boolean keyPressed) {
        this.keyPressed = keyPressed;
    }

    public int getAmmoCurrent() {
        return ammoCurrent;
    }

    public void setAmmoCurrent(int ammoCurrent) {
        this.ammoCurrent = ammoCurrent;
    }

    public int getMeleeDamage() {
        return meleeDamage;
    }

    public void setMeleeDamage(int meleeDamage) {
        this.meleeDamage = meleeDamage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    // implementation Shooting
    @Override
    public boolean needReload() {
        switch (this.getAmmoCurrent()){
            case (0) :
                return true;
            default:
                return false;
        }
    }

    @Override
    public void changeShootingStyle(boolean keyPressed) {
        if (this.getShootingStyleCurrent().equalsIgnoreCase("semi-auto") & keyPressed == true){
            this.setShootingStyleCurrent("single");
        }else if (this.getShootingStyleCurrent().equalsIgnoreCase("single") & keyPressed == true){
            this.setShootingStyleCurrent("semi-auto");
        }
    }

    @Override
    public boolean isShooting(boolean keyPressed) {
        if (keyPressed == true) {
            return true;
        }else return false;
    }

    @Override
    public boolean hasMelee() {
        if (this.getMeleeDamage() <=0){
            return false;
        }else return true;
    }

    // implementation Killing
    @Override
    public int dealDamage(int resist) {
        return this.getDamage() - resist;
    }

    @Override
    public boolean isHeadshot(String target) {
        switch (target.toLowerCase(Locale.ROOT)){
            case ("head"):
                return true;
            default:
                return false;
        }
    }
}
