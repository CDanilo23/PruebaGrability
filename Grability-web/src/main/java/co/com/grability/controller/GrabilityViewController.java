/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.grability.controller;

import co.com.grability.dto.EmployeeDTO;
import co.com.grability.ejb.ControladorDatosSession;
import co.com.grability.ejb.IControladorDatosSessionBeanLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Cristian Ordoñez
 */
@ManagedBean(name = "grabilityViewController")
@RequestScoped
public class GrabilityViewController implements Serializable {

    private static final long serialVersionUID = -7018560073417642644L;

    @EJB(mappedName = "ControladorDatosSessionBean",lookup = "java:app/Grability-ejb-1.0-SNAPSHOT/ControladorDatosSession!co.com.grability.ejb.IControladorDatosSessionBeanLocal")
    IControladorDatosSessionBeanLocal ControladorDatosSessionBean;

    private EmployeeDTO empleadoDto;
    private List<EmployeeDTO> listaEmpleados;
    public GrabilityViewController() {
        empleadoDto = new EmployeeDTO();
    }

    public EmployeeDTO getEmpleadoDto() {
        return empleadoDto;
    }

    public void setEmpleadoDto(EmployeeDTO empleadoDto) {
        this.empleadoDto = empleadoDto;
    }

    public void consultar() {
        listaEmpleados = ControladorDatosSessionBean.consultaEmpleados(empleadoDto);
    }

    public void registrar() {
        this.ControladorDatosSessionBean.registrarEmpleado(empleadoDto);
    }

    public void limpiar() {
        empleadoDto = new EmployeeDTO();
    }

    public List<EmployeeDTO> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<EmployeeDTO> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

}
