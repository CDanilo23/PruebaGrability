/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.grability.ejb;

import co.com.grability.dto.EmployeeDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cristian Ordoñez
 */
@Local
public interface IControladorDatosSessionBeanLocal {

    public List<EmployeeDTO> consultaEmpleados(EmployeeDTO employeeDTO);

    public void registrarEmpleado(EmployeeDTO employeeDto);

}
