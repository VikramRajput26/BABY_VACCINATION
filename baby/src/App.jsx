import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./components/Home";
import UserList from "./pages/UserList";
import UserById from "./pages/UserById";
import UpdateUser from "./pages/UpdateUser";
import ViewUser from "./pages/ViewUser";
import SignIn from "./components/SignIn";
import SignUp from "./components/SignUp";

import "bootstrap/dist/css/bootstrap.min.css";
import ChildRegister from "./pages/ChildRegister";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/sign-in" element={<SignIn />} />
        <Route path="/sign-up" element={<SignUp />} />
        <Route path="/user-list" element={<UserList />} />
        <Route path="/user-by-id" element={<UserById />} />
        <Route path="/childregister" element={<ChildRegister />} />
        <Route path="/update-user/:id" element={<UpdateUser />} />
        <Route path="/view-user/:id" element={<ViewUser />} />
      </Routes>
    </Router>
  );
}

export default App;
