//we will create custom hooks to handle input from user
import { useState } from "react";

export default initialInput => {
  const [values, setValues] = useState("");
  const handleChange = e => {
    setValues(e.target.value);
  };

  const resetInput = () => {
    setValues("");
  };

  return [values, handleChange, resetInput];
};
