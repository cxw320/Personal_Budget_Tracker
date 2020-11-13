
import React, {useState, useEffect} from 'react';


const Transaction= ({id, description, category, amount}) =>{

  return(
      
        <tr>
            <td>{description}</td>
            <td>{category}</td>
            <td>{amount}</td>
            <button>Edit</button>
            <button>Delete</button>
        </tr>
        
  );

  
    
};


export default Transaction;
