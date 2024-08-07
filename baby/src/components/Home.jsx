import React from "react";
import { Link, Route, Routes, useNavigate } from "react-router-dom";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import "./Home.css";
import SignIn from "./SignIn"; // Ensure this path is correct
import SignUp from "./SignUp"; // Ensure this path is correct
import UserList from "../pages/UserList"; // Updated path for UserList
import UserById from "../pages/UserById"; // Updated path for UserById
import UpdateUser from "../pages/UpdateUser"; // Updated path for UpdateUser
import { logout } from "../services/authService"; // Ensure this path is correct

function Home() {
  const navigate = useNavigate();

  const handleLogout = () => {
    logout(); // Clear the token from local storage
    navigate("/"); // Redirect to the home page
  };

  return (
    <>
      <Navbar expand="lg" className="navbar-custom">
        <Container>
          <Navbar.Brand as={Link} to="/">
            Little Hands
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link as={Link} to="/">
                Home
              </Nav.Link>
              <Nav.Link as={Link} to="/about-us">
                About Us
              </Nav.Link>
              <Nav.Link as={Link} to="/contact-us">
                Contact Us
              </Nav.Link>
              <Nav.Link as={Link} to="/sign-in">
                Sign In
              </Nav.Link>
              <Nav.Link as={Link} to="/sign-up">
                Sign Up
              </Nav.Link>
              <Nav.Link onClick={handleLogout}>Logout</Nav.Link>
              <NavDropdown title="Dropdown" id="basic-nav-dropdown">
                <NavDropdown.Item as={Link} to="/user-list">
                  UserList
                </NavDropdown.Item>
                <NavDropdown.Item as={Link} to="/user-by-id">
                  UserById
                </NavDropdown.Item>
                <NavDropdown.Item as={Link} to="/update-user">
                  UpdateUser
                </NavDropdown.Item>
              </NavDropdown>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <div className="full-page-image-container">
        <img src="/baby1.jpg" alt="Happy Baby" className="full-page-image" />
        <div className="form-overlay">
          <Routes>
            <Route path="/sign-in" element={<SignIn />} />
            <Route path="/sign-up" element={<SignUp />} />
            <Route path="/user-list" element={<UserList />} />{" "}
            {/* Add UserList route */}
            <Route path="/user-by-id" element={<UserById />} />{" "}
            {/* Add UserById route */}
            <Route path="/update-user" element={<UpdateUser />} />{" "}
            {/* Add UpdateUser route */}
          </Routes>
        </div>
      </div>
    </>
  );
}

export default Home;
