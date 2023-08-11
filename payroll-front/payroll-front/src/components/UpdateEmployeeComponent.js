import React, { useEffect, useState } from "react";
import EmployeeService from "../services/EmployeeService";
import { Link, useNavigate, useParams } from "react-router-dom";

export const UpdateEmployeeComponent = () => {
  const [firstName, setFirstName] = useState("");
  const [middleName, setMiddleName] = useState("");
  const [lastName, setLastName] = useState("");
  const [locationCity, setLocationCity] = useState("");
  const [address, setAddress] = useState("");
  const [dateBirth, setDateBirth] = useState("");
  const [telephone, setTelephone] = useState("");
  const [status, setStatus] = useState("");
  const [positionTitle, setPositionTitle] = useState("");
  const [hireDate, setHireDate] = useState("");
  const [email, setEmail] = useState("");
  const [salary, setSalary] = useState("");
  const [timeInPosition, setTimeInPostion] = useState("");

  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    EmployeeService.getEmployeeById(id)
      .then((response) => {
        setFirstName(response.data.employeeDetail.firstName);
        setMiddleName(response.data.employeeDetail.middleName);
        setLastName(response.data.employeeDetail.lastname);
        setLocationCity(response.data.employeeDetail.locationCity);
        setAddress(response.data.employeeDetail.address);
        setDateBirth(response.data.employeeDetail.dateBirth);
        setTelephone(response.data.employeeDetail.telephone);
        setStatus(response.data.positionDetail.state);
        setPositionTitle(response.data.positionDetail.positionTitle);
        setHireDate(response.data.positionDetail.hireDate);
        setEmail(response.data.positionDetail.email);
        setSalary(response.data.positionDetail.salary);
        setTimeInPostion(response.data.positionDetail.timeSalary);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const changeFirstNameHandler = (event) => {
    setFirstName(event.target.value);
  };

  const changeMiddleNameHandler = (event) => {
    setMiddleName(event.target.value);
  };

  const changeLastNameHandler = (event) => {
    setLastName(event.target.value);
  };

  const changeLocationCityHandler = (event) => {
    setLocationCity(event.target.value);
  };

  const changeAddressHandler = (event) => {
    setAddress(event.target.value);
  };

  const changeDateBirthHandler = (event) => {
    setDateBirth(event.target.value);
  };

  const changeTelephoneHandler = (event) => {
    setTelephone(event.target.value);
  };

  const changePositionHandler = (event) => {
    setPositionTitle(event.target.value);
  };

  const changeDateArrivalHandler = (event) => {
    setHireDate(event.target.value);
  };

  const changeEmailHandler = (event) => {
    setEmail(event.target.value);
  };

  const changeSalaryHandler = (event) => {
    setSalary(event.target.value);
  };

  const changeTimeSalaryHandler = (event) => {
    setTimeInPostion(event.target.value);
  };

  const changeStatusHandler = (event) => {
    setStatus(event.target.value);
  };

  const updateEmployee = (e) => {
    e.preventDefault();
    let employee = {
      hireDate: hireDate,
      positionTitle: positionTitle,
      email: email,
      salary: salary,
      timeSalary: timeInPosition,
      state: status,
      idEmployee: {
        firstName: firstName,
        middleName: middleName,
        lastname: lastName,
        locationCity: locationCity,
        address: address,
        dateBirth: dateBirth,
        telephone: telephone,
      },
    };
    console.log("employee => " + JSON.stringify(employee));

    EmployeeService.updateEmployee(id, employee).then((res) => {
      navigate("/employee");
    });
  };

  return (
    <div className="container">
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          <h3 className="text-center">Employee Form</h3>
          <div className="card-body">
            <form>
              <h5 className="text-center">Employee Data</h5>
              <div className="form-group">
                <label>First Name:</label>
                <input
                  placeholder="First Name"
                  name="firstName"
                  className="form-control"
                  value={firstName}
                  onChange={changeFirstNameHandler}
                />
              </div>
              <div className="form-group">
                <label>Middle Name:</label>
                <input
                  placeholder="Middle Name"
                  name="middleName"
                  className="form-control"
                  value={middleName}
                  onChange={changeMiddleNameHandler}
                />
              </div>
              <div className="form-group">
                <label>Last Name:</label>
                <input
                  placeholder="Last Name"
                  name="lastName"
                  className="form-control"
                  value={lastName}
                  onChange={changeLastNameHandler}
                />
              </div>
              <div className="form-group">
                <label>Location City:</label>
                <input
                  placeholder="Location City"
                  name="locationCity"
                  className="form-control"
                  value={locationCity}
                  onChange={changeLocationCityHandler}
                />
              </div>
              <div className="form-group">
                <label>Address:</label>
                <input
                  placeholder="Address"
                  name="address"
                  className="form-control"
                  value={address}
                  onChange={changeAddressHandler}
                />
              </div>
              <div className="form-group">
                <label>Date Birth:</label>
                <input
                  type="date"
                  placeholder="Date Birth"
                  name="dateBirth"
                  className="form-control"
                  value={dateBirth}
                  onChange={changeDateBirthHandler}
                />
              </div>
              <div className="form-group">
                <label>Telephone:</label>
                <input
                  placeholder="Telephone"
                  name="telephone"
                  className="form-control"
                  value={telephone}
                  onChange={changeTelephoneHandler}
                />
              </div>
              <br />
              <h5 className="text-center">Position Data</h5>
              <div className="form-group">
                <label>Position:</label>
                <input
                  placeholder="Position"
                  name="position"
                  className="form-control"
                  value={positionTitle}
                  onChange={changePositionHandler}
                />
              </div>
              <div className="form-group">
                <label>Date Arrival:</label>
                <input
                  type="date"
                  placeholder="Date Arrival"
                  name="dateArrival"
                  className="form-control"
                  value={hireDate}
                  onChange={changeDateArrivalHandler}
                />
              </div>
              <div className="form-group">
                <label>Email:</label>
                <input
                  placeholder="Email"
                  name="email"
                  className="form-control"
                  value={email}
                  onChange={changeEmailHandler}
                />
              </div>
              <div className="form-group">
                <label>Salary:</label>
                <input
                  placeholder="Salary"
                  name="salary"
                  className="form-control"
                  value={salary}
                  onChange={changeSalaryHandler}
                />
              </div>
              <div className="form-group">
                <label>Time Salary:</label>
                <input
                  placeholder="Time Salary"
                  name="timeSalary"
                  className="form-control"
                  value={timeInPosition}
                  onChange={changeTimeSalaryHandler}
                />
              </div>
              <div className="form-group">
                <label>Status:</label>
                <select
                  name="status"
                  onChange={changeStatusHandler}
                  value={status}
                  className="form-control"
                >
                  <option value={true}>Active</option>
                  <option value={false}>Inactive</option>
                </select>
              </div>
              <br />
              <button className="btn btn-success" onClick={updateEmployee}>
                Update
              </button>
              <Link to="/employee" className="btn btn-danger">
                Cancel
              </Link>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UpdateEmployeeComponent;
