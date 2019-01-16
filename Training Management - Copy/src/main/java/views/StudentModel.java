/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author faisal-shakiba
 */
public class StudentModel {
    String name;
    String id;
    String semester;
    String cgpa;
    String performance_cgpa;
    String performance_result;
    public StudentModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getPerformance_cgpa() {
        return performance_cgpa;
    }

    public void setPerformance_cgpa(String performance_cgpa) {
        this.performance_cgpa = performance_cgpa;
    }

    public String getPerformance_result() {
        return performance_result;
    }

    public void setPerformance_result(String performance_result) {
        this.performance_result = performance_result;
    }

    public StudentModel(String name, String id, String semester, String cgpa, String performance_cgpa, String performance_result) {
        this.name = name;
        this.id = id;
        this.semester = semester;
        this.cgpa = cgpa;
        this.performance_cgpa = performance_cgpa;
        this.performance_result = performance_result;
    }

    @Override
    public String toString() {
        return "StudentModel{" + "name=" + name + ", id=" + id + ", semester=" + semester + ", cgpa=" + cgpa + ", performance_cgpa=" + performance_cgpa + ", performance_result=" + performance_result + '}';
    }

   

   
   
   
    
}
