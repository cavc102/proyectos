/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Model;

/**
 *
 * @author Carlos
 */
public class PlaneModel {
    private String Cod_plane;
    private int Cod_Order;
    private String Plane_Name;
    private double Unitary_weight;
    private double Unitary_Area;
    private int Review;
    private int Units;
    private String Observation;
    private String State;

    /**
     * @return the Cod_plane
     */
    public String getCod_plane() {
        return Cod_plane;
    }

    /**
     * @param Cod_plane the Cod_plane to set
     */
    public void setCod_plane(String Cod_plane) {
        this.Cod_plane = Cod_plane;
    }

    /**
     * @return the Cod_Order
     */
    public int getCod_Order() {
        return Cod_Order;
    }

    /**
     * @param Cod_Order the Cod_Order to set
     */
    public void setCod_Order(int Cod_Order) {
        this.Cod_Order = Cod_Order;
    }

    /**
     * @return the Plane_Name
     */
    public String getPlane_Name() {
        return Plane_Name;
    }

    /**
     * @param Plane_Name the Plane_Name to set
     */
    public void setPlane_Name(String Plane_Name) {
        this.Plane_Name = Plane_Name;
    }

    /**
     * @return the Unitary_weight
     */
    public double getUnitary_weight() {
        return Unitary_weight;
    }

    /**
     * @param Unitary_weight the Unitary_weight to set
     */
    public void setUnitary_weight(double Unitary_weight) {
        this.Unitary_weight = Unitary_weight;
    }

    /**
     * @return the Unitary_Area
     */
    public double getUnitary_Area() {
        return Unitary_Area;
    }

    /**
     * @param Unitary_Area the Unitary_Area to set
     */
    public void setUnitary_Area(double Unitary_Area) {
        this.Unitary_Area = Unitary_Area;
    }

    /**
     * @return the Review
     */
    public int getReview() {
        return Review;
    }

    /**
     * @param Review the Review to set
     */
    public void setReview(int Review) {
        this.Review = Review;
    }

    /**
     * @return the Units
     */
    public int getUnits() {
        return Units;
    }

    /**
     * @param Units the Units to set
     */
    public void setUnits(int Units) {
        this.Units = Units;
    }

    /**
     * @return the Observation
     */
    public String getObservation() {
        return Observation;
    }

    /**
     * @param Observation the Observation to set
     */
    public void setObservation(String Observation) {
        this.Observation = Observation;
    }

    /**
     * @return the State
     */
    public String getState() {
        return State;
    }

    /**
     * @param State the State to set
     */
    public void setState(String State) {
        this.State = State;
    }
    
}
