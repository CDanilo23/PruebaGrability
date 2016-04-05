/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.grability.ejb;

import co.com.grability.dto.EmployeeDTO;
import co.com.grability.model.Employees;
import co.com.grability.model.Jobs;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Cristian Ordoñez
 */
@Stateless(name = "ControladorDatosSession", mappedName = "ControladorDatosSessionBean")
@LocalBean
public class ControladorDatosSession implements IControladorDatosSessionBeanLocal{

    @PersistenceContext(unitName = "Mock-model")
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<EmployeeDTO> consultaEmpleados(EmployeeDTO employeeDTO) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select new co.com.grability.dto.EmployeeDTO(");
        stringBuilder.append("e.firstName,e.lastName,e.email,j.jobTitle,d.departmentName) from Employees e ");
        stringBuilder.append("join e.jobId j ");
        stringBuilder.append("join e.departmentId d where ");

        if (employeeDTO.getNombre() != null && !employeeDTO.getNombre().isEmpty()) {
            stringBuilder.append(" e.firstName = :NOMBRE and ");
        }
        if (employeeDTO.getApellido() != null && !employeeDTO.getApellido().isEmpty()) {
            stringBuilder.append(" e.lastName = :APELLIDO and ");
        }
        if (employeeDTO.getEmail() != null && !employeeDTO.getEmail().isEmpty()) {
            stringBuilder.append(" e.email = :EMAIL and ");
        }
        if (employeeDTO.getHireDate() != null) {
            stringBuilder.append(" e.hireDate = :FECHA_INGRESO and ");
        }
        if (employeeDTO.getJobId() != null && !employeeDTO.getJobId().isEmpty()) {
            stringBuilder.append(" e.jobId.jobId = :JOB_ID and ");
        }
        stringBuilder.append(" e.employeeId!=null");

        Query query = em.createQuery(stringBuilder.toString());

        if (employeeDTO.getNombre() != null && !employeeDTO.getNombre().isEmpty()) {
            query.setParameter("NOMBRE", employeeDTO.getNombre());
        }
        if (employeeDTO.getApellido() != null && !employeeDTO.getApellido().isEmpty()) {
            query.setParameter("APELLIDO", employeeDTO.getApellido());
        }
        if (employeeDTO.getEmail() != null && !employeeDTO.getEmail().isEmpty()) {
            query.setParameter("EMAIL", employeeDTO.getEmail());
        }
        if (employeeDTO.getHireDate() != null) {
            query.setParameter("FECHA_INGRESO", employeeDTO.getHireDate());
        }
        if (employeeDTO.getJobId() != null && !employeeDTO.getJobId().isEmpty()) {
            query.setParameter("JOB_ID", employeeDTO.getJobId());
        }
        return query.getResultList();
    }

    public void registrarEmpleado(EmployeeDTO employeeDto) {
        Employees employee2 = new Employees();
        employee2.setFirstName(employeeDto.getNombre());
        employee2.setLastName(employeeDto.getApellido());
        employee2.setEmail(employeeDto.getEmail());
        employee2.setHireDate(employeeDto.getHireDate());
        employee2.setJobId(new Jobs(employeeDto.getJobId()));
        try {
            em.persist(employee2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
