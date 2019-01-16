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
public class batch_status {
    private String id;
    private String attendance;
    private String batch_code;
    private String date;
    private String day;
    private String start;
    private String end;
    private String intime;
    private String outtime;
    private String status;
    private String trainer_name;
    private String university_name;


    public batch_status() {
    }

    public batch_status(String attendance, String batch_code, String date, String day, String start, String end, String intime, String outtime, String status, String trainer_name, String university_name) {
        this.attendance = attendance;
        this.batch_code = batch_code;
        this.date = date;
        this.day = day;
        this.start = start;
        this.end = end;
        this.intime = intime;
        this.outtime = outtime;
        this.status = status;
        this.trainer_name = trainer_name;
        this.university_name = university_name;
    }

    public batch_status(String id, String attendance, String batch_code, String date, String day, String start, String end, String intime, String outtime, String status, String trainer_name, String university_name) {
        this.id = id;
        this.attendance = attendance;
        this.batch_code = batch_code;
        this.date = date;
        this.day = day;
        this.start = start;
        this.end = end;
        this.intime = intime;
        this.outtime = outtime;
        this.status = status;
        this.trainer_name = trainer_name;
        this.university_name = university_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getBatch_code() {
        return batch_code;
    }

    public void setBatch_code(String batch_code) {
        this.batch_code = batch_code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrainer_name() {
        return trainer_name;
    }

    public void setTrainer_name(String trainer_name) {
        this.trainer_name = trainer_name;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    @Override
    public String toString() {
        return "batch_status{" + "id=" + id + ", attendance=" + attendance + ", batch_code=" + batch_code + ", date=" + date + ", day=" + day + ", start=" + start + ", end=" + end + ", intime=" + intime + ", outtime=" + outtime + ", status=" + status + ", trainer_name=" + trainer_name + ", university_name=" + university_name + '}';
    }

    
    
    
}
