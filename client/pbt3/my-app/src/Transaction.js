
import React, {useState, useEffect} from 'react';
import API from "./utils/API";
import CustomToggleHook from "./customHooks/toggleStateHook";




const Transaction= ({callback, id, description, category, amount}) =>{

  const [isEdit, setEdit] = CustomToggleHook(false);

  const deleteTransaction = async (ev) => {
    ev.preventDefault();
    console.log("delete button clicked");
    let res = await API.delete(`/transactions/${id}`);
    
    if (typeof callback !== 'undefined') {
        callback(res);
    }
  }

  return(
      
        <tr key={id}>
            <td>{description}</td>
            <td>{category}</td>
            <td>{amount}</td>
            <button>Edit</button>
            <button type='submit' id={id} onClick={deleteTransaction}>Delete</button>
        </tr>
        
  );

  
    
};


export default Transaction;
