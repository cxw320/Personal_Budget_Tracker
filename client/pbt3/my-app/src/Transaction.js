
import React, {useState, useEffect} from 'react';
import API from "./utils/API";
import CustomToggleHook from "./customHooks/toggleStateHook";
import EditTransaction from "./EditTransaction";
import styles from './index.css';



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

    <tr classname={styles.parenttr}>
    
    {isEdit ? (
    
      <EditTransaction id={id} category={category} description={description}
      amount={amount} callback={callback} toggleEditForm={setEdit}/>
      
    ) : (  
      <tr key={id}>
            <td classname={styles.description}>{description}</td>
            <td>{category}</td>
            <td>{amount}</td>
            <button onClick={setEdit}>Edit</button>
            <button type='submit' id={id} onClick={deleteTransaction}>Delete</button>
      </tr>
      
    )}


    </tr>

    

    
    

    
        
  );

  
    
};


export default Transaction;
