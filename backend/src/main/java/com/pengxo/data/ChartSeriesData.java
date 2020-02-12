package com.pengxo.data;

import java.io.Serializable;
import java.util.Objects;

public class ChartSeriesData implements Serializable {

    private String year;

    private int nbrCar;

    private int nbrBike;

    public ChartSeriesData(String year, int nbrCar, int nbrBike) {
        this.year = year;
        this.nbrCar = nbrCar;
        this.nbrBike = nbrBike;
    }

    public ChartSeriesData() {
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getNbrCar() {
        return nbrCar;
    }

    public void setNbrCar(int nbrCar) {
        this.nbrCar = nbrCar;
    }

    public int getNbrBike() {
        return nbrBike;
    }

    public void setNbrBike(int nbrBike) {
        this.nbrBike = nbrBike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartSeriesData that = (ChartSeriesData) o;
        return nbrCar == that.nbrCar &&
                nbrBike == that.nbrBike &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, nbrCar, nbrBike);
    }

    @Override
    public String toString() {
        return "ChartSeriesData{" +
                "year='" + year + '\'' +
                ", nbrCar=" + nbrCar +
                ", nbrBike=" + nbrBike +
                '}';
    }
}
