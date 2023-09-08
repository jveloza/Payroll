import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter as Router } from "react-router-dom";
import { Routes, Route } from "react-router";
import ListEmployeeComponent from "./components/ListEmployeeComponent";
import CreateEmployeeComponent from "./components/CreateEmployeeComponent";
import UpdateEmployeeComponent from "./components/UpdateEmployeeComponent";
import Login from "./components/Login";
import Protected from "./components/Protected";

function App() {
  return (
    <div>
      <Router>
        <div className="container">
          <Routes>
            <Route path="/" exact element={<Login />}></Route>
            <Route
              path="/employee"
              element={<Protected Component={ListEmployeeComponent} />}
            ></Route>
            <Route
              path="/add-employee"
              element={<Protected Component={CreateEmployeeComponent} />}
            ></Route>
            <Route
              path="/upd-employee/:id"
              element={<Protected Component={UpdateEmployeeComponent} />}
            ></Route>
          </Routes>
        </div>
      </Router>
    </div>
  );
}

export default App;
