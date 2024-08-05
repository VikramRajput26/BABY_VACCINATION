import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import BasicExample from "./components/Home";
import SignIn from "./components/SignIn";

import "bootstrap/dist/css/bootstrap.min.css";
import SignUp from "./components/SignUp";

function App() {
  return (
    <Router>
      <div>
        <BasicExample />
        <Routes>
          <Route path="/sign-in" element={<SignIn />} />
          <Route path="/sign-up" element={<SignUp />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
