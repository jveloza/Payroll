import React, { useEffect, useState } from "react";
import EmployeeService from "../services/EmployeeService";
import { Link } from "react-router-dom";

export const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    EmployeeService.getEmployees()
      .then((res) => {
        setEmployees(res.data);
      })
      .catch((error) => {
        console.log(error);
      });
  });

  return (
    <div>
      <h2 className="text-center">Employees List</h2>
      <div>
        <Link to="/add-employee" className="btn btn-primary">
          Add Employee
        </Link>
      </div>
      <div className="row">
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th> First Name </th>
              <th> Last Name</th>
              <th> Position</th>
              <th> Date Arrival</th>
              <th> Active</th>
              <th> Actions</th>
            </tr>
          </thead>
          <tbody>
            {employees &&
              employees.map((employee) => (
                <tr key={employee.id}>
                  <td>{employee.firstName}</td>
                  <td>{employee.lastName}</td>
                  <td>{employee.positionTitle}</td>
                  <td>{employee.dateArrival}</td>
                  <td>{employee.status.toString()}</td>
                  <td>
                    <Link
                      to={`/upd-employee/${employee.idPosition}`}
                      className="btn btn-info"
                    >
                      Update
                    </Link>
                  </td>
                </tr>
              ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ListEmployeeComponent;
