import axios from "axios";

const API_URL = "http://localhost:8080/employee";

class EmployeeService {
  getEmployees() {
    return axios.get(API_URL + "/all");
  }

  createEmployee(employee) {
    return axios.post(API_URL, employee);
  }

  getEmployeeById(id) {
    return axios.get(API_URL + "/detail/" + id);
  }

  updateEmployee(id, employee) {
    return axios.put(API_URL + "/" + id, employee);
  }
}

export default new EmployeeService();
