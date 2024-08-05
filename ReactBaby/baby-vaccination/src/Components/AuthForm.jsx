// src/Components/AuthForm.jsx
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { login, register } from "../Api/auth";

const AuthForm = ({ isLogin }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const data = isLogin
        ? await login(email, password)
        : await register({ email, password });
      localStorage.setItem("token", data.token);
      navigate("/");
    } catch (error) {
      console.error("Error during authentication", error);
    }
  };

  return (
    <div
      className="flex justify-center items-center h-screen bg-gray-100"
      style={{ backgroundImage: "url('/child-bg.jpg')" }}
    >
      <form
        onSubmit={handleSubmit}
        className="bg-white p-6 rounded shadow-md w-full max-w-sm"
      >
        <h2 className="text-2xl mb-4">{isLogin ? "Login" : "Sign Up"}</h2>
        <div className="mb-4">
          <label className="block mb-2">Email</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="w-full px-3 py-2 border rounded"
            required
          />
        </div>
        <div className="mb-4">
          <label className="block mb-2">Password</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="w-full px-3 py-2 border rounded"
            required
          />
        </div>
        <button
          type="submit"
          className="w-full bg-blue-500 text-white py-2 rounded"
        >
          {isLogin ? "Login" : "Sign Up"}
        </button>
      </form>
    </div>
  );
};

export default AuthForm;
