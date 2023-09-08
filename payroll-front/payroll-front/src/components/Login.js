import { useState } from "react";
import { useNavigate } from "react-router-dom";
import LoginService from "../services/LoginService";

export const Login = () => {
  const [user, setUser] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const login = (event) => {
    event.preventDefault();
    try {
      let loginData = {
        user: user,
        password: password,
      };
      LoginService.login(loginData).then(
        (res) => {
          console.log(res.data);

          if (res.data.message == "User not exits") {
            alert("User not exits");
          } else if (res.data.message == "Login Success") {
            localStorage.setItem("login", true);
            navigate("/employee");
          } else {
            alert("Incorrect Email and Password not match");
          }
        },
        (fail) => {
          console.error(fail); // Error!
        }
      );
    } catch (err) {
      alert(err);
    }
  };
  return (
    <div>
      <div class="container">
        <div class="row">
          <h2>Login</h2>
          <hr />
        </div>
        <div class="row">
          <div class="col-sm-6">
            <form>
              <div class="form-group">
                <label>User</label>
                <input
                  type="user"
                  class="form-control"
                  id="user"
                  placeholder="Enter Name"
                  value={user}
                  onChange={(event) => {
                    setUser(event.target.value);
                  }}
                />
              </div>
              <div class="form-group">
                <label>password</label>
                <input
                  type="password"
                  class="form-control"
                  id="password"
                  placeholder="Enter Fee"
                  value={password}
                  onChange={(event) => {
                    setPassword(event.target.value);
                  }}
                />
              </div>
              <button type="submit" class="btn btn-primary" onClick={login}>
                Login
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
