
import React, {useState, useEffect} from 'react';
import './App.css';


const AddTransaction= () =>{

  return(

    <form>

        <span> Description </span>
        <input type="text" />

        <span> Category</span>
        <input type="text"/>

        <span> Amount </span>
        <input type="number"/>

        <button type = "submit"> Add Transaction</button>
    </form>
        
  );

  
    
};


export default AddTransaction;