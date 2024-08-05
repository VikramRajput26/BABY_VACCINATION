// src/App.jsx
import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import LoginPage from "./Pages/LoginPage";
import RegisterPage from "./Pages/RegisterPage";
import UserPage from "./Pages/UserPage";

const App = () => (
  <Router>
    <div className="flex justify-between p-4 bg-blue-600 text-white">
      <Link to="/" className="font-bold text-xl">
        Baby Vaccination
      </Link>
      <div>
        <Link to="/login" className="mr-4">
          Sign In
        </Link>
        <Link to="/register">Sign Up</Link>
      </div>
    </div>
    <Routes>
      <Route path="/login" element={<LoginPage />} />
      <Route path="/register" element={<RegisterPage />} />
      <Route path="/user" element={<UserPage />} />
    </Routes>
  </Router>
);

export default App;
