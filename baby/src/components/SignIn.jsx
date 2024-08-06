import React, { useState } from "react";
import { Form, Button, Container, Alert } from "react-bootstrap";
import { login } from "../services/authService";
import "./SignIn.css";

function SignIn() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [success, setSuccess] = useState(false);
  const [error, setError] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await login(email, password);
      setSuccess(true);
      setError("");
      // Redirect or perform additional actions upon successful login
      console.log(response); // You might want to redirect the user to a dashboard or home page
    } catch (error) {
      setError(error.message);
      setSuccess(false);
    }
  };

  return (
    <Container className="login-wrapper">
      <div className="login-form-container">
        <h2 className="login-title">Sign In</h2>
        {success && <Alert variant="success">Login successful!</Alert>}
        {error && <Alert variant="danger">{error}</Alert>}
        <Form onSubmit={handleSubmit} className="login-form">
          <Form.Group controlId="formBasicEmail">
            <Form.Label>Email address</Form.Label>
            <Form.Control
              type="email"
              placeholder="Enter email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </Form.Group>

          <Form.Group controlId="formBasicPassword">
            <Form.Label>Password</Form.Label>
            <Form.Control
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </Form.Group>

          <Button variant="primary" type="submit" className="login-button">
            Sign In
          </Button>
        </Form>
      </div>
    </Container>
  );
}

export default SignIn;
