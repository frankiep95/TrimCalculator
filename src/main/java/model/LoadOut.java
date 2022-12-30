package model;

import java.io.Serializable;

public class LoadOut implements Serializable {
    public String name;
    public String Station1;
    public String Station2;
    public String Station3;
    public String Station4;
    public String Station5;
    public String Station6;
    public String Station7;
    public String Station8;
    public String Station9;
    public String FuelLoad;
    public String GunLoad;
    boolean station2noPylon;
    boolean station3noPylon;
    boolean station7noPylon;
    boolean station8noPylon;

    public LoadOut(String name, String station1, String station2, String station3, String station4, String station5, String station6, String station7, String station8, String station9, String fuelLoad, String gunLoad, boolean station2noPylon, boolean station3noPylon, boolean station7noPylon, boolean station8noPylon) {
        this.name = name;
        Station1 = station1;
        Station2 = station2;
        Station3 = station3;
        Station4 = station4;
        Station5 = station5;
        Station6 = station6;
        Station7 = station7;
        Station8 = station8;
        Station9 = station9;
        FuelLoad = fuelLoad;
        GunLoad = gunLoad;
        this.station2noPylon = station2noPylon;
        this.station3noPylon = station3noPylon;
        this.station7noPylon = station7noPylon;
        this.station8noPylon = station8noPylon;
    }

    public LoadOut() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStation1() {
        return Station1;
    }

    public void setStation1(String station1) {
        Station1 = station1;
    }

    public String getStation2() {
        return Station2;
    }

    public void setStation2(String station2) {
        Station2 = station2;
    }

    public String getStation3() {
        return Station3;
    }

    public void setStation3(String station3) {
        Station3 = station3;
    }

    public String getStation4() {
        return Station4;
    }

    public void setStation4(String station4) {
        Station4 = station4;
    }

    public String getStation5() {
        return Station5;
    }

    public void setStation5(String station5) {
        Station5 = station5;
    }

    public String getStation6() {
        return Station6;
    }

    public void setStation6(String station6) {
        Station6 = station6;
    }

    public String getStation7() {
        return Station7;
    }

    public void setStation7(String station7) {
        Station7 = station7;
    }

    public String getStation8() {
        return Station8;
    }

    public void setStation8(String station8) {
        Station8 = station8;
    }

    public String getStation9() {
        return Station9;
    }

    public void setStation9(String station9) {
        Station9 = station9;
    }

    public String getFuelLoad() {
        return FuelLoad;
    }

    public void setFuelLoad(String fuelLoad) {
        FuelLoad = fuelLoad;
    }

    public String getGunLoad() {
        return GunLoad;
    }

    public void setGunLoad(String gunLoad) {
        GunLoad = gunLoad;
    }

    public boolean isStation2noPylon() {
        return station2noPylon;
    }

    public void setStation2noPylon(boolean station2noPylon) {
        this.station2noPylon = station2noPylon;
    }

    public boolean isStation3noPylon() {
        return station3noPylon;
    }

    public void setStation3noPylon(boolean station3noPylon) {
        this.station3noPylon = station3noPylon;
    }

    public boolean isStation7noPylon() {
        return station7noPylon;
    }

    public void setStation7noPylon(boolean station7noPylon) {
        this.station7noPylon = station7noPylon;
    }

    public boolean isStation8noPylon() {
        return station8noPylon;
    }

    public void setStation8noPylon(boolean station8noPylon) {
        this.station8noPylon = station8noPylon;
    }

    @Override
    public String toString() {
        return "LoadOut{" +
                "name='" + name + '\'' +
                ", Station1='" + Station1 + '\'' +
                ", Station2='" + Station2 + '\'' +
                ", Station3='" + Station3 + '\'' +
                ", Station4='" + Station4 + '\'' +
                ", Station5='" + Station5 + '\'' +
                ", Station6='" + Station6 + '\'' +
                ", Station7='" + Station7 + '\'' +
                ", Station8='" + Station8 + '\'' +
                ", Station9='" + Station9 + '\'' +
                ", FuelLoad='" + FuelLoad + '\'' +
                ", GunLoad='" + GunLoad + '\'' +
                ", station2noPylon=" + station2noPylon +
                ", station3noPylon=" + station3noPylon +
                ", station7noPylon=" + station7noPylon +
                ", station8noPylon=" + station8noPylon +
                '}';
    }
}
