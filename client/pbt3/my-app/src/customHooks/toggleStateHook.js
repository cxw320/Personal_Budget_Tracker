import { useState } from "react";

function CustomToggleHook() {
  const [toggle, setToggle] = useState(false);

  const handleToggle = () => {
    setToggle(!toggle);
  };

  console.log(toggle);
  return [toggle, handleToggle];
}

export default CustomToggleHook;