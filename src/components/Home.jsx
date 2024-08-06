import React from "react";
import { Link, Route, Routes, useNavigate } from "react-router-dom";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import "./Home.css";
import SignIn from "./SignIn"; // Ensure this path is correct
import SignUp from "./SignUp"; // Ensure this path is correct
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
                <NavDropdown.Item as={Link} to="#action/3.1">
                  Action
                </NavDropdown.Item>
                <NavDropdown.Item as={Link} to="#action/3.2">
                  Another action
                </NavDropdown.Item>
                <NavDropdown.Item as={Link} to="#action/3.3">
                  Something
                </NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item as={Link} to="#action/3.4">
                  Separated link
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
          </Routes>
        </div>
      </div>
    </>
  );
}

export default Home;
