// src/Pages/LoginPage.jsx
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthForm from "../Components/AuthForm"; // Assuming AuthForm handles login

const LoginPage = () => {
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (credentials) => {
    try {
      // Replace this with your actual login logic
      await AuthForm.login(credentials);
      navigate("/user");
    } catch (error) {
      setErrorMessage("Invalid credentials. Please try again.");
    }
  };

  return (
    <div
      className="flex justify-center items-center h-screen bg-gray-100"
      style={{ backgroundImage: "url('/child-bg.jpg')" }}
    >
      <div className="bg-white p-6 rounded shadow-md w-full max-w-sm">
        <h2 className="text-2xl mb-4">Sign In</h2>
        {errorMessage && <p className="text-red-500 mb-4">{errorMessage}</p>}
        <AuthForm isLogin={true} onLogin={handleLogin} />
        <div className="mt-4">
          <p>
            Don't have an account?{" "}
            <a href="/register" className="text-blue-500">
              Sign Up
            </a>
          </p>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
