import { myAxios } from "./helper";

export const signUp = async (user) => {
  try {
    const response = await myAxios.post("/api/v1/auth/sign-up", user);
    return response.data;
  } catch (error) {
    throw error; // This ensures the error is properly caught in the component
  }
};

export const signIn = async (email, password) => {
  try {
    const response = await myAxios.post("/api/v1/auth/sign-in", {
      email,
      password,
    });
    return response.data;
  } catch (error) {
    throw error; // This ensures the error is properly caught in the component
  }
};
