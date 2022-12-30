package model;

import javafx.scene.control.MenuItem;

public class Ordinance extends MenuItem {
    public int ID ;
    public String name;
    public int weight;
    public double station1and9CG;
    public double station2and8CG;
    public double station3and7CG;
    public double station4CG;
    public double station5CG;
    public double station6CG;
    public boolean station1and9;
    public boolean station2and8;
    public boolean station3and7;
    public boolean station4;
    public boolean station5;
    public boolean station6;

    public String type;


    public Ordinance() {
    }

    public Ordinance(int id,String name, int weight, double station1and9CG, double station2and8CG, double station3and7CG, double station4CG, double station5CG, double station6CG, boolean station1and9, boolean station2and8, boolean station3and7, boolean station4, boolean station5, boolean station6, String type) {
        this.ID  = id;
        this.name = name;
        this.weight = weight;
        this.station1and9CG = station1and9CG;
        this.station2and8CG = station2and8CG;
        this.station3and7CG = station3and7CG;
        this.station4CG = station4CG;
        this.station5CG = station5CG;
        this.station6CG = station6CG;
        this.station1and9 = station1and9;
        this.station2and8 = station2and8;
        this.station3and7 = station3and7;
        this.station4 = station4;
        this.station5 = station5;
        this.station6 = station6;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getStation1and9CG() {
        return station1and9CG;
    }

    public void setStation1and9CG(double station1and9CG) {
        this.station1and9CG = station1and9CG;
    }

    public double getStation2and8CG() {
        return station2and8CG;
    }

    public void setStation2and8CG(double station2and8CG) {
        this.station2and8CG = station2and8CG;
    }

    public double getStation3and7CG() {
        return station3and7CG;
    }

    public void setStation3and7CG(double station3and7CG) {
        this.station3and7CG = station3and7CG;
    }

    public double getStation4CG() {
        return station4CG;
    }

    public void setStation4CG(double station4CG) {
        this.station4CG = station4CG;
    }

    public double getStation5CG() {
        return station5CG;
    }

    public void setStation5CG(double station5CG) {
        this.station5CG = station5CG;
    }

    public double getStation6CG() {
        return station6CG;
    }

    public void setStation6CG(double station6CG) {
        this.station6CG = station6CG;
    }

    public boolean isStation1and9() {
        return station1and9;
    }

    public void setStation1and9(boolean station1and9) {
        this.station1and9 = station1and9;
    }

    public boolean isStation2and8() {
        return station2and8;
    }

    public void setStation2and8(boolean station2and8) {
        this.station2and8 = station2and8;
    }

    public boolean isStation3and7() {
        return station3and7;
    }

    public void setStation3and7(boolean station3and7) {
        this.station3and7 = station3and7;
    }

    public boolean isStation4() {
        return station4;
    }

    public void setStation4(boolean station4) {
        this.station4 = station4;
    }

    public boolean isStation5() {
        return station5;
    }

    public void setStation5(boolean station5) {
        this.station5 = station5;
    }

    public boolean isStation6() {
        return station6;
    }

    public void setStation6(boolean station6) {
        this.station6 = station6;
    }

    @Override
    public String toString() {
        return "Ordinance{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", station1and9CG=" + station1and9CG +
                ", station2and8CG=" + station2and8CG +
                ", station3and7CG=" + station3and7CG +
                ", station4CG=" + station4CG +
                ", station5CG=" + station5CG +
                ", station6CG=" + station6CG +
                ", station1and9=" + station1and9 +
                ", station2and8=" + station2and8 +
                ", station3and7=" + station3and7 +
                ", station4=" + station4 +
                ", station5=" + station5 +
                ", station6=" + station6 +
                ", type='" + type + '\'' +
                '}';
    }
}
