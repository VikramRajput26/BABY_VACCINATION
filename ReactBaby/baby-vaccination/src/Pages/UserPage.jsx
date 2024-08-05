// src/Pages/UserPage.jsx
import React from "react";
import { useNavigate } from "react-router-dom";

const UserPage = () => {
  const navigate = useNavigate();

  // Add logic to check if the user is authenticated
  // For example, if you have a user context or a token in localStorage

  return (
    <div
      className="flex justify-center items-center h-screen bg-gray-100"
      style={{ backgroundImage: "url('/welcome-bg.jpg')" }}
    >
      <div className="bg-white p-6 rounded shadow-md w-full max-w-md text-center">
        <h2 className="text-2xl mb-4">Welcome to the Baby Vaccination App!</h2>
        <button
          onClick={() => navigate("/")}
          className="bg-blue-500 text-white py-2 px-4 rounded"
        >
          Go to Home
        </button>
      </div>
    </div>
  );
};

export default UserPage;
