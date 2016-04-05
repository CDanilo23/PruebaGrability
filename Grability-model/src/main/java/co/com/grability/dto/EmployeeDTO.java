/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.grability.dto;

import java.util.Date;

/**
 *
 * @author Cristian Ordoñez
 */
public class EmployeeDTO {
    
    private static final long serialVersionUID = 2914300651944274551L;

    private String nombre;
    private String apellido;
    private String email;
    private Date hireDate;
    private String jobId;
    private Integer departmentId;
    private String cargo;
    private String descDepartamento;

    public EmployeeDTO(String nombre, String apellido, String email, Date hireDate, String jobId,
                       Integer departmentId) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.departmentId = departmentId;
    }
    
    public EmployeeDTO(String nombre, String apellido, String email, String cargo, String descDepartamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.cargo = cargo;
        this.descDepartamento = descDepartamento;
    }

    public EmployeeDTO() {
        super();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setDescDepartamento(String descDepartamento) {
        this.descDepartamento = descDepartamento;
    }

    public String getDescDepartamento() {
        return descDepartamento;
    }
}
