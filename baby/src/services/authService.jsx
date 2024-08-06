import axios from "axios";

const API_URL = "http://localhost:8080/api/v1/auth";

// Function to handle login
export const login = async (email, password) => {
  try {
    const response = await axios.post(`${API_URL}/login`, { email, password });
    const { token } = response.data;
    localStorage.setItem("jwtToken", token); // Store the token in local storage
    return response.data;
  } catch (error) {
    throw new Error(
      error.response ? error.response.data.message : "Login failed"
    );
  }
};

// Function to handle registration
export const register = async (formData) => {
  try {
    const response = await axios.post(`${API_URL}/register`, formData);
    return response.data;
  } catch (error) {
    throw new Error(
      error.response ? error.response.data.message : "Registration failed"
    );
  }
};

// Function to handle logout
export const logout = () => {
  localStorage.removeItem("jwtToken"); // Remove the token from local storage
};
