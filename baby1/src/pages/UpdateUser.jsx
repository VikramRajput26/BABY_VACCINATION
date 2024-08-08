import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { getUserById, updateUser } from "../services/userService";
import "react-toastify/dist/ReactToastify.css";
import "./UpdateUser.css";

const UpdateUser = () => {
  const { id } = useParams();
  const [user, setUser] = useState({
    firstName: "",
    lastName: "",
    email: "",
    contactNumber: "",
    password: "",
    roles: [], // Initialize as an empty array
  });
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchUser = async () => {
      try {
        const userData = await getUserById(id);
        setUser(userData);
        setLoading(false);
      } catch (error) {
        toast.error("Failed to fetch user details.");
      }
    };

    fetchUser();
  }, [id]);

  const handleChange = (e) => {
    const { name, value, checked } = e.target;
    if (name === "roles") {
      setUser((prevUser) => ({
        ...prevUser,
        roles: checked
          ? [...prevUser.roles, value]
          : prevUser.roles.filter((role) => role !== value),
      }));
    } else {
      setUser({ ...user, [name]: value });
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await updateUser(id, user);
      toast.success("User updated successfully!");
      navigate("/user-list");
    } catch (error) {
      toast.error("Failed to update user.");
    }
  };

  const handleBackClick = () => {
    navigate("/user-list");
  };

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <div className="update-user-container">
      <h2>Update User</h2>
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId="formFirstName">
          <Form.Label>First Name</Form.Label>
          <Form.Control
            type="text"
            name="firstName"
            value={user.firstName}
            onChange={handleChange}
            required
          />
        </Form.Group>

        <Form.Group controlId="formLastName">
          <Form.Label>Last Name</Form.Label>
          <Form.Control
            type="text"
            name="lastName"
            value={user.lastName}
            onChange={handleChange}
            required
          />
        </Form.Group>

        <Form.Group controlId="formEmail">
          <Form.Label>Email</Form.Label>
          <Form.Control
            type="email"
            name="email"
            value={user.email}
            onChange={handleChange}
            required
          />
        </Form.Group>

        <Form.Group controlId="formContactNumber">
          <Form.Label>Contact Number</Form.Label>
          <Form.Control
            type="text"
            name="contactNumber"
            value={user.contactNumber}
            onChange={handleChange}
            required
          />
        </Form.Group>

        <Form.Group controlId="formPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control
            type="password"
            name="password"
            value={user.password}
            onChange={handleChange}
          />
          <Form.Text className="text-muted">
            Leave blank if you do not want to change the password.
          </Form.Text>
        </Form.Group>

        <Form.Group controlId="formRoles">
          <Form.Label>Roles</Form.Label>
          <Form.Check
            type="checkbox"
            label="ROLE_USER"
            name="roles"
            value="ROLE_USER"
            checked={user.roles.includes("ROLE_USER")}
            onChange={handleChange}
          />
          <Form.Check
            type="checkbox"
            label="ROLE_ADMIN"
            name="roles"
            value="ROLE_ADMIN"
            checked={user.roles.includes("ROLE_ADMIN")}
            onChange={handleChange}
          />
        </Form.Group>

        <Button variant="primary" type="submit">
          Submit
        </Button>
        <Button variant="secondary" onClick={handleBackClick} className="ml-2">
          Back to User List
        </Button>
      </Form>
    </div>
  );
};

export default UpdateUser;
