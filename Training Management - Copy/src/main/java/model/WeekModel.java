/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author faisal-shakiba
 */
public class WeekModel {
    public int day;
    public String startTime;
    public String outTime;

    public WeekModel() {
    }

    public WeekModel(int day, String startTime, String outTime) {
        this.day = day;
        this.startTime = startTime;
        this.outTime = outTime;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    @Override
    public String toString() {
        return "WeekModel{" + "day=" + day + ", startTime=" + startTime + ", outTime=" + outTime + '}';
    }
    
}
