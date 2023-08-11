import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter as Router } from "react-router-dom";
import { Routes, Route } from "react-router";
import ListEmployeeComponent from "./components/ListEmployeeComponent";
import CreateEmployeeComponent from "./components/CreateEmployeeComponent";
import UpdateEmployeeComponent from "./components/UpdateEmployeeComponent";

function App() {
  return (
    <div>
      <Router>
        <div className="container">
          <Routes>
            <Route path="/" exact element={<ListEmployeeComponent />}></Route>
            <Route path="/employee" element={<ListEmployeeComponent />}></Route>
            <Route
              path="/add-employee"
              element={<CreateEmployeeComponent />}
            ></Route>
            <Route
              path="/upd-employee/:id"
              element={<UpdateEmployeeComponent />}
            ></Route>
          </Routes>
        </div>
      </Router>
    </div>
  );
}

export default App;
