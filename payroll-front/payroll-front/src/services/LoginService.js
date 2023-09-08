import axios from "axios";

const API_URL = "http://localhost:8080/login";

class LoginService {
  login(loginData) {
    return axios.post(API_URL, loginData);
  }
}

export default new LoginService();
