
import React, {useState, useEffect} from 'react';
import './App.css';


const Transaction= ({id, description, category, amount}) =>{

  return(
      
        <tr>
            <td>{description}</td>
            <td>{category}</td>
            <td>{amount}</td>
        </tr>
        
  );

  
    
};


export default Transaction;
